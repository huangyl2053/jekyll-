/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaihenko.NinteichosaIraiHenkoData;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko.NinteichosaIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査依頼先変更者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
public class NinteichosaIraiHenkoReport extends Report<NinteichosaIraiHenkoReportSource> {

    private final NinteichosaIraiHenkoData data;
    private final int indexTmp;

    /**
     * インスタンスを生成します。
     *
     * @param data 認定調査依頼先変更者一覧表のdataList
     * @param indexTmp No
     */
    public NinteichosaIraiHenkoReport(NinteichosaIraiHenkoData data, int indexTmp) {
        this.data = data;
        this.indexTmp = indexTmp;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteichosaIraiHenkoReportSource> reportSourceWriter) {
        INinteichosaIraiHenkoEditor editor = new NinteichosaIraiHenkoEditor(data, indexTmp);
        INinteichosaIraiHenkoBuilder builder = new NinteichosaIraiHenkoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
