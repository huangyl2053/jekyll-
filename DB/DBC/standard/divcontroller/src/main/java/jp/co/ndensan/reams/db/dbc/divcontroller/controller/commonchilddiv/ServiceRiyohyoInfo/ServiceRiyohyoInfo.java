/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.ServiceRiyohyoInfoDivHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.ServiceRiyohyoInfoDivValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * サービス利用票情報のコントローラです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfo {

    private static final RString RSTRING_ONE = new RString("1");
    private static final RString RSTRING_TWO = new RString("2");
    private static final RString プラス値入力不可 = new RString("単位：プラス値入力不可");
    private static final RString マイナス値入力不可 = new RString("単位：マイナス値入力不可");
    private static final RString RSTRING_17 = new RString("17");
    private static final RString RSTRING_67 = new RString("67");
    private static final RString RSTRING_88 = new RString("88");

    private static final Decimal DECIMAL_90 = new Decimal(90);
    private static final Decimal DECIMAL_80 = new Decimal(80);

    private ServiceRiyohyoInfoDivHandler getHandler(ServiceRiyohyoInfoDiv div) {
        return new ServiceRiyohyoInfoDivHandler(div);
    }

    /**
     * 「種類限度額確認」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnShowShuruiGendogaku(ServiceRiyohyoInfoDiv div) {
        RDate 利用年月 = div.getTxtRiyoYM().getValue();
        ViewStateHolder.put(ViewStateKeys.利用年月, 利用年月 == null ? null
                : new FlexibleYearMonth(利用年月.getYearMonth().toDateString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月の情報をコピーする」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnZengetsuCopy(ServiceRiyohyoInfoDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth 対象年月 = ViewStateHolder.get(ViewStateKeys.対象年月, FlexibleYearMonth.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        FlexibleYearMonth 利用年月 = new FlexibleYearMonth(div.getTxtRiyoYM().getValue().getYearMonth().toDateString());
        getHandler(div).setサービス利用票(被保険者番号, 対象年月, 履歴番号, 利用年月.minusMonth(1));
        return ResponseData.of(div).respond();
    }

    /**
     * 前月までの利用日数onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtZengetsuRiyoNissu(ServiceRiyohyoInfoDiv div) {
        getHandler(div).set累積利用日数();
        return ResponseData.of(div).respond();
    }

    /**
     * 当月の計画利用日数onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtTogetsuRiyoNissu(ServiceRiyohyoInfoDiv div) {
        getHandler(div).set累積利用日数();
        return ResponseData.of(div).respond();
    }

    /**
     * 「明細情報を追加する」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnBeppyoMeisaiNew(ServiceRiyohyoInfoDiv div) {
        ViewStateHolder.put(ViewStateKeys.選択有无, false);
        div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoMeisai().setDisplayNone(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtTani().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoTani().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtRiyoushaFutangaku().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getTxtTeigakuRiyoushaFutangaku().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setVisible(true);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput().setDisabled(false);
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei().setDisabled(false);
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoGokeiNew().setDisabled(false);
        ServiceRiyohyoInfoDivHandler handler = getHandler(div);
        handler.事業者サービスクリア();
        handler.明細情報クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 「合計情報を追加する」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnBeppyoGokeiNew(ServiceRiyohyoInfoDiv div) {
        ServiceRiyohyoInfoDivHandler handler = getHandler(div);
        handler.合計情報クリア();
        div.getBtnCalcGokei().setDisabled(false);
        ViewStateHolder.put(ViewStateKeys.選択有无, false);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RDate 利用年月日 = div.getTxtRiyoYM().getValue();
        FlexibleYearMonth 利用年月 = null;
        if (利用年月日 != null) {
            利用年月 = new FlexibleYearMonth(利用年月日.getYearMonth().toDateString());
        }
        handler.init合計情報追加(被保険者番号, 利用年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 明細・合計情報一覧の「選択」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnSelect(ServiceRiyohyoInfoDiv div) {
        ViewStateHolder.put(ViewStateKeys.選択有无, true);
        getHandler(div).setパネルにデータ反映();
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者コードのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onChange_txtJigyosha(ServiceRiyohyoInfoDiv div) {
        div.getCcdJigyoshaInput().get入所施設名称(new JigyoshaNo(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo()));
        div.getBtnBeppyoMeisaiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * サービス項目コードのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onChange_txtServiceEvent(ServiceRiyohyoInfoDiv div) {
        getHandler(div).onChange_txtServiceEvent();
        div.getBtnBeppyoMeisaiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「明細の計算」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnCalcMeisai(ServiceRiyohyoInfoDiv div) {
        ServiceRiyohyoInfoDivValidationHandler validationhandler = getValidatioHandler(div);
        ValidationMessageControlPairs 明細計算Pairs = validationhandler.validate明細計算();
        if (明細計算Pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(明細計算Pairs).respond();
        }
        ServiceRiyohyoInfoDivHandler handler = getHandler(div);
        RString 単位数判定 = handler.onBeforeClick_btnCalcMeisai();
        if (RSTRING_ONE.equals(単位数判定)) {
            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり
                    .getMessage().replace(プラス値入力不可.toString()));
        }
        if (RSTRING_TWO.equals(単位数判定)) {
            throw new ApplicationException(UrErrorMessages.入力値が不正_追加メッセージあり
                    .getMessage().replace(マイナス値入力不可.toString()));
        }
        handler.onClick_btnCalcMeisai();
        return ResponseData.of(div).respond();
    }

    /**
     * 明細情報のみ確定するのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnBeppyoMeisaiKakutei(ServiceRiyohyoInfoDiv div) {
        RString 状態 = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        getHandler(div).onClick_btnBeppyoMeisaiKakutei(状態);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計の計算のイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnGokeiKeisan(ServiceRiyohyoInfoDiv div) {
        ServiceRiyohyoInfoDivValidationHandler validationhandler = getValidatioHandler(div);
        RString サービス種類Tmp;
        if (div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo() != null) {
            onClick_btnCalcMeisai(div);
            サービス種類Tmp = div.getCcdServiceCodeInput().getサービスコード1();
        } else {
            サービス種類Tmp = div.getCcdServiceTypeInput().getサービス種類コード();
        }
        if (RSTRING_17.equals(サービス種類Tmp) || RSTRING_67.equals(サービス種類Tmp)
                || RSTRING_88.equals(サービス種類Tmp)) {
            ValidationMessageControlPairs サービス単位Pairs = validationhandler.validateサービス単位必須();
            if (サービス単位Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(サービス単位Pairs).respond();
            }
        } else {
            ValidationMessageControlPairs サービス単位必須以外Pairs = validationhandler.validateサービス単位必須以外();
            if (サービス単位必須以外Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(サービス単位必須以外Pairs).respond();
            }
        }
        RString 利用者負担定率定額区分
                = div.getServiceRiyohyoBeppyoMeisai().getTxtHdnRiyoshaFutanTeiritsuTeigakuKbn().getValue();
        if (RSTRING_TWO.equals(利用者負担定率定額区分)) {
            ValidationMessageControlPairs 給付率必須Pairs = validationhandler.validate給付率必須();
            if (給付率必須Pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(給付率必須Pairs).respond();
            }
        }
        getHandler(div).onClick_btnGokeiKeisan();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報の確定するのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnBeppyoGokeiKakutei(ServiceRiyohyoInfoDiv div) {
        Decimal 給付率 = ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class) == null
                ? Decimal.ZERO : ViewStateHolder.get(ViewStateKeys.給付率, Decimal.class);
        Decimal 給付率div = div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue() == null
                ? Decimal.ZERO : div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu().getValue();
        if (給付率.compareTo(給付率div) != 0) {
            if (給付率.compareTo(DECIMAL_90) == 0 && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(
                        DbcQuestionMessages.給付率修正確認.getMessage().replace(RSTRING_ONE.toString())).respond();
            } else if (給付率.compareTo(DECIMAL_80) == 0 && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(
                        DbcQuestionMessages.給付率修正確認.getMessage().replace(RSTRING_TWO.toString())).respond();
            }
        }
        if (MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())
                || !new RString(DbcQuestionMessages.給付率修正確認
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {

            getHandler(div).onClick_btnBeppyoGokeiKakutei();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * サービス種類コードのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onChange_txtServiceTypeCode(ServiceRiyohyoInfoDiv div) {
        getHandler(div).onChange_txtServiceEvent();
        return ResponseData.of(div).respond();
    }

    /**
     * 明細・合計情報一覧の「削除」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnDelete(ServiceRiyohyoInfoDiv div) {
        ViewStateHolder.put(ViewStateKeys.選択有无, true);
        ServiceRiyohyoInfoDivHandler handler = getHandler(div);
        handler.setパネルにデータ反映();
        handler.init削除();
        return ResponseData.of(div).respond();
    }

    /**
     * 明細情報パネル.単位onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtTani(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 明細情報パネル.割引適用後率onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtWaribikigoRitsu(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 明細情報パネル.回数onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtKaisu(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル.種類限度超過単位onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtShuruiGendoChokaTani(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル.種類限度内単位onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtShuruiGendonaiTani(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル.単位数単価onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtTanisuTanka(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル.区分限度超過単位onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtKubunGendoChokaTani(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル.区分限度内単位onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtKubunGendonaiTani(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル.給付率onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtKyufuritsu(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 利用年月onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtRiyoYM(ServiceRiyohyoInfoDiv div) {
        RDate 利用年月日 = div.getTxtRiyoYM().getValue();
        if (利用年月日 == null) {
            return ResponseData.of(div).respond();
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 居宅総合事業区分 = ViewStateHolder.get(ViewStateKeys.居宅総合事業区分, RString.class);
        FlexibleYearMonth 利用年月 = new FlexibleYearMonth(利用年月日.getYearMonth().toDateString());
        getHandler(div).set区分支給限度額(被保険者番号, 居宅総合事業区分, 利用年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 明細・合計情報一覧の「修正」ボタンonClickのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnModify(ServiceRiyohyoInfoDiv div) {
        ViewStateHolder.put(ViewStateKeys.選択有无, true);
        ServiceRiyohyoInfoDivHandler handler = getHandler(div);
        handler.setパネルにデータ反映();
        handler.init修正();
        return ResponseData.of(div).respond();
    }

    /**
     * 「合計情報を入力する」ボタンonClickのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnCalcMeisaiGokei(ServiceRiyohyoInfoDiv div) {
        ServiceRiyohyoInfoDivHandler handler = getHandler(div);
        handler.合計情報クリア();
        div.getServiceRiyohyoBeppyoList().getBtnBeppyoGokeiNew().setDisabled(false);
        div.getBtnCalcGokei().setDisabled(false);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        handler.onClick_btnBeppyoMeisaiKakutei(状態);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RDate 利用年月日 = div.getTxtRiyoYM().getValue();
        FlexibleYearMonth 利用年月 = null;
        if (利用年月日 != null) {
            利用年月 = new FlexibleYearMonth(利用年月日.getYearMonth().toDateString());
        }
        handler.init合計情報追加(被保険者番号, 利用年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 明細情報パネル「入力を取り消す」ボタンonClickのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnCancelMeisaiInput(ServiceRiyohyoInfoDiv div) {
        getHandler(div).明細情報クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報パネル「入力を取り消す」ボタンonClickのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnCancelGokeiInput(ServiceRiyohyoInfoDiv div) {
        getHandler(div).合計情報クリア();
        return ResponseData.of(div).respond();
    }

    private ServiceRiyohyoInfoDivValidationHandler getValidatioHandler(ServiceRiyohyoInfoDiv div) {
        return new ServiceRiyohyoInfoDivValidationHandler(div);
    }
}
