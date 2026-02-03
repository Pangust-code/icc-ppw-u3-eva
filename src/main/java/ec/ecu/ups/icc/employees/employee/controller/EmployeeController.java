package ec.ecu.ups.icc.employees.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.ecu.ups.icc.employees.employee.dtos.EmployeeTransferResponseDto;
import ec.ecu.ups.icc.employees.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @PatchMapping("/{employeeId}/transfer")
    public ResponseEntity<EmployeeTransferResponseDto> transferEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam("departmentId") Long departmentId) {
        EmployeeTransferResponseDto response = employeeService.transferEmployee(employeeId, departmentId);
        return ResponseEntity.ok(response);
    }
}
