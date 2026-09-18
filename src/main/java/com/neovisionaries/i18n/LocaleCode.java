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
  /**
   * {@link LanguageCode#af Afrikaans}, {@link CountryCode#NA Namibia}
   */
  af_NA(LanguageCode.af, CountryCode.NA),
  /**
   * {@link LanguageCode#af Afrikaans}, {@link CountryCode#ZA South Africa}
   */
  af_ZA(LanguageCode.af, CountryCode.ZA),
  /**
   * {@link LanguageCode#ak Akan}
   */
  ak(LanguageCode.ak, null),
  /**
   * {@link LanguageCode#ak Akan}, {@link CountryCode#GH Ghana}
   */
  ak_GH(LanguageCode.ak, CountryCode.GH),
  /**
   * {@link LanguageCode#am Amharic}
   */
  am(LanguageCode.am, null),
  /**
   * {@link LanguageCode#am Amharic}, {@link CountryCode#ET Ethiopia}
   */
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
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#DJ Djibouti}
   */
  ar_DJ(LanguageCode.ar, CountryCode.DJ),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#DZ Algeria}
   */
  ar_DZ(LanguageCode.ar, CountryCode.DZ),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#EG Egypt}
   */
  ar_EG(LanguageCode.ar, CountryCode.EG),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#EH Western Sahara}
   */
  ar_EH(LanguageCode.ar, CountryCode.EH),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#ER Eritrea}
   */
  ar_ER(LanguageCode.ar, CountryCode.ER),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#IL Israel}
   */
  ar_IL(LanguageCode.ar, CountryCode.IL),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#IQ Iraq}
   */
  ar_IQ(LanguageCode.ar, CountryCode.IQ),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#JO Jordan}
   */
  ar_JO(LanguageCode.ar, CountryCode.JO),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#KM Comoros}
   */
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
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#MR Mauritania}
   */
  ar_MR(LanguageCode.ar, CountryCode.MR),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#OM Oman}
   */
  ar_OM(LanguageCode.ar, CountryCode.OM),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#PS Palestine, State of}
   */
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
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#SO Somalia}
   */
  ar_SO(LanguageCode.ar, CountryCode.SO),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#SS South Sudan}
   */
  ar_SS(LanguageCode.ar, CountryCode.SS),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#SY Syrian Arab Republic}
   */
  ar_SY(LanguageCode.ar, CountryCode.SY),
  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#TD Chad}
   */
  ar_TD(LanguageCode.ar, CountryCode.TD),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#TN Tunisia}
   */
  ar_TN(LanguageCode.ar, CountryCode.TN),

  /**
   * {@link LanguageCode#ar Arabic}, {@link CountryCode#YE Yemen}
   */
  ar_YE(LanguageCode.ar, CountryCode.YE),
  /**
   * {@link LanguageCode#as Assamese}
   */
  as(LanguageCode.as, null),
  /**
   * {@link LanguageCode#as Assamese}, {@link CountryCode#IN India}
   */
  as_IN(LanguageCode.as, CountryCode.IN),
  /**
   * {@link LanguageCode#az Azerbaijani}
   */
  az(LanguageCode.az, null),
  /**
   * {@link LanguageCode#az Azerbaijani}, {@link CountryCode#AZ Azerbaijan}
   */
  az_AZ(LanguageCode.az, CountryCode.AZ),
  /**
   * {@link LanguageCode#ba Bashkir}
   */
  ba(LanguageCode.ba, null),
  /**
   * {@link LanguageCode#ba Bashkir}, {@link CountryCode#RU Russian Federation}
   */
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
  /**
   * {@link LanguageCode#bm Bambara}
   */
  bm(LanguageCode.bm, null),
  /**
   * {@link LanguageCode#bm Bambara}, {@link CountryCode#ML Mali}
   */
  bm_ML(LanguageCode.bm, CountryCode.ML),
  /**
   * {@link LanguageCode#bn Bengali}
   */
  bn(LanguageCode.bn, null),
  /**
   * {@link LanguageCode#bn Bengali}, {@link CountryCode#BD Bangladesh}
   */
  bn_BD(LanguageCode.bn, CountryCode.BD),
  /**
   * {@link LanguageCode#bn Bengali}, {@link CountryCode#IN India}
   */
  bn_IN(LanguageCode.bn, CountryCode.IN),
  /**
   * {@link LanguageCode#bo Tibetan}
   */
  bo(LanguageCode.bo, null),
  /**
   * {@link LanguageCode#bo Tibetan}, {@link CountryCode#CN China}
   */
  bo_CN(LanguageCode.bo, CountryCode.CN),
  /**
   * {@link LanguageCode#bo Tibetan}, {@link CountryCode#IN India}
   */
  bo_IN(LanguageCode.bo, CountryCode.IN),
  /**
   * {@link LanguageCode#br Breton}
   */
  br(LanguageCode.br, null),
  /**
   * {@link LanguageCode#br Breton}, {@link CountryCode#FR France}
   */
  br_FR(LanguageCode.br, CountryCode.FR),
  /**
   * {@link LanguageCode#bs Bosnian}
   */
  bs(LanguageCode.bs, null),

  /**
   * {@link LanguageCode#bs Bosnian}, {@link CountryCode#BA Bosnia and Herzegovina}
   */
  bs_BA(LanguageCode.bs, CountryCode.BA),

  /**
   * {@link LanguageCode#ca Catalan}
   */
  ca(LanguageCode.ca, null),
  /**
   * {@link LanguageCode#ca Catalan}, {@link CountryCode#AD Andorra}
   */
  ca_AD(LanguageCode.ca, CountryCode.AD),

  /**
   * {@link LanguageCode#ca Catalan}, {@link CountryCode#ES Spain}
   */
  ca_ES(LanguageCode.ca, CountryCode.ES),
  /**
   * {@link LanguageCode#ca Catalan}, {@link CountryCode#FR France}
   */
  ca_FR(LanguageCode.ca, CountryCode.FR),
  /**
   * {@link LanguageCode#ca Catalan}, {@link CountryCode#IT Italy}
   */
  ca_IT(LanguageCode.ca, CountryCode.IT),
  /**
   * {@link LanguageCode#ce Chechen}
   */
  ce(LanguageCode.ce, null),
  /**
   * {@link LanguageCode#ce Chechen}, {@link CountryCode#RU Russian Federation}
   */
  ce_RU(LanguageCode.ce, CountryCode.RU),

  /**
   * {@link LanguageCode#cs Czech}
   */
  cs(LanguageCode.cs, null),

  /**
   * {@link LanguageCode#cs Czech}, {@link CountryCode#CZ Czech Republic}
   */
  cs_CZ(LanguageCode.cs, CountryCode.CZ),
  /**
   * {@link LanguageCode#cv Chuvash}
   */
  cv(LanguageCode.cv, null),
  /**
   * {@link LanguageCode#cv Chuvash}, {@link CountryCode#RU Russian Federation}
   */
  cv_RU(LanguageCode.cv, CountryCode.RU),
  /**
   * {@link LanguageCode#cy Welsh}
   */
  cy(LanguageCode.cy, null),
  /**
   * {@link LanguageCode#cy Welsh}, {@link CountryCode#GB United Kingdom}
   */
  cy_GB(LanguageCode.cy, CountryCode.GB),

  /**
   * {@link LanguageCode#da Danish}
   */
  da(LanguageCode.da, null),

  /**
   * {@link LanguageCode#da Danish}, {@link CountryCode#DK Denmark}
   */
  da_DK(LanguageCode.da, CountryCode.DK),
  /**
   * {@link LanguageCode#da Danish}, {@link CountryCode#GL Greenland}
   */
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
  /**
   * {@link LanguageCode#de German}, {@link CountryCode#BE Belgium}
   */
  de_BE(LanguageCode.de, CountryCode.BE),

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#CH Switzerland}
   */
  de_CH(LanguageCode.de, CountryCode.CH),

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#DE Germany}
   */
  de_DE(LanguageCode.de, CountryCode.DE),
  /**
   * {@link LanguageCode#de German}, {@link CountryCode#IT Italy}
   */
  de_IT(LanguageCode.de, CountryCode.IT),
  /**
   * {@link LanguageCode#de German}, {@link CountryCode#LI Liechtenstein}
   */
  de_LI(LanguageCode.de, CountryCode.LI),

  /**
   * {@link LanguageCode#de German}, {@link CountryCode#LU Luxembourg}
   */
  de_LU(LanguageCode.de, CountryCode.LU),
  /**
   * {@link LanguageCode#dz Dzongkha}
   */
  dz(LanguageCode.dz, null),
  /**
   * {@link LanguageCode#dz Dzongkha}, {@link CountryCode#BT Bhutan}
   */
  dz_BT(LanguageCode.dz, CountryCode.BT),
  /**
   * {@link LanguageCode#ee Ewe}
   */
  ee(LanguageCode.ee, null),
  /**
   * {@link LanguageCode#ee Ewe}, {@link CountryCode#GH Ghana}
   */
  ee_GH(LanguageCode.ee, CountryCode.GH),
  /**
   * {@link LanguageCode#ee Ewe}, {@link CountryCode#TG Togo}
   */
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
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AE United Arab Emirates}
   */
  en_AE(LanguageCode.en, CountryCode.AE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AG Antigua and Barbuda}
   */
  en_AG(LanguageCode.en, CountryCode.AG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AI Anguilla}
   */
  en_AI(LanguageCode.en, CountryCode.AI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AS American Samoa}
   */
  en_AS(LanguageCode.en, CountryCode.AS),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AT Austria}
   */
  en_AT(LanguageCode.en, CountryCode.AT),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#AU Australia}
   */
  en_AU(LanguageCode.en, CountryCode.AU),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BB Barbados}
   */
  en_BB(LanguageCode.en, CountryCode.BB),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BE Belgium}
   */
  en_BE(LanguageCode.en, CountryCode.BE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BI Burundi}
   */
  en_BI(LanguageCode.en, CountryCode.BI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BM Bermuda}
   */
  en_BM(LanguageCode.en, CountryCode.BM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BS Bahamas}
   */
  en_BS(LanguageCode.en, CountryCode.BS),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BW Botswana}
   */
  en_BW(LanguageCode.en, CountryCode.BW),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#BZ Belize}
   */
  en_BZ(LanguageCode.en, CountryCode.BZ),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CA Canada}
   */
  en_CA(LanguageCode.en, CountryCode.CA),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CC Cocos (Keeling) Islands}
   */
  en_CC(LanguageCode.en, CountryCode.CC),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CH Switzerland}
   */
  en_CH(LanguageCode.en, CountryCode.CH),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CK Cook Islands}
   */
  en_CK(LanguageCode.en, CountryCode.CK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CM Cameroon}
   */
  en_CM(LanguageCode.en, CountryCode.CM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CX Christmas Island}
   */
  en_CX(LanguageCode.en, CountryCode.CX),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CY Cyprus}
   */
  en_CY(LanguageCode.en, CountryCode.CY),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#CZ Czech Republic}
   */
  en_CZ(LanguageCode.en, CountryCode.CZ),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#DE Germany}
   */
  en_DE(LanguageCode.en, CountryCode.DE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#DG Diego Garcia}
   */
  en_DG(LanguageCode.en, CountryCode.DG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#DK Denmark}
   */
  en_DK(LanguageCode.en, CountryCode.DK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#DM Dominica}
   */
  en_DM(LanguageCode.en, CountryCode.DM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#EE Estonia}
   */
  en_EE(LanguageCode.en, CountryCode.EE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ER Eritrea}
   */
  en_ER(LanguageCode.en, CountryCode.ER),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ES Spain}
   */
  en_ES(LanguageCode.en, CountryCode.ES),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#FI Finland}
   */
  en_FI(LanguageCode.en, CountryCode.FI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#FJ Fiji}
   */
  en_FJ(LanguageCode.en, CountryCode.FJ),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#FK Falkland Islands (Malvinas)}
   */
  en_FK(LanguageCode.en, CountryCode.FK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#FM Micronesia, Federated States of}
   */
  en_FM(LanguageCode.en, CountryCode.FM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#FR France}
   */
  en_FR(LanguageCode.en, CountryCode.FR),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GB United Kingdom}
   */
  en_GB(LanguageCode.en, CountryCode.GB),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GD Grenada}
   */
  en_GD(LanguageCode.en, CountryCode.GD),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GE Georgia}
   */
  en_GE(LanguageCode.en, CountryCode.GE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GG Guernsey}
   */
  en_GG(LanguageCode.en, CountryCode.GG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GH Ghana}
   */
  en_GH(LanguageCode.en, CountryCode.GH),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GI Gibraltar}
   */
  en_GI(LanguageCode.en, CountryCode.GI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GM Gambia}
   */
  en_GM(LanguageCode.en, CountryCode.GM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GS South Georgia and the South Sandwich Islands}
   */
  en_GS(LanguageCode.en, CountryCode.GS),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GU Guam}
   */
  en_GU(LanguageCode.en, CountryCode.GU),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#GY Guyana}
   */
  en_GY(LanguageCode.en, CountryCode.GY),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#HK Hong Kong}
   *
   * @since 1.22
   */
  en_HK(LanguageCode.en, CountryCode.HK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#HU Hungary}
   */
  en_HU(LanguageCode.en, CountryCode.HU),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ID Indonesia}
   */
  en_ID(LanguageCode.en, CountryCode.ID),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IE Ireland}
   */
  en_IE(LanguageCode.en, CountryCode.IE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IL Israel}
   */
  en_IL(LanguageCode.en, CountryCode.IL),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IM Isle of Man}
   */
  en_IM(LanguageCode.en, CountryCode.IM),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IN India}
   */
  en_IN(LanguageCode.en, CountryCode.IN),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IO British Indian Ocean Territory}
   */
  en_IO(LanguageCode.en, CountryCode.IO),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#IT Italy}
   */
  en_IT(LanguageCode.en, CountryCode.IT),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#JE Jersey}
   */
  en_JE(LanguageCode.en, CountryCode.JE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#JM Jamaica}
   */
  en_JM(LanguageCode.en, CountryCode.JM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#JP Japan}
   */
  en_JP(LanguageCode.en, CountryCode.JP),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#KE Kenya}
   */
  en_KE(LanguageCode.en, CountryCode.KE),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#KI Kiribati}
   */
  en_KI(LanguageCode.en, CountryCode.KI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#KN Saint Kitts and Nevis}
   */
  en_KN(LanguageCode.en, CountryCode.KN),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#KY Cayman Islands}
   */
  en_KY(LanguageCode.en, CountryCode.KY),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#LC Saint Lucia}
   */
  en_LC(LanguageCode.en, CountryCode.LC),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#LR Liberia}
   */
  en_LR(LanguageCode.en, CountryCode.LR),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#LS Lesotho}
   */
  en_LS(LanguageCode.en, CountryCode.LS),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#LT Lithuania}
   */
  en_LT(LanguageCode.en, CountryCode.LT),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#LV Latvia}
   */
  en_LV(LanguageCode.en, CountryCode.LV),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MG Madagascar}
   */
  en_MG(LanguageCode.en, CountryCode.MG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MH Marshall Islands}
   */
  en_MH(LanguageCode.en, CountryCode.MH),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MO Macao}
   */
  en_MO(LanguageCode.en, CountryCode.MO),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MP Northern Mariana Islands}
   */
  en_MP(LanguageCode.en, CountryCode.MP),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MS Montserrat}
   */
  en_MS(LanguageCode.en, CountryCode.MS),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MT Malta}
   */
  en_MT(LanguageCode.en, CountryCode.MT),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MU Mauritius}
   */
  en_MU(LanguageCode.en, CountryCode.MU),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MV Maldives}
   */
  en_MV(LanguageCode.en, CountryCode.MV),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MW Malawi}
   */
  en_MW(LanguageCode.en, CountryCode.MW),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#MY Malaysia}
   */
  en_MY(LanguageCode.en, CountryCode.MY),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NA Namibia}
   */
  en_NA(LanguageCode.en, CountryCode.NA),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NF Norfolk Island}
   */
  en_NF(LanguageCode.en, CountryCode.NF),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NG Nigeria}
   */
  en_NG(LanguageCode.en, CountryCode.NG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NL Netherlands}
   */
  en_NL(LanguageCode.en, CountryCode.NL),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NO Norway}
   */
  en_NO(LanguageCode.en, CountryCode.NO),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NR Naoero}
   */
  en_NR(LanguageCode.en, CountryCode.NR),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NU Niue}
   */
  en_NU(LanguageCode.en, CountryCode.NU),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#NZ New Zealand}
   */
  en_NZ(LanguageCode.en, CountryCode.NZ),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PG Papua New Guinea}
   */
  en_PG(LanguageCode.en, CountryCode.PG),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PH Philippines}
   */
  en_PH(LanguageCode.en, CountryCode.PH),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PK Pakistan}
   */
  en_PK(LanguageCode.en, CountryCode.PK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PL Poland}
   */
  en_PL(LanguageCode.en, CountryCode.PL),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PN Pitcairn}
   */
  en_PN(LanguageCode.en, CountryCode.PN),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PR Puerto Rico}
   */
  en_PR(LanguageCode.en, CountryCode.PR),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PT Portugal}
   */
  en_PT(LanguageCode.en, CountryCode.PT),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#PW Palau}
   */
  en_PW(LanguageCode.en, CountryCode.PW),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#RO Romania}
   */
  en_RO(LanguageCode.en, CountryCode.RO),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#RW Rwanda}
   */
  en_RW(LanguageCode.en, CountryCode.RW),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SB Solomon Islands}
   */
  en_SB(LanguageCode.en, CountryCode.SB),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SC Seychelles}
   */
  en_SC(LanguageCode.en, CountryCode.SC),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SD Sudan}
   */
  en_SD(LanguageCode.en, CountryCode.SD),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SE Sweden}
   */
  en_SE(LanguageCode.en, CountryCode.SE),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SG Singapore}
   */
  en_SG(LanguageCode.en, CountryCode.SG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SH Saint Helena, Ascension and Tristan da Cunha}
   */
  en_SH(LanguageCode.en, CountryCode.SH),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SI Slovenia}
   */
  en_SI(LanguageCode.en, CountryCode.SI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SK Slovakia}
   */
  en_SK(LanguageCode.en, CountryCode.SK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SL Sierra Leone}
   */
  en_SL(LanguageCode.en, CountryCode.SL),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SS South Sudan}
   */
  en_SS(LanguageCode.en, CountryCode.SS),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SX Sint Maarten (Dutch part)}
   */
  en_SX(LanguageCode.en, CountryCode.SX),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#SZ Eswatini}
   */
  en_SZ(LanguageCode.en, CountryCode.SZ),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#TC Turks and Caicos Islands}
   */
  en_TC(LanguageCode.en, CountryCode.TC),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#TK Tokelau}
   */
  en_TK(LanguageCode.en, CountryCode.TK),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#TO Tonga}
   */
  en_TO(LanguageCode.en, CountryCode.TO),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#TT Trinidad and Tobago}
   */
  en_TT(LanguageCode.en, CountryCode.TT),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#TV Tuvalu}
   */
  en_TV(LanguageCode.en, CountryCode.TV),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#TZ Tanzania, United Republic of}
   */
  en_TZ(LanguageCode.en, CountryCode.TZ),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#UA Ukraine}
   */
  en_UA(LanguageCode.en, CountryCode.UA),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#UG Uganda}
   */
  en_UG(LanguageCode.en, CountryCode.UG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#UM United States Minor Outlying Islands}
   */
  en_UM(LanguageCode.en, CountryCode.UM),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#US United States}
   */
  en_US(LanguageCode.en, CountryCode.US),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#VC Saint Vincent and the Grenadines}
   */
  en_VC(LanguageCode.en, CountryCode.VC),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#VG Virgin Islands, British}
   */
  en_VG(LanguageCode.en, CountryCode.VG),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#VI Virgin Islands, U.S.}
   */
  en_VI(LanguageCode.en, CountryCode.VI),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#VU Vanuatu}
   */
  en_VU(LanguageCode.en, CountryCode.VU),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#WS Samoa}
   */
  en_WS(LanguageCode.en, CountryCode.WS),

  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ZA South Africa}
   */
  en_ZA(LanguageCode.en, CountryCode.ZA),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ZM Zambia}
   */
  en_ZM(LanguageCode.en, CountryCode.ZM),
  /**
   * {@link LanguageCode#en English}, {@link CountryCode#ZW Zimbabwe}
   */
  en_ZW(LanguageCode.en, CountryCode.ZW),
  /**
   * {@link LanguageCode#eo Esperanto}
   */
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
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#BR Brazil}
   */
  es_BR(LanguageCode.es, CountryCode.BR),
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#BZ Belize}
   */
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
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#CU Cuba}
   */
  es_CU(LanguageCode.es, CountryCode.CU),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#DO Dominican Republic}
   */
  es_DO(LanguageCode.es, CountryCode.DO),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#EC Ecuador}
   */
  es_EC(LanguageCode.es, CountryCode.EC),
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#EA Ceuta, Melilla}
   */
  es_EA(LanguageCode.es, CountryCode.EA),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#ES Spain}
   */
  es_ES(LanguageCode.es, CountryCode.ES),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#GT Guatemala}
   */
  es_GT(LanguageCode.es, CountryCode.GT),
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#GQ Equatorial Guinea}
   */
  es_GQ(LanguageCode.es, CountryCode.GQ),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#HN Honduras}
   */
  es_HN(LanguageCode.es, CountryCode.HN),

  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#MX Mexico}
   */
  es_MX(LanguageCode.es, CountryCode.MX),
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#IC Canary Islands}
   */
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
  /**
   * {@link LanguageCode#es Spanish}, {@link CountryCode#PH Philippines}
   */
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
  /**
   * {@link LanguageCode#eu Basque}
   */
  eu(LanguageCode.eu, null),
  /**
   * {@link LanguageCode#eu Basque}, {@link CountryCode#ES Spain}
   */
  eu_ES(LanguageCode.eu, CountryCode.ES),

  /**
   * {@link LanguageCode#fa Farsi}
   *
   * @since 1.21
   */
  fa(LanguageCode.fa, null),
  /**
   * {@link LanguageCode#fa Persian}, {@link CountryCode#AF Afghanistan}
   */
  fa_AF(LanguageCode.fa, CountryCode.AF),

  /**
   * {@link LanguageCode#fa Farsi}, {@link CountryCode#IR Iran}
   *
   * @since 1.21
   */
  fa_IR(LanguageCode.fa, CountryCode.IR),
  /**
   * {@link LanguageCode#ff Fula}
   */
  ff(LanguageCode.ff, null),
  /**
   * {@link LanguageCode#ff Fula}, {@link CountryCode#GN Guinea}
   */
  ff_GN(LanguageCode.ff, CountryCode.GN),
  /**
   * {@link LanguageCode#ff Fula}, {@link CountryCode#SN Senegal}
   */
  ff_SN(LanguageCode.ff, CountryCode.SN),

  /**
   * {@link LanguageCode#fi Finnish}
   */
  fi(LanguageCode.fi, null),

  /**
   * {@link LanguageCode#fi Finnish}, {@link CountryCode#FI Finland}
   */
  fi_FI(LanguageCode.fi, CountryCode.FI),
  /**
   * {@link LanguageCode#fo Faroese}
   */
  fo(LanguageCode.fo, null),
  /**
   * {@link LanguageCode#fo Faroese}, {@link CountryCode#DK Denmark}
   */
  fo_DK(LanguageCode.fo, CountryCode.DK),
  /**
   * {@link LanguageCode#fo Faroese}, {@link CountryCode#FO Faroe Islands}
   */
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
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#BF Burkina Faso}
   */
  fr_BF(LanguageCode.fr, CountryCode.BF),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#BI Burundi}
   */
  fr_BI(LanguageCode.fr, CountryCode.BI),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#BJ Benin}
   */
  fr_BJ(LanguageCode.fr, CountryCode.BJ),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#BL Saint Barth\u00E9lemy}
   */
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
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CD Congo, the Democratic Republic of the}
   */
  fr_CD(LanguageCode.fr, CountryCode.CD),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CF Central African Republic}
   */
  fr_CF(LanguageCode.fr, CountryCode.CF),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CG Congo}
   */
  fr_CG(LanguageCode.fr, CountryCode.CG),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CH Switzerland}
   */
  fr_CH(LanguageCode.fr, CountryCode.CH),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CI C\u00F4te d'Ivoire}
   */
  fr_CI(LanguageCode.fr, CountryCode.CI),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#CM Cameroon}
   */
  fr_CM(LanguageCode.fr, CountryCode.CM),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#DJ Djibouti}
   */
  fr_DJ(LanguageCode.fr, CountryCode.DJ),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#DZ Algeria}
   */
  fr_DZ(LanguageCode.fr, CountryCode.DZ),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#FR France}
   */
  fr_FR(LanguageCode.fr, CountryCode.FR),

  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#LU Luxembourg}
   */
  fr_LU(LanguageCode.fr, CountryCode.LU),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#GA Gabon}
   */
  fr_GA(LanguageCode.fr, CountryCode.GA),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#GF French Guiana}
   */
  fr_GF(LanguageCode.fr, CountryCode.GF),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#GN Guinea}
   */
  fr_GN(LanguageCode.fr, CountryCode.GN),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#GP Guadeloupe}
   */
  fr_GP(LanguageCode.fr, CountryCode.GP),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#GQ Equatorial Guinea}
   */
  fr_GQ(LanguageCode.fr, CountryCode.GQ),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#HT Haiti}
   */
  fr_HT(LanguageCode.fr, CountryCode.HT),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#KM Comoros}
   */
  fr_KM(LanguageCode.fr, CountryCode.KM),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MA Morocco}
   */
  fr_MA(LanguageCode.fr, CountryCode.MA),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MC Monaco}
   */
  fr_MC(LanguageCode.fr, CountryCode.MC),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MF Saint Martin (French part)}
   */
  fr_MF(LanguageCode.fr, CountryCode.MF),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MG Madagascar}
   */
  fr_MG(LanguageCode.fr, CountryCode.MG),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#ML Mali}
   */
  fr_ML(LanguageCode.fr, CountryCode.ML),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MQ Martinique}
   */
  fr_MQ(LanguageCode.fr, CountryCode.MQ),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MR Mauritania}
   */
  fr_MR(LanguageCode.fr, CountryCode.MR),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#MU Mauritius}
   */
  fr_MU(LanguageCode.fr, CountryCode.MU),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#NC New Caledonia}
   */
  fr_NC(LanguageCode.fr, CountryCode.NC),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#NE Niger}
   */
  fr_NE(LanguageCode.fr, CountryCode.NE),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#PF French Polynesia}
   */
  fr_PF(LanguageCode.fr, CountryCode.PF),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#PM Saint Pierre and Miquelon}
   */
  fr_PM(LanguageCode.fr, CountryCode.PM),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#RE R\u00E9union}
   */
  fr_RE(LanguageCode.fr, CountryCode.RE),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#RW Rwanda}
   */
  fr_RW(LanguageCode.fr, CountryCode.RW),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#SC Seychelles}
   */
  fr_SC(LanguageCode.fr, CountryCode.SC),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#SN Senegal}
   */
  fr_SN(LanguageCode.fr, CountryCode.SN),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#SY Syrian Arab Republic}
   */
  fr_SY(LanguageCode.fr, CountryCode.SY),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#TD Chad}
   */
  fr_TD(LanguageCode.fr, CountryCode.TD),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#TG Togo}
   */
  fr_TG(LanguageCode.fr, CountryCode.TG),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#TN Tunisia}
   */
  fr_TN(LanguageCode.fr, CountryCode.TN),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#VU Vanuatu}
   */
  fr_VU(LanguageCode.fr, CountryCode.VU),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#WF Wallis and Futuna}
   */
  fr_WF(LanguageCode.fr, CountryCode.WF),
  /**
   * {@link LanguageCode#fr French}, {@link CountryCode#YT Mayotte}
   */
  fr_YT(LanguageCode.fr, CountryCode.YT),
  /**
   * {@link LanguageCode#fy West Frisian}
   */
  fy(LanguageCode.fy, null),
  /**
   * {@link LanguageCode#fy West Frisian}, {@link CountryCode#NL Netherlands}
   */
  fy_NL(LanguageCode.fy, CountryCode.NL),

  /**
   * {@link LanguageCode#ga Irish}
   */
  ga(LanguageCode.ga, null),
  /**
   * {@link LanguageCode#ga Irish}, {@link CountryCode#GB United Kingdom}
   */
  ga_GB(LanguageCode.ga, CountryCode.GB),

  /**
   * {@link LanguageCode#ga Irish}, {@link CountryCode#IE Ireland}
   */
  ga_IE(LanguageCode.ga, CountryCode.IE),
  /**
   * {@link LanguageCode#gd Scottish Gaelic}
   */
  gd(LanguageCode.gd, null),
  /**
   * {@link LanguageCode#gd Scottish Gaelic}, {@link CountryCode#GB United Kingdom}
   */
  gd_GB(LanguageCode.gd, CountryCode.GB),
  /**
   * {@link LanguageCode#gl Galician}
   */
  gl(LanguageCode.gl, null),
  /**
   * {@link LanguageCode#gl Galician}, {@link CountryCode#ES Spain}
   */
  gl_ES(LanguageCode.gl, CountryCode.ES),
  /**
   * {@link LanguageCode#gu Gujarati}
   */
  gu(LanguageCode.gu, null),
  /**
   * {@link LanguageCode#gu Gujarati}, {@link CountryCode#IN India}
   */
  gu_IN(LanguageCode.gu, CountryCode.IN),
  /**
   * {@link LanguageCode#gv Manx}
   */
  gv(LanguageCode.gv, null),
  /**
   * {@link LanguageCode#gv Manx}, {@link CountryCode#IM Isle of Man}
   */
  gv_IM(LanguageCode.gv, CountryCode.IM),
  /**
   * {@link LanguageCode#ha Hausa}
   */
  ha(LanguageCode.ha, null),
  /**
   * {@link LanguageCode#ha Hausa}, {@link CountryCode#GH Ghana}
   */
  ha_GH(LanguageCode.ha, CountryCode.GH),
  /**
   * {@link LanguageCode#ha Hausa}, {@link CountryCode#NE Niger}
   */
  ha_NE(LanguageCode.ha, CountryCode.NE),
  /**
   * {@link LanguageCode#ha Hausa}, {@link CountryCode#NG Nigeria}
   */
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
  /**
   * {@link LanguageCode#hr Croatian}, {@link CountryCode#BA Bosnia and Herzegovina}
   */
  hr_BA(LanguageCode.hr, CountryCode.BA),

  /**
   * {@link LanguageCode#hr Croatian}, {@link CountryCode#HR Croatia}
   */
  hr_HR(LanguageCode.hr, CountryCode.HR),
  /**
   * {@link LanguageCode#ht Haitian}
   */
  ht(LanguageCode.ht, null),
  /**
   * {@link LanguageCode#ht Haitian}, {@link CountryCode#HT Haiti}
   */
  ht_HT(LanguageCode.ht, CountryCode.HT),

  /**
   * {@link LanguageCode#hu Hungarian}
   */
  hu(LanguageCode.hu, null),

  /**
   * {@link LanguageCode#hu Hungarian}, {@link CountryCode#HU Hungary}
   */
  hu_HU(LanguageCode.hu, CountryCode.HU),
  /**
   * {@link LanguageCode#hy Armenian}
   */
  hy(LanguageCode.hy, null),
  /**
   * {@link LanguageCode#hy Armenian}, {@link CountryCode#AM Armenia}
   */
  hy_AM(LanguageCode.hy, CountryCode.AM),
  /**
   * {@link LanguageCode#ia Interlingua}
   */
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
  /**
   * {@link LanguageCode#ie Interlingue}
   */
  ie(LanguageCode.ie, null),
  /**
   * {@link LanguageCode#ie Interlingue}, {@link CountryCode#EE Estonia}
   */
  ie_EE(LanguageCode.ie, CountryCode.EE),
  /**
   * {@link LanguageCode#ig Igbo}
   */
  ig(LanguageCode.ig, null),
  /**
   * {@link LanguageCode#ig Igbo}, {@link CountryCode#NG Nigeria}
   */
  ig_NG(LanguageCode.ig, CountryCode.NG),
  /**
   * {@link LanguageCode#ii Nuosu}
   */
  ii(LanguageCode.ii, null),
  /**
   * {@link LanguageCode#ii Nuosu}, {@link CountryCode#CN China}
   */
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
  /**
   * {@link LanguageCode#it Italian}, {@link CountryCode#SM San Marino}
   */
  it_SM(LanguageCode.it, CountryCode.SM),
  /**
   * {@link LanguageCode#it Italian}, {@link CountryCode#VA Holy See (Vatican City State)}
   */
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
  /**
   * {@link LanguageCode#jv Javanese}
   */
  jv(LanguageCode.jv, null),
  /**
   * {@link LanguageCode#jv Javanese}, {@link CountryCode#ID Indonesia}
   */
  jv_ID(LanguageCode.jv, CountryCode.ID),
  /**
   * {@link LanguageCode#ka Georgian}
   */
  ka(LanguageCode.ka, null),
  /**
   * {@link LanguageCode#ka Georgian}, {@link CountryCode#GE Georgia}
   */
  ka_GE(LanguageCode.ka, CountryCode.GE),
  /**
   * {@link LanguageCode#ki Kikuyu}
   */
  ki(LanguageCode.ki, null),
  /**
   * {@link LanguageCode#ki Kikuyu}, {@link CountryCode#KE Kenya}
   */
  ki_KE(LanguageCode.ki, CountryCode.KE),
  /**
   * {@link LanguageCode#kk Kazakh}
   */
  kk(LanguageCode.kk, null),
  /**
   * {@link LanguageCode#kk Kazakh}, {@link CountryCode#CN China}
   */
  kk_CN(LanguageCode.kk, CountryCode.CN),

  /**
   * {@link LanguageCode#kk Kazakh}, {@link CountryCode#KZ Kazakhstan}
   *
   * @since 1.22
   */
  kk_KZ(LanguageCode.kk, CountryCode.KZ),
  /**
   * {@link LanguageCode#kl Kalaallisut}
   */
  kl(LanguageCode.kl, null),
  /**
   * {@link LanguageCode#kl Kalaallisut}, {@link CountryCode#GL Greenland}
   */
  kl_GL(LanguageCode.kl, CountryCode.GL),
  /**
   * {@link LanguageCode#km Khmer}
   */
  km(LanguageCode.km, null),
  /**
   * {@link LanguageCode#km Khmer}, {@link CountryCode#KH Cambodia}
   */
  km_KH(LanguageCode.km, CountryCode.KH),
  /**
   * {@link LanguageCode#kn Kannada}
   */
  kn(LanguageCode.kn, null),
  /**
   * {@link LanguageCode#kn Kannada}, {@link CountryCode#IN India}
   */
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
  /**
   * {@link LanguageCode#ko Korean}, {@link CountryCode#CN China}
   */
  ko_CN(LanguageCode.ko, CountryCode.CN),
  /**
   * {@link LanguageCode#ko Korean}, {@link CountryCode#KP Korea, Democratic People's Republic of}
   */
  ko_KP(LanguageCode.ko, CountryCode.KP),

  /**
   * {@link LanguageCode#ko Korean}, {@link CountryCode#KR Korea, Republic of}
   */
  ko_KR(LanguageCode.ko, CountryCode.KR),
  /**
   * {@link LanguageCode#ks Kashmiri}
   */
  ks(LanguageCode.ks, null),
  /**
   * {@link LanguageCode#ks Kashmiri}, {@link CountryCode#IN India}
   */
  ks_IN(LanguageCode.ks, CountryCode.IN),
  /**
   * {@link LanguageCode#ku Kurdish}
   */
  ku(LanguageCode.ku, null),
  /**
   * {@link LanguageCode#ku Kurdish}, {@link CountryCode#TR T\u00FCrkiye}
   */
  ku_TR(LanguageCode.ku, CountryCode.TR),
  /**
   * {@link LanguageCode#kw Cornish}
   */
  kw(LanguageCode.kw, null),
  /**
   * {@link LanguageCode#kw Cornish}, {@link CountryCode#GB United Kingdom}
   */
  kw_GB(LanguageCode.kw, CountryCode.GB),
  /**
   * {@link LanguageCode#ky Kyrgyz}
   */
  ky(LanguageCode.ky, null),
  /**
   * {@link LanguageCode#ky Kyrgyz}, {@link CountryCode#KG Kyrgyzstan}
   */
  ky_KG(LanguageCode.ky, CountryCode.KG),
  /**
   * {@link LanguageCode#lb Luxembourgish}
   */
  lb(LanguageCode.lb, null),
  /**
   * {@link LanguageCode#lb Luxembourgish}, {@link CountryCode#LU Luxembourg}
   */
  lb_LU(LanguageCode.lb, CountryCode.LU),
  /**
   * {@link LanguageCode#lg Ganda}
   */
  lg(LanguageCode.lg, null),
  /**
   * {@link LanguageCode#lg Ganda}, {@link CountryCode#UG Uganda}
   */
  lg_UG(LanguageCode.lg, CountryCode.UG),
  /**
   * {@link LanguageCode#ln Lingala}
   */
  ln(LanguageCode.ln, null),
  /**
   * {@link LanguageCode#ln Lingala}, {@link CountryCode#AO Angola}
   */
  ln_AO(LanguageCode.ln, CountryCode.AO),
  /**
   * {@link LanguageCode#ln Lingala}, {@link CountryCode#CD Congo, the Democratic Republic of the}
   */
  ln_CD(LanguageCode.ln, CountryCode.CD),
  /**
   * {@link LanguageCode#ln Lingala}, {@link CountryCode#CF Central African Republic}
   */
  ln_CF(LanguageCode.ln, CountryCode.CF),
  /**
   * {@link LanguageCode#ln Lingala}, {@link CountryCode#CG Congo}
   */
  ln_CG(LanguageCode.ln, CountryCode.CG),
  /**
   * {@link LanguageCode#lo Lao}
   */
  lo(LanguageCode.lo, null),
  /**
   * {@link LanguageCode#lo Lao}, {@link CountryCode#LA Lao People's Democratic Republic}
   */
  lo_LA(LanguageCode.lo, CountryCode.LA),

  /**
   * {@link LanguageCode#lt Lithuanian}
   */
  lt(LanguageCode.lt, null),

  /**
   * {@link LanguageCode#lt Lithuanian}, {@link CountryCode#LT Lithuania}
   */
  lt_LT(LanguageCode.lt, CountryCode.LT),
  /**
   * {@link LanguageCode#lu Luba-Katanga}
   */
  lu(LanguageCode.lu, null),
  /**
   * {@link LanguageCode#lu Luba-Katanga}, {@link CountryCode#CD Congo, the Democratic Republic of the}
   */
  lu_CD(LanguageCode.lu, CountryCode.CD),

  /**
   * {@link LanguageCode#lv Latvian}
   */
  lv(LanguageCode.lv, null),

  /**
   * {@link LanguageCode#lv Latvian}, {@link CountryCode#LV Latvia}
   */
  lv_LV(LanguageCode.lv, CountryCode.LV),
  /**
   * {@link LanguageCode#mg Malagasy}
   */
  mg(LanguageCode.mg, null),
  /**
   * {@link LanguageCode#mg Malagasy}, {@link CountryCode#MG Madagascar}
   */
  mg_MG(LanguageCode.mg, CountryCode.MG),
  /**
   * {@link LanguageCode#mi M&#257;ori}
   */
  mi(LanguageCode.mi, null),
  /**
   * {@link LanguageCode#mi M&#257;ori}, {@link CountryCode#NZ New Zealand}
   */
  mi_NZ(LanguageCode.mi, CountryCode.NZ),

  /**
   * {@link LanguageCode#mk Macedonian}
   */
  mk(LanguageCode.mk, null),

  /**
   * {@link LanguageCode#mk Macedonian}, {@link CountryCode#MK Macedonia, the former Yugoslav Republic of}
   */
  mk_MK(LanguageCode.mk, CountryCode.MK),
  /**
   * {@link LanguageCode#ml Malayalam}
   */
  ml(LanguageCode.ml, null),
  /**
   * {@link LanguageCode#ml Malayalam}, {@link CountryCode#IN India}
   */
  ml_IN(LanguageCode.ml, CountryCode.IN),
  /**
   * {@link LanguageCode#mn Mongolian}
   */
  mn(LanguageCode.mn, null),
  /**
   * {@link LanguageCode#mn Mongolian}, {@link CountryCode#MN Mongolia}
   */
  mn_MN(LanguageCode.mn, CountryCode.MN),
  /**
   * {@link LanguageCode#mr Marathi}
   */
  mr(LanguageCode.mr, null),
  /**
   * {@link LanguageCode#mr Marathi}, {@link CountryCode#IN India}
   */
  mr_IN(LanguageCode.mr, CountryCode.IN),

  /**
   * {@link LanguageCode#ms Malay}
   */
  ms(LanguageCode.ms, null),
  /**
   * {@link LanguageCode#ms Malay}, {@link CountryCode#BN Brunei Darussalam}
   */
  ms_BN(LanguageCode.ms, CountryCode.BN),
  /**
   * {@link LanguageCode#ms Malay}, {@link CountryCode#ID Indonesia}
   */
  ms_ID(LanguageCode.ms, CountryCode.ID),

  /**
   * {@link LanguageCode#ms Malay}, {@link CountryCode#MY Malaysia}
   */
  ms_MY(LanguageCode.ms, CountryCode.MY),
  /**
   * {@link LanguageCode#ms Malay}, {@link CountryCode#SG Singapore}
   */
  ms_SG(LanguageCode.ms, CountryCode.SG),

  /**
   * {@link LanguageCode#mt Maltese}
   */
  mt(LanguageCode.mt, null),

  /**
   * {@link LanguageCode#mt Maltese}, {@link CountryCode#MT Malta}
   */
  mt_MT(LanguageCode.mt, CountryCode.MT),
  /**
   * {@link LanguageCode#my Burmese}
   */
  my(LanguageCode.my, null),
  /**
   * {@link LanguageCode#my Burmese}, {@link CountryCode#MM Myanmar}
   */
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
  /**
   * {@link LanguageCode#nb Norwegian Bokm&aring;l}, {@link CountryCode#SJ Svalbard and Jan Mayen}
   */
  nb_SJ(LanguageCode.nb, CountryCode.SJ),
  /**
   * {@link LanguageCode#nd Northern Ndebele}
   */
  nd(LanguageCode.nd, null),
  /**
   * {@link LanguageCode#nd Northern Ndebele}, {@link CountryCode#ZW Zimbabwe}
   */
  nd_ZW(LanguageCode.nd, CountryCode.ZW),
  /**
   * {@link LanguageCode#ne Nepali}
   */
  ne(LanguageCode.ne, null),
  /**
   * {@link LanguageCode#ne Nepali}, {@link CountryCode#IN India}
   */
  ne_IN(LanguageCode.ne, CountryCode.IN),
  /**
   * {@link LanguageCode#ne Nepali}, {@link CountryCode#NP Nepal}
   */
  ne_NP(LanguageCode.ne, CountryCode.NP),

  /**
   * {@link LanguageCode#nl Dutch}
   */
  nl(LanguageCode.nl, null),
  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#AW Aruba}
   */
  nl_AW(LanguageCode.nl, CountryCode.AW),

  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#BE Belgium}
   */
  nl_BE(LanguageCode.nl, CountryCode.BE),
  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#BQ Bonaire, Sint Eustatius and Saba}
   */
  nl_BQ(LanguageCode.nl, CountryCode.BQ),
  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#CW Cura\u00E7ao}
   */
  nl_CW(LanguageCode.nl, CountryCode.CW),

  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#NL Netherlands}
   */
  nl_NL(LanguageCode.nl, CountryCode.NL),

  /**
   * {@link LanguageCode#nn Norwegian Nynorsk}, {@link CountryCode#NO Norway}
   */
  nn_NO(LanguageCode.nn, CountryCode.NO),
  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#SR Suriname}
   */
  nl_SR(LanguageCode.nl, CountryCode.SR),
  /**
   * {@link LanguageCode#nl Dutch}, {@link CountryCode#SX Sint Maarten (Dutch part)}
   */
  nl_SX(LanguageCode.nl, CountryCode.SX),
  /**
   * {@link LanguageCode#nn Norwegian Nynorsk}
   */
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
  /**
   * {@link LanguageCode#oc Occitan}
   */
  oc(LanguageCode.oc, null),
  /**
   * {@link LanguageCode#oc Occitan}, {@link CountryCode#ES Spain}
   */
  oc_ES(LanguageCode.oc, CountryCode.ES),
  /**
   * {@link LanguageCode#oc Occitan}, {@link CountryCode#FR France}
   */
  oc_FR(LanguageCode.oc, CountryCode.FR),
  /**
   * {@link LanguageCode#om Oromo}
   */
  om(LanguageCode.om, null),
  /**
   * {@link LanguageCode#om Oromo}, {@link CountryCode#ET Ethiopia}
   */
  om_ET(LanguageCode.om, CountryCode.ET),
  /**
   * {@link LanguageCode#om Oromo}, {@link CountryCode#KE Kenya}
   */
  om_KE(LanguageCode.om, CountryCode.KE),
  /**
   * {@link LanguageCode#or Oriya}
   */
  or(LanguageCode.or, null),
  /**
   * {@link LanguageCode#or Oriya}, {@link CountryCode#IN India}
   */
  or_IN(LanguageCode.or, CountryCode.IN),
  /**
   * {@link LanguageCode#os Ossetian}
   */
  os(LanguageCode.os, null),
  /**
   * {@link LanguageCode#os Ossetian}, {@link CountryCode#GE Georgia}
   */
  os_GE(LanguageCode.os, CountryCode.GE),
  /**
   * {@link LanguageCode#os Ossetian}, {@link CountryCode#RU Russian Federation}
   */
  os_RU(LanguageCode.os, CountryCode.RU),
  /**
   * {@link LanguageCode#pa Punjabi}
   */
  pa(LanguageCode.pa, null),
  /**
   * {@link LanguageCode#pa Punjabi}, {@link CountryCode#IN India}
   */
  pa_IN(LanguageCode.pa, CountryCode.IN),
  /**
   * {@link LanguageCode#pa Punjabi}, {@link CountryCode#PK Pakistan}
   */
  pa_PK(LanguageCode.pa, CountryCode.PK),

  /**
   * {@link LanguageCode#pl Polish}
   */
  pl(LanguageCode.pl, null),

  /**
   * {@link LanguageCode#pl Polish}, {@link CountryCode#PL Poland}
   */
  pl_PL(LanguageCode.pl, CountryCode.PL),
  /**
   * {@link LanguageCode#ps Pashto}
   */
  ps(LanguageCode.ps, null),
  /**
   * {@link LanguageCode#ps Pashto}, {@link CountryCode#AF Afghanistan}
   */
  ps_AF(LanguageCode.ps, CountryCode.AF),
  /**
   * {@link LanguageCode#ps Pashto}, {@link CountryCode#PK Pakistan}
   */
  ps_PK(LanguageCode.ps, CountryCode.PK),

  /**
   * {@link LanguageCode#pt Portuguese}
   */
  pt(LanguageCode.pt, null),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#AO Angola}
   */
  pt_AO(LanguageCode.pt, CountryCode.AO),

  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#BR Brazil}
   */
  pt_BR(LanguageCode.pt, CountryCode.BR),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#CH Switzerland}
   */
  pt_CH(LanguageCode.pt, CountryCode.CH),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#CV Cape Verde}
   */
  pt_CV(LanguageCode.pt, CountryCode.CV),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#GQ Equatorial Guinea}
   */
  pt_GQ(LanguageCode.pt, CountryCode.GQ),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#GW Guinea-Bissau}
   */
  pt_GW(LanguageCode.pt, CountryCode.GW),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#LU Luxembourg}
   */
  pt_LU(LanguageCode.pt, CountryCode.LU),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#MO Macao}
   */
  pt_MO(LanguageCode.pt, CountryCode.MO),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#MZ Mozambique}
   */
  pt_MZ(LanguageCode.pt, CountryCode.MZ),

  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#PT Portugal}
   */
  pt_PT(LanguageCode.pt, CountryCode.PT),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#ST Sao Tome and Principe}
   */
  pt_ST(LanguageCode.pt, CountryCode.ST),
  /**
   * {@link LanguageCode#pt Portuguese}, {@link CountryCode#TL Timor-Leste}
   */
  pt_TL(LanguageCode.pt, CountryCode.TL),
  /**
   * {@link LanguageCode#qu Quechua}
   */
  qu(LanguageCode.qu, null),
  /**
   * {@link LanguageCode#qu Quechua}, {@link CountryCode#BO Bolivia, Plurinational State of}
   */
  qu_BO(LanguageCode.qu, CountryCode.BO),
  /**
   * {@link LanguageCode#qu Quechua}, {@link CountryCode#EC Ecuador}
   */
  qu_EC(LanguageCode.qu, CountryCode.EC),
  /**
   * {@link LanguageCode#qu Quechua}, {@link CountryCode#PE Peru}
   */
  qu_PE(LanguageCode.qu, CountryCode.PE),
  /**
   * {@link LanguageCode#rm Romansh}
   */
  rm(LanguageCode.rm, null),
  /**
   * {@link LanguageCode#rm Romansh}, {@link CountryCode#CH Switzerland}
   */
  rm_CH(LanguageCode.rm, CountryCode.CH),
  /**
   * {@link LanguageCode#rn Kirundi}
   */
  rn(LanguageCode.rn, null),
  /**
   * {@link LanguageCode#rn Kirundi}, {@link CountryCode#BI Burundi}
   */
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
  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#BY Belarus}
   */
  ru_BY(LanguageCode.ru, CountryCode.BY),
  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#KG Kyrgyzstan}
   */
  ru_KG(LanguageCode.ru, CountryCode.KG),

  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#KZ Kazakhstan}
   *
   * @since 1.22
   */
  ru_KZ(LanguageCode.ru, CountryCode.KZ),
  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#MD Moldova, Republic of}
   */
  ru_MD(LanguageCode.ru, CountryCode.MD),

  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#RU Russian Federation}
   */
  ru_RU(LanguageCode.ru, CountryCode.RU),
  /**
   * {@link LanguageCode#ru Russian}, {@link CountryCode#UA Ukraine}
   */
  ru_UA(LanguageCode.ru, CountryCode.UA),
  /**
   * {@link LanguageCode#rw Kinyarwanda}
   */
  rw(LanguageCode.rw, null),
  /**
   * {@link LanguageCode#rw Kinyarwanda}, {@link CountryCode#RW Rwanda}
   */
  rw_RW(LanguageCode.rw, CountryCode.RW),
  /**
   * {@link LanguageCode#sa Sanskrit}
   */
  sa(LanguageCode.sa, null),
  /**
   * {@link LanguageCode#sa Sanskrit}, {@link CountryCode#IN India}
   */
  sa_IN(LanguageCode.sa, CountryCode.IN),
  /**
   * {@link LanguageCode#sc Sardinian}
   */
  sc(LanguageCode.sc, null),
  /**
   * {@link LanguageCode#sc Sardinian}, {@link CountryCode#IT Italy}
   */
  sc_IT(LanguageCode.sc, CountryCode.IT),
  /**
   * {@link LanguageCode#sd Sindhi}
   */
  sd(LanguageCode.sd, null),
  /**
   * {@link LanguageCode#sd Sindhi}, {@link CountryCode#IN India}
   */
  sd_IN(LanguageCode.sd, CountryCode.IN),
  /**
   * {@link LanguageCode#sd Sindhi}, {@link CountryCode#PK Pakistan}
   */
  sd_PK(LanguageCode.sd, CountryCode.PK),

  /**
   * {@link LanguageCode#se Northern Sami}
   *
   * @since 1.8
   */
  se(LanguageCode.se, null),
  /**
   * {@link LanguageCode#se Northern Sami}, {@link CountryCode#FI Finland}
   */
  se_FI(LanguageCode.se, CountryCode.FI),

  /**
   * {@link LanguageCode#se Northern Sami}, {@link CountryCode#NO Norway}
   *
   * @since 1.8
   */
  se_NO(LanguageCode.se, CountryCode.NO),
  /**
   * {@link LanguageCode#se Northern Sami}, {@link CountryCode#SE Sweden}
   */
  se_SE(LanguageCode.se, CountryCode.SE),
  /**
   * {@link LanguageCode#sg Sango}
   */
  sg(LanguageCode.sg, null),
  /**
   * {@link LanguageCode#sg Sango}, {@link CountryCode#CF Central African Republic}
   */
  sg_CF(LanguageCode.sg, CountryCode.CF),
  /**
   * {@link LanguageCode#si Sinhala}
   */
  si(LanguageCode.si, null),
  /**
   * {@link LanguageCode#si Sinhala}, {@link CountryCode#LK Sri Lanka}
   */
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
  /**
   * {@link LanguageCode#sn Shona}
   */
  sn(LanguageCode.sn, null),
  /**
   * {@link LanguageCode#sn Shona}, {@link CountryCode#ZW Zimbabwe}
   */
  sn_ZW(LanguageCode.sn, CountryCode.ZW),
  /**
   * {@link LanguageCode#so Somali}
   */
  so(LanguageCode.so, null),
  /**
   * {@link LanguageCode#so Somali}, {@link CountryCode#DJ Djibouti}
   */
  so_DJ(LanguageCode.so, CountryCode.DJ),
  /**
   * {@link LanguageCode#so Somali}, {@link CountryCode#ET Ethiopia}
   */
  so_ET(LanguageCode.so, CountryCode.ET),
  /**
   * {@link LanguageCode#so Somali}, {@link CountryCode#KE Kenya}
   */
  so_KE(LanguageCode.so, CountryCode.KE),
  /**
   * {@link LanguageCode#so Somali}, {@link CountryCode#SO Somalia}
   */
  so_SO(LanguageCode.so, CountryCode.SO),

  /**
   * {@link LanguageCode#sq Albanian}
   */
  sq(LanguageCode.sq, null),

  /**
   * {@link LanguageCode#sq Albanian}, {@link CountryCode#AL Albania}
   */
  sq_MK(LanguageCode.sq, CountryCode.MK),
  /**
   * {@link LanguageCode#sq Albanian}, {@link CountryCode#XK Kosovo, Republic of}
   */
  sq_XK(LanguageCode.sq, CountryCode.XK),
  /**
   * {@link LanguageCode#sq Albanian}, {@link CountryCode#AL Albania}
   */
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
  /**
   * {@link LanguageCode#st Southern Sotho}
   */
  st(LanguageCode.st, null),
  /**
   * {@link LanguageCode#st Southern Sotho}, {@link CountryCode#LS Lesotho}
   */
  st_LS(LanguageCode.st, CountryCode.LS),
  /**
   * {@link LanguageCode#st Southern Sotho}, {@link CountryCode#ZA South Africa}
   */
  st_ZA(LanguageCode.st, CountryCode.ZA),
  /**
   * {@link LanguageCode#su Sundanese}
   */
  su(LanguageCode.su, null),
  /**
   * {@link LanguageCode#su Sundanese}, {@link CountryCode#ID Indonesia}
   */
  su_ID(LanguageCode.su, CountryCode.ID),

  /**
   * {@link LanguageCode#sv Swedish}
   */
  sv(LanguageCode.sv, null),
  /**
   * {@link LanguageCode#sv Swedish}, {@link CountryCode#AX \u00C5land Islands}
   */
  sv_AX(LanguageCode.sv, CountryCode.AX),
  /**
   * {@link LanguageCode#sv Swedish}, {@link CountryCode#FI Finland}
   */
  sv_FI(LanguageCode.sv, CountryCode.FI),

  /**
   * {@link LanguageCode#sv Swedish}, {@link CountryCode#SE Sweden}
   */
  sv_SE(LanguageCode.sv, CountryCode.SE),
  /**
   * {@link LanguageCode#sw Swahili}
   */
  sw(LanguageCode.sw, null),
  /**
   * {@link LanguageCode#sw Swahili}, {@link CountryCode#CD Congo, the Democratic Republic of the}
   */
  sw_CD(LanguageCode.sw, CountryCode.CD),
  /**
   * {@link LanguageCode#sw Swahili}, {@link CountryCode#KE Kenya}
   */
  sw_KE(LanguageCode.sw, CountryCode.KE),
  /**
   * {@link LanguageCode#sw Swahili}, {@link CountryCode#TZ Tanzania, United Republic of}
   */
  sw_TZ(LanguageCode.sw, CountryCode.TZ),
  /**
   * {@link LanguageCode#sw Swahili}, {@link CountryCode#UG Uganda}
   */
  sw_UG(LanguageCode.sw, CountryCode.UG),
  /**
   * {@link LanguageCode#ta Tamil}
   */
  ta(LanguageCode.ta, null),
  /**
   * {@link LanguageCode#ta Tamil}, {@link CountryCode#IN India}
   */
  ta_IN(LanguageCode.ta, CountryCode.IN),
  /**
   * {@link LanguageCode#ta Tamil}, {@link CountryCode#LK Sri Lanka}
   */
  ta_LK(LanguageCode.ta, CountryCode.LK),
  /**
   * {@link LanguageCode#ta Tamil}, {@link CountryCode#MY Malaysia}
   */
  ta_MY(LanguageCode.ta, CountryCode.MY),
  /**
   * {@link LanguageCode#ta Tamil}, {@link CountryCode#SG Singapore}
   */
  ta_SG(LanguageCode.ta, CountryCode.SG),
  /**
   * {@link LanguageCode#te Telugu}
   */
  te(LanguageCode.te, null),
  /**
   * {@link LanguageCode#te Telugu}, {@link CountryCode#IN India}
   */
  te_IN(LanguageCode.te, CountryCode.IN),
  /**
   * {@link LanguageCode#tg Tajik}
   */
  tg(LanguageCode.tg, null),
  /**
   * {@link LanguageCode#tg Tajik}, {@link CountryCode#TJ Tajikistan}
   */
  tg_TJ(LanguageCode.tg, CountryCode.TJ),

  /**
   * {@link LanguageCode#th Thai}
   */
  th(LanguageCode.th, null),

  /**
   * {@link LanguageCode#th Thai}, {@link CountryCode#TH Thailand}
   */
  th_TH(LanguageCode.th, CountryCode.TH),
  /**
   * {@link LanguageCode#ti Tigrinya}
   */
  ti(LanguageCode.ti, null),
  /**
   * {@link LanguageCode#ti Tigrinya}, {@link CountryCode#ER Eritrea}
   */
  ti_ER(LanguageCode.ti, CountryCode.ER),
  /**
   * {@link LanguageCode#ti Tigrinya}, {@link CountryCode#ET Ethiopia}
   */
  ti_ET(LanguageCode.ti, CountryCode.ET),
  /**
   * {@link LanguageCode#tk Turkmen}
   */
  tk(LanguageCode.tk, null),
  /**
   * {@link LanguageCode#tk Turkmen}, {@link CountryCode#TM Turkmenistan}
   */
  tk_TM(LanguageCode.tk, CountryCode.TM),
  /**
   * {@link LanguageCode#tn Tswana}
   */
  tn(LanguageCode.tn, null),
  /**
   * {@link LanguageCode#tn Tswana}, {@link CountryCode#BW Botswana}
   */
  tn_BW(LanguageCode.tn, CountryCode.BW),
  /**
   * {@link LanguageCode#tn Tswana}, {@link CountryCode#ZA South Africa}
   */
  tn_ZA(LanguageCode.tn, CountryCode.ZA),
  /**
   * {@link LanguageCode#to Tongan}
   */
  to(LanguageCode.to, null),
  /**
   * {@link LanguageCode#to Tongan}, {@link CountryCode#TO Tonga}
   */
  to_TO(LanguageCode.to, CountryCode.TO),

  /**
   * {@link LanguageCode#tr Turkish}
   */
  tr(LanguageCode.tr, null),
  /**
   * {@link LanguageCode#tr Turkish}, {@link CountryCode#CY Cyprus}
   */
  tr_CY(LanguageCode.tr, CountryCode.CY),

  /**
   * {@link LanguageCode#tr Turkish}, {@link CountryCode#TR Turkey}
   */
  tr_TR(LanguageCode.tr, CountryCode.TR),
  /**
   * {@link LanguageCode#tt Tatar}
   */
  tt(LanguageCode.tt, null),
  /**
   * {@link LanguageCode#tt Tatar}, {@link CountryCode#RU Russian Federation}
   */
  tt_RU(LanguageCode.tt, CountryCode.RU),
  /**
   * {@link LanguageCode#ug Uighur}
   */
  ug(LanguageCode.ug, null),
  /**
   * {@link LanguageCode#ug Uighur}, {@link CountryCode#CN China}
   */
  ug_CN(LanguageCode.ug, CountryCode.CN),

  /**
   * {@link LanguageCode#uk Ukrainian}
   */
  uk(LanguageCode.uk, null),

  /**
   * {@link LanguageCode#uk Ukrainian}, {@link CountryCode#UA Ukraine}
   */
  uk_UA(LanguageCode.uk, CountryCode.UA),
  /**
   * {@link LanguageCode#ur Urdu}
   */
  ur(LanguageCode.ur, null),
  /**
   * {@link LanguageCode#ur Urdu}, {@link CountryCode#IN India}
   */
  ur_IN(LanguageCode.ur, CountryCode.IN),

  /**
   * {@link LanguageCode#ur Urdu}, {@link CountryCode#PK Pakistan}
   */
  ur_PK(LanguageCode.ur, CountryCode.PK),
  /**
   * {@link LanguageCode#uz Uzbek}
   */
  uz(LanguageCode.uz, null),
  /**
   * {@link LanguageCode#uz Uzbek}, {@link CountryCode#AF Afghanistan}
   */
  uz_AF(LanguageCode.uz, CountryCode.AF),
  /**
   * {@link LanguageCode#uz Uzbek}, {@link CountryCode#UZ Uzbekistan}
   */
  uz_UZ(LanguageCode.uz, CountryCode.UZ),

  /**
   * {@link LanguageCode#vi Vietnamese}
   */
  vi(LanguageCode.vi, null),

  /**
   * {@link LanguageCode#vi Vietnamese}, {@link CountryCode#VN Viet Nam}
   */
  vi_VN(LanguageCode.vi, CountryCode.VN),
  /**
   * {@link LanguageCode#wo Wolof}
   */
  wo(LanguageCode.wo, null),
  /**
   * {@link LanguageCode#wo Wolof}, {@link CountryCode#SN Senegal}
   */
  wo_SN(LanguageCode.wo, CountryCode.SN),
  /**
   * {@link LanguageCode#xh Xhosa}
   */
  xh(LanguageCode.xh, null),
  /**
   * {@link LanguageCode#xh Xhosa}, {@link CountryCode#ZA South Africa}
   */
  xh_ZA(LanguageCode.xh, CountryCode.ZA),
  /**
   * {@link LanguageCode#yi Yiddish}
   */
  yi(LanguageCode.yi, null),
  /**
   * {@link LanguageCode#yi Yiddish}, {@link CountryCode#UA Ukraine}
   */
  yi_UA(LanguageCode.yi, CountryCode.UA),
  /**
   * {@link LanguageCode#yo Yoruba}
   */
  yo(LanguageCode.yo, null),
  /**
   * {@link LanguageCode#yo Yoruba}, {@link CountryCode#BJ Benin}
   */
  yo_BJ(LanguageCode.yo, CountryCode.BJ),
  /**
   * {@link LanguageCode#yo Yoruba}, {@link CountryCode#NG Nigeria}
   */
  yo_NG(LanguageCode.yo, CountryCode.NG),
  /**
   * {@link LanguageCode#za Zhuang}
   */
  za(LanguageCode.za, null),
  /**
   * {@link LanguageCode#za Zhuang}, {@link CountryCode#CN China}
   */
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
  /**
   * {@link LanguageCode#zh Chinese}, {@link CountryCode#MO Macao}
   */
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
  /**
   * {@link LanguageCode#zu Zulu}, {@link CountryCode#ZA South Africa}
   */
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
