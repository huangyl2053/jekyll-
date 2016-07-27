/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshainmasterinsert.KagoKetteiHokenshaInMasterInsert;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * マスタ登録を実行する。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaDoMasterTorokuProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoMasterTorokuProcessParameter parameter;

    @Override
    protected void process() {
        KagoKetteiHokenshaInMasterInsert マスタ登録Manager = KagoKetteiHokenshaInMasterInsert.createInstance();
        マスタ登録Manager.再処理準備と登録(parameter.get処理年月(), parameter.get再処理区分().getコード(),
                parameter.get交換情報識別番号());
    }

}
