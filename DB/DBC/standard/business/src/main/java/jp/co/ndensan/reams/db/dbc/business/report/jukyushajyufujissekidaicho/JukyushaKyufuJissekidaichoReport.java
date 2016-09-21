/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushajyufujissekidaicho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者給付実績台帳 のReportです。
 *
 * @reamsid_L DBC-3080-04 dangjingjing
 */
public class JukyushaKyufuJissekidaichoReport extends Report<JukyushaKyufuJissekidaichoReportSource> {

    private final JukyushaKyufuJissekidaichoData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 受給者給付実績台帳のdataList
     */
    public JukyushaKyufuJissekidaichoReport(JukyushaKyufuJissekidaichoData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter) {
        IJukyushaKyufuJissekidaichoEditor editor = new JukyushaKyufuJissekidaichoEditor(data);
        IJukyushaKyufuJissekidaichoBuilder builder = new JukyushaKyufuJissekidaichoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
