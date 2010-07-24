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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpaoletti
 */
public class ParentClass extends SimpleClass {
    private List<WeakClass> weaks;

    public List<WeakClass> getWeaks() {
        if(weaks==null) weaks=new ArrayList<WeakClass>();
        return weaks;
    }

    public void setWeaks(List<WeakClass> weaks) {
        this.weaks = weaks;
    }


    @Override
    public String toString() {
        return "ParentClass{" + "id=" + getId() + '}';
    }
    
}
