package ec.ecu.ups.icc.employees.company.service;

import ec.ecu.ups.icc.employees.company.dtos.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.dtos.EmplooyeesResponseDto;

public interface companyService {

    CompanyDepartmentsDto getCompanyWithDepartments(Long companyId);

    EmplooyeesResponseDto getEmployeesStatisticsByCompany(Long companyId);


}
