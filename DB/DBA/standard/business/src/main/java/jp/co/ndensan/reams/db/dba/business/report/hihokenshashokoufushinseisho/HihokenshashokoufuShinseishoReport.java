/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険被保険者証交付申請書（第2号被保険者）のReportです。
 */
public class HihokenshashokoufuShinseishoReport extends Report<HihokenshashokoufuShinseishoReportSource> {

    private final HihokenshashokoufuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険被保険者証交付申請書（第2号被保険者）のITEM
     * @return 介護保険被保険者証交付申請書（第2号被保険者）のReport
     */
    public static HihokenshashokoufuShinseishoReport createFrom(
            HihokenshashokoufuShinseishoItem item) {

        return new HihokenshashokoufuShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険被保険者証交付申請書（第2号被保険者）のITEM
     */
    protected HihokenshashokoufuShinseishoReport(HihokenshashokoufuShinseishoItem item) {

        this.item = item;
    }

    /**
     * 介護保険被保険者証交付申請書（第2号被保険者）の印刷処理です。
     * @param reportSourceWriter 介護保険被保険者証交付申請書（第2号被保険者）の帳票データ
     */
    @Override
    public void writeBy(ReportSourceWriter<HihokenshashokoufuShinseishoReportSource> reportSourceWriter) {
        IHihokenshashokoufuShinseishoEditor editor = new HihokenshashokoufuShinseishoEditor(item);
        IHihokenshashokoufuShinseishoBuilder builder = new HihokenshashokoufuShinseishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
