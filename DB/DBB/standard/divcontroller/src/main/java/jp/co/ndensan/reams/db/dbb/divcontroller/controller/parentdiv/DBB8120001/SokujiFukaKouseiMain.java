/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8120001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoFuka;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKoseiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKoseiResult;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.YokunenFukaKoseiResult;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHosokuMonth;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbInformationMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbWarningMessages;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajoho.FukaJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.DBB8120001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.DBB8120001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujikouseiKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8120001.SokujiFukaKouseiMainHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8120001.SokujiFukaKouseiMainValidationHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranparameter.IdoTaishoshaIchiranparameter;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.sokujikosei.SokujiFukaKoseiService;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fukakousei.SokujiFukaKouseiManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HonsanteiIkoHantei;
import jp.co.ndensan.reams.db.dbb.service.core.tokucho.TokuchoIraiJohoSakuseiJokyo;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM13001_2_即時賦課更正のクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiMain {

    private static final RString 保存する = new RString("SokujiFukaKouseibtn");
    private static final RString DBB_HIHOKENSHANO = new RString("DBBHihokenshaNo");
    private static final RString 翌年度の情報を表示する = new RString("翌年度の情報を表示する");
    private static final RString 前年度の情報を表示する = new RString("前年度の情報を表示する");
    private static final RString 個人番号_利用有無名称 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無名称 = new RString("法人番号 利用有無");
    private static final RString 業務固有の識別情報名称 = new RString("業務固有の識別情報");
    private static final RString 無し = new RString("無し");
    private static final RString 四月一日 = new RString("0401");
    private static final RString チェック済み = new RString("チェック済み");
    private static final RString メニューID_通知書発行後異動把握 = new RString("DBBMN32001");
    private static final RString メニューID_特徴仮算定賦課エラー一覧 = new RString("DBBMN33004");
    private static final RString メニューID_即時賦課更正 = new RString("DBBMN13001");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;

    /**
     * 画面の初期化メソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return 画面のResponseData
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onLoad(SokujiFukaKouseiMainDiv div) {
        setViewStateHolder();
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
        TsuchishoNo 通知書番号 = ViewStateHolder.get(ViewStateKeys.通知書番号, TsuchishoNo.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        TsuchishoNo 通知書番号選択 = 通知書番号;
        List<KoseiZengoFuka> 更正前後賦課のリスト = new ArrayList<>();
        KoseiZengoChoshuHoho 更正前後徴収方法 = null;
        NendobunFukaList 更正前賦課リスト = null;
        NendobunFukaList 更正後賦課リスト = null;
        boolean is本算定処理済フラグ;
        if (is特殊処理()) {
            NendobunFukaList 年度分賦課リスト = get年度分賦課リスト(賦課年度, 通知書番号);
            更正前賦課リスト = 年度分賦課リスト;
            更正後賦課リスト = 年度分賦課リスト;
            更正前後徴収方法 = get更正前後徴収方法(賦課年度, 被保険者番号);
            is本算定処理済フラグ = is本算定後(更正前賦課リスト);
        } else {
            SokujiFukaKoseiParameter parameter = new SokujiFukaKoseiParameter();
            parameter.set賦課年度(賦課年度);
            parameter.set被保険者番号(被保険者番号);
            parameter.set通知書番号(通知書番号);
            SokujiFukaKoseiService service = SokujiFukaKoseiService.createInstance();
            SokujiFukaKoseiResult reasult = service.do更正(parameter);
            更正前後賦課のリスト = reasult.get更正前後賦課のリスト();
            更正前後徴収方法 = reasult.get更正前後徴収方法();
            is本算定処理済フラグ = reasult.is本算定処理済フラグ();
            ViewStateHolder.put(ViewStateKeys.資格の情報リスト, (Serializable) reasult.get資格の情報());
            boolean is更正前と状態変更なし = is更正前と状態変更なし(更正前後賦課のリスト);
            if (is更正前と状態変更なし && !ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbbInformationMessages.更正前と状態変更なし.getMessage()).respond();
            }
            if (!is更正前と状態変更なし) {
                handler.set更正前後賦課のリスト降順(更正前後賦課のリスト);
                通知書番号選択 = 更正前後賦課のリスト.get(0).get通知書番号();
                更正前賦課リスト = 更正前後賦課のリスト.get(0).get更正前();
                更正後賦課リスト = 更正前後賦課のリスト.get(0).get更正後();
            } else {
                KoseiZengoFuka 更正前後賦課 = get更正前後賦課By通知書番号(更正前後賦課のリスト, 通知書番号);
                更正前賦課リスト = 更正前後賦課.get更正前();
                更正後賦課リスト = 更正前後賦課.get更正後();
                div.setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            }
        }
        handler.initializeヘッダエリア(is特殊処理(), 賦課年度, 更正前後賦課のリスト, 通知書番号選択, 更正前後徴収方法);
        handler.initialize更正前後データ(is特殊処理(), 更正前賦課リスト, 更正後賦課リスト, 更正前後徴収方法, is本算定処理済フラグ);
        ViewStateHolder.put(ViewStateKeys.更正前, 更正前賦課リスト);
        ViewStateHolder.put(ViewStateKeys.更正後, 更正後賦課リスト);
        ViewStateHolder.put(ViewStateKeys.更正前後徴収方法, 更正前後徴収方法);
        ViewStateHolder.put(ViewStateKeys.更正前後賦課のリスト, (Serializable) 更正前後賦課のリスト);
        ViewStateHolder.put(ViewStateKeys.本算定処理済フラグ, is本算定処理済フラグ);
        AccessLogger.log(AccessLogType.照会, PersonalData.withKojinNo(識別コード));
        LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        return getResponseData(div);
    }

    /**
     * 「保存」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_SokujiFukaKouseibtn(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        if (!ResponseHolder.isWarningIgnoredRequest()) {
            div.setIsHasWarningFlag(RString.EMPTY);
        }
        if (handler.is期別修正による特徴停止(is特殊処理()) && !ResponseHolder.isWarningIgnoredRequest()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbbWarningMessages.期別修正による特徴停止.getMessage()).respond();
            } else if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
                return getResponseData(div);
            }
        }
        KoseiZengoChoshuHoho 更正前後徴収方法 = ViewStateHolder.get(ViewStateKeys.更正前後徴収方法, KoseiZengoChoshuHoho.class);
        SokujiFukaKouseiMainValidationHandler validationHandler = getValidationHandler(div);
        ValidationMessageControlPairs valid = validationHandler.validate(更正前後徴収方法);
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        valid = validationHandler.validate普徴警告();
        if (valid.iterator().hasNext()) {
            if (!ResponseHolder.isWarningIgnoredRequest() || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        valid = validationHandler.validate特徴警告();
        if (valid.iterator().hasNext() && !チェック済み.equals(div.getIsHasWarningFlag())) {
            if (!ResponseHolder.isWarningIgnoredRequest()
                    || (ResponseHolder.getButtonType() == null && ResponseHolder.isWarningIgnoredRequest())
                    || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                div.setIsHasWarningFlag(チェック済み);
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        NendobunFukaList 更正前 = ViewStateHolder.get(ViewStateKeys.更正前, NendobunFukaList.class);
        NendobunFukaList 更正後 = ViewStateHolder.get(ViewStateKeys.更正後, NendobunFukaList.class);
        SokujiFukaKousei sokujiFukaKousei = handler.set保存処理(is特殊処理(), 更正前, 更正後, 更正前後徴収方法);
        if (sokujiFukaKousei.get賦課の情報リスト().isEmpty()) {
            throw new ApplicationException(DbbErrorMessages.賦課変更なしで保存不可.getMessage());
        }
        SokujiFukaKouseiManager manager = SokujiFukaKouseiManager.createInstance();
        manager.do即時賦課更正(sokujiFukaKousei);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        AccessLogger.log(AccessLogType.更新, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
        RealInitialLocker.release(前排他キー);
        return ResponseData.of(div).setState(DBB8120001StateName.完了);
    }

    /**
     * 「再検索」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnResearch(SokujiFukaKouseiMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
            RealInitialLocker.release(前排他キー);
            return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.再検索する).respond();
        }
        return getResponseData(div);
    }

    /**
     * 「検索結果一覧へ」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnToSearchResult(SokujiFukaKouseiMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return getResponseData(div);
        }
        if (is特殊処理()) {
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
            RealInitialLocker.release(前排他キー);
            if (ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class)) {
                return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.検索結果一覧に戻る).respond();
            } else {
                return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.再検索する).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.前画面に戻る).respond();
        }
    }

    /**
     * 「次の対象者を選ぶ」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnKouseiNext(SokujiFukaKouseiMainDiv div) {
        if (is特殊処理()) {
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
            RealInitialLocker.release(前排他キー);
            if (ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class)) {
                return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.検索結果一覧に戻る).respond();
            } else {
                return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.再検索する).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.前画面に戻る).respond();
        }
    }

    /**
     * 「通知書を作成する」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_Kobetsutsuchi(SokujiFukaKouseiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.通知書作成).respond();
    }

    /**
     * 通知書番号選択時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onChange_ddlKoseigoTsuchishoNo(SokujiFukaKouseiMainDiv div) {
        KoseiZengoChoshuHoho 更正前後徴収方法 = ViewStateHolder.get(ViewStateKeys.更正前後徴収方法, KoseiZengoChoshuHoho.class);
        List<KoseiZengoFuka> 更正前後賦課のリスト = ViewStateHolder.get(ViewStateKeys.更正前後賦課のリスト, List.class);
        NendobunFukaList 更正後 = ViewStateHolder.get(ViewStateKeys.更正後, NendobunFukaList.class);
        boolean is本算定処理済フラグ = ViewStateHolder.get(ViewStateKeys.本算定処理済フラグ, Boolean.class);
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        handler.set画面入力項目を反映(更正後);
        KoseiZengoFuka 更正前後賦課 = new KoseiZengoFuka();
        for (KoseiZengoFuka koseiZengoFuka : 更正前後賦課のリスト) {
            if (更正後.get通知書番号().getColumnValue().equals(koseiZengoFuka.get通知書番号().getColumnValue())) {
                更正前後賦課 = koseiZengoFuka;
                更正前後賦課のリスト.remove(koseiZengoFuka);
                break;
            }
        }
        更正前後賦課.set更正後(更正後);
        更正前後賦課のリスト.add(更正前後賦課);
        ViewStateHolder.put(ViewStateKeys.更正前後賦課のリスト, (Serializable) 更正前後賦課のリスト);
        TsuchishoNo 通知書番号 = new TsuchishoNo(div.getDdlKoseigoTsuchishoNo().getSelectedKey());
        KoseiZengoFuka koseiZengoFuka = get更正前後賦課By通知書番号(更正前後賦課のリスト, 通知書番号);
        handler.initialize更正前後データ(is特殊処理(), koseiZengoFuka.get更正前(), koseiZengoFuka.get更正後(),
                更正前後徴収方法, is本算定処理済フラグ);
        ViewStateHolder.put(ViewStateKeys.更正前, koseiZengoFuka.get更正前());
        ViewStateHolder.put(ViewStateKeys.更正後, koseiZengoFuka.get更正後());
        return getResponseData(div);
    }

    /**
     * 「特徴徴収」エリア6月更正後のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo06(SokujiFukaKouseiMainDiv div) {
        Decimal 特別徴収_6月 = div.getSokujikouseiKiwarigaku().getTxtTokuchoKoseiGo06().getValue();
        div.getSokujikouseiKiwarigaku().getTxtTokuchoKoseiGo08().setValue(特別徴収_6月);
        return getResponseData(div);
    }

    /**
     * 「特徴徴収」エリア12月更正後のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo12(SokujiFukaKouseiMainDiv div) {
        Decimal 特別徴収_12月 = div.getSokujikouseiKiwarigaku().getTxtTokuchoKoseiGo12().getValue();
        div.getSokujikouseiKiwarigaku().getTxtTokuchoKoseiGo02().setValue(特別徴収_12月);
        return getResponseData(div);
    }

    /**
     * 「減免額を反映する」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnApplyGemmenGaku(SokujiFukaKouseiMainDiv div) {
        List<KoseiZengoFuka> 更正前後賦課のリスト = ViewStateHolder.get(ViewStateKeys.更正前後賦課のリスト, List.class);
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
        TsuchishoNo 通知書番号 = ViewStateHolder.get(ViewStateKeys.通知書番号, TsuchishoNo.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        KoseiZengoChoshuHoho 更正前後徴収方法 = ViewStateHolder.get(ViewStateKeys.更正前後徴収方法, KoseiZengoChoshuHoho.class);
        NendobunFukaList 更正後 = ViewStateHolder.get(ViewStateKeys.更正後, NendobunFukaList.class);
        boolean is本算定処理済フラグ = ViewStateHolder.get(ViewStateKeys.本算定処理済フラグ, Boolean.class);
        List<HihokenshaDaicho> 資格の情報リスト = ViewStateHolder.get(ViewStateKeys.資格の情報リスト, List.class);
        SokujiFukaKoseiParameter parameter = new SokujiFukaKoseiParameter();
        parameter.set賦課年度(賦課年度);
        parameter.set被保険者番号(被保険者番号);
        parameter.set通知書番号(通知書番号);
        parameter.set更正後減免額(div.getGemmenGakuInput().getTxtGemmenGakuInput().getValue());
        parameter.set更正後徴収方法(更正前後徴収方法.get更正後());
        if (更正前後賦課のリスト != null) {
            HihokenshaDaicho 資格の情報 = null;
            if (!is特殊処理()) {
                KoseiZengoFuka 更正前後賦課 = get更正前後賦課By通知書番号(更正前後賦課のリスト, 通知書番号);
                更正後 = 更正前後賦課.get更正後();
                資格の情報 = get資格の情報(資格の情報リスト, 賦課年度, 更正前後賦課);
            }
            if (更正後 != null) {
                parameter.set更正後年度分賦課リスト(更正後);
            }
            if (資格の情報 != null) {
                parameter.set資格の情報(資格の情報);
            }
        }
        SokujiFukaKoseiService service = SokujiFukaKoseiService.createInstance();
        SokujiFukaKoseiResult reasult = service.do更正(parameter);
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        更正前後賦課のリスト = reasult.get更正前後賦課のリスト();
        KoseiZengoFuka 更正前後賦課 = get更正前後賦課By通知書番号(更正前後賦課のリスト, 通知書番号);
        handler.initialize更正前後データ(is特殊処理(), 更正前後賦課.get更正前(), 更正前後賦課.get更正後(),
                更正前後徴収方法, is本算定処理済フラグ);
        return getResponseData(div);
    }

    /**
     * 「翌年度の情報を表示する」或は「前年度の情報を表示する」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnYokunendoHyoji(SokujiFukaKouseiMainDiv div) {
        NendobunFukaList 更正後 = ViewStateHolder.get(ViewStateKeys.更正後, NendobunFukaList.class);
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        boolean isChange = handler.set画面入力項目を反映(更正後);
        if (isChange) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzQuestionMessages.変更未保存の確認.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
                return getResponseData(div);
            }
        }
        if (翌年度の情報を表示する.equals(div.getBtnYokunendoHyoji().getText())) {
            div.getBtnYokunendoHyoji().setText(前年度の情報を表示する);
            FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
            HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
            TsuchishoNo 通知書番号 = ViewStateHolder.get(ViewStateKeys.通知書番号, TsuchishoNo.class);
            boolean is本算定処理済フラグ = ViewStateHolder.get(ViewStateKeys.本算定処理済フラグ, Boolean.class);
            SokujiFukaKoseiService service = SokujiFukaKoseiService.createInstance();
            YokunenFukaKoseiResult result = service.do翌年度更正(賦課年度.plusYear(INT_1), 被保険者番号);
            List<KoseiZengoFuka> 更正前後賦課のリスト = result.get更正前後賦課のリスト();
            KoseiZengoFuka 更正前後賦課 = get更正前後賦課By通知書番号(更正前後賦課のリスト, 通知書番号);
            handler.initialize更正前後データ(is特殊処理(), 更正前後賦課.get更正前(), 更正前後賦課.get更正後(),
                    result.get更正前後徴収方法(), is本算定処理済フラグ);
            handler.set画面項目入力不可();
            if (!is特徴異動情報作成が処理済み()) {
                SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
                tablePanel.getTxtTokuchoKoseiGo04().setReadOnly(false);
            }
        } else if (前年度の情報を表示する.equals(div.getBtnYokunendoHyoji().getText())) {
            div.getBtnYokunendoHyoji().setText(翌年度の情報を表示する);
            onLoad(div);
        }
        return getResponseData(div);
    }

    private SokujiFukaKouseiMainHandler getHandler(SokujiFukaKouseiMainDiv div) {
        return new SokujiFukaKouseiMainHandler(div);
    }

    private SokujiFukaKouseiMainValidationHandler getValidationHandler(SokujiFukaKouseiMainDiv div) {
        return new SokujiFukaKouseiMainValidationHandler(div);
    }

    private HihokenshaDaicho get資格の情報(List<HihokenshaDaicho> 資格の情報リスト, FlexibleYear 賦課年度, KoseiZengoFuka 更正前後賦課) {
        if (資格の情報リスト == null || 資格の情報リスト.isEmpty()) {
            return null;
        }
        for (HihokenshaDaicho hihokenshaDaicho : 資格の情報リスト) {
            FlexibleDate 第1号資格取得年月日 = hihokenshaDaicho.get第1号資格取得年月日();
            if (第1号資格取得年月日.isBeforeOrEquals(new FlexibleDate(賦課年度.toDateString().concat(四月一日)))) {
                第1号資格取得年月日 = new FlexibleDate(賦課年度.toDateString().concat(四月一日));
            }
            if (第1号資格取得年月日.equals(更正前後賦課.get更正後().get賦課期日())) {
                return hihokenshaDaicho;
            }
        }
        return null;
    }

    private boolean is特徴異動情報作成が処理済み() {
        TokuchoIraiJohoSakuseiJokyo tokuchoIraiJohoSakuseiJokyo = new TokuchoIraiJohoSakuseiJokyo();
        List<ShoriDateKanri> 処理状況リスト = tokuchoIraiJohoSakuseiJokyo.find処理状況Of(TokuchoHosokuMonth.特徴10月捕捉.getコード());
        for (ShoriDateKanri shoriDateKanri : 処理状況リスト) {
            if (shoriDateKanri.get基準日時() != null && !shoriDateKanri.get基準日時().isEmpty()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private NendobunFukaList get年度分賦課リスト(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        FukaJohoRelateMapperParameter param = FukaJohoRelateMapperParameter.createSelectListParam(FlexibleYear.EMPTY,
                賦課年度, 通知書番号);
        FukaJohoManager manager = FukaJohoManager.createInstance();
        List<FukaJoho> 賦課の情報リスト = manager.get履歴番号最大の賦課の情報(param);
        NendobunFukaList 年度分賦課リスト = new NendobunFukaList();
        年度分賦課リスト.set賦課年度(賦課年度);
        年度分賦課リスト.set通知書番号(通知書番号);
        FukaJoho 最新賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度);
        FukaJoho 過年度1賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(INT_1));
        FukaJoho 過年度2賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(INT_2));
        FukaJoho 過年度3賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(INT_3));
        FukaJoho 過年度4賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(INT_4));
        FukaJoho 過年度5賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(INT_5));
        boolean has過年度賦課 = Boolean.FALSE;
        年度分賦課リスト.set現年度(最新賦課の情報);
        年度分賦課リスト.set賦課期日(最新賦課の情報.get賦課期日());
        if (過年度1賦課の情報 != null) {
            年度分賦課リスト.set過年度1(過年度1賦課の情報);
            最新賦課の情報 = 過年度1賦課の情報;
            has過年度賦課 = Boolean.TRUE;
        }
        if (過年度2賦課の情報 != null) {
            年度分賦課リスト.set過年度2(過年度2賦課の情報);
            最新賦課の情報 = 過年度2賦課の情報;
            has過年度賦課 = Boolean.TRUE;
        }
        if (過年度3賦課の情報 != null) {
            年度分賦課リスト.set過年度3(過年度3賦課の情報);
            最新賦課の情報 = 過年度3賦課の情報;
            has過年度賦課 = Boolean.TRUE;
        }
        if (過年度4賦課の情報 != null) {
            年度分賦課リスト.set過年度4(過年度4賦課の情報);
            最新賦課の情報 = 過年度4賦課の情報;
            has過年度賦課 = Boolean.TRUE;
        }
        if (過年度5賦課の情報 != null) {
            年度分賦課リスト.set過年度1(過年度5賦課の情報);
            最新賦課の情報 = 過年度5賦課の情報;
            has過年度賦課 = Boolean.TRUE;
        }
        年度分賦課リスト.setHas過年度賦課(has過年度賦課);
        年度分賦課リスト.set最新賦課の情報(最新賦課の情報);
        return 年度分賦課リスト;
    }

    private KoseiZengoChoshuHoho get更正前後徴収方法(FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        ChoshuHohoManager manager = new ChoshuHohoManager();
        ChoshuHoho 徴収方法 = manager.get介護徴収方法(賦課年度, 被保険者番号);
        KoseiZengoChoshuHoho 更正前後徴収方法 = new KoseiZengoChoshuHoho();
        更正前後徴収方法.set賦課年度(賦課年度);
        更正前後徴収方法.set被保険者番号(被保険者番号);
        更正前後徴収方法.set更正前(徴収方法);
        更正前後徴収方法.set更正後(徴収方法);
        更正前後徴収方法.setHasChanged(Boolean.FALSE);
        return 更正前後徴収方法;
    }

    private FukaJoho get賦課の情報By調定年度(List<FukaJoho> 賦課の情報リスト, FlexibleYear 調定年度) {
        for (FukaJoho fukaJoho : 賦課の情報リスト) {
            if (調定年度.compareTo(fukaJoho.get調定年度()) == 0) {
                return fukaJoho;
            }
        }
        return null;
    }

    private boolean is特殊処理() {
        return メニューID_即時賦課更正.equals(ResponseHolder.getMenuID());
    }

    private boolean is更正前と状態変更なし(List<KoseiZengoFuka> 更正前後賦課のリスト) {
        for (KoseiZengoFuka koseiZengoFuka : 更正前後賦課のリスト) {
            if (koseiZengoFuka.isHasChanged()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private KoseiZengoFuka get更正前後賦課By通知書番号(List<KoseiZengoFuka> 更正前後賦課のリスト, TsuchishoNo 通知書番号) {
        for (KoseiZengoFuka koseiZengoFuka : 更正前後賦課のリスト) {
            if (通知書番号.getColumnValue().equals(koseiZengoFuka.get通知書番号().getColumnValue())) {
                return koseiZengoFuka;
            }
        }
        return null;
    }

    private void setViewStateHolder() {
        FlexibleYear 賦課年度 = null;
        TsuchishoNo 通知書番号 = null;
        HihokenshaNo 被保険者番号 = null;
        ShikibetsuCode 識別コード = null;
        RString メニューID = ResponseHolder.getMenuID();
        if (メニューID_通知書発行後異動把握.equals(メニューID)) {
            IdoTaishoshaIchiranparameter 異動者一覧Par = ViewStateHolder.get(ViewStateKeys.異動者一覧Par, IdoTaishoshaIchiranparameter.class);
            賦課年度 = 異動者一覧Par.getFukaNendo();
            通知書番号 = 異動者一覧Par.getTsuchishoNo();
            被保険者番号 = 異動者一覧Par.getHihokenshaNo();
            識別コード = 異動者一覧Par.getShikibetsuCode();
        } else if (メニューID_特徴仮算定賦課エラー一覧.equals(メニューID)) {
            FukaErrorList 賦課エラー情報 = ViewStateHolder.get(ViewStateKeys.賦課エラー情報, FukaErrorList.class);
            賦課年度 = 賦課エラー情報.get賦課年度();
            通知書番号 = 賦課エラー情報.get通知書番号();
            被保険者番号 = 賦課エラー情報.get被保険者番号();
            識別コード = 賦課エラー情報.get識別コード();
        } else if (メニューID_即時賦課更正.equals(メニューID)) {
            FukaTaishoshaKey 賦課対象者 = ViewStateHolder.get(ViewStateKeys.賦課対象者, FukaTaishoshaKey.class);
            賦課年度 = 賦課対象者.get賦課年度();
            通知書番号 = 賦課対象者.get通知書番号();
            被保険者番号 = 賦課対象者.get被保険者番号();
            識別コード = 賦課対象者.get識別コード();
        }
        ViewStateHolder.put(ViewStateKeys.賦課年度, 賦課年度);
        ViewStateHolder.put(ViewStateKeys.通知書番号, 通知書番号);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
    }

    private ResponseData<SokujiFukaKouseiMainDiv> getResponseData(SokujiFukaKouseiMainDiv div) {
        if (is特殊処理()) {
            return ResponseData.of(div).setState(DBB8120001StateName.即時賦課更正);
        } else {
            return ResponseData.of(div).setState(DBB8120001StateName.即時賦課更正_対象者検索以外);
        }
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code("0001"), 個人番号_利用有無名称, 無し);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code("0002"), 法人番号_利用有無名称, 無し);
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code("0003"), 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2, expandedInfo3);
    }

    private boolean is本算定後(NendobunFukaList 更正前賦課リスト) {
        HonsanteiIkoHantei honsanteiIkoHantei = HonsanteiIkoHantei.createInstance();
        return honsanteiIkoHantei.is本算定後(更正前賦課リスト.get最新賦課の情報());
    }
}
