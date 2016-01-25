/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810012;

import jp.co.ndensan.reams.db.dbc.business.TestEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012.ShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810012.ShinseiDetailHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 償還払い状況照会_申請情報照会画面クラスです
 *
 * @author XuPeng
 */
public class ShinseiDetail {

    /**
     * 償還払い状況照会_申請情報照会画面初期化する
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<ShinseiDetailDiv> onLoad(ShinseiDetailDiv div) {
        TestEntity entity = new TestEntity();
        //介護宛名情報」共有子Divの初期化
//        div.getPanelUp().getCcdKaigoAtenaInfo().load(識別コード);
        //介護資格系基本情報」共有子Div の初期化
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
//            div.getPanelUp().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelUp().getCcdKaigoAtenaInfo().setVisible(false);
        }
        ShinseiDetailHandler handler = getHandler(div);
        handler.initPanelHead(entity.getサービス年月(), entity.get整理番号());
//        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
//        List<ShokanShinsei> businessList = finder.getShokanbaraiShinseiJyohoDetail(
//                entity.get被保険者番号(),
//                entity.getサービス年月(),
//                entity.get整理番号());
//        if (businessList == null || businessList.isEmpty()) {
//            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//        }
//        handler.init申請内容(businessList);
        handler.init();
        return ResponseData.of(div).respond();
    }

    /**
     * 口座情報<br/>
     * DBC0810013_口座情報画面へ遷移する
     *
     * @param div {@link ShinseiDetailDiv 申請情報照会画面Div}
     * @return 申請情報照会画面Divを持つResponseData
     */
    public ResponseData<ShinseiDetailDiv> onClick_btnKouzaInfo(ShinseiDetailDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * サービス提供証明書<br/>
     * DBC0810014_サービス提供証明書情報画面へ遷移する
     *
     * @param div {@link ShinseiDetailDiv 申請情報照会画面Div}
     * @return 申請情報照会画面Divを持つResponseData
     */
    public ResponseData<ShinseiDetailDiv> onClick_btnServerteikyoShomeisyo(ShinseiDetailDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 償還払決定情報<br/>
     * DBC0810015_償還払決定情報画面へ遷移する
     *
     * @param div {@link ShinseiDetailDiv 申請情報照会画面Div}
     * @return 申請情報照会画面Divを持つResponseData
     */
    public ResponseData<ShinseiDetailDiv> onClick_btnShokanBaraiKeteiInfo(ShinseiDetailDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 申請情報検索へ戻る<br/>
     * DBC0810011_申請検索画面へ遷移する
     *
     * @param div {@link ShinseiDetailDiv 申請情報照会画面Div}
     * @return 申請情報照会画面Divを持つResponseData
     */
    public ResponseData<ShinseiDetailDiv> onClick_btnShinseiSearch(ShinseiDetailDiv div) {

        return ResponseData.of(div).respond();
    }

    private ShinseiDetailHandler getHandler(ShinseiDetailDiv div) {
        return ShinseiDetailHandler.of(div);
    }
}
