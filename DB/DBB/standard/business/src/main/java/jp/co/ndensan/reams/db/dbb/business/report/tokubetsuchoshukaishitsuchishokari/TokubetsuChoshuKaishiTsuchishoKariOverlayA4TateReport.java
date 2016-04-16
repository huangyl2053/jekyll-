/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別徴収開始通知書（仮算定）帳票 A4縦・オーバーレイタイプReport
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> {

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final RString 通知書定型文１;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private final NinshoshaSource ninshoshaSource;
    private final CompKaigoToiawasesakiSource toiawasesakiSource;

    /**
     * コンストラクタです
     *
     * @param sofubutsuAtesakiSource SofubutsuAtesakiSource
     * @param ninshoshaSource NinshoshaSource
     * @param toiawasesakiSource CompKaigoToiawasesakiSource
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 通知書定型文１ RString
     */
    public TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(SofubutsuAtesakiSource sofubutsuAtesakiSource,
            NinshoshaSource ninshoshaSource,
            CompKaigoToiawasesakiSource toiawasesakiSource,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 通知書定型文１) {
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
        this.ninshoshaSource = ninshoshaSource;
        this.toiawasesakiSource = toiawasesakiSource;
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
        this.通知書定型文１ = 通知書定型文１;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor editor = new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateEditor(
                sofubutsuAtesakiSource, ninshoshaSource, toiawasesakiSource, 仮算定特徴開始通知書情報, 通知書定型文１);
        ITokubetsuChoshuKaishiTsuchishoKariOverlayA4TateBuilder builder = new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateBuilder(editor);
        writer.writeLine(builder);
    }

}
