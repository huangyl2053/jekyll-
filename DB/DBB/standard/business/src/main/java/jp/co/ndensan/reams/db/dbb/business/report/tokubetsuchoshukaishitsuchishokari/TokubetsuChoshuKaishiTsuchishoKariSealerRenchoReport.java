/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプ連帳Report
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> {

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです
     *
     * @param sofubutsuAtesakiSource SofubutsuAtesakiSource
     * @param ninshoshaSource NinshoshaSource
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     */
    public TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(SofubutsuAtesakiSource sofubutsuAtesakiSource,
            NinshoshaSource ninshoshaSource,
            KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報) {
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
        this.ninshoshaSource = ninshoshaSource;
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> writer) {
        ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor editor = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor(
                sofubutsuAtesakiSource, ninshoshaSource, 仮算定特徴開始通知書情報);
        ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder builder = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder(editor);
        writer.writeLine(builder);
    }

}
