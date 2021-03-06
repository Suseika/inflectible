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
package org.tendiwa.inflectible.implementations;

import com.google.common.collect.ImmutableSet;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Unit tests for {@link EnglishGrammaticalCategory}.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.2.0
 */
public final class EnglishGrammaticalCategoryTest {
    /**
     * {@link EnglishGrammaticalCategory} can tell if it contains a
     * particular grammeme or not.
     * @throws Exception If fails
     */
    @Test
    public void containsGrammemes() throws Exception {
        MatcherAssert.assertThat(
            EnglishGrammaticalCategory.Person
                .containsGrammeme(EnglishGrammeme.I),
            CoreMatchers.is(true)
        );
        MatcherAssert.assertThat(
            EnglishGrammaticalCategory.Person
                .containsGrammeme(EnglishGrammeme.Plur),
            CoreMatchers.is(false)
        );
    }

    /**
     * {@link EnglishGrammaticalCategory} can tell its default grammeme.
     * @throws Exception If fails
     */
    @Test
    public void hasDefaultGrammeme() throws Exception {
        MatcherAssert.assertThat(
            EnglishGrammaticalCategory.Number
                .defaultGrammeme(),
            CoreMatchers.is(EnglishGrammeme.Sing)
        );
    }

    /**
     * {@link EnglishGrammaticalCategory} can get its grammeme from
     * {@link org.tendiwa.inflectible.GrammaticalMeaning}.
     * @throws Exception If fails
     */
    @Test
    public void getsGrammeme() throws Exception {
        MatcherAssert.assertThat(
            EnglishGrammaticalCategory.Person.getGrammeme(
                ()-> ImmutableSet.of(EnglishGrammeme.Ger, EnglishGrammeme.III)
            ),
            CoreMatchers.is(EnglishGrammeme.III)
        );
    }
}
