/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinseimonitor;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定申請モニタリストのプロパティです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
public class ShinseiMonitorProperty extends ReportPropertyBase<ShinseiMonitorReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinseiMonitorProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE011002.getReportId());
    }
}
