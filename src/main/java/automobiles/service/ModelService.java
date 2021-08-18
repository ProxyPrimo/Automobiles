package automobiles.service;

import automobiles.model.entities.ModelEntity;

public interface ModelService {
    void initModels();

    ModelEntity findByModelName(String model);
}
