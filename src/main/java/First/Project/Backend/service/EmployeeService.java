package First.Project.Backend.service;

import First.Project.Backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);


    EmployeeDto getEmployeeById(long employeeId);
    List<EmployeeDto> getAllEmployees();


    EmployeeDto updateEmployee(Long employeeId , EmployeeDto updateEmployee);

    void  deletEmployee(Long employeeId);
}
