/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.business.report.chosahyomatome.ChosahyoMatomeItem;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshoassortment.IkenshoAssortmentItem;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.PrintValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.dgNinteiChosa_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.dgShujiiIkensho_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyomatome.ChosahyoMatomeLayout;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshoassortment.IkenshoAssortmentLayout;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
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
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final RString まとめて印刷する = new RString("matome");
    private static final RString 意見書依頼書 = new RString("iraisho");
    private static final RString 意見書提出用 = new RString("teishutsu");
    private static final RString 命令書 = new RString("meireisho");

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onLoad(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null && model.get申請書管理番号リスト() != null) {
            getHandler(div).initialize(model.get申請書管理番号リスト(), model.get市町村コード(), model.get遷移元画面区分());
        } else if (model != null && model.get申請書管理番号リスト() == null) {
            getHandler(div).initialize白紙(model.get市町村コード(), model.get遷移元画面区分());
        }
        getHandler(div).setChkShindanMeireisho();
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
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkShindanMeireisho(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setChkShindanMeireisho();
        return ResponseData.of(div).respond();
    }

    /**
     * 主事意見書請求書 チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkIkenshoSeikyusho(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
        if (請求書選択selectedKeys.isEmpty()) {
            getHandler(div).setChkIkenshoIraisho();
        } else {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateIkenshoIraisho();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主事意見書作成依頼書 チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkIkenshoIraisho(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setChkIkenshoSeikyusho();
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票(特記事項) チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkChosahyoKatamen(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
        if (調査票選択selectedKeys.contains(KEY2)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateTokkijiko();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票(特記事項) チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkChosahyoRyomen(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
        if (調査票両面選択selectedKeys.contains(KEY2)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateTokkijiko();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票(特記事項) チェックボックスのonChange処理です。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkChosahyoTokki(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
        if (!委託特記事項選択selectedKeys.isEmpty()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateTokkijiko();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
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
     * 白紙で印刷する チェックボックスのonChange処理です。
     * 
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onChange_chkPrintBlank(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        getHandler(div).setCheckBoxPrintBlank();
        return ResponseData.of(div).respond();
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
        return ResponseData.of(div).dialogOKClose();
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
    public ResponseData onClick_btnPrint(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
        if (div.getChkPrintMatome().getSelectedKeys().contains(まとめて印刷する)) {
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService = new ChosaIraishoAndChosahyoAndIkenshoPrintService(reportManager);
            callまとめて出力(div, printService);
            callまとめて出力_まとめない帳票(div, printService);
        } else {
            printData(div, reportManager);
        }
        
        response.data = reportManager.publish();
        }
        if (response.data.iterator().hasNext()) {
            updateData(div);
            ViewStateHolder.put(ViewStateKeys.帳票制御共通, new RString("成功"));
            return response;
        } else {
            ViewStateHolder.put(ViewStateKeys.帳票制御共通, new RString("失敗"));
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 発行押下後、ViewStateHolderのデータを最新化する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onClick_btnPrintKanryo(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        if (!ResponseHolder.isReRequest() && new RString("失敗").equals(ViewStateHolder.get(ViewStateKeys.帳票制御共通, RString.class))) {
            return ResponseData.of(div).addMessage(new InformationMessage(DbzErrorMessages.実行不可.getMessage().replace("ページ数が０の", "印刷").getCode(),
                    DbzErrorMessages.実行不可.getMessage().replace("ページ数が０の", "印刷").evaluate())).respond();
        }
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null && model.get申請書管理番号リスト() != null) {
            RString 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value();
            ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(model.get申請書管理番号リスト(),
                    証記載保険者番号);
            ChosaIraishoAndChosahyoAndIkenshoPrintFinder printFinder = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance();
            if (GamenSeniKbn.認定調査依頼.equals(model.get遷移元画面区分())) {
                List<NinteichosaIraiJoho> 認定調査依頼情報List = printFinder.get更新用認定調査依頼情報(parameter).records();
                ViewStateHolder.put(ViewStateKeys.認定調査依頼情報, Models.create(認定調査依頼情報List));
            } else {
                List<ShujiiIkenshoIraiJoho> 主治医意見書依頼情報List = printFinder.get更新用主治医意見書依頼情報(parameter).records();
                ViewStateHolder.put(ViewStateKeys.主治医意見書依頼情報, Models.create(主治医意見書依頼情報List));
            }
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
            List<dgShujiiIkensho_Row> selectedItems = div.getDgShujiiIkensho().getDataSource();
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

        FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkoYMD().getValue().toString());
        if (!div.getChkIkenshoIraisho().getSelectedKeys().isEmpty()) {
            RString radTeishutsuKigen = div.getRadTeishutsuKigen().getSelectedKey();
            RDate date = RDate.getNowDate();
            RString 期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, date, SubGyomuCode.DBE認定支援,
                    div.getCcdHokenshaList().getSelectedItem().get市町村コード().value());
            int 作成期限日数
                    = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, date, SubGyomuCode.DBE認定支援,
                                    div.getCcdHokenshaList().getSelectedItem().get市町村コード().value()).toString());
            FlexibleDate 作成期限年月日 = null;
            if (KEY0.equals(radTeishutsuKigen)) {
                if (CONFIGVALUE1.equals(期限設定方法)) {
                    FlexibleDate 依頼年月日 = shujiiIkenshoIraiJoho.get主治医意見書作成依頼年月日();
                    作成期限年月日 = 依頼年月日.plusDay(作成期限日数);
                } else if (CONFIGVALUE2.equals(期限設定方法)) {
                    作成期限年月日 = new FlexibleDate(new RDate(row.getNinteiShinseibi().toString()).toDateString()).plusDay(作成期限日数);
                }
            } else if (KEY1.equals(radTeishutsuKigen)) {
                作成期限年月日 = FlexibleDate.EMPTY;
            } else if (KEY2.equals(radTeishutsuKigen)) {
                RDate 共通日 = div.getTxtKyotsuDay().getValue();
                作成期限年月日
                        = (共通日 == null ? FlexibleDate.EMPTY : new FlexibleDate(共通日.toDateString()));
            }
            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set主治医意見書作成期限年月日(作成期限年月日);

            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set依頼書出力年月日(発行日);
        }

        if (!div.getChkIkensho().getSelectedKeys().isEmpty()) {
            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set意見書出力年月日(発行日);
        }

        if (!div.getChkShindanMeireisho().getSelectedKeys().isEmpty()) {
            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set介護保険診断命令書発行有無(true);
            shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信場所(div.getShindanMeirei().getTxtJushinBasho().getValue());
            RString radJyushinKikan = div.getShindanMeirei().getRadJyushinKikan().getSelectedKey();
            if (KEY0.equals(radJyushinKikan)) {
                shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信期間区分(new Code(KEY1));
                shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信日(new FlexibleDate(div.getShindanMeirei().getTxtJyushinymd().getValue().toDateString()));
                RString 受信時分 = new RString(String.format("%02d", div.getShindanMeirei().getTxtJushinTime().getValue().getHour())
                        + String.format("%02d", div.getShindanMeirei().getTxtJushinTime().getValue().getMinute()));
                shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信時分(受信時分);
            } else {
                shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信期間区分(new Code(KEY2));
                shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信期間開始(new FlexibleDate(div.getShindanMeirei().getTxtJushinKikan().getFromValue().toDateString()));
                shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set受信期間終了(new FlexibleDate(div.getShindanMeirei().getTxtJushinKikan().getToValue().toDateString()));
            }
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

        FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkoYMD().getValue().toString());
        if (!div.getChkIraisho().getSelectedKeys().isEmpty()) {
            RString radTeishutsuKigen = div.getRadTeishutsuKigen().getSelectedKey();
            RDate date = RDate.getNowDate();
            RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, date, SubGyomuCode.DBE認定支援,
                    div.getCcdHokenshaList().getSelectedItem().get市町村コード().value());
            int 認定調査作成期限日数
                    = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, date, SubGyomuCode.DBE認定支援,
                                    div.getCcdHokenshaList().getSelectedItem().get市町村コード().value()).toString());
            FlexibleDate 認定調査期限年月日 = null;
            if (KEY0.equals(radTeishutsuKigen)) {
                if (CONFIGVALUE1.equals(認定調査期限設定方法)) {
                    FlexibleDate 認定調査依頼年月日 = ninteichosaIraiJoho.get認定調査依頼年月日();
                    認定調査期限年月日 = 認定調査依頼年月日.plusDay(認定調査作成期限日数);
                } else if (CONFIGVALUE2.equals(認定調査期限設定方法)) {
                    認定調査期限年月日 = new FlexibleDate(new RDate(row.getNinteiShinseibi().toString()).plusDay(認定調査作成期限日数).toDateString());
                }
            } else if (KEY1.equals(radTeishutsuKigen)) {
                認定調査期限年月日 = FlexibleDate.EMPTY;
            } else if (KEY2.equals(radTeishutsuKigen)) {
                RDate 共通日 = div.getTxtKyotsuDay().getValue();
                認定調査期限年月日
                        = (共通日 == null ? FlexibleDate.EMPTY : new FlexibleDate(共通日.toDateString()));
            }
            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set認定調査期限年月日(認定調査期限年月日);

            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set依頼書出力年月日(発行日);
        }

        if (div.getChkChosahyoKatamen().getSelectedKeys().contains(KEY0)
                || div.getChkChosahyoRyomen().getSelectedKeys().contains(KEY0)) {
            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set調査票等出力年月日(発行日);
        }

        NinteichosaIraiJohoManager.createInstance().save認定調査依頼情報(ninteichosaIraiJohoBuilder.build().modifiedModel());
    }

    private void printData(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ReportManager reportManager) {

        RString 保険者市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        ShoKisaiHokenshaNo 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        ChosaIraishoAndChosahyoAndIkenshoPrintService printService = new ChosaIraishoAndChosahyoAndIkenshoPrintService(reportManager);

        List<RString> 依頼書選択selectedKeys = div.getChkIraisho().getSelectedKeys();
        if (依頼書選択selectedKeys.contains(KEY0)) {
            printService.print要介護認定調査依頼書(getHandler(div).create認定調査依頼書印刷用パラメータ(), 証記載保険者番号);
        }
        if (依頼書選択selectedKeys.contains(KEY1)) {
            printService.print認定調査依頼一覧表(getHandler(div).create認定調査依頼一覧表印刷用パラメータ(), 証記載保険者番号);
        }

        List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
        if (調査票選択selectedKeys.contains(KEY0) && 調査票選択selectedKeys.contains(KEY1)) {
            call認定調査票両面_概況AND基本調査(div, printService, 保険者市町村コード);
        } else if (調査票選択selectedKeys.contains(KEY0)) {
            call認定調査票_概況調査(div, printService, 保険者市町村コード);
        } else if (調査票選択selectedKeys.contains(KEY1)) {
            call認定調査票_基本調査(div, printService, 保険者市町村コード);
        }
        if (調査票選択selectedKeys.contains(KEY2)) {
            call認定調査票_特記事項(div, printService, 保険者市町村コード);
        }

        List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
        if (調査票両面選択selectedKeys.contains(KEY0)) {
            call認定調査票両面_概況AND基本調査(div, printService, 保険者市町村コード);
        }
        if (調査票両面選択selectedKeys.contains(KEY2)) {
            call認定調査票両面_特記事項(div, printService, 保険者市町村コード);
        }

        List<RString> 概況特記選択selectedKeys = div.getChkChosahyoGaikyo().getSelectedKeys();
        if (概況特記選択selectedKeys.contains(KEY0)) {
            printService.print認定調査票_概況調査(getHandler(div).create認定調査票_概況調査パラメータ(), ReportIdDBZ.DBE221051.getReportId());
        }

        List<RString> 差異チェック票選択selectedKeys = div.getChkChosahyoSai().getSelectedKeys();
        if (差異チェック票選択selectedKeys.contains(KEY0)) {
            call認定調査差異チェック表(div, printService, 保険者市町村コード);
        }

        List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
        if (委託特記事項選択selectedKeys.contains(KEY0)) {
            call認定調査票_特記事項_調査群記載あり(div, printService, 保険者市町村コード);
        }
        if (委託特記事項選択selectedKeys.contains(KEY1)) {
            call認定調査票_特記事項_フリー様式(div, printService, 保険者市町村コード);
        }

        List<RString> 意見書依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
        if (意見書依頼書選択selectedKeys.contains(KEY0)) {
            printService.print意見書作成依頼書(getHandler(div).create意見書作成依頼書_パラメータ(), 証記載保険者番号);
        }
        if (意見書依頼書選択selectedKeys.contains(KEY1)) {
            printService.print意見書作成依頼一覧表(getHandler(div).create意見書作成依頼一覧表_パラメータ(), 証記載保険者番号);
        }
        if (意見書依頼書選択selectedKeys.contains(KEY2)) {
            printService.print介護保険指定医依頼兼主治医意見書提出意見書(getHandler(div).create介護保険指定医依頼兼主治医意見書提出意見書_パラメータ(), 証記載保険者番号);
        }

        List<RString> 意見書選択selectedKeys = div.getChkIkensho().getSelectedKeys();
        if (意見書選択selectedKeys.contains(KEY0)) {
            call主治医意見書記入用紙(div, printService, 保険者市町村コード);
        }

        List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
        if (請求書選択selectedKeys.contains(KEY0)) {
            printService.print主治医意見書作成料請求書(getHandler(div).create主治医意見書作成料請求書_パラメータ());
        }

        List<RString> 診断命令書選択selectedKeys = div.getChkShindanMeireisho().getSelectedKeys();
        if (診断命令書選択selectedKeys.contains(KEY0)) {
            printService.print介護保険診断命令書(getHandler(div).create介護保険診断命令書_パラメータ(), 証記載保険者番号);
        }
    }
    
    private void callまとめて出力(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        
        RString 保険者市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        ShoKisaiHokenshaNo 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();
        
        ChosaIraishoAndChosahyoAndIkenshoPrintHandler handler = getHandler(div);
        boolean isRyomen = false;
        if (!div.getDgNinteiChosa().getDataSource().isEmpty()) {
            List<ChosahyoMatomeItem> params = new ArrayList<>();
            List<RString> 依頼書選択selectedKeys = div.getChkIraisho().getSelectedKeys();
            List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
            List<RString> 調査票両面選択selectedKeys = div.getChkChosahyoRyomen().getSelectedKeys();
            List<RString> 概況特記選択selectedKeys = div.getChkChosahyoGaikyo().getSelectedKeys();
            List<RString> 委託特記事項選択selectedKeys = div.getChkChosahyoTokki().getSelectedKeys();
            int 宛名連番 = 1;
            for (dgNinteiChosa_Row row : div.getDgNinteiChosa().getDataSource()) {
                
                if (依頼書選択selectedKeys.contains(KEY0)) {
                    ChosahyoMatomeItem item = handler.create認定調査依頼書印刷用パラメータ_個人別(row, 宛名連番);
                    item.setLayout(ChosahyoMatomeLayout.認定調査依頼書);
                    params.add(item);
                }
    //            if (調査票選択selectedKeys.contains(KEY0) && 調査票選択selectedKeys.contains(KEY1)) {
    //                add認定調査票両面_概況AND基本調査パラメータ(params, div, row, 保険者市町村コード);
    //            } else 
                if (調査票選択selectedKeys.contains(KEY0)) {
                    add認定調査票_概況調査(params, div, row, 保険者市町村コード);
                }
                if (調査票選択selectedKeys.contains(KEY1)) {
                    add認定調査票_基本調査(params, div, row, 保険者市町村コード);
                }
                if (調査票選択selectedKeys.contains(KEY2)) {
                    add認定調査票_特記事項(params, div, row, 保険者市町村コード);
                }
                if (調査票両面選択selectedKeys.contains(KEY0)) {
                    add認定調査票両面_概況AND基本調査(params, div, row, 保険者市町村コード);
                    isRyomen = true;
                }
                if (調査票両面選択selectedKeys.contains(KEY2)) {
                    add認定調査票両面_特記事項(params, div, row, 保険者市町村コード);
                    isRyomen = true;
                }
                if (概況特記選択selectedKeys.contains(KEY0)) {
                    ChosahyoMatomeItem item = handler.create認定調査票_概況調査パラメータ_個人別(row);
                    item.setLayout(ChosahyoMatomeLayout.認定調査票_概況特記_OCR);
                    params.add(item);
                }

                if (委託特記事項選択selectedKeys.contains(KEY0)) {
                    add認定調査票_特記事項_調査群記載あり(params, div, row, 保険者市町村コード);
                }
                if (委託特記事項選択selectedKeys.contains(KEY1)) {
                    add認定調査票_特記事項_フリー様式(params, div, row, 保険者市町村コード);
                }
                宛名連番++;
            }
            if (!params.isEmpty()) {
                printService.print調査票個人別(params, isRyomen, 証記載保険者番号);
            }
        }
        
        if (!div.getDgShujiiIkensho().getDataSource().isEmpty()) {
            int 宛名連番 = 1;
            int 連番 = 1;
            List<IkenshoAssortmentItem> params = new ArrayList<>();
            List<RString> 意見書依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
            List<RString> 意見書選択selectedKeys = div.getChkIkensho().getSelectedKeys();
            List<RString> 請求書選択selectedKeys = div.getChkIkenshoSeikyusho().getSelectedKeys();
            List<RString> 診断命令書選択selectedKeys = div.getChkShindanMeireisho().getSelectedKeys();
            Set<RString> ninteiHantei = new HashSet<>();

            for (dgShujiiIkensho_Row row : div.getDgShujiiIkensho().getDataSource()) {
                if (意見書依頼書選択selectedKeys.contains(KEY0)) {
                    ninteiHantei.add(意見書依頼書);
                    IkenshoAssortmentItem item = handler.create意見書作成依頼書_パラメータ_個人別(row, 宛名連番, 連番);
                    item.setLayout(IkenshoAssortmentLayout.主治医意見書作成依頼書);
                    params.add(item);
                    連番++;
                }
                if (意見書依頼書選択selectedKeys.contains(KEY2)) {
                    連番++;
                    ninteiHantei.add(意見書提出用);
                    IkenshoAssortmentItem item = handler.create介護保険指定医依頼兼主治医意見書提出意見書_パラメータ_個人別(row, 宛名連番);
                    item.setLayout(IkenshoAssortmentLayout.介護保険指定医依頼兼主治医意見書提出依頼書);
                    params.add(item);
                }


                if (意見書選択selectedKeys.contains(KEY0)) {
                    連番++;
                    add主治医意見書記入用紙(params, handler, row, 保険者市町村コード);
                    isRyomen = true;
                }

                if (請求書選択selectedKeys.contains(KEY0)) {
                    連番++;
                    IkenshoAssortmentItem item = handler.create主治医意見書作成料請求書_パラメータ_個人別(row);
                    item.setLayout(IkenshoAssortmentLayout.主治医意見書作成料請求書);
                    params.add(item);
                }

                if (診断命令書選択selectedKeys.contains(KEY0)) {
                    連番++;
                    ninteiHantei.add(命令書);
                    IkenshoAssortmentItem item = handler.create介護保険診断命令書_パラメータ_個人別(row, 宛名連番);
                    item.setLayout(IkenshoAssortmentLayout.介護保険診断命令書);
                    params.add(item);
                }
                宛名連番++;
            }
            if (!params.isEmpty()) {
                printService.print意見書個人別(params, isRyomen, ninteiHantei, 証記載保険者番号);
            }
        }
        
    }
    
    private void callまとめて出力_まとめない帳票(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RString 保険者市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        ShoKisaiHokenshaNo 証記載保険者番号 = div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号();

        List<RString> 依頼書選択selectedKeys = div.getChkIraisho().getSelectedKeys();
        if (依頼書選択selectedKeys.contains(KEY1)) {
            printService.print認定調査依頼一覧表(getHandler(div).create認定調査依頼一覧表印刷用パラメータ(), 証記載保険者番号);
        }
        List<RString> 差異チェック票選択selectedKeys = div.getChkChosahyoSai().getSelectedKeys();
        if (差異チェック票選択selectedKeys.contains(KEY0)) {
            call認定調査差異チェック表(div, printService, 保険者市町村コード);
        }
        
        List<RString> 意見書依頼書選択selectedKeys = div.getChkIkenshoIraisho().getSelectedKeys();
        if (意見書依頼書選択selectedKeys.contains(KEY1)) {
            printService.print意見書作成依頼一覧表(getHandler(div).create意見書作成依頼一覧表_パラメータ(), 証記載保険者番号);
        }
    }

    private void call主治医意見書記入用紙(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 表_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 裏_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        List<IkenshokinyuyoshiBusiness> param = getHandler(div).create主治医意見書記入情報1_パラメータ();
        printService.print主治医意見書記入用紙(param, new ReportId(表_帳票ID));
        if (!表_帳票ID.equals(裏_帳票ID)) {
            printService.print主治医意見書記入用紙(param, new ReportId(裏_帳票ID));
        }
    }

    private void call認定調査差異チェック表(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 差異チェック票_印刷タイプ = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (CONFIGVALUE1.equals(差異チェック票_印刷タイプ)) {
            printService.print要介護認定調査票差異チェック票_片面(getHandler(div).create調査票差異チェック票_DBE292004パラメータ());
        } else if (CONFIGVALUE2.equals(差異チェック票_印刷タイプ)) {
            printService.print要介護認定調査票差異チェック票_両面左(getHandler(div).create調査票差異チェック票_DBE292004パラメータ());
        } else if (CONFIGVALUE3.equals(差異チェック票_印刷タイプ)) {
            printService.print要介護認定調査票差異チェック票_両面右(getHandler(div).create調査票差異チェック票_DBE292004パラメータ());
        }
    }

    private void call認定調査票両面_概況AND基本調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID_表 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 帳票ID_裏 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (!帳票ID_表.equals(帳票ID_裏)) {
            call認定調査票_概況調査(div, printService, 保険者市町村コード);
            call認定調査票_基本調査(div, printService, 保険者市町村コード);
        } else if (ReportIdDBZ.DBE221001.getReportId().value().equals(帳票ID_表)) {
            printService.print認定調査票_概況調査(getHandler(div).create認定調査票_概況調査パラメータ(), new ReportId(帳票ID_表));
        } else {
            printService.print認定調査票_両面(getHandler(div).create認定調査票_概況調査パラメータ(), 帳票ID_表);
        }
    }
    
    private void call認定調査票両面_特記事項(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        printService.print認定調査票_特記事項(
                getHandler(div).create認定調査票_特記事項パラメータ(), new ReportId(帳票ID));
    }

    private void call認定調査票_概況調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (ReportIdDBZ.DBE221012.getReportId().value().equals(帳票ID)) {
            printService.print認定調査票_片面(getHandler(div).create認定調査票_概況調査パラメータ(), 1);
        } else {
            printService.print認定調査票_概況調査(getHandler(div).create認定調査票_概況調査パラメータ(), new ReportId(帳票ID));
        }
    }

    private void call認定調査票_基本調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (ReportIdDBZ.DBE221012.getReportId().value().equals(帳票ID)) {
            printService.print認定調査票_片面(getHandler(div).create認定調査票_概況調査パラメータ(), 2);
        } else {
            printService.print認定調査票_基本調査(getHandler(div).create認定調査票_基本調査パラメータ(), new ReportId(帳票ID));
        }
    }

    private void call認定調査票_特記事項(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 表_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 裏_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        printService.print認定調査票_特記事項(getHandler(div).create認定調査票_特記事項パラメータ(), new ReportId(表_帳票ID));
        if (!表_帳票ID.equals(裏_帳票ID)) {
            printService.print認定調査票_特記事項(getHandler(div).create認定調査票_特記事項パラメータ(), new ReportId(裏_帳票ID));
        }
    }

    private void call認定調査票_特記事項_調査群記載あり(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_調査群記載あり_帳票ID, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        printService.print認定調査票_特記事項(getHandler(div).create認定調査票_特記事項パラメータ(), new ReportId(帳票ID));
    }

    private void call認定調査票_特記事項_フリー様式(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div,
            ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_フリー様式_帳票ID, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        printService.print認定調査票_特記事項(getHandler(div).create認定調査票_特記事項パラメータ(), new ReportId(帳票ID));
    }
    
    private void add認定調査票両面_概況AND基本調査(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 帳票ID_表 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 帳票ID_裏 = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        if (!帳票ID_表.equals(帳票ID_裏)) {
            add認定調査票_概況調査(list, div, row, 保険者市町村コード);
            add認定調査票_基本調査(list, div, row, 保険者市町村コード);
        } else if (ReportIdDBZ.DBE221001.getReportId().value().equals(帳票ID_表)) {
            ChosahyoMatomeItem item = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
            item.setLayout(ChosahyoMatomeLayout.認定調査票_概況調査_デザイン);
            list.add(item);
        } else if (ReportIdDBZ.DBE221011.getReportId().value().equals(帳票ID_裏)) {
            ChosahyoMatomeItem item_omote = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
            ChosahyoMatomeItem item_ura = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
            item_omote.setLayout(ChosahyoMatomeLayout.認定調査票_概況調査_OCR);
            item_ura.setLayout(ChosahyoMatomeLayout.認定調査票_基本調査_OCR_両面);
            list.add(item_omote);
            list.add(item_ura);
        }
    }
    
     private void add認定調査票_概況調査(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        ChosahyoMatomeItem item = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
        if (ReportIdDBZ.DBE221012.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_概況調査_OCR);
            list.add(item);
        } else if (ReportIdDBZ.DBE221001.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_概況調査_デザイン);
            list.add(item);
        } else if (ReportIdDBZ.DBE221051.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_概況特記_OCR);
            list.add(item);
        }
    }

    private void add認定調査票_基本調査(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        ChosahyoMatomeItem item = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
        if (ReportIdDBZ.DBE221012.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_基本調査_OCR_片面);
            list.add(item);
        } else if (ReportIdDBZ.DBE221004.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_基本調査_デザイン_片面);
            list.add(item);
        }
    }
    
    private void add認定調査票両面_特記事項(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 表_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 裏_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        ChosahyoMatomeItem item_omote = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
        if (ReportIdDBZ.DBE221003.getReportId().value().equals(表_帳票ID)) {
            item_omote.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_デザイン);
            list.add(item_omote);
        } else if (ReportIdDBZ.DBE221031.getReportId().value().equals(裏_帳票ID)) {
            ChosahyoMatomeItem item_ura = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
            item_omote.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_OCR_表面);
            item_ura.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_OCR_裏面);
            list.add(item_omote);
            list.add(item_ura);
        }
    }
    
    private void add認定調査票_特記事項(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        ChosahyoMatomeItem item = getHandler(div).create認定調査票_概況調査パラメータ_個人別(row);
        if (ReportIdDBZ.DBE221003.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_デザイン);
        } else if (ReportIdDBZ.DBE221032.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_OCR_表面);
        }
        
        list.add(item);
    }
    
    private void add認定調査票_特記事項_調査群記載あり(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_調査群記載あり_帳票ID, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        ChosahyoMatomeItem item = getHandler(div).create認定調査票_特記事項パラメータ_個人別(row);
        
        if (ReportIdDBZ.DBE221021.getReportId().value().equals(帳票ID)
                || ReportIdDBZ.DBE221021_Ari_Mono.getReportId().value().equals(帳票ID)
                || ReportIdDBZ.DBE221021_Ari_Color.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_項目有り);
            list.add(item);
        } else if (ReportIdDBZ.DBE221024.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_項目有り_手入力);
            list.add(item);
        } else if (ReportIdDBZ.DBE221022.getReportId().value().equals(帳票ID)
                || ReportIdDBZ.DBE221024_Nashi_Mono.getReportId().value().equals(帳票ID)
                || ReportIdDBZ.DBE221024_Nashi_Color.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_項目無し);
            list.add(item);
        } else if (ReportIdDBZ.DBE221025.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_項目無し_手入力);
            list.add(item);
        }
    }
    
    private void add認定調査票_特記事項_フリー様式(List<ChosahyoMatomeItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, dgNinteiChosa_Row row, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_特記事項_フリー様式_帳票ID, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        ChosahyoMatomeItem item = getHandler(div).create認定調査票_特記事項_フリー様式パラメータ_個人別(row);
        if (ReportIdDBZ.DBE221023.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_フリー様式);
            list.add(item);
        } else if (ReportIdDBZ.DBE221026.getReportId().value().equals(帳票ID)) {
            item.setLayout(ChosahyoMatomeLayout.認定調査票_特記事項_OCR_フリー様式);
            list.add(item);
        }
    }
    
    private void add主治医意見書記入用紙(List<IkenshoAssortmentItem> list, ChosaIraishoAndChosahyoAndIkenshoPrintHandler handler, dgShujiiIkensho_Row row, RString 保険者市町村コード) {
        RString 表_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        RString 裏_帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        
        if (ReportIdDBZ.DBE231001_Katamen_Mono.getReportId().value().equals(表_帳票ID)) {
            IkenshoAssortmentItem item = handler.create主治医意見書記入情報1_パラメータ_個人別(row, true);
            item.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙_片面_白黒_表);
            list.add(item);
            IkenshoAssortmentItem item_ura = handler.create主治医意見書記入情報1_パラメータ_個人別(row, true);
            item_ura.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙_片面_白黒_裏);
            list.add(item_ura);
        } else if (ReportIdDBZ.DBE231001_Ryomen_Mono.getReportId().value().equals(表_帳票ID)) {
            IkenshoAssortmentItem item = handler.create主治医意見書記入情報1_パラメータ_個人別(row, true);
            item.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙_片面_白黒_表);
            list.add(item);
            IkenshoAssortmentItem item_ura = handler.create主治医意見書記入情報1_パラメータ_個人別(row, true);
            item_ura.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙_両面_白黒_裏);
            list.add(item_ura);
        } else if (ReportIdDBZ.DBE231011_Katamen_Color.getReportId().value().equals(表_帳票ID)) {
            IkenshoAssortmentItem item = handler.create主治医意見書記入情報1_パラメータ_個人別(row, false);
            item.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR_片面_カラー表);
            list.add(item);
            IkenshoAssortmentItem item_ura = handler.create主治医意見書記入情報1_パラメータ_個人別(row, false);
            item_ura.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR_片面_カラー裏);
            list.add(item_ura);
        } else if (ReportIdDBZ.DBE231011_Ryomen_Color.getReportId().value().equals(表_帳票ID)) {
            IkenshoAssortmentItem item = handler.create主治医意見書記入情報1_パラメータ_個人別(row, false);
            item.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR_片面_カラー表);
            list.add(item);
            IkenshoAssortmentItem item_ura = handler.create主治医意見書記入情報1_パラメータ_個人別(row, false);
            item_ura.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR_両面_カラー裏);
            list.add(item_ura);
        } else if (ReportIdDBZ.DBE231012.getReportId().value().equals(表_帳票ID)) {
            IkenshoAssortmentItem item = handler.create主治医意見書記入情報1_パラメータ_個人別(row, true);
            item.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR12);
            list.add(item);
        } else if (ReportIdDBZ.DBE231014.getReportId().value().equals(表_帳票ID)) {
            IkenshoAssortmentItem item = handler.create主治医意見書記入情報1_パラメータ_個人別(row, false);
            item.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR14);
            list.add(item);
        }
        if (!表_帳票ID.equals(裏_帳票ID)) {
            if (ReportIdDBZ.DBE231012.getReportId().value().equals(裏_帳票ID)) {
                IkenshoAssortmentItem item_ura = handler.create主治医意見書記入情報1_パラメータ_個人別(row, true);
                item_ura.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR12);
                list.add(item_ura);
            } else if (ReportIdDBZ.DBE231014.getReportId().value().equals(裏_帳票ID)) {
                IkenshoAssortmentItem item_ura = handler.create主治医意見書記入情報1_パラメータ_個人別(row, false);
                item_ura.setLayout(IkenshoAssortmentLayout.主治医意見書記入用紙OCR14);
                list.add(item_ura);
            }
        }
    }
    

    private ChosaIraishoAndChosahyoAndIkenshoPrintHandler getHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new ChosaIraishoAndChosahyoAndIkenshoPrintHandler(div);
    }

    private PrintValidationHandler getValidationHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new PrintValidationHandler(div);
    }
}
