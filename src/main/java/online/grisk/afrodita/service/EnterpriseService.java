package online.grisk.afrodita.service;

import online.grisk.afrodita.entity.Enterprise;

public interface EnterpriseService {
	
	public Enterprise findByRut(String rut);
	
	public Enterprise save(Enterprise enterprise);
	
}
