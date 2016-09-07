/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpokyuyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業状況報告年報（様式１・２　所得段階）のReportです。
 *
 * @reamsid_L DBU-5610-060 kanghongsong
 */
public class JigyohokokuNenpoKyuyoshiki1Report extends Report<JigyohokokuNenpoKyuyoshiki1ReportSource> {

    private final JigyohokokuNenpoKyuyoshiki1Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 事業状況報告年報（様式１・２　所得段階）Entity
     */
    public JigyohokokuNenpoKyuyoshiki1Report(JigyohokokuNenpoKyuyoshiki1Entity entity) {
        this.entity = entity;
    }

    /**
     * 事業状況報告年報（様式１・２　所得段階）を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuNenpoKyuyoshiki1ReportSource> reportSourceWriter) {

        IJigyohokokuNenpoKyuyoshiki1Editor headerEditor = new JigyohokokuNenpoKyuyoshiki1Editor(entity);
        IJigyohokokuNenpoKyuyoshiki1Builder builder = new JigyohokokuNenpoKyuyoshiki1Builder(headerEditor);
        reportSourceWriter.writeLine(builder);
    }

}
