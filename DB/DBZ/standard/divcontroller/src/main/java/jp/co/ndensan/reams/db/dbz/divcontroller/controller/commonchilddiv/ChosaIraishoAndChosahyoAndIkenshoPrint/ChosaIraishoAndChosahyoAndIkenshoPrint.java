/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.PrintValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.dgNinteiChosa_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.dgShujiiIkensho_Row;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div 依頼書・認定調査票(OCR)・主治医意見書印刷のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
public class ChosaIraishoAndChosahyoAndIkenshoPrint {

    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString CONFIGVALUE4 = new RString("4");

    private static final RString DBE221001_KATAMEN = new RString("DBE221001_ChosahyoGaikyochosa_Katamen");
    private static final RString DBE221001_RYOMEN = new RString("DBE221001_ChosahyoGaikyochosa_Ryomen_Color");
    private static final RString DBE221001 = new RString("DBE221011_chosahyoGaikyochosa");
    private static final RString DBE221002_KATAMEN = new RString("DBE221002_ChosahyoKihonchosaKatamen");
    private static final RString DBE221012 = new RString("DBE221012_chosahyoKihonchosa");
    private static final RString DBE221024_NASHI_COLOR = new RString("DBE221024_chosahyoTokkijiko_Nashi_Color");
    private static final RString DBE221024_NASHI_MONO = new RString("DBE221024_chosahyoTokkijiko_Nashi_Mono");
    private static final RString DBE221021_ARI_COLOR = new RString("DBE221021_chosahyoTokkijiko_Ari_Color");
    private static final RString DBE221021_ARI_MONO = new RString("DBE221021_chosahyoTokkijiko_Ari_Mono");
    private static final RString DBE221042_RYOMEN = new RString("DBE221042_tokkijikoOCR_Ryomen");
    private static final RString DBE221042_KATAMEN = new RString("DBE221042_tokkijikoOCR_Katamen");
    private static final RString DBE221031_FREE_COLOR = new RString("DBE221031_chosahyoTokkijiko_Free_Color");
    private static final RString DBE221031_FREE_MONO = new RString("DBE221031_chosahyoTokkijiko_Free_Mono");
    private static final RString DBE231011_RYOMEN_COLOR = new RString("DBE231011_ikenshokinyuyoshiOCR_Ryomen_Color");
    private static final RString DBE231011_KATAMEN_COLOR = new RString("DBE231011_ikenshokinyuyoshiOCR_Katamen_Color");
    private static final RString DBE231012 = new RString("DBE231012_ikenshokinyuyoshiOCR");
    private static final RString DBE231014 = new RString("DBE231014_ikenshokinyuyoshiOCR");
    private static final RString DBE231001_RYOMEN_MONO = new RString("DBE231001_ikenshokinyuyoshi_Ryomen_Mono");
    private static final RString DBE231001_KATAMEN_MONO = new RString("DBE231001_ikenshokinyuyoshi_Katamen_Mono");
    private static final RString 排他キー = new RString("ShinseishoKanriNo");

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onLoad(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        if (!RealInitialLocker.tryGetLock(new LockingKey(排他キー))) {
            throw new PessimisticLockingException();
        }

        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null) {
            getHandler(div).initialize(model.get申請書管理番号リスト(), model.get遷移元画面区分());
        }
        getHandler(div).setChkIkenshoSakuseiryoSeikyusho();
        getHandler(div).setRadJyushinKikan();
        getHandler(div).setRadTeishutsuKigen();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険診断命令書 チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkIkenshoSakuseiryoSeikyusho(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setChkIkenshoSakuseiryoSeikyusho();
        return ResponseData.of(div).respond();
    }

