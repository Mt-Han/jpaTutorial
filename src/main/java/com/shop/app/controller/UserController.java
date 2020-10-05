package com.shop.app.controller;

import com.shop.app.model.user.User;
import com.shop.app.model.user.UserService;
import com.shop.app.model.user.dto.RequestUser;
import com.shop.app.model.user.dto.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<ResponseUser> sginUp(
            @RequestBody RequestUser request
    ){
        return ResponseEntity.ok(userService.signUp(request));
    }
    @GetMapping("users")
    public ResponseEntity<List<ResponseUser>> users(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("user/{id}")
    public ResponseEntity<ResponseUser> findLoginId(
            @PathVariable("id") String id
    ){
        return ResponseEntity.ok(userService.findLoginId(id));
    }
    @GetMapping("user/name/{name}")
    public ResponseEntity<List<ResponseUser>> findName(
            @PathVariable("name") String name
    ){
        return ResponseEntity.ok(userService.findName(name));
    }
}
