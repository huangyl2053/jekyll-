/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuResultEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴仮算定抽出Tempに登録（特徴継続・4月開始データ）processクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class InsTokuchoKariChushutsuTmp1Process extends BatchProcessBase<TokutyoukariSannteiTyuushutuResultEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select特徴継続者");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    private static final RString 特徴仮算定抽出_TABLE_NAME = new RString("TokutyoukariSannteiTyuushutuTemp");
    private static final int INT_1 = 1;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        TokuchoKarisanteiFukaMyBatisParameter parameter = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.set調定年度BeforeYear(processParameter.get調定年度().minusYear(INT_1));
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(特徴仮算定抽出_TABLE_NAME, TokutyoukariSannteiTyuushutuEntity.class);
    }

    @Override
    protected void process(TokutyoukariSannteiTyuushutuResultEntity entity) {
        TokutyoukariSannteiTyuushutuEntity 特徴仮算定抽出Entity = TokuchoKariSanteiFukaManagerBatch
                .createInstance().create特徴仮算定抽出TempEntity(entity, true);
        tempDbWriter.insert(特徴仮算定抽出Entity);
    }
}
