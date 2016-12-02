package org.openmrs.module.kapsowar.api.model;

/**
 * The allowable settings for the kapsowar module.
 */
public class KapsowarSettings {
	public static final long serialVersionUID = 1L;

	private Integer patientsDetailsReportId;
	private Boolean printPatientsDetails;

	public Integer getPatientsDetailsReportId() {
		return patientsDetailsReportId;
	}

	public void setPatientsDetailsReportId(Integer patientsDetailsReportId) {
		this.patientsDetailsReportId = patientsDetailsReportId;
	}

	public Boolean getPrintPatientsDetails() {
		return printPatientsDetails;
	}

	public void setPrintPatientsDetails(Boolean printPatientsDetails) {
		this.printPatientsDetails = printPatientsDetails;
	}
}
