package org.jpos.ee.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import org.jpos.ee.model.ComplexClass1;

/**
 *
 * @author jpaoletti
 */
public class DataAccessComplexClass1 extends DataAccessTest{

@Override
    protected void fill() {
        list = new ArrayList<Object>();
        int top = random(5, 30);
        for(int i=0 ; i < top; i++){
            ComplexClass1 o = new ComplexClass1();
            o.setId(i);
            o.setDescription(String.format("Description cc %d", i));
            o.setActive((i % 2==0)?Boolean.TRUE:Boolean.FALSE);
            o.setAmount(new BigDecimal(Math.random()));
            o.setDate(new Date());
            o.setDatetime(new Date());
            o.setKey("pm.test.key."+i);
            o.setPassword("password");
            o.setSize(new Long(i*2000));
            list.add(o);
        }
    }
}