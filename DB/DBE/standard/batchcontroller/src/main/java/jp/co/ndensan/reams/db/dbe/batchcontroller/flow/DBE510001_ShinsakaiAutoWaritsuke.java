package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE510001.TaisyosyaJidoWaritsukeProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE510001.DBE510001_ShinsakaiAutoWaritsukeParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 対象者自動割付のバッチフロークラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
public class DBE510001_ShinsakaiAutoWaritsuke extends BatchFlowBase<DBE510001_ShinsakaiAutoWaritsukeParameter> {

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
