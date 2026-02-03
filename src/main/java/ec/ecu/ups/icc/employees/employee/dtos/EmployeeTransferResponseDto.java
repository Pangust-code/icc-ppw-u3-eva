package ec.ecu.ups.icc.employees.employee.dtos;

import java.util.List;

import ec.ecu.ups.icc.employees.departament.dtos.DepartmentDto;

public class EmployeeTransferResponseDto {
    private Long employeeId;
    private String employeeName;
    private List<DepartmentDto> oldDepartment;
    private DepartmentDto newDepartment;
    private String message;

    public EmployeeTransferResponseDto() {
    }

    public EmployeeTransferResponseDto(Long employeeId, String employeeName, List<DepartmentDto> oldDepartment,
            DepartmentDto newDepartment, String message) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.oldDepartment = oldDepartment;
        this.newDepartment = newDepartment;
        this.message = message;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<DepartmentDto> getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(List<DepartmentDto> oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public DepartmentDto getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(DepartmentDto newDepartment) {
        this.newDepartment = newDepartment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
