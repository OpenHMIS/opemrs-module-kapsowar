package org.openmrs.module.kapsowar.api.model;

/**
 * The allowable settings for the kapsowar module.
 */
public class KapsowarSettings {
	public static final long serialVersionUID = 1L;

	private Integer patientsDetailsReportId;
	private Boolean printPatientsDetails;

	private Integer departmentCollectionsReportId;
	private Integer departmentRevenueReportId;
	private Integer shiftSummaryReportId;
	private Integer dailyShiftSummaryReportId;
	private Integer paymentsByPaymentModeReportId;
	private Integer defaultShiftReportId;
	private Integer cashierCollectionsId;
	private Integer cashierBillAdjustmentsId;

	public Integer getCashierCollectionsId() {
		return cashierCollectionsId;
	}

	public void setCashierCollectionsId(Integer cashierCollectionsId) {
		this.cashierCollectionsId = cashierCollectionsId;
	}

	public Integer getCashierBillAdjustmentsId() {
		return cashierBillAdjustmentsId;
	}

	public void setCashierBillAdjustmentsId(Integer cashierBillAdjustmentsId) {
		this.cashierBillAdjustmentsId = cashierBillAdjustmentsId;
	}

	public Integer getDefaultShiftReportId() {
		return defaultShiftReportId;
	}

	public void setDefaultShiftReportId(Integer defaultShiftReportId) {
		this.defaultShiftReportId = defaultShiftReportId;
	}

	public Integer getDepartmentCollectionsReportId() {
		return departmentCollectionsReportId;
	}

	public void setDepartmentCollectionsReportId(Integer departmentCollectionsReportId) {
		this.departmentCollectionsReportId = departmentCollectionsReportId;
	}

	public Integer getDepartmentRevenueReportId() {
		return departmentRevenueReportId;
	}

	public void setDepartmentRevenueReportId(Integer departmentRevenueReportId) {
		this.departmentRevenueReportId = departmentRevenueReportId;
	}

	public Integer getShiftSummaryReportId() {
		return shiftSummaryReportId;
	}

	public void setShiftSummaryReportId(Integer shiftSummaryReportId) {
		this.shiftSummaryReportId = shiftSummaryReportId;
	}

	public Integer getDailyShiftSummaryReportId() {
		return dailyShiftSummaryReportId;
	}

	public void setDailyShiftSummaryReportId(Integer dailyShiftSummaryReportId) {
		this.dailyShiftSummaryReportId = dailyShiftSummaryReportId;
	}

	public Integer getPaymentsByPaymentModeReportId() {
		return paymentsByPaymentModeReportId;
	}

	public void setPaymentsByPaymentModeReportId(Integer paymentsByPaymentModeReportId) {
		this.paymentsByPaymentModeReportId = paymentsByPaymentModeReportId;
	}

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
