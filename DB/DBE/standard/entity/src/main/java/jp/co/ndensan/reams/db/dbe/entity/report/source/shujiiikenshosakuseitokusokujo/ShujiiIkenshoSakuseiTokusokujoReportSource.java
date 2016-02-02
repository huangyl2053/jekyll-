/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 主治医意見書提出督促状のReportSourceです。
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD1", length = 12, order = 1)
    public RString hakkoYMD1;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 3)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "ninshoshaYakushokuMei2", order = 4)
    public RString ninshoshaYakushokuMei2;
    @ReportItem(name = "ninshoshaYakushokuMei1", order = 5)
    public RString ninshoshaYakushokuMei1;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 6)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 7)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 8)
    public RString koinMojiretsu;
    @ReportItem(name = "koinShoryaku", length = 15, order = 9)
    public RString koinShoryaku;
    @ReportItem(name = "bunshoNo", length = 35, order = 10)
    public RString bunshoNo;
    @ReportItem(name = "tsuchibun1", order = 11)
    public RString tsuchibun1;
    @ReportItem(name = "shinseiKubun", length = 2, order = 12)
    public RString shinseiKubun;
    @ReportItem(name = "hokenshaNo1", length = 1, order = 13)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 1, order = 14)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 1, order = 15)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 1, order = 16)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 1, order = 17)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 1, order = 18)
    public RString hokenshaNo6;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 19)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 20)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 21)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 22)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 23)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 24)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 25)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 26)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 27)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 28)
    public RString hihokenshaNo10;
    @ReportItem(name = "shinseiYMD", length = 11, order = 29)
    public RString shinseiYMD;
    @ReportItem(name = "hihokenshaNameKana", order = 30)
    public RString hihokenshaNameKana;
    @ReportItem(name = "seibetsuMan", length = 1, order = 31)
    public RString seibetsuMan;
    @ReportItem(name = "seibetsuWoman", length = 1, order = 32)
    public RString seibetsuWoman;
    @ReportItem(name = "hihokenshaName", order = 33)
    public RString hihokenshaName;
    @ReportItem(name = "birthGengoMeiji", length = 1, order = 34)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 1, order = 35)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 1, order = 36)
    public RString birthGengoShowa;
    @ReportItem(name = "birthYMD", length = 11, order = 37)
    public RString birthYMD;
    @ReportItem(name = "yubinNo", length = 8, order = 38)
    public RString yubinNo;
    @ReportItem(name = "jusho", order = 39)
    public RString jusho;
    @ReportItem(name = "tsuchibun2", order = 40)
    public RString tsuchibun2;
    @ReportItem(name = "shoriName", length = 4, order = 41)
    public RString shoriName;
    @ReportItem(name = "remban", length = 4, order = 42)
    public RString remban;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
