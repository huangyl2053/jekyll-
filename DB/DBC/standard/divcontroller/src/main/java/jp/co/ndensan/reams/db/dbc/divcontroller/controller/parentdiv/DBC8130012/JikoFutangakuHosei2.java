/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8130012;

import jp.co.ndensan.reams.db.dbc.business.core.kogaku.JigyoKogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012.DBC8130012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130012.JikoFutangakuHosei2Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012.JikoFutangakuHosei2Handler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012.JikoFutangakuHosei2ValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130012.JikoFutangakuHoseiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業分自己負担額情報補正（単）_補正入力のクラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
public class JikoFutangakuHosei2 {

    private static final RString 文字列_0 = new RString("0");
    private static final RString 文字列_1 = new RString("1");

    /**
     * 画面の初期化のメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onLoad(JikoFutangakuHosei2Div div) {
        JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.事業高額合算自己負担額補正保持Entity, JigyoKogakuGassanJikofutangakuHosei.class);
        if (文字列_0.equals(事業高額合算自己負担額補正保持Entity.get呼び出しフラグ())) {
            getHandler(div).initilize_初回(事業高額合算自己負担額補正保持Entity);
            getJikoFutangakuHoseiHandler(div).onChange_txt70Kara74FutangakuGatsuGo();
            getHandler(div).変更前補正後金額の設定(事業高額合算自己負担額補正保持Entity);
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額補正保持Entity, 事業高額合算自己負担額補正保持Entity);
        } else if (文字列_1.equals(事業高額合算自己負担額補正保持Entity.get呼び出しフラグ())) {
            getJikoFutangakuHoseiHandler(div).initialize_２回目以降(事業高額合算自己負担額補正保持Entity);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 補正前の金額をコピーするのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onClick_btnHoseiMaeKingakuCopy(JikoFutangakuHosei2Div div) {
        JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.事業高額合算自己負担額補正保持Entity, JigyoKogakuGassanJikofutangakuHosei.class);
        ValidationMessageControlPairs valid = getJikoFutangakuHosei2ValidationHandler(div, 事業高額合算自己負担額補正保持Entity.get生年月日(),
                事業高額合算自己負担額補正保持Entity.get対象年度()).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        getHandler(div).補正後の金額コピー();
        return ResponseData.of(div).respond();
    }

    /**
     * [８月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_celJikofutangaku8GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_celJikofutangaku8GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [８月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi8GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi8GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [９月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangaku9GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangaku9GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [９月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi9GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi9GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [１０月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangaku10GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangaku10GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [１０月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi10GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangaku10GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [１１月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangaku11GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangaku11GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [１１月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi11GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi11GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [１２月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangaku12GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangaku12GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [１２月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi12GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi12GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌１月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku1GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku1GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌１月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehiYoku1GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehiYoku1GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌２月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku2GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku2GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌２月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehiYoku2GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehiYoku2GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌３月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku3GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku3GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌３月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi3GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi3GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌４月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku4GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌４月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi4GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi4GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌５月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku5GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌５月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi5GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi5GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌６月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku6GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌６月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi6GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi6GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌７月分　補正後　自己負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtJikofutangakuYoku7GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtJikofutangakuYoku7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [翌７月分　補正後　高額総合事業サービス費]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txtKougakuSogoJigyoServicehi7GatsuGo(JikoFutangakuHosei2Div div) {
        getHandler(div).onChange_txtKougakuSogoJigyoServicehi7GatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * [補正後　うち70～74歳に係る負担額]changeのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onChange_txt70Kara74FutangakuGatsuGo(JikoFutangakuHosei2Div div) {
        getJikoFutangakuHoseiHandler(div).onChange_txt70Kara74FutangakuGatsuGo();
        return ResponseData.of(div).respond();
    }

    /**
     * 「自己負担管理情報に戻る」ボタンclickのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onClick_btnJikofutanKanrijohoModoru(JikoFutangakuHosei2Div div) {
        return ResponseData.of(div).forwardWithEventName(DBC8130012TransitionEventName.一覧へ).respond();
    }

    /**
     * 「自己負担額情報を確定する」ボタンclickのメソッドです。
     *
     * @param div JikoFutangakuHosei2Div
     * @return 初期化画面
     */
    public ResponseData<JikoFutangakuHosei2Div> onClick_btnJikofutangakuKakutei(JikoFutangakuHosei2Div div) {
        JigyoKogakuGassanJikofutangakuHosei 事業高額合算自己負担額補正保持Entity = ViewStateHolder
                .get(ViewStateKeys.事業高額合算自己負担額補正保持Entity, JigyoKogakuGassanJikofutangakuHosei.class);
        ValidationMessageControlPairs valid = getJikoFutangakuHosei2ValidationHandler(div, 事業高額合算自己負担額補正保持Entity.get生年月日(),
                事業高額合算自己負担額補正保持Entity.get対象年度()).validate補正後チェック();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        getHandler(div).事業高額合算自己負担額保持Entityの設定(事業高額合算自己負担額補正保持Entity);
        ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額補正保持Entity, 事業高額合算自己負担額補正保持Entity);
        return ResponseData.of(div).forwardWithEventName(DBC8130012TransitionEventName.一覧へ).respond();
    }

    private JikoFutangakuHosei2Handler getHandler(JikoFutangakuHosei2Div div) {
        return new JikoFutangakuHosei2Handler(div);
    }

    private JikoFutangakuHoseiHandler getJikoFutangakuHoseiHandler(JikoFutangakuHosei2Div div) {
        return new JikoFutangakuHoseiHandler(div);
    }

    private JikoFutangakuHosei2ValidationHandler getJikoFutangakuHosei2ValidationHandler(
            JikoFutangakuHosei2Div div,
            FlexibleDate 生年月日,
            FlexibleYear 対象年度) {
        return new JikoFutangakuHosei2ValidationHandler(div, 生年月日, 対象年度);
    }

}
