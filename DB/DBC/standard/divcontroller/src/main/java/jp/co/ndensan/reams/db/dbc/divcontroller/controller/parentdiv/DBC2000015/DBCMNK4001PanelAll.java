/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2000015;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180050.DBC180050_KoseiTaishoKyufuJissekiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000015.DBCMNK4001PanelAllDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000015.DBCMNK4001PanelAllHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000015.DBCMNK4001PanelAllValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.koseitaishokyufujissekiichiran.KoseiTaishoKyufuJissekiIchiran;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNK4001_更正対象給付実績一覧のクラスです。
 *
 * @reamsid_L DBC-4960-010 chenyadong
 */
public class DBCMNK4001PanelAll {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div DBCMNK4001PanelAllDiv
     * @return ResponseData
     */
    public ResponseData<DBCMNK4001PanelAllDiv> onLoad(DBCMNK4001PanelAllDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出期間の大小チェックのメソッドます。
     *
     * @param div DBCMNK4001PanelAllDiv
     * @return ResponseData
     */
    public ResponseData<DBCMNK4001PanelAllDiv> onClick_onBeforeOpenDialog(DBCMNK4001PanelAllDiv div) {
        ValidationMessageControlPairs validationPairs = new ValidationMessageControlPairs();
        validationPairs.add(getValidationHandler(div).大小関係が不正());
        if (validationPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータの設定のメソッドます。
     *
     * @param div DBCMNK4001PanelAllDiv
     * @return ResponseData
     */
    public ResponseData<DBC180050_KoseiTaishoKyufuJissekiIchiranParameter> onClick_btnBatchRegister(DBCMNK4001PanelAllDiv div) {
        YMDHMS 今回抽出期間終了日時 = new YMDHMS(div.getTxtKonkaiShuryoDate().getValue(),
                div.getTxtKonkaiShuryoTime().getValue());
        YMDHMS 今回抽出期間開始日時 = new YMDHMS(RString.EMPTY);
        if (div.getTxtKonkaiKaishiDate().getValue() != null && div.getTxtKonkaiKaishiTime().getValue() != null) {
            今回抽出期間開始日時 = new YMDHMS(div.getTxtKonkaiKaishiDate().getValue(),
                    div.getTxtKonkaiKaishiTime().getValue());
        }
        DBC180050_KoseiTaishoKyufuJissekiIchiranParameter parameter = KoseiTaishoKyufuJissekiIchiran.createInstance().
                getBatchiParameter(今回抽出期間開始日時, 今回抽出期間終了日時, div.getPanelSort().getRadSort().getSelectedKey());
        return ResponseData.of(parameter).respond();
    }

    private DBCMNK4001PanelAllHandler getHandler(DBCMNK4001PanelAllDiv div) {
        return new DBCMNK4001PanelAllHandler(div);
    }

    private DBCMNK4001PanelAllValidationHandler getValidationHandler(DBCMNK4001PanelAllDiv div) {
        return new DBCMNK4001PanelAllValidationHandler(div);
    }
}
