/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokkiimage.NinteiChosaTokkiImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特記事項ののReportです。
 *
 * @reamsid_L DBE-0230-080 lizhuoxuan
 */
public class NinteiChosaTokkiImageReport extends Report<NinteiChosaTokkiImageReportSource> {

    private final NinteiChosaTokkiImageEntity entity;
    private static final int ZERO = 0;
    private static final int MAXCOUNT = 8;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public NinteiChosaTokkiImageReport(NinteiChosaTokkiImageEntity entity) {
        this.entity = entity;
    }

    /**
     * 特記事項を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokkiImageReportSource> reportSourceWriter) {
        for (int indexPage = 1; indexPage <= Integer.parseInt(entity.get総ページ数().toString()); indexPage++) {
            for (int i = ZERO; i < MAXCOUNT; i++) {
                INinteiChosaTokkiImageEditor editor = new NinteiChosaTokkiImageEditor(entity, i, indexPage);
                INinteiChosaTokkiImageBuilder builder = new NinteiChosaTokkiImageBuilder(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
