package com.cl.Logistics.Freight.Network.Services;

import com.cl.Logistics.Freight.Network.Repositories.StaffRepositories;
import com.cl.Logistics.Freight.Network.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    StaffRepositories staffRepository;

    @Autowired
    public StaffService(StaffRepositories staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Long addStaff(String name,
                         String role,
                         String phoneNumber) {

        if (name == null) {
            return null;
        }

        Staff staff = new Staff();

        staff.setName(name);
        staff.setRole(role);
        staff.setPhoneNumber(phoneNumber);
        staff.setIsActive(true);

        return staffRepository.save(staff).getId();
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getById(Long id) {

        Optional<Staff> staff = staffRepository.findById(id);

        if (staff.isPresent() && staff.get().getIsActive()) {
            return staff.get();
        }

        return new Staff();
    }
    public Staff updateStaff(Long id,
                             String name,
                             String role,
                             String phoneNumber) {

        Staff staff = staffRepository.findById(id).orElse(null);

        if (staff == null || !staff.getIsActive()) {
            return new Staff();
        }

        staff.setName(name);
        staff.setRole(role);
        staff.setPhoneNumber(phoneNumber);

        return staffRepository.save(staff);
    }

    public Boolean deleteById(Long id) {

        Staff staff = staffRepository.findById(id).orElse(null);

        if (staff == null || !staff.getIsActive()) {
            return false;
        }

        staff.setIsActive(false);

        staffRepository.save(staff);

        return true;
    }
}

