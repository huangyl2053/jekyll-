package jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyooshirasetsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC100063_基準収入額適用お知らせ通知書 Sourceクラスです。
 *
 * @reamsid_L DBC-4640-050 lijian
 */
public class KijunShunyugakuTekiyoOshiraseTsuchishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "title", length = 45, order = 2)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 3)
    public RString tsuchibun1;
    @ReportItem(name = "hihoNameKana1", length = 40, order = 4)
    public RString hihoNameKana1;
    @ReportItem(name = "hihokenshaNo1", length = 10, order = 5)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaName1", order = 6)
    public RString hihokenshaName1;
    @ReportItem(name = "hihoNameKana2", length = 40, order = 7)
    public RString hihoNameKana2;
    @ReportItem(name = "hihokenshaNo2", length = 10, order = 8)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaName2", order = 9)
    public RString hihokenshaName2;
    @ReportItem(name = "hihoNameKana3", length = 40, order = 10)
    public RString hihoNameKana3;
    @ReportItem(name = "hihokenshaNo3", length = 10, order = 11)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaName3", order = 12)
    public RString hihokenshaName3;
    @ReportItem(name = "sonotaHihokensha", length = 15, order = 13)
    public RString sonotaHihokensha;
    @ReportItem(name = "tsuchibun2", order = 14)
    public RString tsuchibun2;
    @ReportItem(name = "yubinNo", length = 8, order = 15)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku1", length = 14, order = 16)
    public RString gyoseiku1;
    @ReportItem(name = "jusho4", length = 20, order = 17)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 18)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 19)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 20)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 21)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 22)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 23)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 24)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 25)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei3", length = 20, order = 26)
    public RString shimei3;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 27)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 28)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 29)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 30)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 31)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei4", length = 20, order = 32)
    public RString shimei4;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 33)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 34)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 35)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 36)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 37)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 38)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 39)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight1", length = 1, order = 40)
    public RString kakkoRight1;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 41)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 42)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 43)
    public RString samaBun1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 44)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 45)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 46)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 47)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 48)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 49)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 50)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 51)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 52)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 53)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 54)
    public RString koinShoryaku;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode1", length = 15)
    public RString shikibetsuCode1;
    @ReportPerson(id = "B")
    @ReportItem(name = "shikibetsuCode2", length = 15)
    public RString shikibetsuCode2;
    @ReportPerson(id = "C")
    @ReportItem(name = "shikibetsuCode3", length = 15)
    public RString shikibetsuCode3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報A1;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation 拡張情報A2;
    @ReportExpandedInfo(id = "B")
    public ExpandedInformation 拡張情報B1;
    @ReportExpandedInfo(id = "B")
    public ExpandedInformation 拡張情報B2;
    @ReportExpandedInfo(id = "C")
    public ExpandedInformation 拡張情報C1;
    @ReportExpandedInfo(id = "C")
    public ExpandedInformation 拡張情報C2;
}
