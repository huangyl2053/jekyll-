package jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護保険料徴収猶予取消通知書 B5横タイプSourceするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "torikeshiYMD", length = 11, order = 2)
    public RString torikeshiYMD;
    @ReportItem(name = "torikeshiRiyu1", length = 30, order = 3)
    public RString torikeshiRiyu1;
    @ReportItem(name = "torikeshiRiyu2", length = 30, order = 4)
    public RString torikeshiRiyu2;
    @ReportItem(name = "listTorikeshiAtoNoki_1", length = 19, order = 5)
    public RString listTorikeshiAtoNoki_1;
    @ReportItem(name = "listKibetsu_1", length = 2, order = 6)
    public RString listKibetsu_1;
    @ReportItem(name = "listKibetsu_2", length = 2, order = 7)
    public RString listKibetsu_2;
    @ReportItem(name = "listKibetsu_3", length = 7, order = 8)
    public RString listKibetsu_3;
    @ReportItem(name = "listKibetsu_4", length = 2, order = 9)
    public RString listKibetsu_4;
    @ReportItem(name = "listKibetsu_5", length = 2, order = 10)
    public RString listKibetsu_5;
    @ReportItem(name = "listKibetsu_6", length = 7, order = 11)
    public RString listKibetsu_6;
    @ReportItem(name = "listKibetsu_7", length = 19, order = 12)
    public RString listKibetsu_7;
    @ReportItem(name = "listZuiji_1", length = 2, order = 13)
    public RString listZuiji_1;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 14)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 15)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 16)
    public RString hyojicodeName3;
    @ReportItem(name = "hyojicode1", length = 11, order = 17)
    public RString hyojicode1;
    @ReportItem(name = "hyojicode2", length = 9, order = 18)
    public RString hyojicode2;
    @ReportItem(name = "hyojicode3", length = 9, order = 19)
    public RString hyojicode3;
    @ReportItem(name = "tsuchishoNo", order = 20)
    public RString tsuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 21)
    public RString setaiCode;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 22)
    public RString hihokenshaNo;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 23)
    public RString shikibetsuCode;
    @ReportItem(name = "choteiNendo", length = 4, order = 24)
    public RString choteiNendo;
    @ReportItem(name = "fukaNendo", length = 4, order = 25)
    public RString fukaNendo;
    @ReportItem(name = "bikoTitle", order = 26)
    public RString bikoTitle;
    @ReportItem(name = "biko", order = 27)
    public RString biko;
    @ReportItem(name = "yubinNo", length = 8, order = 28)
    public RString yubinNo;
    @ReportItem(name = "gyoseiku", length = 14, order = 29)
    public RString gyoseiku;
    @ReportItem(name = "jusho3", length = 20, order = 30)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 31)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 32)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 33)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 34)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 35)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 36)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 37)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 38)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 39)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 40)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 41)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 42)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 43)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 44)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 45)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 46)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 47)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 48)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 49)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 50)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 51)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 52)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 53)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 54)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 55)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 56)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 57)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 58)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 59)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 60)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 61)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 62)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 63)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 64)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 65)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 66)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 67)
    public RString koinShoryaku;
    @ReportItem(name = "yubinBango", length = 8, order = 68)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 69)
    public RString shozaichi;
    @ReportItem(name = "choshaBushoName", order = 70)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", order = 71)
    public RString tantoName;
    @ReportItem(name = "telNo", length = 20, order = 72)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 73)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 74)
    public RString naisenNo;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
