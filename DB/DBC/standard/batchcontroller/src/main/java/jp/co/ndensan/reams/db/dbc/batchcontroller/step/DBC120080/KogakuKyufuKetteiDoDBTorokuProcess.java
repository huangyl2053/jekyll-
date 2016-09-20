/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120080;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiDoDBTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyufukettei.KogakuKyufuKetteiJohoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 高額サービス費決定情報取込み・DB登録を実行する。
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public class KogakuKyufuKetteiDoDBTorokuProcess extends SimpleBatchProcessBase {

    private KogakuKyufuKetteiDoDBTorokuProcessParameter parameter;

    @Override
    protected void process() {
        KogakuKyufuKetteiJohoManager manager = KogakuKyufuKetteiJohoManager.createInstance();
        manager.doDB登録(parameter.get処理年月(), parameter.get再処理区分());
    }

}
