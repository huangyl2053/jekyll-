/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiimagea4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkiimagea4.GaikyotokkiImageA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.gaikyotokkiimagea4.GaikyotokkiImageA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局概況特記のReportです。
 *
 * @reamsid_L DBE-0150-370 wangrenze
 */
public class GaikyotokkiImageA4Report extends Report<GaikyotokkiImageA4ReportSource> {

    private final GaikyotokkiImageA4Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public GaikyotokkiImageA4Report(GaikyotokkiImageA4Entity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<GaikyotokkiImageA4ReportSource> reportSourceWriter) {
        IGaikyotokkiImageA4Editor editor = new GaikyotokkiImageA4Editor(data);
        IGaikyotokkiImageA4Builder builder = new GaikyotokkiImageA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
