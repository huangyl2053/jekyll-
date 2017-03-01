/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoninteijohoteikyoisshiki;

import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteijohoteikyoisshiki.JohoTeikyoIsshiki;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujikensho.ShujiiikenshoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoninteijohoteikyoisshiki.YokaigoNinteiJohoTeikyoIsshikiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定情報提供一式主治医意見書ののReportです。
 *
 * @author N3212 竹内 和紀
 */
public class JohoTeikyoIsshikiShujiiikenshoReport extends Report<YokaigoNinteiJohoTeikyoIsshikiReportSource> {

    private final ShujiiikenshoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 主治医意見書Entity
     */
    public JohoTeikyoIsshikiShujiiikenshoReport(ShujiiikenshoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiJohoTeikyoIsshikiReportSource> reportSourceWriter) {
        IJohoTeikyoIsshikiBuilder builder = new JohoTeikyoIsshikiShujiiikenshoBuilder(entity, JohoTeikyoIsshiki.Shujiiikensho1);
        reportSourceWriter.writeLine(builder);
        IJohoTeikyoIsshikiBuilder builder2 = new JohoTeikyoIsshikiShujiiikenshoBuilder(entity, JohoTeikyoIsshiki.Shujiiikensho2);
        reportSourceWriter.writeLine(builder2);
    }

}
