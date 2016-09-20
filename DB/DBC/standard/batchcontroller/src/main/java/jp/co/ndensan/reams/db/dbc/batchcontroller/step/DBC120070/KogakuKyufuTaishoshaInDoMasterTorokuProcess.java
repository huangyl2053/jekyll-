/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120070;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishosha.KogakuKyufuTaishoshaInManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 高額介護サービス費給付対象者取込のCSVファイル読取
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInDoMasterTorokuProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoMasterTorokuProcessParameter parameter;

    @Override
    protected void process() {
        KogakuKyufuTaishoshaInManager manager = KogakuKyufuTaishoshaInManager.createInstance();
        manager.doマスタ登録(parameter.get再処理区分(), parameter.get処理年月());
    }

}
