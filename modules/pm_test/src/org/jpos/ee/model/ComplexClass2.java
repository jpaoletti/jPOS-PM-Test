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
package org.jpos.ee.model;

import java.util.List;

/**
 *
 * @author jpaoletti
 */
public class ComplexClass2 extends SimpleClass{
    private SimpleClass simpleClass;
    private List<SimpleClass> simpleClasses;

    public SimpleClass getSimpleClass() {
        return simpleClass;
    }

    public void setSimpleClass(SimpleClass simpleClass) {
        this.simpleClass = simpleClass;
    }

    public List<SimpleClass> getSimpleClasses() {
        return simpleClasses;
    }

    public void setSimpleClasses(List<SimpleClass> simpleClasses) {
        this.simpleClasses = simpleClasses;
    }
}
