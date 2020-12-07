package pl.coderslab.letsbefit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.repository.WeightRepository;

import java.util.List;

@Service
public class WeightServiceImpl implements WeightService{

    private final WeightRepository weightRepository;

    @Autowired
    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Override
    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    @Override
    public void add(Weight weight) {
        weightRepository.save(weight);
    }

    @Override
    public Weight get(Long id) {
        return weightRepository.getOne(id);
    }

    @Override
    public void remove(Long id) {
        weightRepository.deleteById(id);
    }

    @Override
    public void update(Weight weight) {
        weightRepository.save(weight);
    }

    @Override
    public List<User> getWeightByUserLogin(String username) {
        return weightRepository.getWeightByUserLogin(username);
    }
}
