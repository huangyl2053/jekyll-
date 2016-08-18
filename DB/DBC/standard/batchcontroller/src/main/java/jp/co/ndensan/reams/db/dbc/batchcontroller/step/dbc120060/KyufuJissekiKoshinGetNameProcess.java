/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.JigyoshaMeisyoAndShikibetsuNoKanrenEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekikoshinin.IKyufuJissekiKoshinJohoMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 給付実績更新結果情報取込・名称取得を実行する。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class KyufuJissekiKoshinGetNameProcess extends BatchProcessBase<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekikoshinin.IKyufuJissekiKoshinJohoMapper.select入力識別名称関連リスト");
    private List<JigyoshaMeisyoAndShikibetsuNoKanrenEntity> 事業者名称取得リスト;
    private List<DbWT1111KyufuJissekiTempEntity> 入力識別名称登録リスト;
    private IKyufuJissekiKoshinJohoMapper mapper;
    private IKokuhorenKyoutsuuTempTableMapper kekkaMapper;
    private static final RString エラー区分_名称取得エラー = new RString("05");

    @Override
    protected void initialize() {
        super.initialize();
        事業者名称取得リスト = new ArrayList<>();
        入力識別名称登録リスト = new ArrayList<>();
        mapper = getMapper(IKyufuJissekiKoshinJohoMapper.class);
        kekkaMapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
    }

    @Override
    protected void beforeExecute() {
        事業者名称取得リスト = mapper.select事業者名称関連リスト();
        for (JigyoshaMeisyoAndShikibetsuNoKanrenEntity t : 事業者名称取得リスト) {
            DbWT1111KyufuJissekiTempEntity 給付実績 = t.get給付実績();
            List<DbT7060KaigoJigyoshaEntity> 介護事業者リスト = t.get介護事業者List();
            if (null != 介護事業者リスト && !介護事業者リスト.isEmpty()) {
                給付実績.set事業者名称(getColumnValue(介護事業者リスト.get(0).getJigyoshaName()));
                mapper.do事業者名称の登録(給付実績);
            } else {
                DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
                処理結果.setエラー区分(エラー区分_名称取得エラー);
                処理結果.setキー3(給付実績.getサービス提供年月().toDateString());
                処理結果.setキー4(getColumnValue(給付実績.get事業所番号()));
                処理結果.set備考(new RString("事業者名称"));
                kekkaMapper.処理結果リスト一時TBLに登録(処理結果);
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(JigyoshaMeisyoAndShikibetsuNoKanrenEntity t) {
        DbWT1111KyufuJissekiTempEntity 給付実績 = t.get給付実績();
        DbT3118ShikibetsuNoKanriEntity 識別番号 = t.get識別番号();
        if (null != 識別番号) {
            給付実績.set入力識別名称(識別番号.getRyakusho());
            入力識別名称登録リスト.add(給付実績);
        }
    }

    @Override
    protected void afterExecute() {
        for (DbWT1111KyufuJissekiTempEntity 給付実績 : 入力識別名称登録リスト) {
            mapper.do入力識別名称の登録(給付実績);
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null == entity) {
            return RString.EMPTY;
        }
        return entity.getColumnValue();
    }

}
