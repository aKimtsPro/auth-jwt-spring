package be.technifutur.bartholomiche.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import be.technifutur.bartholomiche.service.UserService;
import jakarta.validation.Valid;
import be.technifutur.bartholomiche.form.LoginForm;
import be.technifutur.bartholomiche.form.UserInsertForm;
import be.technifutur.bartholomiche.model.DTO.JwtHolderDTO;
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/add")
    public void create(@RequestBody @Valid UserInsertForm form){
        this.userService.create(form);
    }
    @PostMapping("/sign_in")
    public JwtHolderDTO login(@RequestBody @Valid LoginForm form){
       return this.userService.login(form);
    }
}
