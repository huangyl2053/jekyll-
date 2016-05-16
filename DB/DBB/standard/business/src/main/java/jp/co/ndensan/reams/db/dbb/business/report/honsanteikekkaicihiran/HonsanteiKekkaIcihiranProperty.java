/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 「本算定賦課計算」property
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranProperty extends ReportPropertyBase<HonsanteiKekkaIcihiranReportSource> {

    /**
     * コンストラクタです。
     */
    public HonsanteiKekkaIcihiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200009.getReportId());
    }
}
