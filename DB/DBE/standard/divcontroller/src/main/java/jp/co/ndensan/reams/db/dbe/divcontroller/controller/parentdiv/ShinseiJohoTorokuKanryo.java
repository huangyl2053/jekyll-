/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010002.HihokenshaOutlineDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010002.ShinseiJohoTorokuKanryoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
public class ShinseiJohoTorokuKanryo {

    /**
     * onLoad。
     *
     * @param div ShinseiJohoTorokuKanryoDiv
     * @param outline ShinseiJohoInputDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiJohoTorokuKanryoDiv> onLoad(ShinseiJohoTorokuKanryoDiv div, HihokenshaOutlineDiv outline) {
        return onClick_btnCommonSaveShinsei(div, outline);
    }

    /**
     * onClick_btnCommonSaveShinsei
     *
     * @param div ShinseiJohoTorokuKanryoDiv
     * @param outline HihokenshaOutlineDiv
     * @return ResponseData<ShinseiJohoTorokuKanryoDiv>
     */
    public ResponseData<ShinseiJohoTorokuKanryoDiv> onClick_btnCommonSaveShinsei(ShinseiJohoTorokuKanryoDiv div, HihokenshaOutlineDiv outline) {
        div.getKanryoMessage().setSuccessMessage(
                new RString("申請を登録しました。"),
                new RString("被保番号: " + extractHihokenshaNo(outline)),
                new RString("　　氏名: "));
//                new RString("　　氏名: " + extractHihokenshaShimei(outline)));
        div.setDisplayNone(false);
        return _createResponseData(div);
    }

    private RString extractHihokenshaNo(HihokenshaOutlineDiv outline) {
        return outline.getShikakuKihon().getTxtHihokenshaNo().getValue();
    }

//    private RString extractHihokenshaShimei(HihokenshaOutlineDiv outline) {
////        return outline.getAtenaInfo().getAtenaInfo().getTxtAtenaMeisho().getValue();
//        return RString.EMPTY;
//    }
    private ResponseData<ShinseiJohoTorokuKanryoDiv> _createResponseData(ShinseiJohoTorokuKanryoDiv div) {
        ResponseData<ShinseiJohoTorokuKanryoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
