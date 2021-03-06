/*
 * License: Apache License, Version 2.0
 * See the LICENSE file in the root directory or at <a href="http://www.apache.org/licenses/LICENSE-2">apache.org</a>.
 */

package io.leangen.geantyref;

import java.lang.reflect.TypeVariable;

class UnresolvedTypeVariableException extends RuntimeException {
    private static final long serialVersionUID = -1337450928967900324L;
    private final TypeVariable<?> tv;

    UnresolvedTypeVariableException(TypeVariable<?> tv) {
        super("An exact type is requested, but the type contains a type variable that cannot be resolved.\n" +
                "   Variable: " + tv.getName() + " from " + tv.getGenericDeclaration() + "\n" +
                "   Hint: This is usually caused by trying to get an exact type when a generic method who's type parameters are not given is involved.");
        this.tv = tv;
    }

    TypeVariable<?> getTypeVariable() {
        return tv;
    }
}
