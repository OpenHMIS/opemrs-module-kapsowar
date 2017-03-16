package org.openmrs.module.kapsowar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.kapsowar.api.model.KapsowarSettings;
import org.openmrs.module.openhmis.commons.api.f.Action1;

/**
 * Helper class to load and save the kapsowar module global settings.
 */
public class ModuleSettings {
	private static final String PRINT_PATIENT_DETAILS = "kapsowar.printPatientDetailsReport";
	private static final String PATIENT_DETAILS_REPORT_ID_PROPERTY = "kapsowar.patientDetailsReportId";

	public static final String DEPARTMENT_COLLECTIONS_REPORT_ID_PROPERTY = "openhmis.cashier.reports.departmentCollections";
	public static final String DEPARTMENT_REVENUE_REPORT_ID_PROPERTY = "openhmis.cashier.reports.departmentRevenue";
	public static final String SHIFT_SUMMARY_REPORT_ID_PROPERTY = "openhmis.cashier.reports.shiftSummary";
	public static final String DAILY_SHIFT_SUMMARY_REPORT_ID_PROPERTY = "openhmis.cashier.reports.dailyShiftSummary";
	public static final String PAYMENTS_BY_PAYMENT_MODE_REPORT_ID_PROPERTY =
	        "openhmis.cashier.reports.paymentsByPaymentMode";
	public static final String KAPSOWAR_CASHIER_BILL_ADJUSTEMENT_REPORT_ID_PROPERTY =
	        "kapsowar.reports.cashierBillAdjustments";
	public static final String KAPSOWAR_CASHIER_COLLECTIONS_REPORT_ID_PROPERTY = "kapsowar.reports.cashierCollections";
	private static AdministrationService administrationService;

	static {
		administrationService = Context.getAdministrationService();
	}

	protected ModuleSettings() {}

	public static KapsowarSettings loadSettings() {
		final KapsowarSettings kapsowarSettings = new KapsowarSettings();

		getBoolProperty(PRINT_PATIENT_DETAILS, Boolean.FALSE, new Action1<Boolean>() {
			@Override
			public void apply(Boolean parameter) {
				kapsowarSettings.setPrintPatientsDetails(parameter);
			}
		});

		getIntProperty(PATIENT_DETAILS_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setPatientsDetailsReportId(parameter);
			}
		});

		getIntProperty(DEPARTMENT_COLLECTIONS_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setDepartmentCollectionsReportId(parameter);
			}
		});

		getIntProperty(DEPARTMENT_REVENUE_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setDepartmentRevenueReportId(parameter);
			}
		});

		getIntProperty(SHIFT_SUMMARY_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setShiftSummaryReportId(parameter);
			}
		});

		getIntProperty(DAILY_SHIFT_SUMMARY_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setDailyShiftSummaryReportId(parameter);
			}
		});

		getIntProperty(PAYMENTS_BY_PAYMENT_MODE_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setPaymentsByPaymentModeReportId(parameter);
			}
		});

		getIntProperty(KAPSOWAR_CASHIER_BILL_ADJUSTEMENT_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setCashierBillAdjustmentsId(parameter);
			}
		});

		getIntProperty(KAPSOWAR_CASHIER_COLLECTIONS_REPORT_ID_PROPERTY, new Action1<Integer>() {
			@Override
			public void apply(Integer parameter) {
				kapsowarSettings.setCashierCollectionsId(parameter);
			}
		});

		return kapsowarSettings;
	}

	public static void saveSettings(KapsowarSettings kapsowarSettings) {
		if (kapsowarSettings == null) {
			throw new IllegalArgumentException("The settings to save must be defined.");
		}

		setIntProperty(DEPARTMENT_COLLECTIONS_REPORT_ID_PROPERTY, kapsowarSettings.getDepartmentCollectionsReportId());
		setIntProperty(DEPARTMENT_REVENUE_REPORT_ID_PROPERTY, kapsowarSettings.getDepartmentRevenueReportId());
		setIntProperty(SHIFT_SUMMARY_REPORT_ID_PROPERTY, kapsowarSettings.getShiftSummaryReportId());
		setIntProperty(DAILY_SHIFT_SUMMARY_REPORT_ID_PROPERTY, kapsowarSettings.getDailyShiftSummaryReportId());
		setIntProperty(PAYMENTS_BY_PAYMENT_MODE_REPORT_ID_PROPERTY, kapsowarSettings.getPaymentsByPaymentModeReportId());
		setIntProperty(KAPSOWAR_CASHIER_BILL_ADJUSTEMENT_REPORT_ID_PROPERTY, kapsowarSettings.getCashierBillAdjustmentsId());
		setIntProperty(KAPSOWAR_CASHIER_COLLECTIONS_REPORT_ID_PROPERTY, kapsowarSettings.getCashierCollectionsId());
	}

	private static Boolean getBoolProperty(String propertyName) {
		Boolean result = null;
		String property = administrationService.getGlobalProperty(propertyName);
		if (!StringUtils.isEmpty(property)) {
			result = Boolean.parseBoolean(property);
		}

		return result;
	}

	private static void getBoolProperty(String propertyName, Action1<Boolean> action) {
		getBoolProperty(propertyName, null, action);
	}

	private static void getBoolProperty(String propertyName, Boolean defaultValue, Action1<Boolean> action) {
		String property = administrationService.getGlobalProperty(propertyName);
		if (!StringUtils.isEmpty(property)) {
			action.apply(Boolean.parseBoolean(property));
		} else if (defaultValue != null) {
			action.apply(defaultValue);
		}
	}

	private static void setBoolProperty(String propertyName, Boolean value) {
		if (Boolean.TRUE.equals(value)) {
			administrationService.setGlobalProperty(propertyName, Boolean.TRUE.toString());
		} else {
			administrationService.setGlobalProperty(propertyName, Boolean.FALSE.toString());
		}
	}

	private static Integer getIntProperty(String propertyName) {
		Integer result = null;
		String property = administrationService.getGlobalProperty(propertyName);
		if (!StringUtils.isEmpty(property) && NumberUtils.isNumber(property)) {
			result = Integer.parseInt(property);
		}

		return result;
	}

	private static void getIntProperty(String propertyName, Action1<Integer> action) {
		getIntProperty(propertyName, null, action);
	}

	private static void getIntProperty(String propertyName, Integer defaultValue, Action1<Integer> action) {
		String property = administrationService.getGlobalProperty(propertyName);
		if (!StringUtils.isEmpty(property) && NumberUtils.isNumber(property)) {
			action.apply(Integer.parseInt(property));
		} else if (defaultValue != null) {
			action.apply(defaultValue);
		}
	}

	private static void setIntProperty(String propertyName, Integer value) {
		if (value != null) {
			administrationService.setGlobalProperty(propertyName, value.toString());
		} else {
			administrationService.setGlobalProperty(propertyName, "");
		}
	}
}
