/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShisetsuJohoCommonChildDiv;

import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 介護保険施設（介護事業者）、その他特例施設、適用除外施設の事業者・施設入力ガイドを呼び出す元共有子Divです。
 *
 * @reamsid_L DBA-0190-010 houtianpeng
 */
public class ShisetsuJohoCommonChildDiv {

    /**
     * 施設情報に初期化を設定します。
     *
     * @param requestDiv ShisetsuJohoCommonChildDivDiv
     * @return ResponseData<ShisetsuJohoCommonChildDivDiv>
     */
    public ResponseData<ShisetsuJohoCommonChildDivDiv> onChange_daichoShubetsu(ShisetsuJohoCommonChildDivDiv requestDiv) {

        getHandler(requestDiv).onChange();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 入所施設を検索します。<br/>
     *
     * @param requestDiv ShisetsuJohoCommonChildDivDiv
     * @return ResponseData<ShisetsuJohoCommonChildDivDiv>
     */
    public ResponseData<ShisetsuJohoCommonChildDivDiv> onBeforeOpenDialog_shisetsu(ShisetsuJohoCommonChildDivDiv requestDiv) {

        JigyoshaMode mode = new JigyoshaMode();

        if (requestDiv.getRadKaigoHokenShisetsu().getSelectedKey() != null
                && !requestDiv.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty()) {

            mode.setJigyoshaShubetsu(requestDiv.getRadKaigoHokenShisetsu().getSelectedKey());
            requestDiv.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            requestDiv.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            requestDiv.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }

        if (requestDiv.getRadOtherTokureiShisetsu().getSelectedKey() != null
                && !requestDiv.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty()) {

            mode.setJigyoshaShubetsu(requestDiv.getRadOtherTokureiShisetsu().getSelectedKey());
            requestDiv.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            requestDiv.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            requestDiv.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }

        if (requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey() != null
                && !requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty()) {

            mode.setJigyoshaShubetsu(requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey());
            requestDiv.getRadKaigoHokenShisetsu().getDisabledItem().clear();
            requestDiv.getRadOtherTokureiShisetsu().getDisabledItem().clear();
            requestDiv.getRadTekiyoJyogaiShisetsu().getDisabledItem().clear();
        }

        if ((requestDiv.getRadKaigoHokenShisetsu().getSelectedKey() == null
                || requestDiv.getRadKaigoHokenShisetsu().getSelectedKey().isEmpty())
                && (requestDiv.getRadOtherTokureiShisetsu().getSelectedKey() == null
                || requestDiv.getRadOtherTokureiShisetsu().getSelectedKey().isEmpty())
                && (requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey() == null
                || requestDiv.getRadTekiyoJyogaiShisetsu().getSelectedKey().isEmpty())) {

            mode.setJigyoshaShubetsu(ShisetsuType.適用除外施設.getコード());
        }

        requestDiv.setJigyoshaMode(DataPassingConverter.serialize(mode));
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 事業者・施設入力ガイドのOKClose時の処理を行います。<br/>
     *
     * @param requestDiv ShisetsuJohoCommonChildDivDiv
     * @return ResponseData<ShisetsuJohoCommonChildDivDiv>
     */
    public ResponseData<ShisetsuJohoCommonChildDivDiv> onOkClose_btnSenTaKu(ShisetsuJohoCommonChildDivDiv requestDiv) {

        JigyoshaMode mode = DataPassingConverter.deserialize(requestDiv.getJigyoshaMode(), JigyoshaMode.class);

        if (mode.getJigyoshaNo() != null) {
            requestDiv.getTxtNyuryokuShisetsuKodo().setValue(mode.getJigyoshaNo().value());
        }
        if (mode.getJigyoshaName() != null) {
            requestDiv.getTxtNyuryokuShisetsuMeisho().setValue(mode.getJigyoshaName().value());
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 施設情報のonBlur時の処理を行います。<br/>
     *
     * @param requestDiv ShisetsuJohoCommonChildDivDiv
     * @return ResponseData<ShisetsuJohoCommonChildDivDiv>
     */
    public ResponseData<ShisetsuJohoCommonChildDivDiv> onBlur_nyuryokuShisetsuKodo(ShisetsuJohoCommonChildDivDiv requestDiv) {

        if (!requestDiv.getTxtNyuryokuShisetsuKodo().getValue().isEmpty()) {

            getHandler(requestDiv).selectShiSeTuMeiSyo();
        } else {

            requestDiv.getTxtNyuryokuShisetsuMeisho().clearValue();
        }

        return ResponseData.of(requestDiv).respond();
    }

    private ShisetsuJohoHandler getHandler(ShisetsuJohoCommonChildDivDiv requestDiv) {
        return new ShisetsuJohoHandler(requestDiv);
    }
}
