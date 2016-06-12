/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NinshoshaSource;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【期毎タイプ】
 *
 * @reamsid_L DBB-9110-080 liangbc
 */
public class HokenryoNonyuTsuchishoKigotoReport extends Report<HokenryoNonyuTsuchishoKigotoSource> {

    private final HokenryoNonyuTsuchishoKigotoItem item;
    private final NinshoshaSource ninshoshaSource;

    /**
     * コンストラクタです。
     *
     * @param item HokenryoNonyuTsuchishoKigotoItem
     * @param ninshoshaSource 認証者情報
     */
    protected HokenryoNonyuTsuchishoKigotoReport(HokenryoNonyuTsuchishoKigotoItem item, NinshoshaSource ninshoshaSource) {
        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     *
     * @param item HokenryoNonyuTsuchishoKigotoItem
     * @param ninshoshaSource 認証者情報
     * @return HokenryoNonyuTsuchishoKigotoReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static HokenryoNonyuTsuchishoKigotoReport createFrom(HokenryoNonyuTsuchishoKigotoItem item, NinshoshaSource ninshoshaSource) {
        return new HokenryoNonyuTsuchishoKigotoReport(item, ninshoshaSource);
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> writer) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = item.get本算定納入通知書情報();
        if (null == 本算定納入通知書情報) {
            本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        int 連番 = 1;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            IHokenryoNonyuTsuchishoKigotoEditor editor
                    = new HokenryoNonyuTsuchishoKigotoEditor(item, 納入通知書期情報, ninshoshaSource, 連番);
            IHokenryoNonyuTsuchishoKigotoBuilder builder = new HokenryoNonyuTsuchishoKigotoBuilder(editor);
            writer.writeLine(builder);
            連番++;
        }
    }
}
