/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvskakuko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-180 huangh
 */
public class KanendoNonyuTsuchishoCVSKakukoReport extends NonyuTsuchisho<KanendoNonyuTsuchishoCVSKakukoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public KanendoNonyuTsuchishoCVSKakukoReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;

    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoNonyuTsuchishoCVSKakukoSource> reportSourceWriter) {

        IKanendoNonyuTsuchishoCVSKakukoEditor coverEditor = new KanendoNonyuTsuchishoCVSKakukoEditor(item, ninshoshaSource);
        IKanendoNonyuTsuchishoCVSKakukoBuilder builder = new KanendoNonyuTsuchishoCVSKakukoBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSKakukoSource>> devidedByPage() {
        List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSKakukoSource>> nonyuTsuchishoList = new ArrayList<>();
        KanendoNonyuTsuchishoCVSKakukoReport report
                = new KanendoNonyuTsuchishoCVSKakukoReport(item, ninshoshaSource);
        nonyuTsuchishoList.add(report);
        return nonyuTsuchishoList;
    }
}
