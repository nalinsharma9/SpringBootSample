package main.com.demo.Controller;

import main.com.demo.Model.Alien;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
public class mockController {

    @PostMapping(path="/string",produces = {"text/plain"})
    public String stringMessage() {
        return "Error Message";
    }

    @PostMapping(path="/PublishAliens",produces = {"application/json"})
    //code to get call url "http://localhost:8081/alien/101" and return json response
    public ResponseEntity<List<Alien>> publishAlien() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/aliens";
        ResponseEntity<List<Alien>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Alien>>() {}
        );
        List<Alien> alienList = response.getBody();
        for(Alien alien: alienList){
            System.out.println(alien.getAid());
        }
        return ResponseEntity.ok(alienList);
    }

}
