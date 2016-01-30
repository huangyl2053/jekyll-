/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class ShokanKetteiTsuchiShoSealerReportSource implements IReportSource {
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
    @ReportItem(name = "ｔｉtle", length = 20, order = 6)
    public RString ｔｉtle;
    @ReportItem(name = "ｔｉtle2", length = 20, order = 7)
    public RString ｔｉtle2;
    @ReportItem(name = "hihokenshaName2", length = 17, order = 8)
    public RString hihokenshaName2;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 9)
    public RString hihokenshaNo;
    @ReportItem(name = "hihokenshaName", order = 10)
    public RString hihokenshaName;
    @ReportItem(name = "tsuchibun", order = 11)
    public RString tsuchibun;
    @ReportItem(name = "ketteiYMD", length = 11, order = 12)
    public RString ketteiYMD;
    @ReportItem(name = "shiharaiGaku", length = 10, order = 13)
    public RString shiharaiGaku;
    @ReportItem(name = "shiharaiYoteiYMD", length = 11, order = 14)
    public RString shiharaiYoteiYMD;
    @ReportItem(name = "kyufuShurui1", length = 8, order = 15)
    public RString kyufuShurui1;
    @ReportItem(name = "taishoYM1", length = 8, order = 16)
    public RString taishoYM1;
    @ReportItem(name = "shikyuGaku1", length = 13, order = 17)
    public RString shikyuGaku1;
    @ReportItem(name = "yen1", length = 1, order = 18)
    public RString yen1;
    @ReportItem(name = "info", order = 19)
    public RString info;
    @ReportItem(name = "kyufuShurui2", length = 8, order = 20)
    public RString kyufuShurui2;
    @ReportItem(name = "taishoYM2", length = 8, order = 21)
    public RString taishoYM2;
    @ReportItem(name = "shikyuGaku2", length = 13, order = 22)
    public RString shikyuGaku2;
    @ReportItem(name = "yen2", length = 1, order = 23)
    public RString yen2;
    @ReportItem(name = "kyufuShurui3", length = 8, order = 24)
    public RString kyufuShurui3;
    @ReportItem(name = "taishoYM3", length = 8, order = 25)
    public RString taishoYM3;
    @ReportItem(name = "shikyuGaku3", length = 13, order = 26)
    public RString shikyuGaku3;
    @ReportItem(name = "yen3", length = 1, order = 27)
    public RString yen3;
    @ReportItem(name = "kyufuShurui4", length = 8, order = 28)
    public RString kyufuShurui4;
    @ReportItem(name = "taishoYM4", length = 8, order = 29)
    public RString taishoYM4;
    @ReportItem(name = "shikyuGaku4", length = 13, order = 30)
    public RString shikyuGaku4;
    @ReportItem(name = "yen4", length = 1, order = 31)
    public RString yen4;
    @ReportItem(name = "bankName", length = 30, order = 32)
    public RString bankName;
    @ReportItem(name = "branchBankName", order = 33)
    public RString branchBankName;
    @ReportItem(name = "shumokuTitle", length = 4, order = 34)
    public RString shumokuTitle;
    @ReportItem(name = "kouzaShu", length = 6, order = 35)
    public RString kouzaShu;
    @ReportItem(name = "bangoTitle", length = 4, order = 36)
    public RString bangoTitle;
    @ReportItem(name = "kouzaNo", length = 10, order = 37)
    public RString kouzaNo;
    @ReportItem(name = "kouzaMeigi", order = 38)
    public RString kouzaMeigi;
    @ReportItem(name = "yubinNo", length = 8, order = 39)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku2", length = 14, order = 40)
    public RString gyoseiku2;
    @ReportItem(name = "jusho4", length = 20, order = 41)
    public RString jusho4;
    @ReportItem(name = "jushoText", order = 42)
    public RString jushoText;
    @ReportItem(name = "jusho5", length = 20, order = 43)
    public RString jusho5;
    @ReportItem(name = "jusho6", length = 20, order = 44)
    public RString jusho6;
    @ReportItem(name = "katagakiText", order = 45)
    public RString katagakiText;
    @ReportItem(name = "katagaki3", length = 20, order = 46)
    public RString katagaki3;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 47)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki4", length = 20, order = 48)
    public RString katagaki4;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 49)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei5", length = 20, order = 50)
    public RString shimei5;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 51)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 52)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 53)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 54)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 55)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei6", length = 20, order = 56)
    public RString shimei6;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 57)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 58)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 59)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 60)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 61)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 62)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 63)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 64)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 65)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 66)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 67)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 68)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 69)
    public RString customerBarCode;
    @ReportItem(name = "hakkoYMD", length = 12, order = 70)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 71)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 72)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 73)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 74)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 75)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 76)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 77)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 78)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
