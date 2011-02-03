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
import org.jpos.ee.model.ComplexClass2;
import org.jpos.ee.model.SimpleClass;
import org.jpos.ee.pm.core.PMContext;
import org.jpos.ee.pm.core.PMException;
import org.jpos.ee.pm.core.PresentationManager;

/**
 *
 * @author jpaoletti
 */
public class DataAccessComplexClass2 extends DataAccessTest {

    @Override
    protected void fill() {
        try {
            List<?> childs = PresentationManager.getPm().getEntity("simpleclass").getList(new PMContext(""), null);
            list = new ArrayList<Object>();
            int top = random(5, 30);
            for (int i = 0; i < top; i++) {
                ComplexClass2 o = new ComplexClass2();
                o.setId(new Long(i));
                o.setDescription(String.format("Complex Class II %d", i));
                o.setSimpleClass((SimpleClass) childs.get(random(0, childs.size()-1)));
                o.setSimpleClasses(new ArrayList<SimpleClass>());
                int x = random(1, childs.size() - 2);
                for (int j = x - 1; j < x + 1; j++) {
                    o.getSimpleClasses().add((SimpleClass) childs.get(j));
                }
                list.add(o);
            }
        } catch (PMException ex) {
            PresentationManager.pm.error(ex);
        }
    }
}
