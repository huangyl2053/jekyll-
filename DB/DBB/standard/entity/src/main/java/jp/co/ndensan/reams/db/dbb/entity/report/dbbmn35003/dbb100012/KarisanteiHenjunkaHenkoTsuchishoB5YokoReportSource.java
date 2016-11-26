package jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票「特別徴収平準化【B5横タイプ】」の項目を定義するクラスです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "listKibetsu_1", length = 2, order = 2)
    public RString listKibetsu_1;
    @ReportItem(name = "listKibetsu_2", length = 2, order = 3)
    public RString listKibetsu_2;
    @ReportItem(name = "listKibetsu_3", length = 7, order = 4)
    public RString listKibetsu_3;
    @ReportItem(name = "listKibetsu_4", length = 7, order = 5)
    public RString listKibetsu_4;
    @ReportItem(name = "listKibetsu_5", length = 2, order = 6)
    public RString listKibetsu_5;
    @ReportItem(name = "listKibetsu_6", length = 2, order = 7)
    public RString listKibetsu_6;
    @ReportItem(name = "listKibetsu_7", length = 7, order = 8)
    public RString listKibetsu_7;
    @ReportItem(name = "listKibetsu_8", length = 7, order = 9)
    public RString listKibetsu_8;
    @ReportItem(name = "birthYMD", length = 11, order = 10)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 11)
    public RString seibetsu;
    @ReportItem(name = "hyojicodeName1", length = 8, order = 12)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 13)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 14)
    public RString hyojicodeName3;
    @ReportItem(name = "hyojicode1", length = 11, order = 15)
    public RString hyojicode1;
    @ReportItem(name = "hyojicode2", length = 9, order = 16)
    public RString hyojicode2;
    @ReportItem(name = "hyojicode3", length = 9, order = 17)
    public RString hyojicode3;
    @ReportItem(name = "tsuchishoNo", order = 18)
    public RString tsuchishoNo;
    @ReportItem(name = "setaiCode", length = 15, order = 19)
    public RString setaiCode;
    @ReportItem(name = "kongoNofuSubekiGaku", length = 7, order = 20)
    public RString kongoNofuSubekiGaku;
    @ReportItem(name = "mitoraikiNofuzumiGaku", length = 7, order = 21)
    public RString mitoraikiNofuzumiGaku;
    @ReportExpandedInfo(id = "本人")
    @ReportItem(name = "hihokenshaNo", length = 10, order = 22)
    public RString hihokenshaNo;
    @ReportPerson(id = "本人")
    @ReportItem(name = "shikibetsuCode", length = 15, order = 23)
    public RString shikibetsuCode;
    @ReportItem(name = "shutokuYMDMae", length = 10, order = 24)
    public RString shutokuYMDMae;
    @ReportItem(name = "shutokuYMDAto", length = 10, order = 25)
    public RString shutokuYMDAto;
    @ReportItem(name = "soshitsuYMDMae", length = 10, order = 26)
    public RString soshitsuYMDMae;
    @ReportItem(name = "soshitsuYMDAto", length = 10, order = 27)
    public RString soshitsuYMDAto;
    @ReportItem(name = "choteiNendo", length = 6, order = 28)
    public RString choteiNendo;
    @ReportItem(name = "bankCode", length = 7, order = 29)
    public RString bankCode;
    @ReportItem(name = "kozaNo", length = 14, order = 30)
    public RString kozaNo;
    @ReportItem(name = "title1", length = 15, order = 31)
    public RString title1;
    @ReportItem(name = "hokenryoGakuMae", length = 7, order = 32)
    public RString hokenryoGakuMae;
    @ReportItem(name = "hokenryoGakuAto", length = 7, order = 33)
    public RString hokenryoGakuAto;
    @ReportItem(name = "bankName", length = 20, order = 34)
    public RString bankName;
    @ReportItem(name = "title3", length = 14, order = 35)
    public RString title3;
    @ReportItem(name = "title2", length = 9, order = 36)
    public RString title2;
    @ReportItem(name = "zogenGaku", length = 7, order = 37)
    public RString zogenGaku;
    @ReportItem(name = "nokuzumiGaku", length = 7, order = 38)
    public RString nokuzumiGaku;
    @ReportItem(name = "kozaMeigi", length = 14, order = 39)
    public RString kozaMeigi;
    @ReportItem(name = "kozaShurui", length = 3, order = 40)
    public RString kozaShurui;
    @ReportItem(name = "koremadeChoshuho", length = 17, order = 41)
    public RString koremadeChoshuho;
    @ReportItem(name = "korekaraChoshuho", length = 17, order = 42)
    public RString korekaraChoshuho;
    @ReportItem(name = "koremadeTokuchoGimusha", length = 20, order = 43)
    public RString koremadeTokuchoGimusha;
    @ReportItem(name = "korekaraTokuchoGimusha", length = 20, order = 44)
    public RString korekaraTokuchoGimusha;
    @ReportItem(name = "koremadeTokuchoTaishoNenkin", length = 20, order = 45)
    public RString koremadeTokuchoTaishoNenkin;
    @ReportItem(name = "korekaraTokuchoTaishoNenkin", length = 20, order = 46)
    public RString korekaraTokuchoTaishoNenkin;
    @ReportItem(name = "zanteiHokenryoGaku", length = 6, order = 47)
    public RString zanteiHokenryoGaku;
    @ReportItem(name = "choteiJiyu1", length = 40, order = 48)
    public RString choteiJiyu1;
    @ReportItem(name = "choteiJiyu2", length = 40, order = 49)
    public RString choteiJiyu2;
    @ReportItem(name = "choteiJiyu3", length = 40, order = 50)
    public RString choteiJiyu3;
    @ReportItem(name = "choteiJiyu4", length = 40, order = 51)
    public RString choteiJiyu4;
    @ReportItem(name = "yubinNo1", length = 8, order = 52)
    public RString yubinNo1;
    @ReportItem(name = "gyoseiku1", length = 14, order = 53)
    public RString gyoseiku1;
    @ReportItem(name = "jusho3", length = 20, order = 54)
    public RString jusho3;
    @ReportItem(name = "jushoText", order = 55)
    public RString jushoText;
    @ReportItem(name = "jusho1", length = 20, order = 56)
    public RString jusho1;
    @ReportItem(name = "jusho2", length = 20, order = 57)
    public RString jusho2;
    @ReportItem(name = "katagakiText", order = 58)
    public RString katagakiText;
    @ReportItem(name = "katagaki2", length = 20, order = 59)
    public RString katagaki2;
    @ReportItem(name = "katagakiSmall2", length = 30, order = 60)
    public RString katagakiSmall2;
    @ReportItem(name = "katagaki1", length = 20, order = 61)
    public RString katagaki1;
    @ReportItem(name = "katagakiSmall1", length = 30, order = 62)
    public RString katagakiSmall1;
    @ReportItem(name = "shimei2", length = 20, order = 63)
    public RString shimei2;
    @ReportItem(name = "shimeiSmall2", length = 40, order = 64)
    public RString shimeiSmall2;
    @ReportItem(name = "shimeiText", order = 65)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo2", length = 3, order = 66)
    public RString meishoFuyo2;
    @ReportItem(name = "shimeiSmall1", length = 40, order = 67)
    public RString shimeiSmall1;
    @ReportItem(name = "dainoKubunMei", length = 8, order = 68)
    public RString dainoKubunMei;
    @ReportItem(name = "shimei1", length = 20, order = 69)
    public RString shimei1;
    @ReportItem(name = "meishoFuyo1", length = 3, order = 70)
    public RString meishoFuyo1;
    @ReportItem(name = "samabunShimeiText", order = 71)
    public RString samabunShimeiText;
    @ReportItem(name = "samaBun2", length = 3, order = 72)
    public RString samaBun2;
    @ReportItem(name = "samabunShimeiSmall2", length = 40, order = 73)
    public RString samabunShimeiSmall2;
    @ReportItem(name = "kakkoRight2", length = 1, order = 74)
    public RString kakkoRight2;
    @ReportItem(name = "kakkoLeft2", length = 1, order = 75)
    public RString kakkoLeft2;
    @ReportItem(name = "samabunShimei2", length = 20, order = 76)
    public RString samabunShimei2;
    @ReportItem(name = "kakkoRight1", length = 1, order = 77)
    public RString kakkoRight1;
    @ReportItem(name = "kakkoLeft1", length = 1, order = 78)
    public RString kakkoLeft1;
    @ReportItem(name = "samabunShimei1", length = 20, order = 79)
    public RString samabunShimei1;
    @ReportItem(name = "samaBun1", length = 3, order = 80)
    public RString samaBun1;
    @ReportItem(name = "samabunShimeiSmall1", length = 40, order = 81)
    public RString samabunShimeiSmall1;
    @ReportItem(name = "customerBarCode", order = 82)
    public RString customerBarCode;
    @ReportItem(name = "denshiKoin", order = 83)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 84)
    public RString hakkoYMD;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 85)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 86)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 87)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 88)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 89)
    public RString koinShoryaku;
    @ReportItem(name = "yubinBango", length = 8, order = 90)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 91)
    public RString shozaichi;
    @ReportItem(name = "tantoName", order = 92)
    public RString tantoName;
    @ReportItem(name = "choshaBushoName", order = 93)
    public RString choshaBushoName;
    @ReportItem(name = "telNo", length = 20, order = 94)
    public RString telNo;
    @ReportItem(name = "naisenNo", length = 20, order = 95)
    public RString naisenNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 96)
    public RString naisenLabel;
    @ReportItem(name = "kongoNofuSubekigakuChotei", order = 97)
    public RString kongoNofuSubekigakuChotei;
    @ReportItem(name = "nofuSubekiGaku", order = 98)
    public RString nofuSubekiGaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
