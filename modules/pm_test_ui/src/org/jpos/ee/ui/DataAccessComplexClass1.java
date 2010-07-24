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
            o.setId(new Long(i));
            o.setDescription(String.format("Complex Class I %d", i));
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