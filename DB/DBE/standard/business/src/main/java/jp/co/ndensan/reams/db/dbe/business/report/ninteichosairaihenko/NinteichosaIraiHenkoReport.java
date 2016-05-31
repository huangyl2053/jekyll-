/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosairaihenko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaihenko.NinteichosaIraiHenkoData;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko.NinteichosaIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査依頼先変更者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
public class NinteichosaIraiHenkoReport extends Report<NinteichosaIraiHenkoReportSource> {

    private final List<NinteichosaIraiHenkoData> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 認定調査依頼先変更者一覧表のdataList
     */
    public NinteichosaIraiHenkoReport(List<NinteichosaIraiHenkoData> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteichosaIraiHenkoReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            NinteichosaIraiHenkoData dataBody = data.get(i);
            INinteichosaIraiHenkoEditor editor = new NinteichosaIraiHenkoEditor(dataBody, i);
            INinteichosaIraiHenkoBuilder builder = new NinteichosaIraiHenkoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            NinteichosaIraiHenkoData dataBody = new NinteichosaIraiHenkoData();
            dataBody.set氏名(new AtenaMeisho("該当データがありません"));
            INinteichosaIraiHenkoEditor editor = new NinteichosaIraiHenkoEditor(dataBody, -1);
            INinteichosaIraiHenkoBuilder builder = new NinteichosaIraiHenkoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
