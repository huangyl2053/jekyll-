/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120190;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteihokenshain.SaishinsaKetteiDBTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshainmasuta.SaishinsaKetteiManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * マスタ登録を実行する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiDBTorokuProcess extends SimpleBatchProcessBase {

    private SaishinsaKetteiDBTorokuProcessParameter parameter;

    @Override
    protected void process() {
        SaishinsaKetteiManager マスタ登録Manager = SaishinsaKetteiManager.createInstance();
        マスタ登録Manager.saishinsaKetteiHokenshaInMasutaToroku(parameter.get処理年月(),
                parameter.get再処理区分().getコード(),
                null,
                parameter.get交換情報識別番号());
    }

}
