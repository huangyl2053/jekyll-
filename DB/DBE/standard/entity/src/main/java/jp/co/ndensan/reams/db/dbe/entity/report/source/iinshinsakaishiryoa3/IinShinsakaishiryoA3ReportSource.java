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
    @ReportItem(name = "shinsakaiNo", length = 4, order = 1)
    public RString shinsakaiNo;
    @ReportItem(name = "ShinsainName1", length = 20, order = 2)
    public RString ShinsainName1;
    @ReportItem(name = "ShinsainName2", length = 20, order = 3)
    public RString ShinsainName2;
    @ReportItem(name = "shinsakaiKaisaiYMD", length = 21, order = 4)
    public RString shinsakaiKaisaiYMD;
    @ReportItem(name = "ShinsainName3", length = 20, order = 5)
    public RString ShinsainName3;
    @ReportItem(name = "ShinsainName4", length = 20, order = 6)
    public RString ShinsainName4;
    @ReportItem(name = "ShinsainName5", length = 20, order = 7)
    public RString ShinsainName5;
    @ReportItem(name = "gogitaiNo", length = 2, order = 8)
    public RString gogitaiNo;
    @ReportItem(name = "ShinsainName6", length = 20, order = 9)
    public RString ShinsainName6;
    @ReportItem(name = "shinsaTaishoshaCount", length = 2, order = 10)
    public RString shinsaTaishoshaCount;
    @ReportItem(name = "ShinsainName7", length = 20, order = 11)
    public RString ShinsainName7;
    @ReportItem(name = "ShinsainName8", length = 20, order = 12)
    public RString ShinsainName8;
    @ReportItem(name = "listShinsei1_1", length = 2, order = 13)
    public RString listShinsei1_1;
    @ReportItem(name = "listShinsei1_2", length = 6, order = 14)
    public RString listShinsei1_2;
    @ReportItem(name = "listShinsei1_3", length = 10, order = 15)
    public RString listShinsei1_3;
    @ReportItem(name = "listShinsei1_4", length = 30, order = 16)
    public RString listShinsei1_4;
    @ReportItem(name = "listShinsei1_5", length = 1, order = 17)
    public RString listShinsei1_5;
    @ReportItem(name = "listShinsei1_6", length = 3, order = 18)
    public RString listShinsei1_6;
    @ReportItem(name = "listShinsei1_7", length = 3, order = 19)
    public RString listShinsei1_7;
    @ReportItem(name = "listShinsei1_8", length = 4, order = 20)
    public RString listShinsei1_8;
    @ReportItem(name = "listShinsei1_9", length = 7, order = 21)
    public RString listShinsei1_9;
    @ReportItem(name = "listShinsei1_10", length = 3, order = 22)
    public RString listShinsei1_10;
    @ReportItem(name = "listShinsei1_11", length = 4, order = 23)
    public RString listShinsei1_11;
    @ReportItem(name = "listShinsei2_1", length = 2, order = 24)
    public RString listShinsei2_1;
    @ReportItem(name = "listShinsei2_2", length = 6, order = 25)
    public RString listShinsei2_2;
    @ReportItem(name = "listShinsei2_3", length = 10, order = 26)
    public RString listShinsei2_3;
    @ReportItem(name = "listShinsei2_4", length = 30, order = 27)
    public RString listShinsei2_4;
    @ReportItem(name = "listShinsei2_5", length = 1, order = 28)
    public RString listShinsei2_5;
    @ReportItem(name = "listShinsei2_6", length = 3, order = 29)
    public RString listShinsei2_6;
    @ReportItem(name = "listShinsei2_7", length = 3, order = 30)
    public RString listShinsei2_7;
    @ReportItem(name = "listShinsei2_8", length = 4, order = 31)
    public RString listShinsei2_8;
    @ReportItem(name = "listShinsei2_9", length = 7, order = 32)
    public RString listShinsei2_9;
    @ReportItem(name = "listShinsei2_10", length = 3, order = 33)
    public RString listShinsei2_10;
    @ReportItem(name = "listShinsei2_11", length = 4, order = 34)
    public RString listShinsei2_11;
    @ReportItem(name = "listZenkaiｙukokikan1_1", length = 19, order = 35)
    public RString listZenkaiｙukokikan1_1;
    @ReportItem(name = "listYukokikan1_1", length = 19, order = 36)
    public RString listYukokikan1_1;
    @ReportItem(name = "listZenkaiｙukokikan2_1", length = 19, order = 37)
    public RString listZenkaiｙukokikan2_1;
    @ReportItem(name = "listYukokikan2_1", length = 19, order = 38)
    public RString listYukokikan2_1;

    //DBE517085
    @ReportItem(name = "zenZenkaiHanteikekka", length = 8, order = 102)
    public RString zenZenkaiHanteikekka;
    @ReportItem(name = "zenzenkaiYukokikan", length = 4, order = 103)
    public RString zenzenkaiYukokikan;
    @ReportItem(name = "zZenkaiNijiKaishiYMD", length = 9, order = 104)
    public RString zZenkaiNijiKaishiYMD;
    @ReportItem(name = "zZenkaiNijishuryoYMD", length = 9, order = 105)
    public RString zZenkaiNijishuryoYMD;
    @ReportItem(name = "kanriNo", length = 20, order = 106)
    public RString kanriNo;
    @ReportItem(name = "shinseiYMD", length = 9, order = 107)
    public RString shinseiYMD;
    @ReportItem(name = "sakuseiYMD", length = 9, order = 108)
    public RString sakuseiYMD;
    @ReportItem(name = "shinseiCount", length = 2, order = 109)
    public RString shinseiCount;
    @ReportItem(name = "shinseiCountGokei", length = 2, order = 110)
    public RString shinseiCountGokei;
    @ReportItem(name = "hihokenshaKubun", length = 7, order = 111)
    public RString hihokenshaKubun;
    @ReportItem(name = "age", length = 5, order = 112)
    public RString age;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 8, order = 113)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenkaiYukokikan", length = 4, order = 114)
    public RString zenkaiYukokikan;
    @ReportItem(name = "zenkaiNijiKaishiYMD", length = 9, order = 115)
    public RString zenkaiNijiKaishiYMD;
    @ReportItem(name = "zenkaiNijiShuryoYMD", length = 9, order = 116)
    public RString zenkaiNijiShuryoYMD;
    @ReportItem(name = "zenkaiNijihanteiDate", length = 9, order = 117)
    public RString zenkaiNijihanteiDate;
    @ReportItem(name = "zenkaiJotaizo", length = 10, order = 118)
    public RString zenkaiJotaizo;
    @ReportItem(name = "chosaYMD", length = 9, order = 119)
    public RString chosaYMD;
    @ReportItem(name = "shinsaYMD", length = 9, order = 120)
    public RString shinsaYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 121)
    public RString seibetsu;
    @ReportItem(name = "shinseiKubun", length = 13, order = 122)
    public RString shinseiKubun;
    @ReportItem(name = "ichijiHanteiKekka", length = 12, order = 123)
    public RString ichijiHanteiKekka;
    @ReportItem(name = "kijunGokeiTime", length = 40, order = 124)
    public RString kijunGokeiTime;
    @ReportItem(name = "listFuseigo1_1", length = 1, order = 125)
    public RString listFuseigo1_1;
    @ReportItem(name = "listFuseigo1_2", length = 1, order = 126)
    public RString listFuseigo1_2;
    @ReportItem(name = "listIchigun_1", length = 22, order = 127)
    public RString listIchigun_1;
    @ReportItem(name = "listIchigun_2", length = 1, order = 128)
    public RString listIchigun_2;
    @ReportItem(name = "listIchigun_3", length = 1, order = 129)
    public RString listIchigun_3;
    @ReportItem(name = "listIchigun_4", length = 22, order = 130)
    public RString listIchigun_4;
    @ReportItem(name = "zenkaiKijunGokeiTime", length = 40, order = 131)
    public RString zenkaiKijunGokeiTime;
    @ReportItem(name = "gurafuKijunTime", order = 132)
    public RString gurafuKijunTime;
    @ReportItem(name = "listKijunTime_1", length = 7, order = 133)
    public RString listKijunTime_1;
    @ReportItem(name = "listKijunTime_2", length = 7, order = 134)
    public RString listKijunTime_2;
    @ReportItem(name = "listKijunTime_3", length = 7, order = 135)
    public RString listKijunTime_3;
    @ReportItem(name = "listKijunTime_4", length = 7, order = 136)
    public RString listKijunTime_4;
    @ReportItem(name = "listKijunTime_5", length = 7, order = 137)
    public RString listKijunTime_5;
    @ReportItem(name = "listKijunTime_6", length = 7, order = 138)
    public RString listKijunTime_6;
    @ReportItem(name = "listKijunTime_7", length = 7, order = 139)
    public RString listKijunTime_7;
    @ReportItem(name = "listKijunTime_8", length = 7, order = 140)
    public RString listKijunTime_8;
    @ReportItem(name = "listKijunTime_9", length = 7, order = 141)
    public RString listKijunTime_9;
    @ReportItem(name = "listFuseigo2_1", length = 1, order = 142)
    public RString listFuseigo2_1;
    @ReportItem(name = "listFuseigo2_2", length = 1, order = 143)
    public RString listFuseigo2_2;
    @ReportItem(name = "listNigun_1", length = 22, order = 144)
    public RString listNigun_1;
    @ReportItem(name = "listNigun_2", length = 1, order = 145)
    public RString listNigun_2;
    @ReportItem(name = "listNigun_3", length = 1, order = 146)
    public RString listNigun_3;
    @ReportItem(name = "listNigun_4", length = 22, order = 147)
    public RString listNigun_4;
    @ReportItem(name = "chosaJisshiDate1", length = 9, order = 148)
    public RString chosaJisshiDate1;
    @ReportItem(name = "chosaJisshiBasho", length = 30, order = 149)
    public RString chosaJisshiBasho;
    @ReportItem(name = "tokuteishippeiName", length = 40, order = 150)
    public RString tokuteishippeiName;
    @ReportItem(name = "keikokuNo", length = 120, order = 151)
    public RString keikokuNo;
    @ReportItem(name = "listFuseigo3_1", length = 1, order = 152)
    public RString listFuseigo3_1;
    @ReportItem(name = "listFuseigo3_2", length = 1, order = 153)
    public RString listFuseigo3_2;
    @ReportItem(name = "listSangun_1", length = 22, order = 154)
    public RString listSangun_1;
    @ReportItem(name = "listSangun_2", length = 1, order = 155)
    public RString listSangun_2;
    @ReportItem(name = "listSangun_3", length = 1, order = 156)
    public RString listSangun_3;
    @ReportItem(name = "listSangun_4", length = 22, order = 157)
    public RString listSangun_4;
    @ReportItem(name = "listChukanhyoka_1", length = 5, order = 158)
    public RString listChukanhyoka_1;
    @ReportItem(name = "listChukanhyoka_2", length = 5, order = 159)
    public RString listChukanhyoka_2;
    @ReportItem(name = "listChukanhyoka_3", length = 5, order = 160)
    public RString listChukanhyoka_3;
    @ReportItem(name = "listChukanhyoka_4", length = 5, order = 161)
    public RString listChukanhyoka_4;
    @ReportItem(name = "listChukanhyoka_5", length = 5, order = 162)
    public RString listChukanhyoka_5;
    @ReportItem(name = "ｌistSeikatsujiritsu_1", length = 2, order = 163)
    public RString ｌistSeikatsujiritsu_1;
    @ReportItem(name = "ｌistSeikatsujiritsu_2", length = 1, order = 164)
    public RString ｌistSeikatsujiritsu_2;
    @ReportItem(name = "listFuseigo4_1", length = 1, order = 165)
    public RString listFuseigo4_1;
    @ReportItem(name = "listFuseigo4_2", length = 1, order = 166)
    public RString listFuseigo4_2;
    @ReportItem(name = "listYongun_1", length = 22, order = 167)
    public RString listYongun_1;
    @ReportItem(name = "listYongun_2", length = 1, order = 168)
    public RString listYongun_2;
    @ReportItem(name = "listYongun_3", length = 1, order = 169)
    public RString listYongun_3;
    @ReportItem(name = "listYongun_4", length = 22, order = 170)
    public RString listYongun_4;
    @ReportItem(name = "chosaNinchishoJiritsudo", length = 2, order = 171)
    public RString chosaNinchishoJiritsudo;
    @ReportItem(name = "ikenNinchiJiritsudo", length = 2, order = 172)
    public RString ikenNinchiJiritsudo;
    @ReportItem(name = "manzensei", length = 6, order = 173)
    public RString manzensei;
    @ReportItem(name = "jotainoanteisei", length = 4, order = 174)
    public RString jotainoanteisei;
    @ReportItem(name = "kyufukubun", length = 4, order = 175)
    public RString kyufukubun;
    @ReportItem(name = "sabisuKubun", length = 15, order = 176)
    public RString sabisuKubun;
    @ReportItem(name = "sabisuName1", order = 177)
    public RString sabisuName1;
    @ReportItem(name = "sabisuKaisu1", length = 11, order = 178)
    public RString sabisuKaisu1;
    @ReportItem(name = "sabisuName15", order = 179)
    public RString sabisuName15;
    @ReportItem(name = "sabisuKaisu15", length = 11, order = 180)
    public RString sabisuKaisu15;
    @ReportItem(name = "sabisuName2", order = 181)
    public RString sabisuName2;
    @ReportItem(name = "sabisuKaisu2", length = 11, order = 182)
    public RString sabisuKaisu2;
    @ReportItem(name = "sabisuName16", order = 183)
    public RString sabisuName16;
    @ReportItem(name = "sabisuKaisu16", length = 11, order = 184)
    public RString sabisuKaisu16;
    @ReportItem(name = "listFuseigo5_1", length = 1, order = 185)
    public RString listFuseigo5_1;
    @ReportItem(name = "listFuseigo5_2", length = 1, order = 186)
    public RString listFuseigo5_2;
    @ReportItem(name = "listGogun_1", length = 22, order = 187)
    public RString listGogun_1;
    @ReportItem(name = "listGogun_2", length = 1, order = 188)
    public RString listGogun_2;
    @ReportItem(name = "listGogun_3", length = 1, order = 189)
    public RString listGogun_3;
    @ReportItem(name = "listGogun_4", length = 22, order = 190)
    public RString listGogun_4;
    @ReportItem(name = "sabisuName3", order = 191)
    public RString sabisuName3;
    @ReportItem(name = "sabisuKaisu3", length = 11, order = 192)
    public RString sabisuKaisu3;
    @ReportItem(name = "sabisuName17", order = 193)
    public RString sabisuName17;
    @ReportItem(name = "sabisuKaisu17", length = 11, order = 194)
    public RString sabisuKaisu17;
    @ReportItem(name = "sabisuName4", order = 195)
    public RString sabisuName4;
    @ReportItem(name = "sabisuKaisu4", length = 11, order = 196)
    public RString sabisuKaisu4;
    @ReportItem(name = "sabisuName18", order = 197)
    public RString sabisuName18;
    @ReportItem(name = "sabisuKaisu18", length = 11, order = 198)
    public RString sabisuKaisu18;
    @ReportItem(name = "sabisuName5", order = 199)
    public RString sabisuName5;
    @ReportItem(name = "sabisuKaisu5", length = 11, order = 200)
    public RString sabisuKaisu5;
    @ReportItem(name = "sabisuName19", order = 201)
    public RString sabisuName19;
    @ReportItem(name = "sabisuKaisu19", length = 11, order = 202)
    public RString sabisuKaisu19;
    @ReportItem(name = "sabisuName6", order = 203)
    public RString sabisuName6;
    @ReportItem(name = "sabisuKaisu6", length = 11, order = 204)
    public RString sabisuKaisu6;
    @ReportItem(name = "sabisuName20", order = 205)
    public RString sabisuName20;
    @ReportItem(name = "sabisuKaisu20", length = 11, order = 206)
    public RString sabisuKaisu20;
    @ReportItem(name = "sabisuName7", order = 207)
    public RString sabisuName7;
    @ReportItem(name = "sabisuKaisu7", length = 11, order = 208)
    public RString sabisuKaisu7;
    @ReportItem(name = "sabisuName21", order = 209)
    public RString sabisuName21;
    @ReportItem(name = "sabisuKaisu21", length = 11, order = 210)
    public RString sabisuKaisu21;
    @ReportItem(name = "sabisuName8", order = 211)
    public RString sabisuName8;
    @ReportItem(name = "sabisuKaisu8", length = 11, order = 212)
    public RString sabisuKaisu8;
    @ReportItem(name = "listTokubetsunaIryo1_1", length = 2, order = 213)
    public RString listTokubetsunaIryo1_1;
    @ReportItem(name = "listTokubetsunaIryo1_2", length = 1, order = 214)
    public RString listTokubetsunaIryo1_2;
    @ReportItem(name = "listTokubetsunaIryo1_3", length = 1, order = 215)
    public RString listTokubetsunaIryo1_3;
    @ReportItem(name = "listTokubetsunaIryo1_4", length = 1, order = 216)
    public RString listTokubetsunaIryo1_4;
    @ReportItem(name = "listTokubetsunaIryo2_1", length = 2, order = 217)
    public RString listTokubetsunaIryo2_1;
    @ReportItem(name = "listTokubetsunaIryo2_2", length = 1, order = 218)
    public RString listTokubetsunaIryo2_2;
    @ReportItem(name = "listTokubetsunaIryo2_3", length = 1, order = 219)
    public RString listTokubetsunaIryo2_3;
    @ReportItem(name = "listTokubetsunaIryo2_4", length = 1, order = 220)
    public RString listTokubetsunaIryo2_4;
    @ReportItem(name = "sabisuName9", order = 221)
    public RString sabisuName9;
    @ReportItem(name = "sabisuKaisu9", length = 11, order = 222)
    public RString sabisuKaisu9;
    @ReportItem(name = "sabisuName10", order = 223)
    public RString sabisuName10;
    @ReportItem(name = "sabisuKaisu10", length = 11, order = 224)
    public RString sabisuKaisu10;
    @ReportItem(name = "sabisuName11", order = 225)
    public RString sabisuName11;
    @ReportItem(name = "sabisuKaisu11", length = 11, order = 226)
    public RString sabisuKaisu11;
    @ReportItem(name = "sabisuName12", order = 227)
    public RString sabisuName12;
    @ReportItem(name = "sabisuKaisu12", length = 11, order = 228)
    public RString sabisuKaisu12;
    @ReportItem(name = "imgShisetsuName", order = 229)
    public RString imgShisetsuName;
    @ReportItem(name = "shisetsuNameTxit", order = 230)
    public RString shisetsuNameTxit;
    @ReportItem(name = "sabisuName13", order = 231)
    public RString sabisuName13;
    @ReportItem(name = "sabisuKaisu13", length = 11, order = 232)
    public RString sabisuKaisu13;
    @ReportItem(name = "imgShisetsuAddress", order = 233)
    public RString imgShisetsuAddress;
    @ReportItem(name = "shisetsuAddressTxit", order = 234)
    public RString shisetsuAddressTxit;
    @ReportItem(name = "sabisuName14", order = 235)
    public RString sabisuName14;
    @ReportItem(name = "sabisuKaisu14", length = 11, order = 236)
    public RString sabisuKaisu14;
    @ReportItem(name = "shisetsuTelTxit", order = 237)
    public RString shisetsuTelTxit;
    @ReportItem(name = "imgShisetsuTel", order = 238)
    public RString imgShisetsuTel;

    //DBE517041_GaikyotokkiTextA3
    @ReportItem(name = "gaikyotokkiImg", order = 239)
    public RString gaikyotokkiImg;
    @ReportItem(name = "gaikyotokkiText", order = 240)
    public RString gaikyotokkiText;

    //DBE517031_TokkiText1A3
    @ReportItem(name = "tokkiImg1", order = 301)
    public RString tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 302)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 303)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 304)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 305)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 306)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 307)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 308)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 309)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 310)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 311)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 312)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 313)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 314)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 315)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 316)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 317)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 318)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 319)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 320)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 321)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 322)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 323)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 324)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 325)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 326)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 327)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 328)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 329)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 330)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 331)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 332)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 333)
    public RString tokkiImg;
    @ReportItem(name = "tokkiText", order = 334)
    public RString tokkiText;

    //DBE517005_ShujiiikenshoA3
    @ReportItem(name = "sakuseiGengo", length = 2, order = 401)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 402)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 403)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 404)
    public RString sakuseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 405)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 406)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 407)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 408)
    public RString chosaDD;
    @ReportItem(name = "hokenshaNo", length = 6, order = 409)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 410)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", length = 30, order = 411)
    public RString hihokenshaName;
    @ReportItem(name = "shinseiGengo", length = 2, order = 412)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 413)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 414)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 415)
    public RString shinseiDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 416)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 417)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 418)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 419)
    public RString shinsaDD;
    @ReportItem(name = "imgIkensho1", order = 420)
    public RString imgIkensho1;
    @ReportItem(name = "imgIkensho2", order = 421)
    public RString imgIkensho2;

    //DBE517034_TokkiText2A3
    @ReportItem(name = "tokkiImg20", order = 504)
    public RString tokkiImg20;
    @ReportItem(name = "tokkiImg21", order = 506)
    public RString tokkiImg21;
    @ReportItem(name = "tokkiImg22", order = 508)
    public RString tokkiImg22;
    @ReportItem(name = "tokkiImg23", order = 510)
    public RString tokkiImg23;
    @ReportItem(name = "tokkiImg24", order = 512)
    public RString tokkiImg24;
    @ReportItem(name = "tokkiImg25", order = 514)
    public RString tokkiImg25;
    @ReportItem(name = "tokkiImg26", order = 516)
    public RString tokkiImg26;
    @ReportItem(name = "tokkiImg27", order = 518)
    public RString tokkiImg27;
    @ReportItem(name = "tokkiImg28", order = 520)
    public RString tokkiImg28;
    @ReportItem(name = "tokkiImg29", order = 522)
    public RString tokkiImg29;
    @ReportItem(name = "tokkiImg30", order = 524)
    public RString tokkiImg30;
    @ReportItem(name = "tokkiImg31", order = 526)
    public RString tokkiImg31;
    @ReportItem(name = "tokkiImg32", order = 528)
    public RString tokkiImg32;
    @ReportItem(name = "tokkiImg16", order = 529)
    public RString tokkiImg16;
    @ReportItem(name = "tokkiImg33", order = 530)
    public RString tokkiImg33;
    @ReportItem(name = "tokkiImg17", order = 531)
    public RString tokkiImg17;
    @ReportItem(name = "tokkiImg34", order = 532)
    public RString tokkiImg34;
    @ReportItem(name = "tokkiImg18", order = 533)
    public RString tokkiImg18;
    @ReportItem(name = "tokkiImg35", order = 534)
    public RString tokkiImg35;
    @ReportItem(name = "tokkiImg19", order = 535)
    public RString tokkiImg19;
    @ReportItem(name = "tokkiImg36", order = 536)
    public RString tokkiImg36;
    @ReportItem(name = "listChosa2_1", length = 4, order = 538)
    public RString listChosa2_1;
    @ReportItem(name = "listChosa3_1", length = 4, order = 539)
    public RString listChosa3_1;
    @ReportItem(name = "tokkiText20", order = 540)
    public RString tokkiText20;
    @ReportItem(name = "tokkiText21", order = 542)
    public RString tokkiText21;
    @ReportItem(name = "tokkiText22", order = 544)
    public RString tokkiText22;
    @ReportItem(name = "tokkiText23", order = 546)
    public RString tokkiText23;
    @ReportItem(name = "tokkiText24", order = 548)
    public RString tokkiText24;
    @ReportItem(name = "tokkiText25", order = 550)
    public RString tokkiText25;
    @ReportItem(name = "tokkiText26", order = 552)
    public RString tokkiText26;
    @ReportItem(name = "tokkiText27", order = 554)
    public RString tokkiText27;
    @ReportItem(name = "tokkiText28", order = 556)
    public RString tokkiText28;
    @ReportItem(name = "tokkiText29", order = 558)
    public RString tokkiText29;
    @ReportItem(name = "tokkiText30", order = 560)
    public RString tokkiText30;
    @ReportItem(name = "tokkiText31", order = 562)
    public RString tokkiText31;
    @ReportItem(name = "tokkiText32", order = 564)
    public RString tokkiText32;
    @ReportItem(name = "tokkiText16", order = 565)
    public RString tokkiText16;
    @ReportItem(name = "tokkiText33", order = 566)
    public RString tokkiText33;
    @ReportItem(name = "tokkiText17", order = 567)
    public RString tokkiText17;
    @ReportItem(name = "tokkiText34", order = 568)
    public RString tokkiText34;
    @ReportItem(name = "tokkiText18", order = 569)
    public RString tokkiText18;
    @ReportItem(name = "tokkiText35", order = 570)
    public RString tokkiText35;
    @ReportItem(name = "tokkiText19", order = 571)
    public RString tokkiText19;
    @ReportItem(name = "tokkiText36", order = 572)
    public RString tokkiText36;

    //DBE517006_SonotashiryoA3
    @ReportItem(name = "imgSonotashiryo1", order = 620)
    public RString imgSonotashiryo1;
    @ReportItem(name = "imgSonotashiryo2", order = 621)
    public RString imgSonotashiryo2;

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

        tokkiText1,
        tokkiImg1,
    }
}
