package automobiles.web;


import automobiles.service.MakerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/makers")
@CrossOrigin
public class MakerController {
    private final MakerService makerService;

    public MakerController(MakerService makerService) {
        this.makerService = makerService;
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllMakerNames() {
        List<String> makerNames = makerService.findAllMakerNames();

        return new ResponseEntity<>(makerNames, HttpStatus.OK);
    }

}
