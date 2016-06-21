package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoa3;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 委員用主治医意見書A4のReportSourceクラスです。
 *
 * @reamsid_L DBE-0150-140 lishengli
 */
public class ShujiiikenshoA4ReportSource implements IReportSource {
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
    @ReportItem(name = "imgIkensho1", order = 20)
    public RString imgIkensho1;
    @ReportItem(name = "hihokenshaName", length = 30, order = 21)
    public RString two_hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 22)
    public RString two_hokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 23)
    public RString two_shinseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 24)
    public RString two_shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 25)
    public RString two_shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 26)
    public RString two_shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 27)
    public RString two_sakuseiGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 28)
    public RString two_sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 29)
    public RString two_sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 30)
    public RString two_sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 31)
    public RString two_hihokenshaNo;
    @ReportItem(name = "chosaGengo", length = 2, order = 32)
    public RString two_chosaGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 33)
    public RString two_chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 34)
    public RString two_chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 35)
    public RString two_chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 36)
    public RString two_shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 37)
    public RString two_shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 38)
    public RString two_shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 39)
    public RString two_shinsaDD;
    @ReportItem(name = "imgIkensho2", order = 40)
    public RString two_imgIkensho2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hokenshaNo,

    }
}
