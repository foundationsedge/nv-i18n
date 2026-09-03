/*
 * Copyright (C) 2013-2014 Neo Visionaries Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neovisionaries.i18n;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * <a href="https://en.wikipedia.org/wiki/ISO_15924">ISO 15924</a> script code.
 *
 * @author Takahiko Kawasaki
 * @since 1.2
 */
public enum ScriptCode {

  /**
   * Undefined [-1]
   *
   * <p>
   * This is not an official ISO 15924 code.
   * </p>
   *
   * @see #Zxxx Zxxx: 997 Code for unwritten languages
   * @see #Zyyy Zyyy: 998 Code for undetermined script
   * @see #Zzzz Zzzz: 999 Code for uncoded script
   * @since 1.14
   */
  Undefined(-1, "Undefined") {
    @Override
    public Locale toLocale() {
      return LocaleCode.undefined.toLocale();
    }
  },

  /**
   * Adlam [166]
   */
  Adlm(166, "Adlam"),

  /**
   * Afaka [439]
   */
  Afak(439, "Afaka"),


  /**
   * Caucasian Albanian [239]
   */
  Aghb(239, "Caucasian Albanian"),


  /**
   * Ahom, Tai Ahom [338]
   */
  Ahom(338, "Ahom, Tai Ahom"),


  /**
   * Arabic [160]
   */
  Arab(160, "Arabic"),

  /**
   * Arabic (Nastaliq variant) [161]
   */
  Aran(161, "Arabic (Nastaliq variant)"),

  /**
   * Imperial Aramaic [124]
   */
  Armi(124, "Imperial Aramaic"),


  /**
   * Armenian [230]
   */
  Armn(230, "Armenian"),


  /**
   * Avestan [134]
   */
  Avst(134, "Avestan"),


  /**
   * Balinese [360]
   */
  Bali(360, "Balinese"),


  /**
   * Bamum [435]
   */
  Bamu(435, "Bamum"),


  /**
   * Bassa Vah [259]
   */
  Bass(259, "Bassa Vah"),


  /**
   * Batak [365]
   */
  Batk(365, "Batak"),


  /**
   * Bengali (Bangla) [325]
   */
  Beng(325, "Bengali (Bangla)"),

  /**
   * Beria Erfe [258]
   */
  Berf(258, "Beria Erfe"),

  /**
   * Bhaiksuki [334]
   */
  Bhks(334, "Bhaiksuki"),

  /**
   * Blissymbols [550]
   */
  Blis(550, "Blissymbols"),


  /**
   * Bopomofo [285]
   */
  Bopo(285, "Bopomofo"),


  /**
   * Brahmi [300]
   */
  Brah(300, "Brahmi"),


  /**
   * Braille [570]
   */
  Brai(570, "Braille"),


  /**
   * Buginese [367]
   */
  Bugi(367, "Buginese"),


  /**
   * Buhid [372]
   */
  Buhd(372, "Buhid"),


  /**
   * Chakma [349]
   */
  Cakm(349, "Chakma"),


  /**
   * Unified Canadian Aboriginal Syllabics [440]
   */
  Cans(440, "Unified Canadian Aboriginal Syllabics"),


  /**
   * Carian [201]
   */
  Cari(201, "Carian"),


  /**
   * Cham [358]
   */
  Cham(358, "Cham"),


  /**
   * Cherokee [445]
   */
  Cher(445, "Cherokee"),

  /**
   * Chisoi [298]
   */
  Chis(298, "Chisoi"),

  /**
   * Chorasmian [109]
   */
  Chrs(109, "Chorasmian"),

  /**
   * Cirth [291]
   */
  Cirt(291, "Cirth"),


  /**
   * Coptic [204]
   */
  Copt(204, "Coptic"),

  /**
   * Cypro-Minoan [402]
   */
  Cpmn(402, "Cypro-Minoan"),


  /**
   * Cypriot syllabary [403]
   */
  Cprt(403, "Cypriot syllabary"),


  /**
   * Cyrillic [220]
   */
  Cyrl(220, "Cyrillic"),


  /**
   * Cyrillic (Old Church Slavonic variant) [221]
   */
  Cyrs(221, "Cyrillic (Old Church Slavonic variant)"),


  /**
   * Devanagari (Nagari) [315]
   */
  Deva(315, "Devanagari (Nagari)"),

  /**
   * Dives Akuru [342]
   */
  Diak(342, "Dives Akuru"),

  /**
   * Dogra [328]
   */
  Dogr(328, "Dogra"),


  /**
   * Deseret (Mormon) [250]
   */
  Dsrt(250, "Deseret (Mormon)"),


