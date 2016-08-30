/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input.FukaHikakuInput;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.DBB0320003TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.DBB0320004TransitionEventName;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会メインパネル
 */
public class FukaShokaiMain {

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onLoad(FukaShokaiMainDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        DBB0320001StateName state = handler.initializeWithFirstState();
        if (state == DBB0320001StateName.Default) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        return ResponseData.of(div).setState(state);
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onActive(FukaShokaiMainDiv div) {
        if (comesFrom("DBB0320002", DBB0320002TransitionEventName.一覧に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.一覧に戻る).respond();
        }
        if (comesFrom("DBB0320002", DBB0320002TransitionEventName.検索に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.検索に戻る).respond();
        }
        if (comesFrom("DBB0320002", DBB0320002TransitionEventName.履歴一覧)) {
            return onClick_btnRirekiHyoji(div);
        }
        if (comesFrom("DBB0320003", DBB0320003TransitionEventName.一覧に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.一覧に戻る).respond();
        }
        if (comesFrom("DBB0320003", DBB0320003TransitionEventName.検索に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.検索に戻る).respond();
        }
        if (comesFrom("DBB0320003", DBB0320003TransitionEventName.履歴一覧)) {
            return onClick_btnRirekiHyoji(div);
        }
        if (comesFrom("DBB0320004", DBB0320004TransitionEventName.一覧に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.一覧に戻る).respond();
        }
        if (comesFrom("DBB0320004", DBB0320004TransitionEventName.検索に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.検索に戻る).respond();
        }
        if (comesFrom("DBB0320004", DBB0320004TransitionEventName.履歴一覧)) {
            return onClick_btnRirekiHyoji(div);
        }
        return ResponseData.of(div).setState(DBB0320001StateName.賦課根拠期割);
    }

    private static boolean comesFrom(String 画面ID, IContainerEvents 遷移イベント) {
        return Objects.equals(ResponseHolder.getBeforeEvent(),
                new RStringBuilder().append(画面ID).append("_").append(遷移イベント.getName()).toRString());
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnRirekiHyoji(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.show全賦課履歴();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onSelect_dgFukaRirekiAll(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.show賦課履歴一覧();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onSelect_dgFukaRirekiFukaRireki(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.show賦課根拠期割();
        return ResponseData.of(div).setState(DBB0320001StateName.賦課根拠期割);
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_MaeHikaku(FukaShokaiMainDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        Optional<FukaShokaiKey> 後履歴 = handler.getClicked賦課履歴Key();
        Optional<FukaShokaiKey> 前履歴 = handler.get前賦課履歴Key(後履歴);
        if (!前履歴.isPresent() || !後履歴.isPresent()) {
            return ResponseData.of(div).addMessage(DbbInformationMessages.比較対象データなし.getMessage()).respond();
        }
        ViewStateHolder.put(ViewStateKeys.賦課比較キー, FukaHikakuInput.createFor前履歴との比較(後履歴.get(), 前履歴.get()));
        return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.比較).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnZenkairesultHyoji(FukaShokaiMainDiv div) {
        return clearViewStateKeys(div);
    }

    private ResponseData<FukaShokaiMainDiv> clearViewStateKeys(FukaShokaiMainDiv div) {
        FukaShokaiController.clearFukaTaishoshaKeyAndFukaShokaiKey();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnResearch(FukaShokaiMainDiv div) {
        return clearViewStateKeys(div);
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnCommonBack(FukaShokaiMainDiv div) {
        if (comesFrom("DBB0320002", DBB0320002TransitionEventName.履歴一覧)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.世帯員所得).respond();
        }
        if (comesFrom("DBB0320003", DBB0320003TransitionEventName.履歴一覧)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.特別徴収).respond();
        }
        if (comesFrom("DBB0320004", DBB0320004TransitionEventName.履歴一覧)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.減免).respond();
        }
        return ResponseData.of(div).setState(DBB0320001StateName.賦課根拠期割);
    }
}
