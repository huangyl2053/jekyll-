/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 世帯員把握（バッチ）のパラメータです。
 *
 * @reamsid_L DBC-2010-050 tianshuai
 */
public class ConvertGappeinaiJutokushaShinKyuNoProcess extends SimpleBatchProcessBase {

    private SetaiShotokuKazeiHantei manager;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        manager = SetaiShotokuKazeiHantei.createInstance();
        manager.convertGappeinaiJutokushaShinKyuNo();
    }

    @Override
    protected void process() {
    }

    @Override
    protected void afterExecute() {
    }
}
