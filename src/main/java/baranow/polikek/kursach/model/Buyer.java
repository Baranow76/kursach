package baranow.polikek.kursach.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "buyer")
@Entity(name = "buyer")
public class Buyer {

    @Id
    @Column(name="id_buyer")
    @GeneratedValue(generator = "id_buyer_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_buyer_seq", sequenceName = "id_buyer_seq", initialValue = 1, allocationSize = 1)
    @NotNull
    private Long idBuyer;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "buyer")
    private List<Purchase> purchases;

    @Column(name="surname")
    private String surname;

    @Column(name="telephone_number")
    private String telNumber;
}
