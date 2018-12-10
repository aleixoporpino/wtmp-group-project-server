package br.com.techlead.agendacontato.service;
import br.com.techlead.agendacontato.model.Patient;
import br.com.techlead.agendacontato.model.User;

import java.util.Collection;
import java.util.List;

/**
 * Interface de negócio da entidade Patient.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 21/01/2018
 */
public interface IPatientService {
    /**
     * Retorna uma entidade Contato.
     *
     * @param id chave primária da entidade Contato
     * @return Contato
     */
    Patient findById(int id);

    /**
     * Retorna todos os contatos.
     *
     * @return Collection<Contato>
     */
    Collection<Patient> findAll();

    /**
     * Retorna uma lista de entidade Contato por nome.
     *
     * @param name
     * @return Collection<Contato>
     */
    Collection<Patient> findByName(String name, int id);

    /**
     * Salva uma entidade Patient na tabela.
     *
     * @param patient
     * @return Patient
     */
    Patient save(Patient patient);

    /**
     * Editar uma entidade Patient na tabela.
     *
     * @param patient
     * @return Patient
     */
    Patient update(Patient patient);

    /**
     * Excluir uma entidade Patient na tabela.
     *
     * @param id
     * @return Integer
     */
    Integer delete(int id);

    List<Patient> findByDoctor(User d);

    Collection<Patient> findByDoctorId(Integer id);

    Collection<Patient> findByNurseId(Integer id);
}
