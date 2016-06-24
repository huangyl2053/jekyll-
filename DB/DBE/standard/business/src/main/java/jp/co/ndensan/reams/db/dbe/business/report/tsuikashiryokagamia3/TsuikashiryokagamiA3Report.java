/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tsuikashiryokagami.TsuikashiryokagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 追加資料鑑のReportです。
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA3Report extends Report<TsuikashiryokagamiA3ReportSource> {

    private final TsuikashiryokagamiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public TsuikashiryokagamiA3Report(TsuikashiryokagamiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuikashiryokagamiA3ReportSource> reportSourceWriter) {

        ITsuikashiryokagamiA3Editor editor = new TsuikashiryokagamiA3Editor(data);
        ITsuikashiryokagamiA3Builder builder = new TsuikashiryokagamiA3Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
