/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100030;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100030.ShujiiIkenshoKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書確認書Propertyです。
 *
 * @reamsid_L DBD-5790-030 x_zhaowen
 */
public class ShujiiIkenshoKakuninshoProperty extends ReportPropertyBase<ShujiiIkenshoKakuninshoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoKakuninshoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100030.getReportId());
    }
}
