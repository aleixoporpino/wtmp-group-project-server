package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.Patient;
import br.com.techlead.agendacontato.model.PatientRecords;
import br.com.techlead.agendacontato.model.User;
import br.com.techlead.agendacontato.repository.PatientRecordsRepository;
import br.com.techlead.agendacontato.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Classe de negócio da entidade Patient.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Service
public class PatientRecordsService implements IPatientRecordsService {

    @Autowired
    private PatientRecordsRepository patientRecordsRepository;

    @Transactional(readOnly = true)
    public PatientRecords findById(int id) {
        return patientRecordsRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Collection<PatientRecords> findByPatientId(int id) {
        return patientRecordsRepository.findByPatientIdOrderByDate(id);
    }

    @Transactional(readOnly = true)
    public Collection<PatientRecords> findAll() {
        return patientRecordsRepository.findAll();
    }

    @Transactional
    public PatientRecords save(PatientRecords patientRecords) {
        patientRecordsRepository.save(patientRecords);
        return patientRecords;
    }

    @Transactional
    public PatientRecords update(PatientRecords patient) {
        Collection<PatientRecords> patients = findAll();
        for (PatientRecords c : patients) {
            if (c.getId().equals(patient.getId())) {
                patientRecordsRepository.save(patient);
                return patient;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<PatientRecords> patients = findAll();
        for (PatientRecords c : patients) {
            if (c.getId().equals(id)) {
                patientRecordsRepository.delete(id);
                return id;
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<PatientRecords> findByNurse(User d) {
        return patientRecordsRepository.findByNurse(d);
    }

}
