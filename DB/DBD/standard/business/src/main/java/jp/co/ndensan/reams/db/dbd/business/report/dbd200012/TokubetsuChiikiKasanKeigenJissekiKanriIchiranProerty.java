/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200012;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public class TokubetsuChiikiKasanKeigenJissekiKanriIchiranProerty extends
        ReportPropertyBase<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200012.getReportId());
    }
}
