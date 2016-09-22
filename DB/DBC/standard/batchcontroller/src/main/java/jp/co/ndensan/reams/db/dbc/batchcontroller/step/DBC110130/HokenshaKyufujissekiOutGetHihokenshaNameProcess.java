/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNameEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者名の取得 クラスです
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
public class HokenshaKyufujissekiOutGetHihokenshaNameProcess extends BatchProcessBase<HokenshaKyufujissekiOutGetHihokenshaNameEntity> {

    private static final RString TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout."
            + "IHokenshaKyufujissekiOutMapper.select保険者名");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT0001TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT1001HihokenshaTempEntity.class);

    }

    @Override
    protected void process(HokenshaKyufujissekiOutGetHihokenshaNameEntity entity) {
        entity.getDbWT1001Entity().setExHokenshaName(entity.getUrT0507Entity().getHokenjaName());
        dbWT0001TableWriter.update(entity.getDbWT1001Entity());
    }

    @Override
    protected void afterExecute() {

    }

}
