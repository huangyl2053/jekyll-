/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.fukushiyogukonyuhi;

import jp.co.ndensan.reams.db.dba.entity.report.fukushiyogukonyuhi.FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のReportです。
 */
public class FukushiYoguKonyuhiShinseishoJuryoIninHaraiReport extends Report<FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource> {

    private final FukushiYoguKonyuhiShinseishoJuryoIninHaraiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のITEM
     * @return 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のReport
     */
    public static FukushiYoguKonyuhiShinseishoJuryoIninHaraiReport createFrom(
            FukushiYoguKonyuhiShinseishoJuryoIninHaraiItem item) {

        return new FukushiYoguKonyuhiShinseishoJuryoIninHaraiReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書のITEM
     */
    protected FukushiYoguKonyuhiShinseishoJuryoIninHaraiReport(
            FukushiYoguKonyuhiShinseishoJuryoIninHaraiItem item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<FukushiYoguKonyuhiShinseishoJuryoIninHaraiReportSource> reportSourceWriter) {
        IFukushiYoguKonyuhiShinseishoJuryoIninHaraiEditor editor = new FukushiYoguKonyuhiShinseishoJuryoIninHaraiItemEditor(item);
        IFukushiYoguKonyuhiShinseishoJuryoIninHaraiBuilder builder = new FukushiYoguKonyuhiShinseishoJuryoIninHaraiItemBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
