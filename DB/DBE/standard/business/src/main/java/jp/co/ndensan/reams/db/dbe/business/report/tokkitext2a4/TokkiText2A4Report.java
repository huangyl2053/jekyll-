/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext2a4;

import jp.co.ndensan.reams.db.dbe.entity.db.tokkitext2a4.TokkiText2A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext2a4.TokkiText2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項ののReportです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText2A4Report extends Report<TokkiText2ReportSource> {

    private final TokkiText2A4Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public TokkiText2A4Report(TokkiText2A4Entity entity) {
        this.entity = entity;
    }

    /**
     * 特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText2ReportSource> reportSourceWriter) {
        ITokkiText2A4Editor editor = new TokkiText2A4Editor(entity);
        ITokkiText2A4Builder buildera = new TokkiText2A4Builder(editor);
        reportSourceWriter.writeLine(buildera);
    }
}
