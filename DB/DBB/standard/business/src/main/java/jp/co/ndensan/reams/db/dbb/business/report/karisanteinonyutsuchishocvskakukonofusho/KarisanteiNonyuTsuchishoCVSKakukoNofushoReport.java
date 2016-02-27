/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakukonofusho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のReportです。
 *
 */
public class KarisanteiNonyuTsuchishoCVSKakukoNofushoReport extends Report<KarisanteiNonyuTsuchishoCVSKakukoNofushoSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニ角公タイプ】のITEM
     * @return 保険料納入通知書（仮算定）【コンビニ角公タイプ】納付書のReport
     */
    public static KarisanteiNonyuTsuchishoCVSKakukoNofushoReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item) {
        return new KarisanteiNonyuTsuchishoCVSKakukoNofushoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニ角公タイプ】のITEM
     */
    protected KarisanteiNonyuTsuchishoCVSKakukoNofushoReport(
            KariSanteiNonyuTsuchiShoJoho item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoNofushoSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {

            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {

                作成フラグ = false;
                break;
            }
        }
        if (作成フラグ) {
            for (int i = 0; i < item.get納入通知書期情報リスト().size(); i++) {
                IKarisanteiNonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor = new KarisanteiNonyuTsuchishoCVSKakukoNofushoEditor(item);
                IKarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder builder = new KarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder(nofushoEditor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
