package automobiles.service;

import automobiles.model.view.AutomobileViewModel;

import java.util.List;

public interface AutomobileService {
    List<AutomobileViewModel> getAllAutomobiles();
}
