package org.openmrs.module.kapsowar.page.controller.reports;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ui.framework.page.PageRequest;
import org.openmrs.ui.framework.page.PageRequestMapper;
import org.springframework.stereotype.Component;

/**
 * Overrides the cashier reports page
 */
@Component
public class KapsowarReportsPageRequestMapper implements PageRequestMapper {
	private final Log LOG = LogFactory.getLog(getClass());

	/**
	 * Implementations should call {@link PageRequest#setProviderNameOverride(String)} and
	 * {@link PageRequest#setPageNameOverride(String)}, and return true if they want to remap a request, or return false if
	 * they didn't remap it.
	 * @param pageRequest may have its providerNameOverride and pageNameOverride set
	 * @return true if this page was mapped (by overriding the provider and/or page), false otherwise
	 */
	@Override
	public boolean mapRequest(PageRequest pageRequest) {
		if (pageRequest.getProviderName().equals("openhmis.cashier")) {
			if (pageRequest.getPageName().equals("reports/reports")) {
				pageRequest.setProviderNameOverride("kapsowar");
				pageRequest.setPageNameOverride("reports/kapsowarReports");
				LOG.info(pageRequest.toString());
				return true;
			}
		}
		return false;
	}
}
