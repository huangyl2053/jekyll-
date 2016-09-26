/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.HokenShaKodochekkuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.NinteiKekkaRenkeiDetaTorikomiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.ShimeiWaKuhakuNoShoriProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.ShinseiKubunItchiChekkuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.ShutsuryokuFairuRisutooSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001.TogaiHihokenjaNoShinseiDetagaProcess;
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

    private static final String 変更したいデータを取得 = "変更したいデータを取得";
    private static final String 保険者コードチェックデータ検索 = "保険者コードチェックデータ検索";
    private static final String 当該被保険者の申請データが存在するかどうかチェック = "当該被保険者の申請データが存在するかどうかチェック";
    private static final String 申請区分一致チェック = "申請区分一致チェック";
    private static final String 被保険者ｶﾅ氏名と被保険者漢字氏名は空白の処理 = "被保険者ｶﾅ氏名と被保険者漢字氏名は空白の処理";
    private static final String 出力ファイルリストを作成 = "出力ファイルリストを作成";

    @Override
    protected void defineFlow() {
        executeStep(変更したいデータを取得);
        executeStep(保険者コードチェックデータ検索);
        executeStep(当該被保険者の申請データが存在するかどうかチェック);
        executeStep(申請区分一致チェック);
        executeStep(被保険者ｶﾅ氏名と被保険者漢字氏名は空白の処理);
        executeStep(出力ファイルリストを作成);
    }

    /**
     * 変更したいデータを取得
     *
     * @return バッチコマンド
     */
    @Step(変更したいデータを取得)
    protected IBatchFlowCommand NinteiKekkaRenkeiDetaTorikomiProcess() {
        return loopBatch(NinteiKekkaRenkeiDetaTorikomiProcess.class)
                .arguments(getParameter().toRendingJieguoLianxieProcessParameter())
                .define();
    }

    /**
     * 保険者コードチェックデータ検索
     *
     * @return バッチコマンド
     */
    @Step(保険者コードチェックデータ検索)
    protected IBatchFlowCommand HokenShaKodochekkuProcess() {
        return loopBatch(HokenShaKodochekkuProcess.class)
                .define();
    }

    /**
     * 当該被保険者の申請データが存在するかどうかチェック
     *
     * @return バッチコマンド
     */
    @Step(当該被保険者の申請データが存在するかどうかチェック)
    protected IBatchFlowCommand TogaiHihokenjaNoShinseiDetagaProcess() {
        return loopBatch(TogaiHihokenjaNoShinseiDetagaProcess.class)
                .define();
    }

    /**
     * 申請区分一致チェック
     *
     * @return バッチコマンド
     */
    @Step(申請区分一致チェック)
    protected IBatchFlowCommand ShinseiKubunItchiChekkuProcess() {
        return loopBatch(ShinseiKubunItchiChekkuProcess.class)
                .define();
    }

    /**
     * 被保険者ｶﾅ氏名と被保険者漢字氏名は空白の処理
     *
     * @return バッチコマンド
     */
    @Step(被保険者ｶﾅ氏名と被保険者漢字氏名は空白の処理)
    protected IBatchFlowCommand ShimeiWaKuhakuNoShoriProcess() {
        return loopBatch(ShimeiWaKuhakuNoShoriProcess.class)
                .define();
    }

    /**
     * 出力ファイルリストを作成
     *
     * @return バッチコマンド
     */
    @Step(出力ファイルリストを作成)
    protected IBatchFlowCommand ShutsuryokuFairuRisutooSakuseiProcess() {
        return loopBatch(ShutsuryokuFairuRisutooSakuseiProcess.class)
                .arguments(getParameter().toRendingJieguoLianxieProcessParameter())
                .define();
    }

}
