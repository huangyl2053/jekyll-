/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku.KijunShunyugakuDate;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShotokuJokyo.ShotokuJokyoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShotokuJokyo.ShotokuJokyoValidationHandler;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBC_ShotokuJokyo_所得状況のクラスです。
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public class ShotokuJokyo {

    /**
     * 初期化のンメソッドます。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuJokyoDiv> initialize(ShotokuJokyoDiv div) {
        RString モード = DataPassingConverter
                .deserialize(div.getHdnMode(), RString.class);
        FlexibleDate 世帯員把握基準日 = DataPassingConverter
                .deserialize(div.getHdnKijunYMD(), FlexibleDate.class);
        FlexibleDate 処理年度 = DataPassingConverter
                .deserialize(div.getHdnShoriNendo(), FlexibleDate.class);
        ShikibetsuCode 識別コード = DataPassingConverter
                .deserialize(div.getHdnShikibetuCode(), ShikibetsuCode.class);
        getHandler(div).initialize(モード, 世帯員把握基準日, 処理年度, 識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンのンメソッドます。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuJokyoDiv> onClick_btnKakutei(ShotokuJokyoDiv div) {
        ValidationMessageControlPairs messages = getValidationHandler(div).validate();
        if (messages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(messages).respond();
        }
        ResponseData<ShotokuJokyoDiv> response = new ResponseData<>();
        List<KijunShunyugakuDate> list = getHandler(div).set世帯員情報クラス格納リスト();
        div.setHdnDaialogSelectSetaiinJoho(DataPassingConverter.serialize((Serializable) list));
        response.data = div;
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 閉じるボタンのンメソッドます。
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuJokyoDiv> onClick_btnClose(ShotokuJokyoDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShotokuJokyoHandler getHandler(ShotokuJokyoDiv div) {
        return new ShotokuJokyoHandler(div);
    }

    private ShotokuJokyoValidationHandler getValidationHandler(ShotokuJokyoDiv div) {
        return new ShotokuJokyoValidationHandler(div);
    }
}
