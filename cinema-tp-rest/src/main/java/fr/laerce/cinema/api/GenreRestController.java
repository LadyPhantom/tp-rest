package fr.laerce.cinema.api;

import fr.laerce.cinema.model.Genre;
import fr.laerce.cinema.service.GenreManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api/genre")
public class GenreRestController {

    private GenreManager genreManager;

    /**
     * Constructeur permettant l'injection de beans
     * @param genreManager le service de gestion du Genre du film
     */
    public GenreRestController(GenreManager genreManager){
        this.genreManager=genreManager;
        assert(genreManager != null);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Genre get(@PathVariable("id") long id){
        return genreManager.getById(id);
    }

    /**
     *
     * @return
     */
    @GetMapping("")
    public List<Genre> getAll() {
        return genreManager.getAll();
    }

    /**
     *
     * @param genre fichier json
     * @return
     */
    @PostMapping("")
    public Genre add(@RequestBody Genre genre){
        if (genre.getName().isEmpty()) throw new IllegalArgumentException("Name is empty");
        return genreManager.save(genre);
    }

    /*@PostMapping("")
    public Genre add(@Valid @RequestBody Genre genre, BidingResult result){
        if (genre.getName().isEmpty()) throw new IllegalArgumentException("Name is empty");
        return genreManager.save(genre);
        if (result.hasError()){
        return ... ;
        }
    }
    */
    /**
     *
     * @param genre
     * @return
     */
    @PutMapping("")
    public Genre mod(@RequestBody Genre genre){
        return genreManager.save(genre);
    }

    /**
     *
     * @param genre
     * @return
     */
    @DeleteMapping("")
    public Genre rm(@RequestBody Genre genre){
        return genreManager.delete(genre.getId());
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/rm/{id}")
    public Genre rm(@PathVariable("id")long id){
        return genreManager.delete(id);
    }
}
