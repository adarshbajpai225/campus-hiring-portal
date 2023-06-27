package org.credex.hiring.portal.dao;
import org.credex.hiring.portal.model.Role;
import org.credex.hiring.portal.model.ScoreOfCandidate;
import org.credex.hiring.portal.service.BeanUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository
public class ScoreOfCandidateDaoImpl implements ScoreOfCandidateDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public ScoreOfCandidate createScorecard(ScoreOfCandidate scoreOfCandidate) {
        Session session = sessionFactory.getCurrentSession();
        session.save(scoreOfCandidate);
        return scoreOfCandidate;
    }

    @Override
    @Transactional
    public ScoreOfCandidate updateScorecard(ScoreOfCandidate scoreOfCandidate) {
        try {
            Session session = sessionFactory.getCurrentSession();
            ScoreOfCandidate oldScorecard= session.get(ScoreOfCandidate.class, scoreOfCandidate.getScoreId());
            BeanUtility.copyNonNullProperties(scoreOfCandidate, oldScorecard );
            session.save(oldScorecard);
            return oldScorecard ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    @Transactional
//    public List<ScoreOfCandidate> getAllScorecard() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<ScoreOfCandidate> query = session.createQuery("FROM ScoreOfCandidate", ScoreOfCandidate.class);
//        List<ScoreOfCandidate> scoreOfCandidate = query.getResultList();
//        return scoreOfCandidate;
//    }

    @Override
    @Transactional
    public List<ScoreOfCandidate> getAllScorecard() {
        Session session = sessionFactory.getCurrentSession();
        Query<ScoreOfCandidate> query = session.createQuery("FROM ScoreOfCandidate WHERE scorecard >= :score", ScoreOfCandidate.class);
        query.setParameter("score", 65);
        List<ScoreOfCandidate> scoreOfCandidate = query.getResultList();
        return scoreOfCandidate;
    }

    @Override
    @Transactional
    public ScoreOfCandidate getScorecardById(int userId2) {
        Session session = sessionFactory.getCurrentSession();
        ScoreOfCandidate scoreOfCandidate = session.get(ScoreOfCandidate.class, userId2);
        return scoreOfCandidate;
    }
}