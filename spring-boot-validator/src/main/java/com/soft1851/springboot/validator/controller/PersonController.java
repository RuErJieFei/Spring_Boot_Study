package com.soft1851.springboot.validator.controller;

import com.soft1851.springboot.validator.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @ClassName PersonController
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/30 4:32 下午
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
@Slf4j
@Validated
public class PersonController {

    @PostMapping("/person")
    public ResponseEntity<Person> save(@RequestBody @Valid Person person) {
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Integer> getPersonById(@Valid @PathVariable("id") @Size(min = 6, message = "id不能小于6位") String id) {
        return ResponseEntity.ok().body(Integer.parseInt(id));
    }

    @GetMapping("/person1/{name}")
    public ResponseEntity<String> getPersonByName(@Valid @PathVariable("name") @Size(min = 10, message = "name长度超出范围") String name) {
        return ResponseEntity.ok().body(name);
    }

}
