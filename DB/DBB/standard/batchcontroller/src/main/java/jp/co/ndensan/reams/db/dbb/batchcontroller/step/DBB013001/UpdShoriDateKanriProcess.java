/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb013001.TokuchoHeinjunka8GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「処理日付管理テーブル更新」処理クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private TokuchoHeinjunka8GatsuProcessParameter processParameter;
    private ITokuchoHeinjunka8GatsuBatchMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuchoHeinjunka8GatsuBatchMapper.class);
    }

    @Override
    protected void process() {
        TokuchoHeinjunka8GatsuMyBatisParameter parameter = new TokuchoHeinjunka8GatsuMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.setシステーム日時(processParameter.get調定日時().getRDateTime());
        parameter.set調定日時(processParameter.get調定日時());
        mapper.updateShoriDateKanri(parameter);
    }
}
