/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.NinteiKekkaCsvgetProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.NinteiKekkaRenkeiDetaTorikomiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.ShimeiWaKuhakuNoShoriProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.ShutsuryokuFairuRisutooSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.TorikomiErarisutofairuCSVProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD492001.DBD492001_NinteiKekkaInfoUploadParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定結果連携データ取込のバッチフロークラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class DBD492001_NinteiKekkaInfoUpload extends BatchFlowBase<DBD492001_NinteiKekkaInfoUploadParameter> {

    private static final String 取込みファイル = "取込みファイル";
    private static final String 変更したいデータを取得 = "変更したいデータを取得";
    private static final String ファイル出力用データの編集 = "ファイル出力用データの編集";
    private static final String 出力ファイルリストを作成 = "出力ファイルリストを作成";
    private static final String エラーリストファイルの出力 = "エラーリストファイルの出力";
    private static final int NUM_0 = 0;
    private int index;

    @Override
    protected void defineFlow() {
        executeStep(取込みファイル);
        for (int i = NUM_0; i < getParameter().get保険者番号リスト().size(); i++) {
            index = i;
            executeStep(変更したいデータを取得);
        }
        executeStep(ファイル出力用データの編集);
        executeStep(エラーリストファイルの出力);
        executeStep(出力ファイルリストを作成);

    }

    /**
     * 取込みファイル
     *
     * @return バッチコマンド
     */
    @Step(取込みファイル)
    protected IBatchFlowCommand ninteiKekkaCsvgetProcess() {
        return loopBatch(NinteiKekkaCsvgetProcess.class)
                .arguments(getParameter().toRendingJieguoLianxieProcessParameter(NUM_0, false))
                .define();
    }

    /**
     * 変更したいデータを取得
     *
     * @return バッチコマンド
     */
    @Step(変更したいデータを取得)
    protected IBatchFlowCommand ninteiKekkaRenkeiDetaTorikomiProcess() {
        return loopBatch(NinteiKekkaRenkeiDetaTorikomiProcess.class)
                .arguments(getParameter().toRendingJieguoLianxieProcessParameter(index, true))
                .define();
    }

    /**
     * ファイル出力用データの編集
     *
     * @return バッチコマンド
     */
    @Step(ファイル出力用データの編集)
    protected IBatchFlowCommand shimeiWaKuhakuNoShoriProcess() {
        return loopBatch(ShimeiWaKuhakuNoShoriProcess.class)
                .arguments(getParameter().toRendingJieguoLianxieProcessParameter(NUM_0, false))
                .define();
    }

    /**
     * エラーリストファイルの出力の編集
     *
     * @return バッチコマンド
     */
    @Step(エラーリストファイルの出力)
    protected IBatchFlowCommand torikomiErarisutofairuCSVProcess() {
        return loopBatch(TorikomiErarisutofairuCSVProcess.class)
                .arguments(getParameter().toRendingJieguoLianxieProcessParameter(NUM_0, false))
                .define();
    }

    /**
     * 出力ファイルリストを作成
     *
     * @return バッチコマンド
     */
    @Step(出力ファイルリストを作成)
    protected IBatchFlowCommand shutsuryokuFairuRisutooSakuseiProcess() {
        return loopBatch(ShutsuryokuFairuRisutooSakuseiProcess.class)
                .define();
    }

}
