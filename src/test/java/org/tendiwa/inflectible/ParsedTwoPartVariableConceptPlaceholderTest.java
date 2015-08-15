package org.tendiwa.inflectible;

import com.google.common.collect.ImmutableMap;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.tendiwa.inflectible.antlr.TemplateBundleLexer;
import org.tendiwa.inflectible.implementations.English;

public final class ParsedTwoPartVariableConceptPlaceholderTest {
    @Test
    public void capitalizesWordWhenNecessary() throws Exception {
        MatcherAssert.assertThat(
            this.wordFormInsertionResult("[dude][Plur]", "dude", "director"),
            CoreMatchers.equalTo("director")
        );
    }

    @Test
    public void doesntCapitalizeWordWhenUnnecessary() throws Exception {

    }

    private String wordFormInsertionResult(
        String placeholderMarkup,
        String argumentName,
        String wordForm
    ) {
        return
            new ParsedTwoPartVariableConceptPlaceholder(
                new English().grammar(),
                new TemplateBundleParserFactory().createInMode(
                    TemplateBundleLexer.LINE_CONTENT,
                    placeholderMarkup
                )
                    .twoPartPlaceholder()
            ).fillUp(
                ImmutableMap.of(argumentName, new SingleFormLexeme(wordForm)),
                ImmutableMap.of()
            );
    }
}