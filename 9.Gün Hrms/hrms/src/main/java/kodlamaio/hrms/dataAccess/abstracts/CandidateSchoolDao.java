package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateSchool;



public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer> {

	List<CandidateSchool> getByCandidate_Id(int candidateId);

	List<CandidateSchool> getByCandidate_Id(int candidateId, Sort sort);

}
