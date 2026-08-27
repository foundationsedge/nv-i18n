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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CurrencyCodeTest
{
    @Test
    public void test1()
    {
        assertSame(CurrencyCode.JPY, getByCode("JPY"));
    }


    @Test
    public void test2()
    {
        assertNull(getByCode("jpy"));
    }


    @Test
    public void test3()
    {
        assertSame(CurrencyCode.JPY, getByCode("JPY", true));
    }


    @Test
    public void test4()
    {
        assertNull(getByCode("jpy", true));
    }


    @Test
    public void test5()
    {
        assertSame(CurrencyCode.JPY, getByCode("JPY", false));
    }


    @Test
    public void test6()
    {
        assertSame(CurrencyCode.JPY, getByCode("jpy", false));
    }


    @Test
    public void test7()
    {
        assertNull(getByCode(null));
    }


    @Test
    public void test8()
    {
        assertNull(getByCode(""));
    }


    @Test
    public void test9()
    {
        assertNull(getByCode("???"));
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
    public void test11()
    {
        assertFalse(CurrencyCode.JPY.isPreciousMetal());

        assertTrue(CurrencyCode.XAG.isPreciousMetal());
        assertTrue(CurrencyCode.XAU.isPreciousMetal());
        assertTrue(CurrencyCode.XPD.isPreciousMetal());
        assertTrue(CurrencyCode.XPT.isPreciousMetal());
    }


    @Test
    public void test12()
    {
        List<CountryCode> list = CurrencyCode.JPY.getCountryList();

        assertTrue(list.size() == 1);
        assertSame(CountryCode.JP, list.get(0));
    }


    @Test
    public void test13()
    {
        List<CountryCode> list = CurrencyCode.XXX.getCountryList();

        assertTrue(list.size() == 0);
    }


    @Test
    @SuppressWarnings("deprecation")
    public void test14()
    {
        List<CurrencyCode> list = CurrencyCode.findByName(".*Ruble");

        assertEquals(4, list.size());

        // BYN: Belarusian Ruble
        assertTrue(list.contains(CurrencyCode.BYN));

        // BYR: Belarusian Ruble
        assertTrue(list.contains(CurrencyCode.BYR));

        // RUB: Russian Ruble
        assertTrue(list.contains(CurrencyCode.RUB));

        // RUR: Russian Ruble before the 1998 denomination
        assertTrue(list.contains(CurrencyCode.RUR));
    }


    @Test
    public void test15()
    {
        assertSame(CurrencyCode.UNDEFINED, getByCode("UNDEFINED"));
    }


    @Test
    public void test16()
    {
        assertNull(getByCode("undefined"));
    }


    @Test
    public void test17()
    {
        assertSame(CurrencyCode.UNDEFINED, getByCode("undefined", false));
    }

    @Test
    @SuppressWarnings("deprecation")
    public void test18()
    {
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

        assertTrue(deprecated.containsAll(deprecatedCurrencies));
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
