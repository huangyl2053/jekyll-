/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収開始通知書（本算定）帳票【B5横タイプ】
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoB5Property
        extends ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoB5Source> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKaishiTsuchishoB5Property() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100032.getReportId());
    }

}
