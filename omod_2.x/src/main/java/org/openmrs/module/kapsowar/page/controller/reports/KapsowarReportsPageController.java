/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and
 * limitations under the License.
 *
 * Copyright (C) OpenHMIS.  All Rights Reserved.
 */
package org.openmrs.module.kapsowar.page.controller.reports;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.annotation.OpenmrsProfile;
import org.openmrs.api.context.Context;
import org.openmrs.module.jasperreport.JasperReport;
import org.openmrs.module.jasperreport.JasperReportService;
import org.openmrs.module.kapsowar.ModuleSettings;
import org.openmrs.module.kapsowar.api.model.KapsowarSettings;
import org.openmrs.module.kapsowar.api.util.KapsowarConstants;
import org.openmrs.module.openhmis.commons.api.exception.ReportNotFoundException;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the kapsowar reports page
 */
@Controller
@OpenmrsProfile(modules = { "uiframework:*.*" })
public class KapsowarReportsPageController {
	private static final Log LOG = LogFactory.getLog(KapsowarReportsPageController.class);

	private JasperReportService reportService;
	private List<JasperReport> reports;

	public void get(PageModel model) throws IOException {
		reportService = Context.getService(JasperReportService.class);
		reports = new ArrayList<JasperReport>();

		KapsowarSettings kapsowarSettings = ModuleSettings.loadSettings();

		// Add reports to page model
		addReportAttribute(model, kapsowarSettings.getDepartmentCollectionsReportId(), "departmentCollectionsReport");
		addReportAttribute(model, kapsowarSettings.getDepartmentRevenueReportId(), "departmentRevenueReport");
		addReportAttribute(model, kapsowarSettings.getShiftSummaryReportId(), "shiftSummaryReport");
		addReportAttribute(model, kapsowarSettings.getDailyShiftSummaryReportId(), "dailyShiftSummaryReport");
		addReportAttribute(model, kapsowarSettings.getPaymentsByPaymentModeReportId(), "paymentsByPaymentModeReport");
		addReportAttribute(model, kapsowarSettings.getCashierBillAdjustmentsId(), "cashierBillAdjustmentsReport");
		addReportAttribute(model, kapsowarSettings.getCashierCollectionsId(), "cashierCollectionsReport");
		addReportAttribute(model, kapsowarSettings.getPatientDebtsId(), "patientDebts");

		model.addAttribute("reports", reports);
		model.addAttribute("reportUrl", KapsowarConstants.JASPER_REPORT_PAGE);
	}

	private void addReportAttribute(PageModel model, Integer reportId, String reportName) {
		if (reportId != null) {
			try {
				JasperReport report = reportService.getJasperReport(reportId);

				model.addAttribute(reportName, report);
				reports.add(report);
			} catch (NullPointerException e) {
				LOG.error("The jasper report with ID '" + reportId + "' could not be found", e);
				throw new ReportNotFoundException(
				        "The report could not be found. Check configuration under Inventory kapsowarSettings");
			}
		}
	}
}
