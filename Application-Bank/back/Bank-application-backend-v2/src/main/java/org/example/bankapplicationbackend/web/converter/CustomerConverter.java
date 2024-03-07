package org.example.bankapplicationbackend.web.converter;

import org.example.bankapplicationbackend.bean.Customer;
import org.example.bankapplicationbackend.web.dtos.CustomerDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//MapStruct
@Service
public class CustomerConverter {

    private  CustomerDto customerDto;
    public CustomerDto toDto(Customer customer){
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
//        customerDto.setId(customer.getId());
//        customerDto.setName(customer.getName());
//        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }
    public Customer toBean(CustomerDto customerDto){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
//public  List<CustomerDto> toDto(List<Customer> customerList){
//    List<CustomerDto> customerDtos=new ArrayList<>();
//    for (Customer customer:customerList){
//        CustomerDto customerDto=toDto(customer);
//        customerDtos.add(customerDto);
//    }
//    return  customerDtos;
//}
//    public  List<Customer> toBean(List<CustomerDto> customerDtos){
//        List<Customer> customerList=new ArrayList<>();
//        for (CustomerDto customerDto:customerDtos){
//            Customer customer=toBean(customerDto);
//            customerList.add(customer);
//        }
//        return  customerList;
//    }
    public List<Customer> toBean(List<CustomerDto> dtos) {
        return dtos.stream().map(dto->toBean(dto)).collect(Collectors.toList());
    }
    public List<CustomerDto> toDto(List<Customer> beans) {
        return beans.stream().map(bean->toDto(bean)).collect(Collectors.toList());
    }


}
