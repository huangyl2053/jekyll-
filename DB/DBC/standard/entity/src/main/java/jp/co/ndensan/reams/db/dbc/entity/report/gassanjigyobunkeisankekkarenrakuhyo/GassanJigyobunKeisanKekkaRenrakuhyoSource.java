// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    @ReportItem(name = "pagecnt", length = 6, order = 2)
    public RString pagecnt;
    @ReportItem(name = "PageNo", length = 2, order = 3)
    public RString PageNo;
    @ReportItem(name = "pageBonbo", length = 2, order = 4)
    public RString pageBonbo;
    @ReportItem(name = "taishoshaNameKana", length = 60, order = 5)
    public RString taishoshaNameKana;
    @ReportItem(name = "kekkaRenrakuYubinNO", length = 8, order = 6)
    public RString kekkaRenrakuYubinNO;
    @ReportItem(name = "kekkaRenrakuJusho1", length = 25, order = 7)
    public RString kekkaRenrakuJusho1;
    @ReportItem(name = "taishoshaName", length = 40, order = 8)
    public RString taishoshaName;
    @ReportItem(name = "kekkaRenrakuJusho2", length = 25, order = 9)
    public RString kekkaRenrakuJusho2;
    @ReportItem(name = "kekkaRenrakuJusho3", length = 14, order = 10)
    public RString kekkaRenrakuJusho3;
    @ReportItem(name = "seibetsu", length = 1, order = 11)
    public RString seibetsu;
    @ReportItem(name = "birthYMD", length = 11, order = 12)
    public RString birthYMD;
    @ReportItem(name = "kekkaRenrakuMeisho1", length = 20, order = 13)
    public RString kekkaRenrakuMeisho1;
    @ReportItem(name = "jikoFutanSeiriNo", length = 20, order = 14)
    public RString jikoFutanSeiriNo;
    @ReportItem(name = "kekkaRenrakuMeisho2", length = 20, order = 15)
    public RString kekkaRenrakuMeisho2;
    @ReportItem(name = "hokenshaNo", length = 6, order = 16)
    public RString hokenshaNo;
    @ReportItem(name = "hihokenshaKigo", length = 20, order = 17)
    public RString hihokenshaKigo;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "HihokenshaNo", length = 10, order = 18)
    public RString HihokenshaNo;
    @ReportItem(name = "taishoNendo", length = 6, order = 19)
    public RString taishoNendo;
    @ReportItem(name = "tuchiYMD", length = 11, order = 20)
    public RString tuchiYMD;
    @ReportItem(name = "keisanSTYMD", length = 11, order = 21)
    public RString keisanSTYMD;
    @ReportItem(name = "keisanEDYMD", length = 11, order = 22)
    public RString keisanEDYMD;
    @ReportItem(name = "hakkosha", order = 23)
    public RString hakkosha;
    @ReportItem(name = "setaiFutanSogaku", length = 10, order = 24)
    public RString setaiFutanSogaku;
    @ReportItem(name = "setaiGassanFutanGaku", length = 10, order = 25)
    public RString setaiGassanFutanGaku;
    @ReportItem(name = "over70SetaiGassanFutanGaku", length = 10, order = 26)
    public RString over70SetaiGassanFutanGaku;
    @ReportItem(name = "shotokuKbn", length = 5, order = 27)
    public RString shotokuKbn;
    @ReportItem(name = "over70ShotokuKbn", length = 5, order = 28)
    public RString over70ShotokuKbn;
    @ReportItem(name = "santeiKijunGaku", length = 7, order = 29)
    public RString santeiKijunGaku;
    @ReportItem(name = "over70SanteiKijunGaku", length = 6, order = 30)
    public RString over70SanteiKijunGaku;
    @ReportItem(name = "setaiShikyuGaku", length = 10, order = 31)
    public RString setaiShikyuGaku;
    @ReportItem(name = "over70SetaiShikyuGaku", length = 10, order = 32)
    public RString over70SetaiShikyuGaku;
    @ReportItem(name = "honninShikyuGaku", length = 10, order = 33)
    public RString honninShikyuGaku;
    @ReportItem(name = "over70HonninShikyuGaku", length = 10, order = 34)
    public RString over70HonninShikyuGaku;
    @ReportItem(name = "biko", order = 35)
    public RString biko;
    @ReportItem(name = "shikyuSeiriNO", length = 17, order = 36)
    public RString shikyuSeiriNO;
    @ReportItem(name = "List1_1", length = 16, order = 37)
    public RString List1_1;
    @ReportItem(name = "List1_2", length = 20, order = 38)
    public RString List1_2;
    @ReportItem(name = "List1_3", length = 12, order = 39)
    public RString List1_3;
    @ReportItem(name = "List1_4", length = 10, order = 40)
    public RString List1_4;
    @ReportItem(name = "List1_5", length = 20, order = 41)
    public RString List1_5;
    @ReportItem(name = "List1_6", length = 20, order = 42)
    public RString List1_6;
    @ReportItem(name = "List1_7", length = 13, order = 43)
    public RString List1_7;
    @ReportItem(name = "List1_8", length = 17, order = 44)
    public RString List1_8;
    @ReportItem(name = "List1_9", length = 13, order = 45)
    public RString List1_9;
    @ReportItem(name = "List1_10", length = 13, order = 46)
    public RString List1_10;
    @ReportItem(name = "List1_11", length = 13, order = 47)
    public RString List1_11;
    @ReportItem(name = "List1_12", length = 17, order = 48)
    public RString List1_12;
    @ReportItem(name = "List1_13", length = 13, order = 49)
    public RString List1_13;
    @ReportItem(name = "List1_14", length = 13, order = 50)
    public RString List1_14;
    @ReportItem(name = "Over70_Futangaku_Gokei", length = 13, order = 51)
    public RString Over70_Futangaku_Gokei;
    @ReportItem(name = "Over70_Shikyugaku_Gokei", length = 13, order = 52)
    public RString Over70_Shikyugaku_Gokei;
    @ReportItem(name = "Under70_Futangaku_Gokei", length = 13, order = 53)
    public RString Under70_Futangaku_Gokei;
    @ReportItem(name = "Futangaku_Gokei", length = 13, order = 54)
    public RString Futangaku_Gokei;
    @ReportItem(name = "Under70_Shikyugaku_Gokei", length = 13, order = 55)
    public RString Under70_Shikyugaku_Gokei;
    @ReportItem(name = "Shikyugaku_Gokei", length = 13, order = 56)
    public RString Shikyugaku_Gokei;
    @ReportItem(name = "yubinBango", length = 8, order = 57)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", length = 50, order = 58)
    public RString shozaichi;
    @ReportItem(name = "choshaBushoName", length = 50, order = 59)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", length = 20, order = 60)
    public RString tantoName;
    @ReportItem(name = "telNo", length = 20, order = 61)
    public RString telNo;
    @ReportItem(name = "denshiKoin", order = 62)
    public RString denshiKoin;
    @ReportItem(name = "shichosonmeisho1", length = 14, order = 63)
    public RString shichosonmeisho1;
    @ReportItem(name = "shichosonmeisho2", length = 18, order = 64)
    public RString shichosonmeisho2;
    @ReportItem(name = "kouin", length = 3, order = 65)
    public RString kouin;
    @ReportItem(name = "shuchomei", length = 15, order = 66)
    public RString shuchomei;
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
