/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmultinofusho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiNofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書のReportです。
 *
 */
public class KarisanteiNonyuTsuchishoCVSMultiNofushoReport extends NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiNofushoSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】のITEM
     * @param index index
     * @return 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】納付書のReport
     */
    public static KarisanteiNonyuTsuchishoCVSMultiNofushoReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item, int index) {
        return new KarisanteiNonyuTsuchishoCVSMultiNofushoReport(item, index);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】のITEM
     * @param index index
     */
    protected KarisanteiNonyuTsuchishoCVSMultiNofushoReport(
            KariSanteiNonyuTsuchiShoJoho item, int index) {

        this.item = item;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiNofushoSource> reportSourceWriter) {

        IKarisanteiNonyuTsuchishoCVSMultiNofushoEditor nofushoEditor = new KarisanteiNonyuTsuchishoCVSMultiNofushoEditor(item, index);
        IKarisanteiNonyuTsuchishoCVSMultiNofushoBuilder builder = new KarisanteiNonyuTsuchishoCVSMultiNofushoBuilder(nofushoEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho> devidedByPage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
