/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb013001.TokuchoHeinjunka8GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴8月分）バッチ平準化前賦課Temp出力クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class GetShiKakuJohoProcess extends BatchProcessBase<DbT1001HihokenshaDaichoEntity> {

    private static final RString 資格情報TEMP_TABLE_NAME = new RString("ShiKakuJohoTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.get資格情報Temp");
    private TokuchoHeinjunka8GatsuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 仮算定一括発行一時tableWriter;

    @Override
    protected void createWriter() {
        仮算定一括発行一時tableWriter = new BatchEntityCreatedTempTableWriter(資格情報TEMP_TABLE_NAME,
                DbT1001HihokenshaDaichoEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoHeinjunka8GatsuMyBatisParameter myBatisParameter = new TokuchoHeinjunka8GatsuMyBatisParameter();
        myBatisParameter.set調定年度(parameter.get調定年度());
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void process(DbT1001HihokenshaDaichoEntity fukaTmpEntity) {
        仮算定一括発行一時tableWriter.insert(fukaTmpEntity);

    }

}
