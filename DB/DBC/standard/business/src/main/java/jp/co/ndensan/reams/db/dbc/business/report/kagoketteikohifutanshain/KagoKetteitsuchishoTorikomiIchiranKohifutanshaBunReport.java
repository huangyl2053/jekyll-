/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitsuchishotorikomiichirankohifutanshabun.KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票Report
 */
public class KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport extends
        Report<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> {

    private final List<KagoKetteiKohifutanshaInItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets
     * List<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunItem>
     */
    protected KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport(List<KagoKetteiKohifutanshaInItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets
     * List<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunItem>
     * @return
     */
    public static KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport createForm(
            @NonNull List<KagoKetteiKohifutanshaInItem> targets) {
        return new KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> writer) {
        for (KagoKetteiKohifutanshaInItem target : targets) {
            IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor headerEditor = new HeaderEditor(target);
            IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor bodyEditor = new BodyEditor(target);
            IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder builder = new KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
