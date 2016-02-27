/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchocover;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】（連帳）CoverのReportです。
 *
 */
public class NonyuTsuchishoCVSKakukoRenchoCoverReport extends Report<NonyuTsuchishoCVSKakukoRenchoCoverSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ角公タイプ】のITEM
     * @return 保険料納入通知書（本算定）【コンビニ角公タイプ】CoverのReport
     */
    public static NonyuTsuchishoCVSKakukoRenchoCoverReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item) {
        return new NonyuTsuchishoCVSKakukoRenchoCoverReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ角公タイプ】のITEM
     */
    protected NonyuTsuchishoCVSKakukoRenchoCoverReport(
            KariSanteiNonyuTsuchiShoJoho item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSKakukoRenchoCoverSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {

            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {

                作成フラグ = false;
                break;
            }
        }
        if (作成フラグ) {
            INonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor = new NonyuTsuchishoCVSKakukoRenchoCoverEditor(item);
            INonyuTsuchishoCVSKakukoRenchoCoverBuilder builder = new NonyuTsuchishoCVSKakukoRenchoCoverBuilder(renchoCoverEditor);
            reportSourceWriter.writeLine(builder);

        }
    }
}
