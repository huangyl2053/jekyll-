/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100009;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100009.RiysFutgGengMenjKettTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 利用者負担額減額･免除認定決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengMenjKettTsuchishoReport extends Report<RiysFutgGengMenjKettTsuchishoReportSource> {

    private final RiysFutgGengMenjKettTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 利用者負担額減額･免除認定決定通知書
     * @return 利用者負担額減額･免除認定決定通知書
     */
    public static RiysFutgGengMenjKettTsuchishoReport createReport(@NonNull RiysFutgGengMenjKettTsuchishoItem bodyItem) {
        return new RiysFutgGengMenjKettTsuchishoReport(bodyItem);
    }

    private RiysFutgGengMenjKettTsuchishoReport(RiysFutgGengMenjKettTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiysFutgGengMenjKettTsuchishoReportSource> writer) {
        IRiysFutgGengMenjKettTsuchishoEditor bodyEditor = new RiysFutgGengMenjKettTsuchishoBodyEditor(bodyItem);
        IRiysFutgGengMenjKettTsuchishoBuider builder = new RiysFutgGengMenjKettTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
