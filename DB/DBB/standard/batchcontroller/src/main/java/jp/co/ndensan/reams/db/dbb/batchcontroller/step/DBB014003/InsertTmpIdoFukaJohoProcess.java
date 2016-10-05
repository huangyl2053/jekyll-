/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FuchoKariTsuchishoIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tmpidofukajoho.TmpIdoFukaJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定通知書一括発行の異動賦課情報一時テーブルに登録Processクラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class InsertTmpIdoFukaJohoProcess extends BatchProcessBase<FuchoKariTsuchishoIkkatsuHakkoTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufukanrihyoin.IKyufukanrihyoInMapper.get事業者名称_介護予防支援事業所地域包括支援センター作成の場合");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動賦課情報一時tableWriter;
    private static final RString 給付管理票一時_TABLE_NAME = new RString("TmpIdoFukaJoho");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        異動賦課情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付管理票一時_TABLE_NAME, TmpIdoFukaJohoEntity.class);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process(FuchoKariTsuchishoIkkatsuHakkoTempEntity entity) {
        TmpIdoFukaJohoEntity 異動賦課情報 = new TmpIdoFukaJohoEntity();
        異動賦課情報.setAtesakiDaino_atesakiShubetsu(READ_DATA_ID);
        異動賦課情報一時tableWriter.insert(異動賦課情報);
    }

}
