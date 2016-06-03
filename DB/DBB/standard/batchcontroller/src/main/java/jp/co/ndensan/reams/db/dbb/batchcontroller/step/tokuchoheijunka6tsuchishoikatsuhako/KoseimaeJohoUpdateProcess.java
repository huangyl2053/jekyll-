/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「「更正前」計算後情報の全項目の更新」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class KoseimaeJohoUpdateProcess extends SimpleBatchProcessBase {

    FukaJohoShutokuProcessParameter parameter;
    private ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.class);
    }

    @Override
    protected void process() {
        RString 作成処理名 = ShoriName.特徴平準化計算_6月分.get名称();
        mapper.update計算後情報更正前(new TokuchoHeijunka6gatsuMyBatisParameter(
                parameter.is一括発行フラグ(), null, null, null, 作成処理名, null, null, null, null));
    }

}
