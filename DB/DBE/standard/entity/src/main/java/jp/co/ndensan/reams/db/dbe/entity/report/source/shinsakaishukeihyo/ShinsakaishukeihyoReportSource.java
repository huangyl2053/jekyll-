package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査会集計表（判定別）のReportSourceクラスです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
public class ShinsakaishukeihyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 30, order = 1)
    public RString title;
    @ReportItem(name = "shichosonNo", length = 6, order = 2)
    public RString shichosonNo;
    @ReportItem(name = "shinsakaiStartYMD", length = 11, order = 3)
    public RString shinsakaiStartYMD;
    @ReportItem(name = "shinsakaiEndYMD", length = 11, order = 4)
    public RString shinsakaiEndYMD;
    @ReportItem(name = "shinsakaiKaisaiKaisu", length = 3, order = 5)
    public RString shinsakaiKaisaiKaisu;
    @ReportItem(name = "shichosonName", length = 7, order = 6)
    public RString shichosonName;
    @ReportItem(name = "printTimeStamp", length = 34, order = 7)
    public RString printTimeStamp;
    @ReportItem(name = "listHantei1_1", length = 4, order = 8)
    public RString listHantei1_1;
    @ReportItem(name = "listHantei1_2", length = 5, order = 9)
    public RString listHantei1_2;
    @ReportItem(name = "listHantei1_3", length = 5, order = 10)
    public RString listHantei1_3;
    @ReportItem(name = "listHantei1_4", length = 5, order = 11)
    public RString listHantei1_4;
    @ReportItem(name = "listHantei1_5", length = 5, order = 12)
    public RString listHantei1_5;
    @ReportItem(name = "listHantei1_6", length = 5, order = 13)
    public RString listHantei1_6;
    @ReportItem(name = "listHantei1_7", length = 5, order = 14)
    public RString listHantei1_7;
    @ReportItem(name = "listHantei1_8", length = 5, order = 15)
    public RString listHantei1_8;
    @ReportItem(name = "listHantei1_9", length = 5, order = 16)
    public RString listHantei1_9;
    @ReportItem(name = "listHantei1_10", length = 2, order = 17)
    public RString listHantei1_10;
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

        shichosonNo,
    }
}
