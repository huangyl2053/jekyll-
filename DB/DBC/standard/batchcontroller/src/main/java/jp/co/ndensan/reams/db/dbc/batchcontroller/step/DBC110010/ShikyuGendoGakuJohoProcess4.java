/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.ShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給限度額情報取得4のクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class ShikyuGendoGakuJohoProcess4 extends BatchProcessBase<ShikyuGendoGakuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010"
            + ".IKyufukanrihyoOutMapper.get支給限度額登録4");
    private static final RString 自己作成管理一時_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 自己作成管理一時TBL;

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
    protected void process(ShikyuGendoGakuEntity entity) {
        DbT7109KubunShikyuGendoGakuEntity 居宅サービス区分支給限度額Entity = entity.get居宅サービス区分支給限度額Entity();
        KyotakuKeikakuJikosakuseiKanriTempEntity 居宅給付計画自己作成管理一時Entity4 = entity.get居宅給付計画自己作成管理一時Entity();
        居宅給付計画自己作成管理一時Entity4.setHyojiShikyuGendoTanisu(居宅サービス区分支給限度額Entity.getShikyuGendoTaniSu());
        居宅給付計画自己作成管理一時Entity4.setShikyuGendoKaishiYM(居宅サービス区分支給限度額Entity.getTekiyoKaishiYM());
        自己作成管理一時TBL.update(居宅給付計画自己作成管理一時Entity4);
    }
}
