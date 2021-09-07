package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgremmingLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;


@Service
public class ProgrammingLanguageManager implements ProgremmingLanguageService{
	private ProgrammingLanguageDao programmingLanguageDao;
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
	}
	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
	
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccesResult("Peogramlama diliniz sisteme eklendi");
	}
	

}
