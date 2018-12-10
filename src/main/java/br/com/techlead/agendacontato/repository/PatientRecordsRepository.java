package br.com.techlead.agendacontato.repository;

import br.com.techlead.agendacontato.model.PatientRecords;
import br.com.techlead.agendacontato.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRecordsRepository extends JpaRepository<PatientRecords, Integer> {
    List<PatientRecords> findByNurse(User d);

    Collection<PatientRecords> findByPatientIdOrderByDate(int id);
}
