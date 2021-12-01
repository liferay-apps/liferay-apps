package com.liferay.apps.web.internal.util;

import com.liferay.apps.manager.model.App;
import com.liferay.apps.manager.util.comparator.AppNameComparator;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.ResourceBundle;

@Component(service = AppUtil.class)
public class AppUtil {

    public static String getDisplayTitle(ResourceBundle resourceBundle, App app) {
        if (Validator.isNull(app.getName())) {
            return LanguageUtil.get(resourceBundle, "untitled-app");
        }
        return app.getName();
    }

    public static OrderByComparator<App> getOrderByComparator(String orderByCol, String orderByType) {
        boolean orderByAsc = true;
        if (orderByType.equals("desc")) {
            orderByAsc = false;
        }
        //todo: check orderByCol
        OrderByComparator<App> orderByComparator = new AppNameComparator(orderByAsc);
        return orderByComparator;
    }

}