  /**
   * Duployan shorthand, Duployan stenography [755]
   */
  Dupl(755, "Duployan shorthand, Duployan stenography"),


  /**
   * Egyptian demotic [70]
   */
  Egyd(70, "Egyptian demotic"),


  /**
   * Egyptian hieratic [060]
   */
  Egyh(60, "Egyptian hieratic"),


  /**
   * Egyptian hieroglyphs [050]
   */
  Egyp(50, "Egyptian hieroglyphs"),


  /**
   * Elbasan [226]
   */
  Elba(226, "Elbasan"),

  /**
   * Elymaic [128]
   */
  Elym(128, "Elymaic"),


  /**
   * Ethiopic [430]
   */
  Ethi(430, "Ethiopic"),

  /**
   * Garay [164]
   */
  Gara(164, "Garay"),

  /**
   * Khutsuri (Asomtavruli and Nuskhuri) [241]
   */
  Geok(241, "Khutsuri (Asomtavruli and Nuskhuri)"),


  /**
   * Georgian (Mkhedruli and Mtavruli) [240]
   */
  Geor(240, "Georgian (Mkhedruli and Mtavruli)"),


  /**
   * Glagolitic [225]
   */
  Glag(225, "Glagolitic"),

  /**
   * Gunjala Gondi [312]
   */
  Gong(312, "Gunjala Gondi"),

  /**
   * Masaram Gondi [313]
   */
  Gonm(313, "Masaram Gondi"),


  /**
   * Gothic [206]
   */
  Goth(206, "Gothic"),


  /**
   * Grantha [343]
   */
  Gran(343, "Grantha"),


  /**
   * Greek [200]
   */
  Grek(200, "Greek"),


  /**
   * Gujarati [320]
   */
  Gujr(320, "Gujarati"),

  /**
   * Gurung Khema [397]
   */
  Gukh(397, "Gurung Khema"),


  /**
   * Gurmukhi [310]
   */
  Guru(310, "Gurmukhi"),

  /**
   * Han with Bopomofo (alias for Han + Bopomofo) [503]
   */
  Hanb(503, "Han with Bopomofo (alias for Han + Bopomofo)"),


  /**
   * Hangul [286]
   */
  Hang(286, "Hangul"),


  /**
   * Han (Hanzi, Kanji, Hanja) [500]
   */
  Hani(500, "Han (Hanzi, Kanji, Hanja)"),


  /**
   * Hanunoo [371]
   */
  Hano(371, "Hanunoo"),


  /**
   * Han (Simplified variant) [501]
   */
  Hans(501, "Han (Simplified variant)"),


  /**
   * Han (Traditional variant) [502]
   */
  Hant(502, "Han (Traditional variant)"),

  /**
   * Hatran [127]
   */
  Hatr(127, "Hatran"),


  /**
   * Hebrew [125]
   */
  Hebr(125, "Hebrew"),


  /**
   * Hiragana [410]
   */
  Hira(410, "Hiragana"),


  /**
   * Anatolian Hieroglyphs (Luwian Hieroglyphs, Hittite Hieroglyphs) [080]
   */
  Hluw(80, "Anatolian Hieroglyphs (Luwian Hieroglyphs, Hittite Hieroglyphs)"),


  /**
   * Pahawh Hmong [450]
   */
  Hmng(450, "Pahawh Hmong"),

  /**
   * Nyiakeng Puachue Hmong [451]
   */
  Hmnp(451, "Nyiakeng Puachue Hmong"),

  /**
   * Han (Traditional variant) with Latin (alias for Hant + Latn) [504]
   */
  Hntl(504, "Han (Traditional variant) with Latin (alias for Hant + Latn)"),


  /**
   * Japanese syllabaries (alias for Hiragana + Katakana) [412]
   */
  Hrkt(412, "Japanese syllabaries (alias for Hiragana + Katakana)"),


  /**
   * Old Hungarian (Hungarian Runic) [176]
   */
  Hung(176, "Old Hungarian (Hungarian Runic)"),


  /**
   * Indus (Harappan) [610]
   */
  Inds(610, "Indus (Harappan)"),


  /**
   * Old Italic (Etruscan, Oscan, etc.) [210]
   */
  Ital(210, "Old Italic (Etruscan, Oscan, etc.)"),

  /**
   * Jamo (alias for Jamo subset of Hangul) [284]
   */
  Jamo(284, "Jamo (alias for Jamo subset of Hangul)"),

  /**
   * Javanese [361]
   */
  Java(361, "Javanese"),


