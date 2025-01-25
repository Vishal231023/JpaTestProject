package com.codingshuttle.jpa.Tutorial.jpaTuts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_dept_id", referencedColumnName = "id")
    @JsonIgnore
    private DepartmentEntity workersInDepartment;

    @ManyToMany
    @JoinTable(name = "freelance_department_mapping",
            joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns =  @JoinColumn(name = "department_id")
    )
    @JsonIgnore
    private Set<DepartmentEntity> freelanceDepartments;

    public Set<DepartmentEntity> getFreelanceDepartments() {
        return freelanceDepartments;
    }

    public void setFreelanceDepartments(Set<DepartmentEntity> freelanceDepartments) {
        this.freelanceDepartments = freelanceDepartments;
    }

    public DepartmentEntity getWorkersInDepartment() {
        return workersInDepartment;
    }

    public void setWorkersInDepartment(DepartmentEntity workersInDepartment) {
        this.workersInDepartment = workersInDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(DepartmentEntity managedDepartment) {
        this.managedDepartment = managedDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
