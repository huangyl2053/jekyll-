/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101detail;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101detail.FurikomiMeisaiIchiranDetailReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FurikomiMeisaiIchiranDetailReportSource}のプロパティです。
 *
 * @reamsid_L DBC-2180-050 b_liuyang2
 */
public class FurikomiMeisaiIchiranDetailProerty extends ReportPropertyBase<FurikomiMeisaiIchiranDetailReportSource> {

    /**
     * コンストラクタです。
     */
    public FurikomiMeisaiIchiranDetailProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200101_明細.getReportId());
    }
}
