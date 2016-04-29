/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（仮算定）帳票 B5横・オーバレイタイプReport
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> {

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final RString 通知書定型文１;
    private final RString 通知書定型文２;
    private final EditedAtesaki 編集後宛先;
    private final NinshoshaSource ninshoshaSource;
    private final CompKaigoToiawasesakiSource toiawasesakiSource;

    /**
     * コンストラクタです
     *
     * @param 編集後宛先 EditedAtesaki
     * @param ninshoshaSource NinshoshaSource
     * @param toiawasesakiSource CompKaigoToiawasesakiSource
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 通知書定型文１ RString
     * @param 通知書定型文２ RString
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(EditedAtesaki 編集後宛先,
            NinshoshaSource ninshoshaSource,
            CompKaigoToiawasesakiSource toiawasesakiSource,
            @NonNull KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 通知書定型文１,
            RString 通知書定型文２) {
        this.編集後宛先 = 編集後宛先;
        this.ninshoshaSource = ninshoshaSource;
        this.toiawasesakiSource = toiawasesakiSource;
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
        this.通知書定型文１ = 通知書定型文１;
        this.通知書定型文２ = 通知書定型文２;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor editor = new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoEditor(
                編集後宛先, ninshoshaSource, toiawasesakiSource, 仮算定特徴開始通知書情報, 通知書定型文１, 通知書定型文２);
        ITokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoBuilder builder = new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoBuilder(editor);
        writer.writeLine(builder);
    }

}
