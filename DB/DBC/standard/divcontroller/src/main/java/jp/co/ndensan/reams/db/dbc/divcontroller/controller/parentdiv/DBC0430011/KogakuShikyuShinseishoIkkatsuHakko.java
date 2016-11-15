/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0430011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020020.DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuShikyuValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.DBC0430011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額サービス費給付お知らせ通知書作成です。
 *
 * @reamsid_L DBC-4770-010 zhengshenlei
 */
public class KogakuShikyuShinseishoIkkatsuHakko {

    private static final RString メニューID_DBCMN43001 = new RString("DBCMN43001");
    private static final RString メニューID_DBCMNL3001 = new RString("DBCMNL3001");
    private static final RString 高額サービス費給付お知らせ通知書作成 = new RString("高額サービス費給付お知らせ通知書作成");
    private static final RString 事業高額サービス費給付お知らせ通知書作成 = new RString("事業高額サービス費給付お知らせ通知書作成");
    private static final RString 出力順 = new RString("出力順");
    private static final int INT_10 = 10;

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDivselectControlID
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onLoad(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        getHandler(div).initialize(menuID);
        if (メニューID_DBCMN43001.equals(menuID)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0430011StateName.NoChange).data)
                    .rootTitle(高額サービス費給付お知らせ通知書作成).respond();
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0430011StateName.NoChange).data)
                    .rootTitle(事業高額サービス費給付お知らせ通知書作成).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタン「審査年月RAD」のメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_shinsaYM(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setDisabled(false);
        div.getShinseishoHakkoParameters().getBtnHihokenshaSearch().setDisabled(true);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setDisabled(true);
        div.getShinseishoHakkoParameters().getRadHihokenshaNo().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHakushiInsatsu().clearSelectedItem();
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setDisabled(true);

        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタン「被保険者番号RAD」のメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_radHihokenshaNo(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setDisabled(true);
        div.getShinseishoHakkoParameters().getBtnHihokenshaSearch().setDisabled(false);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setDisabled(false);
        div.getShinseishoHakkoParameters().getRadShinsaYM().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHakushiInsatsu().clearSelectedItem();
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setDisabled(false);
        if (div.getShinseishoHakkoParameters().getTxtHihokenshaNo().getValue().isEmpty()) {
            div.getShinseishoHakkoParameters().getDdlServiceYM().getDataSource().clear();
        } else {
            RString menuID = ResponseHolder.getMenuID();
            getHandler(div).setサービス年月DDL(menuID);
            return isError(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタン「白紙印刷RAD」のメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_radHakushiInsatsu(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setDisabled(true);
        div.getShinseishoHakkoParameters().getBtnHihokenshaSearch().setDisabled(true);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setDisabled(true);
        div.getShinseishoHakkoParameters().getRadShinsaYM().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHihokenshaNo().clearSelectedItem();
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号入力ガイドonOkCloseのメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onOkClose(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        if (div.getShinseishoHakkoParameters().getTxtHihokenshaNo() != null) {
            getHandler(div).setサービス年月DDL(menuID);
            return isError(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号入力ガイドonOkCloseのメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> isError(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        if (div.getShinseishoHakkoParameters().getDdlServiceYM().getSelectedKey().equals(new RString("default"))
                || div.getShinseishoHakkoParameters().getDdlServiceYM().getDataSource().isEmpty()) {
            ValidationMessageControlPairs validPairs = getCheckHandler().確定チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号入力ガイドのメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onCancelClose(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号入力onBlurのメソッドです
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> txtHihokenshaNo_onBlur(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        if (div.getShinseishoHakkoParameters().getTxtHihokenshaNo() != null) {
            RString 被保険者番号入力 = div.getTxtHihokenshaNo().getValue();
            div.getTxtHihokenshaNo().setValue(被保険者番号入力.padZeroToLeft(INT_10));
            getHandler(div).setサービス年月DDL(menuID);
            return isError(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialogのメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onBeforeOpenDialog(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getCcdShuturyokujun().get出力順ID() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(
                            UrErrorMessages.未指定, 出力順.toString())));
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue().isEmpty() && !ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbcWarningMessages.申請書提出期限未入力.getMessage()).respond();
        }

        if (!div.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen().getValue().isEmpty() && !ResponseHolder.isReRequest()) {
            FlexibleDate 決定日 = div.getShinseishoHakkoParameters().getTxtKetteiDate().getValue();
            RString 決定日format = 決定日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).toDateString();
            return ResponseData.of(div).addMessage(DbcWarningMessages.自動償還確認.getMessage().replace(決定日format.toString())).respond();
        }

        if (new RString(DbcWarningMessages.申請書提出期限未入力.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }

        if (new RString(DbcWarningMessages.自動償還確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「確定処理を実行する（バッチ用）」ボタンのメソッドです。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter> onclick_btBatch(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter parameter = getHandler(div).createBatchParameter(menuID);
        return ResponseData.of(parameter).respond();
    }

    private KogakuShikyuShinseishoIkkatsuHakkoHandler getHandler(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        return new KogakuShikyuShinseishoIkkatsuHakkoHandler(div);
    }

    private KogakuShikyuValidationHandler getCheckHandler() {
        return new KogakuShikyuValidationHandler();
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
