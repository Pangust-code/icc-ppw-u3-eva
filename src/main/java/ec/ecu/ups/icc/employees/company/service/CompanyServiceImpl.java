package ec.ecu.ups.icc.employees.company.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import ec.ecu.ups.icc.employees.company.dtos.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.dtos.EmplooyeesResponseDto;
import ec.ecu.ups.icc.employees.company.models.companyEntity;
import ec.ecu.ups.icc.employees.company.repository.companyRepository;
import ec.ecu.ups.icc.employees.departament.dtos.DepartmentDto;
import ec.ecu.ups.icc.employees.departament.models.departmentEntity;
import ec.ecu.ups.icc.employees.employee.dtos.EmployeeDto;
import ec.ecu.ups.icc.employees.employee.models.employeeEntity;
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

        List<DepartmentDto> departmentDtos = new ArrayList<>();
        BigDecimal totalBudget = BigDecimal.ZERO;
        
        if (company.getDepartments() != null) {
            departmentDtos = company.getDepartments().stream()
                    .map(dept -> new DepartmentDto(
                        dept.getId(),
                        dept.getName(),
                        dept.getBudget()
                    ))
                    .collect(Collectors.toList());

            totalBudget = company.getDepartments().stream()
                    .map(departmentEntity::getBudget)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        
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

        List<employeeEntity> highSalaryEmployees = 
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
