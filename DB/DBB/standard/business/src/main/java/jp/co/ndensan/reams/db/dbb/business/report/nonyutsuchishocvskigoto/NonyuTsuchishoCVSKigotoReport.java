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
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニ期毎タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-130 huangh
 */
public class NonyuTsuchishoCVSKigotoReport extends NonyuTsuchisho<NonyuTsuchishoCVSKigotoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニ期毎タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public NonyuTsuchishoCVSKigotoReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSKigotoSource> reportSourceWriter) {

        INonyuTsuchishoCVSKigotoEditor coverEditor = new NonyuTsuchishoCVSKigotoEditor(item, ninshoshaSource);
        INonyuTsuchishoCVSKigotoBuilder builder = new NonyuTsuchishoCVSKigotoBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoSource>> devidedByPage() {
        List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoSource>> nonyuTsuchishoList = new ArrayList<>();
        NonyuTsuchishoCVSKigotoReport report
                = new NonyuTsuchishoCVSKigotoReport(item, ninshoshaSource);
        nonyuTsuchishoList.add(report);
        return nonyuTsuchishoList;
    }
}
