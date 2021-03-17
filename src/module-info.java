module TileGameTest1 {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
