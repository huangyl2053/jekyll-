/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110090;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成の保険者番号の取得Processクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutDoErrorProcess extends BatchProcessBase<DbWT1731KagoMoshitateTempEntity> {

    /**
     * 保険者番号Errorの返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    /**
     * 保険者番号Errorの dbWT1731List 返したエンティティ
     */
    public static final RString PARAMETER_OUT_OUTPUTENTRY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
        PARAMETER_OUT_OUTPUTENTRY = new RString("outputEntity");
    }

    private OutputParameter<FlowEntity> flowEntity;
    private OutputParameter<List> outputEntity;
    private List<DbWT1731KagoMoshitateTempEntity> dbWT1731List;
    FlowEntity returnEntity;

    private static final RString TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 送付対象データなし = new RString("01");
    private static int numble = 0;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout."
            + "IKaigokyufuhiKagoMoshitateshoOutMapper.select保険者番号Error");
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT0001TableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        flowEntity = new OutputParameter<>();
        outputEntity = new OutputParameter<>();
        returnEntity = new FlowEntity();
        dbWT1731List = new ArrayList();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbWT1731KagoMoshitateTempEntity entity) {
        dbWT1731List.add(entity);
        numble++;

    }

    @Override
    protected void afterExecute() {
        if (0 == numble) {
            DbWT1002KokuhorenSakuseiErrorTempEntity dbWT1002 = new DbWT1002KokuhorenSakuseiErrorTempEntity();
            dbWT1002.setErrorKubun(送付対象データなし);
            dbWT0001TableWriter.insert(dbWT1002);
        }
        returnEntity.setCodeNum(numble);
        flowEntity.setValue(returnEntity);
        outputEntity.setValue(dbWT1731List);

    }

}
