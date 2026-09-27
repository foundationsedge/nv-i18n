/*
 * Copyright (C) 2013-2014 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import static com.neovisionaries.i18n.LocaleCode.getByCode;
import static com.neovisionaries.i18n.LocaleCode.getByCodeIgnoreCase;
import static com.neovisionaries.i18n.LocaleCode.getByCountry;
import static com.neovisionaries.i18n.LocaleCode.getByCountryIgnoreCase;
import static com.neovisionaries.i18n.LocaleCode.getByLanguage;
import static com.neovisionaries.i18n.LocaleCode.getByLanguageIgnoreCase;
import static com.neovisionaries.i18n.LocaleCode.getByLocale;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCollection;

class LocaleCodeTest {

  @Test
  public void arabicCountryLocalesAreAsExpected() {
    List<LocaleCode> expected = new ArrayList<>();
    expected.add(LocaleCode.ar);
    expected.add(LocaleCode.ar_AE);
    expected.add(LocaleCode.ar_BH);
    expected.add(LocaleCode.ar_DJ);
    expected.add(LocaleCode.ar_DZ);
    expected.add(LocaleCode.ar_EG);
    expected.add(LocaleCode.ar_EH);
    expected.add(LocaleCode.ar_ER);
    expected.add(LocaleCode.ar_IL);
    expected.add(LocaleCode.ar_IQ);
    expected.add(LocaleCode.ar_JO);
    expected.add(LocaleCode.ar_KM);
    expected.add(LocaleCode.ar_KW);
    expected.add(LocaleCode.ar_LB);
    expected.add(LocaleCode.ar_LY);
    expected.add(LocaleCode.ar_MA);
    expected.add(LocaleCode.ar_MR);
    expected.add(LocaleCode.ar_OM);
    expected.add(LocaleCode.ar_PS);
    expected.add(LocaleCode.ar_QA);
    expected.add(LocaleCode.ar_SA);
    expected.add(LocaleCode.ar_SD);
    expected.add(LocaleCode.ar_SO);
    expected.add(LocaleCode.ar_SS);
    expected.add(LocaleCode.ar_SY);
    expected.add(LocaleCode.ar_TD);
    expected.add(LocaleCode.ar_TN);
    expected.add(LocaleCode.ar_YE);

    List<LocaleCode> actual = getByLanguage(LanguageCode.ar);

    assertThatCollection(actual)
      .containsExactlyInAnyOrderElementsOf(expected);
  }

  @Test
  public void noLocalesAreReturnedForANullLanguageCode() {
    LanguageCode nullValue = null;
    List<LocaleCode> actual = getByLanguage(nullValue);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidLanguageCode() {
    LanguageCode languageCode = LanguageCode.en;
    List<LocaleCode> actual = getByLanguage(languageCode);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void noLocalesAreReturnedForANullLanguageCodeStringParameter() {
    String nullValue = null;
    List<LocaleCode> actual = getByLanguage(nullValue);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidLanguageCodeStringParameter() {
    String languageCode = "en";
    List<LocaleCode> actual = getByLanguage(languageCode);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidLanguageCodeAndTrueCaseSensitivity() {
    String languageCode = "en";
    List<LocaleCode> actual = getByLanguage(languageCode, true);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidLanguageCodeAndFalseCaseSensitivity() {
    String languageCode = "EN";
    List<LocaleCode> actual = getByLanguage(languageCode, false);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForANullLanguageCodeAndFalseCaseSensitivity() {
    String languageCode = null;
    List<LocaleCode> actual = getByLanguage(languageCode, false);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidLanguageCodeIgnoringCase() {
    String languageCode = "EN";
    List<LocaleCode> actual = getByLanguageIgnoreCase(languageCode);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForANullLanguageCode() {
    String languageCode = null;
    List<LocaleCode> actual = getByLanguageIgnoreCase(languageCode);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void swissLanguagesAreAsExpected() {
    List<LocaleCode> expected = new ArrayList<>();
    expected.add(LocaleCode.de_CH);
    expected.add(LocaleCode.en_CH);
    expected.add(LocaleCode.fr_CH);
    expected.add(LocaleCode.it_CH);
    expected.add(LocaleCode.pt_CH);
    expected.add(LocaleCode.rm_CH);

    List<LocaleCode> actual = getByCountry(CountryCode.CH);

    assertThatCollection(actual)
      .containsExactlyInAnyOrderElementsOf(expected);
  }

  @Test
  public void swissLanguagesAreAsExpectedWithStringParameter() {
    List<LocaleCode> expected = new ArrayList<>();
    expected.add(LocaleCode.de_CH);
    expected.add(LocaleCode.en_CH);
    expected.add(LocaleCode.fr_CH);
    expected.add(LocaleCode.it_CH);
    expected.add(LocaleCode.pt_CH);
    expected.add(LocaleCode.rm_CH);

    List<LocaleCode> actual = getByCountry("CH");

    assertThatCollection(actual)
      .containsExactlyInAnyOrderElementsOf(expected);
  }

  @Test
  public void noLocalesAreReturnedForANullCountryCode() {
    CountryCode nullValue = null;
    List<LocaleCode> actual = getByCountry(nullValue);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void noLocalesAreReturnedForANullCountryCodeAndTrueCaseSensitivity() {
    String nullValue = null;
    List<LocaleCode> actual = getByCountry(nullValue, true);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void noLocalesAreReturnedForANullCountryCodeAndFalseCaseSensitivity() {
    String nullValue = null;
    List<LocaleCode> actual = getByCountry(nullValue, false);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidCountryCodeAndFalseCaseSensitivity() {
    List<LocaleCode> actual = getByCountry("GB", false);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForALowerCaseCountryCodeAndFalseCaseSensitivity() {
    List<LocaleCode> actual = getByCountry("gb", false);

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForALowerCaseCountryCode() {
    List<LocaleCode> actual = getByCountryIgnoreCase("gb");

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void someLocalesAreReturnedForAValidCaseCountryCode() {
    List<LocaleCode> actual = getByCountryIgnoreCase("GB");

    assertThatCollection(actual)
      .isNotEmpty();
  }

  @Test
  public void noLocalesAreReturnedForANullCountryCodeIgnoringCase() {
    String nullValue = null;
    List<LocaleCode> actual = getByCountryIgnoreCase(nullValue);

    assertThatCollection(actual)
      .isEmpty();
  }

  @Test
  public void toLocaleLanguageCodeForALocaleWhichHasAnEnum() {
    assertThat(LocaleCode.de.toLocale())
      .isEqualTo(Locale.GERMAN);
  }

  @Test
  public void toLocaleLanguageCodeForALocaleWhichDoesNotHaveAnEnum() {
    assertThat(LocaleCode.da.toLocale())
      .isNotNull();
  }

  @Test
  public void toLocaleLanguageAndCountryCodeWhichHasAnEnum() {
    assertThat(LocaleCode.fr_CA.toLocale())
      .isEqualTo(Locale.CANADA_FRENCH);
  }

  @Test
  public void toLocaleLanguageAndCountryCodeWhichDoesNotHaveAnEnum() {
    assertThat(LocaleCode.fr_CD.toLocale())
      .isNotNull();
  }

  @Test
  public void toLocaleUndefined() {
    assertThat(LocaleCode.undefined.toLocale())
      .isEqualTo(Locale.ROOT);
  }

  @Test
  public void toLocaleEnglish() {
    assertThat(LocaleCode.en.toLocale())
      .isEqualTo(Locale.ENGLISH);
  }

  @Test
  public void toLocaleFrench() {
    assertThat(LocaleCode.fr.toLocale())
      .isEqualTo(Locale.FRENCH);
  }

  @Test
  public void toLocaleItaly() {
    assertThat(LocaleCode.it.toLocale())
      .isEqualTo(Locale.ITALIAN);
  }

  @Test
  public void toLocaleJapanese() {
    assertThat(LocaleCode.ja.toLocale())
      .isEqualTo(Locale.JAPANESE);
  }

  @Test
  public void toLocaleKorean() {
    assertThat(LocaleCode.ko.toLocale())
      .isNotNull()
      .isEqualTo(Locale.KOREAN);
  }

  @Test
  public void toLocaleChinese() {
    assertThat(LocaleCode.zh.toLocale())
      .isEqualTo(Locale.CHINESE);
  }

  @Test
  public void toLocaleChineseChina() {
    assertThat(LocaleCode.zh_CN.toLocale())
      .isEqualTo(Locale.SIMPLIFIED_CHINESE);
  }

  @Test
  public void toLocaleChineseTaiwan() {
    assertThat(LocaleCode.zh_TW.toLocale())
      .isEqualTo(Locale.TRADITIONAL_CHINESE);
  }

  @Test
  public void toLocaleForUndefinedMatchesTheRootLocale() {
    Locale undefinedLocale = LocaleCode.undefined.toLocale();

    try {
      Locale root = (Locale) Locale.class.getDeclaredField("ROOT").get(null);
      assertThat(undefinedLocale).isSameAs(root);
    } catch (Exception e) {
      assertThat(undefinedLocale.getLanguage()).isEqualTo("");
      assertThat(undefinedLocale.getCountry()).isEqualTo("");
    }
  }


  @Test
  public void getByLocaleWithJapaneseReturnsJa() {
    assertThat(getByLocale(Locale.JAPANESE)).isSameAs(LocaleCode.ja);
  }


  @Test
  public void getByLocaleWithJapanReturnsJaJp() {
    assertThat(getByLocale(Locale.JAPAN)).isSameAs(LocaleCode.ja_JP);
  }


  @Test
  @SuppressWarnings("deprecation")
  public void getByLocaleWithEmptyLocaleReturnsUndefined() {
    assertThat(getByLocale(new Locale("", ""))).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedLanguageAndNullCountryReturnsUndefined() {
    assertThat(getByCode("undefined", null)).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedLanguageInUpperCaseAndNullCountryReturnsNull() {
    assertThat(getByCode("UNDEFINED", null)).isNull();
  }


  @Test
  public void getByCodeWithUndefinedLanguageAndNullCountryIgnoringCaseReturnsUndefined() {
    assertThat(getByCode("UNDEFINED", null, false)).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedLanguageAndUndefinedCountryInUpperCaseReturnsUndefined() {
    assertThat(getByCode("undefined", "UNDEFINED")).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedLanguageAndUndefinedCountryInLowerCaseReturnsNull() {
    assertThat(getByCode("undefined", "undefined")).isNull();
  }


  @Test
  public void getByCodeWithUndefinedLanguageAndUndefinedCountryInLowerCaseIgnoringCaseReturnsUndefined() {
    assertThat(getByCode("undefined", "undefined", false)).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedReturnsUndefined() {
    assertThat(getByCode("undefined")).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedInUpperCaseReturnsNull() {
    assertThat(getByCode("UNDEFINED")).isNull();
  }


  @Test
  public void getByCodeWithUndefinedInUpperCaseIgnoringCaseReturnsUndefined() {
    assertThat(getByCode("UNDEFINED", false)).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedDashUndefinedInUpperCaseReturnsUndefined() {
    assertThat(getByCode("undefined-UNDEFINED")).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedDashUndefinedInLowerCaseReturnsNull() {
    assertThat(getByCode("undefined-undefined")).isNull();
  }


  @Test
  public void getByCodeWithUndefinedDashUndefinedInLowerCaseIgnoringCaseReturnsUndefined() {
    assertThat(getByCode("undefined-undefined", false)).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedUnderscoreUndefinedInUpperCaseReturnsUndefined() {
    assertThat(getByCode("undefined_UNDEFINED")).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedUnderscoreUndefinedInLowerCaseReturnsNull() {
    assertThat(getByCode("undefined_undefined")).isNull();
  }


  @Test
  public void getByCodeWithUndefinedUnderscoreUndefinedInLowerCaseIgnoringCaseReturnsUndefined() {
    assertThat(getByCode("undefined_undefined", false)).isSameAs(LocaleCode.undefined);
  }


  @Test
  public void getByCodeWithJaReturnsJa() {
    assertThat(getByCode("ja")).isSameAs(LocaleCode.ja);
  }


  @Test
  public void getByCodeWithJaInUpperCaseReturnsNull() {
    assertThat(getByCode("JA")).isNull();
  }


  @Test
  public void getByCodeWithJaInUpperCaseIgnoringCaseReturnsJa() {
    assertThat(getByCode("JA", false)).isSameAs(LocaleCode.ja);
  }


  @Test
  public void getByCodeWithJaDashJpReturnsJaJp() {
    assertThat(getByCode("ja-JP")).isSameAs(LocaleCode.ja_JP);
  }


  @Test
  public void getByCodeWithJaDashJpInLowerCaseReturnsNull() {
    assertThat(getByCode("ja-jp")).isNull();
  }


  @Test
  public void getByCodeWithJaDashJpInLowerCaseIgnoringCaseReturnsJaJp() {
    assertThat(getByCode("ja-jp", false)).isSameAs(LocaleCode.ja_JP);
  }


  @Test
  public void getByCodeWithJaUnderscoreJpReturnsJaJp() {
    assertThat(getByCode("ja_JP")).isSameAs(LocaleCode.ja_JP);
  }


  @Test
  public void getByCodeWithJaUnderscoreJpInLowerCaseReturnsNull() {
    assertThat(getByCode("ja_jp")).isNull();
  }


  @Test
  public void getByCodeWithJaUnderscoreJpInLowerCaseIgnoringCaseReturnsJaJp() {
    assertThat(getByCode("ja_jp", false)).isSameAs(LocaleCode.ja_JP);
  }


  @Test
  public void getByCodeWithJaPlusJpReturnsNull() {
    assertThat(getByCode("ja+JP")).isNull();
  }


  @Test
  public void getByCodeWithNullReturnsNull() {
    assertThat(getByCode(null)).isNull();
  }


  @Test
  public void getByCodeWithEmptyStringReturnsNull() {
    assertThat(getByCode("")).isNull();
  }


  @Test
  public void getByCodeWithRoMdIgnoringCaseReturnsRoMd() {
    assertThat(getByCode("ro_MD", false)).isSameAs(LocaleCode.ro_MD);
  }


  @Test
  public void getByCodeWithUrPkIgnoringCaseReturnsUrPk() {
    assertThat(getByCode("ur_PK", false)).isSameAs(LocaleCode.ur_PK);
  }


  @Test
  public void getByCodeWithBsBaIgnoringCaseReturnsBsBa() {
    assertThat(getByCode("bs_BA", false)).isSameAs(LocaleCode.bs_BA);
  }

  @Test
  public void getByCodeIgnoreCaseWithTwoStrings() {
    assertThat(getByCodeIgnoreCase("bs", "BA"))
      .isEqualTo(LocaleCode.bs_BA);
  }

  @Test
  public void getByCodeIgnoreCaseWithTwoUpperCaseStrings() {
    assertThat(getByCodeIgnoreCase("BS", "BA"))
      .isEqualTo(LocaleCode.bs_BA);
  }

  @Test
  public void getByCodeIgnoreCaseWithTwoLowerCaseStrings() {
    assertThat(getByCodeIgnoreCase("bs", "ba"))
      .isEqualTo(LocaleCode.bs_BA);
  }

  @Test
  public void getByCodeIgnoreCaseWithNullForFirstArgumentReturnsNull() {
    assertThat(getByCodeIgnoreCase(null, "ba"))
      .isNull();
  }

  @Test
  public void getByCodeIgnoreCaseWithNullForSecondArgumentStillFindsAValidLocale() {
    assertThat(getByCodeIgnoreCase("bs", null))
      .isEqualTo(LocaleCode.bs);
  }

  @Test
  public void getByCodeIgnoreCaseWithNullForBothArgumentsReturnsNull() {
    assertThat(getByCodeIgnoreCase(null, null))
      .isNull();
  }

  @Test
  public void getByCodeIgnoreCaseWithLowerCaseLanguageReturnsLocale() {
    assertThat(getByCodeIgnoreCase("bs"))
      .isEqualTo(LocaleCode.bs);
  }

  @Test
  public void getByCodeIgnoreCaseWithUpperCaseLanguageReturnsLocale() {
    assertThat(getByCodeIgnoreCase("BS"))
      .isEqualTo(LocaleCode.bs);
  }

  @Test
  public void getByCodeIgnoreCaseWithNullReturnsNull() {
    assertThat(getByCodeIgnoreCase(null))
      .isNull();
  }

  @Test
  public void toStringForEnumIsNotNull() {
    assertThat(LocaleCode.en.toString())
      .isNotNull()
      .isEqualTo("en");
  }

  @Test
  public void toStringForEnumIsExceptedResult() {
    assertThat(LocaleCode.fr.toString())
      .isEqualTo("fr");
  }

  @Test
  public void getLocaleCodeCount() {
    int localeJdk27Count = 594;
    int undefinedCount = 1;
    assertThat(LocaleCode.values().length)
      .isEqualTo(localeJdk27Count + undefinedCount);
  }
}
