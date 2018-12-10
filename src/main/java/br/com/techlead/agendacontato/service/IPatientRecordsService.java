package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.PatientRecords;
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
public interface IPatientRecordsService {
    PatientRecords findById(int id);

    Collection<PatientRecords> findByPatientId(int id);

    Collection<PatientRecords> findAll();

    PatientRecords save(PatientRecords patientRecords);

    PatientRecords update(PatientRecords patient);

    Integer delete(int id);

    List<PatientRecords> findByNurse(User d);
}
