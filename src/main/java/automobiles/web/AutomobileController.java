package automobiles.web;

import automobiles.model.binding.AutomobileAddBindingModel;
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

    @GetMapping("/add")
    public ResponseEntity<AutomobileAddBindingModel> addAutomobile() {
        return new ResponseEntity<>(new AutomobileAddBindingModel(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void>
    createAutomobile(@Valid @RequestBody AutomobileAddBindingModel automobileAddBindingModel, BindingResult bindingResult) {
        automobileService
                .addAutomobile(modelMapper.map(automobileAddBindingModel, AutomobileServiceModel.class));
        return null;
    }
}
