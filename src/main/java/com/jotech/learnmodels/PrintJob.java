package com.jotech.learnmodels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrintJob {
    @Id
    private int id;

    @ManyToOne
    private PrintQueue queue;
}
