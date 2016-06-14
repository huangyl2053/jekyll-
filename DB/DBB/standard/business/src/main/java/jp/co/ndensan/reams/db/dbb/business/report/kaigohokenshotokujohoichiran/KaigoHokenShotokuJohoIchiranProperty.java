/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のProperty
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranProperty extends ReportPropertyBase<KaigoHokenShotokuJohoIchiranSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenShotokuJohoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200008.getReportId());
    }
}
