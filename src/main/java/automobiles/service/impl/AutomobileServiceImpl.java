package automobiles.service.impl;

import automobiles.model.entities.AutomobileEntity;
import automobiles.model.service.AutomobileServiceModel;
import automobiles.model.service.ModelServiceModel;
import automobiles.model.service.UserServiceModel;
import automobiles.model.view.AutomobileViewModel;
import automobiles.repository.AutomobileRepository;
import automobiles.service.AutomobileService;
import automobiles.service.MakerService;
import automobiles.service.ModelService;
import automobiles.service.UserService;
import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutomobileServiceImpl implements AutomobileService {
    private final AutomobileRepository automobileRepository;
    private final UserService userService;
    private final MakerService makerService;
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    public AutomobileServiceImpl(AutomobileRepository automobileRepository, UserService userService, MakerService makerService, ModelService modelService, ModelMapper modelMapper) {
        this.automobileRepository = automobileRepository;
        this.userService = userService;
        this.makerService = makerService;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AutomobileViewModel> getAllAutomobiles() {
        return automobileRepository
                .findAll()
                .stream()
                .map(a -> {
                    AutomobileViewModel viewModel = modelMapper.map(a, AutomobileViewModel.class);

                    viewModel.setOwnerFullName(
                            a.getOwner().getFirstName()
                                    + " "
                                    + a.getOwner().getMiddleName()
                                    + " "
                                    + a.getOwner().getLastName());
                    return viewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addAutomobile(AutomobileServiceModel automobileServiceModel) {
        AutomobileEntity automobileEntity = modelMapper.map(automobileServiceModel, AutomobileEntity.class);

        automobileEntity.setOwner(userService.findByEmail(automobileEntity.getOwner().getEmail()));
        automobileEntity.setModel(modelService.findByModelName(automobileServiceModel.getModel().getName()));
        automobileEntity.setMaker(makerService.findByMakerName(automobileEntity.getMaker().getName()));


        automobileRepository.saveAndFlush(automobileEntity);
    }

    @Override
    public void deleteById(Long id) {
        automobileRepository.deleteById(id);
    }

    @Override
    public AutomobileEntity findById(Long id) {
        return automobileRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAutomobile(Long id, AutomobileServiceModel automobileServiceModel) {
        if (automobileRepository.findById(id).orElse(null) != null) {
            AutomobileEntity e = modelMapper.map(automobileServiceModel, AutomobileEntity.class);
            e.setOwner(userService.findByEmail(e.getOwner().getEmail()));
            e.setModel(modelService.findByModelName(e.getModel().getName()));
            e.setMaker(makerService.findByMakerName(e.getMaker().getName()));
            e.setId(id);
            automobileRepository.saveAndFlush(e);
        }
    }
}
