package uk.co.foundationsedge.samples.i18n;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;
import com.neovisionaries.i18n.LanguageCode;
import com.neovisionaries.i18n.LocaleCode;
import com.neovisionaries.i18n.ScriptCode;

/**
 * Minimal example of using the nv-i18n standards library as a dependency.
 */
public final class Example {

  public static void main(String[] args) {
    // List all the country codes.
    for (CountryCode code : CountryCode.values()) {
      System.out.format("[%s] %s\n", code, code.getName());
    }

    // List all the language codes.
    for (LanguageCode code : LanguageCode.values()) {
      System.out.format("[%s] %s\n", code, code.getName());
    }

    // List all the locale codes.
    for (LocaleCode code : LocaleCode.values()) {
      String language = code.getLanguage().getName();
      String country = code.getCountry() != null
        ? code.getCountry().getName()
        : null;

      System.out.format("[%s] %s, %s\n", code, language, country);
    }

    // List all the script codes.
    for (ScriptCode code : ScriptCode.values()) {
      System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
    }

    // List all the currency codes.
    for (CurrencyCode code : CurrencyCode.values()) {
      System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
    }
  }
}
