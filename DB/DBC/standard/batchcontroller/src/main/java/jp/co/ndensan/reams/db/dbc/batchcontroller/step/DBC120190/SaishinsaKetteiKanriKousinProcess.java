/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120190;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteihokenshain.SaishinsaKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuInterfaceKanriKousinManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 国保連インタフェース管理更新を実行する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiKanriKousinProcess extends SimpleBatchProcessBase {

    private SaishinsaKetteiProcessParameter parameter;

    @Override
    protected void process() {
        KokuhorenKyoutsuuInterfaceKanriKousinManager 国保連インタフェース管理更新Manager
                = KokuhorenKyoutsuuInterfaceKanriKousinManager.createInstance();
        国保連インタフェース管理更新Manager.updateInterfaceKanriTbl(parameter.get処理年月(), parameter.get交換情報識別番号(),
                parameter.get処理対象年月(), parameter.getレコード件数合計(), parameter.getFileNameList());
    }
}
