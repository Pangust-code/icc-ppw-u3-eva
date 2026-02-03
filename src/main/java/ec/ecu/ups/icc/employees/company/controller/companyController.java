package ec.ecu.ups.icc.employees.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.ecu.ups.icc.employees.company.dtos.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.dtos.EmplooyeesResponseDto;
import ec.ecu.ups.icc.employees.company.service.companyService;

@RestController
@RequestMapping("/api/companies")
public class companyController {
    
    @Autowired
    private companyService companyService;
    
    @GetMapping("/{id}/departments")
    public ResponseEntity<CompanyDepartmentsDto> getCompanyDepartments(@PathVariable Long id) {
        CompanyDepartmentsDto company = companyService.getCompanyWithDepartments(id);
        return ResponseEntity.ok(company);
    }
    
    @GetMapping("/{id}/high-salary-employees")
    public ResponseEntity<EmplooyeesResponseDto> getHighSalaryEmployees(@PathVariable Long id) {
        EmplooyeesResponseDto response = companyService.getEmployeesStatisticsByCompany(id);
        return ResponseEntity.ok(response);
    }
}
