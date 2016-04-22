/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1020001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.DBD1020001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.DBD1020001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.RiyoshaFutangakuGengakuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001.ddlShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001.RiyoshaFutangakuGengakuHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001.RiyoshaFutangakuGengakuHandler.RiyoshaFutangakuGengakuComparator;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1020001.RiyoshaFutangakuGengakuValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担額減額申請のクラスです。
 *
 * @reamsid_L DBD-3600-010 xuyue
 */
public class RiyoshaFutangakuGengakuPanel {

    private final RString 承認メニュー = new RString("DBDMN22002");
    private static final RString 空白KEY = new RString("-1");
    private static final RString 承認する_KEY = new RString("key0");
    private static final Decimal 給付率_81 = new Decimal(81);
    private static final Decimal 給付率_91 = new Decimal(91);
    private static final Decimal 給付率_100 = new Decimal(100);

    /**
     * 利用者負担額減額申請の初期化。(オンロード)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onLoad(RiyoshaFutangakuGengakuPanelDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 利用者負担額減額申請の初期化。(オンアクティブ)
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onActive(RiyoshaFutangakuGengakuPanelDiv div) {

        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「申請情報/承認情報を追加する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnInputNew(RiyoshaFutangakuGengakuPanelDiv div) {

        getHandler(div).追加するボタン押下();
        return ResponseData.of(div).setState(DBD1020001StateName.入力);
    }

    /**
     * 申請一覧の修正ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnModify(RiyoshaFutangakuGengakuPanelDiv div) {
        getHandler(div).申請一覧の修正ボタンをクリック();
        return ResponseData.of(div).setState(DBD1020001StateName.入力);
    }

    /**
     * 申請一覧の削除ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnDelete(RiyoshaFutangakuGengakuPanelDiv div) {
        ddlShinseiIchiran_Row row = div.getDdlShinseiIchiran().getActiveRow();
        RString 決定区分 = row.getKetteiKubun();
        if (決定区分 != null && !決定区分.isEmpty()) {
            throw new ApplicationException(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage());
        }
        getHandler(div).申請一覧の削除ボタンをクリック();
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「申請一覧に戻る」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnBackShinseiIchirai(RiyoshaFutangakuGengakuPanelDiv div) {
        div.getDdlShinseiIchiran().setDisabled(false);
        div.getBtnShinseiKakutei().setVisible(false);
        div.getBtnConfirm().setVisible(false);
        getHandler(div).入力情報をクリア();
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「承認情報を確定する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnConfirm(RiyoshaFutangakuGengakuPanelDiv div) {

        RString 決定区分 = div.getRadKetteiKubun().getSelectedKey();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (承認する_KEY.equals(決定区分)) {
            getValidationHandler().validateFor適用日の必須入力(pairs, div);
            getValidationHandler().validateFor有効期限の必須入力(pairs, div);
            getValidationHandler().validateFor給付率の必須入力(pairs, div);
        }
        getValidationHandler().validateFor申請日の必須入力(pairs, div);
        getValidationHandler().validateFor決定区分の必須入力(pairs, div);
        getValidationHandler().validateFor決定日の必須入力(pairs, div);

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        if (!承認する_KEY.equals(決定区分)) {
            getHandler(div).承認情報を確定するボタン押下();
            return ResponseData.of(div).setState(DBD1020001StateName.一覧);
        }

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RiyoshaFutangakuGengakuService service = RiyoshaFutangakuGengakuService.createInstance();

        FutanwariaiKubun 負担割合区分 = service.get利用者負担割合(被保険者番号, div.getTxtShinseiYmd().getValue());
        Decimal 給付率 = Decimal.ZERO;
        if (div.getTxtKyufuRitsu() != null && div.getTxtKyufuRitsu().getValue() != null) {
            給付率 = div.getTxtKyufuRitsu().getValue();
        }
        if ((FutanwariaiKubun._２割.getコード().equals(負担割合区分.getコード())
                && (給付率.compareTo(給付率_81) < 0 || 給付率.compareTo(給付率_100) > 0))
                || (FutanwariaiKubun._１割.getコード().equals(負担割合区分.getコード())
                && (給付率.compareTo(給付率_91) < 0 || 給付率.compareTo(給付率_100) > 0))) {
            throw new ApplicationException(DbdErrorMessages.利用者負担額減額_給付率範囲外.getMessage());
        }

        FlexibleDate 適用日 = div.getTxtTekiyoYmd().getValue();
        RString 法施行日 = DbBusinessConifg.get(ConfigNameDBU.介護保険法情報_介護保険施行日, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (!new FlexibleDate(法施行日).isBeforeOrEquals(適用日)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_適用日が法施行前.getMessage());
        }

        FlexibleDate 標準有効期限 = service.estimate有効期限(適用日);
        FlexibleDate 有効期限 = div.getTxtYukoKigenYmd().getValue();
        if (!有効期限.isBefore(標準有効期限)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_有効期限が年度外.getMessage());
        }

        if (!適用日.isBeforeOrEquals(有効期限)) {
            throw new ApplicationException(DbdErrorMessages.減免減額_有効期限が適用日以前.getMessage());
        }

        boolean 利用者 = service.canBe利用者(被保険者番号, 適用日);
        if (!利用者) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
        }
        getHandler(div).承認情報を確定するボタン押下();
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「申請情報を確定する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnShinseiKakutei(RiyoshaFutangakuGengakuPanelDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor申請日の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).申請情報を確定するボタン押下();
        return ResponseData.of(div).setState(DBD1020001StateName.一覧);
    }

    /**
     * 「決定区分」ラジオボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onChange_radKetteiKubun(RiyoshaFutangakuGengakuPanelDiv div) {
        getHandler(div).承認情報エリア状態(div.getRadKetteiKubun().getSelectedKey(), false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「減免情報を表示する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onBeforeOpenDialog_btnShowGemmenJoho(RiyoshaFutangakuGengakuPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        div.setHihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「DBD.GemmenShokai」ダイアログを閉じる処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onOkClose_btnShowGemmenJoho(RiyoshaFutangakuGengakuPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「承認しない理由」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onBeforeOpenDialog_btnHiShoninRiyu(RiyoshaFutangakuGengakuPanelDiv div) {
        div.setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHidden登録グループコード(SampleBunshoGroupCodes.減免減額_承認しない理由.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された承認しない理由を本画面にセットします。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onOkClose_btnHiShoninRiyu(RiyoshaFutangakuGengakuPanelDiv div) {
        div.getTxtHiShoninRiyu().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * 「適用日」のonBlur処理に、有効期限を編集します。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onBlur_txtTekiyoYmd(RiyoshaFutangakuGengakuPanelDiv div) {
        getHandler(div).get有効期限By適用日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請情報を保存する/承認情報を保存する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    @Transaction
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnUpdate(RiyoshaFutangakuGengakuPanelDiv div) {

        if (new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        boolean 変更あり = getHandler(div).申請一覧_変更あり();
        if (!変更あり) {
            InformationMessage message = new InformationMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode(),
                    DbzInformationMessages.内容変更なしで保存不可.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (!ResponseHolder.getMenuID().equals(承認メニュー)
                && getHandler(div).適用期間重複あり()) {
            throw new ApplicationException(DbdErrorMessages.減免減額_適用期間重複.getMessage());
        }

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            PersonalData personalData = getHandler(div).toPersonalData(識別コード, 被保険者番号);
            AccessLogger.log(AccessLogType.更新, personalData);

            保存処理();
            前排他キーの解除();
            div.getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("処理").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).setState(DBD1020001StateName.完了メッセージ);
    }

    /**
     * 「再検索する」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnReSearch(RiyoshaFutangakuGengakuPanelDiv div) {

        getHandler(div).viewState破棄();
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD1020001TransitionEventName.検索処理へ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン押下時の処理です。
     *
     * @param div RiyoshaFutangakuGengakuPanelPanelDiv
     * @return レスポンスデータ
     */
    public ResponseData<RiyoshaFutangakuGengakuPanelDiv> onClick_btnToSearchResult(RiyoshaFutangakuGengakuPanelDiv div) {
        getHandler(div).viewState破棄();
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD1020001TransitionEventName.検索結果一覧へ).respond();
    }

    @Transaction
    private void 保存処理() {

        List<RiyoshaFutangakuGengakuViewState> orderViewStateList = new ArrayList<>();
        List<RiyoshaFutangakuGengakuViewState> 削除List = new ArrayList<>();
        履歴番号の修正(orderViewStateList, 削除List);

        List<RiyoshaFutangakuGengakuViewState> 追加List = new ArrayList<>();
        List<RiyoshaFutangakuGengakuViewState> 修正List = new ArrayList<>();
        List<RiyoshaFutangakuGengakuViewState> 履歴修正ありList = new ArrayList<>();
        for (RiyoshaFutangakuGengakuViewState viewState : orderViewStateList) {
            if (EntityDataState.Added == viewState.getState()) {
                追加List.add(viewState);
            } else if (EntityDataState.Modified == viewState.getState()
                    && viewState.getShorigoRirekiNo() == viewState.getRiyoshaFutangakuGengaku().get履歴番号()) {
                修正List.add(viewState);
            } else if (viewState.getShorigoRirekiNo() != viewState.getRiyoshaFutangakuGengaku().get履歴番号()) {
                履歴修正ありList.add(viewState);
            }
        }

        if (削除List.size() > 0) {
            delete(削除List);
        }
        if (修正List.size() > 0) {
            更新or登録(修正List);
        }
        if (履歴修正ありList.size() > 0) {
            delete(履歴修正ありList);
            更新or登録(履歴修正ありList);
        }
        if (追加List.size() > 0) {
            更新or登録(追加List);
        }
    }

    private void 履歴番号の修正(List<RiyoshaFutangakuGengakuViewState> orderViewStateList, List<RiyoshaFutangakuGengakuViewState> 削除List) {

        ArrayList<RiyoshaFutangakuGengakuViewState> viewStateList
                = ViewStateHolder.get(RiyoshaFutangakuGengakuHandler.Dbd1020001Keys.利用者負担額減額情報ListのViewState, ArrayList.class);
        Collections.sort(viewStateList, new RiyoshaFutangakuGengakuComparator());

        int size = viewStateList.size();
        int minRirekiNo = 0;
        boolean isRirekiNoSet = false;

        List<RiyoshaFutangakuGengakuViewState> not削除List = new ArrayList<>();
        RiyoshaFutangakuGengakuViewState joho;
        EntityDataState 状態;
        EntityDataState 始まり承認データ状態 = EntityDataState.Unchanged;
        for (int i = 0; i < size; i++) {
            joho = viewStateList.get(i);
            状態 = joho.getState();
            if (!isRirekiNoSet && (EntityDataState.Unchanged == 状態 || EntityDataState.Modified == 状態)) {
                isRirekiNoSet = true;
                minRirekiNo = joho.getShorigoRirekiNo();
                始まり承認データ状態 = 状態;
            }
            if (EntityDataState.Deleted == 状態) {
                削除List.add(joho);
            } else {
                not削除List.add(joho);
            }
        }
        if (ResponseHolder.getMenuID().equals(承認メニュー) && EntityDataState.Modified == 始まり承認データ状態
                && minRirekiNo == 0) {
            minRirekiNo = 1;
        }

        int tmpRirekiNo = 0;
        RiyoshaFutangakuGengakuViewState joho１;
        RiyoshaFutangakuGengakuViewState joho２;
        size = not削除List.size();
        for (int i = 0; i < size; i++) {

            joho１ = not削除List.get(i);
            tmpRirekiNo = joho１.getShorigoRirekiNo();

            if (joho１.getShorigoRirekiNo() < minRirekiNo && i == 0) {
                tmpRirekiNo = minRirekiNo;
            } else if (joho１.getShorigoRirekiNo() < 0) {
                tmpRirekiNo = not削除List.get(i - 1).getShorigoRirekiNo() + 1;
            }
            joho１ = joho１.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();

            if (i < size - 1) {
                joho２ = not削除List.get(i + 1);
                if (joho２.getShorigoRirekiNo() <= joho１.getShorigoRirekiNo()) {
                    tmpRirekiNo = tmpRirekiNo + 1;
                    joho２ = joho２.createBuilderForEdit().setShorigoRirekiNo(tmpRirekiNo).build();
                    not削除List.set(i + 1, joho２);
                }
            }
            orderViewStateList.add(joho１);
        }
    }

    private void delete(List<RiyoshaFutangakuGengakuViewState> 削除List) {
        RiyoshaFutangakuGengakuManager manager = RiyoshaFutangakuGengakuManager.createInstance();

        RiyoshaFutangakuGengaku joho;
        RiyoshaFutangakuGengaku object;
        for (RiyoshaFutangakuGengakuViewState viewState : 削除List) {
            joho = viewState.getRiyoshaFutangakuGengaku();
            object = manager.get利用者負担額減額(RiyoshaFutangakuGengakuMapperParameter.createSelectByKeyParam(joho.get証記載保険者番号(), joho.get被保険者番号(), joho.get履歴番号()));
            if (object != null) {
                manager.delete利用者負担額減額(object);
            }
        }
    }

    private void 更新or登録(List<RiyoshaFutangakuGengakuViewState> 保存List) {
        RiyoshaFutangakuGengakuManager manager = RiyoshaFutangakuGengakuManager.createInstance();

        RiyoshaFutangakuGengaku joho;
        RiyoshaFutangakuGengaku dbObject;
        for (RiyoshaFutangakuGengakuViewState viewState : 保存List) {
            int 履歴番号 = viewState.getShorigoRirekiNo();
            joho = viewState.getRiyoshaFutangakuGengaku();
            joho = joho.createBuilderForEdit().set履歴番号(履歴番号).build();

            dbObject = manager.get利用者負担額減額(RiyoshaFutangakuGengakuMapperParameter.createSelectByKeyParam(joho.get証記載保険者番号(), joho.get被保険者番号(), joho.get履歴番号()));
            if (dbObject != null) {
                update(joho, dbObject, manager);
            } else {
                insert(joho, manager);
            }
        }
    }

    private void update(RiyoshaFutangakuGengaku joho, RiyoshaFutangakuGengaku dbObject,
            RiyoshaFutangakuGengakuManager manager) {

        RiyoshaFutangakuGengakuBuilder builder = dbObject.createBuilderForEdit();
        builder.set旧措置者有無(joho.is旧措置者有無());
        if (joho.get申請事由() != null) {
            builder.set申請事由(joho.get申請事由());
        }
        builder.set申請年月日(joho.get申請年月日());
        if (joho.get決定区分() != null && KetteiKubun.承認する.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set適用開始年月日(joho.get適用開始年月日());
            builder.set適用終了年月日(joho.get適用終了年月日());
            builder.set給付率(joho.get給付率());
            builder.set非承認理由(RString.EMPTY);

        } else if (joho.get決定区分() != null && KetteiKubun.承認しない.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set非承認理由(joho.get非承認理由());
            builder.set給付率(HokenKyufuRitsu.ZERO);
            builder.set適用開始年月日(FlexibleDate.EMPTY);
            builder.set適用終了年月日(FlexibleDate.EMPTY);
        }

        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = dbObject.getGemmenGengakuShinseiList().get(0).createBuilderForEdit();
        GemmenGengakuShinsei gemmenGengakuShinsei = joho.getGemmenGengakuShinseiList().get(0);
        if (gemmenGengakuShinsei.get事業者区分() != null && !空白KEY.equals(gemmenGengakuShinsei.get事業者区分())) {
            gemmenGengakuShinseiBuilder.set事業者区分(gemmenGengakuShinsei.get事業者区分());
        }
        if (gemmenGengakuShinsei.get申請届出代行事業者番号() != null && !gemmenGengakuShinsei.get申請届出代行事業者番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(gemmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (gemmenGengakuShinsei.get申請届出代行区分() != null && !空白KEY.equals(gemmenGengakuShinsei.get申請届出代行区分())) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(gemmenGengakuShinsei.get申請届出代行区分());
        }
        if (gemmenGengakuShinsei.get申請届出者住所() != null && !gemmenGengakuShinsei.get申請届出者住所().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者住所(gemmenGengakuShinsei.get申請届出者住所());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名() != null && !gemmenGengakuShinsei.get申請届出者氏名().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名(gemmenGengakuShinsei.get申請届出者氏名());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名カナ() != null && !gemmenGengakuShinsei.get申請届出者氏名カナ().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(gemmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (gemmenGengakuShinsei.get申請届出者続柄() != null && !gemmenGengakuShinsei.get申請届出者続柄().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者続柄(gemmenGengakuShinsei.get申請届出者続柄());
        }
        if (gemmenGengakuShinsei.get申請届出者郵便番号() != null && !gemmenGengakuShinsei.get申請届出者郵便番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者郵便番号(gemmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (gemmenGengakuShinsei.get申請届出者電話番号() != null && !gemmenGengakuShinsei.get申請届出者電話番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者電話番号(gemmenGengakuShinsei.get申請届出者電話番号());
        }
        gemmenGengakuShinsei = gemmenGengakuShinseiBuilder.build();

        builder.setGemmenGengakuShinsei(gemmenGengakuShinsei);
        dbObject = builder.build();
        manager.save利用者負担額減額(dbObject);
    }

    private void insert(RiyoshaFutangakuGengaku joho, RiyoshaFutangakuGengakuManager manager) {

        RiyoshaFutangakuGengaku object = new RiyoshaFutangakuGengaku(joho.get証記載保険者番号(), joho.get被保険者番号(), joho.get履歴番号());

        RiyoshaFutangakuGengakuBuilder builder = object.createBuilderForEdit();
        builder.set旧措置者有無(joho.is旧措置者有無());
        if (joho.get申請事由() != null) {
            builder.set申請事由(joho.get申請事由());
        }
        builder.set申請年月日(joho.get申請年月日());
        if (joho.get決定区分() != null && KetteiKubun.承認する.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set適用開始年月日(joho.get適用開始年月日());
            builder.set適用終了年月日(joho.get適用終了年月日());
            builder.set給付率(joho.get給付率());
        } else if (joho.get決定区分() != null && KetteiKubun.承認しない.getコード().equals(joho.get決定区分())) {
            builder.set決定区分(joho.get決定区分());
            builder.set決定年月日(joho.get決定年月日());
            builder.set非承認理由(joho.get非承認理由());
        }

        GemmenGengakuShinsei gemmenGengakuShinsei = new GemmenGengakuShinsei(joho.get証記載保険者番号(), joho.get被保険者番号(), GemmenGengakuShurui.利用者負担額減額.getコード(), joho.get履歴番号());
        GemmenGengakuShinseiBuilder gemmenGengakuShinseiBuilder = gemmenGengakuShinsei.createBuilderForEdit();
        if (gemmenGengakuShinsei.get事業者区分() != null && !空白KEY.equals(gemmenGengakuShinsei.get事業者区分())) {
            gemmenGengakuShinseiBuilder.set事業者区分(gemmenGengakuShinsei.get事業者区分());
        }
        if (gemmenGengakuShinsei.get申請届出代行事業者番号() != null && !gemmenGengakuShinsei.get申請届出代行事業者番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出代行事業者番号(gemmenGengakuShinsei.get申請届出代行事業者番号());
        }
        if (gemmenGengakuShinsei.get申請届出代行区分() != null && !空白KEY.equals(gemmenGengakuShinsei.get申請届出代行区分())) {
            gemmenGengakuShinseiBuilder.set申請届出代行区分(gemmenGengakuShinsei.get申請届出代行区分());
        }
        if (gemmenGengakuShinsei.get申請届出者住所() != null && !gemmenGengakuShinsei.get申請届出者住所().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者住所(gemmenGengakuShinsei.get申請届出者住所());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名() != null && !gemmenGengakuShinsei.get申請届出者氏名().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名(gemmenGengakuShinsei.get申請届出者氏名());
        }
        if (gemmenGengakuShinsei.get申請届出者氏名カナ() != null && !gemmenGengakuShinsei.get申請届出者氏名カナ().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者氏名カナ(gemmenGengakuShinsei.get申請届出者氏名カナ());
        }
        if (gemmenGengakuShinsei.get申請届出者続柄() != null && !gemmenGengakuShinsei.get申請届出者続柄().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者続柄(gemmenGengakuShinsei.get申請届出者続柄());
        }
        if (gemmenGengakuShinsei.get申請届出者郵便番号() != null && !gemmenGengakuShinsei.get申請届出者郵便番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者郵便番号(gemmenGengakuShinsei.get申請届出者郵便番号());
        }
        if (gemmenGengakuShinsei.get申請届出者電話番号() != null && !gemmenGengakuShinsei.get申請届出者電話番号().isEmpty()) {
            gemmenGengakuShinseiBuilder.set申請届出者電話番号(gemmenGengakuShinsei.get申請届出者電話番号());
        }
        gemmenGengakuShinsei = gemmenGengakuShinseiBuilder.build();
        builder.setGemmenGengakuShinsei(gemmenGengakuShinsei);
        object = builder.build();
        manager.save利用者負担額減額(object);
    }

    private void 前排他キーの解除() {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("RiyoshaFutanGengaku")));
        RealInitialLocker.release(排他キー);
    }

    private RiyoshaFutangakuGengakuHandler getHandler(RiyoshaFutangakuGengakuPanelDiv div) {
        return new RiyoshaFutangakuGengakuHandler(div);
    }

    private RiyoshaFutangakuGengakuValidationHandler getValidationHandler() {
        return new RiyoshaFutangakuGengakuValidationHandler();
    }
}
