//package io.springgeeks.duka.service.impl;
//
//import java.util.List;
//
//import io.springgeeks.duka.repository.EmployeeRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import io.springgeeks.duka.domain.ref.Employee;
//import io.springgeeks.duka.service.EmployeeService;
//
//@Service
//@Transactional
//public class EmployeeServiceImpl implements EmployeeService {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public void save(Employee employee) {
//        employeeRepository.save(employee);
//    }
//
//    public List<Employee> findAll() {
//        return (List<Employee>) employeeRepository.findAll();
//    }
//
//    public Employee findByEmployeeNumber(Long employeeId) {
//        return employeeRepository.findByEmployeeNumber(employeeId);
//    }
//}
