/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010014;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 画面サービス登録のクラスです。
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaService {
    
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    
    /**
     * 画面の初期化処理です。
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onLoad(JigyoshaServiceDiv div) {
        RString 画面状態 = ViewStateHolder.get(ViewStateKeys.サービス登録_画面状態, RString.class);
        if (状態_追加.equals(画面状態)) {
            getHandler(div).set状態_追加();
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
        // TODO 前排他制御の処理します。
        return ResponseData.of(div).respond();
    }
    
    /**
     * 詳細情報を表示します。
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_BtnInputShosai(JigyoshaServiceDiv div) {
        getHandler(div).onClick_BtnInputShosai();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 登録保険者入力ガイドボタンを押します。
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_BtnHokenshaInputGuide(JigyoshaServiceDiv div) {
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().setValue(div.getHokenshaNo());
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setValue(div.getHokenshaMeisho());
        return ResponseData.of(div).respond();
    }
    
    /**
     * 基本情報を表示します。
     * @param div 画面情報
     * @return ResponseData<JigyoshaServiceDiv>
     */
    public ResponseData<JigyoshaServiceDiv> onClick_BtnInputKihon(JigyoshaServiceDiv div) {
        getHandler(div).onClick_BtnInputKihon();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 事業者サービスを保存します。
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
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (click_hai(div)) {
                return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).respond();
            }
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 事業者情報に戻るを押します。
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
            return ResponseData.of(div).forwardWithEventName(DBA2010014TransitionEventName.再検索する).respond();
        }
        return ResponseData.of(div).respond();
    }
    
    private boolean click_hai(JigyoshaServiceDiv div) {
        RString 画面状態 = ViewStateHolder.get(ViewStateKeys.サービス登録_画面状態, RString.class);
        if (状態_追加.equals(画面状態)) {
            KaigoJigyoshaShiteiService business = new KaigoJigyoshaShiteiService(new JigyoshaNo(div.getJigyoshaServiceKihon()
                    .getJigyosha().getTxtJigyoshaNo().getValue()),
                    new ServiceShuruiCode(div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey()), 
                    div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue());
            business = getHandler(div).set事業者サービスDiv(business);
            if (データ更新チェック(div)) {
                return getService().insertJigyoshaServiceJoho(business);
            }
        } else if (状態_修正.equals(画面状態)) {
            // TODO 内部QA：1038
            if (データ更新チェック(div)) {
                return データ更新(div);
            }
        } else if (状態_削除.equals(画面状態)) {
            return getService_Delete().情報を物理削除(ViewStateHolder.get(ViewStateKeys.サービス登録_サービス情報, KaigoJigyoshaShiteiService.class));
        }
        return false;
    }
    
    private boolean データ更新(JigyoshaServiceDiv div) {
        KaigoJigyoshaShiteiService business = ViewStateHolder.get(ViewStateKeys.サービス登録_サービス情報, KaigoJigyoshaShiteiService.class);
        if (!div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue().equals(business.get有効開始日())) {
            KaigoJigyoshaShiteiService 更新データ = new KaigoJigyoshaShiteiService(new JigyoshaNo(div.getJigyoshaServiceKihon()
            .getJigyosha().getTxtJigyoshaNo().getValue()),
            new ServiceShuruiCode(div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey()), 
            div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue());
            更新データ = getHandler(div).set事業者サービスDiv(更新データ);
            return getService().insertJigyoshaServiceJoho(更新データ);
        } else {
            business = getHandler(div).set事業者サービスDiv(business);
            return getService().updateJigyoshaServiceJoho(business, new RString("2"));
        }
    }
    
    private boolean データ更新チェック(JigyoshaServiceDiv div) {
        KaigoJigyoshaParameter 重複パラメータ = KaigoJigyoshaParameter.createParam(div.getJigyoshaServiceKihon().getJigyosha()
                .getTxtJigyoshaNo().getValue(),
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue(),
                div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey(),
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue());
        if (getService().checkKikanJufuku(重複パラメータ)) {
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
        KaigoJogaiTokureiParameter 合理性パラメータ = KaigoJogaiTokureiParameter.createParam(RString.EMPTY,
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue(),
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue());
        if (!getService().checkKikanGorisei(合理性パラメータ)) {
            throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
        }
        return true;
    }
    
    private JigyoshaServiceHandler getHandler(JigyoshaServiceDiv div) {
        return new JigyoshaServiceHandler(div);
    }
    
    private List<KaigoJigyoshaShiteiService> get事業者サービス情報取得() {
        KaigoJigyoshaShisetsuKanriMapperParameter param = KaigoJigyoshaShisetsuKanriMapperParameter.createParam(ViewStateHolder
                .get(ViewStateKeys.サービス登録_事業者番号, RString.class),
                ViewStateHolder
                .get(ViewStateKeys.サービス登録_有効開始日, FlexibleDate.class),
                null,
                ViewStateHolder
                .get(ViewStateKeys.サービス登録_サービス種類コード, RString.class),
                null);
        List<KaigoJigyoshaShiteiService> service = KaigoJigyoshaShisetsuKanriManager.createInstance().getJigyoshaServiceJoho(param).records();
        if (!service.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.サービス登録_サービス情報, service.get(0));
        }
        return service;
    }
    
    private KaigoJigyoshaShisetsuKanriManager getService() {
        return KaigoJigyoshaShisetsuKanriManager.createInstance();
    }
    
    private JigyoshaServiceManager getService_Delete() {
        return JigyoshaServiceManager.createInstance();
    }
    
}
