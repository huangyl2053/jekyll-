/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100031;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN32003_介護保険高額サービス費受領委任契約承認（不承認）確認書Report
 *
 * @reamsid_L DBC-1970-040 jiangxiaolong
 */
public class KogakuServiceHiJyuryoItakuKeiyakuKakuninShoReport
        extends Report<KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource> {

    private final KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity 帳票出力対象データ;

    /**
     *
     * @param 帳票出力対象データ KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity
     */
    public KogakuServiceHiJyuryoItakuKeiyakuKakuninShoReport(
            KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<KogakuServiceHiJyuryoItakuKeiyakuKakuninShoSource> writer,
            KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity 帳票出力対象データ) {
        IKogakuServiceHiJyuryoItakuKeiyakuKakuninShoEditor bodyEditor
                = new KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEditor(帳票出力対象データ);
        IKogakuServiceHiJyuryoItakuKeiyakuKakuninShoBuilder builder
                = new KogakuServiceHiJyuryoItakuKeiyakuKakuninShoBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
