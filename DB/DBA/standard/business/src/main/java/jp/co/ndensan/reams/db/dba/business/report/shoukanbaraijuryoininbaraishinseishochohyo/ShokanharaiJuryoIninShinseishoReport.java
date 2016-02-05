/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo;

import jp.co.ndensan.reams.db.dba.entity.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険償還払受領委任払申請書の帳票を作成します。
 */
public class ShokanharaiJuryoIninShinseishoReport extends
        Report<ShokanharaiJuryoIninShinseishoReportSource> {

    private final ShokanharaiJuryoIninShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険償還払受領委任払申請書のItem
     * @return 介護保険償還払受領委任払申請書のReport
     */
    public static ShokanharaiJuryoIninShinseishoReport createFrom(
            ShokanharaiJuryoIninShinseishoItem item) {
        return new ShokanharaiJuryoIninShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険償還払受領委任払申請書のItem
     */
    protected ShokanharaiJuryoIninShinseishoReport(ShokanharaiJuryoIninShinseishoItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanharaiJuryoIninShinseishoReportSource> reportSourceWriter) {
        IShokanharaiJuryoIninShinseishoEditor editor = new ShokanharaiJuryoIninShinseishoEditorImpl(item);
        IShokanharaiJuryoIninShinseishoBuilder builder = new ShokanharaiJuryoIninShinseishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
