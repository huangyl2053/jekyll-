/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180060.KenkouKaruteRenkeiDataProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180060.DBC180060_KenkoKaruteRenkeiDataSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 健康かるて連携データ作成のバッチ定義クラスです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
public class DBC180060_KenkoKaruteRenkeiDataSakusei extends BatchFlowBase<DBC180060_KenkoKaruteRenkeiDataSakuseiParameter> {

    private static final String 健康かるて連携データ作成 = "KenkoKaruteRenkeiDataSakusei";

    @Override
    protected void defineFlow() {
        executeStep(健康かるて連携データ作成);
    }

    /**
     * 健康かるて連携データを作成します。
     *
     * @return バッチコマンド
     */
    @Step(健康かるて連携データ作成)
    IBatchFlowCommand exeKenkoKaruteRenkeiDataSakusei() {
        return loopBatch(KenkouKaruteRenkeiDataProcess.class).define();
    }
}
