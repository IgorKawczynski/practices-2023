package com.practices.global;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/** Global abstract super class
 * with automatically generated id (sequence)
 */
@MappedSuperclass
@Getter
@Setter
public abstract class GlobalEntity {

    public static final String SEQUENCE_NAME = "id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_generator")
    @SequenceGenerator(name = "base_generator", sequenceName = SEQUENCE_NAME, allocationSize = 1)
    protected Long id;

}