  /**
   * Japanese (alias for Han + Hiragana + Katakana) [413]
   */
  Jpan(413, "Japanese (alias for Han + Hiragana + Katakana)"),


  /**
   * Jurchen [510]
   */
  Jurc(510, "Jurchen"),


  /**
   * Kayah Li [357]
   */
  Kali(357, "Kayah Li"),


  /**
   * Katakana [411]
   */
  Kana(411, "Katakana"),

  /**
   * Kawi [368]
   */
  Kawi(368, "Kawi"),


  /**
   * Kharoshthi [305]
   */
  Khar(305, "Kharoshthi"),


  /**
   * Khmer [355]
   */
  Khmr(355, "Khmer"),


  /**
   * Khojki [322]
   */
  Khoj(322, "Khojki"),

  /**
   * Khitan large script [505]
   */
  Kitl(505, "Khitan large script"),

  /**
   * Khitan small script [288]
   */
  Kits(288, "Khitan small script"),


  /**
   * Kannada [345]
   */
  Knda(345, "Kannada"),


  /**
   * Korean (alias for Hangul + Han) [287]
   */
  Kore(287, "Korean (alias for Hangul + Han)"),


  /**
   * Kpelle [436]
   */
  Kpel(436, "Kpelle"),

  /**
   * Kirat Rai [396]
   */
  Krai(396, "Kirat Rai"),


  /**
   * Kaithi [317]
   */
  Kthi(317, "Kaithi"),


  /**
   * Tai Tham (Lanna) [351]
   */
  Lana(351, "Tai Tham (Lanna)"),


  /**
   * Lao [356]
   */
  Laoo(356, "Lao"),


  /**
   * Latin (Fraktur variant) [217]
   */
  Latf(217, "Latin (Fraktur variant)"),


  /**
   * Latin (Gaelic variant) [216]
   */
  Latg(216, "Latin (Gaelic variant)"),


  /**
   * Latin [215]
   */
  Latn(215, "Latin"),

  /**
   * Leke [364]
   */
  Leke(364, "Leke"),


  /**
   * Lepcha [335]
   */
  Lepc(335, "Lepcha"),


  /**
   * Limbu [336]
   */
  Limb(336, "Limbu"),


  /**
   * Linear A [400]
   */
  Lina(400, "Linear A"),


  /**
   * Linear B [401]
   */
  Linb(401, "Linear B"),


  /**
   * Lisu (Fraser) [399]
   */
  Lisu(399, "Lisu (Fraser)"),


  /**
   * Loma [437]
   */
  Loma(437, "Loma"),


  /**
   * Lycian [202]
   */
  Lyci(202, "Lycian"),


  /**
   * Lydian [116]
   */
  Lydi(116, "Lydian"),


  /**
   * Mahajani [314]
   */
  Mahj(314, "Mahajani"),

  /**
   * Makasar [366]
   */
  Maka(366, "Makasar"),


  /**
   * Mandaic, Mandaean [140]
   */
  Mand(140, "Mandaic, Mandaean"),


  /**
   * Manichaean [139]
   */
  Mani(139, "Manichaean"),

  /**
   * Marchen [332]
   */
  Marc(332, "Marchen"),


  /**
   * Mayan hieroglyphs [090]
   */
  Maya(90, "Mayan hieroglyphs"),

  /**
   * Medefaidrin [265]
   */
  Medf(265, "Medefaidrin"),


  /**
   * Mende Kikakui [438]
   */
  Mend(438, "Mende Kikakui"),


  /**
   * Meroitic Cursive [101]
   */
  Merc(101, "Meroitic Cursive"),


  /**
   * Meroitic Hieroglyphs [100]
   */
  Mero(100, "Meroitic Hieroglyphs"),


  /**
   * Malayalam [347]
   */
  Mlym(347, "Malayalam"),

  /**
   * Modi [324]
   */
  Modi(324, "Modi"),

  /**
   * Mongolian [145]
   */
  Mong(145, "Mongolian"),


  /**
   * Moon (Moon code, Moon script, Moon type) [218]
   */
  Moon(218, "Moon (Moon code, Moon script, Moon type)"),


  /**
   * Mro, Mru [264]
   */
  Mroo(264, "Mro, Mru"),


  /**
   * Meitei Mayek (Meithei, Meetei) [337]
   */
  Mtei(337, "Meitei Mayek (Meithei, Meetei)"),

  /**
   * Multani [323]
   */
  Mult(323, "Multani"),


  /**
   * Myanmar (Burmese) [350]
   */
  Mymr(350, "Myanmar (Burmese)"),

