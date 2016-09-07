/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2710011;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011StateName.結果確認;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011TransitionEventName.再検索する;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011TransitionEventName.検索結果一覧へ;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.DBB2710011TransitionEventName.終了する;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.KaigoAtenaJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710011.KaigoAtenaJohoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 特別徴収対象者登録情報Divを制御します。
 *
 * @reamsid_L DBB-0670-010 wangjie2
 */
public class KaigoAtenaJoho {

    private final RString 検索結果一覧へ_FileName = new RString("btnToSearchResult");

    /**
     * 特別徴収対象者登録情報を画面初期化処理しました。
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onload(KaigoAtenaJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            InformationMessage message = new InformationMessage(
                    DbbErrorMessages.特徴対象者でないため処理不可.getMessage().getCode(),
                    DbbErrorMessages.特徴対象者でないため処理不可.getMessage().evaluate());
            FukaTaishoshaKey key = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
            Boolean is経由該当者一覧画面 = ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class);
            if (is経由該当者一覧画面 != null && !is経由該当者一覧画面) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(検索結果一覧へ_FileName, true);
            }
            return getHandler(div).onload(key) ? ResponseData.of(div).addMessage(message).respond() : ResponseData.of(div).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(DbbErrorMessages.特徴対象者でないため処理不可.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 特別徴収対象者登録を「年金情報を検索する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnNenkinInfoKensaku(KaigoAtenaJohoDiv div) {
        FukaTaishoshaKey key = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
        getHandler(div).onClick_btnNenkinInfoKensaku(key);
        return ResponseData.of(div).respond();
    }

    /**
     * 「年金コード」フォーカスロスト処理する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> lostFocus(KaigoAtenaJohoDiv div) {
        getHandler(div).lostFocus();
        return ResponseData.of(div).respond();
    }

    /**
     * 特別徴収対象者登録を「関連付を削除する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnKanrenTsukeSakujo(KaigoAtenaJohoDiv div) {
        getHandler(div).onClick_btnKanrenTsukeSakujo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特別徴収対象者登録を「検索結果一覧へ」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnToSearchResult(KaigoAtenaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(検索結果一覧へ).respond();
    }

    /**
     * 特別徴収対象者登録を「再検索する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnReSearch(KaigoAtenaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(再検索する).respond();
    }

    /**
     * 特別徴収対象者登録を「終了する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnComplete(KaigoAtenaJohoDiv div) {
        return ResponseData.of(div).forwardWithEventName(終了する).respond();
    }

    /**
     * 特別徴収対象者登録を「保存する」を押下する。<br/>
     *
     * @param div {@link KaigoAtenaJohoDiv 特別徴収対象者登録情報Div}
     * @return 特別徴収対象者登録情報Divを持つResponseData
     */
    public ResponseData<KaigoAtenaJohoDiv> onClick_btnUpdate(KaigoAtenaJohoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            KaigoAtenaJohoHandler handler = getHandler(div);
            if (!handler.is画面内容の変更有無()) {
                throw new ApplicationException(DbzInformationMessages.内容変更なしで保存不可.getMessage());
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.保存の確認.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            FukaTaishoshaKey key = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
            getHandler(div).onClick_btnUpdate(key);
            return ResponseData.of(div).setState(結果確認);
        }
        return ResponseData.of(div).respond();
    }

    private KaigoAtenaJohoHandler getHandler(KaigoAtenaJohoDiv div) {
        return new KaigoAtenaJohoHandler(div);
    }

}
