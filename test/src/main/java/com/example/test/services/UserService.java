package com.example.test.services;

import com.example.test.models.Address;
import com.example.test.models.Company;
import com.example.test.models.Geo;
import com.example.test.models.User;
import com.example.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void deleteUser(Long id) {
        userRepository.deleteById((id));
    }

    public User createUser(String name, String email, Address address, Geo geo, String phone, String website, Company company){
        User userInfo = new User();
        userInfo.setName(name);
        userInfo.setEmail(email);
        userInfo.setName(name);
        userInfo.setAddress(address.g); //
        userInfo.setGeo(); //
        userInfo.setPhone(phone);
        userInfo.setWebsite(website);
        userInfo.setCompany(company.getName(), company.getCatchPhrase(), company.getBs()); //
        return userRepository.save(userInfo);
    }

}
