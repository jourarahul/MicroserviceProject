package com.micro.addressapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.micro.addressapp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	//address based on  a employee id
	
	@Query(nativeQuery=true,value="SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM seleniumexpressnew.address ea join seleniumexpressnew.employee e on e.id=ea.employee_id where ea.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
	
}
