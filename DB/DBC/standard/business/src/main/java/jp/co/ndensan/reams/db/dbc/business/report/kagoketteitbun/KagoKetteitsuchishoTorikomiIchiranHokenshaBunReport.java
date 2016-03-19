/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 過誤決定通知書情報取込一覧表（保険者分） 帳票Report
 */
public class KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport extends
        Report<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem>
     */
    protected KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport(
            List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param bunItems
     *
     * List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem>
     * @return KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport
     */
    public static KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport createForm(@NonNull List<
            KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> bunItems) {
        return new KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport(bunItems);
    }

    @Override
    public void writeBy(ReportSourceWriter<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> writer) {
        for (KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem target : targets) {
            IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor bodyEditor = new BodyEditor(target);
            IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor headerEditor = new HeaderEditor(target);
            IKagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder build
                    = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunBuilder(headerEditor, bodyEditor);
            writer.writeLine(build);
        }
    }

}
