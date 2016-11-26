package jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票「仮算定額変更【A4縦タイプ】」の項目を定義するクラスです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenkoTsuchishoA4TateReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "title1", length = 6, order = 2)
    public RString title1;
    @ReportItem(name = "title2", length = 24, order = 3)
    public RString title2;
    @ReportItem(name = "choteiNendo", length = 6, order = 4)
    public RString choteiNendo;
    @ReportItem(name = "title3", length = 14, order = 5)
    public RString title3;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 6)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 7)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 8)
    public RString hyojicodeName3;
    @ReportItem(name = "hyojicode1", length = 11, order = 9)
    public RString hyojicode1;
    @ReportItem(name = "hyojicode2", length = 9, order = 10)
    public RString hyojicode2;
    @ReportItem(name = "hyojicode3", length = 9, order = 11)
    public RString hyojicode3;
    @ReportItem(name = "setaiCode", length = 15, order = 12)
    public RString setaiCode;
    @ReportItem(name = "tsuchishoNo", order = 13)
    public RString tsuchishoNo;
    @ReportItem(name = "zanteiHokenryoGaku", length = 6, order = 14)
    public RString zanteiHokenryoGaku;
    @ReportExpandedInfo(id = "本人")
    @ReportItem(name = "hihokenshaNo", length = 10, order = 15)
    public RString hihokenshaNo;
    @ReportPerson(id = "本人")
    @ReportItem(name = "shikibetsuCode", length = 15, order = 16)
    public RString shikibetsuCode;
    @ReportItem(name = "shutokuYMDMae", length = 10, order = 17)
    public RString shutokuYMDMae;
    @ReportItem(name = "soshitsuYMDMae", length = 10, order = 18)
    public RString soshitsuYMDMae;
    @ReportItem(name = "hokenryoGakuMae", length = 7, order = 19)
    public RString hokenryoGakuMae;
    @ReportItem(name = "shutokuYMDAto", length = 10, order = 20)
    public RString shutokuYMDAto;
    @ReportItem(name = "soshitsuYMDAto", length = 10, order = 21)
    public RString soshitsuYMDAto;
    @ReportItem(name = "hokenryoGakuAto", length = 7, order = 22)
    public RString hokenryoGakuAto;
    @ReportItem(name = "zogenGaku", length = 7, order = 23)
    public RString zogenGaku;
    @ReportItem(name = "koseigoHokenryoGaku", length = 7, order = 24)
    public RString koseigoHokenryoGaku;
    @ReportItem(name = "nofuzumiGaku", length = 7, order = 25)
    public RString nofuzumiGaku;
    @ReportItem(name = "kongoNofusubekiGaku", length = 7, order = 26)
    public RString kongoNofusubekiGaku;
    @ReportItem(name = "korekaraChoshuho", length = 17, order = 27)
    public RString korekaraChoshuho;
    @ReportItem(name = "listKibetsu_1", length = 2, order = 28)
    public RString listKibetsu_1;
    @ReportItem(name = "listKibetsu_2", length = 2, order = 29)
    public RString listKibetsu_2;
    @ReportItem(name = "listKibetsu_3", length = 11, order = 30)
    public RString listKibetsu_3;
    @ReportItem(name = "listKibetsu_4", length = 7, order = 31)
    public RString listKibetsu_4;
    @ReportItem(name = "listKibetsu_5", length = 7, order = 32)
    public RString listKibetsu_5;
    @ReportItem(name = "listKibetsu_6", length = 2, order = 33)
    public RString listKibetsu_6;
    @ReportItem(name = "listKibetsu_7", length = 2, order = 34)
    public RString listKibetsu_7;
    @ReportItem(name = "listKibetsu_8", length = 7, order = 35)
    public RString listKibetsu_8;
    @ReportItem(name = "listKibetsu_9", length = 7, order = 36)
    public RString listKibetsu_9;
    @ReportItem(name = "bankCode", length = 7, order = 37)
    public RString bankCode;
    @ReportItem(name = "bankName", length = 20, order = 38)
    public RString bankName;
    @ReportItem(name = "korekaraTokuchoGimusha", length = 20, order = 39)
    public RString korekaraTokuchoGimusha;
    @ReportItem(name = "korekaraTokuchoTaishoNenkin", length = 20, order = 40)
    public RString korekaraTokuchoTaishoNenkin;
    @ReportItem(name = "kozaShurui", length = 3, order = 41)
    public RString kozaShurui;
    @ReportItem(name = "kozaNo", length = 14, order = 42)
    public RString kozaNo;
    @ReportItem(name = "kozaMeigi", length = 14, order = 43)
    public RString kozaMeigi;
    @ReportItem(name = "choteiJiyu1", length = 30, order = 44)
    public RString choteiJiyu1;
    @ReportItem(name = "choteiJiyu2", length = 30, order = 45)
    public RString choteiJiyu2;
    @ReportItem(name = "choteiJiyu3", length = 30, order = 46)
    public RString choteiJiyu3;
    @ReportItem(name = "choteiJiyu4", length = 30, order = 47)
    public RString choteiJiyu4;
    @ReportItem(name = "yubinNo1", length = 8, order = 48)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 49)
    public RString gyoseiku1;
    @ReportItem(name = "jusho3", length = 20, order = 50)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 51)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 52)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 53)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 54)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 55)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 56)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 57)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 58)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 59)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 60)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 61)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 62)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 63)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 64)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 65)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 66)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 67)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 68)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 69)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 70)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 71)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 72)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 73)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 74)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 75)
    public RString samaBun1;
    @ReportItem(name = "kakkoRight1", length = 1, order = 76)
    public RString kakkoRight1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 77)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 78)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 79)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 80)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 81)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 82)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 83)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 84)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 85)
    public RString koinShoryaku;
    @ReportItem(name = "yubinBango", length = 8, order = 86)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 87)
    public RString shozaichi;
    @ReportItem(name = "tantoName", order = 88)
    public RString tantoName;
    @ReportItem(name = "choshaBushoName", order = 89)
    public RString choshaBushoName;
    @ReportItem(name = "naisenLabel", length = 4, order = 90)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 91)
    public RString naisenNo;
    @ReportItem(name = "telNo", length = 20, order = 92)
    public RString telNo;
    @ReportItem(name = "kongoNofuSubakiGakuChotei", order = 93)
    public RString kongoNofuSubakiGakuChotei;
    @ReportItem(name = "nofuSubekiGaku", order = 94)
    public RString nofuSubekiGaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
