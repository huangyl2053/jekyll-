/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】納付書のReportです。
 *
 * @reamsid_L DBB-9110-130 huangh
 */
public class NonyuTsuchishoCVSKigotoRenchoReport extends NonyuTsuchisho<NonyuTsuchishoCVSKigotoRenchoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ期毎タイプ】連帳のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public NonyuTsuchishoCVSKigotoRenchoReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSKigotoRenchoSource> reportSourceWriter) {

        INonyuTsuchishoCVSKigotoRenchoEditor coverEditor = new NonyuTsuchishoCVSKigotoRenchoEditor(item, ninshoshaSource);
        INonyuTsuchishoCVSKigotoRenchoBuilder builder = new NonyuTsuchishoCVSKigotoRenchoBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoRenchoSource>> devidedByPage() {
        List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoRenchoSource>> nonyuTsuchishoList = new ArrayList<>();
        NonyuTsuchishoCVSKigotoRenchoReport report
                = new NonyuTsuchishoCVSKigotoRenchoReport(item, ninshoshaSource);
        nonyuTsuchishoList.add(report);
        return nonyuTsuchishoList;
    }
}
