package org.tendiwa.inflectible;

/**
 * Stores marked up texts. Same as {@link NativeSpeaker}, but
 * for text rather than for words.
 * @author Georgy Vlasov (suseika@tendiwa.org)
 * @version $Id$
 * @since 0.1
 */
public interface Textuary {
    TextTemplate getText(String name);
}