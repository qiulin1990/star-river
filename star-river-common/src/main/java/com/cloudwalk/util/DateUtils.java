package com.cloudwalk.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
@Slf4j
public class DateUtils {


    public static String ymdhms = "yyyy-MM-dd HH:mm:ss";

    private static String ymdh = "yyyy-MM-dd HH";

    private static String ymdhs = "yyyy-MM-dd HH:mm";

    private static String ymdhms2 = "yyyyMMddHHmmss";

    private static String ymd = "yyyy-MM-dd";

    public static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);

    private static String year = "yyyy";

    private static String month = "MM";

    private static String day = "dd";

    private static String hour = "HH";

    private static String minute = "mm";

    private static String second = "ss";

    public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(ymdhms);

    public static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(ymdhs);

    public static SimpleDateFormat yyyyMMddHH = new SimpleDateFormat(ymdh);

    public static SimpleDateFormat yyyyMMddHHmmss2 = new SimpleDateFormat(
            ymdhms2);

    public static SimpleDateFormat yearSDF = new SimpleDateFormat(year);

    public static SimpleDateFormat monthSDF = new SimpleDateFormat(month);

    public static SimpleDateFormat daySDF = new SimpleDateFormat(day);

    public static SimpleDateFormat hourSDF = new SimpleDateFormat(hour);

    public static SimpleDateFormat minuteSDF = new SimpleDateFormat(minute);

    public static SimpleDateFormat secondSDF = new SimpleDateFormat(second);

    public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat yyyyMMddHH_NOT_ = new SimpleDateFormat(
            "yyyyMMdd");

    public static long DATEMM = 86400L;

    /**
     * 获得当前时间 格式：20151214171555
     *
     * @return String
     */
    public static String getCurrentTime2() {
        return yyyyMMddHHmmss2.format(new Date());
    }

    /**
     * 获得当前时间 格式：2014-12-02 10:38:53
     *
     * @return String
     */
    public static String getCurrentTime() {
        return yyyyMMddHHmmss.format(new Date());
    }

    /**
     * 可以获取昨天的日期 格式：2014-12-01
     *
     * @return String
     */
    public static String getYesterdayYYYYMMDD() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        String str = yyyyMMdd.format(date);
        try {
            date = yyyyMMddHHmmss.parse(str + " 00:00:00");
            return yyyyMMdd.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 可以获取后退N天的日期 格式：传入2 得到2014-11-30
     *
     * @param backDay
     * @return String
     */
    public String getStrDate(String backDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt("-" + backDay));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    /**
     * 可以获取后退N天的日期 格式：传入2 得到 前两天 日期格式：2014-11-30 00:00:00
     */
    public static String getStrDateByN1(String backDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt("-" + backDay));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    /**
     * 可以获取后退N天的日期 格式：传入2 得到2014-11-30
     *
     * @param backDay
     * @return String
     */
    public static String getStrDateByN(String backDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt("-" + backDay));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    /**
     * 可以获取后退N小时的日期
     *
     * @param backHour
     * @return String
     */
    public static String getLastNHour(int backHour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, Integer.parseInt("-" + backHour));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    /**
     * 获取当前的年、月、日
     *
     * @return String
     */
    public static String getCurrentYear() {
        return yearSDF.format(new Date());
    }

    public static String getCurrentMonth() {
        return monthSDF.format(new Date());
    }

    public static String getCurrentDay() {
        return daySDF.format(new Date());
    }

    /**
     * 获取当前的时、分、秒
     *
     * @return
     */
    public static String getCurrentHour() {
        return hourSDF.format(new Date());
    }

    public static String getCurrentMinute() {
        return minuteSDF.format(new Date());
    }

    public static String getCurrentSecond() {
        return secondSDF.format(new Date());
    }

    /**
     * 获取年月日 也就是当前时间 格式：2014-12-02
     *
     * @return String
     */
    public static String getCurrentymd() {
        return ymdSDF.format(new Date());
    }

    /**
     * 获取今天0点开始的秒数
     *
     * @return long
     */
    public static long getTimeNumberToday() {
        Date date = new Date();
        String str = yyyyMMdd.format(date);
        try {
            date = yyyyMMdd.parse(str);
            return date.getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 获取今天的日期 格式：20141202
     *
     * @return String
     */
    public static String getTodayString() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String str = format.format(date);
        return str;
    }

    /**
     * 获取昨天的日期 格式：20141201
     *
     * @return String
     */
    public static String getYesterdayString() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        String str = yyyyMMddHH_NOT_.format(date);
        return str;
    }

    /**
     * 获得昨天零点
     *
     * @return Date
     */
    public static Date getYesterDayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR, 0);
        return cal.getTime();
    }

    /**
     * 把long型日期转String ；---OK
     *
     * @param date   毫秒数；
     * @param format 日期格式；
     * @return
     */
    public static String longToString(Long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt2 = new Date(date);
        String sDateTime = sdf.format(dt2); // 得到精确到秒的表示：08/31/2006 21:08:00
        return sDateTime;
    }

    /**
     * 获得今天零点
     *
     * @return Date
     */
    public static Date getTodayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR, 0);
        return cal.getTime();
    }

    /**
     * 获得昨天23时59分59秒
     *
     * @return
     */
    public static Date getYesterDay24Hour() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.HOUR, 23);
        return cal.getTime();
    }

    /**
     * String To Date ---OK
     *
     * @param date   待转换的字符串型日期；
     * @param format 转化的日期格式
     * @return 返回该字符串的日期型数据；
     */
    public static Date stringToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获得指定日期所在的自然周的第一天，即周日
     *
     * @param date 日期
     * @return 自然周的第一天
     */
    public static Date getStartDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期所在的自然周的最后一天，即周六
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, 7);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期所在当月第一天
     *
     * @param date
     * @return
     */
    public static Date getStartDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期所在当月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期的下一个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getStartDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 获得指定日期的下一个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.DATE, -1);
        date = c.getTime();
        return date;
    }

    /**
     * 求某一个时间向前多少秒的时间(currentTimeToBefer)---OK
     *
     * @param givedTime        给定的时间
     * @param interval         间隔时间的毫秒数；计算方式 ：n(天)*24(小时)*60(分钟)*60(秒)(类型)
     * @param format_Date_Sign 输出日期的格式；如yyyy-MM-dd、yyyyMMdd等；
     */
    public static String givedTimeToBefer(String givedTime, long interval,
                                          String format_Date_Sign) {
        String tomorrow = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format_Date_Sign);
            Date gDate = sdf.parse(givedTime);
            long current = gDate.getTime(); // 将Calendar表示的时间转换成毫秒
            long beforeOrAfter = current - interval * 1000L; // 将Calendar表示的时间转换成毫秒
            Date date = new Date(beforeOrAfter); // 用timeTwo作参数构造date2
            tomorrow = new SimpleDateFormat(format_Date_Sign).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tomorrow;
    }

    /**
     * 把String 日期转换成long型日期；---OK
     *
     * @param date   String 型日期；
     * @param format 日期格式；
     * @return
     */
    public static long stringToLong(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt2 = null;
        long lTime = 0;
        try {
            dt2 = sdf.parse(date);
            // 继续转换得到秒数的long型
            lTime = dt2.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lTime;
    }

    /**
     * 得到二个日期间的间隔日期；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     */
    public static Map<String, String> getTwoDay(String endTime,
                                                String beginTime, boolean isEndTime) {
        Map<String, String> result = new HashMap<String, String>();
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
                .equals(""))))
            return null;
        try {
            Date date = ymdSDF.parse(endTime);
            endTime = ymdSDF.format(date);
            Date mydate = ymdSDF.parse(beginTime);
            long day = (date.getTime() - mydate.getTime())
                    / (24 * 60 * 60 * 1000);
            result = getDate(endTime, Integer.parseInt(day + ""), isEndTime);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 得到二个日期间的间隔日期（单位是天）；
     *
     * @param endTime   结束时间	yyyy-MM-dd
     * @param beginTime 开始时间	yyyy-MM-dd
     * @param isEndTime 是否包含结束日期；
     * @return
     */
    public static Integer getTwoDayInterval(String endTime, String beginTime,
                                            boolean isEndTime) {
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
                .equals(""))))
            return 0;
        long day = 0l;
        try {
            Date date = ymdSDF.parse(endTime);
            endTime = ymdSDF.format(date);
            Date mydate = ymdSDF.parse(beginTime);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return 0;
        }
        return Integer.parseInt(day + "");
    }

    /**
     * 得到二个日期间的间隔日期的秒数(单位是秒)；
     *
     * @param endTime   结束时间
     * @param beginTime 开始时间
     * @param isEndTime 是否包含结束日期；
     * @return
     */
    public static Integer getTwoDayIntervalS(String endTime, String beginTime,
                                             boolean isEndTime) {
        if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
                .equals(""))))
            return 0;
        long s = 0l;
        try {
            Date date = yyyyMMddHHmmss.parse(endTime);
            endTime = yyyyMMddHHmmss.format(date);
            Date mydate = yyyyMMddHHmmss.parse(beginTime);
            s = (date.getTime() - mydate.getTime()) / 1000;
        } catch (Exception e) {
            return 0;
        }
        return Integer.parseInt(s + "");
    }

    /**
     * 根据结束时间以及间隔差值，求符合要求的日期集合；
     *
     * @param endTime
     * @param interval
     * @param isEndTime
     * @return
     */
    public static Map<String, String> getDate(String endTime, Integer interval,
                                              boolean isEndTime) {
        Map<String, String> result = new HashMap<String, String>();
        if (interval == 0 || isEndTime) {
            if (isEndTime)
                result.put(endTime, endTime);
        }
        if (interval > 0) {
            int begin = 0;
            for (int i = begin; i < interval; i++) {
                endTime = givedTimeToBefer(endTime, DATEMM, ymd);
                result.put(endTime, endTime);
            }
        }
        return result;
    }


    /**
     * 判断一个时间是否在另一个时间之前
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     * @author bianfulin
     */
    public static boolean before(String time1, String time2) {
        try {
            Date dateTime1 = yyyyMMddHHmmss.parse(time1);
            Date dateTime2 = yyyyMMddHHmmss.parse(time2);

            if (dateTime1.before(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之后
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean after(String time1, String time2) {
        try {
            Date dateTime1 = yyyyMMddHHmmss.parse(time1);
            Date dateTime2 = yyyyMMddHHmmss.parse(time2);

            if (dateTime1.after(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 计算时间差值（单位为秒）
     *
     * @param time1 时间1
     * @param time2 时间2
     * @return 差值
     */
    public static int minus(String time1, String time2) {
        try {
            Date datetime1 = yyyyMMddHHmmss.parse(time1);
            Date datetime2 = yyyyMMddHHmmss.parse(time2);

            long millisecond = datetime1.getTime() - datetime2.getTime();

            return Integer.valueOf(String.valueOf(millisecond / 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 可以获取后退N天的日期 格式：传入2 得到 前两天 日期格式：2014-11-30 00:00:00
     */
    /**
     * 可获得前进或后退N天的日期时间，日期格式:yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp 日期时间
     * @param backDay   n天，正为前进，负为后退
     * @return
     */
    public static String getStrDateByN1(String timestamp, Integer backDay) {
        try {
            Date date = yyyyMMddHHmmss.parse(timestamp);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, backDay);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String back = sdf.format(calendar.getTime());
            return back;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回指定时间段的特定日期List.比如所有周一(周二、周三....)
     *
     * @param fromYmd 起始日期
     * @param toYmd   中止日期
     * @param type    日期类型:1 周日 2 周一 3 周二  4 周三 5 周四 6 周五 7 周六
     * @param flag    是否包括起始日前面的最近一个指定特殊日期 0:不包括 1:包括
     * @return 日期集合
     */
    public static List<String> getSpecificDayList(String fromYmd, String toYmd,
                                                  int type, int flag) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<String> resultList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Integer.parseInt(fromYmd.substring(0, 4)), Integer.parseInt(fromYmd.substring(4, 6)) - 1, Integer.parseInt(fromYmd.substring(6)));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Integer.parseInt(toYmd.substring(0, 4)), Integer.parseInt(toYmd.substring(4, 6)) - 1, Integer.parseInt(toYmd.substring(6)));

        if ((flag == 1) && (calendar1.get(Calendar.DAY_OF_WEEK) != type)) {
            while (calendar1.get(Calendar.DAY_OF_WEEK) != type) {
                calendar1.add(Calendar.DATE, -1);
            }

            resultList.add(sdf.format(calendar1.getTime()));
            calendar1.add(Calendar.DATE, 1);
        }

        while (!calendar1.after(calendar2)) {
            if (calendar1.get(Calendar.DAY_OF_WEEK) == type) {
                resultList.add(sdf.format(calendar1.getTime()));
            }

            calendar1.add(Calendar.DATE, 1);
        }

        return resultList;
    }

    /**
     * 判断是否是节假日
     *
     * @param date，格式：2018-4-20 22:22:22
     * @return
     */
    public static boolean isHoliday(String date) {
//        SimpleDateFormat sdw = new SimpleDateFormat("E"); 
        if (date == null) return false;
        Date d = null;
        try {
            d = yyyyMMddHHmmss.parse(date);
        } catch (ParseException e) {
            return false;
        }
//        String weedDay = sdw.format(d);
//        logger.error("weedDay="+weedDay);
//        logger.error("星期六");
//        if("星期六".equals(weedDay)||"星期日".equals(weedDay)){
//        	return true;
//        }
//        return false;  
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }
        return false;
    }

    /**
     * 获取小时数
     *
     * @param time ，格式：2018-4-22 22:22:22
     * @return
     */
    public static int getHour(String time) {
        try {
            int hour = yyyyMMddHHmmss.parse(time).getHours();
            return hour;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取当前月份前n个月的list
     *
     * @param nMonth
     * @param pattern 展示格式,例如yyyy-MM
     * @return
     */
    public static List<String> getMonthListBeforeCurrMonth(Integer nMonth, String pattern) {
        List<String> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        for (int i = 1; i <= nMonth; i++) {
            calendar.add(Calendar.MONTH, -1);
            dateList.add(sdf.format(calendar.getTime()));
        }
        return dateList;
    }

    /**
     * 判断time是否在距今n个月内
     *
     * @param time   时间，格式：yyyy-MM-dd HH:mm:ss或yyyy-MM-dd
     * @param nMonth 几个月内
     * @return
     */
    public static boolean withinMonth(String time, Integer nMonth) {
        if (StringUtil.isBlankStr(time)) return false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -nMonth);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long nMonthBefore = calendar.getTimeInMillis();
        SimpleDateFormat sdf = null;
        if (time.length() == 19 && time.contains(":")) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = sdf.parse(time);
                calendar.setTime(date);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                long timeLong = calendar.getTimeInMillis();
                if (timeLong > nMonthBefore) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (time.length() == 7 && time.contains("-") && !time.contains(":")) {
            sdf = new SimpleDateFormat("yyyy-MM");
            try {
                Date date = sdf.parse(time);
                calendar.setTime(date);
                calendar.set(Calendar.DATE, 01);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                long timeLong = calendar.getTimeInMillis();
                if (timeLong > nMonthBefore) {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            try {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                time = time.replace("年", "-").replace("月", "-");
                Date date = sdf.parse(time);
                calendar.setTime(date);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                long timeLong = calendar.getTimeInMillis();
                if (timeLong > nMonthBefore) {
                    return true;
                }
            } catch (ParseException e) {
                log.error("time pattern is wrong ===>" + time);
            }
        }
        return false;
    }

    /**
     * 返回在当前时间n天之前的日期
     * i为正数 向后推迟i天，负数时向前提前i天
     *
     * @param i
     * @return
     */
    public Date getdate(int i) {
        Date dat = null;
        Calendar cd = Calendar.getInstance();
        cd.add(Calendar.DATE, i);
        dat = cd.getTime();
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp date = Timestamp.valueOf(dformat.format(dat));
        return date;
    }

    /**
     * 日期字符串根据老格式转为新格式
     *
     * @param dateStr
     * @param oldPattern
     * @param newPattern
     * @return
     */
    public static String changeDateFormat(String dateStr, String oldPattern, String newPattern) {
        if (dateStr == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(oldPattern);
        try {
            Date date = sdf.parse(dateStr);
            sdf = new SimpleDateFormat(newPattern);
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        Date jointime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
//	public static void main(String[] args) {
////		List<String> monthListBeforeCurrMonth = DateUtils.getMonthListBeforeCurrMonth(3, "yyyy-MM");
////		System.out.println(monthListBeforeCurrMonth);
////		System.out.println("2018-02-07 19:18:09".length());
////		System.out.println("yyyy-MM-dd HH:mm:ss".length());
////		System.out.println("yyyy-MM-dd".length());
//		
//		String time =  "";
////		String time =  "2018-02-17";
////		System.out.println(DateUtils.isHoliday(time));
//		System.out.println(DateUtils.withinMonth(time, 1));
//	}
}
