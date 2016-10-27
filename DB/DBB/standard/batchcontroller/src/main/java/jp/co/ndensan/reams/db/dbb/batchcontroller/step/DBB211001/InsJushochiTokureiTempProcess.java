/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.InsJushochiTokureiTempProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例該当データ抽出します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class InsJushochiTokureiTempProcess extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get住所地特例該当データ");
    private static final RString TEMP_TABLE = new RString("住所地特例該当者Temp");
    private InsJushochiTokureiTempProcessParameter parameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<DbT1001HihokenshaDaichoEntity> 住所地特例該当者Temp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toSelectJushochiTempDataMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        住所地特例該当者Temp = new BatchEntityCreatedTempTableWriter(
                TEMP_TABLE, DbT1001HihokenshaDaichoEntity.class);
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity t) {
        住所地特例該当者Temp.insert(t);
    }
}