  /**
   * Nag Mundari [295]
   */
  Nagm(295, "Nag Mundari"),

  /**
   * Nandinagari [311]
   */
  Nand(311, "Nandinagari"),


  /**
   * Old North Arabian (Ancient North Arabian) [106]
   */
  Narb(106, "Old North Arabian (Ancient North Arabian)"),


  /**
   * Nabataean [159]
   */
  Nbat(159, "Nabataean"),

  /**
   * Newa, Newar, Newari [333]
   */
  Newa(333, "Newa, Newar, Newari"),

  /**
   * Naxi Dongba [85]
   */
  Nkdb(85, "Naxi Dongba"),

  /**
   * Naxi Geba [420]
   */
  Nkgb(420, "Naxi Geba"),


  /**
   * N’Ko [165]
   */
  Nkoo(165, "N’Ko"),


  /**
   * Nushu [499]
   */
  Nshu(499, "Nushu"),


  /**
   * Ogham [212]
   */
  Ogam(212, "Ogham"),


  /**
   * Ol Chiki (Ol Cemet’, Ol, Santali) [261]
   */
  Olck(261, "Ol Chiki (Ol Cemet’, Ol, Santali)"),

  /**
   * Ol Onal [296]
   */
  Onao(296, "Ol Onal"),


  /**
   * Old Turkic, Orkhon Runic [175]
   */
  Orkh(175, "Old Turkic, Orkhon Runic"),


  /**
   * Oriya (Odia) [327]
   */
  Orya(327, "Oriya (Odia)"),

  /**
   * Osage [219]
   */
  Osge(219, "Osage"),


  /**
   * Osmanya [260]
   */
  Osma(260, "Osmanya"),

  /**
   * Old Uyghur [143]
   */
  Ougr(143, "Old Uyghur"),


  /**
   * Palmyrene [126]
   */
  Palm(126, "Palmyrene"),

  /**
   * Pau Cin Hau [263]
   */
  Pauc(263, "Pau Cin Hau"),

  /**
   * Proto-Cuneiform [15]
   */
  Pcun(15, "Proto-Cuneiform"),

  /**
   * Proto-Elamite [16]
   */
  Pelm(16, "Proto-Elamite"),


  /**
   * Old Permic [227]
   */
  Perm(227, "Old Permic"),


  /**
   * Phags-pa [331]
   */
  Phag(331, "Phags-pa"),


  /**
   * Inscriptional Pahlavi [131]
   */
  Phli(131, "Inscriptional Pahlavi"),


  /**
   * Psalter Pahlavi [132]
   */
  Phlp(132, "Psalter Pahlavi"),


  /**
   * Book Pahlavi [133]
   */
  Phlv(133, "Book Pahlavi"),


  /**
   * Phoenician [115]
   */
  Phnx(115, "Phoenician"),

  /**
   * Klingon (KLI pIqaD) [293]
   */
  Piqd(293, "Klingon (KLI pIqaD)"),


  /**
   * Miao (Pollard) [282]
   */
  Plrd(282, "Miao (Pollard)"),


  /**
   * Inscriptional Parthian [130]
   */
  Prti(130, "Inscriptional Parthian"),

  /**
   * Proto-Sinaitic [103]
   */
  Psin(103, "Proto-Sinaitic"),


  /**
   * Reserved for private use [900]
   */
  Qaaa(900, "Reserved for private use"),

  /**
   * Reserved for private use [901]
   */
  Qaab(901, "Reserved for private use"),

  /**
   * Reserved for private use [902]
   */
  Qaac(902, "Reserved for private use"),

  /**
   * Reserved for private use [903]
   */
  Qaad(903, "Reserved for private use"),

  /**
   * Reserved for private use [904]
   */
  Qaae(904, "Reserved for private use"),

  /**
   * Reserved for private use [905]
   */
  Qaaf(905, "Reserved for private use"),

  /**
   * Reserved for private use [906]
   */
  Qaag(906, "Reserved for private use"),

  /**
   * Reserved for private use [907]
   */
  Qaah(907, "Reserved for private use"),

  /**
   * Reserved for private use [908]
   */
  Qaai(908, "Reserved for private use"),

  /**
   * Reserved for private use [909]
   */
  Qaaj(909, "Reserved for private use"),

  /**
   * Reserved for private use [910]
   */
  Qaak(910, "Reserved for private use"),

  /**
   * Reserved for private use [911]
   */
  Qaal(911, "Reserved for private use"),

  /**
   * Reserved for private use [912]
   */
  Qaam(912, "Reserved for private use"),

  /**
   * Reserved for private use [913]
   */
  Qaan(913, "Reserved for private use"),

