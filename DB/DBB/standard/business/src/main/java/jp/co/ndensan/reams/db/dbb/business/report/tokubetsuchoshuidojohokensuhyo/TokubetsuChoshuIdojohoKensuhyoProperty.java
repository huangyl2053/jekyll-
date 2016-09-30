/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Property
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoProperty extends ReportPropertyBase<TokubetsuChoshuIdojohoKensuhyoSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuIdojohoKensuhyoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200022.getReportId());
    }
}
