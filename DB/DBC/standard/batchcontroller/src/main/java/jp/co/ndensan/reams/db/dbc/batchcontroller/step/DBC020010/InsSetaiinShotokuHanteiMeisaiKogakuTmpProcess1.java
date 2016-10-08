/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KogakuFlowReturnEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世世帯員所得判定データ分割①_帯員所得判定明細高額一時１の作成
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess1 extends BatchProcessBase<TempSetaiinShotokuHanteiEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select世帯員所得判定明細一時");
    private static final RString TABLE_世帯員所得判定明細高額一時 = new RString("TempSetaiinShotokuHantei1");

    /**
     * returnEntity
     */
    public static final RString FLOWENTITY;

    static {
        FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<KogakuFlowReturnEntity> flowEntity;
    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細高額一時,
                TempSetaiinShotokuHanteiEntity.class);
    }

    @Override
    protected void process(TempSetaiinShotokuHanteiEntity entity) {
        tableWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
        KogakuFlowReturnEntity flowReturnEntity = mapper.select続柄コード参照年();
        flowEntity.setValue(flowReturnEntity);
    }
}
