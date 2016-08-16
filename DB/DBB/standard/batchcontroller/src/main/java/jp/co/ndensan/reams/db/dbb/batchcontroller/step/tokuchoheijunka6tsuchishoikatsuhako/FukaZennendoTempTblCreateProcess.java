/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「前年度賦課情報一時テーブル作成」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class FukaZennendoTempTblCreateProcess extends BatchProcessBase<DbT2002FukaEntity> {

    FukaJohoShutokuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 前年度賦課情報一時tableWriter;

    private static final RString 前年度賦課情報一時_TABLE_NAME = new RString("DbT2002FukaZennendoTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper."
            + "relate.tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.select前年度賦課情報");

    @Override
    protected void createWriter() {
        前年度賦課情報一時tableWriter = new BatchEntityCreatedTempTableWriter(前年度賦課情報一時_TABLE_NAME, DbT2002FukaEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        IKozaSearchKey key = builder.build();
        return new BatchDbReader(MAPPERPATH, new TokuchoHeijunka6gatsuMyBatisParameter(
                false, parameter.get調定年度(), null, null, null, null, null, null, null, key));
    }

    @Override
    protected void process(DbT2002FukaEntity entity) {
        前年度賦課情報一時tableWriter.insert(entity);
    }

}
