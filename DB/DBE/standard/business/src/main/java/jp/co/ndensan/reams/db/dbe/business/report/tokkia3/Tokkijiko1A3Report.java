/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia3.TokkiText1A3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia3.TokkiText1A3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用特記事項のReportです。
 *
 * @reamsid_L DBE-0150-060 wangrenze
 */
public class Tokkijiko1A3Report extends Report<TokkiText1A3ReportSource> {

    private final TokkiText1A3Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 事務局用特記事項Entity
     */
    public Tokkijiko1A3Report(TokkiText1A3Entity entity) {
        this.entity = entity;
    }

    /**
     * 事務局用特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText1A3ReportSource> reportSourceWriter) {
        ITokkijiko1A3Editor editor = new Tokkijiko1A3Editor(entity);
        ITokkijiko1A3Builder buildera = new Tokkijiko1A3Builder(editor);
        reportSourceWriter.writeLine(buildera);
    }
}
