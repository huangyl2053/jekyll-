/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosayoteimitei.NinteichosaYoteiMiteiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei.NinteichosaYoteiMiteiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査予定未定者一覧表のReportです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
public class NinteichosaYoteiMiteiReport extends Report<NinteichosaYoteiMiteiReportSource> {

    private final NinteichosaYoteiMiteiRelateEntity data;
    private final int index_tmp;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     * @param index_tmp index_tmp
     */
    public NinteichosaYoteiMiteiReport(NinteichosaYoteiMiteiRelateEntity data,
            int index_tmp) {
        this.data = data;
        this.index_tmp = index_tmp;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteichosaYoteiMiteiReportSource> reportSourceWriter) {
        INinteichosaYoteiMiteiEditor editor = new NinteichosaYoteiMiteiEditor(data, index_tmp);
        INinteichosaYoteiMiteiBuilder builder = new NinteichosaYoteiMiteiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
