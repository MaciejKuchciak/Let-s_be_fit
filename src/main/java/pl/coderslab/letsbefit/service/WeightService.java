package pl.coderslab.letsbefit.service;

import pl.coderslab.letsbefit.entity.Weight;

import java.util.List;

public interface WeightService {

    List<Weight> getAllWeights();

    void add(Weight weight);

    Weight get(Long id);

    void remove(Long id);

    void update(Weight weight);

    List<Weight> getAllWeightsByUserLogin(String username);

    Weight getWeightByUserLogin(String username);

    int weightsQuantity(String username);

    Weight getLastWeightByUserLogin(String username);

}
