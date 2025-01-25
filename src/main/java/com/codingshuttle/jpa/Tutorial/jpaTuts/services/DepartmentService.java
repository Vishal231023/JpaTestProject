package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.DepartmentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.EmployeeEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.DepartmentRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private  final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return  departmentEntity
                .flatMap(department ->
                        employeeEntity.map(employee -> {
                            department.setManager(employee);
                            return departmentRepository.save(department);
                                })).orElse(null);

    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        return employeeEntity.map(employee ->
                {
                   return employee.getManagedDepartment();
                }).orElse(null);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return  departmentEntity
                .flatMap(department ->
                        employeeEntity.map(employee -> {
                            employee.setWorkersInDepartment(department);
                             employeeRepository.save(employee);

                             department.getWorkers().add(employee);
                             return department;
                        })).orElse(null);
    }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return  departmentEntity
                .flatMap(department ->
                        employeeEntity.map(employee -> {
                           employee.getFreelanceDepartments().add(department);

                            employeeRepository.save(employee);
                           department.getFreelancers().add(employee);
                           return department;
                        })).orElse(null);

    }
}
