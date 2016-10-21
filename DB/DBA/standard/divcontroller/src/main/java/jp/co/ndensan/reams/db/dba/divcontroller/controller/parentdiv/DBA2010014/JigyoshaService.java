/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010014;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dba.business.core.jigyoshaservice.JigyoshaServiceJoho;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.DBA2010014StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.DBA2010014TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.JigyoshaServiceDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010014.JigyoshaServiceHandler;
import jp.co.ndensan.reams.db.dba.service.core.jigyoshaservice.JigyoshaServiceManager;
import jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri.KaigoJigyoshaShisetsuKanriManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
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
//CHECKSTYLE IGNORE ImportControl FOR NEXT 2 LINES
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.uz.uza.util.Models;

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
    private static final int 登録保険者番号_6桁 = 6;
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
        if (状態_追加.equals(画面状態)) {
            KaigoJigyosha 事業者登録情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報_事業者サービス引継, KaigoJigyosha.class);
            getHandler(div).set状態_追加(事業者登録情報);
            List<RString> chkKihonJunkyoFlag = new ArrayList<>();
            chkKihonJunkyoFlag.add(new RString("0"));
            div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().setSelectedItemsByKey(chkKihonJunkyoFlag);
            getHandler(div).set追加情報(div);
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
        if (状態_追加.equals(画面状態)) {
            KaigoJigyosha 事業者登録情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報_事業者サービス引継, KaigoJigyosha.class);
            if (!div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().isEmpty()) {
                getHandler(div).set状態_追加(事業者登録情報);
            } else {
                div.getJigyoshaServiceKihon().getJigyosha().setDisabled(false);
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setDisabled(true);
            }
            return ResponseData.of(div).setState(DBA2010014StateName.追加状態);
        } else {
            if (!div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().isEmpty()) {
                List<KaigoJigyoshaShiteiService> johoList = get事業者サービス情報取得();
                getHandler(div).onChange_ChkKihonJunkyoFlag(johoList);
            } else {
                div.getJigyoshaServiceKihon().getJigyosha().setDisabled(false);
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setDisabled(true);
            }
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
        if (!div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue().isNullOrEmpty()
                && div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue().length() != 登録保険者番号_6桁) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(JigyoshaErrorMessage.桁数が不正));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        set登録保険者名称(div);
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
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD()));
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確定の確認.getMessage().getCode(),
                    UrQuestionMessages.確定の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RealInitialLocker.release(前排他ロックキー);

            set更新データ(div, create事業者サービスFor入力内容(div));

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

    private void set更新データ(JigyoshaServiceDiv div, KaigoJigyoshaShiteiService newService) {

        Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> models = ViewStateHolder.get(ViewStateKeys.サービス一覧情報, Models.class);
        if (models == null) {
            models = Models.create(new ArrayList<KaigoJigyoshaShiteiService>());
        }
        KaigoJigyoshaShiteiService stateChangeNewService = newService;
        KaigoJigyoshaShiteiService motoData = models.get(new KaigoJigyoshaShiteiServiceIdentifier(newService.get事業者番号(),
                newService.getサービス種類コード(), newService.get有効開始日()));

        RString 画面状態 = ViewStateHolder.get(ViewStateKeys.画面状態, RString.class);
        if (状態_追加.equals(画面状態)) {
            if (models.contains(stateChangeNewService.identifier())) {
                throw new ApplicationException(UrErrorMessages.既に存在.getMessage().replace("追加するサービス"));
            }
            models.add(stateChangeNewService);
        } else if (状態_修正.equals(画面状態)) {
            stateChangeNewService = getHandler(div).set事業者サービスDiv(motoData);
            stateChangeNewService = stateChangeNewService.modifiedModel();
            models.add(stateChangeNewService);
        } else if (状態_削除.equals(画面状態)) {
            if (motoData.isAdded()) {
                models.deleteOrRemove(motoData.identifier());
            } else {
                stateChangeNewService = motoData.deleted();
                models.add(stateChangeNewService);
            }
        }

        ViewStateHolder.put(ViewStateKeys.サービス一覧情報, models);
    }

    private KaigoJigyoshaShiteiService create事業者サービスFor入力内容(JigyoshaServiceDiv div) {
        KaigoJigyoshaShiteiService business = new KaigoJigyoshaShiteiService(new JigyoshaNo(div.getJigyoshaServiceKihon()
                .getJigyosha().getTxtJigyoshaNo().getValue()),
                new ServiceShuruiCode(div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey()),
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue());
        business = getHandler(div).set事業者サービスDiv(business);
        データ更新チェック(div);
        return business;
    }

    private void データ更新チェック(JigyoshaServiceDiv div) {
        FlexibleDate yukoKaishiYMD = div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue();
        FlexibleDate yukoShuryoYMD = div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue();
        KaigoJogaiTokureiParameter 合理性パラメータ
                = KaigoJogaiTokureiParameter.createParam(RString.EMPTY, yukoKaishiYMD, yukoShuryoYMD, null);
        if (!getService().checkKikanGorisei(合理性パラメータ)) {
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
    }

    /**
     * 事業者情報に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_Modoru(JigyoshaServiceDiv div) {
        DbT7063KaigoJigyoshaShiteiServiceEntity beforeDiv = ViewStateHolder.get(ViewStateKeys.モード, DbT7063KaigoJigyoshaShiteiServiceEntity.class);
        DbT7063KaigoJigyoshaShiteiServiceEntity currentDiv = getHandler(div).toEntity();

        boolean changeFlg = Objects.equals(beforeDiv, currentDiv);

        if (!ResponseHolder.isReRequest() && changeFlg) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes || !changeFlg) {
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

    private JigyoshaServiceHandler getHandler(JigyoshaServiceDiv div) {
        return new JigyoshaServiceHandler(div);
    }

    private List<KaigoJigyoshaShiteiService> get事業者サービス情報取得() {
        JigyoshaNo jigyoshaNo = new JigyoshaNo(ViewStateHolder.get(ViewStateKeys.事業者番号, RString.class));
        ServiceShuruiCode serviceShuruiCode = new ServiceShuruiCode(ViewStateHolder.get(ViewStateKeys.サービス種類コード, RString.class));
        FlexibleDate yukoKaishiDate = ViewStateHolder.get(ViewStateKeys.有効開始日, FlexibleDate.class);

        Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> models = ViewStateHolder.get(ViewStateKeys.サービス一覧情報, Models.class);
        if (models == null) {
            models = Models.create(new ArrayList<KaigoJigyoshaShiteiService>());
        }
        KaigoJigyoshaShiteiService サービス情報 = models.get(new KaigoJigyoshaShiteiServiceIdentifier(jigyoshaNo, serviceShuruiCode, yukoKaishiDate));
        List<KaigoJigyoshaShiteiService> service = new ArrayList<>();
        if (サービス情報 != null) {
            ViewStateHolder.put(ViewStateKeys.サービス情報, サービス情報);
            service.add(サービス情報);
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

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中),
        桁数が不正(UrErrorMessages.桁数が不正, "登録保険者番号", "６");
        private final Message message;

        private JigyoshaErrorMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
