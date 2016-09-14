package jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Sourceするクラスです。
 *
 * @reamsid_L DBC-2000-060 lijian
 */
public class KogakuKetteiTsuchiShoSealerSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "tsuban", length = 4, order = 2)
    public RString tsuban;
    @ReportItem(name = "title1", length = 20, order = 3)
    public RString title1;
    @ReportItem(name = "page", length = 2, order = 4)
    public RString page;
    @ReportItem(name = "pages", length = 2, order = 5)
    public RString pages;
    @ReportItem(name = "title", length = 20, order = 6)
    public RString title;
    @ReportItem(name = "title2", length = 20, order = 7)
    public RString title2;
    @ReportItem(name = "testPrint", length = 5, order = 8)
    public RString testPrint;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "hihokenshaNo", length = 10, order = 9)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName2", length = 17, order = 10)
    public RString hihokenshaName2;
    @ReportItem(name = "hihokenshaName", order = 11)
    public RString hihokenshaName;
    @ReportItem(name = "tsuchibun1", length = 29, order = 12)
    public RString tsuchibun1;
    @ReportItem(name = "ketteiYMD", length = 11, order = 13)
    public RString ketteiYMD;
    @ReportItem(name = "tsuchibun2", length = 29, order = 14)
    public RString tsuchibun2;
    @ReportItem(name = "tsuchibun3", length = 29, order = 15)
    public RString tsuchibun3;
    @ReportItem(name = "shiharaiGaku", length = 10, order = 16)
    public RString shiharaiGaku;
    @ReportItem(name = "tsuchibun4", length = 29, order = 17)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 29, order = 18)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 29, order = 19)
    public RString tsuchibun6;
    @ReportItem(name = "shiharaiYoteiYMD", length = 11, order = 20)
    public RString shiharaiYoteiYMD;
    @ReportItem(name = "tsuchibun7", length = 29, order = 21)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 29, order = 22)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 29, order = 23)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 29, order = 24)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 29, order = 25)
    public RString tsuchibun11;
    @ReportItem(name = "taishoYM1", length = 8, order = 26)
    public RString taishoYM1;
    @ReportItem(name = "shikyuGaku1", length = 13, order = 27)
    public RString shikyuGaku1;
    @ReportItem(name = "yen1", length = 1, order = 28)
    public RString yen1;
    @ReportItem(name = "tsuchibun12", length = 29, order = 29)
    public RString tsuchibun12;
    @ReportItem(name = "info1", length = 58, order = 30)
    public RString info1;
    @ReportItem(name = "taishoYM2", length = 8, order = 31)
    public RString taishoYM2;
    @ReportItem(name = "shikyuGaku2", length = 13, order = 32)
    public RString shikyuGaku2;
    @ReportItem(name = "yen2", length = 1, order = 33)
    public RString yen2;
    @ReportItem(name = "tsuchibun13", length = 29, order = 34)
    public RString tsuchibun13;
    @ReportItem(name = "tsuchibun14", length = 29, order = 35)
    public RString tsuchibun14;
    @ReportItem(name = "taishoYM3", length = 8, order = 36)
    public RString taishoYM3;
    @ReportItem(name = "shikyuGaku3", length = 13, order = 37)
    public RString shikyuGaku3;
    @ReportItem(name = "yen3", length = 1, order = 38)
    public RString yen3;
    @ReportItem(name = "info2", length = 58, order = 39)
    public RString info2;
    @ReportItem(name = "tsuchibun15", length = 29, order = 40)
    public RString tsuchibun15;
    @ReportItem(name = "taishoYM4", length = 8, order = 41)
    public RString taishoYM4;
    @ReportItem(name = "shikyuGaku4", length = 13, order = 42)
    public RString shikyuGaku4;
    @ReportItem(name = "yen4", length = 1, order = 43)
    public RString yen4;
    @ReportItem(name = "info3", length = 58, order = 44)
    public RString info3;
    @ReportItem(name = "tsuchibun16", length = 29, order = 45)
    public RString tsuchibun16;
    @ReportItem(name = "info4", length = 58, order = 46)
    public RString info4;
    @ReportItem(name = "tsuchibun17", length = 29, order = 47)
    public RString tsuchibun17;
    @ReportItem(name = "bankName", length = 30, order = 48)
    public RString bankName;
    @ReportItem(name = "info5", length = 58, order = 49)
    public RString info5;
    @ReportItem(name = "tsuchibun18", length = 29, order = 50)
    public RString tsuchibun18;
    @ReportItem(name = "branchBankName", order = 51)
    public RString branchBankName;
    @ReportItem(name = "tsuchibun19", length = 29, order = 52)
    public RString tsuchibun19;
    @ReportItem(name = "info6", length = 58, order = 53)
    public RString info6;
    @ReportItem(name = "tsuchibun20", length = 29, order = 54)
    public RString tsuchibun20;
    @ReportItem(name = "info7", length = 58, order = 55)
    public RString info7;
    @ReportItem(name = "tsuchibun21", length = 29, order = 56)
    public RString tsuchibun21;
    @ReportItem(name = "shumokuTitle", length = 4, order = 57)
    public RString shumokuTitle;
    @ReportItem(name = "kouzaShu", length = 6, order = 58)
    public RString kouzaShu;
    @ReportItem(name = "bangoTitle", length = 4, order = 59)
    public RString bangoTitle;
    @ReportItem(name = "kouzaNo", length = 10, order = 60)
    public RString kouzaNo;
    @ReportItem(name = "info8", length = 58, order = 61)
    public RString info8;
    @ReportItem(name = "tsuchibun22", length = 29, order = 62)
    public RString tsuchibun22;
    @ReportItem(name = "info9", length = 58, order = 63)
    public RString info9;
    @ReportItem(name = "tsuchibun23", length = 29, order = 64)
    public RString tsuchibun23;
    @ReportItem(name = "kouzaMeigi", order = 65)
    public RString kouzaMeigi;
    @ReportItem(name = "info10", length = 58, order = 66)
    public RString info10;
    @ReportItem(name = "tsuchibun24", length = 29, order = 67)
    public RString tsuchibun24;
    @ReportItem(name = "hakkoYMD", length = 12, order = 68)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 69)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 70)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 71)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 72)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 73)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 74)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 75)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 76)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo", length = 8, order = 77)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku2", length = 14, order = 78)
    public RString gyoseiku2;
    @ReportItem(name = "jusho4", length = 20, order = 79)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 80)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 81)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 82)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 83)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 84)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 85)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 86)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 87)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei5", length = 20, order = 88)
    public RString shimei5;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 89)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 90)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 91)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 92)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 93)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei6", length = 20, order = 94)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 95)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 96)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 97)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 98)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 99)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 100)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 101)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 102)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 103)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 104)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 105)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 106)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 107)
    public RString customerBarCode;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
