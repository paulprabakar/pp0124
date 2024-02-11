package com.backend.pp0124.utils;

import com.backend.pp0124.entity.ToolType;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateOperations {

    private final short independenceDayMonth = 7;
    private final short independenceDayDate = 4;
    private final short laborDayMonth = 9;
    private final short iterationDaysCount = 1;
    private final short numberOfDaysInAWeek = 7;

    public short countNumberOfChargeableDays(LocalDate fromDate, LocalDate toDate, ToolType toolType) {
        short weekDaysCount = 0;
        LocalDate processDate = fromDate;

        while (!processDate.isAfter(toDate)) {
            if (isWeekdayChargeable(processDate, toolType) || isWeekendChargeable(processDate, toolType)) {
                weekDaysCount++;
            }
            processDate = processDate.plusDays(iterationDaysCount);
        }
        return weekDaysCount;
    }

    private boolean isWeekdayChargeable(LocalDate localDate, ToolType toolType) {
        return !isWeekEnd(localDate) && (toolType.isWeekdayCharge() || (toolType.isHolidayCharge() && !isHoliday(localDate)));
    }

    private boolean isWeekendChargeable(LocalDate localDate, ToolType toolType) {
        return isWeekEnd(localDate) && (toolType.isWeekendCharge() || (toolType.isHolidayCharge() && !isHoliday(localDate)));
    }

    private boolean isWeekEnd(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isHoliday(LocalDate localDate) {
        return (localDate.getMonthValue() == independenceDayMonth && localDate.getDayOfMonth() == independenceDayDate) ||
                (localDate.getMonthValue() == laborDayMonth && localDate.getDayOfWeek() == DayOfWeek.MONDAY &&
                        localDate.getDayOfMonth() <= numberOfDaysInAWeek);
    }
}
