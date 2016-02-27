package jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票　保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】連帳納付書の項目を定義するクラスです。
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kamokumei", order = 1)
    public RString kamokumei;
    @ReportItem(name = "ryoshushoNendo1", order = 2)
    public RString ryoshushoNendo1;
    @ReportItem(name = "ryoshushoNendo2", order = 3)
    public RString ryoshushoNendo2;
    @ReportItem(name = "nendoNenbun", order = 4)
    public RString nendoNenbun;
    @ReportItem(name = "kibetsu", order = 5)
    public RString kibetsu;
    @ReportItem(name = "ryoshushoNenbun1", order = 6)
    public RString ryoshushoNenbun1;
    @ReportItem(name = "ryoshushoNenbun2", order = 7)
    public RString ryoshushoNenbun2;
    @ReportItem(name = "gokeigaku", length = 15, order = 8)
    public RString gokeigaku;
    @ReportItem(name = "shunoKikanBango1", length = 5, order = 9)
    public RString shunoKikanBango1;
    @ReportItem(name = "nofuBango", length = 20, order = 10)
    public RString nofuBango;
    @ReportItem(name = "kakuninBango1", length = 5, order = 11)
    public RString kakuninBango1;
    @ReportItem(name = "nofuKubun1", length = 3, order = 12)
    public RString nofuKubun1;
    @ReportItem(name = "shunoKikanBango2", length = 5, order = 13)
    public RString shunoKikanBango2;
    @ReportItem(name = "kakuninBango2", length = 5, order = 14)
    public RString kakuninBango2;
    @ReportItem(name = "nofuKubun2", length = 3, order = 15)
    public RString nofuKubun2;
    @ReportItem(name = "nokigenTitle", length = 12, order = 16)
    public RString nokigenTitle;
    @ReportItem(name = "ocrId1", length = 3, order = 17)
    public RString ocrId1;
    @ReportItem(name = "ocrId2", length = 3, order = 18)
    public RString ocrId2;
    @ReportItem(name = "tsuchishoNo", length = 20, order = 19)
    public RString tsuchishoNo;
    @ReportItem(name = "nokigenYmd", length = 16, order = 20)
    public RString nokigenYmd;
    @ReportItem(name = "hakkoYmd", length = 16, order = 21)
    public RString hakkoYmd;
    @ReportItem(name = "honzei", length = 15, order = 22)
    public RString honzei;
    @ReportItem(name = "tokusokuTesuryo", length = 5, order = 23)
    public RString tokusokuTesuryo;
    @ReportItem(name = "ocr11", length = 39, order = 24)
    public RString ocr11;
    @ReportItem(name = "ocrCut1", length = 1, order = 25)
    public RString ocrCut1;
    @ReportItem(name = "ocr12", length = 39, order = 26)
    public RString ocr12;
    @ReportItem(name = "ocrCut2", length = 1, order = 27)
    public RString ocrCut2;
    @ReportItem(name = "entaikin", length = 15, order = 28)
    public RString entaikin;
    @ReportItem(name = "ocr21", length = 44, order = 29)
    public RString ocr21;
    @ReportItem(name = "ocr22", length = 44, order = 30)
    public RString ocr22;
    @ReportItem(name = "shimei", order = 31)
    public RString shimei;
    @ReportItem(name = "biko11", length = 30, order = 32)
    public RString biko11;
    @ReportItem(name = "biko12", length = 30, order = 33)
    public RString biko12;
    @ReportItem(name = "biko21", length = 30, order = 34)
    public RString biko21;
    @ReportItem(name = "biko22", length = 30, order = 35)
    public RString biko22;
    @ReportItem(name = "gimushaShimei", order = 36)
    public RString gimushaShimei;
    @ReportItem(name = "barcodeCvsBarcode1", order = 37)
    public RString barcodeCvsBarcode1;
    @ReportItem(name = "barcodeCvsBarcode2", order = 38)
    public RString barcodeCvsBarcode2;
    @ReportItem(name = "cvsBarcodeNaiyo11", length = 33, order = 39)
    public RString cvsBarcodeNaiyo11;
    @ReportItem(name = "cvsBarcodeNaiyo12", length = 33, order = 40)
    public RString cvsBarcodeNaiyo12;
    @ReportItem(name = "cvsBarcodeNaiyo21", length = 33, order = 41)
    public RString cvsBarcodeNaiyo21;
    @ReportItem(name = "cvsBarcodeNaiyo22", length = 33, order = 42)
    public RString cvsBarcodeNaiyo22;
    @ReportItem(name = "cvsToriatsukaikigen1", length = 16, order = 43)
    public RString cvsToriatsukaikigen1;
    @ReportItem(name = "cvsToriatsukaikigen2", length = 16, order = 44)
    public RString cvsToriatsukaikigen2;
    @ReportItem(name = "funyuFukanBango1", length = 12, order = 45)
    public RString funyuFukanBango1;
    @ReportItem(name = "funyuFukanBango2", length = 12, order = 46)
    public RString funyuFukanBango2;
    @ReportItem(name = "ryoshushoNendo3", order = 47)
    public RString ryoshushoNendo3;
    @ReportItem(name = "ryoshushoNendo4", order = 48)
    public RString ryoshushoNendo4;
    @ReportItem(name = "ryoshushoNenbun3", order = 49)
    public RString ryoshushoNenbun3;
    @ReportItem(name = "ryoshushoNenbun4", order = 50)
    public RString ryoshushoNenbun4;
    @ReportItem(name = "shunoKikanBango3", length = 5, order = 51)
    public RString shunoKikanBango3;
    @ReportItem(name = "kakuninBango3", length = 5, order = 52)
    public RString kakuninBango3;
    @ReportItem(name = "nofuKubun3", length = 3, order = 53)
    public RString nofuKubun3;
    @ReportItem(name = "shunoKikanBango4", length = 5, order = 54)
    public RString shunoKikanBango4;
    @ReportItem(name = "kakuninBango4", length = 5, order = 55)
    public RString kakuninBango4;
    @ReportItem(name = "nofuKubun4", length = 3, order = 56)
    public RString nofuKubun4;
    @ReportItem(name = "ocrId3", length = 3, order = 57)
    public RString ocrId3;
    @ReportItem(name = "ocrId4", length = 3, order = 58)
    public RString ocrId4;
    @ReportItem(name = "ocr13", length = 39, order = 59)
    public RString ocr13;
    @ReportItem(name = "ocrCut3", length = 1, order = 60)
    public RString ocrCut3;
    @ReportItem(name = "ocr14", length = 39, order = 61)
    public RString ocr14;
    @ReportItem(name = "ocrCut4", length = 1, order = 62)
    public RString ocrCut4;
    @ReportItem(name = "ocr23", length = 44, order = 63)
    public RString ocr23;
    @ReportItem(name = "ocr24", length = 44, order = 64)
    public RString ocr24;
    @ReportItem(name = "biko13", length = 30, order = 65)
    public RString biko13;
    @ReportItem(name = "biko14", length = 30, order = 66)
    public RString biko14;
    @ReportItem(name = "biko23", length = 30, order = 67)
    public RString biko23;
    @ReportItem(name = "biko24", length = 30, order = 68)
    public RString biko24;
    @ReportItem(name = "barcodeCvsBarcode3", order = 69)
    public RString barcodeCvsBarcode3;
    @ReportItem(name = "barcodeCvsBarcode4", order = 70)
    public RString barcodeCvsBarcode4;
    @ReportItem(name = "cvsBarcodeNaiyo13", length = 33, order = 71)
    public RString cvsBarcodeNaiyo13;
    @ReportItem(name = "cvsBarcodeNaiyo14", length = 33, order = 72)
    public RString cvsBarcodeNaiyo14;
    @ReportItem(name = "cvsBarcodeNaiyo23", length = 33, order = 73)
    public RString cvsBarcodeNaiyo23;
    @ReportItem(name = "cvsBarcodeNaiyo24", length = 33, order = 74)
    public RString cvsBarcodeNaiyo24;
    @ReportItem(name = "cvsToriatsukaikigen3", length = 16, order = 75)
    public RString cvsToriatsukaikigen3;
    @ReportItem(name = "cvsToriatsukaikigen4", length = 16, order = 76)
    public RString cvsToriatsukaikigen4;
    @ReportItem(name = "funyuFukanBango3", length = 12, order = 77)
    public RString funyuFukanBango3;
    @ReportItem(name = "funyuFukanBango4", length = 12, order = 78)
    public RString funyuFukanBango4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
