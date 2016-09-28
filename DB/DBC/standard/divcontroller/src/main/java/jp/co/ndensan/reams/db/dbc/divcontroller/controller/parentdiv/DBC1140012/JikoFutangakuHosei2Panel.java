/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1140012;

import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.DBC1140012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140012.JikoFutangakuHosei2PanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012.JikoFutangakuHosei2Handler1;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012.JikoFutangakuHosei2Handler2;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012.JikoFutangakuHosei2Handler3;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140012.JikoFutangakuHosei2Handler4;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 高額合算自己負担額情報補正(単)_補正入力のクラスです。
 *
 * @reamsid_L DBC-2080-030 jianglaisheng
 */
public class JikoFutangakuHosei2Panel {

    private static final RString 文字列_0 = new RString("0");
    private static final RString 文字列_1 = new RString("1");
    private static final FlexibleYear 平成20年度 = new FlexibleYear("2008");
    private static final RString 月_003 = new RString("03");
    private static final RString 月_007 = new RString("07");
    private static final RString 日_31 = new RString("31");
    private static final int 歳_75 = 75;
    private static final int INT_35 = 35;
    private static final int INT_36 = 36;

    /**
     * 画面の初期化のメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onLoad(JikoFutangakuHosei2PanelDiv div) {

        KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.高額合算自己負担額補正保持Entity, KogakuGassanJikofutangakuHosei.class);

        if (高額合算自己負担額補正保持Entity == null) {
            高額合算自己負担額補正保持Entity = new KogakuGassanJikofutangakuHosei();
        }
        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();

        if (文字列_0.equals(高額合算自己負担額補正保持Entity.get呼び出しフラグ())) {
            if (平成20年度.equals(対象年度)) {
                getJikoFutangakuHosei2Handler2(div).initilize_初回(高額合算自己負担額補正保持Entity);
                getJikoFutangakuHosei2Handler4(div).変更前補正後金額の設定(高額合算自己負担額補正保持Entity);
                ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 高額合算自己負担額補正保持Entity);
            } else {
                getJikoFutangakuHosei2Handler1(div).initilize_初回(高額合算自己負担額補正保持Entity);
                getJikoFutangakuHosei2Handler3(div).変更前補正後金額の設定(高額合算自己負担額補正保持Entity);
                ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 高額合算自己負担額補正保持Entity);
            }
        } else if (文字列_1.equals(高額合算自己負担額補正保持Entity.get呼び出しフラグ())) {
            if (平成20年度.equals(対象年度)) {
                getJikoFutangakuHosei2Handler4(div).initialize_２回目以降(高額合算自己負担額補正保持Entity);
            } else {
                getJikoFutangakuHosei2Handler3(div).initialize_２回目以降(高額合算自己負担額補正保持Entity);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面初期化のonActiveメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onActive(JikoFutangakuHosei2PanelDiv div) {

        KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.高額合算自己負担額補正保持Entity, KogakuGassanJikofutangakuHosei.class);

        if (高額合算自己負担額補正保持Entity == null) {
            高額合算自己負担額補正保持Entity = new KogakuGassanJikofutangakuHosei();
        }
        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();

        if (文字列_0.equals(高額合算自己負担額補正保持Entity.get呼び出しフラグ())) {
            if (平成20年度.equals(対象年度)) {
                getJikoFutangakuHosei2Handler2(div).initilize_初回(高額合算自己負担額補正保持Entity);
                getJikoFutangakuHosei2Handler4(div).変更前補正後金額の設定(高額合算自己負担額補正保持Entity);
                ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 高額合算自己負担額補正保持Entity);
            } else {
                getJikoFutangakuHosei2Handler1(div).initilize_初回(高額合算自己負担額補正保持Entity);
                getJikoFutangakuHosei2Handler3(div).変更前補正後金額の設定(高額合算自己負担額補正保持Entity);
                ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 高額合算自己負担額補正保持Entity);
            }
        } else if (文字列_1.equals(高額合算自己負担額補正保持Entity.get呼び出しフラグ())) {
            if (平成20年度.equals(対象年度)) {
                getJikoFutangakuHosei2Handler4(div).initialize_２回目以降(高額合算自己負担額補正保持Entity);
            } else {
                getJikoFutangakuHosei2Handler3(div).initialize_２回目以降(高額合算自己負担額補正保持Entity);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 補正前の金額をコピーするのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onClick_btnHoseiMaeKingakuCopy(JikoFutangakuHosei2PanelDiv div) {
        KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.高額合算自己負担額補正保持Entity, KogakuGassanJikofutangakuHosei.class);

        if (高額合算自己負担額補正保持Entity == null) {
            高額合算自己負担額補正保持Entity = new KogakuGassanJikofutangakuHosei();
        }

        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();
        if (!平成20年度.equals(対象年度)
                && 補正後20年以外のデータ入力check(div) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcWarningMessages.高額合算補正前コピー.getMessage()).respond();
        } else if (平成20年度.equals(対象年度)
                && 補正後20年度のデータ入力check4_9(div) && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcWarningMessages.高額合算補正前コピー.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            if (!平成20年度.equals(対象年度)) {
                getJikoFutangakuHosei2Handler3(div).補正後の金額コピー();
            } else if (平成20年度.equals(対象年度)) {
                getJikoFutangakuHosei2Handler4(div).補正後の金額コピー();
            }
        }
        return ResponseData.of(div).respond();
    }

    private boolean 補正後20年度のデータ入力check4_9(JikoFutangakuHosei2PanelDiv div) {
        if (div.getTbl20Nendo().getCel20NendoJikofutangaku4GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku4GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi4GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku5GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku5GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi5GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku6GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku6GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi6GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku7GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku7GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi7GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku8GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku8GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi8GatsuGo().getValue() != null) {
            return true;
        }
        return 補正後20年度のデータ入力check9_翌年2(div) || 補正後_20年度のデータ入力check翌年3_翌年7(div);
    }

    private boolean 補正後20年度のデータ入力check9_翌年2(JikoFutangakuHosei2PanelDiv div) {
        return div.getTbl20Nendo().getTxt20NendoJikofutangaku9GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku9GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi9GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku10GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku10GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi10GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku11GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku11GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi11GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangaku12GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74Futangaku12GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehi12GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku1GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku1GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku1GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku2GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku2GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku2GatsuGo().getValue() != null;
    }

    private boolean 補正後_20年度のデータ入力check翌年3_翌年7(JikoFutangakuHosei2PanelDiv div) {
        return div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku3GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku3GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku3GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku4GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku4GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku4GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku5GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku5GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku5GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku6GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku6GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku6GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoJikofutangakuYoku7GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20Nendo70Kara74FutangakuYoku7GatsuGo().getValue() != null
                || div.getTbl20Nendo().getTxt20NendoKougakuKaigoServicehiYoku7GatsuGo().getValue() != null;
    }

    private boolean 補正後20年以外のデータ入力check(JikoFutangakuHosei2PanelDiv div) {
        if (div.getTbl20Igai().getTxt20IgaiJikofutangaku8GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74Futangaku8GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi8GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangaku9GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74Futangaku9GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi9GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangaku10GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74Futangaku10GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi10GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangaku11GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74Futangaku11GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi11GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangaku12GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74Futangaku12GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehi12GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku1GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku1GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku1GatsuGo().getValue() != null) {
            return true;
        }
        return 翌年補正後_20年以外のデータ入力check(div);
    }

    private boolean 翌年補正後_20年以外のデータ入力check(JikoFutangakuHosei2PanelDiv div) {
        return div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku2GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku2GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku2GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku3GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku3GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku3GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku4GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku4GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku4GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku5GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku5GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku5GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku6GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku6GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku6GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiJikofutangakuYoku7GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20Igai70Kara74FutangakuYoku7GatsuGo().getValue() != null
                || div.getTbl20Igai().getTxt20IgaiKougakuKaigoServicehiYoku7GatsuGo().getValue() != null;
    }

    /**
     * [20年度4月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_cel20NendoJikofutangaku4GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_cel20NendoJikofutangaku4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度4月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi4GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度5月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku5GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度5月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi5GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度6月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku6GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度6月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi6GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度7月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku7GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度7月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi7GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度8月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku8GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku8GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度8月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi8GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi8GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度9月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku9GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku9GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度9月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi9GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi9GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度10月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku10GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku10GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度10月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi10GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi10GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度11月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku11GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku11GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度11月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi11GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi11GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度12月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangaku12GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangaku12GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度12月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehi12GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehi12GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年1月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku1GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku1GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年1月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku1GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku1GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年2月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku2GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku2GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年2月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku2GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku2GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年3月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku3GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku3GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年3月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku3GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku3GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年4月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku4GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年4月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku4GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年5月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku5GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年5月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku5GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年6月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku6GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年6月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku6GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年7月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20NendoJikofutangakuYoku7GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_txt20NendoJikofutangakuYoku7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度翌年7月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20NendoKougakuKaigoServicehiYoku7GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).onChange_Txt20NendoKougakuKaigoServicehiYoku7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外8月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangaku8GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangaku8GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外8月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehi8GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehi8GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外9月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangaku9GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangaku9GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外9月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehi9GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehi9GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外10月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangaku10GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangaku10GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外10月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehi10GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehi10GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外11月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangaku11GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangaku11GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外11月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehi11GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehi11GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外12月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangaku12GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangaku12GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外12月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehi12GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehi12GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年1月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku1GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku1GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年1月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku1GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku1GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年2月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku2GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku2GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年2月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku2GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku2GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年3月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku3GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku3GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年3月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku3GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku3GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年4月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku4GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年4月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku4GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年5月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku5GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年5月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku5GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年6月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku6GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年6月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku6GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年7月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20IgaiJikofutangakuYoku7GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_txt20IgaiJikofutangakuYoku7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外翌年7月分　補正後　高額介護(予防)サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_Txt20IgaiKougakuKaigoServicehiYoku7GatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).onChange_Txt20IgaiKougakuKaigoServicehiYoku7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度 補正後　うち70～74歳に係る負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20Nendo70Kara74FutangakuGatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler2(div).補正後_うち70_74歳に係る負担額の合計();
        return ResponseData.of(div).respond();
    }

    /**
     * [20年度以外 補正後　うち70～74歳に係る負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onChange_txt20Igai70Kara74FutangakuGatsuGo(JikoFutangakuHosei2PanelDiv div) {
        getJikoFutangakuHosei2Handler1(div).補正後_うち70_74歳に係る負担額の合計();
        return ResponseData.of(div).respond();
    }

    /**
     * 「自己負担管理情報に戻る」ボタンclickのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onClick_btnJikofutanKanrijohoModoru(JikoFutangakuHosei2PanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (MessageDialogSelectedResult.No.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBC1140012TransitionEventName.戻る).respond();
    }

    /**
     * 「自己負担額情報を確定する」ボタンclickのメソッドです。
     *
     * @param div JikoFutangakuHosei2PanelPanelDiv
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2PanelDiv> onClick_btnJikofutangakuKakutei(JikoFutangakuHosei2PanelDiv div) {
        KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.高額合算自己負担額補正保持Entity, KogakuGassanJikofutangakuHosei.class);

        if (高額合算自己負担額補正保持Entity == null) {
            高額合算自己負担額補正保持Entity = new KogakuGassanJikofutangakuHosei();
        }

        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();
        if (平成20年度.equals(対象年度)) {
            check_20年度(div, 高額合算自己負担額補正保持Entity);
            getJikoFutangakuHosei2Handler4(div).高額合算自己負担額保持Entity設定(高額合算自己負担額補正保持Entity);
            ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 高額合算自己負担額補正保持Entity);
        }
        if (!平成20年度.equals(対象年度)) {
            check_20年度以外(div, 高額合算自己負担額補正保持Entity);
            getJikoFutangakuHosei2Handler3(div).高額合算自己負担額保持Entity設定(高額合算自己負担額補正保持Entity);
            ViewStateHolder.put(ViewStateKeys.高額合算自己負担額補正保持Entity, 高額合算自己負担額補正保持Entity);
        }
        return ResponseData.of(div).forwardWithEventName(DBC1140012TransitionEventName.戻る).respond();
    }

    private void check_20年度(JikoFutangakuHosei2PanelDiv div, KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        FlexibleDate 生年月日 = 高額合算自己負担額補正保持Entity.get生年月日();
        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();
        FlexibleDate 対象年_3月_31日 = new FlexibleDate(対象年度.toString().concat(月_003.toString()).concat(日_31.toString()));

        JikoFutangakuHosei2Handler4 handler24 = getJikoFutangakuHosei2Handler4(div);
        if (handler24.is補正後チェック１(div)) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連３.getMessage());
        }
        if (handler24.is補正後チェック２(div)) {
            throw new ApplicationException(DbcErrorMessages.高額合算自己負担額関連１.getMessage());
        }
        if (handler24.is補正後チェック３(div)) {
            throw new ApplicationException(DbcErrorMessages.高額合算自己負担額関連２.getMessage());
        }
        if (生年月日.plusYear(歳_75).isBeforeOrEquals(対象年_3月_31日)
                && handler24.is補正後チェック4_補正後(div)) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連１.getMessage());
        }
        int message_code = handler24.is補正後チェック4_6(div, 生年月日, 対象年度);
        if (INT_35 == message_code) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連４.getMessage());
        }
        if (INT_36 == message_code) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連２.getMessage());
        }
        if (handler24.is高額介護_予防_サービス費チェック(div)) {
            throw new ApplicationException(DbcErrorMessages.高額合算自己負担額関連3.getMessage());
        }
    }

    private void check_20年度以外(JikoFutangakuHosei2PanelDiv div, KogakuGassanJikofutangakuHosei 高額合算自己負担額補正保持Entity) {
        FlexibleDate 生年月日 = 高額合算自己負担額補正保持Entity.get生年月日();
        FlexibleYear 対象年度 = 高額合算自己負担額補正保持Entity.get対象年度();
        FlexibleDate 対象年_7月_31日 = new FlexibleDate(対象年度.toString().concat(月_007.toString()).concat(日_31.toString()));

        JikoFutangakuHosei2Handler3 handler23 = getJikoFutangakuHosei2Handler3(div);
        if (handler23.is補正後チェック１(div)) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連３.getMessage());
        }
        if (handler23.is補正後チェック２(div)) {
            throw new ApplicationException(DbcErrorMessages.高額合算自己負担額関連１.getMessage());
        }
        if (handler23.is補正後チェック３(div)) {
            throw new ApplicationException(DbcErrorMessages.高額合算自己負担額関連２.getMessage());
        }
        if (生年月日.plusYear(歳_75).isBeforeOrEquals(対象年_7月_31日)
                && handler23.is補正後チェック4_補正後(div)) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連１.getMessage());
        }
        int message_code = handler23.is補正後チェック8_10(div, 生年月日, 対象年度);
        if (INT_35 == message_code) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連４.getMessage());
        }
        if (INT_36 == message_code) {
            throw new ApplicationException(DbcErrorMessages.うち70_74歳に係る負担額関連２.getMessage());
        }
        if (handler23.is高額介護_予防_サービス費チェック(div)) {
            throw new ApplicationException(DbcErrorMessages.高額合算自己負担額関連3.getMessage());
        }
    }

    private JikoFutangakuHosei2Handler1 getJikoFutangakuHosei2Handler1(JikoFutangakuHosei2PanelDiv div) {
        return new JikoFutangakuHosei2Handler1(div);
    }

    private JikoFutangakuHosei2Handler2 getJikoFutangakuHosei2Handler2(JikoFutangakuHosei2PanelDiv div) {
        return new JikoFutangakuHosei2Handler2(div);
    }

    private JikoFutangakuHosei2Handler3 getJikoFutangakuHosei2Handler3(JikoFutangakuHosei2PanelDiv div) {
        return new JikoFutangakuHosei2Handler3(div);
    }

    private JikoFutangakuHosei2Handler4 getJikoFutangakuHosei2Handler4(JikoFutangakuHosei2PanelDiv div) {
        return new JikoFutangakuHosei2Handler4(div);
    }
}
