package jp.co.ndensan.reams.db.dba.entity.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 適用除外者台帳の帳票データのクラスです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
public class TekiyojogaishaDaichoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 50, order = 2)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 4)
    public RString shichosonName;
    @ReportItem(name = "birthYMD", length = 10, order = 5)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 1, order = 6)
    public RString seibetsu;
    @ReportItem(name = "setaiCode", length = 15, order = 7)
    public RString setaiCode;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 8)
    public RString shikibetsuCode;
    @ReportItem(name = "shimeiKana", order = 9)
    public RString shimeiKana;
    @ReportItem(name = "chiku1CodeTitle", length = 5, order = 10)
    public RString chiku1CodeTitle;
    @ReportItem(name = "chiku1Code", length = 8, order = 11)
    public RString chiku1Code;
    @ReportItem(name = "shimei", order = 12)
    public RString shimei;
    @ReportItem(name = "jotai", length = 7, order = 13)
    public RString jotai;
    @ReportItem(name = "telNoTitle", length = 6, order = 14)
    public RString telNoTitle;
    @ReportItem(name = "chiku2CodeTitle", length = 5, order = 15)
    public RString chiku2CodeTitle;
    @ReportItem(name = "chiku2Code", length = 8, order = 16)
    public RString chiku2Code;
    @ReportItem(name = "jusho1", order = 17)
    public RString jusho1;
    @ReportItem(name = "jusho1Title", length = 5, order = 18)
    public RString jusho1Title;
    @ReportItem(name = "telNo1", length = 14, order = 19)
    public RString telNo1;
    @ReportItem(name = "telNo2", length = 14, order = 20)
    public RString telNo2;
    @ReportItem(name = "chiku3CodeTitle", length = 5, order = 21)
    public RString chiku3CodeTitle;
    @ReportItem(name = "chiku3Code", length = 8, order = 22)
    public RString chiku3Code;
    @ReportItem(name = "jusho1Code", length = 11, order = 23)
    public RString jusho1Code;
    @ReportItem(name = "gyoseikuTitle", length = 5, order = 24)
    public RString gyoseikuTitle;
    @ReportItem(name = "gyoseikuCode", length = 9, order = 25)
    public RString gyoseikuCode;
    @ReportItem(name = "jusho2", order = 26)
    public RString jusho2;
    @ReportItem(name = "jusho2Title", length = 10, order = 27)
    public RString jusho2Title;
    @ReportItem(name = "jusho2Code", length = 11, order = 28)
    public RString jusho2Code;
    @ReportItem(name = "listNo_1", length = 2, order = 29)
    public RString listNo_1;
    @ReportItem(name = "listUpper_1", length = 10, order = 30)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 10, order = 31)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 2, order = 32)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 6, order = 33)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 10, order = 34)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 36, order = 35)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 14, order = 36)
    public RString listUpper_7;
    @ReportItem(name = "listLower_1", length = 10, order = 37)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 10, order = 38)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 2, order = 39)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 6, order = 40)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 10, order = 41)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 36, order = 42)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 14, order = 43)
    public RString listLower_7;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
