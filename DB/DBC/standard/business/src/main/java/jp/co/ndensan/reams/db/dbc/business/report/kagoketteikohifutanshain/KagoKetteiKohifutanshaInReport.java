/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain
        .KagoKetteiKohifutanshaInSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票Report
 */
public class KagoKetteiKohifutanshaInReport extends
        Report<KagoKetteiKohifutanshaInSource> {

    private final List<KagoKetteiKohifutanshaInItem> targets;

    /**
     * コンストラクタです
     *
     * @param targets
     * List<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunItem>
     */
    protected KagoKetteiKohifutanshaInReport(List<KagoKetteiKohifutanshaInItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッド
     *
     * @param targets
     * List<KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunItem>
     * @return KagoKetteiKohifutanshaInReport
     */
    public static KagoKetteiKohifutanshaInReport createForm(
            @NonNull List<KagoKetteiKohifutanshaInItem> targets) {
        return new KagoKetteiKohifutanshaInReport(targets);
    }

    @Override
    public void writeBy(ReportSourceWriter<KagoKetteiKohifutanshaInSource> writer) {
        for (KagoKetteiKohifutanshaInItem target : targets) {
            IKagoKetteiKohifutanshaInEditor headerEditor = new HeaderEditor(target);
            IKagoKetteiKohifutanshaInEditor bodyEditor = new BodyEditor(target);
            IKagoKetteiKohifutanshaInBuilder builder = 
                    new KagoKetteiKohifutanshaInBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
