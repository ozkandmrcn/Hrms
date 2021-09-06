package kodlamaio.hrms.core.adapter;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.mernis.MernisKpsService;

public class MernisKpsServiceAdapter implements UserIdentityValidatorService {

	@Override
	public boolean isValid(Candidate candidate) {
		
		MernisKpsService mernisKpsService=new MernisKpsService();
		return mernisKpsService.tcKimlikDogrula(Long.parseLong(candidate.getIdentitiyNumber()), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear());
	}

}
