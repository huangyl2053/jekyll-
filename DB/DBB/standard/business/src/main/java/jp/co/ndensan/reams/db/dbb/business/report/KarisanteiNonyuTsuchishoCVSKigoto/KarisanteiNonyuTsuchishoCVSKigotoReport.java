/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.KarisanteiNonyuTsuchishoCVSKigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.KarisanteiNonyuTsuchishoCVSKigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】
 */
public class KarisanteiNonyuTsuchishoCVSKigotoReport extends Report<KarisanteiNonyuTsuchishoCVSKigotoSource> {

    private final KarisanteiNonyuTsuchishoCVSKigotoItem item;

    /**
     * コンストラクタです。
     *
     * @param item KarisanteiNonyuTsuchishoCVSKigotoItem
     */
    protected KarisanteiNonyuTsuchishoCVSKigotoReport(KarisanteiNonyuTsuchishoCVSKigotoItem item) {
        this.item = item;
    }

    /**
     *
     * @param item KarisanteiNonyuTsuchishoCVSKigotoItem
     * @return KarisanteiNonyuTsuchishoCVSKigotoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiNonyuTsuchishoCVSKigotoReport createFrom(KarisanteiNonyuTsuchishoCVSKigotoItem item) {
        return new KarisanteiNonyuTsuchishoCVSKigotoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKigotoSource> reportSourceWriter) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        if (null == 仮算定納入通知書情報) {
            仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (納入通知書期情報リスト.isEmpty()) {
            納入通知書期情報リスト = new ArrayList<>();
        }
        //TODO 雛形部品CompNinshoshaを作成する
//        INinshoshaSourceBuilder iNinshoshaSourceBuilder
//                = NinshoshaSourceBuilderFactory.createInstance(null, null, RString.HALF_SPACE, RDate.MAX, 1);
//        NinshoshaSource ninshoshaSource = iNinshoshaSourceBuilder.buildSource();
        //TODO 共通部品CompSofubutsuAtesakiを作成する
        SofubutsuAtesakiSource sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        int 連番 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) <= 0) {
                continue;
            }
            IKarisanteiNonyuTsuchishoCVSKigotoEditor editor
                    = new KarisanteiNonyuTsuchishoCVSKigotoEditor(item, 連番,
                            //ninshoshaSource,
                            sofubutsuAtesakiSource);
            IKarisanteiNonyuTsuchishoCVSKigotoBuilder builder = new KarisanteiNonyuTsuchishoCVSKigotoBuilder(editor);
            reportSourceWriter.writeLine(builder);
            連番++;
        }
    }

    /**
     * devidedByPageメソッド
     *
     * @return List<KarisanteiNonyuTsuchishoCVSKigotoReport>
     */
    public List<KarisanteiNonyuTsuchishoCVSKigotoReport> devidedByPage() {
        //TODO
        List<KarisanteiNonyuTsuchishoCVSKigotoReport> reportLst = new ArrayList<>();
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        if (null == 仮算定納入通知書情報) {
            仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (納入通知書期情報リスト.isEmpty()) {
            納入通知書期情報リスト = new ArrayList<>();
        }
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
            納入通知書期情報リストReport.add(納入通知書期情報);
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report = new KariSanteiNonyuTsuchiShoJoho();
            clone仮算定納入通知書情報(仮算定納入通知書情報Report, 仮算定納入通知書情報);
            仮算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
            仮算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
            KarisanteiNonyuTsuchishoCVSKigotoReport report
                    = KarisanteiNonyuTsuchishoCVSKigotoReport.createFrom(new KarisanteiNonyuTsuchishoCVSKigotoItem(仮算定納入通知書情報Report));
            reportLst.add(report);
        }
        return reportLst;
    }

    private void clone仮算定納入通知書情報(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report,
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        仮算定納入通知書情報Report.set仮算定納入通知書制御情報(仮算定納入通知書情報.get仮算定納入通知書制御情報());
        仮算定納入通知書情報Report.set処理区分(仮算定納入通知書情報.get処理区分());
        仮算定納入通知書情報Report.set出力期リスト(仮算定納入通知書情報.get出力期リスト());
        仮算定納入通知書情報Report.set地方公共団体(仮算定納入通知書情報.get地方公共団体());
        仮算定納入通知書情報Report.set帳票ID(仮算定納入通知書情報.get帳票ID());
        仮算定納入通知書情報Report.set帳票分類ID(仮算定納入通知書情報.get帳票分類ID());
        仮算定納入通知書情報Report.set発行日(仮算定納入通知書情報.get発行日());
        仮算定納入通知書情報Report.set算定の基礎(仮算定納入通知書情報.get算定の基礎());
        仮算定納入通知書情報Report.set納付書共通(仮算定納入通知書情報.get納付書共通());
        仮算定納入通知書情報Report.set編集後仮算定通知書共通情報(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
    }

}
