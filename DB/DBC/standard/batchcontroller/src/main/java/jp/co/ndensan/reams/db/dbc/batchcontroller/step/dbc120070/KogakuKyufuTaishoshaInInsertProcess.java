/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyufutaishoshain.KogakuKyufuTaishoshaInCreate;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3054CSVDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbT3055CSVDataGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishoshaichiran.DbTKogakuKyufuCSVDataHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付対象者取込のCSVファイル読取
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInInsertProcess extends BatchProcessBase<RString> {

    /**
     * ファイルパス
     */
    public static final RString PARAMETER_FILEPATH;
    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;

    InputParameter<RString> filePath;
    private static final Integer INDEX_1 = 1;

    static {
        PARAMETER_FILEPATH = new RString("filePath");
        TABLE_NAME = new RString("DbTKogakuKyufuTaishoshaDataTempTable");
    }
    private DbTKogakuKyufuCSVDataHeadEntity headEntity;
    private DbT3054CSVDataMeisaiEntity meisaiEntity;
    private DbT3055CSVDataGokeiEntity gokeiEntity;
    private List<DbT3054CSVDataMeisaiEntity> meisaiList;
    private List<DbT3055CSVDataGokeiEntity> gokeiList;
    private final RString レコード種別_H1 = new RString("H1");
    private final RString レコード種別_D1 = new RString("D1");
    private final RString レコード種別_T1 = new RString("T1");
    private KogakuKyufuTaishoshaInCreate create;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tempTableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        meisaiList = new ArrayList<>();
        gokeiList = new ArrayList<>();
        create = new KogakuKyufuTaishoshaInCreate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(filePath.getValue());
    }

    @Override
    protected void createWriter() {

        tempTableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        DbTKogakuKyufuTaishoshaDataTempTableEntity.class);
    }

    @Override
    protected void process(RString line) {

        List<RString> data = line.split(",");
        if (data == null || INDEX_1 >= data.size()) {
            return;
        }
        if (レコード種別_H1.equals(data.get(INDEX_1))) {
            headEntity = ListToObjectMappingHelper.toObject(DbTKogakuKyufuCSVDataHeadEntity.class, data);
        } else if (レコード種別_D1.equals(data.get(INDEX_1))) {
            meisaiEntity = ListToObjectMappingHelper.toObject(DbT3054CSVDataMeisaiEntity.class, data);
            meisaiList.add(meisaiEntity);
        } else if (レコード種別_T1.equals(data.get(INDEX_1))) {
            gokeiEntity = ListToObjectMappingHelper.toObject(DbT3055CSVDataGokeiEntity.class, data);
            gokeiList.add(gokeiEntity);
        }
    }

    @Override
    protected void afterExecute() {
        if (meisaiList == null || meisaiList.isEmpty() || gokeiList == null || gokeiList.isEmpty()) {
            tempTableWriter.insert(create.createDataRecord(headEntity));
        } else {
            for (DbT3054CSVDataMeisaiEntity 明細entity : meisaiList) {
                for (DbT3055CSVDataGokeiEntity 合計Entity : gokeiList) {
                    if (明細entity.getHihokenshaNo().equals(合計Entity.getHihokenshaNo())) {
                        tempTableWriter.insert(create.createDataRecord(headEntity, 明細entity, 合計Entity));
                    }

                }

            }
        }
    }
}
