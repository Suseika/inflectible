package org.tendiwa.lexeme;

/**
 * Anything that can be named. For each Localizable, there may be a single
 * lexeme in each language, identified by localization id.
 */
public interface Localizable {
	/**
     * Identifier of a lexeme.
	 * @return A string identifier. May contain only English letters and spaces.
	 */
	String getLocalizationId();
}
