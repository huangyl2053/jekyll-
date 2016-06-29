/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2210003;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.DBE2210003TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003.ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
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

    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;

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
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString 調査実施日 = ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class);
        RString 調査実施場所 = ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class);
        RString 実施場所名称 = ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class);
        RString 所属機関 = ViewStateHolder.get(ViewStateKeys.所属機関, RString.class);
        RString 記入者 = ViewStateHolder.get(ViewStateKeys.記入者, RString.class);
        RString 調査区分 = ViewStateHolder.get(ViewStateKeys.調査区分, RString.class);
        model.set調査実施日(調査実施日);
        model.set調査実施場所(調査実施場所);
        model.set実施場所名称(実施場所名称);
        model.set所属機関(所属機関);
        model.set記入者(記入者);
        model.set調査区分(調査区分);
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());

        gaikyoTokkiNyurokuMap = handler.onLoad(model, temp_申請書管理番号, temp_認定調査履歴番号);
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
     * 「前へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBeforeTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onClick_btnBeforeTokkiJiko();

        return ResponseData.of(div).respond();
    }

    /**
     * 「次へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnAfterTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        handler.onClick_btnAfterTokkiJiko();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号1 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo1(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));

        if ((gaikyoTokkiNyurokuMap.get(key1) != null)
                && gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key1, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key1, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        handler.onBlur_ChosaKomokuNo1();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号2 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo2(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));

        if ((gaikyoTokkiNyurokuMap.get(key2) != null)
                && gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key2, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key2, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        handler.onBlur_ChosaKomokuNo2();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号3 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo3(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));

        if ((gaikyoTokkiNyurokuMap.get(key3) != null)
                && gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key3, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key3, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        handler.onBlur_ChosaKomokuNo3();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号4 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo4(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));

        if ((gaikyoTokkiNyurokuMap.get(key4) != null)
                && gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key4, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key4, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        handler.onBlur_ChosaKomokuNo4();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号5 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo5(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        if ((gaikyoTokkiNyurokuMap.get(key5) != null)
                && gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key5, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key5, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        handler.onBlur_ChosaKomokuNo5();

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
        div.getTokkiNyuryoku().setHidden登録グループコード(new RString("1"));
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン１をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFirstTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtFirstTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(1, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン２をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnSecondTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(2, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン３をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnThirdTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(INT3, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン４をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFourthTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(INT4, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 定型文ボタン５をタップ。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFifthTokkiJikoTeikeibun(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setValue(div.getTokkiNyuryoku().getHiddenサンプル文書());
        handler.tokkiJikoHasChanged(INT5, div.getTokkiNyuryoku().getHiddenサンプル文書());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項１が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFirstTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        handler.tokkiJikoHasChanged(1, div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項２が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtSecondTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        handler.tokkiJikoHasChanged(2, div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項３が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtThirdTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        handler.tokkiJikoHasChanged(INT3, div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項４が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFourthTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        handler.tokkiJikoHasChanged(INT4, div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項５が変更した処理。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onChange_txtFifthTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }

        handler.tokkiJikoHasChanged(INT5, div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンの操作処理を行う。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBack(GaikyoTokkiYichiranNyurokuDiv div) {

        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        boolean notEmpty = handler.onClick_btnBack();

        if (!ResponseHolder.isReRequest() && (notEmpty)) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            前排他キーの解除();
            return ResponseData.of(div).forwardWithEventName(DBE2210003TransitionEventName.認定調査結果登録に戻る).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE2210003TransitionEventName.認定調査結果登録に戻る).respond();
    }

    /**
     * 入力内容を取り消します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnCancel(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            gaikyoTokkiNyurokuMap = ViewStateHolder.get(DBE2210003Keys.入力内容を取り消す用データ, HashMap.class);
            handler.onClick_btnCancel(gaikyoTokkiNyurokuMap);
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「特記事項を保存する」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_Save(GaikyoTokkiYichiranNyurokuDiv div) {
        GaikyoTokkiYichiranNyurokuHandler handler = new GaikyoTokkiYichiranNyurokuHandler(div);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
            handler.onClick_Save(temp_申請書管理番号, temp_認定調査履歴番号);
            前排他キーの解除();
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("保存")).respond();
        }
        return ResponseData.of(div).respond();
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

    private ValidationMessageControlPairs onBlur_ChosaKomokuNoCheck(
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
}
