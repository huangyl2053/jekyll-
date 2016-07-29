/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.DBB0320003TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.DBB0320004TransitionEventName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 賦課照会メインパネル
 */
public class FukaShokaiMain {

//    private static final RString RAML_ID_FUKA_SEARCH = new RString("DBZ0300001");
//    private static final RString FUKA_SEARCH_TAISHOSHA_TOKUTEI = new RStringBuilder()
//            .append(RAML_ID_FUKA_SEARCH)
//            .append("_")
//            .append(対象者特定.getName())
//            .toRString();
//
//    private static boolean comesFromFukaTaishoshaSearch() {
//        return Objects.equals(ResponseHolder.getBeforeEvent(), FUKA_SEARCH_TAISHOSHA_TOKUTEI);
//    }
//
    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onLoad(FukaShokaiMainDiv div) {
//        return onActive(div);
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
//        if (ResponseHolder.isReRequest() || !comesFromFukaTaishoshaSearch()) {
//            return ResponseData.of(div).addMessage((Message) new NotificationMessage("01", ResponseHolder.getBeforeEvent().toString())).respond();
//        }
//        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
//        DBB0320001StateName state = handler.initializeWithFirstState();
//        if (state == DBB0320001StateName.Default) {
//            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
//        }
//        return ResponseData.of(div).setState(state);
//      暫定対応（ちらつきあり）
        if (comesFrom("DBB0320002", DBB0320002TransitionEventName.一覧に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.一覧に戻る).respond();
        }
        if (comesFrom("DBB0320002", DBB0320002TransitionEventName.検索に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.検索に戻る).respond();
        }
        if (comesFrom("DBB0320003", DBB0320003TransitionEventName.一覧に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.一覧に戻る).respond();
        }
        if (comesFrom("DBB0320003", DBB0320003TransitionEventName.検索に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.検索に戻る).respond();
        }
        if (comesFrom("DBB0320004", DBB0320004TransitionEventName.一覧に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.一覧に戻る).respond();
        }
        if (comesFrom("DBB0320004", DBB0320004TransitionEventName.検索に戻る)) {
            return ResponseData.of(div).forwardWithEventName(DBB0320001TransitionEventName.検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
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
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_MaeHikaku(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.compareWith前履歴();
        return ResponseData.of(div).respond();
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
}
