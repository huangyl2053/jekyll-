/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuYobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用予備判定記入表のReportです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoReport extends Report<JimukyokuyoYobihanteiKinyuhyoReportSource> {

    private final JimuYobihanteiKinyuhyoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 申請に関する帳票発行
     */
    public JimukyokuyoYobihanteiKinyuhyoReport(JimuYobihanteiKinyuhyoBusiness business) {
        this.business = business;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimukyokuyoYobihanteiKinyuhyoReportSource> reportSourceWriter) {

        IJimukyokuyoYobihanteiKinyuhyoEditor editor = new JimukyokuyoYobihanteiKinyuhyoEditor(business);
        IJimukyokuyoYobihanteiKinyuhyoBuilder builder = new JimukyokuyoYobihanteiKinyuhyoBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
