/*
 * Copyright (C) 2013-2014 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.util.ArrayList;
import java.util.Arrays;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class LocaleCodeTest {

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
  public void test15() {
    Locale undefinedLocale = LocaleCode.undefined.toLocale();

    try {
      Locale root = (Locale) Locale.class.getDeclaredField("ROOT").get(null);
      assertSame(root, undefinedLocale);
    } catch (Exception e) {
      assertEquals("", undefinedLocale.getLanguage());
      assertEquals("", undefinedLocale.getCountry());
    }
  }


  @Test
  public void test16() {
    assertSame(LocaleCode.ja, getByLocale(Locale.JAPANESE));
  }


  @Test
  public void test17() {
    assertSame(LocaleCode.ja_JP, getByLocale(Locale.JAPAN));
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test18() {
    assertSame(LocaleCode.undefined, getByLocale(new Locale("", "")));
  }


  @Test
  public void test19() {
    assertSame(LocaleCode.undefined, getByCode("undefined", null));
  }


  @Test
  public void test20() {
    assertNull(getByCode("UNDEFINED", null));
  }


  @Test
  public void test21() {
    assertSame(LocaleCode.undefined, getByCode("UNDEFINED", null, false));
  }


  @Test
  public void test22() {
    assertSame(LocaleCode.undefined, getByCode("undefined", "UNDEFINED"));
  }


  @Test
  public void test23() {
    assertNull(getByCode("undefined", "undefined"));
  }


  @Test
  public void test24() {
    assertSame(LocaleCode.undefined, getByCode("undefined", "undefined", false));
  }


  @Test
  public void test25() {
    assertSame(LocaleCode.undefined, getByCode("undefined"));
  }


  @Test
  public void test26() {
    assertNull(getByCode("UNDEFINED"));
  }


  @Test
  public void test27() {
    assertSame(LocaleCode.undefined, getByCode("UNDEFINED", false));
  }


  @Test
  public void test28() {
    assertSame(LocaleCode.undefined, getByCode("undefined-UNDEFINED"));
  }


  @Test
  public void test29() {
    assertNull(getByCode("undefined-undefined"));
  }


  @Test
  public void test30() {
    assertSame(LocaleCode.undefined, getByCode("undefined-undefined", false));
  }


  @Test
  public void test31() {
    assertSame(LocaleCode.undefined, getByCode("undefined_UNDEFINED"));
  }


  @Test
  public void test32() {
    assertNull(getByCode("undefined_undefined"));
  }


  @Test
  public void test33() {
    assertSame(LocaleCode.undefined, getByCode("undefined_undefined", false));
  }


  @Test
  public void test34() {
    assertSame(LocaleCode.ja, getByCode("ja"));
  }


  @Test
  public void test35() {
    assertNull(getByCode("JA"));
  }


  @Test
  public void test36() {
    assertSame(LocaleCode.ja, getByCode("JA", false));
  }


  @Test
  public void test37() {
    assertSame(LocaleCode.ja_JP, getByCode("ja-JP"));
  }


  @Test
  public void test38() {
    assertNull(getByCode("ja-jp"));
  }


  @Test
  public void test39() {
    assertSame(LocaleCode.ja_JP, getByCode("ja-jp", false));
  }


  @Test
  public void test40() {
    assertSame(LocaleCode.ja_JP, getByCode("ja_JP"));
  }


  @Test
  public void test41() {
    assertNull(getByCode("ja_jp"));
  }


  @Test
  public void test42() {
    assertSame(LocaleCode.ja_JP, getByCode("ja_jp", false));
  }


  @Test
  public void test43() {
    assertNull(getByCode("ja+JP"));
  }


  @Test
  public void test44() {
    assertNull(getByCode(null));
  }


  @Test
  public void test45() {
    assertNull(getByCode(""));
  }


  @Test
  public void test46() {
    assertSame(LocaleCode.ro_MD, getByCode("ro_MD", false));
  }


  @Test
  public void test47() {
    assertSame(LocaleCode.ur_PK, getByCode("ur_PK", false));
  }


  @Test
  public void test48() {
    assertSame(LocaleCode.bs_BA, getByCode("bs_BA", false));
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
