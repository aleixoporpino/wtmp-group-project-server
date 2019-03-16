package br.com.techlead.agendacontato.repository;

import br.com.techlead.agendacontato.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findRestaurantByOrderByName();

    List<Restaurant> findByNameContainsIgnoreCaseOrTagsContainsIgnoreCaseOrderByName(String name, String tags);

    List<Restaurant> findByFavoriteIsTrueAndNameContainsIgnoreCaseOrTagsContainsIgnoreCaseOrderByName(String name, String tags);

    List<Restaurant> findAllByFavoriteTrue();
}
