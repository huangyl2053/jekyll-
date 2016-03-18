/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0310012;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.DBC0300011TransitionEventName;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012StateName.saved;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.DBC0310012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310012.PnlTotalPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310012.PnlTotalPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_登録
 */
public class PnlTotalPanel {

    private static final RString 参照 = new RString("参照");
    private static final RString 削除 = new RString("削除");
    private static final RString 修正 = new RString("修正");
    private static final RString 登録 = new RString("登録");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final Decimal 九割 = new Decimal(0.1);

    /**
     * コンストラクタです。
     *
     * @param div PnlTotalPanelDiv
     */
    private PnlTotalPanelHandler getHandler(PnlTotalPanelDiv div) {
        return PnlTotalPanelHandler.of(div);
    }

    private PnlTotalPanelValidationHandler getPnlTotalPanelValidationHandler(PnlTotalPanelDiv div) {
        return new PnlTotalPanelValidationHandler(div);
    }

    /**
     * 初期表示
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onLoad(PnlTotalPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        getHandler(div).createDropDownList();
        if (登録.equals(状態)) {
            div.getPnlCommon().getCcdKaigoShikakuKihon().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setSelectedKey(RString.EMPTY);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninchutisyosakuseibi().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtShikyuumukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtServiceYM().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlFoot().getTxtSyokanseriNo().setDisabled(true);
        } else {
            PnlTotalParameter parameter = ViewStateHolder.
                    get(ViewStateKeys.契約者一覧情報, PnlTotalParameter.class);
            ShokanJuryoininKeiyakushaFinder finder = InstanceProvider.create(ShokanJuryoininKeiyakushaFinder.class);
            ShokanJuryoininKeiyakusha shokanData = finder.getShokanJuryoininKeiyakusha(
                    new HihokenshaNo(parameter.get被保番号()),
                    parameter.get契約申請日(),
                    parameter.get契約事業者番号(),
                    parameter.get契約サービス種類());
            if (shokanData == null) {
                return ResponseData.of(div).addMessage(UrErrorMessages.該当データなし.getMessage()).respond();
            }
            ViewStateHolder.put(ViewStateKeys.契約者一覧情報, shokanData);
            HihokenshaNo 被保険者番号 = new HihokenshaNo(parameter.get被保番号());

            ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            div.getPnlCommon().getCcdAtena().onLoad(識別コード);
            div.getPnlCommon().getCcdKaigoShikakuKihon().onLoad(被保険者番号);

            getHandler(div).set初期データ状態(状態, shokanData.get受付年月日());
            getHandler(div).set初期データ(shokanData);
        }
        JuryoininKeiyakuJigyosha data = ViewStateHolder
                .get(ViewStateKeys.受領委任契約事業者詳細データ, JuryoininKeiyakuJigyosha.class);
        if (data != null) {
            div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().setValue(data.get契約事業者番号());
            div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName()
                    .setValue(new RString(data.get契約事業者名称().toString()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「契約事業者番号」テキストボックス
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onBlur_txtKeyakujigyosyaNo(PnlTotalPanelDiv div) {
        RString 契約事業者番号 = ViewStateHolder.get(ViewStateKeys.契約事業者番号, RString.class);
        RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
        if (契約事業者番号 != null) {
            if (契約事業者番号.equals(div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue())) {
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().setValue(契約事業者名);
            } else {
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 契約事業者検索ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_txtKeyakujigyosyaNo(PnlTotalPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (参照.equals(状態)) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0300011TransitionEventName.事業者選択).respond();
        }
    }

    /**
     * 契約サービス種類onChange
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onChange_ddlKeiyakuServiceType(PnlTotalPanelDiv div) {
        // TODO QA No.417
        div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setValue(new Decimal(1));
        return ResponseData.of(div).respond();
    }

    /**
     * 決定年月日
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onBlur_txtKeyakukettebi(PnlTotalPanelDiv div) {
        if (div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue() != null) {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(KEY_0);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(false);
        } else {
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setSelectedKey(RString.EMPTY);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearFromValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearToValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                    .setSelectedItemsByKey(new ArrayList<RString>());
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 決定区分
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_rdoKettekubun(PnlTotalPanelDiv div) {
        if (KEY_0.equals(div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey())) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(false);
        } else if (KEY_1.equals(div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey())) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保険対象費用額
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onBlur_txtHokentaisyohiyogaku(PnlTotalPanelDiv div) {
        Decimal 保険対象費用額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtHokentaisyohiyogaku().getValue();
        if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().getValue() != null) {
            // TODO QA No.430
            if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().getValue() == null) {
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku()
                        .setValue(保険対象費用額.multiply(new Decimal(1).subtract(九割)));
            } else if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                    .getValue() == null) {
                // TODO QA No.430
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku()
                        .setValue(保険対象費用額.multiply(九割));
            } else {
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setValue(
                        div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue()
                        .subtract(div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku()
                                .getValue()));
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消する」ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_btnCancel(PnlTotalPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            if (修正.equals(状態)) {
                div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().clearValue();
                div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().clearValue();
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().clearValue();
                div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().setSelectedKey(RString.EMPTY);
                div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().clearValue();
                // TODO QA No.430 RadioButtonの値がクリアできない
                div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
                div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setSelectedKey(RString.EMPTY);
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().clearValue();
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearFromValue();
                div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().clearToValue();
                div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun()
                        .setSelectedItemsByKey(new ArrayList<RString>());
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().clearValue();
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().clearValue();
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().clearValue();
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().clearValue();
            }
            return ResponseData.of(div).forwardWithEventName(DBC0310012TransitionEventName.検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_btnUpdate(PnlTotalPanelDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        ValidationMessageControlPairs valid = getPnlTotalPanelValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        if (削除.equals(状態)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).保存処理(状態);
            } else {
                return ResponseData.of(div).respond();
            }
            div.getPnlMsgPrint().getPnlPrint().setDisplayNone(true);
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).保存処理(状態);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        div.getPnlMsgPrint().getCcdKanryoMessage()
                .setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        return ResponseData.of(div).setState(saved);
    }

    /**
     * 「発行する」ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_btnPublish(PnlTotalPanelDiv div) {
        // TODO　QA No.
        return ResponseData.of(div).respond();
    }
}
