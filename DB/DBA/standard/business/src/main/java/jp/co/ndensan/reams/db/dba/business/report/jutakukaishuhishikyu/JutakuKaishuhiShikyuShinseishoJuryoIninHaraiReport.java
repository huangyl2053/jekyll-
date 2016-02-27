/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu;

import jp.co.ndensan.reams.db.dba.entity.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のReportです。
 */
public class JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport extends Report<JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource> {

    private final JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のITEM
     * @return 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のReport
     */
    public static JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport createFrom(
            JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem item) {

        return new JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のITEM
     */
    protected JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport(
            JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource> reportSourceWriter) {
        IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiEditor editor = new JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItemEditor(item);
        IJutakuKaishuhiShikyuShinseishoJuryoIninHaraiBuilder builder = new JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItemBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
