package jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 認定調査票情報のReportSourceクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
public class NinteiChosaJohohyo32ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaName", length = 30, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 3)
    public RString shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 4)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 5)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 6)
    public RString shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 7)
    public RString sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 8)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 9)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 10)
    public RString sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 11)
    public RString hihokenshaNo;
    @ReportItem(name = "chosaGengo", length = 2, order = 12)
    public RString chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 13)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 14)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 15)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 16)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 17)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 18)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 19)
    public RString shinsaDD;
    @ReportItem(name = "title", length = 30, order = 20)
    public RString title;
    @ReportItem(name = "age", length = 4, order = 21)
    public RString age;
    @ReportItem(name = "seibetsu", length = 1, order = 22)
    public RString seibetsu;
    @ReportItem(name = "listIchigun2_1", length = 3, order = 23)
    public RString listIchigun2_1;
    @ReportItem(name = "listIchigun1_1", length = 3, order = 24)
    public RString listIchigun1_1;
    @ReportItem(name = "yubimNo", length = 8, order = 25)
    public RString yubimNo;
    @ReportItem(name = "hihokenshaTelNo", length = 13, order = 26)
    public RString hihokenshaTelNo;
    @ReportItem(name = "hihokenshaJusho", length = 30, order = 27)
    public RString hihokenshaJusho;
    @ReportItem(name = "kazokuTelNo1", length = 13, order = 28)
    public RString kazokuTelNo1;
    @ReportItem(name = "kazokuYubimNo", length = 8, order = 29)
    public RString kazokuYubimNo;
    @ReportItem(name = "kazokuTelNo2", length = 13, order = 30)
    public RString kazokuTelNo2;
    @ReportItem(name = "kazokuJusho", length = 30, order = 31)
    public RString kazokuJusho;
    @ReportItem(name = "kazokuName", length = 15, order = 32)
    public RString kazokuName;
    @ReportItem(name = "listNigun_1", length = 20, order = 33)
    public RString listNigun_1;
    @ReportItem(name = "zokugara", length = 8, order = 34)
    public RString zokugara;
    @ReportItem(name = "shinseiKubun", length = 13, order = 35)
    public RString shinseiKubun;
    @ReportItem(name = "shinsaYMD", length = 11, order = 36)
    public RString shinsaYMD;
    @ReportItem(name = "shinseikubunHorei", length = 13, order = 37)
    public RString shinseikubunHorei;
    @ReportItem(name = "ichijiHanteiKekka", length = 9, order = 38)
    public RString ichijiHanteiKekka;
    @ReportItem(name = "nijiHanteiKekka", length = 4, order = 39)
    public RString nijiHanteiKekka;
    @ReportItem(name = "nijihanteiKaishiYMD", length = 11, order = 40)
    public RString nijihanteiKaishiYMD;
    @ReportItem(name = "ｙukokikan", length = 2, order = 41)
    public RString ｙukokikan;
    @ReportItem(name = "nijihanteishuryoYMD", length = 11, order = 42)
    public RString nijihanteishuryoYMD;
    @ReportItem(name = "listSangun_1", length = 20, order = 43)
    public RString listSangun_1;
    @ReportItem(name = "jotaizo", length = 26, order = 44)
    public RString jotaizo;
    @ReportItem(name = "henkoJiyu", length = 20, order = 45)
    public RString henkoJiyu;
    @ReportItem(name = "tokuteishippeiName", length = 40, order = 46)
    public RString tokuteishippeiName;
    @ReportItem(name = "listYongun_1", length = 20, order = 47)
    public RString listYongun_1;
    @ReportItem(name = "shinsakaiIken", length = 70, order = 48)
    public RString shinsakaiIken;
    @ReportItem(name = "zenkaiNijihanteiDate", length = 11, order = 49)
    public RString zenkaiNijihanteiDate;
    @ReportItem(name = "zenkaiNijihanteikekka", length = 4, order = 50)
    public RString zenkaiNijihanteikekka;
    @ReportItem(name = "zenHanteiKaishiYMD", length = 11, order = 51)
    public RString zenHanteiKaishiYMD;
    @ReportItem(name = "zenkaiYukokikan", length = 2, order = 52)
    public RString zenkaiYukokikan;
    @ReportItem(name = "zenHanteishuryoYMD", length = 11, order = 53)
    public RString zenHanteishuryoYMD;
    @ReportItem(name = "listGogun_1", length = 20, order = 54)
    public RString listGogun_1;
    @ReportItem(name = "chosaJisshiYMD", length = 11, order = 55)
    public RString chosaJisshiYMD;
    @ReportItem(name = "chosaJisshiBashoTxit", order = 56)
    public RString chosaJisshiBashoTxit;
    @ReportItem(name = "imgChosaJisshiBasho", order = 57)
    public RString imgChosaJisshiBasho;
    @ReportItem(name = "chosaJisshiBasho", length = 6, order = 58)
    public RString chosaJisshiBasho;
    @ReportItem(name = "chosainName", length = 30, order = 59)
    public RString chosainName;
    @ReportItem(name = "chosaItakusakiName", length = 30, order = 60)
    public RString chosaItakusakiName;
    @ReportItem(name = "listSabisujokyo_1", length = 10, order = 61)
    public RString listSabisujokyo_1;
    @ReportItem(name = "listRokugun_1", length = 20, order = 62)
    public RString listRokugun_1;
    @ReportItem(name = "listRokugun1_1", length = 20, order = 63)
    public RString listRokugun1_1;
    @ReportItem(name = "imgTokubetsukyufu", order = 64)
    public RString imgTokubetsukyufu;
    @ReportItem(name = "tokubetsukyufuTxit", order = 65)
    public RString tokubetsukyufuTxit;
    @ReportItem(name = "listIryo_1", length = 20, order = 66)
    public RString listIryo_1;
    @ReportItem(name = "imgZaitakusabisu", order = 67)
    public RString imgZaitakusabisu;
    @ReportItem(name = "zaitakusabisuTxit", order = 68)
    public RString zaitakusabisuTxit;
    @ReportItem(name = "shisetsuriyo", length = 25, order = 69)
    public RString shisetsuriyo;
    @ReportItem(name = "imgShisetsuName", order = 70)
    public RString imgShisetsuName;
    @ReportItem(name = "shisetsuNameTxit", order = 71)
    public RString shisetsuNameTxit;
    @ReportItem(name = "imgShisetsujusho", order = 72)
    public RString imgShisetsujusho;
    @ReportItem(name = "shisetsujushoTxit", order = 73)
    public RString shisetsujushoTxit;
    @ReportItem(name = "imgShisetsuTel", order = 74)
    public RString imgShisetsuTel;
    @ReportItem(name = "shisetsuTxitTel", order = 75)
    public RString shisetsuTxitTel;
    @ReportItem(name = "listJugun_1", length = 20, order = 76)
    public RString listJugun_1;
    @ReportItem(name = "listChosaJiritsudo_1", length = 3, order = 77)
    public RString listChosaJiritsudo_1;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
