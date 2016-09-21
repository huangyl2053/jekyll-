/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110080.DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200013.KogakuGassanHoseizumiJikofutangakuJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200013.KogakuGassanHoseizumiJikofutangakuJohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 保険者情報送付データ作成_[37K]高額合算補正済自己負担額情報のクラスです。
 *
 * @reamsid_L DBC-3300-050 wangxingpeng
 */
public class KogakuGassanHoseizumiJikofutangakuJoho {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 交換情報識別番号;

    /**
     * onLoadのメソッドです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     * @return ResponseData KogakuGassanHoseizumiJikofutangakuJohoDiv
     */
    public ResponseData<KogakuGassanHoseizumiJikofutangakuJohoDiv> onLoad(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        交換情報識別番号 = parmater.get交換情報識別番号();
        getHandler(div).onload(再処理区分, 処理年月, 交換情報識別番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     * @return ResponseData
     */
    public ResponseData<DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter> onClick_Execute(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連送付情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        if (getHandler(div).setBatchParameter(再処理区分, 処理年月) != null) {
            return ResponseData.of(getHandler(div).setBatchParameter(再処理区分, 処理年月)).respond();
        }
        return ResponseData.of(new DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter()).respond();
    }

    private KogakuGassanHoseizumiJikofutangakuJohoHandler getHandler(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        return KogakuGassanHoseizumiJikofutangakuJohoHandler.of(div);
    }
}
