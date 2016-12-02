package org.openmrs.module.kapsowar.page.controller.kapsowar;

import org.openmrs.annotation.OpenmrsProfile;
import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.Extension;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.kapsowar.api.util.KapsowarConstants;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.page.PageModel;
import org.openmrs.ui.framework.page.PageRequest;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Controller for the kapsowar management landing page.
 */
@Controller
@OpenmrsProfile(modules = { "uiframework:*.*" })
public class KapsowarManageModulePageController {
	/**
	 * Process requests to show the home page
	 * @param model
	 * @param appFrameworkService
	 * @param request
	 * @param ui
	 * @throws IOException
	 */
	public void get(PageModel model, PageRequest request, UiUtils ui) throws IOException {
		AppFrameworkService appFrameworkService = Context.getService(AppFrameworkService.class);
		List<Extension> extensions = appFrameworkService.getExtensionsForCurrentUser(
		        KapsowarConstants.MANAGE_MODULE_PAGE_EXTENSION_POINT_ID);
		model.addAttribute("extensions", extensions);
	}
}
