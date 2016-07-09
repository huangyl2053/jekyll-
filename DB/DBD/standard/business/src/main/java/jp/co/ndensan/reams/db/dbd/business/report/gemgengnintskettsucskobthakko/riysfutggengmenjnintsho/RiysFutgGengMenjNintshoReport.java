/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.riysfutggengmenjnintsho;

import jp.co.ndensan.reams.db.dbd.entity.report.riysfutggengmenjnintsho.RiyoshaFutangakuGengakuMenjoNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 利用者負担額減額・免除等認定証のReportです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNintshoReport extends Report<RiyoshaFutangakuGengakuMenjoNinteishoReportSource> {

    private final RiysFutgGengMenjNintshoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 利用者負担額減額・免除等認定証
     * @return 利用者負担額減額・免除等認定証
     */
    public static RiysFutgGengMenjNintshoReport createReport(@NonNull RiysFutgGengMenjNintshoItem bodyItem) {
        return new RiysFutgGengMenjNintshoReport(bodyItem);
    }

    private RiysFutgGengMenjNintshoReport(RiysFutgGengMenjNintshoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiyoshaFutangakuGengakuMenjoNinteishoReportSource> writer) {
        IRiysFutgGengMenjNintshoEditor bodyEditor = new RiysFutgGengMenjNintshoBodyEditor(bodyItem);
        IRiysFutgGengMenjNintshoBuider builder = new RiysFutgGengMenjNintshoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
