package br.com.techlead.agendacontato.model;

import br.com.techlead.agendacontato.utils.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Classe de persistência da tabela Contato.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Integer age;

    @NotNull
    private String address;

    @NotNull
    private String roomNumber;

    @NotNull
    private String emergencyNumber;

    @NotNull
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private GenderEnum gender;

    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "id", nullable = false)
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "nurseId", referencedColumnName = "id")
    private User nurse;

    public Patient(Integer id) {
        this.id = id;
    }


}