/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokkiimage.NinteiChosaTokkiImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供一式特記事項のReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiNinteiChosaTokkiImageReport extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final NinteiChosaTokkiImageEntity entity;
    private static final int ZERO = 0;
    private static final int MAXCOUNT = 8;

    /**
     * インスタンスを生成します。
     *
     * @param entity 特記事項Entity
     */
    public JohoTeikyoIsshikiNinteiChosaTokkiImageReport(NinteiChosaTokkiImageEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        for (int indexPage = 1; indexPage <= Integer.parseInt(entity.get総ページ数().toString()); indexPage++) {
            for (int i = ZERO; i < MAXCOUNT; i++) {
                IJohoTeikyoIsshikiBuilder builder = new JohoTeikyoIsshikiNinteiChosaTokkiImageBuilder(entity, i, indexPage);
                reportSourceWriter.writeLine(builder);
            }
        }
    }

}
