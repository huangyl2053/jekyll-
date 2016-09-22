/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetOldHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧被保険者番号の取得 クラスです
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
public class HokenshaKyufujissekiOutGetOldHihokenshaNoProcess extends BatchProcessBase<HokenshaKyufujissekiOutGetOldHihokenshaEntity> {

    /**
     * 被保険者番号変換対象データの取得後の返したエンティティ
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
            + "IHokenshaKyufujissekiOutMapper.select旧被保険者番号");
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
    protected void process(HokenshaKyufujissekiOutGetOldHihokenshaEntity entity) {
        entity.getDbWT1001Entity().setExHokenshaNo(new HokenshaNo(entity.getDbWT1001Entity().getExShoHokenshaNo().getColumnValue()));
        entity.getDbWT1001Entity().setOldShichosonCode(entity.getDbT7026Entity().getShichosonCode());
        entity.getDbWT1001Entity().setSofuHihokenshaNo(new HihokenshaNo(entity.getDbT7026Entity().getKyuNo()));
        dbWT0001TableWriter.update(entity.getDbWT1001Entity());
        numble++;
    }

    @Override
    protected void afterExecute() {
        returnEntity.setCodeNum(numble);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);

    }

}
