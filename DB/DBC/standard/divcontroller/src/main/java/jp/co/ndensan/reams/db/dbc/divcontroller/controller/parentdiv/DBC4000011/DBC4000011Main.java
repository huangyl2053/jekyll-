/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4000011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.DBC4000011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.DBC4000011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.DBC4000011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4000011.DBC4000011MainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4000011.DBC4000011MainValidationHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouHolder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC4000011_サービス内容登録のクラスです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class DBC4000011Main {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 検索 = new RString("検索");
    private static final RString MESSAGEMAIN = new RString("サービス内容の登録が完了しました。");
    private static final RString MESSAGETAISHO1 = new RString("サービスコード：");
    private static final RString MESSAGETAISHO2 = new RString("サービス名称：");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onLoad(DBC4000011MainDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC4000011StateName.初期状態);
    }

    /**
     * サービス内容を検索するのメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onClick_btnSearch(DBC4000011MainDiv div) {
        if (RString.isNullOrEmpty(div.getKensakuJoken().getCcdServiceCdInput().getサービスコード1())
                && RString.isNullOrEmpty(div.getKensakuJoken().getCcdServiceCdInput().getサービスコード2())) {
            return ResponseData.of(div).respond();
        }
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        ViewStateHolder.put(ViewStateKeys.状態, 検索);
        List<KaigoServiceNaiyou> kaigoServiceNaiyouList = getHandler(div).getサービス内容();
        ViewStateHolder.put(ViewStateKeys.介護サービス内容データ, new KaigoServiceNaiyouHolder(kaigoServiceNaiyouList));
        return ResponseData.of(div).setState(DBC4000011StateName.検索結果表示状態);
    }

    /**
     * 追加するのメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onClick_btnTsuika(DBC4000011MainDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).追加する();
        return ResponseData.of(div).setState(DBC4000011StateName.追加状態);
    }

    /**
     * 修正するのメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onSelect_Update(DBC4000011MainDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        KaigoServiceNaiyouHolder holder = ViewStateHolder.get(ViewStateKeys.介護サービス内容データ, KaigoServiceNaiyouHolder.class);
        KaigoServiceNaiyouIdentifier identifier = getHandler(div).修正する(holder);
        if (identifier != null) {
            ViewStateHolder.put(ViewStateKeys.介護サービス内容データID, identifier);
        }
        return ResponseData.of(div).setState(DBC4000011StateName.修正状態);
    }

    /**
     * 削除するのメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onSelect_Delete(DBC4000011MainDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        KaigoServiceNaiyouHolder holder = ViewStateHolder.get(ViewStateKeys.介護サービス内容データ, KaigoServiceNaiyouHolder.class);
        KaigoServiceNaiyouIdentifier identifier = getHandler(div).削除する(holder);
        if (identifier != null) {
            ViewStateHolder.put(ViewStateKeys.介護サービス内容データID, identifier);
        }
        return ResponseData.of(div).setState(DBC4000011StateName.削除状態);
    }

    /**
     * サービス内容一覧選択のメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onSelect_dgService(DBC4000011MainDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (!検索.equals(状態)) {
            return ResponseData.of(div).respond();
        }
        KaigoServiceNaiyouHolder holder = ViewStateHolder.get(ViewStateKeys.介護サービス内容データ, KaigoServiceNaiyouHolder.class);
        getHandler(div).サービス内容一覧選択(holder);
        return ResponseData.of(div).respond();
    }

    /**
     * 入力をやめるのメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onClick_btnCancel(DBC4000011MainDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (削除.equals(状態)) {
            getHandler(div).入力をやめる();
            ViewStateHolder.put(ViewStateKeys.状態, 検索);
            return ResponseData.of(div).setState(DBC4000011StateName.検索結果表示状態);
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).入力をやめる();
            ViewStateHolder.put(ViewStateKeys.状態, 検索);
            return ResponseData.of(div).setState(DBC4000011StateName.検索結果表示状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するのメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onClick_btnResearch(DBC4000011MainDiv div) {
        DBC4000011MainHandler handle = getHandler(div);
        handle.初期状態返る();
        handle.前排他を解除する();
        return ResponseData.of(div).setState(DBC4000011StateName.初期状態);
    }

    /**
     * 定率／定額区分のメソッドです。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onChange_radTeiritsuOrTeigaku(DBC4000011MainDiv div) {
        DBC4000011MainHandler handle = getHandler(div);
        handle.定率定額区分選択();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onSelect_Save(
            DBC4000011MainDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (登録.equals(状態)) {
            DBC4000011MainValidationHandler validationHander = getValidationHandler(div);
            ValidationMessageControlPairs pairs = validationHander.validate();
            if (pairs.iterator().hasNext() && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            if (削除.equals(状態)) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            } else {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            KaigoServiceNaiyouHolder holder = ViewStateHolder.get(ViewStateKeys.介護サービス内容データ, KaigoServiceNaiyouHolder.class);
            KaigoServiceNaiyouIdentifier identifier = ViewStateHolder.get(ViewStateKeys.介護サービス内容データID, KaigoServiceNaiyouIdentifier.class);
            getHandler(div).保存する(holder, 状態, identifier);
            RString messageTaisho1 = MESSAGETAISHO1.concat(div.getKensakuJoken().getCcdServiceCdInput().getサービスコード1())
                    .concat(div.getKensakuJoken().getCcdServiceCdInput().getサービスコード2());
            RString messageTaisho2 = MESSAGETAISHO2.concat(div.getServiceShosai().getTxtServiceMeisho().getValue());
            div.getCcdKanryoMsg().setSuccessMessage(MESSAGEMAIN, messageTaisho1, messageTaisho2);
            getHandler(div).前排他を解除する();
            return ResponseData.of(div).setState(DBC4000011StateName.完了状態);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「サービス種類登録に戻る」ボタンの処理です。
     *
     * @param div DBC4000011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onSelect_Return(
            DBC4000011MainDiv div) {
        getHandler(div).初期状態返る();
        return ResponseData.of(div).setState(DBC4000011StateName.初期状態);
    }

    /**
     * 「完了する」ボタンの処理です。
     *
     * @param div div
     * @return ResponseData
     */
    public ResponseData<DBC4000011MainDiv> onSelect_Compelete(
            DBC4000011MainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC4000011TransitionEventName.処理完了).respond();
    }

    private DBC4000011MainHandler getHandler(DBC4000011MainDiv div) {
        return new DBC4000011MainHandler(div);
    }

    private DBC4000011MainValidationHandler getValidationHandler(DBC4000011MainDiv div) {
        return new DBC4000011MainValidationHandler(div);
    }

}
