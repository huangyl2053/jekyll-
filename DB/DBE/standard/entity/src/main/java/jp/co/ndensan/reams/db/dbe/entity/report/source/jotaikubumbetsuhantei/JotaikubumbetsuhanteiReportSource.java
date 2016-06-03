package jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 要介護状態区分別判定件数のReportSourceクラスです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
public class JotaikubumbetsuhanteiReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonNo", length = 6, order = 2)
    public RString shichosonNo;
    @ReportItem(name = "gogitaiName", length = 20, order = 3)
    public RString gogitaiName;
    @ReportItem(name = "shinsakaiStartYMD", length = 11, order = 4)
    public RString shinsakaiStartYMD;
    @ReportItem(name = "shinsakaiEndYMD", length = 11, order = 5)
    public RString shinsakaiEndYMD;
    @ReportItem(name = "shichosonName", length = 7, order = 6)
    public RString shichosonName;
    @ReportItem(name = "shinsakaiKaisaiKaisu", length = 3, order = 7)
    public RString shinsakaiKaisaiKaisu;
    @ReportItem(name = "printTimeStamp", length = 34, order = 8)
    public RString printTimeStamp;
    @ReportItem(name = "listHantei1_1", length = 4, order = 9)
    public RString listHantei1_1;
    @ReportItem(name = "listHantei1_2", length = 5, order = 10)
    public RString listHantei1_2;
    @ReportItem(name = "listHantei1_3", length = 5, order = 11)
    public RString listHantei1_3;
    @ReportItem(name = "listHantei1_4", length = 5, order = 12)
    public RString listHantei1_4;
    @ReportItem(name = "listHantei1_5", length = 5, order = 13)
    public RString listHantei1_5;
    @ReportItem(name = "listHantei1_6", length = 5, order = 14)
    public RString listHantei1_6;
    @ReportItem(name = "listHantei1_7", length = 5, order = 15)
    public RString listHantei1_7;
    @ReportItem(name = "listHantei1_8", length = 5, order = 16)
    public RString listHantei1_8;
    @ReportItem(name = "listHantei1_9", length = 5, order = 17)
    public RString listHantei1_9;
    @ReportItem(name = "listHantei1_10", length = 2, order = 18)
    public RString listHantei1_10;
    @ReportItem(name = "listHantei_1", length = 5, order = 19)
    public RString listHantei_1;
    @ReportItem(name = "listHantei_2", length = 5, order = 20)
    public RString listHantei_2;
    @ReportItem(name = "listHantei_3", length = 5, order = 21)
    public RString listHantei_3;
    @ReportItem(name = "listHantei_4", length = 5, order = 22)
    public RString listHantei_4;
    @ReportItem(name = "listHantei_5", length = 6, order = 23)
    public RString listHantei_5;
    @ReportItem(name = "henkosha", length = 5, order = 24)
    public RString henkosha;
    @ReportItem(name = "keido", length = 5, order = 25)
    public RString keido;
    @ReportItem(name = "judo", length = 5, order = 26)
    public RString judo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    @ReportPerson(id = "X")
    public ShikibetsuCode shikibetuCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation hokenshaNo;
// </editor-fold>

    /**
     * 改ページ条件のキーです。
     */
    public enum ReportSourceFields {

        gogitaiName,
        shichosonNo,

    }
}
