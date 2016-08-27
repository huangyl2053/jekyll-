package jp.co.ndensan.reams.db.dbd.entity.report.dbd100025;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 障がい者控除対象者認定証ReportSourceです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class NinteishoJohoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "tsuchiBun1", order = 2)
    public RString tsuchiBun1;
    @ReportItem(name = "shiseishaJusho", order = 3)
    public RString shiseishaJusho;
    @ReportItem(name = "shiseishaShimei", order = 4)
    public RString shiseishaShimei;
    @ReportItem(name = "hihokenshaJusho", order = 5)
    public RString hihokenshaJusho;
    @ReportItem(name = "seibetsu", length = 4, order = 6)
    public RString seibetsu;
    @ReportItem(name = "hihokenshaName", order = 7)
    public RString hihokenshaName;
    @ReportItem(name = "birthYMD", length = 11, order = 8)
    public RString birthYMD;
    @ReportItem(name = "shogaiRiyu", order = 9)
    public RString shogaiRiyu;
    @ReportItem(name = "ninteiYMD", length = 11, order = 10)
    public RString ninteiYMD;
    @ReportItem(name = "shiyoMokuteki", order = 11)
    public RString shiyoMokuteki;
    @ReportItem(name = "tsuchiBun2", order = 12)
    public RString tsuchiBun2;
    @ReportItem(name = "tsuchiBun3", order = 13)
    public RString tsuchiBun3;
    @ReportItem(name = "seibetsu1", length = 4, order = 14)
    public RString seibetsu1;
    @ReportItem(name = "hakkoYMD", length = 12, order = 15)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 16)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "denshiKoin", order = 17)
    public RString denshiKoin;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 18)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 19)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 20)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 21)
    public RString koinShoryaku;
    @ReportItem(name = "yubinNo", length = 8, order = 22)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 23)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 24)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 25)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 26)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 27)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 28)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 29)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 30)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 31)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 32)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 33)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 34)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 35)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 36)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 37)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 38)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 39)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 40)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 41)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 42)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 43)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 44)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 45)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 46)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 47)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 48)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 49)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 50)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 51)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 52)
    public RString customerBarCode;
    @ReportItem(name = "yubinBango", length = 8, order = 53)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 54)
    public RString shozaichi;
    @ReportItem(name = "choshaBushoName", order = 55)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", order = 56)
    public RString tantoName;
    @ReportItem(name = "telNo", length = 20, order = 57)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 58)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 59)
    public RString naisenNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "001")
    public RString shikibetsuCode;  // TODO 95838
    @ReportExpandedInfo(id = "001", code = "003", name = "被保険者番号")
    public RString hihokenshaNo;
// </editor-fold>
}
