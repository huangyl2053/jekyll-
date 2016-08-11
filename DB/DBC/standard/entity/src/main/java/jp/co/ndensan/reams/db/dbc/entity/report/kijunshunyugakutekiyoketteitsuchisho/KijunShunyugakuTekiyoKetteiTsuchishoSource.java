/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC100074_基準収入額適用決定通知書のReportSourceクラスです。
 *
 * @reamsid_L DBC-4610-040 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchishoSource implements IReportSource {

// <editor-fold defaultstate="collapsed" desc="Generated Code">
    public static final String ITEM_HIHOKENSHANO1 = "hihokenshaNo1";

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "title", length = 40, order = 2)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 3)
    public RString tsuchibun1;
    @ReportItem(name = "shinseiYMD", length = 11, order = 4)
    public RString shinseiYMD;
    @ReportItem(name = "ketteiYMD", length = 11, order = 5)
    public RString ketteiYMD;
    @ReportItem(name = "tekiyouStartYM", length = 8, order = 6)
    public RString tekiyouStartYM;
    @ReportItem(name = "santeiKijunGaku", length = 13, order = 7)
    public RString santeiKijunGaku;
    @ReportExpandedInfo(id = "A")
    @ReportItem(name = "hihokenshaNo1", length = 10, order = 8)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNameKana1", length = 40, order = 9)
    public RString hihokenshaNameKana1;
    @ReportExpandedInfo(id = "A")
    @ReportItem(name = "hihokenshaName1", order = 10)
    public RString hihokenshaName1;
    @ReportExpandedInfo(id = "B")
    @ReportItem(name = "hihokenshaNo2", length = 10, order = 11)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNameKana2", length = 40, order = 12)
    public RString hihokenshaNameKana2;
    @ReportExpandedInfo(id = "B")
    @ReportItem(name = "hihokenshaName2", order = 13)
    public RString hihokenshaName2;
    @ReportExpandedInfo(id = "C")
    @ReportItem(name = "hihokenshaNo3", length = 10, order = 14)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNameKana3", length = 40, order = 15)
    public RString hihokenshaNameKana3;
    @ReportExpandedInfo(id = "C")
    @ReportItem(name = "hihokenshaName3", order = 16)
    public RString hihokenshaName3;
    @ReportItem(name = "sonotaHihokensha", length = 15, order = 17)
    public RString sonotaHihokensha;
    @ReportItem(name = "tsuchibun2", order = 18)
    public RString tsuchibun2;
    @ReportItem(name = "tsuchibunLarge", order = 20)
    public RString tsuchibunLarge;
    @ReportItem(name = "tsuchibunMixTwo1", order = 21)
    public RString tsuchibunMixTwo1;
    @ReportItem(name = "tsuchibunMixTwo2", order = 22)
    public RString tsuchibunMixTwo2;
    @ReportItem(name = "tsuchibunMix1", order = 23)
    public RString tsuchibunMix1;
    @ReportItem(name = "tsuchibunMix2", order = 24)
    public RString tsuchibunMix2;
    @ReportItem(name = "yubinNo", length = 8, order = 25)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku2", length = 14, order = 26)
    public RString gyoseiku2;
    @ReportItem(name = "jusho4", length = 20, order = 27)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 28)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 29)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 30)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 31)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 32)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 33)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 34)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 35)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei5", length = 20, order = 36)
    public RString shimei5;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 37)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 38)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 39)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 40)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 41)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei6", length = 20, order = 42)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 43)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 44)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 45)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 46)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 47)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 48)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 49)
    public RString kakkoRight2;
    @ReportItem(name = "hakkoYMD", length = 12, order = 50)
    public RString hakkoYMD;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 51)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 52)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 53)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 54)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 55)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "denshiKoin", order = 56)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 57)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 58)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "customerBarCode", order = 59)
    public RString customerBarCode;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 60)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 61)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 62)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 63)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 64)
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
}
