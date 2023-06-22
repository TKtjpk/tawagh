package com.example.tawagh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TawaghApi {

    @Autowired
    private TawaghDB tawaghDB;

    @PostMapping(value = "studies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewStudy(@RequestBody TawaghModel study) {
        tawaghDB.addStudy(study);
    }

    @GetMapping(value = "studies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TawaghModel> getStudiesList(@Nullable @RequestParam("name") String name,
                                            @Nullable @RequestParam("ects") Integer ects,
                                            @Nullable @RequestParam("class") Integer class_room,
                                            @Nullable @RequestParam("exam") String exam) {
        return tawaghDB.getStudiesList(name, ects, class_room, exam);
    }

    @GetMapping(value = "studies/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getActivityById(@PathVariable("id") Integer id) {
        TawaghModel activity = tawaghDB.getActivityById(id);
        if (activity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(activity);
        }
    }
    @DeleteMapping(value = "studies",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete() {
        tawaghDB.deleteAll();
    }
    @DeleteMapping(value = "studies/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted  = tawaghDB.deleteById(id);
        if (isDeleted)
        {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}