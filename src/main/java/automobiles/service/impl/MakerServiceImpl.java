package automobiles.service.impl;

import automobiles.model.entities.MakerEntity;
import automobiles.repository.MakerRepository;
import automobiles.service.MakerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakerServiceImpl implements MakerService {
    private final MakerRepository makerRepository;

    public MakerServiceImpl(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    @Override
    public void initMakers() {
        if (makerRepository.count() == 0) {
            makerRepository.saveAllAndFlush(List.of(
                    new MakerEntity("Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.", "Suzuki"),
                    new MakerEntity("Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo.", "Pontiac"),
                    new MakerEntity("Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.", "BMW"),
                    new MakerEntity("Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla.", "Lexus"),
                    new MakerEntity("Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.", "Volkswagen")
            ));
        }
    }

    @Override
    public MakerEntity findByMakerName(String name) {
        return makerRepository.findByName(name);
    }

    @Override
    public List<String> findAllMakerNames() {
        return makerRepository.findAllNames();
    }
}
