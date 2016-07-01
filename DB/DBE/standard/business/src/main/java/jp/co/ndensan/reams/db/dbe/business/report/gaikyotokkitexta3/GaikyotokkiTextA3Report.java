/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkitexta3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkitexta3.GaikyotokkiTextA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkitexta3.GaikyotokkiTextA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用概況特記のReportです。
 *
 * @reamsid_L DBE-0150-070 wangrenze
 */
public class GaikyotokkiTextA3Report extends Report<GaikyotokkiTextA3ReportSource> {

    private final GaikyotokkiTextA3Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdata
     */
    public GaikyotokkiTextA3Report(GaikyotokkiTextA3Entity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<GaikyotokkiTextA3ReportSource> reportSourceWriter) {

        IGaikyotokkiTextA3Editor editor = new GaikyotokkiTextA3Editor(data);
        IGaikyotokkiTextA3Builder builder = new GaikyotokkiTextA3Builder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
