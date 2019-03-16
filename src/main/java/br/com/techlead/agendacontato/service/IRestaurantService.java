package br.com.techlead.agendacontato.service;

import br.com.techlead.agendacontato.model.Restaurant;

import java.util.Collection;
import java.util.List;

public interface IRestaurantService {
    List<Restaurant> findAll();

    List<Restaurant> findByNameOrTags(String nameOrTags);

    List<Restaurant> findByFavoriteNameOrTags(String nameOrTags);

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);

    Integer delete(int id);

    Restaurant findById(Integer id);

    Collection<Restaurant> findAllFavorites();
}
