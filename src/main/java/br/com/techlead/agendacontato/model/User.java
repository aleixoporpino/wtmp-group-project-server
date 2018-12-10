package br.com.techlead.agendacontato.model;

import br.com.techlead.agendacontato.utils.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String department;

    @NotNull
    private String email;

    private String beep;

    private String cellphone;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserTypeEnum type;

    @Transient
    private List<PatientRecords> patientsRecords = new ArrayList<>();

    @Transient
    private List<Patient> patients = new ArrayList<>();

    public User(Integer id) {
        this.id = id;
    }

    public User(@org.jetbrains.annotations.NotNull User user) {
        this.id = user.id;
        this.login = user.login;
        this.password = user.password;
        this.email = user.email;
        this.beep = user.beep;
        this.name = user.name;
        this.patientsRecords = user.patientsRecords;
        this.department = user.department;
        this.patients = user.patients;
        this.type = user.type;
    }

}
