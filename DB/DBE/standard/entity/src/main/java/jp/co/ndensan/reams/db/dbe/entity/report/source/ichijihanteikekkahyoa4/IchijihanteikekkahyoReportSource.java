package jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 一次判定結果Sourceクラスです。
 *
 * @reamsid_L DBE-0230-060 lizhuoxuan
 */
public class IchijihanteikekkahyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sakuseiGengo", length = 2, order = 1)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 2)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 3)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 4)
    public RString sakuseiDD;
    @ReportItem(name = "title", length = 20, order = 5)
    public RString title;
    @ReportItem(name = "shinseiGengo", length = 2, order = 6)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 7)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 8)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 9)
    public RString shinseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 10)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 11)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 12)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 13)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 14)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 15)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 16)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 17)
    public RString shinsaDD;
    @ReportItem(name = "shisetsuriyo", length = 20, order = 18)
    public RString shisetsuriyo;
    @ReportItem(name = "age", length = 5, order = 19)
    public RString age;
    @ReportItem(name = "seibetsu", length = 1, order = 20)
    public RString seibetsu;
    @ReportItem(name = "zenZenkaiNijihanteikekka", length = 4, order = 21)
    public RString zenZenkaiNijihanteikekka;
    @ReportItem(name = "zenzenkaiYukokikan", length = 4, order = 22)
    public RString zenzenkaiYukokikan;
    @ReportItem(name = "zZenkaiNijiKaishiYMD", length = 9, order = 23)
    public RString zZenkaiNijiKaishiYMD;
    @ReportItem(name = "zZenkaiNijishuryoYMD", length = 9, order = 24)
    public RString zZenkaiNijishuryoYMD;
    @ReportItem(name = "gogitaiNo", length = 3, order = 25)
    public RString gogitaiNo;
    @ReportItem(name = "shinseiCount", length = 2, order = 26)
    public RString shinseiCount;
    @ReportItem(name = "hihokenshaKubun", length = 7, order = 27)
    public RString hihokenshaKubun;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 4, order = 28)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenkaiYukokikan", length = 4, order = 29)
    public RString zenkaiYukokikan;
    @ReportItem(name = "zenkaiNijiKaishiYMD", length = 9, order = 30)
    public RString zenkaiNijiKaishiYMD;
    @ReportItem(name = "zenkaiNijishuryoYMD", length = 9, order = 31)
    public RString zenkaiNijishuryoYMD;
    @ReportItem(name = "zenkaiNijihanteiDATE", length = 10, order = 32)
    public RString zenkaiNijihanteiDATE;
    @ReportItem(name = "zenkaiJotaizo", length = 10, order = 33)
    public RString zenkaiJotaizo;
    @ReportItem(name = "kanriNo", length = 20, order = 34)
    public RString kanriNo;
    @ReportItem(name = "shinseiKubun", length = 13, order = 35)
    public RString shinseiKubun;
    @ReportItem(name = "hihokenshaName", length = 30, order = 36)
    public RString hihokenshaName;
    @ReportExpandedInfo
    @ReportItem(name = "hihokenshaNo", length = 10, order = 37)
    public RString hihokenshaNo;
    @ReportItem(name = "shozokuName", length = 20, order = 38)
    public RString shozokuName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 39)
    public RString hokenshaNo;
    @ReportItem(name = "listTokki1_1", length = 1, order = 40)
    public RString listTokki1_1;
    @ReportItem(name = "listIchigun_1", length = 22, order = 41)
    public RString listIchigun_1;
    @ReportItem(name = "listIchigun_2", length = 1, order = 42)
    public RString listIchigun_2;
    @ReportItem(name = "listIchigun_3", length = 1, order = 43)
    public RString listIchigun_3;
    @ReportItem(name = "listIchigun_4", length = 22, order = 44)
    public RString listIchigun_4;
    @ReportItem(name = "shichosonName", length = 10, order = 45)
    public RString shichosonName;
    @ReportItem(name = "chosaItakusakiNo", length = 12, order = 46)
    public RString chosaItakusakiNo;
    @ReportItem(name = "chosaItakusakiName", length = 30, order = 47)
    public RString chosaItakusakiName;
    @ReportItem(name = "chosainNo", length = 8, order = 48)
    public RString chosainNo;
    @ReportItem(name = "chosainName", length = 30, order = 49)
    public RString chosainName;
    @ReportItem(name = "chosainShikaku", length = 20, order = 50)
    public RString chosainShikaku;
    @ReportItem(name = "iryokikanName", length = 30, order = 51)
    public RString iryokikanName;
    @ReportItem(name = "iryokikanNo", length = 12, order = 52)
    public RString iryokikanNo;
    @ReportItem(name = "ishiNo", length = 8, order = 53)
    public RString ishiNo;
    @ReportItem(name = "ishiName", length = 30, order = 54)
    public RString ishiName;
    @ReportItem(name = "ichijiHanteiKekka", length = 12, order = 55)
    public RString ichijiHanteiKekka;
    @ReportItem(name = "nijiHanteiKekka", length = 12, order = 56)
    public RString nijiHanteiKekka;
    @ReportItem(name = "nijihanteiKaishiYMD", length = 9, order = 57)
    public RString nijihanteiKaishiYMD;
    @ReportItem(name = "nijihanteishuryoYMD", length = 9, order = 58)
    public RString nijihanteishuryoYMD;
    @ReportItem(name = "ｙukokikan", length = 4, order = 59)
    public RString ｙukokikan;
    @ReportItem(name = "tokuteishippeiName", length = 40, order = 60)
    public RString tokuteishippeiName;
    @ReportItem(name = "jotaizo", length = 26, order = 61)
    public RString jotaizo;
    @ReportItem(name = "kijunGokeiTime", length = 40, order = 62)
    public RString kijunGokeiTime;
    @ReportItem(name = "gurafuKijunTime", order = 63)
    public RString gurafuKijunTime;
    @ReportItem(name = "listTokki2_1", length = 1, order = 64)
    public RString listTokki2_1;
    @ReportItem(name = "listNigun_1", length = 22, order = 65)
    public RString listNigun_1;
    @ReportItem(name = "listNigun_2", length = 1, order = 66)
    public RString listNigun_2;
    @ReportItem(name = "listNigun_3", length = 1, order = 67)
    public RString listNigun_3;
    @ReportItem(name = "listNigun_4", length = 22, order = 68)
    public RString listNigun_4;
    @ReportItem(name = "listkijunTime_1", length = 7, order = 69)
    public RString listkijunTime_1;
    @ReportItem(name = "listkijunTime_2", length = 7, order = 70)
    public RString listkijunTime_2;
    @ReportItem(name = "listkijunTime_3", length = 7, order = 71)
    public RString listkijunTime_3;
    @ReportItem(name = "listkijunTime_4", length = 7, order = 72)
    public RString listkijunTime_4;
    @ReportItem(name = "listkijunTime_5", length = 7, order = 73)
    public RString listkijunTime_5;
    @ReportItem(name = "listkijunTime_6", length = 7, order = 74)
    public RString listkijunTime_6;
    @ReportItem(name = "listkijunTime_7", length = 7, order = 75)
    public RString listkijunTime_7;
    @ReportItem(name = "listkijunTime_8", length = 7, order = 76)
    public RString listkijunTime_8;
    @ReportItem(name = "listkijunTime_9", length = 7, order = 77)
    public RString listkijunTime_9;
    @ReportItem(name = "keikokuNo", length = 120, order = 78)
    public RString keikokuNo;
    @ReportItem(name = "listChukanhyoka_1", length = 5, order = 79)
    public RString listChukanhyoka_1;
    @ReportItem(name = "listChukanhyoka_2", length = 5, order = 80)
    public RString listChukanhyoka_2;
    @ReportItem(name = "listChukanhyoka_3", length = 5, order = 81)
    public RString listChukanhyoka_3;
    @ReportItem(name = "listChukanhyoka_4", length = 5, order = 82)
    public RString listChukanhyoka_4;
    @ReportItem(name = "listChukanhyoka_5", length = 5, order = 83)
    public RString listChukanhyoka_5;
    @ReportItem(name = "listTokki3_1", length = 1, order = 84)
    public RString listTokki3_1;
    @ReportItem(name = "listSangun_1", length = 22, order = 85)
    public RString listSangun_1;
    @ReportItem(name = "listSangun_2", length = 1, order = 86)
    public RString listSangun_2;
    @ReportItem(name = "listSangun_3", length = 1, order = 87)
    public RString listSangun_3;
    @ReportItem(name = "listSangun_4", length = 22, order = 88)
    public RString listSangun_4;
    @ReportItem(name = "listTokki8_1", length = 1, order = 89)
    public RString listTokki8_1;
    @ReportItem(name = "ｌistNichijoseikatsujiritsudo_1", length = 2, order = 90)
    public RString ｌistNichijoseikatsujiritsudo_1;
    @ReportItem(name = "chosaNinchishoJiritsudo", length = 2, order = 91)
    public RString chosaNinchishoJiritsudo;
    @ReportItem(name = "ikenNinchishoJiritsudo", length = 2, order = 92)
    public RString ikenNinchishoJiritsudo;
    @ReportItem(name = "manzensei", length = 6, order = 93)
    public RString manzensei;
    @ReportItem(name = "jotainoanteisei", length = 4, order = 94)
    public RString jotainoanteisei;
    @ReportItem(name = "kyufukubun", length = 4, order = 95)
    public RString kyufukubun;
    @ReportItem(name = "listTokki4_1", length = 1, order = 96)
    public RString listTokki4_1;
    @ReportItem(name = "listYongun_1", length = 22, order = 97)
    public RString listYongun_1;
    @ReportItem(name = "listYongun_2", length = 1, order = 98)
    public RString listYongun_2;
    @ReportItem(name = "listYongun_3", length = 1, order = 99)
    public RString listYongun_3;
    @ReportItem(name = "listYongun_4", length = 22, order = 100)
    public RString listYongun_4;
    @ReportItem(name = "sabisuKubun", length = 15, order = 101)
    public RString sabisuKubun;
    @ReportItem(name = "sabisuName1", order = 102)
    public RString sabisuName1;
    @ReportItem(name = "sabisuKaisu1", length = 11, order = 103)
    public RString sabisuKaisu1;
    @ReportItem(name = "sabisuName2", order = 104)
    public RString sabisuName2;
    @ReportItem(name = "sabisuKaisu2", length = 11, order = 105)
    public RString sabisuKaisu2;
    @ReportItem(name = "sabisuName3", order = 106)
    public RString sabisuName3;
    @ReportItem(name = "sabisuKaisu3", length = 11, order = 107)
    public RString sabisuKaisu3;
    @ReportItem(name = "sabisuName4", order = 108)
    public RString sabisuName4;
    @ReportItem(name = "sabisuKaisu4", length = 11, order = 109)
    public RString sabisuKaisu4;
    @ReportItem(name = "sabisuName5", order = 110)
    public RString sabisuName5;
    @ReportItem(name = "sabisuKaisu5", length = 11, order = 111)
    public RString sabisuKaisu5;
    @ReportItem(name = "sabisuName6", order = 112)
    public RString sabisuName6;
    @ReportItem(name = "sabisuKaisu6", length = 11, order = 113)
    public RString sabisuKaisu6;
    @ReportItem(name = "sabisuName7", order = 114)
    public RString sabisuName7;
    @ReportItem(name = "sabisuKaisu7", length = 11, order = 115)
    public RString sabisuKaisu7;
    @ReportItem(name = "sabisuName8", order = 116)
    public RString sabisuName8;
    @ReportItem(name = "sabisuKaisu8", length = 11, order = 117)
    public RString sabisuKaisu8;
    @ReportItem(name = "sabisuName9", order = 118)
    public RString sabisuName9;
    @ReportItem(name = "sabisuKaisu9", length = 11, order = 119)
    public RString sabisuKaisu9;
    @ReportItem(name = "sabisuName10", order = 120)
    public RString sabisuName10;
    @ReportItem(name = "sabisuKaisu10", length = 11, order = 121)
    public RString sabisuKaisu10;
    @ReportItem(name = "sabisuName11", order = 122)
    public RString sabisuName11;
    @ReportItem(name = "sabisuKaisu11", length = 11, order = 123)
    public RString sabisuKaisu11;
    @ReportItem(name = "sabisuName12", order = 124)
    public RString sabisuName12;
    @ReportItem(name = "sabisuKaisu12", length = 11, order = 125)
    public RString sabisuKaisu12;
    @ReportItem(name = "sabisuName13", order = 126)
    public RString sabisuName13;
    @ReportItem(name = "sabisuKaisu13", length = 11, order = 127)
    public RString sabisuKaisu13;
    @ReportItem(name = "sabisuName14", order = 128)
    public RString sabisuName14;
    @ReportItem(name = "sabisuKaisu14", length = 11, order = 129)
    public RString sabisuKaisu14;
    @ReportItem(name = "sabisuName15", order = 130)
    public RString sabisuName15;
    @ReportItem(name = "sabisuKaisu15", length = 11, order = 131)
    public RString sabisuKaisu15;
    @ReportItem(name = "listTokki5_1", length = 1, order = 132)
    public RString listTokki5_1;
    @ReportItem(name = "listGogun_1", length = 22, order = 133)
    public RString listGogun_1;
    @ReportItem(name = "listGogun_2", length = 1, order = 134)
    public RString listGogun_2;
    @ReportItem(name = "listGogun_3", length = 1, order = 135)
    public RString listGogun_3;
    @ReportItem(name = "listGogun_4", length = 22, order = 136)
    public RString listGogun_4;
    @ReportItem(name = "sabisuName16", order = 137)
    public RString sabisuName16;
    @ReportItem(name = "sabisuKaisu16", length = 11, order = 138)
    public RString sabisuKaisu16;
    @ReportItem(name = "sabisuName17", order = 139)
    public RString sabisuName17;
    @ReportItem(name = "sabisuKaisu17", length = 11, order = 140)
    public RString sabisuKaisu17;
    @ReportItem(name = "sabisuName18", order = 141)
    public RString sabisuName18;
    @ReportItem(name = "sabisuKaisu18", length = 11, order = 142)
    public RString sabisuKaisu18;
    @ReportItem(name = "sabisuName19", order = 143)
    public RString sabisuName19;
    @ReportItem(name = "sabisuKaisu19", length = 11, order = 144)
    public RString sabisuKaisu19;
    @ReportItem(name = "sabisuName20", order = 145)
    public RString sabisuName20;
    @ReportItem(name = "sabisuKaisu20", length = 11, order = 146)
    public RString sabisuKaisu20;
    @ReportItem(name = "sabisuName21", order = 147)
    public RString sabisuName21;
    @ReportItem(name = "sabisuKaisu21", length = 11, order = 148)
    public RString sabisuKaisu21;
    @ReportItem(name = "listshujiiikensho_1", length = 18, order = 149)
    public RString listshujiiikensho_1;
    @ReportItem(name = "listshujiiikensho_2", length = 1, order = 150)
    public RString listshujiiikensho_2;
    @ReportItem(name = "listshujiiikensho_3", length = 1, order = 151)
    public RString listshujiiikensho_3;
    @ReportItem(name = "listshujiiikensho_4", length = 18, order = 152)
    public RString listshujiiikensho_4;
    @ReportItem(name = "listTokki6_1", length = 1, order = 153)
    public RString listTokki6_1;
    @ReportItem(name = "listTokubetsunaIryo1_1", length = 2, order = 154)
    public RString listTokubetsunaIryo1_1;
    @ReportItem(name = "listTokubetsunaIryo1_2", length = 1, order = 155)
    public RString listTokubetsunaIryo1_2;
    @ReportItem(name = "listTokki7_1", length = 1, order = 156)
    public RString listTokki7_1;
    @ReportItem(name = "listTokubetsunaIryo2_1", length = 2, order = 157)
    public RString listTokubetsunaIryo2_1;
    @ReportItem(name = "listTokubetsunaIryo2_2", length = 1, order = 158)
    public RString listTokubetsunaIryo2_2;

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
    @ReportItem(name = "sabisuName", length = 15, order = 300)
    public RString sabisuName;
}
