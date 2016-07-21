/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link NinteiKoshinTsuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoProperty extends ReportPropertyBase<NinteiKoshinTsuchishoReportSource> {

    private static final ReportId ID = ReportIdDBD.DBDPR12002_1_1.getReportId();

    /**
     * インスタンスを生成します。
     */
    public NinteiKoshinTsuchishoProperty() {
        super(SubGyomuCode.DBD介護受給, ID);
    }
}
