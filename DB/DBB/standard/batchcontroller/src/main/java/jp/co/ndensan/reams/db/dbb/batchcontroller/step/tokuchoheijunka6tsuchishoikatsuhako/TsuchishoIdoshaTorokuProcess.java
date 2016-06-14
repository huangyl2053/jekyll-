package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoIdoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「通知書発行後異動者の登録」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TsuchishoIdoshaTorokuProcess extends SimpleBatchProcessBase {

    private TsuchishoIdoshaTorokuProcessParameter parameter;

    @Override
    protected void process() {

        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();

        TsuchishoHakoProcessParameter param;

        for (OutputChohyoIchiran 出力帳票entity : parameter.get出力帳票entity()) {
            param = new TsuchishoHakoProcessParameter();

            param.set帳票作成日時(parameter.get帳票作成日時());
            param.set出力順ID(出力帳票entity.get出力順ID());
            param.set出力対象区分(Integer.valueOf(parameter.get出力対象区分().toString()));
            param.set帳票ID(出力帳票entity.get帳票ID());
            param.set基準日時(parameter.get基準日時());
            service.insTsuchishoHakkogoIdosha(param);
        }
    }

}
