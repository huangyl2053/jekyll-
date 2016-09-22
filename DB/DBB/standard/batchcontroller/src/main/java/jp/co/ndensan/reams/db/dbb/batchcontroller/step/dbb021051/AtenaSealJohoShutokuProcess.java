/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021051;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.dbb021051.DBB021051DataUtil;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb021051.DBB021051ProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.AtenaSealJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051ShoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051TableJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のプロセスクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public class AtenaSealJohoShutokuProcess extends BatchProcessBase<AtenaSealJohoEntity> {

    /**
     * 出力パラメターhasErrorの名称です。
     */
    public static final RString HAS_ERROR;
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "dbb021051.IDBB021051Mapper.get一時表情報");
    private static final RString 宛名シール情報TABLENAME = new RString("DbWT1051AtenaShirYoho");
    private static final RString 処理結果リストTABLENAME = new RString("DbWT1051SyorikekaRisuto");
    private boolean existingFlag;
    private OutputParameter<Boolean> hasError;
    private DBB021051ProcessParameter parameter;
    private DBB021051DataUtil dataUtil;
    @BatchWriter
    private IBatchTableWriter<DBB021051TableJohoTempEntity> 宛名シール情報Temp;
    @BatchWriter
    private IBatchTableWriter<DBB021051ShoriKekkaListTempEntity> 処理結果リストTemp;

    static {
        HAS_ERROR = new RString("hasError");
    }

    @Override
    protected void initialize() {
        existingFlag = false;
        dataUtil = new DBB021051DataUtil();
        hasError = new OutputParameter<>();
        hasError.setValue(false);
        List<KoikiZenShichosonJoho> koikiZenShichosonJohoList
                = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
        KoikiZenShichosonJoho koikiZenShichosonJoho;
        if (koikiZenShichosonJohoList == null || koikiZenShichosonJohoList.isEmpty()) {
            koikiZenShichosonJoho = null;
        } else {
            koikiZenShichosonJoho = koikiZenShichosonJohoList.get(0);
        }
        dataUtil.intProcessParameter(koikiZenShichosonJoho, parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toDBB021051MyBatisParameter(RString.EMPTY));
    }

    @Override
    protected void createWriter() {
        宛名シール情報Temp = new BatchEntityCreatedTempTableWriter<>(
                宛名シール情報TABLENAME, DBB021051TableJohoTempEntity.class);
        処理結果リストTemp = new BatchEntityCreatedTempTableWriter<>(
                処理結果リストTABLENAME, DBB021051ShoriKekkaListTempEntity.class);
    }

    @Override
    protected void process(AtenaSealJohoEntity entity) {
        existingFlag = true;
        宛名シール情報Temp.insert(dataUtil.toDBB021051TableJohoTempEntity(entity, parameter));
    }

    @Override
    protected void afterExecute() {
        if (!existingFlag) {
            処理結果リストTemp.insert(dataUtil.getErrorEntity());
            hasError.setValue(!existingFlag);
        }
    }
}
