/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.SetaiinShotokuHanteiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員所得判定データ分割①_世帯員所得判定明細事業高額一時１の作成
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1 extends BatchProcessBase<SetaiinShotokuHanteiMeisaiTempEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select世帯員所得判定明細一時");
    private static final RString TABLE_世帯員所得判定明細事業高額一時 = new RString("TempSetaiinShotokuHanteiJigyo");

    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;

    /**
     * returnEntity
     */
    public static final RString OUT_PARAMETER;

    static {
        OUT_PARAMETER = new RString("processParameter");
    }

    OutputParameter<KyufuJissekiKihonKogakuProcessParameter> processParameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細事業高額一時,
                SetaiinShotokuHanteiMeisaiTempEntity.class);
    }

    @Override
    protected void process(SetaiinShotokuHanteiMeisaiTempEntity entity) {
        tableWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
//        KyufuJissekiKihonKogakuProcessParameter parameter = mapper.select続柄コード参照年();
//        processParameter.setValue(parameter);
    }

}
