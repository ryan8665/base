package com.nsoft.enums;

public enum DayOfWeek {

    SATURDAY(1,"شنبه","Saturday"),
    SUNDAY(2,"یکشنبه","Sunday"),
    MONDAY(3,"دوشنبه","Monday"),
    TUESDAY(4,"سه شنبه","Tuesday"),
    WEDNESDAY(5,"چهار شنبه","Wednesday"),
    THURSDAY(6,"پنج شنبه","Thursday"),
    FRIDAY(7,"جمعه","Friday");

    private Integer order;
    private String firstLangTitle;
    private String secondLangTitle;

    private DayOfWeek(Integer order,String firstLangTitle,String secondLangTitle) {
        this.order = order;
        this.firstLangTitle = firstLangTitle;
        this.secondLangTitle = secondLangTitle;
    }

    public Integer getOrder() {
        return order;
    }

    public String getFirstLangTitle() {
        return firstLangTitle;
    }

    public String getSecondLangTitle() {
        return secondLangTitle;
    }

    public static DayOfWeek getDayOfWeekFromOrder(Integer order) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getOrder().equals(order)) {
                return dayOfWeek;
            }
        }
        return null;
    }

    public static DayOfWeek getDayOfWeekFromTitle(String title) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getFirstLangTitle().equals(title) ||
                    dayOfWeek.getSecondLangTitle().equals(title)) {
                return dayOfWeek;
            }
        }
        return null;
    }

}