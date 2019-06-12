package online.grisk.afrodita.service.impl;

import online.grisk.afrodita.entity.Enterprise;
import online.grisk.afrodita.entity.User;
import online.grisk.afrodita.repository.EnterpriseRepository;
import online.grisk.afrodita.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    public Enterprise findByRut(String rut) {
        return enterpriseRepository.findByRut(rut);
    }

    public Enterprise save(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }
}
