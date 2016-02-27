/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.futangendogakuninteishinseisho.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険負担限度額認定申請書のReportです。
 */
public final class FutangendogakuNinteiShinseishoReport extends Report<FutangendogakuNinteiShinseishoReportSource> {

    private final FutangendogakuNinteiShinseishoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 介護保険負担限度額認定申請書情報
     * @return 介護保険負担限度額認定申請書
     */
    public static FutangendogakuNinteiShinseishoReport createReport(@NonNull FutangendogakuNinteiShinseishoBodyItem bodyItem) {
        return new FutangendogakuNinteiShinseishoReport(bodyItem);
    }

    private FutangendogakuNinteiShinseishoReport(FutangendogakuNinteiShinseishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutangendogakuNinteiShinseishoReportSource> writer) {
        IFutangendogakuNinteiShinseishoEditor bodyEditor = new FutangendogakuNinteiShinseishoBodyEditor(bodyItem);
        IFutangendogakuNinteiShinseishoBuilder builder = new FutangendogakuNinteiShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
