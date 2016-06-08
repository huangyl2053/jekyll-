/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource}のプロパティです。
 * 
 * @reamsid_L DBA-0540-700  suguangjun 
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoBackProerty extends
        ReportPropertyBase<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoBackProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBD800007_Back.getReportId());
    }
}
