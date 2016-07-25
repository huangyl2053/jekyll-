package jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特記事項（A4版）のReportSourceです。
 *
 * @reamsid_L DBE-0150-340 wangrenze
 */
public class TokkiText1A4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "gaikyotokkiImg", order = 1)
    public RString gaikyotokkiImg;
    @ReportItem(name = "hihokenshaName", length = 30, order = 2)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "shinseiYY", length = 2, order = 4)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 5)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 6)
    public RString shinseiDD;
    @ReportItem(name = "sakuseiGengo", length = 2, order = 7)
    public RString sakuseiGengo;
    @ReportItem(name = "chosaGengo", length = 2, order = 8)
    public RString chosaGengo;
    @ReportItem(name = "sakuseiYY", length = 2, order = 9)
    public RString sakuseiYY;
    @ReportItem(name = "sakuseiMM", length = 2, order = 10)
    public RString sakuseiMM;
    @ReportItem(name = "sakuseiDD", length = 2, order = 11)
    public RString sakuseiDD;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 12)
    public RString hihokenshaNo;
    @ReportItem(name = "shinseiGengo", length = 2, order = 13)
    public RString shinseiGengo;
    @ReportItem(name = "shinsaGengo", length = 2, order = 14)
    public RString shinsaGengo;
    @ReportItem(name = "shinsaYY", length = 2, order = 15)
    public RString shinsaYY;
    @ReportItem(name = "shinsaMM", length = 2, order = 16)
    public RString shinsaMM;
    @ReportItem(name = "shinsaDD", length = 2, order = 17)
    public RString shinsaDD;
    @ReportItem(name = "chosaYY", length = 2, order = 18)
    public RString chosaYY;
    @ReportItem(name = "chosaMM", length = 2, order = 19)
    public RString chosaMM;
    @ReportItem(name = "chosaDD", length = 2, order = 20)
    public RString chosaDD;
    @ReportItem(name = "gaikyotokkiText", order = 21)
    public RString gaikyotokkiText;
    @ReportItem(name = "tokkiImg1", order = 22)
    public RString tokkiImg1;
    @ReportItem(name = "listChosa_1", length = 4, order = 23)
    public RString listChosa_1;
    @ReportItem(name = "tokkiImg2", order = 24)
    public RString tokkiImg2;
    @ReportItem(name = "tokkiImg3", order = 25)
    public RString tokkiImg3;
    @ReportItem(name = "tokkiImg4", order = 26)
    public RString tokkiImg4;
    @ReportItem(name = "tokkiImg5", order = 27)
    public RString tokkiImg5;
    @ReportItem(name = "tokkiImg6", order = 28)
    public RString tokkiImg6;
    @ReportItem(name = "tokkiImg7", order = 29)
    public RString tokkiImg7;
    @ReportItem(name = "tokkiImg8", order = 30)
    public RString tokkiImg8;
    @ReportItem(name = "tokkiImg9", order = 31)
    public RString tokkiImg9;
    @ReportItem(name = "tokkiImg10", order = 32)
    public RString tokkiImg10;
    @ReportItem(name = "tokkiImg11", order = 33)
    public RString tokkiImg11;
    @ReportItem(name = "tokkiImg12", order = 34)
    public RString tokkiImg12;
    @ReportItem(name = "tokkiImg13", order = 35)
    public RString tokkiImg13;
    @ReportItem(name = "tokkiImg14", order = 36)
    public RString tokkiImg14;
    @ReportItem(name = "tokkiImg15", order = 37)
    public RString tokkiImg15;
    @ReportItem(name = "tokkiText1", order = 38)
    public RString tokkiText1;
    @ReportItem(name = "listChosa1_1", length = 4, order = 39)
    public RString listChosa1_1;
    @ReportItem(name = "tokkiText2", order = 40)
    public RString tokkiText2;
    @ReportItem(name = "tokkiText3", order = 41)
    public RString tokkiText3;
    @ReportItem(name = "tokkiText4", order = 42)
    public RString tokkiText4;
    @ReportItem(name = "tokkiText5", order = 43)
    public RString tokkiText5;
    @ReportItem(name = "tokkiText6", order = 44)
    public RString tokkiText6;
    @ReportItem(name = "tokkiText7", order = 45)
    public RString tokkiText7;
    @ReportItem(name = "tokkiText8", order = 46)
    public RString tokkiText8;
    @ReportItem(name = "tokkiText9", order = 47)
    public RString tokkiText9;
    @ReportItem(name = "tokkiText10", order = 48)
    public RString tokkiText10;
    @ReportItem(name = "tokkiText11", order = 49)
    public RString tokkiText11;
    @ReportItem(name = "tokkiText12", order = 50)
    public RString tokkiText12;
    @ReportItem(name = "tokkiText13", order = 51)
    public RString tokkiText13;
    @ReportItem(name = "tokkiText14", order = 52)
    public RString tokkiText14;
    @ReportItem(name = "tokkiText15", order = 53)
    public RString tokkiText15;
    @ReportItem(name = "tokkiImg", order = 54)
    public RString tokkiImg;
    @ReportItem(name = "tokkiText", order = 55)
    public RString tokkiText;
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
