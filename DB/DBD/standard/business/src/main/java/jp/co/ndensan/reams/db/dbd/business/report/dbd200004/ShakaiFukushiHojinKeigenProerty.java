/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200004;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200004.ShakaiFukushiHojinReportSourse;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShakaiFukushiHojinReportSourse}のプロパティです。
 *
 * @reamsid_L DBD-3830-060 tianyh
 */
public class ShakaiFukushiHojinKeigenProerty extends ReportPropertyBase<ShakaiFukushiHojinReportSourse> {

    /**
     * コンストラクタです。
     */
    public ShakaiFukushiHojinKeigenProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200004.getReportId());
    }
}
