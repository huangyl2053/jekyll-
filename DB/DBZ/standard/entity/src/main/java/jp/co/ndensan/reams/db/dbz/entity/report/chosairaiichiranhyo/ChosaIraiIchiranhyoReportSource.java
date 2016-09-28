/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 認定調査依頼一覧表Sourceクラスです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
public class ChosaIraiIchiranhyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hakkoYMD", length = 12, order = 1)
    public RString hakkoYMD;
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
    @ReportItem(name = "yubinNo1", length = 8, order = 10)
    public RString yubinNo1;
    @ReportItem(name = "jushoText", order = 11)
    public RString jushoText;
    @ReportItem(name = "kikanNameText", order = 12)
    public RString kikanNameText;
    @ReportItem(name = "shimeiText", order = 13)
    public RString shimeiText;
    @ReportItem(name = "meishoFuyo", length = 3, order = 14)
    public RString meishoFuyo;
    @ReportItem(name = "jigyoshaNo", length = 12, order = 15)
    public RString jigyoshaNo;
    @ReportItem(name = "printTimeStamp", length = 34, order = 16)
    public RString printTimeStamp;
    @ReportItem(name = "listIchiranhyo_1", length = 2, order = 17)
    public RString listIchiranhyo_1;
    @ReportItem(name = "listIchiranhyo_2", length = 18, order = 18)
    public RString listIchiranhyo_2;
    @ReportItem(name = "listIchiranhyo_3", length = 10, order = 19)
    public RString listIchiranhyo_3;
    @ReportItem(name = "listIchiranhyo_4", length = 10, order = 20)
    public RString listIchiranhyo_4;
    @ReportItem(name = "listIchiranhyo_5", length = 8, order = 21)
    public RString listIchiranhyo_5;
    @ReportItem(name = "listIchiranhyo_6", length = 16, order = 22)
    public RString listIchiranhyo_6;
    @ReportItem(name = "listIchiranhyo_7", length = 30, order = 23)
    public RString listIchiranhyo_7;
    @ReportItem(name = "listIchiranhyo_8", length = 2, order = 24)
    public RString listIchiranhyo_8;
    @ReportItem(name = "listIchiranhyo_9", length = 10, order = 25)
    public RString listIchiranhyo_9;
    @ReportItem(name = "listIchiranhyo_10", length = 30, order = 26)
    public RString listIchiranhyo_10;
    @ReportItem(name = "listIchiranhyo_11", length = 13, order = 27)
    public RString listIchiranhyo_11;
    @ReportItem(name = "listIchiranhyo_12", length = 10, order = 28)
    public RString listIchiranhyo_12;
    @ReportItem(name = "tsuchibun1", order = 29)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", order = 30)
    public RString tsuchibun2;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
