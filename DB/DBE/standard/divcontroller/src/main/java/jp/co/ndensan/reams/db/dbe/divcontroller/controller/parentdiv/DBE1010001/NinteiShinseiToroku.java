/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinJogaiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.NinteiShinseiTorokuResult;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseitoroku.RirekiJohoResult;
import jp.co.ndensan.reams.db.dbe.business.core.seikatsuhogotoroku.Minashi2shisaiJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.DBE1010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.NinteiShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001.NinteiShinseiTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001.NinteiShinseiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseitoroku.NinteiShinseiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoHokensha;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinItiran;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinItiranData;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JidoWariateJyogaishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.KoikinaiTenkyoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoHokenshaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.TextKind;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 審査依頼受付／みなし２号審査受付のコントローラです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiToroku {

    private final NinteiShinseiTorokuManager manager;
    private final KaigoHokenshaManager dbt7050Manager;

    private static final RString MENUID_DBEMN31001 = new RString("DBEMN31001");
    private static final RString MENUID_DBEMN31003 = new RString("DBEMN31003");
    private static final int ZERO_17 = 17;
    private static final int ZERO_5 = 5;
    private static final RString ZERO_6 = new RString("000000");

    /**
     * コンストラクタです。
     *
     */
    public NinteiShinseiToroku() {
        this.manager = NinteiShinseiTorokuManager.createInstance();
        this.dbt7050Manager = KaigoHokenshaManager.createInstance();
    }

    /**
     * 審査依頼受付／みなし２号審査受付初期化の設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onLoad(NinteiShinseiTorokuDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        ((KaigoNinteiAtenaInfoDiv) div.getCcdAtenaInfo()).getBtnKojinMemo().setDisabled(Boolean.TRUE);
        ((KaigoNinteiAtenaInfoDiv) div.getCcdAtenaInfo()).getBtnSetaiMemo().setDisabled(Boolean.TRUE);
        ShichosonSecurityJoho shichosonSecurity = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 介護導入形態 = RString.EMPTY;
        if (shichosonSecurity.get導入形態コード().value().equals(new RString("211"))) {
            介護導入形態 = new RString("4");
        }
        if (shichosonSecurity.get導入形態コード().value().equals(new RString("220"))) {
            介護導入形態 = new RString("1");
        }
        if (MENUID_DBEMN31001.equals(menuID)) {
            ShinseishoKanriNo 管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            RString 被保険者番号 = manager.get被保険者番号(管理番号);

            ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, manager.get要介護認定申請情報(管理番号));
            ViewStateHolder.put(ViewStateKeys.要介護認定申請届出情報, manager.get認定申請届出情報(管理番号));

            NinteiShinseiTorokuResult result = manager.getDataForLoad(管理番号);
            if (result != null) {
                ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));

                getHandler(div).loadUpdate(result, 管理番号, 被保険者番号, 介護導入形態);
                NinteiShinseiTodokedeshaDataPassModel dataPass = getHandler(div).set届出情報();
                dataPass.set申請書管理番号(管理番号.value());
                div.getCcdShinseiTodokedesha().initialize(dataPass);

                getHandler(div).set医療保険(manager.get医療保険履歴(result.get識別コード()));

                div.setHdnShichosonRenrakuJiko(result.get市町村連絡事項());
                getHandler(div).set市町村連絡事項(result.get市町村連絡事項());

                set連絡先(管理番号, div, false);

                RirekiJohoResult comResult = manager.get共有子データ(被保険者番号);
                div.setHdnKonkai(DataPassingConverter.serialize(comResult.get今回履歴情報()));
                div.setHdnZenkai(DataPassingConverter.serialize(comResult.get前回履歴情報()));
                div.setHdnDisplayModeKey(new RString("1"));
                div.setHdnSubGyomuCd(SubGyomuCode.DBE認定支援.value());

                div.setHdnJogaiMode(new RString("入力"));
                setIconName(div, 管理番号);
                div.setHdnShinseishoKanriNo(管理番号.value());
            }
            return ResponseData.of(div).rootTitle(new RString("審査依頼受付")).respond();
        }
        if (MENUID_DBEMN31003.equals(menuID)) {
            Minashi2shisaiJoho business = ViewStateHolder.get(ViewStateKeys.みなし2号登録情報, Minashi2shisaiJoho.class);
            if (business != null) {
                ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
                getHandler(div).loadInsert(business, business.get保険者().get市町村コード(), 介護導入形態);

                div.getCcdShinseiTodokedesha().initialize(getHandler(div).set届出情報());

                getHandler(div).set医療保険(manager.get医療保険履歴(business.get識別コード()));

                set連絡先(business.get前回申請書管理番号(), div, true);
                div.setHdnJogaiMode(new RString("入力"));
                div.setHdnShinseishoKanriNo(RString.EMPTY);
                if (div.getCcdAtenaInfo() == null || div.getCcdAtenaInfo().get被保険者氏名().isNullOrEmpty() || div.getCcdAtenaInfo().get性別().isNullOrEmpty()) {
                    throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("宛名情報"));
                }
            }
            return ResponseData.of(div).rootTitle(new RString("みなし２号審査受付")).respond();
        }
        
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().setTextKind(TextKind.全角のみ);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().setTextKind(TextKind.全角のみ);
        div.getCcdNinteiInput().getTxtShinsakaiIken().setTextKind(TextKind.全角のみ);
        return ResponseData.of(div).respond();
    }

    /**
     * 医療保険ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onChange_ddlHihokenshaKubun(NinteiShinseiTorokuDiv div) {
        KaigoNinteiShinseiKihonJohoInputDiv kihonJohoInputDiv = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(kihonJohoInputDiv.getDdlHihokenshaKubun().getSelectedKey())) {
            div.getCcdKaigoNinteiShinseiKihon().setRequiredForDdlTokuteiShippei(true);
        } else {
            div.getCcdKaigoNinteiShinseiKihon().setRequiredForDdlTokuteiShippei(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 医療保険ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnIryohokenGuide(NinteiShinseiTorokuDiv div) {
        div.setHdnIryoMode(new RString("照会"));
        return ResponseData.of(div).respond();
    }

    /**
     * 入院/施設入所ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnNyuinAndShisetsuNyusho(NinteiShinseiTorokuDiv div) {
        div.setHdnKanriMode(new RString("照会"));
        return ResponseData.of(div).respond();
    }

    /**
     * 定型文から選ぶダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnEnkiRiyuTeikeibun(NinteiShinseiTorokuDiv div) {
        div.setHdnSubGyomuCd(GyomuCode.DB介護保険.value());
        div.setHdnGroupCode(new RString("1007"));
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先ダイアログを閉じるの場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onOkClose_btnRenrakusaki(NinteiShinseiTorokuDiv div) {
        NinteiShinseiBusinessCollection data = DataPassingConverter.deserialize(div.getHdnRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        if (data != null && data.getDbdBusiness() != null && !data.getDbdBusiness().isEmpty()) {
            div.getBtnRenrakusaki().setIconNameEnum(IconName.Complete);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡事項ダイアログを表示の前の場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onBefore_btnShichosonRenrakuJiko(NinteiShinseiTorokuDiv div) {
        NinteiShinseiCodeModel data = new NinteiShinseiCodeModel();
        data.set連絡事項(div.getHdnShichosonRenrakuJiko());
        data.set表示モード(NinteiShinseiCodeModel.HyojiMode.InputMode);
        ViewStateHolder.put(ViewStateKeys.モード, data);
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡事項ダイアログを閉じるの場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onOkClose_btnShichosonRenrakuJiko(NinteiShinseiTorokuDiv div) {
        NinteiShinseiCodeModel data = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        if (data != null && !RString.isNullOrEmpty(data.get連絡事項())) {
            div.getBtnShichosonRenrakuJiko().setIconNameEnum(IconName.Complete);
            div.setHdnShichosonRenrakuJiko(data.get連絡事項());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 除外委員ダイアログを閉じるの場合、データを設定します。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onOkClose_btnJogaiShinsakaiIinGuide(NinteiShinseiTorokuDiv div) {
        ShinsakaiIinItiranData data = DataPassingConverter.deserialize(div.getHdnJogaiShinsainJoho(), ShinsakaiIinItiranData.class);
        if (data != null && data.getShinsakaiIinItiranList() != null && !data.getShinsakaiIinItiranList().isEmpty()) {
            div.getBtnJogaiShinsakaiIinGuide().setIconNameEnum(IconName.Complete);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧画面に遷移する。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onClick_btnBackToIchiran(NinteiShinseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBE1010001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 保存する　ボタン
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     * @return ResponseData<NinteiShinseiTorokuDiv>
     */
    public ResponseData<NinteiShinseiTorokuDiv> onClick_btnUpdate(NinteiShinseiTorokuDiv div) {
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString(UrInformationMessages.正常終了.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).forwardWithEventName(DBE1010001TransitionEventName.完了).respond();
        }
        RString menuID = ResponseHolder.getMenuID();
        ShinsakaiIinItiranData dataList = DataPassingConverter.deserialize(div.getHdnJogaiShinsainJoho(), ShinsakaiIinItiranData.class);
        NinteiShinseiBusinessCollection zenkaiJoho = DataPassingConverter.deserialize(div.getHdnRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (MENUID_DBEMN31003.equals(menuID)) {
            validationMessages.add(getValidationHandler(div).データ重複チェック(
                    manager.has要介護認定申請情報(div.getCcdShikakuInfo().getHookenshaCode(),
                            div.getCcdShikakuInfo().getTxtHihokenshaNo().getValue(),
                            rDateTOFlexDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                                    .getTxtShinseiYMD().getValue()), new Code(div.getCcdKaigoNinteiShinseiKihon().
                                    getKaigoNinteiShinseiKihonJohoInputDiv()
                                    .getDdlShinseiKubunShinseiji().getSelectedKey()))));
            validationMessages.add(getValidationHandler(div).被保険者区分チェック());
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            ShinseishoKanriNo 申請書管理番号 = get申請書管理番号(div);
            manager.save要介護認定申請情報(get要介護認定申請情報(div, 申請書管理番号));
            manager.save申請届出情報(get認定申請届出者情報(div, true, 申請書管理番号));
            manager.save申請履歴情報(get申請履歴情報(申請書管理番号));
            for (RenrakusakiJoho renrakusakiJoho : zenkaiJoho.getDbdBusiness()) {
                manager.save介護連絡先情報(set介護連絡先情報(renrakusakiJoho, true, 申請書管理番号));
            }
            add審査会委員除外情報(申請書管理番号, dataList);
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("みなし２号審査受付")).respond();
        } else {
            KaigoNinteiShinseiKihonJohoInputDiv kihonJohoInputDiv = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
            NinteiShinseiJoho shinseiJoho = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, NinteiShinseiJoho.class);
            validationMessages.add(getValidationHandler(div).データ重複チェック(
                    manager.has要介護認定申請情報(
                            shinseiJoho.get証記載保険者番号(), shinseiJoho.get被保険者番号(), rDateTOFlexDate(kihonJohoInputDiv
                                    .getTxtShinseiYMD().getValue()), new Code(kihonJohoInputDiv
                                    .getDdlShinseiKubunShinseiji().getSelectedKey()))));
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())
                    || NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())) {
                NinteiShinseiJohoBuilder shinseiJohoBuilder = get要介護認定申請情報Com(div, kihonJohoInputDiv, shinseiJoho);
                shinseiJohoBuilder.set認定申請区分_申請時_コード(new Code(kihonJohoInputDiv
                        .getDdlShinseiKubunShinseiji().getSelectedKey()));
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            }
            if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(kihonJohoInputDiv.getDdlShinseiKubunShinseiji().getSelectedKey())) {
                NinteiShinseiJohoBuilder shinseiJohoBuilder = get要介護認定申請情報Com(div, kihonJohoInputDiv, shinseiJoho);
                shinseiJohoBuilder.set申請サービス削除の理由(kihonJohoInputDiv.getTxtServiceSakujo().getValue());
                manager.save要介護認定申請情報(shinseiJohoBuilder.build().modifiedModel());
            }
            save介護連絡先情報(zenkaiJoho.getDbdBusiness());
            ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            del審査会委員除外情報(申請書管理番号, dataList);
            add審査会委員除外情報(申請書管理番号, dataList);
            manager.save申請届出情報(get認定申請届出者情報(div, false, ShinseishoKanriNo.EMPTY));
            return ResponseData.of(div).addMessage(UrInformationMessages.正常終了.getMessage().replace("審査依頼受付")).respond();
        }
    }

    private NinteiShinseiTorokuHandler getHandler(NinteiShinseiTorokuDiv div) {
        return new NinteiShinseiTorokuHandler(div);
    }

    private NinteiShinseiTorokuValidationHandler getValidationHandler(NinteiShinseiTorokuDiv div) {
        return new NinteiShinseiTorokuValidationHandler(div);
    }

    private void setIconName(NinteiShinseiTorokuDiv div, ShinseishoKanriNo 申請書管理番号) {
        if (!manager.get除外審査会委員情報(申請書管理番号).records().isEmpty()) {
            div.getBtnJogaiShinsakaiIinGuide().setIconNameEnum(IconName.Check);
        }
    }

    private void del審査会委員除外情報(ShinseishoKanriNo 申請書管理番号, ShinsakaiIinItiranData dataList) {
        if (dataList != null && dataList.getShinsakaiIinItiranList() != null) {
            for (ShinsakaiIinItiran data : dataList.getShinsakaiIinItiranList()) {
                manager.del除外審査会委員情報(申請書管理番号, data.getShinsakaiIinCode());
            }
        }
    }

    private void add審査会委員除外情報(ShinseishoKanriNo 申請書管理番号, ShinsakaiIinItiranData dataList) {
        if (dataList != null && dataList.getShinsakaiIinItiranList() != null) {
            int reban = 1;
            for (ShinsakaiIinItiran data : dataList.getShinsakaiIinItiranList()) {
                ShinsakaiIinJogaiJoho iinJogaiJoho = new ShinsakaiIinJogaiJoho(申請書管理番号, reban);
                ShinsakaiIinJogaiJohoBuilder builder = iinJogaiJoho.createBuilderForEdit();
                builder.set除外対象審査会委員コード(data.getShinsakaiIinCode());
                manager.save審査会委員除外情報(builder.build());
                reban = reban + 1;
            }
        }
    }

    private void save介護連絡先情報(List<RenrakusakiJoho> 介護連絡先情報リスト) {
        if (!RString.isNullOrEmpty(ViewStateHolder.get(ViewStateKeys.一覧データ, RString.class))) {
            for (RenrakusakiJoho renrakusakiJoho : 介護連絡先情報リスト) {
                if (renrakusakiJoho.toEntity().getState() == EntityDataState.Added) {
                    manager.save介護連絡先情報(set介護連絡先情報(renrakusakiJoho, false, ShinseishoKanriNo.EMPTY));
                } else if (renrakusakiJoho.toEntity().getState() == EntityDataState.Deleted) {
                    manager.del介護連絡先情報(renrakusakiJoho);
                } else {
                    manager.save介護連絡先情報(renrakusakiJoho);
                }
            }
        } else {
            for (RenrakusakiJoho renrakusakiJoho : 介護連絡先情報リスト) {
                manager.save介護連絡先情報(set介護連絡先情報(renrakusakiJoho, false, ShinseishoKanriNo.EMPTY));
            }
        }
    }

    private RenrakusakiJoho set介護連絡先情報(RenrakusakiJoho renrakusakiJoho, boolean flag, ShinseishoKanriNo 申請書管理番号) {
        RenrakusakiJoho renrakusaki = null;
        if (flag) {
            renrakusaki = new RenrakusakiJoho(申請書管理番号, renrakusakiJoho.get連番());
        } else {
            renrakusaki = new RenrakusakiJoho(new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class)), renrakusakiJoho.get連番());
        }
        RenrakusakiJohoBuilder renrakusakiBuilder = renrakusaki.createBuilderForEdit();
        renrakusakiBuilder.set連絡先区分番号(renrakusakiJoho.get連絡先区分番号());
        if (renrakusakiJoho.get支所コード() != null) {
            renrakusakiBuilder.set支所コード(renrakusakiJoho.get支所コード());
        }
        renrakusakiBuilder.set連絡先氏名(renrakusakiJoho.get連絡先氏名());
        renrakusakiBuilder.set連絡先氏名カナ(renrakusakiJoho.get連絡先氏名カナ());
        renrakusakiBuilder.set連絡先続柄(renrakusakiJoho.get連絡先続柄());
        renrakusakiBuilder.set連絡先郵便番号(renrakusakiJoho.get連絡先郵便番号());
        renrakusakiBuilder.set連絡先住所(renrakusakiJoho.get連絡先住所());
        renrakusakiBuilder.set連絡先電話番号(renrakusakiJoho.get連絡先電話番号());
        renrakusakiBuilder.set連絡先携帯番号(renrakusakiJoho.get連絡先携帯番号());
        renrakusakiBuilder.set優先順位(renrakusakiJoho.get優先順位());
        return renrakusakiBuilder.build();
    }

    private NinteiShinseiJohoBuilder get要介護認定申請情報Com(NinteiShinseiTorokuDiv div,
            KaigoNinteiShinseiKihonJohoInputDiv kihonJohoInputDiv, NinteiShinseiJoho shinseiJoho) {
        NinteiShinseiJohoBuilder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
        shinseiJohoBuilder.set申請年度(new FlexibleYear(kihonJohoInputDiv
                .getTxtShinseiYMD().getValue().getYear().toDateString()));
        shinseiJohoBuilder.set認定申請年月日(rDateTOFlexDate(kihonJohoInputDiv
                .getTxtShinseiYMD().getValue()));
        shinseiJohoBuilder.set被保険者区分コード(kihonJohoInputDiv.getDdlHihokenshaKubun().getSelectedKey());
        if (!RString.isNullOrEmpty(div.getCcdAtenaInfo().get年齢())) {
            shinseiJohoBuilder.set年齢(Integer.parseInt(div.getCcdAtenaInfo().get年齢().toString()));
        }
        shinseiJohoBuilder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().getValue());
        shinseiJohoBuilder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        shinseiJohoBuilder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        shinseiJohoBuilder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChodsItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        shinseiJohoBuilder.set認定調査員コード(new ChosainCode(div.getCcdChodsItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        shinseiJohoBuilder.set調査員への連絡事項(div.getCcdChodsItakusakiAndChosainInput().getChosainRenrakuJiko());
        shinseiJohoBuilder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        shinseiJohoBuilder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        shinseiJohoBuilder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        shinseiJohoBuilder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        shinseiJohoBuilder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        if (RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            shinseiJohoBuilder.set施設入所の有無(true);
        } else {
            shinseiJohoBuilder.set施設入所の有無(false);
        }
        if (!RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            shinseiJohoBuilder.set入所施設コード(new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo()));
        }
        shinseiJohoBuilder.set訪問調査先郵便番号(div.getTxtYubinNo().getValue());
        shinseiJohoBuilder.set訪問調査先住所(div.getTxtJusho().getDomain());
        shinseiJohoBuilder.set訪問調査先名称(new AtenaMeisho(div.getTxtChosasakiName().getValue()));
        shinseiJohoBuilder.set訪問調査先電話番号(div.getTxtTelNo().getDomain());
        if (!RString.isNullOrEmpty(div.getHdnShichosonRenrakuJiko())) {
            shinseiJohoBuilder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        }
        shinseiJohoBuilder.set延期決定年月日(rDateTOFlexDate(div.getTxtEnkiKetteiYMD().getValue()));
        shinseiJohoBuilder.set延期理由(div.getTxtEnkiRiyu().getValue());
        shinseiJohoBuilder.set延期通知発行年月日(rDateTOFlexDate(div.getTxtEnkiTsuchiHakkoYMD().getValue()));
        if (div.getTxtEnkiTsuchishoHakkoCount().getValue() != null) {
            shinseiJohoBuilder.set延期通知発行回数(div.getTxtEnkiTsuchishoHakkoCount().getValue().intValue());
        }
        shinseiJohoBuilder.set延期見込期間開始年月日(rDateTOFlexDate(div.getTxtEnkiMikomiKikanFrom().getValue()));
        shinseiJohoBuilder.set延期見込期間終了年月日(rDateTOFlexDate(div.getTxtEnkiMikomiKikanTo().getValue()));
        shinseiJohoBuilder.set論理削除フラグ(false);
        return shinseiJohoBuilder;
    }

    private ShinseiRirekiJoho get申請履歴情報(ShinseishoKanriNo 申請書管理番号) {
        ShinseiRirekiJoho shinseiRirekiJoho = new ShinseiRirekiJoho(申請書管理番号);
        ShinseiRirekiJohoBuilder shinseiRirekiJohoBuilder = shinseiRirekiJoho.createBuilderForEdit();
        Minashi2shisaiJoho business = ViewStateHolder.get(ViewStateKeys.みなし2号登録情報, Minashi2shisaiJoho.class);
        if (business != null && business.get前回申請書管理番号() != null && !business.get前回申請書管理番号().isEmpty()) {
            shinseiRirekiJohoBuilder.set前回申請管理番号(business.get前回申請書管理番号());
        } else {
            shinseiRirekiJohoBuilder.set前回申請管理番号(new ShinseishoKanriNo(RString.EMPTY.padZeroToLeft(ZERO_17)));
        }
        return shinseiRirekiJohoBuilder.build();
    }

    private ShinseitodokedeJoho get認定申請届出者情報(NinteiShinseiTorokuDiv div, boolean flag, ShinseishoKanriNo 申請書管理番号) {
        ShinseitodokedeJoho todokedeJoho = null;
        if (flag) {
            todokedeJoho = new ShinseitodokedeJoho(申請書管理番号);
        } else {
            todokedeJoho = ViewStateHolder.get(ViewStateKeys.要介護認定申請届出情報, ShinseitodokedeJoho.class);
        }
        ShinseitodokedeJohoBuilder todokedeJohoBuilder = todokedeJoho.createBuilderForEdit();
        NinteiShinseiTodokedeshaNaiyo todokedeshaNaiyo = div.getCcdShinseiTodokedesha().get一覧内容();
        todokedeJohoBuilder.set申請届出代行区分コード(new Code(todokedeshaNaiyo.get届出代行区分()));
        todokedeJohoBuilder.set申請届出者氏名(todokedeshaNaiyo.get氏名());
        todokedeJohoBuilder.set申請届出者氏名カナ(todokedeshaNaiyo.getカナ氏名());
        todokedeJohoBuilder.set申請届出者続柄コード(todokedeshaNaiyo.get本人との関係性());
        if (!RString.isNullOrEmpty(todokedeshaNaiyo.get事業者コード())) {
            todokedeJohoBuilder.set申請届出代行事業者番号(new JigyoshaNo(todokedeshaNaiyo.get事業者コード()));
        }
        todokedeJohoBuilder.set事業者区分(todokedeshaNaiyo.get申請関係者());
        if (new RString("key0").equals(todokedeshaNaiyo.get管内管外区分())) {
            todokedeJohoBuilder.set申請届出者郵便番号(todokedeshaNaiyo.get郵便番号());
            todokedeJohoBuilder.set申請届出者住所(todokedeshaNaiyo.get町域入力住所名称());
        }
        if (new RString("key1").equals(todokedeshaNaiyo.get管内管外区分())) {
            todokedeJohoBuilder.set申請届出者郵便番号(new YubinNo(todokedeshaNaiyo.get全国郵便番号()));
            todokedeJohoBuilder.set申請届出者住所(todokedeshaNaiyo.get全国住所名称());
        }
        todokedeJohoBuilder.set申請届出者電話番号(new TelNo(todokedeshaNaiyo.get電話番号()));
        return todokedeJohoBuilder.build();
    }

    private NinteiShinseiJoho get要介護認定申請情報(NinteiShinseiTorokuDiv div, ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseiJoho shinseiJoho = new NinteiShinseiJoho(申請書管理番号);
        NinteiShinseiJohoBuilder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
        shinseiJohoBuilder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        shinseiJohoBuilder.set証記載保険者番号(div.getCcdShikakuInfo().getHookenshaCode());
        shinseiJohoBuilder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getTxtShinseiYMD().getValue().getYear().toDateString()));
        shinseiJohoBuilder.set被保険者番号(div.getCcdShikakuInfo().getTxtHihokenshaNo().getValue());
        shinseiJohoBuilder.set認定申請年月日(rDateTOFlexDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getTxtShinseiYMD().getValue()));
        shinseiJohoBuilder.set認定申請枝番コード(new EdabanCode(new RString("000")));
        shinseiJohoBuilder.set認定申請区分_法令_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getDdlShinseiKubunHorei().getSelectedKey()));
        shinseiJohoBuilder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv()
                .getDdlShinseiKubunShinseiji().getSelectedKey()));
        shinseiJohoBuilder.set取下区分コード(new Code(TorisageKubunCode.認定申請有効.getコード()));
        shinseiJohoBuilder.set被保険者区分コード(HihokenshaKubunCode.生活保護.getコード());
        shinseiJohoBuilder.set生年月日(rDateTOFlexDate(div.getCcdAtenaInfo().get生年月日()));
        if (!RString.isNullOrEmpty(div.getCcdAtenaInfo().get年齢())) {
            shinseiJohoBuilder.set年齢(Integer.parseInt(div.getCcdAtenaInfo().get年齢().toString()));
        }
        if (!RString.isNullOrEmpty(div.getCcdAtenaInfo().get性別())) {
            shinseiJohoBuilder.set性別(new Code(Seibetsu.valueOf(div.getCcdAtenaInfo().get性別().toString()).getコード()));
        }
        shinseiJohoBuilder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getHdnShimeiKana()));
        shinseiJohoBuilder.set被保険者氏名(new AtenaMeisho(div.getCcdAtenaInfo().get被保険者氏名()));
        shinseiJohoBuilder.set郵便番号(div.getCcdAtenaInfo().get郵便番号());
        shinseiJohoBuilder.set住所(new AtenaJusho(div.getCcdAtenaInfo().get住所()));
        shinseiJohoBuilder.set電話番号(new TelNo(div.getCcdAtenaInfo().get電話番号()));
        shinseiJohoBuilder.set支所コード(div.getHdnShishoCode());
        shinseiJohoBuilder.set識別コード(new ShikibetsuCode(div.getCcdAtenaInfo().get識別コード()));
        shinseiJohoBuilder.setみなし２号等対象フラグ(true);
        shinseiJohoBuilder.set広域内転居区分(new Code(KoikinaiTenkyoKubun.対象外.getコード()));
        shinseiJohoBuilder.set認定申請有効区分(new Code(NinteiShinseiYukoKubunCode.有効.getコード()));
        shinseiJohoBuilder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        shinseiJohoBuilder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtNinteiShinseRiyu().getValue());
        shinseiJohoBuilder.set前回要介護状態区分コード(new Code(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue()));
        shinseiJohoBuilder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        shinseiJohoBuilder.set前回認定有効期間_開始_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        shinseiJohoBuilder.set前回認定有効期間_終了_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        shinseiJohoBuilder.set２号医療保険者名(div.getHdnIryoHokenshaMeisho());
        shinseiJohoBuilder.set２号医療保険記号番号(div.getHdnIryoHokenKigoNo());
        shinseiJohoBuilder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        shinseiJohoBuilder.set自動割当除外者区分(JidoWariateJyogaishaKubun.除外.getコード());
        shinseiJohoBuilder.set情報提供への同意有無(true);
        shinseiJohoBuilder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        shinseiJohoBuilder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        shinseiJohoBuilder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        shinseiJohoBuilder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        shinseiJohoBuilder.set認定延期通知発行しないことに対する同意有無(false);
        if (RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            shinseiJohoBuilder.set施設入所の有無(true);
        } else {
            shinseiJohoBuilder.set施設入所の有無(false);
        }
        if (!RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            shinseiJohoBuilder.set入所施設コード(new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo()));
        }
        shinseiJohoBuilder.set訪問調査先郵便番号(div.getTxtYubinNo().getValue());
        shinseiJohoBuilder.set訪問調査先住所(div.getTxtJusho().getDomain());
        shinseiJohoBuilder.set訪問調査先名称(new AtenaMeisho(div.getTxtChosasakiName().getValue()));
        shinseiJohoBuilder.set訪問調査先電話番号(div.getTxtTelNo().getDomain());
        if (!RString.isNullOrEmpty(div.getHdnShichosonRenrakuJiko())) {
            shinseiJohoBuilder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        }
        shinseiJohoBuilder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        shinseiJohoBuilder.set処理状態区分(new Code(ShoriJotaiKubun.通常.getコード()));
        shinseiJohoBuilder.set審査継続区分(false);
        shinseiJohoBuilder.set介護認定審査会優先振分区分コード(new Code(ShinsakaiYusenWaritsukeKubunCode.通常.getコード()));
        shinseiJohoBuilder.set論理削除フラグ(false);

        return shinseiJohoBuilder.build();
    }

    private void set連絡先(ShinseishoKanriNo 申請書管理番号, NinteiShinseiTorokuDiv div, boolean flag) {
        if (flag) {
            if (申請書管理番号 != null) {
                NinteiShinseiBusinessCollection zenkaiJoho = new NinteiShinseiBusinessCollection();
                zenkaiJoho.setDbdBusiness(manager.get介護連絡先情報(申請書管理番号).records());
                div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(zenkaiJoho));
            }
            div.setHdnRenrakusakiReadOnly(RString.EMPTY);
            NinteiShinseiBusinessCollection konkaiJoho = new NinteiShinseiBusinessCollection();
            konkaiJoho.setDbdBusiness(new ArrayList<RenrakusakiJoho>());
            div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(konkaiJoho));
        } else {
            ShinseishoKanriNo 前回申請管理番号 = manager.get前回申請管理番号(申請書管理番号);
            if (前回申請管理番号 != null) {
                NinteiShinseiBusinessCollection zenkaiJoho = new NinteiShinseiBusinessCollection();
                zenkaiJoho.setDbdBusiness(manager.get介護連絡先情報(前回申請管理番号).records());
                div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(zenkaiJoho));
            }
            NinteiShinseiBusinessCollection konkaiJoho = new NinteiShinseiBusinessCollection();
            if (!manager.get介護連絡先情報(申請書管理番号).records().isEmpty()) {
                div.getBtnRenrakusaki().setIconNameEnum(IconName.Check);
                ViewStateHolder.put(ViewStateKeys.一覧データ, new RString("1"));
            }
            konkaiJoho.setDbdBusiness(manager.get介護連絡先情報(申請書管理番号).records());
            div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(konkaiJoho));
            div.setHdnRenrakusakiReadOnly(RString.EMPTY);
        }

    }

    private FlexibleDate rDateTOFlexDate(RDate fromDate) {
        if (fromDate != null) {
            return new FlexibleDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
        }
        return FlexibleDate.EMPTY;
    }

    private ShinseishoKanriNo get申請書管理番号(NinteiShinseiTorokuDiv div) {
        KaigoHokensha hokensha = dbt7050Manager.get介護保険者By広域保険者番号(new ShoKisaiHokenshaNo(div.getCcdShikakuInfo().getHookenshaCode()));
        RString 連番 = Saiban.get(SubGyomuCode.DBZ介護共通, SaibanHanyokeyName.市町村コード_西暦_月.getコード()).nextString();
        RStringBuilder rsb = new RStringBuilder();
        if (ZERO_6.equals(div.getCcdShikakuInfo().getHookenshaCode())) {
            rsb.append(ZERO_6);
        } else {
            rsb.append(hokensha.get広域保険者市町村コード().value());
        }
        rsb.append(RDate.getNowDate().getYearMonth().toDateString());
        rsb.append(連番.padZeroToLeft(ZERO_5));
        return new ShinseishoKanriNo(rsb.toRString());
    }
}
