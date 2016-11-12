/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001.TokuchoHeinjunka6GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「処理日付管理テーブル更新」処理クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class UpdShoriDateKanriProcess extends SimpleBatchProcessBase {

    private TokuchoHeinjunka6GatsuProcessParameter processParameter;
    private ITokuchoHeinjunka6GatsuBatchMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuchoHeinjunka6GatsuBatchMapper.class);
    }

    @Override
    protected void process() {
        TokuchoHeinjunka6GatsuMyBatisParameter parameter = new TokuchoHeinjunka6GatsuMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.setシステーム日時(processParameter.get調定日時().getRDateTime());
        parameter.set調定日時(processParameter.get調定日時());
        mapper.updateShoriDateKanri(parameter);
    }
}
