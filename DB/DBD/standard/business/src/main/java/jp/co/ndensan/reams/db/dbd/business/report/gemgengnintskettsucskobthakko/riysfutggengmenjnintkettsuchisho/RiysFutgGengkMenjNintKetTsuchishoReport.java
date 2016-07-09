/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.riysfutggengmenjnintkettsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.riysfutggengmenjnintkettsuchisho.RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 利用者負担額減額･免除認定決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-070 wangchao
 */
public class RiysFutgGengkMenjNintKetTsuchishoReport extends Report<RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource> {

    private final RiysFutgGengkMenjNintKetTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 利用者負担額減額･免除認定決定通知書
     * @return 利用者負担額減額･免除認定決定通知書
     */
    public static RiysFutgGengkMenjNintKetTsuchishoReport createReport(@NonNull RiysFutgGengkMenjNintKetTsuchishoItem bodyItem) {
        return new RiysFutgGengkMenjNintKetTsuchishoReport(bodyItem);
    }

    private RiysFutgGengkMenjNintKetTsuchishoReport(RiysFutgGengkMenjNintKetTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<RiyoshaFutangakuGengakuMenjoKetteiTsuchishoReportSource> writer) {
        IRiysFutgGengkMenjNintKetTsuchishoEditor bodyEditor = new RiysFutgGengkMenjNintKetTsuchishoBodyEditor(bodyItem);
        IRiysFutgGengkMenjNintKetTsuchishoBuider builder = new RiysFutgGengkMenjNintKetTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
