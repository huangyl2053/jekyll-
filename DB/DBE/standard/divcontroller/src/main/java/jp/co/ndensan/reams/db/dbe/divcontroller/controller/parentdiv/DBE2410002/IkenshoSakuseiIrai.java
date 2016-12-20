/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2410002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudou;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportJoho;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouReportJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.IkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002.IkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002.IkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseiirai.IkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiReportOutputService;
import jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshi.IkenshokinyuyoshiPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 主治医意見書作成依頼(手動)のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIrai {

    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final RString SELECTED_KEY3 = new RString("key3");
    private static final RString SELECTED_KEY4 = new RString("key4");
    private static final RString SELECTED_KEY5 = new RString("key5");
    private static final RString 依頼書印刷処理 = new RString("依頼書印刷処理");
    private static final int 数字_0 = 0;
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString 指定医 = new RString("2");
    private static  RDate 認定申請年月日 = null;

    /**
     * 主治医意見書作成依頼(手動)の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onLoad(IkenshoSakuseiIraiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        div.getCcdNinteiShinseishaKihonInfo().initialize(申請書管理番号);
        IkenshoSakuseiIraiManager manager = IkenshoSakuseiIraiManager.createInstance();
        IkenshoirairirekiichiranShudou 主治医意見書作成依頼 = manager.get主治医意見書作成依頼(申請書管理番号.value());
        NinteiShinseiJoho 要介護認定申請情報 = manager.get要介護認定申請情報(申請書管理番号.value());
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, 要介護認定申請情報);
        div.getCcdShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleInputMode);
        div.getCcdShujiiInput().initialize(主治医意見書作成依頼.get市町村コード(), 申請書管理番号, SubGyomuCode.DBE認定支援,
                主治医意見書作成依頼.get主治医医療機関コード(), 主治医意見書作成依頼.get医療機関名称(),
                主治医意見書作成依頼.get主治医コード(), 主治医意見書作成依頼.get主治医氏名());
        boolean is指定医 = false;
        if (主治医意見書作成依頼.get医師区分コード() != null && 指定医.equals(主治医意見書作成依頼.get医師区分コード().value())) {
            is指定医 = true;
        }
        div.getCcdShujiiInput().setShiteii(is指定医);
        RString 主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼.get主治医意見書作成依頼履歴番号();
        if (RString.isNullOrEmpty(主治医意見書作成依頼履歴番号)) {
            主治医意見書作成依頼履歴番号 = RString.EMPTY;
        }

        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().
                concat(new RString("ShinseishoKanriNo")).concat(申請書管理番号.value()).
                concat(主治医意見書作成依頼履歴番号));
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            div.setReadOnly(true);
            throw new PessimisticLockingException();
        }
        認定申請年月日 = new RDate(主治医意見書作成依頼.get認定申請年月日().toString());
        createHandler(div).initialize(主治医意見書作成依頼);
        if (!ResponseHolder.isReRequest()) {
            div.getTxtHakobi().setValue(RDate.getNowDate());
        }
        div.getCcdShujiiInput().getBtnIryokikanGuide().setDisabled(true);
        onChange_radKigen(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 提出期限変更時、画面状態を制御します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onChange_radKigen(IkenshoSakuseiIraiDiv div) {
        RString コンフィグ_主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString key = div.getRadKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (CONFIGVALUE1.equals(コンフィグ_主治医意見書作成期限設定方法)) {
            if (SELECTED_KEY0.equals(key)) {
                div.getTxtKigenymd().setDisabled(true);
                div.getTxtKigenymd().setValue(div.getTxtSakuseiIraiD().getValue().plusDay(期限日数));
            } else if (SELECTED_KEY1.equals(key)) {
                div.getTxtKigenymd().setDisabled(false);
                div.getTxtKigenymd().clearValue();
            } else if (SELECTED_KEY2.equals(key)) {
                div.getTxtKigenymd().setDisabled(true);
                div.getTxtKigenymd().setValue(RDate.getNowDate().plusDay(期限日数));
            }
        } else if (認定申請年月日 != null) {
            div.getTxtKigenymd().setValue(認定申請年月日.plusDay(期限日数));
            div.getRadKigen().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 受診期間変更時、画面状態を制御します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onChange_radJyushin(IkenshoSakuseiIraiDiv div) {
        if (SELECTED_KEY0.equals(div.getRadJyushin().getSelectedKey())) {
            div.getTxtJyushinymd().setDisabled(false);
            div.getTxtJyushintime().setDisabled(false);
            div.getTxtJyushinKikan().setDisabled(true);
            div.getTxtJyushinKikan().clearFromValue();
            div.getTxtJyushinKikan().clearToValue();
        } else {
            div.getTxtJyushinKikan().setDisabled(false);
            div.getTxtJyushinymd().setDisabled(true);
            div.getTxtJyushinymd().clearValue();
            div.getTxtJyushintime().setDisabled(true);
            div.getTxtJyushintime().clearValue();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択した帳票を発行する」ボタン押下時、画面チェックを行いします。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_btnHakkouCheck(IkenshoSakuseiIraiDiv div) {
        ValidationMessageControlPairs validPairs = createValidationHandler(div).check発行();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択した帳票を発行する」ボタン押下時、帳票を印刷します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<SourceDataCollection> onClick_btnHakkou(IkenshoSakuseiIraiDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        update主治医意見書作成依頼情報(div);

        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        NinteiShinseiJoho 要介護認定申請情報 = IkenshoSakuseiIraiManager.createInstance().get要介護認定申請情報(申請書管理番号.value());
        NinteiShinseiJohoBuilder builder = 要介護認定申請情報.createBuilderForEdit();
        builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiInput().hasShiteii());
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, builder.build());
        try (ReportManager reportManager = new ReportManager()) {
            AccessLogger.log(AccessLogType.照会, toPersonalData());
            printData(div, reportManager);
            response.data = reportManager.publish();
        }
        return response;
    }

    /**
     * 発行押下後、処理完了メッセージを表示します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_btnHakkouKanryo(IkenshoSakuseiIraiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RString 主治医意見書作成依頼履歴番号 = div.getIkenshoIraiRirekiNo();
            if (RString.isNullOrEmpty(主治医意見書作成依頼履歴番号)) {
                主治医意見書作成依頼履歴番号 = RString.EMPTY;
            }
            LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().
                    concat(new RString("ShinseishoKanriNo")).
                    concat(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).value()).
                    concat(主治医意見書作成依頼履歴番号));
            RealInitialLocker.release(排他キー);
            return ResponseData.of(div).addMessage((UrInformationMessages.正常終了.getMessage().replace(依頼書印刷処理.toString()))).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険診断命令書を選択したら、診断命令書印刷設定パネルを表示します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_Chkprint(IkenshoSakuseiIraiDiv div) {
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY3)) {
            div.getMeireishoPanel().setDisplayNone(false);
        } else {
            div.getMeireishoPanel().setDisplayNone(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン押下時、意見書作成依頼情報を更新します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<IkenshoSakuseiIraiDiv> onClick_btnUpdate(IkenshoSakuseiIraiDiv div) {
        ValidationMessageControlPairs validPairs = createValidationHandler(div).check保存();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            保存処理(div);
            onLoad(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private void 保存処理(IkenshoSakuseiIraiDiv div) {
        NinteiShinseiJoho 要介護認定申請情報 = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, NinteiShinseiJoho.class);
        NinteiShinseiJohoBuilder builder = 要介護認定申請情報.createBuilderForEdit();
        builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiInput().hasShiteii());
        builder.setShujiiIkenshoIraiJoho(createHandler(div)
                .create主治医意見書作成依頼(要介護認定申請情報, ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).value()));
        IkenshoSakuseiIraiManager.createInstance().save(builder.build().modifiedModel());
    }

    private IkenshoSakuseiIraiHandler createHandler(IkenshoSakuseiIraiDiv div) {
        return new IkenshoSakuseiIraiHandler(div);
    }

    private PersonalData toPersonalData() {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private IkenshoSakuseiIraiValidationHandler createValidationHandler(IkenshoSakuseiIraiDiv div) {
        return new IkenshoSakuseiIraiValidationHandler(div);
    }

    private void update主治医意見書作成依頼情報(IkenshoSakuseiIraiDiv div) {
        ShujiiIkenshoIraiJohoBuilder 主治医意見書依頼情報builder = null;
        NinteiShinseiJoho 要介護認定申請情報 = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, NinteiShinseiJoho.class);
        ShujiiIkenshoIraiJoho ikenshoIraiJoho = 要介護認定申請情報.getshujiiIkenshoIraiJohoList().get(数字_0);
        if (div.getChkIrai().getSelectedKeys().contains(SELECTED_KEY0) || div.getChkIrai().getSelectedKeys().contains(SELECTED_KEY1)) {
            主治医意見書依頼情報builder = ikenshoIraiJoho.createBuilderForEdit();
            主治医意見書依頼情報builder.set依頼書出力年月日(new FlexibleDate(div.getTxtHakobi().getValue().toDateString()));
        }
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY0) || div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY1)) {
            主治医意見書依頼情報builder = ikenshoIraiJoho.createBuilderForEdit();
            主治医意見書依頼情報builder.set意見書出力年月日(new FlexibleDate(div.getTxtHakobi().getValue().toDateString()));
            主治医意見書依頼情報builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
            主治医意見書依頼情報builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
        }
        if (主治医意見書依頼情報builder != null) {
            NinteiShinseiJohoBuilder builder = 要介護認定申請情報.createBuilderForEdit();
            builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
            builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
            builder.set指定医フラグ(div.getCcdShujiiInput().hasShiteii());
            builder.setShujiiIkenshoIraiJoho(主治医意見書依頼情報builder.build());
            IkenshoSakuseiIraiManager.createInstance().save(builder.build().modifiedModel());
        }
    }

    private void printData(IkenshoSakuseiIraiDiv div, ReportManager reportManager) {

        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ChosaIraishoAndChosahyoAndIkenshoPrintService printService = new ChosaIraishoAndChosahyoAndIkenshoPrintService(reportManager);
        IkenshoSakuseiIraiManager 依頼書manager = IkenshoSakuseiIraiManager.createInstance();
        ChosaIraishoAndChosahyoAndIkenshoPrintFinder 意見書Finder = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance();
        ShujiiIkenshoSakuseiIraiReportOutputService 意見書PrintService = ShujiiIkenshoSakuseiIraiReportOutputService.createInstance();
        IkenshoirairirekiichiranShudou 意見書作成依頼書情報 = 依頼書manager.get主治医意見書作成依頼(申請書管理番号.value());
        IkenshokinyuyoshiPrintService ikenshoPrintService = new IkenshokinyuyoshiPrintService(reportManager);
        if (div.getChkIrai().getSelectedKeys().contains(SELECTED_KEY0)) {
            List<ShujiiIkenshoSakuseiIraishoItem> 意見書作成依頼書List = createHandler(div).create意見書作成依頼書(意見書作成依頼書情報);
            意見書PrintService.print主治医意見書作成依頼情報(意見書作成依頼書List, reportManager);
        }
        if (div.getChkIrai().getSelectedKeys().contains(SELECTED_KEY1)) {
            List<IkenshoSakuseiIraiIchiranhyoItem> 意見書作成依頼一覧表List
                    = createHandler(div).create意見書作成依頼一覧表(意見書作成依頼書情報);
            意見書PrintService.print主治医意見書作成依頼一覧表(意見書作成依頼一覧表List, reportManager);
        }
        if (div.getChkIrai().getSelectedKeys().contains(SELECTED_KEY2)) {
            SyujiyikenshosakuseyiraihakouReportJoho 主治医意見書作成依頼発行一覧表List = createHandler(div).
                    create主治医意見書作成依頼発行一覧表(依頼書manager.get主治医意見書作成依頼発行一覧表(申請書管理番号.value()).records());
            意見書PrintService.print主治医意見書作成依頼発行一覧表(主治医意見書作成依頼発行一覧表List, reportManager);
        }
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY0)) {
            RString 印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (CONFIGVALUE1.equals(印刷タイプ)) {
                ikenshoPrintService.print(get主治医意見書記入用紙(div), ReportIdDBZ.DBE231001_Katamen_Mono.getReportId());

            } else if (CONFIGVALUE2.equals(印刷タイプ)) {
                ikenshoPrintService.print(get主治医意見書記入用紙(div), ReportIdDBZ.DBE231001_Ryomen_Mono.getReportId());
            }
        }
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY1)) {
            RString 印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (CONFIGVALUE1.equals(印刷タイプ)) {
                ikenshoPrintService.print(get主治医意見書記入用紙(div), ReportIdDBZ.DBE231011_Katamen_Color.getReportId());
            } else if (CONFIGVALUE2.equals(印刷タイプ)) {
                ikenshoPrintService.print(get主治医意見書記入用紙(div), ReportIdDBZ.DBE231011_Ryomen_Color.getReportId());
            }
        }
        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(申請書管理番号.value());
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY2)) {
            if (!意見書Finder.get主治医意見書作成料請求書(parameter).records().isEmpty()) {
                List<ShujiiIkenshoSakuseiRyoSeikyushoItem> 主治医意見書作成料請求書List
                        = createHandler(div).create主治医意見書作成料請求書(意見書Finder.get主治医意見書作成料請求書(parameter).records().get(数字_0));
                printService.print主治医意見書作成料請求書(主治医意見書作成料請求書List);
            }
        }
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY3)) {
            if (!意見書Finder.get介護保険診断命令書(parameter).records().isEmpty()) {
                List<KaigohokenShindanMeireishoHeaderItem> 護保険診断命令書List
                        = createHandler(div).create介護保険診断命令書(意見書Finder.get介護保険診断命令書(parameter).records().get(数字_0));
                printService.print介護保険診断命令書(護保険診断命令書List);
            }
        }
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY4)) {
            ShujiiIkenshoTeishutsuIraishoReportJoho 介護保険指定医依頼兼主治医意見書提出意見書
                    = createHandler(div).create介護保険指定医依頼兼主治医意見書提出意見書(
                            依頼書manager.get介護保険指定医依頼兼主治医意見書提出意見書(申請書管理番号.value()).records());
            意見書PrintService.print介護保険指定医依頼兼主治医意見書提出意見書(介護保険指定医依頼兼主治医意見書提出意見書.getItemList(), reportManager);
        }
        if (div.getChkPrint().getSelectedKeys().contains(SELECTED_KEY5)) {
            List<IkenshoirairirekiIchiran> 主治医意見書依頼該当者履歴一覧List
                    = 依頼書manager.get主治医意見書依頼該当者履歴一覧(意見書作成依頼書情報.get被保険者番号()).records();
            意見書PrintService.print主治医意見書依頼該当者履歴一覧(主治医意見書依頼該当者履歴一覧List, reportManager);
        }
    }

    private List<IkenshokinyuyoshiBusiness> get主治医意見書記入用紙(IkenshoSakuseiIraiDiv div) {

        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.
                createParameter(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).value());

        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                .get主治医意見書記入用紙(parameter).records();
        ChosaIraishoAndChosahyoAndIkenshoPrintBusiness business = businessList.get(数字_0);
        return createHandler(div).create主治医意見書記入情報_パラメータ(business);
    }
}
