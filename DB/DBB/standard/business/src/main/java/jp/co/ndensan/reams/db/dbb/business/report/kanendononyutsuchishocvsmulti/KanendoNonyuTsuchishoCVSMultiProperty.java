/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvsmulti;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】のEditorです。
 *
 * @reamsid_L DBB-9110-170 huangh
 */
public class KanendoNonyuTsuchishoCVSMultiProperty extends ReportPropertyBase<KanendoNonyuTsuchishoCVSMultiSource> {

    /**
     * インスタンスを生成します。
     */
    public KanendoNonyuTsuchishoCVSMultiProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100075.getReportId());
    }
}
