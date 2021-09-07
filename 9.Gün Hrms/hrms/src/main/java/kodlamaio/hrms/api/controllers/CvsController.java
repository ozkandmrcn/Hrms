package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV;



@RestController
@RequestMapping("/api/CV")

public class CvsController {

	private CVService cvService;

	@Autowired
	public CvsController(CVService cvService) {
		super();
		this.cvService = cvService;
	}

	@GetMapping("/getByCandidateId")
	public DataResult<List<CV>> getByCandidateId(@RequestParam int candidateId) {
		return this.cvService.getByCandidateId(candidateId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody CV cv) {
		return this.cvService.add(cv);
	}
}
