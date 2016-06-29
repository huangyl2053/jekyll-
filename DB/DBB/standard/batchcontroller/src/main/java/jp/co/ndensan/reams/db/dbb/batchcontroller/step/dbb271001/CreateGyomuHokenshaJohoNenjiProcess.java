/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb271001;

import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha.TokuchoTaishoshaDoteiIkatsu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 業務被保険者情報作成（年次）
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CreateGyomuHokenshaJohoNenjiProcess extends SimpleBatchProcessBase {

    private TokuchoTaishoshaDoteiIkatsu manager;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = TokuchoTaishoshaDoteiIkatsu.createInstance();
    }

    @Override
    protected void process() {
        manager.createGyomuHokenshaJohoNenji();
    }

}
