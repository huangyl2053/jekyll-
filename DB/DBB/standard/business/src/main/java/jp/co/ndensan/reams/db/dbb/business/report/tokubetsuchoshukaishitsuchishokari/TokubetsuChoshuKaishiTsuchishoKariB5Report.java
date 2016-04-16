/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別徴収開始通知書（仮算定）帳票 B5横タイプ
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariB5Report extends
        Report<TokubetsuChoshuKaishiTsuchishoKariB5Source> {

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final RString 宛名連番;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです
     *
     * @param sofubutsuAtesakiSource SofubutsuAtesakiSource
     * @param ninshoshaSource NinshoshaSource
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 宛名連番 RString
     */
    public TokubetsuChoshuKaishiTsuchishoKariB5Report(SofubutsuAtesakiSource sofubutsuAtesakiSource,
            NinshoshaSource ninshoshaSource,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 宛名連番) {
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
        this.ninshoshaSource = ninshoshaSource;
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
        this.宛名連番 = 宛名連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> writer) {
        ITokubetsuChoshuKaishiTsuchishoKariB5Editor editor = new TokubetsuChoshuKaishiTsuchishoKariB5Editor(
                sofubutsuAtesakiSource, ninshoshaSource, 仮算定特徴開始通知書情報, 宛名連番);
        ITokubetsuChoshuKaishiTsuchishoKariB5Builder builder = new TokubetsuChoshuKaishiTsuchishoKariB5Builder(editor);
        writer.writeLine(builder);
    }
}
