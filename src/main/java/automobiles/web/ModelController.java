package automobiles.web;

import automobiles.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
@CrossOrigin
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllModelNames() {
        List<String> modelNames = modelService.findAllModelNames();

        return new ResponseEntity<>(modelNames, HttpStatus.OK);
    }
}
