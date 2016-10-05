/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100030;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（事業者用） Report
 *
 * @reamsid_L DBC-1910-040 jiangxiaolong
 */
public class JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoReport
        extends Report<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> {

    private final JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 帳票出力対象データ;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力対象データ JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity
     */
    public JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoReport(
            JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public void writeBy(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource> writer,
            JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 帳票出力対象データ) {
        IJyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor bodyEditor
                = new JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor(帳票出力対象データ);
        IJyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoBuilder builder
                = new JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
