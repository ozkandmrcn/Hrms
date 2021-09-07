package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	
	
	List<JobAdvertisement> getByEmployer_Id(int employer_id);
	
	@Query("From JobAdvertisement where is_active = true")
	List<JobAdvertisement> getByActiveStatuss();
	
	@Query("From JobAdvertisement where is_active=true and employer.id=:employerId")
	List<JobAdvertisement> getByActiveAndEmployerId(int employerId);
	
	@Query("From JobAdvertisement where is_active=true ORDER BY due_date ASC")
    List<JobAdvertisement> getByAscDate();
	
	@Query("From JobAdvertisement where employer.companyName=:companyName and is_active = true")
	List<JobAdvertisement> getByCompanyNameAndActive(String companyName);

	@Query("From JobAdvertisement where employer.companyName=:companyName")
	List<JobAdvertisement> getByCompanyName(String companyName);
	
	
}
