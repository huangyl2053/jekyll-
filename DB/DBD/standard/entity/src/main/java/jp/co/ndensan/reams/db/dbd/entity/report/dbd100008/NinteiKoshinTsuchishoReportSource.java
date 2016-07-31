package jp.co.ndensan.reams.db.dbd.entity.report.dbd100008;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "title", length = 40, order = 2)
    public RString title;
    @ReportItem(name = "hihokenshaNameKana", length = 40, order = 3)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 4)
    @ReportExpandedInfo(id = "001", code = "003", name = "被保険者番号")
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "tsuchibun", order = 6)
    public RString tsuchibun;
    @ReportItem(name = "yubinNo", length = 8, order = 7)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku1", length = 14, order = 8)
    public RString gyoseiku1;
    @ReportItem(name = "jusho4", length = 20, order = 9)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 10)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 11)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 12)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 13)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 14)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 15)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 16)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 17)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei3", length = 20, order = 18)
    public RString shimei3;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 19)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 20)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 21)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 22)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 23)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei4", length = 20, order = 24)
    public RString shimei4;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 25)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 26)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 27)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 28)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 29)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 30)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 31)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 32)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 33)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 34)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 35)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 36)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 37)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 38)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 39)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 40)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 41)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 42)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 43)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 44)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 45)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 46)
    public RString koinShoryaku;
    @ReportPerson(id = "001")
    public ShikibetsuCode shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
