/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190;

import jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshain.SaishinsaKetteiTsuchishoJyohoTorikomiHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 一時テーブルにデータの編集です。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaTempUpdateProcess extends SimpleBatchProcessBase {

    private SaishinsaKetteiTsuchishoJyohoTorikomiHenshu manager;

    @Override
    protected void beforeExecute() {
        manager = SaishinsaKetteiTsuchishoJyohoTorikomiHenshu.createInstance();
    }

    @Override
    protected void process() {
        manager.updateHihokenshaData();
    }

}
