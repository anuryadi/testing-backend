package ari.nuryadi.testingbackend.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CoreDate {
	static final long ONE_HOUR = 60 * 60 * 1000L;

	static final double AVERAGE_MILLIS_PER_MONTH = 365.24 * 24 * 60 * 60 * 1000 / 12;

	public static Date getDateInterval(String IntervalType, int IntervalValue, Date prosesDate) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(prosesDate);
		if (IntervalType.equals("1-Harian")) {
			calendar.add(Calendar.DAY_OF_WEEK, IntervalValue);
		} else if (IntervalType.equals("2-Pasaran")) {
			calendar.add(Calendar.DAY_OF_WEEK, 5 * IntervalValue);
		} else

		if (IntervalType.equals("3-Mingguan")) {
			calendar.add(Calendar.DAY_OF_WEEK, 7 * IntervalValue);
		} else if (IntervalType.equals("4-Bulanan")) {
			calendar.add(Calendar.MONTH, IntervalValue);
		} else if (IntervalType.equals("5-Tahunan")) {
			calendar.add(Calendar.YEAR, IntervalValue);
		}

		Date newdate = calendar.getTime();

		return newdate;

	}

	public static Date getLastDateOfMonth(Date prosesDate) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(prosesDate);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);

		Date newdate = calendar.getTime();
		return newdate;

	}

	public static Date getStartDateOfMonth(Date prosesDate) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(prosesDate);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		Date newdate = calendar.getTime();
		return newdate;

	}

	public static Date getServerDate() {
		Date tglServer = new Date();
		tglServer.getHours();
		tglServer.getMonth();
		tglServer.getDay();
		tglServer.getYear();

		return tglServer;
	}

	public static Date getLocalDate() {
		Date tglLocal = new Date();
		tglLocal.getHours();
		tglLocal.getMonth();
		tglLocal.getDay();
		tglLocal.getYear();

		return tglLocal;
	}

	public static String getFormat(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatHourOnly(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}
	
	public static String getFormatDayOnly(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatddMMyyyyNamingFile(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HHmm");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatddMMyyyy(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatddMMMyy(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		String newDate = dateFormat.format(prosesDate).toUpperCase();

		return newDate;

	}

	public static boolean isValidFormatddMMMyy(String prosesDate) {
		boolean check= true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		// Input to be parsed should strictly follow the defined date format above.
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(prosesDate);
			//String newDate = dateFormat.format(prosesDate).toUpperCase();

		}
		catch (Throwable e){
			check = false;
			e.printStackTrace();
		}

		return check;

	}


	
	public static String getFormatddMMyyyyCurrentDate(String DD) {
		SimpleDateFormat dateFormatPartial = new SimpleDateFormat("-MM-yyyy");
		String partialDate = dateFormatPartial.format(new Date());
		return DD + partialDate;
	}

	public static String getFormatMonthName(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatLastHour(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 24:00:00");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatLastHourddMMMyyyy(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy 24:00:00");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatHHMMSS(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

    public static String getFormatHHMMSSLog(Date prosesDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mmss");
        String newDate = dateFormat.format(prosesDate);

        return newDate;

    }


    public static String getFormatddMMyyyyhhmmss(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatddMMyyyyhhmmssOracle(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}


	public static String getFormatddMMyyyy_hhmmss(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatMMDDYY(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy hh:mm:ss");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static String getFormatDate(Date prosesDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String newDate = dateFormat.format(prosesDate);

		return newDate;

	}

	public static Date StringToDate(String prosesDate) throws Exception {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		date = (Date) formatter.parse(prosesDate);

		return date;

	}

	public static Date getStartDateOfYear(Date prosesDate) throws Exception {
		DateFormat formatter;
		Date date;

		formatter = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = formatter.format(prosesDate);

		String year = newDate.substring(0, 4);

		date = (Date) formatter.parse(year + "-01-01");

		return date;

	}

	public static Date getLastDateOfYear(Date prosesDate) throws Exception {
		DateFormat formatter;
		Date date;

		formatter = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = formatter.format(prosesDate);

		String year = newDate.substring(0, 4);

		date = (Date) formatter.parse(year + "-12-31");

		return date;

	}

	public static Integer getCheckDate(Date prosesDate) {
		return null;
		/*
		 * /// kalau mau mabil hari nya begini : /// 0=Minggu 1=Senin 2=Selsasa 3=Rabu
		 * 4=Kamis 5=Jumat 6=Sabtu Calendar calendar= GregorianCalendar.getInstance();
		 * calendar.setTime(prosesDate); if(prosesDate.getDay()==5) {
		 * calendar.add(Calendar.DAY_OF_WEEK, 3); }else if(prosesDate.getDay()==6) {
		 * calendar.add(Calendar.DAY_OF_WEEK, 2); }else if(prosesDate.getDay()==0) {
		 * calendar.add(Calendar.DAY_OF_WEEK, 1); }
		 * 
		 * Date newdate=calendar.getTime();
		 * 
		 * 
		 * //kalau mau ambil bulan begini juga mas newdate.getMonth() //kalau mau ambil
		 * tahun begini juga mas newdate.getYear() // kalau mau ambil tanggal begini
		 * juga mas newdate.getDate()
		 * 
		 * //return newdate;
		 */
	}

	public static long calculateDays(Date dateEarly, Date dateLater) {
		return (dateLater.getTime() - dateEarly.getTime()) / (24 * 60 * 60 * 1000);
	}

	/** Using Calendar - THE CORRECT WAY **/

	public static long daysBetween(Date startDate, Date endDate) {
		long result = ((endDate.getTime() - startDate.getTime() + ONE_HOUR) / (ONE_HOUR * 24));

		return result < 0 ? 0 : result;
	}

	public static int monthsBetween(Date startDate, Date endDate) {

		int result = 0;

		if (endDate.before(startDate)) {
			result = -1;
		} else {
			result = (int) ((endDate.getTime() - startDate.getTime()) / AVERAGE_MILLIS_PER_MONTH);
		}

		return result;

	}

	public static int monthsBetweenDay(Date startDate, Date endDate) {

		Date d1 = new Date();

		d1.setDate(startDate.getDate());
		d1.setMonth(startDate.getMonth());
		d1.setYear(startDate.getYear());

		int d = d1.getDate();
		int imonth = d1.getMonth();
		int m = 0;

		while (d1.before(endDate)) {

			d1.setDate(d);

			if (imonth != d1.getMonth()) {
				m++;
				imonth = d1.getMonth();
			}

			if (d1.getDate() == 1) {
				d = 1;
			}

			d++;
		}

		return m < 0 ? 0 : m;
	}

	public static int monthsBetweenDays(Date startDate, Date endDate) {

		Date d1 = new Date();
		Date d2 = new Date();

		d1.setYear(startDate.getYear());
		d1.setMonth(startDate.getMonth());
		d1.setDate(startDate.getDate());

		int d = d1.getDate() + 1;
		int m = 0;

		while (d1.before(endDate)) {

			d1.setDate(d);

			if (startDate.getDate() == d1.getDate()) {
				m++;
			} else {
				if (d1.getMonth() != d2.getMonth()) {

					m++;
				}
			}

			if (d1.getDate() == 1) {
				d = 1;
			}

			d2.setYear(d1.getYear());
			d2.setMonth(d1.getMonth());
			d2.setDate(d1.getDate());

			d++;
		}

		return m < 0 ? 0 : m;
	}

	public static Date DateNow(){
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		return date;
	}
}