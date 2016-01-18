/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinInputGuideCommonChildDiv;

import jp.co.ndensan.reams.db.dbc.business.core.basic.FukushiyoguShohin;
import jp.co.ndensan.reams.db.dbc.business.core.basic.FukushiyoguShohinBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.FukushiyoguShohinIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogushohin.FukushiyoguShohinMode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide.FukushiyoguShohinGuideDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide.FukushiyoguShohinInputGuideHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide.ValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogushohin.FukushiyoguShohinInputGuideManager;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 福祉用具商品名入力ガイドの取得処理。
 */
public class FukushiyoguShohinGuide {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * 福祉用具商品名入力ガイド。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> initialize(FukushiyoguShohinGuideDiv fukuDiv) {
        createHandlerOf(fukuDiv).initialize();
        return createResponseData(fukuDiv);
    }

    /**
     * 検索ボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_Btnkennsaku(FukushiyoguShohinGuideDiv fukuDiv) {
        createHandlerOf(fukuDiv).kennsaku();
        fukuDiv.getPanInput().setVisible(false);
        fukuDiv.getPanInput().setState(RString.EMPTY);
        fukuDiv.getBtnSave().setVisible(false);
        return createResponseData(fukuDiv);
    }

    /**
     * 選択ボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_Btnsenntaku(FukushiyoguShohinGuideDiv fukuDiv) {
        FukushiyoguShohinMode mode = new FukushiyoguShohinMode();
        mode.setHinmokuCode(fukuDiv.getDgFukushiyoguShohin().getSelectedItems().get(0).getHinmokuCode());
        mode.setSeizoJigyoshamei(fukuDiv.getDgFukushiyoguShohin().getSelectedItems().get(0).getHinmokuCode());
        mode.setShohinmei(fukuDiv.getDgFukushiyoguShohin().getSelectedItems().get(0).getHinmokuCode());
        fukuDiv.setFukushiyoguShohinMode(DataPassingConverter.serialize(mode));
        return createResponseData(fukuDiv);
    }

    /**
     * 追加ボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDivfukuDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_TuyikaButton(FukushiyoguShohinGuideDiv fukuDiv) {
        ViewStateHolder.put(ViewStateKeys.状態, 追加);
        fukuDiv.getPanInput().setState(追加);
        fukuDiv.getPanInput().setVisible(true);
        fukuDiv.getBtnSave().setVisible(true);
        createHandlerOf(fukuDiv).状態の調整(追加);
        return createResponseData(fukuDiv);
    }

    /**
     * 修正ボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_ModifyButton(FukushiyoguShohinGuideDiv fukuDiv) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        fukuDiv.getPanInput().setState(修正);
        fukuDiv.getPanInput().setVisible(true);
        fukuDiv.getBtnSave().setVisible(true);
        createHandlerOf(fukuDiv).状態の調整(修正);
        return createResponseData(fukuDiv);
    }

    /**
     * 削除ボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_DeleteButton(FukushiyoguShohinGuideDiv fukuDiv) {
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        fukuDiv.getPanInput().setState(削除);
        fukuDiv.getPanInput().setVisible(true);
        fukuDiv.getBtnSave().setVisible(true);
        createHandlerOf(fukuDiv).状態の調整(削除);
        return createResponseData(fukuDiv);
    }

    /**
     * 保存ボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_btnUpdate(FukushiyoguShohinGuideDiv fukuDiv) {
        if (削除.equals(fukuDiv.getPanInput().getState())) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(fukuDiv).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                setfukushiyo(fukuDiv);
            }
        } else {
            ValidationMessageControlPairs validationMessageControlPairs = check_btnKakuninn(fukuDiv);
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(fukuDiv).addValidationMessages(validationMessageControlPairs).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(fukuDiv).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                setfukushiyo(fukuDiv);
            }
        }
        onClick_Btnkennsaku(fukuDiv);
        return createResponseData(fukuDiv);
    }

    public ValidationMessageControlPairs check_btnKakuninn(FukushiyoguShohinGuideDiv fukuDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        getValidationHandler(fukuDiv).管理日Fromの必須チェック(validationMessages);
        getValidationHandler(fukuDiv).商品名の必須チェック(validationMessages);
//        getValidationHandler(fukuDiv).管理日Fromと管理日Toの整合性チェック();
        return validationMessages;
    }
//
//    public void 管理日Fromの必須チェック(FukushiyoguShohinGuideDiv fukuDiv) {
//
//    }
//
//    public void 商品名の必須チェック(FukushiyoguShohinGuideDiv fukuDiv) {
//
//    }
//
//    public void 管理日Fromと管理日Toの整合性チェック(FukushiyoguShohinGuideDiv fukuDiv) {
//
//    }

    private void setfukushiyo(FukushiyoguShohinGuideDiv fukuDiv) {
        Models<FukushiyoguShohinIdentifier, FukushiyoguShohin> models = ViewStateHolder.get(ViewStateKeys.福祉用具商品名入力ガイド検索結果, Models.class);
        FukushiyoguShohinInputGuideManager fukushiManager = FukushiyoguShohinInputGuideManager.createInstance();
        if (追加.equals(fukuDiv.getPanInput().getState())) {
            FukushiyoguShohin fukushiyoguShohin = new FukushiyoguShohin(Saiban.get(SubGyomuCode.DBC介護給付,
                    SaibanHanyokeyName.商品番号.getコード()).nextString(),
                    new FlexibleDate(fukuDiv.getTxtKanriKaishiDay().getValue().toString()));
            FukushiyoguShohinBuilder builder = fukushiyoguShohin.createBuilderForEdit();
            if (fukuDiv.getTxtKanriShuryoDay().getValue() != null) {
                builder.set管理終了年月日(new FlexibleDate(fukuDiv.getTxtKanriShuryoDay().getValue().toString()));
            }
            builder.set商品名(nullToEmpty(fukuDiv.getTxtShohinmei().getValue()));
            builder.set製造事業者名(nullToEmpty(fukuDiv.getTxtSeizoJigyoshamei().getValue()));
            builder.set品目コード(nullToEmpty(fukuDiv.getTxtHinmokuCode().getValue()));
            fukushiyoguShohin = builder.build();
            fukushiyoguShohin.toEntity().setState(EntityDataState.Added);
            fukushiManager.saveOrDelete(fukushiyoguShohin);
        } else if (修正.equals(fukuDiv.getPanInput().getState())) {
            FukushiyoguShohinIdentifier key = new FukushiyoguShohinIdentifier(fukuDiv.getPanInput().getShohinNo(),
                    new FlexibleDate(fukuDiv.getTxtKanriKaishiDay().getValue().toString()));
            FukushiyoguShohin fukushiyoguShohin = models.get(key);
            FukushiyoguShohinBuilder builder = fukushiyoguShohin.createBuilderForEdit();
            if (fukuDiv.getTxtKanriShuryoDay() != null) {
                builder.set管理終了年月日(new FlexibleDate(fukuDiv.getTxtKanriShuryoDay().getValue().toString()));
            }
            builder.set商品名(nullToEmpty(fukuDiv.getTxtShohinmei().getValue()));
            builder.set製造事業者名(nullToEmpty(fukuDiv.getTxtSeizoJigyoshamei().getValue()));
            builder.set品目コード(nullToEmpty(fukuDiv.getTxtHinmokuCode().getValue()));
            fukushiyoguShohin = builder.build();
            fukushiyoguShohin.toEntity().setState(EntityDataState.Modified);
            fukushiManager.saveOrDelete(fukushiyoguShohin);
        } else if (削除.equals(fukuDiv.getPanInput().getState())) {
            FukushiyoguShohinIdentifier key = new FukushiyoguShohinIdentifier(fukuDiv.getPanInput().getShohinNo(),
                    new FlexibleDate(fukuDiv.getTxtKanriKaishiDay().getValue().toString()));
            FukushiyoguShohin fukushiyoguShohin = models.get(key);
            fukushiManager.saveOrDelete(fukushiyoguShohin.deleted());
        }

    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 閉じるボタン。<br/>
     *
     * @param fukuDiv FukushiyoguShohinGuideDiv
     * @return ResponseData<FukushiyoguShohinGuideDiv>
     */
    public ResponseData<FukushiyoguShohinGuideDiv> onClick_btnTorikeshi(FukushiyoguShohinGuideDiv fukuDiv) {
        if ((追加.equals(fukuDiv.getPanInput().getState())
                || 修正.equals(fukuDiv.getPanInput().getState()))
                || 削除.equals(fukuDiv.getPanInput().getState())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(fukuDiv).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            }
        }
        return ResponseData.of(fukuDiv).respond();
    }

    private FukushiyoguShohinInputGuideHandler createHandlerOf(FukushiyoguShohinGuideDiv fukuDiv) {
        return new FukushiyoguShohinInputGuideHandler(fukuDiv);
    }

    private ResponseData<FukushiyoguShohinGuideDiv> createResponseData(FukushiyoguShohinGuideDiv fukuDiv) {
        ResponseData<FukushiyoguShohinGuideDiv> response = new ResponseData();
        response.data = fukuDiv;
        return response;
    }

    private ValidationHandler getValidationHandler(FukushiyoguShohinGuideDiv div) {
        return new ValidationHandler(div);
    }
}
