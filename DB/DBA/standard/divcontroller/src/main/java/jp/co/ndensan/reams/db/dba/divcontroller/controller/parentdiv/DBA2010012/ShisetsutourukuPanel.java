/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010012;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012.DBA2010012StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012.DBA2010012TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010012.ShisetsutourukuPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010012.ShisetsutourukuPanelHandler;
import jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri.KaigoJigyoshaShisetsuKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 施設登録のクラスです。
 *
 * @reamsid_L DBA-0340-040 wanghui
 */
public class ShisetsutourukuPanel {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 照会 = new RString("照会");
    private final KaigoJigyoshaShisetsuKanriManager manager;
    private static final LockingKey LOCKINGKEY = new LockingKey(new RString("KaigoShisetsuToroku"));

    /**
     * コンストラクタです。
     */
    public ShisetsutourukuPanel() {
        manager = KaigoJigyoshaShisetsuKanriManager.createInstance();
    }

    /**
     * 初期化の設定します。
     *
     * @param div ShisetsutourukuPanel
     * @return ResponseData<ShisetsutourukuPanel>
     */
    public ResponseData<ShisetsutourukuPanelDiv> onLoad(ShisetsutourukuPanelDiv div) {
        RString 介護事業者_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        if (介護事業者_状態 == null || 追加.equals(介護事業者_状態)) {
            getHandler(div).追加_状態();
            return ResponseData.of(div).setState(DBA2010012StateName.追加状態);
        } else if (修正.equals(介護事業者_状態)) {
            List<KaigoJogaiTokureiTaishoShisetsu> list = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter()).records();
            getHandler(div).修正_状態(list);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010012StateName.修正状態);
        } else if (削除.equals(介護事業者_状態)) {
            List<KaigoJogaiTokureiTaishoShisetsu> list = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter()).records();
            getHandler(div).削除_状態(list);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010012StateName.削除状態);
        } else if (照会.equals(介護事業者_状態)) {
            List<KaigoJogaiTokureiTaishoShisetsu> list = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter()).records();
            getHandler(div).削除_状態(list);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010012StateName.照会状態);
        }
        if (!RealInitialLocker.tryGetLock(LOCKINGKEY)) {
            div.setReadOnly(true);
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            validationMessages.add(new ValidationMessageControlPair(ShisetsutourukuPanelErrorMessage.排他_他のユーザが使用中));
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 事業者種類の変更した時。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> onChange_ServiceShurui(ShisetsutourukuPanelDiv div) {
        getHandler(div).set事業者種類();
        return ResponseData.of(div).respond();
    }

    /**
     * 施設情報を保存する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> onClick_HoZonn(ShisetsutourukuPanelDiv div) {
        if (ViewStateHolder.get(ViewStateKeys.状態, RString.class) == null || 追加.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                事業者情報の追加処理(div);
                RealInitialLocker.release(LOCKINGKEY);
                return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
            }
        }
        if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の修正処理(div);
                RealInitialLocker.release(LOCKINGKEY);
                return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
            }
        }
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の削除処理(div);
                RealInitialLocker.release(LOCKINGKEY);
                return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンを押下する。
     *
     * @param div ShisetsutourukuPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsutourukuPanelDiv> onClick_Search(ShisetsutourukuPanelDiv div) {
        // 編集有無フラグ
        boolean changeflag = false;
        KaigoJogaiTokureiTaishoShisetsu business = ViewStateHolder.get(
                ViewStateKeys.サービス情報, KaigoJogaiTokureiTaishoShisetsu.class);
        // 事業者種類
        if (!div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey()
                .equals(business.get事業者種別())) {
            changeflag = true;
        // 有効開始日
        } else if (!div.getShisetsuJoho().getTxtShisetsuYukoKaishiYMD().getValue().isEmpty()
                && !business.get有効開始年月日().isEmpty()
                && div.getShisetsuJoho().getTxtShisetsuYukoKaishiYMD().getValue().compareTo(
                        business.get有効開始年月日()) != 0) {
            changeflag = true;
        } else if (!div.getShisetsuJoho().getTxtShisetsuYukoKaishiYMD().getValue().isEmpty()
                && business.get有効開始年月日().isEmpty()) {
            changeflag = true;
        } else if (div.getShisetsuJoho().getTxtShisetsuYukoKaishiYMD().getValue().isEmpty()
                && !business.get有効開始年月日().isEmpty()) {
            changeflag = true;
        // 有効終了日
        } else if (!div.getShisetsuJoho().getTxtShisetsuYukoShuryoYMD().getValue().isEmpty()
                && !business.get有効終了年月日().isEmpty()
                && div.getShisetsuJoho().getTxtShisetsuYukoShuryoYMD().getValue().compareTo(
                        business.get有効終了年月日()) != 0) {
            changeflag = true;
        } else if (!div.getShisetsuJoho().getTxtShisetsuYukoShuryoYMD().getValue().isEmpty()
                && business.get有効終了年月日().isEmpty()) {
            changeflag = true;
        } else if (div.getShisetsuJoho().getTxtShisetsuYukoShuryoYMD().getValue().isEmpty()
                && !business.get有効終了年月日().isEmpty()) {
            changeflag = true;
        // 管内・管外区分
        } else if (!div.getShisetsuJoho().getRadShisetsuKannaiKangaiKubun().getSelectedKey()
                .equals(business.get管内_管外区分())) {
            changeflag = true;
        // 事業者番号
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoshaNo().getText()
                .equals(business.get事業者番号())) {
            changeflag = true;
        // 事業者名
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoshaName().getText().toString()
                .equals(business.get事業者名称().toString())) {
            changeflag = true;
        // 事業者名(ｶﾅ)
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoshaNameKana().getText().toString()
                .equals(business.get事業者名称カナ().toString())) {
            changeflag = true;
        // 事業開始日
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoKaishiYMD().getValue().isEmpty()
                && !business.get事業開始年月日().isEmpty()
                && div.getShisetsuJoho().getTxtShisetsuJigyoKaishiYMD().getValue().compareTo(
                        business.get事業開始年月日()) != 0) {
            changeflag = true;
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoKaishiYMD().getValue().isEmpty()
                && business.get事業開始年月日().isEmpty()) {
            changeflag = true;
        } else if (div.getShisetsuJoho().getTxtShisetsuJigyoKaishiYMD().getValue().isEmpty()
                && !business.get事業開始年月日().isEmpty()) {
            changeflag = true;
        // 事業休止日
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoKyushuYMD().getValue().isEmpty()
                && !business.get事業休止年月日().isEmpty()
                && div.getShisetsuJoho().getTxtShisetsuJigyoKyushuYMD().getValue().compareTo(
                        business.get事業休止年月日()) != 0) {
            changeflag = true;
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoKyushuYMD().getValue().isEmpty()
                && business.get事業休止年月日().isEmpty()) {
            changeflag = true;
        } else if (div.getShisetsuJoho().getTxtShisetsuJigyoKyushuYMD().getValue().isEmpty()
                && !business.get事業休止年月日().isEmpty()) {
            changeflag = true;
        // 事業再開日
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoSaikaiYMD().getValue().isEmpty()
                && !business.get事業再開年月日().isEmpty()
                && div.getShisetsuJoho().getTxtShisetsuJigyoSaikaiYMD().getValue().compareTo(
                        business.get事業再開年月日()) != 0) {
            changeflag = true;
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoSaikaiYMD().getValue().isEmpty()
                && business.get事業再開年月日().isEmpty()) {
            changeflag = true;
        } else if (div.getShisetsuJoho().getTxtShisetsuJigyoSaikaiYMD().getValue().isEmpty()
                && !business.get事業再開年月日().isEmpty()) {
            changeflag = true;
        // 事業廃止日
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoHaishiYMD().getValue().isEmpty()
                && !business.get事業廃止年月日().isEmpty()
                && div.getShisetsuJoho().getTxtShisetsuJigyoHaishiYMD().getValue().compareTo(
                        business.get事業廃止年月日()) != 0) {
            changeflag = true;
        } else if (!div.getShisetsuJoho().getTxtShisetsuJigyoHaishiYMD().getValue().isEmpty()
                && business.get事業廃止年月日().isEmpty()) {
            changeflag = true;
        } else if (div.getShisetsuJoho().getTxtShisetsuJigyoHaishiYMD().getValue().isEmpty()
                && !business.get事業廃止年月日().isEmpty()) {
            changeflag = true;
        // 郵便番号
        } else if (!div.getShisetsuJoho().getTxtShisetsuYubinNo().getText().toString()
                .equals(business.get郵便番号().toString())) {
            changeflag = true;
        // 電話番号
        } else if (!div.getShisetsuJoho().getTxtShisetsuTelNo().getText().toString()
                .equals(business.get電話番号().toString())) {
            changeflag = true;
        // FAX番号
        } else if (!div.getShisetsuJoho().getTxtShisetsuFaxNo().getText().toString()
                .equals(business.getFAX番号().toString())) {
            changeflag = true;
        // 住所
        } else if (!div.getShisetsuJoho().getTxtShisetsuJusho().getText().toString()
                .equals(business.get事業者住所().toString())) {
            changeflag = true;
        // 住所(ｶﾅ)
        } else if (!div.getShisetsuJoho().getTxtShisetsuJushoKana().getText().toString()
                .equals(business.get事業者住所カナ().toString())) {
            changeflag = true;
        // 代表者名
        } else if (!div.getShisetsuJoho().getTxtShisetsuDaihyoshaName().getText().toString()
                .equals(business.get代表者名称().toString())) {
            changeflag = true;
        // 代表者名(ｶﾅ)
        } else if (!div.getShisetsuJoho().getTxtShisetsuDaihyoshaNameKana().getText().toString()
                .equals(business.get代表者名称カナ().toString())) {
            changeflag = true;
        // 役職
        } else if (!div.getShisetsuJoho().getTxtShisetsuYakushoku().getText().toString()
                .equals(business.get役職().toString())) {
            changeflag = true;
        // 備考
        } else if (!div.getShisetsuJoho().getTxtShisetsuBiko().getText().toString()
                .equals(business.get備考().toString())) {
            changeflag = true;
        }
        
        if (changeflag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RealInitialLocker.release(LOCKINGKEY);
                return ResponseData.of(div).forwardWithEventName(DBA2010012TransitionEventName.再検索).respond();
            }
        } else {
            RealInitialLocker.release(LOCKINGKEY);
            return ResponseData.of(div).forwardWithEventName(DBA2010012TransitionEventName.再検索).respond();
        }

        return ResponseData.of(div).respond();
    }

    private ShisetsutourukuPanelHandler getHandler(ShisetsutourukuPanelDiv div) {
        return new ShisetsutourukuPanelHandler(div);
    }

    private ResponseData<ShisetsutourukuPanelDiv> 事業者情報の追加処理(ShisetsutourukuPanelDiv div) {
        if (manager.施設情報存在チェック(div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(),
                div.getTxtShisetsuJigyoshaNo().getValue(),
                div.getTxtShisetsuYukoKaishiYMD().getValue())) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("事業者番号が介護除外住所地特例対象施設テーブルに存在する"));
        }
        有効期間合理性チェック(div);
        KaigoJogaiTokureiTaishoShisetsu business = new KaigoJogaiTokureiTaishoShisetsu(div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(),
                div.getTxtShisetsuJigyoshaNo().getValue(),
                div.getTxtShisetsuYukoKaishiYMD().getValue());
        KaigoJogaiTokureiTaishoShisetsuBuilder builde = business.createBuilderForEdit();
        builde.set有効開始年月日(div.getTxtShisetsuYukoKaishiYMD().getValue());
        builde.set有効終了年月日(div.getTxtShisetsuYukoShuryoYMD().getValue());
        builde.set管内_管外区分(div.getRadShisetsuKannaiKangaiKubun().getSelectedKey());
        builde.set事業者番号(div.getTxtShisetsuJigyoshaNo().getValue());
        builde.set事業者名称(new AtenaMeisho(div.getTxtShisetsuJigyoshaName().getValue()));
        builde.set事業者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuJigyoshaNameKana().getValue()));
        builde.set事業開始年月日(div.getTxtShisetsuJigyoKaishiYMD().getValue());
        builde.set事業休止年月日(div.getTxtShisetsuJigyoKyushuYMD().getValue());
        builde.set事業再開年月日(div.getTxtShisetsuJigyoSaikaiYMD().getValue());
        builde.set事業廃止年月日(div.getTxtShisetsuJigyoHaishiYMD().getValue());
        builde.set郵便番号(div.getTxtShisetsuYubinNo().getValue());
        builde.set電話番号(new TelNo(div.getTxtShisetsuTelNo().getValue()));
        builde.setFax番号(new TelNo(div.getTxtShisetsuFaxNo().getValue()));
        builde.set事業者住所(div.getTxtShisetsuJusho().getValue());
        builde.set事業者住所カナ(div.getTxtShisetsuJushoKana().getValue());
        builde.set代表者名称(new AtenaMeisho(div.getTxtShisetsuDaihyoshaName().getValue()));
        builde.set代表者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuDaihyoshaNameKana().getValue()));
        builde.set役職(div.getTxtShisetsuYakushoku().getValue());
        builde.set備考(div.getTxtShisetsuBiko().getValue());
        builde.set異動事由(new RString("01"));
        builde.set異動年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
        business = builde.build();
        manager.insertJigyoshaJoho(null, div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(), business);
        div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                .replace("追加").evaluate()),
                RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の修正処理(ShisetsutourukuPanelDiv div) {
        有効期間合理性チェック(div);
        KaigoJogaiTokureiTaishoShisetsu 旧事業者情報
                = ViewStateHolder.get(ViewStateKeys.サービス情報, KaigoJogaiTokureiTaishoShisetsu.class);
        KaigoJogaiTokureiTaishoShisetsu 事業者情報;
        if (旧事業者情報.get有効開始年月日().equals(div.getTxtShisetsuYukoKaishiYMD().getValue())) {
            事業者情報 = 旧事業者情報;
        } else {
            事業者情報 = new KaigoJogaiTokureiTaishoShisetsu(div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(),
                    div.getTxtShisetsuJigyoshaNo().getValue(),
                    div.getTxtShisetsuYukoKaishiYMD().getValue());
        }
        KaigoJogaiTokureiTaishoShisetsuBuilder builde = 事業者情報.createBuilderForEdit();
        builde.set有効開始年月日(div.getTxtShisetsuYukoKaishiYMD().getValue());
        builde.set有効終了年月日(div.getTxtShisetsuYukoShuryoYMD().getValue());
        builde.set管内_管外区分(div.getRadShisetsuKannaiKangaiKubun().getSelectedKey());
        builde.set事業者番号(div.getTxtShisetsuJigyoshaNo().getValue());
        builde.set事業者名称(new AtenaMeisho(div.getTxtShisetsuJigyoshaName().getValue()));
        builde.set事業者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuJigyoshaNameKana().getValue()));
        builde.set事業開始年月日(div.getTxtShisetsuJigyoKaishiYMD().getValue());
        builde.set事業休止年月日(div.getTxtShisetsuJigyoKyushuYMD().getValue());
        builde.set事業再開年月日(div.getTxtShisetsuJigyoSaikaiYMD().getValue());
        builde.set事業廃止年月日(div.getTxtShisetsuJigyoHaishiYMD().getValue());
        builde.set郵便番号(div.getTxtShisetsuYubinNo().getValue());
        builde.set電話番号(new TelNo(div.getTxtShisetsuTelNo().getValue()));
        builde.setFax番号(new TelNo(div.getTxtShisetsuFaxNo().getValue()));
        builde.set事業者住所(div.getTxtShisetsuJusho().getValue());
        builde.set事業者住所カナ(div.getTxtShisetsuJushoKana().getValue());
        builde.set代表者名称(new AtenaMeisho(div.getTxtShisetsuDaihyoshaName().getValue()));
        builde.set代表者名称カナ(new AtenaKanaMeisho(div.getTxtShisetsuDaihyoshaNameKana().getValue()));
        builde.set役職(div.getTxtShisetsuYakushoku().getValue());
        builde.set備考(div.getTxtShisetsuBiko().getValue());
        事業者情報 = builde.build();
        manager.insertJigyoshaJoho(null, div.getJigyoshaShurui().getRadServiceShurui().getSelectedKey(), 事業者情報);
        div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                .replace("修正").evaluate()),
                RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の削除処理(ShisetsutourukuPanelDiv div) {
        KaigoJogaiTokureiTaishoShisetsu 事業者情報
                = ViewStateHolder.get(ViewStateKeys.サービス情報, KaigoJogaiTokureiTaishoShisetsu.class);
        事業者情報.toEntity().setState(EntityDataState.Deleted);
        事業者情報 = 事業者情報.deleted();
        manager.saveOrDelete(事業者情報);
        div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                .replace("削除").evaluate()),
                RString.EMPTY, RString.EMPTY, true);

        return ResponseData.of(div).setState(DBA2010012StateName.完了状態);
    }

    private void 有効期間合理性チェック(ShisetsutourukuPanelDiv div) {
        JigyoshaMode mode = ViewStateHolder.get(ViewStateKeys.介護事業者情報, JigyoshaMode.class);
        if (mode != null) {
            KaigoJigyoshaParameter paramter = KaigoJigyoshaParameter
                    .createParam(mode.getJigyoshaNo() == null ? RString.EMPTY : mode.getJigyoshaNo().value(),
                            mode.getJigyoshaShubetsu(),
                            div.getTxtShisetsuYukoKaishiYMD().getValue(),
                            div.getTxtShisetsuYukoShuryoYMD().getValue());
            if (manager.checkKikanJufuku(paramter, new FlexibleDate(mode.getYukoKaishiYMD()))) {
                throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
            }
        }
        KaigoJogaiTokureiParameter 重複paramter = KaigoJogaiTokureiParameter
                .createParam(RString.EMPTY,
                        div.getTxtShisetsuYukoKaishiYMD().getValue(),
                        div.getTxtShisetsuYukoShuryoYMD().getValue(),
                        null);
        if (!manager.checkKikanGorisei(重複paramter)) {
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }

    }

    private KaigoJigyoshaParameter 事業者情報取得paramter() {
        JigyoshaMode mode = ViewStateHolder.get(ViewStateKeys.介護事業者情報, JigyoshaMode.class);
        return KaigoJigyoshaParameter.createParam(mode.getJigyoshaNo() == null ? RString.EMPTY : mode.getJigyoshaNo().value(),
                ViewStateHolder.get(ViewStateKeys.事業者種別, RString.class),
                new FlexibleDate(mode.getYukoKaishiYMD()),
                FlexibleDate.EMPTY);
    }

    private ResponseData<ShisetsutourukuPanelDiv> get事業者情報の検索処理(ShisetsutourukuPanelDiv div) {
        List<KaigoJogaiTokureiTaishoShisetsu> 事業者登録情報List = manager.selectByKoseiShichosonMasterList(事業者情報取得paramter()).records();
        KaigoJogaiTokureiTaishoShisetsu business = null;
        if (!事業者登録情報List.isEmpty()) {
            business = 事業者登録情報List.get(0);
        }
        ViewStateHolder.put(ViewStateKeys.サービス情報, business);
        ViewStateHolder.put(ViewStateKeys.有効開始日, div.getTxtShisetsuYukoKaishiYMD().getValue());
        return ResponseData.of(div).respond();
    }

    private enum ShisetsutourukuPanelErrorMessage implements IValidationMessage {

        排他_他のユーザが使用中(UrErrorMessages.排他_他のユーザが使用中);
        private final Message message;

        private ShisetsutourukuPanelErrorMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
