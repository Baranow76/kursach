package baranow.polikek.kursach.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
@Table(name = "purchase")
@Entity(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "id_purchase")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_purchase_seq")
    @SequenceGenerator(name = "id_purchase_seq", sequenceName = "id_purchase_seq", initialValue = 1, allocationSize = 1)
    private Long idPurchase;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name="count_tovar_in_purchase")
    private Long countTovarInPurchase;

    @ManyToOne
    @JoinColumn(name = "id_buyer")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @CreationTimestamp
    @Column(name = "date_added_purchase")
    private LocalDateTime dateAddedPurchase;
}
