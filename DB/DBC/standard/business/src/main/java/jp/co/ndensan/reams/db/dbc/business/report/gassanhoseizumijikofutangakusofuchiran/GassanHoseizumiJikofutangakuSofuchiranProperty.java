/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanhoseizumijikofutangakusofuchiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanhoseizumijikofutangakusofuchiran.GassanHoseizumiJikofutangakuSofuchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200032_高額合算補正済自己負担額情報送付一覧表 Propertyクラスです。
 *
 * @reamsid_L DBC-2660-040 lijian
 */
public class GassanHoseizumiJikofutangakuSofuchiranProperty extends ReportPropertyBase<GassanHoseizumiJikofutangakuSofuchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public GassanHoseizumiJikofutangakuSofuchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200032.getReportId());
    }

}
