/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohokensuhyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraijohokensuhyo.TokubetsuChoshuIraiJohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR82001_2_特別徴収依頼情報件数表のPropertyクラスです。
 *
 * @reamsid_L DBB-1840-070 wangxingpeng
 */
public class TokubetsuChoshuIraiJohoKensuhyoProperty
        extends ReportPropertyBase<TokubetsuChoshuIraiJohoKensuhyoSource> {

    /**
     * コンストラクタです。
     *
     */
    public TokubetsuChoshuIraiJohoKensuhyoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200020.getReportId());
    }
}
