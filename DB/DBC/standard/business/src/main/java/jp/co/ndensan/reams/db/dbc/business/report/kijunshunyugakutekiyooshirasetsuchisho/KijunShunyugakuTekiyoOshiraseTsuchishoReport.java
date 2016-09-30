/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyooshirasetsuchisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100063_基準収入額適用お知らせ通知書 Reportクラスです。
 *
 * @reamsid_L DBC-4640-050 lijian
 */
public class KijunShunyugakuTekiyoOshiraseTsuchishoReport extends Report<KijunShunyugakuTekiyoOshiraseTsuchishoSource> {

    private final KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity;

    /**
     * コンストラクタです。
     *
     * @param 基準収入額適用Entity KijunShunyugakuTekiyoShinseishoEntity
     */
    public KijunShunyugakuTekiyoOshiraseTsuchishoReport(KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity) {
        this.基準収入額適用Entity = 基準収入額適用Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> writer) {
        writeLine(writer, 基準収入額適用Entity);
    }

    private void writeLine(ReportSourceWriter<KijunShunyugakuTekiyoOshiraseTsuchishoSource> writer,
            KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity) {
        IKijunShunyugakuTekiyoOshiraseTsuchishoEditor editor = new KijunShunyugakuTekiyoOshiraseTsuchishoEditor(基準収入額適用Entity);

        IKijunShunyugakuTekiyoOshiraseTsuchishoBuilder builder = new KijunShunyugakuTekiyoOshiraseTsuchishoBuilder(editor);
        writer.writeLine(builder);

    }
}
