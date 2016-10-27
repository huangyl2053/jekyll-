/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jutakairiyusakuteseikenshin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakairiyusakuteseikenshin.JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutakairiyusakuteseikenshin.JutakuKaishuRSTSKSReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のReportです。
 *
 * @reamsid_L DBC-2860-040 dangjingjing
 */
public class JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoReport extends Report<JutakuKaishuRSTSKSReportSource> {

    private final JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 住宅改修理由書作成手数料請求書兼申請書作成のdataList
     */
    public JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoReport(JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JutakuKaishuRSTSKSReportSource> reportSourceWriter) {
        IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor editor = new JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoEditor(data);
        IJutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoBuilder builder
                = new JutakuKaishuRiyushoSakuseiTesuryoSeikyuKenShinseishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
