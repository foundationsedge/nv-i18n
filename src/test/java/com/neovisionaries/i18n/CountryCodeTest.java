/*
 * Copyright (C) 2014-2021 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static com.neovisionaries.i18n.CountryCode.getByCode;
import static com.neovisionaries.i18n.CountryCode.getByCodeIgnoreCase;
import static com.neovisionaries.i18n.CountryCode.getByLocale;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountryCodeTest {
  @Test
  public void test1() {
    List<CountryCode> list = CountryCode.findByName(".*United.*");

    assertThat(list).hasSize(8);

    // AE: United Arab Emirates
    assertThat(list).contains(CountryCode.AE);

    // GB: United Kingdom
    assertThat(list).contains(CountryCode.GB);

    // TZ: Tanzania, United Republic of
    assertThat(list).contains(CountryCode.TZ);

    // UK: United Kingdom
    assertThat(list).contains(CountryCode.UK);

    // UM: United States Minor Outlying Islands
    assertThat(list).contains(CountryCode.UM);

    // US: United States
    assertThat(list).contains(CountryCode.US);

    // XU: United Kingdom (excluding Northern Ireland)
    assertThat(list).contains(CountryCode.XU);

    // UN: United Nations
    assertThat(list).contains(CountryCode.UN);
  }


  @Test
  public void test2() {
    assertThat(CountryCode.CA.toLocale()).isEqualTo(Locale.CANADA);
  }


  @Test
  public void test3() {
    assertThat(CountryCode.CN.toLocale()).isEqualTo(Locale.CHINA);
  }


  @Test
  public void test4() {
    assertThat(CountryCode.DE.toLocale()).isEqualTo(Locale.GERMANY);
  }


  @Test
  public void test5() {
    assertThat(CountryCode.FR.toLocale()).isEqualTo(Locale.FRANCE);
  }


  @Test
  public void test6() {
    assertThat(CountryCode.GB.toLocale()).isEqualTo(Locale.UK);
  }


  @Test
  public void test7() {
    assertThat(CountryCode.IT.toLocale()).isEqualTo(Locale.ITALY);
  }


  @Test
  public void test8() {
    assertThat(CountryCode.JP.toLocale()).isEqualTo(Locale.JAPAN);
  }


  @Test
  public void test9() {
    assertThat(CountryCode.KR.toLocale()).isEqualTo(Locale.KOREA);
  }


  @Test
  public void test10() {
    assertThat(CountryCode.TW.toLocale()).isEqualTo(Locale.TAIWAN);
  }


  @Test
  public void test11() {
    assertThat(CountryCode.US.toLocale()).isEqualTo(Locale.US);

  }


  @Test
  public void test12() {
    Locale undefinedLocale = CountryCode.UNDEFINED.toLocale();

    assertThatCode(() -> {
      Locale root = (Locale) Locale.class.getDeclaredField("ROOT").get(null);
      assertThat(undefinedLocale).isSameAs(root);
    }).doesNotThrowAnyException();
  }


  @Test
  public void test13() {
    assertThat(getByCode("UNDEFINED")).isSameAs(CountryCode.UNDEFINED);
  }

  @Test
  public void test14() {
    assertThat(getByCode("undefined")).isNull();
  }

  @Test
  void getByCodeWithAValueZeroReturnsNull() {
    assertThat(getByCode(0)).isNull();
  }

  @Test
  void getByCodeWithAValueBelowZeroReturnsNull() {
    assertThat(getByCode(1)).isNull();
  }

  @Test
  void getByCodeWithAValueAboveZeroDoesNotReturnNull() {
    assertThat(getByCode(104)).isNotNull();
  }

  @Test
  public void test15() {
    assertThat(getByCodeIgnoreCase("undefined")).isSameAs(CountryCode.UNDEFINED);
  }

  @Test
  @SuppressWarnings("deprecation")
  public void test16() {
    assertThat(getByLocale(new Locale("", ""))).isSameAs(CountryCode.UNDEFINED);
  }

  @Test
  public void test17() {
    assertThat(getByCode(null)).isNull();
  }

  @Test
  public void test18() {
    assertThat(getByCode("")).isNull();
  }

  @Test
  public void test19() {
    assertThat(CountryCode.getByCode("ANT")).isSameAs(CountryCode.AN);
  }

  @Test
  public void test20() {
    assertThat(CountryCode.getByCode("ANHH")).isSameAs(CountryCode.AN);
  }

  @Test
  public void test21() {
    assertThat(CountryCode.getByCode("BUR")).isSameAs(CountryCode.BU);
  }

  @Test
  public void test22() {
    assertThat(CountryCode.getByCode("BUMM")).isSameAs(CountryCode.BU);
  }

  @Test
  public void test23() {
    assertThat(CountryCode.getByCode("SCG")).isSameAs(CountryCode.CS);
  }

  @Test
  public void test24() {
    assertThat(CountryCode.getByCode("CSXX")).isSameAs(CountryCode.CS);
  }

  @Test
  public void test25() {
    assertThat(CountryCode.getByCode("NTZ")).isSameAs(CountryCode.NT);
  }

  @Test
  public void test26() {
    assertThat(CountryCode.getByCode("NTHH")).isSameAs(CountryCode.NT);
  }

  @Test
  public void test27() {
    assertThat(CountryCode.getByCode("TMP")).isSameAs(CountryCode.TP);
  }

  @Test
  public void test28() {
    assertThat(CountryCode.getByCode("TPTL")).isSameAs(CountryCode.TP);
  }

  @Test
  public void test29() {
    assertThat(CountryCode.getByCode("YUG")).isSameAs(CountryCode.YU);
  }

  @Test
  public void test30() {
    assertThat(CountryCode.getByCode("YUCS")).isSameAs(CountryCode.YU);
  }

  @Test
  public void test31() {
    assertThat(CountryCode.getByCode("ZAR")).isSameAs(CountryCode.ZR);
  }

  @Test
  public void test32() {
    assertThat(CountryCode.getByCode("ZRCD")).isSameAs(CountryCode.ZR);
  }

  @Test
  void alpha2Lengths() {
    for (CountryCode cc : CountryCode.values()) {
      String alpha2 = cc.getAlpha2();

      if (alpha2 != null && cc != CountryCode.UNDEFINED) {
        assertThat(alpha2.length()).isEqualTo(2);
      }
    }
  }

  @Test
  void alpha3Lengths() {
    for (CountryCode cc : CountryCode.values()) {
      String alpha3 = cc.getAlpha3();

      if (alpha3 != null) {
        assertThat(alpha3.length()).isEqualTo(3);
      }
    }
  }

  @Test
  public void test34() {
    assertThat(CountryCode.getByCode("FIN")).isSameAs(CountryCode.FI);
  }

  @Test
  public void test35() {
    assertThat(CountryCode.getByCode(104)).isSameAs(CountryCode.MM);
  }

  @Test
  public void test36() {
    assertThat(CountryCode.getByCode(180)).isSameAs(CountryCode.CD);
  }

  @Test
  public void test37() {
    assertThat(CountryCode.getByCode(246)).isSameAs(CountryCode.FI);
  }

  @Test
  public void test38() {
    assertThat(CountryCode.getByCode(826)).isSameAs(CountryCode.GB);
  }

  @Test
  public void test39() {
    assertThat(CountryCode.getByCode(626)).isSameAs(CountryCode.TL);
  }

  @Test
  public void test40() {
    assertThat(CountryCode.getByCode(392)).isSameAs(CountryCode.JP);
  }

  @Test
  public void test41() {
    assertThat(CountryCode.FX.getNumeric()).isEqualTo(249);
    assertThat(CountryCode.SU.getNumeric()).isEqualTo(810);
    assertThat(CountryCode.TP.getNumeric()).isEqualTo(626);
    assertThat(CountryCode.UK.getNumeric()).isEqualTo(826);
    assertThat(CountryCode.ZR.getNumeric()).isEqualTo(180);
  }

  @Test
  public void test42() {
    assertThat(CountryCode.getByCode(280)).isEqualTo(CountryCode.DE);
  }

  @Test
  void officiallyAssigned() {
    assertThat(Arrays.stream(CountryCode.values())
            .filter(x -> x.getAssignment().equals(CountryCode.Assignment.OFFICIALLY_ASSIGNED)))
            .hasSize(249);
  }

  @Test
  void userAssigned() {
    assertThat(Arrays.stream(CountryCode.values())
            .filter(x -> x.getAssignment().equals(CountryCode.Assignment.USER_ASSIGNED)))
            .hasSize(4);
  }

  @Test
  void exceptionallyReserved() {
    assertThat(Arrays.stream(CountryCode.values())
            .filter(x -> x.getAssignment().equals(CountryCode.Assignment.EXCEPTIONALLY_RESERVED)))
            .hasSize(13);
  }

  @Test
  void indeterminatelyReserved() {
    assertThat(Arrays.stream(CountryCode.values())
            .filter(x -> x.getAssignment().equals(CountryCode.Assignment.INDETERMINATELY_RESERVED)))
            .hasSize(30);
  }

  @Test
  void transitionallyReserved() {
    assertThat(Arrays.stream(CountryCode.values())
            .filter(x -> x.getAssignment().equals(CountryCode.Assignment.TRANSITIONALLY_RESERVED)))
            .hasSize(7);
  }

  @Test
  void getAlpha2CheckingValue() {
    CountryCode underTest = CountryCode.GB;

    assertThat(underTest.getAlpha2()).isEqualTo(underTest.name());
  }

  @Test
  void toLocaleCheckingValue() {
    CountryCode underTest = CountryCode.UK;

    assertThat(underTest.toLocale()).isEqualTo(Locale.UK);
  }

  @Test
  void getCurrencyCheckingValue() {
    CountryCode underTest = CountryCode.GB;

    assertThat(underTest.getCurrency()).isEqualTo(Currency.getInstance(Locale.UK));
  }

  @Test
  void getCurrencyForCountryWithoutOne() {
    CountryCode underTest = CountryCode.AC;

    assertThat(underTest.getCurrency()).isNull();
  }

  @Test
  void getByLocaleValidValue() {
    assertThat(CountryCode.getByLocale(Locale.UK)).isEqualTo(CountryCode.GB);
  }

  @Test
  void getByLocaleUndefinedValue() {
    assertThat(CountryCode.getByLocale(Locale.ROOT)).isEqualTo(CountryCode.UNDEFINED);
  }

  @Test
  void getByLocaleReturnsNullWhenPassedNull() {
    assertThat(CountryCode.getByLocale(null)).isNull();
  }

  @Test
  void findByNameThrowsExceptionWhenPassedNullString() {
    String regex = null;
    assertThatThrownBy(() -> CountryCode.findByName(regex))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void findByNameThrowsExceptionWhenPassedNullPattern() {
    Pattern pattern = null;
    assertThatThrownBy(() -> CountryCode.findByName(pattern))
      .isInstanceOf(IllegalArgumentException.class);
  }
}