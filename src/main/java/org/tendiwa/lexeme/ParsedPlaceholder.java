package org.tendiwa.lexeme;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.tendiwa.lexeme.antlr.TextBundleParser;

/**
 * Placeholder in a parse tree.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1
 */
public class ParsedPlaceholder implements Placeholder {
    private final TextBundleParser.PlaceholderContext placeholderCtx;

    /**
     * Creates a placeholder from a parse tree.
     * @param placeholderCtx A piece of parse tree containing the placeholder
     * tokens.
     */
    public ParsedPlaceholder(TextBundleParser.PlaceholderContext placeholderCtx) {
        this.placeholderCtx = placeholderCtx;
    }

    @Override
    public final String id() {
        final String capitalizableId =
            this.placeholderCtx.CAPITALIZABLE_ID().getText();
        final char firstChar = capitalizableId.charAt(0);
        if (Character.isLowerCase(firstChar)) {
            return capitalizableId;
        } else {
            return Character.toLowerCase(firstChar)
                + capitalizableId.substring(1);
        }
    }

    @Override
    public ImmutableList<String> explicitGrammemes() {
        final List<TerminalNode> categoryNodes = this.placeholderCtx.CATEGORY();
        final ImmutableList.Builder<String> categories =
            ImmutableList.builder();
        for (TerminalNode node : categoryNodes) {
            categories.add(node.getText());
        }
        return categories.build();
    }

    @Override
    public final Optional<String> agreementId() {
        return Optional.of(
            this.placeholderCtx.agreement().AGREEMENT_ID().getText()
        );
    }
}