/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200039_高額合算支給不支給決定通知書情報取込一覧表 のPropertyクラスです。
 *
 * @reamsid_L DBC-2690-030 qinzhen
 */
public class GassanShikyuTsuchishoTorikomiIchiranProperty extends
        ReportPropertyBase<GassanShikyuTsuchishoTorikomiIchiranSource> {

    /**
     * コンストラクタです。
     */
    public GassanShikyuTsuchishoTorikomiIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200039.getReportId());
    }
}
