/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jigyoshaservice.JigyoshaServiceJoho;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.ServiceItiranHyojiJohoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.ServiceJohoBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.DBA2010014StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.DBA2010014TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.JigyoshaServiceDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010014.JigyoshaServiceHandler;
import jp.co.ndensan.reams.db.dba.service.core.jigyoshaservice.JigyoshaServiceManager;
import jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri.KaigoJigyoshaShisetsuKanriManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.IHokenjaManager;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja._HokenjaManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 画面サービス登録のクラスです。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaService {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final LockingKey 前排他ロックキー = new LockingKey("KaigoJigyoshaShiteiService");

    /**
     * 画面の初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onLoad(JigyoshaServiceDiv div) {
        setサービス種類(div);
        RString 画面状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 事業者登録情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
        if (状態_追加.equals(画面状態)) {
            getHandler(div).set状態_追加(ViewStateHolder
                    .get(ViewStateKeys.事業者番号, RString.class),事業者登録情報);
            List<RString> chkKihonJunkyoFlag = new ArrayList<>();
            chkKihonJunkyoFlag.add(new RString("0"));
            div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().setSelectedItemsByKey(chkKihonJunkyoFlag);
            return ResponseData.of(div).setState(DBA2010014StateName.追加状態);
        } else if (状態_修正.equals(画面状態)) {
            getHandler(div).set画面情報(get事業者サービス情報取得());
            getHandler(div).set状態_修正();
            return ResponseData.of(div).setState(DBA2010014StateName.修正状態);
        } else if (状態_削除.equals(画面状態)) {
            getHandler(div).set画面情報(get事業者サービス情報取得());
            getHandler(div).set状態_削除();
            return ResponseData.of(div).setState(DBA2010014StateName.削除状態);
        }
        set登録保険者名称(div);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(JigyoshaErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void setサービス種類(JigyoshaServiceDiv div) {
        List<JigyoshaServiceJoho> johoList = getService_Delete().getserviceShuruiCdDDL().records();
        List<KeyValueDataSource> dateSource = new ArrayList<>();
        for (JigyoshaServiceJoho joho : johoList) {
            KeyValueDataSource keyValue = new KeyValueDataSource(joho.getサービス種類コード().getColumnValue(), joho.getサービス種類名称());
            dateSource.add(keyValue);
        }
        div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().setDataSource(dateSource);
    }

    private void set登録保険者名称(JigyoshaServiceDiv div) {
        IHokenjaManager manager = new _HokenjaManager();
        RString 保険者コード = RString.EMPTY;
        if (div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue() != null) {
            保険者コード = div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue();
        }
        Hokenja hokenja = manager.get保険者(new HokenjaNo(保険者コード), new HokenjaShubetsu(new RString("08")));
        if (hokenja != null) {
            div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setValue(hokenja.get保険者名());
        }

    }

    /**
     * 介護事業者は基本情報に準拠チェックボックスを選択します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onChange_ChkKihonJunkyoFlag(JigyoshaServiceDiv div) {
        RString 画面状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 事業者登録情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
        if (状態_追加.equals(画面状態)) {
            if(!div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().isEmpty()){
                 getHandler(div).set状態_追加(ViewStateHolder
                         .get(ViewStateKeys.事業者番号, RString.class),事業者登録情報);
            }else{
                div.getJigyoshaServiceKihon().getJigyosha().setDisabled(false);
            }
            return ResponseData.of(div).setState(DBA2010014StateName.追加状態);
        }else{
            List<KaigoJigyoshaShiteiService> johoList = get事業者サービス情報取得();
            getHandler(div).onChange_ChkKihonJunkyoFlag(johoList);
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 登録保険者名テキストボックスを設定します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onBlur_TxtTorokuHokenshaNo(JigyoshaServiceDiv div) {
        IHokenjaManager manager = new _HokenjaManager();
        Hokenja joho = manager.get保険者except介護保険(new HokenjaNo(div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue()));
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setValue(joho == null ? RString.EMPTY : joho.get保険者名());
        return ResponseData.of(div).respond();
    }

    /**
     * 「登録保険者入力ガイド」ボタンを押しダイアログ画面を戻る、登録保険者を設定します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_BtnHokenshaInputGuide(JigyoshaServiceDiv div) {
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().setValue(div.getHokenshaNo());
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setValue(div.getHokenshaMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 詳細情報を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_BtnInputShosai(JigyoshaServiceDiv div) {
        getHandler(div).onClick_BtnInputShosai();
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_BtnInputKihon(JigyoshaServiceDiv div) {
        getHandler(div).onClick_BtnInputKihon();
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者サービスを保存します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_Save(JigyoshaServiceDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && click_hai(div)) {
            RealInitialLocker.release(前排他ロックキー);
            RString 画面状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
            if (状態_追加.equals(画面状態)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).parameter(状態_追加);
            } else if (状態_修正.equals(画面状態)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).parameter(状態_修正);
            } else if (状態_削除.equals(画面状態)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).parameter(状態_削除);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者情報に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_Modoru(JigyoshaServiceDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RealInitialLocker.release(前排他ロックキー);
            RString 画面状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
            if (状態_追加.equals(画面状態)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).parameter(状態_追加);
            } else if (状態_修正.equals(画面状態)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).parameter(状態_修正);
            } else if (状態_削除.equals(画面状態)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).parameter(状態_削除);
            }
        }
        return ResponseData.of(div).respond();
    }

    private boolean click_hai(JigyoshaServiceDiv div) {
        RString 画面状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
        if (状態_追加.equals(画面状態)) {
            KaigoJigyoshaShiteiService business = new KaigoJigyoshaShiteiService(new JigyoshaNo(div.getJigyoshaServiceKihon()
                    .getJigyosha().getTxtJigyoshaNo().getValue()),
                    new ServiceShuruiCode(div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey()),
                    div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue());
            business = getHandler(div).set事業者サービスDiv(business);
            データ更新チェック(div);
            return getService().insertJigyoshaServiceJoho(business);
        } else if (状態_修正.equals(画面状態)) {
            データ更新チェック(div);
            return データ更新(div);
        } else if (状態_削除.equals(画面状態)) {
            return getService_Delete().情報を物理削除(ViewStateHolder.get(ViewStateKeys.サービス情報, KaigoJigyoshaShiteiService.class));
        }
        return false;
    }

    private boolean データ更新(JigyoshaServiceDiv div) {
        KaigoJigyoshaShiteiService business = ViewStateHolder.get(ViewStateKeys.サービス情報, KaigoJigyoshaShiteiService.class);
        KaigoJigyoshaShiteiService businessUpdate;
        if (div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue().equals(business.get有効開始日())) {
            businessUpdate = getHandler(div).set事業者サービスDiv(business);
        } else {
            KaigoJigyoshaShiteiService 更新データ = new KaigoJigyoshaShiteiService(new JigyoshaNo(div.getJigyoshaServiceKihon()
                    .getJigyosha().getTxtJigyoshaNo().getValue()),
                    new ServiceShuruiCode(div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey()),
                    div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue());
            businessUpdate = getHandler(div).set事業者サービスDiv(更新データ);
        }
        return getService().updateJigyoshaServiceJoho(business, businessUpdate);
    }

    private void データ更新チェック(JigyoshaServiceDiv div) {
        FlexibleDate yukoKaishiYMD = div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue();
        FlexibleDate yukoShuryoYMD = div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue();
        KaigoJogaiTokureiParameter 合理性パラメータ
                = KaigoJogaiTokureiParameter.createParam(RString.EMPTY, yukoKaishiYMD, yukoShuryoYMD, null);
        if (!getService().checkKikanGorisei(合理性パラメータ)) {
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
        KaigoJogaiTokureiParameter サービス一覧パラメータ = KaigoJogaiTokureiParameter.createParam(
                ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class),
                ViewStateHolder.get(ViewStateKeys.有効開始日, FlexibleDate.class),
                FlexibleDate.EMPTY, RDate.getNowDate().getYearMonth());
        List<ServiceItiranHyojiJohoBusiness> サービス一覧表示情報List = getService().getServiceItiranHyojiJoho(サービス一覧パラメータ).records();
        List<ServiceJohoBusiness> businessList = new ArrayList<>();
        for (ServiceItiranHyojiJohoBusiness johoBusiness : サービス一覧表示情報List) {
            ServiceJohoBusiness serviceJohoBusiness = new ServiceJohoBusiness(johoBusiness.get有効開始日(), johoBusiness.get有効終了日(), johoBusiness.getサービス種類略称());
            businessList.add(serviceJohoBusiness);
        }
        getService().サービスと事業者期間関連のチェック(businessList, yukoKaishiYMD, yukoShuryoYMD);
    }

    private JigyoshaServiceHandler getHandler(JigyoshaServiceDiv div) {
        return new JigyoshaServiceHandler(div);
    }

    private List<KaigoJigyoshaShiteiService> get事業者サービス情報取得() {
        KaigoJigyoshaShisetsuKanriMapperParameter param = KaigoJigyoshaShisetsuKanriMapperParameter.createParam(ViewStateHolder
                .get(ViewStateKeys.事業者番号, RString.class),
                ViewStateHolder
                .get(ViewStateKeys.有効開始日, FlexibleDate.class),
                null,
                ViewStateHolder
                .get(ViewStateKeys.サービス種類コード, RString.class),
                null);
        List<KaigoJigyoshaShiteiService> service = KaigoJigyoshaShisetsuKanriManager.createInstance().getJigyoshaServiceJoho(param).records();
        if (!service.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.サービス情報, service.get(0));
        }
        return service;
    }

    private KaigoJigyoshaShisetsuKanriManager getService() {
        return KaigoJigyoshaShisetsuKanriManager.createInstance();
    }

    private JigyoshaServiceManager getService_Delete() {
        return JigyoshaServiceManager.createInstance();
    }

    private enum JigyoshaErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private JigyoshaErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
