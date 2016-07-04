/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】連帳 KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport
 *
 * @reamsid_L DBB-9110-070 wangjie2
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport
        extends NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource> {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     */
    protected KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @return KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport createFrom(
            @NonNull KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        return new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport(仮算定納入通知書情報, ninshoshaSource);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource> reportSourceWriter) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト) {
            納入通知書期情報リスト = new ArrayList<>();
        }
        int 連番 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (null == 納入通知書期情報.get納付額() || 納入通知書期情報.get納付額().compareTo(Decimal.ZERO) <= 0) {
                continue;
            }
            IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor editor
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor(仮算定納入通知書情報, 納入通知書期情報, ninshoshaSource, 連番);
            IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder builder = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder(editor);
            reportSourceWriter.writeLine(builder);
            連番++;
        }
    }

    @Override
    public List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource>> devidedByPage() {
        List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource>> reportLst = new ArrayList<>();
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
            KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport report
                    = KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport.createFrom(仮算定納入通知書情報Report, ninshoshaSource);
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
