/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニ期毎タイプ】のReportです。
 *
 */
public class NonyuTsuchishoCVSKigotoReport extends Report<NonyuTsuchishoCVSKigotoSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ期毎タイプ】のITEM
     * @return 保険料納入通知書（本算定）【コンビニ期毎タイプ】のReport
     */
    public static NonyuTsuchishoCVSKigotoReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item) {
        return new NonyuTsuchishoCVSKigotoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ期毎タイプ】のITEM
     */
    protected NonyuTsuchishoCVSKigotoReport(
            KariSanteiNonyuTsuchiShoJoho item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSKigotoSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {

            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {

                作成フラグ = false;
                break;
            }
        }
        if (作成フラグ) {
            INonyuTsuchishoCVSKigotoEditor coverEditor = new NonyuTsuchishoCVSKigotoEditor(item);
            INonyuTsuchishoCVSKigotoBuilder builder = new NonyuTsuchishoCVSKigotoBuilder(coverEditor);
            reportSourceWriter.writeLine(builder);

        }
    }
}
