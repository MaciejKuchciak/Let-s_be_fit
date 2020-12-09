package pl.coderslab.letsbefit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.letsbefit.entity.Weight;
import pl.coderslab.letsbefit.repository.WeightRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
    public List<Weight> getAllWeightsByUserLogin(String username) {
        return weightRepository.getAllWeightsByUserLogin(username);
    }

    @Override
    public Weight getWeightByUserLogin(String username) {
        return weightRepository.getAllWeightsByUserLogin(username).get(weightRepository.getAllWeightsByUserLogin(username).size()-1);
    }

    @Override
    public int weightsQuantity(String username) {
        return weightRepository.weightsQuantity(username);
    }

    @Override
    public Weight getLastWeightByUserLogin(String username) {
        return weightRepository.getLastWeightByUserLogin(username);
    }

    @Override
    public double differenceInWeightByUserLogin(String username) {
        Weight firstWeight = weightRepository.getFirstWeightByUserLogin(username);
        if(firstWeight == null){
            return -500000;
        } else {
            double firstWeightDouble = weightRepository.getFirstWeightByUserLogin(username).getCurrentWeight();
            double lastWeightDouble = weightRepository.getLastWeightByUserLogin(username).getCurrentWeight();
            BigDecimal bd = new BigDecimal(lastWeightDouble - firstWeightDouble).setScale(1, RoundingMode.HALF_EVEN);
            double result = bd.doubleValue();
            return result;
        }
    }

    @Override
    public Weight getFirstWeightByUserLogin(String username) {
        return weightRepository.getFirstWeightByUserLogin(username);
    }
}
