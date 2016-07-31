/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishokigoto.KanendoHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定過年度）【期毎タイプ】
 *
 * @reamsid_L DBB-9110-140 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoKigotoReport extends NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoKigotoSource> {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     */
    public KanendoHokenryoNonyuTsuchishoKigotoReport(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoHokenryoNonyuTsuchishoKigotoSource> writer) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト || 納入通知書期情報リスト.isEmpty()) {
            return;
        }
        int 連番 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (null == 納入通知書期情報.get納付額() || 納入通知書期情報.get納付額().compareTo(Decimal.ZERO) <= 0) {
                continue;
            }
            IKanendoHokenryoNonyuTsuchishoKigotoEditor editor
                    = new KanendoHokenryoNonyuTsuchishoKigotoEditor(本算定納入通知書情報, ninshoshaSource, 納入通知書期情報, 連番);
            IKanendoHokenryoNonyuTsuchishoKigotoBuilder builder = new KanendoHokenryoNonyuTsuchishoKigotoBuilder(editor);
            writer.writeLine(builder);
            連番++;
        }
    }

    @Override
    public List<NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoKigotoSource>> devidedByPage() {
        List<NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoKigotoSource>> reportList = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト || 納入通知書期情報リスト.isEmpty()) {
            return reportList;
        }
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            reportList.add(getNewReport(納入通知書期情報));
        }
        return reportList;
    }

    private KanendoHokenryoNonyuTsuchishoKigotoReport getNewReport(NonyuTsuchiShoKiJoho 納入通知書期情報) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = new ArrayList<>();
        納入通知書期情報リスト.add(納入通知書期情報);
        HonSanteiNonyuTsuchiShoJoho new本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        new本算定納入通知書情報.set処理区分(this.本算定納入通知書情報.get処理区分());
        new本算定納入通知書情報.set出力期リスト(this.本算定納入通知書情報.get出力期リスト());
        new本算定納入通知書情報.set地方公共団体(this.本算定納入通知書情報.get地方公共団体());
        new本算定納入通知書情報.set帳票ID(this.本算定納入通知書情報.get帳票ID());
        new本算定納入通知書情報.set帳票分類ID(this.本算定納入通知書情報.get帳票分類ID());
        new本算定納入通知書情報.set本算定納入通知書制御情報(this.本算定納入通知書情報.get本算定納入通知書制御情報());
        new本算定納入通知書情報.set現年度_過年度区分(this.本算定納入通知書情報.get現年度_過年度区分());
        new本算定納入通知書情報.set発行日(this.本算定納入通知書情報.get発行日());
        new本算定納入通知書情報.set納付書共通(this.本算定納入通知書情報.get納付書共通());
        new本算定納入通知書情報.set編集後本算定通知書共通情報(this.本算定納入通知書情報.get編集後本算定通知書共通情報());
        new本算定納入通知書情報.set編集範囲区分(this.本算定納入通知書情報.get編集範囲区分());
        new本算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        new本算定納入通知書情報.set連番(本算定納入通知書情報.get連番());
        return new KanendoHokenryoNonyuTsuchishoKigotoReport(new本算定納入通知書情報, ninshoshaSource);
    }

}
