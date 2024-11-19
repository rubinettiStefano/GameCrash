module com.generation.gamecrash {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;


	opens com.generation.gamecrash to javafx.fxml;
	exports com.generation.gamecrash;
	exports com.generation.gamecrash.controller;
	opens com.generation.gamecrash.controller to javafx.fxml;
}