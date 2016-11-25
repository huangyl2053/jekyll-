/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBCN130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeisho;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeishoMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.DBCN130001StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.DBCN130001TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.dgShomeishoRireki_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 事業分自己負担額証明書登録（単）のクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JikofutangakuShomeishoToroku {

    private static final RString 排他キー = new RString("DBCHihokenshaNo");
    private static final RString BUTTON_BTNBACKSEARCHRESULT_SEARCHGAMEN = new RString("btnBackSearchResult_SearchGamen");
    private static final RString BUTTON_SAVE = new RString("btnUpdate");
    private static final RString STATUS_新規 = new RString("新規");
    private static final RString STATUS_照会 = new RString("照会");
    private static final RString STATUS_修正 = new RString("修正");
    private static final RString STATUS_削除 = new RString("削除");

    /**
     * 初期化状態です。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onLoad(JikofutangakuShomeishoTorokuDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        RString 前排他キー = 排他キー.concat(被保険者番号.value());
        LockingKey key = new LockingKey(前排他キー);
        if (!RealInitialLocker.tryGetLock(key)) {
            throw new PessimisticLockingException();
        }
        div.setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_BTNBACKSEARCHRESULT_SEARCHGAMEN, false);
        getHandler(div).onLoad(被保険者番号, 識別コード);
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号, 識別コード));
        return ResponseData.of(div).respond();
    }

    /**
     * 新規追加処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnShinkiTsuika(JikofutangakuShomeishoTorokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).新規追加空白チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).新規追加妥当性チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        div.setExecutionStatus(STATUS_新規);
        getHandler(div).set登録情報();
        getHandler(div).set証明書登録To読取専用(false);
        div.getTxtTorokuTaishoNendo().setReadOnly(true);
        div.getTxtTorokuShokisaiHokenshaNo().setReadOnly(true);
        div.getTxtTorokuShikyuShinseishoSeiriNo().setReadOnly(true);
        div.getTxtTorokuRirekiNo().setReadOnly(true);
        div.getTxtJikofutangakuGokei().setReadOnly(true);
        div.getTxtUchiFutangakuGokei().setReadOnly(true);
        return ResponseData.of(div).setState(DBCN130001StateName.証明書登録);
    }

    /**
     * 検索処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnSearch(JikofutangakuShomeishoTorokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).検索チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterForbtnSearch(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<RString> keys = div.getChkIsRirekiHyoji().getSelectedKeys();
        List<JigyoKogakuGassanJikoFutanGakuShomeisho> 証明書情報List;
        if (keys.isEmpty()) {
            証明書情報List = manager.get事業高額合算自己負担額証明書履歴情報(parameter).records();
        } else {
            証明書情報List = manager.get事業高額合算自己負担額証明書情報(parameter).records();
        }

        if (証明書情報List.isEmpty()) {
            div.getDgShomeishoRireki().setDataSource(new ArrayList<dgShomeishoRireki_Row>());
            return ResponseData.of(div).addValidationMessages(getValidationHandler(div).検索対象データなし()).respond();
        }
        getHandler(div).set証明書履歴GRD(証明書情報List);
        return ResponseData.of(div).respond();
    }

    /**
     * 照会処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_shokai(JikofutangakuShomeishoTorokuDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterSelectRow(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<JikofutangakuShomeishoTorokuBusiness> list = manager.get事業高額合算支給申請書情報(parameter).records();
        if (!list.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額証明書情報, list.get(0));
            getHandler(div).set登録情報(list);
        }
        getHandler(div).set証明書登録To読取専用(true);
        div.setExecutionStatus(STATUS_照会);
        return ResponseData.of(div).respond();
    }

    /**
     * 修正処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_shusei(JikofutangakuShomeishoTorokuDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterSelectRow(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<JikofutangakuShomeishoTorokuBusiness> list = manager.get事業高額合算支給申請書情報(parameter).records();
        if (!list.isEmpty() && list.get(0) != null) {
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額証明書情報, list.get(0));
            getHandler(div).set登録情報(list);
        }
        getHandler(div).set証明書登録To読取専用(false);
        div.getTxtTorokuTaishoNendo().setReadOnly(true);
        div.getTxtTorokuShokisaiHokenshaNo().setReadOnly(true);
        div.getTxtTorokuShikyuShinseishoSeiriNo().setReadOnly(true);
        div.getTxtTorokuRirekiNo().setReadOnly(true);
        div.getTxtJikofutangakuGokei().setReadOnly(true);
        div.getTxtUchiFutangakuGokei().setReadOnly(true);
        div.setExecutionStatus(STATUS_修正);
        return ResponseData.of(div).respond();
    }

    /**
     * onStateTransition
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onStateTransition(JikofutangakuShomeishoTorokuDiv div) {
        if (div.getExecutionStatus().equals(STATUS_修正)) {
            CommonButtonHolder.setTextByCommonButtonFieldName(BUTTON_SAVE, STATUS_修正.toString());
        }
        if (div.getExecutionStatus().equals(STATUS_削除)) {
            CommonButtonHolder.setTextByCommonButtonFieldName(BUTTON_SAVE, STATUS_削除.toString());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_sakujo(JikofutangakuShomeishoTorokuDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterSelectRow(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<JikofutangakuShomeishoTorokuBusiness> list = manager.get事業高額合算支給申請書情報(parameter).records();
        if (!list.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額証明書情報, list.get(0));
            getHandler(div).set登録情報(list);
        }
        getHandler(div).set証明書登録To読取専用(true);
        div.setExecutionStatus(STATUS_削除);
        return ResponseData.of(div).respond();
    }

    /**
     * 証明書検索_検索結果一覧へBTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnBackSearchResult_SearchGamen(JikofutangakuShomeishoTorokuDiv div) {
        if (getHandler(div).is証明書検索画面変更()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
                RString 前排他キー = 排他キー.concat(被保険者番号.value());
                LockingKey key = new LockingKey(前排他キー);
                RealInitialLocker.release(key);
                return ResponseData.of(div).forwardWithEventName(DBCN130001TransitionEventName.検索結果一覧に戻る).respond();
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 証明書検索_再検索するBTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnResearch_SearchGamen(JikofutangakuShomeishoTorokuDiv div) {
        if (getHandler(div).is証明書検索画面変更()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
                RString 前排他キー = 排他キー.concat(被保険者番号.value());
                LockingKey key = new LockingKey(前排他キー);
                RealInitialLocker.release(key);
                return ResponseData.of(div).forwardWithEventName(DBCN130001TransitionEventName.対象者検索に戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求めるBTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnGokei(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku8(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutanga9(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku10(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku11(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku12(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku1(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku2(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku3(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku4(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku5(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku6(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtJikofutangaku7(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).自己負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku8(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku9(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku10(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div JikofutangakuShomeishoTorokuDiv
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku11(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku12(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku1(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku2(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku3(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku4(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku5(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku6(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 合計を求める。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onBlur_txtUchiFutangaku7(JikofutangakuShomeishoTorokuDiv div) {
        getHandler(div).うち70_74歳に係る負担額合計の計算();
        return ResponseData.of(div).respond();
    }

    /**
     * 証明書登録_再検索するBTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnResearch_TorokuGamen(JikofutangakuShomeishoTorokuDiv div) {
        JikofutangakuShomeishoTorokuBusiness business
                = ViewStateHolder.get(ViewStateKeys.事業高額合算自己負担額証明書情報, JikofutangakuShomeishoTorokuBusiness.class);
        if (is照会OR削除(div)) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 前排他キー = 排他キー.concat(被保険者番号.value());
            LockingKey key = new LockingKey(前排他キー);
            RealInitialLocker.release(key);
            return ResponseData.of(div).forwardWithEventName(DBCN130001TransitionEventName.対象者検索に戻る).respond();
        }
        if (getHandler(div).is証明書登録画面変更(business)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
                RString 前排他キー = 排他キー.concat(被保険者番号.value());
                LockingKey key = new LockingKey(前排他キー);
                RealInitialLocker.release(key);
                return ResponseData.of(div).forwardWithEventName(DBCN130001TransitionEventName.対象者検索に戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 証明書登録_検索結果一覧へBTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnBackSearchResult_TorokuGamen(JikofutangakuShomeishoTorokuDiv div) {
        JikofutangakuShomeishoTorokuBusiness business
                = ViewStateHolder.get(ViewStateKeys.事業高額合算自己負担額証明書情報, JikofutangakuShomeishoTorokuBusiness.class);
        if (is照会OR削除(div)) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 前排他キー = 排他キー.concat(被保険者番号.value());
            LockingKey key = new LockingKey(前排他キー);
            RealInitialLocker.release(key);
            return ResponseData.of(div).forwardWithEventName(DBCN130001TransitionEventName.検索結果一覧に戻る).respond();
        }
        if (getHandler(div).is証明書登録画面変更(business)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
                RString 前排他キー = 排他キー.concat(被保険者番号.value());
                LockingKey key = new LockingKey(前排他キー);
                RealInitialLocker.release(key);
                return ResponseData.of(div).forwardWithEventName(DBCN130001TransitionEventName.検索結果一覧に戻る).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 証明書検索に戻るBTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnBack(JikofutangakuShomeishoTorokuDiv div) {
        JikofutangakuShomeishoTorokuBusiness business
                = ViewStateHolder.get(ViewStateKeys.事業高額合算自己負担額証明書情報, JikofutangakuShomeishoTorokuBusiness.class);
        if (is照会OR削除(div)) {
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 前排他キー = 排他キー.concat(被保険者番号.value());
            LockingKey key = new LockingKey(前排他キー);
            RealInitialLocker.release(key);
            getHandler(div).set登録情報();
            return ResponseData.of(div).setState(DBCN130001StateName.証明書検索);
        }
        if (getHandler(div).is証明書登録画面変更(business)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if ((new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
                RString 前排他キー = 排他キー.concat(被保険者番号.value());
                LockingKey key = new LockingKey(前排他キー);
                RealInitialLocker.release(key);
                getHandler(div).set登録情報();
                return ResponseData.of(div).setState(DBCN130001StateName.証明書検索);
            }
        }
        return ResponseData.of(div).respond();
    }

    private boolean is照会OR削除(JikofutangakuShomeishoTorokuDiv div) {
        return STATUS_照会.equals(div.getExecutionStatus()) || STATUS_削除.equals(div.getExecutionStatus());
    }

    /**
     * 更新用BTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnUpdate(JikofutangakuShomeishoTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            if (div.getExecutionStatus().equals(STATUS_新規)) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (div.getExecutionStatus().equals(STATUS_削除)) {
                QuestionMessage message = new QuestionMessage(DbcQuestionMessages.確認メッセージ.getMessage().getCode(),
                        DbcQuestionMessages.確認メッセージ.getMessage().replace(STATUS_削除.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (div.getExecutionStatus().equals(STATUS_修正)) {
                QuestionMessage message = new QuestionMessage(DbcQuestionMessages.確認メッセージ.getMessage().getCode(),
                        DbcQuestionMessages.確認メッセージ.getMessage().replace(STATUS_修正.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            JikofutangakuShomeishoTorokuBusiness business
                    = ViewStateHolder.get(ViewStateKeys.事業高額合算自己負担額証明書情報, JikofutangakuShomeishoTorokuBusiness.class);
            if (STATUS_新規.equals(div.getExecutionStatus()) || STATUS_修正.equals(div.getExecutionStatus())) {
                ValidationMessageControlPairs validPairs = getValidationHandler(div).更新処理チェック(getHandler(div).is修正_証明書登録画面変更(business));
                if (validPairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(validPairs).respond();
                }
            }
            RStringBuilder 完了メッセージ = new RStringBuilder("対象者の自己負担額証明書情報の、");
            if (STATUS_新規.equals(div.getExecutionStatus())) {
                insert(div);
                完了メッセージ.append(new RString("新規追加"));
            } else if (STATUS_修正.equals(div.getExecutionStatus())) {
                update(div, business);
                完了メッセージ.append(STATUS_修正);
            } else if (STATUS_削除.equals(div.getExecutionStatus())) {
                delete(business);
                完了メッセージ.append(STATUS_削除);
            }
            完了メッセージ.append(new RString("が完了しました。"));
            TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RStringBuilder messageTaisho1 = new RStringBuilder(被保険者番号.value());
            messageTaisho1.append(new RString("："));
            messageTaisho1.append(div.getCcdAtenaInfo().get氏名漢字());
            RStringBuilder messageTaisho2 = new RStringBuilder();
            messageTaisho2.append(new RString("支給申請書整理番号："));
            messageTaisho2.append(div.getTxtTorokuShikyuShinseishoSeiriNo().getValue());

            div.getCcdKanryoMessage().setMessage(
                    完了メッセージ.toRString(), RString.EMPTY,
                    messageTaisho1.toRString(), messageTaisho2.toRString(), true);
            return ResponseData.of(div).setState(DBCN130001StateName.処理完了);
        }
        return ResponseData.of(div).respond();
    }

    private void insert(JikofutangakuShomeishoTorokuDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        int count = manager.get事業高額合算自己負担額証明書Count(getHandler(div).getParameterFor登録(被保険者番号));
        if (count == 0) {
            manager.save事業高額合算自己負担額証明書and明細(getHandler(div).get事業高額合算自己負担額証明書(被保険者番号, Decimal.ZERO),
                    getHandler(div).get事業高額合算自己負担額証明書明細(被保険者番号, Decimal.ZERO));
        } else {
            Decimal 履歴番号 = manager.get事業高額合算自己負担額証明書最新履歴番号(getHandler(div).getParameterFor登録(被保険者番号));
            manager.save事業高額合算自己負担額証明書and明細(getHandler(div).get事業高額合算自己負担額証明書(被保険者番号, 履歴番号),
                    getHandler(div).get事業高額合算自己負担額証明書明細(被保険者番号, 履歴番号));
        }
    }

    private void update(JikofutangakuShomeishoTorokuDiv div, JikofutangakuShomeishoTorokuBusiness business) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = business.get事業高額合算自己負担額証明書情報();
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = business.get事業高額合算自己負担額証明書明細情報();
        if (shomeisho.get転入前保険者番号().value().equals(div.getCcdTennyumaeHokensha().getHokenjaNo())) {

            Decimal 履歴番号 = manager.get事業高額合算自己負担額証明書最新履歴番号(getHandler(div).getParameterFor登録(被保険者番号));
            if (履歴番号 != null && !Decimal.ZERO.equals(履歴番号)) {
                manager.save事業高額合算自己負担額証明書(getHandler(div).get更新用事業高額合算自己負担額証明書1(被保険者番号, shomeisho),
                        getHandler(div).get更新用事業高額合算自己負担額証明書明細1(被保険者番号, meisaiList));
            } else {
                JigyoKogakuGassanJikoFutanGakuShomeisho updateShomeisho = getHandler(div).get更新用事業高額合算自己負担額証明書(被保険者番号, shomeisho);
                manager.save事業高額合算自己負担額証明書(updateShomeisho,
                        getHandler(div).get更新用事業高額合算自己負担額証明書明細(被保険者番号, meisaiList));
            }

        } else {

            manager.save事業高額合算自己負担額証明書and明細(
                    getHandler(div).get事業高額合算自己負担額証明書(被保険者番号, Decimal.ZERO),
                    getHandler(div).get事業高額合算自己負担額証明書明細(被保険者番号, Decimal.ZERO),
                    getHandler(div).get更新用事業高額合算自己負担額証明書1(被保険者番号, shomeisho),
                    getHandler(div).get更新用事業高額合算自己負担額証明書明細1(被保険者番号, meisaiList));
        }
    }

    private void delete(JikofutangakuShomeishoTorokuBusiness business) {
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = business.get事業高額合算自己負担額証明書情報();
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = business.get事業高額合算自己負担額証明書明細情報();
        manager.delete事業高額合算自己負担額証明書and明細(shomeisho, meisaiList);
    }

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * Handlerを取得します。
     *
     * @param div JikofutangakuShomeishoTorokuDiv
     * @return JikofutangakuShomeishoTorokuHandler
     */
    public JikofutangakuShomeishoTorokuHandler getHandler(JikofutangakuShomeishoTorokuDiv div) {
        return new JikofutangakuShomeishoTorokuHandler(div);
    }

    /**
     * ValidationHandlerを取得します。
     *
     * @param div div
     * @return JikofutangakuShomeishoTorokuValidationHandler
     */
    public JikofutangakuShomeishoTorokuValidationHandler getValidationHandler(JikofutangakuShomeishoTorokuDiv div) {
        return new JikofutangakuShomeishoTorokuValidationHandler(div);
    }
}
