/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200044_給付費通知発行一覧表のプロパティです。
 *
 * @reamsid_L DBC-2280-080 lizhuoxuan
 */
public class KyufuhiTuchiHakkoIchiranProperty extends ReportPropertyBase<KyufuhiTuchiHakkoIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiTuchiHakkoIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200044.getReportId());
    }
}
