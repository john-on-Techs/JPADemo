package com.jotech.learnmodels;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import java.util.List;

@Entity
public class PrintQueue {
    @Id
    private String name;

    @OneToMany(mappedBy = "queue")
    @OrderColumn(name = "print_order")
    private List<PrintJob> jobs;
}
