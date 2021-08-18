package automobiles.service;

import automobiles.model.service.AutomobileServiceModel;
import automobiles.model.view.AutomobileViewModel;

import java.util.List;

public interface AutomobileService {
    List<AutomobileViewModel> getAllAutomobiles();

    void addAutomobile(AutomobileServiceModel automobileServiceModel);
}
