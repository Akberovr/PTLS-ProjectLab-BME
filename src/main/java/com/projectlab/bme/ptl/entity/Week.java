package com.projectlab.bme.ptl.entity;


import javax.persistence.*;

@Entity
@Table(name="week")
public class Week {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "week_id")
    private int week_id;

    @Column(name="week_name")
    private String week_name;

}
