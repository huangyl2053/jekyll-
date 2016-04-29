/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoPropertyクラスです。
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty
        extends ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100009.getReportId());
    }
}
