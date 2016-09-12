/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBA-9999-021 zhengsongling
 */
public enum ReportIdDBZ {

    /**
     * 要介護認定調査票差異チェック票(両面左)の帳票ＩＤです。
     */
    DBE292003(new ReportId("DBE292003_SaiChekkuhyoHidari"), new RString("要介護認定調査票差異チェック票(両面左)")),
    /**
     * 要介護認定調査票差異チェック票(両面右)の帳票ＩＤです。
     */
    DBE292002(new ReportId("DBE292002_SaiChekkuhyoMigi"), new RString("要介護認定調査票差異チェック票(両面右)")),
    /**
     * 主治医意見書作成料請求書です。
     */
    DBE234001(new ReportId("DBE234001_ShujiiIkenshoSakuseiRyoSeikyusho"), new RString("主治医意見書作成料請求書")),
    /**
     * 主治医意見書作成依頼書の帳票ＩＤです。
     */
    DBE230001(new ReportId("DBE230001_ShujiiIkenshoSakuseiIraisho"), new RString("主治医意見書作成依頼書")),
    /**
     * 要介護認定調査票差異チェック票(片面)の帳票ＩＤです。
     */
    DBE292001(new ReportId("DBE292001_SaiChekkuhyo"), new RString("要介護認定調査票差異チェック票")),
    /**
     * 要介護認定調査票（特記事項）フリー様式の帳票ＩＤです。
     */
    DBE221022_2(new ReportId("DBE221022_chosahyoTokkijiko"), new RString("要介護認定調査票（特記事項）フリー様式")),
    /**
     * 要介護認定調査票（特記事項）の帳票ＩＤです。
     */
    DBE221022_1(new ReportId("DBE221022_chosahyoTokkijiko"), new RString("要介護認定調査票（特記事項）")),
    /**
     * 要介護認定調査票（概況特記）の帳票ID。
     */
    DBE221051(new ReportId("DBE221051_GaikyotokkiA4"), new RString("要介護認定調査票（概況特記）")),
    /**
     * 要介護認定調査票（概況調査）の帳票ＩＤです。
     */
    DBE221011(new ReportId("DBE221011_chosahyoGaikyochosa"), new RString("要介護認定調査票（概況調査）")),
    /**
     * 介護保険診断命令書の帳票ＩＤです。
     */
    DBE235001(new ReportId("DBE235001_kaigohokenShindanMeireisho"), new RString("介護保険診断命令書")),
    /**
     * 主治医意見書作成依頼一覧の帳票ＩＤです。
     */
    DBE230002(
            new ReportId("DBE230002_IkenshoSakuseiIraiIchiranhyo"), new RString("主治医意見書作成依頼一覧")),
    /**
     * 要介護認定主治医意見書記入用紙の帳票ＩＤです。
     */
    DBE231001(new ReportId("DBE231001_ikenshokinyuyoshi"), new RString("要介護認定主治医意見書記入用紙")),
    /**
     * 要介護認定調査依頼書の帳票ＩＤです。
     */
    DBE220001(
            new ReportId("DBE220001_ChosaIraisho"), new RString("要介護認定調査依頼書")),
    /**
     * 認定調査依頼一覧表の帳票ＩＤです。
     */
    DBE220002(
            new ReportId("DBE220002_ChosaIraiIchiranhyo"), new RString("認定調査依頼一覧表")),
    /**
     * 要介護認定調査票（基本調査）の帳票ＩＤです。
     */
    DBE221012(new ReportId("DBE221012_chosahyoKihonchosa"), new RString("要介護認定調査票（基本調査）")),
    /**
     * 宛名シールの帳票ＩＤです。
     */
    DBZ100001(new ReportId("DBZ100001_AtenaSeal"), new RString("宛名シール"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBZ(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    /**
     * 帳票ＩＤの取得します。
     *
     * @return 帳票ＩＤ
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票Nameの取得します。
     *
     * @return 帳票Name
     */
    public RString getReportName() {
        return reportName;
    }

}
