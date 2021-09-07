package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSocialLinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidatesSocialLinkDao;
import kodlamaio.hrms.entities.concretes.CandidatesSocialLink;


@Service
public class CandidateSocialLinkManager implements CandidateSocialLinkService{

	CandidatesSocialLinkDao candidatesSocialLinkDao;
	@Autowired
	public CandidateSocialLinkManager(CandidatesSocialLinkDao candidatesSocialLinkDao) {
		super();
		this.candidatesSocialLinkDao = candidatesSocialLinkDao;
	}

	@Override
	public Result add(CandidatesSocialLink candidatesSocialLink) {
		this.candidatesSocialLinkDao.save(candidatesSocialLink);
		return new SuccesResult("sosyal medya bilgisi eklendi");
	}

	

	
}
