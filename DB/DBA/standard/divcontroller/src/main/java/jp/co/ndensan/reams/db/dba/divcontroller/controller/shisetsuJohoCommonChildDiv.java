/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shisetsuJohoCommonChildDiv.shisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shisetsuJohoCommonChildDiv.ShisetsuJohoHandler;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 介護保険施設（介護事業者）、その他特例施設、適用除外施設の事業者・施設入力ガイドを呼び出す元共有子Divです。
 */
public class shisetsuJohoCommonChildDiv {

    /**
     * 施設情報初期化。<br/>
     *
     * @param requestDiv 該当事業者一覧Div
     * @return レスポンス
     */
    public ResponseData<shisetsuJohoCommonChildDivDiv> onLoad(shisetsuJohoCommonChildDivDiv requestDiv) {

        ResponseData<shisetsuJohoCommonChildDivDiv> responseData = new ResponseData<>();

        ShisetsuJohoHandler handler = createHandlerOf(requestDiv);
        RString 台帳種別 = DataPassingConverter.deserialize(requestDiv.get台帳種別(), RString.class);
        RString 台帳種別表示 = DataPassingConverter.deserialize(requestDiv.get台帳種別表示(), RString.class);
        handler.load(台帳種別表示, 台帳種別);
        responseData.data = requestDiv;

        return responseData;
    }

    /**
     * 施設情報に初期化を設定する。
     *
     * @param requestDiv 施設情報Div
     * @return レスポンス
     */
    public ResponseData<shisetsuJohoCommonChildDivDiv> onChange_btn(shisetsuJohoCommonChildDivDiv requestDiv) {

        ShisetsuJohoHandler handler = createHandlerOf(requestDiv);
        RString 台帳種別表示 = DataPassingConverter.deserialize(requestDiv.get台帳種別表示(), RString.class);
        handler.onChange(台帳種別表示);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 入所施設検索。<br/>
     *
     * @param requestDiv 施設情報Div
     * @return レスポンス
     */
    public ResponseData<shisetsuJohoCommonChildDivDiv> onBeforeOpenDialog_shisetsu(shisetsuJohoCommonChildDivDiv requestDiv) {

        JigyoshaMode mode = new JigyoshaMode();

        if (requestDiv.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !requestDiv.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty()) {

            mode.setJigyoshaShubetsu(requestDiv.getRadKaigoHokenShisetsu().getSelectedKey());
        }

        if (!requestDiv.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty()) {

            mode.setJigyoshaShubetsu(requestDiv.getRadOtherTokureiShisetsu().getSelectedKey());
        }

        if (!requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty()) {

            mode.setJigyoshaShubetsu(requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey());
        }

        requestDiv.setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 事業者・施設入力ガイドのOKClose時の処理を行います。<br/>
     *
     * @param requestDiv 施設情報Div
     * @return レスポンス
     */
    public ResponseData<shisetsuJohoCommonChildDivDiv> onOkClose_btnSenTaKu(shisetsuJohoCommonChildDivDiv requestDiv) {

        JigyoshaMode mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);

        requestDiv.getTxtNyuryokuShisetsuKodo().setValue(mode.getJigyoshaNo().value());
        requestDiv.getTxtNyuryokuShisetsuMeisho().setValue(mode.getJigyoshaName().value());

        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 事業者・施設入力ガイドのonBlur時の処理を行います。<br/>
     *
     * @param requestDiv 施設情報Div
     * @return レスポンス
     */
    public ResponseData<shisetsuJohoCommonChildDivDiv> onBlur_btn(shisetsuJohoCommonChildDivDiv requestDiv) {

        ShisetsuJohoHandler handler = createHandlerOf(requestDiv);
        RString 台帳種別 = DataPassingConverter.deserialize(requestDiv.get台帳種別(), RString.class);
        RString 台帳種別表示 = DataPassingConverter.deserialize(requestDiv.get台帳種別表示(), RString.class);
        if (!requestDiv.getTxtNyuryokuShisetsuKodo().getValue().isEmpty()) {

            handler.selectShiSeTuMeiSyo(台帳種別, 台帳種別表示);
        } else {

            requestDiv.getTxtNyuryokuShisetsuMeisho().clearValue();
        }

        return ResponseData.of(requestDiv).respond();
    }

    private ShisetsuJohoHandler createHandlerOf(shisetsuJohoCommonChildDivDiv requestDiv) {
        return new ShisetsuJohoHandler(requestDiv);
    }
}
