package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Basariyla Listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccesResult("Basariyla Eklendi.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_Id(id));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByActiveStatus() {
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatuss(),"Aktif is ilanlari Listelendi.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int employerId) {
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveAndEmployerId(employerId)
				,"Bir sirkete bagli aktif is ilanları listelendi");	
	}
	
	
	public DataResult<List<JobAdvertisement>> getByAscDate(){
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAscDate(), "Tarihe Gore Listelendi.");
	}
	
	public DataResult<List<JobAdvertisement>> getByCompanyNameAndActive(String companyName){
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyNameAndActive(companyName)
				, "CompanyName ve Aktif is ilanlarina gore Listelendi.");
	}
	
	public DataResult<List<JobAdvertisement>> getByCompanyName(String companyName){
		
		return new SuccesDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyName(companyName)
				, "CompanyName e gore Listelendi.");
	}
}
