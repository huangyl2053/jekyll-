/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosayoteimitei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosayoteimitei.NinteichosaYoteiMiteiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei.NinteichosaYoteiMiteiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査予定未定者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
public class NinteichosaYoteiMiteiReport extends Report<NinteichosaYoteiMiteiReportSource> {

    private final List<NinteichosaYoteiMiteiRelateEntity> data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public NinteichosaYoteiMiteiReport(List<NinteichosaYoteiMiteiRelateEntity> data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteichosaYoteiMiteiReportSource> reportSourceWriter) {
        for (int i = 0; i < data.size(); i++) {
            NinteichosaYoteiMiteiRelateEntity dataBody = data.get(i);
            INinteichosaYoteiMiteiEditor editor = new NinteichosaYoteiMiteiEditor(dataBody, i);
            INinteichosaYoteiMiteiBuilder builder = new NinteichosaYoteiMiteiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
        if (data.isEmpty()) {
            NinteichosaYoteiMiteiRelateEntity entity = new NinteichosaYoteiMiteiRelateEntity();
            entity.setDbT5101_hihokenshaName(new AtenaMeisho("該当データがありません"));
            INinteichosaYoteiMiteiEditor editor = new NinteichosaYoteiMiteiEditor(entity, -1);
            INinteichosaYoteiMiteiBuilder builder = new NinteichosaYoteiMiteiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
