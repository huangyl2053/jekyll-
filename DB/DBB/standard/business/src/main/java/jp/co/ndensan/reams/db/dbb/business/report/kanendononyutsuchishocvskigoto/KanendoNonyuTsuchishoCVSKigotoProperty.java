/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】のPropertyです。
 *
 * @reamsid_L DBB-9110-190 huangh
 */
public class KanendoNonyuTsuchishoCVSKigotoProperty extends ReportPropertyBase<KanendoNonyuTsuchishoCVSKigotoSource> {

    /**
     * インスタンスを生成します。
     */
    public KanendoNonyuTsuchishoCVSKigotoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100076.getReportId());
    }
}
