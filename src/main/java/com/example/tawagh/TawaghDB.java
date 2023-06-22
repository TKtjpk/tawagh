package com.example.tawagh;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class TawaghDB {
    private List<TawaghModel> studiesList = new ArrayList<>();
    private Integer studyCounter = 1;
    public void addStudy(TawaghModel study) {
        study.setId(studyCounter);
        studiesList.add(study);
        studyCounter++;
    }
    public List<TawaghModel> getStudiesList(String name, Integer ects, Integer class_room, String exam) {
        List<TawaghModel> filteredStudies = new ArrayList<>(studiesList);
        if (name != null) {
            filteredStudies.removeIf(n -> !n.getName().equals(name));
        }
        if (ects != null) {
            filteredStudies.removeIf(n -> !n.getEcts_points().equals(ects));
        }
        if (class_room != null) {
            filteredStudies.removeIf(n -> !n.getClass_room().equals(class_room));
        }
        if (exam != null) {
            filteredStudies.removeIf(n -> !n.getExams().equals(exam));
        }
        return filteredStudies;
    }
    public TawaghModel getActivityById(Integer id) {
        for (TawaghModel element : studiesList) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }
    public void deleteAll() {
        studiesList.clear();
    }
    public boolean deleteById(Integer id) {
        TawaghModel toDelete = null;
        for (TawaghModel element : studiesList) {
            if (element.getId().equals(id)) {
                toDelete = element;
            }
        }
        return studiesList.remove(toDelete);
    }
}
