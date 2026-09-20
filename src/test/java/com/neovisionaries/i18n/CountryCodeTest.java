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
import org.junit.jupiter.api.Test;
import static com.neovisionaries.i18n.CountryCode.getByCode;
import static com.neovisionaries.i18n.CountryCode.getByCodeIgnoreCase;
import static com.neovisionaries.i18n.CountryCode.getByLocale;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CountryCodeTest {
  @Test
  public void findByNameWithUnitedRegexReturnsMatchingCountryCodes() {
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
  public void toLocaleWithCaReturnsLocaleCanada() {
    assertThat(CountryCode.CA.toLocale()).isEqualTo(Locale.CANADA);
  }


  @Test
  public void toLocaleWithCnReturnsLocaleChina() {
    assertThat(CountryCode.CN.toLocale()).isEqualTo(Locale.CHINA);
  }


  @Test
  public void toLocaleWithDeReturnsLocaleGermany() {
    assertThat(CountryCode.DE.toLocale()).isEqualTo(Locale.GERMANY);
  }


  @Test
  public void toLocaleWithFrReturnsLocaleFrance() {
    assertThat(CountryCode.FR.toLocale()).isEqualTo(Locale.FRANCE);
  }


  @Test
  public void toLocaleWithGbReturnsLocaleUk() {
    assertThat(CountryCode.GB.toLocale()).isEqualTo(Locale.UK);
  }


  @Test
  public void toLocaleWithItReturnsLocaleItaly() {
    assertThat(CountryCode.IT.toLocale()).isEqualTo(Locale.ITALY);
  }


  @Test
  public void toLocaleWithJpReturnsLocaleJapan() {
    assertThat(CountryCode.JP.toLocale()).isEqualTo(Locale.JAPAN);
  }


  @Test
  public void toLocaleWithKrReturnsLocaleKorea() {
    assertThat(CountryCode.KR.toLocale()).isEqualTo(Locale.KOREA);
  }


  @Test
  public void toLocaleWithTwReturnsLocaleTaiwan() {
    assertThat(CountryCode.TW.toLocale()).isEqualTo(Locale.TAIWAN);
  }


  @Test
  public void toLocaleWithUsReturnsLocaleUs() {
    assertThat(CountryCode.US.toLocale()).isEqualTo(Locale.US);

  }


  @Test
  public void toLocaleWithUndefinedReturnsRootLocale() {
    Locale undefinedLocale = CountryCode.UNDEFINED.toLocale();

    assertThatCode(() -> {
      Locale root = (Locale) Locale.class.getDeclaredField("ROOT").get(null);
      assertThat(undefinedLocale).isSameAs(root);
    }).doesNotThrowAnyException();
  }


  @Test
  public void getByCodeWithUndefinedInExactCaseReturnsUndefined() {
    assertThat(getByCode("UNDEFINED")).isSameAs(CountryCode.UNDEFINED);
  }

  @Test
  public void getByCodeWithUndefinedInMismatchedCaseReturnsNull() {
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
  public void getByCodeIgnoreCaseWithUndefinedReturnsUndefined() {
    assertThat(getByCodeIgnoreCase("undefined")).isSameAs(CountryCode.UNDEFINED);
  }

  @Test
  @SuppressWarnings("deprecation")
  public void getByLocaleWithEmptyLocaleReturnsUndefined() {
    assertThat(getByLocale(new Locale("", ""))).isSameAs(CountryCode.UNDEFINED);
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
  public void getByCodeWithTransitionallyReservedAntReturnsAn() {
    assertThat(CountryCode.getByCode("ANT")).isSameAs(CountryCode.AN);
  }

  @Test
  public void getByCodeWithTransitionallyReservedAnhhReturnsAn() {
    assertThat(CountryCode.getByCode("ANHH")).isSameAs(CountryCode.AN);
  }

  @Test
  public void getByCodeWithTransitionallyReservedBurReturnsBu() {
    assertThat(CountryCode.getByCode("BUR")).isSameAs(CountryCode.BU);
  }

  @Test
  public void getByCodeWithTransitionallyReservedBummReturnsBu() {
    assertThat(CountryCode.getByCode("BUMM")).isSameAs(CountryCode.BU);
  }

  @Test
  public void getByCodeWithTransitionallyReservedScgReturnsCs() {
    assertThat(CountryCode.getByCode("SCG")).isSameAs(CountryCode.CS);
  }

  @Test
  public void getByCodeWithTransitionallyReservedCsxxReturnsCs() {
    assertThat(CountryCode.getByCode("CSXX")).isSameAs(CountryCode.CS);
  }

  @Test
  public void getByCodeWithTransitionallyReservedNtzReturnsNt() {
    assertThat(CountryCode.getByCode("NTZ")).isSameAs(CountryCode.NT);
  }

  @Test
  public void getByCodeWithTransitionallyReservedNthhReturnsNt() {
    assertThat(CountryCode.getByCode("NTHH")).isSameAs(CountryCode.NT);
  }

  @Test
  public void getByCodeWithTransitionallyReservedTmpReturnsTp() {
    assertThat(CountryCode.getByCode("TMP")).isSameAs(CountryCode.TP);
  }

  @Test
  public void getByCodeWithTransitionallyReservedTptlReturnsTp() {
    assertThat(CountryCode.getByCode("TPTL")).isSameAs(CountryCode.TP);
  }

  @Test
  public void getByCodeWithTransitionallyReservedYugReturnsYu() {
    assertThat(CountryCode.getByCode("YUG")).isSameAs(CountryCode.YU);
  }

  @Test
  public void getByCodeWithTransitionallyReservedYucsReturnsYu() {
    assertThat(CountryCode.getByCode("YUCS")).isSameAs(CountryCode.YU);
  }

  @Test
  public void getByCodeWithTransitionallyReservedZarReturnsZr() {
    assertThat(CountryCode.getByCode("ZAR")).isSameAs(CountryCode.ZR);
  }

  @Test
  public void getByCodeWithTransitionallyReservedZrcdReturnsZr() {
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
  public void getByCodeWithAlpha3FinReturnsFi() {
    assertThat(CountryCode.getByCode("FIN")).isSameAs(CountryCode.FI);
  }

  @Test
  public void getByCodeWithNumeric104ReturnsMm() {
    assertThat(CountryCode.getByCode(104)).isSameAs(CountryCode.MM);
  }

  @Test
  public void getByCodeWithNumeric180ReturnsCd() {
    assertThat(CountryCode.getByCode(180)).isSameAs(CountryCode.CD);
  }

  @Test
  public void getByCodeWithNumeric246ReturnsFi() {
    assertThat(CountryCode.getByCode(246)).isSameAs(CountryCode.FI);
  }

  @Test
  public void getByCodeWithNumeric826ReturnsGb() {
    assertThat(CountryCode.getByCode(826)).isSameAs(CountryCode.GB);
  }

  @Test
  public void getByCodeWithNumeric626ReturnsTl() {
    assertThat(CountryCode.getByCode(626)).isSameAs(CountryCode.TL);
  }

  @Test
  public void getByCodeWithNumeric392ReturnsJp() {
    assertThat(CountryCode.getByCode(392)).isSameAs(CountryCode.JP);
  }

  @Test
  public void getNumericReturnsExpectedValuesForWithdrawnCodes() {
    assertThat(CountryCode.FX.getNumeric()).isEqualTo(249);
    assertThat(CountryCode.SU.getNumeric()).isEqualTo(810);
    assertThat(CountryCode.TP.getNumeric()).isEqualTo(626);
    assertThat(CountryCode.UK.getNumeric()).isEqualTo(826);
    assertThat(CountryCode.ZR.getNumeric()).isEqualTo(180);
  }

  @Test
  public void getByCodeWithNumeric280ReturnsDe() {
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
}