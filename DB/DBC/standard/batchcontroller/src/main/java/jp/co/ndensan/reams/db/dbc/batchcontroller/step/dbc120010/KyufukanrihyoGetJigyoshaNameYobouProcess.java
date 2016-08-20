/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin.KyufukanrihyoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者名称を取得する。<br>
 * 居宅サービス計画作成区分コード＝3：介護予防支援事業所・地域包括支援センター作成の場合
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
public class KyufukanrihyoGetJigyoshaNameYobouProcess extends BatchProcessBase<KyufukanrihyoJigyoshaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufukanrihyoin.IKyufukanrihyoInMapper.get事業者名称_介護予防支援事業所地域包括支援センター作成の場合");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付管理票一時tableWriter;
    private static final RString 給付管理票一時_TABLE_NAME = new RString("DbWT1121KyufuKanrihyo");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付管理票一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付管理票一時_TABLE_NAME, DbWT1121KyufuKanrihyoEntity.class);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process(KyufukanrihyoJigyoshaEntity entity) {
        DbWT1121KyufuKanrihyoEntity 給付管理票 = entity.get給付管理票().toEntity();
        給付管理票.setJigyoshaName(entity.get事業者名称());
        給付管理票一時tableWriter.update(給付管理票);
    }

}
