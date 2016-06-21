/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.KoseimaeJohoUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.DbT2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「「更正前」計算後情報の全項目の更新」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class KoseimaeJohoUpdateProcess extends BatchProcessBase<DbT2002FukaTempTableEntity> {

    KoseimaeJohoUpdateProcessParameter parameter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako."
            + "ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.selectAll賦課TempTableEntity");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT2002FukaTempTableEntity> batchEntityCreatedWriter;

    private List<DbTKeisangoJohoTempTableEntity> 計算後List;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchEntityCreatedWriter = new BatchEntityCreatedTempTableWriter<>(DbT2002FukaTempTableEntity.TABLE_NAME,
                DbT2002FukaTempTableEntity.class);
    }

    @Override
    protected void beforeExecute() {
        計算後List = (List<DbTKeisangoJohoTempTableEntity>) parameter.get計算後List();
    }

    @Override
    protected void process(DbT2002FukaTempTableEntity entity) {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        if (service.find計算後情報For更正前(計算後List, entity) != null) {
            batchEntityCreatedWriter.update(entity);
        }
    }

}
