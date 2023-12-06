package com.practices.sellers;

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
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
public class SellerEntity extends GlobalEntity {

    private String companyName;

    private String address;

    @OneToMany(mappedBy = "sellerEntity", fetch = LAZY)
    private List<ProductEntity> products;

}
