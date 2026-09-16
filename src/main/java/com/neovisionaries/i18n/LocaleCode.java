/*
 * Copyright (C) 2012-2017 Neo Visionaries Inc.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.neovisionaries.i18n;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Collections.emptyList;

/**
 * Locale code.
 *
 * <p>
 * The list of the enum entries was generated based on the output from
 * {@link java.util.Locale#getAvailableLocales()
 * Locale.getAvailableLocales()} of JDK 27, but locales whose
 * format do not match either 'xx' or 'xx-XX' were excluded.
 * </p>
 *
 * <pre style="background-color: #EEEEEE; margin-left: 2em; margin-right: 2em; border: 1px solid black;">
 * <span style="color: darkgreen;">// List all the locale codes.</span>
 * for (LocaleCode code : LocaleCode.values()) {
 *     String language = code.{@link #getLanguage()}.{@link LanguageCode#getName() getName()};
 *     String country  = code.{@link #getCountry()} != null
 *                     ? code.{@link #getCountry()}.{@link CountryCode#getName() getName()}
 *                     : null;
 *
 *     <span style="color: darkgreen;">// For example, "[de-DE] German, Germany" is printed.</span>
 *     System.out.format(<span style="color: darkred;">"[%s] %s, %s\n"</span>, code, language, country);
 * }
 *
 * <span style="color: darkgreen;">// Get a LocaleCode instance in various ways.</span>
 * LocaleCode code;
 * code = LocaleCode.{@link #getByCode(String) getByCode}(<span style="color: darkred;">"en-GB"</span>);
 * code = LocaleCode.{@link #getByCode(String, String) getByCode}(<span style="color: darkred;">"es"</span>, <span style="color: darkred;">"ES"</span>);
 * code = LocaleCode.{@link #getByLocale(Locale) getByLocale}(new Locale(<span style="color: darkred;">"pt"</span>, <span style="color: darkred;">"BR"</span>));
 *
 * <span style="color: darkgreen;">// Convert to a Locale instance.</span>
 * Locale locale = LocaleCode.{@link #en}.{@link #toLocale()};
 *
 * <span style="color: darkgreen;">// toLocale() of some LocaleCode instances does not create</span>
 * <span style="color: darkgreen;">// a new Locale instance but returns a static variable of</span>
 * <span style="color: darkgreen;">// Locale class instead. See {@link #toLocale()} for details.</span>
 * if (locale == Locale.ENGLISH)
 * {
 *     System.out.println(<span style="color: darkred;">"Locale.en.toLocale() returned Locale.ENGLISH"</span>);
 * }
 *
 * <span style="color: darkgreen;">// Get a list of LocaleCode instances whose language is Arabic.</span>
 * List&lt;LocaleCode&gt; list = LocaleCode.{@link #getByLanguage(LanguageCode) getByLanguage}({@link LanguageCode#ar});
 *
 * <span style="color: darkgreen;">// Get a list of LocaleCode instances whose country is Switzerland.</span>
 * list = LocaleCode.{@link #getByCountry(CountryCode) getByCountry}({@link CountryCode#CH});
 * </pre>
 *
 * @author Takahiko Kawasaki
 */
public enum LocaleCode {
  /**
   * {@link LanguageCode#undefined Undefined}, {@link CountryCode#UNDEFINED Undefined}
   *
   * @since 1.14
   */
  undefined(LanguageCode.undefined, CountryCode.UNDEFINED) {
    @Override
    public Locale toLocale() {
      return undefinedLocale;
    }
  },

  /**
   * {@link LanguageCode#af Afrikaans}
   */
  af(LanguageCode.af, null),
  af_NA(LanguageCode.af, CountryCode.NA),
  af_ZA(LanguageCode.af, CountryCode.ZA),
  ak(LanguageCode.ak, null),
  ak_GH(LanguageCode.ak, CountryCode.GH),
  am(LanguageCode.am, null),
  am_ET(LanguageCode.am, CountryCode.ET),

  /**
   * {@link LanguageCode#ar Arabic}
   */
  ar(LanguageCode.ar, null),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#AE United Arab Emirates}
   */
  ar_AE(LanguageCode.ar, CountryCode.AE),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#BH Bahrain}
   */
  ar_BH(LanguageCode.ar, CountryCode.BH),
  ar_DJ(LanguageCode.ar, CountryCode.DJ),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#DZ Algeria}
   */
  ar_DZ(LanguageCode.ar, CountryCode.DZ),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#EG Egypt}
   */
  ar_EG(LanguageCode.ar, CountryCode.EG),
  ar_EH(LanguageCode.ar, CountryCode.EH),
  ar_ER(LanguageCode.ar, CountryCode.ER),
  ar_IL(LanguageCode.ar, CountryCode.IL),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#IQ Iraq}
   */
  ar_IQ(LanguageCode.ar, CountryCode.IQ),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#JO Jordan}
   */
  ar_JO(LanguageCode.ar, CountryCode.JO),
  ar_KM(LanguageCode.ar, CountryCode.KM),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#KW Kuwait}
   */
  ar_KW(LanguageCode.ar, CountryCode.KW),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#LB Lebanon}
   */
  ar_LB(LanguageCode.ar, CountryCode.LB),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#LY Libya}
   */
  ar_LY(LanguageCode.ar, CountryCode.LY),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#MA Morocco}
   */
  ar_MA(LanguageCode.ar, CountryCode.MA),
  ar_MR(LanguageCode.ar, CountryCode.MR),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#OM Oman}
   */
  ar_OM(LanguageCode.ar, CountryCode.OM),
  ar_PS(LanguageCode.ar, CountryCode.PS),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#QA Qatar}
   */
  ar_QA(LanguageCode.ar, CountryCode.QA),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#SA Saudi Arabia}
   */
  ar_SA(LanguageCode.ar, CountryCode.SA),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#SD Sudan}
   */
  ar_SD(LanguageCode.ar, CountryCode.SD),
  ar_SO(LanguageCode.ar, CountryCode.SO),
  ar_SS(LanguageCode.ar, CountryCode.SS),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#SY Syrian Arab Republic}
   */
  ar_SY(LanguageCode.ar, CountryCode.SY),
  ar_TD(LanguageCode.ar, CountryCode.TD),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#TN Tunisia}
   */
  ar_TN(LanguageCode.ar, CountryCode.TN),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#YE Yemen}
   */
  ar_YE(LanguageCode.ar, CountryCode.YE),
  as(LanguageCode.as, null),
  as_IN(LanguageCode.as, CountryCode.IN),
  az(LanguageCode.az, null),
  az_AZ(LanguageCode.az, CountryCode.AZ),
  ba(LanguageCode.ba, null),
  ba_RU(LanguageCode.ba, CountryCode.RU),

  /**
   * {@link LanguageCode#be Belarusian}
   */
  be(LanguageCode.be, null),

  /**
   * {@link LanguageCode#be Belarusian}, {@link CountryCode#BY Belarus}
   */
  be_BY(LanguageCode.be, CountryCode.BY),

  /**
   * {@link LanguageCode#bg Bulgarian}
   */
  bg(LanguageCode.bg, null),

  /**
   * {@link LanguageCode#bg Bulgarian}, {@link CountryCode#BG Bulgaria}
   */
  bg_BG(LanguageCode.bg, CountryCode.BG),
  bm(LanguageCode.bm, null),
  bm_ML(LanguageCode.bm, CountryCode.ML),
  bn(LanguageCode.bn, null),
  bn_BD(LanguageCode.bn, CountryCode.BD),
  bn_IN(LanguageCode.bn, CountryCode.IN),
  bo(LanguageCode.bo, null),
  bo_CN(LanguageCode.bo, CountryCode.CN),
  bo_IN(LanguageCode.bo, CountryCode.IN),
  br(LanguageCode.br, null),
  br_FR(LanguageCode.br, CountryCode.FR),
  bs(LanguageCode.bs, null),

  /**
   * {@link LanguageCode#bs Bosnian}, {@link CountryCode#BA Bosnia and Herzegovina}
   */
  bs_BA(LanguageCode.bs, CountryCode.BA),

  /**
   * {@link LanguageCode#ca Catalan}
   */
  ca(LanguageCode.ca, null),
  ca_AD(LanguageCode.ca, CountryCode.AD),

  /**
   * {@link LanguageCode#ca Catalan}, {@link CountryCode#ES Spain}
   */
  ca_ES(LanguageCode.ca, CountryCode.ES),
  ca_FR(LanguageCode.ca, CountryCode.FR),
  ca_IT(LanguageCode.ca, CountryCode.IT),
  ce(LanguageCode.ce, null),
  ce_RU(LanguageCode.ce, CountryCode.RU),

