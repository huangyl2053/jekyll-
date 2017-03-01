/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供一式一次判定結果のReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiIchijihanteikekkahyoReport extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final IchijihanteikekkahyoEntity entity;
    private static final int ZERO = 0;
    private static final int MAXCOUNT = 20;

    /**
     * インスタンスを生成します。
     *
     * @param entity 主治医意見書Entity
     */
    public JohoTeikyoIsshikiIchijihanteikekkahyoReport(IchijihanteikekkahyoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        for (int i = ZERO; i < MAXCOUNT; i++) {
            IJohoTeikyoIsshikiBuilder builder = new JohoTeikyoIsshikiIIchijihanteikekkahyoBuilder(entity, i);
            reportSourceWriter.writeLine(builder);
        }
    }
}
