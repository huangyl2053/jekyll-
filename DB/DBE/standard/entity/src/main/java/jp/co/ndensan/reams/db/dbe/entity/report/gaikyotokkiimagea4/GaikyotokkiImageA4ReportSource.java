package jp.co.ndensan.reams.db.dbe.entity.report.gaikyotokkiimagea4;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 事務局概況特記のReportSourceです。
 *
 * @reamsid_L DBE-0150-370 wangrenze
 */
public class GaikyotokkiImageA4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "tokkiText1", order = 1)
    public RString tokkiText1;
    @ReportItem(name = "tokkiText2", order = 2)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 3)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 4)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 5)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 6)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 7)
    public RString tokkiText7;
    @ReportItem(name = "hihokenshaName", length = 30, order = 8)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 9)
    public RString hokenshaNo;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 10)
    public RString sakuseiGengo;
    @ReportItem(name = "shinseiYY", length = 2, order = 11)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 12)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 13)
    public RString shinseiDD;
    @ReportItem(name = "chosaGengo", length = 2, order = 14)
    public RString chosaGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 15)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 16)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 17)
    public RString sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 18)
    public RString hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 19)
    public RString shinseiGengo;
    @ReportItem(name = "chosaYY", length = 2, order = 20)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 21)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 22)
    public RString chosaDD;
    @ReportItem(name = "shinsaGengo", length = 2, order = 23)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 24)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 25)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 26)
    public RString shinsaDD;
    @ReportItem(name = "gaikyotokkiImg1", order = 27)
    public RString gaikyotokkiImg1;
    @ReportItem(name = "gaikyotokkiImg2", order = 28)
    public RString gaikyotokkiImg2;
    @ReportItem(name = "gaikyotokkiImg3", order = 29)
    public RString gaikyotokkiImg3;
    @ReportItem(name = "gaikyotokkiImg4", order = 30)
    public RString gaikyotokkiImg4;
    @ReportItem(name = "gaikyotokkiImg5", order = 31)
    public RString gaikyotokkiImg5;
    @ReportItem(name = "gaikyotokkiImg6", order = 32)
    public RString gaikyotokkiImg6;
    @ReportItem(name = "gaikyotokkiImg7", order = 33)
    public RString gaikyotokkiImg7;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hishokenshaNo;

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        hokenshaNo,
    }
}
