package com.bitirme.BitirmeProjesi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ogretmen")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Teacher {
    @Id
    @SequenceGenerator(name = "SEQ_ogretmen_id", sequenceName = "SEQ_ogretmen_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ogretmen_id")
    @Column(name = "ogretmen_Id", unique = true, nullable = false)
    private Long ogretmen_Id;
    @Column(name = "ogretmenAdi")
    private String ogretmenAdi;
    @Column(name = "ogretmenSoyadi")
    private String ogretmenSoyadi;
    @Column(name = "ogretmen_no", nullable = false, unique = true)
    private Long ogretmen_no;
    @Column(name = "ogretmen_tc", unique = true, nullable = false)
    private Long ogretmen_TC;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher", orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}