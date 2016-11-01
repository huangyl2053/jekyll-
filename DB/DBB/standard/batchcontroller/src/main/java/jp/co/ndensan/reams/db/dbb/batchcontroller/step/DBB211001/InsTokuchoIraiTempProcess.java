/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsTokuchoIraiTempProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoIraiTempEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴依頼のデータ抽出します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsTokuchoIraiTempProcess extends BatchProcessBase<TokuChoIraiTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.特徴依頼のデータ抽出");
    private static final RString TEMP_TABLE = new RString("特徴依頼Temp");
    private InsTokuchoIraiTempProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<TokuChoIraiTempEntity> 特徴依頼TempTableWriter;

    @Override
    protected IBatchReader createReader() {
        RString 通知内容コード = TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード();
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectTokuChoIraiDataMyBatisParameter(通知内容コード));
    }

    @Override
    protected void createWriter() {
        特徴依頼TempTableWriter = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, TokuChoIraiTempEntity.class);
    }

    @Override
    protected void process(TokuChoIraiTempEntity t) {
        特徴依頼TempTableWriter.insert(t);
    }

}
