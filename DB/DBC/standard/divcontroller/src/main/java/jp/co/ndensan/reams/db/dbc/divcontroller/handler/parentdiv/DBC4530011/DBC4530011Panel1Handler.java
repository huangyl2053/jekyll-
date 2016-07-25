/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4530011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4530011.DBC4530011Panel1Div;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 高額合算自己負担額補正・支払場所のHandlerクラスです。
 *
 * @reamsid_L DBC-3360-010 xuxin
 */
public class DBC4530011Panel1Handler {

    private static final RString 更新 = new RString("を使用して更新");

    private final DBC4530011Panel1Div div;

    /**
     * コンストラクタです。
     *
     * @param div DBC4530011Panel1Div
     */
    public DBC4530011Panel1Handler(DBC4530011Panel1Div div) {
        this.div = div;
    }

    /**
     * 画面ロード時の動作です。
     */
    public void initialize() {
        div.getTxtShiharaiBasho().setValue(getConfig値(ConfigNameDBC.高額合算自己負担額補正_支払場所));
    }

    private RString getConfig値(Enum key) {
        return DbBusinessConfig.get(key, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
    }

    /**
     * 業務コンフィグの保存処理です。
     */
    public void config保存() {

        RString config値 = div.getTxtShiharaiBasho().getValue();
        RString 変更理由 = ResponseHolder.getMenuID().concat(更新);
        RDate 運用日 = RDate.getNowDate();
        BusinessConfig.update(SubGyomuCode.DBC介護給付, ConfigNameDBC.高額合算自己負担額補正_支払場所,
                config値, 変更理由, RString.EMPTY, 運用日);
    }

}
