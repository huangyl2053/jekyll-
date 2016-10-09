/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteitsuchishohakko.TmpIdoFukaJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.DbT2015KeisangoJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定の更新後データを抽出するクラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class UpdateKeisangoJohoIchijiProcess extends BatchProcessBase<DbT2015KeisangoJohoTempEntity> {

    private static final RString 異動賦課情報一時テーブル = new RString("TmpIdoFukaJoho");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "fuchokaritsuchishoikkatsuhakko.IFuchoKarisanteiTsuchishoHakkoMapper.select異動賦課情報_計算後情報一時_計算後情報更正前");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動賦課情報一時tableWriter;

    @Override
    protected void createWriter() {
        異動賦課情報一時tableWriter = new BatchEntityCreatedTempTableWriter(異動賦課情報一時テーブル,
                TmpIdoFukaJohoEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(DbT2015KeisangoJohoTempEntity keisangoJohoEntity) {
        DbT2015KeisangoJohoEntity 計算後情報_更正前 = keisangoJohoEntity.get計算後情報_更正前();
        TmpIdoFukaJohoEntity 異動賦課情報一時 = keisangoJohoEntity.get異動賦課情報一時テーブル();
        if (異動賦課情報一時 != null && 計算後情報_更正前 != null) {
            IdoFukaJohoTempEntitySet entitySet = new IdoFukaJohoTempEntitySet();
            entitySet.update異動賦課情報一時Entity(異動賦課情報一時, 計算後情報_更正前);
            異動賦課情報一時tableWriter.update(異動賦課情報一時);
        }
    }
}
