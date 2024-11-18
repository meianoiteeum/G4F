import br.com.g4f.controller.HomeController;
import br.com.g4f.model.Home;
import br.com.g4f.service.HomeService;
import br.com.g4f.service.impl.HomeServiceImpl;
import br.com.g4f.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        Home home = new Home();
        HomeService homeService = new HomeServiceImpl(home);
        ConsoleView view = new ConsoleView();
        HomeController controller = new HomeController(homeService, view);
        controller.start();
    }

}