  /**
   * Reserved for private use [914]
   */
  Qaao(914, "Reserved for private use"),

  /**
   * Reserved for private use [915]
   */
  Qaap(915, "Reserved for private use"),

  /**
   * Reserved for private use [916]
   */
  Qaaq(916, "Reserved for private use"),

  /**
   * Reserved for private use [917]
   */
  Qaar(917, "Reserved for private use"),

  /**
   * Reserved for private use [918]
   */
  Qaas(918, "Reserved for private use"),

  /**
   * Reserved for private use [919]
   */
  Qaat(919, "Reserved for private use"),

  /**
   * Reserved for private use [920]
   */
  Qaau(920, "Reserved for private use"),

  /**
   * Reserved for private use [921]
   */
  Qaav(921, "Reserved for private use"),

  /**
   * Reserved for private use [922]
   */
  Qaaw(922, "Reserved for private use"),

  /**
   * Reserved for private use [923]
   */
  Qaax(923, "Reserved for private use"),

  /**
   * Reserved for private use [924]
   */
  Qaay(924, "Reserved for private use"),

  /**
   * Reserved for private use [925]
   */
  Qaaz(925, "Reserved for private use"),

  /**
   * Reserved for private use [926]
   */
  Qaba(926, "Reserved for private use"),

  /**
   * Reserved for private use [927]
   */
  Qabb(927, "Reserved for private use"),

  /**
   * Reserved for private use [928]
   */
  Qabc(928, "Reserved for private use"),

  /**
   * Reserved for private use [929]
   */
  Qabd(929, "Reserved for private use"),

  /**
   * Reserved for private use [930]
   */
  Qabe(930, "Reserved for private use"),

  /**
   * Reserved for private use [931]
   */
  Qabf(931, "Reserved for private use"),

  /**
   * Reserved for private use [932]
   */
  Qabg(932, "Reserved for private use"),

  /**
   * Reserved for private use [933]
   */
  Qabh(933, "Reserved for private use"),

  /**
   * Reserved for private use [934]
   */
  Qabi(934, "Reserved for private use"),

  /**
   * Reserved for private use [935]
   */
  Qabj(935, "Reserved for private use"),

  /**
   * Reserved for private use [936]
   */
  Qabk(936, "Reserved for private use"),

  /**
   * Reserved for private use [937]
   */
  Qabl(937, "Reserved for private use"),

  /**
   * Reserved for private use [938]
   */
  Qabm(938, "Reserved for private use"),

  /**
   * Reserved for private use [939]
   */
  Qabn(939, "Reserved for private use"),

  /**
   * Reserved for private use [940]
   */
  Qabo(940, "Reserved for private use"),

  /**
   * Reserved for private use [941]
   */
  Qabp(941, "Reserved for private use"),

  /**
   * Reserved for private use [942]
   */
  Qabq(942, "Reserved for private use"),

  /**
   * Reserved for private use [943]
   */
  Qabr(943, "Reserved for private use"),

  /**
   * Reserved for private use [944]
   */
  Qabs(944, "Reserved for private use"),

  /**
   * Reserved for private use [945]
   */
  Qabt(945, "Reserved for private use"),

  /**
   * Reserved for private use [946]
   */
  Qabu(946, "Reserved for private use"),

  /**
   * Reserved for private use [947]
   */
  Qabv(947, "Reserved for private use"),

  /**
   * Reserved for private use [948]
   */
  Qabw(948, "Reserved for private use"),

  /**
   * Reserved for private use [949]
   */
  Qabx(949, "Reserved for private use"),

  /**
   * Ranjana [303]
   */
  Ranj(303, "Ranjana"),


  /**
   * Rejang (Redjang, Kaganga) [363]
   */
  Rjng(363, "Rejang (Redjang, Kaganga)"),

  /**
   * Hanifi Rohingya [167]
   */
  Rohg(167, "Hanifi Rohingya"),


  /**
   * Rongorongo [620]
   */
  Roro(620, "Rongorongo"),


  /**
   * Runic [211]
   */
  Runr(211, "Runic"),


  /**
   * Samaritan [123]
   */
  Samr(123, "Samaritan"),


  /**
   * Sarati [292]
   */
  Sara(292, "Sarati"),


  /**
   * Old South Arabian [105]
   */
  Sarb(105, "Old South Arabian"),


  /**
   * Saurashtra [344]
   */
  Saur(344, "Saurashtra"),

  /**
   * (Small) Seal [590]
   */
  Seal(590, "(Small) Seal"),


