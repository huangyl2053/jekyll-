/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 委員審査会資料組み合わせ一覧A3のReportSourceです。
 *
 * @reamsid_L DBE-0150-200 zhaoyao
 */
public class IinShinsakaishiryoA3ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    //DBE517001
    @ReportItem(name = "one_shinsakaiNo", length = 4, order = 1)
    public RString one_shinsakaiNo;
    @ReportItem(name = "one_ShinsainName1", length = 20, order = 2)
    public RString one_ShinsainName1;
    @ReportItem(name = "one_ShinsainName2", length = 20, order = 3)
    public RString one_ShinsainName2;
    @ReportItem(name = "one_shinsakaiKaisaiYMD", length = 21, order = 4)
    public RString one_shinsakaiKaisaiYMD;
    @ReportItem(name = "one_ShinsainName3", length = 20, order = 5)
    public RString one_ShinsainName3;
    @ReportItem(name = "one_ShinsainName4", length = 20, order = 6)
    public RString one_ShinsainName4;
    @ReportItem(name = "one_ShinsainName5", length = 20, order = 7)
    public RString one_ShinsainName5;
    @ReportItem(name = "one_gogitaiNo", length = 2, order = 8)
    public RString one_gogitaiNo;
    @ReportItem(name = "one_ShinsainName6", length = 20, order = 9)
    public RString one_ShinsainName6;
    @ReportItem(name = "one_shinsaTaishoshaCount", length = 2, order = 10)
    public RString one_shinsaTaishoshaCount;
    @ReportItem(name = "one_ShinsainName7", length = 20, order = 11)
    public RString one_ShinsainName7;
    @ReportItem(name = "one_ShinsainName8", length = 20, order = 12)
    public RString one_ShinsainName8;
    @ReportItem(name = "one_listShinsei1_1", length = 2, order = 13)
    public RString one_listShinsei1_1;
    @ReportItem(name = "one_listShinsei1_2", length = 6, order = 14)
    public RString one_listShinsei1_2;
    @ReportItem(name = "one_listShinsei1_3", length = 10, order = 15)
    public RString one_listShinsei1_3;
    @ReportItem(name = "one_listShinsei1_4", length = 30, order = 16)
    public RString one_listShinsei1_4;
    @ReportItem(name = "one_listShinsei1_5", length = 1, order = 17)
    public RString one_listShinsei1_5;
    @ReportItem(name = "one_listShinsei1_6", length = 3, order = 18)
    public RString one_listShinsei1_6;
    @ReportItem(name = "one_listShinsei1_7", length = 3, order = 19)
    public RString one_listShinsei1_7;
    @ReportItem(name = "one_listShinsei1_8", length = 4, order = 20)
    public RString one_listShinsei1_8;
    @ReportItem(name = "one_listShinsei1_9", length = 7, order = 21)
    public RString one_listShinsei1_9;
    @ReportItem(name = "one_listShinsei1_10", length = 3, order = 22)
    public RString one_listShinsei1_10;
    @ReportItem(name = "one_listShinsei1_11", length = 4, order = 23)
    public RString one_listShinsei1_11;
    @ReportItem(name = "one_listShinsei2_1", length = 2, order = 24)
    public RString one_listShinsei2_1;
    @ReportItem(name = "one_listShinsei2_2", length = 6, order = 25)
    public RString one_listShinsei2_2;
    @ReportItem(name = "one_listShinsei2_3", length = 10, order = 26)
    public RString one_listShinsei2_3;
    @ReportItem(name = "one_listShinsei2_4", length = 30, order = 27)
    public RString one_listShinsei2_4;
    @ReportItem(name = "one_listShinsei2_5", length = 1, order = 28)
    public RString one_listShinsei2_5;
    @ReportItem(name = "one_listShinsei2_6", length = 3, order = 29)
    public RString one_listShinsei2_6;
    @ReportItem(name = "one_listShinsei2_7", length = 3, order = 30)
    public RString one_listShinsei2_7;
    @ReportItem(name = "one_listShinsei2_8", length = 4, order = 31)
    public RString one_listShinsei2_8;
    @ReportItem(name = "one_listShinsei2_9", length = 7, order = 32)
    public RString one_listShinsei2_9;
    @ReportItem(name = "one_listShinsei2_10", length = 3, order = 33)
    public RString one_listShinsei2_10;
    @ReportItem(name = "one_listShinsei2_11", length = 4, order = 34)
    public RString one_listShinsei2_11;
    @ReportItem(name = "one_listZenkaiｙukokikan1_1", length = 19, order = 35)
    public RString one_listZenkaiｙukokikan1_1;
    @ReportItem(name = "one_listYukokikan1_1", length = 19, order = 36)
    public RString one_listYukokikan1_1;
    @ReportItem(name = "one_listZenkaiｙukokikan2_1", length = 19, order = 37)
    public RString one_listZenkaiｙukokikan2_1;
    @ReportItem(name = "one_listYukokikan2_1", length = 19, order = 38)
    public RString one_listYukokikan2_1;

    //DBE517085
    @ReportItem(name = "two_gogitaiNo", length = 3, order = 101)
    public RString two_gogitaiNo;
    @ReportItem(name = "two_zenZenkaiHanteikekka", length = 8, order = 102)
    public RString two_zenZenkaiHanteikekka;
    @ReportItem(name = "two_zenzenkaiYukokikan", length = 4, order = 103)
    public RString two_zenzenkaiYukokikan;
    @ReportItem(name = "two_zZenkaiNijiKaishiYMD", length = 9, order = 104)
    public RString two_zZenkaiNijiKaishiYMD;
    @ReportItem(name = "two_zZenkaiNijishuryoYMD", length = 9, order = 105)
    public RString two_zZenkaiNijishuryoYMD;
    @ReportItem(name = "two_kanriNo", length = 20, order = 106)
    public RString two_kanriNo;
    @ReportItem(name = "two_shinseiYMD", length = 9, order = 107)
    public RString two_shinseiYMD;
    @ReportItem(name = "two_sakuseiYMD", length = 9, order = 108)
    public RString two_sakuseiYMD;
    @ReportItem(name = "two_shinseiCount", length = 2, order = 109)
    public RString two_shinseiCount;
    @ReportItem(name = "two_shinseiCountGokei", length = 2, order = 110)
    public RString two_shinseiCountGokei;
    @ReportItem(name = "two_hihokenshaKubun", length = 7, order = 111)
    public RString two_hihokenshaKubun;
    @ReportItem(name = "two_age", length = 5, order = 112)
    public RString two_age;
    @ReportItem(name = "two_zenkaiNijihanteikekka", length = 8, order = 113)
    public RString two_zenkaiNijihanteikekka;
    @ReportItem(name = "two_zenkaiYukokikan", length = 4, order = 114)
    public RString two_zenkaiYukokikan;
    @ReportItem(name = "two_zenkaiNijiKaishiYMD", length = 9, order = 115)
    public RString two_zenkaiNijiKaishiYMD;
    @ReportItem(name = "two_zenkaiNijiShuryoYMD", length = 9, order = 116)
    public RString two_zenkaiNijiShuryoYMD;
    @ReportItem(name = "two_zenkaiNijihanteiDate", length = 9, order = 117)
    public RString two_zenkaiNijihanteiDate;
    @ReportItem(name = "two_zenkaiJotaizo", length = 10, order = 118)
    public RString two_zenkaiJotaizo;
    @ReportItem(name = "two_chosaYMD", length = 9, order = 119)
    public RString two_chosaYMD;
    @ReportItem(name = "two_shinsaYMD", length = 9, order = 120)
    public RString two_shinsaYMD;
    @ReportItem(name = "two_seibetsu", length = 1, order = 121)
    public RString two_seibetsu;
    @ReportItem(name = "two_shinseiKubun", length = 13, order = 122)
    public RString two_shinseiKubun;
    @ReportItem(name = "two_ichijiHanteiKekka", length = 12, order = 123)
    public RString two_ichijiHanteiKekka;
    @ReportItem(name = "two_kijunGokeiTime", length = 40, order = 124)
    public RString two_kijunGokeiTime;
    @ReportItem(name = "two_listFuseigo1_1", length = 1, order = 125)
    public RString two_listFuseigo1_1;
    @ReportItem(name = "two_listFuseigo1_2", length = 1, order = 126)
    public RString two_listFuseigo1_2;
    @ReportItem(name = "two_listIchigun_1", length = 22, order = 127)
    public RString two_listIchigun_1;
    @ReportItem(name = "two_listIchigun_2", length = 1, order = 128)
    public RString two_listIchigun_2;
    @ReportItem(name = "two_listIchigun_3", length = 1, order = 129)
    public RString two_listIchigun_3;
    @ReportItem(name = "two_listIchigun_4", length = 22, order = 130)
    public RString two_listIchigun_4;
    @ReportItem(name = "two_zenkaiKijunGokeiTime", length = 40, order = 131)
    public RString two_zenkaiKijunGokeiTime;
    @ReportItem(name = "two_gurafuKijunTime", order = 132)
    public RString two_gurafuKijunTime;
    @ReportItem(name = "two_listKijunTime_1", length = 7, order = 133)
    public RString two_listKijunTime_1;
    @ReportItem(name = "two_listKijunTime_2", length = 7, order = 134)
    public RString two_listKijunTime_2;
    @ReportItem(name = "two_listKijunTime_3", length = 7, order = 135)
    public RString two_listKijunTime_3;
    @ReportItem(name = "two_listKijunTime_4", length = 7, order = 136)
    public RString two_listKijunTime_4;
    @ReportItem(name = "two_listKijunTime_5", length = 7, order = 137)
    public RString two_listKijunTime_5;
    @ReportItem(name = "two_listKijunTime_6", length = 7, order = 138)
    public RString two_listKijunTime_6;
    @ReportItem(name = "two_listKijunTime_7", length = 7, order = 139)
    public RString two_listKijunTime_7;
    @ReportItem(name = "two_listKijunTime_8", length = 7, order = 140)
    public RString two_listKijunTime_8;
    @ReportItem(name = "two_listKijunTime_9", length = 7, order = 141)
    public RString two_listKijunTime_9;
    @ReportItem(name = "two_listFuseigo2_1", length = 1, order = 142)
    public RString two_listFuseigo2_1;
    @ReportItem(name = "two_listFuseigo2_2", length = 1, order = 143)
    public RString two_listFuseigo2_2;
    @ReportItem(name = "two_listNigun_1", length = 22, order = 144)
    public RString two_listNigun_1;
    @ReportItem(name = "two_listNigun_2", length = 1, order = 145)
    public RString two_listNigun_2;
    @ReportItem(name = "two_listNigun_3", length = 1, order = 146)
    public RString two_listNigun_3;
    @ReportItem(name = "two_listNigun_4", length = 22, order = 147)
    public RString two_listNigun_4;
    @ReportItem(name = "two_chosaJisshiDate1", length = 9, order = 148)
    public RString two_chosaJisshiDate1;
    @ReportItem(name = "two_chosaJisshiBasho", length = 30, order = 149)
    public RString two_chosaJisshiBasho;
    @ReportItem(name = "two_tokuteishippeiName", length = 40, order = 150)
    public RString two_tokuteishippeiName;
    @ReportItem(name = "two_keikokuNo", length = 120, order = 151)
    public RString two_keikokuNo;
    @ReportItem(name = "two_listFuseigo3_1", length = 1, order = 152)
    public RString two_listFuseigo3_1;
    @ReportItem(name = "two_listFuseigo3_2", length = 1, order = 153)
    public RString two_listFuseigo3_2;
    @ReportItem(name = "two_listSangun_1", length = 22, order = 154)
    public RString two_listSangun_1;
    @ReportItem(name = "two_listSangun_2", length = 1, order = 155)
    public RString two_listSangun_2;
    @ReportItem(name = "two_listSangun_3", length = 1, order = 156)
    public RString two_listSangun_3;
    @ReportItem(name = "two_listSangun_4", length = 22, order = 157)
    public RString two_listSangun_4;
    @ReportItem(name = "two_listChukanhyoka_1", length = 5, order = 158)
    public RString two_listChukanhyoka_1;
    @ReportItem(name = "two_listChukanhyoka_2", length = 5, order = 159)
    public RString two_listChukanhyoka_2;
    @ReportItem(name = "two_listChukanhyoka_3", length = 5, order = 160)
    public RString two_listChukanhyoka_3;
    @ReportItem(name = "two_listChukanhyoka_4", length = 5, order = 161)
    public RString two_listChukanhyoka_4;
    @ReportItem(name = "two_listChukanhyoka_5", length = 5, order = 162)
    public RString two_listChukanhyoka_5;
    @ReportItem(name = "two_ｌistSeikatsujiritsu_1", length = 2, order = 163)
    public RString two_ｌistSeikatsujiritsu_1;
    @ReportItem(name = "two_ｌistSeikatsujiritsu_2", length = 1, order = 164)
    public RString two_ｌistSeikatsujiritsu_2;
    @ReportItem(name = "two_listFuseigo4_1", length = 1, order = 165)
    public RString two_listFuseigo4_1;
    @ReportItem(name = "two_listFuseigo4_2", length = 1, order = 166)
    public RString two_listFuseigo4_2;
    @ReportItem(name = "two_listYongun_1", length = 22, order = 167)
    public RString two_listYongun_1;
    @ReportItem(name = "two_listYongun_2", length = 1, order = 168)
    public RString two_listYongun_2;
    @ReportItem(name = "two_listYongun_3", length = 1, order = 169)
    public RString two_listYongun_3;
    @ReportItem(name = "two_listYongun_4", length = 22, order = 170)
    public RString two_listYongun_4;
    @ReportItem(name = "two_chosaNinchishoJiritsudo", length = 2, order = 171)
    public RString two_chosaNinchishoJiritsudo;
    @ReportItem(name = "two_ikenNinchiJiritsudo", length = 2, order = 172)
    public RString two_ikenNinchiJiritsudo;
    @ReportItem(name = "two_manzensei", length = 6, order = 173)
    public RString two_manzensei;
    @ReportItem(name = "two_jotainoanteisei", length = 4, order = 174)
    public RString two_jotainoanteisei;
    @ReportItem(name = "two_kyufukubun", length = 4, order = 175)
    public RString two_kyufukubun;
    @ReportItem(name = "two_sabisuKubun", length = 15, order = 176)
    public RString two_sabisuKubun;
    @ReportItem(name = "two_sabisuName1", order = 177)
    public RString two_sabisuName1;
    @ReportItem(name = "two_sabisuKaisu1", length = 11, order = 178)
    public RString two_sabisuKaisu1;
    @ReportItem(name = "two_sabisuName15", order = 179)
    public RString two_sabisuName15;
    @ReportItem(name = "two_sabisuKaisu15", length = 11, order = 180)
    public RString two_sabisuKaisu15;
    @ReportItem(name = "two_sabisuName2", order = 181)
    public RString two_sabisuName2;
    @ReportItem(name = "two_sabisuKaisu2", length = 11, order = 182)
    public RString two_sabisuKaisu2;
    @ReportItem(name = "two_sabisuName16", order = 183)
    public RString two_sabisuName16;
    @ReportItem(name = "two_sabisuKaisu16", length = 11, order = 184)
    public RString two_sabisuKaisu16;
    @ReportItem(name = "two_listFuseigo5_1", length = 1, order = 185)
    public RString two_listFuseigo5_1;
    @ReportItem(name = "two_listFuseigo5_2", length = 1, order = 186)
    public RString two_listFuseigo5_2;
    @ReportItem(name = "two_listGogun_1", length = 22, order = 187)
    public RString two_listGogun_1;
    @ReportItem(name = "two_listGogun_2", length = 1, order = 188)
    public RString two_listGogun_2;
    @ReportItem(name = "two_listGogun_3", length = 1, order = 189)
    public RString two_listGogun_3;
    @ReportItem(name = "two_listGogun_4", length = 22, order = 190)
    public RString two_listGogun_4;
    @ReportItem(name = "two_sabisuName3", order = 191)
    public RString two_sabisuName3;
    @ReportItem(name = "two_sabisuKaisu3", length = 11, order = 192)
    public RString two_sabisuKaisu3;
    @ReportItem(name = "two_sabisuName17", order = 193)
    public RString two_sabisuName17;
    @ReportItem(name = "two_sabisuKaisu17", length = 11, order = 194)
    public RString two_sabisuKaisu17;
    @ReportItem(name = "two_sabisuName4", order = 195)
    public RString two_sabisuName4;
    @ReportItem(name = "two_sabisuKaisu4", length = 11, order = 196)
    public RString two_sabisuKaisu4;
    @ReportItem(name = "two_sabisuName18", order = 197)
    public RString two_sabisuName18;
    @ReportItem(name = "two_sabisuKaisu18", length = 11, order = 198)
    public RString two_sabisuKaisu18;
    @ReportItem(name = "two_sabisuName5", order = 199)
    public RString two_sabisuName5;
    @ReportItem(name = "two_sabisuKaisu5", length = 11, order = 200)
    public RString two_sabisuKaisu5;
    @ReportItem(name = "two_sabisuName19", order = 201)
    public RString two_sabisuName19;
    @ReportItem(name = "two_sabisuKaisu19", length = 11, order = 202)
    public RString two_sabisuKaisu19;
    @ReportItem(name = "two_sabisuName6", order = 203)
    public RString two_sabisuName6;
    @ReportItem(name = "two_sabisuKaisu6", length = 11, order = 204)
    public RString two_sabisuKaisu6;
    @ReportItem(name = "two_sabisuName20", order = 205)
    public RString two_sabisuName20;
    @ReportItem(name = "two_sabisuKaisu20", length = 11, order = 206)
    public RString two_sabisuKaisu20;
    @ReportItem(name = "two_sabisuName7", order = 207)
    public RString two_sabisuName7;
    @ReportItem(name = "two_sabisuKaisu7", length = 11, order = 208)
    public RString two_sabisuKaisu7;
    @ReportItem(name = "two_sabisuName21", order = 209)
    public RString two_sabisuName21;
    @ReportItem(name = "two_sabisuKaisu21", length = 11, order = 210)
    public RString two_sabisuKaisu21;
    @ReportItem(name = "two_sabisuName8", order = 211)
    public RString two_sabisuName8;
    @ReportItem(name = "two_sabisuKaisu8", length = 11, order = 212)
    public RString two_sabisuKaisu8;
    @ReportItem(name = "two_listTokubetsunaIryo1_1", length = 2, order = 213)
    public RString two_listTokubetsunaIryo1_1;
    @ReportItem(name = "two_listTokubetsunaIryo1_2", length = 1, order = 214)
    public RString two_listTokubetsunaIryo1_2;
    @ReportItem(name = "two_listTokubetsunaIryo1_3", length = 1, order = 215)
    public RString two_listTokubetsunaIryo1_3;
    @ReportItem(name = "two_listTokubetsunaIryo1_4", length = 1, order = 216)
    public RString two_listTokubetsunaIryo1_4;
    @ReportItem(name = "two_listTokubetsunaIryo2_1", length = 2, order = 217)
    public RString two_listTokubetsunaIryo2_1;
    @ReportItem(name = "two_listTokubetsunaIryo2_2", length = 1, order = 218)
    public RString two_listTokubetsunaIryo2_2;
    @ReportItem(name = "two_listTokubetsunaIryo2_3", length = 1, order = 219)
    public RString two_listTokubetsunaIryo2_3;
    @ReportItem(name = "two_listTokubetsunaIryo2_4", length = 1, order = 220)
    public RString two_listTokubetsunaIryo2_4;
    @ReportItem(name = "two_sabisuName9", order = 221)
    public RString two_sabisuName9;
    @ReportItem(name = "two_sabisuKaisu9", length = 11, order = 222)
    public RString two_sabisuKaisu9;
    @ReportItem(name = "two_sabisuName10", order = 223)
    public RString two_sabisuName10;
    @ReportItem(name = "two_sabisuKaisu10", length = 11, order = 224)
    public RString two_sabisuKaisu10;
    @ReportItem(name = "two_sabisuName11", order = 225)
    public RString two_sabisuName11;
    @ReportItem(name = "two_sabisuKaisu11", length = 11, order = 226)
    public RString two_sabisuKaisu11;
    @ReportItem(name = "two_sabisuName12", order = 227)
    public RString two_sabisuName12;
    @ReportItem(name = "two_sabisuKaisu12", length = 11, order = 228)
    public RString two_sabisuKaisu12;
    @ReportItem(name = "two_imgShisetsuName", order = 229)
    public RString two_imgShisetsuName;
    @ReportItem(name = "two_shisetsuNameTxit", order = 230)
    public RString two_shisetsuNameTxit;
    @ReportItem(name = "two_sabisuName13", order = 231)
    public RString two_sabisuName13;
    @ReportItem(name = "two_sabisuKaisu13", length = 11, order = 232)
    public RString two_sabisuKaisu13;
    @ReportItem(name = "two_imgShisetsuAddress", order = 233)
    public RString two_imgShisetsuAddress;
    @ReportItem(name = "two_shisetsuAddressTxit", order = 234)
    public RString two_shisetsuAddressTxit;
    @ReportItem(name = "two_sabisuName14", order = 235)
    public RString two_sabisuName14;
    @ReportItem(name = "two_sabisuKaisu14", length = 11, order = 236)
    public RString two_sabisuKaisu14;
    @ReportItem(name = "two_shisetsuTelTxit", order = 237)
    public RString two_shisetsuTelTxit;
    @ReportItem(name = "two_imgShisetsuTel", order = 238)
    public RString two_imgShisetsuTel;

    //DBE517041_GaikyotokkiTextA3
    @ReportItem(name = "three_gaikyotokkiImg", order = 239)
    public RString three_gaikyotokkiImg;
    @ReportItem(name = "three_gaikyotokkiText", order = 240)
    public RString three_gaikyotokkiText;

    //DBE517031_TokkiText1A3
    @ReportItem(name = "four_tokkiImg1", order = 301)
    public RString four_tokkiImg1;
    @ReportItem(name = "four_listChosa_1", length = 4, order = 302)
    public RString four_listChosa_1;
    @ReportItem(name = "four_tokkiImg2", order = 303)
    public RString four_tokkiImg2;
    @ReportItem(name = "four_tokkiImg3", order = 304)
    public RString four_tokkiImg3;
    @ReportItem(name = "four_tokkiImg4", order = 305)
    public RString four_tokkiImg4;
    @ReportItem(name = "four_tokkiImg5", order = 306)
    public RString four_tokkiImg5;
    @ReportItem(name = "four_tokkiImg6", order = 307)
    public RString four_tokkiImg6;
    @ReportItem(name = "four_tokkiImg7", order = 308)
    public RString four_tokkiImg7;
    @ReportItem(name = "four_tokkiImg8", order = 309)
    public RString four_tokkiImg8;
    @ReportItem(name = "four_tokkiImg9", order = 310)
    public RString four_tokkiImg9;
    @ReportItem(name = "four_tokkiImg10", order = 311)
    public RString four_tokkiImg10;
    @ReportItem(name = "four_tokkiImg11", order = 312)
    public RString four_tokkiImg11;
    @ReportItem(name = "four_tokkiImg12", order = 313)
    public RString four_tokkiImg12;
    @ReportItem(name = "four_tokkiImg13", order = 314)
    public RString four_tokkiImg13;
    @ReportItem(name = "four_tokkiImg14", order = 315)
    public RString four_tokkiImg14;
    @ReportItem(name = "four_tokkiImg15", order = 316)
    public RString four_tokkiImg15;
    @ReportItem(name = "four_tokkiText1", order = 317)
    public RString four_tokkiText1;
    @ReportItem(name = "four_listChosa1_1", length = 4, order = 318)
    public RString four_listChosa1_1;
    @ReportItem(name = "four_tokkiText2", order = 319)
    public RString four_tokkiText2;
    @ReportItem(name = "four_tokkiText3", order = 320)
    public RString four_tokkiText3;
    @ReportItem(name = "four_tokkiText4", order = 321)
    public RString four_tokkiText4;
    @ReportItem(name = "four_tokkiText5", order = 322)
    public RString four_tokkiText5;
    @ReportItem(name = "four_tokkiText6", order = 323)
    public RString four_tokkiText6;
    @ReportItem(name = "four_tokkiText7", order = 324)
    public RString four_tokkiText7;
    @ReportItem(name = "four_tokkiText8", order = 325)
    public RString four_tokkiText8;
    @ReportItem(name = "four_tokkiText9", order = 326)
    public RString four_tokkiText9;
    @ReportItem(name = "four_tokkiText10", order = 327)
    public RString four_tokkiText10;
    @ReportItem(name = "four_tokkiText11", order = 328)
    public RString four_tokkiText11;
    @ReportItem(name = "four_tokkiText12", order = 329)
    public RString four_tokkiText12;
    @ReportItem(name = "four_tokkiText13", order = 330)
    public RString four_tokkiText13;
    @ReportItem(name = "four_tokkiText14", order = 331)
    public RString four_tokkiText14;
    @ReportItem(name = "four_tokkiText15", order = 332)
    public RString four_tokkiText15;
    @ReportItem(name = "four_tokkiImg", order = 333)
    public RString four_tokkiImg;
    @ReportItem(name = "four_tokkiText", order = 334)
    public RString four_tokkiText;

    //DBE517005_ShujiiikenshoA3
    @ReportItem(name = "five_sakuseiGengo", length = 2, order = 401)
    public RString five_sakuseiGengo;
    @ReportItem(name = "five_sakuseiYY", length = 2, order = 402)
    public RString five_sakuseiYY;
    @ReportItem(name = "five_sakuseiMM", length = 2, order = 403)
    public RString five_sakuseiMM;
    @ReportItem(name = "five_sakuseiDD", length = 2, order = 404)
    public RString five_sakuseiDD;
    @ReportItem(name = "five_chosaGengo", length = 2, order = 405)
    public RString five_chosaGengo;
    @ReportItem(name = "five_chosaYY", length = 2, order = 406)
    public RString five_chosaYY;
    @ReportItem(name = "five_chosaMM", length = 2, order = 407)
    public RString five_chosaMM;
    @ReportItem(name = "five_chosaDD", length = 2, order = 408)
    public RString five_chosaDD;
    @ReportItem(name = "five_hokenshaNo", length = 6, order = 409)
    public RString five_hokenshaNo;
    @ReportItem(name = "five_hihokenshaNo", length = 10, order = 410)
    public RString five_hihokenshaNo;
    @ReportItem(name = "five_hihokenshaName", length = 30, order = 411)
    public RString five_hihokenshaName;
    @ReportItem(name = "five_shinseiGengo", length = 2, order = 412)
    public RString five_shinseiGengo;
    @ReportItem(name = "five_shinseiYY", length = 2, order = 413)
    public RString five_shinseiYY;
    @ReportItem(name = "five_shinseiMM", length = 2, order = 414)
    public RString five_shinseiMM;
    @ReportItem(name = "five_shinseiDD", length = 2, order = 415)
    public RString five_shinseiDD;
    @ReportItem(name = "five_shinsaGengo", length = 2, order = 416)
    public RString five_shinsaGengo;
    @ReportItem(name = "five_shinsaYY", length = 2, order = 417)
    public RString five_shinsaYY;
    @ReportItem(name = "five_shinsaMM", length = 2, order = 418)
    public RString five_shinsaMM;
    @ReportItem(name = "five_shinsaDD", length = 2, order = 419)
    public RString five_shinsaDD;
    @ReportItem(name = "five_imgIkensho1", order = 420)
    public RString five_imgIkensho1;
    @ReportItem(name = "five_imgIkensho2", order = 421)
    public RString five_imgIkensho2;

    //DBE517034_TokkiText2A3
    @ReportItem(name = "six_listChosa_1", length = 4, order = 501)
    public RString six_listChosa_1;
    @ReportItem(name = "six_tokkiImg3", order = 502)
    public RString six_tokkiImg3;
    @ReportItem(name = "six_listChosa1_1", length = 4, order = 503)
    public RString six_listChosa1_1;
    @ReportItem(name = "six_tokkiImg20", order = 504)
    public RString six_tokkiImg20;
    @ReportItem(name = "six_tokkiImg4", order = 505)
    public RString six_tokkiImg4;
    @ReportItem(name = "six_tokkiImg21", order = 506)
    public RString six_tokkiImg21;
    @ReportItem(name = "six_tokkiImg5", order = 507)
    public RString six_tokkiImg5;
    @ReportItem(name = "six_tokkiImg22", order = 508)
    public RString six_tokkiImg22;
    @ReportItem(name = "six_tokkiImg6", order = 509)
    public RString six_tokkiImg6;
    @ReportItem(name = "six_tokkiImg23", order = 510)
    public RString six_tokkiImg23;
    @ReportItem(name = "six_tokkiImg7", order = 511)
    public RString six_tokkiImg7;
    @ReportItem(name = "six_tokkiImg24", order = 512)
    public RString six_tokkiImg24;
    @ReportItem(name = "six_tokkiImg8", order = 513)
    public RString six_tokkiImg8;
    @ReportItem(name = "six_tokkiImg25", order = 514)
    public RString six_tokkiImg25;
    @ReportItem(name = "six_tokkiImg9", order = 515)
    public RString six_tokkiImg9;
    @ReportItem(name = "six_tokkiImg26", order = 516)
    public RString six_tokkiImg26;
    @ReportItem(name = "six_tokkiImg10", order = 517)
    public RString six_tokkiImg10;
    @ReportItem(name = "six_tokkiImg27", order = 518)
    public RString six_tokkiImg27;
    @ReportItem(name = "six_tokkiImg11", order = 519)
    public RString six_tokkiImg11;
    @ReportItem(name = "six_tokkiImg28", order = 520)
    public RString six_tokkiImg28;
    @ReportItem(name = "six_tokkiImg12", order = 521)
    public RString six_tokkiImg12;
    @ReportItem(name = "six_tokkiImg29", order = 522)
    public RString six_tokkiImg29;
    @ReportItem(name = "six_tokkiImg13", order = 523)
    public RString six_tokkiImg13;
    @ReportItem(name = "six_tokkiImg30", order = 524)
    public RString six_tokkiImg30;
    @ReportItem(name = "six_tokkiImg14", order = 525)
    public RString six_tokkiImg14;
    @ReportItem(name = "six_tokkiImg31", order = 526)
    public RString six_tokkiImg31;
    @ReportItem(name = "six_tokkiImg15", order = 527)
    public RString six_tokkiImg15;
    @ReportItem(name = "six_tokkiImg32", order = 528)
    public RString six_tokkiImg32;
    @ReportItem(name = "six_tokkiImg16", order = 529)
    public RString six_tokkiImg16;
    @ReportItem(name = "six_tokkiImg33", order = 530)
    public RString six_tokkiImg33;
    @ReportItem(name = "six_tokkiImg17", order = 531)
    public RString six_tokkiImg17;
    @ReportItem(name = "six_tokkiImg34", order = 532)
    public RString six_tokkiImg34;
    @ReportItem(name = "six_tokkiImg18", order = 533)
    public RString six_tokkiImg18;
    @ReportItem(name = "six_tokkiImg35", order = 534)
    public RString six_tokkiImg35;
    @ReportItem(name = "six_tokkiImg19", order = 535)
    public RString six_tokkiImg19;
    @ReportItem(name = "six_tokkiImg36", order = 536)
    public RString six_tokkiImg36;
    @ReportItem(name = "six_tokkiText3", order = 537)
    public RString six_tokkiText3;
    @ReportItem(name = "six_listChosa2_1", length = 4, order = 538)
    public RString six_listChosa2_1;
    @ReportItem(name = "six_listChosa3_1", length = 4, order = 539)
    public RString six_listChosa3_1;
    @ReportItem(name = "six_tokkiText20", order = 540)
    public RString six_tokkiText20;
    @ReportItem(name = "six_tokkiText4", order = 541)
    public RString six_tokkiText4;
    @ReportItem(name = "six_tokkiText21", order = 542)
    public RString six_tokkiText21;
    @ReportItem(name = "six_tokkiText5", order = 543)
    public RString six_tokkiText5;
    @ReportItem(name = "six_tokkiText22", order = 544)
    public RString six_tokkiText22;
    @ReportItem(name = "six_tokkiText6", order = 545)
    public RString six_tokkiText6;
    @ReportItem(name = "six_tokkiText23", order = 546)
    public RString six_tokkiText23;
    @ReportItem(name = "six_tokkiText7", order = 547)
    public RString six_tokkiText7;
    @ReportItem(name = "six_tokkiText24", order = 548)
    public RString six_tokkiText24;
    @ReportItem(name = "six_tokkiText8", order = 549)
    public RString six_tokkiText8;
    @ReportItem(name = "six_tokkiText25", order = 550)
    public RString six_tokkiText25;
    @ReportItem(name = "six_tokkiText9", order = 551)
    public RString six_tokkiText9;
    @ReportItem(name = "six_tokkiText26", order = 552)
    public RString six_tokkiText26;
    @ReportItem(name = "six_tokkiText10", order = 553)
    public RString six_tokkiText10;
    @ReportItem(name = "six_tokkiText27", order = 554)
    public RString six_tokkiText27;
    @ReportItem(name = "six_tokkiText11", order = 555)
    public RString six_tokkiText11;
    @ReportItem(name = "six_tokkiText28", order = 556)
    public RString six_tokkiText28;
    @ReportItem(name = "six_tokkiText12", order = 557)
    public RString six_tokkiText12;
    @ReportItem(name = "six_tokkiText29", order = 558)
    public RString six_tokkiText29;
    @ReportItem(name = "six_tokkiText13", order = 559)
    public RString six_tokkiText13;
    @ReportItem(name = "six_tokkiText30", order = 560)
    public RString six_tokkiText30;
    @ReportItem(name = "six_tokkiText14", order = 561)
    public RString six_tokkiText14;
    @ReportItem(name = "six_tokkiText31", order = 562)
    public RString six_tokkiText31;
    @ReportItem(name = "six_tokkiText15", order = 563)
    public RString six_tokkiText15;
    @ReportItem(name = "six_tokkiText32", order = 564)
    public RString six_tokkiText32;
    @ReportItem(name = "six_tokkiText16", order = 565)
    public RString six_tokkiText16;
    @ReportItem(name = "six_tokkiText33", order = 566)
    public RString six_tokkiText33;
    @ReportItem(name = "six_tokkiText17", order = 567)
    public RString six_tokkiText17;
    @ReportItem(name = "six_tokkiText34", order = 568)
    public RString six_tokkiText34;
    @ReportItem(name = "six_tokkiText18", order = 569)
    public RString six_tokkiText18;
    @ReportItem(name = "six_tokkiText35", order = 570)
    public RString six_tokkiText35;
    @ReportItem(name = "six_tokkiText19", order = 571)
    public RString six_tokkiText19;
    @ReportItem(name = "six_tokkiText36", order = 572)
    public RString six_tokkiText36;
    @ReportItem(name = "six_tokkiImg1", order = 573)
    public RString six_tokkiImg1;
    @ReportItem(name = "six_tokkiImg2", order = 574)
    public RString six_tokkiImg2;
    @ReportItem(name = "six_sakuseiGengo", length = 2, order = 575)
    public RString six_sakuseiGengo;
    @ReportItem(name = "six_sakuseiYY", length = 2, order = 576)
    public RString six_sakuseiYY;
    @ReportItem(name = "six_sakuseiMM", length = 2, order = 577)
    public RString six_sakuseiMM;
    @ReportItem(name = "six_sakuseiDD", length = 2, order = 578)
    public RString six_sakuseiDD;
    @ReportItem(name = "six_chosaGengo", length = 2, order = 579)
    public RString six_chosaGengo;
    @ReportItem(name = "six_chosaYY", length = 2, order = 580)
    public RString six_chosaYY;
    @ReportItem(name = "six_chosaMM", length = 2, order = 581)
    public RString six_chosaMM;
    @ReportItem(name = "six_chosaDD", length = 2, order = 582)
    public RString six_chosaDD;
    @ReportItem(name = "six_hokenshaNo", length = 6, order = 583)
    public RString six_hokenshaNo;
    @ReportItem(name = "six_hihokenshaNo", length = 10, order = 584)
    public RString six_hihokenshaNo;
    @ReportItem(name = "six_hihokenshaName", length = 30, order = 585)
    public RString six_hihokenshaName;
    @ReportItem(name = "six_shinseiGengo", length = 2, order = 586)
    public RString six_shinseiGengo;
    @ReportItem(name = "six_shinseiYY", length = 2, order = 587)
    public RString six_shinseiYY;
    @ReportItem(name = "six_shinseiMM", length = 2, order = 588)
    public RString six_shinseiMM;
    @ReportItem(name = "six_shinseiDD", length = 2, order = 589)
    public RString six_shinseiDD;
    @ReportItem(name = "six_shinsaGengo", length = 2, order = 590)
    public RString six_shinsaGengo;
    @ReportItem(name = "six_shinsaYY", length = 2, order = 591)
    public RString six_shinsaYY;
    @ReportItem(name = "six_shinsaMM", length = 2, order = 592)
    public RString six_shinsaMM;
    @ReportItem(name = "six_shinsaDD", length = 2, order = 593)
    public RString six_shinsaDD;
    @ReportItem(name = "six_tokkiText1", order = 594)
    public RString six_tokkiText1;
    @ReportItem(name = "six_tokkiText2", order = 595)
    public RString six_tokkiText2;

    //DBE517006_SonotashiryoA3
    @ReportItem(name = "seven_sakuseiGengo", length = 2, order = 601)
    public RString seven_sakuseiGengo;
    @ReportItem(name = "seven_sakuseiYY", length = 2, order = 602)
    public RString seven_sakuseiYY;
    @ReportItem(name = "seven_sakuseiMM", length = 2, order = 603)
    public RString seven_sakuseiMM;
    @ReportItem(name = "seven_sakuseiDD", length = 2, order = 604)
    public RString seven_sakuseiDD;
    @ReportItem(name = "seven_chosaGengo", length = 2, order = 605)
    public RString seven_chosaGengo;
    @ReportItem(name = "seven_chosaYY", length = 2, order = 606)
    public RString seven_chosaYY;
    @ReportItem(name = "seven_chosaMM", length = 2, order = 607)
    public RString seven_chosaMM;
    @ReportItem(name = "seven_chosaDD", length = 2, order = 608)
    public RString seven_chosaDD;
    @ReportItem(name = "seven_hokenshaNo", length = 6, order = 609)
    public RString seven_hokenshaNo;
    @ReportItem(name = "seven_hihokenshaNo", length = 10, order = 610)
    public RString seven_hihokenshaNo;
    @ReportItem(name = "seven_hihokenshaName", length = 30, order = 611)
    public RString seven_hihokenshaName;
    @ReportItem(name = "seven_shinseiGengo", length = 2, order = 612)
    public RString seven_shinseiGengo;
    @ReportItem(name = "seven_shinseiYY", length = 2, order = 613)
    public RString seven_shinseiYY;
    @ReportItem(name = "seven_shinseiMM", length = 2, order = 614)
    public RString seven_shinseiMM;
    @ReportItem(name = "seven_shinseiDD", length = 2, order = 615)
    public RString seven_shinseiDD;
    @ReportItem(name = "seven_shinsaGengo", length = 2, order = 616)
    public RString seven_shinsaGengo;
    @ReportItem(name = "seven_shinsaYY", length = 2, order = 617)
    public RString seven_shinsaYY;
    @ReportItem(name = "seven_shinsaMM", length = 2, order = 618)
    public RString seven_shinsaMM;
    @ReportItem(name = "seven_shinsaDD", length = 2, order = 619)
    public RString seven_shinsaDD;
    @ReportItem(name = "seven_imgSonotashiryo1", order = 620)
    public RString seven_imgSonotashiryo1;
    @ReportItem(name = "seven_imgSonotashiryo2", order = 621)
    public RString seven_imgSonotashiryo2;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportItem(name = "layout", order = 999)
    public Layouts layout;

    /**
     * レイアウトブレイク用キーの一覧です。
     */
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        six_tokkiText1,
        six_tokkiImg1,
    }
}
