/**
 * 
 */
package com.yourcompany.demo.util;

import org.dozer.DozerConverter;
import org.joda.time.DateTime;

/**
 * This class is intended to keep Dozer happy when converting Joda's DateTime classes.
 * @author wwadge
 *
 */
public class DateTimeCustomConverter extends DozerConverter<DateTime, DateTime> {

    public DateTimeCustomConverter() {
        super(DateTime.class, DateTime.class);
    }

    @Override
    public DateTime convertTo(final DateTime source, final DateTime destination) {

        if (source == null) {
            return null;
        }

        return new DateTime(source);
    }

    @Override
    public DateTime convertFrom(final DateTime source, final DateTime destination) {
    	return convertTo(source, destination);
    }
}
