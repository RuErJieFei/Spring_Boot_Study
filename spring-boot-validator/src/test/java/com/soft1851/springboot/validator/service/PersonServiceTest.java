package com.soft1851.springboot.validator.service;

import com.soft1851.springboot.validator.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@SpringBootTest
class PersonServiceTest {
    @Resource
    private PersonService personService;

    @Test
    void validatePerson() {
        personService.validatePerson(Person.builder().build());
    }

    @Test
    void checkManually() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(Person.builder().id("123")
                .name("21312").email("123123123").build());
        for (ConstraintViolation<Person> constraintViolation : violations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}