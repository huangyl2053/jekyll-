/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import jp.co.ndensan.reams.db.dbe.entity.db.tokkitext1a4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項ののReportです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class TokkiText1A4Report extends Report<TokkiText1ReportSource> {

    private final TokkiText1A4Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public TokkiText1A4Report(TokkiText1A4Entity entity) {
        this.entity = entity;
    }

    /**
     * 特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TokkiText1ReportSource> reportSourceWriter) {
        ITokkiText1A4Editor editor = new TokkiText1A4Editor(entity);
        ITokkiText1A4Builder buildera = new TokkiText1A4Builder(editor);
        reportSourceWriter.writeLine(buildera);
    }
}
