package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.Restaurant;
import br.com.techlead.agendacontato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    private RestaurantRepository repository;


    @Transactional(readOnly = true)
    public List<Restaurant> findAll() {
        return repository.findRestaurantByOrderByName();
    }

    @Transactional(readOnly = true)
    public List<Restaurant> findByNameOrTags(String nameOrTags) {
        return repository.findByNameContainsIgnoreCaseOrTagsContainsIgnoreCaseOrderByName(nameOrTags, nameOrTags);
    }

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        repository.save(restaurant);
        return restaurant;
    }

    @Transactional
    public Restaurant update(Restaurant restaurant) {
        Collection<Restaurant> restaurants = findAll();
        for (Restaurant c : restaurants) {
            if (c.getId().equals(restaurant.getId())) {
                repository.save(restaurant);
                return restaurant;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<Restaurant> restaurants = findAll();
        for (Restaurant c : restaurants) {
            if (c.getId().equals(id)) {
                repository.delete(id);
                return id;
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Restaurant findById(Integer id) {
        return repository.findOne(id);
    }
}
