/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 平準化前賦課Tempテーブルに削除のクラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class DelHeijunkaZenFukaTemp1Process extends SimpleBatchProcessBase {

    private ITokuchoHeinjunka8GatsuBatchMapper mapper;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(ITokuchoHeinjunka8GatsuBatchMapper.class);
    }

    @Override
    protected void process() {
        mapper.do賦課情報あり_平準化前賦課Tempテーブルに削除();
    }

}
