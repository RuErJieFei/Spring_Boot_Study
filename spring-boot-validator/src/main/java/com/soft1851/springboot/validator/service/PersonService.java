package com.soft1851.springboot.validator.service;

import com.soft1851.springboot.validator.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @ClassName personService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/30 5:08 下午
 * @Version 1.0
 **/
@Service
@Validated
@Slf4j
public class PersonService {
    public void validatePerson(@Valid Person person) {
        log.info("service方法验证");
    }
}