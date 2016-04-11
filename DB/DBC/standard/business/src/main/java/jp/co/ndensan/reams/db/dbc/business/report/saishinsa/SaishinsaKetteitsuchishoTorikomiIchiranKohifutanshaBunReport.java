/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsa;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票Report
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport
        extends Report<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> {

    private final List<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets List<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem>
     */
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport(
            List<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets List<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem> targets
     * @return KogakuKyufuTaishoshaIchiranReport
     */
    public static SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport createForm(
            @NonNull List<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem> targets) {
        return new SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource> writer) {
        for (SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunItem target : targets) {
            ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor headerEditor = new HeaderEditor(target);
            ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor bodyEditor = new BodyEditor(target);
            ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder builder
                    = new SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }
}
