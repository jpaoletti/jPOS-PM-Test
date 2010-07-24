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
package org.jpos.ee.ui.validators;

import java.util.List;
import org.jpos.ee.model.SimpleClass;
import org.jpos.ee.pm.core.PMContext;
import org.jpos.ee.pm.core.PMException;
import org.jpos.ee.pm.core.PMMessage;
import org.jpos.ee.pm.validator.ValidationResult;
import org.jpos.ee.pm.validator.ValidatorSupport;

/**
 *
 * @author jpaoletti
 */
public class SimpleClassUniqueIdValidator extends ValidatorSupport {

    public ValidationResult validate(PMContext ctx) {
        final ValidationResult result = new ValidationResult();
        final PMMessage error = new PMMessage(ENTITY, get("msg", "pm.validator.simple.class.uniqueid"));
        result.setSuccessful(true);
        try {
            final SimpleClass sc = (SimpleClass) ctx.getSelected().getInstance();
            final List<SimpleClass> list = (List<SimpleClass>) ctx.getEntity().getList(ctx);
            for (SimpleClass simpleClass : list) {
                if (simpleClass.getId().equals(sc.getId())) {
                    result.setSuccessful(false);
                    result.getMessages().add(error);
                }
            }
        } catch (PMException ex) {
            ctx.getPresentationManager().error(ex);
            result.setSuccessful(false);
            result.getMessages().add(error);
        }
        return result;
    }
}
