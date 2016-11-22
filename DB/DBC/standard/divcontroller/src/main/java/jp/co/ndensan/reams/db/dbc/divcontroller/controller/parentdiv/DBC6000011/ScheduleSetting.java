/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC6000011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshashikakuteisei.SukejuruRirekiJohoListEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.DBC6000011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.DBC6000011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.ScheduleSettingDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.dgDataSofu_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011.dgDataTorikomi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6000011.ScheduleSettingHandler;
import jp.co.ndensan.reams.db.dbc.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeisei;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ScheduleSetting_国保連連携スケジュール設定クラスです。
 *
 * @reamsid_L DBC-2930-010 liuxiaoyu
 */
public class ScheduleSetting {

    private final HihokenshaShikakuTeisei hihokenshaShikakuTeisei = InstanceProvider.create(HihokenshaShikakuTeisei.class);
    private static final int INDEX_ZERO = 0;
    private static final int いち月 = 1;
    private static final RString メニューID_DBCMNH1001 = new RString("DBCMNH1001");

    /**
     * 画面初期化
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onLoad(ScheduleSettingDiv div) {
        SukejuruRirekiJohoListEntity entity = getHandler(div).onLoad();
        ViewStateHolder.put(ViewStateKeys.スケジュール履歴情報Entity, entity);
        RString menuID = ResponseHolder.getMenuID();
        if (メニューID_DBCMNH1001.equals(menuID)) {
            return ResponseData.of(div).setState(DBC6000011StateName.メニューからの遷移);
        } else {
            return ResponseData.of(div).setState(DBC6000011StateName.送付取込画面からの遷移);
        }
    }

    /**
     * 「戻る」ボタンを押下すると、画面に遷移する。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnBack(ScheduleSettingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC6000011TransitionEventName.情報送付取込へ戻る).respond();
    }

    /**
     * 「完了する」ボタンを押下すると、メニュー画面に戻る。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnComplete(ScheduleSettingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC6000011TransitionEventName.メニューへ戻る).respond();
    }

    /**
     * 「表示」ボタンを押下する。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnDisplay(ScheduleSettingDiv div) {
        boolean 送付新規Flag = false;
        boolean 取込新規Flag = false;
        boolean 送付Flag = false;
        boolean 取込Flag = false;
        RDate 画面処理年月 = div.getTxtShoriNengetsu().getValue();
        if (画面処理年月 == null) {
            return ResponseData.of(div).respond();
        }
        div.getTxtHyojiTaishoNengetsu().setValue(画面処理年月);
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(画面処理年月.getYearMonth().toDateString());
        SukejuruRirekiJohoListEntity 履歴情報 = hihokenshaShikakuTeisei.getSukejuruRirekiJoho(処理年月);
        List<KokuhorenInterfaceKanri> 送付List = 履歴情報.getスケジュール履歴情報_送付List();
        List<KokuhorenInterfaceKanri> 取込List = 履歴情報.getスケジュール履歴情報_取込List();
        if (!送付List.isEmpty()) {
            List<dgDataSofu_Row> sList = getHandler(div).スケジュール履歴情報処理_送付(送付List);
            div.getDgDataSofu().setDataSource(sList);
        } else {
            送付List = hihokenshaShikakuTeisei.getSukejuruRirekiShokiJoho().getスケジュール履歴情報_送付List();
            FlexibleYearMonth 最終処理年月 = null;
            if (!送付List.isEmpty()) {
                最終処理年月 = 送付List.get(INDEX_ZERO).get処理年月();
            }
            if (null == 最終処理年月) {
                List<dgDataSofu_Row> sList = getHandler(div).スケジュール履歴情報処理_送付(送付List);
                div.getDgDataSofu().setDataSource(sList);
            } else if (処理年月.equals(最終処理年月.plusMonth(いち月))) {
                送付Flag = true;

            } else {
                throw new ApplicationException(DbcErrorMessages.国保連連携スケジュール_新規設定不可.getMessage().evaluate());
            }
        }
        if (!取込List.isEmpty()) {
            List<dgDataTorikomi_Row> tList = getHandler(div).スケジュール履歴情報処理_取込(取込List);
            div.getDgDataTorikomi().setDataSource(tList);
        } else {
            取込List = hihokenshaShikakuTeisei.getSukejuruRirekiShokiJoho().getスケジュール履歴情報_取込List();
            FlexibleYearMonth 最終処理年月 = null;
            if (!取込List.isEmpty()) {
                最終処理年月 = 取込List.get(INDEX_ZERO).get処理年月();
            }
            if (null == 最終処理年月) {
                List<dgDataTorikomi_Row> tList = getHandler(div).スケジュール履歴情報処理_取込(取込List);
                div.getDgDataTorikomi().setDataSource(tList);
            } else if (処理年月.equals(最終処理年月.plusMonth(いち月))) {
                取込Flag = true;

            } else {
                throw new ApplicationException(DbcErrorMessages.国保連連携スケジュール_新規設定不可.getMessage().evaluate());
            }
        }

        if (送付Flag || 取込Flag) {
            DbcQuestionMessages questionMessages;
            if (is処理前あり(送付List) || is処理前あり(取込List)) {
                questionMessages = DbcQuestionMessages.国保連連携スケジュール_新規設定確認２;
            } else {
                questionMessages = DbcQuestionMessages.国保連連携スケジュール_新規設定確認;
            }

            // CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 1 LINES
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage 新規設定確認MESSAGE = new QuestionMessage(
                        questionMessages.getMessage().getCode(),
                        questionMessages.getMessage().evaluate(),
                        ButtonSelectPattern.OKCancel);
                return ResponseData.of(div).addMessage(新規設定確認MESSAGE).respond();
            }
            // CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 1 LINES
            if (new RString(questionMessages.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

                if (送付Flag) {
                    送付新規Flag = true;
                    List<dgDataSofu_Row> sList = getHandler(div).スケジュール履歴情報処理_送付(new ArrayList<KokuhorenInterfaceKanri>());
                    sList = getHandler(div).set送付処理状況(sList, 送付List);
                    div.getDgDataSofu().setDataSource(sList);
                }
                if (取込Flag) {
                    取込新規Flag = true;
                    List<dgDataTorikomi_Row> tList = getHandler(div).スケジュール履歴情報処理_取込(new ArrayList<KokuhorenInterfaceKanri>());
                    tList = getHandler(div).set取込処理状況(tList, 取込List);
                    div.getDgDataTorikomi().setDataSource(tList);
                }
            }
        }

        SukejuruRirekiJohoListEntity entity = new SukejuruRirekiJohoListEntity();
        if (送付新規Flag) {
            entity.setスケジュール履歴情報_送付List(new ArrayList<KokuhorenInterfaceKanri>());
        } else {
            entity.setスケジュール履歴情報_送付List(送付List);
        }
        if (取込新規Flag) {
            entity.setスケジュール履歴情報_取込List(new ArrayList<KokuhorenInterfaceKanri>());
        } else {
            entity.setスケジュール履歴情報_取込List(取込List);
        }
        ViewStateHolder.put(ViewStateKeys.スケジュール履歴情報Entity, entity);
        return ResponseData.of(div).respond();
    }

    private boolean is処理前あり(List<KokuhorenInterfaceKanri> list) {
        for (KokuhorenInterfaceKanri kanri : list) {
            if (ShoriJotaiKubun.処理前.getコード().equals(kanri.get処理状態区分())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 「保存する」ボタンを押下する。
     *
     * @param div 画面div
     *
     * @return ResponseData<ScheduleSettingDiv>
     */
    public ResponseData<ScheduleSettingDiv> onClick_btnSave(ScheduleSettingDiv div) {
        if (!new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && !new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            QuestionMessage 保存の確認MESSAGE = new QuestionMessage(
                    UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate(),
                    ButtonSelectPattern.YesNo);
            return ResponseData.of(div).addMessage(保存の確認MESSAGE).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            SukejuruRirekiJohoListEntity entity
                    = ViewStateHolder.get(ViewStateKeys.スケジュール履歴情報Entity, SukejuruRirekiJohoListEntity.class);
            getHandler(div).保存処理(entity);
        }
        if (!new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            InformationMessage 保存終了MESSAGE = new InformationMessage(
                    UrInformationMessages.保存終了.getMessage().getCode(),
                    UrInformationMessages.保存終了.getMessage().evaluate());
            return ResponseData.of(div).addMessage(保存終了MESSAGE).respond();
        }
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            RString menuID = ResponseHolder.getMenuID();
            if (メニューID_DBCMNH1001.equals(menuID)) {
                return ResponseData.of(div).forwardWithEventName(DBC6000011TransitionEventName.メニューへ戻る).respond();
            } else {
                return ResponseData.of(div).forwardWithEventName(DBC6000011TransitionEventName.情報送付取込へ戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    private ScheduleSettingHandler getHandler(ScheduleSettingDiv div) {
        return ScheduleSettingHandler.of(div);
    }
}
