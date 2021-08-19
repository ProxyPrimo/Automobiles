package automobiles.service.impl;

import automobiles.model.entities.ModelEntity;
import automobiles.model.entities.enumerations.CarType;
import automobiles.model.entities.enumerations.EngineType;
import automobiles.repository.ModelRepository;
import automobiles.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void initModels() {
        if (modelRepository.count() == 0) {
            modelRepository.saveAll(
                    List.of(
                    new ModelEntity("Mustang", 1979, EngineType.HYBRID, CarType.HATCHBACK),
                    new ModelEntity("Silverado", 2008, EngineType.DIESEL, CarType.HATCHBACK),
                    new ModelEntity("Vibe", 2007, EngineType.DIESEL, CarType.HATCHBACK),
                    new ModelEntity("GLK-Class", 2011, EngineType.GAS, CarType.HATCHBACK),
                    new ModelEntity("Town Car", 2007, EngineType.GAS, CarType.COUPE),
                    new ModelEntity("Phantom", 2009, EngineType.HYBRID, CarType.COUPE),
                    new ModelEntity("Murciélago", 2002, EngineType.GAS, CarType.COUPE),
                    new ModelEntity("Venture", 2001, EngineType.GAS, CarType.SEDAN),
                    new ModelEntity("Malibu", 2010, EngineType.HYBRID, CarType.SEDAN),
                    new ModelEntity("Tempo", 1993, EngineType.HYBRID, CarType.SEDAN)
            ));
        }
    }

    @Override
    public ModelEntity findByModelName(String model) {
        return modelRepository.findByName(model);
    }

    @Override
    public List<String> findAllModelNames() {
        return modelRepository.findAllNames();
    }
}
