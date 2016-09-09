/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 過誤決定通知書情報取込一覧表（保険者分） 帳票Report
 *
 * @reamsid_L DBC-0980-470 lijunjun
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport extends
        Report<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final KagoKetteiHokenshaIchiranParameter 帳票用パラメター;

    /**
     * コンストラクタです
     *
     * @param 帳票用パラメター KagoKetteiHokenshaIchiranParameter
     */
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport(
            KagoKetteiHokenshaIchiranParameter 帳票用パラメター) {
        this.帳票用パラメター = 帳票用パラメター;
    }

    @Override
    public void writeBy(ReportSourceWriter<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> writer) {
        IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor body
                = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunBodyEditor(帳票用パラメター);
        IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor header
                = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunHeaderEditor(帳票用パラメター);
        IKagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder builder
                = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder(header, body);
        builder.build();
        writer.writeLine(builder);
    }

}
