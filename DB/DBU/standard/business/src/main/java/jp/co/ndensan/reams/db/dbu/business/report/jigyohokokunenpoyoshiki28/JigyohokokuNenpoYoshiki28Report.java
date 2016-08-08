/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki28;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業状況報告年報（様式１・２　市町村特別給付）のReportです。
 *
 * @reamsid_L DBU-5610-050 yaoyahui
 */
public class JigyohokokuNenpoYoshiki28Report extends Report<JigyohokokuNenpoYoshiki28ReportSource> {

    private final JigyohokokuNenpoYoshiki28Entity entity;

    public JigyohokokuNenpoYoshiki28Report(JigyohokokuNenpoYoshiki28Entity entity) {
        this.entity = entity;
    }
    /**
     * インスタンスを生成します。
     *
     * @param entity 事業状況報告年報（様式１・２　市町村特別給付）の帳票出力用データEntity
     * @return KaigohokenRenrakuhyoReport
     */
    public static JigyohokokuNenpoYoshiki28Report createReport(JigyohokokuNenpoYoshiki28Entity entity) {
        return new JigyohokokuNenpoYoshiki28Report(entity);
    }
    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuNenpoYoshiki28ReportSource> reportSourceWriter) {
        IJigyohokokuNenpoYoshiki28Editor editor = new JigyohokokuNenpoYoshiki28Editor(entity);
        IJigyohokokuNenpoYoshiki28Builder builder = new JigyohokokuNenpoYoshiki28Builder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
