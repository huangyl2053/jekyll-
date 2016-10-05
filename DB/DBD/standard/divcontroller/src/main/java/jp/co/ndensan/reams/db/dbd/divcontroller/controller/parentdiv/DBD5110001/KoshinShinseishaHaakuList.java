/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5110001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511003.DBD511003_KoshinMiShinseishaHaakuParameter;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.DBD5110001StateName.初期表示;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.DBD5110001StateName.対象期間;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.DBD5110001StateName.未申請者;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.DBD5110001StateName.範囲指定;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.KoshinShinseishaHaakuListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5110001.KoshinShinseishaHaakuListHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5110001.KoshinShinseishaHaakuListValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 更新未申請者把握リスト作成画面のDivControllerです。
 *
 * @reamsid_L DBD-1420-010 wangjie2
 */
public class KoshinShinseishaHaakuList {

    private final RString 未申請者全て_KEY = new RString("all");
    private final RString 対象月まで_KEY = new RString("endto");
    private final RString 範囲指定_KEY = new RString("endfromto");

    /**
     * 画面初期化処理です。
     *
     * @param div KoshinShinseishaHaakuListDiv
     * @return ResponseData<KoshinShinseishaHaakuListDiv>
     */
    public ResponseData<KoshinShinseishaHaakuListDiv> onLoad(KoshinShinseishaHaakuListDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(初期表示);
    }

    /**
     * 印刷範囲指定ラジオボタン変更処理です。
     *
     * @param div KoshinShinseishaHaakuListDiv
     * @return ResponseData<KoshinShinseishaHaakuListDiv>
     */
    public ResponseData<KoshinShinseishaHaakuListDiv> onChange_radPrintSelect(KoshinShinseishaHaakuListDiv div) {
        RString selectedKey = div.getRadPrintSelect().getSelectedKey();
        if (未申請者全て_KEY.equals(selectedKey)) {
            getHandler(div).未申請者状態();
            return ResponseData.of(div).setState(未申請者);
        } else if (対象月まで_KEY.equals(selectedKey)) {
            getHandler(div).対象期間状態();
            return ResponseData.of(div).setState(対象期間);
        } else if (範囲指定_KEY.equals(selectedKey)) {
            getHandler(div).範囲指定状態();
            return ResponseData.of(div).setState(範囲指定);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「把握リストを発行する」の前処理です。
     *
     * @param div KoshinShinseishaHaakuListDiv
     * @return ResponseData<KoshinShinseishaHaakuListDiv>
     */
    public ResponseData<KoshinShinseishaHaakuListDiv> beforeOnClick_btnprint(KoshinShinseishaHaakuListDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinShinseishaHaakuListValidationHandler validationHandler = new KoshinShinseishaHaakuListValidationHandler();
        if (対象期間.getName().equals(ResponseHolder.getState())) {
            validationHandler.認定有効期間_終了月の未入力チェック(pairs, div);
        } else if (範囲指定.getName().equals(ResponseHolder.getState())) {
            validationHandler.認定有効期間_終了月_Fromの未入力チェック(pairs, div);
            validationHandler.認定有効期間_終了月_Toの未入力チェック(pairs, div);
            validationHandler.期間大小関係チェック(pairs, div);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「把握リストを発行する」の処理です。
     *
     * @param div KoshinShinseishaHaakuListDiv
     * @return ResponseData<KoshinShinseishaHaakuListDiv>
     */
    public ResponseData<DBD511003_KoshinMiShinseishaHaakuParameter> onClick_btnprint(KoshinShinseishaHaakuListDiv div) {
        DBD511003_KoshinMiShinseishaHaakuParameter parameter = getHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private KoshinShinseishaHaakuListHandler getHandler(KoshinShinseishaHaakuListDiv div) {
        return new KoshinShinseishaHaakuListHandler(div);
    }

}
