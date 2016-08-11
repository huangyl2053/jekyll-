/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran.FutanWariaiShoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200090_負担割合証発行一覧表 Property
 *
 * @reamsid_L DBC-4990-061 pengxingyi
 */
public class FutanWariaiShoHakkoIchiranProperty extends ReportPropertyBase<FutanWariaiShoHakkoIchiranSource> {

    /**
     * インスタンスを生成します。
     */
    public FutanWariaiShoHakkoIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200090.getReportId());
    }
}
