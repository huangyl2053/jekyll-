/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kohijukyushabetsuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kohijukyushabetsuichiran.KohijukyushaBetsuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護給付費公費受給者別一覧表のプロパティです。
 *
 * @reamsid_L DBC-2800-030 xuyannan
 */
public class KohijukyushaBetsuIchiranProperty
        extends ReportPropertyBase<KohijukyushaBetsuIchiranReportSource> {

    /**
     * コンストラクタです。
     */
    public KohijukyushaBetsuIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200008.getReportId());
    }

}
