/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.report.dbd511001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 認定更新お知らせ通知書ReportSourceです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public class KoshinShinseiOshiraseTshuchishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "yubinNo", length = 8, order = 1)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 2)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 3)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 4)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 5)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 6)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 7)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 8)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 9)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 10)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 11)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 12)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 13)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 14)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 15)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 16)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 17)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 18)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 19)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 20)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 21)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 22)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 23)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 24)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 25)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 26)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 27)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 28)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 29)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 30)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 31)
    public RString customerBarCode;
    @ReportItem(name = "hakkoYMD1", length = 12, order = 32)
    public RString hakkoYMD1;
    @ReportItem(name = "denshiKoin", order = 33)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 34)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 35)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 36)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 37)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 38)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 39)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 40)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 41)
    public RString bunshoNo;
    @ReportItem(name = "title", length = 50, order = 42)
    public RString title;
    @ReportItem(name = "tsuchibun1", order = 43)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaNameKana", order = 44)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 45)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 46)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 47)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 48)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 49)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 50)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 51)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 52)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 53)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 54)
    public RString hihokenshaNo10;
    @ReportItem(name = "hihokenshaName", order = 55)
    public RString hihokenshaName;
    @ReportItem(name = "yokaigoNinteiKaishoYMD", length = 11, order = 56)
    public RString yokaigoNinteiKaishoYMD;
    @ReportItem(name = "yokaigoNinteiShuryoYMD", length = 11, order = 57)
    public RString yokaigoNinteiShuryoYMD;
    @ReportItem(name = "yokaigoJotaiKubun", length = 6, order = 58)
    public RString yokaigoJotaiKubun;
    @ReportItem(name = "tsuchibun2", order = 59)
    public RString tsuchibun2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportExpandedInfo(id = "001", code = "003", name = "被保険者番号")
    public RString 被保険者番号;
// </editor-fold>
}
