/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100029;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100029.JyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100029.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（利用者向け） Report
 *
 * @reamsid_L DBC-1910-050 jiangxiaolong
 */
public class JyuryoItakuKeiyakuKakuninShoReport
        extends Report<JyuryoItakuKeiyakuKakuninShoSource> {

    private final JyuryoItakuKeiyakuKakuninShoEntity 帳票出力対象データ;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力対象データ JyuryoItakuKeiyakuKakuninShoEntity
     */
    public JyuryoItakuKeiyakuKakuninShoReport(
            JyuryoItakuKeiyakuKakuninShoEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public void writeBy(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<JyuryoItakuKeiyakuKakuninShoSource> writer,
            JyuryoItakuKeiyakuKakuninShoEntity 帳票出力対象データ) {
        IJyuryoItakuKeiyakuKakuninShoEditor bodyEditor
                = new JyuryoItakuKeiyakuKakuninShoEditor(帳票出力対象データ);
        IJyuryoItakuKeiyakuKakuninShoBuilder builder
                = new JyuryoItakuKeiyakuKakuninShoBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
