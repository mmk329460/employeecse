package First.Project.Backend.mapper;

import First.Project.Backend.dto.EmployeeDto;
import First.Project.Backend.entity.Employee;

public class EmployeeMapper {
/// /create EmployeeDto and EmployeeMapper
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public  static  Employee mapToEmployeeDto(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}