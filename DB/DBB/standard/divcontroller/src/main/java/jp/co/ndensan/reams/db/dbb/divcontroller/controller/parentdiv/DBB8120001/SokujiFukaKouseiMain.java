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
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKoseiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKoseiResult;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.SokujiFukaKousei;
import jp.co.ndensan.reams.db.dbb.business.core.sokujikosei.YokunenFukaKoseiResult;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
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
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8120001.SokujiFukaKouseiSaveHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.viewbox.idotaishoshaichiranparameter.IdoTaishoshaIchiranparameter;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.sokujikosei.SokujiFukaKoseiService;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fukakousei.SokujiFukaKouseiManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HonsanteiIkoHantei;
import jp.co.ndensan.reams.db.dbb.service.core.tokucho.TokuchoIraiJohoSakuseiJokyo;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
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
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

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
    private static final RString 業務固有の識別情報名称 = new RString("業務固有の識別情報");
    private static final RString 四月一日 = new RString("0401");
    private static final RString チェック済み_特徴警告 = new RString("チェック済み_特徴警告");
    private static final RString チェック済み_普徴警告 = new RString("チェック済み_普徴警告");
    private static final RString メニューID_通知書発行後異動把握 = new RString("DBBMN32001");
    private static final RString メニューID_特徴仮算定賦課エラー一覧 = new RString("DBBMN33004");
    private static final RString メニューID_即時賦課更正 = new RString("DBBMN13001");
    private static final RString メニューID_特殊処理 = new RString("DBBMNC3001");
    private static final Code CODE_003 = new Code("0003");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_13 = 13;
    private static final int NUM_14 = 14;
    private static final RString FLAG_CHANGE = new RString("1");
    private static final RString TEXT_期 = new RString("期");
    private static final RString 調定事由コード_更正 = new RString("04");
    private static final RString 戻るフラグ = new RString("ViaSokujiKosei");
    private static final RString ZERO = new RString("0");
    private static final RString 読点 = new RString(",");

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
        LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
        if (!RealInitialLocker.tryGetLock(前排他キー) && !ResponseHolder.isReRequest()) {
            throw new PessimisticLockingException();
        }
        List<KoseiZengoFuka> 更正前後賦課のリスト = new ArrayList<>();
        KoseiZengoChoshuHoho 更正前後徴収方法 = null;
        NendobunFukaList 更正前賦課リスト = null;
        NendobunFukaList 更正後賦課リスト = null;
        TsuchishoNo 通知書番号選択 = 通知書番号;
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
            handler.set更正前後賦課のリスト降順(更正前後賦課のリスト);
            KoseiZengoFuka 更正前後賦課 = get更正前後賦課By通知書番号(更正前後賦課のリスト, 通知書番号);
            if (!is更正前と状態変更なし && !更正前後賦課のリスト.isEmpty()) {
                更正前賦課リスト = 更正前後賦課のリスト.get(0).get更正前();
                更正後賦課リスト = 更正前後賦課のリスト.get(0).get更正後();
                通知書番号選択 = 更正後賦課リスト.get通知書番号();
            } else if (is更正前と状態変更なし && 更正前後賦課 != null) {
                更正前賦課リスト = 更正前後賦課.get更正前();
                更正後賦課リスト = 更正前後賦課.get更正後();
                div.setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, true);
            } else {
                更正前賦課リスト = new NendobunFukaList();
                更正後賦課リスト = new NendobunFukaList();
            }
        }
        handler.initializeヘッダエリア(is特殊処理(), 賦課年度, 更正前後賦課のリスト, 通知書番号選択, 更正前後徴収方法);
        handler.initialize更正前後データ(is特殊処理(), 更正前賦課リスト, 更正後賦課リスト, 更正前後徴収方法, is本算定処理済フラグ);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, is年間保険料額変更あり(div));
        ViewStateHolder.put(ViewStateKeys.更正前, 更正前賦課リスト);
        ViewStateHolder.put(ViewStateKeys.更正後, 更正後賦課リスト);
        ViewStateHolder.put(ViewStateKeys.更正前後徴収方法, 更正前後徴収方法);
        ViewStateHolder.put(ViewStateKeys.更正前後賦課のリスト, (Serializable) 更正前後賦課のリスト);
        ViewStateHolder.put(ViewStateKeys.本算定処理済フラグ, is本算定処理済フラグ);
        AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード));
        return getResponseData(div);
    }

    /**
     * 「保存」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_SokujiFukaKouseibtn(SokujiFukaKouseiMainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return getResponseData(div);
        }
        boolean is保存の確認 = UrQuestionMessages.保存の確認.getMessage().getCode().
                equals(ResponseHolder.getMessageCode().toString()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes;
        boolean is期別特徴停止の確認 = DbbWarningMessages.期別修正による特徴停止.getMessage().getCode().
                equals(ResponseHolder.getMessageCode().toString()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes;
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        if (!ResponseHolder.isWarningIgnoredRequest()) {
            div.setIsHasWarningFlag(RString.EMPTY);
        }
        if (handler.is期別修正による特徴停止(is特殊処理())
                && !ResponseHolder.isWarningIgnoredRequest()
                && (!ResponseHolder.isReRequest() || is保存の確認)) {
            return ResponseData.of(div).addMessage(DbbWarningMessages.期別修正による特徴停止.getMessage()).respond();
        }
        KoseiZengoChoshuHoho 更正前後徴収方法 = ViewStateHolder.get(ViewStateKeys.更正前後徴収方法, KoseiZengoChoshuHoho.class);
        SokujiFukaKouseiMainValidationHandler validationHandler = getValidationHandler(div);
        ValidationMessageControlPairs valid = validationHandler.validate(更正前後徴収方法);
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        ResponseData<SokujiFukaKouseiMainDiv> responseData = getValidate特徴警告(valid, validationHandler, div,
                is保存の確認, is期別特徴停止の確認);
        if (responseData != null) {
            return responseData;
        }
        responseData = getValidate普徴警告(valid, validationHandler, div,
                is保存の確認, is期別特徴停止の確認);
        if (responseData != null) {
            return responseData;
        }
        NendobunFukaList 更正前 = ViewStateHolder.get(ViewStateKeys.更正前, NendobunFukaList.class);
        NendobunFukaList 更正後 = ViewStateHolder.get(ViewStateKeys.更正後, NendobunFukaList.class);
        set画面入力項目を反映(div, 更正後);
        SokujiFukaKousei sokujiFukaKousei = getSaveHandler().set保存処理(is特殊処理(), 更正前, 更正後, 更正前後徴収方法);
        if (sokujiFukaKousei.get賦課の情報リスト().isEmpty()) {
            throw new ApplicationException(DbbErrorMessages.賦課変更なしで保存不可.getMessage());
        }
        SokujiFukaKouseiManager manager = SokujiFukaKouseiManager.createInstance();
        manager.do即時賦課更正(sokujiFukaKousei);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        AccessLogger.log(AccessLogType.更新, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        get前排他Release();
        return ResponseData.of(div).setState(DBB8120001StateName.完了);
    }

    /**
     * 「再検索」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnResearch(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        boolean is入力があれ = handler.is入力があれ();
        if (!ResponseHolder.isReRequest() && is入力があれ) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (!is入力があれ || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            get前排他Release();
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
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        boolean is入力があれ = handler.is入力があれ();
        if (!ResponseHolder.isReRequest() && is入力があれ) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (!is入力があれ || ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            get前排他Release();
            return toSearchResultResponseData(div);
        }
        return getResponseData(div);
    }

    /**
     * 「次の対象者を選ぶ」ボタン押下時のイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onClick_btnKouseiNext(SokujiFukaKouseiMainDiv div) {
        if (is賦課対象者一覧()) {
            return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.再検索する).respond();
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
        ViewStateHolder.put(ViewStateKeys.各種通知書作成戻るフラグ, 戻るフラグ);
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
        set画面入力項目を反映(div, 更正後);
        KoseiZengoFuka 更正前後賦課 = new KoseiZengoFuka();
        for (KoseiZengoFuka koseiZengoFuka : 更正前後賦課のリスト) {
            if (更正後.get通知書番号().getColumnValue().equals(koseiZengoFuka.get更正後().get通知書番号().getColumnValue())) {
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
        if (handler.is入力があれ()) {
            div.setIsDataChange(FLAG_CHANGE);
        }
        handler.initialize更正前後データ(is特殊処理(), koseiZengoFuka.get更正前(), koseiZengoFuka.get更正後(),
                更正前後徴収方法, is本算定処理済フラグ);
        ViewStateHolder.put(ViewStateKeys.更正前, koseiZengoFuka.get更正前());
        ViewStateHolder.put(ViewStateKeys.更正後, koseiZengoFuka.get更正後());
        return getResponseData(div);
    }

    /**
     * 「特徴徴収」エリア4月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo04(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblTokuchoZogenValue04().setText(get金額のカンマ編集(
                (tablePanel.getTxtTokuchoKoseiGo04().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtTokuchoKoseiGo04().getValue()).subtract(
                        getFormat金額(tablePanel.getLblTokuchoKoseiMaeValue04().getText()))));
        tablePanel.getLblTokuchoKoseiGoSum().setText(handler.get特別徴収の更正後合計());
        tablePanel.getLblTokuchoZogenSum().setText(handler.get特別徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「特徴徴収」エリア6月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo06(SokujiFukaKouseiMainDiv div) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 特別徴収_6月 = tablePanel.getTxtTokuchoKoseiGo06().getValue();
        tablePanel.getTxtTokuchoKoseiGo08().setValue(特別徴収_6月);
        tablePanel.getLblTokuchoZogenValue06().setText(get金額のカンマ編集(
                (tablePanel.getTxtTokuchoKoseiGo06().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtTokuchoKoseiGo06().getValue()).subtract(
                        getFormat金額(tablePanel.getLblTokuchoKoseiMaeValue06().getText()))));
        return onBlur_txtTokuchoKoseiGo08(div);
    }

    /**
     * 「特徴徴収」エリア8月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo08(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblTokuchoZogenValue08().setText(get金額のカンマ編集(
                (tablePanel.getTxtTokuchoKoseiGo08().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtTokuchoKoseiGo08().getValue()).subtract(
                        getFormat金額(tablePanel.getLblTokuchoKoseiMaeValue08().getText()))));
        tablePanel.getLblTokuchoKoseiGoSum().setText(handler.get特別徴収の更正後合計());
        tablePanel.getLblTokuchoZogenSum().setText(handler.get特別徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「特徴徴収」エリア10月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo10(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblTokuchoZogenValue10().setText(get金額のカンマ編集(
                (tablePanel.getTxtTokuchoKoseiGo10().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtTokuchoKoseiGo10().getValue()).subtract(
                        getFormat金額(tablePanel.getLblTokuchoKoseiMaeValue10().getText()))));
        tablePanel.getLblTokuchoKoseiGoSum().setText(handler.get特別徴収の更正後合計());
        tablePanel.getLblTokuchoZogenSum().setText(handler.get特別徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「特徴徴収」エリア12月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo12(SokujiFukaKouseiMainDiv div) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 特別徴収_12月 = tablePanel.getTxtTokuchoKoseiGo12().getValue();
        tablePanel.getTxtTokuchoKoseiGo02().setValue(特別徴収_12月);
        tablePanel.getLblTokuchoZogenValue12().setText(get金額のカンマ編集(
                (tablePanel.getTxtTokuchoKoseiGo12().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtTokuchoKoseiGo12().getValue()).subtract(
                        getFormat金額(tablePanel.getLblTokuchoKoseiMaeValue12().getText()))));
        return onBlur_txtTokuchoKoseiGo02(div);
    }

    /**
     * 「特徴徴収」エリア2月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtTokuchoKoseiGo02(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblTokuchoZogenValue02().setText(get金額のカンマ編集(
                (tablePanel.getTxtTokuchoKoseiGo02().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtTokuchoKoseiGo02().getValue()).subtract(
                        getFormat金額(tablePanel.getLblTokuchoKoseiMaeValue02().getText()))));
        tablePanel.getLblTokuchoKoseiGoSum().setText(handler.get特別徴収の更正後合計());
        tablePanel.getLblTokuchoZogenSum().setText(handler.get特別徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア4月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo04(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue04().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo04().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo04().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue04().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア5月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo05(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue05().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo05().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo05().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue05().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア6月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo06(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue06().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo06().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo06().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue06().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア7月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo07(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue07().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo07().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo07().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue07().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア8月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo08(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue08().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo08().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo08().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue08().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア9月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo09(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue09().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo09().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo09().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue09().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア10月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo10(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue10().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo10().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo10().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue10().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア11月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo11(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue11().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo11().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo11().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue11().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア12月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo12(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue12().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo12().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo12().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue12().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア1月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo01(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue01().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo01().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo01().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue01().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア2月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo02(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue02().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo02().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo02().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue02().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア3月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGo03(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValue03().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGo03().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGo03().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValue03().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア翌年度4月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGoYoku04(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValueYoku04().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGoYoku04().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGoYoku04().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValueYoku04().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
        return getResponseData(div);
    }

    /**
     * 「普通徴収」エリア翌年度5月更正後のtextBoxのonblurでイベントメソッドです。
     *
     * @param div SokujiFukaKouseiMainDiv
     * @return ResponseData<SokujiFukaKouseiMainDiv>
     */
    public ResponseData<SokujiFukaKouseiMainDiv> onBlur_txtFuchoKoseiGoYoku05(SokujiFukaKouseiMainDiv div) {
        SokujiFukaKouseiMainHandler handler = getHandler(div);
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getLblFuchoZogenValueYoku05().setText(get金額のカンマ編集(
                (tablePanel.getTxtFuchoKoseiGoYoku05().getValue() == null ? Decimal.ZERO
                        : tablePanel.getTxtFuchoKoseiGoYoku05().getValue()).subtract(
                        getFormat金額(tablePanel.getLblFuchoKoseiMaeValueYoku05().getText()))));
        tablePanel.getLblFuchoKoseiGoSum().setText(handler.get普通徴収の更正後合計());
        tablePanel.getLblFuchoZogenSum().setText(handler.get普通徴収の増減合計());
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
        if (前年度の情報を表示する.equals(div.getBtnYokunendoHyoji().getText())) {
            賦課年度 = 賦課年度.plusYear(NUM_1);
        }
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
        boolean isChange = set画面入力項目を反映(div, 更正後);
        if (isChange) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzQuestionMessages.変更未保存の確認.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
                return getResponseData(div);
            }
        }
        FlexibleYear 賦課年度 = ViewStateHolder.get(ViewStateKeys.賦課年度, FlexibleYear.class);
        TsuchishoNo 通知書番号 = ViewStateHolder.get(ViewStateKeys.通知書番号, TsuchishoNo.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        List<KoseiZengoFuka> 更正前後賦課のリスト;
        KoseiZengoChoshuHoho 更正前後徴収方法 = null;
        NendobunFukaList 更正前賦課リスト = null;
        NendobunFukaList 更正後賦課リスト = null;
        boolean is本算定処理済フラグ;
        if (翌年度の情報を表示する.equals(div.getBtnYokunendoHyoji().getText())) {
            div.getBtnYokunendoHyoji().setText(前年度の情報を表示する);
            is本算定処理済フラグ = ViewStateHolder.get(ViewStateKeys.本算定処理済フラグ, Boolean.class);
            SokujiFukaKoseiService service = SokujiFukaKoseiService.createInstance();
            賦課年度 = 賦課年度.plusYear(NUM_1);
            YokunenFukaKoseiResult result = service.do翌年度更正(賦課年度, 被保険者番号);
            更正前後賦課のリスト = result.get更正前後賦課のリスト();
            handler.set更正前後賦課のリスト降順(更正前後賦課のリスト);
            KoseiZengoFuka 更正前後賦課 = 更正前後賦課のリスト.get(0);
            更正前賦課リスト = 更正前後賦課.get更正前();
            更正後賦課リスト = 更正前後賦課.get更正後();
            更正前後徴収方法 = result.get更正前後徴収方法();
            handler.initializeヘッダエリア(is特殊処理(), 賦課年度, 更正前後賦課のリスト,
                    更正後賦課リスト.get通知書番号(), 更正前後徴収方法);
            handler.initialize更正前後データ(is特殊処理(), 更正前賦課リスト, 更正後賦課リスト,
                    更正前後徴収方法, is本算定処理済フラグ);
            set画面項目入力不可(div);
            if (!is特徴異動情報作成が処理済み()) {
                SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
                tablePanel.getTxtTokuchoKoseiGo04().setReadOnly(false);
            }
        } else {
            div.getBtnYokunendoHyoji().setText(翌年度の情報を表示する);
            setViewStateHolder();
            SokujiFukaKoseiParameter parameter = new SokujiFukaKoseiParameter();
            parameter.set賦課年度(賦課年度);
            parameter.set被保険者番号(被保険者番号);
            parameter.set通知書番号(通知書番号);
            SokujiFukaKoseiService service = SokujiFukaKoseiService.createInstance();
            SokujiFukaKoseiResult reasult = service.do更正(parameter);
            更正前後賦課のリスト = reasult.get更正前後賦課のリスト();
            更正前後徴収方法 = reasult.get更正前後徴収方法();
            is本算定処理済フラグ = reasult.is本算定処理済フラグ();
            handler.set更正前後賦課のリスト降順(更正前後賦課のリスト);
            更正前賦課リスト = 更正前後賦課のリスト.get(0).get更正前();
            更正後賦課リスト = 更正前後賦課のリスト.get(0).get更正後();
            TsuchishoNo 通知書番号選択 = 更正後賦課リスト.get通知書番号();
            handler.initializeヘッダエリア(is特殊処理(), 賦課年度, 更正前後賦課のリスト, 通知書番号選択, 更正前後徴収方法);
            handler.initialize更正前後データ(is特殊処理(), 更正前賦課リスト, 更正後賦課リスト, 更正前後徴収方法, is本算定処理済フラグ);
        }
        ViewStateHolder.put(ViewStateKeys.更正前, 更正前賦課リスト);
        ViewStateHolder.put(ViewStateKeys.更正後, 更正後賦課リスト);
        ViewStateHolder.put(ViewStateKeys.更正前後徴収方法, 更正前後徴収方法);
        ViewStateHolder.put(ViewStateKeys.更正前後賦課のリスト, (Serializable) 更正前後賦課のリスト);
        ViewStateHolder.put(ViewStateKeys.本算定処理済フラグ, is本算定処理済フラグ);
        return getResponseData(div);
    }

    private SokujiFukaKouseiMainHandler getHandler(SokujiFukaKouseiMainDiv div) {
        return new SokujiFukaKouseiMainHandler(div);
    }

    private SokujiFukaKouseiSaveHandler getSaveHandler() {
        return new SokujiFukaKouseiSaveHandler();
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
            if (第1号資格取得年月日 == null || 第1号資格取得年月日.isEmpty()) {
                continue;
            }
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
        FukaJoho 過年度1賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(NUM_1));
        FukaJoho 過年度2賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(NUM_2));
        FukaJoho 過年度3賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(NUM_3));
        FukaJoho 過年度4賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(NUM_4));
        FukaJoho 過年度5賦課の情報 = get賦課の情報By調定年度(賦課の情報リスト, 賦課年度.plusYear(NUM_5));
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
            年度分賦課リスト.set過年度5(過年度5賦課の情報);
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
        return メニューID_特殊処理.equals(ResponseHolder.getMenuID());
    }

    private boolean is賦課対象者一覧() {
        return メニューID_即時賦課更正.equals(ResponseHolder.getMenuID())
                || メニューID_特殊処理.equals(ResponseHolder.getMenuID());
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
            if (通知書番号.getColumnValue().equals(koseiZengoFuka.get更正後().get通知書番号().getColumnValue())) {
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
        } else if (メニューID_即時賦課更正.equals(メニューID)
                || メニューID_特殊処理.equals(メニューID)) {
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
        if (is賦課対象者一覧()) {
            return ResponseData.of(div).setState(DBB8120001StateName.即時賦課更正);
        } else {
            return ResponseData.of(div).setState(DBB8120001StateName.即時賦課更正_対象者検索以外);
        }
    }

    private ResponseData<SokujiFukaKouseiMainDiv> toSearchResultResponseData(SokujiFukaKouseiMainDiv div) {
        if (is賦課対象者一覧()) {
            if (ViewStateHolder.get(ViewStateKeys.is経由該当者一覧画面, Boolean.class)) {
                return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.検索結果一覧に戻る).respond();
            } else {
                return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.再検索する).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBB8120001TransitionEventName.前画面に戻る).respond();
        }
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE_003, 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    private boolean is本算定後(NendobunFukaList 更正前賦課リスト) {
        HonsanteiIkoHantei honsanteiIkoHantei = HonsanteiIkoHantei.createInstance();
        return honsanteiIkoHantei.is本算定後(更正前賦課リスト.get最新賦課の情報());
    }

    private ResponseData<SokujiFukaKouseiMainDiv> getValidate特徴警告(
            ValidationMessageControlPairs valid,
            SokujiFukaKouseiMainValidationHandler validationHandler,
            SokujiFukaKouseiMainDiv div,
            boolean is保存の確認,
            boolean is期別特徴停止の確認) {
        valid = validationHandler.validate特徴警告();
        if (valid.iterator().hasNext()
                && !チェック済み_特徴警告.equals(div.getIsHasWarningFlag())
                && !チェック済み_普徴警告.equals(div.getIsHasWarningFlag())
                && (!ResponseHolder.isWarningIgnoredRequest()
                || (ResponseHolder.getButtonType() == null && ResponseHolder.isWarningIgnoredRequest())
                || is保存の確認
                || is期別特徴停止の確認)) {
            div.setIsHasWarningFlag(チェック済み_特徴警告);
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        return null;
    }

    private ResponseData<SokujiFukaKouseiMainDiv> getValidate普徴警告(
            ValidationMessageControlPairs valid,
            SokujiFukaKouseiMainValidationHandler validationHandler,
            SokujiFukaKouseiMainDiv div,
            boolean is保存の確認,
            boolean is期別特徴停止の確認) {
        valid = validationHandler.validate普徴警告();
        if (valid.iterator().hasNext()
                && (!ResponseHolder.isWarningIgnoredRequest()
                || (ResponseHolder.isWarningIgnoredRequest() && チェック済み_特徴警告.equals(div.getIsHasWarningFlag()))
                || is保存の確認
                || is期別特徴停止の確認)) {
            div.setIsHasWarningFlag(チェック済み_普徴警告);
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        return null;
    }

    private void get前排他Release() {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        LockingKey 前排他キー = new LockingKey(DBB_HIHOKENSHANO.concat(被保険者番号.getColumnValue()));
        RealInitialLocker.release(前排他キー);
    }

    private void set画面項目入力不可(SokujiFukaKouseiMainDiv div) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        tablePanel.getTxtTokuchoKoseiGo04().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo06().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo08().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo10().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo12().setReadOnly(true);
        tablePanel.getTxtTokuchoKoseiGo02().setReadOnly(true);

        tablePanel.getTxtFuchoKoseiGo04().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo05().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo06().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo07().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo08().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo09().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo10().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo11().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo12().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo01().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo02().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGo03().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGoYoku04().setReadOnly(true);
        tablePanel.getTxtFuchoKoseiGoYoku05().setReadOnly(true);

        tablePanel.getTxtFuchoNokigen04().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen05().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen06().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen07().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen08().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen09().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen10().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen11().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen12().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen01().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen02().setReadOnly(true);
        tablePanel.getTxtFuchoNokigen03().setReadOnly(true);
        tablePanel.getTxtFuchoNokigenYoku04().setReadOnly(true);
        tablePanel.getTxtFuchoNokigenYoku05().setReadOnly(true);
    }

    private boolean set画面入力項目を反映(SokujiFukaKouseiMainDiv div, NendobunFukaList 更正後) {
        Boolean is差異がある = Boolean.FALSE;
        FukaJoho 最新賦課の情報 = 更正後.get最新賦課の情報();
        FlexibleYear 賦課年度 = 最新賦課の情報.get賦課年度();
        FlexibleYear 調定年度 = 最新賦課の情報.get調定年度();
        is差異がある = set期別金額(最新賦課の情報, NUM_1, ChoshuHohoKibetsu.特別徴収.getコード(), get特別徴収期TextBoxNum(div, NUM_1),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_2, ChoshuHohoKibetsu.特別徴収.getコード(), get特別徴収期TextBoxNum(div, NUM_2),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_3, ChoshuHohoKibetsu.特別徴収.getコード(), get特別徴収期TextBoxNum(div, NUM_3),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_4, ChoshuHohoKibetsu.特別徴収.getコード(), get特別徴収期TextBoxNum(div, NUM_4),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_5, ChoshuHohoKibetsu.特別徴収.getコード(), get特別徴収期TextBoxNum(div, NUM_5),
                null, is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_6, ChoshuHohoKibetsu.特別徴収.getコード(), get特別徴収期TextBoxNum(div, NUM_6),
                null, is差異がある);

        is差異がある = set期別金額(最新賦課の情報, NUM_1, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_1),
                get普通徴収期TextBoxDate(div, NUM_1), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_2, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_2),
                get普通徴収期TextBoxDate(div, NUM_2), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_3, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_3),
                get普通徴収期TextBoxDate(div, NUM_3), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_4, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_4),
                get普通徴収期TextBoxDate(div, NUM_4), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_5, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_5),
                get普通徴収期TextBoxDate(div, NUM_5), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_6, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_6),
                get普通徴収期TextBoxDate(div, NUM_6), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_7, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_7),
                get普通徴収期TextBoxDate(div, NUM_7), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_8, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_8),
                get普通徴収期TextBoxDate(div, NUM_8), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_9, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_9),
                get普通徴収期TextBoxDate(div, NUM_9), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_10, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_10),
                get普通徴収期TextBoxDate(div, NUM_10), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_11, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_11),
                get普通徴収期TextBoxDate(div, NUM_11), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_12, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_12),
                get普通徴収期TextBoxDate(div, NUM_12), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_13, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_13),
                get普通徴収期TextBoxDate(div, NUM_13), is差異がある);
        is差異がある = set期別金額(最新賦課の情報, NUM_14, ChoshuHohoKibetsu.普通徴収.getコード(), get普通徴収期TextBoxNum(div, NUM_14),
                get普通徴収期TextBoxDate(div, NUM_14), is差異がある);
        boolean is過年度を反映 = Boolean.FALSE;
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 特徴歳出還付額 = getFormat金額(tablePanel.getLblTokuchoZogenSum().getText()).multiply((-1));
        Decimal 普徴歳出還付額 = getFormat金額(tablePanel.getLblFuchoZogenSum().getText()).multiply((-1));
        if (更正後.get過年度5() != null) {
            if (調定年度.equals(賦課年度.plusYear(NUM_5))) {
                is過年度を反映 = Boolean.TRUE;
                更正後.set過年度5(最新賦課の情報);
            }
            if (特徴歳出還付額.compareTo(Decimal.ZERO) > 0 || 普徴歳出還付額.compareTo(Decimal.ZERO) > 0) {
                更正後.get過年度5().createBuilderForEdit().set特徴歳出還付額(特徴歳出還付額);
                更正後.get過年度5().createBuilderForEdit().set普徴歳出還付額(普徴歳出還付額);
            }
        }
        if (!is過年度を反映 && 更正後.get過年度4() != null) {
            if (調定年度.equals(賦課年度.plusYear(NUM_4))) {
                is過年度を反映 = Boolean.TRUE;
                更正後.set過年度4(最新賦課の情報);
            }
            if (特徴歳出還付額.compareTo(Decimal.ZERO) > 0 || 普徴歳出還付額.compareTo(Decimal.ZERO) > 0) {
                更正後.get過年度4().createBuilderForEdit().set特徴歳出還付額(特徴歳出還付額);
                更正後.get過年度4().createBuilderForEdit().set普徴歳出還付額(普徴歳出還付額);
            }
        }
        if (!is過年度を反映 && 更正後.get過年度3() != null) {
            if (調定年度.equals(賦課年度.plusYear(NUM_3))) {
                is過年度を反映 = Boolean.TRUE;
                更正後.set過年度3(最新賦課の情報);
            }
            if (特徴歳出還付額.compareTo(Decimal.ZERO) > 0 || 普徴歳出還付額.compareTo(Decimal.ZERO) > 0) {
                更正後.get過年度3().createBuilderForEdit().set特徴歳出還付額(特徴歳出還付額);
                更正後.get過年度3().createBuilderForEdit().set普徴歳出還付額(普徴歳出還付額);
            }
        }
        return set画面入力項目を反映_2(更正後, 賦課年度, 調定年度, 最新賦課の情報, is差異がある, is過年度を反映, 特徴歳出還付額, 普徴歳出還付額);
    }

    private Boolean set画面入力項目を反映_2(NendobunFukaList 更正後, FlexibleYear 賦課年度, FlexibleYear 調定年度,
            FukaJoho 最新賦課の情報, Boolean is差異がある, boolean is過年度を反映, Decimal 特徴歳出還付額, Decimal 普徴歳出還付額) {
        if (!is過年度を反映 && 更正後.get過年度2() != null) {
            if (調定年度.equals(賦課年度.plusYear(NUM_2))) {
                is過年度を反映 = Boolean.TRUE;
                更正後.set過年度2(最新賦課の情報);
            }
            if (特徴歳出還付額.compareTo(Decimal.ZERO) > 0 || 普徴歳出還付額.compareTo(Decimal.ZERO) > 0) {
                更正後.get過年度2().createBuilderForEdit().set特徴歳出還付額(特徴歳出還付額);
                更正後.get過年度2().createBuilderForEdit().set普徴歳出還付額(普徴歳出還付額);
            }
        }
        if (!is過年度を反映 && 更正後.get過年度1() != null) {
            if (調定年度.equals(賦課年度.plusYear(NUM_1))) {
                is過年度を反映 = Boolean.TRUE;
                更正後.set過年度1(最新賦課の情報);
            }
            if (特徴歳出還付額.compareTo(Decimal.ZERO) > 0 || 普徴歳出還付額.compareTo(Decimal.ZERO) > 0) {
                更正後.get過年度1().createBuilderForEdit().set特徴歳出還付額(特徴歳出還付額);
                更正後.get過年度1().createBuilderForEdit().set普徴歳出還付額(普徴歳出還付額);
            }
        }
        if (!is過年度を反映) {
            更正後.set現年度(最新賦課の情報);
        } else {
            更正後.set現年度(更正後.get現年度());
        }
        return is差異がある;
    }

    private TextBoxNum get特別徴収期TextBoxNum(SokujiFukaKouseiMainDiv div, int 期) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        if (is有効の期(tablePanel.getLblTokuchoKi04().getText(), 期)) {
            return tablePanel.getTxtTokuchoKoseiGo04();
        }
        if (is有効の期(tablePanel.getLblTokuchoKi06().getText(), 期)) {
            return tablePanel.getTxtTokuchoKoseiGo06();
        }
        if (is有効の期(tablePanel.getLblTokuchoKi08().getText(), 期)) {
            return tablePanel.getTxtTokuchoKoseiGo08();
        }
        if (is有効の期(tablePanel.getLblTokuchoKi10().getText(), 期)) {
            return tablePanel.getTxtTokuchoKoseiGo10();
        }
        if (is有効の期(tablePanel.getLblTokuchoKi12().getText(), 期)) {
            return tablePanel.getTxtTokuchoKoseiGo12();
        }
        if (is有効の期(tablePanel.getLblTokuchoKi02().getText(), 期)) {
            return tablePanel.getTxtTokuchoKoseiGo02();
        }
        return null;
    }

    private TextBoxNum get普通徴収期TextBoxNum(SokujiFukaKouseiMainDiv div, int 期) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        if (is有効の期(tablePanel.getLblFuchoKi04().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo04();
        }
        if (is有効の期(tablePanel.getLblFuchoKi05().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo05();
        }
        if (is有効の期(tablePanel.getLblFuchoKi06().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo06();
        }
        if (is有効の期(tablePanel.getLblFuchoKi07().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo07();
        }
        if (is有効の期(tablePanel.getLblFuchoKi08().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo08();
        }
        if (is有効の期(tablePanel.getLblFuchoKi09().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo09();
        }
        if (is有効の期(tablePanel.getLblFuchoKi10().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo10();
        }
        if (is有効の期(tablePanel.getLblFuchoKi11().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo11();
        }
        if (is有効の期(tablePanel.getLblFuchoKi12().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo12();
        }
        if (is有効の期(tablePanel.getLblFuchoKi01().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo01();
        }
        if (is有効の期(tablePanel.getLblFuchoKi02().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo02();
        }
        if (is有効の期(tablePanel.getLblFuchoKi03().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGo03();
        }
        if (is有効の期(tablePanel.getLblFuchoKiYoku04().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGoYoku04();
        }
        if (is有効の期(tablePanel.getLblFuchoKiYoku05().getText(), 期)) {
            return tablePanel.getTxtFuchoKoseiGoYoku05();
        }
        return null;
    }

    private TextBoxDate get普通徴収期TextBoxDate(SokujiFukaKouseiMainDiv div, int 期) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        if (is有効の期(tablePanel.getLblFuchoKi04().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen04();
        }
        if (is有効の期(tablePanel.getLblFuchoKi05().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen05();
        }
        if (is有効の期(tablePanel.getLblFuchoKi06().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen06();
        }
        if (is有効の期(tablePanel.getLblFuchoKi07().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen07();
        }
        if (is有効の期(tablePanel.getLblFuchoKi08().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen08();
        }
        if (is有効の期(tablePanel.getLblFuchoKi09().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen09();
        }
        if (is有効の期(tablePanel.getLblFuchoKi10().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen10();
        }
        if (is有効の期(tablePanel.getLblFuchoKi11().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen11();
        }
        if (is有効の期(tablePanel.getLblFuchoKi12().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen12();
        }
        if (is有効の期(tablePanel.getLblFuchoKi01().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen01();
        }
        if (is有効の期(tablePanel.getLblFuchoKi02().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen02();
        }
        if (is有効の期(tablePanel.getLblFuchoKi03().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigen03();
        }
        if (is有効の期(tablePanel.getTxtFuchoNokigenYoku04().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigenYoku04();
        }
        if (is有効の期(tablePanel.getLblFuchoKiYoku05().getText(), 期)) {
            return tablePanel.getTxtFuchoNokigenYoku05();
        }
        return null;
    }

    private boolean is有効の期(RString text, int 期) {
        return !RString.EMPTY.equals(text)
                && 期 == Integer.valueOf(text.replace(TEXT_期, RString.EMPTY).toString());
    }

    private boolean set期別金額(FukaJoho 賦課の情報, int 期, RString 徴収方法期別, TextBoxNum textBoxNum,
            TextBoxDate textBoxDate, Boolean is差異がある) {
        if (賦課の情報 == null || 賦課の情報.getKibetsuList().isEmpty() || textBoxNum == null) {
            return is差異がある;
        }
        Decimal 期別金額 = textBoxNum.getValue() == null ? Decimal.ZERO : textBoxNum.getValue();
        List<Kibetsu> 介護期別List = new ArrayList<>(賦課の情報.getKibetsuList());
        for (Kibetsu 介護期別 : 介護期別List) {
            if (徴収方法期別.equals(介護期別.get徴収方法())
                    && 期 == 介護期別.get期()) {
                ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(介護期別.get調定ID().longValue());
                ChoteiKyotsuBuilder choteiKyotsuBuilder = 介護期別.getChoteiKyotsu(identifier).createBuilderForEdit();
                boolean isChange = Boolean.FALSE;
                if (!期別金額.equals(介護期別.getChoteiKyotsu(identifier).get調定額()) && !textBoxNum.isReadOnly()) {
                    is差異がある = Boolean.TRUE;
                    isChange = Boolean.TRUE;
                    choteiKyotsuBuilder.set調定額(期別金額);
                }
                if (ChoshuHohoKibetsu.普通徴収.getコード().equals(徴収方法期別)
                        && !介護期別.getChoteiKyotsu(identifier).get納期限().equals(textBoxDate.getValue())
                        && !textBoxDate.isReadOnly()) {
                    is差異がある = Boolean.TRUE;
                    isChange = Boolean.TRUE;
                    choteiKyotsuBuilder.set納期限(textBoxDate.getValue());
                }
                if (isChange) {
                    Kibetsu 介護期別情報 = 介護期別.createBuilderForEdit().setKibetsu(choteiKyotsuBuilder.build().modifiedModel()).build();
                    賦課の情報.createBuilderForEdit().setKibetsu(介護期別情報);
                }
                return is差異がある;
            }
        }
        if (Decimal.ZERO.compareTo(期別金額) < 0) {
            ChoteiKyotsu 調定共通 = new ChoteiKyotsu(0L).createBuilderForEdit().
                    set収納ID(0L).
                    set会計年度(new RYear(賦課の情報.get賦課年度().getYearValue())).
                    set処理年度(new RYear(賦課の情報.get賦課年度().getYearValue())).
                    set調定事由コード(調定事由コード_更正).
                    set調定額(期別金額).
                    set消費税額(Decimal.ZERO).
                    set賦課処理状況(Boolean.FALSE).build();
            if (賦課の情報.get調定日時() != null) {
                調定共通 = 調定共通.createBuilderForEdit().set調定年月日(賦課の情報.get調定日時().getDate()).build();
            }
            if (textBoxDate != null) {
                調定共通 = 調定共通.createBuilderForEdit().set納期限(textBoxDate.getValue()).build();
            }
            Kibetsu 介護期別情報 = new Kibetsu(
                    賦課の情報.get調定年度(),
                    賦課の情報.get賦課年度(),
                    賦課の情報.get通知書番号(),
                    賦課の情報.get履歴番号(),
                    徴収方法期別,
                    期).createBuilderForEdit().set調定ID(Decimal.ZERO).setKibetsu(調定共通).build();
            賦課の情報.createBuilderForEdit().setKibetsu(介護期別情報);
        }
        return is差異がある;
    }

    private RString get金額のカンマ編集(Decimal 金額) {
        if (金額 == null) {
            return ZERO;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, NUM_0);
    }

    private Decimal getFormat金額(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return Decimal.ZERO;
        }
        return new Decimal(金額.replace(読点, RString.EMPTY).trim().toString());
    }

    private boolean is年間保険料額変更あり(SokujiFukaKouseiMainDiv div) {
        Decimal 年間保険料額前 = div.getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoMae().getTxtNenkanHokenryo1().getValue();
        Decimal 年間保険料額後 = div.getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoAto().getTxtNenkanHokenryo2().getValue();
        return null != 年間保険料額前 && null != 年間保険料額後 && 年間保険料額前.equals(年間保険料額後);
    }
}
