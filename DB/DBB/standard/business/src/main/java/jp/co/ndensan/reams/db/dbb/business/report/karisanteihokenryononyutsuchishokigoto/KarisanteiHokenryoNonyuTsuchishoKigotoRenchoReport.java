/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】連帳
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport
        extends Report<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource> {

    private final KarisanteiHokenryoNonyuTsuchishoKigotoItem target;

    /**
     * コンストラクタです。
     *
     * @param target KarisanteiHokenryoNonyuTsuchishoKigotoItem
     */
    protected KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport(
            KarisanteiHokenryoNonyuTsuchishoKigotoItem target) {
        this.target = target;
    }

    /**
     *
     * @param item KarisanteiHokenryoNonyuTsuchishoKigotoItem
     * @return KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport createFrom(
            @NonNull KarisanteiHokenryoNonyuTsuchishoKigotoItem item) {
        return new KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource> reportSourceWriter) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = target.get仮算定納入通知書情報();
        if (null == 仮算定納入通知書情報) {
            仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト) {
            納入通知書期情報リスト = new ArrayList<>();
        }
        int 領収書連番 = 1;
        int 連番 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) <= 0) {
                continue;
            }
            IKarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor editor
                    = new KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor(
                            target, 納入通知書期情報, 連番, target.getNinshoshaSource(), 領収書連番);
            領収書連番++;
            連番++;
            IKarisanteiHokenryoNonyuTsuchishoKigotoRenchoBuilder builder = new KarisanteiHokenryoNonyuTsuchishoKigotoRenchoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

//    /**
//     * devidedByPageメソッド
//     *
//     * @return List<NonyuTsuchisho>
//     */
//    @Override
//    public List<NonyuTsuchisho> devidedByPage() {
//        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = target.get仮算定納入通知書情報();
//        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
//        List<NonyuTsuchisho> reportLst = new ArrayList<>();
//        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
//            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report = new KariSanteiNonyuTsuchiShoJoho();
//            clone仮算定納入通知書情報(仮算定納入通知書情報Report);
//            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
//            納入通知書期情報リストReport.add(納入通知書期情報);
//            仮算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
//            仮算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
//            KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport report = KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport
//                    .createFrom(new KarisanteiHokenryoNonyuTsuchishoKigotoItem(仮算定納入通知書情報Report, target.getNinshoshaSource()));
//            reportLst.add(report);
//        }
//        return reportLst;
//    }
//
//    private void clone仮算定納入通知書情報(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report) {
//        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = target.get仮算定納入通知書情報();
//        仮算定納入通知書情報Report.set仮算定納入通知書制御情報(仮算定納入通知書情報.get仮算定納入通知書制御情報());
//        仮算定納入通知書情報Report.set処理区分(仮算定納入通知書情報.get処理区分());
//        仮算定納入通知書情報Report.set出力期リスト(仮算定納入通知書情報.get出力期リスト());
//        仮算定納入通知書情報Report.set地方公共団体(仮算定納入通知書情報.get地方公共団体());
//        仮算定納入通知書情報Report.set帳票ID(仮算定納入通知書情報.get帳票ID());
//        仮算定納入通知書情報Report.set帳票分類ID(仮算定納入通知書情報.get帳票分類ID());
//        仮算定納入通知書情報Report.set発行日(仮算定納入通知書情報.get発行日());
//        仮算定納入通知書情報Report.set算定の基礎(仮算定納入通知書情報.get算定の基礎());
//        仮算定納入通知書情報Report.set納付書共通(仮算定納入通知書情報.get納付書共通());
//        仮算定納入通知書情報Report.set編集後仮算定通知書共通情報(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
//    }
}
