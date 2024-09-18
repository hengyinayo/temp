package org.ybigta.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Getter
@Setter
@Entity
@Table(name = "attendence")
public class Attendence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private double sessionId;

    @Column(nullable = false)
    private AttStatus status;

    @Column(columnDefinition = "TEXT")
    private String remark;
}
