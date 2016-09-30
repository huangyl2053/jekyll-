/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 Propertyクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranProperty extends ReportPropertyBase<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200088.getReportId());
    }
}
