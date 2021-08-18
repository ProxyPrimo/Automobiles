package automobiles.init;

import automobiles.service.MakerService;
import automobiles.service.ModelService;
import automobiles.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;
    private final ModelService modelService;
    private final MakerService makerService;

    public DBInit(UserService userService, ModelService modelService, MakerService makerService) {
        this.userService = userService;
        this.modelService = modelService;
        this.makerService = makerService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initUsers();
        modelService.initModels();
        makerService.initMakers();
    }
}
