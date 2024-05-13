package baranow.polikek.kursach.service;
import baranow.polikek.kursach.exceptions.ExceptionHandler;
import baranow.polikek.kursach.model.Employee;
import baranow.polikek.kursach.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    private final ExceptionHandler exceptionHandler;

    @Override
    public void addEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        }catch (Exception e){
            exceptionHandler.handleException(e);
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> putEmployeeById(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if(existingEmployee.isPresent()){
            Employee employeeToUpdate = existingEmployee.get();

            if(updatedEmployee.getNameEmployee() != null) {
                employeeToUpdate.setNameEmployee(updatedEmployee.getNameEmployee());
            }
            if(updatedEmployee.getSurnameEmployee() != null) {
                employeeToUpdate.setSurnameEmployee(updatedEmployee.getSurnameEmployee());
            }
            if (updatedEmployee.getNumTelephoneEmployee() != null){
                employeeToUpdate.setNumTelephoneEmployee(updatedEmployee.getNumTelephoneEmployee());
            }

            try {
                employeeRepository.save(employeeToUpdate);
            }catch (Exception e){
                exceptionHandler.handleException(e);
            }
        }
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
