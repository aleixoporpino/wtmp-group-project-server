package br.com.techlead.agendacontato.repository;

import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.utils.UserTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Classe reponsável por realizar as transações com o banco de dados da tabela User.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    Collection<User> findByTypeOrderByName(UserTypeEnum userTypeEnum);

    Collection<User> findByNameContainsAndTypeOrderByName(String name, UserTypeEnum userTypeEnum);
}
