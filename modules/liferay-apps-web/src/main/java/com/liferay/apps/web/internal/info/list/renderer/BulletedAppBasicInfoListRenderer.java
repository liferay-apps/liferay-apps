package com.liferay.apps.web.internal.info.list.renderer;

import com.liferay.apps.manager.model.App;
import com.liferay.info.list.renderer.InfoListRenderer;
import com.liferay.info.taglib.list.renderer.BulletedBasicInfoListRenderer;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = InfoListRenderer.class)
public class BulletedAppBasicInfoListRenderer extends BaseAppBasicInfoListRenderer
	implements BulletedBasicInfoListRenderer<App> {
}