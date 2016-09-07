/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshumidoteiichiran.TokubetsuChoshuMidoteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR81003_2_特別徴収未同定一覧表のPropertyです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
public class TokubetsuChoshuMidoteiIchiranProperty extends ReportPropertyBase<TokubetsuChoshuMidoteiIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuMidoteiIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200032.getReportId());
    }

}
