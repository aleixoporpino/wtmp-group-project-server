package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.service.INurseService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/nurse")
public class NurseController extends RestUtils<INurseService> {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/")
    Collection<User> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/name/{name}")
    Collection<User> findByName(@PathVariable("name") String name) {
        return this.service.findByName(name);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> save(@RequestBody User nurse) {
        this.service.save(nurse);
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), nurse);
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> update(@RequestBody User nurse) {
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_UPDATE.getMessage(), nurse);
        if (this.service.update(nurse) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + nurse.getId() + " não encontrado.", nurse);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

}
