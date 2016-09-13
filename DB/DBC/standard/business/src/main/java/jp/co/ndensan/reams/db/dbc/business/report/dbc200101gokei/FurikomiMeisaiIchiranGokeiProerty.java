/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101gokei;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101gokei.FurikomiMeisaiIchiranGokeiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link FurikomiMeisaiIchiranGokeiReportSource}のプロパティです。
 *
 * @reamsid_L DBC-2180-040 b_liuyang2
 */
public class FurikomiMeisaiIchiranGokeiProerty extends ReportPropertyBase<FurikomiMeisaiIchiranGokeiReportSource> {

    /**
     * コンストラクタです。
     */
    public FurikomiMeisaiIchiranGokeiProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200101_合計.getReportId());
    }
}
