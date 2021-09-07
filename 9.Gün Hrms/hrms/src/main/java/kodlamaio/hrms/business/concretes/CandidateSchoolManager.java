package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

@Service
public class CandidateSchoolManager implements CandidateSchoolService {

	private CandidateSchoolDao candidateSchoolDao;

	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
		super();
		this.candidateSchoolDao = candidateSchoolDao;
	}

	@Override
	public DataResult<List<CandidateSchool>> getAll() {
		List<CandidateSchool> candidateAllSchool = this.candidateSchoolDao.findAll();

		return new SuccesDataResult<List<CandidateSchool>>(candidateAllSchool, "bütün veriler getirildi");
	}

	@Override
	public DataResult<List<CandidateSchool>> getByCandidateIdSortByFinishDate(int candidateId, String direction) {
		Sort sort = Sort.by(Direction.fromString(direction), "finishDate");
		List<CandidateSchool> candidateSchools = this.candidateSchoolDao.getByCandidate_Id(candidateId, sort);

		return new SuccesDataResult<List<CandidateSchool>>(candidateSchools,
				"iş arayana ait eğitim bilgileri sıralı şekilde getirildi");
	}

	@Override
	public Result add(CandidateSchool candidateSchool) {
		this.candidateSchoolDao.save(candidateSchool);
		return new SuccesResult("egitim bilgisi eklendi");
	}

}
