package org.tendiwa.inflectible;

import java.net.URL;

/**
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1
 */
public abstract class AbstractLanguage implements Language {

    private final String localizedName;

    private final String localeName;
    private final Class<? extends Grammeme> grammemesClass;

    /**
     * @param localizedName Name of the language in that language, for example
     *  "Русский" for Russian.
     */
    protected AbstractLanguage(
        String localizedName,
        String localeName,
        Class<? extends Grammeme> grammemesClass
    ) {
        this.localizedName = localizedName;
        this.localeName = localeName;
        this.grammemesClass = grammemesClass;
    }

    @Override
    public final boolean validateLanguage(URL url) {
        return url.getPath().matches(
            "(.*\\.)" + this.getLocaleName() + "(\\..*)"
        );
    }

    @Override
    public Grammar grammar() {
        return new EnumBasedGrammar(this.grammemesClass);
    }


    @Override
    public final String getLocaleName() {
        return this.localeName;
    }

    @Override
    public final String getLocalizedName() {
        return this.localizedName;
    }
}