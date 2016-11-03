/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigokyufuhitaishoshatoroku.KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績社会福祉法人軽減額のバックアップのProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
public class InsKyufuJissekiShafukuKeigenTmpProcess extends BatchProcessBase<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> {

    private KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績社会福祉法人軽減額tableWriter;

    private static final RString 給付実績社会福祉法人軽減額_TABLE_NAME = new RString("TempKyufuJissekiShakaiFukushiHojinKeigengaku");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select給付実績社会福祉法人軽減額");

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void createWriter() {
        給付実績社会福祉法人軽減額tableWriter = new BatchEntityCreatedTempTableWriter(
                給付実績社会福祉法人軽減額_TABLE_NAME, DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        KyufuJissekiKihonKogakuMybatisParameter mybatisParam = new KyufuJissekiKihonKogakuMybatisParameter();
        mybatisParam.set最古のサービス提供年月(parameter.get最古のサービス提供年月());
        mybatisParam.set最新のサービス提供年月(parameter.get最新のサービス提供年月());
        return new BatchDbReader(MAPPERPATH, mybatisParam);
    }

    @Override
    protected void process(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {
        給付実績社会福祉法人軽減額tableWriter.insert(entity);
    }

}
