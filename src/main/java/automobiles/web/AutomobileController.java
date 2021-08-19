package automobiles.web;

import automobiles.error.ErrorInfo;
import automobiles.model.binding.AutomobileAddBindingModel;
import automobiles.model.entities.AutomobileEntity;
import automobiles.model.service.AutomobileServiceModel;
import automobiles.model.view.AutomobileViewModel;
import automobiles.service.AutomobileService;
import automobiles.service.MakerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<ErrorInfo>> createAutomobile(@Valid @RequestBody AutomobileAddBindingModel automobileAddBindingModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ErrorInfo> collect = bindingResult
                    .getAllErrors()
                    .stream()
                    .map(err -> new ErrorInfo(err.getDefaultMessage(), ((FieldError) err).getField()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(collect, HttpStatus.NOT_ACCEPTABLE);
        }

        automobileService
                .addAutomobile(modelMapper.map(automobileAddBindingModel, AutomobileServiceModel.class));
        return ResponseEntity.ok().build();
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

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ErrorInfo>> updateAutomobile(@PathVariable Long id
            , @Valid @RequestBody AutomobileAddBindingModel automobileAddBindingModel
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorInfo> collect = bindingResult.getAllErrors()
                    .stream()
                    .map(err -> new ErrorInfo(err.getDefaultMessage(), ((FieldError) err).getField()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(collect, HttpStatus.BAD_REQUEST);
        }
        automobileService.updateAutomobile(id
                , modelMapper.map(automobileAddBindingModel, AutomobileServiceModel.class));

        return ResponseEntity.ok().build();
    }
}
