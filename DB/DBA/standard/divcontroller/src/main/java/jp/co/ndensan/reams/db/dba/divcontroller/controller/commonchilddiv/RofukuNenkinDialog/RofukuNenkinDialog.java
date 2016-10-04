/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.RofukuNenkinDialog;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RofukuNenkinDialog.RofukuNenkinDialogDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RofukuNenkinState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 老齢福祉年金ダイアログのイベントを定義したクラスです。
 *
 * @author n8178
 */
public class RofukuNenkinDialog {

    /**
     * onLoad時の処理です。 ダイアログBTNから渡された要素を元に、共有子Divの初期化を行います。
     *
     * @param div RofukuNenkinDialogDiv
     * @return ResponseData
     */
    public ResponseData<RofukuNenkinDialogDiv> onLoad(RofukuNenkinDialogDiv div) {

        if (isEmptyKeyData(div)) {
            div.getCcdRofukuNenkinRireki().initialize(ShikibetsuCode.EMPTY, HihokenshaNo.EMPTY);
            div.getCcdRofukuNenkinRireki().setShokaiMode();
            setState(div, RofukuNenkinState.照会);
            return ResponseData.of(div).respond();
        }

        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(div.getShikibetsuCode());
        HihokenshaNo hihokenshaNo = new HihokenshaNo(div.getHihokenshaNo());

        if (isEmptySaveData(div)) {
            div.getCcdRofukuNenkinRireki().initialize(shikibetsuCode, hihokenshaNo);
            setState(div);
        } else {
            Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                    = DataPassingConverter.deserialize(div.getSaveData(), Models.class);
            div.getCcdRofukuNenkinRireki().initialize(roreiFukushiNenkinJukyusha);
            setState(div);
        }

        return ResponseData.of(div).respond();
    }

    private boolean isEmptyKeyData(RofukuNenkinDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            return true;
        }
        return (div.getShikibetsuCode() == null || div.getShikibetsuCode().isEmpty());
    }

    private boolean isEmptySaveData(RofukuNenkinDialogDiv div) {
        return (div.getSaveData() == null || div.getSaveData().isEmpty());
    }

    private void setState(RofukuNenkinDialogDiv div) {
        setState(div, div.getMode());
    }

    private void setState(RofukuNenkinDialogDiv div, RofukuNenkinState state) {
        setState(div, state.getStateValue());
    }

    private void setState(RofukuNenkinDialogDiv div, RString state) {

        if (RofukuNenkinState.照会.getStateValue().equals(state)) {
            div.getCcdRofukuNenkinRireki().setShokaiMode();
        } else if (RofukuNenkinState.登録.getStateValue().equals(state)) {
            div.getCcdRofukuNenkinRireki();
        }
    }

    /**
     * 閉じるBTNをクリックした場合の処理です。 老福年金グリッド上に設定されているデータを、受け渡し用の要素に設定します。
     *
     * @param div RofukuNenkinDialogDiv
     * @return ResponseData
     */
    public ResponseData<RofukuNenkinDialogDiv> onClick_btnClose(RofukuNenkinDialogDiv div) {
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = div.getCcdRofukuNenkinRireki().getSaveData();
        RString serialized = DataPassingConverter.serialize(roreiFukushiNenkinJukyusha);
        div.setSaveData(serialized);
        return ResponseData.of(div).respond();
    }
}
