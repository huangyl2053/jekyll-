package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.taisyosyajidowaritsuke;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 対象者自動割付のバッチフロークラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
public class TaisyosyaJidoWaritsukeFlow extends BatchFlowBase<TaisyosyaJidoWaritsukeBatchParameter> {

    private static final String 対象者自動割付 = "TaisyosyaJidoWaritsuke";

    @Override
    protected void defineFlow() {
        executeStep(対象者自動割付);
    }

    /**
     * 対象者自動割付の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(対象者自動割付)
    protected IBatchFlowCommand selectTaisyosyaByShinsakaiKaisaiNo() {
        return simpleBatch(TaisyosyaJidoWaritsukeProcess.class)
                .arguments(getParameter().toTaisyosyaJidoWaritsukeProcessParameter()).define();
    }
}
