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

import com.google.common.collect.ImmutableList;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for {@link BasicActualArguments}.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1.0
 */
public final class BasicActualArgumentsTest {
    /**
     * {@link BasicActualArgumentsTest} can return an argument value by its
     * declared name.
     * @throws Exception If fails
     */
    @Test
    public void returnsArgumentByName() throws Exception {
        final String subject = "subject";
        final String bear = "bear";
        MatcherAssert.assertThat(
            new BasicActualArguments(
                ImmutableList.of(
                    new AnBasic(subject),
                    new AnBasic("object")
                ),
                ImmutableList.of(
                    new SingleFormLexeme(bear),
                    new SingleFormLexeme("human")
                )
            )
                .byName(new AnBasic(subject))
                .defaultSpelling()
                .string(),
            CoreMatchers.equalTo(bear)
        );
    }

    /**
     * {@link BasicActualArguments} can fail if it is asked for an argument
     * whose name wasn't declared.
     * @throws Exception If fails
     */
    @Test(expected = IllegalArgumentException.class)
    public void failsIfNoArgumentWithSuchName() throws Exception {
        new BasicActualArguments(
            ImmutableList.of(new AnBasic("action")),
            ImmutableList.of(Mockito.mock(Lexeme.class))
        )
            .byName(new AnBasic("property"));
    }
}
