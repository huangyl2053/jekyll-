/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100013;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100013.FutanGendogakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 負担限度額決定通知書のReportです。
 *
 * @reamsid_L DBD-3540-050 wangchao
 */
public final class FutanGendogakuKetteiTsuchishoReport extends Report<FutanGendogakuKetteiTsuchishoReportSource> {

    private final FutanGendogakuKetteiTsuchishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 負担限度額決定通知書
     * @return 負担限度額決定通知書
     */
    public static FutanGendogakuKetteiTsuchishoReport createReport(@NonNull FutanGendogakuKetteiTsuchishoItem bodyItem) {
        return new FutanGendogakuKetteiTsuchishoReport(bodyItem);
    }

    private FutanGendogakuKetteiTsuchishoReport(FutanGendogakuKetteiTsuchishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuKetteiTsuchishoReportSource> writer) {
        IFutanGendogakuKetteiTsuchishoEditor bodyEditor = new FutanGendogakuKetteiTsuchishoBodyEditor(bodyItem);
        IFutanGendogakuKetteiTsuchishoBuider builder = new FutanGendogakuKetteiTsuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
