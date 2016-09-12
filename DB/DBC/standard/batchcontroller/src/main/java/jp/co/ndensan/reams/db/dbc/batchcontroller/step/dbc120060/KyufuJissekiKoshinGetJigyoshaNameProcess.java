/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.JigyoshaMeisyoAndShikibetsuNoKanrenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
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
 * 給付実績更新結果情報取込・事業者名称取得を実行する。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class KyufuJissekiKoshinGetJigyoshaNameProcess extends BatchProcessBase<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekikoshinin.IKyufuJissekiKoshinJohoMapper.select事業者名称関連リスト");
    private static final RString エラー区分_名称取得エラー = new RString("05");
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績一時tableWriter;
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 給付実績一時_TABLE_NAME = new RString("DbWT1111KyufuJisseki");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時_TABLE_NAME, DbWT1111KyufuJissekiEntity.class);
    }

    @Override
    protected void process(JigyoshaMeisyoAndShikibetsuNoKanrenEntity t) {
        DbWT1111KyufuJissekiEntity 給付実績 = t.get給付実績();
        List<DbT7060KaigoJigyoshaEntity> 介護事業者リスト = t.get介護事業者List();
        if (null != 介護事業者リスト && !介護事業者リスト.isEmpty()) {
            給付実績.setJigyoshaName(getColumnValue(介護事業者リスト.get(0).getJigyoshaName()));
            給付実績.setState(EntityDataState.Modified);
            給付実績一時tableWriter.update(給付実績);
        } else {
            DbWT0002KokuhorenTorikomiErrorEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorEntity();
            処理結果.setErrorKubun(エラー区分_名称取得エラー);
            処理結果.setKey3(給付実績.getServiceTeikyoYM().toDateString());
            処理結果.setKey4(getColumnValue(給付実績.getJigyoshoNo()));
            処理結果.setBiko(new RString("事業者名称"));
            処理結果.setState(EntityDataState.Added);
            処理結果リスト一時tableWriter.insert(処理結果);
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null == entity) {
            return RString.EMPTY;
        }
        return entity.getColumnValue();
    }

}
