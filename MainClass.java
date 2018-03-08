package springbootwithjavafx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

@SpringBootApplication
public class MainClass extends Application {

	private ConfigurableApplicationContext springContext;

	@Override
	public void init() throws Exception {
		// springContext = SpringApplication.run(WizardHandler.class);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MainClass.class);
		springContext = builder.headless(false).run();
	}

	@Override
	public void stop() throws Exception {
		System.out.println(springContext.isRunning() + "  ::  " + springContext.isActive());
		// springContext.stop();
		springContext.close();
		System.out.println(springContext.isRunning() + "  ::  " + springContext.isActive());
	}

	public static void main(String[] args) {
		launch(MainClass.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Text text = new Text();
		text.setText("Hello how are you");
		text.setX(50);
		text.setY(50);
		Group root = new Group(text);
		Scene scene = new Scene(root, 600, 300);
		primaryStage.setTitle("Sample Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
