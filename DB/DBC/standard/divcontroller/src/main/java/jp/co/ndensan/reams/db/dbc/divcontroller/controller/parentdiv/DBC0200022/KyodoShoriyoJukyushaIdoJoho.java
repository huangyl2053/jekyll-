/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200022;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110030.DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200022.KyodoShoriyoJukyushaIdoJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[5C1]共同処理用受給者異動情報のクラスです。
 *
 * @reamsid_L DBC-3300-150 wangxingpeng
 */
public class KyodoShoriyoJukyushaIdoJoho {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 外部ＣＳＶファイル名;
    private RString サイクル区分;
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString 月次 = new RString("月次");
    private static final RString 年次 = new RString("年次");
    private static final RString 状態パターン = new RString("3");

    /**
     * onLoadのメソッドです。
     *
     * @param div KyodoShoriyoJukyushaIdoJohoDiv
     * @return ResponseData KyodoShoriyoJukyushaIdoJohoDiv
     */
    public ResponseData<KyodoShoriyoJukyushaIdoJohoDiv> onLoad(KyodoShoriyoJukyushaIdoJohoDiv div) {
        KokuhorenDataSofuViewState parmater = ViewStateHolder.get(ViewStateHolderName.国保連取込情報,
                KokuhorenDataSofuViewState.class);
        再処理区分 = parmater.get再処理区分();
        処理年月 = parmater.get処理年月();
        RDate 基準日 = RDate.getNowDate();
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        サイクル区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付_共同処理用受給者異動情報_処理サイクル区分, 基準日, SubGyomuCode.DBC介護給付);
        if (NUM_1.equals(サイクル区分)) {
            サイクル区分 = 月次;
        }
        if (NUM_2.equals(サイクル区分)) {
            サイクル区分 = 年次;
        }
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, サイクル区分, 状態パターン);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行するボタンのメソッドです。
     *
     * @param div KyodoShoriyoJukyushaIdoJohoDiv
     * @return ResponseData
     */
    public ResponseData<DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter> onClick_Execute(KyodoShoriyoJukyushaIdoJohoDiv div) {
        DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter parameter = new DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter();
        parameter.set再処理区分(再処理区分);
        parameter.set処理年月(処理年月);
        return ResponseData.of(parameter).respond();
    }
}
