package automobiles.service.impl;

import automobiles.model.view.AutomobileViewModel;
import automobiles.repository.AutomobileRepository;
import automobiles.service.AutomobileService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutomobileServiceImpl implements AutomobileService {
    private final AutomobileRepository automobileRepository;
    private final ModelMapper modelMapper;

    public AutomobileServiceImpl(AutomobileRepository automobileRepository, ModelMapper modelMapper) {
        this.automobileRepository = automobileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AutomobileViewModel> getAllAutomobiles() {
        return automobileRepository
                .findAll()
                .stream()
                .map(a -> modelMapper.map(a, AutomobileViewModel.class))
                .collect(Collectors.toList());
    }
}
