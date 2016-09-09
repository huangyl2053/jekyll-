/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateMeisyoKanrenEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護給付費再審査申立書情報作成・介護事業者指定サービス・事業者名称取得を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateGetShiteiServiceJigyoshaNameProcess extends BatchProcessBase<SaishinsaMoshitateMeisyoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select介護事業者指定サービス名称関連リスト");
    @BatchWriter
    private IBatchTableWriter 再審査申立一時tableWriter;
    private static final RString 再審査申立一時_TABLE_NAME = new RString("DbWT1741SaishinsaMoshitate");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        再審査申立一時tableWriter
                = new BatchEntityCreatedTempTableWriter(再審査申立一時_TABLE_NAME, DbWT1741SaishinsaMoshitateEntity.class);
    }

    @Override
    protected void process(SaishinsaMoshitateMeisyoKanrenEntity entity) {
        DbWT1741SaishinsaMoshitateEntity 再審査申立 = entity.get再審査申立();
        DbT7063KaigoJigyoshaShiteiServiceEntity サービス事業者 = entity.getサービス事業者();
        再審査申立.setJigyoshaName(getColumnValue(サービス事業者.getJigyoshaName()));
        再審査申立.setState(EntityDataState.Modified);
        再審査申立一時tableWriter.update(再審査申立);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
