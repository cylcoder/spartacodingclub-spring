package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JacksonTest {

    @Test
    @DisplayName("Object To JSON: 변환될 객체 클래스에 getter 필수")
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(star);
        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON To Object : 기본 생성자 & getter or setter 필수")
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Robbie\",\"age\":95}";
        ObjectMapper objectMapper = new ObjectMapper();
        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
    }

}
