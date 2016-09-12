/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800007;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0540-700 suguangjun
 */
public class TokubetsuChiikiKasanGenmenTaishoShinseishoProerty extends ReportPropertyBase<TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChiikiKasanGenmenTaishoShinseishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD800007.getReportId());
    }
}