    /**
     * 受診期間 ラジオボタンのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_radJyushinKikan(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setRadJyushinKikan();
        return ResponseData.of(div).clearValidateMessage().respond();
    }

    /**
     * 提出期限 ラジオボタンのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_radTeishutsuKigen(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setRadTeishutsuKigen();
        return ResponseData.of(div).clearValidateMessage().respond();
    }

    /**
     * 戻るボタンを押す処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onClick_btnModoru(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        if (getHandler(div).isUpdate()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RealInitialLocker.release(new LockingKey(排他キー));
                return ResponseData.of(div).dialogOKClose();
            }
        } else {
            RealInitialLocker.release(new LockingKey(排他キー));
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択された帳票を発行するボタンを押すバリデーションチェック処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onClick_btnPrintValidation(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(DbQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 選択された帳票を発行するボタンを押す処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnPrint(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            printData(div, reportManager);
            response.data = reportManager.publish();
        }
        updateData(div);
        RealInitialLocker.release(new LockingKey(排他キー));
        return response;
    }

    /**
     * 発行押下後、画面のデータを最新化する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onClick_btnPrintKanryo(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null) {
            getHandler(div).initialize(model.get申請書管理番号リスト(), model.get遷移元画面区分());
        }
        return ResponseData.of(div).respond();
    }
    
    private void updateData(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (GamenSeniKbn.認定調査依頼.equals(model.get遷移元画面区分())) {
            List<dgNinteiChosa_Row> selectedItems = div.getDgNinteiChosa().getDataSource();

            for (dgNinteiChosa_Row row : selectedItems) {
                update認定調査依頼情報(div, row);
            }
        }
        if (GamenSeniKbn.主治医意見書依頼.equals(model.get遷移元画面区分())) {
            List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getSelectedItems();
            for (dgShujiiIkensho_Row row : selectedItems) {
                update主治医意見書依頼情報(div, row);
            }
        }
    }

    private void update主治医意見書依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgShujiiIkensho_Row row) {
        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> models = ViewStateHolder.get(ViewStateKeys.主治医意見書依頼情報, Models.class);
        ShujiiIkenshoIraiJohoIdentifier identifier = new ShujiiIkenshoIraiJohoIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.parseInt(row.getRirekiNo().toString()));

        ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = models.get(identifier);
        ShujiiIkenshoIraiJohoBuilder shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJoho.createBuilderForEdit();
        RString radTeishutsuKigen = div.getRadTeishutsuKigen().getSelectedKey();
        RDate date = RDate.getNowDate();
        RString 期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, date, SubGyomuCode.DBE認定支援);
        int 作成期限日数
                = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, date, SubGyomuCode.DBE認定支援).toString());
        FlexibleDate 作成期限年月日 = null;
        if (CONFIGVALUE1.equals(期限設定方法)) {
            if (KEY0.equals(radTeishutsuKigen)) {
                FlexibleDate 依頼年月日 = shujiiIkenshoIraiJoho.get主治医意見書作成依頼年月日();
                作成期限年月日 = 依頼年月日.plusDay(作成期限日数);
            } else if (KEY1.equals(radTeishutsuKigen)) {
                作成期限年月日 = FlexibleDate.EMPTY;
            } else if (KEY2.equals(radTeishutsuKigen)) {
                RDate 共通日 = div.getTxtKyotsuDay().getValue();
                作成期限年月日
                        = (共通日 == null ? FlexibleDate.EMPTY : new FlexibleDate(共通日.plusDay(作成期限日数).toDateString()));
            }
        } else if (CONFIGVALUE2.equals(期限設定方法)) {
            作成期限年月日 = new FlexibleDate(new RDate(row.getNinteiShinseibi().toString()).toDateString()).plusDay(作成期限日数);
        }
        shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set主治医意見書作成期限年月日(作成期限年月日);
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        if (!div.getChkInsatsuIkensho().getSelectedKeys().isEmpty()) {
            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set依頼書出力年月日(システム日付);
        }
        List<RString> selectedKeys = div.getChkIkenshoSakuseiIchiran().getSelectedKeys();
        if (selectedKeys.contains(KEY0) || selectedKeys.contains(KEY1)) {
            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set意見書出力年月日(システム日付);
        }
        ShujiiIkenshoIraiJohoManager.createInstance().save主治医意見書作成依頼情報(shujiiIkenshoIraiJohoBuilder.build().modifiedModel());
    }

    private void update認定調査依頼情報(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row) {
        NinteichosaIraiJohoIdentifier identifier = new NinteichosaIraiJohoIdentifier(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.parseInt(row.getRirekiNo().toString()));
        Models<NinteichosaIraiJohoIdentifier, NinteichosaIraiJoho> models = ViewStateHolder.get(ViewStateKeys.認定調査依頼情報, Models.class);
        NinteichosaIraiJoho ninteichosaIraiJoho = models.get(identifier);
        NinteichosaIraiJohoBuilder ninteichosaIraiJohoBuilder = ninteichosaIraiJoho.createBuilderForEdit();
        RString radTeishutsuKigen = div.getRadTeishutsuKigen().getSelectedKey();
        RDate date = RDate.getNowDate();
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, date, SubGyomuCode.DBE認定支援);
        int 認定調査作成期限日数
                = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, date, SubGyomuCode.DBE認定支援).toString());
        FlexibleDate 認定調査期限年月日 = null;
        if (CONFIGVALUE1.equals(認定調査期限設定方法)) {
            if (KEY0.equals(radTeishutsuKigen)) {
                FlexibleDate 認定調査依頼年月日 = ninteichosaIraiJoho.get認定調査依頼年月日();
                認定調査期限年月日 = 認定調査依頼年月日.plusDay(認定調査作成期限日数);
            } else if (KEY1.equals(radTeishutsuKigen)) {
                認定調査期限年月日 = FlexibleDate.EMPTY;
            } else if (KEY2.equals(radTeishutsuKigen)) {
                RDate 共通日 = div.getTxtKyotsuDay().getValue();
                認定調査期限年月日
                        = (共通日 == null ? FlexibleDate.EMPTY : new FlexibleDate(共通日.plusDay(認定調査作成期限日数).toDateString()));
            }
        } else if (CONFIGVALUE2.equals(認定調査期限設定方法)) {
            認定調査期限年月日 = new FlexibleDate(new RDate(row.getNinteiShinseibi().toString()).plusDay(認定調査作成期限日数).toDateString());
        }
        ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set認定調査期限年月日(認定調査期限年月日);
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        if (!div.getChk().getSelectedKeys().isEmpty()) {
            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set依頼書出力年月日(システム日付);
        }
        if (!div.getChkChosahyo().getSelectedKeys().isEmpty()
                || !div.getChkOcrChosahyo().getSelectedKeys().isEmpty()) {
            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set調査票等出力年月日(システム日付);
        }
        NinteichosaIraiJohoManager.createInstance().save認定調査依頼情報(ninteichosaIraiJohoBuilder.build().modifiedModel());
    }

    private void printData(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ReportManager reportManager) {
        ChosaIraishoAndChosahyoAndIkenshoPrintService printService = new ChosaIraishoAndChosahyoAndIkenshoPrintService(reportManager);
        List<RString> chk = div.getChk().getSelectedKeys();
        if (chk.contains(KEY0)) {
            printService.print要介護認定調査依頼書(getHandler(div).create認定調査依頼書印刷用パラメータ());
        }
        if (chk.contains(KEY1)) {
            printService.print認定調査依頼一覧表(getHandler(div).create認定調査依頼一覧表印刷用パラメータ());
        }
        List<RString> chkChosahyo = div.getChkChosahyo().getSelectedKeys();
        if (chkChosahyo.contains(KEY0)) {
            call認定調査票_概況調査(div, printService);
        }
        if (chkChosahyo.contains(KEY1)) {
            call認定調査票_基本調査(div, printService);
        }
        if (chkChosahyo.contains(KEY2)) {
            call認定調査票_特記事項(div, printService);
        }
//        概況特記の帳票不明
//        if (chkChosahyo.contains(KEY3)) {
//
//        }
        List<RString> chkOcrChosahyo = div.getChkOcrChosahyo().getSelectedKeys();
        if (chkOcrChosahyo.contains(KEY0)) {
            call認定調査票OCR_概況調査(div, printService);
        }
        if (chkOcrChosahyo.contains(KEY1)) {
            call認定調査票OCR_基本調査(div, printService);
        }
        if (chkOcrChosahyo.contains(KEY2)) {
            call認定調査票OCR_特記事項(div, printService);
        }
//        概況特記OCR不明
//        if (chkOcrChosahyo.contains(KEY3)) {
//
//        }
        List<RString> chkChosahyo2 = div.getChkChosahyo2().getSelectedKeys();
        if (chkChosahyo2.contains(KEY0)) {
            call認定調査差異チェック表(div, printService);
        }
        if (chkChosahyo2.contains(KEY1)) {
            call認定調査票_特記事項_フリー様式(div, printService);
        }
        List<RString> chkInsatsuIkensho = div.getChkInsatsuIkensho().getSelectedKeys();
        if (chkInsatsuIkensho.contains(KEY0)) {
            printService.print意見書作成依頼書(getHandler(div).create意見書作成依頼書_パラメータ());
        }
        if (chkInsatsuIkensho.contains(KEY1)) {
            printService.print意見書作成依頼一覧表(getHandler(div).create意見書作成依頼一覧表_パラメータ());
        }
        List<RString> ichiran = div.getChkIkenshoSakuseiIchiran().getSelectedKeys();
        if (ichiran.contains(KEY0)) {
            call主治医意見書記入用紙(div, printService);
        }
        if (ichiran.contains(KEY1)) {
            call主治医意見書記入用紙OCR(div, printService);
        }
        if (ichiran.contains(KEY2)) {
            create主治医意見書記入用紙D(div, printService);
        }
        List<RString> seikyusho = div.getChkIkenshoSakuseiryoSeikyusho().getSelectedKeys();
        if (seikyusho.contains(KEY0)) {
            printService.print主治医意見書作成料請求書(getHandler(div).create主治医意見書作成料請求書_パラメータ());
        }
        if (seikyusho.contains(KEY1)) {
            printService.print介護保険診断命令書(getHandler(div).create介護保険診断命令書_パラメータ());
        }
        if (seikyusho.contains(KEY2)) {
            printService.print介護保険指定医依頼兼主治医意見書提出意見書(getHandler(div).create介護保険指定医依頼兼主治医意見書提出意見書_パラメータ());
        }
    }

    private void call主治医意見書記入用紙(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー片面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙カラー両面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            }
        }
        if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ片面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォーム白紙モノクロ両面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            }
        }
    }

    private void call主治医意見書記入用紙OCR(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面1, date,
                        SubGyomuCode.DBE認定支援), div, printService);
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面2, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート両面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            }
        }
    }
    
    private void create主治医意見書記入用紙D(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面1, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.意見書印刷フォームデザインシート片面2, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            }
        }
    }
    
    private void call認定調査差異チェック表(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            printService.print要介護認定調査票差異チェック票_片面(getHandler(div).create調査票差異チェック票_DBE292004パラメータ());
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            printService.print要介護認定調査票差異チェック票_両面右(getHandler(div).create調査票差異チェック票_DBE292004パラメータ());
        } else if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            printService.print要介護認定調査票差異チェック票_両面左(getHandler(div).create調査票差異チェック票_DBE292004パラメータ());
        }
    }

    private void call認定調査票OCR_概況調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート片面1枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート片面2枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォームデザインシート両面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
    }

    private void call認定調査票OCR_特記事項(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート片面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォームデザインシート両面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            }
        }
    }

    private void call認定調査票OCR_基本調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート片面1枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート片面2枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォームデザインシート両面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
    }

    private void call認定調査票_概況調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー片面1枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー片面2枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況調査_印刷フォーム白紙カラー両面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
    }

    private void call認定調査票_特記事項(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))
                && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙カラー片面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
        if (CONFIGVALUE3.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))
                && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム白紙モノクロ片面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
        if (CONFIGVALUE4.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_用紙タイプ, date, SubGyomuCode.DBE認定支援))) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自片面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項_印刷フォーム独自両面, date,
                        SubGyomuCode.DBE認定支援), div, printService);
            }
        }
    }

    private void call認定調査票_特記事項_フリー様式(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項フリー_用紙タイプ, date, SubGyomuCode.DBE認定支援))
                && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項フリー_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項フリー_印刷フォーム白紙カラー片面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
        if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項フリー_用紙タイプ, date, SubGyomuCode.DBE認定支援))
                && CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項フリー_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_特記事項フリー_印刷フォーム白紙モノクロ片面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
    }

    private void call認定調査票_基本調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー片面1枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー片面2枚目, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            getExecuteStep(DbBusinessConfig.get(ConfigNameDBE.認定調査票_基本調査_印刷フォーム白紙カラー両面, date,
                    SubGyomuCode.DBE認定支援), div, printService);
        }
    }

    private void getExecuteStep(RString rseValue, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {

        if (DBE221001_KATAMEN.equals(rseValue) || DBE221001_RYOMEN.equals(rseValue) || DBE221001.equals(rseValue)) {
            printService.print認定調査票_概況調査(getHandler(div).create認定調査票_概況調査パラメータ());
        }

        if (DBE221002_KATAMEN.equals(rseValue) || DBE221012.equals(rseValue)) {
            printService.print認定調査票_基本調査(getHandler(div).create認定調査票_基本調査パラメータ());
        }

        if (DBE221021_ARI_COLOR.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221021_Ari_Color.getReportId());
        }
        if (DBE221021_ARI_MONO.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221021_Ari_Mono.getReportId());
        }
        if (DBE221042_RYOMEN.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221042_Ryomen.getReportId());
        }

        if (DBE221042_KATAMEN.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221042_Katamen.getReportId());
        }

        if (DBE221024_NASHI_COLOR.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221024_Nashi_Color.getReportId());
        }

        if (DBE221024_NASHI_MONO.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221024_Nashi_Mono.getReportId());
        }

        if (DBE221031_FREE_COLOR.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221024_Nashi_Mono.getReportId());
        }

        if (DBE221031_FREE_MONO.equals(rseValue)) {
            printService.print認定調査票_特記事項(
                    getHandler(div).create認定調査票_特記事項パラメータ(), ReportIdDBZ.DBE221024_Nashi_Mono.getReportId());
        }

        if (DBE231011_RYOMEN_COLOR.equals(rseValue)) {
            printService.print主治医意見書記入用紙(
                    getHandler(div).create主治医意見書記入情報1_パラメータ(), ReportIdDBZ.DBE231011_Ryomen_Color.getReportId());
        }

        if (DBE231011_KATAMEN_COLOR.equals(rseValue)) {
            printService.print主治医意見書記入用紙(
                    getHandler(div).create主治医意見書記入情報2_パラメータ(), ReportIdDBZ.DBE231011_Katamen_Color.getReportId());
        }

        if (DBE231001_RYOMEN_MONO.equals(rseValue)) {
            printService.print主治医意見書記入用紙(
                    getHandler(div).create主治医意見書記入情報3_パラメータ(), ReportIdDBZ.DBE231001_Ryomen_Mono.getReportId());
        }

        if (DBE231001_KATAMEN_MONO.equals(rseValue)) {
            printService.print主治医意見書記入用紙(
                    getHandler(div).create主治医意見書記入情報3_パラメータ(), ReportIdDBZ.DBE231001_Katamen_Mono.getReportId());
        }
        
        if (DBE231012.equals(rseValue)) {
            printService.print主治医意見書記入用紙(
                    getHandler(div).create主治医意見書記入情報1_パラメータ(), ReportIdDBZ.DBE231012.getReportId());
        }
        
        if (DBE231014.equals(rseValue)) {
            printService.print主治医意見書記入用紙(
                    getHandler(div).create主治医意見書記入情報1_パラメータ(), ReportIdDBZ.DBE231014.getReportId());
        }
    }

    private ChosaIraishoAndChosahyoAndIkenshoPrintHandler getHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new ChosaIraishoAndChosahyoAndIkenshoPrintHandler(div);
    }

    private PrintValidationHandler getValidationHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new PrintValidationHandler(div);
    }
}
