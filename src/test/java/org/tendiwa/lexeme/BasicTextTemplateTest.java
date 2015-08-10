package org.tendiwa.lexeme;

import junit.framework.Assert;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * @since 0.1
 */
public final class BasicTextTemplateTest {

    /**
     * BasicMarkedUpText knows its argumentName.
     */
    @Test
    public void knowsItsId() {
        Assert.assertEquals(
            "action.act",
            new BasicTextTemplate(
                new TextBundleParserFactory()
                    .create(
                        "action.act(actor, seer) {",
                        "  [Actor][;seer]. And then [seer][;actor]",
                        "}"
                    )
                    .text()
            )
                .id()
        );
    }

    @Test
    public void hasWalkableBody() {
        MatcherAssert.assertThat(
            new BasicTextTemplate(
                new TextBundleParserFactory()
                    .create(
                        "story.short(dude, dudette) {",
                        "  [Dude] and [dudette] once ate a taco.",
                        "}"
                    )
                    .text()
            )
                .body()
                .walk(PlaceholderMarkup::argumentName),
            CoreMatchers.equalTo("dude and dudette once ate a taco.")
        );
    }
}