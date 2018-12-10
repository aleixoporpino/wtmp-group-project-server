package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.repository.UserRepository;
import br.com.techlead.agendacontato.utils.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Classe de negócio da entidade User.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Service
public class NurseService implements INurseService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Transactional(readOnly = true)
    public Collection<User> findAll() {
        return userRepository.findByTypeOrderByName(UserTypeEnum.NURSE);
    }

    @Transactional(readOnly = true)
    public Collection<User> findByName(String name) {
        return userRepository.findByNameContainsAndTypeOrderByName(name, UserTypeEnum.NURSE);
    }

    @Transactional
    public User save(User user) {
        user.setLogin(user.getName());
        user.setPassword("");
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        user.setType(UserTypeEnum.NURSE);
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User update(User usuario) {
        Collection<User> usuarios = findAll();
        for (User c : usuarios) {
            if (c.getId().equals(usuario.getId())) {
                userRepository.save(usuario);
                return usuario;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<User> usuarios = findAll();
        for (User c : usuarios) {
            if (c.getId().equals(id)) {
                userRepository.delete(id);
                return id;
            }
        }
        return null;
    }

}
