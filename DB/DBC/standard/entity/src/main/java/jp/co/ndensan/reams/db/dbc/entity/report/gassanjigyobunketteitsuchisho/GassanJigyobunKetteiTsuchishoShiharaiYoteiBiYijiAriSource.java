/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBCMNN2003_事業分高額合算支給決定通知書（単）のReportSourceクラスです。
 *
 * @reamsid_L DBC-4850-030 dongqianjing
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiAriSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tsuchibun6", order = 1)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", order = 2)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun4", order = 3)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", order = 4)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun3", order = 5)
    public RString tsuchibun3;
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
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 40)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 41)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 42)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 43)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 44)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 45)
    public RString koinShoryaku;
    @ReportItem(name = "title", length = 70, order = 46)
    public RString title;
    @ReportItem(name = "title2_1", length = 10, order = 47)
    public RString title2_1;
    @ReportItem(name = "title221", length = 2, order = 48)
    public RString title221;
    @ReportItem(name = "title222", length = 2, order = 49)
    public RString title222;
    @ReportItem(name = "title231", length = 5, order = 50)
    public RString title231;
    @ReportItem(name = "title232", length = 5, order = 51)
    public RString title232;
    @ReportItem(name = "title24", length = 5, order = 52)
    public RString title24;
    @ReportItem(name = "tsuchibun1", order = 53)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaName", order = 54)
    public RString hihokenshaName;
    @ReportItem(name = "hihoNo1", length = 1, order = 55)
    public RString hihoNo1;
    @ReportItem(name = "hihoNo2", length = 1, order = 56)
    public RString hihoNo2;
    @ReportItem(name = "hihoNo3", length = 1, order = 57)
    public RString hihoNo3;
    @ReportItem(name = "hihoNo4", length = 1, order = 58)
    public RString hihoNo4;
    @ReportItem(name = "hihoNo5", length = 1, order = 59)
    public RString hihoNo5;
    @ReportItem(name = "hihoNo6", length = 1, order = 60)
    public RString hihoNo6;
    @ReportItem(name = "hihoNo7", length = 1, order = 61)
    public RString hihoNo7;
    @ReportItem(name = "hihoNo8", length = 1, order = 62)
    public RString hihoNo8;
    @ReportItem(name = "hihoNo9", length = 1, order = 63)
    public RString hihoNo9;
    @ReportItem(name = "hihoNo10", length = 1, order = 64)
    public RString hihoNo10;
    @ReportItem(name = "taisyoStYm", length = 8, order = 65)
    public RString taisyoStYm;
    @ReportItem(name = "taisyoEdYm", length = 8, order = 66)
    public RString taisyoEdYm;
    @ReportItem(name = "shinseiYmd", length = 11, order = 67)
    public RString shinseiYmd;
    @ReportItem(name = "shiharaiGaku", length = 14, order = 68)
    public RString shiharaiGaku;
    @ReportItem(name = "ketteiYmd", length = 11, order = 69)
    public RString ketteiYmd;
    @ReportItem(name = "kekka", length = 30, order = 70)
    public RString kekka;
    @ReportItem(name = "shikyuGakuTitle", length = 8, order = 71)
    public RString shikyuGakuTitle;
    @ReportItem(name = "shikyuGaku", length = 14, order = 72)
    public RString shikyuGaku;
    @ReportItem(name = "kyuhuShu", length = 76, order = 73)
    public RString kyuhuShu;
    @ReportItem(name = "kyuhuShu2", length = 76, order = 74)
    public RString kyuhuShu2;
    @ReportItem(name = "kyuhuShu3", length = 76, order = 75)
    public RString kyuhuShu3;
    @ReportItem(name = "riyu", length = 12, order = 76)
    public RString riyu;
    @ReportItem(name = "riyu1", length = 76, order = 77)
    public RString riyu1;
    @ReportItem(name = "riyu2", length = 76, order = 78)
    public RString riyu2;
    @ReportItem(name = "riyu3", length = 76, order = 79)
    public RString riyu3;
    @ReportItem(name = "torikeshi1", length = 14, order = 80)
    public RString torikeshi1;
    @ReportItem(name = "torikeshi2", length = 14, order = 81)
    public RString torikeshi2;
    @ReportItem(name = "mochimono1", length = 30, order = 82)
    public RString mochimono1;
    @ReportItem(name = "bankName", order = 83)
    public RString bankName;
    @ReportItem(name = "mochimono2", length = 30, order = 84)
    public RString mochimono2;
    @ReportItem(name = "mochimono3", length = 30, order = 85)
    public RString mochimono3;
    @ReportItem(name = "bankShiten", order = 86)
    public RString bankShiten;
    @ReportItem(name = "maBasho1", length = 32, order = 87)
    public RString maBasho1;
    @ReportItem(name = "maBasho2", length = 32, order = 88)
    public RString maBasho2;
    @ReportItem(name = "shumokuTitle", length = 8, order = 89)
    public RString shumokuTitle;
    @ReportItem(name = "kouzaShu", length = 30, order = 90)
    public RString kouzaShu;
    @ReportItem(name = "maBasho3", length = 32, order = 91)
    public RString maBasho3;
    @ReportItem(name = "maBasho4", length = 32, order = 92)
    public RString maBasho4;
    @ReportItem(name = "bangoTitle", length = 8, order = 93)
    public RString bangoTitle;
    @ReportItem(name = "kouzaNo1", length = 10, order = 94)
    public RString kouzaNo1;
    @ReportItem(name = "maStYmd", length = 17, order = 95)
    public RString maStYmd;
    @ReportItem(name = "kouzaMeigi", length = 30, order = 96)
    public RString kouzaMeigi;
    @ReportItem(name = "maEdYmd", length = 14, order = 97)
    public RString maEdYmd;
    @ReportItem(name = "sihaYoYmd", length = 11, order = 98)
    public RString sihaYoYmd;
    @ReportItem(name = "maStJikan", length = 12, order = 99)
    public RString maStJikan;
    @ReportItem(name = "kara2", length = 2, order = 100)
    public RString kara2;
    @ReportItem(name = "maEdJikan", length = 12, order = 101)
    public RString maEdJikan;
    @ReportItem(name = "tsuchibun2", order = 102)
    public RString tsuchibun2;
    @ReportItem(name = "tsuchiNo", length = 17, order = 103)
    public RString tsuchiNo;
    @ReportItem(name = "tsuban", length = 6, order = 104)
    public RString tsuban;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
