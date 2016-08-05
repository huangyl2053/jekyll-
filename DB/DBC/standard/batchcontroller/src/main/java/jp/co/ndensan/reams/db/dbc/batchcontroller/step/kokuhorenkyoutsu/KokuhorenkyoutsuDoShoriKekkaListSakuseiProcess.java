/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuSyoriKekkaListSakuseiManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 処理結果リスト作成する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess extends SimpleBatchProcessBase {

    private KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter;

    @Override
    protected void process() {
        KokuhorenKyoutsuuSyoriKekkaListSakuseiManager 処理結果リスト作成Manager
                = KokuhorenKyoutsuuSyoriKekkaListSakuseiManager.createInstance();
        処理結果リスト作成Manager.create国保連情報データ取込処理結果リスト(parameter.getエラーリストタイプ());
    }

}