  /**
   * SignWriting [095]
   */
  Sgnw(95, "SignWriting"),


  /**
   * Shavian (Shaw) [281]
   */
  Shaw(281, "Shavian (Shaw)"),


  /**
   * Sharada [319]
   */
  Shrd(319, "Sharada"),

  /**
   * Shuishu [530]
   */
  Shui(530, "Shuishu"),

  /**
   * Siddham [302]
   */
  Sidd(302, "Siddham"),

  /**
   * Sidetic [180]
   */
  Sidt(180, "Sidetic"),


  /**
   * Khudawadi, Sindhi [318]
   */
  Sind(318, "Khudawadi, Sindhi"),


  /**
   * Sinhala [348]
   */
  Sinh(348, "Sinhala"),

  /**
   * Sogdian [141]
   */
  Sogd(141, "Sogdian"),

  /**
   * Old Sogdian [142]
   */
  Sogo(142, "Old Sogdian"),


  /**
   * Sora Sompeng [398]
   */
  Sora(398, "Sora Sompeng"),

  /**
   * Soyombo [329]
   */
  Soyo(329, "Soyombo"),


  /**
   * Sundanese [362]
   */
  Sund(362, "Sundanese"),

  /**
   * Sunuwar [274]
   */
  Sunu(274, "Sunuwar"),


  /**
   * Syloti Nagri [316]
   */
  Sylo(316, "Syloti Nagri"),


  /**
   * Syriac [135]
   */
  Syrc(135, "Syriac"),


  /**
   * Syriac (Estrangelo variant) [138]
   */
  Syre(138, "Syriac (Estrangelo variant)"),


  /**
   * Syriac (Western variant) [137]
   */
  Syrj(137, "Syriac (Western variant)"),


  /**
   * Syriac (Eastern variant) [136]
   */
  Syrn(136, "Syriac (Eastern variant)"),


  /**
   * Tagbanwa [373]
   */
  Tagb(373, "Tagbanwa"),


  /**
   * Takri [321]
   */
  Takr(321, "Takri"),


  /**
   * Tai Le [353]
   */
  Tale(353, "Tai Le"),


  /**
   * New Tai Lue [354]
   */
  Talu(354, "New Tai Lue"),


  /**
   * Tamil [346]
   */
  Taml(346, "Tamil"),


  /**
   * Tangut [520]
   */
  Tang(520, "Tangut"),


  /**
   * Tai Viet [359]
   */
  Tavt(359, "Tai Viet"),

  /**
   * Tai Yo [380]
   */
  Tayo(380, "Tai Yo"),


  /**
   * Telugu [340]
   */
  Telu(340, "Telugu"),


  /**
   * Tengwar [290]
   */
  Teng(290, "Tengwar"),


  /**
   * Tifinagh (Berber) [120]
   */
  Tfng(120, "Tifinagh (Berber)"),


  /**
   * Tagalog (Baybayin, Alibata) [370]
   */
  Tglg(370, "Tagalog (Baybayin, Alibata)"),


  /**
   * Thaana [170]
   */
  Thaa(170, "Thaana"),


  /**
   * Thai [352]
   */
  Thai(352, "Thai"),


  /**
   * Tibetan [330]
   */
  Tibt(330, "Tibetan"),


  /**
   * Tirhuta [326]
   */
  Tirh(326, "Tirhuta"),

  /**
   * Tangsa [275]
   */
  Tnsa(275, "Tangsa"),

  /**
   * Todhri [229]
   */
  Todr(229, "Todhri"),

  /**
   * Tolong Siki [299]
   */
  Tols(299, "Tolong Siki"),

  /**
   * Toto [294]
   */
  Toto(294, "Toto"),

  /**
   * Tulu-Tigalari [341]
   */
  Tutg(341, "Tulu-Tigalari"),


  /**
   * Ugaritic [040]
   */
  Ugar(40, "Ugaritic"),


  /**
   * Vai [470]
   */
  Vaii(470, "Vai"),


  /**
   * Visible Speech [280]
   */
  Visp(280, "Visible Speech"),

  /**
   * Vithkuqi [228]
   */
  Vith(228, "Vithkuqi"),


  /**
   * Warang Citi (Varang Kshiti) [262]
   */
  Wara(262, "Warang Citi (Varang Kshiti)"),

  /**
   * Wancho [283]
   */
  Wcho(283, "Wancho"),


  /**
   * Woleai [480]
   */
  Wole(480, "Woleai"),


  /**
   * Old Persian [030]
   */
  Xpeo(30, "Old Persian"),


  /**
   * Cuneiform, Sumero-Akkadian [020]
   */
  Xsux(20, "Cuneiform, Sumero-Akkadian"),

