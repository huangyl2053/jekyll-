/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 Property クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
public class TokubetsuChoshuIdojohoIchiranProperty extends ReportPropertyBase<TokubetsuChoshuIdojohoIchiranSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuIdojohoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200021.getReportId());
    }
}
