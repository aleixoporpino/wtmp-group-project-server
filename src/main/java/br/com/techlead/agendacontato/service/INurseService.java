package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.User;

import java.util.Collection;

/**
 * Interface de negócio da entidade User.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 21/01/2018
 */
public interface INurseService {

    Collection<User> findAll();

    Collection<User> findByName(String name);

    /**
     * Salva uma entidade User na tabela.
     *
     * @param usuario
     * @return User
     */
    User save(User usuario);

    /**
     * Edita uma entidade User na tabela.
     *
     * @param usuario
     * @return User
     */
    User update(User usuario);

    /**
     * Deleta uma entidade User na tabela.
     *
     * @param id
     * @return Integer
     */
    Integer delete(int id);

}
