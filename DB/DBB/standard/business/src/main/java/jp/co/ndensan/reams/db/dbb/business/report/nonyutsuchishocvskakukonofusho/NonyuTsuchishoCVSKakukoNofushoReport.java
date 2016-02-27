/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukonofusho;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のReportです。
 *
 */
public class NonyuTsuchishoCVSKakukoNofushoReport extends Report<NonyuTsuchishoCVSKakukoNofushoSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ角公タイプ】のITEM
     * @return 保険料納入通知書（本算定）【コンビニ角公タイプ】納付書のReport
     */
    public static NonyuTsuchishoCVSKakukoNofushoReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item) {
        return new NonyuTsuchishoCVSKakukoNofushoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ角公タイプ】のITEM
     */
    protected NonyuTsuchishoCVSKakukoNofushoReport(
            KariSanteiNonyuTsuchiShoJoho item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSKakukoNofushoSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {

            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {

                作成フラグ = false;
                break;
            }
        }
        if (作成フラグ) {
            for (int i = 0; i < item.get納入通知書期情報リスト().size(); i++) {
                INonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor = new NonyuTsuchishoCVSKakukoNofushoEditor(item);
                INonyuTsuchishoCVSKakukoNofushoBuilder builder = new NonyuTsuchishoCVSKakukoNofushoBuilder(nofushoEditor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
