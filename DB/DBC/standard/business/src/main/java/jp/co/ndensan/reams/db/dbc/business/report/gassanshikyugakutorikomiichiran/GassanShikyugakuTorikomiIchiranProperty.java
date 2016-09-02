/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakutorikomiichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakutorikomiichiran.GassanShikyugakuTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200037_高額合算支給額計算結果連絡票情報取込一覧表のPropertyクラスです。
 *
 * @reamsid_L DBC-2680-030 qinzhen
 */
public class GassanShikyugakuTorikomiIchiranProperty extends
        ReportPropertyBase<GassanShikyugakuTorikomiIchiranSource> {

    /**
     * コンストラクタです。
     */
    public GassanShikyugakuTorikomiIchiranProperty() {

        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200037.getReportId());
    }
}
