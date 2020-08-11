package com.timebird.scheduleGetData.Service;

import com.timebird.scheduleGetData.DAO.UserDAO;
import com.timebird.scheduleGetData.entity.User;
import com.timebird.scheduleGetData.helper.AuthenObj;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    UserDAO userDAO;
    public HSSFCellStyle createTitleStyle(HSSFWorkbook workbook){
        HSSFFont font=workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style=workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public AuthenObj<Object> createExcel(String path){
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("testUser");
        List<User> users=userDAO.getAllUser();
        HSSFCellStyle titleStyle=createTitleStyle(workbook);
        Row row;
        Cell cell;
        row=sheet.createRow(0);

        cell=row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(titleStyle);

        cell=row.createCell(1);
        cell.setCellValue("Name");
        cell.setCellStyle(titleStyle);

        cell=row.createCell(2);
        cell.setCellValue("Mail");
        cell.setCellStyle(titleStyle);

        int rowNum=1;
        for(User user:users){
            row=sheet.createRow(rowNum);

            cell=row.createCell(0);
            cell.setCellValue(user.getUserID());

            cell=row.createCell(1);
            cell.setCellValue(user.getName());

            cell=row.createCell(2);
            cell.setCellValue(user.getMail());

            rowNum++;
        }
        sheet.autoSizeColumn(2);

        File file=new File(path);
        try {
            //FileOutputStream fos=new FileOutputStream(file);
            workbook.write(file);
            workbook.close();
            //fos.close();
            return new AuthenObj<>(true, file);
        } catch (FileNotFoundException e) {
            return new AuthenObj<>(false,e.getMessage());
        } catch (IOException e) {
            return new AuthenObj<>(false,e.getMessage());
        }
    }
}
