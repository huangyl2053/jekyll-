/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tsuikashiryokagamia3;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tsuikashiryokagamia3.TsuikashiryokagamiA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 追加資料鑑（A3版）のReportです。
 *
 * @reamsid_L DBE-0150-410 wangrenze
 */
public class TsuikashiryokagamiA3Report extends Report<TsuikashiryokagamiA3ReportSource> {

    private final JimuTuikaSiryoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 申請に関する帳票発行
     */
    public TsuikashiryokagamiA3Report(JimuTuikaSiryoBusiness business) {
        this.business = business;
    }

    @Override
    public void writeBy(ReportSourceWriter<TsuikashiryokagamiA3ReportSource> reportSourceWriter) {

        ITsuikashiryokagamiA3Editor editor = new TsuikashiryokagamiA3Editor(business);
        ITsuikashiryokagamiA3Builder builder = new TsuikashiryokagamiA3Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
