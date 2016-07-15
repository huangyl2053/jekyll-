/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100009;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100009.RiysFutgGengMenjKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link RiysFutgGengMenjKettTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengMenjKettTsuchishoProerty extends ReportPropertyBase<RiysFutgGengMenjKettTsuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public RiysFutgGengMenjKettTsuchishoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100009.getReportId());
    }
}
