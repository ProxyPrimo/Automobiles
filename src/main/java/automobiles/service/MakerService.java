package automobiles.service;

import automobiles.model.entities.MakerEntity;

import java.util.List;

public interface MakerService {
    void initMakers();

    MakerEntity findByMakerName(String model);

    List<String> findAllMakerNames();
}
