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

import lombok.EqualsAndHashCode;
import org.tendiwa.inflectible.antlr.LexemeBundleParser;

/**
 * Name for a {@link Lexeme}. Must consist only of uppercase letters.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode(of = { "value" })
public final class LexemeName implements ValidatedIdentifier {
    /**
     * String value of the lexeme name.
     */
    private final transient String value;

    /**
     * Ctor.
     * @param name String value of the lexeme name.
     */
    public LexemeName(final String name) {
        this.value = name;
    }

    /**
     * Ctor.
     * @param ctx ANTLR parse tree for a {@link Lexeme}.
     */
    public LexemeName(final LexemeBundleParser.LexemeContext ctx) {
        this(ctx.LEXEME_NAME().getText());
    }

    @Override
    public String string() throws Exception {
        this.validate();
        return this.value;
    }

    /**
     * Validates lexeme name.
     * @throws Exception If the name is not valid
     */
    private void validate() throws Exception {
        for (final char character : this.value.toCharArray()) {
            if (!Character.isUpperCase(character)) {
                throw new IllegalArgumentException(
                    String.format(
                        "\"%s\" is not a valid lexeme identifier",
                        this.value
                    )
                );
            }
        }
    }
}
