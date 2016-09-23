/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012003;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
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
        return new BatchDbReader(MAPPERPATH, new TokuchoHeijunka6gatsuMyBatisParameter(
                false, parameter.get調定年度(), null, null, null, null, null, null, null));
    }

    @Override
    protected void beforeExecute() {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        service.update計算後情報更正前(new TokuchoHeijunka6gatsuMyBatisParameter(
                parameter.is一括発行フラグ(), null, null, null, ShoriName.特徴平準化計算_6月分.get名称(), null, null, null, null));
    }

    @Override
    protected void process(DbT2002FukaEntity entity) {
        前年度賦課情報一時tableWriter.insert(entity);
    }

}
