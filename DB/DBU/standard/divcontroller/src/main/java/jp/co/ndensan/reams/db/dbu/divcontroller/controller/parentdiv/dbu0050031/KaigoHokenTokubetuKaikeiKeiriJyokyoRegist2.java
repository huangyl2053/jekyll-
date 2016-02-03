/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050011.TaishokensakuJyouken;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.ValidationHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050011.TaishokensakuJyoukenHandler;
import jp.co.ndensan.reams.db.dbu.entity.insuranceinformation.InsuranceInformationEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.ShichosonEntity;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author huangh
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2 {

    private static RString 内部処理モード;
    public static final RString 内部処理モード_修正追加 = new RString("修正追加");
    public static final RString 内部処理モード_修正 = new RString("修正");
    public static final RString 内部処理モード_削除 = new RString("削除");
    public static final RString 内部処理モード_追加 = new RString("追加");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onload(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        if (TaishokensakuJyoukenHandler.UPDATE.equals(insuranceInfEntity.get処理フラグ())
                || TaishokensakuJyoukenHandler.DELETE.equals(insuranceInfEntity.get処理フラグ())) {

            List<KaigoHokenJigyoHokokuNenpoEntity> list = manager.getJigyoHokokuNenpoDetal(
                    insuranceInfEntity.get報告年(),
                    new RString(insuranceInfEntity.get集計対象年().toString()),
                    insuranceInfEntity.get統計対象区分(),
                    insuranceInfEntity.get市町村コード(),
                    new RString("0200"));
            if (list.isEmpty()) {
                内部処理モード = 内部処理モード_修正追加;

                TextBoxFlexibleDate hokokuYM = new TextBoxFlexibleDate();
                hokokuYM.setValue(new FlexibleDate(insuranceInfEntity.get報告年().toString()));
                div.getYoshikiyonMeisai().setTxthokokuYM(hokokuYM);
                div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                TextBoxCode txtHihokenshabango = new TextBoxCode();
                TextBox txthihokenshamei = new TextBox();
                txthihokenshamei.setValue(insuranceInfEntity.get市町村名称());
                txtHihokenshabango.setValue(insuranceInfEntity.get保険者コード().getColumnValue());
                div.getYoshikiyonMeisai().setTxtHihokenshabango(txtHihokenshabango);
                div.getYoshikiyonMeisai().getTxtHihokenshabango().setDisabled(true);
                div.getYoshikiyonMeisai().setTxthihokenshamei(txthihokenshamei);
                div.getYoshikiyonMeisai().getTxthihokenshamei().setDisabled(true);

            } else {
                if (TaishokensakuJyoukenHandler.UPDATE.equals(insuranceInfEntity.get処理フラグ())) {

                    div.getKanryoMessage().setVisible(false);

                    div.getHihokenshabango().getBtnYoshikiyon().setDisabled(false);
                    div.getHihokenshabango().getBnYoshikiyonnoni().setDisabled(true);
                    div.getHihokenshabango().getBtnYoskiyonosan().setDisabled(false);

                    div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxtShukeiY().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxtHihokenshabango().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxthihokenshamei().setDisabled(true);
                    div.getYoshikiyonMeisai().getDdlShicyoson().setVisible(false);
                    div.getYoshikiyonMeisai().getBtnKakutei().setVisible(false);

                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnAddCancel"), false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnDelCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnBackGaitoIchiran"), false);

                    内部処理モード = 内部処理モード_修正;

                } else {
                    div.getKanryoMessage().setVisible(false);

                    if (new RString("入力未").equals(insuranceInfEntity.get様式４入力状況())) {
                        div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
                    }
                    div.getHihokenshabango().getBnYoshikiyonnoni().setDisabled(true);
                    if (new RString("入力未").equals(insuranceInfEntity.get様式４の３入力状況())) {
                        div.getHihokenshabango().getBtnYoskiyonosan().setDisabled(true);
                    }

                    div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxtShukeiY().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxtHihokenshabango().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxthihokenshamei().setDisabled(true);
                    div.getYoshikiyonMeisai().getDdlShicyoson().setVisible(false);
                    div.getYoshikiyonMeisai().getBtnKakutei().setVisible(false);

                    div.getYoshikiyonMeisai().getTblTokukaikeijokyo().setDisabled(true);

                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnAddCancel"), false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnDelCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnBackGaitoIchiran"), false);

                    内部処理モード = 内部処理モード_削除;
                }
            }

        } else if (TaishokensakuJyoukenHandler.ADD.equals(insuranceInfEntity.get処理フラグ())) {

            List<ShichosonEntity> shichosonEntityList = manager.getShichosonCodeNameList();

            if (shichosonEntityList.isEmpty()) {

                throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
            } else {
                List<KeyValueDataSource> 市町村list = new ArrayList();
                for (int i = 0; i < shichosonEntityList.size(); i++) {
                    KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
                    keyValueDataSource.setKey(shichosonEntityList.get(i).get市町村コード().value());
                    keyValueDataSource.setValue(shichosonEntityList.get(i).get市町村名称());
                    市町村list.add(keyValueDataSource);
                }

                div.getYoshikiyonMeisai().getDdlShicyoson().setDataSource(市町村list);
            }

            if (RDate.getNowDate().getMonthValue() < 6) {
                TextBoxFlexibleDate hokokuYM = new TextBoxFlexibleDate();
                int 報告年度 = RDate.getNowDate().getYearValue() - 2;
                hokokuYM.setValue(new FlexibleDate(String.valueOf(報告年度)));
                div.getYoshikiyonMeisai().setTxthokokuYM(hokokuYM);

                TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
                int 集計年度 = RDate.getNowDate().getYearValue() - 1;
                shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
                div.getYoshikiyonMeisai().setTxtShukeiY(shukeiY);

            } else {

                TextBoxFlexibleDate hokokuYM = new TextBoxFlexibleDate();
                int 報告年度 = RDate.getNowDate().getYearValue();
                hokokuYM.setValue(new FlexibleDate(String.valueOf(報告年度)));
                div.getYoshikiyonMeisai().setTxthokokuYM(hokokuYM);

                TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
                int 集計年度 = RDate.getNowDate().getYearValue() - 2;
                shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
                div.getYoshikiyonMeisai().setTxtShukeiY(shukeiY);
            }

            div.getKanryoMessage().setVisible(false);

            div.getHihokenshabango().getBtnYoshikiyon().setDisabled(false);
            div.getHihokenshabango().getBnYoshikiyonnoni().setDisabled(true);
            div.getHihokenshabango().getBtnYoskiyonosan().setDisabled(false);

            div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(false);
            div.getYoshikiyonMeisai().getTxtShukeiY().setDisabled(true);
            div.getYoshikiyonMeisai().getTxtHihokenshabango().setVisible(false);
            div.getYoshikiyonMeisai().getTxthihokenshamei().setVisible(false);
            div.getYoshikiyonMeisai().getDdlShicyoson().setDisabled(false);
            div.getYoshikiyonMeisai().getBtnKakutei().setDisabled(false);

            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnAddCancel"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModCancel"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnDelCancel"), false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), true);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnBackGaitoIchiran"), true);

            内部処理モード = 内部処理モード_追加;
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 様式４ボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnYoshikiyon(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (内部処理モード_修正.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpoEntity 修正Entity = this.修正データの取得(div);
            if (修正Entity == null) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).respond();
            } else {

                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                    return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
                }
            }

        } else if (内部処理モード_修正追加.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード)) {
            if (this.入力項目いずれか空白ではない(div)) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                    return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).respond();
                }
            } else if (内部処理モード_削除.equals(内部処理モード)) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 様式４の３ボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnYoskiyonosan(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (内部処理モード_修正.equals(内部処理モード)) {

            KaigoHokenJigyoHokokuNenpoEntity 修正Entity = this.修正データの取得(div);
            if (修正Entity == null) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
            } else {

                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                    return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
                }
            }
        } else if (内部処理モード_修正追加.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード)) {
            if (this.入力項目いずれか空白ではない(div)) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                    return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
                }
            } else if (内部処理モード_削除.equals(内部処理モード)) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 報告年度を確定するボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnKakutei(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationHandler validationHandler = new ValidationHandler(div);
        validationHandler.報告年度の必須チェック(validationMessages);

        List<ShichosonEntity> shichosonEntityList = manager.getShichosonCodeNameList();
        TokeiTaishoKubun tokeiTaishoKubun = TokeiTaishoKubun.空;
        if (!shichosonEntityList.isEmpty()) {

            for (int i = 0; i < shichosonEntityList.size(); i++) {
                if (div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().equals(shichosonEntityList.get(i).get市町村コード().value())) {

                    tokeiTaishoKubun = shichosonEntityList.get(i).get保険者区分();
                }
            }

            List<KaigoHokenJigyoHokokuNenpoEntity> list = manager.getJigyoHokokuNenpoList(
                    div.getYoshikiyonMeisai().getTxthokokuYM().getValue().getYear(),
                    new LasdecCode(div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().toString()),
                    tokeiTaishoKubun);

            if (list.isEmpty()) {
                div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                div.getYoshikiyonMeisai().getDdlShicyoson().setDisabled(true);
                div.getYoshikiyonMeisai().getBtnKakutei().setDisabled(true);
                div.getYoshikiyonMeisai().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), false);

            } else {
                throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());

            }

        }
        return ResponseData.of(div).respond();
    }

    /**
     * 追加をやめるボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnAdd(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (this.入力項目いずれか空白ではない(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
            }
        }
        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
    }

    /**
     * 修正をやめるボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnUpdate(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (内部処理モード_修正.equals(内部処理モード)) {

            KaigoHokenJigyoHokokuNenpoEntity 修正Entity = this.修正データの取得(div);
            if (修正Entity == null) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
            } else {

                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                    return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
                }
            }
        } else if (内部処理モード_修正追加.equals(内部処理モード)) {

            if (this.入力項目いずれか空白ではない(div)) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                            UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                    return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
                }
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 削除をやめるボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnDelete(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
    }

    /**
     * 保存するボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnSave(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        if (内部処理モード_追加.equals(内部処理モード)) {
            if (!this.入力項目いずれか空白ではない(div)) {

                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            } else {

                KaigoHokenJigyoHokokuNenpoEntity kaigoHokenJigyoHokokuNenpoEntity = new KaigoHokenJigyoHokokuNenpoEntity();
                Map<RString, Decimal> 詳細データエリア = new HashMap<>();

                kaigoHokenJigyoHokokuNenpoEntity.set報告年(new FlexibleYear(div.getYoshikiyonMeisai().getTxthokokuYM().toString()));
                kaigoHokenJigyoHokokuNenpoEntity.set報告月(new RString("00"));
                kaigoHokenJigyoHokokuNenpoEntity.set集計対象年(new FlexibleYear(div.getYoshikiyonMeisai().getTxtShukeiY().getText()));
                kaigoHokenJigyoHokokuNenpoEntity.set集計対象月(new RString("00"));
                // TODOset統計対象区分
                kaigoHokenJigyoHokokuNenpoEntity.set市町村コード(new LasdecCode(div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().toString()));
                kaigoHokenJigyoHokokuNenpoEntity.set表番号(new Code("09"));
                kaigoHokenJigyoHokokuNenpoEntity.set集計番号(new Code("0200"));
                kaigoHokenJigyoHokokuNenpoEntity.set集計単位(new Code("1"));
                詳細データエリア.put(new RString("1_1"), div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue());
                詳細データエリア.put(new RString("1_2"), div.getYoshikiyonMeisai().getTxtsomu().getValue());
                詳細データエリア.put(new RString("2_1"), div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue());
                詳細データエリア.put(new RString("2_2"), div.getYoshikiyonMeisai().getTxtitakusabisu().getValue());
                詳細データエリア.put(new RString("3_1"), div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue());
                詳細データエリア.put(new RString("3_2"), div.getYoshikiyonMeisai().getTxtmitchaku().getValue());
                詳細データエリア.put(new RString("4_1"), div.getYoshikiyonMeisai().getTxtjiki().getValue());
                詳細データエリア.put(new RString("4_2"), div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue());
                詳細データエリア.put(new RString("5_1"), div.getYoshikiyonMeisai().getTxtsotashunyu().getValue());
                詳細データエリア.put(new RString("5_2"), div.getYoshikiyonMeisai().getTxtjigyosota().getValue());
                詳細データエリア.put(new RString("6_1"), div.getYoshikiyonMeisai().getTxtbuntankin().getValue());
                詳細データエリア.put(new RString("6_2"), div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue());
                詳細データエリア.put(new RString("7_1"), div.getYoshikiyonMeisai().getTxtfutankin().getValue());
                詳細データエリア.put(new RString("7_2"), div.getYoshikiyonMeisai().getTxtkikinsekin().getValue());
                詳細データエリア.put(new RString("8_1"), div.getYoshikiyonMeisai().getTxtshiyohi().getValue());
                詳細データエリア.put(new RString("8_2"), div.getYoshikiyonMeisai().getTxtkosai().getValue());
                詳細データエリア.put(new RString("9_1"), div.getYoshikiyonMeisai().getTxttesuryo().getValue());
                詳細データエリア.put(new RString("9_2"), div.getYoshikiyonMeisai().getTxtyobih().getValue());
                詳細データエリア.put(new RString("10_1"), div.getYoshikiyonMeisai().getTxtkokko().getValue());
                詳細データエリア.put(new RString("10_2"), div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue());
                詳細データエリア.put(new RString("11_1"), div.getYoshikiyonMeisai().getTxttodofuken().getValue());
                詳細データエリア.put(new RString("11_2"), div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue());
                詳細データエリア.put(new RString("12_1"), div.getYoshikiyonMeisai().getTxtzaisannyu().getValue());
                詳細データエリア.put(new RString("12_2"), div.getYoshikiyonMeisai().getTxtshosonota().getValue());
                詳細データエリア.put(new RString("13_1"), div.getYoshikiyonMeisai().getTxtkifukin().getValue());
                詳細データエリア.put(new RString("13_2"), div.getYoshikiyonMeisai().getTxtshohi().getValue());
                詳細データエリア.put(new RString("14_1"), div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue());
                詳細データエリア.put(new RString("15_1"), div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue());
                詳細データエリア.put(new RString("16_1"), div.getYoshikiyonMeisai().getTxtkurikosu().getValue());
                詳細データエリア.put(new RString("17_1"), div.getYoshikiyonMeisai().getTxtshichoson().getValue());
                詳細データエリア.put(new RString("18_1"), div.getYoshikiyonMeisai().getTxtshonyu().getValue());
                詳細データエリア.put(new RString("19_1"), div.getYoshikiyonMeisai().getTxtsainyugokei().getValue());
                詳細データエリア.put(new RString("19_2"), div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue());
                詳細データエリア.put(new RString("20_1"), div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue());
                詳細データエリア.put(new RString("21_1"), div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue());

                kaigoHokenJigyoHokokuNenpoEntity.set詳細データエリア(詳細データエリア);

                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

                    List<KaigoHokenJigyoHokokuNenpoEntity> list = new ArrayList<>();
                    list.add(kaigoHokenJigyoHokokuNenpoEntity);
                    manager.regKaigoHokenTokubetuKaikeiKeiriJyokyo(list);
                }
            }
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpoEntity 修正Entity = this.修正データの取得(div);
            if (修正Entity == null) {
                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            } else {

                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

                    List<KaigoHokenJigyoHokokuNenpoEntity> list = new ArrayList<>();
                    list.add(修正Entity);
                    manager.updKaigoHokenTokubetuKaikeiKeiriJyokyo(list);
                }
            }

        } else if (内部処理モード_修正追加.equals(内部処理モード)) {
            if (!this.入力項目いずれか空白ではない(div)) {

                throw new ApplicationException(DbzErrorMessages.編集なしで更新不可.getMessage());
            } else {

                KaigoHokenJigyoHokokuNenpoEntity kaigoHokenJigyoHokokuNenpoEntity = new KaigoHokenJigyoHokokuNenpoEntity();
                Map<RString, Decimal> 詳細データエリア = new HashMap<>();

                kaigoHokenJigyoHokokuNenpoEntity.set報告年(new FlexibleYear(div.getYoshikiyonMeisai().getTxthokokuYM().toString()));
                kaigoHokenJigyoHokokuNenpoEntity.set報告月(new RString("00"));
                kaigoHokenJigyoHokokuNenpoEntity.set集計対象年(new FlexibleYear(div.getYoshikiyonMeisai().getTxtShukeiY().getText()));
                kaigoHokenJigyoHokokuNenpoEntity.set集計対象月(new RString("00"));
                // TODOset統計対象区分
                kaigoHokenJigyoHokokuNenpoEntity.set市町村コード(new LasdecCode(div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().toString()));
                kaigoHokenJigyoHokokuNenpoEntity.set表番号(new Code("09"));
                kaigoHokenJigyoHokokuNenpoEntity.set集計番号(new Code("0200"));
                kaigoHokenJigyoHokokuNenpoEntity.set集計単位(new Code("1"));
                詳細データエリア.put(new RString("1_1"), div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue());
                詳細データエリア.put(new RString("1_2"), div.getYoshikiyonMeisai().getTxtsomu().getValue());
                詳細データエリア.put(new RString("2_1"), div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue());
                詳細データエリア.put(new RString("2_2"), div.getYoshikiyonMeisai().getTxtitakusabisu().getValue());
                詳細データエリア.put(new RString("3_1"), div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue());
                詳細データエリア.put(new RString("3_2"), div.getYoshikiyonMeisai().getTxtmitchaku().getValue());
                詳細データエリア.put(new RString("4_1"), div.getYoshikiyonMeisai().getTxtjiki().getValue());
                詳細データエリア.put(new RString("4_2"), div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue());
                詳細データエリア.put(new RString("5_1"), div.getYoshikiyonMeisai().getTxtsotashunyu().getValue());
                詳細データエリア.put(new RString("5_2"), div.getYoshikiyonMeisai().getTxtjigyosota().getValue());
                詳細データエリア.put(new RString("6_1"), div.getYoshikiyonMeisai().getTxtbuntankin().getValue());
                詳細データエリア.put(new RString("6_2"), div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue());
                詳細データエリア.put(new RString("7_1"), div.getYoshikiyonMeisai().getTxtfutankin().getValue());
                詳細データエリア.put(new RString("7_2"), div.getYoshikiyonMeisai().getTxtkikinsekin().getValue());
                詳細データエリア.put(new RString("8_1"), div.getYoshikiyonMeisai().getTxtshiyohi().getValue());
                詳細データエリア.put(new RString("8_2"), div.getYoshikiyonMeisai().getTxtkosai().getValue());
                詳細データエリア.put(new RString("9_1"), div.getYoshikiyonMeisai().getTxttesuryo().getValue());
                詳細データエリア.put(new RString("9_2"), div.getYoshikiyonMeisai().getTxtyobih().getValue());
                詳細データエリア.put(new RString("10_1"), div.getYoshikiyonMeisai().getTxtkokko().getValue());
                詳細データエリア.put(new RString("10_2"), div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue());
                詳細データエリア.put(new RString("11_1"), div.getYoshikiyonMeisai().getTxttodofuken().getValue());
                詳細データエリア.put(new RString("11_2"), div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue());
                詳細データエリア.put(new RString("12_1"), div.getYoshikiyonMeisai().getTxtzaisannyu().getValue());
                詳細データエリア.put(new RString("12_2"), div.getYoshikiyonMeisai().getTxtshosonota().getValue());
                詳細データエリア.put(new RString("13_1"), div.getYoshikiyonMeisai().getTxtkifukin().getValue());
                詳細データエリア.put(new RString("13_2"), div.getYoshikiyonMeisai().getTxtshohi().getValue());
                詳細データエリア.put(new RString("14_1"), div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue());
                詳細データエリア.put(new RString("15_1"), div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue());
                詳細データエリア.put(new RString("16_1"), div.getYoshikiyonMeisai().getTxtkurikosu().getValue());
                詳細データエリア.put(new RString("17_1"), div.getYoshikiyonMeisai().getTxtshichoson().getValue());
                詳細データエリア.put(new RString("18_1"), div.getYoshikiyonMeisai().getTxtshonyu().getValue());
                詳細データエリア.put(new RString("19_1"), div.getYoshikiyonMeisai().getTxtsainyugokei().getValue());
                詳細データエリア.put(new RString("19_2"), div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue());
                詳細データエリア.put(new RString("20_1"), div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue());
                詳細データエリア.put(new RString("21_1"), div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue());

                kaigoHokenJigyoHokokuNenpoEntity.set詳細データエリア(詳細データエリア);

                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                        .equals(ResponseHolder.getMessageCode())
                        && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

                    List<KaigoHokenJigyoHokokuNenpoEntity> list = new ArrayList<>();
                    list.add(kaigoHokenJigyoHokokuNenpoEntity);
                    manager.regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(list);
                }
            }
        } else if (内部処理モード_削除.equals(内部処理モード)) {

            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                        UrQuestionMessages.処理実行の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

                List<KaigoHokenJigyoHokokuNenpoEntity> list = new ArrayList<>();

                manager.delKaigoHokenTokubetuKaikeiKeiriJyokyo(
                        new FlexibleYear(insuranceInfEntity.get報告年().toString()),
                        new FlexibleYear(insuranceInfEntity.get集計対象年().toString()),
                        insuranceInfEntity.get統計対象区分(),
                        insuranceInfEntity.get市町村コード(),
                        insuranceInfEntity.get表番号(),
                        new Code("0200"));
            }
        }

        div.getKanryoMessage().setVisible(true);
        div.getHihokenshabango().setVisible(false);
        div.getYoshikiyonMeisai().setVisible(false);

        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnAddCancel"), false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModCancel"), false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnDelCancel"), false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnSaveCancel"), false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnEnd"), false);

        if (TaishokensakuJyoukenHandler.ADD.equals(insuranceInfEntity.get処理フラグ())) {
            // TODO
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        } else if (TaishokensakuJyoukenHandler.UPDATE.equals(insuranceInfEntity.get処理フラグ())) {
            // TODO
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        } else if (TaishokensakuJyoukenHandler.DELETE.equals(insuranceInfEntity.get処理フラグ())) {
            // TODO
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 完了するボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnEnd(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 入力項目いずれか空白ではないことを判断。
     *
     * @param div 画面情報
     * @return 入力項目いずれか空白ではない
     */
    public boolean 入力項目いずれか空白ではない(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtjiki().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtsotashunyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtfutankin().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshiyohi().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxttesuryo().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtkokko().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxttodofuken().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtzaisannyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtkifukin().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtkurikosu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshichoson().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshonyu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtsainyugokei().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtsomu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtitakusabisu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtmitchaku().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtjigyosota().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtkikinsekin().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtkosai().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtyobih().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshosonota().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshohi().getValue().toString()))) {

            return true;
        } else if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue().toString()))) {

            return true;
        }
        return true;
    }

    /**
     * 市町村名を取得します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onBlur_txthokokuYM(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {
        if (RDate.getNowDate().getYear().toDateString().equals(div.getYoshikiyonMeisai().getTxthokokuYM().getText())) {
            if (RDate.getNowDate().getMonthValue() >= 6) {

                TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
                int 集計年度 = RDate.getNowDate().getYearValue() - 2;
                shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
                div.getYoshikiyonMeisai().setTxtShukeiY(shukeiY);
            } else {
                TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
                int 集計年度 = RDate.getNowDate().getYearValue() - 1;
                shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
                div.getYoshikiyonMeisai().setTxtShukeiY(shukeiY);
            }

        } else if (div.getYoshikiyonMeisai().getTxthokokuYM().getValue().isEmpty()) {

        } else {

            TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
            int 集計年度 = div.getYoshikiyonMeisai().getTxthokokuYM().getValue().getYearValue() - 2;
            shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
            div.getYoshikiyonMeisai().setTxtShukeiY(shukeiY);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 修正データを取得します。
     *
     * @param div KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div
     * @return KaigoHokenJigyoHokokuNenpoEntity
     */
    public KaigoHokenJigyoHokokuNenpoEntity 修正データの取得(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {
        InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        List<KaigoHokenJigyoHokokuNenpoEntity> list = manager.getJigyoHokokuNenpoDetal(
                new FlexibleYear(insuranceInfEntity.get報告年().toString()),
                new RString(insuranceInfEntity.get集計対象年().toString()),
                insuranceInfEntity.get統計対象区分(),
                insuranceInfEntity.get市町村コード(),
                new RString("0200"));

        KaigoHokenJigyoHokokuNenpoEntity 修正データEntity = new KaigoHokenJigyoHokokuNenpoEntity();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).get詳細データエリア().get(new RString("1_1")).equals(div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("1_1"), div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("1_2")).equals(div.getYoshikiyonMeisai().getTxtsomu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("1_2"), div.getYoshikiyonMeisai().getTxtsomu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("2_1")).equals(div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("2_1"), div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("2_2")).equals(div.getYoshikiyonMeisai().getTxtitakusabisu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("2_2"), div.getYoshikiyonMeisai().getTxtitakusabisu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("3_1")).equals(div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("3_1"), div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("3_2")).equals(div.getYoshikiyonMeisai().getTxtmitchaku().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("3_2"), div.getYoshikiyonMeisai().getTxtmitchaku().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("4_1")).equals(div.getYoshikiyonMeisai().getTxtjiki().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("4_1"), div.getYoshikiyonMeisai().getTxtjiki().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("4_2")).equals(div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("4_2"), div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("5_1")).equals(div.getYoshikiyonMeisai().getTxtsotashunyu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("5_1"), div.getYoshikiyonMeisai().getTxtsotashunyu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("5_2")).equals(div.getYoshikiyonMeisai().getTxtjigyosota().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("5_2"), div.getYoshikiyonMeisai().getTxtjigyosota().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("6_1")).equals(div.getYoshikiyonMeisai().getTxtbuntankin().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("6_1"), div.getYoshikiyonMeisai().getTxtbuntankin().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("6_2")).equals(div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("6_2"), div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("7_1")).equals(div.getYoshikiyonMeisai().getTxtfutankin().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("7_1"), div.getYoshikiyonMeisai().getTxtfutankin().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("7_2")).equals(div.getYoshikiyonMeisai().getTxtkikinsekin().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("7_2"), div.getYoshikiyonMeisai().getTxtkikinsekin().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("8_1")).equals(div.getYoshikiyonMeisai().getTxtshiyohi().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("8_1"), div.getYoshikiyonMeisai().getTxtshiyohi().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("8_2")).equals(div.getYoshikiyonMeisai().getTxtkosai().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("8_2"), div.getYoshikiyonMeisai().getTxtkosai().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("9_1")).equals(div.getYoshikiyonMeisai().getTxttesuryo().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("9_1"), div.getYoshikiyonMeisai().getTxttesuryo().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("9_2")).equals(div.getYoshikiyonMeisai().getTxtyobih().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("9_2"), div.getYoshikiyonMeisai().getTxtyobih().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("10_1")).equals(div.getYoshikiyonMeisai().getTxtkokko().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("10_1"), div.getYoshikiyonMeisai().getTxtkokko().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("10_2")).equals(div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("10_2"), div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("11_1")).equals(div.getYoshikiyonMeisai().getTxttodofuken().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("11_1"), div.getYoshikiyonMeisai().getTxttodofuken().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("11_2")).equals(div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("11_2"), div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("12_1")).equals(div.getYoshikiyonMeisai().getTxtzaisannyu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("12_1"), div.getYoshikiyonMeisai().getTxtzaisannyu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("12_2")).equals(div.getYoshikiyonMeisai().getTxtshosonota().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("12_2"), div.getYoshikiyonMeisai().getTxtshosonota().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("13_1")).equals(div.getYoshikiyonMeisai().getTxtkifukin().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("13_1"), div.getYoshikiyonMeisai().getTxtkifukin().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("13_2")).equals(div.getYoshikiyonMeisai().getTxtshohi().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("13_2"), div.getYoshikiyonMeisai().getTxtshohi().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("14_1")).equals(div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("14_1"), div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("15_1")).equals(div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("15_1"), div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("16_1")).equals(div.getYoshikiyonMeisai().getTxtkurikosu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("16_1"), div.getYoshikiyonMeisai().getTxtkurikosu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("17_1")).equals(div.getYoshikiyonMeisai().getTxtshichoson().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("17_1"), div.getYoshikiyonMeisai().getTxtshichoson().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("18_1")).equals(div.getYoshikiyonMeisai().getTxtshonyu().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("18_1"), div.getYoshikiyonMeisai().getTxtshonyu().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("19_1")).equals(div.getYoshikiyonMeisai().getTxtsainyugokei().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("19_1"), div.getYoshikiyonMeisai().getTxtsainyugokei().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("19_2")).equals(div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("19_2"), div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("20_1")).equals(div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("20_1"), div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue());
            }
            if (!list.get(i).get詳細データエリア().get(new RString("21_1")).equals(div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue())) {
                修正データEntity.get詳細データエリア().put(new RString("21_1"), div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue());
            }

        }

        return 修正データEntity;
    }

    /**
     * 引き継ぎデータ取得処理です。
     *
     */
    private InsuranceInformationEntity get引き継ぎデータ() {
        InsuranceInformationEntity 引き継ぎデータ
                = (InsuranceInformationEntity) ViewStateHolder.get(TaishokensakuJyouken.ViewStateKey.様式４の2, InsuranceInformationEntity.class);
        if (null == 引き継ぎデータ) {
            引き継ぎデータ = new InsuranceInformationEntity();
            引き継ぎデータ.set処理フラグ(TaishokensakuJyoukenHandler.ADD);
        }
        return 引き継ぎデータ;
    }
}
