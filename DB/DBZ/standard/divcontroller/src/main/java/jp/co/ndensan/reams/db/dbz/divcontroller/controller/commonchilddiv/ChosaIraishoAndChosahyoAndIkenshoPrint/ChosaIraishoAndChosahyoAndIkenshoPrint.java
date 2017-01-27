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
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrintHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint.PrintValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint.dgNinteiChosa_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaIraishoAndChosahyoAndIkenshoPrint.ChosaIraishoAndChosahyoAndIkenshoPrint.dgShujiiIkensho_Row;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    private static final RString KEY3 = new RString("3");
    private static final RString KEY4 = new RString("4");
    private static final RString KEY5 = new RString("5");
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
    private static final RString DBE221041 = new RString("DBE221041_tokkijikoOCR");
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

    /**
     * 共通子DIVを初期化します。
     *
     * @param div ChosaIraishoAndChosahyoAndIkenshoPrintDiv
     * @return ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv>
     */
    public ResponseData<ChosaIraishoAndChosahyoAndIkenshoPrintDiv> onLoad(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        IkenshoPrintParameterModel model = DataPassingConverter.deserialize(div.getHiddenIuputModel(), IkenshoPrintParameterModel.class);
        if (model != null) {
            getHandler(div).initialize(model.get申請書管理番号リスト(), model.get市町村コード(), model.get遷移元画面区分());
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
            printData(div, reportManager);
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
        if (model != null) {
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

        RString radTeishutsuKigen = div.getRadTeishutsuKigen().getSelectedKey();
        RDate date = RDate.getNowDate();
        RString 期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, date, SubGyomuCode.DBE認定支援);
        int 作成期限日数
                = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, date, SubGyomuCode.DBE認定支援).toString());
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
                    = (共通日 == null ? FlexibleDate.EMPTY : new FlexibleDate(共通日.plusDay(作成期限日数).toDateString()));
        }
        shujiiIkenshoIraiJohoBuilder = shujiiIkenshoIraiJohoBuilder.set主治医意見書作成期限年月日(作成期限年月日);

        FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkoYMD().getValue().toString());
        if (!div.getChkIkenshoIraisho().getSelectedKeys().isEmpty()) {
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

        RString radTeishutsuKigen = div.getRadTeishutsuKigen().getSelectedKey();
        RDate date = RDate.getNowDate();
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, date, SubGyomuCode.DBE認定支援);
        int 認定調査作成期限日数
                = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, date, SubGyomuCode.DBE認定支援).toString());
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

        FlexibleDate 発行日 = new FlexibleDate(div.getTxtHakkoYMD().getValue().toString());
        if (!div.getChkIraisho().getSelectedKeys().isEmpty()) {
            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set依頼書出力年月日(発行日);
        }

        if (!div.getChkChosahyoKatamen().getSelectedKeys().isEmpty()
                || !div.getChkChosahyoRyomen().getSelectedKeys().isEmpty()) {
            ninteichosaIraiJohoBuilder = ninteichosaIraiJohoBuilder.set調査票等出力年月日(発行日);
        }

        NinteichosaIraiJohoManager.createInstance().save認定調査依頼情報(ninteichosaIraiJohoBuilder.build().modifiedModel());
    }

    private void printData(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ReportManager reportManager) {

        RString 保険者市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        ChosaIraishoAndChosahyoAndIkenshoPrintService printService = new ChosaIraishoAndChosahyoAndIkenshoPrintService(reportManager);

        List<RString> 依頼書選択selectedKeys = div.getChkIraisho().getSelectedKeys();
        if (依頼書選択selectedKeys.contains(KEY0)) {
            printService.print要介護認定調査依頼書(getHandler(div).create認定調査依頼書印刷用パラメータ());
        }
        if (依頼書選択selectedKeys.contains(KEY1)) {
            printService.print認定調査依頼一覧表(getHandler(div).create認定調査依頼一覧表印刷用パラメータ());
        }

        List<RString> 調査票選択selectedKeys = div.getChkChosahyoKatamen().getSelectedKeys();
        if (調査票選択selectedKeys.contains(KEY0)) {
            call認定調査票_概況調査(div, printService, 保険者市町村コード);
        }
        if (調査票選択selectedKeys.contains(KEY1)) {
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
            call認定調査差異チェック表(div, printService);
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
            printService.print意見書作成依頼書(getHandler(div).create意見書作成依頼書_パラメータ());
        }
        if (意見書依頼書選択selectedKeys.contains(KEY1)) {
            printService.print意見書作成依頼一覧表(getHandler(div).create意見書作成依頼一覧表_パラメータ());
        }
        if (意見書依頼書選択selectedKeys.contains(KEY2)) {
            printService.print介護保険指定医依頼兼主治医意見書提出意見書(getHandler(div).create介護保険指定医依頼兼主治医意見書提出意見書_パラメータ());
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
            printService.print介護保険診断命令書(getHandler(div).create介護保険診断命令書_パラメータ());
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

    private void call認定調査差異チェック表(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService) {
        RString 差異チェック票_印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
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
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        printService.print認定調査票_両面(getHandler(div).create認定調査票_概況調査パラメータ(), 帳票ID);
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
        printService.print認定調査票_概況調査(getHandler(div).create認定調査票_概況調査パラメータ(), new ReportId(帳票ID));

    }

    private void call認定調査票_基本調査(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div, ChosaIraishoAndChosahyoAndIkenshoPrintService printService, RString 保険者市町村コード) {
        RString 帳票ID = DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_表, RDate.getNowDate(), SubGyomuCode.DBE認定支援, 保険者市町村コード);
        printService.print認定調査票_基本調査(getHandler(div).create認定調査票_基本調査パラメータ(), new ReportId(帳票ID));
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

    private ChosaIraishoAndChosahyoAndIkenshoPrintHandler getHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new ChosaIraishoAndChosahyoAndIkenshoPrintHandler(div);
    }

    private PrintValidationHandler getValidationHandler(ChosaIraishoAndChosahyoAndIkenshoPrintDiv div) {
        return new PrintValidationHandler(div);
    }
}
