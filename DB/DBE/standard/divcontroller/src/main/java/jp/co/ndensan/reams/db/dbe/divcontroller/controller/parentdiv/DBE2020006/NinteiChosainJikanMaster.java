/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020006;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainjikan.NinteiChosainBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.DBE2020006StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.NinteiChosainJikanMasterDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.dgTimeScheduleList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020006.NinteiChosainJikanMasterHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020006.NinteiChosainJikanMasterValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosainjikan.NinteiChosainJikanMasterManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaScheduleIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosaikkatsuinput.NinteiChosaIkkatsuInputModel;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Seireki;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査スケジュール登録6のコントローラです。
 *
 * @reamsid_L DBE-0022-010 linghuhang
 */
public class NinteiChosainJikanMaster {

    private static final int 時間枠_1 = 1;
    private static final int 時間枠_2 = 2;
    private static final int 時間枠_3 = 3;
    private static final int 時間枠_4 = 4;
    private static final int 時間枠_5 = 5;
    private static final int 時間枠_6 = 6;
    private static final int 時間枠_7 = 7;
    private static final int 時間枠_8 = 8;
    private static final int 時間枠_9 = 9;
    private static final int 時間枠_10 = 10;
    private static final int 時間枠数 = 11;
    private final RString 予約フラグ_可 = new RString("key0");
    private final RString 予約フラグ_不可 = new RString("key1");
    private final RString 処理区分_未処理 = new RString("0");
    private final RString 処理区分_削除 = new RString("3");
    private final RString 処理区分_新規 = new RString("1");
    private final RString 処理区分_更新 = new RString("2");
    private final RString 編集状態_未指定 = new RString("1");
    private final RString 編集状態_既存 = new RString("2");
    private final RString 保存 = new RString("保存");

