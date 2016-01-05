package jp.co.ndensan.reams.db.dbe.entity.report.dbe223001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票「認定調査督促対象者一覧表」の項目を定義するクラスです。
 */
public class NinteiChosaTokusokujoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shomeiHakkoYMD", length = 22, order = 1)
    public RString shomeiHakkoYMD;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "shichosonMei", length = 40, order = 3)
    public RString shichosonMei;
    @ReportItem(name = "shuchoMei", length = 14, order = 4)
    public RString shuchoMei;
    @ReportItem(name = "koinShoryaku", length = 15, order = 5)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 6)
    public RString bunshoNo;
    @ReportItem(name = "hakkoYMD", length = 11, order = 7)
    public RString hakkoYMD;
    @ReportItem(name = "tsuchibun1", length = 48, order = 8)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 45, order = 9)
    public RString tsuchibun2;
    @ReportItem(name = "shinseiKubun", length = 2, order = 10)
    public RString shinseiKubun;
    @ReportItem(name = "hokenshaNo1", length = 1, order = 11)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 1, order = 12)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 1, order = 13)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 1, order = 14)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 1, order = 15)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 1, order = 16)
    public RString hokenshaNo6;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 17)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 18)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 19)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 20)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 21)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 22)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 23)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 24)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 25)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 26)
    public RString hihokenshaNo10;
    @ReportItem(name = "shinseiYMD", length = 11, order = 27)
    public RString shinseiYMD;
    @ReportItem(name = "hihokenshaNameKana", order = 28)
    public RString hihokenshaNameKana;
    @ReportItem(name = "seibetsuMan", length = 1, order = 29)
    public RString seibetsuMan;
    @ReportItem(name = "seibetsuWoman", length = 1, order = 30)
    public RString seibetsuWoman;
    @ReportItem(name = "hihokenshaName", order = 31)
    public RString hihokenshaName;
    @ReportItem(name = "birthGengoMeiji", length = 1, order = 32)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 1, order = 33)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 1, order = 34)
    public RString birthGengoShowa;
    @ReportItem(name = "birthYMD", length = 11, order = 35)
    public RString birthYMD;
    @ReportItem(name = "yubinNo", length = 8, order = 36)
    public RString yubinNo;
    @ReportItem(name = "jusho", order = 37)
    public RString jusho;
    @ReportItem(name = "tsuchibun3", length = 45, order = 38)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 45, order = 39)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 45, order = 40)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 45, order = 41)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", length = 45, order = 42)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 45, order = 43)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 45, order = 44)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 45, order = 45)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 45, order = 46)
    public RString tsuchibun11;
    @ReportItem(name = "tsuchibun12", length = 45, order = 47)
    public RString tsuchibun12;
    @ReportItem(name = "tsuchibun13", length = 45, order = 48)
    public RString tsuchibun13;
    @ReportItem(name = "tsuchibun14", length = 45, order = 49)
    public RString tsuchibun14;
    @ReportItem(name = "tsuchibun15", length = 45, order = 50)
    public RString tsuchibun15;
    @ReportItem(name = "tsuchibun16", length = 45, order = 51)
    public RString tsuchibun16;
    @ReportItem(name = "tsuchibun17", length = 45, order = 52)
    public RString tsuchibun17;
    @ReportItem(name = "tsuchibun18", length = 45, order = 53)
    public RString tsuchibun18;
    @ReportItem(name = "tsuchibun19", length = 45, order = 54)
    public RString tsuchibun19;
    @ReportItem(name = "remban", length = 4, order = 55)
    public RString remban;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
