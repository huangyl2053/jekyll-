package jp.co.ndensan.reams.db.dbe.entity.report.dbe581001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票「要介護認定延期通知書タイトル」の項目を定義するクラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public class YokaigoNinteiEnkiTshuchishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tsuchibun3", order = 1)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", order = 2)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", order = 3)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", order = 4)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", order = 5)
    public RString tsuchibun7;
    @ReportItem(name = "yubinNo", length = 8, order = 6)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 7)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 8)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 9)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 10)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 11)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 12)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 13)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 14)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 15)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 16)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 17)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 18)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 19)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 20)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 21)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 22)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 23)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 24)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 25)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 26)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 27)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 28)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 29)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 30)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 31)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 32)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 33)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 34)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 35)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 36)
    public RString customerBarCode;
    @ReportItem(name = "hakkoYMD", length = 11, order = 37)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 38)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 39)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 40)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 41)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 42)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 43)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 44)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 45)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 46)
    public RString bunshoNo;
    @ReportItem(name = "nendo", length = 7, order = 47)
    public RString nendo;
    @ReportItem(name = "title", length = 50, order = 48)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 49)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaName", order = 50)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 51)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 52)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 53)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 54)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 55)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 56)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 57)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 58)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 59)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 60)
    public RString hihokenshaNo10;
    @ReportItem(name = "riyu1", order = 61)
    public RString riyu1;
    @ReportItem(name = "shoriMikomiKaishiYMD", length = 11, order = 62)
    public RString shoriMikomiKaishiYMD;
    @ReportItem(name = "shoriMikomiShuryoYMD", length = 11, order = 63)
    public RString shoriMikomiShuryoYMD;
    @ReportItem(name = "tsuchibun2", order = 64)
    public RString tsuchibun2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "001")
    public RString shikibetsuCode;
    @ReportExpandedInfo(id = "001", code = "0003", name = "被保番号")
    public RString hihokenshaNo;
// </editor-fold>
}
