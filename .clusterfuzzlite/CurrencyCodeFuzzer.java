/*
 * Copyright (C) 2026 The nv-i18n Contributors.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyCodeFuzzer {
  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    String country = data.consumeRemainingAsString();

    List<CurrencyCode> currencies = CurrencyCode.getByCountry(country);

    assertThat(currencies).isNotNull();

    CountryCode countryCode = CountryCode.getByCode(country, true);
    for (CurrencyCode currency : currencies) {
      assertThat(currency.getCountryList()).contains(countryCode);
    }
  }
}
