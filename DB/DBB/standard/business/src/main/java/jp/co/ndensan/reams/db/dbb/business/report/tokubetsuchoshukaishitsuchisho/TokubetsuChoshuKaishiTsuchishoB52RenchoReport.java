/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 別徴収開始通知書（本算定） B5横タイプ2（連帳）帳票Report
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoB52RenchoReport extends Report<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 宛名連番;
    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 編集後本算定通知書共通情報
     * @param 宛名連番 宛名連番
     * @param sourceBuilder sourceBuilder
     */
    public TokubetsuChoshuKaishiTsuchishoB52RenchoReport(
            @NonNull EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            NinshoshaSource sourceBuilder) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.宛名連番 = 宛名連番;
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoB52RenchoEditor editor = new TokubetsuChoshuKaishiTsuchishoB52RenchoEditor(編集後本算定通知書共通情報,
                宛名連番, sourceBuilder);
        ITokubetsuChoshuKaishiTsuchishoB52RenchoBuilder builder = new TokubetsuChoshuKaishiTsuchishoB52RenchoBuilder(editor);
        writer.writeLine(builder);
    }
}
