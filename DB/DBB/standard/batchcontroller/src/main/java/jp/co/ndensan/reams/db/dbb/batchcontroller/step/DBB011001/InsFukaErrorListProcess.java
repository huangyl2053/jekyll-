/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧データに登録processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class InsFukaErrorListProcess extends BatchProcessBase<TokutyoukariSannteiTyuushutuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select不整合データ");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    private static final RString 特徴仮算定抽出_TABLE_NAME = new RString("TokutyoukariSannteiTyuushutuTemp");
    private TokuchoKariSanteiFukaManagerBatch manager;

    @BatchWriter
    private IBatchTableWriter 賦課エラー一覧Writer;
    @BatchWriter
    private IBatchTableWriter 特徴仮算定抽出TempWriter;

    @Override
    protected void initialize() {
        super.initialize();
        manager = TokuchoKariSanteiFukaManagerBatch.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        賦課エラー一覧Writer = new BatchPermanentTableWriter(DbT2010FukaErrorListEntity.class);
        特徴仮算定抽出TempWriter = new BatchEntityCreatedTempTableWriter(特徴仮算定抽出_TABLE_NAME, TokutyoukariSannteiTyuushutuEntity.class);
    }

    @Override
    protected void process(TokutyoukariSannteiTyuushutuEntity entity) {
        DbT2010FukaErrorListEntity 賦課エラー一覧Entity = manager.set賦課エラー一覧Entity(entity, processParameter.get調定日時());
        賦課エラー一覧Writer.insert(賦課エラー一覧Entity);
        特徴仮算定抽出TempWriter.delete(entity);
    }

}
