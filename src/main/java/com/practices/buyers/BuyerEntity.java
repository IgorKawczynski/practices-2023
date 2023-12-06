package com.practices.buyers;

import com.practices.global.GlobalEntity;
import com.practices.products.ProductEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "buyers")
@Getter
@Setter
@NoArgsConstructor
public class BuyerEntity extends GlobalEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany(mappedBy = "buyerEntity", fetch = LAZY)
    private List<ProductEntity> products;

}
