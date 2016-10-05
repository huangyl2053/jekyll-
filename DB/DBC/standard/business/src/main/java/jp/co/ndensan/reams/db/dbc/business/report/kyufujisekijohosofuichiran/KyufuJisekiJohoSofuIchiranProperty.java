/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200053_給付実績情報送付一覧表　Propertyクラスです。
 *
 * @reamsid_L DBC-2460-030 lijian
 */
public class KyufuJisekiJohoSofuIchiranProperty extends ReportPropertyBase<KyufuJisekiJohoSofuIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public KyufuJisekiJohoSofuIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200053.getReportId());
    }

}
