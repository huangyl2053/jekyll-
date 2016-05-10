/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.commonchilddiv.kaigogekihenkanwasettei;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigogekihenkanwasettei.KaigoGekihenKanwaSettei.KaigoGekihenKanwaSetteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigogekihenkanwasettei.KaigoGekihenKanwaSettei.KaigoGekihenKanwaSetteiHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * KaigoGekihenKanwaSettei_激変緩和ダイアログのクラスです。
 *
 * @reamsid_L DBB-1770-020 wangkanglei
 */
public class KaigoGekihenKanwaSettei {

    private final RString 保険料率 = new RString("保険料率");

    /**
     * 初期化のンメソッドます。
     *
     * @param div KaigoGekihenKanwaSetteiDiv
     * @return ResponseData
     */
    public ResponseData<KaigoGekihenKanwaSetteiDiv> onLoad(KaigoGekihenKanwaSetteiDiv div) {
        Decimal hdnGekihenIndex04 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex04(), Decimal.class);
        Decimal hdnGekihenIndex05 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex05(), Decimal.class);
        Decimal hdnGekihenIndex06 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex06(), Decimal.class);
        Decimal hdnGekihenIndex08 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex08(), Decimal.class);
        Decimal hdnGekihenIndex09 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex09(), Decimal.class);
        Decimal hdnGekihenIndex10 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex10(), Decimal.class);
        Decimal hdnGekihenIndex11 = DataPassingConverter
                .deserialize(div.getHdnGekihenIndex11(), Decimal.class);
        getHandler(div).onLoad(hdnGekihenIndex04,
                hdnGekihenIndex05,
                hdnGekihenIndex06,
                hdnGekihenIndex08,
                hdnGekihenIndex09,
                hdnGekihenIndex10,
                hdnGekihenIndex11);
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタンのンメソッドます。
     *
     * @param div KaigoGekihenKanwaSetteiDiv
     * @return ResponseData
     */
    public ResponseData<KaigoGekihenKanwaSetteiDiv> onClickBtnKakutei(KaigoGekihenKanwaSetteiDiv div) {
        if (getHandler(div).isHiddenInput()) {
            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり.getMessage()
                    .replace(保険料率.toString()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタンのンメソッドます。
     *
     * @param div KaigoGekihenKanwaSetteiDiv
     * @return ResponseData
     */
    public ResponseData<KaigoGekihenKanwaSetteiDiv> onClickBtnClose(KaigoGekihenKanwaSetteiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 激変緩和GridのHandlerクラスを取得のンメソッドます。
     *
     * @param requestDiv ShikibetsuBangoSelectorDiv
     * @return ShikibetsuBangoSelectorDivHandler
     */
    private KaigoGekihenKanwaSetteiHandler getHandler(KaigoGekihenKanwaSetteiDiv div) {
        return new KaigoGekihenKanwaSetteiHandler(div);
    }
}
