package automobiles.service;

import automobiles.model.entities.AutomobileEntity;
import automobiles.model.service.AutomobileServiceModel;
import automobiles.model.view.AutomobileViewModel;

import java.util.List;

public interface AutomobileService {
    List<AutomobileViewModel> getAllAutomobiles();

    void addAutomobile(AutomobileServiceModel automobileServiceModel);

    void deleteById(Long id);

    AutomobileEntity findById(Long id);

    void updateAutomobile(Long id, AutomobileServiceModel map);
}
