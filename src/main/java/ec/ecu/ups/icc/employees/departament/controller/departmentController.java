package ec.ecu.ups.icc.employees.departament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.ecu.ups.icc.employees.departament.dtos.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.departament.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class departmentController {
    

    private DepartmentService departmentService;

    

    public departmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/{id}/employees")
    public ResponseEntity<DepartmentWithEmployeesDto> getDepartmentEmployees(@PathVariable("id") Long id) {
        DepartmentWithEmployeesDto department = departmentService.getDepartmentWithEmployees(id);
        return ResponseEntity.ok(department);
    }
}
