package com.codingshuttle.jpa.Tutorial.jpaTuts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private AdmissionRecordEntity record;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_professor_mapping",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns =  @JoinColumn(name = "professor_id")
    )
    @JsonIgnore
    private Set<ProfessorEntity> professorsSet;

    @ManyToMany(mappedBy = "studentsSet")
    private Set<SubjectEntity> subjectSet;

    public Set<SubjectEntity> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<SubjectEntity> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public Set<ProfessorEntity> getProfessorsSet() {
        return professorsSet;
    }

    public void setProfessorsSet(Set<ProfessorEntity> professorsSet) {
        this.professorsSet = professorsSet;
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

    public AdmissionRecordEntity getRecord() {
        return record;
    }

    public void setRecord(AdmissionRecordEntity record) {
        this.record = record;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
