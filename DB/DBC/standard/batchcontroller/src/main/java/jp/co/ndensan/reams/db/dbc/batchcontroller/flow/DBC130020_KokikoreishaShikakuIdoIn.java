/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020.CreateCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020.InsKokiKoreshaJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020.InsKokuhoShikakuJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020.InsTorikomiKokiKoreshaJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020.UpdTorikomiKokiKoreshaJyohoTemp1Processs;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020.UpdTorikomiKokiKoreshaJyohoTemp2Processs;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc130020.DBC130020_KokikoreishaShikakuIdoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020.TorikomiKokiKoreshaJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020.UpdTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 後期高齢者資格異動情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public class DBC130020_KokikoreishaShikakuIdoIn extends BatchFlowBase<DBC130020_KokikoreishaShikakuIdoInParameter> {

    private IKokikoreishaShikakuIdoInMapper mapper;
    private RString 市町村識別ID;

    private static final String 取込後期高齢者情報に登録 = "kokikoreishaShikakuIdoInOutputProcess";
    private static final String エラーチェックして取込後期高齢者情報に更新一 = "updTorikomiKokiKoreshaJyohoProcess1";
    private static final String エラーチェックして取込後期高齢者情報に更新二 = "updTorikomiKokiKoreshaJyohoProcess2";
    private static final String 後期高齢者情報インポート用に登録 = "InsKokiKoreshaJyohoTempProcess";
    private static final String 後期高齢者情報に登録 = "InsKokiKoreshaJyohoProcess";
    private static final String 処理日付管理マスタ更新 = "InsKokiKoreshaJyohoProcess";
    private static final String 取込確認CSVファイル出力 = "createCsvFileProcess";

    @Override
    protected void initialize() {
        mapper = getMapper(IKokikoreishaShikakuIdoInMapper.class);
        mapper.get宛名識別コードリスト();
        市町村識別ID = RString.EMPTY;
    }

    @Override
    protected void defineFlow() {
        for (RString value : getParameter().getShoriShichoson()) {
            市町村識別ID = value;
            executeStep(取込後期高齢者情報に登録);
        }
        executeStep(エラーチェックして取込後期高齢者情報に更新一);
        executeStep(エラーチェックして取込後期高齢者情報に更新二);
        executeStep(後期高齢者情報インポート用に登録);
        executeStep(処理日付管理マスタ更新);
        executeStep(エラーチェックして取込後期高齢者情報に更新二);
        executeStep(後期高齢者情報に登録);
    }

    /**
     * 取込後期高齢者情報Tempに登録。
     *
     * @return バッチコマンド
     */
    @Step(取込後期高齢者情報に登録)
    protected IBatchFlowCommand torikomiKokiKoreshaJyohoProcess() {
        return loopBatch(InsTorikomiKokiKoreshaJyohoProcess.class)
                .arguments(getInsTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    /**
     * エラーチェックして取込後期高齢者情報Temp1に更新。
     *
     * @return バッチコマンド
     */
    @Step(エラーチェックして取込後期高齢者情報に更新一)
    protected IBatchFlowCommand updTorikomiKokiKoreshaJyohoProcess1() {
        return loopBatch(UpdTorikomiKokiKoreshaJyohoTemp1Processs.class)
                .arguments(getUpdTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    /**
     * エラーチェックして取込後期高齢者情報Tempに更新。
     *
     * @return バッチコマンド
     */
    @Step(エラーチェックして取込後期高齢者情報に更新二)
    protected IBatchFlowCommand updTorikomiKokiKoreshaJyohoProcess2() {
        return loopBatch(UpdTorikomiKokiKoreshaJyohoTemp2Processs.class)
                .arguments(getUpdTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    /**
     * 後期高齢者情報インポート用に登録。
     *
     * @return バッチコマンド
     */
    @Step(後期高齢者情報インポート用に登録)
    protected IBatchFlowCommand insKokiKoreshaJyohoTempProcess() {
        return loopBatch(InsKokiKoreshaJyohoTempProcess.class)
                .arguments(getUpdTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    /**
     * 後期高齢者情報に登録。
     *
     * @return バッチコマンド
     */
    @Step(後期高齢者情報に登録)
    protected IBatchFlowCommand insKokiKoreshaJyohoProcess() {
        return loopBatch(InsKokuhoShikakuJyohoProcess.class)
                .arguments(getUpdTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    /**
     * 処理日付管理マスタ更新。
     *
     * @return バッチコマンド
     */
    @Step(処理日付管理マスタ更新)
    protected IBatchFlowCommand updShoriDateKanriProcess() {
        return simpleBatch(UpdShoriDateKanriProcess.class)
                .arguments(getUpdTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    /**
     * 取込確認CSVファイル出力。
     *
     * @return バッチコマンド
     */
    @Step(取込確認CSVファイル出力)
    protected IBatchFlowCommand createCsvFileProcess() {
        return loopBatch(CreateCsvFileProcess.class).define();
    }

    private TorikomiKokiKoreshaJyohoTempProcessParameter getInsTorikomiKokuhoJyohoTempProcessParameter() {
        return new TorikomiKokiKoreshaJyohoTempProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                市町村識別ID,
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }

    private UpdTorikomiKokuhoJyohoTempProcessParameter getUpdTorikomiKokuhoJyohoTempProcessParameter() {
        return new UpdTorikomiKokuhoJyohoTempProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                getParameter().getShoriShichoson(),
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }
}
