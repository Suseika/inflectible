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
package org.tendiwa.inflectible.antlr.parsed;

import java.util.Locale;
import org.tendiwa.inflectible.ArgumentName;
import org.tendiwa.inflectible.antlr.TemplateParser;

/**
 * {@link ArgumentName} parsed from an ANTLR parse tree of an argument name.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.2.0
 */
public final class AnParsed implements ArgumentName {

    /**
     * ANTLR parse tree of an argument name.
     */
    private final transient TemplateParser.ArgumentNameContext ctx;

    /**
     * Ctor.
     * @param context ANTLR parse tree of an argument name
     */
    AnParsed(final TemplateParser.ArgumentNameContext context) {
        this.ctx = context;
    }

    @Override
    public String string() throws Exception {
        return this.ctx
            .ARGUMENT_NAME()
            .getText()
            .toLowerCase(Locale.getDefault());
    }
}
