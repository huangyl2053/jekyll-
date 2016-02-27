/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定）【期毎タイプ】
 */
public class HokenryoNonyuTsuchishoKigotoReport extends Report<HokenryoNonyuTsuchishoKigotoSource> {

    private final HokenryoNonyuTsuchishoKigotoItem item;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoKigotoItem
     */
    protected HokenryoNonyuTsuchishoKigotoReport(HokenryoNonyuTsuchishoKigotoItem item) {
        this.item = item;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoKigotoItem
     * @return HokenryoNonyuTsuchishoKigotoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoKigotoReport createFrom(HokenryoNonyuTsuchishoKigotoItem item) {
        return new HokenryoNonyuTsuchishoKigotoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> writer) {
        //TODO 雛形部品CompNinshoshaを作成する
//        INinshoshaSourceBuilder iNinshoshaSourceBuilder
//                = NinshoshaSourceBuilderFactory.createInstance(null, null, RString.HALF_SPACE, RDate.MAX);
//        NinshoshaSource ninshoshaSource = iNinshoshaSourceBuilder.buildSource();
        //TODO 共通部品CompSofubutsuAtesakiを作成する
        SofubutsuAtesakiSource sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = item.get本算定納入通知書情報();
        if (null == 本算定納入通知書情報) {
            本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        int 連番 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) <= 0) {
                continue;
            }
            IHokenryoNonyuTsuchishoKigotoEditor editor
                    = new HokenryoNonyuTsuchishoKigotoEditor(item, 納入通知書期情報, 連番,
                            //ninshoshaSource,
                            sofubutsuAtesakiSource);
            IHokenryoNonyuTsuchishoKigotoBuilder builder = new HokenryoNonyuTsuchishoKigotoBuilder(editor);
            writer.writeLine(builder);
            連番++;
        }
    }

    /**
     * devidedByPageメソッド
     *
     * @return List<HokenryoNonyuTsuchishoKigotoReport>
     */
    public List<HokenryoNonyuTsuchishoKigotoReport> devidedByPage() {//TODO
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = item.get本算定納入通知書情報();
        if (null == 本算定納入通知書情報) {
            本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
        List<HokenryoNonyuTsuchishoKigotoReport> reportLst = new ArrayList<>();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            納入通知書期情報リストReport.add(納入通知書期情報);
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Report = new HonSanteiNonyuTsuchiShoJoho();
            clone本算定納入通知書情報(本算定納入通知書情報Report, 本算定納入通知書情報);
            本算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
            本算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
            HokenryoNonyuTsuchishoKigotoReport report
                    = HokenryoNonyuTsuchishoKigotoReport.createFrom(new HokenryoNonyuTsuchishoKigotoItem(本算定納入通知書情報Report));
            reportLst.add(report);
        }
        return reportLst;
    }

    private void clone本算定納入通知書情報(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Report, HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        本算定納入通知書情報Report.set処理区分(本算定納入通知書情報.get処理区分());
        本算定納入通知書情報Report.set出力期リスト(本算定納入通知書情報.get出力期リスト());
        本算定納入通知書情報Report.set地方公共団体(本算定納入通知書情報.get地方公共団体());
        本算定納入通知書情報Report.set帳票ID(本算定納入通知書情報.get帳票ID());
        本算定納入通知書情報Report.set帳票分類ID(本算定納入通知書情報.get帳票分類ID());
        本算定納入通知書情報Report.set本算定納入通知書制御情報(本算定納入通知書情報.get本算定納入通知書制御情報());
        本算定納入通知書情報Report.set現年度_過年度区分(本算定納入通知書情報.get現年度_過年度区分());
        本算定納入通知書情報Report.set発行日(本算定納入通知書情報.get発行日());
        本算定納入通知書情報Report.set納付書共通(本算定納入通知書情報.get納付書共通());
        本算定納入通知書情報Report.set編集後本算定通知書共通情報(本算定納入通知書情報.get編集後本算定通知書共通情報());
    }

}
