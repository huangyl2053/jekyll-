/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020090;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiJigyoHaakuNyuryokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握（バッチ）のパラメータです。
 *
 * @reamsid_L DBC-2010-050 tianshuai
 */
public class SetaiinHaakuNyuryokuTempCreatProcess extends SimpleBatchProcessBase {

    private static final RString TABLE_世帯員所得情報高額一時 = new RString("TmpSetaiHaakuNyuryoku");
    private static final RString TABLE_世帯員所得情報事業高額一時 = new RString("TmpSetaiJigyoHaakuNyuryoku");

    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinShotokuWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter setaiinShotokuJigyoWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        createTempTable();
    }

    @Override
    protected void process() {
    }

    @Override
    protected void afterExecute() {
    }

    private void createTempTable() {
        setaiinShotokuWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得情報高額一時, TmpSetaiHaakuNyuryokuEntity.class);
        setaiinShotokuJigyoWriter = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得情報事業高額一時, TmpSetaiJigyoHaakuNyuryokuEntity.class);
    }
}
