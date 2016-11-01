/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishocvsmulti;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-170 huangh
 */
public class KanendoNonyuTsuchishoCVSMultiReport extends NonyuTsuchisho<KanendoNonyuTsuchishoCVSMultiSource> {

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

        IKanendoNonyuTsuchishoCVSMultiEditor coverEditor = new KanendoNonyuTsuchishoCVSMultiEditor(item, ninshoshaSource);
        IKanendoNonyuTsuchishoCVSMultiBuilder builder = new KanendoNonyuTsuchishoCVSMultiBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSMultiSource>> devidedByPage() {
        List<NonyuTsuchisho<KanendoNonyuTsuchishoCVSMultiSource>> nonyuTsuchishoList = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト) {
            return nonyuTsuchishoList;
        }

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            HonSanteiNonyuTsuchiShoJoho 本算定過年度納入通知書情報Report = new HonSanteiNonyuTsuchiShoJoho();
            clone本算定納入通知書情報(本算定過年度納入通知書情報Report);
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
            納入通知書期情報リストReport.add(納入通知書期情報);
            本算定過年度納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);

            KanendoNonyuTsuchishoCVSMultiReport report
                    = new KanendoNonyuTsuchishoCVSMultiReport(本算定過年度納入通知書情報Report, ninshoshaSource);
            nonyuTsuchishoList.add(report);
        }

        return nonyuTsuchishoList;
    }

    private void clone本算定納入通知書情報(HonSanteiNonyuTsuchiShoJoho 本算定過年度納入通知書情報Report) {
        本算定過年度納入通知書情報Report.set本算定納入通知書制御情報(item.get本算定納入通知書制御情報());
        本算定過年度納入通知書情報Report.set処理区分(item.get処理区分());
        本算定過年度納入通知書情報Report.set出力期リスト(item.get出力期リスト());
        本算定過年度納入通知書情報Report.set地方公共団体(item.get地方公共団体());
        本算定過年度納入通知書情報Report.set帳票ID(item.get帳票ID());
        本算定過年度納入通知書情報Report.set帳票分類ID(item.get帳票分類ID());
        本算定過年度納入通知書情報Report.set発行日(item.get発行日());
        本算定過年度納入通知書情報Report.set現年度_過年度区分(item.get現年度_過年度区分());
        本算定過年度納入通知書情報Report.set納付書共通(item.get納付書共通());
        本算定過年度納入通知書情報Report.set編集後本算定通知書共通情報(item.get編集後本算定通知書共通情報());
        本算定過年度納入通知書情報Report.set連番(item.get連番());
    }
}
