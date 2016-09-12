/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskakuko;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】のEditorです。
 *
 * @reamsid_L DBB-9110-180 huangh
 */
public class KanendoNonyuTsuchishoCVSKakukoProperty extends ReportPropertyBase<KanendoNonyuTsuchishoCVSKakukoSource> {

    /**
     * インスタンスを生成します。
     */
    public KanendoNonyuTsuchishoCVSKakukoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100073.getReportId());
    }
}
