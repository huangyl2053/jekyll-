/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.ServiceItiranHyojiJohoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.ServiceJohoBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.DBA2010013StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.DBA2010013TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.JigyoshaTourokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.dgServiceList_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010013.JigyoshaTourokuHandler;
import jp.co.ndensan.reams.db.dba.service.core.jigyoshatouroku.JigyoshaTourokuFinder;
import jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri.KaigoJigyoshaShisetsuKanriManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 事業者登録クラスです。
 *
 * @reamsid_L DBA-0340-050 lijia
 *
 */
public class JigyoshaTouroku {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_照会 = new RString("照会");
    private static final LockingKey 前排他ロックキー = new LockingKey("KaigoJigyoshaToroku");
    private KaigoJigyoshaShisetsuKanriMapperParameter 事業者登録パラメータ;
    private KaigoJogaiTokureiParameter サービス一覧パラメータ;
    private final KaigoJigyoshaShisetsuKanriManager manager = KaigoJigyoshaShisetsuKanriManager.createInstance();
    private final JigyoshaTourokuFinder jigyoshaTourokuFinder = JigyoshaTourokuFinder.createInstance();

    /**
     * 事業者登録Divを初期化します。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onLoad(JigyoshaTourokuDiv div) {
        JigyoshaMode jigyoshaMode = ViewStateHolder.get(ViewStateKeys.介護事業者情報, JigyoshaMode.class);
        if (jigyoshaMode != null) {
            ViewStateHolder.put(ViewStateKeys.事業者番号, jigyoshaMode.getJigyoshaNo().getColumnValue());
            ViewStateHolder.put(ViewStateKeys.有効開始日, new FlexibleDate(jigyoshaMode.getYukoKaishiYMD()));
        }
        ViewStateHolder.put(ViewStateKeys.事業者種類コード, new RString("11"));
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        FlexibleDate 有効開始日 = ViewStateHolder.get(ViewStateKeys.有効開始日, FlexibleDate.class);
        事業者登録パラメータ = KaigoJigyoshaShisetsuKanriMapperParameter.createParam(
                事業者番号, 有効開始日, RString.EMPTY, RString.EMPTY, FlexibleDate.EMPTY);
        サービス一覧パラメータ = KaigoJogaiTokureiParameter.createParam(
                事業者番号, 有効開始日, FlexibleDate.EMPTY, RDate.getNowDate().getYearMonth());
        if (初期_状態 == null || 状態_追加.equals(初期_状態)) {
            getHandler(div).initialize(初期_状態);
            return ResponseData.of(div).setState(DBA2010013StateName.追加状態);
        } else if (状態_修正.equals(初期_状態)) {
            getHandler(div).initialize(初期_状態);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010013StateName.修正状態);
        } else if (状態_削除.equals(初期_状態)) {
            getHandler(div).initialize(初期_状態);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010013StateName.削除状態);
        } else if (状態_照会.equals(初期_状態)) {
            getHandler(div).initialize(初期_状態);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010013StateName.照会状態);
        }
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(JigyoshaTourokuErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaTourokuDiv> get事業者情報の検索処理(JigyoshaTourokuDiv div) {
        List<KaigoJigyosha> 事業者登録情報List = manager.getJigyoshaJoho(事業者登録パラメータ).records();
        List<KaigoJigyoshaShiteiService> サービス一覧情報List = manager.getServiceItiranJoho(サービス一覧パラメータ).records();
        List<ServiceItiranHyojiJohoBusiness> サービス一覧表示情報List = manager.getServiceItiranHyojiJoho(サービス一覧パラメータ).records();
        boolean selectFlag = false;
        KaigoJigyosha kaigoJigyosha = null;
        if (!事業者登録情報List.isEmpty()) {
            selectFlag = true;
            kaigoJigyosha = 事業者登録情報List.get(0);
        }
        ViewStateHolder.put(ViewStateKeys.事業者登録情報, kaigoJigyosha);
        ViewStateHolder.put(ViewStateKeys.サービス一覧情報, Models.create(サービス一覧情報List));
        getHandler(div).get事業者情報_代表者_開設者情報(selectFlag, kaigoJigyosha);
        getHandler(div).getサービス一覧情報(サービス一覧表示情報List);
        return ResponseData.of(div).respond();
    }

    /**
     * サービス一覧の「再表示」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnServiceReload(JigyoshaTourokuDiv div) {
        List<RString> chkFlagList = div.getServiceJoho().getChkKakoRirekiHyojiFlag().getSelectedKeys();
        boolean chkFlag = false;
        if (chkFlagList.isEmpty()) {
            chkFlag = true;
        }
        RString 事業者番号 = div.getServiceJigyoshaJoho().getTxtJigyoshaNo().getValue();
        FlexibleDate 有効開始日 = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
        FlexibleDate 有効終了日 = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
        サービス一覧パラメータ = KaigoJogaiTokureiParameter.createParam(
                事業者番号, 有効開始日, 有効終了日, RDate.getNowDate().getYearMonth());
        List<KaigoJigyoshaShiteiService> サービス一覧情報List = manager.getServiceItiranJoho(サービス一覧パラメータ).records();
        getHandler(div).getサービス一覧情報再表示(サービス一覧情報List,chkFlag);
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービスを追加する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnAddService(JigyoshaTourokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面状態, 状態_追加);
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity tourokuEntity = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
        tourokuEntity.setJigyoshaNo(div.getServiceJigyoshaJoho().getTxtJigyoshaNo().getValue());
        tourokuEntity.setJigyoshaMeisho(new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaName().getValue()));
        tourokuEntity.setJigyoshaKanaMeisho(new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().getValue()));
        tourokuEntity.setJigyoshaJusho(div.getServiceJigyoshaJoho().getTxtJusho().getValue());
        tourokuEntity.setJigyoshaKanaJusho(div.getServiceJigyoshaJoho().getTxtJushoKana().getValue());
        tourokuEntity.setJigyoHaishiYMD(div.getServiceJigyoshaJoho().getTxtJigyoHaishiYMD().getValue());
        tourokuEntity.setJigyoKaishiYMD(div.getServiceJigyoshaJoho().getTxtJigyoKaishiYMD().getValue());
        tourokuEntity.setJigyoKyushiYMD(div.getServiceJigyoshaJoho().getTxtJigyoKyushuYMD().getValue());
        tourokuEntity.setJigyoSaikaiYMD(div.getServiceJigyoshaJoho().getTxtJigyoSaikaiYMD().getValue());
        tourokuEntity.setFaxNo(new TelNo(div.getServiceJigyoshaJoho().getTxtFaxNo().getValue()));
        tourokuEntity.setTelNo(new TelNo(div.getServiceJigyoshaJoho().getTxtTelNo().getValue()));
        tourokuEntity.setYubinNo(div.getServiceJigyoshaJoho().getTxtYubinNo().getValue());
        tourokuEntity.setYukoKaishiYMD(div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue());
        tourokuEntity.setYukoShuryoYMD(div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue());                
        ViewStateHolder.put(ViewStateKeys.事業者登録情報, tourokuEntity);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.サービス追加).respond();
    }

    /**
     * 「サービスを修正する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnModify(JigyoshaTourokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面状態, 状態_修正);
        set画面引数の設定(div);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.サービス修正).respond();
    }

    /**
     * 「サービスを削除する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnDelete(JigyoshaTourokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面状態, 状態_削除);
        set画面引数の設定(div);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.サービス削除).respond();
    }

    private void set画面引数の設定(JigyoshaTourokuDiv div) {
        if (RString.isNullOrEmpty(ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.事業者番号, div.getServiceJigyoshaJoho().getTxtJigyoshaNo().getValue());
        } else {
            ViewStateHolder.put(ViewStateKeys.事業者番号,
                    ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class));
        }
        ViewStateHolder.put(ViewStateKeys.サービス種類コード,
                div.getServiceJoho().getDgServiceList().getClickedItem().getServiceShuruiCode());
        ViewStateHolder.put(ViewStateKeys.有効開始日,
                div.getServiceJoho().getDgServiceList().getClickedItem().getKaishiDate().getValue());
    }

    /**
     * 「事業者情報を保存する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnSave(JigyoshaTourokuDiv div) {
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);       
        if (初期_状態 == null || 状態_追加.equals(初期_状態)) {
            RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
            FlexibleDate yukoKaishiYMD = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
            FlexibleDate yukoShuryoYMD = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
            KaigoJogaiTokureiParameter parameter
                = KaigoJogaiTokureiParameter.createParam(事業者番号, yukoKaishiYMD, yukoShuryoYMD, null);
            if (!manager.checkKikanGorisei(parameter)) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(new ValidationMessageControlPair(JigyoshaTourokuErrorMessage.期間が不正,
                        div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD(),div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD()));
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }        
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の登録処理(div);
                RealInitialLocker.release(前排他ロックキー);
                return ResponseData.of(div).setState(DBA2010013StateName.完了状態);
            }
        } else if (状態_修正.equals(初期_状態)) {            
            KaigoJigyosha 旧事業者情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, KaigoJigyosha.class);
            FlexibleDate yukoKaishiYMD = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
            FlexibleDate yukoShuryoYMD = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
            KaigoJogaiTokureiParameter parameter = KaigoJogaiTokureiParameter.createParam(
                旧事業者情報.get事業者番号().getColumnValue(), yukoKaishiYMD, yukoShuryoYMD, null);
            if (!manager.checkKikanGorisei(parameter)) {
                ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
                validationMessages.add(new ValidationMessageControlPair(JigyoshaTourokuErrorMessage.期間が不正,
                        div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD(),div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD()));
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RealInitialLocker.release(前排他ロックキー);
                get事業者情報の更新処理(div);
                return ResponseData.of(div).setState(DBA2010013StateName.完了状態);
            }
        } else if (状態_削除.equals(初期_状態)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RealInitialLocker.release(前排他ロックキー);
                get事業者情報の削除処理(div);
                return ResponseData.of(div).setState(DBA2010013StateName.完了状態);
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaTourokuDiv> get事業者情報の登録処理(JigyoshaTourokuDiv div) {
        RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class);
        JigyoshaNo jigyoshaNo = new JigyoshaNo(div.getServiceJigyoshaJoho().getTxtJigyoshaNo().getValue());
        FlexibleDate 有効開始日 = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
        if (jigyoshaTourokuFinder.事業者番号重複チェック(jigyoshaNo, 有効開始日)) {
            throw new ApplicationException("事業者番号が介護事業者テーブルに存在するのため登録できません。");
        }
        FlexibleDate yukoKaishiYMD = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
        FlexibleDate yukoShuryoYMD = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
        KaigoJigyoshaParameter kaigoJigyoshaParameter = KaigoJigyoshaParameter.createParam(
                jigyoshaNo.getColumnValue(),
                ViewStateHolder.get(ViewStateKeys.事業者種類コード, RString.class
                ),
                yukoKaishiYMD,
                yukoShuryoYMD);
        if (manager.checkKikanJufuku(kaigoJigyoshaParameter, 有効開始日)) {
            throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
        }
        KaigoJigyosha kaigoJigyosha = new KaigoJigyosha(jigyoshaNo, yukoKaishiYMD);
        KaigoJigyoshaBuilder kaigoJigyoshaBuilder = kaigoJigyosha.createBuilderForEdit();
        kaigoJigyoshaBuilder.set有効終了日(div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue());
        kaigoJigyoshaBuilder.set事業者名称(
                new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaName().getValue()));
        kaigoJigyoshaBuilder.set事業者名称カナ(
                new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().getValue()));
        kaigoJigyoshaBuilder.set異動日(new FlexibleDate(RDate.getNowDate().toDateString()));
        kaigoJigyoshaBuilder.set異動事由(new RString("01"));
        kaigoJigyoshaBuilder.set事業開始日(div.getServiceJigyoshaJoho().getTxtJigyoKaishiYMD().getValue());
        kaigoJigyoshaBuilder.set事業休止日(div.getServiceJigyoshaJoho().getTxtJigyoKyushuYMD().getValue());
        kaigoJigyoshaBuilder.set事業再開日(div.getServiceJigyoshaJoho().getTxtJigyoSaikaiYMD().getValue());
        kaigoJigyoshaBuilder.set事業廃止日(div.getServiceJigyoshaJoho().getTxtJigyoHaishiYMD().getValue());
        kaigoJigyoshaBuilder.set郵便番号(div.getServiceJigyoshaJoho().getTxtYubinNo().getValue());
        kaigoJigyoshaBuilder.set電話番号(
                new TelNo(div.getServiceJigyoshaJoho().getTxtTelNo().getValue()));
        kaigoJigyoshaBuilder.setFAX番号(
                new TelNo(div.getServiceJigyoshaJoho().getTxtFaxNo().getValue()));
        kaigoJigyoshaBuilder.set事業者住所(
                new AtenaJusho(div.getServiceJigyoshaJoho().getTxtJusho().getValue()));
        kaigoJigyoshaBuilder.set事業者住所カナ(div.getServiceJigyoshaJoho().getTxtJushoKana().getValue());
        kaigoJigyoshaBuilder.set所在市町村(div.getServiceJigyoshaJoho().getTxtShozaiShichoson().getValue());
        kaigoJigyoshaBuilder.setサービス実施地域(div.getServiceJigyoshaJoho().getTxtServiceTiiki().getValue());
        Decimal 所属人数 = div.getServiceJigyoshaJoho().getTxtShozokuNum().getValue();
        kaigoJigyoshaBuilder.set所属人数(所属人数 == null ? 0 : 所属人数.intValue());
        Decimal 利用者数 = div.getServiceJigyoshaJoho().getTxtRiyoshaNum().getValue();
        kaigoJigyoshaBuilder.set利用者数(利用者数 == null ? 0 : 利用者数.intValue());
        Decimal ベッド数 = div.getServiceJigyoshaJoho().getTxtBedNum().getValue();
        kaigoJigyoshaBuilder.setベッド数(ベッド数 == null ? 0 : ベッド数.intValue());
        kaigoJigyoshaBuilder.set宛先人名(
                new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtAtesakininName().getValue()));
        kaigoJigyoshaBuilder.set宛先人名カナ(
                new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtAtesakininNameKana().getValue()));
        kaigoJigyoshaBuilder.set宛先部署(div.getServiceJigyoshaJoho().getTxtAtesakiBusho().getValue());
        kaigoJigyoshaBuilder.set法人等種別(
                new Code(div.getServiceJigyoshaJoho().getDdlHojinShubetsu().getSelectedKey()));
        kaigoJigyoshaBuilder.set指定_基準該当等事業所区分(
                new Code(div.getServiceJigyoshaJoho().getDdlShiteiKijungaitoKubun().getSelectedKey()));
        kaigoJigyoshaBuilder.set備考(div.getServiceJigyoshaJoho().getTxtBiko().getValue());
        KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = new KaigoJigyoshaDaihyosha(jigyoshaNo, yukoKaishiYMD);
        KaigoJigyoshaDaihyoshaBuilder kaigoJigyoshaDaihyoshaBuilder = kaigoJigyoshaDaihyosha.createBuilderForEdit();
        kaigoJigyoshaDaihyoshaBuilder.set代表者名(
                new AtenaMeisho(div.getDaihyoshaJoho().getTxtDaihyoshaName().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set代表者名カナ(
                new AtenaKanaMeisho(div.getDaihyoshaJoho().getTxtDaihyoshaNameKana().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set代表者住所(
                new AtenaJusho(div.getDaihyoshaJoho().getTxtDaihyoshaJusho().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set代表者住所カナ(div.getDaihyoshaJoho().getTxtDaihyoshaJushoKana().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set代表者役職名(div.getDaihyoshaJoho().getTxtDaihyoshaYakushokuMei().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set代表者郵便番号(div.getDaihyoshaJoho().getTxtDaihyoshaYubinNo().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set開設者名称(
                new AtenaMeisho(div.getKaisetsushaJoho().getTxtKaisetsushaName().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者名称カナ(
                new AtenaKanaMeisho(div.getKaisetsushaJoho().getTxtKaisetsushaNameKana().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者郵便番号(div.getKaisetsushaJoho().getTxtKaisetsushaYubinNo().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set開設者電話番号(
                new TelNo(div.getKaisetsushaJoho().getTxtKaisetsushaTelNo().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者ＦＡＸ番号(
                new TelNo(div.getKaisetsushaJoho().getTxtKaisetsushaFaxNo().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者住所(
                new AtenaJusho(div.getKaisetsushaJoho().getTxtKaisetsushaJusho().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者住所カナ(div.getKaisetsushaJoho().getTxtKaisetsushaJushoKana().getValue());
        kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyoshaBuilder.build();
        kaigoJigyoshaBuilder.setKaigoJigyoshaDaihyosha(kaigoJigyoshaDaihyosha);
        kaigoJigyosha = kaigoJigyoshaBuilder.build();
        boolean insertFlag = manager.insertJigyoshaJoho(
                kaigoJigyosha,
                ViewStateHolder.get(ViewStateKeys.事業者種類コード, RString.class),
                null);
        if (insertFlag) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaTourokuDiv> get事業者情報の更新処理(JigyoshaTourokuDiv div) {
        KaigoJigyosha 旧事業者情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, KaigoJigyosha.class);
        FlexibleDate yukoKaishiYMD = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
        FlexibleDate yukoShuryoYMD = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
        KaigoJigyoshaParameter kaigoJigyoshaParameter = KaigoJigyoshaParameter.createParam(
                旧事業者情報.get事業者番号().getColumnValue(),
                ViewStateHolder.get(ViewStateKeys.事業者種類コード, RString.class),
                yukoKaishiYMD,
                yukoShuryoYMD);
        if (manager.checkKikanJufuku(kaigoJigyoshaParameter, yukoKaishiYMD)) {
            throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
        }
        manager.サービスと事業者期間関連のチェック(getサービス一覧(div), yukoKaishiYMD, yukoShuryoYMD);
        KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha;
        if (旧事業者情報.get有効開始日().equals(yukoKaishiYMD)) {
            KaigoJigyoshaDaihyoshaIdentifier identifier
                    = new KaigoJigyoshaDaihyoshaIdentifier(旧事業者情報.get事業者番号(), 旧事業者情報.get有効開始日());
            kaigoJigyoshaDaihyosha = 旧事業者情報.getKaigoJigyoshaDaihyoshaList(identifier);
        } else {
            kaigoJigyoshaDaihyosha = new KaigoJigyoshaDaihyosha(旧事業者情報.get事業者番号(), yukoKaishiYMD);
        }
        KaigoJigyoshaDaihyoshaBuilder kaigoJigyoshaDaihyoshaBuilder = kaigoJigyoshaDaihyosha.createBuilderForEdit();
        kaigoJigyoshaDaihyoshaBuilder.set代表者名(
                new AtenaMeisho(div.getDaihyoshaJoho().getTxtDaihyoshaName().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set代表者名カナ(
                new AtenaKanaMeisho(div.getDaihyoshaJoho().getTxtDaihyoshaNameKana().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set代表者住所(
                new AtenaJusho(div.getDaihyoshaJoho().getTxtDaihyoshaJusho().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set代表者住所カナ(div.getDaihyoshaJoho().getTxtDaihyoshaJushoKana().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set代表者役職名(div.getDaihyoshaJoho().getTxtDaihyoshaYakushokuMei().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set代表者郵便番号(div.getDaihyoshaJoho().getTxtDaihyoshaYubinNo().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set開設者名称(
                new AtenaMeisho(div.getKaisetsushaJoho().getTxtKaisetsushaName().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者名称カナ(
                new AtenaKanaMeisho(div.getKaisetsushaJoho().getTxtKaisetsushaNameKana().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者郵便番号(div.getKaisetsushaJoho().getTxtKaisetsushaYubinNo().getValue());
        kaigoJigyoshaDaihyoshaBuilder.set開設者電話番号(
                new TelNo(div.getKaisetsushaJoho().getTxtKaisetsushaTelNo().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者ＦＡＸ番号(
                new TelNo(div.getKaisetsushaJoho().getTxtKaisetsushaFaxNo().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者住所(
                new AtenaJusho(div.getKaisetsushaJoho().getTxtKaisetsushaJusho().getValue()));
        kaigoJigyoshaDaihyoshaBuilder.set開設者住所カナ(div.getKaisetsushaJoho().getTxtKaisetsushaJushoKana().getValue());
        kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyoshaBuilder.build();
        KaigoJigyosha 事業者情報;
        if (旧事業者情報.get有効開始日().equals(yukoKaishiYMD)) {
            事業者情報 = 旧事業者情報;
        } else {
            事業者情報 = new KaigoJigyosha(旧事業者情報.get事業者番号(), yukoKaishiYMD);
        }
        KaigoJigyoshaBuilder kaigoJigyoshaBuilder = 事業者情報.createBuilderForEdit();
        kaigoJigyoshaBuilder.set有効終了日(div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue());
        kaigoJigyoshaBuilder.set事業者名称(
                new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaName().getValue()));
        kaigoJigyoshaBuilder.set事業者名称カナ(
                new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().getValue()));
        kaigoJigyoshaBuilder.set事業開始日(div.getServiceJigyoshaJoho().getTxtJigyoKaishiYMD().getValue());
        kaigoJigyoshaBuilder.set事業休止日(div.getServiceJigyoshaJoho().getTxtJigyoKyushuYMD().getValue());
        kaigoJigyoshaBuilder.set事業再開日(div.getServiceJigyoshaJoho().getTxtJigyoSaikaiYMD().getValue());
        kaigoJigyoshaBuilder.set事業廃止日(div.getServiceJigyoshaJoho().getTxtJigyoHaishiYMD().getValue());
        kaigoJigyoshaBuilder.set郵便番号(div.getServiceJigyoshaJoho().getTxtYubinNo().getValue());
        kaigoJigyoshaBuilder.set電話番号(
                new TelNo(div.getServiceJigyoshaJoho().getTxtTelNo().getValue()));
        kaigoJigyoshaBuilder.setFAX番号(
                new TelNo(div.getServiceJigyoshaJoho().getTxtFaxNo().getValue()));
        kaigoJigyoshaBuilder.set事業者住所(
                new AtenaJusho(div.getServiceJigyoshaJoho().getTxtJusho().getValue()));
        kaigoJigyoshaBuilder.set事業者住所カナ(div.getServiceJigyoshaJoho().getTxtJushoKana().getValue());
        kaigoJigyoshaBuilder.set所在市町村(div.getServiceJigyoshaJoho().getTxtShozaiShichoson().getValue());
        kaigoJigyoshaBuilder.setサービス実施地域(div.getServiceJigyoshaJoho().getTxtServiceTiiki().getValue());
        Decimal 所属人数 = div.getServiceJigyoshaJoho().getTxtShozokuNum().getValue();
        kaigoJigyoshaBuilder.set所属人数(所属人数 == null ? 0 : 所属人数.intValue());
        Decimal 利用者数 = div.getServiceJigyoshaJoho().getTxtRiyoshaNum().getValue();
        kaigoJigyoshaBuilder.set利用者数(利用者数 == null ? 0 : 利用者数.intValue());
        Decimal ベッド数 = div.getServiceJigyoshaJoho().getTxtBedNum().getValue();
        kaigoJigyoshaBuilder.setベッド数(ベッド数 == null ? 0 : ベッド数.intValue());
        kaigoJigyoshaBuilder.set宛先人名(
                new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtAtesakininName().getValue()));
        kaigoJigyoshaBuilder.set宛先人名カナ(
                new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtAtesakininNameKana().getValue()));
        kaigoJigyoshaBuilder.set宛先部署(div.getServiceJigyoshaJoho().getTxtAtesakiBusho().getValue());
        kaigoJigyoshaBuilder.set法人等種別(
                new Code(div.getServiceJigyoshaJoho().getDdlHojinShubetsu().getSelectedKey()));
        kaigoJigyoshaBuilder.set指定_基準該当等事業所区分(
                new Code(div.getServiceJigyoshaJoho().getDdlShiteiKijungaitoKubun().getSelectedKey()));
        kaigoJigyoshaBuilder.set備考(div.getServiceJigyoshaJoho().getTxtBiko().getValue());
        kaigoJigyoshaBuilder.setKaigoJigyoshaDaihyosha(kaigoJigyoshaDaihyosha.modifiedModel());
        事業者情報 = kaigoJigyoshaBuilder.build();
        boolean updateFlag = manager.updateJigyoshaJoho(
                旧事業者情報,
                事業者情報,
                ViewStateHolder.get(ViewStateKeys.事業者種類コード, RString.class),
                null,
                null);
        if (updateFlag) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).respond();
    }

    private List<ServiceJohoBusiness> getサービス一覧(JigyoshaTourokuDiv div) {
        List<dgServiceList_Row> サービス一覧list = div.getServiceJoho().getDgServiceList().getDataSource();
        List<ServiceJohoBusiness> businessList = new ArrayList<>();
        for (dgServiceList_Row dgServiceListRow : サービス一覧list) {
            TextBoxFlexibleDate 有効開始日 = dgServiceListRow.getKaishiDate();
            TextBoxFlexibleDate 有効終了日 = dgServiceListRow.getShuryoDate();
            ServiceJohoBusiness business = new ServiceJohoBusiness(
                    有効開始日 == null ? FlexibleDate.EMPTY : 有効開始日.getValue(),
                    有効終了日 == null ? FlexibleDate.EMPTY : 有効終了日.getValue(),
                    dgServiceListRow.getServiceType());
            businessList.add(business);
        }
        return businessList;
    }

    private ResponseData<JigyoshaTourokuDiv> get事業者情報の削除処理(JigyoshaTourokuDiv div) {
        boolean deleteServiceFlag = false;
        Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> サービス一覧情報Model = ViewStateHolder.get(ViewStateKeys.サービス一覧情報, Models.class
        );
        for (KaigoJigyoshaShiteiService business
                : サービス一覧情報Model.values()) {
            deleteServiceFlag = jigyoshaTourokuFinder.isShiteiServiceDelete(business);
        }
        KaigoJigyosha 事業者情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, KaigoJigyosha.class);
        KaigoJigyoshaDaihyoshaIdentifier identifier
                = new KaigoJigyoshaDaihyoshaIdentifier(事業者情報.get事業者番号(), 事業者情報.get有効開始日());
        KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = 事業者情報.getKaigoJigyoshaDaihyoshaList(identifier);
        KaigoJigyoshaDaihyoshaBuilder kaigoJigyoshaDaihyoshaBuilder = kaigoJigyoshaDaihyosha.createBuilderForEdit();
        kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyoshaBuilder.build();
        KaigoJigyoshaBuilder kaigoJigyoshaBuilder = 事業者情報.createBuilderForEdit();

        kaigoJigyoshaBuilder.setKaigoJigyoshaDaihyosha(kaigoJigyoshaDaihyosha.deleted());
        事業者情報 = kaigoJigyoshaBuilder.build();
        boolean deleteFlag = jigyoshaTourokuFinder.saveOrDelete(事業者情報.deleted());
        if (deleteFlag && deleteServiceFlag) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("削除").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }

        return ResponseData.of(div)
                .respond();
    }

    /**
     * 「再検索する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnBack(JigyoshaTourokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaTourokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaTourokuDiv> onClick_btnComplete(JigyoshaTourokuDiv div) {
        RealInitialLocker.release(前排他ロックキー);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.完了).respond();
    }

    private JigyoshaTourokuHandler getHandler(JigyoshaTourokuDiv div) {
        return new JigyoshaTourokuHandler(div);

    }

    private enum JigyoshaTourokuErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中),
        期間が不正(UrErrorMessages.期間が不正);
        private final Message message;

        private JigyoshaTourokuErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
