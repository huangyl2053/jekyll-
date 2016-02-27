/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashosaikoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashosaikoufushinseisho.HihokenshashoSaikoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 介護保険被保険者証等再交付申請書のReportです。
 */
public final class HihokenshashoSaikoufuShinseishoReport extends Report<HihokenshashoSaikoufuShinseishoReportSource> {

    private final HihokenshashoSaikoufuShinseishoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem 介護保険被保険者証等再交付申請書情報
     * @return 介護保険被保険者証等再交付申請書
     */
    public static HihokenshashoSaikoufuShinseishoReport createReport(@NonNull HihokenshashoSaikoufuShinseishoBodyItem bodyItem) {
        return new HihokenshashoSaikoufuShinseishoReport(bodyItem);
    }

    private HihokenshashoSaikoufuShinseishoReport(HihokenshashoSaikoufuShinseishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<HihokenshashoSaikoufuShinseishoReportSource> writer) {
        IHihokenshashoSaikoufuShinseishoEditor bodyEditor = new HihokenshashoSaikoufuShinseishoBodyEditor(bodyItem);
        IHihokenshashoSaikoufuShinseishoBuilder builder = new HihokenshashoSaikoufuShinseishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }
}