  /**
   * {@link LanguageCode#cs Czech}
   */
  cs(LanguageCode.cs, null),

  /**
   * {@link LanguageCode#cs Czech}, {@link CountryCode#CZ Czech Republic}
   */
  cs_CZ(LanguageCode.cs, CountryCode.CZ),
  cv(LanguageCode.cv, null),
  cv_RU(LanguageCode.cv, CountryCode.RU),
  cy(LanguageCode.cy, null),
  cy_GB(LanguageCode.cy, CountryCode.GB),

  /**
   * {@link LanguageCode#da Danish}
   */
  da(LanguageCode.da, null),

  /**
   * {@link LanguageCode#da Danish}, {@link CountryCode#DK Denmark}
   */
  da_DK(LanguageCode.da, CountryCode.DK),
  da_GL(LanguageCode.da, CountryCode.GL),

  /**
   * {@link LanguageCode#de German}
   */
  de(LanguageCode.de, null) {
    @Override
    public Locale toLocale() {
      return Locale.GERMAN;
    }
  },

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#AT Austria}
   */
  de_AT(LanguageCode.de, CountryCode.AT),
  de_BE(LanguageCode.de, CountryCode.BE),

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#CH Switzerland}
   */
  de_CH(LanguageCode.de, CountryCode.CH),

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#DE Germany}
   */
  de_DE(LanguageCode.de, CountryCode.DE),
  de_IT(LanguageCode.de, CountryCode.IT),
  de_LI(LanguageCode.de, CountryCode.LI),

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#LU Luxembourg}
   */
  de_LU(LanguageCode.de, CountryCode.LU),
  dz(LanguageCode.dz, null),
  dz_BT(LanguageCode.dz, CountryCode.BT),
  ee(LanguageCode.ee, null),
  ee_GH(LanguageCode.ee, CountryCode.GH),
  ee_TG(LanguageCode.ee, CountryCode.TG),

  /**
   * {@link LanguageCode#el Greek}
   */
  el(LanguageCode.el, null),

  /**
   * {@link LanguageCode#el Greek}, {@link CountryCode#CY Cyprus}
   */
  el_CY(LanguageCode.el, CountryCode.CY),

  /**
   * {@link LanguageCode#el Greek}, {@link CountryCode#GR Greece}
   */
  el_GR(LanguageCode.el, CountryCode.GR),

