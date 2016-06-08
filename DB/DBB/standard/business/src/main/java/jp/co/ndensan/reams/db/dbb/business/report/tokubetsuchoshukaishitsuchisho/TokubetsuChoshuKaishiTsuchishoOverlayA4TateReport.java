/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（本算定） A4縦・オーバレイタイプ帳票Report
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport extends Report<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 通知書定型文;
    private final CompKaigoToiawasesakiSource toiawasesakiSource;
    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 編集後本算定通知書共通情報
     * @param 通知書定型文 通知書定型文
     * @param toiawasesakiSource toiawasesakiSource
     * @param sourceBuilder sourceBuilder
     */
    public TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(
            @NonNull EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 通知書定型文,
            CompKaigoToiawasesakiSource toiawasesakiSource,
            NinshoshaSource sourceBuilder) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.通知書定型文 = 通知書定型文;
        this.toiawasesakiSource = toiawasesakiSource;
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor editor = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateEditor(
                編集後本算定通知書共通情報, 通知書定型文, toiawasesakiSource, sourceBuilder);
        ITokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder builder = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateBuilder(editor);
        writer.writeLine(builder);
    }
}
