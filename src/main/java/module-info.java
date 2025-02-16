module daggerfx {
	requires dagger;
	requires jakarta.inject;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javax.inject;

	opens daggerfx to javafx.fxml, javafx.graphics;
}
