/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5100001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakai.KaigoNinteiShinsakaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.DBE5100001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.DBE5100001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.KaigoNinteiShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100001.KaigoNinteiShinsakaiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.IYokaigoNinteiShinsakaiIchiranListDiv.*;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigoNinteiShinsakaiIchiranList.YokaigoNinteiShinsakaiIchiranList.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaikaisai.ShinsakaiKaisaiFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IParentResponse;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.workflow.menu.Menus;

/**
 * 審査会一覧のコントローラです。
 *
 * @reamsid_L DBE-1350-010 zuotao
 */
public class KaigoNinteiShinsakai {

    private static final int 数字_0 = 0;
    private static final int LENGTH_4 = 4;
    private static final RString 審査会自動割付使用しない = new RString("2");
    private static final RString 自動割当ボタン名 = new RString("btnAutoWaritsuke");

    /**
     * この親Divを経由するすべての機能の定義です。
     */
    private enum Functions {

        審査会個人別状況照会("DBEUC01201", モード_判定結果, DBE5100001StateName.審査会個人別状況照会),
        介護認定審査会審査対象データ出力_モバイル("DBEUC51801", モード_データ出力, DBE5100001StateName.データ出力_モバイル),
        介護認定審査会対象者割付("DBEUC51601", モード_対象者割付, DBE5100001StateName.対象者割付),
        介護認定審査会資料作成("DBEUC51701", モード_審査会資料, DBE5100001StateName.審査会資料),
        介護認定審査会委員事前審査結果登録("DBEUC52001", モード_事前結果登録, DBE5100001StateName.事前審査結果登録),
        介護認定審査会委員事前審査("DBEUC52010", モード_事前結果登録, DBE5100001StateName.事前審査),
        審査会開催結果登録("DBEUC52101", モード_審査結果登録, DBE5100001StateName.開催結果登録),
        審査会審査結果登録("DBEUC52301", モード_事前結果登録, DBE5100001StateName.審査結果登録),
        介護認定審査会審査結果データ取込み_モバイル("DBEUC52201", モード_データ出力, DBE5100001StateName.データ取込み_モバイル),
        介護認定審査会審査結果登録_OCR("DBEUC52401", モード_審査結果登録, DBE5100001StateName.結果登録_OCR),
        介護認定審査会委員割付("DBEUC51410", モード_委員割付, DBE5100001StateName.審査会資料);

        private final RString uiContainerID;
        private final RString mode;
        private final DBE5100001StateName state;

        private Functions(String uiContainerID, RString mode, DBE5100001StateName state) {
            this.uiContainerID = new RString(uiContainerID);
            this.mode = mode;
            this.state = state;
        }

        private static Functions toValue(RString uiContainerID) {
            return UIContainerIDToValue.get(uiContainerID);
        }

        /**
         * {@link IYokaigoNinteiShinsakaiIchiranListDiv}の動作に関わる概念「モード」を返します。
         *
         * @param uiContainerID UIコンテナID
         * @return モード
         */
        private static RString getMode(RString uiContainerID) {
            return toValue(uiContainerID).mode;
        }

        private static DBE5100001StateName getState(RString uiContainerID) {
            return toValue(uiContainerID).state;
        }

        private static boolean is審査会一覧更新(RString uiContainerID) {
            Functions f = toValue(uiContainerID);
            return f == 審査会開催結果登録 || f == 審査会審査結果登録 || f == 介護認定審査会対象者割付 || f == 介護認定審査会委員割付;
        }

        //<editor-fold defaultstate="collapsed" desc="UIContainerIDToValue">
        private static final class UIContainerIDToValue {

            private static final Map<RString, Functions> DICTHIONARY;

            static {
                Map<RString, Functions> map = new HashMap<>();
                for (Functions value : values()) {
                    map.put(value.uiContainerID, value);
                }
                DICTHIONARY = Collections.unmodifiableMap(map);
            }

            static Functions get(RString uiContainerID) {
                return DICTHIONARY.get(uiContainerID);
            }
        }
        //</editor-fold>
    }

