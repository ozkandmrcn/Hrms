package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidatesSocialLink;

public interface CandidateSocialLinkService {

	Result add(CandidatesSocialLink candidatesSocialLink);
}
