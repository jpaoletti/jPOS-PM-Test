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
import org.jpos.ee.model.ParentClass;
import org.jpos.ee.model.WeakClass;

/**
 *
 * @author jpaoletti
 */
public class DataAccessParentClass extends DataAccessTest {

    @Override
    protected void fill() {
        list = new ArrayList<Object>();
        int top = random(5, 30);
        for (int i = 0; i < top; i++) {
            ParentClass o = new ParentClass();
            o.setId(new Long(i));
            o.setDescription(String.format("Parent Class %d", i));
            o.setWeaks(new ArrayList<WeakClass>());
            int x = random(1, 10);
            for (int j = 0; j < x + 1; j++) {
                WeakClass weak = new WeakClass();
                weak.setParent(o);
                weak.setDescription("Weak "+j+" of " + o.getId());
                o.getWeaks().add(weak);
            }
            list.add(o);
        }

    }
}
