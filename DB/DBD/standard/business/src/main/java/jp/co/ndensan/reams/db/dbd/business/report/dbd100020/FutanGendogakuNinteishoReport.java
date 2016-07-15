/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100020.FutanGendogakuNinteishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 負担限度額認定証のReportです。
 *
 * @reamsid_L DBD-3540-040 wangchao
 */
public class FutanGendogakuNinteishoReport extends Report<FutanGendogakuNinteishoReportSource> {

    private final FutanGendogakuNinteishoItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 負担限度額認定証
     * @return 負担限度額認定証
     */
    public static FutanGendogakuNinteishoReport createReport(@NonNull FutanGendogakuNinteishoItem bodyItem) {
        return new FutanGendogakuNinteishoReport(bodyItem);
    }

    private FutanGendogakuNinteishoReport(FutanGendogakuNinteishoItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuNinteishoReportSource> writer) {
        IFutanGendogakuNinteishoEditor bodyEditor = new FutanGendogakuNinteishoBodyEditor(bodyItem);
        IFutanGendogakuNinteishoBuider builder = new FutanGendogakuNinteishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
