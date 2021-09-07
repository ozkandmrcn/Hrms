package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapter.UserIdentityValidatorService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	
	private CandidateDao candidateDao;
	private UserIdentityValidatorService userIdentityValidatorService;
	
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return  new SuccesDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidate Basariyla Listelendi.");
	}
	

	@Override
	public Result add(Candidate candidate) {
		if(userIdentityValidatorService.isValid(candidate) == false) {
			return new ErrorResult("Candidate Eklenemedi. Mernis Dogrulanmadi.");
		}else if(approval(candidate) == false){
			return new ErrorResult("Candidate Eklenemedi. Bos Birakamazsiniz.");
		}else if(checkEmailAndIdentityVerify(candidate)==false) {
			return new ErrorResult("Candidate Eklenemedi. Email veya TC Kayitli. ");
		}
		this.candidateDao.save(candidate);
		return new SuccesResult("Candidate Basariyla Eklendi.");
	}

	@Override
	public boolean checkFirstName(Candidate candidate) {
		if(candidate.getFirstName().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(Candidate candidate) {
		if(candidate.getLastName().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIdentitiyNumber(Candidate candidate) {
		if(candidate.getIdentitiyNumber().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkBirthDate(Candidate candidate) {
		if(candidate.getBirthYear().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmail(Candidate candidate) {
		if(candidate.getEmail().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(Candidate candidate) {
		if(candidate.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPasswordRepeat(Candidate candidate) {
		if(candidate.getPasswordRepeat().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean approval(Candidate candidate) {
		if(checkFirstName(candidate) && checkLastName(candidate) && checkIdentitiyNumber(candidate) && checkEmail(candidate) 
				&& checkBirthDate(candidate) && checkPassword(candidate)&& checkPasswordRepeat(candidate) == true) {
			return true;
		}
		return false;

	}
	
	public boolean checkEmailAndIdentityVerify(Candidate candidate) {
		List<Candidate> candidates = this.candidateDao.findAll();
		for (Candidate candidateIndex : candidates) {
			if ( candidate.getEmail() == candidateIndex.getEmail() || candidate.getIdentitiyNumber()== candidateIndex.getIdentitiyNumber()) {
				return true;
			}
		}
		return false;
	}

}
