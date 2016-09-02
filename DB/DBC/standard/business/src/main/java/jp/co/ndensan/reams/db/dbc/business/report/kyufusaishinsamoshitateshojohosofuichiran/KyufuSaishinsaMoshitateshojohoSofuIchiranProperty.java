/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 Propertyクラスです。
 *
 * @reamsid_L DBC-2540-040 lijian
 */
public class KyufuSaishinsaMoshitateshojohoSofuIchiranProperty extends ReportPropertyBase<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public KyufuSaishinsaMoshitateshojohoSofuIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200047.getReportId());
    }

}
