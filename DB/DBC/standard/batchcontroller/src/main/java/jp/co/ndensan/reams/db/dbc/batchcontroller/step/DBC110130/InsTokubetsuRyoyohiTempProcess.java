/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujisseki.DbWT1111KyufuJissekiTempTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の特定診療費・特別療養費データの取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class InsTokubetsuRyoyohiTempProcess extends BatchProcessBase<DbWT1111KyufuJissekiTempTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get特定診療費_特別療養費");
    private static final RString データ区分 = new RString("05");

    private static final RString 給付実績一時NAME = new RString("DbWT1111KyufuJissekiTemp");
    private static final int INT_1 = 1;

    private HokenshaKyufujissekiProcessParameter processParameter;
    private int renban2;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績一時tableWriter;

    @Override
    protected void initialize() {
        renban2 = INT_1;
    }

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
    protected void process(DbWT1111KyufuJissekiTempTempEntity entity) {
        entity.setDataKunbun(データ区分);
        entity.setRenban2(renban2);
        給付実績一時tableWriter.insert(entity);
        renban2 = renban2 + INT_1;
    }
}
