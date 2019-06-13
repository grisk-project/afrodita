package online.grisk.afrodita.restcontroller;

import online.grisk.afrodita.estrategy.Estrategy;
import online.grisk.afrodita.estrategy.impl.CreatedUserAdminByLogin;
import online.grisk.afrodita.model.OrganizationModel;
import online.grisk.afrodita.model.UserModel;
import online.grisk.afrodita.entity.Organization;
import online.grisk.afrodita.entity.Role;
import online.grisk.afrodita.entity.User;
import online.grisk.afrodita.dto.ResponseRestAPI;
import online.grisk.afrodita.processor.Processor;
import online.grisk.afrodita.service.OrganizationService;
import online.grisk.afrodita.service.RoleService;
import online.grisk.afrodita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class UserRestController {

    @Autowired
    Processor userProcessor;
    
    @Autowired
    Estrategy createdUserAdminByLogin;

	@PostMapping(value = "/api/created-user-admin-by-login")
    public ResponseEntity<?> login(@Valid @RequestBody UserModel usuario, Errors errors) {
        if(errors.hasErrors()) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
        return userProcessor.run(usuario, createdUserAdminByLogin);
    }

    /*@Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/api/test-eureka")
    public ResponseEntity<?> test() {
        final Object forObject = restTemplate.getForObject("http://atenea/users", Object.class);
        return null;
    }*/
}
