package jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 事業分計算結果連絡票Sourceクラスです。
 *
 * @reamsid_L DBC-4840-030 wangxingpeng
 */
public class GassanJigyobunKeisanKekkaRenrakuhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 40, order = 1)
    public RString title;
    @ReportItem(name = "pageBonbo", length = 2, order = 2)
    public RString pageBonbo;
    @ReportItem(name = "taishoshaNameKana", length = 60, order = 3)
    public RString taishoshaNameKana;
    @ReportItem(name = "kekkaRenrakuYubinNO", length = 8, order = 4)
    public RString kekkaRenrakuYubinNO;
    @ReportItem(name = "kekkaRenrakuJusho1", length = 25, order = 5)
    public RString kekkaRenrakuJusho1;
    @ReportItem(name = "taishoshaName", length = 40, order = 6)
    public RString taishoshaName;
    @ReportItem(name = "kekkaRenrakuJusho2", length = 25, order = 7)
    public RString kekkaRenrakuJusho2;
    @ReportItem(name = "kekkaRenrakuJusho3", length = 14, order = 8)
    public RString kekkaRenrakuJusho3;
    @ReportItem(name = "seibetsu", length = 1, order = 9)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 11, order = 10)
    public RString birthYMD;
    @ReportItem(name = "kekkaRenrakuMeisho1", length = 20, order = 11)
    public RString kekkaRenrakuMeisho1;
    @ReportItem(name = "jikoFutanSeiriNo", length = 20, order = 12)
    public RString jikoFutanSeiriNo;
    @ReportItem(name = "kekkaRenrakuMeisho2", length = 20, order = 13)
    public RString kekkaRenrakuMeisho2;
    @ReportItem(name = "hokenshaNo", length = 6, order = 14)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaKigo", length = 20, order = 15)
    public RString hihokenshaKigo;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 16)
    public RString hihokenshaNo;
    @ReportItem(name = "taishoNendo", length = 6, order = 17)
    public RString taishoNendo;
    @ReportItem(name = "tuchiYMD", length = 11, order = 18)
    public RString tuchiYMD;
    @ReportItem(name = "keisanSTYMD", length = 11, order = 19)
    public RString keisanSTYMD;
    @ReportItem(name = "keisanEDYMD", length = 11, order = 20)
    public RString keisanEDYMD;
    @ReportItem(name = "hakkosha", order = 21)
    public RString hakkosha;
    @ReportItem(name = "setaiFutanSogaku", length = 10, order = 22)
    public RString setaiFutanSogaku;
    @ReportItem(name = "setaiGassanFutanGaku", length = 10, order = 23)
    public RString setaiGassanFutanGaku;
    @ReportItem(name = "over70SetaiGassanFutanGaku", length = 10, order = 24)
    public RString over70SetaiGassanFutanGaku;
    @ReportItem(name = "shotokuKbn", length = 5, order = 25)
    public RString shotokuKbn;
    @ReportItem(name = "over70ShotokuKbn", length = 5, order = 26)
    public RString over70ShotokuKbn;
    @ReportItem(name = "santeiKijunGaku", length = 7, order = 27)
    public RString santeiKijunGaku;
    @ReportItem(name = "over70SanteiKijunGaku", length = 6, order = 28)
    public RString over70SanteiKijunGaku;
    @ReportItem(name = "setaiShikyuGaku", length = 10, order = 29)
    public RString setaiShikyuGaku;
    @ReportItem(name = "over70SetaiShikyuGaku", length = 10, order = 30)
    public RString over70SetaiShikyuGaku;
    @ReportItem(name = "toiawasesaki", order = 31)
    public RString toiawasesaki;
    @ReportItem(name = "honninShikyuGaku", length = 10, order = 32)
    public RString honninShikyuGaku;
    @ReportItem(name = "over70HonninShikyuGaku", length = 10, order = 33)
    public RString over70HonninShikyuGaku;
    @ReportItem(name = "biko", order = 34)
    public RString biko;
    @ReportItem(name = "shikyuSeiriNO", length = 17, order = 35)
    public RString shikyuSeiriNO;
    @ReportItem(name = "list1_1", length = 16, order = 36)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 20, order = 37)
    public RString list1_2;
    @ReportItem(name = "list1_3", length = 12, order = 38)
    public RString list1_3;
    @ReportItem(name = "list1_4", length = 10, order = 39)
    public RString list1_4;
    @ReportItem(name = "list1_5", length = 20, order = 40)
    public RString list1_5;
    @ReportItem(name = "list1_6", length = 20, order = 41)
    public RString list1_6;
    @ReportItem(name = "list1_7", length = 13, order = 42)
    public RString list1_7;
    @ReportItem(name = "list1_8", length = 17, order = 43)
    public RString list1_8;
    @ReportItem(name = "list1_9", length = 13, order = 44)
    public RString list1_9;
    @ReportItem(name = "list1_10", length = 13, order = 45)
    public RString list1_10;
    @ReportItem(name = "list1_11", length = 13, order = 46)
    public RString list1_11;
    @ReportItem(name = "list1_12", length = 17, order = 47)
    public RString list1_12;
    @ReportItem(name = "list1_13", length = 13, order = 48)
    public RString list1_13;
    @ReportItem(name = "list1_14", length = 13, order = 49)
    public RString list1_14;
    @ReportItem(name = "over70FutangakuGokei", length = 13, order = 50)
    public RString over70FutangakuGokei;
    @ReportItem(name = "over70ShikyugakuGokei", length = 13, order = 51)
    public RString over70ShikyugakuGokei;
    @ReportItem(name = "under70FutangakuGokei", length = 13, order = 52)
    public RString under70FutangakuGokei;
    @ReportItem(name = "futangakuGokei", length = 13, order = 53)
    public RString futangakuGokei;
    @ReportItem(name = "under70ShikyugakuGokei", length = 13, order = 54)
    public RString under70ShikyugakuGokei;
    @ReportItem(name = "shikyugakuGokei", length = 13, order = 55)
    public RString shikyugakuGokei;
    @ReportItem(name = "denshiKoin", order = 56)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 57)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 58)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 59)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 60)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 61)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 62)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 63)
    public RString koinShoryaku;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
