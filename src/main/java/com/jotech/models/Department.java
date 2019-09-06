package com.jotech.models;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import java.util.Map;

public class Department {
    @Id
    private int id;
    @OneToMany(mappedBy = "department")
    @MapKeyColumn(name="cub_id")
    private Map<String,Employee> employeeByCubicle;

}
