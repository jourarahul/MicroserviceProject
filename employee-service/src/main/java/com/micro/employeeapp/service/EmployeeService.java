package com.micro.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micro.employeeapp.entity.Employee;
import com.micro.employeeapp.rep.EmployeeRepo;
import com.micro.employeeapp.response.AddressResponse;
import com.micro.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
//	private DiscoveryClient discoveryClient;

	//private List<ServiceInstance> instances;

	//private ServiceInstance serviceInstance;
	
//	@Autowired
	//private LoadBalancerClient loadBalancerClient;
	
	//@Value("${addressservice.base.url}")
	//private String addressBaseURL;
	
	
	public EmployeeResponse getEmployeeById(int id)
	{
		
		//AddressResponse adddressResponse=new AddressResponse();
		
		
		// db call --> employee 1
				Employee employee=employeeRepo.findById(id).get();
				EmployeeResponse employeeResponse=modelMapper.map(employee, EmployeeResponse.class);
				
				//AddressResponse adddressResponse = restTemplate.getForObject(addressBaseURL+"/address/{id}", AddressResponse.class, id);
				
				//get me the details for the ip and a port number of address service
				
				/*
				 * instances = discoveryClient.getInstances("address-app"); serviceInstance =
				 * instances.get(0); String uri=serviceInstance.getUri().toString();
				 */
				/*
				 * ServiceInstance serviceInstance = loadBalancerClient.choose("address-app");
				 * String uri=serviceInstance.getUri().toString();
				 * System.out.println("uri>>>>>>"+uri); String
				 * contextRoot=serviceInstance.getMetadata().get("configPath");
				 * System.out.println("Config>>>>>>"+contextRoot);
				 */
			//	AddressResponse adddressResponse = restTemplate.getForObject(uri+contextRoot+"/address/{id}", AddressResponse.class, id);
				AddressResponse adddressResponse = restTemplate.getForObject("http://address-app/address-app/api/address/{id}", AddressResponse.class, id);
				
				employeeResponse.setAddressResponse(adddressResponse);
				/*
				 * EmployeeResponse employeeResponse=new EmployeeResponse();
				 * employeeResponse.setId(employee.getId());
				 * employeeResponse.setName(employee.getName());
				 * employeeResponse.setEmail(employee.getEmail());
				 * employeeResponse.setBloodGroup(employee.getBloodGroup());
				 */
				return employeeResponse;
	}

}
