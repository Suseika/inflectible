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
import com.google.common.collect.ImmutableSet;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for {@link GmCombined}.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.3.0
 */
public final class GmCombinedTest {
    /**
     * {@link GmCombined} can combine multiple grammatical meanings.
     * @throws Exception If fails
     */
    @Test
    public void combinesGrammaticalMeanings() throws Exception {
        final Grammeme one = Mockito.mock(Grammeme.class);
        final Grammeme two = Mockito.mock(Grammeme.class);
        final Grammeme three = Mockito.mock(Grammeme.class);
        final GrammaticalMeaning meaning = new GmCombined(
            ImmutableList.of(
                () -> ImmutableSet.of(one),
                () -> ImmutableSet.of(two),
                () -> ImmutableSet.of(three)
            )
        );
        MatcherAssert.assertThat(
            meaning.grammemes(),
            Matchers.containsInAnyOrder(one, two, three)
        );
    }
}
