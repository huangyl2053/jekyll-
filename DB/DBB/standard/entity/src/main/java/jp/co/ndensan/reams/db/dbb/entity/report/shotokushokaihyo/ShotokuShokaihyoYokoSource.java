package jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBPR51002_所得照会票
 *
 * @reamsid_L DBB-1710-030 xuhao
 */
public class ShotokuShokaihyoYokoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "sofusakiTantoBushoKeisho", length = 2, order = 1)
    public RString sofusakiTantoBushoKeisho;
    @ReportItem(name = "sofusakiTantoBusho", length = 15, order = 2)
    public RString sofusakiTantoBusho;
    @ReportItem(name = "sofusakiYubinno", length = 8, order = 3)
    public RString sofusakiYubinno;
    @ReportItem(name = "sofusakiJusho1", length = 15, order = 4)
    public RString sofusakiJusho1;
    @ReportItem(name = "sofusakiJusho2", length = 15, order = 5)
    public RString sofusakiJusho2;
    @ReportItem(name = "title3", length = 7, order = 6)
    public RString title3;
    @ReportItem(name = "sofusakiYakusho1", length = 9, order = 7)
    public RString sofusakiYakusho1;
    @ReportItem(name = "sofusakiYakusho2", length = 9, order = 8)
    public RString sofusakiYakusho2;
    @ReportItem(name = "juminzeiNendo2", length = 4, order = 9)
    public RString juminzeiNendo2;
    @ReportItem(name = "barcode", order = 10)
    public RString barcode;
    @ReportItem(name = "shokaiYMD", length = 11, order = 11)
    public RString shokaiYMD;
    @ReportItem(name = "setaiCode", length = 15, order = 12)
    public RString setaiCode;
    @ReportItem(name = "zenJusho", order = 13)
    public RString zenJusho;
    @ReportItem(name = "genJusho", order = 14)
    public RString genJusho;
    @ReportItem(name = "ymdTitle", length = 5, order = 15)
    public RString ymdTitle;
    @ReportItem(name = "tennyuYMD1", length = 11, order = 16)
    public RString tennyuYMD1;
    @ReportItem(name = "tennyuYMD2", length = 11, order = 17)
    public RString tennyuYMD2;
    @ReportItem(name = "tennyuYMD3", length = 11, order = 18)
    public RString tennyuYMD3;
    @ReportItem(name = "tennyuYMD4", length = 11, order = 19)
    public RString tennyuYMD4;
    @ReportItem(name = "shikibetsuCode1", length = 15, order = 20)
    public RString shikibetsuCode1;
    @ReportItem(name = "shikibetsuCode2", length = 15, order = 21)
    public RString shikibetsuCode2;
    @ReportItem(name = "shikibetsuCode3", length = 15, order = 22)
    public RString shikibetsuCode3;
    @ReportItem(name = "shikibetsuCode4", length = 15, order = 23)
    public RString shikibetsuCode4;
    @ReportItem(name = "shimeiKana1", length = 26, order = 24)
    public RString shimeiKana1;
    @ReportItem(name = "shimeiKana2", length = 26, order = 25)
    public RString shimeiKana2;
    @ReportItem(name = "shimeiKana3", length = 26, order = 26)
    public RString shimeiKana3;
    @ReportItem(name = "shimeiKana4", length = 26, order = 27)
    public RString shimeiKana4;
    @ReportItem(name = "shimei1", length = 12, order = 28)
    public RString shimei1;
    @ReportItem(name = "shimei2", length = 12, order = 29)
    public RString shimei2;
    @ReportItem(name = "shimei3", length = 12, order = 30)
    public RString shimei3;
    @ReportItem(name = "shimei4", length = 12, order = 31)
    public RString shimei4;
    @ReportItem(name = "sofusakiYakushokuName", length = 10, order = 32)
    public RString sofusakiYakushokuName;
    @ReportItem(name = "sofusakiYakushokuKeisho", length = 2, order = 33)
    public RString sofusakiYakushokuKeisho;
    @ReportItem(name = "birthYMD1", length = 11, order = 34)
    public RString birthYMD1;
    @ReportItem(name = "birthYMD2", length = 11, order = 35)
    public RString birthYMD2;
    @ReportItem(name = "birthYMD3", length = 11, order = 36)
    public RString birthYMD3;
    @ReportItem(name = "birthYMD4", length = 11, order = 37)
    public RString birthYMD4;
    @ReportItem(name = "title1", length = 7, order = 38)
    public RString title1;
    @ReportItem(name = "title2", length = 7, order = 39)
    public RString title2;
    @ReportItem(name = "juminzeiNendo1", length = 4, order = 40)
    public RString juminzeiNendo1;
    @ReportItem(name = "hihokenshaJusho", length = 33, order = 41)
    public RString hihokenshaJusho;
    @ReportItem(name = "hihokenshaShimei", length = 28, order = 42)
    public RString hihokenshaShimei;
    @ReportItem(name = "hihokenshaumareYMD", length = 11, order = 43)
    public RString hihokenshaumareYMD;
    @ReportItem(name = "kazeiNendo", length = 6, order = 44)
    public RString kazeiNendo;
    @ReportItem(name = "yubinBango", length = 8, order = 45)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", length = 50, order = 46)
    public RString shozaichi;
    @ReportItem(name = "bushoName", length = 20, order = 47)
    public RString bushoName;
    @ReportItem(name = "tantoName", length = 20, order = 48)
    public RString tantoName;
    @ReportItem(name = "choshaName", length = 20, order = 49)
    public RString choshaName;
    @ReportItem(name = "naisenNo", length = 20, order = 50)
    public RString naisenNo;
    @ReportItem(name = "telNo", length = 35, order = 51)
    public RString telNo;
    @ReportItem(name = "denshiKoin", order = 52)
    public RString denshiKoin;
    @ReportItem(name = "hakkoYMD", length = 12, order = 53)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 54)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaShimeiKakenai", length = 14, order = 55)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "koinShoryaku", length = 15, order = 56)
    public RString koinShoryaku;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
