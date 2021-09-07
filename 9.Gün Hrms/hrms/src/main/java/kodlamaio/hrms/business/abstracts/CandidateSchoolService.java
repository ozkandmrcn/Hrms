package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSchool;


public interface CandidateSchoolService {
	DataResult<List<CandidateSchool>> getAll();
	
	DataResult<List<CandidateSchool>> getByCandidateIdSortByFinishDate(int candidateId,String direction);
	
	Result add(CandidateSchool candidateSchool);
	

}
