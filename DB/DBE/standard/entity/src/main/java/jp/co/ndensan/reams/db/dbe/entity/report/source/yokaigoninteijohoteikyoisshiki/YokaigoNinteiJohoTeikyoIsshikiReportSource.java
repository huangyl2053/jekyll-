/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護認定情報提供一式のReportSourceクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class YokaigoNinteiJohoTeikyoIsshikiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaName", length = 30, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 3)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 4)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 5)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 6)
    public RString shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 7)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 8)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 9)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 10)
    public RString sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 11)
    public RString hihokenshaNo;
    @ReportItem(name = "chosaGengo", length = 2, order = 12)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 13)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 14)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 15)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 16)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 17)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 18)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 19)
    public RString shinsaDD;
    @ReportItem(name = "title", length = 30, order = 20)
    public RString title;
    @ReportItem(name = "age", length = 4, order = 21)
    public RString age;
    @ReportItem(name = "seibetsu", length = 1, order = 22)
    public RString seibetsu;
    @ReportItem(name = "yubimNo", length = 8, order = 23)
    public RString yubimNo;
    @ReportItem(name = "hihokenshaTelNo", length = 13, order = 24)
    public RString hihokenshaTelNo;
    @ReportItem(name = "listIchigun2_1", length = 2, order = 25)
    public RString listIchigun2_1;
    @ReportItem(name = "listIchigun1_1", length = 2, order = 26)
    public RString listIchigun1_1;
    @ReportItem(name = "hihokenshaJusho", length = 30, order = 27)
    public RString hihokenshaJusho;
    @ReportItem(name = "kazokuTelNo1", length = 13, order = 28)
    public RString kazokuTelNo1;
    @ReportItem(name = "kazokuYubimNo", length = 8, order = 29)
    public RString kazokuYubimNo;
    @ReportItem(name = "kazokuTelNo2", length = 13, order = 30)
    public RString kazokuTelNo2;
    @ReportItem(name = "kazokuJusho", length = 30, order = 31)
    public RString kazokuJusho;
    @ReportItem(name = "kazokuName", length = 15, order = 32)
    public RString kazokuName;
    @ReportItem(name = "listIchigun_1", length = 20, order = 33)
    public RString listIchigun_1;
    @ReportItem(name = "zokugara", length = 8, order = 34)
    public RString zokugara;
    @ReportItem(name = "shinseiKubun", length = 13, order = 35)
    public RString shinseiKubun;
    @ReportItem(name = "shinseikubunHorei", length = 13, order = 36)
    public RString shinseikubunHorei;
    @ReportItem(name = "shinsaYMD", length = 11, order = 37)
    public RString shinsaYMD;
    @ReportItem(name = "ichijiHanteiKekka", length = 9, order = 38)
    public RString ichijiHanteiKekka;
    @ReportItem(name = "nijiHanteiKekka", length = 4, order = 39)
    public RString nijiHanteiKekka;
    @ReportItem(name = "nijihanteiKaishiYMD", length = 11, order = 40)
    public RString nijihanteiKaishiYMD;
    @ReportItem(name = "ｙukokikan", length = 2, order = 41)
    public RString ｙukokikan;
    @ReportItem(name = "nijihanteishuryoYMD", length = 11, order = 42)
    public RString nijihanteishuryoYMD;
    @ReportItem(name = "jotaizo", length = 26, order = 43)
    public RString jotaizo;
    @ReportItem(name = "tokuteishippeiName", length = 40, order = 44)
    public RString tokuteishippeiName;
    @ReportItem(name = "shinsakaiIken", length = 70, order = 45)
    public RString shinsakaiIken;
    @ReportItem(name = "listNigun_1", length = 20, order = 46)
    public RString listNigun_1;
    @ReportItem(name = "zenkaiNijihanteiDate", length = 11, order = 47)
    public RString zenkaiNijihanteiDate;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 4, order = 48)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenHanteiKaishiYMD", length = 11, order = 49)
    public RString zenHanteiKaishiYMD;
    @ReportItem(name = "zenkaiYukokikan", length = 2, order = 50)
    public RString zenkaiYukokikan;
    @ReportItem(name = "zenHanteishuryoYMD", length = 11, order = 51)
    public RString zenHanteishuryoYMD;
    @ReportItem(name = "chosaJisshiYMD", length = 11, order = 52)
    public RString chosaJisshiYMD;
    @ReportItem(name = "chosaJisshiBashoTxit", order = 53)
    public RString chosaJisshiBashoTxit;
    @ReportItem(name = "imgChosaJisshiBasho", order = 54)
    public RString imgChosaJisshiBasho;
    @ReportItem(name = "chosaJisshiBasho", length = 6, order = 55)
    public RString chosaJisshiBasho;
    @ReportItem(name = "chosainName", length = 30, order = 56)
    public RString chosainName;
    @ReportItem(name = "chosaItakusakiName", length = 30, order = 57)
    public RString chosaItakusakiName;
    @ReportItem(name = "listSangun_1", length = 20, order = 58)
    public RString listSangun_1;
    @ReportItem(name = "listSabisujokyo_1", length = 10, order = 59)
    public RString listSabisujokyo_1;
    @ReportItem(name = "listYongun_1", length = 20, order = 60)
    public RString listYongun_1;
    @ReportItem(name = "listGogun_1", length = 20, order = 61)
    public RString listGogun_1;
    @ReportItem(name = "imgTokubetsukyufu", order = 62)
    public RString imgTokubetsukyufu;
    @ReportItem(name = "tokubetsukyufuTxit", order = 63)
    public RString tokubetsukyufuTxit;
    @ReportItem(name = "imgZaitakusabisu", order = 64)
    public RString imgZaitakusabisu;
    @ReportItem(name = "zaitakusabisuTxit", order = 65)
    public RString zaitakusabisuTxit;
    @ReportItem(name = "listNigun1_1", length = 20, order = 66)
    public RString listNigun1_1;
    @ReportItem(name = "shisetsuriyo", length = 25, order = 67)
    public RString shisetsuriyo;
    @ReportItem(name = "imgShisetsuName", order = 68)
    public RString imgShisetsuName;
    @ReportItem(name = "shisetsuNameTxit", order = 69)
    public RString shisetsuNameTxit;
    @ReportItem(name = "imgShisetsujusho", order = 70)
    public RString imgShisetsujusho;
    @ReportItem(name = "shisetsujushoTxit", order = 71)
    public RString shisetsujushoTxit;
    @ReportItem(name = "imgShisetsuTel", order = 72)
    public RString imgShisetsuTel;
    @ReportItem(name = "shisetsuTxitTel", order = 73)
    public RString shisetsuTxitTel;
    @ReportItem(name = "listChosaJiritsudo_1", length = 3, order = 74)
    public RString listChosaJiritsudo_1;
    @ReportItem(name = "listIkenJiritsudo_1", length = 3, order = 75)
    public RString listIkenJiritsudo_1;
    @ReportItem(name = "henkoJiyu", length = 20, order = 76)
    public RString henkoJiyu;
    @ReportItem(name = "listRokugun_1", length = 20, order = 77)
    public RString listRokugun_1;
    @ReportItem(name = "listRokugun1_1", length = 20, order = 78)
    public RString listRokugun1_1;
    @ReportItem(name = "listIryo_1", length = 20, order = 79)
    public RString listIryo_1;
    @ReportItem(name = "listJugun_1", length = 20, order = 80)
    public RString listJugun_1;
    @ReportItem(name = "listSabisujokyo1_1", length = 3, order = 81)
    public RString listSabisujokyo1_1;
    @ReportItem(name = "tokkiPageNo", length = 1, order = 82)
    public RString tokkiPageNo;
    @ReportItem(name = "tokkiPageMax", length = 1, order = 83)
    public RString tokkiPageMax;
    @ReportItem(name = "listChosa_1", length = 4, order = 84)
    public RString listChosa_1;
    @ReportItem(name = "listChosa_2", length = 15, order = 85)
    public RString listChosa_2;
    @ReportItem(name = "listChosa_3", length = 4, order = 86)
    public RString listChosa_3;
    @ReportItem(name = "listChosa_4", length = 15, order = 87)
    public RString listChosa_4;
    @ReportItem(name = "listChosa_5", length = 4, order = 88)
    public RString listChosa_5;
    @ReportItem(name = "listChosa_6", length = 15, order = 89)
    public RString listChosa_6;
    @ReportItem(name = "tokki1", order = 90)
    public RString tokki1;
    @ReportItem(name = "tokki9", order = 91)
    public RString tokki9;
    @ReportItem(name = "tokki17", order = 92)
    public RString tokki17;
    @ReportItem(name = "tokki2", order = 93)
    public RString tokki2;
    @ReportItem(name = "tokki10", order = 94)
    public RString tokki10;
    @ReportItem(name = "tokki18", order = 95)
    public RString tokki18;
    @ReportItem(name = "tokki3", order = 96)
    public RString tokki3;
    @ReportItem(name = "tokki11", order = 97)
    public RString tokki11;
    @ReportItem(name = "tokki19", order = 98)
    public RString tokki19;
    @ReportItem(name = "tokki4", order = 99)
    public RString tokki4;
    @ReportItem(name = "tokki12", order = 100)
    public RString tokki12;
    @ReportItem(name = "tokki20", order = 101)
    public RString tokki20;
    @ReportItem(name = "tokki5", order = 102)
    public RString tokki5;
    @ReportItem(name = "tokki13", order = 103)
    public RString tokki13;
    @ReportItem(name = "tokki21", order = 104)
    public RString tokki21;
    @ReportItem(name = "tokki6", order = 105)
    public RString tokki6;
    @ReportItem(name = "tokki14", order = 106)
    public RString tokki14;
    @ReportItem(name = "tokki22", order = 107)
    public RString tokki22;
    @ReportItem(name = "tokki7", order = 108)
    public RString tokki7;
    @ReportItem(name = "tokki15", order = 109)
    public RString tokki15;
    @ReportItem(name = "tokki23", order = 110)
    public RString tokki23;
    @ReportItem(name = "tokki8", order = 111)
    public RString tokki8;
    @ReportItem(name = "tokki16", order = 112)
    public RString tokki16;
    @ReportItem(name = "tokki24", order = 113)
    public RString tokki24;
    @ReportItem(name = "gaikyotokkiImg", order = 114)
    public RString gaikyotokkiImg;
    @ReportItem(name = "gaikyotokkiText", order = 115)
    public RString gaikyotokkiText;
    @ReportItem(name = "tokkiImg1", order = 116)
    public RString tokkiImg1;
    @ReportItem(name = "tokkiImg2", order = 117)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 118)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 119)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 120)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 121)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 122)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 123)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 124)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 125)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 126)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 127)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 128)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 129)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 130)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 131)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 132)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 133)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 134)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 135)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 136)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 137)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 138)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 139)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 140)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 141)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 142)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 143)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 144)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 145)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 146)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 147)
    public RString tokkiImg;
    @ReportItem(name = "tokkiText", order = 148)
    public RString tokkiText;
    @ReportItem(name = "imgSonotashiryo", order = 149)
    public RString imgSonotashiryo;
    @ReportItem(name = "zenZenkaiNijihanteikekka", length = 4, order = 150)
    public RString zenZenkaiNijihanteikekka;
    @ReportItem(name = "zenzenkaiYukokikan", length = 4, order = 151)
    public RString zenzenkaiYukokikan;
    @ReportItem(name = "zZenkaiNijiKaishiYMD", length = 9, order = 152)
    public RString zZenkaiNijiKaishiYMD;
    @ReportItem(name = "zZenkaiNijishuryoYMD", length = 9, order = 153)
    public RString zZenkaiNijishuryoYMD;
    @ReportItem(name = "gogitaiNo", length = 3, order = 154)
    public RString gogitaiNo;
    @ReportItem(name = "shinseiCount", length = 2, order = 155)
    public RString shinseiCount;
    @ReportItem(name = "hihokenshaKubun", length = 7, order = 156)
    public RString hihokenshaKubun;
    @ReportItem(name = "zenkaiNijiKaishiYMD", length = 9, order = 157)
    public RString zenkaiNijiKaishiYMD;
    @ReportItem(name = "zenkaiNijishuryoYMD", length = 9, order = 158)
    public RString zenkaiNijishuryoYMD;
    @ReportItem(name = "zenkaiNijihanteiDATE", length = 10, order = 159)
    public RString zenkaiNijihanteiDATE;
    @ReportItem(name = "zenkaiJotaizo", length = 10, order = 160)
    public RString zenkaiJotaizo;
    @ReportItem(name = "kanriNo", length = 20, order = 161)
    public RString kanriNo;
    @ReportItem(name = "shozokuName", length = 20, order = 162)
    public RString shozokuName;
    @ReportItem(name = "listTokki1_1", length = 1, order = 163)
    public RString listTokki1_1;
    @ReportItem(name = "listIchigun_2", length = 1, order = 164)
    public RString listIchigun_2;
    @ReportItem(name = "listIchigun_3", length = 1, order = 165)
    public RString listIchigun_3;
    @ReportItem(name = "listIchigun_4", length = 22, order = 166)
    public RString listIchigun_4;
    @ReportItem(name = "shichosonName", length = 10, order = 167)
    public RString shichosonName;
    @ReportItem(name = "chosaItakusakiNo", length = 12, order = 168)
    public RString chosaItakusakiNo;
    @ReportItem(name = "chosainNo", length = 8, order = 169)
    public RString chosainNo;
    @ReportItem(name = "chosainShikaku", length = 20, order = 170)
    public RString chosainShikaku;
    @ReportItem(name = "iryokikanName", length = 30, order = 171)
    public RString iryokikanName;
    @ReportItem(name = "iryokikanNo", length = 12, order = 172)
    public RString iryokikanNo;
    @ReportItem(name = "ishiNo", length = 8, order = 173)
    public RString ishiNo;
    @ReportItem(name = "ishiName", length = 30, order = 174)
    public RString ishiName;
    @ReportItem(name = "kijunGokeiTime", length = 40, order = 175)
    public RString kijunGokeiTime;
    @ReportItem(name = "gurafuKijunTime", order = 176)
    public RString gurafuKijunTime;
    @ReportItem(name = "listTokki2_1", length = 1, order = 177)
    public RString listTokki2_1;
    @ReportItem(name = "listNigun_2", length = 1, order = 178)
    public RString listNigun_2;
    @ReportItem(name = "listNigun_3", length = 1, order = 179)
    public RString listNigun_3;
    @ReportItem(name = "listNigun_4", length = 22, order = 180)
    public RString listNigun_4;
    @ReportItem(name = "listkijunTime_1", length = 7, order = 181)
    public RString listkijunTime_1;
    @ReportItem(name = "listkijunTime_2", length = 7, order = 182)
    public RString listkijunTime_2;
    @ReportItem(name = "listkijunTime_3", length = 7, order = 183)
    public RString listkijunTime_3;
    @ReportItem(name = "listkijunTime_4", length = 7, order = 184)
    public RString listkijunTime_4;
    @ReportItem(name = "listkijunTime_5", length = 7, order = 185)
    public RString listkijunTime_5;
    @ReportItem(name = "listkijunTime_6", length = 7, order = 186)
    public RString listkijunTime_6;
    @ReportItem(name = "listkijunTime_7", length = 7, order = 187)
    public RString listkijunTime_7;
    @ReportItem(name = "listkijunTime_8", length = 7, order = 188)
    public RString listkijunTime_8;
    @ReportItem(name = "listkijunTime_9", length = 7, order = 189)
    public RString listkijunTime_9;
    @ReportItem(name = "keikokuNo", length = 120, order = 190)
    public RString keikokuNo;
    @ReportItem(name = "listChukanhyoka_1", length = 5, order = 191)
    public RString listChukanhyoka_1;
    @ReportItem(name = "listChukanhyoka_2", length = 5, order = 192)
    public RString listChukanhyoka_2;
    @ReportItem(name = "listChukanhyoka_3", length = 5, order = 193)
    public RString listChukanhyoka_3;
    @ReportItem(name = "listChukanhyoka_4", length = 5, order = 194)
    public RString listChukanhyoka_4;
    @ReportItem(name = "listChukanhyoka_5", length = 5, order = 195)
    public RString listChukanhyoka_5;
    @ReportItem(name = "listTokki3_1", length = 1, order = 196)
    public RString listTokki3_1;
    @ReportItem(name = "listSangun_2", length = 1, order = 197)
    public RString listSangun_2;
    @ReportItem(name = "listSangun_3", length = 1, order = 198)
    public RString listSangun_3;
    @ReportItem(name = "listSangun_4", length = 22, order = 199)
    public RString listSangun_4;
    @ReportItem(name = "listTokki8_1", length = 1, order = 200)
    public RString listTokki8_1;
    @ReportItem(name = "ｌistNichijoseikatsujiritsudo_1", length = 2, order = 201)
    public RString ｌistNichijoseikatsujiritsudo_1;
    @ReportItem(name = "chosaNinchishoJiritsudo", length = 2, order = 202)
    public RString chosaNinchishoJiritsudo;
    @ReportItem(name = "ikenNinchishoJiritsudo", length = 2, order = 203)
    public RString ikenNinchishoJiritsudo;
    @ReportItem(name = "manzensei", length = 6, order = 204)
    public RString manzensei;
    @ReportItem(name = "jotainoanteisei", length = 4, order = 205)
    public RString jotainoanteisei;
    @ReportItem(name = "kyufukubun", length = 4, order = 206)
    public RString kyufukubun;
    @ReportItem(name = "listTokki4_1", length = 1, order = 207)
    public RString listTokki4_1;
    @ReportItem(name = "listYongun_2", length = 1, order = 208)
    public RString listYongun_2;
    @ReportItem(name = "listYongun_3", length = 1, order = 209)
    public RString listYongun_3;
    @ReportItem(name = "listYongun_4", length = 22, order = 210)
    public RString listYongun_4;
    @ReportItem(name = "sabisuKubun", length = 15, order = 211)
    public RString sabisuKubun;
    @ReportItem(name = "sabisuName1", order = 212)
    public RString sabisuName1;
    @ReportItem(name = "sabisuKaisu1", length = 11, order = 213)
    public RString sabisuKaisu1;
    @ReportItem(name = "sabisuName2", order = 214)
    public RString sabisuName2;
    @ReportItem(name = "sabisuKaisu2", length = 11, order = 215)
    public RString sabisuKaisu2;
    @ReportItem(name = "sabisuName3", order = 216)
    public RString sabisuName3;
    @ReportItem(name = "sabisuKaisu3", length = 11, order = 217)
    public RString sabisuKaisu3;
    @ReportItem(name = "sabisuName4", order = 218)
    public RString sabisuName4;
    @ReportItem(name = "sabisuKaisu4", length = 11, order = 219)
    public RString sabisuKaisu4;
    @ReportItem(name = "sabisuName5", order = 220)
    public RString sabisuName5;
    @ReportItem(name = "sabisuKaisu5", length = 11, order = 221)
    public RString sabisuKaisu5;
    @ReportItem(name = "sabisuName6", order = 222)
    public RString sabisuName6;
    @ReportItem(name = "sabisuKaisu6", length = 11, order = 223)
    public RString sabisuKaisu6;
    @ReportItem(name = "sabisuName7", order = 224)
    public RString sabisuName7;
    @ReportItem(name = "sabisuKaisu7", length = 11, order = 225)
    public RString sabisuKaisu7;
    @ReportItem(name = "sabisuName8", order = 226)
    public RString sabisuName8;
    @ReportItem(name = "sabisuKaisu8", length = 11, order = 227)
    public RString sabisuKaisu8;
    @ReportItem(name = "sabisuName9", order = 228)
    public RString sabisuName9;
    @ReportItem(name = "sabisuKaisu9", length = 11, order = 229)
    public RString sabisuKaisu9;
    @ReportItem(name = "sabisuName10", order = 230)
    public RString sabisuName10;
    @ReportItem(name = "sabisuKaisu10", length = 11, order = 231)
    public RString sabisuKaisu10;
    @ReportItem(name = "sabisuName11", order = 232)
    public RString sabisuName11;
    @ReportItem(name = "sabisuKaisu11", length = 11, order = 233)
    public RString sabisuKaisu11;
    @ReportItem(name = "sabisuName12", order = 234)
    public RString sabisuName12;
    @ReportItem(name = "sabisuKaisu12", length = 11, order = 235)
    public RString sabisuKaisu12;
    @ReportItem(name = "sabisuName13", order = 236)
    public RString sabisuName13;
    @ReportItem(name = "sabisuKaisu13", length = 11, order = 237)
    public RString sabisuKaisu13;
    @ReportItem(name = "sabisuName14", order = 238)
    public RString sabisuName14;
    @ReportItem(name = "sabisuKaisu14", length = 11, order = 239)
    public RString sabisuKaisu14;
    @ReportItem(name = "sabisuName15", order = 240)
    public RString sabisuName15;
    @ReportItem(name = "sabisuKaisu15", length = 11, order = 241)
    public RString sabisuKaisu15;
    @ReportItem(name = "listTokki5_1", length = 1, order = 242)
    public RString listTokki5_1;
    @ReportItem(name = "listGogun_2", length = 1, order = 243)
    public RString listGogun_2;
    @ReportItem(name = "listGogun_3", length = 1, order = 244)
    public RString listGogun_3;
    @ReportItem(name = "listGogun_4", length = 22, order = 245)
    public RString listGogun_4;
    @ReportItem(name = "sabisuName16", order = 246)
    public RString sabisuName16;
    @ReportItem(name = "sabisuKaisu16", length = 11, order = 247)
    public RString sabisuKaisu16;
    @ReportItem(name = "sabisuName17", order = 248)
    public RString sabisuName17;
    @ReportItem(name = "sabisuKaisu17", length = 11, order = 249)
    public RString sabisuKaisu17;
    @ReportItem(name = "sabisuName18", order = 250)
    public RString sabisuName18;
    @ReportItem(name = "sabisuKaisu18", length = 11, order = 251)
    public RString sabisuKaisu18;
    @ReportItem(name = "sabisuName19", order = 252)
    public RString sabisuName19;
    @ReportItem(name = "sabisuKaisu19", length = 11, order = 253)
    public RString sabisuKaisu19;
    @ReportItem(name = "sabisuName20", order = 254)
    public RString sabisuName20;
    @ReportItem(name = "sabisuKaisu20", length = 11, order = 255)
    public RString sabisuKaisu20;
    @ReportItem(name = "sabisuName21", order = 256)
    public RString sabisuName21;
    @ReportItem(name = "sabisuKaisu21", length = 11, order = 257)
    public RString sabisuKaisu21;
    @ReportItem(name = "listshujiiikensho_1", length = 18, order = 258)
    public RString listshujiiikensho_1;
    @ReportItem(name = "listshujiiikensho_2", length = 1, order = 259)
    public RString listshujiiikensho_2;
    @ReportItem(name = "listshujiiikensho_3", length = 1, order = 260)
    public RString listshujiiikensho_3;
    @ReportItem(name = "listshujiiikensho_4", length = 18, order = 261)
    public RString listshujiiikensho_4;
    @ReportItem(name = "listTokki6_1", length = 1, order = 262)
    public RString listTokki6_1;
    @ReportItem(name = "listTokubetsunaIryo1_1", length = 2, order = 263)
    public RString listTokubetsunaIryo1_1;
    @ReportItem(name = "listTokubetsunaIryo1_2", length = 1, order = 264)
    public RString listTokubetsunaIryo1_2;
    @ReportItem(name = "listTokki7_1", length = 1, order = 265)
    public RString listTokki7_1;
    @ReportItem(name = "listTokubetsunaIryo2_1", length = 2, order = 266)
    public RString listTokubetsunaIryo2_1;
    @ReportItem(name = "listTokubetsunaIryo2_2", length = 1, order = 267)
    public RString listTokubetsunaIryo2_2;
    @ReportItem(name = "shinsakaiOrder", length = 2, order = 268)
    public RString shinsakaiOrder;
    @ReportItem(name = "imgIkensho1", order = 269)
    public RString imgIkensho1;
    @ReportItem(name = "imgIkensho2", order = 270)
    public RString imgIkensho2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hihokennshaNo;

    //レイアウトブレイク用フィールド
    @ReportItem(name = "layout", order = 999)
    public int layout;
    @ReportItem(name = "recordCount", length = 10, order = 997)
    public int recordCount;

    //レイアウトブレイク用キーの一覧です。
    public static final List<RString> LAYOUT_BREAK_KEYS;

    static {
        LAYOUT_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("layout")));
    }
}
