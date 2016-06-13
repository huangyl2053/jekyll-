/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvsmulti;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.INonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-170 huangh
 */
public class KanendoNonyuTsuchishoCVSMultiReport extends INonyuTsuchisho<KanendoNonyuTsuchishoCVSMultiSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public KanendoNonyuTsuchishoCVSMultiReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;

    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoNonyuTsuchishoCVSMultiSource> reportSourceWriter) {

        IKanendoNonyuTsuchishoCVSMultiEditor coverEditor = new KanendoNonyuTsuchishoCVSMultiEditor(item, ninshoshaSource, 1);
        IKanendoNonyuTsuchishoCVSMultiBuilder builder = new KanendoNonyuTsuchishoCVSMultiBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<INonyuTsuchisho> devidedByPage() {
        List<INonyuTsuchisho> nonyuTsuchishoList = new ArrayList<>();
        KanendoNonyuTsuchishoCVSMultiReport report
                = new KanendoNonyuTsuchishoCVSMultiReport(item, ninshoshaSource);
        nonyuTsuchishoList.add(report);
        return nonyuTsuchishoList;
    }
}
