package com.timebird.scheduleGetData.Controller;

import com.timebird.scheduleGetData.Modal.ModalA;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ControllerA {
    @GetMapping("/atest")
    public ResponseEntity test() {
        ModalA modalA = new ModalA();
        modalA.setName("A");
        modalA.setAge("AAge");
        modalA.setAddress("AAddr");
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:10000/btest");
        RestTemplate restTemplate = new RestTemplate();
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ModalA> entity = new HttpEntity<>(modalA,headers);
        URI uri = uriComponentsBuilder.build(true).toUri();
        return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
    }
}
