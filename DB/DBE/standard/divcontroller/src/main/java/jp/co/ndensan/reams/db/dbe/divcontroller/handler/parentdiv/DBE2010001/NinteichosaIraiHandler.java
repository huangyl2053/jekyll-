/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・認定調査依頼のHandlerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiHandler {

    private final NinteichosaIraiDiv div;
    private static final RString 調査依頼モード = new RString("調査依頼モード");
    private static final RString 使用する = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査依頼Div
     */
    public NinteichosaIraiHandler(NinteichosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・認定調査依頼に初期化を設定します。
     */
    public void onLoad() {
        div.getCcdTaskList().initialize(調査依頼モード);
        RString 認定調査自動割付 = DbBusinessConfig.get(ConfigNameDBE.認定調査自動割付, RDate.getNowDate());
        if (使用する.equals(認定調査自動割付)) {
            div.getBtniraiauto().setDisabled(false);
        } else {
            div.getBtniraiauto().setDisabled(true);
        }
        RString モバイル調査使用有無 = DbBusinessConfig.get(ConfigNameDBE.モバイル調査使用有無, RDate.getNowDate());
        if (使用する.equals(モバイル調査使用有無)) {
            div.getBtnchosadataoutput().setDisabled(false);
        } else {
            div.getBtnchosadataoutput().setDisabled(true);
        }

    }

}
