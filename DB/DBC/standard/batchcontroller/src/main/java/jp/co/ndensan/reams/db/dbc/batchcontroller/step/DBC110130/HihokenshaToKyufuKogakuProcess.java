/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshakyufujisseki.HihokenshaToKyufuKogakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikogakukaigoservicehi.DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の変換結果取込_高額Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HihokenshaToKyufuKogakuProcess extends BatchProcessBase<HihokenshaToKyufuKogakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get変換結果取込_高額");
    private static final RString 給付実績高額一時NAME = new RString("DbWT1132KyufujissekiKogakuKaigoServicehi");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績高額一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績高額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績高額一時NAME, DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity.class);
    }

    @Override
    protected void process(HihokenshaToKyufuKogakuEntity entity) {
        DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity 一時entity = entity.get給付実績高額一時Entity();
        DbWT1001HihokenshaTempEntity 被保険者一時entity = entity.get被保険者一時Entity();
        一時entity.setHokenshaNo(被保険者一時entity.getExHokenshaNo());
        一時entity.setHokenshaName(被保険者一時entity.getExHokenshaName());
        一時entity.setSofuHihokenshaNo(被保険者一時entity.getSofuHihokenshaNo());
        給付実績高額一時tableWriter.update(一時entity);
    }
}
