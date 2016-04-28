package operations.report;

import java.util.Calendar;

import operations.Operation;

//public class ReportFactory extends Operation {
//	ReportFactory instance = null;
//
//	/**
//	 * Raport ilości założonych produktów
//	 */
//	public static final String QUANTITY_REPORT = "Quantity Report";
//
//	private ReportFactory() {
//		this.type = 10;
//		this.date = Calendar.getInstance().getTime();
//		this.description = "Raport";
//	}
//
//	public ReportFactory getInstance() {
//		if (instance == null) {
//			instance = new ReportFactory();
//		}
//		return instance;
//	}
//
//	/**
//	 * Generuje raport na podstawie podanego typu raportu i kryteriów.
//	 * 
//	 * @param reportType
//	 * @return
//	 */
//	public static Report generateReport(String reportType) { // TODO: dodać pozostałe parametry filtrujące
//		Report report = null;
//
//		switch (reportType) {
//		case QUANTITY_REPORT:
//			report = new QuantityReport();
//			break;
//
//		default:
//			break;
//		}
//
//		return report;
//	}
//
//	@Override
//	public <T> T execute() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//}
