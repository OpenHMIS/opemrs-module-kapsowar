package org.openmrs.module.kapsowar.fragment.controller;

import org.apache.commons.lang.StringUtils;
import org.openmrs.module.jasperreport.ReportsControllerBase;
import org.openmrs.module.kapsowar.ModuleSettings;
import org.openmrs.module.kapsowar.api.util.KapsowarConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Controller that facilitates the printing of patient details.
 */
@Controller
@RequestMapping(value = KapsowarConstants.JASPER_REPORT_PATIENT)
public class PrintPatientDetailsController extends ReportsControllerBase {
	@Override
	public String parse(int reportId, WebRequest request, HttpServletResponse response) throws IOException {
		int personId;
		String message = null;
		String temp = request.getParameter("personId");
		if (!StringUtils.isEmpty(temp) && StringUtils.isNumeric(temp)) {
			personId = Integer.parseInt(temp);
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "The person id ('" + temp + "') must be "
			        + "defined and be numeric.");
			return null;
		}

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("personId", personId);

		reportId = ModuleSettings.loadSettings().getPatientsDetailsReportId();
		return renderReport(reportId, params, "Patient Details Report - " + temp, response);
	}
}
