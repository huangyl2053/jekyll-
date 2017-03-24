/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5230001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidate;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeNotificationMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.DBE5230001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.NinteiShinseiKubunHoreiCalculator;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.OperationMode;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.ShinsakaiKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001.TaishoshaIchiranRow;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.IShinsaKekkaPreserver;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.IShinsakakKekksaTorokuManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuService;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.KaigoRowState;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.db.dbz.service.core.ninteichosajokyo.NinteiChosaJokyoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護認定審査会審査結果登録クラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaToroku {

    private static final RString 認定調査状況ダイアログ_照会モード = new RString("1");
    private static final RString 審査会メモ定型文GroupCode = new RString("5102");
    private static final RString 審査会意見定型文GroupCode = new RString("5201");
    private static final RString 一次判定結果変更理由定型文GroupCode = new RString("5103");
    private static final Code 二次判定結果入力方法_画面入力 = new Code("1");
    private static final RString 一_五次判定ダイアログ_照会モード = new RString("照会");
    private static final RString SUB_MENU_UICONTAINERID = new RString("DBEUC52101");
    private static final RString KIHON_UNYO_UICONTAINERID = new RString("DBEUC40201");
    private static final RString 戻るBTN = new RString("btnBack");
    private static final Comparator<dgTaishoshaIchiran_Row> ORDER_BY_SHINSA_JUNJO_ASC
            = new Comparator<dgTaishoshaIchiran_Row>() {
                @Override
                public int compare(dgTaishoshaIchiran_Row o1, dgTaishoshaIchiran_Row o2) {
                    return o1.getShinsakaiJunjoSort().compareTo(o2.getShinsakaiJunjoSort());
                }
            };

    private enum _ViewStateKey {

        削除候補;
    }

    private final ShinsakaiKekkaTorokuService service;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaToroku() {
        this.service = ShinsakaiKekkaTorokuService.createInstance();
    }

    /**
     * 介護認定審査会審査結果登録Divを初期化します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData 介護認定審査会審査結果登録Div
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onLoad(ShinsakaiKekkaTorokuDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }

        RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        List<ShinsakaiKekkaTorokuBusiness> headList = service.getヘッドエリア内容検索(開催番号).records();
        List<ShinsakaiKekkaTorokuIChiRanBusiness> iChiRanList = service.get審査会委員一覧検索(開催番号).records();
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (申請書管理番号 == null || 申請書管理番号.isEmpty()) {
            handler.initalize(headList, iChiRanList);
        } else {
            handler.initalize(headList, iChiRanList, 申請書管理番号);
        }
        for (ShinsakaiKekkaTorokuBusiness b : headList) {
            if (b.is未開催()) {
                handler.set操作不可();
                return ResponseData.of(div).addMessage(DbeErrorMessages.開催結果未登録のため処理不可.getMessage()).respond();
            }
        }
        List<ShinsakaiWariateJoho> yoteiJohoList = service.get介護認定審査会割当情報(開催番号).records();
        Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiKaisaiYoteiJoho = Models.create(yoteiJohoList);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会開催予定情報, shinsakaiKaisaiYoteiJoho);
        List<NinteiShinseiJoho> ninteiShinseiJohoList = service.get要介護認定申請情報(開催番号).records();
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho = Models.create(ninteiShinseiJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, ninteiShinseiJoho);
        List<NinteiKekkaJoho> ninteiKekkaJohoList = service.get要介護認定結果情報(開催番号).records();
        Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho = Models.create(ninteiKekkaJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定結果情報, ninteiKekkaJoho);
        List<NinteiKanryoJoho> ninteiKanryoJohoList = service.get要介護認定完了情報(開催番号).records();
        Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho = Models.create(ninteiKanryoJohoList);
        ViewStateHolder.put(ViewStateKeys.要介護認定完了情報, ninteiKanryoJoho);
        ViewStateHolder.put(_ViewStateKey.削除候補, new HashMap<>(service.get削除候補情報(開催番号)));

        if (SUB_MENU_UICONTAINERID.equals(ResponseHolder.getUIContainerId())) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(戻るBTN, true);
        } else if (KIHON_UNYO_UICONTAINERID.equals(ResponseHolder.getUIContainerId())) {
            ViewStateHolder.put(ViewStateKeys.処理モード, OperationMode.更新);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタン押下時の処理です。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onSelectByModifyButton_dgTaishoshaIchiran(ShinsakaiKekkaTorokuDiv div) {
        return _onSelect_dgTaishoshaIchiran(div, OperationMode.更新);
    }

    /**
     * 審査会委員一覧Gridの「削除」ボタン押下時の処理です。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onSelectByDeleteButton_dgTaishoshaIchiran(ShinsakaiKekkaTorokuDiv div) {
        return _onSelect_dgTaishoshaIchiran(div, OperationMode.削除);
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> _onSelect_dgTaishoshaIchiran(ShinsakaiKekkaTorokuDiv div, OperationMode mode) {
        return reflectSpecificRowToKobetsuHyojiRanToEdit(div, div.getDgTaishoshaIchiran().getClickedItem(), mode);
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> reflectSpecificRowToKobetsuHyojiRanToEdit(
            ShinsakaiKekkaTorokuDiv div, dgTaishoshaIchiran_Row row, OperationMode mode) {
        return reflectSpecificRowToKobetsuHyojiRanToEditWithMessage(div, row, mode, null);
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> reflectSpecificRowToKobetsuHyojiRanToEditWithMessage(
            ShinsakaiKekkaTorokuDiv div, dgTaishoshaIchiran_Row row, OperationMode mode, Message message) {
        if (row == null) {
            return ResponseData.of(div).respond();
        }
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.set個別表示欄入力可();
        handler.displayTo個別表示欄(row, mode);
        if (mode.is更新()) {
            setNinteiYukoKikanOperatable(div, handler, handler.get今回二次判定());
        }
        ViewStateHolder.put(ViewStateKeys.処理モード, mode);
        if (message == null) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).addMessage(message).respond();
        }
    }

    /**
     * 確定ボタンを押下しました。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onClick_KaKuTeiButton(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        OperationMode mode = ViewStateHolder.get(ViewStateKeys.処理モード, OperationMode.class);
        if (!ResponseHolder.isReRequest()) {
            dgTaishoshaIchiran_Row row = handler.find更新中RowOrNull();
            if (row == null) {
                return ResponseData.of(div).respond();
            }
            ResponseData r = checkCanKakuteiIfPossibleReturnNull(div, row, mode);
            if (r != null) {
                return r;
            }
        }
        if (ResponseHolder.getMessageCode().toString().equals(DbeErrorMessages.審査結果登録済のため処理不可.getMessage().getCode())) {
            return ResponseData.of(div).respond(); //何もしない。
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond(); //何もしない。
        }
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate個別();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        dgTaishoshaIchiran_Row currentRow = handler.set個別表示欄To更新中Row(mode);
        if (mode.is削除()) {
            return clearKobetsuHyojiRanSettingDisable(div, handler);
        }
        dgTaishoshaIchiran_Row next = findNext(div, currentRow);
        if (next == null) {
            return clearKobetsuHyojiRanSettingDisableWithMessage(div, handler,
                    DbeNotificationMessages.全審査結果登録完了.getMessage());
        }
        div.getDgTaishoshaIchiran().setSelectedItems(Arrays.asList(next));
        return reflectSpecificRowToKobetsuHyojiRanToEditWithMessage(div, next, OperationMode.更新,
                DbeNotificationMessages.審査会結果登録_未判定被保険者表示
                .getMessage()
                .replace(
                        next.getShinsakaiJunjo().toString(),
                        next.getHihokenshaNo().toString(),
                        next.getShimei().toString()
                )
        );
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> clearKobetsuHyojiRanSettingDisableWithMessage(
            ShinsakaiKekkaTorokuDiv div, ShinsakaiKekkaTorokuHandler handler, Message message) {
        handler.clear個別表示欄();
        handler.set個別表示欄入力不可();
        if (message == null) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).addMessage(message).respond();
        }
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> clearKobetsuHyojiRanSettingDisable(
            ShinsakaiKekkaTorokuDiv div, ShinsakaiKekkaTorokuHandler handler) {
        return clearKobetsuHyojiRanSettingDisableWithMessage(div, handler, null);
    }

    @CheckForNull
    private static dgTaishoshaIchiran_Row findNext(ShinsakaiKekkaTorokuDiv div, dgTaishoshaIchiran_Row currentRow) {
        List<dgTaishoshaIchiran_Row> list = new ArrayList<>(div.getDgTaishoshaIchiran().getDataSource());
        Collections.sort(list, ORDER_BY_SHINSA_JUNJO_ASC);
        for (dgTaishoshaIchiran_Row row : list) {
            if (0 <= currentRow.getShinsakaiJunjoSort().compareTo(row.getShinsakaiJunjoSort())) {
                continue;
            }
            if (RString.isNullOrEmpty(row.getHanteiKekkaCode())) {
                return row;
            }
        }
        return null;
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> checkCanKakuteiIfPossibleReturnNull(ShinsakaiKekkaTorokuDiv div, dgTaishoshaIchiran_Row row, OperationMode mode) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (mode.is更新()) {
            if (!Objects.equals(row.getHenkoMaeTorisageKubunCode(), handler.calculateTorisageKubunCodeBy個別入力欄())) {
                return ResponseData.of(div)
                        .addMessage(DbeQuestionMessages.取下区分の更新可否確認.getMessage())
                        .respond();
            }
            if (had審査結果登録(row.getShinseishoKanriNo())) {
                return ResponseData.of(div)
                        .addMessage(DbeQuestionMessages.審査結果登録完了データ修正確認.getMessage())
                        .respond();
            }
            return null;
        }
        if (mode.is削除() && had審査結果登録(row.getShinseishoKanriNo())) {
            return ResponseData.of(div)
                    .addMessage(DbeErrorMessages.審査結果登録済のため処理不可.getMessage())
                    .respond();
        }
        return null;
    }

    private static boolean had審査結果登録(RString shinseishoKanriNo) {
        NinteiKanryoJoho kanryoJoho = (NinteiKanryoJoho) ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class)
                .get(new NinteiKanryoJohoIdentifier(new ShinseishoKanriNo(shinseishoKanriNo)));
        return kanryoJoho.get認定審査会完了年月日() != null && kanryoJoho.get認定審査会完了年月日().isValid();
    }

    /**
     * 入力をやめるボタンを押下イベント
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnCancel(ShinsakaiKekkaTorokuDiv div) {
        return clearKobetsuHyojiRanSettingDisable(div, getHandler(div));
    }

    /**
     * 戻るボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_btnBack(ShinsakaiKekkaTorokuDiv div) {
        removeViewState();
        return ResponseData.of(div).forwardWithEventName(DBE5230001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「保存する」ボタンを押下しました。。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onClick_Save(ShinsakaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).validate全体();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            service.saveBy(new ShinsaKekkaPreserver(div));
            if (KIHON_UNYO_UICONTAINERID.equals(ResponseHolder.getUIContainerId())) {
                return ResponseData.of(div).forwardWithEventName(DBE5230001TransitionEventName.一覧に戻る).respond();
            }
            div.getKanryoMessagePanel().getCcdKaigoKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("保存").evaluate()),
                    new RStringBuilder().append("審査会名称：").append(div.getTxtShinsakaiName().getValue()).toRString(),
                    RString.EMPTY);
            if (SUB_MENU_UICONTAINERID.equals(ResponseHolder.getUIContainerId())) {
                return ResponseData.of(div).setState(DBE5230001StateName.開催から終了);
            } else {
                return ResponseData.of(div).setState(DBE5230001StateName.完了);
            }
        }
        return ResponseData.of(div).respond();
    }

    //<editor-fold defaultstate="collapsed" desc="ShinsaKekkaPreserver">
    private static class ShinsaKekkaPreserver implements IShinsaKekkaPreserver {

        private final ShinsakaiKekkaTorokuDiv div;

        ShinsaKekkaPreserver(ShinsakaiKekkaTorokuDiv div) {
            this.div = div;
        }

        @Override
        public void saveBy(IShinsakakKekksaTorokuManager service) {
            save審査結果(service, this.div);
        }

        private void save審査結果(IShinsakakKekksaTorokuManager manager, ShinsakaiKekkaTorokuDiv div) {
            List<dgTaishoshaIchiran_Row> rowList = div.getDgTaishoshaIchiran().getDataSource();
            RString 開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
            DbAccessLogger logger = new DbAccessLogger();
            for (dgTaishoshaIchiran_Row row : rowList) {
                TaishoshaIchiranRow row2 = new TaishoshaIchiranRow(row);
                KaigoRowState state = row2.getJotai();
                switch (state) {
                    case 追加:
                        saveBy(manager, row2, 開催番号, state);
                        break;
                    case 修正:
                        saveBy(manager, row2, 開催番号, state);
                        break;
                    case 削除:
                        deleteBy(manager, row2, 開催番号);
                        break;
                    default:
                        continue;
                }
                logger.store(row2.getHokenshaNo(), row2.getHihokenshaNo(),
                        ExpandedInformations.申請書管理番号.fromValue(row2.getShinseishoKanriNo().value())
                );
            }
            logger.flushBy(AccessLogType.更新);
        }

        private static void saveBy(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, RString 開催番号, KaigoRowState state) {
            HanteiKekkaCode hanteiKekka = row.getHanteiKekka();
            if (hanteiKekka == null) {
                return;
            }
            ShinsakaiWariateJoho wariateUpdated = update介護認定審査会割当情報(manager, row, 開催番号, hanteiKekka);
            update要介護認定完了情報(manager, row, hanteiKekka);
            if (hanteiKekka == HanteiKekkaCode.認定) {
                update要介護認定申請情報(manager, row);
                save要介護認定結果情報(manager, row, wariateUpdated);
                return;
            }
            if (hanteiKekka.is再調査()) {
                delete削除候補情報(manager, row, hanteiKekka);
            }
            if (state == KaigoRowState.修正) {
                reset要介護認定申請情報(manager, row);
                delete要介護認定結果情報(manager, row);
            }
        }

        //<editor-fold defaultstate="collapsed" desc="methods for saveBy()">
        private static void delete介護認定審査会割当情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row,
                RString 開催番号) {
            update介護認定審査会割当情報(manager, row, 開催番号, null);
        }

        private static ShinsakaiWariateJoho update介護認定審査会割当情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row,
                RString 開催番号, HanteiKekkaCode hanteiKekka) {
            Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiWariateJohoJoho
                    = ViewStateHolder.get(ViewStateKeys.介護認定審査会開催予定情報, Models.class);
            ShinsakaiWariateJohoIdentifier identifier
                    = new ShinsakaiWariateJohoIdentifier(開催番号, row.getShinseishoKanriNo());
            ShinsakaiWariateJoho shinsakaiWariateJoho = shinsakaiWariateJohoJoho.get(identifier);
            ShinsakaiWariateJohoBuilder shinsakaiWariate = shinsakaiWariateJoho.createBuilderForEdit();
            shinsakaiWariate.set判定結果コード(hanteiKekka == null ? Code.EMPTY : hanteiKekka.getCode());
            shinsakaiWariateJoho = shinsakaiWariate.build();
            manager.save介護認定審査会割当情報(shinsakaiWariateJoho);
            return shinsakaiWariateJoho;
        }

        private static void update要介護認定完了情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, HanteiKekkaCode code) {
            if (HanteiKekkaCode.認定 == code || null == code) {
                return;
            }
            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> ninteiKanryoJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定完了情報, Models.class);
            NinteiKanryoJohoIdentifier identifier = new NinteiKanryoJohoIdentifier(row.getShinseishoKanriNo());
            NinteiKanryoJoho ninteiKanryo = ninteiKanryoJoho.get(identifier);
            manager.save要介護認定完了情報(edited(ninteiKanryo, code));
        }

        private static NinteiKanryoJoho edited(NinteiKanryoJoho kanryo, HanteiKekkaCode code) {
            NinteiKanryoJohoBuilder builder = kanryo.createBuilderForEdit();
            if (HanteiKekkaCode.再審査 == code || HanteiKekkaCode.未審査 == code) {
                builder.set認定審査会割当完了年月日(null);
                builder.set認定審査会完了年月日(null);
                return builder.build();
            }
            if (HanteiKekkaCode.再調査_意見書のみ == code || HanteiKekkaCode.再調査_調査_意見書 == code) {
                builder.set主治医意見書作成依頼完了年月日(null);
                builder.set主治医意見書登録完了年月日(null);
            }
            if (HanteiKekkaCode.再調査_調査のみ == code || HanteiKekkaCode.再調査_調査_意見書 == code) {
                builder.set認定調査依頼完了年月日(null);
                builder.set認定調査完了年月日(null);
            }
            builder.set要介護認定一次判定完了年月日(null);
            builder.setマスキング完了年月日(null);
            builder.set認定審査会割当完了年月日(null);
            builder.set認定審査会完了年月日(null);
            return builder.build();
        }

        private static void update要介護認定申請情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row) {
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, Models.class);
            NinteiShinseiJohoIdentifier identifier = new NinteiShinseiJohoIdentifier(row.getShinseishoKanriNo());
            NinteiShinseiJoho ninteiShinsei = ninteiShinseiJoho.get(identifier);
            NinteiShinseiJohoBuilder builder = ninteiShinsei.createBuilderForEdit();
            builder.set認定申請区分_法令_コード(row.getHoreiKubunCode());
            builder.set取下区分コード(row.getTorisageKubunCode());
            manager.save要介護認定申請情報(builder.build());
        }

        private static void delete削除候補情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, HanteiKekkaCode code) {
            Map<ShinseishoKanriNo, ShinsakaiKekkaTorokuDeletionCandidate> map
                    = ViewStateHolder.get(_ViewStateKey.削除候補, Map.class);
            ShinsakaiKekkaTorokuDeletionCandidate o = map.get(row.getShinseishoKanriNo());
            manager.delete削除候補(o.deletedBy(code));
        }

        private static void delete要介護認定結果情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row) {
            Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定結果情報, Models.class);
            NinteiKekkaJohoIdentifier identifier = new NinteiKekkaJohoIdentifier(row.getShinseishoKanriNo());
            NinteiKekkaJoho ninteiKekka = ninteiKekkaJoho.get(identifier);
            if (ninteiKekka == null) {
                return;
            }
            manager.save要介護認定結果情報(ninteiKekka.deleted());
        }

        private static void save要介護認定結果情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, ShinsakaiWariateJoho 審査会割当) {
            Models<NinteiKekkaJohoIdentifier, NinteiKekkaJoho> ninteiKekkaJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定結果情報, Models.class);
            NinteiKekkaJohoIdentifier identifier = new NinteiKekkaJohoIdentifier(row.getShinseishoKanriNo());
            NinteiKekkaJoho ninteiKekka = ninteiKekkaJoho.get(identifier);
            if (ninteiKekka == null) {
                manager.save要介護認定結果情報(edited(new NinteiKekkaJoho(identifier.get申請書管理番号()), row, 審査会割当));
                return;
            }
            manager.save要介護認定結果情報(edited(ninteiKekka, row, 審査会割当));
        }

        private static NinteiKekkaJoho edited(NinteiKekkaJoho o, TaishoshaIchiranRow row, ShinsakaiWariateJoho 審査会割当) {
            NinteiKekkaJohoBuilder builder = o.createBuilderForEdit();
            builder.set二次判定年月日(row.getNijiHanteiYMD());
            builder.set二次判定要介護状態区分コード(row.getKonkaiNijiHanteiCode());
            builder.set二次判定認定有効期間(row.getNinteiKikanTsukiSu());
            builder.set二次判定認定有効開始年月日(row.getNinteiYukoKikanKaishiYMD());
            builder.set二次判定認定有効終了年月日(row.getNinteiYukoKikanShuryoYMD());
            builder.set介護認定審査会資料作成年月日(審査会割当.get審査会資料作成年月日());
            builder.set介護認定審査会開催番号(審査会割当.get介護認定審査会開催番号());
            builder.set介護認定審査会意見(row.getShinsakaiIken());
            builder.set一次判定結果変更理由(row.getIchijiHanteiKekkaHenkoRiyu());
            builder.set要介護状態像例コード(row.getJotaiZoReiCode());
            builder.set認定審査会意見種類(row.getShinsakaiIkenShuruiCode());
            builder.set審査会メモ(row.getShinsakaiMemo());
            builder.set二次判定結果入力方法(二次判定結果入力方法_画面入力);
            builder.set二次判定結果入力年月日(FlexibleDate.getNowDate());
            return builder.build();
        }
        //</editor-fold>

        private static void deleteBy(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row, RString 開催番号) {
            reset要介護認定申請情報(manager, row);
            delete要介護認定結果情報(manager, row);
            delete介護認定審査会割当情報(manager, row, 開催番号);
        }

        private static void reset要介護認定申請情報(IShinsakakKekksaTorokuManager manager, TaishoshaIchiranRow row) {
            Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> ninteiShinseiJoho
                    = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, Models.class);
            NinteiShinseiJohoIdentifier identifier = new NinteiShinseiJohoIdentifier(row.getShinseishoKanriNo());
            NinteiShinseiJoho ninteiShinsei = ninteiShinseiJoho.get(identifier);
            if (!row.hasTorisageKubunChanged()) {
                return;
            }
            NinteiShinseiJohoBuilder builder = ninteiShinsei.createBuilderForEdit();
            builder.set認定申請区分_法令_コード(Code.EMPTY);
            builder.set取下区分コード(row.getHenkoMaeTorisageKubun());
            manager.save要介護認定申請情報(builder.build());
        }

    }
    //</editor-fold>

    /**
     * 「判定結果」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_HanteiKekka(ShinsakaiKekkaTorokuDiv div) {
        getHandler(div).set個別入力制御変更from判定結果();
        return ResponseData.of(div).respond();
    }

    /**
     * 「二次判定」ドロップダウンリストの選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onChange_NijiHantei(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        YokaigoJotaiKubun09 今回二次判定 = handler.get今回二次判定();
        setNinteiYukoKikanOperatable(div, handler, 今回二次判定);
        if (ShinsakaiKekkaTorokuHandler.is要支援要介護(今回二次判定)) {
            return onChange_NijiHantei_when要介護Or要支援(今回二次判定, div, handler);
        }
        return ResponseData.of(div).respond();
    }

    private static boolean setNinteiYukoKikanOperatable(
            ShinsakaiKekkaTorokuDiv div, ShinsakaiKekkaTorokuHandler handler, YokaigoJotaiKubun09 yokaigodo) {
        boolean operatable = ShinsakaiKekkaTorokuHandler.is要支援要介護(yokaigodo) || yokaigodo == YokaigoJotaiKubun09.なし;
        boolean disabled = !operatable;
        div.getDdlNinteiKikanMonth().setDisabled(disabled);
        div.getTxtNinteiKikanFrom().setDisabled(disabled);
        div.getTxtNinteiKikanTo().setDisabled(disabled);
        if (disabled) {
            div.getDdlNinteiKikanMonth().setSelectedKey(div.getDdlNinteiKikanMonth().getDataSource().get(0).getKey());
            div.getTxtNinteiKikanFrom().clearValue();
            div.getTxtNinteiKikanTo().clearValue();
        }
        handler.set状態像Disabled(yokaigodo != YokaigoJotaiKubun09.要介護1);
        return operatable;
    }

    private static ResponseData<ShinsakaiKekkaTorokuDiv> onChange_NijiHantei_when要介護Or要支援(
            YokaigoJotaiKubun09 今回二次判定, ShinsakaiKekkaTorokuDiv div, ShinsakaiKekkaTorokuHandler handler) {
        handler.set認定期間月数from申請内容();
        handler.change有効月数に関連するコントロール();
        handler.set認定期間開始日();
        handler.set認定期間終了日();
        NinteiShinseiKubunShinsei 申請時申請区分 = handler.get申請時申請区分();
        YokaigoJotaiKubun09 前回二次判定 = handler.get前回二次判定();
        FlexibleDate 前回有効期間終了日 = handler.get前回有効期間終了日();
        FlexibleDate 申請日 = div.getTxtShinseiDay().getValue();
        handler.set法令申請区分(NinteiShinseiKubunHoreiCalculator.calculate(
                申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日));
        handler.set取下区分(TorisageKubun.toValue(
                申請時申請区分, 前回二次判定, 前回有効期間終了日, 今回二次判定, 申請日));
        return ResponseData.of(div).respond();
    }

    /**
     * 「有効月数」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanMonth(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        handler.change有効月数に関連するコントロール();
        if (handler.get認定期間月数() == 0) {
            return ResponseData.of(div).respond();
        }
        if (handler.get認定期間開始日() == null) {
            handler.set認定期間開始日();
        }
        handler.set認定期間終了日();
        return ResponseData.of(div).respond();
    }

    /**
     * メモ定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(審査会メモ定型文GroupCode);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択したメモ定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnMemoTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtShinsakaiMemo().getValue() == null
                ? RString.EMPTY : div.getTxtShinsakaiMemo().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtShinsakaiMemo().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 審査会意見定型文ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(審査会意見定型文GroupCode);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択した意見書定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnIkenTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtShinsakaiIken().getValue() == null
                ? RString.EMPTY : div.getTxtShinsakaiIken().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtShinsakaiIken().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定結果変更理由ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCd(一次判定結果変更理由定型文GroupCode);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ上で選択した一次判定結果変更理由定型文情報を取得します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData onOkClose_btnIChiTeikeibunGuide(ShinsakaiKekkaTorokuDiv div) {

        RStringBuilder serviceSakujo = new RStringBuilder(div.getTxtIchijiHanteiKekkaHenkoRiyu().getValue() == null
                ? RString.EMPTY : div.getTxtIchijiHanteiKekkaHenkoRiyu().getValue());
        serviceSakujo.append(div.getHdnSampleText());
        div.getTxtIchijiHanteiKekkaHenkoRiyu().setValue(serviceSakujo.toRString());

        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査状況照会ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnNinteiChosaJokyoShokai(ShinsakaiKekkaTorokuDiv div) {
        RString 申請書管理番号 = getHandler(div).get申請書管理番号();
        div.setHdnDialogDisplayModeKey(認定調査状況ダイアログ_照会モード);
        if (申請書管理番号 == null) {
            div.setHdnNinteiChosaJokyo(null);
        } else {
            NinteiChosaJokyoFinder finder = NinteiChosaJokyoFinder.createInstance();
            ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(申請書管理番号);
            NinteiChosaJokyoDataPass konkaiDataPass = finder.get認定調査状況DataPass(shinseishoKanriNo);
            RDate 予定年月日 = (div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().getValue() == null) ? null
                    : new RDate(div.getKyotsuHyojiArea().getTxtShinsakaiKaisaiYoteiYMD().getValue().toString());
            konkaiDataPass.set認定審査会予定年月日(予定年月日);
            if (konkaiDataPass.get介護認定審査会資料作成年月日() == null) {
                ShinsakaiWariateJoho shinsakaiWariateJoho = find審査会割当情報(shinseishoKanriNo);
                konkaiDataPass.set介護認定審査会資料作成年月日(
                        shinsakaiWariateJoho == null ? null : toRDate(shinsakaiWariateJoho.get審査会資料作成年月日())
                );
            }
            div.setHdnNinteiChosaJokyo(DataPassingConverter.serialize(konkaiDataPass));
        }
        return ResponseData.of(div).respond();
    }

    private static ShinsakaiWariateJoho find審査会割当情報(ShinseishoKanriNo 申請書管理番号) {
        Models<ShinsakaiWariateJohoIdentifier, ShinsakaiWariateJoho> shinsakaiWariateJohos
                = ViewStateHolder.get(ViewStateKeys.介護認定審査会開催予定情報, Models.class);
        if (shinsakaiWariateJohos == null) {
            return null;
        }
        ShinsakaiWariateJohoIdentifier identifier = new ShinsakaiWariateJohoIdentifier(
                ViewStateHolder.get(ViewStateKeys.開催番号, RString.class),
                申請書管理番号
        );
        return shinsakaiWariateJohos.get(identifier);
    }

    private static RDate toRDate(FlexibleDate fDate) {
        return fDate == null ? null : !fDate.isValid() ? null : new RDate(fDate.toString());
    }

    /**
     * 1.5次判定ダイアログ表示前、データを設定します。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return ResponseData
     */
    public ResponseData<ShinsakaiKekkaTorokuDiv> onBefore_btnIchigoHantei(ShinsakaiKekkaTorokuDiv div) {
        RString 申請書管理番号 = getHandler(div).get申請書管理番号();
        div.getKobetsuHyojiArea().setIchigoMode(一_五次判定ダイアログ_照会モード);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間From」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanFrom(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (handler.get認定期間開始日() == null) {
            return ResponseData.of(div).respond();
        }
        if (handler.get認定期間月数() == 0) {
            handler.set認定期間月数from申請内容();
        }
        handler.set認定期間終了日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「認定期間To」の選択変更。
     *
     * @param div 介護認定審査会審査結果登録Div
     * @return responseData
     */
    public ResponseData onChange_NinteiKikanTo(ShinsakaiKekkaTorokuDiv div) {
        ShinsakaiKekkaTorokuHandler handler = getHandler(div);
        if (handler.get認定期間開始日() == null || handler.get認定期間終了日() == null) {
            return ResponseData.of(div).respond();
        }
        getHandler(div).set認定期間月数from認定期間();
        getHandler(div).change有効月数に関連するコントロール();
        return ResponseData.of(div).respond();
    }

    private static ShinsakaiKekkaTorokuHandler getHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuHandler(div);
    }

    private static ShinsakaiKekkaTorokuValidationHandler getValidationHandler(ShinsakaiKekkaTorokuDiv div) {
        return new ShinsakaiKekkaTorokuValidationHandler(div);
    }

    private void removeViewState() {
        ViewStateHolder.remove(ViewStateKeys.介護認定審査会開催予定情報.name());
        ViewStateHolder.remove(ViewStateKeys.要介護認定申請情報.name());
        ViewStateHolder.remove(ViewStateKeys.要介護認定結果情報.name());
        ViewStateHolder.remove(ViewStateKeys.要介護認定完了情報.name());
        ViewStateHolder.remove(ViewStateKeys.開催番号.name());
        ViewStateHolder.remove(ViewStateKeys.申請書管理番号.name());
    }
}
