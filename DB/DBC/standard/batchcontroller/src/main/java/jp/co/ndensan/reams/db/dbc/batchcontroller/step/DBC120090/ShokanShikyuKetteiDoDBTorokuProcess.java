/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiDoDBTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteiin.ShokanShikyuKetteiInManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共通バッチ処理クラス．償還払支給不支給決定情報取込共通処理（DB登録）を実行する。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class ShokanShikyuKetteiDoDBTorokuProcess extends SimpleBatchProcessBase {

    private static final RString 支給不支給区分_支給 = new RString("1");

    private KogakuKyufuKetteiDoDBTorokuProcessParameter parameter;

    @Override
    protected void process() {
        ShokanShikyuKetteiInManager manager = ShokanShikyuKetteiInManager.createInstance();
        manager.checkDataAndDbRegister(parameter.get処理年月(), parameter.get再処理区分().getコード(), 支給不支給区分_支給);
    }

}
