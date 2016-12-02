package org.openmrs.module.kapsowar;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.kapsowar.api.model.KapsowarSettings;

/**
 * Helper class to load and save the kapsowar module global settings.
 */
public class ModuleSettings {
	private static final String PRINT_PATIENT_DETAILS = "kapsowar.printPatientDetailsReport";
	private static final String PATIENT_DETAILS_REPORT_ID_PROPERTY = "kapsowar.patientDetailsReportId";

	protected ModuleSettings() {}

	public static KapsowarSettings loadSettings() {
		KapsowarSettings kapsowarSettings = new KapsowarSettings();
		AdministrationService administrationService = Context.getAdministrationService();

		String property = administrationService.getGlobalProperty(PRINT_PATIENT_DETAILS);
		if (!StringUtils.isEmpty(property)) {
			kapsowarSettings.setPrintPatientsDetails(Boolean.parseBoolean(property));
		} else {
			kapsowarSettings.setPrintPatientsDetails(Boolean.FALSE);
		}

		property = administrationService.getGlobalProperty(PATIENT_DETAILS_REPORT_ID_PROPERTY);
		if (!StringUtils.isEmpty(property)) {
			kapsowarSettings.setPatientsDetailsReportId(Integer.parseInt(property));
		}

		return kapsowarSettings;
	}

	public static void saveSettings(KapsowarSettings kapsowarSettings) {
		if (kapsowarSettings == null) {
			throw new IllegalArgumentException("The settings to save must be defined.");
		}
	}
}
