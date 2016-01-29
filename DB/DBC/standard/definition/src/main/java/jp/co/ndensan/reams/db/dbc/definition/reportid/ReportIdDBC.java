/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBC {

    /**
     * 住宅改修事前申請承認結果通知書の帳票ＩＤです。
     */
    DBC100001(new ReportId("DBC100001"), new RString("住宅改修事前申請承認結果通知書")),
    /**
     * 償還払い支給（不支給）決定通知書の帳票ＩＤです。
     */
    DBC100002(new ReportId("DBC100002"), new RString("償還払い支給（不支給）決定通知書")),
    /**
     * 償還払い支給（不支給）決定通知書(支払予定日あり）の帳票ＩＤです。
     */
    DBC100003(new ReportId("DBC100003"), new RString("償還払い支給（不支給）決定通知書(支払予定日あり）"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBC(ReportId reportId, RString reportName) {
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
