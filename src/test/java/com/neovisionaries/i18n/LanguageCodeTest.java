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
      ("aa ab ae af ak am an ar as av ay az ba be bg bh bi bm bn bo br bs "
       + "ca ce ch co cr cs cu cv cy da de dv dz ee el en eo es et eu fa ff "
       + "fi fj fo fr fy ga gd gl gn gu gv ha he hi ho hr ht hu hy hz ia id "
       + "ie ig ii ik io is it iu ja jv ka kg ki kj kk kl km kn ko kr ks ku "
       + "kv kw ky la lb lg li ln lo lt lu lv mg mh mi mk ml mn mr ms mt my "
       + "na nb nd ne ng nl nn no nr nv ny oc oj om or os pa pi pl ps pt qu "
       + "rm rn ro ru rw sa sc sd se sg si sk sl sm sn so sq sr ss st su sv "
       + "sw ta te tg th ti tk tl tn to tr ts tt tw ty ug uk ur uz ve vi vo "
       + "wa wo xh yi yo za zh zu").split(" ");


  @Test
  public void getByCodeWithJaReturnsJa() {
    assertThat(getByCode("ja")).isSameAs(LanguageCode.ja);
  }


  @Test
  public void getByCodeWithJaInUpperCaseReturnsNull() {
    assertThat(getByCode("JA")).isNull();
  }


  @Test
  public void getByCodeWithJaAndCaseSensitiveTrueReturnsJa() {
    assertThat(getByCode("ja", true)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void getByCodeWithJaInUpperCaseAndCaseSensitiveTrueReturnsNull() {
    assertThat(getByCode("JA", true)).isNull();
  }


  @Test
  public void getByCodeWithJaAndCaseSensitiveFalseReturnsJa() {
    assertThat(getByCode("ja", false)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void getByCodeWithJaInUpperCaseAndCaseSensitiveFalseReturnsJa() {
    assertThat(getByCode("JA", false)).isSameAs(LanguageCode.ja);
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
  public void getByCodeWithOneQuestionMarkReturnsNull() {
    assertThat(getByCode("?")).isNull();
  }


  @Test
  public void getByCodeWithTwoQuestionMarksReturnsNull() {
    assertThat(getByCode("??")).isNull();
  }


  @Test
  public void getByCodeWithThreeQuestionMarksReturnsNull() {
    assertThat(getByCode("???")).isNull();
  }


  @Test
  public void getByCodeWithFourQuestionMarksReturnsNull() {
    assertThat(getByCode("????")).isNull();
  }


  @Test
  public void getByCodeWithHeReturnsHe() {
    assertThat(getByCode("he")).isSameAs(LanguageCode.he);
  }


  @Test
  public void getByCodeWithWithdrawnIwAliasReturnsHe() {
    assertThat(getByCode("iw")).isSameAs(LanguageCode.he);
  }


  @Test
  public void getByCodeWithYiReturnsYi() {
    assertThat(getByCode("yi")).isSameAs(LanguageCode.yi);
  }


  @Test
  public void getByCodeWithWithdrawnJiAliasReturnsYi() {
    assertThat(getByCode("ji")).isSameAs(LanguageCode.yi);
  }


  @Test
  public void getByCodeWithIdReturnsId() {
    assertThat(getByCode("id")).isSameAs(LanguageCode.id);
  }


  @Test
  public void getByCodeWithWithdrawnInAliasReturnsId() {
    assertThat(getByCode("in")).isSameAs(LanguageCode.id);
  }


  @Test
  public void toLocaleWithDeReturnsLocaleGerman() {
    assertThat(LanguageCode.de.toLocale()).isSameAs(Locale.GERMAN);
  }


  @Test
  public void toLocaleWithEnReturnsLocaleEnglish() {
    assertThat(LanguageCode.en.toLocale()).isSameAs(Locale.ENGLISH);
  }


  @Test
  public void toLocaleWithFrReturnsLocaleFrench() {
    assertThat(LanguageCode.fr.toLocale()).isSameAs(Locale.FRENCH);
  }


  @Test
  public void toLocaleWithItReturnsLocaleItalian() {
    assertThat(LanguageCode.it.toLocale()).isSameAs(Locale.ITALIAN);
  }


  @Test
  public void toLocaleWithJaReturnsLocaleJapanese() {
    assertThat(LanguageCode.ja.toLocale()).isSameAs(Locale.JAPANESE);
  }


  @Test
  public void toLocaleWithKoReturnsLocaleKorean() {
    assertThat(LanguageCode.ko.toLocale()).isSameAs(Locale.KOREAN);
  }


  @Test
  public void toLocaleWithZhReturnsLocaleChinese() {
    assertThat(LanguageCode.zh.toLocale()).isSameAs(Locale.CHINESE);
  }


  @Test
  public void getByLocaleWithNullReturnsNull() {
    assertThat(getByLocale(null)).isNull();
  }


  @Test
  @SuppressWarnings("deprecation")
  public void getByLocaleWithEmptyLocaleReturnsUndefined() {
    assertThat(getByLocale(new Locale(""))).isSameAs(LanguageCode.undefined);
  }


  @Test
  public void getByLocaleWithCanadaFrenchReturnsFr() {
    assertThat(getByLocale(Locale.CANADA_FRENCH)).isSameAs(LanguageCode.fr);
  }


  @Test
  public void getByLocaleWithChineseReturnsZh() {
    assertThat(getByLocale(Locale.CHINESE)).isSameAs(LanguageCode.zh);
  }


  @Test
  public void getByLocaleWithEnglishReturnsEn() {
    assertThat(getByLocale(Locale.ENGLISH)).isSameAs(LanguageCode.en);
  }


  @Test
  public void getByLocaleWithFrenchReturnsFr() {
    assertThat(getByLocale(Locale.FRENCH)).isSameAs(LanguageCode.fr);
  }


  @Test
  public void getByLocaleWithGermanReturnsDe() {
    assertThat(getByLocale(Locale.GERMAN)).isSameAs(LanguageCode.de);
  }


  @Test
  public void getByLocaleWithItalianReturnsIt() {
    assertThat(getByLocale(Locale.ITALIAN)).isSameAs(LanguageCode.it);
  }


  @Test
  public void getByLocaleWithJapaneseReturnsJa() {
    assertThat(getByLocale(Locale.JAPANESE)).isSameAs(LanguageCode.ja);
  }


  @Test
  public void getByLocaleWithKoreanReturnsKo() {
    assertThat(getByLocale(Locale.KOREAN)).isSameAs(LanguageCode.ko);
  }


  @Test
  public void getByLocaleWithSimplifiedChineseReturnsZh() {
    assertThat(getByLocale(Locale.SIMPLIFIED_CHINESE)).isSameAs(LanguageCode.zh);
  }


  @Test
  public void getByLocaleWithTraditionalChineseReturnsZh() {
    assertThat(getByLocale(Locale.TRADITIONAL_CHINESE)).isSameAs(LanguageCode.zh);
  }


  @Test
  @SuppressWarnings("deprecation")
  public void getByLocaleWithLanguageOnlyLocaleReturnsJa() {
    assertThat(getByLocale(new Locale("ja"))).isSameAs(LanguageCode.ja);
  }


  @Test
  @SuppressWarnings("deprecation")
  public void getByLocaleWithLanguageAndCountryLocaleReturnsJa() {
    assertThat(getByLocale(new Locale("ja", "JP"))).isSameAs(LanguageCode.ja);
  }


  @Test
  public void getByCodeWithAlpha2BoReturnsBo() {
    assertThat(getByCode("bo")).isSameAs(LanguageCode.bo);
  }


  @Test
  public void getByCodeWithTerminologyBodReturnsBo() {
    assertThat(getByCode("bod")).isSameAs(LanguageCode.bo);
  }


  @Test
  public void getByCodeWithBibliographicTibReturnsBo() {
    assertThat(getByCode("tib")).isSameAs(LanguageCode.bo);
  }


  @Test
  public void getByCodeWithAlpha2EuReturnsEu() {
    assertThat(getByCode("eu")).isSameAs(LanguageCode.eu);
  }


  @Test
  public void getByCodeWithTerminologyEusReturnsEu() {
    assertThat(getByCode("eus")).isSameAs(LanguageCode.eu);
  }


  @Test
  public void getByCodeWithBibliographicBaqReturnsEu() {
    assertThat(getByCode("baq")).isSameAs(LanguageCode.eu);
  }


  @Test
  public void getByCodeWithAlpha2CsReturnsCs() {
    assertThat(getByCode("cs")).isSameAs(LanguageCode.cs);
  }


  @Test
  public void getByCodeWithTerminologyCesReturnsCs() {
    assertThat(getByCode("ces")).isSameAs(LanguageCode.cs);
  }


  @Test
  public void getByCodeWithBibliographicCzeReturnsCs() {
    assertThat(getByCode("cze")).isSameAs(LanguageCode.cs);
  }


  @Test
  public void getByCodeWithAlpha2CyReturnsCy() {
    assertThat(getByCode("cy")).isSameAs(LanguageCode.cy);
  }


  @Test
  public void getByCodeWithTerminologyCymReturnsCy() {
    assertThat(getByCode("cym")).isSameAs(LanguageCode.cy);
  }


  @Test
  public void getByCodeWithBibliographicWelReturnsCy() {
    assertThat(getByCode("wel")).isSameAs(LanguageCode.cy);
  }


  @Test
  public void getByCodeWithAlpha2DeReturnsDe() {
    assertThat(getByCode("de")).isSameAs(LanguageCode.de);
  }


  @Test
  public void getByCodeWithTerminologyDeuReturnsDe() {
    assertThat(getByCode("deu")).isSameAs(LanguageCode.de);
  }


  @Test
  public void getByCodeWithBibliographicGerReturnsDe() {
    assertThat(getByCode("ger")).isSameAs(LanguageCode.de);
  }


  @Test
  public void getByCodeWithAlpha2ElReturnsEl() {
    assertThat(getByCode("el")).isSameAs(LanguageCode.el);
  }


  @Test
  public void getByCodeWithTerminologyEllReturnsEl() {
    assertThat(getByCode("ell")).isSameAs(LanguageCode.el);
  }


  @Test
  public void getByCodeWithBibliographicGreReturnsEl() {
    assertThat(getByCode("gre")).isSameAs(LanguageCode.el);
  }


  @Test
  public void getByCodeWithAlpha2FaReturnsFa() {
    assertThat(getByCode("fa")).isSameAs(LanguageCode.fa);
  }


  @Test
  public void getByCodeWithBibliographicPerReturnsFa() {
    assertThat(getByCode("per")).isSameAs(LanguageCode.fa);
  }


  @Test
  public void getByCodeWithTerminologyFasReturnsFa() {
    assertThat(getByCode("fas")).isSameAs(LanguageCode.fa);
  }


  @Test
  public void getByCodeWithAlpha2FrReturnsFr() {
    assertThat(getByCode("fr")).isSameAs(LanguageCode.fr);
  }


  @Test
  public void getByCodeWithTerminologyFraReturnsFr() {
    assertThat(getByCode("fra")).isSameAs(LanguageCode.fr);
  }


  @Test
  public void getByCodeWithBibliographicFreReturnsFr() {
    assertThat(getByCode("fre")).isSameAs(LanguageCode.fr);
  }


  @Test
  public void getByCodeWithAlpha2HyReturnsHy() {
    assertThat(getByCode("hy")).isSameAs(LanguageCode.hy);
  }


  @Test
  public void getByCodeWithTerminologyHyeReturnsHy() {
    assertThat(getByCode("hye")).isSameAs(LanguageCode.hy);
  }


  @Test
  public void getByCodeWithBibliographicArmReturnsHy() {
    assertThat(getByCode("arm")).isSameAs(LanguageCode.hy);
  }


  @Test
  public void getByCodeWithAlpha2IsReturnsIs() {
    assertThat(getByCode("is")).isSameAs(LanguageCode.is);
  }


  @Test
  public void getByCodeWithTerminologyIslReturnsIs() {
    assertThat(getByCode("isl")).isSameAs(LanguageCode.is);
  }


  @Test
  public void getByCodeWithBibliographicIceReturnsIs() {
    assertThat(getByCode("ice")).isSameAs(LanguageCode.is);
  }


  @Test
  public void getByCodeWithAlpha2KaReturnsKa() {
    assertThat(getByCode("ka")).isSameAs(LanguageCode.ka);
  }


  @Test
  public void getByCodeWithTerminologyKatReturnsKa() {
    assertThat(getByCode("kat")).isSameAs(LanguageCode.ka);
  }


  @Test
  public void getByCodeWithBibliographicGeoReturnsKa() {
    assertThat(getByCode("geo")).isSameAs(LanguageCode.ka);
  }


  @Test
  public void getByCodeWithAlpha2MiReturnsMi() {
    assertThat(getByCode("mi")).isSameAs(LanguageCode.mi);
  }


  @Test
  public void getByCodeWithTerminologyMriReturnsMi() {
    assertThat(getByCode("mri")).isSameAs(LanguageCode.mi);
  }


  @Test
  public void getByCodeWithBibliographicMaoReturnsMi() {
    assertThat(getByCode("mao")).isSameAs(LanguageCode.mi);
  }


  @Test
  public void getByCodeWithAlpha2MkReturnsMk() {
    assertThat(getByCode("mk")).isSameAs(LanguageCode.mk);
  }


  @Test
  public void getByCodeWithTerminologyMkdReturnsMk() {
    assertThat(getByCode("mkd")).isSameAs(LanguageCode.mk);
  }


  @Test
  public void getByCodeWithBibliographicMacReturnsMk() {
    assertThat(getByCode("mac")).isSameAs(LanguageCode.mk);
  }


  @Test
  public void getByCodeWithAlpha2MsReturnsMs() {
    assertThat(getByCode("ms")).isSameAs(LanguageCode.ms);
  }


  @Test
  public void getByCodeWithTerminologyMsaReturnsMs() {
    assertThat(getByCode("msa")).isSameAs(LanguageCode.ms);
  }


  @Test
  public void getByCodeWithBibliographicMayReturnsMs() {
    assertThat(getByCode("may")).isSameAs(LanguageCode.ms);
  }


  @Test
  public void getByCodeWithAlpha2MyReturnsMy() {
    assertThat(getByCode("my")).isSameAs(LanguageCode.my);
  }


  @Test
  public void getByCodeWithTerminologyMyaReturnsMy() {
    assertThat(getByCode("mya")).isSameAs(LanguageCode.my);
  }


  @Test
  public void getByCodeWithBibliographicBurReturnsMy() {
    assertThat(getByCode("bur")).isSameAs(LanguageCode.my);
  }


  @Test
  public void getByCodeWithAlpha2NlReturnsNl() {
    assertThat(getByCode("nl")).isSameAs(LanguageCode.nl);
  }


  @Test
  public void getByCodeWithTerminologyNldReturnsNl() {
    assertThat(getByCode("nld")).isSameAs(LanguageCode.nl);
  }


  @Test
  public void getByCodeWithBibliographicDutReturnsNl() {
    assertThat(getByCode("dut")).isSameAs(LanguageCode.nl);
  }


  @Test
  public void getByCodeWithAlpha2RoReturnsRo() {
    assertThat(getByCode("ro")).isSameAs(LanguageCode.ro);
  }


  @Test
  public void getByCodeWithTerminologyRonReturnsRo() {
    assertThat(getByCode("ron")).isSameAs(LanguageCode.ro);
  }


  @Test
  public void getByCodeWithBibliographicRumReturnsRo() {
    assertThat(getByCode("rum")).isSameAs(LanguageCode.ro);
  }


  @Test
  public void getByCodeWithAlpha2SkReturnsSk() {
    assertThat(getByCode("sk")).isSameAs(LanguageCode.sk);
  }


  @Test
  public void getByCodeWithTerminologySlkReturnsSk() {
    assertThat(getByCode("slk")).isSameAs(LanguageCode.sk);
  }


  @Test
  public void getByCodeWithBibliographicSloReturnsSk() {
    assertThat(getByCode("slo")).isSameAs(LanguageCode.sk);
  }


  @Test
  public void getByCodeWithAlpha2SqReturnsSq() {
    assertThat(getByCode("sq")).isSameAs(LanguageCode.sq);
  }


  @Test
  public void getByCodeWithTerminologySqiReturnsSq() {
    assertThat(getByCode("sqi")).isSameAs(LanguageCode.sq);
  }


  @Test
  public void getByCodeWithBibliographicAlbReturnsSq() {
    assertThat(getByCode("alb")).isSameAs(LanguageCode.sq);
  }


  @Test
  public void getAlpha3ForBoReturnsBod() {
    assertThat(LanguageCode.bo.getAlpha3()).isSameAs(LanguageAlpha3Code.bod);
  }


  @Test
  public void getAlpha3ForEuReturnsEus() {
    assertThat(LanguageCode.eu.getAlpha3()).isSameAs(LanguageAlpha3Code.eus);
  }


  @Test
  public void getAlpha3ForCsReturnsCes() {
    assertThat(LanguageCode.cs.getAlpha3()).isSameAs(LanguageAlpha3Code.ces);
  }


  @Test
  public void getAlpha3ForCyReturnsCym() {
    assertThat(LanguageCode.cy.getAlpha3()).isSameAs(LanguageAlpha3Code.cym);
  }


  @Test
  public void getAlpha3ForDeReturnsDeu() {
    assertThat(LanguageCode.de.getAlpha3()).isSameAs(LanguageAlpha3Code.deu);
  }


  @Test
  public void getAlpha3ForElReturnsEll() {
    assertThat(LanguageCode.el.getAlpha3()).isSameAs(LanguageAlpha3Code.ell);
  }


  @Test
  public void getAlpha3ForFaReturnsFas() {
    assertThat(LanguageCode.fa.getAlpha3()).isSameAs(LanguageAlpha3Code.fas);
  }


  @Test
  public void getAlpha3ForFrReturnsFra() {
    assertThat(LanguageCode.fr.getAlpha3()).isSameAs(LanguageAlpha3Code.fra);
  }


  @Test
  public void getAlpha3ForHyReturnsHye() {
    assertThat(LanguageCode.hy.getAlpha3()).isSameAs(LanguageAlpha3Code.hye);
  }


  @Test
  public void getAlpha3ForIsReturnsIsl() {
    assertThat(LanguageCode.is.getAlpha3()).isSameAs(LanguageAlpha3Code.isl);
  }


  @Test
  public void getAlpha3ForKaReturnsKat() {
    assertThat(LanguageCode.ka.getAlpha3()).isSameAs(LanguageAlpha3Code.kat);
  }


  @Test
  public void getAlpha3ForMiReturnsMri() {
    assertThat(LanguageCode.mi.getAlpha3()).isSameAs(LanguageAlpha3Code.mri);
  }


  @Test
  public void getAlpha3ForMkReturnsMkd() {
    assertThat(LanguageCode.mk.getAlpha3()).isSameAs(LanguageAlpha3Code.mkd);
  }


  @Test
  public void getAlpha3ForMsReturnsMsa() {
    assertThat(LanguageCode.ms.getAlpha3()).isSameAs(LanguageAlpha3Code.msa);
  }


  @Test
  public void getAlpha3ForMyReturnsMya() {
    assertThat(LanguageCode.my.getAlpha3()).isSameAs(LanguageAlpha3Code.mya);
  }


  @Test
  public void getAlpha3ForNlReturnsNld() {
    assertThat(LanguageCode.nl.getAlpha3()).isSameAs(LanguageAlpha3Code.nld);
  }


  @Test
  public void getAlpha3ForRoReturnsRon() {
    assertThat(LanguageCode.ro.getAlpha3()).isSameAs(LanguageAlpha3Code.ron);
  }


  @Test
  public void getAlpha3ForSkReturnsSlk() {
    assertThat(LanguageCode.sk.getAlpha3()).isSameAs(LanguageAlpha3Code.slk);
  }


  @Test
  public void getAlpha3ForSqReturnsSqi() {
    assertThat(LanguageCode.sq.getAlpha3()).isSameAs(LanguageAlpha3Code.sqi);
  }


  @Test
  public void getAlpha3ForJaReturnsJpn() {
    assertThat(LanguageCode.ja.getAlpha3()).isSameAs(LanguageAlpha3Code.jpn);
  }


  @Test
  public void getNameForJaReturnsJapanese() {
    assertThat(LanguageCode.ja.getName()).isSameAs("Japanese");
  }


  @Test
  public void findByNameWithNeseSuffixReturnsMatchingLanguageCodes() {
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
  public void getByCodeWithUndefinedReturnsUndefined() {
    assertThat(getByCode("undefined")).isSameAs(LanguageCode.undefined);
  }


  @Test
  public void getByCodeWithUndefinedInUpperCaseReturnsNull() {
    assertThat(getByCode("UNDEFINED")).isNull();
  }


  @Test
  public void getByCodeWithUndefinedInUpperCaseAndCaseSensitiveFalseReturnsUndefined() {
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
  public void findByNameThrowsExceptionWhenPassedNull() {
    Pattern pattern = null;
    assertThatThrownBy(() -> LanguageCode.findByName(pattern))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
