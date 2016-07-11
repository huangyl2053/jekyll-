/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkia4;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkia4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkia4.Tokkijiko2A4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用特記事項のReportです。
 *
 * @reamsid_L DBE-0150-060 wangrenze
 */
public class Tokkijiko2A4Report extends Report<Tokkijiko2A4ReportSource> {

    private final TokkiText1A4Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 事務局用特記事項Entity
     */
    public Tokkijiko2A4Report(TokkiText1A4Entity entity) {
        this.entity = entity;
    }

    /**
     * 事務局用特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<Tokkijiko2A4ReportSource> reportSourceWriter) {
        ITokkijiko2A4Editor editor = new Tokkijiko2A4Editor(entity);
        ITokkijiko2A4Builder buildera = new Tokkijiko2A4Builder(editor);
        reportSourceWriter.writeLine(buildera);
    }
}
