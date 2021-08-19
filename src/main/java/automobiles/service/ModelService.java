package automobiles.service;

import automobiles.model.entities.ModelEntity;

import java.util.List;

public interface ModelService {
    void initModels();

    ModelEntity findByModelName(String model);

    List<String> findAllModelNames();
}
