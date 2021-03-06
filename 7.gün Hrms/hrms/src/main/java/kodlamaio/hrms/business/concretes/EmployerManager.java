package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	
   private  EmployerDao employerDao;
   
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccesDataResult<List<Employer>>(this.employerDao.findAll(), "Employer Basariyla Listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		
		this.employerDao.save(employer);
		return new SuccesResult("Basariyla Eklendi.");
	

}
	}
