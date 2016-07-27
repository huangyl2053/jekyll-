/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuSyoriKekkaListSakuseiManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 処理結果リスト作成する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaDoShoriKekkaListSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoShoriKekkaListSakuseiProcessParameter parameter;

    @Override
    protected void process() {
        KokuhorenKyoutsuuSyoriKekkaListSakuseiManager 処理結果リスト作成Manager
                = KokuhorenKyoutsuuSyoriKekkaListSakuseiManager.createInstance();
        処理結果リスト作成Manager.create国保連情報データ取込処理結果リスト(parameter.getエラーリストタイプ());
    }

}