  /**
   * Yezidi [192]
   */
  Yezi(192, "Yezidi"),


  /**
   * Yi [460]
   */
  Yiii(460, "Yi"),

  /**
   * Zanabazar Square [339]
   */
  Zanb(339, "Zanabazar Square"),


  /**
   * Code for inherited script [994]
   */
  Zinh(994, "Code for inherited script"),


  /**
   * Mathematical notation [995]
   */
  Zmth(995, "Mathematical notation"),

  /**
   * Symbols (emoji variant) [993]
   */
  Zsye(993, "Symbols (emoji variant)"),


  /**
   * Symbols [996]
   */
  Zsym(996, "Symbols"),


  /**
   * Code for unwritten documents [997]
   */
  Zxxx(997, "Code for unwritten documents"),


  /**
   * Code for undetermined script [998]
   */
  Zyyy(998, "Code for undetermined script"),


  /**
   * Code for uncoded script [999]
   */
  Zzzz(999, "Code for uncoded script");


  /**
   * Map to look up ScriptCode by numeric code.
   */
  private static final Map<Integer, ScriptCode> numericMap = new HashMap<>();


  static {
    for (ScriptCode sc : values()) {
      if (sc.getNumeric() != -1) {
        numericMap.put(sc.getNumeric(), sc);
      }
    }
  }


  /**
   * The numeric code of this script code.
   */
  private final int numeric;


  /**
   * English name of this script code.
   */
  private final String name;


  /**
   * Constructor.
   */
  ScriptCode(int numeric, String name) {
    this.numeric = numeric;
    this.name = name;
  }


  /**
   * Get the numeric code of this script code.
   *
   * @return Numeric code.
   */
  public int getNumeric() {
    return numeric;
  }


  /**
   * Get English name of this script code.
   *
   * @return English name.
   */
  public String getName() {
    return name;
  }


  /**
   * Convert this {@code ScriptCode} instance to a {@link Locale} instance.
   *
   * <p>
   * This method creates a new {@code Locale} instance
   * every time it is called.
   * </p>
   *
   * @return A {@code Locale} instance that matches this {@code ScriptCode}.
   * @since 1.30
   */
  public Locale toLocale() {
    return new Locale.Builder().setScript(name()).build();
  }

  /**
   * Get a {@code ScriptCode} instance that corresponds to the given
   * ISO 15924 alpha-4 code.
   *
   * <p>
   * This method calls {@link #getByCode(String, boolean) getByCode}{@code (code, true)}.
   * Note that the behavior has changed since the version 1.13. In the older versions,
   * this method was an alias of {@code getByCode(code, false)}.
   * </p>
   *
   * @param code ISO 15924 alpha-4 code. Or "Undefined" (case-sensitive).
   * @return A {@code ScriptCode} instance, or {@code null} if not found.
   */
  public static ScriptCode getByCode(String code) {
    return getByCode(code, true);
  }


  /**
   * Get a {@code ScriptCode} instance that corresponds to the given
   * ISO 15924 alpha-4 code.
   *
   * <p>
   * This method calls {@link #getByCode(String, boolean) getByCode}{@code (code, false)}.
   * </p>
   *
   * @param code ISO 15924 alpha-4 code. Or "Undefined" (case-insensitive).
   * @return A {@code ScriptCode} instance, or {@code null} if not found.
   * @since 1.13
   */
  public static ScriptCode getByCodeIgnoreCase(String code) {
    return getByCode(code, false);
  }


