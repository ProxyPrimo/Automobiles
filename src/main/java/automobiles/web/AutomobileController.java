package automobiles.web;

import automobiles.model.binding.AutomobileAddBindingModel;
import automobiles.model.entities.AutomobileEntity;
import automobiles.model.service.AutomobileServiceModel;
import automobiles.model.view.AutomobileViewModel;
import automobiles.service.AutomobileService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/automobiles")
@CrossOrigin
public class AutomobileController {

    private final AutomobileService automobileService;
    private final ModelMapper modelMapper;

    public AutomobileController(AutomobileService automobileService, ModelMapper modelMapper) {
        this.automobileService = automobileService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AutomobileViewModel>> getAllAutomobiles() {
        List<AutomobileViewModel> automobiles =
                automobileService.getAllAutomobiles();

        return new ResponseEntity<>(automobiles, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAutomobile(@Valid @RequestBody AutomobileAddBindingModel automobileAddBindingModel, BindingResult bindingResult) {
        automobileService
                .addAutomobile(modelMapper.map(automobileAddBindingModel, AutomobileServiceModel.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomobileAddBindingModel> getAutomobile(@PathVariable Long id) {
        AutomobileEntity entity = automobileService.findById(id);
        AutomobileAddBindingModel automobileAddBindingModel = modelMapper.map(entity, AutomobileAddBindingModel.class);
        automobileAddBindingModel.setOwnerEmail(entity.getOwner().getEmail());

        return new ResponseEntity<>(automobileAddBindingModel, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutomobile(@PathVariable Long id) {
        automobileService.deleteById(id);
    }
}
