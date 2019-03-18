package br.com.techlead.agendacontato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column
    private String name;

    @Column(name = "brief_description")
    private String briefDescription;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private String address;

    @NotNull
    @Column
    private String tags;

    @NotNull
    @Column
    private String phone;

    @NotNull
    private Boolean favorite = false;

    @NotNull
    private Integer stars = 0;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public Restaurant(Integer id) {
        this.id = id;
    }


}
