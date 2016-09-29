package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のSourceクラスです。
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
public class TokubetsuChoshuIraiJohoKensuhyoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nenkinHokenshaName", length = 3, order = 2)
    public RString nenkinHokenshaName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "shichosonCode", length = 6, order = 4)
    public RString shichosonCode;
    @ReportItem(name = "hokenshaName", length = 24, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "shichosonName", length = 24, order = 6)
    public RString shichosonName;
    @ReportItem(name = "listLeftUpper_1", length = 3, order = 7)
    public RString listLeftUpper_1;
    @ReportItem(name = "listLeftUpper_2", length = 20, order = 8)
    public RString listLeftUpper_2;
    @ReportItem(name = "listLeftUpper_3", length = 7, order = 9)
    public RString listLeftUpper_3;
    @ReportItem(name = "listLeftUpper_4", length = 14, order = 10)
    public RString listLeftUpper_4;
    @ReportItem(name = "listLeftLower_1", length = 14, order = 11)
    public RString listLeftLower_1;
    @ReportItem(name = "listRightUpper_1", length = 3, order = 12)
    public RString listRightUpper_1;
    @ReportItem(name = "listRightUpper_2", length = 20, order = 13)
    public RString listRightUpper_2;
    @ReportItem(name = "listRightUpper_3", length = 7, order = 14)
    public RString listRightUpper_3;
    @ReportItem(name = "listRightUpper_4", length = 14, order = 15)
    public RString listRightUpper_4;
    @ReportItem(name = "listRightLower_1", length = 14, order = 16)
    public RString listRightLower_1;
    @ReportItem(name = "gokeiKensu", length = 7, order = 17)
    public RString gokeiKensu;
    @ReportItem(name = "gokeiKingaku1", length = 14, order = 18)
    public RString gokeiKingaku1;
    @ReportItem(name = "gokeiKingaku2", length = 14, order = 19)
    public RString gokeiKingaku2;
    @ReportItem(name = "baitaiNo", length = 6, order = 20)
    public RString baitaiNo;
    @ReportItem(name = "shurokuKensu", length = 7, order = 21)
    public RString shurokuKensu;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * TokubetsuChoshuIraiJohoKensuhyoSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        nenkinHokenshaName,
        hokenshaNo,
        shichosonCode,
        hokenshaName,
        shichosonName,
        listLeftUpper_1,
        listLeftUpper_2,
        listLeftUpper_3,
        listLeftUpper_4,
        listLeftLower_1,
        listRightUpper_1,
        listRightUpper_2,
        listRightUpper_3,
        listRightUpper_4,
        listRightLower_1,
        gokeiKensu,
        gokeiKingaku1,
        gokeiKingaku2,
        baitaiNo,
        shurokuKensu
    }
}
