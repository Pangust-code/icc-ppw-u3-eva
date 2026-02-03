package ec.ecu.ups.icc.employees.company.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import ec.ecu.ups.icc.employees.company.dtos.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.dtos.EmplooyeesResponseDto;
import ec.ecu.ups.icc.employees.company.models.companyEntity;
import ec.ecu.ups.icc.employees.company.repository.companyRepository;
import ec.ecu.ups.icc.employees.employee.dtos.EmployeeDto;
import ec.ecu.ups.icc.employees.employee.repository.employeeRepository;
import exceptions.domain.NotFoundException;

@Service
public class CompanyServiceImpl implements companyService {

    private final companyRepository companyRepository;
    private final employeeRepository employeeRepository;

    public CompanyServiceImpl(companyRepository companyRepository, employeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public CompanyDepartmentsDto getCompanyWithDepartments(Long companyId) {
        companyEntity company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NotFoundException("Compañía no encontrada con id: " + companyId));

        List<ec.ecu.ups.icc.employees.departament.dtos.DepartmentDto> departmentDtos = new java.util.ArrayList<>();
        java.math.BigDecimal totalBudget = java.math.BigDecimal.ZERO;
        
        if (company.getDepartments() != null) {
            departmentDtos = company.getDepartments().stream()
                    .map(dept -> new ec.ecu.ups.icc.employees.departament.dtos.DepartmentDto(
                        dept.getId(),
                        dept.getName(),
                        dept.getBudget()
                    ))
                    .collect(java.util.stream.Collectors.toList());
            
            // Calcular el presupuesto total
            totalBudget = company.getDepartments().stream()
                    .map(ec.ecu.ups.icc.employees.departament.models.departmentEntity::getBudget)
                    .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
        }
        
        // Crear el DTO de respuesta
        CompanyDepartmentsDto dto = new CompanyDepartmentsDto();
        dto.setCompanyId(company.getId());
        dto.setCompanyName(company.getName());
        dto.setCountry(company.getCountry());
        dto.setDepartments(departmentDtos);
        dto.setDepartmentCount(departmentDtos.size());
        dto.setTotalBudget(totalBudget);
        
        return dto;
    }

    @Override
    public EmplooyeesResponseDto getEmployeesStatisticsByCompany(Long companyId) {

        companyEntity company = companyRepository.findById(companyId)
                .orElseThrow(() -> new NotFoundException("Compañía no encontrada con id: " + companyId));
        
        BigDecimal averageSalary = employeeRepository.findAverageSalaryByCompany(companyId);
        if (averageSalary == null) {
            averageSalary = BigDecimal.ZERO;
        }

        List<ec.ecu.ups.icc.employees.employee.models.employeeEntity> highSalaryEmployees = 
                employeeRepository.findHighSalaryEmployeesByCompany(companyId, averageSalary);
        

        List<EmployeeDto> employeeDtos = highSalaryEmployees.stream()
                .map(emp -> new EmployeeDto(
                    emp.getId(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getEmail(),
                    emp.getSalary()
                ))
                .collect(Collectors.toList());
        
        EmplooyeesResponseDto response = new EmplooyeesResponseDto();
        response.setCompanyName(company.getName());
        response.setMinSalary(averageSalary);
        response.setCount(new BigDecimal(employeeDtos.size()));
        response.setEmployees(employeeDtos);
        
        return response;
    }
    
}
