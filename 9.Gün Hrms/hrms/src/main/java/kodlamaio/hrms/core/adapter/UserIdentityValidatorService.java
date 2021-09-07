package kodlamaio.hrms.core.adapter;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface UserIdentityValidatorService {
	
	boolean isValid(Candidate candidate);

}
