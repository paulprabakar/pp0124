package com.backend.pp0124.utils;

import com.backend.pp0124.entity.ToolType;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class DateOperations {
    final short independenceDayMonth = 7;
    final short independenceDayDate = 4;
    final short laborDayMonth = 9;
    final short iterationDaysCount = 1;

    final short numberOfDaysInAWeek = 7;


    public short countNumberOfChargeableDays(LocalDate fromDate, LocalDate toDate, ToolType toolType) {
        short weekDaysCount = 0;
        LocalDate processDate = fromDate;

        do {
            //Holiday
                if (isHoliday(processDate)) {
                    if (toolType.isHolidayCharge() && !isWeekEnd(processDate)) {
                        weekDaysCount++;
                        processDate = processDate.plusDays(iterationDaysCount);
                        continue;
                    }
                    else {
                        // Independence Day Weekend Scenario
                        if (processDate.getMonthValue() == independenceDayMonth
                                && processDate.getDayOfMonth() == independenceDayDate)
                        {
                            if ((processDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) && processDate.isAfter(fromDate))
                                    || (processDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) && processDate.isBefore(toDate))) {
                                if (!toolType.isHolidayCharge()) {
                                    processDate = processDate.plusDays(iterationDaysCount);
                                    continue;
                                }
                            }

                        }
                    }
                }

            //Weekday
            if (toolType.isWeekdayCharge() && !isWeekEnd(processDate)) {
                if (isHoliday(processDate) && !toolType.isHolidayCharge()) {
                    processDate = processDate.plusDays(1);
                    continue;
                }
                weekDaysCount++;
                processDate = processDate.plusDays(1);
                continue;
            }
            //weekend
            if (toolType.isWeekendCharge() && isWeekEnd(processDate)) {
                if (isHoliday(processDate) && toolType.isHolidayCharge()) {
                    processDate = processDate.plusDays(1);
                    continue;
                }
                weekDaysCount++;
                processDate = processDate.plusDays(1);
                continue;
            }
            processDate = processDate.plusDays(1);
        } while (processDate.isBefore(toDate));
         return weekDaysCount;
    }

    private boolean isWeekEnd(LocalDate localDate) {
        if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
            return true;
        else
            return false;
    }

    private boolean isHoliday(LocalDate localDate) {
        if ((localDate.getMonthValue() == independenceDayMonth
                && localDate.getDayOfMonth() == independenceDayDate) ||
                (localDate.getMonthValue() == laborDayMonth
                        && localDate.getDayOfWeek().equals(DayOfWeek.MONDAY)
                        && localDate.getDayOfMonth() <= numberOfDaysInAWeek)) {
                return true;
        } else {
            return false;
        }
    }
}
