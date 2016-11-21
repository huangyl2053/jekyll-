/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.AtenaJohoForShikyugakuUpdateTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.ChohyoToCsvOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.DataDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.GogakuGassanShikyugakuCalcResultProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.JigyoGassanKeisanKekkaUpdateShikyugakuUpdateTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.JigyoKogakuGassanJikoFutanGakuMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.JigyoKogakuGassanJikoFutanGakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.JigyoKogakuGassanJikoFutanGakuShomeishoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.JigyoShikyuFushikyuKetteiUpdateShikyugakuUpdateTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.KogakuGassanShikyugakuKeisanKekkaMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.KogakuShikyuFushikyuKetteiUpdateShikyugakuUpdateTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.KozaJohoForShikyugakuUpdateTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.ShikyugakuCalcProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.ShoriDateKanriMasterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.ShoriKekkaKakuninRisutoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.ShoriKekkaKakuninRisutoPrtProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.UpdateMasterTableProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070.UpdateShikyugakuUpdateTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020070.DBC020070_JigyobunShikyugakuKeisanParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業分支給額計算バッチフロークラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class DBC020070_JigyobunShikyugakuKeisan extends BatchFlowBase<DBC020070_JigyobunShikyugakuKeisanParameter> {

    private static final String 高額合算支給額計算結果 = "高額合算支給額計算結果";
    private static final String 事業高額合算自己負担額証明書 = "事業高額合算自己負担額証明書";
    private static final String 事業高額合算自己負担額 = "事業高額合算自己負担額";
    private static final String データを削除する = "データを削除する";
    private static final String 高額合算支給額計算結果明細 = "高額合算支給額計算結果明細";
    private static final String 事業高額合算自己負担額明細 = "事業高額合算自己負担額明細";
    private static final String 事業高額合算自己負担額証明書明細 = "事業高額合算自己負担額証明書明細";
    private static final String 更新用一時の作成 = "更新用一時の作成";
    private static final String 計算結果データ最新の履歴番号 = "計算結果データ最新の履歴番号";
    private static final String 更新用データの支払情報を更新する = "更新用データの支払情報を更新する";
    private static final String 高額合算データ最新の履歴 = "高額合算支給不支給決定データ最新の履歴";
    private static final String 事業高額合算支給不支給決定データ最新の履歴 = "事業高額合算支給不支給決定データ最新の履歴";
    private static final String 更新用データに宛名情報 = "更新用データに宛名情報";
    private static final String 更新用データに口座情報 = "更新用データに口座情報";
    private static final String 事業分支給額計算結果の帳票_CSVを出力する = "事業分支給額計算結果の帳票_CSVを出力する";
    private static final String 処理結果確認リストを出力する = "処理結果確認リストを出力する";
    private static final String 更新用一時の情報をマスタにINSERTする = "更新用一時の情報をマスタにINSERTする";
    private static final String 処理結果を_処理日付管理マスタに設定する = "処理結果を_処理日付管理マスタに設定する";
    private static final String 処理結果リスト作成 = "処理結果リスト作成";
    private static final String 出力対象区分 = "1";

    @Override
    protected void defineFlow() {
        executeStep(高額合算支給額計算結果);
        boolean hasData = getResult(
                Boolean.class, new RString(高額合算支給額計算結果), GogakuGassanShikyugakuCalcResultProcess.PARAMETER_OUT_FLOWFLAG);
        if (!hasData) {
            return;
        }
        executeStep(事業高額合算自己負担額証明書);
        executeStep(事業高額合算自己負担額);
        executeStep(データを削除する);
        executeStep(高額合算支給額計算結果明細);
        executeStep(事業高額合算自己負担額明細);
        executeStep(事業高額合算自己負担額証明書明細);

        executeStep(更新用一時の作成);

        executeStep(計算結果データ最新の履歴番号);
        executeStep(更新用データの支払情報を更新する);
        executeStep(事業高額合算支給不支給決定データ最新の履歴);
        executeStep(高額合算データ最新の履歴);
        executeStep(更新用データに宛名情報);
        executeStep(更新用データに口座情報);
        executeStep(事業分支給額計算結果の帳票_CSVを出力する);
        executeStep(処理結果確認リストを出力する);
        executeStep(処理結果リスト作成);
        executeStep(更新用一時の情報をマスタにINSERTする);
        if (出力対象区分.equals(getParameter().get出力対象区分().toString())) {
            executeStep(処理結果を_処理日付管理マスタに設定する);
        }
    }

    @Step(高額合算支給額計算結果)
    IBatchFlowCommand execute高額合算支給額計算結果() {
        return loopBatch(GogakuGassanShikyugakuCalcResultProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(事業高額合算自己負担額証明書)
    IBatchFlowCommand execute事業高額合算自己負担額証明書() {
        return loopBatch(JigyoKogakuGassanJikoFutanGakuShomeishoProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(事業高額合算自己負担額)
    IBatchFlowCommand execute事業高額合算自己負担額() {
        return loopBatch(JigyoKogakuGassanJikoFutanGakuProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(データを削除する)
    IBatchFlowCommand executeデータを削除する() {
        return loopBatch(DataDeleteProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(高額合算支給額計算結果明細)
    IBatchFlowCommand execute高額合算支給額計算結果明細() {
        return loopBatch(KogakuGassanShikyugakuKeisanKekkaMeisaiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(事業高額合算自己負担額明細)
    IBatchFlowCommand execute事業高額合算自己負担額明細() {
        return loopBatch(JigyoKogakuGassanJikoFutanGakuMeisaiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(事業高額合算自己負担額証明書明細)
    IBatchFlowCommand execute事業高額合算自己負担額証明書明細() {
        return loopBatch(JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(更新用一時の作成)
    IBatchFlowCommand execute更新用一時の作成() {
        return loopBatch(ShikyugakuCalcProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(計算結果データ最新の履歴番号)
    IBatchFlowCommand execute計算結果データ最新の履歴番号() {
        return loopBatch(JigyoGassanKeisanKekkaUpdateShikyugakuUpdateTempProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(更新用データの支払情報を更新する)
    IBatchFlowCommand execute更新用データの支払情報を更新する() {
        return loopBatch(UpdateShikyugakuUpdateTempProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(高額合算データ最新の履歴)
    IBatchFlowCommand execute高額合算データ最新の履歴() {
        return loopBatch(KogakuShikyuFushikyuKetteiUpdateShikyugakuUpdateTempProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(事業高額合算支給不支給決定データ最新の履歴)
    IBatchFlowCommand execute事業高額合算支給不支給決定データ最新の履歴() {
        return loopBatch(JigyoShikyuFushikyuKetteiUpdateShikyugakuUpdateTempProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(更新用データに宛名情報)
    IBatchFlowCommand execute更新用データに宛名情報() {
        return loopBatch(AtenaJohoForShikyugakuUpdateTempProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(更新用データに口座情報)
    IBatchFlowCommand execute更新用データに口座情報() {
        return loopBatch(KozaJohoForShikyugakuUpdateTempProcess.class).define();
    }

    @Step(事業分支給額計算結果の帳票_CSVを出力する)
    IBatchFlowCommand execute事業分支給額計算結果の帳票_CSVを出力する() {
        return loopBatch(ChohyoToCsvOutputProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(処理結果確認リストを出力する)
    IBatchFlowCommand execute処理結果確認リストを出力する() {
        return loopBatch(ShoriKekkaKakuninRisutoProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(処理結果リスト作成)
    IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        return loopBatch(ShoriKekkaKakuninRisutoPrtProcess.class).define();
    }

    @Step(更新用一時の情報をマスタにINSERTする)
    IBatchFlowCommand execute更新用一時の情報をマスタにINSERTする() {
        return loopBatch(UpdateMasterTableProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(処理結果を_処理日付管理マスタに設定する)
    IBatchFlowCommand execute処理日付管理マスタに設定する() {
        return loopBatch(ShoriDateKanriMasterProcess.class).arguments(getParameter().toProcessParameter()).define();
    }
}
