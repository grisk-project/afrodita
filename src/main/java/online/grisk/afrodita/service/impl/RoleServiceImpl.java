package online.grisk.afrodita.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.grisk.afrodita.entity.Enterprise;
import online.grisk.afrodita.entity.Role;
import online.grisk.afrodita.repository.EnterpriseRepository;
import online.grisk.afrodita.repository.RoleRepository;
import online.grisk.afrodita.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
    RoleRepository roleRepository;

    public Role findByCode(String code) {
        return roleRepository.findByCode(code);
    }
}
