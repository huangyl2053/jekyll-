/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tsuikashiryokagami.TsuikashiryokagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia4.TsuikashiryokagamiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 追加資料鑑のReportです。
 *
 * @reamsid_L DBE-0150-180 wangrenze
 */
public class TsuikashiryokagamiA4Report extends Report<TsuikashiryokagamiA4ReportSource> {

    private final TsuikashiryokagamiEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public TsuikashiryokagamiA4Report(TsuikashiryokagamiEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuikashiryokagamiA4ReportSource> reportSourceWriter) {

        ITsuikashiryokagamiA4Editor editor = new TsuikashiryokagamiA4Editor(data);
        ITsuikashiryokagamiA4Builder builder = new TsuikashiryokagamiA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
