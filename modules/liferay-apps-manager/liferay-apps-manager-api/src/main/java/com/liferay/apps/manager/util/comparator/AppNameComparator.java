package com.liferay.apps.manager.util.comparator;

import com.liferay.apps.manager.model.App;
import com.liferay.portal.kernel.util.OrderByComparator;

public class AppNameComparator extends OrderByComparator<App> {

	public static final String ORDER_BY_ASC = "App.name ASC";

	public static final String ORDER_BY_DESC = "App.name DESC";

	public static final String[] ORDER_BY_FIELDS = {"name"};

	public AppNameComparator() {
		this(false);
	}

	public AppNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(App entry1, App entry2) {
		String name1 = entry1.getName();
		String name2 = entry2.getName();

		int value = name1.compareTo(name2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}