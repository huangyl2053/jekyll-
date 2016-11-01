/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyufukanrihyoOutDoBillOutEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票・保険者番号取込を実行する。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyufukanrihyoOutHokenshaNoProcess extends BatchProcessBase<KyufukanrihyoOutDoBillOutEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper."
                    + "get保険者番号登録");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 自己作成管理一時TBL;
    private static final RString 自己作成管理一時_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        自己作成管理一時TBL = new BatchEntityCreatedTempTableWriter(自己作成管理一時_NAME,
                KyotakuKeikakuJikosakuseiKanriTempEntity.class);
    }

    @Override
    protected void process(KyufukanrihyoOutDoBillOutEntity entity) {
        KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity = entity.get自己作成管理一時Entity();
        HihokenshaTempEntity 被保険者一時Entity = entity.get被保険者一時Entity();
        自己作成管理一時Entity.setHokenshaNo(被保険者一時Entity.getExHokenshaNo());
        自己作成管理一時Entity.setHokenshaName(被保険者一時Entity.getExHokenshaName());
        自己作成管理一時TBL.update(自己作成管理一時Entity);
    }
}
