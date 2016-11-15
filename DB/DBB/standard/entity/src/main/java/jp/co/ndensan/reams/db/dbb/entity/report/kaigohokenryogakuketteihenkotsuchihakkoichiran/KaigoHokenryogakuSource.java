package jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBRP43002_3_介護保険料額決定通知書発行一覧表
 */
public class KaigoHokenryogakuSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 50, order = 2)
    public RString title;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
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
    @ReportItem(name = "hyojicodeName1", length = 8, order = 10)
    public RString hyojicodeName1;
    @ReportItem(name = "hyojicodeName2", length = 8, order = 11)
    public RString hyojicodeName2;
    @ReportItem(name = "hyojicodeName3", length = 8, order = 12)
    public RString hyojicodeName3;
    @ReportItem(name = "listUpper_1", length = 6, order = 13)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 20, order = 14)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 15)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 15, order = 16)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 12, order = 17)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 12, order = 18)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 12, order = 19)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 7, order = 20)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 10, order = 21)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 4, order = 22)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 9, order = 23)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 3, order = 24)
    public RString listUpper_12;
    @ReportItem(name = "listLower_1", length = 20, order = 25)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 8, order = 26)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 28, order = 27)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 7, order = 28)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 10, order = 29)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 4, order = 30)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 38, order = 31)
    public RString listLower_7;

    @ReportItem(name = "choikiCode", length = 15, order = 32)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 15, order = 33)
    public RString gyoseikuCode;
    @ReportItem(name = "chikuCode1", length = 15, order = 34)
    public RString chikuCode1;
    @ReportItem(name = "chikuCode2", length = 15, order = 35)
    public RString chikuCode2;
    @ReportItem(name = "chikuCode3", length = 15, order = 36)
    public RString chikuCode3;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 37)
    public RString shikibetsuCode;
    @ReportItem(name = "kanaMeisho", length = 30, order = 38)
    public RString kanaMeisho;
    @ReportItem(name = "nenkinCode", length = 15, order = 39)
    public RString nenkinCode;
    @ReportItem(name = "nokumiCode", length = 15, order = 40)
    public RString nokumiCode;
    @ReportItem(name = "seihoFlag", length = 15, order = 41)
    public RString seihoFlag;
    @ReportItem(name = "seihoFlag1", length = 15, order = 42)
    public RString seihoFlag1;
    @ReportItem(name = "tokuchoKaishi8", length = 30, order = 43)
    public RString tokuchoKaishi8;
    @ReportItem(name = "tokuchoKaishi10", length = 30, order = 44)
    public RString tokuchoKaishi10;
    @ReportItem(name = "banchiCode", length = 30, order = 45)
    public RString banchiCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
