package First.Project.Backend.service.impl;

import First.Project.Backend.dto.EmployeeDto;
import First.Project.Backend.entity.Employee;
import First.Project.Backend.exception.ResourceNotFountException;
import First.Project.Backend.mapper.EmployeeMapper;
import First.Project.Backend.repository.EmployeeRepository;
import First.Project.Backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeSirviceimpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployeeDto(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {

      Employee employee=  employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFountException("Employee is not exist with givin id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee>employees=employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
                .collect((Collectors.toList()));
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
     Employee employee=   employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFountException("Employee is not exsits with given id " + employeeId)
        );


     employee.setFirstName(updateEmployee.getFirstName());
     employee.setLastName(updateEmployee.getLastName());
     employee.setEmail(updateEmployee.getEmail());


      Employee updateEmployeeObj= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deletEmployee(Long employeeId) {
        Employee employee=   employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFountException("Employee is not exsits with given id " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
