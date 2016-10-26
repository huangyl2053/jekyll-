/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.ShikyuGendoGakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成の介護事業者指定サービス事業者名称取得Processクラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyufukanrihyoOutGetjigyoshaNameProcess extends BatchProcessBase<ShikyuGendoGakuEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper."
                    + "select介護事業者名称");
    private static final RString 自己作成管理一時TBL_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT7063TableWriter;

    @Override
    protected void createWriter() {
        this.dbWT7063TableWriter = new BatchEntityCreatedTempTableWriter(自己作成管理一時TBL_NAME, KyotakuKeikakuJikosakuseiKanriTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(ShikyuGendoGakuEntity entity) {
        KyotakuKeikakuJikosakuseiKanriTempEntity kyotakuKeikakuTempEntity = entity.get居宅給付計画自己作成管理一時Entity();
        kyotakuKeikakuTempEntity.setServiceTeikyoJigyoshaName(entity.get介護事業者指定サービスEntity().getJigyoshaName().getColumnValue());
        dbWT7063TableWriter.update(kyotakuKeikakuTempEntity);
    }
}
