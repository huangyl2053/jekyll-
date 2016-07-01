/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkitexta3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkitexta3.GaikyotokkiTextA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3.GaikyotokkiTextA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用概況特記のReportです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA4Report extends Report<GaikyotokkiTextA4ReportSource> {

    private final GaikyotokkiTextA4Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public GaikyotokkiTextA4Report(GaikyotokkiTextA4Entity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<GaikyotokkiTextA4ReportSource> reportSourceWriter) {

        IGaikyotokkiTextA4Editor editor = new GaikyotokkiTextA4Editor(data);
        IGaikyotokkiTextA4Builder builder = new GaikyotokkiTextA4Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
