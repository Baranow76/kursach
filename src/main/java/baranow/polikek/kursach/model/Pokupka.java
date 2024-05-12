package baranow.polikek.kursach.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pokupka")
@Entity(name = "pokupka")

public class Pokupka {

    @Id
    @Column(name="id_polupki")
    @GeneratedValue(generator = "id_buyer_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_buyer_seq", sequenceName = "id_buyer_seq", initialValue = 1, allocationSize = 1)
    private Long idPokupki;

    @ManyToOne
    @JoinColumn(name = "id_tovara")
    private Tovar tovar;

    @Column(name="count_tovar_in_pokupka")
    private Long countTovarInPokupka;

    @ManyToOne
    @JoinColumn(name = "id_buyer")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @CreationTimestamp
    @Column(name = "date_change_place")
    private LocalDateTime dateAddPokupka;






}
