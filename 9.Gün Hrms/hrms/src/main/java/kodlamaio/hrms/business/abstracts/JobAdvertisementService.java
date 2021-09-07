package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	
	DataResult<List<JobAdvertisement>> getByActiveStatus();
	
	DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int employerId);
	
	DataResult<List<JobAdvertisement>> getByAscDate();
	
	DataResult<List<JobAdvertisement>> getByCompanyNameAndActive(String companyName);
	
	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	

}
