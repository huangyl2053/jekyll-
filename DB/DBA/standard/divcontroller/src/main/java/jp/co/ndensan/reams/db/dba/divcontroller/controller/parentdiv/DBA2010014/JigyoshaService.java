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
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
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
        if (状態_追加.equals(画面状態)) {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 事業者登録情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
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
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 事業者登録情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);
            if(!div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().isEmpty()){
                 getHandler(div).set状態_追加(事業者登録情報);
            }else{
                div.getJigyoshaServiceKihon().getJigyosha().setDisabled(false);
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setDisabled(true);
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
        boolean changeFlg = false;
        DbT7063KaigoJigyoshaShiteiServiceEntity beforeDiv = ViewStateHolder.get(ViewStateKeys.モード, DbT7063KaigoJigyoshaShiteiServiceEntity.class);
        if(
                    (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().getValue().equals(beforeDiv.getJigyoshaNo().value()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().getValue().equals(beforeDiv.getJigyoshaNo().value()))
                    || (!div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().getSelectedKey().equals(beforeDiv.getServiceShuruiCode().value()))
                    ||  ((div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue().isEmpty() && !beforeDiv.getYukoKaishiYMD().isEmpty())
                            || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue().isEmpty() && beforeDiv.getYukoKaishiYMD().isEmpty())
                            || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue().isEmpty() && !beforeDiv.getYukoKaishiYMD().isEmpty()
                                && div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().getValue().compareTo(beforeDiv.getYukoKaishiYMD()) !=0))
                    ||  ((div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue().isEmpty() && !beforeDiv.getYukoShuryoYMD().isEmpty())
                            || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue().isEmpty() && beforeDiv.getYukoShuryoYMD().isEmpty())
                            || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue().isEmpty() && !beforeDiv.getYukoShuryoYMD().isEmpty()
                              && div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue().compareTo(beforeDiv.getYukoShuryoYMD()) !=0 ))
                    || ((!div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().isEmpty() && beforeDiv.getKihonJohoJunkyoKubun().isNullOrEmpty())
                            || (div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().isEmpty() && !beforeDiv.getKihonJohoJunkyoKubun().isNullOrEmpty()))
                    ||  ((div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().getValue().isEmpty() && !beforeDiv.getJigyoKaishiYMD().isEmpty())
                           || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().getValue().isEmpty() && beforeDiv.getJigyoKaishiYMD().isEmpty())
                           || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().getValue().isEmpty() && !beforeDiv.getJigyoKaishiYMD().isEmpty()
                                && div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().getValue().compareTo(beforeDiv.getJigyoKaishiYMD()) !=0))
                    ||  ((!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().getValue().isEmpty() && beforeDiv.getJigyoKyushiYMD().isEmpty())
                           || (div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().getValue().isEmpty() && !beforeDiv.getJigyoKyushiYMD().isEmpty())
                           || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().getValue().isEmpty() && !beforeDiv.getJigyoKyushiYMD().isEmpty()
                               && div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().getValue().compareTo(beforeDiv.getJigyoKyushiYMD()) !=0))
                    ||  ((!div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().getValue().isEmpty() && beforeDiv.getJigyoSaikaiYMD().isEmpty())
                            || (div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().getValue().isEmpty() && !beforeDiv.getJigyoSaikaiYMD().isEmpty())
                            || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().getValue().isEmpty() && !beforeDiv.getJigyoSaikaiYMD().isEmpty()
                                &&  div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().getValue().compareTo(beforeDiv.getJigyoSaikaiYMD()) !=0))
                    ||  ((!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().getValue().isEmpty() && beforeDiv.getJigyoHaishiYMD().isEmpty())
                          || (div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().getValue().isEmpty() && !beforeDiv.getJigyoHaishiYMD().isEmpty())
                          || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().getValue().isEmpty() && !beforeDiv.getJigyoHaishiYMD().isEmpty()
                               && div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().getValue().compareTo(beforeDiv.getJigyoHaishiYMD()) !=0))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaName().getValue().equals(beforeDiv.getJigyoshaName().value()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNameKana().getValue().equals(beforeDiv.getJigyoshaNameKana().value()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaYubinNo().getValue().equals(beforeDiv.getJigyoshaYubinNo()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddress().getValue().equals(beforeDiv.getJigyoshaAddress().value()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddressKana().getValue().equals(beforeDiv.getJigyoshaAddressKana()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaTelNo().getValue().equals(beforeDiv.getJigyoshaTelNo().value()))
                    || (!div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaFaxNo().getValue().equals(beforeDiv.getJigyoshaFaxNo().value()))
                    || (!div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue().equals(beforeDiv.getTorokuHokenshaNo()))
                    || (!div.getJigyoshaServiceKihon().getRadJuryoininUmu().getSelectedKey().equals(beforeDiv.getJuryoininUmu().value()))
                    ||  ((div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().getValue().isEmpty() && !beforeDiv.getTorokuKaishiYMD().isEmpty())
                        || (!div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().getValue().isEmpty() && beforeDiv.getTorokuKaishiYMD().isEmpty())
                        || (!div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().getValue().isEmpty() && !beforeDiv.getTorokuKaishiYMD().isEmpty()
                            && div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().getValue().compareTo(beforeDiv.getTorokuKaishiYMD()) !=0))
                    ||  ((!div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().getValue().isEmpty() && beforeDiv.getTorokuShuryoYMD().isEmpty())
                          || (div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().getValue().isEmpty() && !beforeDiv.getTorokuShuryoYMD().isEmpty())
                          || (!div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().getValue().isEmpty() && !beforeDiv.getTorokuShuryoYMD().isEmpty()
                              && div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().getValue().compareTo(beforeDiv.getTorokuShuryoYMD()) !=0))
                    || (!div.getJigyoshaServiceKihon().getTxtKanrishaName().getValue().equals(beforeDiv.getKanrishaName().value()))
                    || (!div.getJigyoshaServiceKihon().getTxtKanrishaNameKana().getValue().equals(beforeDiv.getKanrishaNameKana().value()))
                    || (!div.getJigyoshaServiceKihon().getTxtKanrishaYubinNo().getValue().equals(beforeDiv.getKanrishaYubinNo()))
                    || (!div.getJigyoshaServiceKihon().getTxtKanrishaAddress().getValue().equals(beforeDiv.getKanrishaAddress().value()))
                    || (!div.getJigyoshaServiceKihon().getTxtKanrishaAddressKana().getValue().equals(beforeDiv.getKanrishaAddressKana()))
                    || (!div.getJigyoshaServiceKihon().getRadShakaiFukushihoujinKeigenjigyouJisshiUumu().getSelectedKey().equals(beforeDiv.getShakaiFukushihoujinKeigenjigyouJisshi_umu().value()))
                    || (!div.getJigyoshaServiceKihon().getRadSeikatsuhogohouShiteiUmu().getSelectedKey().equals(beforeDiv.getSeikatsuhogohouShitei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlShisetsunadoKubun().getSelectedKey().equals(beforeDiv.getShisetsunadoKubun().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlJininHaichiKubun().getSelectedKey().equals(beforeDiv.getJininHaichiKubun().value()))
                    || (!div.getJigyoshaServiceShosai().getRadTokubetsuChiikiKasanUmu().getSelectedKey().equals(beforeDiv.getTokubetsuChiikiKasan_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKinkyujiHomonkaigoKasanUmu().getSelectedKey().equals(beforeDiv.getKinkyujiHomonkaigoKasan_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadTokubetsuKanriTaisei().getSelectedKey().equals(beforeDiv.getTokubetsuKanriTaisei().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKinoKunrenShidoTaiseiUmu().getSelectedKey().equals(beforeDiv.getKinoKunrenShidoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadShokujiTeikyoTaiseiUmu().getSelectedKey().equals(beforeDiv.getShokujiTeikyoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNyuyokuKaijoTaiseiUmu().getSelectedKey().equals(beforeDiv.getNyuyokuKaijoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadTokubetsuNyuyokuKaijoTaiseiUmu().getSelectedKey().equals(beforeDiv.getTokubetsuNyuyokuKaijoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJoukinsenjuIshiHaichiUmu().getSelectedKey().equals(beforeDiv.getJoukinsenjuIshiHaichi_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadIshiHaichiKijun().getSelectedKey().equals(beforeDiv.getIshiHaichiKijun().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSeisinkaIshiTeikitekiRyouyousidouUmu().getSelectedKey().equals(beforeDiv.getSeisinkaIshiTeikitekiRyouyousidou_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlYakanKinmuJokenKijun().getSelectedKey().equals(beforeDiv.getYakanKinmuJokenKijun().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNinchishouSenmontouUmu().getSelectedKey().equals(beforeDiv.getNinchishouSenmontou_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlShokujiTeikyoJokyo().getSelectedKey().equals(beforeDiv.getShokujiTeikyoJokyo().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSougeiTaisei().getSelectedKey().equals(beforeDiv.getSougeiTaisei().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSogoRehaShisetsuUmu().getSelectedKey().equals(beforeDiv.getRehaTeikyoTaisei_SogoRehaShisetsu_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRigakuRyohoIIUmu().getSelectedKey().equals(beforeDiv.getRehaTeikyoTaisei_RigakuRyohoII_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRigakuRyohoIIIUmu().getSelectedKey().equals(beforeDiv.getRehaTeikyoTaisei_RigakuRyohoIII_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSagyoRyohoIIUmu().getSelectedKey().equals(beforeDiv.getRehaTeikyoTaisei_SagyoRyohoII_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSeisinkaSagyouRyohoUmu().getSelectedKey().equals(beforeDiv.getRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSonotaUmu().getSelectedKey().equals(beforeDiv.getRehaTeikyoTaisei_Sonota_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRehabilitationKasanJokyoUmu().getSelectedKey().equals(beforeDiv.getRehabilitationKasanJokyo().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlRyoyoKankyoKijun().getSelectedKey().equals(beforeDiv.getRyoyoKankyoKijun().value()))
                    || (!div.getJigyoshaServiceShosai().getRadIshiKetuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getIshiKetuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKangoShokuinKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getKangoShokuinKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRigakuRyouhousiKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getRigakuRyouhousiKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSagyouRyouhousiKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getSagyouRyouhousiKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKaigoShokuinKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getKaigoShokuinKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKaigoJujishaKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getKaigoJujishaKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKansenTaisakuSidoKanriUmu().getSelectedKey().equals(beforeDiv.getKansenTaisakuSidoKanri_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJushoHifuKaiyouShidoKanriUmu().getSelectedKey().equals(beforeDiv.getJushoHifuKaiyouShidoKanri_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadYakuzaiKaniriShidoUmu().getSelectedKey().equals(beforeDiv.getYakuzaiKaniriShido_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadShogaishaSeikatsuShienTaiseiUmu().getSelectedKey().equals(beforeDiv.getShogaishaSeikatsuShienTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlChiikiKubun().getSelectedKey().equals(beforeDiv.getChiikiKubunCode().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJikanEnchoServiceTaisei().getSelectedKey().equals(beforeDiv.getJikanEnchoServiceTaisei().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuRehabilitationTeikyoTaisei().getSelectedKey().equals(beforeDiv.getKobetsuRehabilitationTeikyoTaisei().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKyojuhiTaisaku().getSelectedKey().equals(beforeDiv.getKyojuhiTaisaku().value()))
                    || (!div.getJigyoshaServiceShosai().getRadYakanCareUmu().getSelectedKey().equals(beforeDiv.getYakanCare_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRehabilitationKinoKyokaUmu().getSelectedKey().equals(beforeDiv.getRehabilitationKinoKyoka_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuSogoRehaShisetsuUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIIUmu1().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIIIUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuSagyoRyohoIIUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoIUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoIIUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadGengoChokakushiKetsuinGenzanJokyoUmu().getSelectedKey().equals(beforeDiv.getGengoChokakushiKetsuinGenzanJokyo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlEiyouKanriHyoka().getSelectedKey().equals(beforeDiv.getEiyouKanriHyoka().value()))
                    || (!div.getJigyoshaServiceShosai().getRadTokuteijigyoushoKasanHomonKaigoUmu().getSelectedKey().equals(beforeDiv.getTokuteijigyoushoKasan_HomonKaigo_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJakunenseiNinchishoCareTaiseiUmu().getSelectedKey().equals(beforeDiv.getJakunenseiNinchishoCareTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadUndokiKinoKojoTaiseiUmu().getSelectedKey().equals(beforeDiv.getUndokiKinoKojoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadEiyoManagementKaizenTaiseiUmu().getSelectedKey().equals(beforeDiv.getEiyoManagement_KaizenTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKokuKinoKojoTaiseiUmu().getSelectedKey().equals(beforeDiv.getKokuKinoKojoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJigyoshoHyokaKasanMoshideUmu().getSelectedKey().equals(beforeDiv.getJigyoshoHyokaKasan_Moshide_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJigyoshoHyokaKasanKetteiUmu().getSelectedKey().equals(beforeDiv.getJigyoshoHyokaKasan_Kettei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKinkyuUkeireTaiseiUmu().getSelectedKey().equals(beforeDiv.getKinkyuUkeireTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadYakanKangoTaiseiUmu().getSelectedKey().equals(beforeDiv.getYakanKangoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlTokuteijigyoshoKasanKyotakukaigoshienUmu().getSelectedKey().equals(beforeDiv.getTokuteijigyoshoKasan_Kyotakukaigoshien_umu().value()))
                    ||    ((div.getJigyoshaServiceShosai().getTxtKaigoShienSemmoninSenjuJokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtKaigoShienSemmoninSenjuJokinshaNinsu().getValue().intValue())  
                             != beforeDiv.getKaigoShienSemmoninSenjuJokinshaNinsu())
                    ||    ((div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninSenjuHijokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninSenjuHijokinshaNinsu().getValue().intValue())
                             != beforeDiv.getKaigoSienSemmoninSenjuHijokinshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninKemmuJokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninKemmuJokinshaNinsu().getValue().intValue())
                             != beforeDiv.getKaigoSienSemmoninKemmuJokinshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninKemmuHijokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninKemmuHijokinshaNinsu().getValue().intValue())
                             != beforeDiv.getKaigoSienSemmoninKemmuHijokinshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtHomonkaigoServiceTeikyoSekininshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtHomonkaigoServiceTeikyoSekininshaNinsu().getValue().intValue())
                             != beforeDiv.getHomonkaigoServiceTeikyoSekininshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtHomonkaigoSenjuJokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtHomonkaigoSenjuJokinshaNinsu().getValue().intValue())
                             != beforeDiv.getHomonkaigoSenjuJokinshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtHomonkaigoSenjuHijokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtHomonkaigoSenjuHijokinshaNinsu().getValue().intValue())
                             != beforeDiv.getHomonkaigoSenjuHijokinshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtHomonkaigoKemmuJokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtHomonkaigoKemmuJokinshaNinsu().getValue().intValue())
                             != beforeDiv.getHomonkaigoKemmuJokinshaNinsu() )
                    ||    ((div.getJigyoshaServiceShosai().getTxtHomonkaigoKemmuHijokinshaNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtHomonkaigoKemmuHijokinshaNinsu().getValue().intValue())
                             != beforeDiv.getHomonkaigoKemmuHijokinshaNinsu() )
                    ||   ((div.getJigyoshaServiceShosai().getTxtHomonkaigoJokinKanzangoNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtHomonkaigoJokinKanzangoNinsu().getValue().intValue())
                             != beforeDiv.getHomonkaigoJokinKanzangoNinsu() )
                    ||   ((div.getJigyoshaServiceShosai().getTxtRiyoTeiinNinsu().getValue() 
                                        == null ? 0 : div.getJigyoshaServiceShosai().getTxtRiyoTeiinNinsu().getValue().intValue())
                             != beforeDiv.getRiyoTeiinNinsu() )
                    ||  ((!div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD().getValue().isEmpty() && beforeDiv.getShiteiYukoKaishiYMD().isEmpty())
                         || (div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD().getValue().isEmpty() && !beforeDiv.getShiteiYukoKaishiYMD().isEmpty())
                         || (!div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD().getValue().isEmpty() && !beforeDiv.getShiteiYukoKaishiYMD().isEmpty()
                              && div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD().getValue().compareTo(beforeDiv.getShiteiYukoKaishiYMD()) !=0))
                    ||  ((!div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD().getValue().isEmpty() && beforeDiv.getShiteiYukoShuryoYMD().isEmpty())
                          || (div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD().getValue().isEmpty() && !beforeDiv.getShiteiYukoShuryoYMD().isEmpty())
                          || (!div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD().getValue().isEmpty() && !beforeDiv.getShiteiYukoShuryoYMD().isEmpty()
                              && div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD().getValue().compareTo(beforeDiv.getShiteiYukoShuryoYMD()) !=0))
                    || (!div.getJigyoshaServiceShosai().getRadShiteiKoshinShinseichuKubun().getSelectedKey().equals(beforeDiv.getShiteiKoshinShinseichuKubun().value()))
                    ||  ((!div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD().getValue().isEmpty() && beforeDiv.getKoryokuTeishiKaishiYMD().isEmpty())
                         || (div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD().getValue().isEmpty() && !beforeDiv.getKoryokuTeishiKaishiYMD().isEmpty())
                         || (!div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD().getValue().isEmpty() && !beforeDiv.getKoryokuTeishiKaishiYMD().isEmpty()
                               && div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD().getValue().compareTo(beforeDiv.getKoryokuTeishiKaishiYMD()) !=0))
                    ||  ((!div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD().getValue().isEmpty() && beforeDiv.getKoryokuTeishiShuryoYMD().isEmpty())
                         || (div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD().getValue().isEmpty() && !beforeDiv.getKoryokuTeishiShuryoYMD().isEmpty())
                         || (!div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD().getValue().isEmpty() && !beforeDiv.getKoryokuTeishiShuryoYMD().isEmpty()
                             && div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD().getValue().compareTo(beforeDiv.getKoryokuTeishiShuryoYMD()) !=0))
                    || (!div.getJigyoshaServiceShosai().getRadDaikiboJigyoshaGaitoUmu().getSelectedKey().equals(beforeDiv.getDaikiboJigyoshaGaito_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJunUnitCareTaiseiUmu().getSelectedKey().equals(beforeDiv.getJunUnitCareTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadJudokaTaioTaiseiUmu().getSelectedKey().equals(beforeDiv.getJudokaTaioTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadIryoRenkeiTaiseiUmu().getSelectedKey().equals(beforeDiv.getIryoRenkeiTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadUnitCareTaiseiUmu().getSelectedKey().equals(beforeDiv.getUnitCareTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadZaitakuNyushoSogoRiyoTaiseiUmu().getSelectedKey().equals(beforeDiv.getZaitaku_nyushoSogoRiyoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadTerminalCareTaiseiUmu().getSelectedKey().equals(beforeDiv.getTerminalCareTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadShintaiKosokuHaishiTorikumiUmu().getSelectedKey().equals(beforeDiv.getShintaiKosokuHaishiTorikumi_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadShokiboKyotenShugoTaiseiUmu().getSelectedKey().equals(beforeDiv.getShokiboKyotenShugoTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNinchishoCareKasanUmu().getSelectedKey().equals(beforeDiv.getNinchishoCareKasan_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlKobetsuKinoKunrenTaiseiUmu().getSelectedKey().equals(beforeDiv.getKobetsuKinoKunrenTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRigakuRyohoIIUmu2().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuSagyoRyohoUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_SagyoRyoho_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuSonotaUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_Sonota_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSetsubiKijun().getSelectedKey().equals(beforeDiv.getSetsubiKijun().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRyoyoTaiseiIjiTokubetsuKasan().getSelectedKey().equals(beforeDiv.getRyoyoTaiseiIjiTokubetsuKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKobetsuRehaShidoKanriUmu().getSelectedKey().equals(beforeDiv.getKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSankyuHelperTaisei().getSelectedKey().equals(beforeDiv.getSankyuHelperTaisei().value()))
                    || (!div.getJigyoshaServiceShosai().getRadChuSankanChiikiShokiboJigyoshoKasanChiiki().getSelectedKey().equals(beforeDiv.getChuSankanChiikiShokiboJigyoshoKasan_chiiki().value()))
                    || (!div.getJigyoshaServiceShosai().getRadChuSankanChiikiShokiboJigyoshoKasanKibo().getSelectedKey().equals(beforeDiv.getChuSankanChiikiShokiboJigyoushoKasan_kibo().value()))
                    || (!div.getJigyoshaServiceShosai().getDdlServiceTeikyoTaiseiKyokaKasan().getSelectedKey().equals(beforeDiv.getServiceTeikyoTaiseiKyokaKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNinchishoTankiShuchuRehabilitationKasan().getSelectedKey().equals(beforeDiv.getNinchishoTankiShuchuRehabilitationKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKakunenseiNinchishoRiyoushaUkeeireKasan().getSelectedKey().equals(beforeDiv.getJakunenseiNinchishoRiyoushaUkeeireKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKangoTaiseiKasan().getSelectedKey().equals(beforeDiv.getKangoTaiseiKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadYakinShokuinHaichiKasan().getSelectedKey().equals(beforeDiv.getYakinShokuinHaichiKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadRyoyoShokuKasan().getSelectedKey().equals(beforeDiv.getRyoyoShokuKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNichijoSeikatsuKeizokuShienKasan().getSelectedKey().equals(beforeDiv.getNichijoSeikatsuKeizokuShienKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNinchishoSemmonCareKasan().getSelectedKey().equals(beforeDiv.getNinchishoSemmonCareKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRad24JikanTsuhoTaioKasan().getSelectedKey().equals(beforeDiv.getTwentyFourHoursTsuhoTaioKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKangoShokuinHaichiKasan().getSelectedKey().equals(beforeDiv.getKangoShokuinHaichiKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadYakanCareKasan().getSelectedKey().equals(beforeDiv.getYakanCareKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadShudanCommunicationRyohoUmu().getSelectedKey().equals(beforeDiv.getShudanCommunicationRyoho_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadServiceTeikyoTaiseiKyokaKasanKaradokogata().getSelectedKey().equals(beforeDiv.getServiceTeikyoTaiseiKyokaKasan_Karadokogata().value()))
                    || (!div.getJigyoshaServiceShosai().getRadNitchuShintaikaigoTaise20funmimanUmu().getSelectedKey().equals(beforeDiv.getNitchuShintaikaigoTaise_20funmiman_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadServiceTeikyoSekininshaTaiseiUmu().getSelectedKey().equals(beforeDiv.getServiceTeikyoSekininshaTaisei_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadDoitsuTatemonoKyojuRiyoshaGenzanUmu().getSelectedKey().equals(beforeDiv.getDoitsuTatemonoKyojuRiyoshaGenzan_umu().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKinkyuTankiNyushoTaiseiKakuhoKasan().getSelectedKey().equals(beforeDiv.getKinkyuTankiNyushoTaiseiKakuhoKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadZaitakuFukkiZaitakuRyoyoShienKinoKasan().getSelectedKey().equals(beforeDiv.getZaitakuFukki_ZaitakuRyoyoShienKinoKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadSeikatuKinoKojoGroupKatsudoKasan().getSelectedKey().equals(beforeDiv.getSeikatuKinoKojoGroupKatsudoKasan().value()))
                    || (!div.getJigyoshaServiceShosai().getRadKaigoShokuinShoguKaizenKasan().getSelectedKey().equals(beforeDiv.getKaigoShokuinShoguKaizenKasan().value())   )

                    ){
                changeFlg = true;
            }

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
