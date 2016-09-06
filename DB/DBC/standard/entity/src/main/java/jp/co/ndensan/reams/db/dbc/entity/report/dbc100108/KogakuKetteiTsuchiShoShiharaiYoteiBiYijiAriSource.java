/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.dbc100108;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 高額サービス等支給（不支給）決定通知書(支払予定日あり)のReportSource
 *
 * @reamsid_L DBC-5160-040 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "sakuseiYmd", length = 11, order = 2)
    public RString sakuseiYmd;
    @ReportItem(name = "testPrint", length = 5, order = 3)
    public RString testPrint;
    @ReportItem(name = "title", length = 70, order = 4)
    public RString title;
    @ReportItem(name = "title2_1", length = 11, order = 5)
    public RString title2_1;
    @ReportItem(name = "title2_2_1", length = 2, order = 6)
    public RString title2_2_1;
    @ReportItem(name = "title2_2_2", length = 2, order = 7)
    public RString title2_2_2;
    @ReportItem(name = "title2_3_1", length = 5, order = 8)
    public RString title2_3_1;
    @ReportItem(name = "title2_3_2", length = 5, order = 9)
    public RString title2_3_2;
    @ReportItem(name = "title2_4", length = 5, order = 10)
    public RString title2_4;
    @ReportItem(name = "title3_1", length = 11, order = 11)
    public RString title3_1;
    @ReportItem(name = "title3_2_1", length = 2, order = 12)
    public RString title3_2_1;
    @ReportItem(name = "title3_2_2", length = 2, order = 13)
    public RString title3_2_2;
    @ReportItem(name = "title3_3_1", length = 5, order = 14)
    public RString title3_3_1;
    @ReportItem(name = "title3_3_2", length = 5, order = 15)
    public RString title3_3_2;
    @ReportItem(name = "title3_4", length = 5, order = 16)
    public RString title3_4;
    @ReportItem(name = "tsuchibun1", order = 17)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaName", order = 18)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 19)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 20)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 21)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 22)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 23)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 24)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 25)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 26)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 27)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 28)
    public RString hihokenshaNo10;
    @ReportItem(name = "uketsukeYMD", length = 11, order = 29)
    public RString uketsukeYMD;
    @ReportItem(name = "ketteiYMD", length = 11, order = 30)
    public RString ketteiYMD;
    @ReportItem(name = "honninShiharaiGaku", length = 14, order = 31)
    public RString honninShiharaiGaku;
    @ReportItem(name = "taishoYM", length = 11, order = 32)
    public RString taishoYM;
    @ReportItem(name = "kyufuShu1", length = 76, order = 33)
    public RString kyufuShu1;
    @ReportItem(name = "kyufuShu2", length = 76, order = 34)
    public RString kyufuShu2;
    @ReportItem(name = "kyufuShu3", length = 76, order = 35)
    public RString kyufuShu3;
    @ReportItem(name = "ketteiGaku", length = 8, order = 36)
    public RString ketteiGaku;
    @ReportItem(name = "kekka", length = 30, order = 37)
    public RString kekka;
    @ReportItem(name = "shikyuGaku", length = 14, order = 38)
    public RString shikyuGaku;
    @ReportItem(name = "riyuTitle", length = 12, order = 39)
    public RString riyuTitle;
    @ReportItem(name = "riyu1", length = 76, order = 40)
    public RString riyu1;
    @ReportItem(name = "riyu2", length = 76, order = 41)
    public RString riyu2;
    @ReportItem(name = "riyu3", length = 76, order = 42)
    public RString riyu3;
    @ReportItem(name = "torikeshi1", length = 14, order = 43)
    public RString torikeshi1;
    @ReportItem(name = "torikeshi2", length = 14, order = 44)
    public RString torikeshi2;
    @ReportItem(name = "mochimono1", length = 30, order = 45)
    public RString mochimono1;
    @ReportItem(name = "bankName", length = 30, order = 46)
    public RString bankName;
    @ReportItem(name = "torikeshiMochimono1", length = 12, order = 47)
    public RString torikeshiMochimono1;
    @ReportItem(name = "mochimono2", length = 30, order = 48)
    public RString mochimono2;
    @ReportItem(name = "torikeshiMochimono2", length = 12, order = 49)
    public RString torikeshiMochimono2;
    @ReportItem(name = "branchBankName", order = 50)
    public RString branchBankName;
    @ReportItem(name = "mochimono3", length = 30, order = 51)
    public RString mochimono3;
    @ReportItem(name = "shiharaiBasho", order = 52)
    public RString shiharaiBasho;
    @ReportItem(name = "torikeshiShiharaibasho", length = 12, order = 53)
    public RString torikeshiShiharaibasho;
    @ReportItem(name = "shumokuTitle", length = 8, order = 54)
    public RString shumokuTitle;
    @ReportItem(name = "kouzaShu", length = 30, order = 55)
    public RString kouzaShu;
    @ReportItem(name = "bangoTitle", length = 8, order = 56)
    public RString bangoTitle;
    @ReportItem(name = "kouzaNo", length = 10, order = 57)
    public RString kouzaNo;
    @ReportItem(name = "shiharaiStartYMD", length = 17, order = 58)
    public RString shiharaiStartYMD;
    @ReportItem(name = "torikeshiShiharaikikan", length = 12, order = 59)
    public RString torikeshiShiharaikikan;
    @ReportItem(name = "shiharaiEndYMD", length = 14, order = 60)
    public RString shiharaiEndYMD;
    @ReportItem(name = "kouzaMeigi", order = 61)
    public RString kouzaMeigi;
    @ReportItem(name = "shiharaiStartHMS", length = 12, order = 62)
    public RString shiharaiStartHMS;
    @ReportItem(name = "karaFugo", length = 2, order = 63)
    public RString karaFugo;
    @ReportItem(name = "shiharaiEndHMS", length = 12, order = 64)
    public RString shiharaiEndHMS;
    @ReportItem(name = "sihaYoYmd", length = 11, order = 65)
    public RString sihaYoYmd;
    @ReportItem(name = "toiawasesaki", order = 66)
    public RString toiawasesaki;
    @ReportItem(name = "tsuchiNo", length = 6, order = 67)
    public RString tsuchiNo;
    @ReportItem(name = "remban", length = 4, order = 68)
    public RString remban;
    @ReportItem(name = "tsuchibunLarge", order = 69)
    public RString tsuchibunLarge;
    @ReportItem(name = "tsuchibunMix1", order = 70)
    public RString tsuchibunMix1;
    @ReportItem(name = "tsuchibunMix2", order = 71)
    public RString tsuchibunMix2;
    @ReportItem(name = "tsuchibunMixTwo1", order = 72)
    public RString tsuchibunMixTwo1;
    @ReportItem(name = "tsuchibunMixTwo2", order = 73)
    public RString tsuchibunMixTwo2;
    @ReportItem(name = "gyoseiku", length = 14, order = 74)
    public RString gyoseiku;
    @ReportItem(name = "yubinNo", length = 8, order = 75)
    public RString yubinNo;
    @ReportItem(name = "jusho1", length = 20, order = 76)
    public RString jusho1;
    @ReportItem(name = "jushoText", order = 77)
    public RString jushoText;
    @ReportItem(name = "jusho2", length = 20, order = 78)
    public RString jusho2;
    @ReportItem(name = "jusho3", length = 20, order = 79)
    public RString jusho3;
    @ReportItem(name = "katagakiText", order = 80)
    public RString katagakiText;
    @ReportItem(name = "katagaki1", length = 20, order = 81)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 82)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki2", length = 20, order = 83)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 84)
    public RString katagakiSmall1;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 85)
    public RString meishoFuyo2;
    @ReportItem(name = "shimei1", length = 20, order = 86)
    public RString shimei1;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 87)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 88)
    public RString shimeiText;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 89)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 90)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei2", length = 20, order = 91)
    public RString shimei2;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 92)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 93)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 94)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 95)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 96)
    public RString kakkoLeft2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 97)
    public RString kakkoRight2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 98)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 99)
    public RString kakkoLeft1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 100)
    public RString kakkoRight1;
    @ReportItem(name = "samaBun1", length = 3, order = 101)
    public RString samaBun1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 102)
    public RString samabunShimei1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 103)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 104)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 105)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 106)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 107)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 108)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 109)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 110)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 111)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 112)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 113)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportExpandedInfo(id = "001", code = "0003", name = "被保険者番号_高額サービス等支給（不支給）決定通知書")
    public RString 被保険者番号;
// </editor-fold>
}
