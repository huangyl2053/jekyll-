/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のReportです。
 *
 * @reamsid_L DBC-2860-050 dangjingjing
 */
public class JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport
        extends Report<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> {

    private final JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 住宅改修理由書作成手数料請求書兼申請書作成のdataList
     */
    public JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport(JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> reportSourceWriter) {
        IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor editor = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranEditor(data);
        IJutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranBuilder builder
                = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
