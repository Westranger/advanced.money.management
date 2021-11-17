package de.westranger.advanced.money.management.core.booking.util;

import java.util.HashSet;
import java.util.Set;

public final class DateExclusionImpl extends DateExclusion {
    private final Set<Long> excludesDates;

    public DateExclusionImpl() {
        this.excludesDates = new HashSet<>();
    }

    public boolean addDateToExclude(final long date) {
        return this.excludesDates.add(date);
    }

    @Override
    public boolean isExcluded(final long date) {
        return this.excludesDates.contains(date);
    }
}
