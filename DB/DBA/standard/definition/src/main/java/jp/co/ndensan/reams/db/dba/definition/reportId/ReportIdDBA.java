/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.definition.reportId;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBA {
    
    /**
     * 被保険者証発行一覧表の帳票ＩＤです。
     */
    DBA200003(new ReportId("DBA200003"), new RString("被保険者証発行一覧表")),
    /**
     * 被保険者証発行一覧表の帳票ＩＤです。
     */
    DBA100001(new ReportId("DBA100001"), new RString("介護保険被保険者証（B4版）")),
    /**
     * 被保険者証発行一覧表の帳票ＩＤです。
     */
    DBA800001(new ReportId("DBA800001"), new RString("介護保険資格取得・異動・喪失届"));
    
    private final ReportId reportId;
    private final RString reportName;
    
    private ReportIdDBA(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }
    
    /**
     * 帳票ＩＤの取得します。
     * @return 帳票ＩＤ
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票Nameの取得します。
     * @return 帳票Name
     */
    public RString getReportName() {
        return reportName;
    }
    
}
