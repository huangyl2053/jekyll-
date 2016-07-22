/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0050031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.Shichoson;
import jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0050011.TaishokensakuJyouken.ViewStateKey;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.DBU0050031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.ValidationHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031.YoshikiYonnoniDiv;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護保険特別会計経理状況登録_様式４の２情報Divを制御します。
 *
 * @reamsid_L DBU-1130-030 liangbc
 */
public class YoshikiYonnoni {

    private static final RString UPDATE = new RString("modify");
    private static final RString DELETE = new RString("delete");
    private static final RString ADD = new RString("add");
    private static final RString 内部処理モード_修正追加 = new RString("修正追加");
    private static final RString 内部処理モード_修正 = new RString("修正");
    private static final RString 内部処理モード_削除 = new RString("削除");
    private static final RString 内部処理モード_追加 = new RString("追加");
    private static final int MONTH_6 = 6;
    private static final int INT_4 = 4;
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
    private static final RString 報告月 = new RString("00");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onload(YoshikiYonnoniDiv div) {

        InsuranceInformation insuranceInf = get引き継ぎデータ(div);
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        if (UPDATE.equals(insuranceInf.get処理フラグ())
                || DELETE.equals(insuranceInf.get処理フラグ())) {
            List<KaigoHokenJigyoHokokuNenpo> list = manager.getJigyoHokokuNenpoDetal(
                    insuranceInf.get報告年(),
                    new RString(insuranceInf.get集計対象年().toString()),
                    insuranceInf.get統計対象区分(),
                    insuranceInf.get市町村コード(),
                    集計番号_0200);
            div.getYoshikiYonnoniMeisai().getDdlShicyoson().setDisplayNone(true);
            div.getYoshikiYonnoniMeisai().getBtnKakutei().setDisplayNone(true);
            div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setValue(
                    new FlexibleDate(new RDate(insuranceInf.get報告年().getYearValue()).toString()));
            div.getYoshikiYonnoniMeisai().getTxtShukeiYM().setValue(
                    new FlexibleDate(new RDate(insuranceInf.get集計対象年().getYearValue()).toString()));
            div.getYoshikiYonnoniMeisai().getTxtHihokenshaNo().setValue(insuranceInf.get市町村コード().getColumnValue());
            div.getYoshikiYonnoniMeisai().getTxtHihokenshaName().setValue(insuranceInf.get市町村名称());
            if (list.isEmpty()) {
                div.setShoriMode(内部処理モード_修正追加);
                div.getYoshikiYonnoniMeisai().setDisabled(false);
                div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHihokenshaNo().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHihokenshaName().setDisabled(true);
            } else if (UPDATE.equals(insuranceInf.get処理フラグ())) {
                set詳細データエリア(list.get(0).get詳細データエリア(), div);
                div.getYoshikiYonnoniMeisai().setDisabled(false);
                div.getYoshikiButtonArea().getBtnYoshikiyon().setDisabled(false);
                div.getYoshikiButtonArea().getBtnYoshikiyonnoni().setDisabled(true);
                div.getYoshikiButtonArea().getBtnYoskiyonosan().setDisabled(false);
                div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtShukeiYM().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHihokenshaNo().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHihokenshaName().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getDdlShicyoson().setVisible(false);
                div.getYoshikiYonnoniMeisai().getBtnKakutei().setVisible(false);
                div.setShoriMode(内部処理モード_修正);
            } else {
                set詳細データエリア(list.get(0).get詳細データエリア(), div);
                this.btnDisabled(div, insuranceInf);
                div.getYoshikiYonnoniMeisai().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtShukeiYM().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHihokenshaNo().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getTxtHihokenshaName().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getDdlShicyoson().setVisible(false);
                div.getYoshikiYonnoniMeisai().getBtnKakutei().setVisible(false);
                div.setShoriMode(内部処理モード_削除);
            }
        } else if (ADD.equals(insuranceInf.get処理フラグ())) {
            div.getYoshikiYonnoniMeisai().setDisabled(false);
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
                div.getYoshikiYonnoniMeisai().getDdlShicyoson().setDataSource(市町村list);
                div.getYoshikiYonnoniMeisai().getDdlShicyoson().setSelectedIndex(0);
            }
            RDate date = RDate.getNowDate();
            if (date.getMonthValue() < MONTH_6) {
                int 報告年度 = date.getYearValue() - 1;
                div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setValue(new FlexibleDate(報告年度, 1, 1));
                int 集計年度 = date.getYearValue() - 2;
                div.getYoshikiYonnoniMeisai().getTxtShukeiYM().setValue(new FlexibleDate(集計年度, 1, 1));
            } else {
                int 報告年度 = date.getYearValue();
                div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setValue(new FlexibleDate(報告年度, 1, 1));
                int 集計年度 = date.getYearValue() - 1;
                div.getYoshikiYonnoniMeisai().getTxtShukeiYM().setValue(new FlexibleDate(集計年度, 1, 1));
            }
            div.getYoshikiButtonArea().getBtnYoshikiyon().setDisabled(false);
            div.getYoshikiButtonArea().getBtnYoshikiyonnoni().setDisabled(true);
            div.getYoshikiButtonArea().getBtnYoskiyonosan().setDisabled(false);
            div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setReadOnly(false);
            div.getYoshikiYonnoniMeisai().getTxtShukeiYM().setReadOnly(true);
            div.getYoshikiYonnoniMeisai().getTxtHihokenshaNo().setDisplayNone(true);
            div.getYoshikiYonnoniMeisai().getTxtHihokenshaName().setDisplayNone(true);
            div.getYoshikiYonnoniMeisai().getDdlShicyoson().setDisabled(false);
            div.getYoshikiYonnoniMeisai().getBtnKakutei().setDisabled(false);
            div.setShoriMode(内部処理モード_追加);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 様式４ボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnYoshikiyon(
            YoshikiYonnoniDiv div) {
        RString 内部処理モード = ResponseHolder.getState();
        if (DBU0050031StateName.修正状態.getName().equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ.get詳細データエリア() == null || 修正データ.get詳細データエリア().isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).parameter(内部処理モード_修正);
            } else {
                return this.messageAndGoto(DBU0050031TransitionEventName.様式４, div);
            }

        } else if (DBU0050031StateName.追加状態.getName().equals(内部処理モード)) {
            if (this.入力項目いずれか空白ではない(div)) {
                return this.messageAndGoto(DBU0050031TransitionEventName.様式４, div);
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).parameter(内部処理モード_追加);
            }
        } else if (DBU0050031StateName.削除状態.getName().equals(内部処理モード)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４).parameter(内部処理モード_削除);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 様式４の３ボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnYoskiyonosan(YoshikiYonnoniDiv div) {
        RString 内部処理モード = ResponseHolder.getState();
        if (DBU0050031StateName.修正状態.getName().equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ.get詳細データエリア() == null || 修正データ.get詳細データエリア().isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).parameter(内部処理モード_修正);
            } else {

                return this.messageAndGoto(DBU0050031TransitionEventName.様式４の３, div);
            }
        } else if (DBU0050031StateName.追加状態.getName().equals(内部処理モード)) {
            if (this.入力項目いずれか空白ではない(div)) {
                return this.messageAndGoto(DBU0050031TransitionEventName.様式４の３, div);

            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).parameter(内部処理モード_追加);
            }
        } else if (DBU0050031StateName.削除状態.getName().equals(内部処理モード)) {
            return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.様式４の３).parameter(内部処理モード_削除);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 報告年度を確定するボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnKakutei(YoshikiYonnoniDiv div) {

        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationHandler validationHandler = new ValidationHandler(div);
        validationHandler.報告年度の必須チェック(validationMessages);

        List<Shichoson> shichosonList = manager.getShichosonCodeNameList();
        TokeiTaishoKubun tokeiTaishoKubun = TokeiTaishoKubun.空;
        if (!shichosonList.isEmpty()) {

            for (int i = 0; i < shichosonList.size(); i++) {
                if (div.getYoshikiYonnoniMeisai().getDdlShicyoson().getSelectedKey().equals(shichosonList.get(i).get市町村コード().value())) {

                    tokeiTaishoKubun = shichosonList.get(i).get保険者区分();
                }
            }

            List<KaigoHokenJigyoHokokuNenpo> list = manager.getJigyoHokokuNenpoList(
                    new FlexibleDate(new RDate(div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getText().toString()).toString()).getYear(),
                    new LasdecCode(div.getYoshikiYonnoniMeisai().getDdlShicyoson().getSelectedKey().toString()),
                    tokeiTaishoKubun);

            if (list.isEmpty()) {
                div.getYoshikiYonnoniMeisai().getTxtHokokuYM().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getDdlShicyoson().setDisabled(true);
                div.getYoshikiYonnoniMeisai().getBtnKakutei().setDisabled(true);
                div.getYoshikiYonnoniMeisai().setDisabled(true);

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
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnAdd(YoshikiYonnoniDiv div) {

        if (this.入力項目いずれか空白ではない(div)) {
            return this.messageAndGoto(DBU0050031TransitionEventName.検索に戻る, div);
        }
        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
    }

    /**
     * 修正をやめるボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnUpdate(YoshikiYonnoniDiv div) {

        if (内部処理モード_修正.equals(div.getShoriMode())) {

            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ.get詳細データエリア().isEmpty()) {
                return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
            } else {
                this.messageAndGoto(DBU0050031TransitionEventName.検索に戻る, div);
            }
        } else if (内部処理モード_修正追加.equals(div.getShoriMode())
                && this.入力項目いずれか空白ではない(div)) {
            return this.messageAndGoto(DBU0050031TransitionEventName.検索に戻る, div);
        }

        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
    }

    /**
     * 削除をやめるボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnDelete(YoshikiYonnoniDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.検索に戻る).respond();
    }

    /**
     * 保存するボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnSave(YoshikiYonnoniDiv div) {

        InsuranceInformation insuranceInf = get引き継ぎデータ(div);
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();

        if (内部処理モード_追加.equals(div.getShoriMode())) {
            if (!this.入力項目いずれか空白ではない(div)) {

                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                Map<RString, Decimal> 詳細データエリア = new HashMap<>();

                this.put詳細データエリア(詳細データエリア, div);

                KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo = new KaigoHokenJigyoHokokuNenpo(
                        new FlexibleDate(new RDate(div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getText().toString()).toString()).getYear(),
                        new RString("00"),
                        new FlexibleDate(new RDate(div.getYoshikiYonnoniMeisai().getTxtShukeiYM().getText().toString()).toString()).getYear(),
                        new RString("00"),
                        insuranceInf.get統計対象区分(),
                        new LasdecCode(div.getYoshikiYonnoniMeisai().getDdlShicyoson().getSelectedKey().toString()),
                        new Code("09"),
                        CODE_0200,
                        new Code("1"),
                        div.getShoriMode(),
                        Code.EMPTY,
                        Code.EMPTY,
                        詳細データエリア);

                return this.regKaigoHokenTokubetuKaikeiKeiriJyokyo(kaigoHokenJigyoHokokuNenpo, manager, div);
            }
        } else if (内部処理モード_修正.equals(div.getShoriMode())) {
            KaigoHokenJigyoHokokuNenpo 修正データ = this.修正データの取得(div);
            if (修正データ == null) {
                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {
                return this.updKaigoHokenTokubetuKaikeiKeiriJyokyo(修正データ, manager, div);
            }

        } else if (内部処理モード_修正追加.equals(div.getShoriMode())) {
            if (!this.入力項目いずれか空白ではない(div)) {

                throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
            } else {

                Map<RString, Decimal> 詳細データエリア = new HashMap<>();

                this.put詳細データエリア(詳細データエリア, div);

                KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo = new KaigoHokenJigyoHokokuNenpo(
                        insuranceInf.get報告年(),
                        new RString("00"),
                        insuranceInf.get集計対象年(),
                        new RString("00"),
                        insuranceInf.get統計対象区分(),
                        insuranceInf.get市町村コード(),
                        new Code("09"),
                        CODE_0200,
                        new Code("1"),
                        div.getShoriMode(),
                        Code.EMPTY,
                        Code.EMPTY,
                        詳細データエリア);

                return regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(kaigoHokenJigyoHokokuNenpo, manager, div);
            }
        } else if (内部処理モード_削除.equals(div.getShoriMode())) {

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
                div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                        new RString(UrInformationMessages.正常終了.getMessage().replace("削除").evaluate()), RString.EMPTY, RString.EMPTY, true);
            }
        }

        return ResponseData.of(div).setState(DBU0050031StateName.完了状態);
    }

    /**
     * 完了するボタンを押す。
     *
     * @param div 画面情報
     * @return ResponseData<YoshikiYonnoniDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onClick_btnEnd(YoshikiYonnoniDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBU0050031TransitionEventName.処理完了).respond();
    }

    /**
     * 入力項目いずれか空白ではないことを判断。
     *
     * @param div 画面情報
     * @return 入力項目いずれか空白ではない
     */
    public boolean 入力項目いずれか空白ではない(YoshikiYonnoniDiv div) {

        boolean 空白_前 = this.入力項目いずれか空白ではない_前(div);
        boolean 空白_後 = this.入力項目いずれか空白ではない_後(div);

        return 空白_前 || 空白_後;
    }

    /**
     * 市町村名を取得します。
     *
     * @param div ShujiiMasterDiv
     * @return ResponseData<ShujiiMasterDiv>
     */
    public ResponseData<YoshikiYonnoniDiv> onBlur_txthokokuYM(YoshikiYonnoniDiv div) {
        RDate date = RDate.getNowDate();
        if (date.getYear().toDateString().equals(div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getText())) {
            if (date.getMonthValue() >= MONTH_6) {

                TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
                int 集計年度 = date.getYearValue() - 1;
                shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
                div.getYoshikiYonnoniMeisai().setTxtShukeiYM(shukeiY);
            } else {
                TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
                int 集計年度 = date.getYearValue() - 2;
                shukeiY.setValue(new FlexibleDate(String.valueOf(集計年度)));
                div.getYoshikiYonnoniMeisai().setTxtShukeiYM(shukeiY);
            }

        } else if (!div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getValue().isEmpty()) {

            TextBoxFlexibleDate shukeiY = new TextBoxFlexibleDate();
            int 集計年度 = Integer.parseInt(div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getText().substring(0, INT_4).toString()) - 1;
            shukeiY.setValue(new FlexibleDate(new StringBuilder(String.valueOf(集計年度)).append("0101").toString()));
            div.getYoshikiYonnoniMeisai().setTxtShukeiYM(shukeiY);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 修正データを取得します。
     *
     * @param div YoshikiYonnoniDiv
     * @return KaigoHokenJigyoHokokuNenpo
     */
    public KaigoHokenJigyoHokokuNenpo 修正データの取得(YoshikiYonnoniDiv div) {
        InsuranceInformation insuranceInf = get引き継ぎデータ(div);
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
            修正データ.set報告年(insuranceInf.get報告年());
            修正データ.set報告月(報告月);
            修正データ.set集計対象年(insuranceInf.get集計対象年());
            修正データ.set集計対象月(報告月);
            修正データ.set統計対象区分(insuranceInf.get統計対象区分());
            修正データ.set表番号(new Code("09"));
            修正データ.set集計番号(CODE_0200);
            修正データ.set集計単位(new Code("1"));
            修正データ.set市町村コード(insuranceInf.get市町村コード());
        }

        return 修正データ;
    }

    /**
     * 引き継ぎデータ取得処理です。
     *
     */
    private InsuranceInformation get引き継ぎデータ(YoshikiYonnoniDiv div) {
        InsuranceInformation 引き継ぎデータ
                = ViewStateHolder.get(ViewStateKey.様式４, InsuranceInformation.class);
        if (null == 引き継ぎデータ) {
            if (div.getYoshikiYonnoniMeisai().getDdlShicyoson().isDisplayNone()) {
                引き継ぎデータ = new InsuranceInformation(
                        ADD,
                        LasdecCode.EMPTY,
                        RString.EMPTY);
            } else {
                引き継ぎデータ = new InsuranceInformation(
                        ADD,
                        new LasdecCode(div.getYoshikiYonnoniMeisai().getDdlShicyoson().getSelectedKey()),
                        div.getYoshikiYonnoniMeisai().getDdlShicyoson().getSelectedValue());
            }
        }
        return 引き継ぎデータ;
    }

    /**
     * BtnYoshikiyonとBtnYoskiyonosanはDisabledになります。
     *
     */
    private void btnDisabled(YoshikiYonnoniDiv div, InsuranceInformation insuranceInf) {
        if (new RString("入力未").equals(insuranceInf.get様式４入力状況())) {
            div.getYoshikiButtonArea().getBtnYoshikiyon().setDisabled(true);
        }
        div.getYoshikiButtonArea().getBtnYoshikiyonnoni().setDisabled(true);
        if (new RString("入力未").equals(insuranceInf.get様式４の３入力状況())) {
            div.getYoshikiButtonArea().getBtnYoskiyonosan().setDisabled(true);
        }
    }

    /**
     * メッセージ出力、且つ画面遷移する。
     *
     */
    private ResponseData<YoshikiYonnoniDiv> messageAndGoto(
            IContainerEvents events, YoshikiYonnoniDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            if (DBU0050031TransitionEventName.検索に戻る.equals(events) || DBU0050031TransitionEventName.処理完了.equals(events)) {
                return ResponseData.of(div).forwardWithEventName(events).respond();
            } else if (内部処理モード_修正追加.equals(div.getShoriMode()) || RString.isNullOrEmpty(div.getShoriMode())) {
                return ResponseData.of(div).forwardWithEventName(events).parameter(内部処理モード_修正);
            } else {
                return ResponseData.of(div).forwardWithEventName(events).parameter(div.getShoriMode());
            }
        }
        return ResponseData.of(div).respond();
    }

    private boolean is変更あり(List<KaigoHokenJigyoHokokuNenpo> list, int i, RString 座標, Decimal value) {
        if (list.get(i).get詳細データエリア().get(座標) == null) {
            if (value != null) {
                return true;
            }
        } else if (!list.get(i).get詳細データエリア().get(座標).equals(value)) {
            return true;
        }
        return false;
    }

    /**
     * 修正データ１の取得する。
     *
     */
    private void 修正データの取得_１(
            KaigoHokenJigyoHokokuNenpo 修正データ,
            List<KaigoHokenJigyoHokokuNenpo> list,
            int i,
            YoshikiYonnoniDiv div) {
        if (is変更あり(list, i, 座標1_1, div.getYoshikiYonnoniMeisai().getTxtkaigoshunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標1_1, div.getYoshikiYonnoniMeisai().getTxtkaigoshunyu().getValue());
        }
        if (is変更あり(list, i, 座標1_2, div.getYoshikiYonnoniMeisai().getTxtsomu().getValue())) {
            修正データ.get詳細データエリア().put(座標1_2, div.getYoshikiYonnoniMeisai().getTxtsomu().getValue());
        }
        if (is変更あり(list, i, 座標2_1, div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標2_1, div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().getValue());
        }
        if (is変更あり(list, i, 座標2_2, div.getYoshikiYonnoniMeisai().getTxtitakusabisu().getValue())) {
            修正データ.get詳細データエリア().put(座標2_2, div.getYoshikiYonnoniMeisai().getTxtitakusabisu().getValue());
        }
        if (is変更あり(list, i, 座標3_1, div.getYoshikiYonnoniMeisai().getTxttokuteinyushoshunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標3_1, div.getYoshikiYonnoniMeisai().getTxttokuteinyushoshunyu().getValue());
        }
        if (is変更あり(list, i, 座標3_2, div.getYoshikiYonnoniMeisai().getTxtmitchaku().getValue())) {
            修正データ.get詳細データエリア().put(座標3_2, div.getYoshikiYonnoniMeisai().getTxtmitchaku().getValue());
        }
        if (is変更あり(list, i, 座標4_1, div.getYoshikiYonnoniMeisai().getTxtjiki().getValue())) {
            修正データ.get詳細データエリア().put(座標4_1, div.getYoshikiYonnoniMeisai().getTxtjiki().getValue());
        }
        if (is変更あり(list, i, 座標4_2, div.getYoshikiYonnoniMeisai().getTxtitakugaigoshien().getValue())) {
            修正データ.get詳細データエリア().put(座標4_2, div.getYoshikiYonnoniMeisai().getTxtitakugaigoshien().getValue());
        }
        if (is変更あり(list, i, 座標5_1, div.getYoshikiYonnoniMeisai().getTxtsotashunyu().getValue())) {
            修正データ.get詳細データエリア().put(座標5_1, div.getYoshikiYonnoniMeisai().getTxtsotashunyu().getValue());
        }
        if (is変更あり(list, i, 座標5_2, div.getYoshikiYonnoniMeisai().getTxtjigyosota().getValue())) {
            修正データ.get詳細データエリア().put(座標5_2, div.getYoshikiYonnoniMeisai().getTxtjigyosota().getValue());
        }
        if (is変更あり(list, i, 座標6_1, div.getYoshikiYonnoniMeisai().getTxtbuntankin().getValue())) {
            修正データ.get詳細データエリア().put(座標6_1, div.getYoshikiYonnoniMeisai().getTxtbuntankin().getValue());
        }
        if (is変更あり(list, i, 座標6_2, div.getYoshikiYonnoniMeisai().getTxtshisetsuseibi().getValue())) {
            修正データ.get詳細データエリア().put(座標6_2, div.getYoshikiYonnoniMeisai().getTxtshisetsuseibi().getValue());
        }
        if (is変更あり(list, i, 座標7_1, div.getYoshikiYonnoniMeisai().getTxtfutankin().getValue())) {
            修正データ.get詳細データエリア().put(座標7_1, div.getYoshikiYonnoniMeisai().getTxtfutankin().getValue());
        }
        if (is変更あり(list, i, 座標7_2, div.getYoshikiYonnoniMeisai().getTxtkikinsekin().getValue())) {
            修正データ.get詳細データエリア().put(座標7_2, div.getYoshikiYonnoniMeisai().getTxtkikinsekin().getValue());
        }
        if (is変更あり(list, i, 座標8_1, div.getYoshikiYonnoniMeisai().getTxtshiyohi().getValue())) {
            修正データ.get詳細データエリア().put(座標8_1, div.getYoshikiYonnoniMeisai().getTxtshiyohi().getValue());
        }
        if (is変更あり(list, i, 座標8_2, div.getYoshikiYonnoniMeisai().getTxtkosai().getValue())) {
            修正データ.get詳細データエリア().put(座標8_2, div.getYoshikiYonnoniMeisai().getTxtkosai().getValue());
        }
        if (is変更あり(list, i, 座標9_1, div.getYoshikiYonnoniMeisai().getTxttesuryo().getValue())) {
            修正データ.get詳細データエリア().put(座標9_1, div.getYoshikiYonnoniMeisai().getTxttesuryo().getValue());
        }
        if (is変更あり(list, i, 座標9_2, div.getYoshikiYonnoniMeisai().getTxtyobih().getValue())) {
            修正データ.get詳細データエリア().put(座標9_2, div.getYoshikiYonnoniMeisai().getTxtyobih().getValue());

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
            YoshikiYonnoniDiv div) {

        if (is変更あり(list, i, 座標10_1, div.getYoshikiYonnoniMeisai().getTxtkokko().getValue())) {
            修正データ.get詳細データエリア().put(座標10_1, div.getYoshikiYonnoniMeisai().getTxtkokko().getValue());
        }
        if (is変更あり(list, i, 座標10_2, div.getYoshikiYonnoniMeisai().getTxtshoshishutsu().getValue())) {
            修正データ.get詳細データエリア().put(座標10_2, div.getYoshikiYonnoniMeisai().getTxtshoshishutsu().getValue());
        }
        if (is変更あり(list, i, 座標11_1, div.getYoshikiYonnoniMeisai().getTxttodofuken().getValue())) {
            修正データ.get詳細データエリア().put(座標11_1, div.getYoshikiYonnoniMeisai().getTxttodofuken().getValue());
        }
        if (is変更あり(list, i, 座標11_2, div.getYoshikiYonnoniMeisai().getTxthokenkanjokuridasu().getValue())) {
            修正データ.get詳細データエリア().put(座標11_2, div.getYoshikiYonnoniMeisai().getTxthokenkanjokuridasu().getValue());
        }
        if (is変更あり(list, i, 座標12_1, div.getYoshikiYonnoniMeisai().getTxtzaisannyu().getValue())) {
            修正データ.get詳細データエリア().put(座標12_1, div.getYoshikiYonnoniMeisai().getTxtzaisannyu().getValue());
        }
        if (is変更あり(list, i, 座標12_2, div.getYoshikiYonnoniMeisai().getTxtshosonota().getValue())) {
            修正データ.get詳細データエリア().put(座標12_2, div.getYoshikiYonnoniMeisai().getTxtshosonota().getValue());
        }
        if (is変更あり(list, i, 座標13_1, div.getYoshikiYonnoniMeisai().getTxtkifukin().getValue())) {
            修正データ.get詳細データエリア().put(座標13_1, div.getYoshikiYonnoniMeisai().getTxtkifukin().getValue());
        }
        if (is変更あり(list, i, 座標13_2, div.getYoshikiYonnoniMeisai().getTxtshohi().getValue())) {
            修正データ.get詳細データエリア().put(座標13_2, div.getYoshikiYonnoniMeisai().getTxtshohi().getValue());
        }
        if (is変更あり(list, i, 座標14_1, div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().getValue())) {
            修正データ.get詳細データエリア().put(座標14_1, div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().getValue());
        }
        if (is変更あり(list, i, 座標15_1, div.getYoshikiYonnoniMeisai().getTxtchiikishienyobo().getValue())) {
            修正データ.get詳細データエリア().put(座標15_1, div.getYoshikiYonnoniMeisai().getTxtchiikishienyobo().getValue());
        }
        if (is変更あり(list, i, 座標16_1, div.getYoshikiYonnoniMeisai().getTxtkurikosu().getValue())) {
            修正データ.get詳細データエリア().put(座標16_1, div.getYoshikiYonnoniMeisai().getTxtkurikosu().getValue());
        }
        if (is変更あり(list, i, 座標17_1, div.getYoshikiYonnoniMeisai().getTxtshichoson().getValue())) {
            修正データ.get詳細データエリア().put(座標17_1, div.getYoshikiYonnoniMeisai().getTxtshichoson().getValue());
        }
        if (is変更あり(list, i, 座標18_1, div.getYoshikiYonnoniMeisai().getTxtshonyu().getValue())) {
            修正データ.get詳細データエリア().put(座標18_1, div.getYoshikiYonnoniMeisai().getTxtshonyu().getValue());
        }
        if (is変更あり(list, i, 座標19_1, div.getYoshikiYonnoniMeisai().getTxtsainyugokei().getValue())) {
            修正データ.get詳細データエリア().put(座標19_1, div.getYoshikiYonnoniMeisai().getTxtsainyugokei().getValue());
        }
        if (is変更あり(list, i, 座標19_2, div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei().getValue())) {
            修正データ.get詳細データエリア().put(座標19_2, div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei().getValue());
        }
        if (is変更あり(list, i, 座標20_1, div.getYoshikiYonnoniMeisai().getTxtsainyushutsusa().getValue())) {
            修正データ.get詳細データエリア().put(座標20_1, div.getYoshikiYonnoniMeisai().getTxtsainyushutsusa().getValue());
        }
        if (is変更あり(list, i, 座標21_1, div.getYoshikiYonnoniMeisai().getTxtuchikikinkurigaku().getValue())) {
            修正データ.get詳細データエリア().put(座標21_1, div.getYoshikiYonnoniMeisai().getTxtuchikikinkurigaku().getValue());

        }
    }

    /**
     * 入力項目いずれか空白ではない_前の判断。
     *
     */
    private boolean 入力項目いずれか空白ではない_前(YoshikiYonnoniDiv div) {

        if (div.getYoshikiYonnoniMeisai().getTxtkaigoshunyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxttokuteinyushoshunyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtjiki().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtsotashunyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtfutankin().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtshiyohi().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxttesuryo().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtkokko().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxttodofuken().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtzaisannyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtkifukin().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtchiikishienyobo().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtkurikosu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtshichoson().getValue() != null) {

            return true;
        }
        return false;
    }

    /**
     * 入力項目いずれか空白ではない_後の判断。
     *
     */
    private boolean 入力項目いずれか空白ではない_後(YoshikiYonnoniDiv div) {

        if (div.getYoshikiYonnoniMeisai().getTxtshonyu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtsainyugokei().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtsomu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtitakusabisu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtmitchaku().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtitakugaigoshien().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtjigyosota().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtshisetsuseibi().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtkikinsekin().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtkosai().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtyobih().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtshoshishutsu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxthokenkanjokuridasu().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtshosonota().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtshohi().getValue() != null) {

            return true;
        } else if (div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei().getValue() != null) {

            return true;
        }
        return false;
    }

    /**
     * 介護保険特別会計経理状況詳細データの新規。
     *
     */
    private ResponseData<YoshikiYonnoniDiv> regKaigoHokenTokubetuKaikeiKeiriJyokyo(
            KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager,
            YoshikiYonnoniDiv div) {

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
        } else {
            return ResponseData.of(div).respond();
        }
        div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                new RString(UrInformationMessages.正常終了.getMessage().replace("登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBU0050031StateName.完了状態);
    }

    /**
     * 介護保険特別会計経理状況詳細データの修正新規。
     *
     */
    private ResponseData<YoshikiYonnoniDiv> regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(
            KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager,
            YoshikiYonnoniDiv div) {

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
        } else {
            return ResponseData.of(div).respond();
        }
        div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                new RString(UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBU0050031StateName.完了状態);
    }

    /**
     * 介護保険特別会計経理状況詳細データの更新。
     *
     */
    private ResponseData<YoshikiYonnoniDiv> updKaigoHokenTokubetuKaikeiKeiriJyokyo(
            KaigoHokenJigyoHokokuNenpo kaigoHokenJigyoHokokuNenpo,
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager manager,
            YoshikiYonnoniDiv div) {

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
        } else {
            return ResponseData.of(div).respond();
        }
        div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                new RString(UrInformationMessages.正常終了.getMessage().replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBU0050031StateName.完了状態);
    }

    /**
     * 詳細データエリアの設定。
     *
     */
    private void put詳細データエリア(
            Map<RString, Decimal> 詳細データエリア,
            YoshikiYonnoniDiv div) {

        詳細データエリア.put(座標1_1, div.getYoshikiYonnoniMeisai().getTxtkaigoshunyu().getValue());
        詳細データエリア.put(座標1_2, div.getYoshikiYonnoniMeisai().getTxtsomu().getValue());
        詳細データエリア.put(座標2_1, div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().getValue());
        詳細データエリア.put(座標2_2, div.getYoshikiYonnoniMeisai().getTxtitakusabisu().getValue());
        詳細データエリア.put(座標3_1, div.getYoshikiYonnoniMeisai().getTxttokuteinyushoshunyu().getValue());
        詳細データエリア.put(座標3_2, div.getYoshikiYonnoniMeisai().getTxtmitchaku().getValue());
        詳細データエリア.put(座標4_1, div.getYoshikiYonnoniMeisai().getTxtjiki().getValue());
        詳細データエリア.put(座標4_2, div.getYoshikiYonnoniMeisai().getTxtitakugaigoshien().getValue());
        詳細データエリア.put(座標5_1, div.getYoshikiYonnoniMeisai().getTxtsotashunyu().getValue());
        詳細データエリア.put(座標5_2, div.getYoshikiYonnoniMeisai().getTxtjigyosota().getValue());
        詳細データエリア.put(座標6_1, div.getYoshikiYonnoniMeisai().getTxtbuntankin().getValue());
        詳細データエリア.put(座標6_2, div.getYoshikiYonnoniMeisai().getTxtshisetsuseibi().getValue());
        詳細データエリア.put(座標7_1, div.getYoshikiYonnoniMeisai().getTxtfutankin().getValue());
        詳細データエリア.put(座標7_2, div.getYoshikiYonnoniMeisai().getTxtkikinsekin().getValue());
        詳細データエリア.put(座標8_1, div.getYoshikiYonnoniMeisai().getTxtshiyohi().getValue());
        詳細データエリア.put(座標8_2, div.getYoshikiYonnoniMeisai().getTxtkosai().getValue());
        詳細データエリア.put(座標9_1, div.getYoshikiYonnoniMeisai().getTxttesuryo().getValue());
        詳細データエリア.put(座標9_2, div.getYoshikiYonnoniMeisai().getTxtyobih().getValue());
        詳細データエリア.put(座標10_1, div.getYoshikiYonnoniMeisai().getTxtkokko().getValue());
        詳細データエリア.put(座標10_2, div.getYoshikiYonnoniMeisai().getTxtshoshishutsu().getValue());
        詳細データエリア.put(座標11_1, div.getYoshikiYonnoniMeisai().getTxttodofuken().getValue());
        詳細データエリア.put(座標11_2, div.getYoshikiYonnoniMeisai().getTxthokenkanjokuridasu().getValue());
        詳細データエリア.put(座標12_1, div.getYoshikiYonnoniMeisai().getTxtzaisannyu().getValue());
        詳細データエリア.put(座標12_2, div.getYoshikiYonnoniMeisai().getTxtshosonota().getValue());
        詳細データエリア.put(座標13_1, div.getYoshikiYonnoniMeisai().getTxtkifukin().getValue());
        詳細データエリア.put(座標13_2, div.getYoshikiYonnoniMeisai().getTxtshohi().getValue());
        詳細データエリア.put(座標14_1, div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().getValue());
        詳細データエリア.put(座標15_1, div.getYoshikiYonnoniMeisai().getTxtchiikishienyobo().getValue());
        詳細データエリア.put(座標16_1, div.getYoshikiYonnoniMeisai().getTxtkurikosu().getValue());
        詳細データエリア.put(座標17_1, div.getYoshikiYonnoniMeisai().getTxtshichoson().getValue());
        詳細データエリア.put(座標18_1, div.getYoshikiYonnoniMeisai().getTxtshonyu().getValue());
        詳細データエリア.put(座標19_1, div.getYoshikiYonnoniMeisai().getTxtsainyugokei().getValue());
        詳細データエリア.put(座標19_2, div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei().getValue());
        詳細データエリア.put(座標20_1, div.getYoshikiYonnoniMeisai().getTxtsainyushutsusa().getValue());
        詳細データエリア.put(座標21_1, div.getYoshikiYonnoniMeisai().getTxtuchikikinkurigaku().getValue());
    }

    /**
     * 詳細データエリアの設定。
     *
     */
    private void set詳細データエリア(
            Map<RString, Decimal> 詳細データエリア,
            YoshikiYonnoniDiv div) {

        div.getYoshikiYonnoniMeisai().getTxtkaigoshunyu().setValue(詳細データエリア.get(座標1_1));
        div.getYoshikiYonnoniMeisai().getTxtsomu().setValue(詳細データエリア.get(座標1_2));
        div.getYoshikiYonnoniMeisai().getTxtyoboshunyu().setValue(詳細データエリア.get(座標2_1));
        div.getYoshikiYonnoniMeisai().getTxtitakusabisu().setValue(詳細データエリア.get(座標2_2));
        div.getYoshikiYonnoniMeisai().getTxttokuteinyushoshunyu().setValue(詳細データエリア.get(座標3_1));
        div.getYoshikiYonnoniMeisai().getTxtmitchaku().setValue(詳細データエリア.get(座標3_2));
        div.getYoshikiYonnoniMeisai().getTxtjiki().setValue(詳細データエリア.get(座標4_1));
        div.getYoshikiYonnoniMeisai().getTxtitakugaigoshien().setValue(詳細データエリア.get(座標4_2));
        div.getYoshikiYonnoniMeisai().getTxtsotashunyu().setValue(詳細データエリア.get(座標5_1));
        div.getYoshikiYonnoniMeisai().getTxtjigyosota().setValue(詳細データエリア.get(座標5_2));
        div.getYoshikiYonnoniMeisai().getTxtbuntankin().setValue(詳細データエリア.get(座標6_1));
        div.getYoshikiYonnoniMeisai().getTxtshisetsuseibi().setValue(詳細データエリア.get(座標6_2));
        div.getYoshikiYonnoniMeisai().getTxtfutankin().setValue(詳細データエリア.get(座標7_1));
        div.getYoshikiYonnoniMeisai().getTxtkikinsekin().setValue(詳細データエリア.get(座標7_2));
        div.getYoshikiYonnoniMeisai().getTxtshiyohi().setValue(詳細データエリア.get(座標8_1));
        div.getYoshikiYonnoniMeisai().getTxtkosai().setValue(詳細データエリア.get(座標8_2));
        div.getYoshikiYonnoniMeisai().getTxttesuryo().setValue(詳細データエリア.get(座標9_1));
        div.getYoshikiYonnoniMeisai().getTxtyobih().setValue(詳細データエリア.get(座標9_2));
        div.getYoshikiYonnoniMeisai().getTxtkokko().setValue(詳細データエリア.get(座標10_1));
        div.getYoshikiYonnoniMeisai().getTxtshoshishutsu().setValue(詳細データエリア.get(座標10_2));
        div.getYoshikiYonnoniMeisai().getTxttodofuken().setValue(詳細データエリア.get(座標11_1));
        div.getYoshikiYonnoniMeisai().getTxthokenkanjokuridasu().setValue(詳細データエリア.get(座標11_2));
        div.getYoshikiYonnoniMeisai().getTxtzaisannyu().setValue(詳細データエリア.get(座標12_1));
        div.getYoshikiYonnoniMeisai().getTxtshosonota().setValue(詳細データエリア.get(座標12_2));
        div.getYoshikiYonnoniMeisai().getTxtkifukin().setValue(詳細データエリア.get(座標13_1));
        div.getYoshikiYonnoniMeisai().getTxtshohi().setValue(詳細データエリア.get(座標13_2));
        div.getYoshikiYonnoniMeisai().getTxthokenkanjokirijigyo().setValue(詳細データエリア.get(座標14_1));
        div.getYoshikiYonnoniMeisai().getTxtchiikishienyobo().setValue(詳細データエリア.get(座標15_1));
        div.getYoshikiYonnoniMeisai().getTxtkurikosu().setValue(詳細データエリア.get(座標16_1));
        div.getYoshikiYonnoniMeisai().getTxtshichoson().setValue(詳細データエリア.get(座標17_1));
        div.getYoshikiYonnoniMeisai().getTxtshonyu().setValue(詳細データエリア.get(座標18_1));
        div.getYoshikiYonnoniMeisai().getTxtsainyugokei().setValue(詳細データエリア.get(座標19_1));
        div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei().setValue(詳細データエリア.get(座標19_2));
        div.getYoshikiYonnoniMeisai().getTxtsainyushutsusa().setValue(詳細データエリア.get(座標20_1));
        div.getYoshikiYonnoniMeisai().getTxtuchikikinkurigaku().setValue(詳細データエリア.get(座標21_1));
    }
}
