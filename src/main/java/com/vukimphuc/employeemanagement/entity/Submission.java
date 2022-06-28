package com.vukimphuc.employeemanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne()
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
