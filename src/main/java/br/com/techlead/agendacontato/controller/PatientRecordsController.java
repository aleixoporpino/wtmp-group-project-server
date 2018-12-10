package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.PatientRecords;
import br.com.techlead.agendacontato.service.IPatientRecordsService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/records")
public class PatientRecordsController extends RestUtils<IPatientRecordsService> {

    @GetMapping("{id}")
    PatientRecords findById(@PathVariable("id") int id) {
        return this.service.findById(id);
    }

    @GetMapping("patient/{id}")
    Collection<PatientRecords> findByPatientId(@PathVariable("id") int id) {
        return this.service.findByPatientId(id);
    }

    @GetMapping("")
    Collection<PatientRecords> findAll() {
        return service.findAll();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> save(@RequestBody PatientRecords record) {
        if(record.getNurse() != null && record.getNurse().getId() == null) record.setNurse(null);
        this.service.save(record);
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), record);
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> update(@RequestBody PatientRecords record) {
        if(record.getNurse() != null && record.getNurse().getId() == null) record.setNurse(null);
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_UPDATE.getMessage(), record);
        if (this.service.update(record) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Not found with this id " + record.getId(), record);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpReturnMessage> delete(@PathVariable("id") int idPatient) {
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_DELETE.getMessage(), idPatient);
        if (this.service.delete(idPatient) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Not found with this id " + idPatient, idPatient);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

}
