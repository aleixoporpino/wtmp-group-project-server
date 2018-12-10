package br.com.techlead.agendacontato.repository;

import br.com.techlead.agendacontato.model.Patient;
import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.utils.UserTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Collection<Patient> findByFirstNameContainsOrLastNameContainsAndDoctorIdOrderByLastName(String name, String lastName, int id);

    List<Patient> findByDoctor(User d);

    Collection<Patient> findByDoctorIdOrderByLastName(Integer id);

    Collection<Patient> findByNurseIdOrderByLastName(Integer id);
}
