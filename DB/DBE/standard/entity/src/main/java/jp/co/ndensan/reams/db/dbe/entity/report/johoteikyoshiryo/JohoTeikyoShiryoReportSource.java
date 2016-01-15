/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定結果情報提供票（主治医）のReportSourceクラスです。
 */
public class JohoTeikyoShiryoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD", length = 11, order = 1)
    public RString hakkoYMD;
    @ReportItem(name = "denshiKoin", order = 2)
    public RString denshiKoin;
    @ReportItem(name = "hokenshaName1", length = 25, order = 3)
    public RString hokenshaName1;
    @ReportItem(name = "hokenshaName2", length = 25, order = 4)
    public RString hokenshaName2;
    @ReportItem(name = "koinShoryaku", length = 10, order = 5)
    public RString koinShoryaku;
    @ReportItem(name = "title", length = 50, order = 6)
    public RString title;
    @ReportItem(name = "tsuchibun1", length = 40, order = 7)
    public RString tsuchibun1;
    @ReportItem(name = "hihokenshaName", order = 8)
    public RString hihokenshaName;
    @ReportItem(name = "Jusho", order = 9)
    public RString Jusho;
    @ReportItem(name = "infoNijiDate", length = 11, order = 10)
    public RString infoNijiDate;
    @ReportItem(name = "ninteiKekka", length = 4, order = 11)
    public RString ninteiKekka;
    @ReportItem(name = "yokaigoNiteiKaishoYMD", length = 11, order = 12)
    public RString yokaigoNiteiKaishoYMD;
    @ReportItem(name = "yokaigoNinteiShuryoYMD", length = 11, order = 13)
    public RString yokaigoNinteiShuryoYMD;
    @ReportItem(name = "shinsakaiIken", order = 14)
    public RString shinsakaiIken;
    @ReportItem(name = "tsuchibun2", length = 40, order = 15)
    public RString tsuchibun2;
    @ReportItem(name = "tsuchibun3", length = 40, order = 16)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 40, order = 17)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 40, order = 18)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 40, order = 19)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", length = 40, order = 20)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 40, order = 21)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 40, order = 22)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 40, order = 23)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 40, order = 24)
    public RString tsuchibun11;
    @ReportItem(name = "tsuchibun12", length = 40, order = 25)
    public RString tsuchibun12;
    @ReportItem(name = "tsuchibun13", length = 40, order = 26)
    public RString tsuchibun13;
    @ReportItem(name = "tsuchibun14", length = 40, order = 27)
    public RString tsuchibun14;
    @ReportItem(name = "tsuchibun15", length = 40, order = 28)
    public RString tsuchibun15;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
