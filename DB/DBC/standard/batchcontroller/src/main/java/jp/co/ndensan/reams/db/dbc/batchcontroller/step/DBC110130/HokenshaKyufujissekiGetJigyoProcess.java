/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.JigyoshaMeisyoAndShikibetsuNoKanrenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 保険者保有給付実績情報作成の事業者名称取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class HokenshaKyufujissekiGetJigyoProcess extends BatchProcessBase<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekikoshinin.IKyufuJissekiKoshinJohoMapper.select事業者名称関連リスト");
    private static final RString 処理結果リスト一時NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString 給付実績一時NAME = new RString("DbWT1111KyufuJisseki");
    private static final RString 事業者名称R = new RString("事業者名称");

    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時NAME, DbWT1111KyufuJissekiEntity.class);
    }

    @Override
    protected void process(JigyoshaMeisyoAndShikibetsuNoKanrenEntity t) {
        DbWT1111KyufuJissekiEntity 給付実績 = t.get給付実績();
        DbT7060KaigoJigyoshaEntity 介護事業者 = t.get介護事業者();
        if (null != 介護事業者) {
            給付実績.setJigyoshaName(getColumnValue(介護事業者.getJigyoshaName()));
            給付実績一時tableWriter.update(給付実績);
        } else {
            DbWT1002KokuhorenSakuseiErrorTempEntity dbWT1002Entity = get処理結果リスト一時Entity(給付実績);
            処理結果リスト一時tableWriter.insert(dbWT1002Entity);
        }
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時Entity(DbWT1111KyufuJissekiEntity 給付実績) {
        DbWT1002KokuhorenSakuseiErrorTempEntity 一時Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        一時Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.名称取得エラー.getコード());
        一時Enttiy.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        一時Enttiy.setHihokenshaNo(HihokenshaNo.EMPTY);
        一時Enttiy.setKey1(RString.EMPTY);
        一時Enttiy.setKey2(RString.EMPTY);
        一時Enttiy.setKey3(RString.EMPTY);
        一時Enttiy.setKey4(給付実績.getJigyoshoNo().getColumnValue());
        一時Enttiy.setKey5(RString.EMPTY);
        一時Enttiy.setHihokenshaKanaShimei(RString.EMPTY);
        一時Enttiy.setHihokenshaShimei(RString.EMPTY);
        一時Enttiy.setBiko(事業者名称R);
        return 一時Enttiy;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null == entity) {
            return RString.EMPTY;
        }
        return entity.getColumnValue();
    }
}
