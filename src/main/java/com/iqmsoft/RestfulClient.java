package com.iqmsoft;

import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestfulClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(Arrays.asList(new Jaxb2RootElementHttpMessageConverter()));

        Person random = restTemplate.getForObject("http://localhost:8080/person/random", Person.class);
        System.out.println("Received: " + random);

        Person edited = restTemplate.postForObject("http://localhost:8080/person/edit", random, Person.class);
        System.out.println("Edited: " + edited);
    }
}
