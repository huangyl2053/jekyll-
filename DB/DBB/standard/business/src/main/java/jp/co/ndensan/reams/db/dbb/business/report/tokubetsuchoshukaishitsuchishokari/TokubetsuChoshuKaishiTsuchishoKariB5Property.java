/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 特別徴収開始通知書（仮算定）【B5横タイプ】のプロパティです。
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariB5Property
        extends ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariB5Source> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKaishiTsuchishoKariB5Property() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100003.getReportId());
    }

}
