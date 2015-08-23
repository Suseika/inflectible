/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Georgy Vlasov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.tendiwa.inflectible;

import java.util.function.Supplier;

/**
 * Chooses at runtime to capitalize or not to capitalize.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.2.0
 */
public final class SrConditionalCapitalization implements SpellingRule {
    /**
     * Condition.
     */
    private final transient Supplier<Boolean> condition;

    /**
     * Ctor.
     * @param check If this condition holds, this GraphicRule will capitalize
     *  spelling, otherwise it will leave spelling as it is.
     */
    SrConditionalCapitalization(final Supplier<Boolean> check) {
        this.condition = check;
    }

    @Override
    public Spelling adjustSpelling(final Spelling spelling) {
        final Spelling modified;
        if (this.condition.get()) {
            modified = new CapitalizedSpelling(spelling);
        } else {
            modified = spelling;
        }
        return modified;
    }
}