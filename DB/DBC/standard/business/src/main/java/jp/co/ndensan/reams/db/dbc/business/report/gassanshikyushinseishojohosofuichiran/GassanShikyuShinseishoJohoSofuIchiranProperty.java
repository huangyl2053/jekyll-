/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のPropertyクラスです。
 *
 * @reamsid_L DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranProperty extends ReportPropertyBase<GassanShikyuShinseishoJohoSofuIchiranSource> {

    /**
     * コンストラクタです。
     */
    public GassanShikyuShinseishoJohoSofuIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200027.getReportId());
    }
}
