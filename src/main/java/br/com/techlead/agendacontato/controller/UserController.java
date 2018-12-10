package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.service.IPatientService;
import br.com.techlead.agendacontato.service.IUserService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import br.com.techlead.agendacontato.utils.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController extends RestUtils<IUserService> {

    @Autowired
    IPatientService patientService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("{id}")
    User findById(@PathVariable("id") Integer id) {
        return this.service.findById(id);
    }

    @GetMapping("login/{login}/{password}")
    User findByLoginSenha(@PathVariable("login") String login, @PathVariable("password") String password) {
        User user = this.service.findByLogin(login);
        if (user != null) {
            if (getPasswordEncoder().matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @GetMapping("nurses")
    Collection<User> findNurses() {
        return this.service.findByType(UserTypeEnum.NURSE);
    }

    @GetMapping("doctors")
    Collection<User> findDoctors() {
        return this.service.findByType(UserTypeEnum.DOCTOR);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<Object> save(@RequestBody User user) {
        user.setType(UserTypeEnum.DOCTOR);
        Collection<User> users = service.findAll();
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())) {
                return new ResponseEntity<>(
                        new HttpReturnMessage(1, "This user already exists.", user),
                        HttpStatus.CONFLICT);
            }
        }

        this.service.save(user);
        return new ResponseEntity<>(new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), user), HttpStatus.OK);
    }

}
