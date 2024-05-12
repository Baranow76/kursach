package baranow.polikek.kursach.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
@Entity(name = "employee")
public class Employee {
    @Id
    @Column(name="id_employee")
    @GeneratedValue(generator = "id_employee_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_employee_seq", sequenceName = "id_employee_seq", initialValue = 1, allocationSize = 1)
    private Long idEmployee;

    @Column(name = "name_employee")
    private String nameEmployee;

    @Column(name = "surname_employee")
    private String surnameEmployee;

    @Column(name = "number_telephone_employee")
    private String numTelephoneEmployee;

    @OneToMany(mappedBy = "employee")
    private List<Pokupka> pokupkas;

}