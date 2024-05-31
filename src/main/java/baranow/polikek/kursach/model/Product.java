package baranow.polikek.kursach.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="product")
@Table(name="product")
public class Product {

    @Id
    @Column(name="id_product")
    @GeneratedValue(generator = "id_prod_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_prod_seq", sequenceName = "id_prod_seq", initialValue = 1, allocationSize = 1)
    @NotNull
    private Long idProduct;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_available_in_stock")
    private Long countAvailable;

    @Column(name="price")
    private Long price;

    @Column(name="discount")
    private Long discount;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases;




}
