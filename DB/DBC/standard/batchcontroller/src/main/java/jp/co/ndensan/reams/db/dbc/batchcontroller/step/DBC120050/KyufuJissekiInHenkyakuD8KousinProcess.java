/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT111JKyufuJissekiD8Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.KyufuJissekiInHenkyakuD8DataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 返却データ削除・給付実績D8の新規、修正データの場合。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInHenkyakuD8KousinProcess extends BatchProcessBase<KyufuJissekiInHenkyakuD8DataEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufujissekiin.IKyufuJissekiInMasterTorokuMapper.select給付実績D8の新規修正データ");
    @BatchWriter
    private BatchPermanentTableWriter 給付実績高額tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績D8tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    private static final RString 給付実績D8一時_TABLE_NAME = new RString("DbWT111JKyufuJissekiD8");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績高額tableWriter
                = new BatchPermanentTableWriter(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class);
        給付実績D8tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績D8一時_TABLE_NAME, DbWT111JKyufuJissekiD8Entity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(KyufuJissekiInHenkyakuD8DataEntity entity) {
        DbWT111JKyufuJissekiD8Entity 給付実績D8 = entity.get給付実績D8();
        DbT3028KyufujissekiKogakuKaigoServicehiEntity 給付実績高額 = entity.get給付実績高額介護サービス費();
        DbWT0001HihokenshaTempEntity 被保険者一時 = entity.get被保険者一時();
        if (給付実績D8.getShikyugaku() == 給付実績高額.getShikyugaku()) {
            給付実績高額.setState(EntityDataState.Deleted);
            給付実績高額tableWriter.delete(給付実績高額);

            給付実績D8.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(true);
            給付実績D8.setState(EntityDataState.Modified);
            給付実績D8tableWriter.update(給付実績D8);
        } else {
            do削除対象なし(給付実績D8, 被保険者一時);
        }
    }

    private void do削除対象なし(DbWT111JKyufuJissekiD8Entity 給付実績D8, DbWT0001HihokenshaTempEntity 被保険者一時) {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.給付実績情報内容不一致.getコード());
        処理結果.setShoHokanehshaNo(new ShoKisaiHokenshaNo(給付実績D8.getShokisaiHokenshaNo().getColumnValue()));
        処理結果.setHihokenshaNo(被保険者一時.get登録被保険者番号());
        処理結果.setKey1(給付実績D8.getKokanJohoShikibetsuNo().getColumnValue());
        処理結果.setKey2(給付実績D8.getInputShikibetsuNo().getColumnValue());
        RString サービス提供年月 = 給付実績D8.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
        処理結果.setKey3(サービス提供年月);
        処理結果.setKey4(RString.EMPTY);
        処理結果.setKey5(RString.EMPTY);
        処理結果.setHihokenshaKanaShimei(被保険者一時.get宛名カナ名称());
        処理結果.setHihokenshaShimei(被保険者一時.get宛名名称());
        処理結果.setBiko(RString.EMPTY);
        処理結果リスト一時tableWriter.insert(処理結果);
    }

}