    /**
     * コンストラクタです。
     */
    public NinteiChosainJikanMaster() {
    }

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> onLoad(NinteiChosainJikanMasterDiv div) {

        getHandler(div).onLoad(new FlexibleDate(RDate.getNowDate().toDateString()));
        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                    UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
            throw new ApplicationException(message);
        }
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「前月へ」ボタンを押下する、設定年月、日付は前月連動表示します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnPrevious(NinteiChosainJikanMasterDiv div) {
        FlexibleDate 設定年月 = div.getTxtSettingMonth().getValue();
        div.getTxtSettingMonth().setValue(設定年月.minusMonth(1));
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();

        if (認定調査委託先コード == null || 認定調査委託先コード.isEmpty()
                || 認定調査員コード == null || 認定調査員コード.isEmpty()) {
            div.getTxtSettingMonth().setValue(設定年月.minusMonth(1));
            getHandler(div).onLoad(div.getTxtSettingMonth().getValue());
        }
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
        List<NinteiChosainBusiness> 認定調査情報List = get認定調査情報(
                div.getTxtSettingMonth().getValue(),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        if (認定調査情報List == null || 認定調査情報List.isEmpty()) {
            div.getTxtSettingMonth().setValue(設定年月.minusMonth(1));
            getHandler(div).onLoad(div.getTxtSettingMonth().getValue());
        } else {
            getHandler(div).btnSearch(認定調査情報List);
        }
        setModel時間枠設定一覧情報(
                認定調査情報List,
                div.getTxtSettingMonth().getValue(),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「次月へ」ボタンを押下する、設定年月、日付は前月連動表示します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnNext(NinteiChosainJikanMasterDiv div) {
        FlexibleDate 設定年月 = div.getTxtSettingMonth().getValue();
        div.getTxtSettingMonth().setValue(設定年月.plusMonth(1));
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        if (認定調査委託先コード == null || 認定調査委託先コード.isEmpty()
                || 認定調査員コード == null || 認定調査員コード.isEmpty()) {
            div.getTxtSettingMonth().setValue(設定年月.plusMonth(1));
            getHandler(div).onLoad(div.getTxtSettingMonth().getValue());
        }
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
        List<NinteiChosainBusiness> 認定調査情報List = get認定調査情報(
                div.getTxtSettingMonth().getValue(),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        if (認定調査情報List == null || 認定調査情報List.isEmpty()) {
            div.getTxtSettingMonth().setValue(設定年月.plusMonth(1));
            getHandler(div).onLoad(div.getTxtSettingMonth().getValue());
        } else {
            getHandler(div).btnSearch(認定調査情報List);
        }
        setModel時間枠設定一覧情報(
                認定調査情報List,
                div.getTxtSettingMonth().getValue(),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「対象地区」DDLの値を変更する場合、画面を初期化する。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> ddlHenkou(NinteiChosainJikanMasterDiv div) {
        div.getMainPanel().getSearchConditionPanel().setTaishoChikuKey(div.getDdlTaishoChiku().getSelectedKey());
        getHandler(div).onLoad(div.getTxtSettingMonth().getValue());
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「設定年月の時間枠を検索する」ボタンを押下する、時間枠設定一覧情報を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnSearch(NinteiChosainJikanMasterDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSearch();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        KijuntsukiShichosonjohoiDataPassModel model = new KijuntsukiShichosonjohoiDataPassModel();
        model.setサブ業務コード(SubGyomuCode.DBE認定支援.getColumnValue());
        model.set対象モード(new RString("Chosain"));
        div.setHdnDataPass(DataPassingConverter.serialize(model));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「設定年月の時間枠を検索する」ボタンのOKClose時の処理を行います。<br/>
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> onOkClose_btnSenTaKuSearch(NinteiChosainJikanMasterDiv div) {
        KijuntsukiShichosonjohoiDataPassModel models = DataPassingConverter.deserialize(div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        div.getTxtNinteiChosaItakusakiCode().setValue(models.get委託先コード());
        div.getTxtNinteiChosaItakusakiName().setValue(models.get委託先名());
        div.getTxtNinteiChosainCode().setValue(models.get調査員コード());
        div.getTxtNinteiChosainName().setValue(models.get調査員名());
        LasdecCode 市町村コード = new LasdecCode(models.get市町村コード());
        div.getMainPanel().getSearchConditionPanel().setHiddenShichosonCode(市町村コード.getColumnValue());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        List<NinteiChosainBusiness> 認定調査情報List = get認定調査情報(
                div.getTxtSettingMonth().getValue(),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        getHandler(div).btnSearch(認定調査情報List);
        setModel時間枠設定一覧情報(
                認定調査情報List,
                div.getTxtSettingMonth().getValue(),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        div.getMainPanel().getBtnNinteiChosaIkkatsuInput().setDisabled(false);
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu1(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku01()), new RString("1"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu2(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku02()), new RString("2"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu3(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku03()), new RString("3"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu4(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku04()), new RString("4"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu5(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku05()), new RString("5"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu6(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku06()), new RString("6"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu7(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku07()), new RString("7"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu8(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku08()), new RString("8"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu9(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku09()), new RString("9"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 編集ボタンを押下する場合、時間枠設定を設定します。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnHennsyu10(NinteiChosainJikanMasterDiv div) {
        if (未来日の確認(div)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode(),
                        DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbeQuestionMessages.処理日より過去のスケジュールを変更.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        dgTimeScheduleList_Row 編集データ = div.getDgTimeScheduleList().getActiveRow();
        時間枠編集の設定(div, 編集データ, nullToEmpty(編集データ.getChosaJikanwaku10()), new RString("10"));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「中止する」ボタンを押下する場合、時間枠設定Divを閉じる。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnAbort(NinteiChosainJikanMasterDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getMainPanel().getSettingDetail().setDisplayNone(true);
            div.getDgTimeScheduleList().setReadOnly(false);
            div.getMainPanel().getSettingDetail().getTxtBiko().clearValue();
        }
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「削除する」ボタンを押下する場合、時間枠設定Divを閉じる。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnDelete(NinteiChosainJikanMasterDiv div) {
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
        Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels
                = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール情報, Models.class);
        if (!ResponseHolder.isReRequest()) {
            WarningMessage message = new WarningMessage(UrWarningMessages.削除の確認.getMessage().getCode(),
                    UrWarningMessages.削除の確認.getMessage().replace(new RString("該当時間枠情報").toString()).evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrWarningMessages.削除の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            NinteichosaScheduleIdentifier 情報PK = new NinteichosaScheduleIdentifier(
                    new FlexibleDate(div.getTxtSetteiYMD().getValue().toDateString()),
                    時間の処理(div.getTxtKaishiJikan().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm)),
                    時間の処理(div.getTxtShuryoJikan().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm)),
                    new Code(div.getTxtJikanWaku().getValue()),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            ninteichosaModels.deleteOrRemove(情報PK);
            getHandler(div).btnDelete(
                    new FlexibleDate(div.getMainPanel().getTxtSetteiYMD().getValue().toString()),
                    div.getMainPanel().getTxtJikanWaku().getValue());
            div.getMainPanel().getSettingDetail().setDisplayNone(true);
        }
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール情報, Models.create(ninteichosaModels));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「登録する」ボタンを押下する場合、時間枠設定Divを閉じる。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnCreate(NinteiChosainJikanMasterDiv div) {
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
        Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels
                = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール情報, Models.class);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForCreate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (編集状態_既存.equals(div.getMainPanel().getSettingDetail().getHensyuTajyo())) {
            NinteichosaScheduleIdentifier 情報PK = new NinteichosaScheduleIdentifier(
                    new FlexibleDate(div.getTxtSetteiYMD().getValue().toDateString()),
                    時間の処理(div.getTxtKaishiJikan().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm)),
                    時間の処理(div.getTxtShuryoJikan().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm)),
                    new Code(div.getTxtJikanWaku().getValue()),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            ninteichosaModels.add(ninteichosaModels.get(情報PK).
                    createBuilderForEdit().set予約可能フラグ(is予約可能フラグ(div.getRadYoyaku().getSelectedKey()))
                    .set備考(div.getTxtBiko().getValue())
                    .build());
        } else {
            NinteichosaSchedule 情報 = new NinteichosaSchedule(
                    new FlexibleDate(div.getTxtSetteiYMD().getValue().toDateString()),
                    時間の処理(div.getTxtKaishiJikan().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm)),
                    時間の処理(div.getTxtShuryoJikan().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm)),
                    new Code(div.getTxtJikanWaku().getValue()),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            NinteichosaSchedule nintei = getHandler(div).editNinteichosaSchedule(情報);
            ninteichosaModels.add(nintei);
        }

        getHandler(div).btnCreate(new FlexibleDate(div.getMainPanel().getTxtSetteiYMD().getValue().toString()),
                div.getMainPanel().getTxtJikanWaku().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール情報, Models.create(ninteichosaModels));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「一括設定する」ボタンを押下する場合、時間枠設定Divを閉じる。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnNinteiChosaIkkatsuInput(NinteiChosainJikanMasterDiv div) {
        List<dgTimeScheduleList_Row> 編集内容 = div.getDgTimeScheduleList().getDataSource();
        boolean 編集内容Flag = false;
        for (dgTimeScheduleList_Row row : 編集内容) {
            if (RString.isNullOrEmpty(row.getChosaJikanwaku01())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku02())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku03())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku04())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku05())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku06())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku07())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku08())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku09())
                    && RString.isNullOrEmpty(row.getChosaJikanwaku10()
                    )) {
                continue;
            }
            編集内容Flag = true;
            break;
        }
        NinteiChosaIkkatsuInputModel model = new NinteiChosaIkkatsuInputModel();
        model.set設定年月(new FlexibleDate(div.getTxtSettingMonth().getValue().getYearMonth().toDateString()));
        div.setNinteiChosaIkkatsuInputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 調査時間一括設定のOKClose時の処理を行います。<br/>
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> onOkClose_btnSenTaKu(NinteiChosainJikanMasterDiv div) {
        getHandler(div).btnNinteiChosaIkkatsuInput();
        btnNinteiChosaModel(div);
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    /**
     * 「保存する」ボタンを押下する場合、処理完了メッセージを表示する。
     *
     * @param div NinteiChosainJikanMasterDiv
     * @return ResponseData<NinteiChosainJikanMasterDiv>
     */
    public ResponseData<NinteiChosainJikanMasterDiv> btnSave(NinteiChosainJikanMasterDiv div) {
        Seireki 設定年月 = div.getTxtSettingMonth().getValue().seireki();
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            前排他キーの解除();
            boolean gotLock = 前排他キーのセット();
            if (!gotLock) {
                ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                        UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
                throw new ApplicationException(message);
            }
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels
                    = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール情報, Models.class);
            List<dgTimeScheduleList_Row> 画面データ = div.getDgTimeScheduleList().getDataSource();
            for (dgTimeScheduleList_Row row : 画面データ) {
                FlexibleDate 予定年月日
                        = new FlexibleDate(Integer.parseInt(設定年月.getYear().toString()),
                                Integer.parseInt(設定年月.getMonth().toString()),
                                Integer.parseInt(row.getDate().toString()));
                保存の処理(row, 予定年月日, 調査地区コード,
                        認定調査委託先コード,
                        認定調査員コード,
                        市町村コード,
                        ninteichosaModels);
            }
            div.getKanryoMessage().getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(保存.toString()).evaluate()), RString.EMPTY, RString.EMPTY);
            前排他キーの解除();
            return ResponseData.of(div).setState(DBE2020006StateName.完了);
        }
        return ResponseData.of(div).setState(DBE2020006StateName.編集);
    }

    private NinteiChosainJikanMasterHandler getHandler(NinteiChosainJikanMasterDiv div) {
        return new NinteiChosainJikanMasterHandler(div);
    }

    private NinteiChosainJikanMasterValidationHandler getValidationHandler(NinteiChosainJikanMasterDiv div) {
        return new NinteiChosainJikanMasterValidationHandler(div);
    }

    private static List<NinteiChosainBusiness> get認定調査情報(
            FlexibleDate 設定年月,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        return NinteiChosainJikanMasterManager.createInstance().
                get時間枠設定一覧情報(
                        設定年月,
                        調査地区コード,
                        認定調査委託先コード,
                        認定調査員コード,
                        市町村コード).records();
    }

    private void 時間枠編集の設定(
            NinteiChosainJikanMasterDiv div,
            dgTimeScheduleList_Row 編集データ,
            RString 調査時間枠,
            RString 時間枠) {
        if (編集状態_既存.equals(編集状態の設定(調査時間枠))) {
            Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
            RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
            RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
            LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels
                    = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール情報, Models.class);
            FlexibleDate 認定調査予定日 = new FlexibleDate(
                    div.getTxtSettingMonth().getValue().getYearValue(),
                    div.getTxtSettingMonth().getValue().getMonthValue(),
                    Integer.parseInt(編集データ.getDate().toString()));
            RString 開始時間 = 時間の処理(調査時間枠.split("-").get(0));
            RString 終了時間 = 時間の処理(調査時間枠.split("-").get(1));
            NinteichosaScheduleIdentifier 情報PK = new NinteichosaScheduleIdentifier(
                    認定調査予定日,
                    開始時間,
                    終了時間,
                    new Code(時間枠),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            if (ninteichosaModels.contains(情報PK)) {
                div.getTxtBiko().setValue(ninteichosaModels.get(情報PK).get備考());
                div.getRadYoyaku().setSelectedKey(予約可否設定(ninteichosaModels.get(情報PK).is予約可能フラグ()));
                div.getDdlTaishoChiku().setDisabled(true);
                div.getTxtSettingMonth().setDisabled(true);
                div.getBtnPrevious().setDisabled(true);
                div.getBtnNext().setDisabled(true);
                div.getBtnSearch().setDisabled(true);
                div.getDgTimeScheduleList().setReadOnly(true);
                div.getMainPanel().getBtnNinteiChosaIkkatsuInput().setDisabled(true);
                div.getMainPanel().getSettingDetail().setDisplayNone(false);
                div.getMainPanel().getSettingDetail().setHensyuTajyo(編集状態_既存);
                div.getTxtSetteiYMD().setValue(new RDate(認定調査予定日.toString()));
                div.getTxtJikanWaku().setValue(時間枠);
                div.getTxtKaishiJikan().setValue(RTime.parse(調査時間枠.split("-").get(0)));
                div.getTxtShuryoJikan().setValue(RTime.parse(調査時間枠.split("-").get(1)));

            } else {
                NinteiChosainBusiness 編集元 = 時間枠設定の編集元取得(
                        div,
                        編集データ,
                        時間の処理(調査時間枠.split("-").get(0)),
                        時間の処理(調査時間枠.split("-").get(1)),
                        時間枠);
                div.getMainPanel().getSettingDetail().setHensyuTajyo(編集状態_既存);
                getHandler(div).btnHennsyu(編集元, 時間枠, 編集データ);
            }
        } else {
            div.getMainPanel().getSettingDetail().setHensyuTajyo(編集状態_未指定);
            getHandler(div).btnHennsyu(編集データ, 時間枠);
        }
    }

    private boolean 未来日の確認(NinteiChosainJikanMasterDiv div) {
        RDate 当日 = RDate.getNowDate();
        RString 設定年月 = new RString(div.getTxtSettingMonth().getValue().toString()).substring(0, 6);
        RString 処理日_日 = div.getDgTimeScheduleList().getActiveRow().getDate().padZeroToLeft(2);
        RString 処理日 = 設定年月.concat(処理日_日);
        return 当日.compareTo(new RDate(処理日.toString())) > 0;
    }

    private NinteiChosainBusiness 時間枠設定の編集元取得(
            NinteiChosainJikanMasterDiv div,
            dgTimeScheduleList_Row 編集データ,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            RString 時間枠) {
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        FlexibleDate 認定調査予定日 = new FlexibleDate(
                Integer.parseInt(date2.getYear().toString()),
                Integer.parseInt(date2.getMonth().toString()),
                Integer.parseInt(編集データ.getDate().toString()));
        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
        return NinteiChosainJikanMasterManager.createInstance().
                時間枠設定の編集元取得(
                        認定調査予定日,
                        調査地区コード,
                        認定調査委託先コード,
                        認定調査員コード,
                        市町村コード,
                        認定調査予定開始時間,
                        認定調査予定終了時間,
                        new Code(時間枠));
    }

    private RString 編集状態の設定(RString 時間枠) {
        if (RString.isNullOrEmpty(時間枠)) {
            return 編集状態_未指定;
        }
        return 編集状態_既存;
    }

    private RString nullToEmpty(RString 時間枠) {
        if (RString.isNullOrEmpty(時間枠)) {
            return RString.EMPTY;
        }
        return 時間枠;
    }

    private RString 時間の処理(RString 時間) {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(時間.split(":").get(0))
                .append(時間.split(":").get(1)).toRString();
    }

    private void setModel時間枠設定一覧情報(
            List<NinteiChosainBusiness> 認定調査情報,
            FlexibleDate 設定年月,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        if (認定調査情報 == null || 認定調査情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール情報, Models.create(new ArrayList()));
        } else {
            List<NinteichosaSchedule> 情報 = NinteiChosainJikanMasterManager.createInstance().
                    select時間枠設定一覧情報(
                            設定年月,
                            調査地区コード,
                            認定調査委託先コード,
                            認定調査員コード,
                            市町村コード).records();
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール情報, Models.create(情報));
        }
    }

    private RString 予約可否設定(boolean 予約可能フラグ) {
        if (予約可能フラグ) {
            return 予約フラグ_可;
        } else {
            return 予約フラグ_不可;
        }
    }

    private boolean is予約可能フラグ(RString 予約可能フラグ) {
        return 予約フラグ_可.equals(予約可能フラグ);
    }

    private void 保存の処理(dgTimeScheduleList_Row row, FlexibleDate 予定年月日, Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels) {
        for (int i = 1; i < 時間枠数; i++) {
            時間枠一と時間枠二(row, 予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード, ninteichosaModels, i);
            時間枠三と時間枠四(row, 予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード, ninteichosaModels, i);
            時間枠五と時間枠六(row, 予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード, ninteichosaModels, i);
            時間枠七と時間枠八(row, 予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード, ninteichosaModels, i);
            時間枠九と時間枠十(row, 予定年月日, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード, ninteichosaModels, i);
        }
    }

    private void 保存更新の処理(FlexibleDate 予定年月日,
            RString 処理区分,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            int 時間枠,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels,
            RString 予約状況,
            RString 変更後認定調査予定開始時間,
            RString 変更後認定調査予定終了時間) {
        if (処理区分_新規.equals(処理区分)) {
            NinteichosaScheduleIdentifier 情報PK = new NinteichosaScheduleIdentifier(
                    予定年月日,
                    認定調査予定開始時間,
                    認定調査予定終了時間,
                    new Code(new RString(Integer.toString(時間枠))),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            if (ninteichosaModels.get(情報PK) != null) {
                NinteiChosainJikanMasterManager.createInstance().save(
                        ninteichosaModels.get(情報PK).createBuilderForEdit().set予約状況(new Code(予約状況)).build().toEntity());
            }
        } else if (処理区分_更新.equals(処理区分)) {
            NinteichosaScheduleIdentifier 情報PK = new NinteichosaScheduleIdentifier(
                    予定年月日,
                    認定調査予定開始時間,
                    認定調査予定終了時間,
                    new Code(new RString(Integer.toString(時間枠))),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            NinteichosaScheduleIdentifier 登録情報PK = new NinteichosaScheduleIdentifier(
                    予定年月日,
                    変更後認定調査予定開始時間,
                    変更後認定調査予定終了時間,
                    new Code(new RString(Integer.toString(時間枠))),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            if (!EntityDataState.Added.equals(ninteichosaModels.get(情報PK).toEntity().getState())) {
                ninteichosaModels.deleteOrRemove(情報PK);
            }
            NinteiChosainJikanMasterManager.createInstance().更新(
                    ninteichosaModels.get(情報PK).createBuilderForEdit().set予約状況(new Code(予約状況)).build().toEntity(),
                    ninteichosaModels.get(登録情報PK).createBuilderForEdit().set予約状況(new Code(予約状況)).build().toEntity());
        } else if (処理区分_削除.equals(処理区分)) {
            NinteichosaScheduleIdentifier 情報PK = new NinteichosaScheduleIdentifier(
                    予定年月日,
                    認定調査予定開始時間,
                    認定調査予定終了時間,
                    new Code(new RString(Integer.toString(時間枠))),
                    調査地区コード,
                    認定調査委託先コード,
                    認定調査員コード,
                    市町村コード);
            if (ninteichosaModels.get(情報PK) != null) {
                NinteiChosainJikanMasterManager.createInstance().saveOrDelete(ninteichosaModels.get(情報PK).toEntity());
            }
        }
    }

    private void 時間枠一と時間枠二(dgTimeScheduleList_Row row, FlexibleDate 予定年月日, Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels,
            int i) {
        RString 処理区分;
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        RString 変更後認定調査予定開始時間 = null;
        RString 変更後認定調査予定終了時間 = null;
        switch (i) {
            case 時間枠_1:
                if (row.getSyoriKben01() != null && !row.getSyoriKben01().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben01())) {
                    処理区分 = row.getSyoriKben01();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku01().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku01().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben01())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku01().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku01().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo01(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            case 時間枠_2:
                if (row.getSyoriKben02() != null && !row.getSyoriKben02().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben02())) {
                    処理区分 = row.getSyoriKben02();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku02().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku02().split("-").get(1));

                    if (!処理区分_削除.equals(row.getSyoriKben02())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku02().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku02().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            default:
                break;
        }
    }

    private void 時間枠三と時間枠四(dgTimeScheduleList_Row row, FlexibleDate 予定年月日, Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels,
            int i) {
        RString 処理区分;
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        RString 変更後認定調査予定開始時間 = null;
        RString 変更後認定調査予定終了時間 = null;
        switch (i) {
            case 時間枠_3:
                if (row.getSyoriKben03() != null && !row.getSyoriKben03().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben03())) {
                    処理区分 = row.getSyoriKben03();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku03().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku03().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben03())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku03().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku03().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            case 時間枠_4:
                if (row.getSyoriKben04() != null && !row.getSyoriKben04().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben04())) {
                    処理区分 = row.getSyoriKben04();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku04().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku04().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben04())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku04().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku04().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            default:
                break;
        }
    }

    private void 時間枠五と時間枠六(dgTimeScheduleList_Row row, FlexibleDate 予定年月日, Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels,
            int i) {
        RString 処理区分;
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        RString 変更後認定調査予定開始時間 = null;
        RString 変更後認定調査予定終了時間 = null;
        switch (i) {
            case 時間枠_5:
                if (row.getSyoriKben05() != null && !row.getSyoriKben05().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben05())) {
                    処理区分 = row.getSyoriKben05();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku05().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku05().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben05())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku05().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku05().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            case 時間枠_6:
                if (row.getSyoriKben06() != null && !row.getSyoriKben06().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben06())) {
                    処理区分 = row.getSyoriKben06();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku06().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku06().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben06())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku06().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku06().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            default:
                break;
        }
    }

    private void 時間枠七と時間枠八(dgTimeScheduleList_Row row, FlexibleDate 予定年月日, Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels,
            int i) {
        RString 処理区分;
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        RString 変更後認定調査予定開始時間 = null;
        RString 変更後認定調査予定終了時間 = null;
        switch (i) {
            case 時間枠_7:
                if (row.getSyoriKben07() != null && !row.getSyoriKben07().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben07())) {
                    処理区分 = row.getSyoriKben07();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku07().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku07().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben07())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku07().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku07().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }

                break;
            case 時間枠_8:
                if (row.getSyoriKben08() != null && !row.getSyoriKben08().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben08())) {
                    処理区分 = row.getSyoriKben08();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku08().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku08().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben08())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku08().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku08().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            default:
                break;
        }
    }

    private void 時間枠九と時間枠十(dgTimeScheduleList_Row row, FlexibleDate 予定年月日, Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels,
            int i) {
        RString 処理区分;
        RString 認定調査予定開始時間;
        RString 認定調査予定終了時間;
        RString 変更後認定調査予定開始時間 = null;
        RString 変更後認定調査予定終了時間 = null;
        switch (i) {
            case 時間枠_9:
                if (row.getSyoriKben09() != null && !row.getSyoriKben09().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben09())) {
                    処理区分 = row.getSyoriKben09();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku09().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku09().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben09())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku09().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku09().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            case 時間枠_10:
                if (row.getSyoriKben10() != null && !row.getSyoriKben10().isEmpty() && !処理区分_未処理.equals(row.getSyoriKben10())) {
                    処理区分 = row.getSyoriKben10();
                    認定調査予定開始時間 = 時間の処理(row.getHiddenChosaJikanwaku10().split("-").get(0));
                    認定調査予定終了時間 = 時間の処理(row.getHiddenChosaJikanwaku10().split("-").get(1));
                    if (!処理区分_削除.equals(row.getSyoriKben10())) {
                        変更後認定調査予定開始時間 = 時間の処理(row.getChosaJikanwaku10().split("-").get(0));
                        変更後認定調査予定終了時間 = 時間の処理(row.getChosaJikanwaku10().split("-").get(1));
                    }
                    保存更新の処理(予定年月日, 処理区分, 認定調査予定開始時間, 認定調査予定終了時間, i, 調査地区コード, 認定調査委託先コード,
                            認定調査員コード, 市町村コード, ninteichosaModels, row.getYoyakuJokyo02(), 変更後認定調査予定開始時間, 変更後認定調査予定終了時間);
                }
                break;
            default:
                break;
        }
    }

    private boolean 前排他キーのセット() {
        LockingKey 排他キー = new LockingKey(new RString("DBE2020006"));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除() {
        LockingKey 排他キー = new LockingKey(new RString("DBE2020006"));
        RealInitialLocker.release(排他キー);
    }

    private List<KeyValueDataSource> get調査地区ドロップダウンリスト() {
        List<KeyValueDataSource> dataSource = new ArrayList();
        List<ChikuShichoson> chikuShichosonList = NinteiChosainJikanMasterManager.createInstance().
                getChikuShichosonList().records();
        for (ChikuShichoson chikuShichoson : chikuShichosonList) {
            dataSource.add(調査地区ドロップダウンリスト(chikuShichoson.get調査地区コード()));
        }
        return dataSource;
    }

    private KeyValueDataSource 調査地区ドロップダウンリスト(Code 調査地区コード) {
        FlexibleDate 基准日 = FlexibleDate.getNowDate();
        UzT0007CodeEntity 指定調査地区 = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(), 調査地区コード, 基准日);
        KeyValueDataSource keyValue = new KeyValueDataSource();
        keyValue.setKey(指定調査地区.getコード().value());
        keyValue.setValue(指定調査地区.getコード名称());
        return keyValue;
    }

    private void btnNinteiChosaModel(NinteiChosainJikanMasterDiv div) {
        NinteiChosaIkkatsuInputModel models = DataPassingConverter.deserialize(div.getNinteiChosaIkkatsuInputModel(), NinteiChosaIkkatsuInputModel.class);
        if (models != null) {
            List<NinteiChosaIkkatsuInputModel> データ = models.getModelList();
            if (データ != null) {
                for (NinteiChosaIkkatsuInputModel model : データ) {
                    FlexibleDate 設定予定日 = model.get認定調査予定年月日();
                    RString 時間枠 = model.get認定調査時間枠().getColumnValue();
                    RString 認定調査予定開始時間 = model.get認定調査予定開始時間();
                    RString 認定調査予定終了時間 = model.get認定調査予定終了時間();
                    データ編集(設定予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
                }
            }
        }
    }

    private void データ編集(
            FlexibleDate 設定予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        Seireki date2 = div.getTxtSettingMonth().getValue().seireki();
        for (int i = 1; i < (div.getTxtSettingMonth().getValue().getLastDay() + 1); i++) {
            FlexibleDate 予定日 = new FlexibleDate(
                    Integer.parseInt(date2.getYear().toString()),
                    Integer.parseInt(date2.getMonth().toString()), i);
            if (設定予定日.compareTo(予定日) == 0) {
                一括設定データ(予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
            }
        }
    }

    private void 一括設定データ(
            FlexibleDate 予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        一括設定時間枠一と一括設定時間枠二(予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
        一括設定時間枠三と一括設定時間枠四(予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
        一括設定時間枠五と一括設定時間枠六(予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
        一括設定時間枠七と一括設定時間枠八(予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
        一括設定時間枠九と一括設定時間枠十(予定日, 時間枠, 認定調査予定開始時間, 認定調査予定終了時間, div);
    }

    private void 一括設定時間枠一と一括設定時間枠二(FlexibleDate 予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_1:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            case 時間枠_2:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠三と一括設定時間枠四(FlexibleDate 予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_3:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            case 時間枠_4:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠五と一括設定時間枠六(FlexibleDate 予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_5:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            case 時間枠_6:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠七と一括設定時間枠八(FlexibleDate 予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_7:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            case 時間枠_8:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            default:
                break;
        }
    }

    private void 一括設定時間枠九と一括設定時間枠十(FlexibleDate 予定日,
            RString 時間枠,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            NinteiChosainJikanMasterDiv div) {
        switch (Integer.parseInt(時間枠.toString())) {
            case 時間枠_9:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            case 時間枠_10:
                set一括設定Model(予定日, 認定調査予定開始時間, 認定調査予定終了時間, 時間枠, div);
                break;
            default:
                break;
        }
    }

    private void set一括設定Model(FlexibleDate 予定年月日, RString 認定調査予定開始時間, RString 認定調査予定終了時間, RString 時間枠,
            NinteiChosainJikanMasterDiv div) {

        Code 調査地区コード = new Code(div.getDdlTaishoChiku().getSelectedKey());
        RString 認定調査委託先コード = div.getTxtNinteiChosaItakusakiCode().getValue();
        RString 認定調査員コード = div.getTxtNinteiChosainCode().getValue();
        LasdecCode 市町村コード = new LasdecCode(div.getMainPanel().getSearchConditionPanel().getHiddenShichosonCode());
        Models<NinteichosaScheduleIdentifier, NinteichosaSchedule> ninteichosaModels
                = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール情報, Models.class);
        NinteichosaSchedule 情報PK = new NinteichosaSchedule(
                予定年月日,
                認定調査予定開始時間,
                認定調査予定終了時間,
                new Code(時間枠),
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード);
        ninteichosaModels.add(情報PK.createBuilderForEdit().set予約可能フラグ(true).build());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール情報, Models.create(ninteichosaModels));

    }
}
