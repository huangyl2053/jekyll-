/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供一式認定調査票情報12のReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiNinteiChosaJohohyo12Report extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final NinteiChosaJohohyoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 認定調査票情報のItem
     */
    public JohoTeikyoIsshikiNinteiChosaJohohyo12Report(NinteiChosaJohohyoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        int maxCount = entity.getサービス区分リスト().size();
        for (int i = 0; i < maxCount; i++) {
            IJohoTeikyoIsshikiBuilder builder = new JohoTeikyoIsshikiNinteiChosaJohohyo12Builder(entity, i);
            reportSourceWriter.writeLine(builder);
        }
    }

}
