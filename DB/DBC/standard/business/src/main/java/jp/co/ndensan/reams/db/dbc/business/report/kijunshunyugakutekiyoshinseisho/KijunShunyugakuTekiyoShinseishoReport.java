/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100064_基準収入額適用申請書 Reportクラスです。
 *
 * @reamsid_L DBC-4640-040 lijian
 */
public class KijunShunyugakuTekiyoShinseishoReport extends Report<KijunShunyugakuTekiyoShinseishoSource> {

    private final KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity;

    /**
     * コンストラクタです。
     *
     * @param 基準収入額適用申請書Entity KijunShunyugakuTekiyoShinseishoEntity
     */
    public KijunShunyugakuTekiyoShinseishoReport(KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity) {
        this.基準収入額適用申請書Entity = 基準収入額適用申請書Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> writer) {
        writeLine(writer, 基準収入額適用申請書Entity);
    }

    private void writeLine(ReportSourceWriter<KijunShunyugakuTekiyoShinseishoSource> writer,
            KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用申請書Entity) {
        IKijunShunyugakuTekiyoShinseishoEditor editor = new KijunShunyugakuTekiyoShinseishoEditor(基準収入額適用申請書Entity);

        IKijunShunyugakuTekiyoShinseishoBuilder builder = new KijunShunyugakuTekiyoShinseishoBuilder(editor);
        writer.writeLine(builder);
    }
}
