/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 利用者負担額減額・免除等認定証のReportです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNinteishoReport extends Report<RiysFutgGengMenjNinteishoReportSource> {

    private final RiysFutgGengMenjNinteishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 利用者負担額減額・免除等認定証
     * @return 利用者負担額減額・免除等認定証
     */
    public static RiysFutgGengMenjNinteishoReport createReport(@NonNull RiysFutgGengMenjNinteishoItem bodyItem) {
        return new RiysFutgGengMenjNinteishoReport(bodyItem);
    }

    private RiysFutgGengMenjNinteishoReport(RiysFutgGengMenjNinteishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiysFutgGengMenjNinteishoReportSource> writer) {
        IRiysFutgGengMenjNinteishoEditor bodyEditor = new RiysFutgGengMenjNinteishoBodyEditor(bodyItem);
        IRiysFutgGengMenjNinteishoBuider builder = new RiysFutgGengMenjNinteishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
