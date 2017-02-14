/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2210003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.textmasking.TextMaskingDataModel;
import jp.co.ndensan.reams.db.dbe.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.DBE2210003TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003.ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査結果登録3のクラス。
 *
 * @reamsid_L DBE-0040-030 huangh
 */
public class GaikyoTokkiYichiranNyuroku {

    private HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> gaikyoTokkiNyurokuMap = new HashMap<>();
    private int 当前ページ数 = 1;

    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");
    private static final RString KEY4 = new RString("4");
    private static final RString KEY5 = new RString("5");
    private static final RString DELETE = new RString("DELETE");

    private enum DBE2210003Keys {

        入力内容を取り消す用データ
    }

    /**
     * 認定調査結果登録3初期化の設定します。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onLoad(GaikyoTokkiYichiranNyurokuDiv div) {

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        model.set認定申請日(ViewStateHolder.get(ViewStateKeys.申請日, RString.class));
        model.set調査実施日(ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class));
        model.set調査実施場所(ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class));
        model.set実施場所名称(ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class));
        model.set所属機関コード(ViewStateHolder.get(ViewStateKeys.所属機関コード, RString.class));
        model.set所属機関名称(ViewStateHolder.get(ViewStateKeys.所属機関名称, RString.class));
        model.set記入者コード(ViewStateHolder.get(ViewStateKeys.記入者コード, RString.class));
        model.set記入者名称(ViewStateHolder.get(ViewStateKeys.記入者名称, RString.class));
        model.set調査区分(ViewStateHolder.get(ViewStateKeys.調査区分, RString.class));
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());

        gaikyoTokkiNyurokuMap = getHandler(div).onLoad(model, temp_申請書管理番号, temp_認定調査履歴番号);
        ViewStateHolder.put(DBE2210003Keys.入力内容を取り消す用データ, gaikyoTokkiNyurokuMap);
        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                    UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査結果登録3再表示の設定します。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onActive(GaikyoTokkiYichiranNyurokuDiv div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        model.set認定申請日(ViewStateHolder.get(ViewStateKeys.申請日, RString.class));
        model.set調査実施日(ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class));
        model.set調査実施場所(ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class));
        model.set実施場所名称(ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class));
        model.set所属機関コード(ViewStateHolder.get(ViewStateKeys.所属機関コード, RString.class));
        model.set所属機関名称(ViewStateHolder.get(ViewStateKeys.所属機関名称, RString.class));
        model.set記入者コード(ViewStateHolder.get(ViewStateKeys.記入者コード, RString.class));
        model.set記入者名称(ViewStateHolder.get(ViewStateKeys.記入者名称, RString.class));
        model.set調査区分(ViewStateHolder.get(ViewStateKeys.調査区分, RString.class));
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().intialize(model);
        div.getRenrakusakiKihon().setIsOpen(false);
        div.getChosaJisshisha().setIsOpen(false);
        getHandler(div).set特記事項最大文字数();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号1 のonChange処理です。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_ChosaKomokuNo1(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY1);

        div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo()));

        if (!getHandler(div).isChange特記事項番号(key, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項番号(key,
                    div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrErrorMessages.設定不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setValue(getHandler(div).get変更前特記事項番号(key));
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onChange_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onChange_ChosaKomokuNo1();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号2 のonChange処理です。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_ChosaKomokuNo2(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY2);

        div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo()));

        if (!getHandler(div).isChange特記事項番号(key, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項番号(key,
                    div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrErrorMessages.設定不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setValue(getHandler(div).get変更前特記事項番号(key));
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onChange_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onChange_ChosaKomokuNo2();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号3 のonChange処理です。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_ChosaKomokuNo3(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY3);

        div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo()));

        if (!getHandler(div).isChange特記事項番号(key, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項番号(key,
                    div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrErrorMessages.設定不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setValue(getHandler(div).get変更前特記事項番号(key));
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onChange_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onChange_ChosaKomokuNo3();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号4 のonChange処理です。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_ChosaKomokuNo4(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY4);

        div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo()));

        if (!getHandler(div).isChange特記事項番号(key, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項番号(key,
                    div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrErrorMessages.設定不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setValue(getHandler(div).get変更前特記事項番号(key));
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onChange_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onChange_ChosaKomokuNo4();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号5 のonChange処理です。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_ChosaKomokuNo5(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY5);

        div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo()));

        if (!getHandler(div).isChange特記事項番号(key, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項番号(key,
                    div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(UrErrorMessages.設定不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setValue(getHandler(div).get変更前特記事項番号(key));
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onChange_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onChange_ChosaKomokuNo5();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項１が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFirstTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnFirstMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnFirstMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY1), div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue());

        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().setDisabled(false);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項２が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtSecondTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnSecondMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnSecondMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY2), div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().getValue());

        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().setDisabled(false);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項３が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtThirdTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnThirdMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnThirdMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY3), div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue());

        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().setDisabled(false);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項４が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFourthTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnFourthMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnFourthMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY4), div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue());

        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().setDisabled(false);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項５が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFifthTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        if (div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnFifthMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnFifthMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY5), div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue());

        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().setDisabled(false);
        div.getTokkiNyuryoku().getBtnAfterTokkiJiko().setDisabled(false);

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項１の削除チェックボックスの値が変更した際の処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_chkFirstChosaDelete(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange削除(getKey(div, KEY1),
                    !div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().getSelectedItems().isEmpty());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<RString> arrayList = new ArrayList<>();
            if (div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().getSelectedItems().isEmpty()) {
                arrayList.add(new RString("0"));
            }
            div.getTokkiNyuryoku().getChkFirstChosaDelete().setSelectedItemsByKey(arrayList);
            return ResponseData.of(div).respond();
        }
        if (div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().getSelectedItems().isEmpty()) {
            getHandler(div).setDeleteFlag(getKey(div, KEY1), false);
            getHandler(div).setDisabledTokkiNyuryoku_First(false);
        } else {
            getHandler(div).setDeleteFlag(getKey(div, KEY1), true);
            getHandler(div).setDisabledTokkiNyuryoku_First(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項２の削除チェックボックスの値が変更した際の処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_chkSecondChosaDelete(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange削除(getKey(div, KEY2),
                    !div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().getSelectedItems().isEmpty());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<RString> arrayList = new ArrayList<>();
            if (div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().getSelectedItems().isEmpty()) {
                arrayList.add(new RString("0"));
            }
            div.getTokkiNyuryoku().getChkSecondChosaDelete().setSelectedItemsByKey(arrayList);
            return ResponseData.of(div).respond();
        }
        if (div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().getSelectedItems().isEmpty()) {
            getHandler(div).setDeleteFlag(getKey(div, KEY2), false);
            getHandler(div).setDisabledTokkiNyuryoku_Second(false);
        } else {
            getHandler(div).setDeleteFlag(getKey(div, KEY2), true);
            getHandler(div).setDisabledTokkiNyuryoku_Second(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項３の削除チェックボックスの値が変更した際の処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_chkThirdChosaDelete(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange削除(getKey(div, KEY3),
                    !div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().getSelectedItems().isEmpty());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<RString> arrayList = new ArrayList<>();
            if (div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().getSelectedItems().isEmpty()) {
                arrayList.add(new RString("0"));
            }
            div.getTokkiNyuryoku().getChkThirdChosaDelete().setSelectedItemsByKey(arrayList);
            return ResponseData.of(div).respond();
        }
        if (div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().getSelectedItems().isEmpty()) {
            getHandler(div).setDeleteFlag(getKey(div, KEY3), false);
            getHandler(div).setDisabledTokkiNyuryoku_Third(false);
        } else {
            getHandler(div).setDeleteFlag(getKey(div, KEY3), true);
            getHandler(div).setDisabledTokkiNyuryoku_Third(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項４の削除チェックボックスの値が変更した際の処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_chkFourthChosaDelete(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange削除(getKey(div, KEY4),
                    !div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().getSelectedItems().isEmpty());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<RString> arrayList = new ArrayList<>();
            if (div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().getSelectedItems().isEmpty()) {
                arrayList.add(new RString("0"));
            }
            div.getTokkiNyuryoku().getChkFourthChosaDelete().setSelectedItemsByKey(arrayList);
            return ResponseData.of(div).respond();
        }
        if (div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().getSelectedItems().isEmpty()) {
            getHandler(div).setDeleteFlag(getKey(div, KEY4), false);
            getHandler(div).setDisabledTokkiNyuryoku_Fourth(false);
        } else {
            getHandler(div).setDeleteFlag(getKey(div, KEY4), true);
            getHandler(div).setDisabledTokkiNyuryoku_Fourth(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項５の削除チェックボックスの値が変更した際の処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_chkFifthChosaDelete(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange削除(getKey(div, KEY5),
                    !div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().getSelectedItems().isEmpty());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            List<RString> arrayList = new ArrayList<>();
            if (div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().getSelectedItems().isEmpty()) {
                arrayList.add(new RString("0"));
            }
            div.getTokkiNyuryoku().getChkFifthChosaDelete().setSelectedItemsByKey(arrayList);
            return ResponseData.of(div).respond();
        }
        if (div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().getSelectedItems().isEmpty()) {
            getHandler(div).setDeleteFlag(getKey(div, KEY5), false);
            getHandler(div).setDisabledTokkiNyuryoku_Fifth(false);
        } else {
            getHandler(div).setDeleteFlag(getKey(div, KEY5), true);
            getHandler(div).setDisabledTokkiNyuryoku_Fifth(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_setDialogParameter(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.getTokkiNyuryoku().setHidden登録グループコード(SampleBunshoGroupCodes.調査票調査項目特記事項.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン１をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFirstTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().getTxtFirstTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY1), div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン２をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnSecondTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY2), div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン３をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnThirdTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY3), div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン４をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFourthTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY4), div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン５をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFifthTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY5), div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン1押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnFirstMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> mapTokki = new HashMap<>();
        mapTokki.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());
        mapTokki.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenFirstTokkiJiko());
        Map<RString, Boolean> mapDelete = new HashMap<>();
        mapDelete.put(GenponMaskKubun.原本.getコード(), !div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().getSelectedItems().isEmpty());
        mapDelete.put(GenponMaskKubun.マスク.getコード(), !RString.isNullOrEmpty(div.getTokkiNyuryoku().getHiddenIsDeleteFirstTokki()));

        TextMaskingDataModel model = new TextMaskingDataModel();
        setTextMaskingDataModel(
                div,
                model,
                getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo()),
                div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getValue(),
                div.getTokkiNyuryoku().getTxtFirstTokkiRenban().getValue().intValue(),
                TokkijikoTextImageKubun.テキスト.getコード(),
                mapTokki,
                mapDelete,
                KEY1
        );
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン2押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnSecondMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> mapTokki = new HashMap<>();
        mapTokki.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());
        mapTokki.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenSecondTokkiJiko());
        Map<RString, Boolean> mapDelete = new HashMap<>();
        mapDelete.put(GenponMaskKubun.原本.getコード(), !div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().getSelectedItems().isEmpty());
        mapDelete.put(GenponMaskKubun.マスク.getコード(), !RString.isNullOrEmpty(div.getTokkiNyuryoku().getHiddenIsDeleteSecondTokki()));

        TextMaskingDataModel model = new TextMaskingDataModel();
        setTextMaskingDataModel(
                div,
                model,
                getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo()),
                div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getValue(),
                div.getTokkiNyuryoku().getTxtSecondTokkiRenban().getValue().intValue(),
                TokkijikoTextImageKubun.テキスト.getコード(),
                mapTokki,
                mapDelete,
                KEY2
        );
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン3押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnThirdMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> mapTokki = new HashMap<>();
        mapTokki.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());
        mapTokki.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenThirdTokkiJiko());
        Map<RString, Boolean> mapDelete = new HashMap<>();
        mapDelete.put(GenponMaskKubun.原本.getコード(), !div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().getSelectedItems().isEmpty());
        mapDelete.put(GenponMaskKubun.マスク.getコード(), !RString.isNullOrEmpty(div.getTokkiNyuryoku().getHiddenIsDeleteThirdTokki()));

        TextMaskingDataModel model = new TextMaskingDataModel();
        setTextMaskingDataModel(
                div,
                model,
                getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo()),
                div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getValue(),
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().getValue().intValue(),
                TokkijikoTextImageKubun.テキスト.getコード(),
                mapTokki,
                mapDelete,
                KEY3
        );
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン4押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnFourthMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> mapTokki = new HashMap<>();
        mapTokki.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());
        mapTokki.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenFourthTokkiJiko());
        Map<RString, Boolean> mapDelete = new HashMap<>();
        mapDelete.put(GenponMaskKubun.原本.getコード(), !div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().getSelectedItems().isEmpty());
        mapDelete.put(GenponMaskKubun.マスク.getコード(), !RString.isNullOrEmpty(div.getTokkiNyuryoku().getHiddenIsDeleteFourthTokki()));

        TextMaskingDataModel model = new TextMaskingDataModel();
        setTextMaskingDataModel(
                div,
                model,
                getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo()),
                div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().getValue(),
                div.getTokkiNyuryoku().getTxtFourthTokkiRenban().getValue().intValue(),
                TokkijikoTextImageKubun.テキスト.getコード(),
                mapTokki,
                mapDelete,
                KEY4
        );
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン5押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnFifthMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> mapTokki = new HashMap<>();
        mapTokki.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());
        mapTokki.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenFifthTokkiJiko());
        Map<RString, Boolean> mapDelete = new HashMap<>();
        mapDelete.put(GenponMaskKubun.原本.getコード(), !div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().getSelectedItems().isEmpty());
        mapDelete.put(GenponMaskKubun.マスク.getコード(), !RString.isNullOrEmpty(div.getTokkiNyuryoku().getHiddenIsDeleteFifthTokki()));

        TextMaskingDataModel model = new TextMaskingDataModel();
        setTextMaskingDataModel(
                div,
                model,
                getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo()),
                div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().getValue(),
                div.getTokkiNyuryoku().getTxtFifthTokkiRenban().getValue().intValue(),
                TokkijikoTextImageKubun.テキスト.getコード(),
                mapTokki,
                mapDelete,
                KEY5
        );
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFirstMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY1), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()),
                model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード()));
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getLblFirstMaskExist().setDisplayNone(false);
        div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        if (model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード())) {
            div.getTokkiNyuryoku().setHiddenIsDeleteFirstTokki(DELETE);
        } else {
            div.getTokkiNyuryoku().setHiddenIsDeleteFirstTokki(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnSecondMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY2), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()),
                model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード()));
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getLblSecondMaskExist().setDisplayNone(false);
        div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        if (model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード())) {
            div.getTokkiNyuryoku().setHiddenIsDeleteSecondTokki(DELETE);
        } else {
            div.getTokkiNyuryoku().setHiddenIsDeleteSecondTokki(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnThirdMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY3), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()),
                model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード()));
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getLblThirdMaskExist().setDisplayNone(false);
        div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        if (model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード())) {
            div.getTokkiNyuryoku().setHiddenIsDeleteThirdTokki(DELETE);
        } else {
            div.getTokkiNyuryoku().setHiddenIsDeleteThirdTokki(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFourthMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY4), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()),
                model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード()));
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getLblFourthMaskExist().setDisplayNone(false);
        div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        if (model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード())) {
            div.getTokkiNyuryoku().setHiddenIsDeleteFourthTokki(DELETE);
        } else {
            div.getTokkiNyuryoku().setHiddenIsDeleteFourthTokki(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFifthMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY5), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()),
                model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード()));
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getLblFifthMaskExist().setDisplayNone(false);
        div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        if (model.get削除_マッピング().get(GenponMaskKubun.マスク.getコード())) {
            div.getTokkiNyuryoku().setHiddenIsDeleteFifthTokki(DELETE);
        } else {
            div.getTokkiNyuryoku().setHiddenIsDeleteFifthTokki(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「前へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBeforeTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ValidationMessageControlPairs pairs = getValidationMessageControl(div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).onClick_btnBeforeTokkiJiko(temp_申請書管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「次へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnAfterTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ValidationMessageControlPairs pairs = getValidationMessageControl(div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).onClick_btnAfterTokkiJiko(temp_申請書管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンの操作処理を行う。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBack(GaikyoTokkiYichiranNyurokuDiv div) {
        前排他キーの解除();
        ValidationMessageControlPairs pairs = getValidationMessageControl(div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        ViewStateHolder.put(ViewStateKeys.特記事項一覧, 
                DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class));
        ViewStateHolder.put(ViewStateKeys.特記事項マスク一覧, 
                DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class));
        return ResponseData.of(div).forwardWithEventName(DBE2210003TransitionEventName.認定調査結果登録に戻る).respond();
    }

    /**
     * 入力内容を取り消します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnCancel(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            getHandler(div).onClick_btnCancel(temp_申請書管理番号);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void setTextMaskingDataModel(GaikyoTokkiYichiranNyurokuDiv div,
            TextMaskingDataModel model,
            RString 調査項目番号,
            RString 調査項目名称,
            int 特記事項連番,
            RString 特記事項テキストイメージ区分,
            Map<RString, RString> map特記事項,
            Map<RString, Boolean> map削除,
            RString key) {
        model.set調査項目番号(調査項目番号);
        model.set調査項目名称(調査項目名称);
        model.set特記連番(特記事項連番);
        model.set特記事項テキスト_イメージ区分(特記事項テキストイメージ区分);
        model.set特記事項_マッピング(map特記事項);
        model.set削除_マッピング(map削除);
        model.setExistData(getHandler(div).isExistMaskData(getKey(div, key)));
    }

    private ValidationMessageControlPairs getValidationMessageControl(GaikyoTokkiYichiranNyurokuDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if ((!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().getSelectedItems().isEmpty())
                || (!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().getSelectedItems().isEmpty())) {
            getValidationHandler().validateFor特記事項1の必須入力(pairs, div);
        }
        if ((!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().getSelectedItems().isEmpty())
                || (!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().getSelectedItems().isEmpty())) {
            getValidationHandler().validateFor特記事項2の必須入力(pairs, div);
        }
        if ((!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().getSelectedItems().isEmpty())
                || (!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().getSelectedItems().isEmpty())) {
            getValidationHandler().validateFor特記事項3の必須入力(pairs, div);
        }
        if ((!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().getSelectedItems().isEmpty())
                || (!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().getSelectedItems().isEmpty())) {
            getValidationHandler().validateFor特記事項4の必須入力(pairs, div);
        }
        if ((!RString.isNullOrEmpty(div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue())
                && div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().getSelectedItems().isEmpty())) {
            getValidationHandler().validateFor特記事項5の必須入力(pairs, div);
        }
        return pairs;
    }

    private boolean 前排他キーのセット() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
                .concat(temp_申請書管理番号.getColumnValue()));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
                .concat(temp_申請書管理番号.getColumnValue()));
        RealInitialLocker.release(排他キー);
    }

    private ValidationMessageControlPairs onChange_ChosaKomokuNoCheck(
            HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> map,
            RString key,
            TextBox texBox) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationHandler handler = new ValidationHandler();

        handler.特記事項番号入力チェック(validationMessages, texBox);
        handler.既存同じ特記事項番号チェック(validationMessages, map, key, texBox);
        handler.連番最大値超過チェック(validationMessages, map, key, texBox);
        return validationMessages;
    }

    private void 値回復(
            HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> map,
            RString key,
            TextBox textBox) {

        if (map.get(key) != null) {
            textBox.setValue(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号());
        } else {
            textBox.clearValue();
        }
    }

    private GaikyoTokkiYichiranNyurokuHandler getHandler(GaikyoTokkiYichiranNyurokuDiv div) {
        return new GaikyoTokkiYichiranNyurokuHandler(div);
    }

    private ValidationHandler getValidationHandler() {
        return new ValidationHandler();
    }

    private RString getKey(GaikyoTokkiYichiranNyurokuDiv div, RString key) {
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        return new RString(String.valueOf(当前ページ数).concat(key.toString()));
    }

}
