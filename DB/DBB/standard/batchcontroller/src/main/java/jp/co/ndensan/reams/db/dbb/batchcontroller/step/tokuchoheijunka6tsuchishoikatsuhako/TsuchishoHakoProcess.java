/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「帳票の発行」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TsuchishoHakoProcess extends SimpleBatchProcessBase {

    private TsuchishoHakoProcessParameter parameter;

    @Override
    protected void process() {

        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();

        TsuchishoHakoEntity param;

        for (OutputChohyoIchiran 出力帳票entity : parameter.get出力帳票entity()) {
            param = new TsuchishoHakoEntity();

            param.set帳票分類ID(出力帳票entity.get帳票分類ID());
            param.set調定年度(parameter.get調定年度());
            param.set賦課年度(parameter.get賦課年度());
            param.set出力対象区分(parameter.get出力対象区分());
            param.set発行日(parameter.get発行日());
            param.set帳票作成日時(parameter.get帳票作成日時());
            param.set出力順ID(出力帳票entity.get出力順ID());
            param.set帳票ID(出力帳票entity.get帳票ID());
            service.printTsuchisho(param);
        }
    }

}
