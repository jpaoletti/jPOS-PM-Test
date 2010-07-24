/*
 * jPOS Project [http://jpos.org]
 * Copyright (C) 2000-2010 Alejandro P. Revilla
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpos.ee.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jpos.ee.Constants;
import org.jpos.ee.pm.core.DataAccess;
import org.jpos.ee.pm.core.EntityFilter;
import org.jpos.ee.pm.core.PMContext;
import org.jpos.ee.pm.core.PMException;

/**
 *
 * @author jpaoletti
 */
public abstract class DataAccessTest implements DataAccess, Constants {

    protected List<Object> list;

    protected abstract void fill();

    protected int random(int from, int to) {
        return from + (int) (Math.random() * (to - from) + 0.5);
    }

    public Object getItem(PMContext ctx, String property, String value) throws PMException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<?> list(PMContext ctx, EntityFilter filter, Integer from, Integer count) throws PMException {
        if (list == null) {
            fill();
        }
        List result = new ArrayList(list);
        Collections.sort(result, new TestComparator(ctx.getString(PM_LIST_ORDER), (Boolean)ctx.get(PM_LIST_ASC)));
        int f = (from == null) ? 0 : from;
        int c = (int) ((count == null) ? count(ctx) : count);
        System.out.println(String.format("count: %d ; c: %d, f: %d", count(ctx), c, f));
        if (count(ctx) < c) {
            return result;
        }
        if (count(ctx) < f) {
            return null;
        }
        int fpc = f + c;
        final List subList = result.subList(f, (int) ((fpc > count(ctx)) ? count(ctx) : fpc));
        return subList;
    }

    public Long count(PMContext ctx) throws PMException {
        return new Long(list.size());
    }

    public void delete(PMContext ctx, Object object) throws PMException {
        list.remove(object);
    }

    public void update(PMContext ctx, Object instance) throws PMException {
    }

    public void add(PMContext ctx, Object instance) throws PMException {
        list.add(instance);
    }

    public Object refresh(PMContext ctx, Object o) throws PMException {
        return o;
    }

    public EntityFilter createFilter(PMContext ctx) throws PMException {
        return null;
    }
}
