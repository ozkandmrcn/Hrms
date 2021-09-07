package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	Result add (Candidate candidate);
	
	boolean checkFirstName(Candidate candidate);
	boolean checkLastName(Candidate candidate);
	boolean checkIdentitiyNumber(Candidate candidate);
	boolean checkBirthDate(Candidate candidate);
	boolean checkEmail(Candidate candidate);
	boolean checkPassword(Candidate candidate);
	boolean checkPasswordRepeat(Candidate candidate);
	boolean approval(Candidate candidate);

}
