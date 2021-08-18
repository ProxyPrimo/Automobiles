package automobiles.web;

import automobiles.model.binding.AutomobileAddBindingModel;
import automobiles.model.view.AutomobileViewModel;
import automobiles.service.AutomobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/automobiles")
@CrossOrigin
public class AutomobileController {
    private final AutomobileService automobileService;

    public AutomobileController(AutomobileService automobileService) {
        this.automobileService = automobileService;
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
}
