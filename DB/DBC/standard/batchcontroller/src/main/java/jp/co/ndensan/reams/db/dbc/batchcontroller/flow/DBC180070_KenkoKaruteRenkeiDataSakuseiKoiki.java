/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180070.KenkoKaruteRenkeiKoikiTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180070.KenkouKaruteRenkeiDataKoikiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180070.DBC180070_KenkoKaruteRenkeiDataSakuseiKoikiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 健康かるて連携データ作成（広域用）のバッチ定義クラスです。
 *
 * @reamsid_L DBC-5020-011 wangxiaodong
 */
public class DBC180070_KenkoKaruteRenkeiDataSakuseiKoiki extends BatchFlowBase<DBC180070_KenkoKaruteRenkeiDataSakuseiKoikiParameter> {

    private static final String 広域介護被保険者配信用一時テーブル作成 = "KenkoKaruteRenkeiDataKoikiTempTableSakusei";
    private static final String 健康かるて連携データ作成_広域用 = "KenkoKaruteRenkeiDataSakuseiKoiki";

    @Override
    protected void defineFlow() {
        executeStep(広域介護被保険者配信用一時テーブル作成);
        executeStep(健康かるて連携データ作成_広域用);
    }

    /**
     * 健康かるて連携データを作成します。
     *
     * @return バッチコマンド
     */
    @Step(広域介護被保険者配信用一時テーブル作成)
    IBatchFlowCommand exeKenkoKaruteRenkeiDataKoikiTempTable() {
        return loopBatch(KenkoKaruteRenkeiKoikiTempTableSakuseiProcess.class).define();
    }

    /**
     * 健康かるて連携データを作成します。
     *
     * @return バッチコマンド
     */
    @Step(健康かるて連携データ作成_広域用)
    IBatchFlowCommand exeKenkoKaruteRenkeiDataSakusei() {
        return loopBatch(KenkouKaruteRenkeiDataKoikiProcess.class).define();
    }
}
