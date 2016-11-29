/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB514001;

import jp.co.ndensan.reams.db.dbb.business.core.nofugakudatasakuseitandokushichoson.NofugakuJohoCreate;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nofugakudatasakuseitandokushichoson.NofugakuDataProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額情報一時テーブル作成
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public class NofugakuJohoSakuseiProcess extends BatchProcessBase<NofugakuJohoResultEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".nofugakudatasakuseitandokushichoson.INofugakuDataSakuseiMapper.get納付額情報");
    private static final RString TABLE_NAME = new RString("DbT2016NofugakuJohoTemp");
    private static final RString 波線 = new RString("～");
    private NofugakuDataProcessParameter parameter;
    private RString breakKey;
    private NofugakuJohoTempEntity 納付額情報TempEntity;
    private NofugakuJohoCreate create;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        breakKey = RString.EMPTY;
        create = new NofugakuJohoCreate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                NofugakuJohoTempEntity.class);
    }

    @Override
    protected void process(NofugakuJohoResultEntity entity) {
        RString nowKey = entity.get調定年度().toDateString().concat(波線).concat(entity.get賦課年度().toDateString())
                .concat(波線).concat(entity.get通知書番号().value());
        if (breakKey.equals(nowKey)) {
            create.set期別金額(entity, 納付額情報TempEntity);
            create.set収入情報(entity, 納付額情報TempEntity);
        } else {
            if (納付額情報TempEntity != null) {
                tableWriter.insert(納付額情報TempEntity);
                納付額情報TempEntity = null;
            }
            breakKey = nowKey;
            納付額情報TempEntity = create.get納付額情報TempEntity(entity);
            create.set期別金額(entity, 納付額情報TempEntity);
            create.set収入情報(entity, 納付額情報TempEntity);
        }
    }

    @Override
    protected void afterExecute() {
        if (納付額情報TempEntity != null) {
            tableWriter.insert(納付額情報TempEntity);
        }
    }
}
