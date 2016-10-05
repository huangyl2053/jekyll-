/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1040021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD204010.DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040021.TokubetsuPanelHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040021.TokubetsuPanelValidationHandler;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 特別地域加算軽減実績管理画面のControllerクラスです
 *
 * @reamsid_L DBD-3880-010 xuejm
 */
public class TokubetsuPanel {

    /**
     * 特別地域加算軽減実績管理リストDivの初期化を表します。
     *
     * @param div TokubetsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuPanelDiv> onLoad(TokubetsuPanelDiv div) {
        creatTokubetsuHandler(div).onLoad();
        return createResponse(div);

    }

    /**
     * 画面の地区DDLを操作です。
     *
     * @param div TokubetsuPanelDiv
     * @return ResponseData<TokubetsuPanelDiv>
     */
    public ResponseData<TokubetsuPanelDiv> onChange_ddlChiku(TokubetsuPanelDiv div) {
        creatTokubetsuHandler(div).onChange_ddlChiku();
        return createResponse(div);
    }

    /**
     * onOkClose_btnGyoseikuFrom。
     *
     * @param div TokubetsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuPanelDiv> onOkClose_btnGyoseikuFrom(TokubetsuPanelDiv div) {
        div.getTxtChikuCodeFrom().setValue(div.getHdnChugakkokuCode());
        div.getTxtChikuNameFrom().setValue(div.getHdnName());
        return createResponse(div);
    }

    /**
     * onOkClose_btnGyoseikuTo。
     *
     * @param div TokubetsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuPanelDiv> onOkClose_btnGyoseikuTo(TokubetsuPanelDiv div) {
        div.getTxtChikuCodeTo().setValue(div.getHdnChugakkokuCode());
        div.getTxtChikuNameTo().setValue(div.getHdnName());
        return createResponse(div);
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div TokubetsuPanelDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<TokubetsuPanelDiv> onBeforeCilck_btnBatchchek(TokubetsuPanelDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor年月範囲が非空チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return createResponse(div);
    }

    /**
     * 実行するボタンを押下のバッチ用パラメータを作成します。
     *
     * @param div TokubetsuPanelDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter> onClick_btnBatchRegister(TokubetsuPanelDiv div) {
        TokubetsuChiikiKasanKeigenJisekiKanriIchiran tokubetsuchiran
                = new TokubetsuChiikiKasanKeigenJisekiKanriIchiran();
        return ResponseData.of(tokubetsuchiran.createParameter(div)).respond();
    }

    /**
     * onBeforeOpenDialog_btnJigyosyano事件です。
     *
     * @param div TokubetsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuPanelDiv> onBeforeOpenDialog_btnJigyosyano(TokubetsuPanelDiv div) {
        JigyoshaMode mode = new JigyoshaMode();
        mode.setJigyoshaShubetsu(ShisetsuType.住所地特例対象施設.getコード());
        div.setHiddenJigyoshaMode(DataPassingConverter.serialize(mode));
        return createResponse(div);
    }

    /**
     * onOkClose_btnSienJigyosyano事件です。
     *
     * @param div TokubetsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<TokubetsuPanelDiv> onOkClose_btnJigyosyano(TokubetsuPanelDiv div) {
        JigyoshaMode mode = DataPassingConverter.deserialize(
                div.getHiddenJigyoshaMode(), JigyoshaMode.class);
        div.getTxtJigyoshaName().setValue(new RString(mode.getJigyoshaName().toString()));
        div.getTxtJigyoshaNo().setValue(new RString(mode.getJigyoshaNo().toString()));
        return createResponse(div);
    }

    private TokubetsuPanelHandler creatTokubetsuHandler(TokubetsuPanelDiv div) {
        return new TokubetsuPanelHandler(div);
    }

    private TokubetsuPanelValidationHandler getValidationHandler() {
        return new TokubetsuPanelValidationHandler();
    }

    private ResponseData<TokubetsuPanelDiv> createResponse(TokubetsuPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
