/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujisseki.DbWT1111KyufuJissekiTempTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の基本データの取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class InsKihonTempProcess extends BatchProcessBase<DbWT1131KyufujissekiKihonTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get基本一時データ");
    private static final RString データ区分 = new RString("00");

    private static final RString 給付実績一時NAME = new RString("DbWT1111KyufuJissekiTemp");
    private static final int INT_0 = 0;

    private HokenshaKyufujissekiProcessParameter processParameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, processParameter.toHokenshaKyufujissekiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時NAME, DbWT1111KyufuJissekiTempTempEntity.class);
    }

    @Override
    protected void process(DbWT1131KyufujissekiKihonTempEntity entity) {
        DbWT1111KyufuJissekiTempTempEntity 給付実績一時entity = new DbWT1111KyufuJissekiTempTempEntity(entity);
        給付実績一時entity.setDataKunbun(データ区分);
        給付実績一時entity.setRenban2(INT_0);
        給付実績一時tableWriter.insert(給付実績一時entity);
    }
}
