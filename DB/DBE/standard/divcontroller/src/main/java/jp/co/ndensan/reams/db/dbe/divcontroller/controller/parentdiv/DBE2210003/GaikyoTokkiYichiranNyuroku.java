/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2210003;

import java.util.HashMap;
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
     * 「前へ」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBeforeTokkiJiko(GaikyoTokkiYichiranNyurokuDiv div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
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
        getHandler(div).onClick_btnAfterTokkiJiko(temp_申請書管理番号);

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号1 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo1(GaikyoTokkiYichiranNyurokuDiv div) {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY1);

        div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo()));

        if ((gaikyoTokkiNyurokuMap.get(key) != null)
                && gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onBlur_ChosaKomokuNo1();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号2 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo2(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY2);

        div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo()));

        if ((gaikyoTokkiNyurokuMap.get(key) != null)
                && gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onBlur_ChosaKomokuNo2();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号3 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo3(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY3);

        div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo()));

        if ((gaikyoTokkiNyurokuMap.get(key) != null)
                && gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onBlur_ChosaKomokuNo3();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号4 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo4(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY4);

        div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo()));

        if ((gaikyoTokkiNyurokuMap.get(key) != null)
                && gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onBlur_ChosaKomokuNo4();

        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項番号5 lostfocus。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBlur_ChosaKomokuNo5(GaikyoTokkiYichiranNyurokuDiv div) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        RString key = getKey(div, KEY5);

        div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setValue(
                getHandler(div).to認定調査特記事項番号_表示Form(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo()));

        if ((gaikyoTokkiNyurokuMap.get(key) != null)
                && gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号()
                .equals(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue())) {
            return ResponseData.of(div).respond();
        }

        ValidationMessageControlPairs validationMessages
                = onBlur_ChosaKomokuNoCheck(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());

        if (validationMessages.iterator().hasNext()) {
            this.値回復(gaikyoTokkiNyurokuMap, key, div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        getHandler(div).onBlur_ChosaKomokuNo5();

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
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnFirstImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> map = new HashMap<>();
        map.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());
        map.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenFirstTokkiJiko());

        RString 調査項目番号 = getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo());

        TextMaskingDataModel model = new TextMaskingDataModel();
        model.set調査項目番号(調査項目番号);
        model.set調査項目名称(div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getValue());
        model.set特記連番(div.getTokkiNyuryoku().getTxtFirstTokkiRenban().getValue().intValue());
        model.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        model.set特記事項_マッピング(map);
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFirstImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        if (!div.getTokkiNyuryoku().getHiddenFirstTokkiJiko().equals(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()))) {
            getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY1), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        }
        div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン2押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnSecondImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> map = new HashMap<>();
        map.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());
        map.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenSecondTokkiJiko());

        RString 調査項目番号 = getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo());

        TextMaskingDataModel model = new TextMaskingDataModel();
        model.set調査項目番号(調査項目番号);
        model.set調査項目名称(div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getValue());
        model.set特記連番(div.getTokkiNyuryoku().getTxtSecondTokkiRenban().getValue().intValue());
        model.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        model.set特記事項_マッピング(map);
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnSecondImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        if (!div.getTokkiNyuryoku().getHiddenSecondTokkiJiko().equals(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()))) {
            getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY2), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        }
        div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン3押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnThirdImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> map = new HashMap<>();
        map.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());
        map.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenThirdTokkiJiko());

        RString 調査項目番号 = getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo());

        TextMaskingDataModel model = new TextMaskingDataModel();
        model.set調査項目番号(調査項目番号);
        model.set調査項目名称(div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getValue());
        model.set特記連番(div.getTokkiNyuryoku().getTxtThirdTokkiRenban().getValue().intValue());
        model.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        model.set特記事項_マッピング(map);
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnThirdImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        if (!div.getTokkiNyuryoku().getHiddenThirdTokkiJiko().equals(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()))) {
            getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY3), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        }
        div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン4押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnFourthImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> map = new HashMap<>();
        map.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());
        map.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenFourthTokkiJiko());

        RString 調査項目番号 = getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo());

        TextMaskingDataModel model = new TextMaskingDataModel();
        model.set調査項目番号(調査項目番号);
        model.set調査項目名称(div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().getValue());
        model.set特記連番(div.getTokkiNyuryoku().getTxtFourthTokkiRenban().getValue().intValue());
        model.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        model.set特記事項_マッピング(map);
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFourthImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        if (!div.getTokkiNyuryoku().getHiddenFourthTokkiJiko().equals(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()))) {
            getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY4), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        }
        div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        return ResponseData.of(div).respond();
    }

    /**
     * マスクダイアログボタン5押下後、マスキングダイアログが開かれる前のイベントメソッドです。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onBeforeOpenDialog_btnFifthImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        Map<RString, RString> map = new HashMap<>();
        map.put(GenponMaskKubun.原本.getコード(), div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());
        map.put(GenponMaskKubun.マスク.getコード(), div.getTokkiNyuryoku().getHiddenFifthTokkiJiko());

        RString 調査項目番号 = getHandler(div).to認定調査特記事項番号_マスキングForm(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo());

        TextMaskingDataModel model = new TextMaskingDataModel();
        model.set調査項目番号(調査項目番号);
        model.set調査項目名称(div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().getValue());
        model.set特記連番(div.getTokkiNyuryoku().getTxtFifthTokkiRenban().getValue().intValue());
        model.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        model.set特記事項_マッピング(map);
        div.getTokkiNyuryoku().setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * テキストマスキングDivにて保存ボタンを押下した際に動作するメソッドです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onOkClose_btnFifthImageMasking(GaikyoTokkiYichiranNyurokuDiv div) {
        TextMaskingDataModel model = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHdnTextMasking(), TextMaskingDataModel.class);
        if (!div.getTokkiNyuryoku().getHiddenFifthTokkiJiko().equals(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()))) {
            getHandler(div).changeHiddenTokkiJiko(getKey(div, KEY5), model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
        }
        div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(model.get特記事項_マッピング().get(GenponMaskKubun.マスク.getコード()));
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
        
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項(
                    getKey(div, KEY1), div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setValue(getHandler(div).get変更前特記事項(getKey(div, KEY1)));
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY1), div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());

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
        
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項(
                    getKey(div, KEY2), div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setValue(getHandler(div).get変更前特記事項(getKey(div, KEY2)));
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY2), div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());

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
        
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項(
                    getKey(div, KEY3), div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setValue(getHandler(div).get変更前特記事項(getKey(div, KEY3)));
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY3), div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());

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
        
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項(
                    getKey(div, KEY4), div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setValue(getHandler(div).get変更前特記事項(getKey(div, KEY4)));
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY4), div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());

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
        
        if (!ResponseHolder.isReRequest()) {
            ErrorMessage message = getHandler(div).checkChange特記事項(
                    getKey(div, KEY5), div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());
            if (message.evaluate() != null) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (new RString(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setValue(getHandler(div).get変更前特記事項(getKey(div, KEY5)));
            return ResponseData.of(div).respond();
        }

        if (div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue().isEmpty()) {
            div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(RString.EMPTY);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(false);
        }
        getHandler(div).tokkiJikoHasChanged(getKey(div, KEY5), div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());

        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンの操作処理を行う。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_btnBack(GaikyoTokkiYichiranNyurokuDiv div) {

        boolean notEmpty = getHandler(div).onClick_btnBack();

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
        return ResponseData.of(div).respond();
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

    /**
     * 「特記事項を保存する」ボタンの操作処理を行う。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     * @return ResponseData<GaikyoTokkiNyurokuDiv>
     */
    public ResponseData<GaikyoTokkiYichiranNyurokuDiv> onClick_Save(GaikyoTokkiYichiranNyurokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
            getHandler(div).onClick_Save(temp_申請書管理番号, temp_認定調査履歴番号);
            前排他キーの解除();
            InformationMessage message = new InformationMessage(UrInformationMessages.正常終了.getMessage().getCode(),
                    UrInformationMessages.正常終了.getMessage().replace("保存").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrInformationMessages.正常終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            this.onLoad(div);
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

    private GaikyoTokkiYichiranNyurokuHandler getHandler(GaikyoTokkiYichiranNyurokuDiv div) {
        return new GaikyoTokkiYichiranNyurokuHandler(div);
    }

    private RString getKey(GaikyoTokkiYichiranNyurokuDiv div, RString key) {
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        return new RString(String.valueOf(当前ページ数).concat(key.toString()));
    }

}
