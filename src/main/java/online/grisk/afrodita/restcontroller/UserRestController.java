package online.grisk.afrodita.restcontroller;

import online.grisk.afrodita.dto.EnterpriseDTO;
import online.grisk.afrodita.dto.UserDTO;
import online.grisk.afrodita.entity.Enterprise;
import online.grisk.afrodita.entity.Role;
import online.grisk.afrodita.entity.User;
import online.grisk.afrodita.response.ResponseRestAPI;
import online.grisk.afrodita.service.EnterpriseService;
import online.grisk.afrodita.service.RoleService;
import online.grisk.afrodita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;

	@Autowired
	EnterpriseService enterpriseService;

	@Autowired
	RoleService roleService;
	
	@PostMapping(value = "/api/users")
    public ResponseEntity<Object> login(@Valid @RequestBody UserDTO usuario, Errors errors) {
        Role role = roleService.findByCode("ADMIN");
        EnterpriseDTO presentedEnterprise = usuario.getEnterprise();
        Enterprise existedEnterprise = enterpriseService.findByRut(presentedEnterprise.getRut());
        if (existedEnterprise == null){
            existedEnterprise = enterpriseService.save(new Enterprise(presentedEnterprise.getRut(), presentedEnterprise.getName()));
        }
        User user = null;
        if(userService.findByUsername(usuario.getUsername())== null && userService.findByEmail(usuario.getEmail())== null){
        	user = userService.save(new User(usuario.getUsername(),usuario.getEmail(), usuario.getPass(), false, true, 0, new Date(), new Date(), existedEnterprise, role));
        }        
        return new ResponseEntity<Object>(new ResponseRestAPI(HttpStatus.OK, HttpStatus.OK.toString(), "Recurso creado", new Date(), user), HttpStatus.OK);
    }
}
