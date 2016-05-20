/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）NonyuTsuchIchiranProperty
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class NonyuTsuchIchiranProperty extends ReportPropertyBase<NonyuTsuchIchiranSource> {

    /**
     * コンストラクタです。
     */
    public NonyuTsuchIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200010.getReportId());
    }
}
