package automobiles.service;

import automobiles.model.entities.MakerEntity;

public interface MakerService {
    void initMakers();

    MakerEntity findByMakerName(String model);
}
