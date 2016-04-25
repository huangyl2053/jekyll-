/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0310012;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice.KeiyakuServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.DBC0300012StateName.saved;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.DBC0310011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.DBC0310012TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310012.PnlTotalPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310012.PnlTotalPanelValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalSearchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310012.PnlTotalPanelParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_登録
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
public class PnlTotalPanel {

    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 参照 = new RString("参照");
    private static final RString 事業者検索 = new RString("事業者検索");
    private static final Decimal 一割 = new Decimal(0.1);
    private static final Decimal 九割 = new Decimal(0.9);
    private static final Decimal 番号_0 = new Decimal(0);
    private static final Decimal 番号_1 = new Decimal(1);

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
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        getHandler(div).createDropDownList();
        if (登録.equals(画面モード)) {
            div.getPnlCommon().getCcdAtena().setDisabled(true);
            div.getPnlCommon().getCcdKaigoShikakuKihon().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認しない.getコード());
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
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            if (識別コード != null || !識別コード.isEmpty()) {
                div.getPnlCommon().getCcdAtena().onLoad(識別コード);
            }
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            if (被保険者番号 != null || !被保険者番号.isEmpty()) {
                div.getPnlCommon().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
            }
            RString 表示モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
            if (事業者検索.equals(表示モード)) {
                PnlTotalPanelParameter param = ViewStateHolder
                        .get(ViewStateKeys.受領委任契約契約者詳細データ, PnlTotalPanelParameter.class);
                getHandler(div).set登録データ(param);
                JuryoininKeiyakuJigyosha data = ViewStateHolder
                        .get(ViewStateKeys.受領委任契約事業者詳細データ, JuryoininKeiyakuJigyosha.class);
                ViewStateHolder.put(ViewStateKeys.契約事業者番号, data.get契約事業者番号());
                ViewStateHolder.put(ViewStateKeys.契約事業者名, data.get契約事業者名称() == null
                        || data.get契約事業者名称().isEmpty() ? null : data.get契約事業者名称().getColumnValue());
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().setValue(data.get契約事業者番号());
                div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaName()
                        .setValue(data.get契約事業者名称() == null || data.get契約事業者名称().isEmpty() ? null
                                : data.get契約事業者名称().getColumnValue());
            }
        } else {
            PnlTotalSearchParameter parameter = ViewStateHolder.
                    get(ViewStateKeys.契約者一覧情報, PnlTotalSearchParameter.class);
            ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
            ShokanJuryoininKeiyakusha shokanData = finder.getShokanJuryoininKeiyakusha(
                    new HihokenshaNo(parameter.get被保番号()),
                    parameter.get契約申請日(),
                    parameter.get契約事業者番号(),
                    parameter.get契約サービス種類());
            if (shokanData == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            ViewStateHolder.put(ViewStateKeys.契約者一覧情報, shokanData);
            HihokenshaNo 被保険者番号 = new HihokenshaNo(parameter.get被保番号());
            div.getPnlCommon().getCcdKaigoShikakuKihon().onLoad(被保険者番号);

            getHandler(div).set初期データ状態(画面モード, shokanData);
            getHandler(div).set初期データ(shokanData, parameter);
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
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (登録.equals(画面モード)) {
            PnlTotalPanelParameter parameter = getHandler(div).createParameter();
            ViewStateHolder.put(ViewStateKeys.受領委任契約契約者詳細データ, parameter);
            ViewStateHolder.put(ViewStateKeys.表示モード, 事業者検索);
            ViewStateHolder.put(ViewStateKeys.状態, 参照);
            return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.事業者検索).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 契約サービス種類onChange
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onChange_ddlKeiyakuServiceType(PnlTotalPanelDiv div) {
        RString コード = div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey();
        if (KeiyakuServiceShurui.住宅改修.getコード().equals(コード)
                || KeiyakuServiceShurui.予防住宅改修.getコード().equals(コード)) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setValue(番号_0);
        } else if (KeiyakuServiceShurui.福祉用具.getコード().equals(コード)
                || KeiyakuServiceShurui.予防福祉用具.getコード().equals(コード)) {
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().setValue(番号_1);
        }
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
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認する.getコード());
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
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
            div.getPnlCommon().getPnlDetail().getRdoKettekubun().setSelectedKey(ShoninKubun.承認する.getコード());
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
        if (ShoninKubun.承認する.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(true);
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().clearValue();
            div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtSyoninkikan().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlHidari().getChkSaihakoukubun().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHiyogakugokei().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().setDisabled(false);
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().setDisabled(false);
        } else if (ShoninKubun.承認しない.getコード().equals(div.getPnlCommon().getPnlDetail()
                .getRdoKettekubun().getSelectedKey())) {
            div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().setDisabled(false);
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
     * 保険対象費用額
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onBlur_txtHokentaisyohiyogaku(PnlTotalPanelDiv div) {
        Decimal 保険対象費用額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtHokentaisyohiyogaku().getValue();
        if (保険対象費用額 == null || 保険対象費用額 == Decimal.ZERO) {
            return ResponseData.of(div).respond();
        }
        Decimal 利用者自己負担額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi()
                .getTxtRiyosyajikofutangaku().getValue();
        Decimal 保険給付費用額 = div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku().getValue();
        if (利用者自己負担額 == null && 保険給付費用額 == null) {
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku()
                    .setValue(保険対象費用額.multiply(一割));
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                    .setValue(保険対象費用額.multiply(九割));
            if (少数点以下は切れ(保険対象費用額.multiply(一割)).add(少数点以下は切れ(保険対象費用額.multiply(九割)))
                    .compareTo(保険対象費用額) < 0) {
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                        .setValue(保険対象費用額.subtract(少数点以下は切れ(保険対象費用額.multiply(一割))));
            }
        } else if (利用者自己負担額 == null && 保険給付費用額 != null) {
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtRiyosyajikofutangaku()
                    .setValue(保険対象費用額.multiply(一割));
        } else if (利用者自己負担額 != null && 保険給付費用額 == null) {
            div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                    .setValue(保険対象費用額.multiply(九割));
            if (利用者自己負担額.add(少数点以下は切れ(保険対象費用額.multiply(九割))).compareTo(保険対象費用額) < 0) {
                div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokenkyufuhiyogaku()
                        .setValue(保険対象費用額.subtract(少数点以下は切れ(保険対象費用額.multiply(一割))));
            }
        }
        return ResponseData.of(div).respond();
    }

    private Decimal 少数点以下は切れ(Decimal decimal) {
        return new Decimal((int) Math.floor(decimal.doubleValue()));
    }

    /**
     * 「取消する」ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_btnCancel(PnlTotalPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (登録.equals(画面モード) || 修正.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).forwardWithEventName(DBC0310012TransitionEventName.検索に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBC0310012TransitionEventName.検索に戻る).respond();
    }

    /**
     * 「保存する」ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_btnUpdate(PnlTotalPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ValidationMessageControlPairs valid = getPnlTotalPanelValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        if (削除.equals(画面モード)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).保存処理(画面モード);
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
                getHandler(div).保存処理(画面モード);
            } else {
                return ResponseData.of(div).respond();
            }
        }
        div.getPnlMsgPrint().getCcdKanryoMessage()
                .setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(saved);
    }

    /**
     * 「発行する」ボタン
     *
     * @param div PnlTotalPanelDiv
     * @return ResponseData<PnlTotalPanelDiv>
     */
    public ResponseData<PnlTotalPanelDiv> onClick_btnPublish(PnlTotalPanelDiv div) {
        // TODO　QA No.474(Redmine#:79881)
        return ResponseData.of(div).respond();
    }
}
