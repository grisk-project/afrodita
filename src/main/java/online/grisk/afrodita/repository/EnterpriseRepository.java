/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.grisk.afrodita.repository;

import online.grisk.afrodita.entity.Enterprise;
import online.grisk.afrodita.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */
@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long> {
    Enterprise findByRut(String rut);
}


