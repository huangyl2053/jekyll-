/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.JukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.JukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.JukyushaIdoRenrakuhyoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBCKD00007_(共有子Div)受給者異動連絡票です。
 *
 * @reamsid_L DBC-4350-010 chenhui
 */
public class JukyushaIdoRenrakuhyo {

    /**
     * 「事業区分」操作制御のメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     *
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onClick_radNijiyoboJigyoKubun(JukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).onClick_事業区分();
        return createResponse(div);
    }

    /**
     * 「計画作成区分」操作制御のメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onClick_radKyotakuServiceSakuseiKubun(JukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).onClick_計画作成区分();
        return createResponse(div);
    }

    /**
     * 異動日focus outのメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onBlur_txtIdoYMD(JukyushaIdoRenrakuhyoDiv div) {
        RString 処理モード = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        getHandler(div).onBlur_異動日(処理モード);
        return createResponse(div);
    }

    /**
     * 支援事業者番号focus outのメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onBlur_txtKyotakuKaigoShienJigyoshoNo(JukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).onBlur_支援事業者番号();
        return createResponse(div);
    }

    /**
     * 認定申請中区分チェック
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onClick_radTokuteiNyushoshaNinteiShinseichuKubun(JukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).onChange_認定申請中区分();
        return createResponse(div);
    }

    /**
     * 住所地特例の保険者番号focus outのメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onBlur_txtShisetsuShozaiHokenjaNo(JukyushaIdoRenrakuhyoDiv div) {
        getHandler(div).onBlur_保険者番号();
        return createResponse(div);
    }

    /**
     * 「支援事業者」ボタンを押した後のメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onBeforeOpenDialog_btnJigyosha(
            JukyushaIdoRenrakuhyoDiv div) {
        JigyoshaMode jigyoshaMode = new JigyoshaMode();
        jigyoshaMode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(jigyoshaMode));
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者・施設選択入力ガイド」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div JukyushaIdoRenrakuhyoDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoDiv> onOkClose_btnJigyosha(
            JukyushaIdoRenrakuhyoDiv div) {
        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.getJigyoshaMode(), JigyoshaMode.class);
        div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoNo().setValue(
                jigyoshaMode.getJigyoshaNo().value());
        div.getKyotakuServicePlanPanel().getTxtKyotakuKaigoShienJigyoshoName().setPlaceHolder(
                jigyoshaMode.getJigyoshaName().value());
        return ResponseData.of(div).respond();
    }

    private ResponseData<JukyushaIdoRenrakuhyoDiv> createResponse(JukyushaIdoRenrakuhyoDiv div) {
        return ResponseData.of(div).respond();
    }

    private JukyushaIdoRenrakuhyoHandler getHandler(JukyushaIdoRenrakuhyoDiv div) {
        return new JukyushaIdoRenrakuhyoHandler(div);
    }

}
