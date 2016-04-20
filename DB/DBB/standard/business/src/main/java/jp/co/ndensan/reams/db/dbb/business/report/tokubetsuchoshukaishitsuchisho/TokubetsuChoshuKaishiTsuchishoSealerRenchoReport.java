/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（本算定） シーラタイプ（連帳）帳票Report
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuKaishiTsuchishoSealerRenchoReport extends Report<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 編集後本算定通知書共通情報
     * @param sourceBuilder sourceBuilder
     */
    public TokubetsuChoshuKaishiTsuchishoSealerRenchoReport(
            @NonNull EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            NinshoshaSource sourceBuilder) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoSealerRenchoEditor editor = new TokubetsuChoshuKaishiTsuchishoSealerRenchoEditor(
                編集後本算定通知書共通情報, sourceBuilder);
        ITokubetsuChoshuKaishiTsuchishoSealerRenchoBuilder builder = new TokubetsuChoshuKaishiTsuchishoSealerRenchoBuilder(editor);
        writer.writeLine(builder);
    }

}
