package online.grisk.afrodita.estrategy.impl;

import online.grisk.afrodita.dto.ResponseRestAPI;
import online.grisk.afrodita.entity.Organization;
import online.grisk.afrodita.entity.Role;
import online.grisk.afrodita.entity.User;
import online.grisk.afrodita.estrategy.Estrategy;
import online.grisk.afrodita.model.OrganizationModel;
import online.grisk.afrodita.model.UserModel;
import online.grisk.afrodita.service.OrganizationService;
import online.grisk.afrodita.service.RoleService;
import online.grisk.afrodita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreatedUserAdminByLogin implements Estrategy {

	@Autowired
	UserService userService;

	@Autowired
	OrganizationService organizationService;

	@Autowired
	RoleService roleService;

	@Override
	public ResponseEntity<?> execute(Object object) {
		try {
			UserModel presentedUser = (UserModel) object;
			if (userService.findByUsername(presentedUser.getUsername()) == null
					&& userService.findByEmail(presentedUser.getEmail()) == null) {
				Role role = roleService.findByCode("ADMIN");
				if (role == null)
					return new ResponseEntity<Object>(new ResponseRestAPI(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
							HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un problema inesperado", new Date(), null),
							HttpStatus.INTERNAL_SERVER_ERROR);

				OrganizationModel presentedOrganization = presentedUser.getOrganization();
				Organization existedOrganization = organizationService.findByRut(presentedOrganization.getRut());
				if (existedOrganization == null) {
					existedOrganization = organizationService
							.save(new Organization(presentedOrganization.getRut(), presentedOrganization.getName()));
				}
				User user = userService
						.save(new User(presentedUser.getUsername(), presentedUser.getEmail(), presentedUser.getPass(),
								false, true, (short) 0, new Date(), new Date(), existedOrganization, role));

				return new ResponseEntity<Object>(new ResponseRestAPI(HttpStatus.CREATED.toString(), HttpStatus.CREATED,
						"Usuario creado correctamente", new Date(), user), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(new ResponseRestAPI(HttpStatus.CONFLICT.toString(),
						HttpStatus.CONFLICT, "Usuario ya registrado con el mismo username y/o email.", new Date(), null),
						HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(new ResponseRestAPI(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un problema inesperado", new Date(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
