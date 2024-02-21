package ru.kurs.springsecurity.service;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.kurs.springsecurity.models.Application;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class AppService {
    private List<Application> applicationList;
    @PostConstruct
    public void loadAppInDB(){
        Faker faker = new Faker();
        applicationList = IntStream.rangeClosed(1,100)
                .mapToObj(i -> Application.builder()
                .id(i)
                .name(faker.app().name())
                .author(faker.app().author())
                .version(faker.app().version())
                .build())
                .toList();

    }
    public  List<Application> allApplications(){
        return applicationList;
    }

    public Application applicationByID(int id){
        return applicationList.stream()
                .filter(aop -> aop.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
