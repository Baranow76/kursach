package baranow.polikek.kursach.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="tovar")
@Table(name="tovar")
public class Tovar {

    @Id
    @Column(name="id_tovar")
    @GeneratedValue(generator = "id_tov_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_tov_seq", sequenceName = "id_tov_seq", initialValue = 1, allocationSize = 1)
    private Long idTovar;

    @Column(name="tovar_name")
    private String tovarName;

    @Column(name="tovar_available_in_stock")
    private Long countAvailable;

    @Column(name="price")
    private Long price;

    @Column(name="discount")
    private Long discount;

    @JsonIgnore
    @OneToMany(mappedBy = "tovar")
    private List<Pokupka> pokupkas;




}
