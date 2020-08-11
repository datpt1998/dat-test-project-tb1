package com.timebird.scheduleGetData.Controller;

import com.timebird.scheduleGetData.DAO.LDAPAuthenticator;
import com.timebird.scheduleGetData.Modal.LoginModal;
import com.timebird.scheduleGetData.Modal.UserDetailDTO;
import com.timebird.scheduleGetData.Service.ExcelService;
import com.timebird.scheduleGetData.Service.JWTService;
import com.timebird.scheduleGetData.entity.User;
import com.timebird.scheduleGetData.helper.AuthenObj;
import com.timebird.scheduleGetData.helper.CustomResponseEntity;
import com.timebird.scheduleGetData.helper.MyResponseObj;
import com.timebird.scheduleGetData.helper.TokenObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@RestController
@RequestMapping("/api")
//@CrossOrigin
public class MyController {
    @Autowired
    JWTService jwtService;
    @Autowired
    LDAPAuthenticator authenticator;
    @Autowired
    ExcelService excelService;

    @GetMapping("/test")
    public ResponseEntity myTestHeader(@AuthenticationPrincipal(expression = "user") User user){
        return new CustomResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginModal modal){
        AuthenObj<String> authenObj=authenticator.authenticate(modal.username, modal.password);
        if(authenObj.isPass())
        {
            TokenObject tokenObject=jwtService.signToken(modal.username);
            return new CustomResponseEntity<TokenObject>(tokenObject, HttpStatus.OK);
        }
        else{
            return new CustomResponseEntity<String>(authenObj.getContent(),HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/verify")
    public ResponseEntity verifyToken(@RequestHeader("Access-Token") String accessToken){
        AuthenObj<String> authenObj=jwtService.decodeAccess(accessToken);
        if(authenObj.isPass()){
            return new CustomResponseEntity<String>(authenObj.getContent(), HttpStatus.OK);
        }
        else{
            return new CustomResponseEntity<String>(authenObj.getContent(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/export", produces = "application/vnd.ms-excel")
    public ResponseEntity<InputStreamResource> download2(HttpServletRequest request) throws IOException {
        AuthenObj authenObj=excelService.createExcel("test.xls");
        HttpHeaders responseHeader = new HttpHeaders();
        try {
            File file = (File)authenObj.getContent();
            byte[] data = FileUtils.readFileToByteArray(file);
            // Set mimeType trả về
            responseHeader.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            // Thiết lập thông tin trả về
            responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
            responseHeader.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeader, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<InputStreamResource>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    public ResponseEntity testExcel(@RequestParam("path") String path, HttpServletResponse response) throws IOException {
//        AuthenObj authenObj=excelService.createExcel(path+".xls");
//        if(authenObj.isPass()){
//            File file=(File) authenObj.getContent();
//            byte[] data= Files.readAllBytes(file.toPath());
//            Files.copy(file.toPath(),response.getOutputStream());
//            Files.delete(file.toPath());
//            return ResponseEntity.ok("");
////                    .contentLength(data.length)
////                    .header(HttpHeaders.CONTENT_TYPE, "application/vnd.ms-excel")
////                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
////                             .body(data);
////            response.setContentType("application/vnd.ms-excel");
////            response.setContentType("application/json");
////            response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
////            response.setContentLength(data.length);
////            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
////            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
////            return new ResponseEntity<InputStreamResource>(inputStreamResource, HttpStatus.OK);
//
////            System.out.println(Files.copy(file.toPath(),response.getOutputStream()));
////            //response.getOutputStream().close();
//
////            OutputStream outStream = response.getOutputStream();
////            byte[] buffer = new byte[4096];
////            int bytesRead = -1;
////            while ((bytesRead = inputStream.read(buffer)) != -1) {
////                outStream.write(buffer, 0, bytesRead);
////            }
////            inputStream.close();
////            outStream.close();
////
////            Files.delete(file.toPath());
//        }
//        else{
//            return new CustomResponseEntity<AuthenObj>(authenObj, HttpStatus.CONFLICT);
//        }
    }