    /**
     * 審査会一覧初期化の設定します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onLoad(KaigoNinteiShinsakaiDiv div) {
        RString mode = Functions.getMode(ResponseHolder.getUIContainerId());
        if (モード_対象者割付.equals(mode)) {
            RString 審査会自動割付使用有無 = DbBusinessConfig.get(ConfigNameDBE.審査会自動割付使用有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (審査会自動割付使用しない.equals(審査会自動割付使用有無)) {
                mode = モード_対象者割付_自動割付使用不可;
                CommonButtonHolder.setDisabledByCommonButtonFieldName(自動割当ボタン名, true);
            }
        }
        div.getCcdShinsakaiItiran().initialize(mode);
        IParentResponse<KaigoNinteiShinsakaiDiv> response = ResponseData.of(div);
        response.rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName());
        response.setState(Functions.getState(ResponseHolder.getUIContainerId()));
        return response.respond();
    }

    /**
     * 審査会一覧を更新します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onActive_KaigoNinteiShinsakai(KaigoNinteiShinsakaiDiv div) {
        RString uiContainerID = ResponseHolder.getUIContainerId();
        if (!Functions.is審査会一覧更新(uiContainerID)) {
            return onActive_return(div, uiContainerID);
        }

        RString 開催番号;
        開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        ShinsakaiKaisaiParameter parameter = ShinsakaiKaisaiParameter.create審査会検索Param(開催番号);
        ShinsakaiKaisai shinsakaiKaisai = ShinsakaiKaisaiFinder.createInstance().get審査会(parameter);
        if (shinsakaiKaisai == null) {
            return onActive_return(div, uiContainerID);
        }

        List<dgShinsakaiIchiran_Row> selectedRow = new ArrayList<>();
        int seledted = 0;
        for (dgShinsakaiIchiran_Row row : div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().getDataSource()) {
            if (開催番号.equals(row.getShinsakaiKaisaiNo())) {
                selectedRow.add(row);
                row.getKaisaiYoteiDate().setValue(shinsakaiKaisai.get介護認定審査会開催予定年月日());
                row.getYoteiKaishiTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会開始予定時刻()));
                row.getYoteiShuryoTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会終了予定時刻()));
                row.setShinsakaiMeisho(shinsakaiKaisai.get編集審査会名称());
                row.setGogitaiMeisho(shinsakaiKaisai.get合議体名称());
                row.setShurui(shinsakaiKaisai.get種類());
                row.setShinsakaiKaijo(shinsakaiKaisai.get介護認定審査会開催場所名称());
                row.getKaisaiDay().setValue(shinsakaiKaisai.get介護認定審査会開催年月日());
                row.getKaisaiTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会開始時刻()));
                row.getShuryoTime().setValue(getRStringToRtime(shinsakaiKaisai.get介護認定審査会終了時刻()));
                row.getYoteiTeiin().setValue(shinsakaiKaisai.get介護認定審査会予定定員());
                row.getWariateNinzu().setValue(shinsakaiKaisai.get介護認定審査会割当済み人数());
                row.getTaishoNinzu().setValue(shinsakaiKaisai.get介護認定審査会実施人数());
                row.setOnseiKiroku(shinsakaiKaisai.get音声記録());
                row.getDataShutsuryoku().setValue(shinsakaiKaisai.getモバイルデータ出力年月日());
//                if (shinsakaiKaisai.is資料作成済フラグ()) {
//                    row.setShiryoSakuseiKubun(IsShiryoSakuseiZumi.toValue(shinsakaiKaisai.is資料作成済フラグ()).get名称());
//                } else {
//                    row.setShiryoSakuseiKubun(RString.EMPTY);
//                }
                row.setShiryoSakuseiKubun(shinsakaiKaisai.get資料作成状況());
                if (!RString.isNullOrEmpty(shinsakaiKaisai.get介護認定審査会進捗状況())) {
                    row.setShinchokuJokyo(ShinsakaiShinchokuJokyo.toValue(shinsakaiKaisai.get介護認定審査会進捗状況()).get画面表示名称());
                } else {
                    row.setShinchokuJokyo(RString.EMPTY);
                }
                row.setDummyFlag(shinsakaiKaisai.isダミーフラグ());
                row.setGogitaiNo(shinsakaiKaisai.get合議体番号());
                row.setShinsakaiKaisaiNo(shinsakaiKaisai.get審査会開催番号());
                div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().getDataSource().set(seledted, row);
                break;
            }
            seledted++;
        }
        div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().setSelectedItems(selectedRow);
        return onActive_return(div, uiContainerID);
    }

    private RTime getRStringToRtime(RString time) {
        if (!RString.isNullOrEmpty(time)) {
            time = time.padZeroToLeft(LENGTH_4);
            return RTime.of(Integer.valueOf(time.substring(0, 2).toString()), Integer.valueOf(time.substring(2).toString()));
        }
        return RTime.of(0, 0, 0, 0);
    }

    private ResponseData<KaigoNinteiShinsakaiDiv> onActive_return(KaigoNinteiShinsakaiDiv div, RString uiContainerID) {
        IParentResponse<KaigoNinteiShinsakaiDiv> response = ResponseData.of(div);
        response.rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName());
        response.setState(Functions.getState(uiContainerID));
        return response.respond();
    }

    /**
     * 個人別状況照会へ遷移を処理します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnkojin(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択不可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div)
                    .rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName())
                    .addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.開催番号, div.getCcdShinsakaiItiran().get開催番号List().get(数字_0));
        return ResponseData.of(div)
                .forwardWithEventName(DBE5100001TransitionEventName.個人別状況照会へ遷移する).respond();
    }

    /**
     * データ出力を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btndataoutput(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div)
                    .rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName())
                    .addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.開催番号,
                new KaigoNinteiShinsakaiParameter(div.getCcdShinsakaiItiran().get開催番号List()));
        return ResponseData.of(div)
                .forwardWithEventName(DBE5100001TransitionEventName.データ出力を実行する).respond();
    }

    /**
     * 審査会対象者割付へ遷移を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnwaritsuke(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択不可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div)
                    .rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName())
                    .addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.介護認定審査会番号, div.getCcdShinsakaiItiran().get開催番号List().get(数字_0));
        return ResponseData.of(div)
                .forwardWithEventName(DBE5100001TransitionEventName.審査会対象者割付へ遷移する).respond();
    }

    /**
     * 自動割付へ遷移を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnAutoWaritsuke(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div)
                    .rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName())
                    .addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.開催番号,
                new KaigoNinteiShinsakaiParameter(div.getCcdShinsakaiItiran().get開催番号List()));
        return ResponseData.of(div)
                .forwardWithEventName(DBE5100001TransitionEventName.自動割付を実行する).respond();
    }

    /**
     * 選択ボタンの処理を実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btnSelectAlias(KaigoNinteiShinsakaiDiv div) {
        RString 合議体名称 = div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().getActiveRow().getShinsakaiMeisho();
        RString 開催番号 = RString.EMPTY;
        if (!RString.isNullOrEmpty(合議体名称)) {
            開催番号 = 合議体名称.substring(1, 合議体名称.length() - LENGTH_4);
        }
        RString 開催年月日 = RString.EMPTY;
        if (!div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().getActiveRow().getKaisaiYoteiDate().getValue().isEmpty()) {
            開催年月日 = new RString(div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().getActiveRow().getKaisaiYoteiDate().getValue().toString());
        }
        ViewStateHolder.put(ViewStateKeys.開催番号, 開催番号);
        ViewStateHolder.put(ViewStateKeys.開催年月日, 開催年月日);
        div.getCcdShinsakaiItiran().setHdnSelectedGridLine(new RString(String.valueOf(div.getCcdShinsakaiItiran().getDgShinsakaiIchiran().getActiveRow().getId())));

        ValidationMessageControlPairs validationMessages = check_審査会選択(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div)
                    .rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName())
                    .addValidationMessages(validationMessages).respond();
        }

        div.getCcdShinsakaiItiran().getSelectedGridLine();
        if (Functions.介護認定審査会対象者割付 == Functions.toValue(ResponseHolder.getUIContainerId())) {
            ViewStateHolder.put(ViewStateKeys.介護認定審査会番号, div.getCcdShinsakaiItiran().get開催番号List().get(数字_0));
            return ResponseData.of(div)
                    .forwardWithEventName(DBE5100001TransitionEventName.審査会対象者割付へ遷移する).respond();
        }
        return ResponseData.of(div)
                .forwardWithEventName(DBE5100001TransitionEventName.審査会選択).respond();
    }

    /**
     * データ取込みを実行します。
     *
     * @param div 審査会一覧Div
     * @return ResponseData<KaigoNinteiShinsakaiDiv>
     */
    public ResponseData<KaigoNinteiShinsakaiDiv> onClick_btndatainput(KaigoNinteiShinsakaiDiv div) {

        ValidationMessageControlPairs validationMessages = check_審査会複数選択可(div);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div)
                    .rootTitle(Menus.getMenuInfo(SubGyomuCode.DBE認定支援, ResponseHolder.getMenuID()).getMenuName())
                    .addValidationMessages(validationMessages).respond();
        }
        ViewStateHolder.put(ViewStateKeys.開催番号,
                new KaigoNinteiShinsakaiParameter(div.getCcdShinsakaiItiran().get開催番号List()));
        return ResponseData.of(div)
                .forwardWithEventName(DBE5100001TransitionEventName.データ取込みを実行する).respond();
    }

    private KaigoNinteiShinsakaiValidationHandler createValidationHandler(KaigoNinteiShinsakaiDiv div) {
        return new KaigoNinteiShinsakaiValidationHandler(div);
    }

    private ValidationMessageControlPairs check_審査会複数選択不可(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(check_審査会複数選択可(div));
        validationMessages.add(createValidationHandler(div).審査会複数選択不可チェック());
        return validationMessages;
    }

    private ValidationMessageControlPairs check_審査会複数選択可(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(createValidationHandler(div).審査会データ空チェック());
        validationMessages.add(createValidationHandler(div).審査会未選択チェック());
        return validationMessages;
    }

    private ValidationMessageControlPairs check_審査会選択(KaigoNinteiShinsakaiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(createValidationHandler(div).審査会データ空チェック());
        validationMessages.add(createValidationHandler(div).
                審査会未選択チェック_選択(ViewStateHolder.get(ViewStateKeys.開催番号, RString.class)));
        return validationMessages;
    }

}
