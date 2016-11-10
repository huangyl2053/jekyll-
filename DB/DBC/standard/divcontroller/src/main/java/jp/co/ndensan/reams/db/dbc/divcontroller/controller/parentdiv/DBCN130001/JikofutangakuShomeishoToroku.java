/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBCN130001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeisho;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeishoMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.DBCN130001StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.DBCN130001TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo("0000000010"));
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000033"));
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
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
        return ResponseData.of(div).respond();
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
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterForbtnSearch(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<RString> keys = div.getChkIsRirekiHyoji().getSelectedKeys();
        List<JigyoKogakuGassanJikoFutanGakuShomeisho> 証明書情報List;
        if (keys.isEmpty()) {
            証明書情報List = manager.get事業高額合算自己負担額証明書情報(parameter).records();
        } else {
            証明書情報List = manager.get事業高額合算自己負担額証明書履歴情報(parameter).records();
        }

        if (証明書情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
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
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterSelectRow(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<JikofutangakuShomeishoTorokuBusiness> list = manager.get事業高額合算支給申請書情報(parameter).records();
        if (!list.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額証明書情報, list.get(0));
            getHandler(div).set登録情報(list);
        }
        getHandler(div).set証明書登録To読取専用();
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
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterSelectRow(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<JikofutangakuShomeishoTorokuBusiness> list = manager.get事業高額合算支給申請書情報(parameter).records();
        if (!list.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額証明書情報, list.get(0));
            getHandler(div).set登録情報(list);
        }
        div.setExecutionStatus(STATUS_修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_sakujo(JikofutangakuShomeishoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JikofutangakuShomeishoTorokuParameter parameter = getHandler(div).getParameterSelectRow(被保険者番号);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        List<JikofutangakuShomeishoTorokuBusiness> list = manager.get事業高額合算支給申請書情報(parameter).records();
        if (!list.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.事業高額合算自己負担額証明書情報, list.get(0));
            getHandler(div).set登録情報(list);
        }
        getHandler(div).set証明書登録To読取専用();
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
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
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
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
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
     * @param div div
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
        if (getHandler(div).is証明書登録画面変更(business)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
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
        if (getHandler(div).is証明書登録画面変更(business)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
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
        if (getHandler(div).is証明書登録画面変更(business)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
                RString 前排他キー = 排他キー.concat(被保険者番号.value());
                LockingKey key = new LockingKey(前排他キー);
                RealInitialLocker.release(key);
                getHandler(div).set登録情報();
                return ResponseData.of(div).setState(DBCN130001StateName.証明書検索);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 更新用BTN処理を行う。
     *
     * @param div div
     * @return ResponseData<JikofutangakuShomeishoTorokuDiv>
     */
    public ResponseData<JikofutangakuShomeishoTorokuDiv> onClick_btnUpdate(JikofutangakuShomeishoTorokuDiv div) {
        JikofutangakuShomeishoTorokuBusiness business
                = ViewStateHolder.get(ViewStateKeys.事業高額合算自己負担額証明書情報, JikofutangakuShomeishoTorokuBusiness.class);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).更新処理チェック(getHandler(div).is修正_証明書登録画面変更(business));
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
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

        RStringBuilder messageTaisho1 = new RStringBuilder(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class).value());
        messageTaisho1.append(new RString("："));
        messageTaisho1.append(div.getCcdAtenaInfo().get氏名漢字());
        RStringBuilder messageTaisho2 = new RStringBuilder();
        messageTaisho2.append(new RString("支給申請書整理番号"));
        messageTaisho2.append(business.get事業高額合算自己負担額証明書情報().get支給申請書整理番号());

        div.getCcdKanryoMessage().setMessage(
                完了メッセージ.toRString(), RString.EMPTY,
                messageTaisho1.toRString(), messageTaisho2.toRString(), true);
        return ResponseData.of(div).setState(DBCN130001StateName.処理完了);
    }

    private void insert(JikofutangakuShomeishoTorokuDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        int count = manager.get事業高額合算自己負担額証明書Count(getHandler(div).getParameterFor登録(被保険者番号));
        if (count == 0) {
            manager.save事業高額合算自己負担額証明書(getHandler(div).get事業高額合算自己負担額証明書(被保険者番号, Decimal.ZERO));
            manager.save事業高額合算自己負担額証明書明細(getHandler(div).get事業高額合算自己負担額証明書明細(被保険者番号, Decimal.ZERO));
        } else {
            Decimal 履歴番号 = manager.get事業高額合算自己負担額証明書最新履歴番号(getHandler(div).getParameterFor登録(被保険者番号));
            manager.save事業高額合算自己負担額証明書(getHandler(div).get事業高額合算自己負担額証明書(被保険者番号, 履歴番号));
            manager.save事業高額合算自己負担額証明書明細(getHandler(div).get事業高額合算自己負担額証明書明細(被保険者番号, 履歴番号));
        }
    }

    private void update(JikofutangakuShomeishoTorokuDiv div, JikofutangakuShomeishoTorokuBusiness business) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = business.get事業高額合算自己負担額証明書情報();
        if (shomeisho.get転入前保険者番号().value().equals(div.getCcdTennyumaeHokensha().getHokenjaNo())) {
            manager.save事業高額合算自己負担額証明書(shomeisho.createBuilderForEdit().set自己負担額証明書整理番号(div.getTxtJikofutangakuShomeishoSeiriNo().getValue())
                    .set転入前保険者名(div.getCcdTennyumaeHokensha().getHokenjaName())
                    .set対象計算期間開始年月日(new FlexibleDate(div.getTxtTaishoKikan().getFromValue().toDateString()))
                    .set対象計算期間終了年月日(new FlexibleDate(div.getTxtTaishoKikan().getToValue().toDateString()))
                    .set被保険者期間開始年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getFromValue().toDateString()))
                    .set被保険者期間終了年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getToValue().toDateString()))
                    .set発行年月日(div.getTxtHakkoDate().getValue())
                    .set合計合計_自己負担額(div.getTxtJikofutangakuGokei().getValue())
                    .set合計_70_74自己負担額_内訳(div.getTxtUchiFutangakuGokei().getValue())
                    .set支給額計算結果連絡先郵便番号(div.getTxtYubinNo().getValue())
                    .set支給額計算結果連絡先住所(div.getTxtRenrakusakiJusho().getValue())
                    .set支給額計算結果連絡先名称1(div.getTxtRenrakusakiMei1().getValue())
                    .set支給額計算結果連絡先名称2(div.getTxtRenrakusakiMei2().getValue())
                    .set受付年月日(div.getTxtUketsukeDate().getValue()).build());
            List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = business.get事業高額合算自己負担額証明書明細情報();
            manager.delete事業高額合算自己負担額証明書明細(meisaiList);
            manager.save事業高額合算自己負担額証明書明細(getHandler(div).get更新用事業高額合算自己負担額証明書明細(被保険者番号, meisaiList));
        } else {
            manager.save事業高額合算自己負担額証明書(getHandler(div).get事業高額合算自己負担額証明書(被保険者番号, Decimal.ZERO));
            manager.save事業高額合算自己負担額証明書明細(getHandler(div).get事業高額合算自己負担額証明書明細(被保険者番号, Decimal.ZERO));
        }
    }

    private void delete(JikofutangakuShomeishoTorokuBusiness business) {
        JikofutangakuShomeishoTorokuManager manager = JikofutangakuShomeishoTorokuManager.createInstance();
        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = business.get事業高額合算自己負担額証明書情報();
        manager.delete事業高額合算自己負担額証明書(shomeisho);
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = business.get事業高額合算自己負担額証明書明細情報();
        manager.delete事業高額合算自己負担額証明書明細(meisaiList);
    }

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                被保険者番号.value());
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * Handlerを取得します。
     *
     * @param div div
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
