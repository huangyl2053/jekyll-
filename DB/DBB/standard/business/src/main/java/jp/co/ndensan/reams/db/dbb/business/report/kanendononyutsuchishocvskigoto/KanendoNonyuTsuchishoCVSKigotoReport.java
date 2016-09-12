/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-190 huangh
 */
public class KanendoNonyuTsuchishoCVSKigotoReport extends NonyuTsuchisho<KanendoNonyuTsuchishoCVSKigotoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public KanendoNonyuTsuchishoCVSKigotoReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoNonyuTsuchishoCVSKigotoSource> reportSourceWriter) {

        IKanendoNonyuTsuchishoCVSKigotoEditor coverEditor = new KanendoNonyuTsuchishoCVSKigotoEditor(item, ninshoshaSource);
        IKanendoNonyuTsuchishoCVSKigotoBuilder builder = new KanendoNonyuTsuchishoCVSKigotoBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSKigotoSource>> devidedByPage() {
        List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSKigotoSource>> nonyuTsuchishoList = new ArrayList<>();
        KanendoNonyuTsuchishoCVSKigotoReport report
                = new KanendoNonyuTsuchishoCVSKigotoReport(item, ninshoshaSource);
        nonyuTsuchishoList.add(report);
        return nonyuTsuchishoList;
    }
}
