/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者給付実績一覧表 のReportです。
 *
 * @reamsid_L DBC-3070-040 dangjingjing
 */
public class JukyushaKyufuJissekiIchiranReport extends Report<JukyushaKyufuJissekiIchiranReportSource> {

    private final JukyushaKyufuJissekiIchiranData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 受給者給付実績一覧表のdataList
     */
    public JukyushaKyufuJissekiIchiranReport(JukyushaKyufuJissekiIchiranData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaKyufuJissekiIchiranReportSource> reportSourceWriter) {
        IJukyushaKyufuJissekiIchiranEditor editor = new JukyushaKyufuJissekiIchiranEditor(data);
        IJukyushaKyufuJissekiIchiranBuilder builder = new JukyushaKyufuJissekiIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
