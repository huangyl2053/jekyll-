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
import jp.co.ndensan.reams.db.dbu.business.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.business.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.business.kaigohokentokubetukaikeikeirijyokyoregist.Shichoson;
import jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050011.TaishokensakuJyouken.ViewStateKey;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.ValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
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
 * 介護保険特別会計経理状況登録_様式４の２情報Divを制御します。
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2 {

    private RString 内部処理モード;
    private static final RString UPDATE = new RString("modify");
    private static final RString DELETE = new RString("delete");
    private static final RString ADD = new RString("add");
    private static final RString 内部処理モード_修正追加 = new RString("修正追加");
    private static final RString 内部処理モード_修正 = new RString("修正");
    private static final RString 内部処理モード_削除 = new RString("削除");
    private static final RString 内部処理モード_追加 = new RString("追加");
    private static final int MONTH_6 = 6;
    private static final RString 追加をやめる = new RString("btnAddCancel");
    private static final RString 修正をやめる = new RString("btnModCancel");
    private static final RString 削除をやめる = new RString("btnDelCancel");
    private static final RString 保存する = new RString("btnSaveCancel");
    private static final RString 該当一覧へ戻る = new RString("btnBackGaitoIchiran");
    private static final RString 完了する = new RString("btnEnd");
    private static final RString 座標1_1 = new RString("1_1");
    private static final RString 座標1_2 = new RString("1_2");
    private static final RString 座標2_1 = new RString("2_1");
    private static final RString 座標2_2 = new RString("2_2");
    private static final RString 座標3_1 = new RString("3_1");
    private static final RString 座標3_2 = new RString("3_2");
    private static final RString 座標4_1 = new RString("4_1");
    private static final RString 座標4_2 = new RString("4_2");
    private static final RString 座標5_1 = new RString("5_1");
    private static final RString 座標5_2 = new RString("5_2");
    private static final RString 座標6_1 = new RString("6_1");
    private static final RString 座標6_2 = new RString("6_2");
    private static final RString 座標7_1 = new RString("7_1");
    private static final RString 座標7_2 = new RString("7_2");
    private static final RString 座標8_1 = new RString("8_1");
    private static final RString 座標8_2 = new RString("8_2");
    private static final RString 座標9_1 = new RString("9_1");
    private static final RString 座標9_2 = new RString("9_2");
    private static final RString 座標10_1 = new RString("10_1");
    private static final RString 座標10_2 = new RString("10_2");
    private static final RString 座標11_1 = new RString("11_1");
    private static final RString 座標11_2 = new RString("11_2");
    private static final RString 座標12_1 = new RString("12_1");
    private static final RString 座標12_2 = new RString("12_2");
    private static final RString 座標13_1 = new RString("13_1");
    private static final RString 座標13_2 = new RString("13_2");
    private static final RString 座標14_1 = new RString("14_1");
    private static final RString 座標15_1 = new RString("15_1");
    private static final RString 座標16_1 = new RString("16_1");
    private static final RString 座標17_1 = new RString("17_1");
    private static final RString 座標18_1 = new RString("18_1");
    private static final RString 座標19_1 = new RString("19_1");
    private static final RString 座標19_2 = new RString("19_2");
    private static final RString 座標20_1 = new RString("20_1");
    private static final RString 座標21_1 = new RString("21_1");
    private static final RString 集計番号_0200 = new RString("0200");
    private static final Code CODE_0200 = new Code("0200");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onload(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        InsuranceInformation insuranceInf = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        if (UPDATE.equals(insuranceInf.get処理フラグ())
                || DELETE.equals(insuranceInf.get処理フラグ())) {

            List<KaigoHokenJigyoHokokuNenpo> list = manager.getJigyoHokokuNenpoDetal(
                    insuranceInf.get報告年(),
                    new RString(insuranceInf.get集計対象年().toString()),
                    insuranceInf.get統計対象区分(),
                    insuranceInf.get市町村コード(),
                    集計番号_0200);
            if (list.isEmpty()) {
                内部処理モード = 内部処理モード_修正追加;

                TextBoxFlexibleDate hokokuYM = new TextBoxFlexibleDate();
                hokokuYM.setValue(new FlexibleDate(insuranceInf.get報告年().toString()));
                div.getYoshikiyonMeisai().setTxthokokuYM(hokokuYM);
                div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                TextBoxCode txtHihokenshabango = new TextBoxCode();
                TextBox txthihokenshamei = new TextBox();
                txthihokenshamei.setValue(insuranceInf.get市町村名称());
                txtHihokenshabango.setValue(insuranceInf.get保険者コード().getColumnValue());
                div.getYoshikiyonMeisai().setTxtHihokenshabango(txtHihokenshabango);
                div.getYoshikiyonMeisai().getTxtHihokenshabango().setDisabled(true);
                div.getYoshikiyonMeisai().setTxthihokenshamei(txthihokenshamei);
                div.getYoshikiyonMeisai().getTxthihokenshamei().setDisabled(true);

            } else {
                if (UPDATE.equals(insuranceInf.get処理フラグ())) {

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

                    CommonButtonHolder.setVisibleByCommonButtonFieldName(追加をやめる, false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(修正をやめる, false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(削除をやめる, false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(該当一覧へ戻る, false);

                    内部処理モード = 内部処理モード_修正;

                } else {
                    div.getKanryoMessage().setVisible(false);

                    this.btnDisabled(div, insuranceInf);

                    div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxtShukeiY().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxtHihokenshabango().setDisabled(true);
                    div.getYoshikiyonMeisai().getTxthihokenshamei().setDisabled(true);
                    div.getYoshikiyonMeisai().getDdlShicyoson().setVisible(false);
                    div.getYoshikiyonMeisai().getBtnKakutei().setVisible(false);

                    div.getYoshikiyonMeisai().getTblTokukaikeijokyo().setDisabled(true);

                    CommonButtonHolder.setVisibleByCommonButtonFieldName(追加をやめる, false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(修正をやめる, false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(削除をやめる, false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(該当一覧へ戻る, false);

                    内部処理モード = 内部処理モード_削除;
                }
            }

        } else if (ADD.equals(insuranceInf.get処理フラグ())) {

            List<Shichoson> shichosonList = manager.getShichosonCodeNameList();

            if (shichosonList.isEmpty()) {

                throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
            } else {
                List<KeyValueDataSource> 市町村list = new ArrayList<>();
                for (int i = 0; i < shichosonList.size(); i++) {
                    KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
                    keyValueDataSource.setKey(shichosonList.get(i).get市町村コード().value());
                    keyValueDataSource.setValue(shichosonList.get(i).get市町村名称());
                    市町村list.add(keyValueDataSource);
                }

                div.getYoshikiyonMeisai().getDdlShicyoson().setDataSource(市町村list);
            }

            if (RDate.getNowDate().getMonthValue() < MONTH_6) {
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

            CommonButtonHolder.setDisabledByCommonButtonFieldName(追加をやめる, false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(修正をやめる, false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(削除をやめる, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(該当一覧へ戻る, true);

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
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onClick_btnYoshikiyon(
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (内部処理モード_修正.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ.get詳細データエリア().isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).respond();
            } else {
                this.messageAndGoto(DBU0050031TransitionEventName.様式４, div);
            }

        } else if ((内部処理モード_修正追加.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード))
                && this.入力項目いずれか空白ではない(div)) {
            this.messageAndGoto(DBU0050031TransitionEventName.様式４, div);
        } else if (内部処理モード_削除.equals(内部処理モード)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).respond();
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

            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ.get詳細データエリア().isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
            } else {

                this.messageAndGoto(DBU0050031TransitionEventName.様式４の３, div);
            }
        } else if ((内部処理モード_修正追加.equals(内部処理モード)
                || 内部処理モード_追加.equals(内部処理モード))
                && this.入力項目いずれか空白ではない(div)) {
            this.messageAndGoto(DBU0050031TransitionEventName.様式４の３, div);
        } else if (内部処理モード_削除.equals(内部処理モード)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).respond();
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

        List<Shichoson> shichosonList = manager.getShichosonCodeNameList();
        TokeiTaishoKubun tokeiTaishoKubun = TokeiTaishoKubun.空;
        if (!shichosonList.isEmpty()) {

            for (int i = 0; i < shichosonList.size(); i++) {
                if (div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().equals(shichosonList.get(i).get市町村コード().value())) {

                    tokeiTaishoKubun = shichosonList.get(i).get保険者区分();
                }
            }

            List<KaigoHokenJigyoHokokuNenpo> list = manager.getJigyoHokokuNenpoList(
                    div.getYoshikiyonMeisai().getTxthokokuYM().getValue().getYear(),
                    new LasdecCode(div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().toString()),
                    tokeiTaishoKubun);

            if (list.isEmpty()) {
                div.getYoshikiyonMeisai().getTxthokokuYM().setDisabled(true);
                div.getYoshikiyonMeisai().getDdlShicyoson().setDisabled(true);
                div.getYoshikiyonMeisai().getBtnKakutei().setDisabled(true);
                div.getYoshikiyonMeisai().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);

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
            this.messageAndGoto(DBU0050031TransitionEventName.検索に戻る, div);
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

            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ.get詳細データエリア().isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
            } else {
                this.messageAndGoto(DBU0050031TransitionEventName.検索に戻る, div);
            }
        } else if (内部処理モード_修正追加.equals(内部処理モード)
                && this.入力項目いずれか空白ではない(div)) {
            this.messageAndGoto(DBU0050031TransitionEventName.検索に戻る, div);
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

        InsuranceInformation insuranceInf = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        if (内部処理モード_追加.equals(内部処理モード)) {
            if (!this.入力項目いずれか空白ではない(div)) {

                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                Map<RString, Decimal> 詳細データエリア = new HashMap<>();

                this.put詳細データエリア(詳細データエリア, div);

                KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo = new KaigoHokenJigyoHokokuNenpo(
                        new FlexibleYear(div.getYoshikiyonMeisai().getTxthokokuYM().toString()),
                        new RString("00"),
                        new FlexibleYear(div.getYoshikiyonMeisai().getTxtShukeiY().getText()),
                        new RString("00"),
                        // TODOset統計対象区分
                        new RString("統計対象区分"),
                        new LasdecCode(div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().toString()),
                        new Code("09"),
                        CODE_0200,
                        new Code("1"),
                        内部処理モード,
                        Code.EMPTY,
                        Code.EMPTY,
                        詳細データエリア);

                this.regKaigoHokenTokubetuKaikeiKeiriJyokyo(kaigoHokenJigyoHokokuNenpo, manager, div);
            }
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ == null) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                this.updKaigoHokenTokubetuKaikeiKeiriJyokyo(修正データ, manager, div);
            }

        } else if (内部処理モード_修正追加.equals(内部処理モード)) {
            if (!this.入力項目いずれか空白ではない(div)) {

                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {

                Map<RString, Decimal> 詳細データエリア = new HashMap<>();

                this.put詳細データエリア(詳細データエリア, div);

                KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo = new KaigoHokenJigyoHokokuNenpo(
                        new FlexibleYear(div.getYoshikiyonMeisai().getTxthokokuYM().toString()),
                        new RString("00"),
                        new FlexibleYear(div.getYoshikiyonMeisai().getTxtShukeiY().getText()),
                        new RString("00"),
                        // TODOset統計対象区分
                        new RString("統計対象区分"),
                        new LasdecCode(div.getYoshikiyonMeisai().getDdlShicyoson().getSelectedKey().toString()),
                        new Code("09"),
                        CODE_0200,
                        new Code("1"),
                        内部処理モード,
                        Code.EMPTY,
                        Code.EMPTY,
                        詳細データエリア);

                this.regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(kaigoHokenJigyoHokokuNenpo, manager, div);
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

                manager.delKaigoHokenTokubetuKaikeiKeiriJyokyo(
                        new FlexibleYear(insuranceInf.get報告年().toString()),
                        new FlexibleYear(insuranceInf.get集計対象年().toString()),
                        insuranceInf.get統計対象区分(),
                        insuranceInf.get市町村コード(),
                        insuranceInf.get表番号(),
                        CODE_0200);
            }
        }

        div.getKanryoMessage().setVisible(true);
        div.getHihokenshabango().setVisible(false);
        div.getYoshikiyonMeisai().setVisible(false);

        CommonButtonHolder.setVisibleByCommonButtonFieldName(追加をやめる, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(修正をやめる, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(削除をやめる, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(保存する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(完了する, false);

        if (ADD.equals(insuranceInf.get処理フラグ())) {
            // TODO
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        } else if (UPDATE.equals(insuranceInf.get処理フラグ())) {
            // TODO
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        } else if (DELETE.equals(insuranceInf.get処理フラグ())) {
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

        boolean 空白_前 = this.入力項目いずれか空白ではない_前(div);
        boolean 空白_後 = this.入力項目いずれか空白ではない_後(div);

        return !空白_前 && !空白_後;
    }

    /**
     * 市町村名を取得します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> onBlur_txthokokuYM(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {
        if (RDate.getNowDate().getYear().toDateString().equals(div.getYoshikiyonMeisai().getTxthokokuYM().getText())) {
            if (RDate.getNowDate().getMonthValue() >= MONTH_6) {

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

        } else if (!div.getYoshikiyonMeisai().getTxthokokuYM().getValue().isEmpty()) {

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
     * @return KaigoHokenJigyoHokokuNenpo
     */
    public KaigoHokenJigyoHokokuNenpo 修正データの取得(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {
        InsuranceInformation insuranceInf = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        List<KaigoHokenJigyoHokokuNenpo> list = manager.getJigyoHokokuNenpoDetal(
                new FlexibleYear(insuranceInf.get報告年().toString()),
                new RString(insuranceInf.get集計対象年().toString()),
                insuranceInf.get統計対象区分(),
                insuranceInf.get市町村コード(),
                集計番号_0200);

        KaigoHokenJigyoHokokuNenpo 修正データ = new KaigoHokenJigyoHokokuNenpo();
        for (int i = 0; i < list.size(); i++) {

            this.修正データの取得_１(修正データ, list, i, div);
            this.修正データの取得_２(修正データ, list, i, div);
        }

        return 修正データ;
    }

    /**
     * 引き継ぎデータ取得処理です。
     *
     */
    private InsuranceInformation get引き継ぎデータ() {
        InsuranceInformation 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKey.様式４の2, InsuranceInformation.class);
        if (null == 引き継ぎデータ) {
            引き継ぎデータ = new InsuranceInformation(ADD);
        }
        return 引き継ぎデータ;
    }

    /**
     * BtnYoshikiyonとBtnYoskiyonosanはDisabledになります。
     *
     */
    private void btnDisabled(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div, InsuranceInformation insuranceInf) {
        if (new RString("入力未").equals(insuranceInf.get様式４入力状況())) {
            div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
        }
        div.getHihokenshabango().getBnYoshikiyonnoni().setDisabled(true);
        if (new RString("入力未").equals(insuranceInf.get様式４の３入力状況())) {
            div.getHihokenshabango().getBtnYoskiyonosan().setDisabled(true);
        }
    }

    /**
     * メッセージ出力、且つ画面遷移する。
     *
     */
    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> messageAndGoto(
            IContainerEvents events, KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).forwardWithEventName(events).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 修正データ１の取得する。
     *
     */
    private void 修正データの取得_１(
            KaigoHokenJigyoHokokuNenpo 修正データ,
            List<KaigoHokenJigyoHokokuNenpo> list,
            int i,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {
        if (!list.get(i).get詳細データエリア().get(座標1_1).equals(div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標1_1, div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標1_2).equals(div.getYoshikiyonMeisai().getTxtsomu().getValue())) {
            修正データ.get詳細データエリア().put(座標1_2, div.getYoshikiyonMeisai().getTxtsomu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標2_1).equals(div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標2_1, div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標2_2).equals(div.getYoshikiyonMeisai().getTxtitakusabisu().getValue())) {
            修正データ.get詳細データエリア().put(座標2_2, div.getYoshikiyonMeisai().getTxtitakusabisu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標3_1).equals(div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標3_1, div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標3_2).equals(div.getYoshikiyonMeisai().getTxtmitchaku().getValue())) {
            修正データ.get詳細データエリア().put(座標3_2, div.getYoshikiyonMeisai().getTxtmitchaku().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標4_1).equals(div.getYoshikiyonMeisai().getTxtjiki().getValue())) {
            修正データ.get詳細データエリア().put(座標4_1, div.getYoshikiyonMeisai().getTxtjiki().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標4_2).equals(div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue())) {
            修正データ.get詳細データエリア().put(座標4_2, div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標5_1).equals(div.getYoshikiyonMeisai().getTxtsotashunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標5_1, div.getYoshikiyonMeisai().getTxtsotashunyu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標5_2).equals(div.getYoshikiyonMeisai().getTxtjigyosota().getValue())) {
            修正データ.get詳細データエリア().put(座標5_2, div.getYoshikiyonMeisai().getTxtjigyosota().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標6_1).equals(div.getYoshikiyonMeisai().getTxtbuntankin().getValue())) {
            修正データ.get詳細データエリア().put(座標6_1, div.getYoshikiyonMeisai().getTxtbuntankin().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標6_2).equals(div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue())) {
            修正データ.get詳細データエリア().put(座標6_2, div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標7_1).equals(div.getYoshikiyonMeisai().getTxtfutankin().getValue())) {
            修正データ.get詳細データエリア().put(座標7_1, div.getYoshikiyonMeisai().getTxtfutankin().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標7_2).equals(div.getYoshikiyonMeisai().getTxtkikinsekin().getValue())) {
            修正データ.get詳細データエリア().put(座標7_2, div.getYoshikiyonMeisai().getTxtkikinsekin().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標8_1).equals(div.getYoshikiyonMeisai().getTxtshiyohi().getValue())) {
            修正データ.get詳細データエリア().put(座標8_1, div.getYoshikiyonMeisai().getTxtshiyohi().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標8_2).equals(div.getYoshikiyonMeisai().getTxtkosai().getValue())) {
            修正データ.get詳細データエリア().put(座標8_2, div.getYoshikiyonMeisai().getTxtkosai().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標9_1).equals(div.getYoshikiyonMeisai().getTxttesuryo().getValue())) {
            修正データ.get詳細データエリア().put(座標9_1, div.getYoshikiyonMeisai().getTxttesuryo().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標9_2).equals(div.getYoshikiyonMeisai().getTxtyobih().getValue())) {
            修正データ.get詳細データエリア().put(座標9_2, div.getYoshikiyonMeisai().getTxtyobih().getValue());
        }
    }

    /**
     * 修正データ２の取得する。
     *
     */
    private void 修正データの取得_２(
            KaigoHokenJigyoHokokuNenpo 修正データ,
            List<KaigoHokenJigyoHokokuNenpo> list,
            int i,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!list.get(i).get詳細データエリア().get(座標10_1).equals(div.getYoshikiyonMeisai().getTxtkokko().getValue())) {
            修正データ.get詳細データエリア().put(座標10_1, div.getYoshikiyonMeisai().getTxtkokko().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標10_2).equals(div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue())) {
            修正データ.get詳細データエリア().put(座標10_2, div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標11_1).equals(div.getYoshikiyonMeisai().getTxttodofuken().getValue())) {
            修正データ.get詳細データエリア().put(座標11_1, div.getYoshikiyonMeisai().getTxttodofuken().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標11_2).equals(div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue())) {
            修正データ.get詳細データエリア().put(座標11_2, div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標12_1).equals(div.getYoshikiyonMeisai().getTxtzaisannyu().getValue())) {
            修正データ.get詳細データエリア().put(座標12_1, div.getYoshikiyonMeisai().getTxtzaisannyu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標12_2).equals(div.getYoshikiyonMeisai().getTxtshosonota().getValue())) {
            修正データ.get詳細データエリア().put(座標12_2, div.getYoshikiyonMeisai().getTxtshosonota().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標13_1).equals(div.getYoshikiyonMeisai().getTxtkifukin().getValue())) {
            修正データ.get詳細データエリア().put(座標13_1, div.getYoshikiyonMeisai().getTxtkifukin().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標13_2).equals(div.getYoshikiyonMeisai().getTxtshohi().getValue())) {
            修正データ.get詳細データエリア().put(座標13_2, div.getYoshikiyonMeisai().getTxtshohi().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標14_1).equals(div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue())) {
            修正データ.get詳細データエリア().put(座標14_1, div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標15_1).equals(div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue())) {
            修正データ.get詳細データエリア().put(座標15_1, div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標16_1).equals(div.getYoshikiyonMeisai().getTxtkurikosu().getValue())) {
            修正データ.get詳細データエリア().put(座標16_1, div.getYoshikiyonMeisai().getTxtkurikosu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標17_1).equals(div.getYoshikiyonMeisai().getTxtshichoson().getValue())) {
            修正データ.get詳細データエリア().put(座標17_1, div.getYoshikiyonMeisai().getTxtshichoson().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標18_1).equals(div.getYoshikiyonMeisai().getTxtshonyu().getValue())) {
            修正データ.get詳細データエリア().put(座標18_1, div.getYoshikiyonMeisai().getTxtshonyu().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標19_1).equals(div.getYoshikiyonMeisai().getTxtsainyugokei().getValue())) {
            修正データ.get詳細データエリア().put(座標19_1, div.getYoshikiyonMeisai().getTxtsainyugokei().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標19_2).equals(div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue())) {
            修正データ.get詳細データエリア().put(座標19_2, div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標20_1).equals(div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue())) {
            修正データ.get詳細データエリア().put(座標20_1, div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue());
        }
        if (!list.get(i).get詳細データエリア().get(座標21_1).equals(div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue())) {
            修正データ.get詳細データエリア().put(座標21_1, div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue());
        }
    }

    /**
     * 入力項目いずれか空白ではない_前の判断。
     *
     */
    private boolean 入力項目いずれか空白ではない_前(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

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
        }
        return false;
    }

    /**
     * 入力項目いずれか空白ではない_後の判断。
     *
     */
    private boolean 入力項目いずれか空白ではない_後(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!RString.isNullOrEmpty(new RString(div.getYoshikiyonMeisai().getTxtshonyu().getValue().toString()))) {

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
        return false;
    }

    /**
     * 介護保険特別会計経理状況詳細データの新規。
     *
     */
    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> regKaigoHokenTokubetuKaikeiKeiriJyokyo(
            KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

            List<KaigoHokenJigyoHokokuNenpo> list = new ArrayList<>();
            list.add(kaigoHokenJigyoHokokuNenpo);
            manager.regKaigoHokenTokubetuKaikeiKeiriJyokyo(list);
        }
        return null;
    }

    /**
     * 介護保険特別会計経理状況詳細データの修正新規。
     *
     */
    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(
            KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

            List<KaigoHokenJigyoHokokuNenpo> list = new ArrayList<>();
            list.add(kaigoHokenJigyoHokokuNenpo);
            manager.regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(list);
        }
        return null;
    }

    /**
     * 介護保険特別会計経理状況詳細データの更新。
     *
     */
    private ResponseData<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div> updKaigoHokenTokubetuKaikeiKeiriJyokyo(
            KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {

            List<KaigoHokenJigyoHokokuNenpo> list = new ArrayList<>();
            list.add(kaigoHokenJigyoHokokuNenpo);
            manager.updKaigoHokenTokubetuKaikeiKeiriJyokyo(list);
        }
        return null;
    }

    /**
     * 詳細データエリアの設定。
     *
     */
    private void put詳細データエリア(
            Map<RString, Decimal> 詳細データエリア,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegist2Div div) {

        詳細データエリア.put(座標1_1, div.getYoshikiyonMeisai().getTxtkaigoshunyu().getValue());
        詳細データエリア.put(座標1_2, div.getYoshikiyonMeisai().getTxtsomu().getValue());
        詳細データエリア.put(座標2_1, div.getYoshikiyonMeisai().getTxtyoboshunyu().getValue());
        詳細データエリア.put(座標2_2, div.getYoshikiyonMeisai().getTxtitakusabisu().getValue());
        詳細データエリア.put(座標3_1, div.getYoshikiyonMeisai().getTxttokuteinyushoshunyu().getValue());
        詳細データエリア.put(座標3_2, div.getYoshikiyonMeisai().getTxtmitchaku().getValue());
        詳細データエリア.put(座標4_1, div.getYoshikiyonMeisai().getTxtjiki().getValue());
        詳細データエリア.put(座標4_2, div.getYoshikiyonMeisai().getTxtitakugaigoshien().getValue());
        詳細データエリア.put(座標5_1, div.getYoshikiyonMeisai().getTxtsotashunyu().getValue());
        詳細データエリア.put(座標5_2, div.getYoshikiyonMeisai().getTxtjigyosota().getValue());
        詳細データエリア.put(座標6_1, div.getYoshikiyonMeisai().getTxtbuntankin().getValue());
        詳細データエリア.put(座標6_2, div.getYoshikiyonMeisai().getTxtshisetsuseibi().getValue());
        詳細データエリア.put(座標7_1, div.getYoshikiyonMeisai().getTxtfutankin().getValue());
        詳細データエリア.put(座標7_2, div.getYoshikiyonMeisai().getTxtkikinsekin().getValue());
        詳細データエリア.put(座標8_1, div.getYoshikiyonMeisai().getTxtshiyohi().getValue());
        詳細データエリア.put(座標8_2, div.getYoshikiyonMeisai().getTxtkosai().getValue());
        詳細データエリア.put(座標9_1, div.getYoshikiyonMeisai().getTxttesuryo().getValue());
        詳細データエリア.put(座標9_2, div.getYoshikiyonMeisai().getTxtyobih().getValue());
        詳細データエリア.put(座標10_1, div.getYoshikiyonMeisai().getTxtkokko().getValue());
        詳細データエリア.put(座標10_2, div.getYoshikiyonMeisai().getTxtshoshishutsu().getValue());
        詳細データエリア.put(座標11_1, div.getYoshikiyonMeisai().getTxttodofuken().getValue());
        詳細データエリア.put(座標11_2, div.getYoshikiyonMeisai().getTxthokenkanjokuridasu().getValue());
        詳細データエリア.put(座標12_1, div.getYoshikiyonMeisai().getTxtzaisannyu().getValue());
        詳細データエリア.put(座標12_2, div.getYoshikiyonMeisai().getTxtshosonota().getValue());
        詳細データエリア.put(座標13_1, div.getYoshikiyonMeisai().getTxtkifukin().getValue());
        詳細データエリア.put(座標13_2, div.getYoshikiyonMeisai().getTxtshohi().getValue());
        詳細データエリア.put(座標14_1, div.getYoshikiyonMeisai().getTxthokenkanjokirijigyo().getValue());
        詳細データエリア.put(座標15_1, div.getYoshikiyonMeisai().getTxtchiikishienyobo().getValue());
        詳細データエリア.put(座標16_1, div.getYoshikiyonMeisai().getTxtkurikosu().getValue());
        詳細データエリア.put(座標17_1, div.getYoshikiyonMeisai().getTxtshichoson().getValue());
        詳細データエリア.put(座標18_1, div.getYoshikiyonMeisai().getTxtshonyu().getValue());
        詳細データエリア.put(座標19_1, div.getYoshikiyonMeisai().getTxtsainyugokei().getValue());
        詳細データエリア.put(座標19_2, div.getYoshikiyonMeisai().getTxtsaishutsugokei().getValue());
        詳細データエリア.put(座標20_1, div.getYoshikiyonMeisai().getTxtsainyushutsusa().getValue());
        詳細データエリア.put(座標21_1, div.getYoshikiyonMeisai().getTxtuchikikinkurigaku().getValue());
    }
}