  /**
   * Get a {@code ScriptCode} instance that corresponds to the given
   * ISO 15924 alpha-4 code.
   *
   * @param code          ISO 15924 alpha-4 code. Or "Undefined" (its case sensitivity
   *                      depends on the value of {@code caseSensitive}).
   * @param caseSensitive If {@code true}, the first letter of the given code should be
   *                      capital and the other letters should be small. If {@code false},
   *                      whether letters are capital or small does not matter.
   *                      For example, {@code getByCode("JPAN", true)} returns
   *                      {@code null} but {@code getByCode("JPAN", false)} returns
   *                      {@link #Jpan}.
   * @return A {@code ScriptCode} instance, or {@code null} if not found.
   */
  public static ScriptCode getByCode(String code, boolean caseSensitive) {
    if (code == null) {
      return null;
    }

    switch (code.length()) {
      case 4:
      case 9:
        break;

      default:
        return null;
    }

    code = canonicalize(code, caseSensitive);

    try {
      return Enum.valueOf(ScriptCode.class, code);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }


  /**
   * Get a {@code ScriptCode} instance that corresponds to the given
   * ISO 15924 numeric code.
   *
   * @param code ISO 15924 numeric code.
   * @return A {@code ScriptCode} instance, or {@code null} if not found.
   * If 0 or a negative value is given, {@code null} is returned.
   */
  public static ScriptCode getByCode(int code) {
    if (code <= 0) {
      return null;
    }

    return numericMap.get(code);
  }

  /**
   * Get a {@code ScriptCode} that corresponds to the script code of
   * the given {@link Locale} instance.
   *
   * @param locale A {@code Locale} instance.
   * @return A {@code ScriptCode} instance, or {@code null} if not found.
   * When {@link Locale#getScript() getScript()} method of the
   * given {@code Locale} instance returns {@code null} or an
   * empty string, {@link #Undefined ScriptCode.Undefined} is
   * returned.
   * @see Locale#getScript()
   */
  public static ScriptCode getByLocale(Locale locale) {
    if (locale == null) {
      return null;
    }

    String script = locale.getScript();

    if (script.isEmpty()) {
      return ScriptCode.Undefined;
    }

    return ScriptCode.getByCode(script, true);
  }

  private static String canonicalize(String code, boolean caseSensitive) {
    if (caseSensitive) {
      return code;
    }

    // Lazily allocate the builder only when a character actually needs
    // canonicalization. This preserves the original String instance
    // when the input is already in canonical form.
    StringBuilder sb = null;

    for (int i = 0; i < code.length(); i++) {
      char original = code.charAt(i);

      // Canonical form uses an uppercase first character
// followed by lowercase characters.
      char canonical = (i == 0)
        ? Character.toUpperCase(original)
        : Character.toLowerCase(original);

      if (sb != null) {
        // Once a modification has started, append all remaining
        // characters in canonical form.
        sb.append(canonical);
      } else if (original != canonical) {
        // Allocate only at the first required modification and copy
        // the already validated prefix unchanged.
        sb = new StringBuilder(code.length());
        sb.append(code, 0, i);
        sb.append(canonical);
      }
    }

    // Avoid creating a new String when no normalization was required.
    return sb == null ? code : sb.toString();
  }


  /**
   * Get a list of {@code ScriptCode} by a name regular expression.
   *
   * <p>
   * This method is almost equivalent to {@link #findByName(Pattern)
   * findByName}{@code (Pattern.compile(regex))}.
   * </p>
   *
   * @param regex Regular expression for names.
   * @return List of {@code ScriptCode}. If nothing has matched,
   * an empty list is returned.
   * @throws IllegalArgumentException               {@code regex} is {@code null}.
   * @throws java.util.regex.PatternSyntaxException {@code regex} failed to be compiled.
   * @since 1.11
   */
  public static List<ScriptCode> findByName(String regex) {
    if (regex == null) {
      throw new IllegalArgumentException("regex is null.");
    }

    // Compile the regular expression. This may throw
    // java.util.regex.PatternSyntaxException.
    Pattern pattern = Pattern.compile(regex);

    return findByName(pattern);
  }


  /**
   * Get a list of {@code ScriptCode} by a name pattern.
   *
   * <p>
   * For example, the list obtained by the code snippet below:
   * </p>
   *
   * <pre style="background-color: #EEEEEE; margin-left: 2em; margin-right: 2em; border: 1px solid black; padding: 0.5em;">
   * Pattern pattern = Pattern.compile(<span style="color: darkred;">"Egyptian.*"</span>);
   * List&lt;ScriptCode&gt; list = ScriptCode.findByName(pattern);</pre>
   *
   * <p>
   * contains 3 {@code ScriptCode}s as listed below.
   * </p>
   *
   * <ol>
   * <li>{@link #Egyd} : Egyptian demotic
   * <li>{@link #Egyh} : Egyptian hieratic
   * <li>{@link #Egyp} : Egyptian hieroglyphs
   * </ol>
   *
   * @param pattern Pattern to match names.
   * @return List of {@code ScriptCode}. If nothing has matched,
   * an empty list is returned.
   * @throws IllegalArgumentException {@code pattern} is {@code null}.
   * @since 1.11
   */
  public static List<ScriptCode> findByName(Pattern pattern) {
    if (pattern == null) {
      throw new IllegalArgumentException("pattern is null.");
    }

    List<ScriptCode> list = new ArrayList<>();

    for (ScriptCode entry : values()) {
      // If the name matches the given pattern.
      if (pattern.matcher(entry.getName()).matches()) {
        list.add(entry);
      }
    }

    return list;
  }
}
