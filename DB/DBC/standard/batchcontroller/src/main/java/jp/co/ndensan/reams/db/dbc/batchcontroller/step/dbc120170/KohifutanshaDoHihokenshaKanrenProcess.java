/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170;

import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuHihokansyaKanrenManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 被保険者関連処理を実行する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaDoHihokenshaKanrenProcess extends SimpleBatchProcessBase {

    @Override
    protected void process() {
        KokuhorenKyoutsuuHihokansyaKanrenManager 被保険者関連処理Manager
                = KokuhorenKyoutsuuHihokansyaKanrenManager.createInstance();
        被保険者関連処理Manager.do被保険者関連処理();
    }

}
