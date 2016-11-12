package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 特別徴収依頼金額明細一覧表帳票Source
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 4, order = 2)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 10)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 11)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 12)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 13)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 14)
    public RString kaipage5;
    @ReportItem(name = "nendoTitle", length = 3, order = 15)
    public RString nendoTitle;
    @ReportItem(name = "listUpper_1", length = 20, order = 16)
    public RString listUpper_1;
    @ReportPerson(id = "X")
    @ReportItem(name = "listUpper_2", length = 15, order = 17)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 9, order = 18)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 4, order = 19)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 24, order = 20)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 14, order = 21)
    public RString listUpper_6;
    @ReportItem(name = "listCenter_1", length = 2, order = 22)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 7, order = 23)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 7, order = 24)
    public RString listCenter_3;
    @ReportItem(name = "listCenter_4", length = 2, order = 25)
    public RString listCenter_4;
    @ReportItem(name = "listCenter_5", length = 2, order = 26)
    public RString listCenter_5;
    @ReportItem(name = "listCenter_6", length = 7, order = 27)
    public RString listCenter_6;
    @ReportItem(name = "listCenter_7", length = 15, order = 28)
    public RString listCenter_7;
    @ReportItem(name = "listLower_1", length = 10, order = 29)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 15, order = 30)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 11, order = 31)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 10, order = 32)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 20, order = 33)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 19, order = 34)
    public RString listLower_6;
    @ReportItem(name = "keisanHoho", length = 80, order = 35)
    public RString keisanHoho;
    @ReportItem(name = "choikiCode", length = 80, order = 36)
    public RString choikiCode;
    @ReportItem(name = "shichosonCode", length = 80, order = 37)
    public RString shichosonCode;
    @ReportExpandedInfo(id = "X")
    public ExpandedInformation 拡張情報;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
    /**
     * TokubetsuChoshuKaishiSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        nendo,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        nendoTitle,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listUpper_6,
        listCenter_1,
        listCenter_2,
        listCenter_3,
        listCenter_4,
        listCenter_5,
        listCenter_6,
        listCenter_7,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6,
        keisanHoho,
        choikiCode,
        shichosonCode
    }
// </editor-fold>
}