  /**
   * {@link LanguageCode#en English}
   */
  en(LanguageCode.en, null) {
    @Override
    public Locale toLocale() {
      return Locale.ENGLISH;
    }
  },
  en_AE(LanguageCode.en, CountryCode.AE),
  en_AG(LanguageCode.en, CountryCode.AG),
  en_AI(LanguageCode.en, CountryCode.AI),
  en_AS(LanguageCode.en, CountryCode.AS),
  en_AT(LanguageCode.en, CountryCode.AT),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AU Australia}
   */
  en_AU(LanguageCode.en, CountryCode.AU),
  en_BB(LanguageCode.en, CountryCode.BB),
  en_BE(LanguageCode.en, CountryCode.BE),
  en_BI(LanguageCode.en, CountryCode.BI),
  en_BM(LanguageCode.en, CountryCode.BM),
  en_BS(LanguageCode.en, CountryCode.BS),
  en_BW(LanguageCode.en, CountryCode.BW),
  en_BZ(LanguageCode.en, CountryCode.BZ),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CA Canada}
   */
  en_CA(LanguageCode.en, CountryCode.CA),
  en_CC(LanguageCode.en, CountryCode.CC),
  en_CH(LanguageCode.en, CountryCode.CH),
  en_CK(LanguageCode.en, CountryCode.CK),
  en_CM(LanguageCode.en, CountryCode.CM),
  en_CX(LanguageCode.en, CountryCode.CX),
  en_CY(LanguageCode.en, CountryCode.CY),
  en_CZ(LanguageCode.en, CountryCode.CZ),
  en_DE(LanguageCode.en, CountryCode.DE),
  en_DG(LanguageCode.en, CountryCode.DG),
  en_DK(LanguageCode.en, CountryCode.DK),
  en_DM(LanguageCode.en, CountryCode.DM),
  en_EE(LanguageCode.en, CountryCode.EE),
  en_ER(LanguageCode.en, CountryCode.ER),
  en_ES(LanguageCode.en, CountryCode.ES),
  en_FI(LanguageCode.en, CountryCode.FI),
  en_FJ(LanguageCode.en, CountryCode.FJ),
  en_FK(LanguageCode.en, CountryCode.FK),
  en_FM(LanguageCode.en, CountryCode.FM),
  en_FR(LanguageCode.en, CountryCode.FR),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GB United Kingdom}
   */
  en_GB(LanguageCode.en, CountryCode.GB),
  en_GD(LanguageCode.en, CountryCode.GD),
  en_GE(LanguageCode.en, CountryCode.GE),
  en_GG(LanguageCode.en, CountryCode.GG),
  en_GH(LanguageCode.en, CountryCode.GH),
  en_GI(LanguageCode.en, CountryCode.GI),
  en_GM(LanguageCode.en, CountryCode.GM),
  en_GS(LanguageCode.en, CountryCode.GS),
  en_GU(LanguageCode.en, CountryCode.GU),
  en_GY(LanguageCode.en, CountryCode.GY),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#HK Hong Kong}
   *
   * @since 1.22
   */
  en_HK(LanguageCode.en, CountryCode.HK),
  en_HU(LanguageCode.en, CountryCode.HU),
  en_ID(LanguageCode.en, CountryCode.ID),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IE Ireland}
   */
  en_IE(LanguageCode.en, CountryCode.IE),
  en_IL(LanguageCode.en, CountryCode.IL),
  en_IM(LanguageCode.en, CountryCode.IM),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IN India}
   */
  en_IN(LanguageCode.en, CountryCode.IN),
  en_IO(LanguageCode.en, CountryCode.IO),
  en_IT(LanguageCode.en, CountryCode.IT),
  en_JE(LanguageCode.en, CountryCode.JE),
  en_JM(LanguageCode.en, CountryCode.JM),
  en_JP(LanguageCode.en, CountryCode.JP),
  en_KE(LanguageCode.en, CountryCode.KE),
  en_KI(LanguageCode.en, CountryCode.KI),
  en_KN(LanguageCode.en, CountryCode.KN),
  en_KY(LanguageCode.en, CountryCode.KY),
  en_LC(LanguageCode.en, CountryCode.LC),
  en_LR(LanguageCode.en, CountryCode.LR),
  en_LS(LanguageCode.en, CountryCode.LS),
  en_LT(LanguageCode.en, CountryCode.LT),
  en_LV(LanguageCode.en, CountryCode.LV),
  en_MG(LanguageCode.en, CountryCode.MG),
  en_MH(LanguageCode.en, CountryCode.MH),
  en_MO(LanguageCode.en, CountryCode.MO),
  en_MP(LanguageCode.en, CountryCode.MP),
  en_MS(LanguageCode.en, CountryCode.MS),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MT Malta}
   */
  en_MT(LanguageCode.en, CountryCode.MT),
  en_MU(LanguageCode.en, CountryCode.MU),
  en_MV(LanguageCode.en, CountryCode.MV),
  en_MW(LanguageCode.en, CountryCode.MW),
  en_MY(LanguageCode.en, CountryCode.MY),
  en_NA(LanguageCode.en, CountryCode.NA),
  en_NF(LanguageCode.en, CountryCode.NF),
  en_NG(LanguageCode.en, CountryCode.NG),
  en_NL(LanguageCode.en, CountryCode.NL),
  en_NO(LanguageCode.en, CountryCode.NO),
  en_NR(LanguageCode.en, CountryCode.NR),
  en_NU(LanguageCode.en, CountryCode.NU),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NZ New Zealand}
   */
  en_NZ(LanguageCode.en, CountryCode.NZ),
  en_PG(LanguageCode.en, CountryCode.PG),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PH Philippines}
   */
  en_PH(LanguageCode.en, CountryCode.PH),
  en_PK(LanguageCode.en, CountryCode.PK),
  en_PL(LanguageCode.en, CountryCode.PL),
  en_PN(LanguageCode.en, CountryCode.PN),
  en_PR(LanguageCode.en, CountryCode.PR),
  en_PT(LanguageCode.en, CountryCode.PT),
  en_PW(LanguageCode.en, CountryCode.PW),
  en_RO(LanguageCode.en, CountryCode.RO),
  en_RW(LanguageCode.en, CountryCode.RW),
  en_SB(LanguageCode.en, CountryCode.SB),
  en_SC(LanguageCode.en, CountryCode.SC),
  en_SD(LanguageCode.en, CountryCode.SD),
  en_SE(LanguageCode.en, CountryCode.SE),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SG Singapore}
   */
  en_SG(LanguageCode.en, CountryCode.SG),
  en_SH(LanguageCode.en, CountryCode.SH),
  en_SI(LanguageCode.en, CountryCode.SI),
  en_SK(LanguageCode.en, CountryCode.SK),
  en_SL(LanguageCode.en, CountryCode.SL),
  en_SS(LanguageCode.en, CountryCode.SS),
  en_SX(LanguageCode.en, CountryCode.SX),
  en_SZ(LanguageCode.en, CountryCode.SZ),
  en_TC(LanguageCode.en, CountryCode.TC),
  en_TK(LanguageCode.en, CountryCode.TK),
  en_TO(LanguageCode.en, CountryCode.TO),
  en_TT(LanguageCode.en, CountryCode.TT),
  en_TV(LanguageCode.en, CountryCode.TV),
  en_TZ(LanguageCode.en, CountryCode.TZ),
  en_UA(LanguageCode.en, CountryCode.UA),
  en_UG(LanguageCode.en, CountryCode.UG),
  en_UM(LanguageCode.en, CountryCode.UM),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#US United States}
   */
  en_US(LanguageCode.en, CountryCode.US),
  en_VC(LanguageCode.en, CountryCode.VC),
  en_VG(LanguageCode.en, CountryCode.VG),
  en_VI(LanguageCode.en, CountryCode.VI),
  en_VU(LanguageCode.en, CountryCode.VU),
  en_WS(LanguageCode.en, CountryCode.WS),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ZA South Africa}
   */
  en_ZA(LanguageCode.en, CountryCode.ZA),
  en_ZM(LanguageCode.en, CountryCode.ZM),
  en_ZW(LanguageCode.en, CountryCode.ZW),
  eo(LanguageCode.eo, null),

  /**
   * {@link LanguageCode#es Spanish}
   */
  es(LanguageCode.es, null),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#AR Argentina}
   */
  es_AR(LanguageCode.es, CountryCode.AR),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#BO Bolivia, Plurinational State of}
   */
  es_BO(LanguageCode.es, CountryCode.BO),
  es_BR(LanguageCode.es, CountryCode.BR),
  es_BZ(LanguageCode.es, CountryCode.BZ),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#CL Chile}
   */
  es_CL(LanguageCode.es, CountryCode.CL),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#CO Colombia}
   */
  es_CO(LanguageCode.es, CountryCode.CO),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#CR Costa Rica}
   */
  es_CR(LanguageCode.es, CountryCode.CR),
  es_CU(LanguageCode.es, CountryCode.CU),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#DO Dominican Republic}
   */
  es_DO(LanguageCode.es, CountryCode.DO),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#EC Ecuador}
   */
  es_EC(LanguageCode.es, CountryCode.EC),
  es_EA(LanguageCode.es, CountryCode.EA),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#ES Spain}
   */
  es_ES(LanguageCode.es, CountryCode.ES),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#GT Guatemala}
   */
  es_GT(LanguageCode.es, CountryCode.GT),
  es_GQ(LanguageCode.es, CountryCode.GQ),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#HN Honduras}
   */
  es_HN(LanguageCode.es, CountryCode.HN),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#MX Mexico}
   */
  es_MX(LanguageCode.es, CountryCode.MX),
  es_IC(LanguageCode.es, CountryCode.IC),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#NI Nicaragua}
   */
  es_NI(LanguageCode.es, CountryCode.NI),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#PA Panama}
   */
  es_PA(LanguageCode.es, CountryCode.PA),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#PE Peru}
   */
  es_PE(LanguageCode.es, CountryCode.PE),
  es_PH(LanguageCode.es, CountryCode.PH),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#PR Puerto Rico}
   */
  es_PR(LanguageCode.es, CountryCode.PR),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#PY Paraguay}
   */
  es_PY(LanguageCode.es, CountryCode.PY),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#SV El Salvador}
   */
  es_SV(LanguageCode.es, CountryCode.SV),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#US United States}
   */
  es_US(LanguageCode.es, CountryCode.US),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#UY Uruguay}
   */
  es_UY(LanguageCode.es, CountryCode.UY),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#VE Venezuela, Bolivarian Republic of}
   */
  es_VE(LanguageCode.es, CountryCode.VE),

  /**
   * {@link LanguageCode#et Estonian}
   */
  et(LanguageCode.et, null),

  /**
   * {@link LanguageCode#et Estonian}, {@link CountryCode#EE Estonia}
   */
  et_EE(LanguageCode.et, CountryCode.EE),
  eu(LanguageCode.eu, null),
  eu_ES(LanguageCode.eu, CountryCode.ES),

  /**
   * {@link LanguageCode#fa Farsi}
   *
   * @since 1.21
   */
  fa(LanguageCode.fa, null),
  fa_AF(LanguageCode.fa, CountryCode.AF),

  /**
   * {@link LanguageCode#fa Farsi}, {@link CountryCode#IR Iran}
   *
   * @since 1.21
   */
  fa_IR(LanguageCode.fa, CountryCode.IR),
  ff(LanguageCode.ff, null),
  ff_GN(LanguageCode.ff, CountryCode.GN),
  ff_SN(LanguageCode.ff, CountryCode.SN),

  /**
   * {@link LanguageCode#fi Finnish}
   */
  fi(LanguageCode.fi, null),

  /**
   * {@link LanguageCode#fi Finnish}, {@link CountryCode#FI Finland}
   */
  fi_FI(LanguageCode.fi, CountryCode.FI),
  fo(LanguageCode.fo, null),
  fo_DK(LanguageCode.fo, CountryCode.DK),
  fo_FO(LanguageCode.fo, CountryCode.FO),

  /**
   * {@link LanguageCode#fr French}
   */
  fr(LanguageCode.fr, null) {
    @Override
    public Locale toLocale() {
      return Locale.FRENCH;
    }
  },

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#BE Belgium}
   */
  fr_BE(LanguageCode.fr, CountryCode.BE),
  fr_BF(LanguageCode.fr, CountryCode.BF),
  fr_BI(LanguageCode.fr, CountryCode.BI),
  fr_BJ(LanguageCode.fr, CountryCode.BJ),
  fr_BL(LanguageCode.fr, CountryCode.BL),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CA Canada}
   */
  fr_CA(LanguageCode.fr, CountryCode.CA) {
    @Override
    public Locale toLocale() {
      return Locale.CANADA_FRENCH;
    }
  },
  fr_CD(LanguageCode.fr, CountryCode.CD),
  fr_CF(LanguageCode.fr, CountryCode.CF),
  fr_CG(LanguageCode.fr, CountryCode.CG),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CH Switzerland}
   */
  fr_CH(LanguageCode.fr, CountryCode.CH),
  fr_CI(LanguageCode.fr, CountryCode.CI),
  fr_CM(LanguageCode.fr, CountryCode.CM),
  fr_DJ(LanguageCode.fr, CountryCode.DJ),
  fr_DZ(LanguageCode.fr, CountryCode.DZ),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#FR France}
   */
  fr_FR(LanguageCode.fr, CountryCode.FR),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#LU Luxembourg}
   */
  fr_LU(LanguageCode.fr, CountryCode.LU),
  fr_GA(LanguageCode.fr, CountryCode.GA),
  fr_GF(LanguageCode.fr, CountryCode.GF),
  fr_GN(LanguageCode.fr, CountryCode.GN),
  fr_GP(LanguageCode.fr, CountryCode.GP),
  fr_GQ(LanguageCode.fr, CountryCode.GQ),
  fr_HT(LanguageCode.fr, CountryCode.HT),
  fr_KM(LanguageCode.fr, CountryCode.KM),
  fr_MA(LanguageCode.fr, CountryCode.MA),
  fr_MC(LanguageCode.fr, CountryCode.MC),
  fr_MF(LanguageCode.fr, CountryCode.MF),
  fr_MG(LanguageCode.fr, CountryCode.MG),
  fr_ML(LanguageCode.fr, CountryCode.ML),
  fr_MQ(LanguageCode.fr, CountryCode.MQ),
  fr_MR(LanguageCode.fr, CountryCode.MR),
  fr_MU(LanguageCode.fr, CountryCode.MU),
  fr_NC(LanguageCode.fr, CountryCode.NC),
  fr_NE(LanguageCode.fr, CountryCode.NE),
  fr_PF(LanguageCode.fr, CountryCode.PF),
  fr_PM(LanguageCode.fr, CountryCode.PM),
  fr_RE(LanguageCode.fr, CountryCode.RE),
  fr_RW(LanguageCode.fr, CountryCode.RW),
  fr_SC(LanguageCode.fr, CountryCode.SC),
  fr_SN(LanguageCode.fr, CountryCode.SN),
  fr_SY(LanguageCode.fr, CountryCode.SY),
  fr_TD(LanguageCode.fr, CountryCode.TD),
  fr_TG(LanguageCode.fr, CountryCode.TG),
  fr_TN(LanguageCode.fr, CountryCode.TN),
  fr_VU(LanguageCode.fr, CountryCode.VU),
  fr_WF(LanguageCode.fr, CountryCode.WF),
  fr_YT(LanguageCode.fr, CountryCode.YT),
  fy(LanguageCode.fy, null),
  fy_NL(LanguageCode.fy, CountryCode.NL),

  /**
   * {@link LanguageCode#ga Irish}
   */
  ga(LanguageCode.ga, null),
  ga_GB(LanguageCode.ga, CountryCode.GB),

  /**
   * {@link LanguageCode#ga Irish}, {@link CountryCode#IE Ireland}
   */
  ga_IE(LanguageCode.ga, CountryCode.IE),
  gd(LanguageCode.gd, null),
  gd_GB(LanguageCode.gd, CountryCode.GB),
  gl(LanguageCode.gl, null),
  gl_ES(LanguageCode.gl, CountryCode.ES),
  gu(LanguageCode.gu, null),
  gu_IN(LanguageCode.gu, CountryCode.IN),
  gv(LanguageCode.gv, null),
  gv_IM(LanguageCode.gv, CountryCode.IM),
  ha(LanguageCode.ha, null),
  ha_GH(LanguageCode.ha, CountryCode.GH),
  ha_NE(LanguageCode.ha, CountryCode.NE),
  ha_NG(LanguageCode.ha, CountryCode.NG),

  /**
   * {@link LanguageCode#he Hebrew}
   */
  he(LanguageCode.he, null),

  /**
   * {@link LanguageCode#he Hebrew}, {@link CountryCode#IL Israel}
   */
  he_IL(LanguageCode.he, CountryCode.IL),

  /**
   * {@link LanguageCode#hi Hindi}
   */
  hi(LanguageCode.hi, null),

  /**
   * {@link LanguageCode#hi Hindi}, {@link CountryCode#IN India}
   */
  hi_IN(LanguageCode.hi, CountryCode.IN),

  /**
   * {@link LanguageCode#hr Croatian}
   */
  hr(LanguageCode.hr, null),
  hr_BA(LanguageCode.hr, CountryCode.BA),

  /**
   * {@link LanguageCode#hr Croatian}, {@link CountryCode#HR Croatia}
   */
  hr_HR(LanguageCode.hr, CountryCode.HR),
  ht(LanguageCode.ht, null),
  ht_HT(LanguageCode.ht, CountryCode.HT),

  /**
   * {@link LanguageCode#hu Hungarian}
   */
  hu(LanguageCode.hu, null),

  /**
   * {@link LanguageCode#hu Hungarian}, {@link CountryCode#HU Hungary}
   */
  hu_HU(LanguageCode.hu, CountryCode.HU),
  hy(LanguageCode.hy, null),
  hy_AM(LanguageCode.hy, CountryCode.AM),
  ia(LanguageCode.ia, null),

  /**
   * {@link LanguageCode#id Indonesian}
   */
  id(LanguageCode.id, null),

  /**
   * {@link LanguageCode#id Indonesian}, {@link CountryCode#ID Indonesia}
   */
  id_ID(LanguageCode.id, CountryCode.ID),

  /**
   * {@link LanguageCode#is Icelandic}
   */
  is(LanguageCode.is, null),

  /**
   * {@link LanguageCode#is Icelandic}, {@link CountryCode#IS Iceland}
   */
  is_IS(LanguageCode.is, CountryCode.IS),
  ie(LanguageCode.ie, null),
  ie_EE(LanguageCode.ie, CountryCode.EE),
  ig(LanguageCode.ig, null),
  ig_NG(LanguageCode.ig, CountryCode.NG),
  ii(LanguageCode.ii, null),
  ii_CN(LanguageCode.ii, CountryCode.CN),

  /**
   * {@link LanguageCode#it Italian}
   */
  it(LanguageCode.it, null) {
    @Override
    public Locale toLocale() {
      return Locale.ITALIAN;
    }
  },

  /**
   * {@link LanguageCode#it Italian}, {@link CountryCode#CH Switzerland}
   */
  it_CH(LanguageCode.it, CountryCode.CH),

  /**
   * {@link LanguageCode#it Italian}, {@link CountryCode#IT Italy}
   */
  it_IT(LanguageCode.it, CountryCode.IT),
  it_SM(LanguageCode.it, CountryCode.SM),
  it_VA(LanguageCode.it, CountryCode.VA),

  /**
   * {@link LanguageCode#ja Japanese}
   */
  ja(LanguageCode.ja, null) {
    @Override
    public Locale toLocale() {
      return Locale.JAPANESE;
    }
  },

  /**
   * {@link LanguageCode#ja Japanese}, {@link CountryCode#JP Japan}
   */
  ja_JP(LanguageCode.ja, CountryCode.JP),
  jv(LanguageCode.jv, null),
  jv_ID(LanguageCode.jv, CountryCode.ID),
  ka(LanguageCode.ka, null),
  ka_GE(LanguageCode.ka, CountryCode.GE),
  ki(LanguageCode.ki, null),
  ki_KE(LanguageCode.ki, CountryCode.KE),
  kk(LanguageCode.kk, null),
  kk_CN(LanguageCode.kk, CountryCode.CN),

  /**
   * {@link LanguageCode#kk Kazakh}, {@link CountryCode#KZ Kazakhstan}
   *
   * @since 1.22
   */
  kk_KZ(LanguageCode.kk, CountryCode.KZ),
  kl(LanguageCode.kl, null),
  kl_GL(LanguageCode.kl, CountryCode.GL),
  km(LanguageCode.km, null),
  km_KH(LanguageCode.km, CountryCode.KH),
  kn(LanguageCode.kn, null),
  kn_IN(LanguageCode.kn, CountryCode.IN),

  /**
   * {@link LanguageCode#ko Korean}
   */
  ko(LanguageCode.ko, null) {
    @Override
    public Locale toLocale() {
      return Locale.KOREAN;
    }
  },
  ko_CN(LanguageCode.ko, CountryCode.CN),
  ko_KP(LanguageCode.ko, CountryCode.KP),

  /**
   * {@link LanguageCode#ko Korean}, {@link CountryCode#KR Korea, Republic of}
   */
  ko_KR(LanguageCode.ko, CountryCode.KR),
  ks(LanguageCode.ks, null),
  ks_IN(LanguageCode.ks, CountryCode.IN),
  ku(LanguageCode.ku, null),
  ku_TR(LanguageCode.ku, CountryCode.TR),
  kw(LanguageCode.kw, null),
  kw_GB(LanguageCode.kw, CountryCode.GB),
  ky(LanguageCode.ky, null),
  ky_KG(LanguageCode.ky, CountryCode.KG),
  lb(LanguageCode.lb, null),
  lb_LU(LanguageCode.lb, CountryCode.LU),
  lg(LanguageCode.lg, null),
  lg_UG(LanguageCode.lg, CountryCode.UG),
  ln(LanguageCode.ln, null),
  ln_AO(LanguageCode.ln, CountryCode.AO),
  ln_CD(LanguageCode.ln, CountryCode.CD),
  ln_CF(LanguageCode.ln, CountryCode.CF),
  ln_CG(LanguageCode.ln, CountryCode.CG),
  lo(LanguageCode.lo, null),
  lo_LA(LanguageCode.lo, CountryCode.LA),

  /**
   * {@link LanguageCode#lt Lithuanian}
   */
  lt(LanguageCode.lt, null),

  /**
   * {@link LanguageCode#lt Lithuanian}, {@link CountryCode#LT Lithuania}
   */
  lt_LT(LanguageCode.lt, CountryCode.LT),
  lu(LanguageCode.lu, null),
  lu_CD(LanguageCode.lu, CountryCode.CD),

  /**
   * {@link LanguageCode#lv Latvian}
   */
  lv(LanguageCode.lv, null),

  /**
   * {@link LanguageCode#lv Latvian}, {@link CountryCode#LV Latvia}
   */
  lv_LV(LanguageCode.lv, CountryCode.LV),
  mg(LanguageCode.mg, null),
  mg_MG(LanguageCode.mg, CountryCode.MG),
  mi(LanguageCode.mi, null),
  mi_NZ(LanguageCode.mi, CountryCode.NZ),

  /**
   * {@link LanguageCode#mk Macedonian}
   */
  mk(LanguageCode.mk, null),

  /**
   * {@link LanguageCode#mk Macedonian}, {@link CountryCode#MK Macedonia, the former Yugoslav Republic of}
   */
  mk_MK(LanguageCode.mk, CountryCode.MK),
  ml(LanguageCode.ml, null),
  ml_IN(LanguageCode.ml, CountryCode.IN),
  mn(LanguageCode.mn, null),
  mn_MN(LanguageCode.mn, CountryCode.MN),
  mr(LanguageCode.mr, null),
  mr_IN(LanguageCode.mr, CountryCode.IN),

  /**
   * {@link LanguageCode#ms Malay}
   */
  ms(LanguageCode.ms, null),
  ms_BN(LanguageCode.ms, CountryCode.BN),
  ms_ID(LanguageCode.ms, CountryCode.ID),

  /**
   * {@link LanguageCode#ms Malay}, {@link CountryCode#MY Malaysia}
   */
  ms_MY(LanguageCode.ms, CountryCode.MY),
  ms_SG(LanguageCode.ms, CountryCode.SG),

  /**
   * {@link LanguageCode#mt Maltese}
   */
  mt(LanguageCode.mt, null),

  /**
   * {@link LanguageCode#mt Maltese}, {@link CountryCode#MT Malta}
   */
  mt_MT(LanguageCode.mt, CountryCode.MT),
  my(LanguageCode.my, null),
  my_MM(LanguageCode.my, CountryCode.MM),

  /**
   * {@link LanguageCode#nb Norwegian Bokm&aring;l}
   *
   * @since 1.8
   */
  nb(LanguageCode.nb, null),

  /**
   * {@link LanguageCode#nb Norwegian Bokm&aring;l}, {@link CountryCode#NO Norway}
   *
   * @since 1.8
   */
  nb_NO(LanguageCode.nb, CountryCode.NO),
  nb_SJ(LanguageCode.nb, CountryCode.SJ),
  nd(LanguageCode.nd, null),
  nd_ZW(LanguageCode.nd, CountryCode.ZW),
  ne(LanguageCode.ne, null),
  ne_IN(LanguageCode.ne, CountryCode.IN),
  ne_NP(LanguageCode.ne, CountryCode.NP),

  /**
   * {@link LanguageCode#nl Dutch}
   */
  nl(LanguageCode.nl, null),
  nl_AW(LanguageCode.nl, CountryCode.AW),

  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#BE Belgium}
   */
  nl_BE(LanguageCode.nl, CountryCode.BE),
  nl_BQ(LanguageCode.nl, CountryCode.BQ),
  nl_CW(LanguageCode.nl, CountryCode.CW),

  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#NL Netherlands}
   */
  nl_NL(LanguageCode.nl, CountryCode.NL),

  /**
   * {@link LanguageCode#nn Norwegian Nynorsk}, {@link CountryCode#NO Norway}
   */
  nn_NO(LanguageCode.nn, CountryCode.NO),
  nl_SR(LanguageCode.nl, CountryCode.SR),
  nl_SX(LanguageCode.nl, CountryCode.SX),
  nn(LanguageCode.nn, null),

  /**
   * {@link LanguageCode#no Norwegian}
   *
   * @see <a href="https://web.archive.org/web/20211017053710/http://i18n.skolelinux.no/localekoder.txt"
   * >Spr&aring;kkoder for POSIX locale i Norge</a>
   * @see <a href="https://bugzilla.redhat.com/show_bug.cgi?id=532487"
   * >Red Hat Bugzilla – Bug 532487 Legacy Norwegian locale (no_NO)
   * should be removed from language selection menu</a>
   * @deprecated {@link #nb} or {@link #nb_NO} should be used.
   */
  @Deprecated
  no(LanguageCode.no, null),

  /**
   * {@link LanguageCode#no Norwegian}, {@link CountryCode#NO Norway}
   *
   * @see <a href="https://web.archive.org/web/20211017053710/http://i18n.skolelinux.no/localekoder.txt"
   * >Spr&aring;kkoder for POSIX locale i Norge</a>
   * @see <a href="https://bugzilla.redhat.com/show_bug.cgi?id=532487"
   * >Red Hat Bugzilla – Bug 532487 Legacy Norwegian locale (no_NO)
   * should be removed from language selection menu</a>
   * @deprecated {@link #nb_NO} should be used.
   */
  @Deprecated
  no_NO(LanguageCode.no, CountryCode.NO),
  oc(LanguageCode.oc, null),
  oc_ES(LanguageCode.oc, CountryCode.ES),
  oc_FR(LanguageCode.oc, CountryCode.FR),
  om(LanguageCode.om, null),
  om_ET(LanguageCode.om, CountryCode.ET),
  om_KE(LanguageCode.om, CountryCode.KE),
  or(LanguageCode.or, null),
  or_IN(LanguageCode.or, CountryCode.IN),
  os(LanguageCode.os, null),
  os_GE(LanguageCode.os, CountryCode.GE),
  os_RU(LanguageCode.os, CountryCode.RU),
  pa(LanguageCode.pa, null),
  pa_IN(LanguageCode.pa, CountryCode.IN),
  pa_PK(LanguageCode.pa, CountryCode.PK),

  /**
   * {@link LanguageCode#pl Polish}
   */
  pl(LanguageCode.pl, null),

  /**
   * {@link LanguageCode#pl Polish}, {@link CountryCode#PL Poland}
   */
  pl_PL(LanguageCode.pl, CountryCode.PL),
  ps(LanguageCode.ps, null),
  ps_AF(LanguageCode.ps, CountryCode.AF),
  ps_PK(LanguageCode.ps, CountryCode.PK),

  /**
   * {@link LanguageCode#pt Portuguese}
   */
  pt(LanguageCode.pt, null),
  pt_AO(LanguageCode.pt, CountryCode.AO),

  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#BR Brazil}
   */
  pt_BR(LanguageCode.pt, CountryCode.BR),
  pt_CH(LanguageCode.pt, CountryCode.CH),
  pt_CV(LanguageCode.pt, CountryCode.CV),
  pt_GQ(LanguageCode.pt, CountryCode.GQ),
  pt_GW(LanguageCode.pt, CountryCode.GW),
  pt_LU(LanguageCode.pt, CountryCode.LU),
  pt_MO(LanguageCode.pt, CountryCode.MO),
  pt_MZ(LanguageCode.pt, CountryCode.MZ),

  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#PT Portugal}
   */
  pt_PT(LanguageCode.pt, CountryCode.PT),
  pt_ST(LanguageCode.pt, CountryCode.ST),
  pt_TL(LanguageCode.pt, CountryCode.TL),
  qu(LanguageCode.qu, null),
  qu_BO(LanguageCode.qu, CountryCode.BO),
  qu_EC(LanguageCode.qu, CountryCode.EC),
  qu_PE(LanguageCode.qu, CountryCode.PE),
  rm(LanguageCode.rm, null),
  rm_CH(LanguageCode.rm, CountryCode.CH),
  rn(LanguageCode.rn, null),
  rn_BI(LanguageCode.rn, CountryCode.BI),

  /**
   * {@link LanguageCode#ro Romanian}
   */
  ro(LanguageCode.ro, null),

  /**
   * {@link LanguageCode#ro Romanian}, {@link CountryCode#MD Moldova, Republic of}
   */
  ro_MD(LanguageCode.ro, CountryCode.MD),

  /**
   * {@link LanguageCode#ro Romanian}, {@link CountryCode#RO Romania}
   */
  ro_RO(LanguageCode.ro, CountryCode.RO),

  /**
   * {@link LanguageCode#ru Russian}
   */
  ru(LanguageCode.ru, null),
  ru_BY(LanguageCode.ru, CountryCode.BY),
  ru_KG(LanguageCode.ru, CountryCode.KG),

  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#KZ Kazakhstan}
   *
   * @since 1.22
   */
  ru_KZ(LanguageCode.ru, CountryCode.KZ),
  ru_MD(LanguageCode.ru, CountryCode.MD),

  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#RU Russian Federation}
   */
  ru_RU(LanguageCode.ru, CountryCode.RU),
  ru_UA(LanguageCode.ru, CountryCode.UA),
  rw(LanguageCode.rw, null),
  rw_RW(LanguageCode.rw, CountryCode.RW),
  sa(LanguageCode.sa, null),
  sa_IN(LanguageCode.sa, CountryCode.IN),
  sc(LanguageCode.sc, null),
  sc_IT(LanguageCode.sc, CountryCode.IT),
  sd(LanguageCode.sd, null),
  sd_IN(LanguageCode.sd, CountryCode.IN),
  sd_PK(LanguageCode.sd, CountryCode.PK),

  /**
   * {@link LanguageCode#se Northern Sami}
   *
   * @since 1.8
   */
  se(LanguageCode.se, null),
  se_FI(LanguageCode.se, CountryCode.FI),

  /**
   * {@link LanguageCode#se Northern Sami}, {@link CountryCode#NO Norway}
   *
   * @since 1.8
   */
  se_NO(LanguageCode.se, CountryCode.NO),
  se_SE(LanguageCode.se, CountryCode.SE),
  sg(LanguageCode.sg, null),
  sg_CF(LanguageCode.sg, CountryCode.CF),
  si(LanguageCode.si, null),
  si_LK(LanguageCode.si, CountryCode.LK),

  /**
   * {@link LanguageCode#sk Slovak}
   */
  sk(LanguageCode.sk, null),

  /**
   * {@link LanguageCode#sk Slovak}, {@link CountryCode#SK Slovakia}
   */
  sk_SK(LanguageCode.sk, CountryCode.SK),

  /**
   * {@link LanguageCode#sl Slovene}
   */
  sl(LanguageCode.sl, null),

  /**
   * {@link LanguageCode#sl Slovene}, {@link CountryCode#SI Slovenia}
   */
  sl_SI(LanguageCode.sl, CountryCode.SI),
  sn(LanguageCode.sn, null),
  sn_ZW(LanguageCode.sn, CountryCode.ZW),
  so(LanguageCode.so, null),
  so_DJ(LanguageCode.so, CountryCode.DJ),
  so_ET(LanguageCode.so, CountryCode.ET),
  so_KE(LanguageCode.so, CountryCode.KE),
  so_SO(LanguageCode.so, CountryCode.SO),

  /**
   * {@link LanguageCode#sq Albanian}
   */
  sq(LanguageCode.sq, null),

  /**
   * {@link LanguageCode#sq Albanian}, {@link CountryCode#AL Albania}
   */
  sq_MK(LanguageCode.sq, CountryCode.MK),
  sq_XK(LanguageCode.sq, CountryCode.XK),
  sq_AL(LanguageCode.sq, CountryCode.AL),

  /**
   * {@link LanguageCode#sr Serbian}
   */
  sr(LanguageCode.sr, null),

  /**
   * {@link LanguageCode#sr Serbian}, {@link CountryCode#BA Bosnia and Herzegovina}
   */
  sr_BA(LanguageCode.sr, CountryCode.BA),

  /**
   * {@link LanguageCode#sr Serbian}, {@link CountryCode#CS Serbia and Montenegro}
   */
  sr_CS(LanguageCode.sr, CountryCode.CS),

  /**
   * {@link LanguageCode#sr Serbian}, {@link CountryCode#ME Montenegro}
   */
  sr_ME(LanguageCode.sr, CountryCode.ME),

  /**
   * {@link LanguageCode#sr Serbian}, {@link CountryCode#RS Serbia}
   */
  sr_RS(LanguageCode.sr, CountryCode.RS),
  st(LanguageCode.st, null),
  st_LS(LanguageCode.st, CountryCode.LS),
  st_ZA(LanguageCode.st, CountryCode.ZA),
  su(LanguageCode.su, null),
  su_ID(LanguageCode.su, CountryCode.ID),

  /**
   * {@link LanguageCode#sv Swedish}
   */
  sv(LanguageCode.sv, null),
  sv_AX(LanguageCode.sv, CountryCode.AX),
  sv_FI(LanguageCode.sv, CountryCode.FI),

  /**
   * {@link LanguageCode#sv Swedish}, {@link CountryCode#SE Sweden}
   */
  sv_SE(LanguageCode.sv, CountryCode.SE),
  sw(LanguageCode.sw, null),
  sw_CD(LanguageCode.sw, CountryCode.CD),
  sw_KE(LanguageCode.sw, CountryCode.KE),
  sw_TZ(LanguageCode.sw, CountryCode.TZ),
  sw_UG(LanguageCode.sw, CountryCode.UG),
  ta(LanguageCode.ta, null),
  ta_IN(LanguageCode.ta, CountryCode.IN),
  ta_LK(LanguageCode.ta, CountryCode.LK),
  ta_MY(LanguageCode.ta, CountryCode.MY),
  ta_SG(LanguageCode.ta, CountryCode.SG),
  te(LanguageCode.te, null),
  te_IN(LanguageCode.te, CountryCode.IN),
  tg(LanguageCode.tg, null),
  tg_TJ(LanguageCode.tg, CountryCode.TJ),

  /**
   * {@link LanguageCode#th Thai}
   */
  th(LanguageCode.th, null),

  /**
   * {@link LanguageCode#th Thai}, {@link CountryCode#TH Thailand}
   */
  th_TH(LanguageCode.th, CountryCode.TH),
  ti(LanguageCode.ti, null),
  ti_ER(LanguageCode.ti, CountryCode.ER),
  ti_ET(LanguageCode.ti, CountryCode.ET),
  tk(LanguageCode.tk, null),
  tk_TM(LanguageCode.tk, CountryCode.TM),
  tn(LanguageCode.tn, null),
  tn_BW(LanguageCode.tn, CountryCode.BW),
  tn_ZA(LanguageCode.tn, CountryCode.ZA),
  to(LanguageCode.to, null),
  to_TO(LanguageCode.to, CountryCode.TO),

  /**
   * {@link LanguageCode#tr Turkish}
   */
  tr(LanguageCode.tr, null),
  tr_CY(LanguageCode.tr, CountryCode.CY),

  /**
   * {@link LanguageCode#tr Turkish}, {@link CountryCode#TR Turkey}
   */
  tr_TR(LanguageCode.tr, CountryCode.TR),
  tt(LanguageCode.tt, null),
  tt_RU(LanguageCode.tt, CountryCode.RU),
  ug(LanguageCode.ug, null),
  ug_CN(LanguageCode.ug, CountryCode.CN),

  /**
   * {@link LanguageCode#uk Ukrainian}
   */
  uk(LanguageCode.uk, null),

  /**
   * {@link LanguageCode#uk Ukrainian}, {@link CountryCode#UA Ukraine}
   */
  uk_UA(LanguageCode.uk, CountryCode.UA),
  ur(LanguageCode.ur, null),
  ur_IN(LanguageCode.ur, CountryCode.IN),

  /**
   * {@link LanguageCode#ur Urdu}, {@link CountryCode#PK Pakistan}
   */
  ur_PK(LanguageCode.ur, CountryCode.PK),
  uz(LanguageCode.uz, null),
  uz_AF(LanguageCode.uz, CountryCode.AF),
  uz_UZ(LanguageCode.uz, CountryCode.UZ),

  /**
   * {@link LanguageCode#vi Vietnamese}
   */
  vi(LanguageCode.vi, null),

  /**
   * {@link LanguageCode#vi Vietnamese}, {@link CountryCode#VN Viet Nam}
   */
  vi_VN(LanguageCode.vi, CountryCode.VN),
  wo(LanguageCode.wo, null),
  wo_SN(LanguageCode.wo, CountryCode.SN),
  xh(LanguageCode.xh, null),
  xh_ZA(LanguageCode.xh, CountryCode.ZA),
  yi(LanguageCode.yi, null),
  yi_UA(LanguageCode.yi, CountryCode.UA),
  yo(LanguageCode.yo, null),
  yo_BJ(LanguageCode.yo, CountryCode.BJ),
  yo_NG(LanguageCode.yo, CountryCode.NG),
  za(LanguageCode.za, null),
  za_CN(LanguageCode.za, CountryCode.CN),

  /**
   * {@link LanguageCode#zh Chinese}
   */
  zh(LanguageCode.zh, null) {
    @Override
    public Locale toLocale() {
      return Locale.CHINESE;
    }
  },

  /**
   * {@link LanguageCode#zh Chinese}, {@link CountryCode#CN China}
   */
  zh_CN(LanguageCode.zh, CountryCode.CN) {
    @Override
    public Locale toLocale() {
      return Locale.SIMPLIFIED_CHINESE;
    }
  },

  /**
   * {@link LanguageCode#zh Chinese}, {@link CountryCode#HK Hong Kong}
   */
  zh_HK(LanguageCode.zh, CountryCode.HK),
  zh_MO(LanguageCode.zh, CountryCode.MO),

  /**
   * {@link LanguageCode#zh Chinese}, {@link CountryCode#SG Singapore}
   */
  zh_SG(LanguageCode.zh, CountryCode.SG),

  /**
   * {@link LanguageCode#zh Chinese}, {@link CountryCode#TW Taiwan, Province of China}
   */
  zh_TW(LanguageCode.zh, CountryCode.TW) {
    @Override
    public Locale toLocale() {
      return Locale.TRADITIONAL_CHINESE;
    }
  },

  /**
   * {@link LanguageCode#zu Zulu}
   */
  zu(LanguageCode.zu, null),
  zu_ZA(LanguageCode.zu, CountryCode.ZA),
  ;


  private static final Locale undefinedLocale = getUndefinedLocale();

  private final LanguageCode language;
  private final CountryCode country;
  private final String string;


  LocaleCode(LanguageCode language, CountryCode country) {
    this.language = language;
    this.country = country;

    if (country == null) {
      string = language.name();
    } else {
      string = language.name() + "-" + country.name();
    }
  }


  /**
   * Get the language code.
   *
   * @return The language code. This method always returns a non-null value.
   */
  public LanguageCode getLanguage() {
    return language;
  }


  /**
   * Get the country code.
   *
   * @return The country code. This method may return null.
   * For example, {@link #en LocaleCode.en}.getCountry() returns null.
   */
  public CountryCode getCountry() {
    return country;
  }


  /**
   * Get the string representation of this locale code. Its format is
   * either of the following:
   *
   * <ul>
   * <li><i>language</i></li>
   * <li><i>language</i><code>-</code><i>country</i>
   * </ul>
   *
   * <p>
   * where <i>language</i> is an <a
   * href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a> code
   * and <i>country</i> is an <a
   * href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1
   * alpha-2</a> code.
   * </p>
   *
   * @return The string representation of this locale code.
   */
  @Override
  public String toString() {
    return string;
  }


  /**
   * Convert this {@code LocaleCode} instance to a {@link Locale} instance.
   *
   * <p>
   * In most cases, this method creates a new {@code Locale} instance
   * every time it is called, but some {@code LocaleCode} instances
   * return their corresponding entries in {@code Locale} class.
   * For example, {@link #it LocaleCode.it} always returns
   * {@link Locale#ITALIAN}.
   * </p>
   *
   * <p>
   * The table below lists {@code LocaleCode} entries whose {@code toLocale()}
   * does not create a new {@code Locale} instance but returns an entry in
   * {@code Locale} class.
   * </p>
   *
   * <table border="1" style="border-collapse: collapse; padding: 5px;">
   * <caption>Table of Locale codes</caption>
   * <tr style="background: #FF8C00;">
   *   <th>LocaleCode</th>
   *   <th>Locale</th>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#de LocaleCode.de}</td>
   *   <td>{@link Locale#GERMAN}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#en LocaleCode.en}</td>
   *   <td>{@link Locale#ENGLISH}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#fr LocaleCode.fr}</td>
   *   <td>{@link Locale#FRENCH}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#fr_CA LocaleCode.fr_CA}</td>
   *   <td>{@link Locale#CANADA_FRENCH}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#it LocaleCode.it}</td>
   *   <td>{@link Locale#ITALIAN}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#ja LocaleCode.ja}</td>
   *   <td>{@link Locale#JAPANESE}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#ko LocaleCode.ko}</td>
   *   <td>{@link Locale#KOREAN}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#zh LocaleCode.zh}</td>
   *   <td>{@link Locale#CHINESE}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#zh_CN LocaleCode.zh_CN}</td>
   *   <td>{@link Locale#SIMPLIFIED_CHINESE}</td>
   * </tr>
   * <tr>
   *   <td>{@link LocaleCode#zh_TW LocaleCode.zh_TW}</td>
   *   <td>{@link Locale#TRADITIONAL_CHINESE}</td>
   * </tr>
   * </table>
   *
   * <p>
   * In addition, {@code toLocale()} of {@link LocaleCode#undefined
   * LocaleCode.undefined} behaves a bit differently. It returns
   * {@link Locale#ROOT Locale.ROOT} when it is available (i.e. when
   * the version of Java SE is 1.6 or higher). Otherwise, it returns
   * a {@code Locale} instance whose language and country are empty
   * strings. Even in the latter case, the same instance is returned
   * on every call.
   * </p>
   *
   * @return A {@code Locale} instance that matches this {@code LocaleCode}.
   */
  @SuppressWarnings("deprecation")
  public Locale toLocale() {
    if (country != null) {
      return new Locale(language.name(), country.name());
    } else {
      return new Locale(language.name());
    }
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given code.
   *
   * <p>
   * This method just calls {@link #getByCode(String, boolean) getByCode}{@code (code, true)}.
   * Note that the behaviour has changed since the version 1.13. In the older versions,
   * this method was an alias of {@code getByCode(code, false)}.
   * </p>
   *
   * @param code A locale code.
   * @return A {@code LocaleCode} instance, or {@code null} if not found.
   * @see #getByCode(String, boolean)
   */
  public static LocaleCode getByCode(String code) {
    return getByCode(code, true);
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given code.
   *
   * <p>
   * This method just calls {@link #getByCode(String, boolean) getByCode}{@code (code, false)}.
   * </p>
   *
   * @param code A locale code.
   * @return A {@code LocaleCode} instance, or {@code null} if not found.
   * @see #getByCode(String, boolean)
   * @since 1.13
   */
  public static LocaleCode getByCodeIgnoreCase(String code) {
    return getByCode(code, false);
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given code.
   *
   * <p>
   * The format of the code should be either of the following:
   * </p>
   *
   * <ul>
   * <li><i>language</i></li>
   * <li><i>language</i><code>-</code><i>country</i>
   * </ul>
   *
   * <p>
   * where <i>language</i> is an <a
   * href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a> code
   * and <i>country</i> is an <a
   * href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1
   * alpha-2</a> code. The separator between <i>language</i> and
   * <i>country</i> should be a hyphen (<code>-</code>) or an underscore
   * (<code>_</code>).
   * </p>
   *
   * <p>
   * Note that if the language part of the given code is one of legacy
   * ones { "iw", "ji" and "in" }, it is regarded as its newer official
   * counterpart { "he", "yi" and "id" }, respectively.
   * </p>
   *
   * @param code          A locale code.
   * @param caseSensitive If {@code true}, the <i>language</i> part of the given code must be
   *                      lower-case and the <i>country</i> part, if not {@code null}, must be
   *                      upper-case. If false, this method internally canonicalizes
   *                      the given code and then performs search.
   * @return A {@code LocaleCode} instance, or {@code null} if not found.
   */
  public static LocaleCode getByCode(String code, boolean caseSensitive) {
    if (code == null) {
      return null;
    }

    switch (code.length()) {
      case 2:
      case 9:
        // The given code is regarded as a language code.
        return getByCode(code, null, caseSensitive);

      case 5:
        return getByCombinedCode(code, caseSensitive, 2);

      case 19:
        return getByCombinedCode(code, caseSensitive, 9);

      default:
        return null;
    }
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given pair of
   * language code and country code.
   *
   * <p>
   * This method just calls {@link #getByCode(String, String, boolean)
   * getByCode}{@code (language, country, true)}.
   * Note that the behaviour has changed since the version 1.13.
   * In the older versions, this method was an alias of {@code
   * getByCode(language, country, false)}.
   * </p>
   *
   * @param language <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a>
   *                 language code. Or "undefined" (case-sensitive). If the
   *                 given language code is one of legacy ones { "iw", "ji" and
   *                 "in" }, it is regarded as its newer official counterpart { "he",
   *                 "yi" and "id" }, respectively.
   * @param country  <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
   *                 country code. Or "UNDEFINED" (case-sensitive).
   * @return A {@code LocaleCode}, or {@code null} if not found.
   * @see #getByCode(String, String, boolean)
   */
  public static LocaleCode getByCode(String language, String country) {
    return getByCode(language, country, true);
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given pair of
   * language code and country code.
   *
   * <p>
   * This method just calls {@link #getByCode(String, String, boolean)
   * getByCode}{@code (language, country, false)}.
   * </p>
   *
   * @param language <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a>
   *                 language code. Or "undefined" (case-insensitive). If the given
   *                 language code is one of legacy ones { "iw", "ji" and "in" },
   *                 it is regarded as its newer counterpart { "he", "yi" and "id"
   *                 }, respectively.
   * @param country  <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
   *                 >ISO 3166-1 alpha-2</a> country code. Or "UNDEFINED"
   *                 (case-insensitive).
   * @return A {@code LocaleCode}, or {@code null} if not found.
   * @see #getByCode(String, String, boolean)
   * @since 1.13
   */
  public static LocaleCode getByCodeIgnoreCase(String language, String country) {
    return getByCode(language, country, false);
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given pair of
   * language code and country code.
   *
   * <p>
   * If {@code language} is "undefined" and if {@code country} is {@code null}
   * or "UNDEFINED", {@link #undefined LocaleCode.undefined} is returned.
   * </p>
   *
   * @param language      <a href="https://en.wikipedia.org/wiki/ISO_639-1">ISO 639-1</a>
   *                      language code. Or "undefined". If the given language code
   *                      is one of legacy ones { "iw", "ji" and "in" }, it is regarded
   *                      as its newer official counterpart { "he", "yi" and "id" },
   *                      respectively.
   * @param country       <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
   *                      >ISO 3166-1 alpha-2</a> country code. Or "UNDEFINED".
   * @param caseSensitive If {@code true}, the given language code must be lower-case and
   *                      the given country code, if not {@code null}, must be upper-case.
   *                      If {@code false}, this method internally canonicalizes the given
   *                      codes and then performs search.
   * @return A {@code LocaleCode}, or {@code null} if not found.
   */
  public static LocaleCode getByCode(String language, String country, boolean caseSensitive) {
    // Canonicalize the given language code.
    language = LanguageCode.canonicalize(language, caseSensitive);

    if (language == null) {
      // There is no LocaleCode whose language is not given.
      return null;
    }

    // Canonicalize the given country code.
    country = CountryCode.canonicalize(country, caseSensitive);

    if (language.equals("undefined") && (country == null || country.equals("UNDEFINED"))) {
      return LocaleCode.undefined;
    }

    if (country == null) {
      return getByEnumName(language);
    } else {
      return getByEnumName(language + "_" + country);
    }
  }


  /**
   * Get a {@code LocaleCode} instance that corresponds to the given
   * {@link Locale} instance.
   *
   * @param locale A {@code Locale} instance.
   * @return A {@code LocaleCode} instance, or {@code null} if not found.
   * When the value returned by {@link Locale#getLanguage() getLanguage()}
   * method of the given instance is {@code null} or an empty string and
   * the value returned by {@link Locale#getCountry() getCountry()} method
   * of the given instance is {@code null} or an empty string,
   * {@link #undefined LocaleCode.undefined} is returned.
   */
  public static LocaleCode getByLocale(Locale locale) {
    if (locale == null) {
      return null;
    }

    // Locale.getLanguage() returns either an empty string or
    // a lower-case ISO 639 code.
    String language = locale.getLanguage();

    // Locale.getCountry() returns either an empty string or
    // an upper-case ISO 3166-1 alpha-2 code.
    String country = locale.getCountry();

    if (language.isEmpty() && country.isEmpty()) {
      return LocaleCode.undefined;
    }

    // 'language' and 'country' are already lower-case and upper-case,
    // so true can be given as the third argument.
    return getByCode(language, country, true);
  }


  private static LocaleCode getByCombinedCode(String code, boolean caseSensitive, int splitPosition) {
    // Get the character that separates the language code from the country code.
    char separator = code.charAt(splitPosition);

    if (separator == '_') {
      if (caseSensitive && splitPosition == 2) {
        // The given code can be handled as enum name.
        return getByEnumName(code);
      }
    } else if (separator != '-') {
      // Bad format.
      return null;
    }

    // Extract the language part and the country part from the given code.
    String language = code.substring(0, splitPosition);
    String country = code.substring(splitPosition + 1);

    return getByCode(language, country, caseSensitive);
  }


  private static LocaleCode getByEnumName(String name) {
    try {
      return Enum.valueOf(LocaleCode.class, name);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }


  /**
   * Get a list of {@code LocaleCode} instances whose language matches the given one.
   *
   * <p>
   * This method is an alias of {@link #getByLanguage(String, boolean)
   * getByLanguage}{@code (language, true)}.
   * Note that the behaviour has changed since the version 1.13. In the older versions,
   * this method was an alias of {@code getByLanguage(language, false)}.
   * </p>
   *
   * @param language Language code. ISO 639 alpha-2 or alpha-3.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose language matches the given one, the size of the returned
   * list is zero.
   * @since 1.3
   */
  public static List<LocaleCode> getByLanguage(String language) {
    return getByLanguage(language, true);
  }


  /**
   * Get a list of {@code LocaleCode} instances whose language matches the given one.
   *
   * <p>
   * This method is an alias of {@link #getByLanguage(String, boolean)
   * getByLanguage}{@code (language, false)}.
   * </p>
   *
   * @param language Language code. ISO 639 alpha-2 or alpha-3.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose language matches the given one, the size of the returned
   * list is zero.
   * @since 1.13
   */
  public static List<LocaleCode> getByLanguageIgnoreCase(String language) {
    return getByLanguage(language, false);
  }


  /**
   * Get a list of {@code LocaleCode} instances whose language matches the given one.
   *
   * <p>
   * This method is an alias of {@link #getByLanguage(LanguageCode)
   * getByLanguage}{@code (}{@link LanguageCode}{@code .}{@link
   * LanguageCode#getByCode(String, boolean) getByCode}{@code (language, caseSensitive))}.
   * </p>
   *
   * @param language      Language code. ISO 639 alpha-2 or alpha-3.
   * @param caseSensitive If {@code true}, the given code should consist of lowercase letters only.
   *                      If {@code false}, case is ignored.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose language matches the given one, the size of the returned
   * list is zero.
   * @since 1.3
   */
  public static List<LocaleCode> getByLanguage(String language, boolean caseSensitive) {
    return getByLanguage(LanguageCode.getByCode(language, caseSensitive));
  }


  /**
   * Get a list of {@code LocaleCode} instances whose language matches the given one.
   *
   * @param language {@code LanguageCode} instance that represents a language.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose language matches the given one, the size of the returned
   * list is zero.
   * @since 1.3
   */
  public static List<LocaleCode> getByLanguage(LanguageCode language) {
    List<LocaleCode> list = new ArrayList<>();

    if (language == null) {
      return emptyList();
    }

    for (LocaleCode code : values()) {
      if (code.getLanguage() == language) {
        list.add(code);
      }
    }

    return list;
  }


  /**
   * Get a list of {@code LocaleCode} instances whose country matches the given one.
   *
   * <p>
   * This method is an alias of {@link #getByCountry(String, boolean)
   * getByCountry}{@code (country, true)}.
   * Note that the behaviour has changed since the version 1.13. In the older versions,
   * this method was an alias of {@code getByCountry(country, false)}.
   * </p>
   *
   * @param country Country code. ISO 3166-1 alpha-2 or alpha-3.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose country matches the given one, the size of the returned
   * list is zero.
   * @since 1.3
   */
  public static List<LocaleCode> getByCountry(String country) {
    return getByCountry(country, true);
  }


  /**
   * Get a list of {@code LocaleCode} instances whose country matches the given one.
   *
   * <p>
   * This method is an alias of {@link #getByCountry(String, boolean)
   * getByCountry}{@code (country, false)}.
   * </p>
   *
   * @param country Country code. ISO 3166-1 alpha-2 or alpha-3.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose country matches the given one, the size of the returned
   * list is zero.
   * @since 1.13
   */
  public static List<LocaleCode> getByCountryIgnoreCase(String country) {
    return getByCountry(country, false);
  }


  /**
   * Get a list of {@code LocaleCode} instances whose country matches the given one.
   *
   * <p>
   * This method is an alias of {@link #getByCountry(CountryCode)
   * getByCountry}{@code (}{@link CountryCode}{@code .}{@link
   * CountryCode#getByCode(String, boolean) getByCode}{@code
   * (country, caseSensitive))}.
   * </p>
   *
   * @param country       Country code. ISO 3166-1 alpha-2 or alpha-3.
   * @param caseSensitive If {@code true}, the given code should consist of uppercase letters only.
   *                      If {@code false}, case is ignored.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose country matches the given one, the size of the returned
   * list is zero.
   * @since 1.3
   */
  public static List<LocaleCode> getByCountry(String country, boolean caseSensitive) {
    return getByCountry(CountryCode.getByCode(country, caseSensitive));
  }


  /**
   * Get a list of {@code LocaleCode} instances whose country matches the given one.
   *
   * @param country {@code CountryCode} instance that represents a country.
   * @return List of {@code LocaleCode} instances. If there is no {@code LocaleCode}
   * instance whose country matches the given one, the size of the returned
   * list is zero.
   * @since 1.3
   */
  public static List<LocaleCode> getByCountry(CountryCode country) {
    List<LocaleCode> list = new ArrayList<>();

    if (country == null) {
      return emptyList();
    }

    for (LocaleCode code : values()) {
      if (code.getCountry() == country) {
        list.add(code);
      }
    }

    return list;
  }

  @SuppressWarnings("deprecation")
  private static Locale getUndefinedLocale() {
    try {
      // Try to get Locale.ROOT which is available since Java SE 1.6.
      Field root = Locale.class.getDeclaredField("ROOT");

      // Return Locale.ROOT.
      return (Locale) root.get(null);
    } catch (Exception e) {
      // Simulate Locale.ROOT.
      return new Locale("", "");
    }
  }
}
