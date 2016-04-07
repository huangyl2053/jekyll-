/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査会スケジュール表かがみのプロパティです。
 *
 * @reamsid_L DBE-0130-080 xuyannan
 */
public class ShinsaschedulekagamiProperty extends ReportPropertyBase<ShinsaschedulekagamiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsaschedulekagamiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE514002.getReportId());
    }
}
