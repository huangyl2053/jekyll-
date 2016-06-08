/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 特別徴収開始通知書（仮算定）【B5横タイプ（連帳）】のプロパティです。
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty
        extends ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100004.getReportId());
    }

}
