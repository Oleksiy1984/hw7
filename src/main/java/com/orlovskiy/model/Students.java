package com.orlovskiy.model;


import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone", nullable = false)
    private int phone;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "email", nullable = false)
    private String email;


}
