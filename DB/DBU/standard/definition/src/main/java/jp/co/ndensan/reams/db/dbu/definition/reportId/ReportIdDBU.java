/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.reportId;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBU {

    /**
     * 境界層管理マスタリストの帳票ID。
     */
    DBA200005(new ReportId("DBA200005"), new RString("境界層管理マスタリスト")),
    /**
     * 弁明書の帳票ＩＤです。
     */
    DBU100001(new ReportId("DBU100001_Bemmeisyo"), new RString("弁明書")),
    DBA200011(new ReportId("DBA200011_KoikinaiTenkyoKekkaIchiranhyo"), new RString("介護保険　広域内転居結果一覧表"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBU(ReportId reportId, RString reportName) {
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
