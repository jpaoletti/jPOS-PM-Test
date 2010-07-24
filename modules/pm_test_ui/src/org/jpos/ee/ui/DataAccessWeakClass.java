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
import java.util.List;
import org.jpos.ee.model.ParentClass;
import org.jpos.ee.model.WeakClass;
import org.jpos.ee.pm.core.EntityFilter;
import org.jpos.ee.pm.core.PMContext;
import org.jpos.ee.pm.core.PMException;

/**
 *
 * @author jpaoletti
 */
public class DataAccessWeakClass extends DataAccessTest{

    @Override
    protected void fill() {
        
    }

    @Override
    public List<?> list(PMContext ctx, EntityFilter filter, Integer from, Integer count) throws PMException {
        ParentClass pc = getParent(ctx);
        List<?> weaklist = pc.getWeaks();
        int f = (from == null)?0:from;
        int c = (int) ((count == null) ? count(ctx) : count);
        System.out.println(String.format("count: %d ; c: %d, f: %d", count(ctx), c, f ));
        if(count(ctx) < c)  return weaklist;
        if(count(ctx) < f)  return null;
        int fpc = f + c;
        return weaklist.subList(f, (int) ((fpc > count(ctx)) ? count(ctx) : fpc));
    }

    @Override
    public Long count(PMContext ctx) throws PMException {
        ParentClass pc = getParent(ctx);
        return new Long(pc.getWeaks().size());
    }



    @Override
    public void add(PMContext ctx, Object instance) throws PMException {
        ParentClass pc = getParent(ctx);
        pc.getWeaks().add((WeakClass) instance);
    }

    @Override
    public void delete(PMContext ctx, Object object) throws PMException {
        ParentClass pc = getParent(ctx);
        pc.getWeaks().remove(object);
    }

    protected ParentClass getParent(PMContext ctx) throws PMException {
        ParentClass pc = (ParentClass) ctx.getEntityContainer().getOwner().getSelected().getInstance();
        return pc;
    }

}
