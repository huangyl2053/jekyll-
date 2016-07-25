/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link RiysFutgGengMenjNinteishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNinteishoProerty extends ReportPropertyBase<RiysFutgGengMenjNinteishoReportSource> {

    /**
     * コンストラクタです。
     *
     * @param reportId ReportId
     */
    public RiysFutgGengMenjNinteishoProerty(ReportId reportId) {
        super(SubGyomuCode.DBD介護受給, reportId);
    }
}
