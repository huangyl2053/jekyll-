/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域加入日以前のデータを取得 クラスです
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
public class HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess extends BatchProcessBase<DbWT1001HihokenshaTempEntity> {

    /**
     * 広域加入日以前のデータを取得後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;
    private static int numble = 0;

    private static final RString TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout."
            + "IHokenshaKyufujissekiOutMapper.select広域加入日以前のデータ");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT0001TableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        returnEntity = new FlowEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT1001HihokenshaTempEntity.class);

    }

    @Override
    protected void process(DbWT1001HihokenshaTempEntity entity) {
        entity.setHenkanFlag(true);
        dbWT0001TableWriter.update(entity);
        numble++;
    }

    @Override
    protected void afterExecute() {
        returnEntity.setCodeNum(numble);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

}
