package br.com.techlead.agendacontato.model;

import br.com.techlead.agendacontato.utils.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Date date;

    @NotNull
    private String type;

    @NotNull
    private String details;

    @NotNull
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "nurseId", referencedColumnName = "id")
    private User nurse;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id", nullable = false)
    private Patient patient;

    public PatientRecords(Integer id) {
        this.id = id;
    }

}
