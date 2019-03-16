package br.com.techlead.agendacontato.controller;

import br.com.techlead.agendacontato.model.Restaurant;
import br.com.techlead.agendacontato.service.IRestaurantService;
import br.com.techlead.agendacontato.utils.HttpMessageEnum;
import br.com.techlead.agendacontato.utils.HttpReturnMessage;
import br.com.techlead.agendacontato.utils.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController extends RestUtils<IRestaurantService> {

    @GetMapping("")
    Collection<Restaurant> findAll() {
        return service.findAll();
    }

    @GetMapping("/favorites")
    Collection<Restaurant> findAllFavorites() {
        return service.findAllFavorites();
    }


    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> save(@RequestBody Restaurant restaurant) {
        this.service.save(restaurant);
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_SAVE.getMessage(), restaurant);
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<HttpReturnMessage> update(@PathVariable("id") int idRestaurant, @RequestBody Restaurant restaurant) {
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_UPDATE.getMessage(), restaurant);
        if (this.service.update(restaurant) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + restaurant.getId() + " não encontrado.", restaurant);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpReturnMessage> delete(@PathVariable("id") int idRestaurant) {
        httpReturnMessage = new HttpReturnMessage(0, HttpMessageEnum.SUCCESS_DELETE.getMessage(), idRestaurant);
        if (this.service.delete(idRestaurant) == null) {
            httpReturnMessage = new HttpReturnMessage(1, "Registro com id " + idRestaurant + " não encontrado.", idRestaurant);
            return new ResponseEntity<>(httpReturnMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(httpReturnMessage, HttpStatus.OK);
    }

    @GetMapping("nameortags/{name}")
    public List<Restaurant> findByName(@PathVariable("name") String name) {
        return this.service.findByNameOrTags(name);
    }

    @GetMapping("favorites/{name}")
    public List<Restaurant> findFavoritesByNameOrTags(@PathVariable("name") String name) {
        return this.service.findByNameOrTags(name);
    }

    @GetMapping("/{id}")
    public Restaurant findByName(@PathVariable("id") Integer id) {
        return this.service.findById(id);
    }

}
