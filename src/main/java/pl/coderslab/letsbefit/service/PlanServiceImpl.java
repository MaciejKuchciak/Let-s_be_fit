package pl.coderslab.letsbefit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.Plan;
import pl.coderslab.letsbefit.repository.PlanRepository;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }


    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public void add(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public Plan get(Long id) {
        return planRepository.getOne(id);
    }

    @Override
    public void remove(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public void update(Plan plan) {
        planRepository.save(plan);

    }
}
