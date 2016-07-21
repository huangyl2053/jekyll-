/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550002;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550002.ServiceHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ServiceHenkoTshuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1430-040 b_zhengs
 */
public class ServiceHenkoTshuchishoProperty extends ReportPropertyBase<ServiceHenkoTshuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ServiceHenkoTshuchishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550002.getReportId());
    }

}
