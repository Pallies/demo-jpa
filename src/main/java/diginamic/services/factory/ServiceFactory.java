package diginamic.services.factory;

import java.util.ResourceBundle;

public abstract class ServiceFactory<T> {

	private static final int MODE_STATUS;

	static {
		ResourceBundle props = ResourceBundle.getBundle("developpement");
		MODE_STATUS = Integer.valueOf(props.getString("mode_status"));
	}

	public T builder() {
		Mode mode = Mode.values()[MODE_STATUS];
		T instance = null;
		switch (mode) {
		case DEV:
			instance = getInstanceDev();
			break;
		case TEST:
			instance = getInstanceTest();
			break;
		case PROD:
			instance = getInstanceProd();
			break;
		}
		return instance;
	}

	protected abstract T getInstanceDev();

	protected abstract T getInstanceTest();

	protected abstract T getInstanceProd();

}
