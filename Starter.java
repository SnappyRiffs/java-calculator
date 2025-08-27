public class Starter {

	public static void main(String[] args) {

		// MVC model
		MyModel model = new MyModel();
		MyView view = new MyView(model);
		new MyController(model, view);
	}
}
