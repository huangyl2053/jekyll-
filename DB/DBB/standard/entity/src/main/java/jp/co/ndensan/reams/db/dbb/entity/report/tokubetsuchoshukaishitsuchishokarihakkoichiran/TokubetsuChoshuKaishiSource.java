package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）発行一覧表
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 20, order = 2)
    public RString title;
    @ReportItem(name = "nendo", length = 4, order = 3)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 4)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 5)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 6)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 7)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 8)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 9)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 10)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaipage1", length = 20, order = 11)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 12)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 13)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 14)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 15)
    public RString kaipage5;
    @ReportItem(name = "titleChoshugaku", length = 4, order = 16)
    public RString titleChoshugaku;
    @ReportItem(name = "listUpper_1", length = 6, order = 17)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 8, order = 18)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 69, order = 19)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 12, order = 20)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 11, order = 21)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 1, order = 22)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 20, order = 23)
    public RString listUpper_7;
    @ReportItem(name = "listLower_1", length = 20, order = 24)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 15, order = 25)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 25, order = 26)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 20, order = 27)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 20, order = 28)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 3, order = 29)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 7, order = 30)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 3, order = 31)
    public RString listLower_8;
    @ReportItem(name = "listLower_9", length = 7, order = 32)
    public RString listLower_9;
    @ReportItem(name = "listLower_10", length = 3, order = 33)
    public RString listLower_10;
    @ReportItem(name = "listLower_11", length = 7, order = 34)
    public RString listLower_11;

    @ReportItem(name = "choikiCode", length = 15, order = 35)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 15, order = 36)
    public RString gyoseikuCode;
    @ReportItem(name = "chikuCode1", length = 15, order = 37)
    public RString chikuCode1;
    @ReportItem(name = "chikuCode2", length = 15, order = 38)
    public RString chikuCode2;
    @ReportItem(name = "chikuCode3", length = 15, order = 39)
    public RString chikuCode3;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 40)
    public RString shikibetsuCode;
    @ReportItem(name = "kanaMeisho", length = 30, order = 41)
    public RString kanaMeisho;
    @ReportItem(name = "hihokenshaNo", length = 15, order = 42)
    public RString hihokenshaNo;
    @ReportItem(name = "nenkinCode", length = 15, order = 43)
    public RString nenkinCode;
    @ReportItem(name = "nokumiCode", length = 15, order = 44)
    public RString nokumiCode;
    @ReportItem(name = "seihoFlag", length = 15, order = 45)
    public RString seihoFlag;
    @ReportItem(name = "tokuchoKaishi10", length = 30, order = 46)
    public RString tokuchoKaishi10;
    @ReportItem(name = "banchiCode", length = 30, order = 47)
    public RString banchiCode;

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
        title,
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
        titleChoshugaku,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listUpper_6,
        listUpper_7,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6,
        listLower_7,
        listLower_8,
        listLower_9,
        listLower_10,
        listLower_11
    }
// </editor-fold>
}
