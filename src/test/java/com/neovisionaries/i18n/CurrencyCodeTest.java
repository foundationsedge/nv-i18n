/*
 * Copyright (C) 2014 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neovisionaries.i18n;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static com.neovisionaries.i18n.CurrencyCode.getByCode;
import static org.assertj.core.api.Assertions.assertThat;

class CurrencyCodeTest {
  @Test
  public void getCurrencyReturnsSameInstanceAsJavaCurrency() {
    assertThat(getByCode("JPY").getCurrency()).isSameAs(Currency.getInstance("JPY"));
  }


  @Test
  public void getByCodeLowerCaseReturnsNull() {
    assertThat(getByCode("jpy")).isNull();
  }


  @Test
  public void getByCodeCaseSensitiveUpperCaseReturnsCode() {
    assertThat(getByCode("JPY", true)).isSameAs(CurrencyCode.JPY);
  }


  @Test
  public void getByCodeCaseSensitiveLowerCaseReturnsNull() {
    assertThat(getByCode("jpy", true)).isNull();
  }


  @Test
  public void getByCodeCaseInsensitiveUpperCaseReturnsCode() {
    assertThat(getByCode("JPY", false)).isSameAs(CurrencyCode.JPY);
  }


  @Test
  public void getByCodeCaseInsensitiveLowerCaseReturnsCode() {
    assertThat(getByCode("jpy", false)).isSameAs(CurrencyCode.JPY);
  }


  @Test
  public void getByCodeNullReturnsNull() {
    assertThat(getByCode(null)).isNull();
  }


  @Test
  public void getByCodeEmptyStringReturnsNull() {
    assertThat(getByCode("")).isNull();
  }


  @Test
  public void getByCodeUnknownCodeReturnsNull() {
    assertThat(getByCode("???")).isNull();
  }


  @Test
  @SuppressWarnings("deprecation")
  void checkAllFunds() {
    assertThat(CurrencyCode.JPY.isFund()).isFalse();

    assertThat(CurrencyCode.BOV.isFund()).isTrue();
    assertThat(CurrencyCode.CHE.isFund()).isTrue();
    assertThat(CurrencyCode.CHW.isFund()).isTrue();
    assertThat(CurrencyCode.CLF.isFund()).isTrue();
    assertThat(CurrencyCode.COU.isFund()).isTrue();
    assertThat(CurrencyCode.MXV.isFund()).isTrue();
    assertThat(CurrencyCode.USN.isFund()).isTrue();
    assertThat(CurrencyCode.USS.isFund()).isTrue();
    assertThat(CurrencyCode.UYI.isFund()).isTrue();
    assertThat(CurrencyCode.UYW.isFund()).isTrue();
  }


  @Test
  public void checkAllPreciousMetals() {
    assertThat(CurrencyCode.JPY.isPreciousMetal()).isFalse();

    assertThat(CurrencyCode.XAG.isPreciousMetal()).isTrue();
    assertThat(CurrencyCode.XAU.isPreciousMetal()).isTrue();
    assertThat(CurrencyCode.XPD.isPreciousMetal()).isTrue();
    assertThat(CurrencyCode.XPT.isPreciousMetal()).isTrue();
  }


  @Test
  public void getCountryListReturnsSingleCountryForJpy() {
    List<CountryCode> list = CurrencyCode.JPY.getCountryList();

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.get(0)).isSameAs(CountryCode.JP);
  }


  @Test
  public void getCountryListIsEmptyForXxx() {
    List<CountryCode> list = CurrencyCode.XXX.getCountryList();

    assertThat(list.size()).isEqualTo(0);
  }


  @Test
  @SuppressWarnings("deprecation")
  public void findByNameMatchesAllRubleCurrencies() {
    List<CurrencyCode> list = CurrencyCode.findByName(".*Ruble");

    assertThat(list.size()).isEqualTo(4);

    // BYN: Belarusian Ruble
    assertThat(list).contains(CurrencyCode.BYN);

    // BYR: Belarusian Ruble
    assertThat(list).contains(CurrencyCode.BYR);

    // RUB: Russian Ruble
    assertThat(list).contains(CurrencyCode.RUB);

    // RUR: Russian Ruble before the 1998 denomination
    assertThat(list).contains(CurrencyCode.RUR);
  }


  @Test
  public void getByCodeUndefinedReturnsUndefinedCode() {
    assertThat(getByCode("UNDEFINED")).isSameAs(CurrencyCode.UNDEFINED);
  }


  @Test
  public void getByCodeLowerCaseUndefinedReturnsNull() {
    assertThat(getByCode("undefined")).isNull();
  }


  @Test
  public void getByCodeCaseInsensitiveLowerCaseUndefinedReturnsUndefinedCode() {
    assertThat(getByCode("undefined", false)).isSameAs(CurrencyCode.UNDEFINED);
  }

  @Test
  @SuppressWarnings("deprecation")
  public void deprecatedCurrenciesAreAnnotatedAsDeprecated() {
    List<CurrencyCode> deprecated = Arrays.stream(CurrencyCode.values()).filter(value -> {
      try {
        Field field = CurrencyCode.class.getField(value.name());
        return field.isAnnotationPresent(Deprecated.class);
      } catch (NoSuchFieldException | SecurityException e) {
        return false;
      }
    }).collect(Collectors.toList());

    ArrayList<CurrencyCode> deprecatedCurrencies = new ArrayList<>();
    deprecatedCurrencies.add(CurrencyCode.BYR);
    deprecatedCurrencies.add(CurrencyCode.MRO);
    deprecatedCurrencies.add(CurrencyCode.STD);
    deprecatedCurrencies.add(CurrencyCode.RUR);
    deprecatedCurrencies.add(CurrencyCode.LTL);
    deprecatedCurrencies.add(CurrencyCode.VEF);

    assertThat(deprecated).containsAll(deprecatedCurrencies);
  }

  @Test
  void getNumericValue() {
    assertThat(CurrencyCode.GBP.getNumeric()).isEqualTo(826);
  }

  @Test
  void getMinorUnitValue() {
    assertThat(CurrencyCode.GBP.getMinorUnit()).isEqualTo(2);
  }

  @Test
  void getCurrencyValue() {
    assertThat(CurrencyCode.GBP.getCurrency()).isEqualTo(Currency.getInstance("GBP"));
  }

  @Test
  void getByCodeValidValue() {
    assertThat(CurrencyCode.getByCode("GBP")).isEqualTo(CurrencyCode.GBP);
  }

  @Test
  void canonicalizeIsNullWhenCodeIsNull() {
    assertThat(CurrencyCode.getByCode(null)).isNull();
  }

  @Test
  void canonicalizeIsNullWhenCodeLengthIsZero() {
    assertThat(CurrencyCode.getByCode("")).isNull();
  }

  @Test
  void getByCodeIgnoreCaseValidValue() {
    assertThat(CurrencyCode.getByCodeIgnoreCase("gbp")).isEqualTo(CurrencyCode.GBP);
  }

  @Test
  void getByCodeValidNumericalValue() {
    assertThat(CurrencyCode.getByCode(826)).isEqualTo(CurrencyCode.GBP);
  }

  @Test
  void getByCodeBoundaryNumericalValue() {
    assertThat(CurrencyCode.getByCode(0)).isNull();
  }

  @Test
  void getByCodeBelowBoundaryNumericalValue() {
    assertThat(CurrencyCode.getByCode(-1)).isNull();
  }

  @Test
  void getByCountryValidValue() {
    List<CurrencyCode> codes = new ArrayList<>();
    codes.add(CurrencyCode.GBP);

    assertThat(CurrencyCode.getByCountry(CountryCode.GB)).isEqualTo(codes);
  }

  @Test
  void getByCountryWithNullReturnsEmptyList() {
    List<CurrencyCode> codes = Collections.emptyList();
    CountryCode country = null;

    assertThat(CurrencyCode.getByCountry(country)).isEqualTo(codes);
  }

  @Test
  void getByCountryValidValueString() {
    List<CurrencyCode> codes = new ArrayList<>();
    codes.add(CurrencyCode.GBP);

    assertThat(CurrencyCode.getByCountry("GB")).isEqualTo(codes);
  }

  @Test
  void getByCountryIgnoreCaseValidValueString() {
    List<CurrencyCode> codes = new ArrayList<>();
    codes.add(CurrencyCode.GBP);

    assertThat(CurrencyCode.getByCountryIgnoreCase("gb")).isEqualTo(codes);
  }
}
