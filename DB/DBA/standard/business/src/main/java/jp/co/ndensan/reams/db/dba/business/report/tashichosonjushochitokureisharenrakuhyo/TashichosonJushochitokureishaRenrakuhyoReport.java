/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.entity.report.source.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険他市町村住所地特例者連絡票のReportです。
 */
public class TashichosonJushochitokureishaRenrakuhyoReport extends Report<TashichosonJushochitokureishaRenrakuhyoReportSource> {

    private final TashichosonJushochitokureishaRenrakuhyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険他市町村住所地特例者連絡票のITEM
     * @return 介護保険他市町村住所地特例者連絡票のReport
     */
    public static TashichosonJushochitokureishaRenrakuhyoReport createFrom(
            TashichosonJushochitokureishaRenrakuhyoItem item) {

        return new TashichosonJushochitokureishaRenrakuhyoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険他市町村住所地特例者連絡票のITEM
     */
    protected TashichosonJushochitokureishaRenrakuhyoReport(TashichosonJushochitokureishaRenrakuhyoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<TashichosonJushochitokureishaRenrakuhyoReportSource> reportSourceWriter) {
        TashichosonJushochitokureishaRenrakuhyoEditor editor = new TashichosonJushochitokureishaRenrakuhyoEditor(item);
        ITashichosonJushochitokureishaRenrakuhyoBuilder builder = new TashichosonJushochitokureishaRenrakuhyoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }

}
