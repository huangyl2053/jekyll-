/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei.CreateGyomuHokenshaJohoGetsujiProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha.TokuchoTaishoshaDoteiIkatsu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 業務被保険者情報作成（月次）
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CreateGyomuHokenshaJohoGetsujiProcess extends SimpleBatchProcessBase {

    private TokuchoTaishoshaDoteiIkatsu manager;
    private CreateGyomuHokenshaJohoGetsujiProcessParameter parameter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();
    }

    @Override
    protected void process() {
        manager.createGyomuHokenshaJohoGetsuji(parameter.get処理年度(), parameter.get開始月());
    }

}
