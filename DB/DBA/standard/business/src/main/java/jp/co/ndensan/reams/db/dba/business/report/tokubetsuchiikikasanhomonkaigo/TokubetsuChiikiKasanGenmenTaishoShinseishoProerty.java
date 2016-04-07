/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigo;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigo.TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource}のプロパティです。
 * 
 * @reamsid_L DBA-0540-700  suguangjun
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoProerty extends ReportPropertyBase<TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800007.getReportId());
    }
}
