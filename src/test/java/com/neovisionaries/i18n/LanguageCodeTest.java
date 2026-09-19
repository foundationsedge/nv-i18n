/*
 * Copyright (C) 2012-2014 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

import static com.neovisionaries.i18n.LanguageCode.getByCode;
import static com.neovisionaries.i18n.LanguageCode.getByCodeIgnoreCase;
import static com.neovisionaries.i18n.LanguageCode.getByLocale;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LanguageCodeTest {
  @Test
  public void test1() {
    assertThat(getByCode("ja")).isSameAs(LanguageCode.ja);
  }


  @Test
  public void test2() {
    assertThat(getByCode("JA")).isNull();
  }


  @Test
  public void test3() {
    assertThat(getByCode("ja", true)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void test4() {
    assertThat(getByCode("JA", true)).isNull();
  }


  @Test
  public void test5() {
    assertThat(getByCode("ja", false)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void test6() {
    assertThat(getByCode("JA", false)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void test7() {
    assertThat(getByCode(null)).isNull();
  }


  @Test
  public void test8() {
    assertThat(getByCode("")).isNull();
  }


  @Test
  public void test9() {
    assertThat(getByCode("?")).isNull();
  }


  @Test
  public void test10() {
    assertThat(getByCode("??")).isNull();
  }


  @Test
  public void test11() {
    assertThat(getByCode("???")).isNull();
  }


  @Test
  public void test12() {
    assertThat(getByCode("????")).isNull();
  }


  @Test
  public void test13() {
    assertThat(getByCode("he")).isSameAs(LanguageCode.he);
  }


  @Test
  public void test14() {
    assertThat(getByCode("iw")).isSameAs(LanguageCode.he);
  }


  @Test
  public void test15() {
    assertThat(getByCode("yi")).isSameAs(LanguageCode.yi);
  }


  @Test
  public void test16() {
    assertThat(getByCode("ji")).isSameAs(LanguageCode.yi);
  }


  @Test
  public void test17() {
    assertThat(getByCode("id")).isSameAs(LanguageCode.id);
  }


  @Test
  public void test18() {
    assertThat(getByCode("in")).isSameAs(LanguageCode.id);
  }


  @Test
  public void test19() {
    assertThat(LanguageCode.de.toLocale()).isSameAs(Locale.GERMAN);
  }


  @Test
  public void test20() {
    assertThat(LanguageCode.en.toLocale()).isSameAs(Locale.ENGLISH);
  }


  @Test
  public void test21() {
    assertThat(LanguageCode.fr.toLocale()).isSameAs(Locale.FRENCH);
  }


  @Test
  public void test22() {
    assertThat(LanguageCode.it.toLocale()).isSameAs(Locale.ITALIAN);
  }


  @Test
  public void test23() {
    assertThat(LanguageCode.ja.toLocale()).isSameAs(Locale.JAPANESE);
  }


  @Test
  public void test24() {
    assertThat(LanguageCode.ko.toLocale()).isSameAs(Locale.KOREAN);
  }


  @Test
  public void test25() {
    assertThat(LanguageCode.zh.toLocale()).isSameAs(Locale.CHINESE);
  }


  @Test
  public void test26() {
    assertThat(getByLocale(null)).isNull();
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test27() {
    assertThat(getByLocale(new Locale(""))).isSameAs(LanguageCode.undefined);
  }


  @Test
  public void test28() {
    assertThat(getByLocale(Locale.CANADA_FRENCH)).isSameAs(LanguageCode.fr);
  }


  @Test
  public void test29() {
    assertThat(getByLocale(Locale.CHINESE)).isSameAs(LanguageCode.zh);
  }


  @Test
  public void test30() {
    assertThat(getByLocale(Locale.ENGLISH)).isSameAs(LanguageCode.en);
  }


  @Test
  public void test31() {
    assertThat(getByLocale(Locale.FRENCH)).isSameAs(LanguageCode.fr);
  }


  @Test
  public void test32() {
    assertThat(getByLocale(Locale.GERMAN)).isSameAs(LanguageCode.de);
  }


  @Test
  public void test33() {
    assertThat(getByLocale(Locale.ITALIAN)).isSameAs(LanguageCode.it);
  }


  @Test
  public void test34() {
    assertThat(getByLocale(Locale.JAPANESE)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void test35() {
    assertThat(getByLocale(Locale.KOREAN)).isSameAs(LanguageCode.ko);
  }


  @Test
  public void test36() {
    assertThat(getByLocale(Locale.SIMPLIFIED_CHINESE)).isSameAs(LanguageCode.zh);
  }


  @Test
  public void test37() {
    assertThat(getByLocale(Locale.TRADITIONAL_CHINESE)).isSameAs(LanguageCode.zh);
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test38() {
    assertThat(getByLocale(new Locale("ja"))).isSameAs(LanguageCode.ja);
  }


  @Test
  @SuppressWarnings("deprecation")
  public void test39() {
    assertThat(getByLocale(new Locale("ja", "JP"))).isSameAs(LanguageCode.ja);
  }


  @Test
  public void test40() {
    assertThat(getByCode("bo")).isSameAs(LanguageCode.bo);
  }


  @Test
  public void test41() {
    assertThat(getByCode("bod")).isSameAs(LanguageCode.bo);
  }


  @Test
  public void test42() {
    assertThat(getByCode("tib")).isSameAs(LanguageCode.bo);
  }


  @Test
  public void test43() {
    assertThat(getByCode("eu")).isSameAs(LanguageCode.eu);
  }


  @Test
  public void test44() {
    assertThat(getByCode("eus")).isSameAs(LanguageCode.eu);
  }


  @Test
  public void test45() {
    assertThat(getByCode("baq")).isSameAs(LanguageCode.eu);
  }


  @Test
  public void test46() {
    assertThat(getByCode("cs")).isSameAs(LanguageCode.cs);
  }


  @Test
  public void test47() {
    assertThat(getByCode("ces")).isSameAs(LanguageCode.cs);
  }


  @Test
  public void test48() {
    assertThat(getByCode("cze")).isSameAs(LanguageCode.cs);
  }


  @Test
  public void test49() {
    assertThat(getByCode("cy")).isSameAs(LanguageCode.cy);
  }


  @Test
  public void test50() {
    assertThat(getByCode("cym")).isSameAs(LanguageCode.cy);
  }


  @Test
  public void test51() {
    assertThat(getByCode("wel")).isSameAs(LanguageCode.cy);
  }


  @Test
  public void test52() {
    assertThat(getByCode("de")).isSameAs(LanguageCode.de);
  }


  @Test
  public void test53() {
    assertThat(getByCode("deu")).isSameAs(LanguageCode.de);
  }


  @Test
  public void test54() {
    assertThat(getByCode("ger")).isSameAs(LanguageCode.de);
  }


  @Test
  public void test55() {
    assertThat(getByCode("el")).isSameAs(LanguageCode.el);
  }


  @Test
  public void test56() {
    assertThat(getByCode("ell")).isSameAs(LanguageCode.el);
  }


  @Test
  public void test57() {
    assertThat(getByCode("gre")).isSameAs(LanguageCode.el);
  }


  @Test
  public void test58() {
    assertThat(getByCode("fa")).isSameAs(LanguageCode.fa);
  }


  @Test
  public void test59() {
    assertThat(getByCode("per")).isSameAs(LanguageCode.fa);
  }


  @Test
  public void test60() {
    assertThat(getByCode("fas")).isSameAs(LanguageCode.fa);
  }


  @Test
  public void test61() {
    assertThat(getByCode("fr")).isSameAs(LanguageCode.fr);
  }


  @Test
  public void test62() {
    assertThat(getByCode("fra")).isSameAs(LanguageCode.fr);
  }


  @Test
  public void test63() {
    assertThat(getByCode("fre")).isSameAs(LanguageCode.fr);
  }


  @Test
  public void test64() {
    assertThat(getByCode("hy")).isSameAs(LanguageCode.hy);
  }


  @Test
  public void test65() {
    assertThat(getByCode("hye")).isSameAs(LanguageCode.hy);
  }


  @Test
  public void test66() {
    assertThat(getByCode("arm")).isSameAs(LanguageCode.hy);
  }


  @Test
  public void test67() {
    assertThat(getByCode("is")).isSameAs(LanguageCode.is);
  }


  @Test
  public void test68() {
    assertThat(getByCode("isl")).isSameAs(LanguageCode.is);
  }


  @Test
  public void test69() {
    assertThat(getByCode("ice")).isSameAs(LanguageCode.is);
  }


  @Test
  public void test70() {
    assertThat(getByCode("ka")).isSameAs(LanguageCode.ka);
  }


  @Test
  public void test71() {
    assertThat(getByCode("kat")).isSameAs(LanguageCode.ka);
  }


  @Test
  public void test72() {
    assertThat(getByCode("geo")).isSameAs(LanguageCode.ka);
  }


  @Test
  public void test73() {
    assertThat(getByCode("mi")).isSameAs(LanguageCode.mi);
  }


  @Test
  public void test74() {
    assertThat(getByCode("mri")).isSameAs(LanguageCode.mi);
  }


  @Test
  public void test75() {
    assertThat(getByCode("mao")).isSameAs(LanguageCode.mi);
  }


  @Test
  public void test76() {
    assertThat(getByCode("mk")).isSameAs(LanguageCode.mk);
  }


  @Test
  public void test77() {
    assertThat(getByCode("mkd")).isSameAs(LanguageCode.mk);
  }


  @Test
  public void test78() {
    assertThat(getByCode("mac")).isSameAs(LanguageCode.mk);
  }


  @Test
  public void test79() {
    assertThat(getByCode("ms")).isSameAs(LanguageCode.ms);
  }


  @Test
  public void test80() {
    assertThat(getByCode("msa")).isSameAs(LanguageCode.ms);
  }


  @Test
  public void test81() {
    assertThat(getByCode("may")).isSameAs(LanguageCode.ms);
  }


  @Test
  public void test82() {
    assertThat(getByCode("my")).isSameAs(LanguageCode.my);
  }


  @Test
  public void test83() {
    assertThat(getByCode("mya")).isSameAs(LanguageCode.my);
  }


  @Test
  public void test84() {
    assertThat(getByCode("bur")).isSameAs(LanguageCode.my);
  }


  @Test
  public void test85() {
    assertThat(getByCode("nl")).isSameAs(LanguageCode.nl);
  }


  @Test
  public void test86() {
    assertThat(getByCode("nld")).isSameAs(LanguageCode.nl);
  }


  @Test
  public void test87() {
    assertThat(getByCode("dut")).isSameAs(LanguageCode.nl);
  }


  @Test
  public void test88() {
    assertThat(getByCode("ro")).isSameAs(LanguageCode.ro);
  }


  @Test
  public void test89() {
    assertThat(getByCode("ron")).isSameAs(LanguageCode.ro);
  }


  @Test
  public void test90() {
    assertThat(getByCode("rum")).isSameAs(LanguageCode.ro);
  }


  @Test
  public void test91() {
    assertThat(getByCode("sk")).isSameAs(LanguageCode.sk);
  }


  @Test
  public void test92() {
    assertThat(getByCode("slk")).isSameAs(LanguageCode.sk);
  }


  @Test
  public void test93() {
    assertThat(getByCode("slo")).isSameAs(LanguageCode.sk);
  }


  @Test
  public void test94() {
    assertThat(getByCode("sq")).isSameAs(LanguageCode.sq);
  }


  @Test
  public void test95() {
    assertThat(getByCode("sqi")).isSameAs(LanguageCode.sq);
  }


  @Test
  public void test96() {
    assertThat(getByCode("alb")).isSameAs(LanguageCode.sq);
  }


  @Test
  public void test97() {
    assertThat(LanguageCode.bo.getAlpha3()).isSameAs(LanguageAlpha3Code.bod);
  }


  @Test
  public void test98() {
    assertThat(LanguageCode.eu.getAlpha3()).isSameAs(LanguageAlpha3Code.eus);
  }


  @Test
  public void test99() {
    assertThat(LanguageCode.cs.getAlpha3()).isSameAs(LanguageAlpha3Code.ces);
  }


  @Test
  public void test100() {
    assertThat(LanguageCode.cy.getAlpha3()).isSameAs(LanguageAlpha3Code.cym);
  }


  @Test
  public void test101() {
    assertThat(LanguageCode.de.getAlpha3()).isSameAs(LanguageAlpha3Code.deu);
  }


  @Test
  public void test102() {
    assertThat(LanguageCode.el.getAlpha3()).isSameAs(LanguageAlpha3Code.ell);
  }


  @Test
  public void test103() {
    assertThat(LanguageCode.fa.getAlpha3()).isSameAs(LanguageAlpha3Code.fas);
  }


  @Test
  public void test104() {
    assertThat(LanguageCode.fr.getAlpha3()).isSameAs(LanguageAlpha3Code.fra);
  }


  @Test
  public void test105() {
    assertThat(LanguageCode.hy.getAlpha3()).isSameAs(LanguageAlpha3Code.hye);
  }


  @Test
  public void test106() {
    assertThat(LanguageCode.is.getAlpha3()).isSameAs(LanguageAlpha3Code.isl);
  }


  @Test
  public void test107() {
    assertThat(LanguageCode.ka.getAlpha3()).isSameAs(LanguageAlpha3Code.kat);
  }


  @Test
  public void test108() {
    assertThat(LanguageCode.mi.getAlpha3()).isSameAs(LanguageAlpha3Code.mri);
  }


  @Test
  public void test109() {
    assertThat(LanguageCode.mk.getAlpha3()).isSameAs(LanguageAlpha3Code.mkd);
  }


  @Test
  public void test110() {
    assertThat(LanguageCode.ms.getAlpha3()).isSameAs(LanguageAlpha3Code.msa);
  }


  @Test
  public void test111() {
    assertThat(LanguageCode.my.getAlpha3()).isSameAs(LanguageAlpha3Code.mya);
  }


  @Test
  public void test112() {
    assertThat(LanguageCode.nl.getAlpha3()).isSameAs(LanguageAlpha3Code.nld);
  }


  @Test
  public void test113() {
    assertThat(LanguageCode.ro.getAlpha3()).isSameAs(LanguageAlpha3Code.ron);
  }


  @Test
  public void test114() {
    assertThat(LanguageCode.sk.getAlpha3()).isSameAs(LanguageAlpha3Code.slk);
  }


  @Test
  public void test115() {
    assertThat(LanguageCode.sq.getAlpha3()).isSameAs(LanguageAlpha3Code.sqi);
  }


  @Test
  public void test116() {
    assertThat(LanguageCode.ja.getAlpha3()).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void test117() {
    assertThat(LanguageCode.ja.getName()).isSameAs("Japanese");
  }


  @Test
  public void test118() {
    List<LanguageCode> list = LanguageCode.findByName(".*nese");

    assertThat(list).hasSize(5);

    // an : Aragonese
    assertThat(list).contains(LanguageCode.an);

    // ja : Japanese
    assertThat(list).contains(LanguageCode.ja);

    // jv : Javanese
    assertThat(list).contains(LanguageCode.jv);

    // su : Sudanese
    assertThat(list).contains(LanguageCode.su);

    // zh : Chinese
    assertThat(list).contains(LanguageCode.zh);
  }


  @Test
  public void test119() {
    assertThat(getByCode("undefined")).isSameAs(LanguageCode.undefined);
  }


  @Test
  public void test120() {
    assertThat(getByCode("UNDEFINED")).isNull();
  }


  @Test
  public void test121() {
    assertThat(getByCode("UNDEFINED", false)).isSameAs(LanguageCode.undefined);
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

  @Test
  public void findByNameThrowsExceptionWhenPassedNullString() {
    String regex = null;
    assertThatThrownBy(() -> LanguageCode.findByName(regex))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void findByNameThrowsExceptionWhenPassedNullPattern() {
    Pattern pattern = null;
    assertThatThrownBy(() -> LanguageCode.findByName(pattern))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
