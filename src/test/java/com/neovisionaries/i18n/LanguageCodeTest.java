/*
 * Copyright (C) 2012-2014 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;

import static com.neovisionaries.i18n.LanguageCode.getByCode;
import static com.neovisionaries.i18n.LanguageCode.getByCodeIgnoreCase;
import static com.neovisionaries.i18n.LanguageCode.getByLocale;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LanguageCodeTest {
  @Test
  public void test1() {
    assertSame(LanguageCode.ja, getByCode("ja"));
  }


  @Test
  public void test2() {
    assertNull(getByCode("JA"));
  }


  @Test
  public void test3() {
    assertSame(LanguageCode.ja, getByCode("ja", true));
  }


  @Test
  public void test4() {
    assertNull(getByCode("JA", true));
  }


  @Test
  public void test5() {
    assertSame(LanguageCode.ja, getByCode("ja", false));
  }


  @Test
  public void test6() {
    assertSame(LanguageCode.ja, getByCode("JA", false));
  }


  @Test
  public void test7() {
    assertNull(getByCode(null));
  }


  @Test
  public void test8() {
    assertNull(getByCode(""));
  }


  @Test
  public void test9() {
    assertNull(getByCode("?"));
  }


  @Test
  public void test10() {
    assertNull(getByCode("??"));
  }


  @Test
  public void test11() {
    assertNull(getByCode("???"));
  }


  @Test
  public void test12() {
    assertNull(getByCode("????"));
  }


  @Test
  public void test13() {
    assertSame(LanguageCode.he, getByCode("he"));
  }


  @Test
  public void test14() {
    assertSame(LanguageCode.he, getByCode("iw"));
  }


  @Test
  public void test15() {
    assertSame(LanguageCode.yi, getByCode("yi"));
  }


  @Test
  public void test16() {
    assertSame(LanguageCode.yi, getByCode("ji"));
  }


  @Test
  public void test17() {
    assertSame(LanguageCode.id, getByCode("id"));
  }


  @Test
  public void test18() {
    assertSame(LanguageCode.id, getByCode("in"));
  }


  @Test
  public void test19() {
    assertSame(Locale.GERMAN, LanguageCode.de.toLocale());
  }


  @Test
  public void test20() {
    assertSame(Locale.ENGLISH, LanguageCode.en.toLocale());
  }


  @Test
  public void test21() {
    assertSame(Locale.FRENCH, LanguageCode.fr.toLocale());
  }


  @Test
  public void test22() {
    assertSame(Locale.ITALIAN, LanguageCode.it.toLocale());
  }


  @Test
  public void test23() {
    assertSame(Locale.JAPANESE, LanguageCode.ja.toLocale());
  }


  @Test
  public void test24() {
    assertSame(Locale.KOREAN, LanguageCode.ko.toLocale());
  }


  @Test
  public void test25() {
    assertSame(Locale.CHINESE, LanguageCode.zh.toLocale());
  }


  @Test
  public void test26() {
    assertNull(getByLocale(null));
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test27() {
    assertSame(LanguageCode.undefined, getByLocale(new Locale("")));
  }


  @Test
  public void test28() {
    assertSame(LanguageCode.fr, getByLocale(Locale.CANADA_FRENCH));
  }


  @Test
  public void test29() {
    assertSame(LanguageCode.zh, getByLocale(Locale.CHINESE));
  }


  @Test
  public void test30() {
    assertSame(LanguageCode.en, getByLocale(Locale.ENGLISH));
  }


  @Test
  public void test31() {
    assertSame(LanguageCode.fr, getByLocale(Locale.FRENCH));
  }


  @Test
  public void test32() {
    assertSame(LanguageCode.de, getByLocale(Locale.GERMAN));
  }


  @Test
  public void test33() {
    assertSame(LanguageCode.it, getByLocale(Locale.ITALIAN));
  }


  @Test
  public void test34() {
    assertSame(LanguageCode.ja, getByLocale(Locale.JAPANESE));
  }


  @Test
  public void test35() {
    assertSame(LanguageCode.ko, getByLocale(Locale.KOREAN));
  }


  @Test
  public void test36() {
    assertSame(LanguageCode.zh, getByLocale(Locale.SIMPLIFIED_CHINESE));
  }


  @Test
  public void test37() {
    assertSame(LanguageCode.zh, getByLocale(Locale.TRADITIONAL_CHINESE));
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test38() {
    assertSame(LanguageCode.ja, getByLocale(new Locale("ja")));
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test39() {
    assertSame(LanguageCode.ja, getByLocale(new Locale("ja", "JP")));
  }


  @Test
  public void test40() {
    assertSame(LanguageCode.bo, getByCode("bo"));
  }


  @Test
  public void test41() {
    assertSame(LanguageCode.bo, getByCode("bod"));
  }


  @Test
  public void test42() {
    assertSame(LanguageCode.bo, getByCode("tib"));
  }


  @Test
  public void test43() {
    assertSame(LanguageCode.eu, getByCode("eu"));
  }


  @Test
  public void test44() {
    assertSame(LanguageCode.eu, getByCode("eus"));
  }


  @Test
  public void test45() {
    assertSame(LanguageCode.eu, getByCode("baq"));
  }


  @Test
  public void test46() {
    assertSame(LanguageCode.cs, getByCode("cs"));
  }


  @Test
  public void test47() {
    assertSame(LanguageCode.cs, getByCode("ces"));
  }


  @Test
  public void test48() {
    assertSame(LanguageCode.cs, getByCode("cze"));
  }


  @Test
  public void test49() {
    assertSame(LanguageCode.cy, getByCode("cy"));
  }


  @Test
  public void test50() {
    assertSame(LanguageCode.cy, getByCode("cym"));
  }


  @Test
  public void test51() {
    assertSame(LanguageCode.cy, getByCode("wel"));
  }


  @Test
  public void test52() {
    assertSame(LanguageCode.de, getByCode("de"));
  }


  @Test
  public void test53() {
    assertSame(LanguageCode.de, getByCode("deu"));
  }


  @Test
  public void test54() {
    assertSame(LanguageCode.de, getByCode("ger"));
  }


  @Test
  public void test55() {
    assertSame(LanguageCode.el, getByCode("el"));
  }


  @Test
  public void test56() {
    assertSame(LanguageCode.el, getByCode("ell"));
  }


  @Test
  public void test57() {
    assertSame(LanguageCode.el, getByCode("gre"));
  }


  @Test
  public void test58() {
    assertSame(LanguageCode.fa, getByCode("fa"));
  }


  @Test
  public void test59() {
    assertSame(LanguageCode.fa, getByCode("per"));
  }


  @Test
  public void test60() {
    assertSame(LanguageCode.fa, getByCode("fas"));
  }


  @Test
  public void test61() {
    assertSame(LanguageCode.fr, getByCode("fr"));
  }


  @Test
  public void test62() {
    assertSame(LanguageCode.fr, getByCode("fra"));
  }


  @Test
  public void test63() {
    assertSame(LanguageCode.fr, getByCode("fre"));
  }


  @Test
  public void test64() {
    assertSame(LanguageCode.hy, getByCode("hy"));
  }


  @Test
  public void test65() {
    assertSame(LanguageCode.hy, getByCode("hye"));
  }


  @Test
  public void test66() {
    assertSame(LanguageCode.hy, getByCode("arm"));
  }


  @Test
  public void test67() {
    assertSame(LanguageCode.is, getByCode("is"));
  }


  @Test
  public void test68() {
    assertSame(LanguageCode.is, getByCode("isl"));
  }


  @Test
  public void test69() {
    assertSame(LanguageCode.is, getByCode("ice"));
  }


  @Test
  public void test70() {
    assertSame(LanguageCode.ka, getByCode("ka"));
  }


  @Test
  public void test71() {
    assertSame(LanguageCode.ka, getByCode("kat"));
  }


  @Test
  public void test72() {
    assertSame(LanguageCode.ka, getByCode("geo"));
  }


  @Test
  public void test73() {
    assertSame(LanguageCode.mi, getByCode("mi"));
  }


  @Test
  public void test74() {
    assertSame(LanguageCode.mi, getByCode("mri"));
  }


  @Test
  public void test75() {
    assertSame(LanguageCode.mi, getByCode("mao"));
  }


  @Test
  public void test76() {
    assertSame(LanguageCode.mk, getByCode("mk"));
  }


  @Test
  public void test77() {
    assertSame(LanguageCode.mk, getByCode("mkd"));
  }


  @Test
  public void test78() {
    assertSame(LanguageCode.mk, getByCode("mac"));
  }


  @Test
  public void test79() {
    assertSame(LanguageCode.ms, getByCode("ms"));
  }


  @Test
  public void test80() {
    assertSame(LanguageCode.ms, getByCode("msa"));
  }


  @Test
  public void test81() {
    assertSame(LanguageCode.ms, getByCode("may"));
  }


  @Test
  public void test82() {
    assertSame(LanguageCode.my, getByCode("my"));
  }


  @Test
  public void test83() {
    assertSame(LanguageCode.my, getByCode("mya"));
  }


  @Test
  public void test84() {
    assertSame(LanguageCode.my, getByCode("bur"));
  }


  @Test
  public void test85() {
    assertSame(LanguageCode.nl, getByCode("nl"));
  }


  @Test
  public void test86() {
    assertSame(LanguageCode.nl, getByCode("nld"));
  }


  @Test
  public void test87() {
    assertSame(LanguageCode.nl, getByCode("dut"));
  }


  @Test
  public void test88() {
    assertSame(LanguageCode.ro, getByCode("ro"));
  }


  @Test
  public void test89() {
    assertSame(LanguageCode.ro, getByCode("ron"));
  }


  @Test
  public void test90() {
    assertSame(LanguageCode.ro, getByCode("rum"));
  }


  @Test
  public void test91() {
    assertSame(LanguageCode.sk, getByCode("sk"));
  }


  @Test
  public void test92() {
    assertSame(LanguageCode.sk, getByCode("slk"));
  }


  @Test
  public void test93() {
    assertSame(LanguageCode.sk, getByCode("slo"));
  }


  @Test
  public void test94() {
    assertSame(LanguageCode.sq, getByCode("sq"));
  }


  @Test
  public void test95() {
    assertSame(LanguageCode.sq, getByCode("sqi"));
  }


  @Test
  public void test96() {
    assertSame(LanguageCode.sq, getByCode("alb"));
  }


  @Test
  public void test97() {
    assertSame(LanguageAlpha3Code.bod, LanguageCode.bo.getAlpha3());
  }


  @Test
  public void test98() {
    assertSame(LanguageAlpha3Code.eus, LanguageCode.eu.getAlpha3());
  }


  @Test
  public void test99() {
    assertSame(LanguageAlpha3Code.ces, LanguageCode.cs.getAlpha3());
  }


  @Test
  public void test100() {
    assertSame(LanguageAlpha3Code.cym, LanguageCode.cy.getAlpha3());
  }


  @Test
  public void test101() {
    assertSame(LanguageAlpha3Code.deu, LanguageCode.de.getAlpha3());
  }


  @Test
  public void test102() {
    assertSame(LanguageAlpha3Code.ell, LanguageCode.el.getAlpha3());
  }


  @Test
  public void test103() {
    assertSame(LanguageAlpha3Code.fas, LanguageCode.fa.getAlpha3());
  }


  @Test
  public void test104() {
    assertSame(LanguageAlpha3Code.fra, LanguageCode.fr.getAlpha3());
  }


  @Test
  public void test105() {
    assertSame(LanguageAlpha3Code.hye, LanguageCode.hy.getAlpha3());
  }


  @Test
  public void test106() {
    assertSame(LanguageAlpha3Code.isl, LanguageCode.is.getAlpha3());
  }


  @Test
  public void test107() {
    assertSame(LanguageAlpha3Code.kat, LanguageCode.ka.getAlpha3());
  }


  @Test
  public void test108() {
    assertSame(LanguageAlpha3Code.mri, LanguageCode.mi.getAlpha3());
  }


  @Test
  public void test109() {
    assertSame(LanguageAlpha3Code.mkd, LanguageCode.mk.getAlpha3());
  }


  @Test
  public void test110() {
    assertSame(LanguageAlpha3Code.msa, LanguageCode.ms.getAlpha3());
  }


  @Test
  public void test111() {
    assertSame(LanguageAlpha3Code.mya, LanguageCode.my.getAlpha3());
  }


  @Test
  public void test112() {
    assertSame(LanguageAlpha3Code.nld, LanguageCode.nl.getAlpha3());
  }


  @Test
  public void test113() {
    assertSame(LanguageAlpha3Code.ron, LanguageCode.ro.getAlpha3());
  }


  @Test
  public void test114() {
    assertSame(LanguageAlpha3Code.slk, LanguageCode.sk.getAlpha3());
  }


  @Test
  public void test115() {
    assertSame(LanguageAlpha3Code.sqi, LanguageCode.sq.getAlpha3());
  }


  @Test
  public void test116() {
    assertSame(LanguageAlpha3Code.jpn, LanguageCode.ja.getAlpha3());
  }


  @Test
  public void test117() {
    assertSame("Japanese", LanguageCode.ja.getName());
  }


  @Test
  public void test118() {
    List<LanguageCode> list = LanguageCode.findByName(".*nese");

    assertEquals(5, list.size());

    // an : Aragonese
    assertTrue(list.contains(LanguageCode.an));

    // ja : Japanese
    assertTrue(list.contains(LanguageCode.ja));

    // jv : Javanese
    assertTrue(list.contains(LanguageCode.jv));

    // su : Sudanese
    assertTrue(list.contains(LanguageCode.su));

    // zh : Chinese
    assertTrue(list.contains(LanguageCode.zh));
  }


  @Test
  public void test119() {
    assertSame(LanguageCode.undefined, getByCode("undefined"));
  }


  @Test
  public void test120() {
    assertNull(getByCode("UNDEFINED"));
  }


  @Test
  public void test121() {
    assertSame(LanguageCode.undefined, getByCode("UNDEFINED", false));
  }

  @Test
  public void getByCodeIgnoreCaseUpperCase() {
    assertThat(getByCodeIgnoreCase("FR")).isEqualTo(LanguageCode.fr);
  }

  @Test
  public void getByCodeIgnoreCaseMixedCase() {
    assertThat(getByCodeIgnoreCase("fR")).isEqualTo(LanguageCode.fr);
  }

  @Test
  @SuppressWarnings("deprecation")
  public void toLocaleForLanguageWithoutOverride() {
    assertThat(LanguageCode.cs.toLocale()).isEqualTo(new Locale("cs"));
  }

  @Test
  public void getNameNeverThrowsNullPointerException() {
    // getName() must tolerate getAlpha3() returning null (avoids NPE).
    for (LanguageCode code : LanguageCode.values()) {
      code.getName();
    }

    assertThat(LanguageCode.ja.getName()).isEqualTo("Japanese");
    assertThat(LanguageCode.undefined.getName()).isEqualTo("Undefined");
  }


  /**
   * The complete set of ISO 639-1 alpha-2 codes.
   *
   * <p>
   * This excludes the codes withdrawn from the standard ("mo", withdrawn in
   * 2008) and the obsolete codes that {@code java.util.Locale} still reports
   * ("in", "iw" and "ji"); the latter are handled by {@link
   * LanguageCode#getByCode(String)} as aliases of "id", "he" and "yi".
   * </p>
   */
  private static final String[] ISO_639_1_CODES =
      ("aa ab ae af ak am an ar as av ay az ba be bg bh bi bm bn bo br bs " +
       "ca ce ch co cr cs cu cv cy da de dv dz ee el en eo es et eu fa ff " +
       "fi fj fo fr fy ga gd gl gn gu gv ha he hi ho hr ht hu hy hz ia id " +
       "ie ig ii ik io is it iu ja jv ka kg ki kj kk kl km kn ko kr ks ku " +
       "kv kw ky la lb lg li ln lo lt lu lv mg mh mi mk ml mn mr ms mt my " +
       "na nb nd ne ng nl nn no nr nv ny oc oj om or os pa pi pl ps pt qu " +
       "rm rn ro ru rw sa sc sd se sg si sk sl sm sn so sq sr ss st su sv " +
       "sw ta te tg th ti tk tl tn to tr ts tt tw ty ug uk ur uz ve vi vo " +
       "wa wo xh yi yo za zh zu").split(" ");


  @Test
  void enumCoversExactlyTheIso639_1CodeSet() {
    List<String> names = new ArrayList<String>();

    for (LanguageCode code : LanguageCode.values()) {
      if (code != LanguageCode.undefined) {
        names.add(code.name());
      }
    }

    assertThat(names).containsExactlyInAnyOrder(ISO_639_1_CODES);
  }


  @Test
  void everyIso639_1CodeIsResolvableByGetByCode() {
    for (String code : ISO_639_1_CODES) {
      assertThat(getByCode(code)).as(code).isNotNull();
    }
  }


  @Test
  void everyCodeMapsToAnAlpha3CodeThatMapsBack() {
    for (LanguageCode code : LanguageCode.values()) {
      LanguageAlpha3Code alpha3 = code.getAlpha3();

      assertThat(alpha3).as(code.name()).isNotNull();
      assertThat(alpha3.getUsage()).as(code.name())
          .isNotEqualTo(LanguageAlpha3Code.Usage.BIBLIOGRAPHY);
      assertThat(alpha3.getAlpha2()).as(code.name()).isSameAs(code);
    }
  }


  @Test
  void everyCodeHasANonEmptyName() {
    for (LanguageCode code : LanguageCode.values()) {
      assertThat(code.getName()).as(code.name()).isNotEmpty();
    }
  }


  @Test
  void getNameForCornish() {
    assertThat(LanguageCode.kw.getName()).isEqualTo("Cornish");
  }


  @Test
  void getNameForBasque() {
    assertThat(LanguageCode.eu.getName()).isEqualTo("Basque");
  }
}
