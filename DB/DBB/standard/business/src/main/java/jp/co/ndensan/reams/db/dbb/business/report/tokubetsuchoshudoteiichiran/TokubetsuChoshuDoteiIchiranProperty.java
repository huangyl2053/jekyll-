/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR81003_1_特別徴収同定一覧表のProperty
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
public class TokubetsuChoshuDoteiIchiranProperty extends ReportPropertyBase<TokubetsuChoshuDoteiIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuDoteiIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200031.getReportId());
    }
}
