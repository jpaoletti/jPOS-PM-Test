package org.jpos.ee.ui;

import java.util.List;
import org.jpos.ee.pm.core.DataAccess;
import org.jpos.ee.pm.core.EntityFilter;
import org.jpos.ee.pm.core.PMContext;
import org.jpos.ee.pm.core.PMException;

/**
 *
 * @author jpaoletti
 */
public abstract class DataAccessTest implements DataAccess{
    protected List<Object> list;

    protected abstract void fill();

    protected int random(int from, int to){
        return from + (int) ( Math.random()*(to - from) + 0.5 );
    }

    public Object getItem(PMContext ctx, String property, String value) throws PMException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<?> list(PMContext ctx, EntityFilter filter, Integer from, Integer count) throws PMException {
        if(list == null) fill();
        if(count(ctx) < count) return list;
        if(count(ctx) < from)  return null;
        if(from > count)       return null;
        int fpc = from + count;
        return list.subList(from, (int) ((fpc > count(ctx)) ? count(ctx) : fpc));
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