/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.nenreikeikyubetsuriyojyokyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年齢階級別利用状況作成 Reportクラスです。
 *
 * @reamsid_L DBE-3470-040 dongyabin
 */
public class NenreiKeikyuBetsuRiyoJyokyoReport extends Report<NenreiKeikyuBetsuRiyoJyokyoReportSource> {

    private final NenreiKeikyuBetsuRiyoJyokyoEntity deta;

    /**
     * インスタンスを生成します。
     *
     * @param deta 給付費通知減免補正一覧表パラメータ
     */
    public NenreiKeikyuBetsuRiyoJyokyoReport(NenreiKeikyuBetsuRiyoJyokyoEntity deta) {
        this.deta = deta;
    }

    @Override
    public void writeBy(ReportSourceWriter<NenreiKeikyuBetsuRiyoJyokyoReportSource> reportSourceWriter) {
        INenreiKeikyuBetsuRiyoJyokyoEditor editor = new NenreiKeikyuBetsuRiyoJyokyoEditor(deta);
        NenreiKeikyuBetsuRiyoJyokyoBuilder builder = new NenreiKeikyuBetsuRiyoJyokyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
