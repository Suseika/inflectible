package org.tendiwa.lexeme;

import org.tendiwa.rocollections.ReadOnlyList;

/**
 * A piece of textual markup for a single word form.
 * <p/>
 * Consists of:
 * <ol>
 *     <li>Spelling</li>
 *     <li>Names of grammemes</li>
 * </ol>
 * <h4>Examples of markup:</h4>
 * Base form, with no grammemes:
 * <pre>
 * cat
 * </pre>
 * Form with some grammemes:
 * <pre>
 * cats [Plur]
 * </pre>
 * @see "WordBundleParser.g4, rule `entry` for how MarkedUpWordForm is parsed."
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1
 */
interface MarkedUpWordForm {
    /**
     * @return The actual spelling of a word form.
     */
    String spelling();

    /**
     * @return Names of grammemes that this word form has.
     */
    ReadOnlyList<String> grammemes();
}
