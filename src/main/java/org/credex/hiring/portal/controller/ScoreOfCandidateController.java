package org.credex.hiring.portal.controller;
import org.credex.hiring.portal.dao.ScoreOfCandidateDao;
import org.credex.hiring.portal.model.Role;
import org.credex.hiring.portal.model.ScoreOfCandidate;
import org.credex.hiring.portal.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/score")
public class ScoreOfCandidateController {
    @Autowired
    private ScoreOfCandidateDao scoreOfCandidateDao;
    @GetMapping("/getById/{userId2}")
    public ScoreOfCandidate getScorecardById(@PathVariable int userId2) {
        return scoreOfCandidateDao.getScorecardById(userId2);
    }
    @GetMapping("/get")
    public List<ScoreOfCandidate> getAllScorecard() {
        return scoreOfCandidateDao.getAllScorecard();
    }
    @PostMapping(value="/create")
    public ScoreOfCandidate createScorecard(@RequestBody ScoreOfCandidate scoreOfCandidate) {
        return scoreOfCandidateDao.createScorecard(scoreOfCandidate);
    }

    @PutMapping("/update")
    public ScoreOfCandidate updateScorecard(@RequestBody ScoreOfCandidate scoreOfCandidate)
    {
        System.out.println("It's Called ");
          return scoreOfCandidateDao.updateScorecard(scoreOfCandidate);
    }

}





