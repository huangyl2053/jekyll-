/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.JigyoshaMeisyoAndShikibetsuNoKanrenEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付更新結果情報取込・入力識別名称取得を実行する。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInGetNameProcess extends BatchProcessBase<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekiin.IKyufuJissekiInJohoMapper.select入力識別名称関連リスト");
    @BatchWriter
    private IBatchTableWriter 給付実績一時tableWriter;
    private static final RString 給付実績一時_TABLE_NAME = new RString("DbWT1111KyufuJisseki");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時_TABLE_NAME, DbWT1111KyufuJissekiEntity.class);
    }

    @Override
    protected void process(JigyoshaMeisyoAndShikibetsuNoKanrenEntity t) {
        DbWT1111KyufuJissekiEntity 給付実績 = t.get給付実績();
        DbT3118ShikibetsuNoKanriEntity 識別番号 = t.get識別番号();
        if (null != 識別番号) {
            給付実績.setNyuryokuShikibetsuMeisho(識別番号.getRyakusho());
            給付実績.setState(EntityDataState.Modified);
            給付実績一時tableWriter.update(給付実績);
        }
    }

}
