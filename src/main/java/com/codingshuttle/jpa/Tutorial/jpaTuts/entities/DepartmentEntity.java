package com.codingshuttle.jpa.Tutorial.jpaTuts.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @OneToOne
    @JoinColumn(name = "department_Manager",nullable = true)
    private EmployeeEntity manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    // Explicitly define the setter (optional if Lombok works)
    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }


}
