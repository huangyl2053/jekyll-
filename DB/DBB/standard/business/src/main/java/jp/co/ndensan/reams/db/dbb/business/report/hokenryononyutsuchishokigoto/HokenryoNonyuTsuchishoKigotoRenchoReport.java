/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【期毎タイプ】
 *
 * @reamsid_L DBB-9110-080 huangh
 */
public class HokenryoNonyuTsuchishoKigotoRenchoReport extends NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoRenchoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです。
     *
     * @param item HonSanteiNonyuTsuchiShoJoho
     * @param ninshoshaSource 認証者情報
     */
    public HokenryoNonyuTsuchishoKigotoRenchoReport(HonSanteiNonyuTsuchiShoJoho item, NinshoshaSource ninshoshaSource) {
        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoKigotoRenchoSource> writer) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = item;
        if (null == 本算定納入通知書情報) {
            本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額() == null
                    || (納入通知書期情報.get納付額() != null && 納入通知書期情報.get納付額().intValue() <= 0)) {
                continue;
            }
            IHokenryoNonyuTsuchishoKigotoRenchoEditor editor
                    = new HokenryoNonyuTsuchishoKigotoRenchoEditor(item, 納入通知書期情報, ninshoshaSource);
            IHokenryoNonyuTsuchishoKigotoRenchoBuilder builder = new HokenryoNonyuTsuchishoKigotoRenchoBuilder(editor);
            writer.writeLine(builder);
        }
    }

    @Override
    public List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoRenchoSource>> devidedByPage() {
        List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoRenchoSource>> nonyuTsuchishoList = new ArrayList<>();

        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = item;
        if (null == 本算定納入通知書情報) {
            本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            nonyuTsuchishoList.add(getNewReport(納入通知書期情報));
        }

        return nonyuTsuchishoList;
    }

    private HokenryoNonyuTsuchishoKigotoRenchoReport getNewReport(NonyuTsuchiShoKiJoho 納入通知書期情報) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = new ArrayList<>();
        納入通知書期情報リスト.add(納入通知書期情報);
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        本算定納入通知書情報.set処理区分(this.item.get処理区分());
        本算定納入通知書情報.set出力期リスト(this.item.get出力期リスト());
        本算定納入通知書情報.set地方公共団体(this.item.get地方公共団体());
        本算定納入通知書情報.set帳票ID(this.item.get帳票ID());
        本算定納入通知書情報.set帳票分類ID(this.item.get帳票分類ID());
        本算定納入通知書情報.set本算定納入通知書制御情報(this.item.get本算定納入通知書制御情報());
        本算定納入通知書情報.set現年度_過年度区分(this.item.get現年度_過年度区分());
        本算定納入通知書情報.set発行日(this.item.get発行日());
        本算定納入通知書情報.set納付書共通(this.item.get納付書共通());
        本算定納入通知書情報.set編集後本算定通知書共通情報(this.item.get編集後本算定通知書共通情報());
        本算定納入通知書情報.set編集範囲区分(this.item.get編集範囲区分());
        本算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        本算定納入通知書情報.set連番(item.get連番());
        return new HokenryoNonyuTsuchishoKigotoRenchoReport(本算定納入通知書情報, ninshoshaSource);
    }
}
