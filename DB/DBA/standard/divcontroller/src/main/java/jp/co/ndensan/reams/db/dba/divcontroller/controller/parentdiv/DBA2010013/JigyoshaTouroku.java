/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2010013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.DBA2010013StateName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.DBA2010013TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.JigyoshaToutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010013.JigyoshaTourokuHandler;
import jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri.KaigoJigyoshaShisetsuKanriManager;
import jp.co.ndensan.reams.db.dba.service.jigyoshatouroku.JigyoshaTourokuFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
    private KaigoJigyoshaShisetsuKanriMapperParameter 事業者登録パラメータ;
    private KaigoJogaiTokureiParameter サービス一覧パラメータ;
    private final KaigoJigyoshaShisetsuKanriManager manager = KaigoJigyoshaShisetsuKanriManager.createInstance();
    private final JigyoshaTourokuFinder jigyoshaTourokuFinder = JigyoshaTourokuFinder.createInstance();

    /**
     * 事業者登録Divを初期化します。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onLoad(JigyoshaToutokuDiv div) {
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.事業者登録_画面状態, RString.class);
        RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者登録_事業者番号, RString.class);
        FlexibleDate 有効開始日 = ViewStateHolder.get(ViewStateKeys.事業者登録_有効開始日, FlexibleDate.class);
        事業者登録パラメータ = KaigoJigyoshaShisetsuKanriMapperParameter.createParam(
                事業者番号, 有効開始日, RString.EMPTY, RString.EMPTY, FlexibleDate.EMPTY);
        サービス一覧パラメータ = KaigoJogaiTokureiParameter.createParam(
                事業者番号, 有効開始日, FlexibleDate.EMPTY);
        if (初期_状態.equals(状態_追加)) {
            getHandler(div).initialize(初期_状態);
            return ResponseData.of(div).setState(DBA2010013StateName.追加状態);
        } else if (初期_状態.equals(状態_修正)) {
            getHandler(div).initialize(初期_状態);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010013StateName.修正状態);
        } else if (初期_状態.equals(状態_削除)) {
            getHandler(div).initialize(初期_状態);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010013StateName.削除状態);
        } else if (初期_状態.equals(状態_照会)) {
            getHandler(div).initialize(初期_状態);
            get事業者情報の検索処理(div);
            return ResponseData.of(div).setState(DBA2010013StateName.照会状態);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaToutokuDiv> get事業者情報の検索処理(JigyoshaToutokuDiv div) {
        List<KaigoJigyosha> 事業者登録情報List = manager.getJigyoshaJoho(事業者登録パラメータ).records();
        List<KaigoJogaiTokureiBusiness> サービス一覧情報List = manager.getServiceItiranJoho(サービス一覧パラメータ).records();
        boolean selectFlag = false;
        KaigoJigyosha kaigoJigyosha = null;
        if (!事業者登録情報List.isEmpty()) {
            selectFlag = true;
            kaigoJigyosha = 事業者登録情報List.get(0);
        }
        ViewStateHolder.put(ViewStateKeys.事業者登録情報, kaigoJigyosha);
        getHandler(div).get事業者情報_代表者_開設者情報(selectFlag, kaigoJigyosha);
        getHandler(div).getサービス一覧情報(サービス一覧情報List);
        return ResponseData.of(div).respond();
    }

    /**
     * サービス一覧の「再表示」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnServiceReload(JigyoshaToutokuDiv div) {
        List<RString> chkKakoRirekiHyojiFlagList = div.getServiceJoho().getChkKakoRirekiHyojiFlag().getSelectedKeys();
        boolean chkKakoRirekiHyojiFlag = false;
        if (chkKakoRirekiHyojiFlagList.isEmpty()) {
            chkKakoRirekiHyojiFlag = true;
        }
        //TODO QA:1033
        RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者登録_事業者番号, RString.class);
        FlexibleDate 有効開始日 = ViewStateHolder.get(ViewStateKeys.事業者登録_有効開始日, FlexibleDate.class);
        サービス一覧パラメータ = KaigoJogaiTokureiParameter.createParam(
                事業者番号, 有効開始日, FlexibleDate.EMPTY);
        List<KaigoJogaiTokureiBusiness> サービス一覧情報List = manager.getServiceItiranJoho(サービス一覧パラメータ).records();
        List<KaigoJogaiTokureiBusiness> サービス一覧の現在有効の情報List = new ArrayList();
        if (chkKakoRirekiHyojiFlag) {
            for (KaigoJogaiTokureiBusiness business : サービス一覧情報List) {
                if (business.get有効終了日() == null) {
                    サービス一覧の現在有効の情報List.add(business);
                }
            }
            getHandler(div).getサービス一覧情報(サービス一覧の現在有効の情報List);
        } else {
            getHandler(div).getサービス一覧情報(サービス一覧情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービスを追加する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnAddService(JigyoshaToutokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.サービス登録_画面状態, 状態_追加);
        set画面引数の設定(div);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.サービス追加).respond();
    }

    /**
     * 「サービスを修正する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnModify(JigyoshaToutokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.サービス登録_画面状態, 状態_修正);
        set画面引数の設定(div);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.サービス修正).respond();
    }

    /**
     * 「サービスを削除する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnDelete(JigyoshaToutokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.サービス登録_画面状態, 状態_削除);
        set画面引数の設定(div);
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.サービス削除).respond();
    }

    private void set画面引数の設定(JigyoshaToutokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.サービス登録_事業者番号, ViewStateHolder.get(ViewStateKeys.事業者登録_事業者番号, RString.class));
        ViewStateHolder.put(ViewStateKeys.サービス登録_サービス種類コード, 
                div.getServiceJoho().getDgServiceList().getClickedItem().getServiceType());
        ViewStateHolder.put(ViewStateKeys.サービス登録_有効開始日, ViewStateHolder.get(ViewStateKeys.事業者登録_有効開始日, FlexibleDate.class));
    }

    /**
     * 「事業者情報を保存する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnSave(JigyoshaToutokuDiv div) {
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.事業者登録_画面状態, RString.class);
        RString 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者登録_事業者番号, RString.class);
        FlexibleDate 有効開始日 = ViewStateHolder.get(ViewStateKeys.事業者登録_有効開始日, FlexibleDate.class);
        if (初期_状態.equals(状態_追加)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の登録処理(事業者番号, div);
                return ResponseData.of(div).setState(DBA2010013StateName.完了状態);
            }
        } else if (初期_状態.equals(状態_修正)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の更新処理(div, 事業者番号, 有効開始日);
                return ResponseData.of(div).setState(DBA2010013StateName.完了状態);
            }
        } else if (初期_状態.equals(状態_削除)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get事業者情報の削除処理(div);
                return ResponseData.of(div).setState(DBA2010013StateName.完了状態);
            }
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaToutokuDiv> get事業者情報の登録処理(RString 事業者番号, JigyoshaToutokuDiv div) {
        JigyoshaNo jigyoshaNo = new JigyoshaNo(div.getServiceJigyoshaJoho().getTxtJigyoshaNo().getValue());
        FlexibleDate yukoKaishiYMD = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
        FlexibleDate yukoShuryoYMD = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
        KaigoJogaiTokureiParameter parameter = KaigoJogaiTokureiParameter.createParam(事業者番号, yukoKaishiYMD, yukoShuryoYMD);
        if (!manager.checkKikanGorisei(parameter)) {
            throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
        KaigoJigyoshaParameter kaigoJigyoshaParameter = KaigoJigyoshaParameter.createParam(
                jigyoshaNo.getColumnValue(),
                yukoKaishiYMD,
                ViewStateHolder.get(ViewStateKeys.事業者登録_事業者種類コード, RString.class
                ),
                yukoShuryoYMD);
        if (manager.checkKikanJufuku(kaigoJigyoshaParameter)) {
            throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
        }
        KaigoJigyosha kaigoJigyosha = new KaigoJigyosha(jigyoshaNo, yukoKaishiYMD);
        KaigoJigyoshaBuilder kaigoJigyoshaBuilder = kaigoJigyosha.createBuilderForEdit();
        kaigoJigyoshaBuilder.set有効終了日(div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue());
        kaigoJigyoshaBuilder.set事業者名称(
                new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaName().getValue()));
        kaigoJigyoshaBuilder.set事業者名称カナ(
                new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().getValue()));
        kaigoJigyoshaBuilder.set事業開始日(div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue());
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
                ViewStateHolder.get(ViewStateKeys.事業者登録_事業者種類コード, RString.class),
                null);
        if (insertFlag) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaToutokuDiv> get事業者情報の更新処理(JigyoshaToutokuDiv div, RString 事業者番号, FlexibleDate 有効開始日) {
        KaigoJigyosha 事業者情報 = ViewStateHolder.get(ViewStateKeys.事業者登録情報, KaigoJigyosha.class);
        FlexibleDate 有効終了日 = 事業者情報.get有効終了日();
        RString jigyoshaNo = div.getServiceJigyoshaJoho().getTxtJigyoshaNo().getValue();
        FlexibleDate yukoKaishiYMD = div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue();
        FlexibleDate yukoShuryoYMD = div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue();
        if (!有効開始日.equals(yukoKaishiYMD)
                || get有効終了日の変更判定(有効終了日, yukoShuryoYMD)) {
            KaigoJogaiTokureiParameter parameter = KaigoJogaiTokureiParameter.createParam(事業者番号, yukoKaishiYMD, yukoShuryoYMD);
            if (!manager.checkKikanGorisei(parameter)) {
                throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
            }
            KaigoJigyoshaParameter kaigoJigyoshaParameter = KaigoJigyoshaParameter.createParam(
                    事業者番号,
                    yukoKaishiYMD,
                    ViewStateHolder.get(ViewStateKeys.事業者登録_事業者種類コード, RString.class),
                    yukoShuryoYMD);
            if (!manager.checkKikanJufuku(kaigoJigyoshaParameter)) {
                throw new ApplicationException(UrErrorMessages.期間が重複.getMessage());
            }
        }
        if (!事業者番号.equals(jigyoshaNo)
                || !有効開始日.equals(yukoKaishiYMD)) {
            get事業者情報の登録処理(事業者番号, div);
            return ResponseData.of(div).respond();
        }
        KaigoJigyoshaDaihyoshaIdentifier identifier
                = new KaigoJigyoshaDaihyoshaIdentifier(事業者情報.get事業者番号(), 事業者情報.get有効開始日());
        KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = 事業者情報.getKaigoJigyoshaDaihyoshaList(identifier);        
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
        KaigoJigyoshaBuilder kaigoJigyoshaBuilder = 事業者情報.createBuilderForEdit();
        kaigoJigyoshaBuilder.set有効終了日(div.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().getValue());
        kaigoJigyoshaBuilder.set事業者名称(
                new AtenaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaName().getValue()));
        kaigoJigyoshaBuilder.set事業者名称カナ(
                new AtenaKanaMeisho(div.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().getValue()));
        kaigoJigyoshaBuilder.set事業開始日(div.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().getValue());
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
                事業者情報,
                ViewStateHolder.get(ViewStateKeys.事業者登録_事業者種類コード, RString.class),
                null,
                new RString("1"));
        if (updateFlag) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("更新").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoshaToutokuDiv> get事業者情報の削除処理(JigyoshaToutokuDiv div) {
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
        if (deleteFlag) {
            div.getKaigoKanryo().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace("削除").evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(div).respond();
    }

    private boolean get有効終了日の変更判定(FlexibleDate 有効終了日, FlexibleDate yukoShuryoYMD) {
        return !yukoShuryoYMD.equals(有効終了日);
    }

    /**
     * 「再検索する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnBack(JigyoshaToutokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.検索画面遷移の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.検索に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンの押下を処理です。
     *
     * @param div 事業者登録Div
     * @return ResponseData<JigyoshaToutokuDiv> 事業者登録Div
     */
    public ResponseData<JigyoshaToutokuDiv> onClick_btnComplete(JigyoshaToutokuDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBA2010013TransitionEventName.完了).respond();
    }

    private JigyoshaTourokuHandler getHandler(JigyoshaToutokuDiv div) {
        return new JigyoshaTourokuHandler(div);
    }
}
