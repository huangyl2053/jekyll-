/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.definition.core.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiReportOutputService;
import jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshi.IkenshokinyuyoshiPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.message.DbQuestionMessages;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbz.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医意見書作成依頼のクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIrai {

    private static final RString 主治医意見書作成期限設定方法_1 = new RString("1");
    private static final RString 削除 = new RString("削除");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final RString SELECTED_KEY3 = new RString("key3");
    private static final RString SELECTED_KEY4 = new RString("key4");
    private static final RString SELECTED_KEY5 = new RString("key5");
    private static final int 数字_0 = 0;
    private static final int 数字_1 = 1;
    private static final int 数字_2 = 2;
    private static final int 数字_3 = 3;
    private static final int 数字_4 = 4;
    private static final int 数字_5 = 5;
    private static final int 数字_6 = 6;
    private static final int 数字_7 = 7;
    private static final int 数字_8 = 8;
    private static final int 数字_9 = 9;
    private static final int 数字_10 = 10;
    private static final RString 意見書作成料_種別 = new RString("✔");
    private static final RString 再依頼申請者削除 = new RString("再依頼申請者を削除します。");
    private static final RString 依頼書印刷処理 = new RString("依頼書印刷処理");
    private static final RString 星 = new RString("＊");
    private List<ShujiiIkenshoSakuseiIraishoItem> 主治医意見書作成依頼情報ItemList;
    private List<IkenshoSakuseiIraiIchiranhyoItem> 主治医意見書作成依頼一覧表ItemList;
    private List<ShujiiIkenshoSakuseiRyoSeikyushoItem> 主治医意見書作成料請求書ItemList;
    private List<KaigohokenShindanMeireishoHeaderItem> 介護保険診断命令書ItemList;
    private List<ShujiiIkenshoTeishutsuIraishoItem> 介護保険指定医依頼兼主治医意見書提出意見書ItemList;
    private List<IkenshokinyuyoshiBusiness> 主治医意見書記入用紙List;
    private List<IkenshokinyuyoshiBusiness> 主治医意見書記入用紙OCRList;
    private List<IkenshokinyuyoshiBusiness> 主治医意見書記入用紙DList;
    private static final RString CONFIGVALUE1 = new RString("1");
    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");
    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));

    /**
     * 主治医意見書作成依頼の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onLoad(ShujiiIkenshoSakuseiIraiDiv div) {
        createHandler(div).load();
        div.getTxtShujiiIkensahoSakuseiIraiDay().setValue(RDate.getNowDate());
        div.getIraiprint().getTxtHakobi().setValue(RDate.getNowDate());
        div.getMeireisho().getRadjyushin().setSelectedKey(SELECTED_KEY1);
        set受信(div);
        div.getMeireisho().setDisplayNone(true);
        RDate sysdate = RDate.getNowDate();
        Boolean 介護保険診断命令書_出力有無 = Boolean.parseBoolean(DbBusinessConfig.get
            (ConfigNameDBE.介護保険診断命令書_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString());
        Boolean 意見書作成依頼書_出力有無 = Boolean.parseBoolean((DbBusinessConfig.get
            (ConfigNameDBE.主治医意見書作成依頼_意見書作成依頼書_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString()));
        Boolean 記入用紙_出力有無 = Boolean.parseBoolean(DbBusinessConfig.get
            (ConfigNameDBE.主治医意見書作成依頼_記入用紙_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString());
        Boolean 記入用紙OCR_出力有無 = Boolean.parseBoolean(DbBusinessConfig.get
            (ConfigNameDBE.主治医意見書作成依頼_記入用紙OCR_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString());
        Boolean 作成料請求書_出力有無 = Boolean.parseBoolean(DbBusinessConfig.get
            (ConfigNameDBE.主治医意見書作成依頼_作成料請求書_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString());
        Boolean デザイン用紙_出力有無 = Boolean.parseBoolean(DbBusinessConfig.get
            (ConfigNameDBE.主治医意見書作成依頼_デザイン用紙_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString());
        Boolean 提出意見書_出力有無 = Boolean.parseBoolean(DbBusinessConfig.get
            (ConfigNameDBE.主治医意見書作成依頼_提出意見書_出力有無, sysdate, SubGyomuCode.DBE認定支援).toString());
        div.getIraiprint().getIraiSho().setDisplayNone(意見書作成依頼書_出力有無);
        div.getIraiprint().getIraiIchiranHyo().setDisplayNone(意見書作成依頼書_出力有無);
        div.getIraiprint().getKinyoYoshi().setDisplayNone(記入用紙_出力有無);
        div.getIraiprint().getKinyuYoshiOCR().setDisplayNone(記入用紙OCR_出力有無);
        div.getIraiprint().getKinyuYoshiDesign().setDisplayNone(デザイン用紙_出力有無);
        div.getIraiprint().getSeikyuSho().setDisplayNone(作成料請求書_出力有無);
        div.getIraiprint().getMeireiSho().setDisplayNone(介護保険診断命令書_出力有無);
        div.getIraiprint().getTeishutsuIraiSho().setDisplayNone(提出意見書_出力有無);
        return ResponseData.of(div).respond();
    }
    /**
     * 検索条件クリア処理です。
     *
     * @param div ShujiiIkenshoSakuseiIraiDiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnClear(ShujiiIkenshoSakuseiIraiDiv div) {
        createHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護保険診断命令書を選択したら、診断命令書印刷設定パネルを表示します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_MeireiSho(ShujiiIkenshoSakuseiIraiDiv div) {
        if (div.getMeireiSho().getSelectedKeys().contains(SELECTED_KEY0)) {
            div.getMeireisho().setDisplayNone(false);
        } else {
            div.getMeireisho().setDisplayNone(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書作成依頼の検索を処理します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnSearch(ShujiiIkenshoSakuseiIraiDiv div) {

        ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().validate();
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        div.setHdnClickedButton(new RString(ClickedButton.検索する.name()));
        RString hihokenshaNo = div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue();
        return searchCore(div, hihokenshaNo);
    }

    /**
     * 最近処理者の「表示する」を押下した時の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onSaikinshorishaClick(ShujiiIkenshoSakuseiIraiDiv div) {
        ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().validate();
        if (pairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        div.setHdnClickedButton(new RString(ClickedButton.表示する.name()));
        RString hihokenshaNo = div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().getSelectedHihokenshaNo();
        return searchCore(div, hihokenshaNo);
    }

    private ResponseData<ShujiiIkenshoSakuseiIraiDiv> searchCore(ShujiiIkenshoSakuseiIraiDiv div, RString hihokenshaNo) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(div));
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameter(hihokenshaNo);
        createHandler(div).init(manager.get申請者情報(param));
        return ResponseData.of(div).respond();
    }

    /**
     * 「依頼する」ボタン押下、指定値をセットします。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnIrai(ShujiiIkenshoSakuseiIraiDiv div) {

        ShujiiIkenshoSakuseiIraiValidationHandler validationHandler = createValidationHandler(div);
        ValidationMessageControlPairs validationMessages = validationHandler.依頼チェック();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        createHandler(div).set主治医();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnHozon(ShujiiIkenshoSakuseiIraiDiv div) {
        ShujiiIkenshoSakuseiIraiValidationHandler validationHandler = createValidationHandler(div);
        ValidationMessageControlPairs validationMessages = validationHandler.保存チェック();
         if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).
                equals(ResponseHolder.getMessageCode()) && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            toHozon(div);
            onClick_btnSearch(div);
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者変更処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onChange_ddlHokensha(ShujiiIkenshoSakuseiIraiDiv div) {
        div.getCcdShujiiIryoKikanAndShujiiInput().initialize(
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().getSelectedItem().get市町村コード(),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        return ResponseData.of(div).respond();
    }

    /**
     * 発行押下のチェック処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnHakkouValidationCheck(ShujiiIkenshoSakuseiIraiDiv div) {
        ValidationMessageControlPairs validationMessage = createValidationHandler(div).発行チェック();
        if (validationMessage.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessage).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(DbQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * レコードをクリックの場合、主治医意見書作成依頼情報が「主治医医療機関/主治医エリア」に正しく書き込みします。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onSelect_dgShinseishaIchiran(ShujiiIkenshoSakuseiIraiDiv div) {
        dgShinseishaIchiran_Row row = div.getDgShinseishaIchiran().getActiveRow();
        if (!RString.isNullOrEmpty(row.getIraiKubun())) {
            div.getCcdShujiiIryoKikanAndShujiiInput().initialize(new LasdecCode(row.getShichosonCode()),
                    new ShinseishoKanriNo(row.getShiseishoKanriNo()), SubGyomuCode.DBE認定支援,
                    row.getShujiiIryoKikanCode(), row.getShujiiIryoKikan(), row.getShujiiCode(), row.getShujii());
            div.getCcdShujiiIryoKikanAndShujiiInput().setShiteii(row.getShiteiiFlag());
        } else {
            div.getCcdShujiiIryoKikanAndShujiiInput().clear();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * dgShinseishaIchiranで照会ボタンを押下。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onBeforeOpenDialog_dgShinseishaIchiran(ShujiiIkenshoSakuseiIraiDiv div) {
        dgShinseishaIchiran_Row row = div.getDgShinseishaIchiran().getActiveRow();
        if (!RString.isNullOrEmpty(row.getShiseishoKanriNo())) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, row.getShiseishoKanriNo());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 発行押下の処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<SourceDataCollection> onClick_btnHakkou(ShujiiIkenshoSakuseiIraiDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            toHozon(div);
            ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
            ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameter(getHihokenshaNo(div));
            printData(div, reportManager);
            createHandler(div).init(manager.get申請者情報(param));
            response.data = reportManager.publish();
            reportManager.close();
        }
        return response;
    }

    /**
     * 発行押下後、処理完了メッセージを表示します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnHakkouKanryo(ShujiiIkenshoSakuseiIraiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            onClick_btnSearch(div);
            return ResponseData.of(div).addMessage((UrInformationMessages.正常終了.getMessage().replace(依頼書印刷処理.toString()))).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenshoSakuseiIraiHandler createHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        return new ShujiiIkenshoSakuseiIraiHandler(div);
    }

    private ShujiiIkenshoSakuseiIraiValidationHandler createValidationHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        return new ShujiiIkenshoSakuseiIraiValidationHandler(div);
    }

    private void toHozon(ShujiiIkenshoSakuseiIraiDiv div) {
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        RDate sysdate = RDate.getNowDate();
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, sysdate, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, sysdate, SubGyomuCode.DBE認定支援);
        RDate 共通日 = div.getTxtkigenymd().getValue();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (新規.equals(row.getStatus())) {
                int rirekiNo = 数字_1;
                if (!RString.isNullOrEmpty(row.getPreRirekiNo())) {
                    rirekiNo = Integer.parseInt(row.getPreRirekiNo().toString()) + 数字_1;
                }
                manager.save主治医意見書作成依頼情報(
                        create主治医意見書作成依頼情報(div, row, 主治医意見書作成期限設定方法, 主治医意見書作成期限日数, rirekiNo, 共通日), EntityDataState.Added);
                RString shiseishoKanriNo = new RString(row.getShiseishoKanriNo().toString());
                ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameterNinteiShinseiJoho2(shiseishoKanriNo, getHihokenshaNo(div));
                NinteiShinseiJoho2 shinseiJoho = manager.get要介護認定申請情報(param);

                NinteiShinseiJoho2Builder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
                shinseiJohoBuilder.set主治医医療機関コード(row.getShujiiIryoKikanCode());
                shinseiJohoBuilder.set主治医コード(row.getShujiiCode());
                shinseiJohoBuilder.set指定医フラグ(row.getShiteiiFlag());
                shinseiJoho = shinseiJohoBuilder.build();
                manager.save要介護認定申請情報(shinseiJoho, EntityDataState.Modified);
            } else if (修正.equals(row.getStatus())) {
                RString shiseishoKanriNo = new RString(row.getShiseishoKanriNo().toString());
                ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameterShujiiIkenshoIraiJoho(shiseishoKanriNo,
                        row.getRirekiNo().toInt(), getHihokenshaNo(div));
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = manager.get主治医意見書作成依頼情報(param);
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                builder.set論理削除フラグ(true);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
                manager.save主治医意見書作成依頼情報(
                        create主治医意見書作成依頼情報(div, row, 主治医意見書作成期限設定方法, 主治医意見書作成期限日数,
                                Integer.parseInt(row.getRirekiNo().toString()) + 1, 共通日), EntityDataState.Added);

                ShujiiIkenshoSakuseiIraiParameter param2 = createHandler(div).createParameterNinteiShinseiJoho2(shiseishoKanriNo, getHihokenshaNo(div));
                NinteiShinseiJoho2 shinseiJoho = manager.get要介護認定申請情報(param2);
                NinteiShinseiJoho2Builder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
                shinseiJohoBuilder.set主治医医療機関コード(row.getShujiiIryoKikanCode());
                shinseiJohoBuilder.set主治医コード(row.getShujiiCode());
                shinseiJohoBuilder.set指定医フラグ(row.getShiteiiFlag());
                shinseiJoho = shinseiJohoBuilder.build();
                manager.save要介護認定申請情報(shinseiJoho, EntityDataState.Modified);
            } else if (削除.equals(row.getStatus())) {
                RString shiseishoKanriNo = new RString(row.getShiseishoKanriNo().toString());
                ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameterShujiiIkenshoIraiJoho(shiseishoKanriNo,
                        row.getRirekiNo().toInt(), getHihokenshaNo(div));
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = manager.get主治医意見書作成依頼情報(param);
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                builder.set論理削除フラグ(true);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
            }
        }
    }

    private ShujiiIkenshoIraiJoho create主治医意見書作成依頼情報(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row, RString 設定方法, RString 期限日数, int rirekiNo, RDate 日付) {
        ShujiiIkenshoIraiJohoBuilder builder = create主治医意見書作成依頼情報Builder(div, row, 設定方法, 期限日数, rirekiNo, 日付);
        if (RString.isNullOrEmpty(row.getIraiKubun())) {
            builder.set主治医意見書依頼区分(ShujiiIkenshoIraiKubun.初回.getCode());
        } else if (!row.getSakujoKbn()) {
            builder.set主治医意見書依頼区分(ShujiiIkenshoIraiKubun.再依頼.getCode());
        }
        return builder.build();
    }

    private ShujiiIkenshoIraiJohoBuilder create主治医意見書作成依頼情報Builder(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row,
            RString 設定方法, RString 期限日数, int rirekiNo, RDate 日付) {
        ShujiiIkenshoIraiJoho iraiJoho = new ShujiiIkenshoIraiJoho(new ShinseishoKanriNo(row.getShiseishoKanriNo()),
                rirekiNo);
        ShujiiIkenshoIraiJohoBuilder builder = iraiJoho.createBuilderForEdit();
        builder.set主治医医療機関コード(row.getShujiiIryoKikanCode());
        builder.set主治医コード(row.getShujiiCode());
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set主治医意見書作成回数(数字_1);
        builder.set医師区分コード(new Code(row.getIshiKbnCode()));
        if (row.getShujiiIkenshoSakuseiIraiDay().getValue() != null) {
            builder.set主治医意見書作成依頼年月日(new FlexibleDate(row.getShujiiIkenshoSakuseiIraiDay().getValue().toDateString()));
        } else {
            builder.set主治医意見書作成依頼年月日(new FlexibleDate(div.getTxtShujiiIkensahoSakuseiIraiDay().getValue().toDateString()));
        }
        if (日付 != null) {
            builder.set主治医意見書作成期限年月日(new FlexibleDate(日付.toDateString()));
        } else {
            if (SELECTED_KEY1.equals(div.getRadkigen().getSelectedKey())) {
                builder.set主治医意見書作成期限年月日(FlexibleDate.MAX);
            } else if (主治医意見書作成期限設定方法_1.equals(設定方法) && row.getShujiiIkenshoSakuseiIraiDay() != null) {
                builder.set主治医意見書作成期限年月日(new FlexibleDate(row.getShujiiIkenshoSakuseiIraiDay()
                        .getValue().plusDay(Integer.parseInt(期限日数.toString())).toDateString()));
            } else if (row.getShinseiDay() != null) {
                builder.set主治医意見書作成期限年月日(new FlexibleDate(row.getShinseiDay()
                        .getValue().plusDay(Integer.parseInt(期限日数.toString())).toDateString()));
            }
        }
        builder.set論理削除フラグ(false);
        return builder;
    }

    private void printData(ShujiiIkenshoSakuseiIraiDiv div, ReportManager reportManager) {

        主治医意見書作成依頼情報ItemList = new ArrayList<>();
        主治医意見書作成依頼一覧表ItemList = new ArrayList<>();
        主治医意見書作成料請求書ItemList = new ArrayList<>();
        介護保険診断命令書ItemList = new ArrayList<>();
        介護保険指定医依頼兼主治医意見書提出意見書ItemList = new ArrayList<>();
        主治医意見書記入用紙List = new ArrayList<>();
        主治医意見書記入用紙OCRList = new ArrayList<>();
        主治医意見書記入用紙DList = new ArrayList<>();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            createChoHyoData(div, row);
        }
        toPrint(reportManager);
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && 新規.equals(row.getStatus())) {
                int rirekiNo = 数字_1;
                if (!RString.isNullOrEmpty(row.getPreRirekiNo())) {
                    rirekiNo = Integer.parseInt(row.getPreRirekiNo().toString()) + 数字_1;
                }
                ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
                RString shiseishoKanriNo = new RString(row.getShiseishoKanriNo().toString());
                ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameterShujiiIkenshoIraiJoho(shiseishoKanriNo,
                        rirekiNo, getHihokenshaNo(div));
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = manager.get主治医意見書作成依頼情報(param);
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                setJushinJoho(div, builder);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
            } else if (row.getSelected() && 修正.equals(row.getStatus())) {
                ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
                RString shiseishoKanriNo = new RString(row.getShiseishoKanriNo().toString());
                ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameterShujiiIkenshoIraiJoho(shiseishoKanriNo,
                        row.getRirekiNo().toInt() + 1, getHihokenshaNo(div));
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = manager.get主治医意見書作成依頼情報(param);
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                setJushinJoho(div, builder);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
            }else if(row.getSelected()){
                ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
                RString shiseishoKanriNo = new RString(row.getShiseishoKanriNo().toString());
                ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameterShujiiIkenshoIraiJoho(shiseishoKanriNo,
                        row.getRirekiNo().toInt(), getHihokenshaNo(div));
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = manager.get主治医意見書作成依頼情報(param);
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                setJushinJoho(div, builder);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
            }
        }
    }
    
    private void setJushinJoho(ShujiiIkenshoSakuseiIraiDiv div, ShujiiIkenshoIraiJohoBuilder getBuilder){
        
        getBuilder.set依頼書出力年月日(new FlexibleDate(div.getTxtHakobi().getValue().toDateString()));
        if (div.getMeireiSho().getSelectedKeys().contains(SELECTED_KEY0)) {
                    getBuilder.set介護保険診断命令書発行有無(true);
                    if (SELECTED_KEY0.equals(div.getRadjyushin().getSelectedKey())) {
                        getBuilder.set受信期間区分(new Code(new RString(数字_1)));
                        getBuilder.set受信日(new FlexibleDate(div.getTxtjyushinymd().getValue().toDateString()));
                        getBuilder.set受信時分(new RString(div.getTxtjyushintime().getValue().toString()));
                    }
                    if (SELECTED_KEY1.equals(div.getRadjyushin().getSelectedKey())) {
                        getBuilder.set受信期間区分(new Code(new RString(数字_2)));
                        getBuilder.set受信期間開始(new FlexibleDate(div.getTxtJyushinKikan().getFromValue().toDateString()));
                        getBuilder.set受信期間終了(new FlexibleDate(div.getTxtJyushinKikan().getToValue().toDateString()));
                        getBuilder.set受信場所(new RString(div.getTxtjyushinbasho().toString()));
                    }
                }
    }

    private RString getEditedYubinNo(RString yubinNo) {
        if (RString.isNullOrEmpty(yubinNo)) {
            return RString.EMPTY;
        }
        if (yubinNo.length() < 数字_5) {
            return yubinNo;
        }
        return yubinNo.insert(yubinNo.length() - 数字_4, "-");
    }

    private void clearShujii(dgShinseishaIchiran_Row row) {
        row.setShujiiIryoKikan(RString.EMPTY);
        row.setShujiiIryoKikanCode(RString.EMPTY);
        row.setShujii(RString.EMPTY);
        row.setShujiiCode(RString.EMPTY);
        row.getShujiiIkenshoSakuseiIraiDay().clearValue();
    }

    private ShujiiIkenshoSakuseiIraishoItem create主治医意見書作成依頼書(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        ShujiiIkenshoSakuseiIraishoItem iraishoItem = new ShujiiIkenshoSakuseiIraishoItem();
        iraishoItem.setTitle(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        iraishoItem.setHakkoYMD1(div.getTxtHakobi().getValue().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        if(!RString.isNullOrEmpty(div.getBunshoBango().get文書番号().trim())){
            iraishoItem.setBunshoNo(div.getBunshoBango().get文書番号());
        }else{
            iraishoItem.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), FlexibleDate.getNowDate()));
        }
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), KamokuCode.EMPTY, 数字_1);
        iraishoItem.setTsuchibun1(通知文.get(数字_1));
        iraishoItem.setTsuchibun2(通知文.get(数字_2));
        iraishoItem.setHihokenshaNo1(hihokenshaNo.substring(数字_0, 数字_1));
        iraishoItem.setHihokenshaNo2(hihokenshaNo.substring(数字_1, 数字_2));
        iraishoItem.setHihokenshaNo3(hihokenshaNo.substring(数字_2, 数字_3));
        iraishoItem.setHihokenshaNo4(hihokenshaNo.substring(数字_3, 数字_4));
        iraishoItem.setHihokenshaNo5(hihokenshaNo.substring(数字_4, 数字_5));
        iraishoItem.setHihokenshaNo6(hihokenshaNo.substring(数字_5, 数字_6));
        iraishoItem.setHihokenshaNo7(hihokenshaNo.substring(数字_6, 数字_7));
        iraishoItem.setHihokenshaNo8(hihokenshaNo.substring(数字_7, 数字_8));
        iraishoItem.setHihokenshaNo9(hihokenshaNo.substring(数字_8, 数字_9));
        iraishoItem.setHihokenshaNo10(hihokenshaNo.substring(数字_9));
        iraishoItem.setHihokenshaNameKana(row.getHihokenshaShimeiKana());
        iraishoItem.setHihokenshaName(row.getHihokennshaShimei());
        iraishoItem.setJusho(row.getJusho());
        iraishoItem.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        RString hokenshaNo = row.getHokenshaNo().padRight(RString.HALF_SPACE, 数字_6);
        iraishoItem.setHokenshaNo1(hokenshaNo.substring(数字_0, 数字_1));
        iraishoItem.setHokenshaNo2(hokenshaNo.substring(数字_1, 数字_2));
        iraishoItem.setHokenshaNo3(hokenshaNo.substring(数字_2, 数字_3));
        iraishoItem.setHokenshaNo4(hokenshaNo.substring(数字_3, 数字_4));
        iraishoItem.setHokenshaNo5(hokenshaNo.substring(数字_4, 数字_5));
        iraishoItem.setHokenshaNo6(hokenshaNo.substring(数字_5));
        iraishoItem.setShinseiKubun(row.getShinseiKubunShinseiji());
        iraishoItem.setTeishutsuKigen(get主治医意見書作成期限年月日(div, row, SELECTED_KEY0));
        if (row.getShinseiDay().getValue() != null) {
            iraishoItem.setShinseiYMD(row.getShinseiDay().getValue().
                    wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        iraishoItem.setShoriName(row.getIraiKubun());
        iraishoItem.setRemban(new RString("1"));
        ShujiiIraiAtenaJoho atenaJoho = get宛先(row);
        if (atenaJoho != null) {
            iraishoItem.setYubinNo1(atenaJoho.getTemp_宛名郵便番号() == null ? RString.EMPTY : atenaJoho.getTemp_宛名郵便番号().getEditedYubinNo());
            iraishoItem.setJushoText(atenaJoho.getTemp_宛名住所() == null ? RString.EMPTY : atenaJoho.getTemp_宛名住所().value());
            iraishoItem.setKikanNameText(atenaJoho.getTemp_宛名機関名());
            iraishoItem.setShimeiText(atenaJoho.getTemp_宛名氏名() == null ? RString.EMPTY : atenaJoho.getTemp_宛名氏名().value());
            iraishoItem.setCustomerBarCode(ReportUtil.getCustomerBarCode(iraishoItem.getYubinNo1(), iraishoItem.getJushoText()));
        }
        iraishoItem.setMeishoFuyo(
                ChohyoAtesakiKeisho.toValue(DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称,
                        RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称());
        iraishoItem.setSonota(RString.EMPTY);

        FlexibleDate birthYMD = row.getBirthYMD().getValue();
        if (birthYMD != null && !FlexibleDate.EMPTY.equals(birthYMD)) {
            iraishoItem.setBirthYMD(birthYMD.wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().substring(数字_2));
            if (new RString("明").equals(birthYMD.wareki().getEra())) {
                iraishoItem.setBirthGengoShowa(星);
                iraishoItem.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.wareki().getEra())) {
                iraishoItem.setBirthGengoMeiji(星);
                iraishoItem.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.wareki().getEra())) {
                iraishoItem.setBirthGengoTaisho(星);
                iraishoItem.setBirthGengoMeiji(星);
            } else {
                iraishoItem.setBirthGengoMeiji(星);
                iraishoItem.setBirthGengoShowa(星);
                iraishoItem.setBirthGengoTaisho(星);
            }
        }
        if (!RString.isNullOrEmpty(row.getSeibetsu())) {
            if (Seibetsu.男.get名称().equals(row.getSeibetsu())) {
                iraishoItem.setSeibetsuWoman(星);
            } else if (Seibetsu.女.get名称().equals(row.getSeibetsu())) {
                iraishoItem.setSeibetsuMan(星);
            }
        }
        return iraishoItem;
    }

    private IkenshoSakuseiIraiIchiranhyoItem create主治医意見書作成依頼一覧表(ShujiiIkenshoSakuseiIraiDiv div,
            dgShinseishaIchiran_Row row) {
        IkenshoSakuseiIraiIchiranhyoItem item = new IkenshoSakuseiIraiIchiranhyoItem();
        item.setYubinNo1(getEditedYubinNo(row.getYubinNo()));
        item.setJushoText(row.getJusho());
        item.setKikanNameText(row.getShujiiIryoKikan());
        ShujiiIraiAtenaJoho atenaJoho = get宛先(row);
        if (atenaJoho != null) {
            item.setYubinNo1(atenaJoho.getTemp_宛名郵便番号() == null ? RString.EMPTY : atenaJoho.getTemp_宛名郵便番号().getEditedYubinNo());
            item.setJushoText(atenaJoho.getTemp_宛名住所() == null ? RString.EMPTY : atenaJoho.getTemp_宛名住所().value());
            item.setKikanNameText(atenaJoho.getTemp_宛名機関名());
            item.setShimeiText(atenaJoho.getTemp_宛名氏名() == null ? RString.EMPTY : atenaJoho.getTemp_宛名氏名().value());
        }
        item.setMeishoFuyo(
                ChohyoAtesakiKeisho.toValue(DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称,
                        RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称());
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        item.setPrintTimeStamp(systemDateTime.toRString());
        item.setListIchiranhyo_2(row.getShujii());
        item.setListIchiranhyo_3(row.getHihokenshaNo());
        item.setListIchiranhyo_4(row.getHihokennshaShimei());
        item.setListIchiranhyo_5(row.getHihokenshaShimeiKana());
        item.setListIchiranhyo_6(row.getJusho());
        item.setListIchiranhyo_7(row.getBirthYMD().getValue() == null || FlexibleDate.EMPTY.equals(row.getBirthYMD().getValue())
                ? RString.EMPTY : row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        item.setListIchiranhyo_8(row.getSeibetsu());
        item.setListIchiranhyo_9(get主治医意見書作成期限年月日(div, row, SELECTED_KEY1));
        item.setTsuchibun1(ReportUtil.get通知文(
                SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE230002.getReportId(), KamokuCode.EMPTY, 数字_1).get(数字_1));
        item.setShujiiIryokikanCode(row.getShujiiIryoKikanCode());
        return item;
    }

    private void create主治医意見書記入用紙(dgShinseishaIchiran_Row row) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            主治医意見書記入用紙List.add(SetValueOmote(row));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            主治医意見書記入用紙List.add(SetValueOmote(row));
        }
    }

    private void create主治医意見書記入用紙D(dgShinseishaIchiran_Row row) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            主治医意見書記入用紙DList.add(SetValueOmote(row));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            主治医意見書記入用紙DList.add(SetValueOmote(row));
        }
    }

    private void create主治医意見書記入用紙OCR(dgShinseishaIchiran_Row row) {
        RDate date = RDate.getNowDate();
        if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            主治医意見書記入用紙OCRList.add(SetValueOmote(row));
        } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
            主治医意見書記入用紙OCRList.add(SetValueOmote(row));
        }
    }

    private IkenshokinyuyoshiBusiness SetValueOmote(dgShinseishaIchiran_Row row) {
        IkenshokinyuyoshiBusiness business = new IkenshokinyuyoshiBusiness();
        business.setHihokenshaNameKana(row.getHihokenshaShimeiKana());
        business.setHihokenshaName(row.getHihokennshaShimei());
        business.setAge(row.getAge());
        business.setHihokenshaTel(row.getTelNo());
        business.setJusho(row.getJusho());
        business.setShujiiName(row.getShujii());
        business.setIryokikanName(row.getShujiiIryoKikan());
        business.setIryokikanAdress(row.getIryoukikanShozaichi());
        business.setIryokikanNameTel(row.getIryoKikanTelNo());
        business.setIryokikanFax(row.getIryoKikanFaxNo());
        business.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        FlexibleDate birthYMD = row.getBirthYMD().getValue();
        if (birthYMD != null && !FlexibleDate.EMPTY.equals(birthYMD)) {
            business.setBirthYY(birthYMD.wareki().getYear().substring(数字_1));
            business.setBirthMM(birthYMD.wareki().getMonth());
            business.setBirthDD(birthYMD.wareki().getDay());
            if (new RString("明").equals(birthYMD.wareki().getEra())) {
                business.setBirthGengoShowa(星);
                business.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.wareki().getEra())) {
                business.setBirthGengoMeiji(星);
                business.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.wareki().getEra())) {
                business.setBirthGengoTaisho(星);
                business.setBirthGengoMeiji(星);
            } else {
                business.setBirthGengoMeiji(星);
                business.setBirthGengoShowa(星);
                business.setBirthGengoTaisho(星);
            }
        }
        if (!RString.isNullOrEmpty(row.getSeibetsu())) {
            if (Seibetsu.男.get名称().equals(row.getSeibetsu())) {
                business.setSeibetsuWoman(星);
            } else if (Seibetsu.女.get名称().equals(row.getSeibetsu())) {
                business.setSeibetsuMan(星);
            }
        }
        RString hokenshaNo = row.getHokenshaNo().padRight(RString.HALF_SPACE, 数字_6);
        business.setHokenshaNo1(hokenshaNo.substring(数字_0, 数字_1));
        business.setHokenshaNo2(hokenshaNo.substring(数字_1, 数字_2));
        business.setHokenshaNo3(hokenshaNo.substring(数字_2, 数字_3));
        business.setHokenshaNo4(hokenshaNo.substring(数字_3, 数字_4));
        business.setHokenshaNo5(hokenshaNo.substring(数字_4, 数字_5));
        business.setHokenshaNo6(hokenshaNo.substring(数字_5));
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        business.setHihokenshaNo1(hihokenshaNo.substring(数字_0, 数字_1));
        business.setHihokenshaNo2(hihokenshaNo.substring(数字_1, 数字_2));
        business.setHihokenshaNo3(hihokenshaNo.substring(数字_2, 数字_3));
        business.setHihokenshaNo4(hihokenshaNo.substring(数字_3, 数字_4));
        business.setHihokenshaNo5(hihokenshaNo.substring(数字_4, 数字_5));
        business.setHihokenshaNo6(hihokenshaNo.substring(数字_5, 数字_6));
        business.setHihokenshaNo7(hihokenshaNo.substring(数字_6, 数字_7));
        business.setHihokenshaNo8(hihokenshaNo.substring(数字_7, 数字_8));
        business.setHihokenshaNo9(hihokenshaNo.substring(数字_8, 数字_9));
        business.setHihokenshaNo10(hihokenshaNo.substring(数字_9));
        RDate 認定申請日 = row.getShinseiDay().getValue();
        if (認定申請日 != null) {
            business.setShinseiYY1(認定申請日.getYear().wareki().toDateString().substring(数字_1, 数字_2));
            business.setShinseiYY2(認定申請日.getYear().wareki().toDateString().substring(数字_2, 数字_3));
            business.setShinseiMM1(new RString(String.valueOf(認定申請日.getMonthValue() / 数字_10)));
            business.setShinseiMM2(new RString(String.valueOf(認定申請日.getMonthValue() % 数字_10)));
            business.setShinseiDD1(new RString(String.valueOf(認定申請日.getDayValue() / 数字_10)));
            business.setShinseiDD2(new RString(String.valueOf(認定申請日.getDayValue() % 数字_10)));
        }

        return business;
    }

    private ShujiiIkenshoSakuseiRyoSeikyushoItem create主治医意見書作成料請求書(dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        RString tempP_新規在宅金額 = IkenshoSakuseiRyo.在宅新規.get名称();
        RString tempP_新規施設金額 = IkenshoSakuseiRyo.施設新規.get名称();
        RString tempP_継続在宅金額 = IkenshoSakuseiRyo.在宅継続.get名称();
        RString tempP_継続施設金額 = IkenshoSakuseiRyo.施設継続.get名称();
        ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
        if (!tempP_新規在宅金額.isNull() && !tempP_新規在宅金額.isEmpty()) {
            item.setShinkiZaitakuKingaku(new RString(tempP_新規在宅金額.toString()));
        }
        if (!tempP_新規施設金額.isNull() && !tempP_新規施設金額.isEmpty()) {
            item.setShinkiShisetsuKingaku(new RString(tempP_新規施設金額.toString()));
        }
        if (!tempP_継続在宅金額.isNull() && !tempP_継続在宅金額.isEmpty()) {
            item.setKeizokuZaitakuKingaku(new RString(tempP_継続在宅金額.toString()));
        }
        if (!tempP_継続施設金額.isNull() && !tempP_継続施設金額.isEmpty()) {
            item.setKeizokuShisetsuKingaku(new RString(tempP_継続施設金額.toString()));
        }
        item.setGengo(RDate.getNowDate().toDateString());
        item.setAtesakiHokenshaName(row.getHokensha());
        item.setHihokenshaNo1(hihokenshaNo.substring(数字_0, 数字_1));
        item.setHihokenshaNo2(hihokenshaNo.substring(数字_1, 数字_2));
        item.setHihokenshaNo3(hihokenshaNo.substring(数字_2, 数字_3));
        item.setHihokenshaNo4(hihokenshaNo.substring(数字_3, 数字_4));
        item.setHihokenshaNo5(hihokenshaNo.substring(数字_4, 数字_5));
        item.setHihokenshaNo6(hihokenshaNo.substring(数字_5, 数字_6));
        item.setHihokenshaNo7(hihokenshaNo.substring(数字_6, 数字_7));
        item.setHihokenshaNo8(hihokenshaNo.substring(数字_7, 数字_8));
        item.setHihokenshaNo9(hihokenshaNo.substring(数字_8, 数字_9));
        item.setHihokenshaNo10(hihokenshaNo.substring(数字_9));
        item.setHihokenshaNameKana(row.getHihokenshaShimeiKana());
        item.setHihokenshaName(row.getHihokennshaShimei());
        item.setSeikyuIryokikanTel(row.getIryoKikanTelNo());
        item.setSeikyuIryokikanJusho(row.getIryoukikanShozaichi());
        item.setSeikyuIryokikanYubinNo(getEditedYubinNo(row.getIryoKikanYubinNo()));
        item.setSeikyuIryokikanDaihyoName(row.getDaihyoshaName());
        item.setSeikyuIryokikanName(row.getShujiiIryoKikan());
        if (row.getBirthYMD().getValue() != null && !FlexibleDate.EMPTY.equals(row.getBirthYMD().getValue())) {
            item.setBirthYMD(row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        item.setSeibetsu(row.getSeibetsu());
        if (!row.getShisetsuNyushoFlag()) {
            item.setShubetsuZaitaku(意見書作成料_種別);
        } else {
            item.setShubetsuShisetsu(意見書作成料_種別);
        }
        if (new RString(ShujiiIkenshoIraiKubun.初回.name()).equals(row.getIraiKubun())) {
            item.setShubetsuShinki(意見書作成料_種別);
        } else {
            item.setShubetsuKeizoku(意見書作成料_種別);
        }
        if (!row.getShisetsuNyushoFlag()) {
            if (new RString(ShujiiIkenshoIraiKubun.初回.name()).equals(row.getIraiKubun())) {
                item.setIkenshoSakuseiRyo1(tempP_新規在宅金額.substring(数字_0, 数字_1));
                item.setIkenshoSakuseiRyo2(tempP_新規在宅金額.substring(数字_1, 数字_2));
                item.setIkenshoSakuseiRyo3(tempP_新規在宅金額.substring(数字_2, 数字_3));
                item.setIkenshoSakuseiRyo4(tempP_新規在宅金額.substring(数字_3));
                item.setSeikyugakuIkenshoSakuseiRyo1(tempP_新規在宅金額.substring(数字_0, 数字_1));
                item.setSeikyugakuIkenshoSakuseiRyo2(tempP_新規在宅金額.substring(数字_1, 数字_2));
                item.setSeikyugakuIkenshoSakuseiRyo3(tempP_新規在宅金額.substring(数字_2, 数字_3));
                item.setSeikyugakuIkenshoSakuseiRyo4(tempP_新規在宅金額.substring(数字_3));
            } else if (new RString(ShujiiIkenshoIraiKubun.再依頼.name()).equals(row.getIraiKubun())) {
                item.setIkenshoSakuseiRyo1(tempP_継続在宅金額.substring(数字_0, 数字_1));
                item.setIkenshoSakuseiRyo2(tempP_継続在宅金額.substring(数字_1, 数字_2));
                item.setIkenshoSakuseiRyo3(tempP_継続在宅金額.substring(数字_2, 数字_3));
                item.setIkenshoSakuseiRyo4(tempP_継続在宅金額.substring(数字_3));
                item.setSeikyugakuIkenshoSakuseiRyo1(tempP_継続在宅金額.substring(数字_0, 数字_1));
                item.setSeikyugakuIkenshoSakuseiRyo2(tempP_継続在宅金額.substring(数字_1, 数字_2));
                item.setSeikyugakuIkenshoSakuseiRyo3(tempP_継続在宅金額.substring(数字_2, 数字_3));
                item.setSeikyugakuIkenshoSakuseiRyo4(tempP_継続在宅金額.substring(数字_3));
            }
        } else if (new RString(ShujiiIkenshoIraiKubun.初回.name()).equals(row.getIraiKubun())) {
            item.setIkenshoSakuseiRyo1(tempP_新規施設金額.substring(数字_0, 数字_1));
            item.setIkenshoSakuseiRyo2(tempP_新規施設金額.substring(数字_1, 数字_2));
            item.setIkenshoSakuseiRyo3(tempP_新規施設金額.substring(数字_2, 数字_3));
            item.setIkenshoSakuseiRyo4(tempP_新規施設金額.substring(数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo1(tempP_新規施設金額.substring(数字_0, 数字_1));
            item.setSeikyugakuIkenshoSakuseiRyo2(tempP_新規施設金額.substring(数字_1, 数字_2));
            item.setSeikyugakuIkenshoSakuseiRyo3(tempP_新規施設金額.substring(数字_2, 数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(tempP_新規施設金額.substring(数字_3));
        } else if (new RString(ShujiiIkenshoIraiKubun.再依頼.name()).equals(row.getIraiKubun())) {
            item.setIkenshoSakuseiRyo1(tempP_継続施設金額.substring(数字_0, 数字_1));
            item.setIkenshoSakuseiRyo2(tempP_継続施設金額.substring(数字_1, 数字_2));
            item.setIkenshoSakuseiRyo3(tempP_継続施設金額.substring(数字_2, 数字_3));
            item.setIkenshoSakuseiRyo4(tempP_継続施設金額.substring(数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo1(tempP_継続施設金額.substring(数字_0, 数字_1));
            item.setSeikyugakuIkenshoSakuseiRyo2(tempP_継続施設金額.substring(数字_1, 数字_2));
            item.setSeikyugakuIkenshoSakuseiRyo3(tempP_継続施設金額.substring(数字_2, 数字_3));
            item.setSeikyugakuIkenshoSakuseiRyo4(tempP_継続施設金額.substring(数字_3));
        }
        return item;
    }

    private KaigohokenShindanMeireishoHeaderItem create介護保険診断命令書(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        RStringBuilder jyushin = new RStringBuilder();
        if (SELECTED_KEY0.equals(div.getMeireisho().getRadjyushin().getSelectedKey())) {
            jyushin.append(div.getMeireisho().getTxtjyushinymd().getValue().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            jyushin.append(RString.HALF_SPACE);
            jyushin.append(div.getMeireisho().getTxtjyushintime().getValue().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
        } else {
            jyushin.append(div.getMeireisho().getTxtJyushinKikan().getFromValue().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            jyushin.append(new RString("～"));
            jyushin.append(div.getMeireisho().getTxtJyushinKikan().getToValue().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        KaigohokenShindanMeireishoHeaderItem item = new KaigohokenShindanMeireishoHeaderItem();
        item.setHihokenshaNo(row.getHihokenshaNo());
        //#109276のQAにより修正
        item.setHihokenshaName(row.getHihokennshaShimei());
        item.setTitle(DbBusinessConfig.get(ConfigNameDBE.介護保険診断命令書, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        item.setIryokikanName(row.getShujiiIryoKikan());
        item.setTantoIshiName(row.getShujii());
        item.setIryokikanJusho(row.getIryoukikanShozaichi());
        item.setTelNo(row.getIryoKikanTelNo());
        item.setJushinKikan(jyushin.toRString());
        item.setJushinArea(div.getMeireisho().getTxtjyushinbasho().getValue());
        item.setHakkoYMD(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setJushoText(row.getJusho());
        item.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        item.setMeishoFuyo(ChohyoAtesakiKeisho.toValue(
                DbBusinessConfig.get(ConfigNameDBE.介護保険診断命令書_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称());
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId(), KamokuCode.EMPTY, 数字_1);
        item.setTsuchibun1(通知文.get(数字_1));
        item.setTsuchibun2(通知文.get(数字_2));
        item.setCustomerBarCode(ReportUtil.getCustomerBarCode(row.getIryoKikanYubinNo(), row.getIryoukikanShozaichi()));
        return item;
    }

    private ShujiiIkenshoTeishutsuIraishoItem create介護保険指定医依頼兼主治医意見書提出意見書(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        ShujiiIkenshoTeishutsuIraishoItem item = new ShujiiIkenshoTeishutsuIraishoItem();
        if(!RString.isNullOrEmpty(div.getBunshoBango().get文書番号())){
            item.setBunshoNo(div.getBunshoBango().get文書番号());
        }else{
            item.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), FlexibleDate.getNowDate()));
        }
        item.setTitle(ReportIdDBE.DBE236001.getReportName());
        item.setHakkoYMD1(div.getTxtHakobi().getValue().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        item.setHihokenshaNo1(hihokenshaNo.substring(数字_0, 数字_1));
        item.setHihokenshaNo2(hihokenshaNo.substring(数字_1, 数字_2));
        item.setHihokenshaNo3(hihokenshaNo.substring(数字_2, 数字_3));
        item.setHihokenshaNo4(hihokenshaNo.substring(数字_3, 数字_4));
        item.setHihokenshaNo5(hihokenshaNo.substring(数字_4, 数字_5));
        item.setHihokenshaNo6(hihokenshaNo.substring(数字_5, 数字_6));
        item.setHihokenshaNo7(hihokenshaNo.substring(数字_6, 数字_7));
        item.setHihokenshaNo8(hihokenshaNo.substring(数字_7, 数字_8));
        item.setHihokenshaNo9(hihokenshaNo.substring(数字_8, 数字_9));
        item.setHihokenshaNo10(hihokenshaNo.substring(数字_9));
        item.setHihokenshaName(row.getHihokennshaShimei());
        item.setHihokenshaNameKana(row.getHihokenshaShimeiKana());
        item.setJusho(row.getJusho());
        item.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        FlexibleDate birthYMD = row.getBirthYMD().getValue();
        if (birthYMD != null && !FlexibleDate.EMPTY.equals(birthYMD)) {
            item.setBirthYMD(row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().substring(数字_2));
            if (new RString("明").equals(birthYMD.wareki().getEra())) {
                item.setBirthGengoShowa(星);
                item.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.wareki().getEra())) {
                item.setBirthGengoMeiji(星);
                item.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.wareki().getEra())) {
                item.setBirthGengoTaisho(星);
                item.setBirthGengoMeiji(星);
            } else {
                item.setBirthGengoMeiji(星);
                item.setBirthGengoShowa(星);
                item.setBirthGengoTaisho(星);
            }
        }
        if (!RString.isNullOrEmpty(row.getSeibetsu())) {
            if (Seibetsu.男.get名称().equals(row.getSeibetsu())) {
                item.setSeibetsuWoman(星);
            } else if (Seibetsu.女.get名称().equals(row.getSeibetsu())) {
                item.setSeibetsuMan(星);
            }
        }
        Map<Integer, RString> 通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援,
                ReportIdDBE.DBE236001.getReportId(), KamokuCode.EMPTY, 数字_1);
        item.setTsuchibun1(通知文.get(数字_1));
        item.setTsuchibun2(通知文.get(数字_2));
        item.setYubinNo1(getEditedYubinNo(row.getIryoKikanYubinNo()));
        item.setJushoText(row.getIryoukikanShozaichi());
        item.setKikanNameText(row.getShujiiIryoKikan());
        item.setShimeiText(row.getShujii());
        item.setMeishoFuyo(ChohyoAtesakiKeisho.toValue(DbBusinessConfig.get(ConfigNameDBE.介護保険指定医依頼兼主治医意見書提出依頼書_宛先敬称,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援)).get名称());
        item.setCustomerBarCode(ReportUtil.getCustomerBarCode(row.getIryoKikanYubinNo(), row.getIryoukikanShozaichi()));
        item.setSonota(row.getHihokenshaNo());
        return item;
    }

    private void createChoHyoData(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        if (row.getSelected()) {
            if (div.getIraiprint().getIraiSho().getSelectedKeys().contains(SELECTED_KEY0)) {
                主治医意見書作成依頼情報ItemList.add(create主治医意見書作成依頼書(div, row));
            }
            if (div.getIraiprint().getIraiIchiranHyo().getSelectedKeys().contains(SELECTED_KEY0)) {
                主治医意見書作成依頼一覧表ItemList.add(create主治医意見書作成依頼一覧表(div, row));
            }
            if (div.getIraiprint().getKinyoYoshi().getSelectedKeys().contains(SELECTED_KEY0)) {
                create主治医意見書記入用紙(row);
            }
            if (div.getIraiprint().getKinyuYoshiOCR().getSelectedKeys().contains(SELECTED_KEY0)) {
                create主治医意見書記入用紙OCR(row);
            }
            if (div.getIraiprint().getKinyuYoshiDesign().getSelectedKeys().contains(SELECTED_KEY0)) {
                create主治医意見書記入用紙D(row);
            }
            if (div.getIraiprint().getSeikyuSho().getSelectedKeys().contains(SELECTED_KEY0)) {
                主治医意見書作成料請求書ItemList.add(create主治医意見書作成料請求書(row));
            }
            if (div.getIraiprint().getMeireiSho().getSelectedKeys().contains(SELECTED_KEY0)) {
                介護保険診断命令書ItemList.add(create介護保険診断命令書(div, row));
            }
            if (div.getIraiprint().getTeishutsuIraiSho().getSelectedKeys().contains(SELECTED_KEY0)) {
                介護保険指定医依頼兼主治医意見書提出意見書ItemList.add(create介護保険指定医依頼兼主治医意見書提出意見書(div, row));
            }
        }
    }

    private void toPrint(ReportManager reportManager) {
        RDate date = RDate.getNowDate();
        ShujiiIkenshoSakuseiIraiReportOutputService outputService = ShujiiIkenshoSakuseiIraiReportOutputService.createInstance();
        IkenshokinyuyoshiPrintService printService = new IkenshokinyuyoshiPrintService(reportManager);
        if (!主治医意見書作成依頼情報ItemList.isEmpty()) {
            outputService.print主治医意見書作成依頼情報(主治医意見書作成依頼情報ItemList, reportManager);
        }
        if (!主治医意見書作成依頼一覧表ItemList.isEmpty()) {
            outputService.print主治医意見書作成依頼一覧表(主治医意見書作成依頼一覧表ItemList, reportManager);
        }
        if (!主治医意見書作成料請求書ItemList.isEmpty()) {
            outputService.print主治医意見書作成料請求書(主治医意見書作成料請求書ItemList, reportManager);
        }
        if (!介護保険診断命令書ItemList.isEmpty()) {
            outputService.print介護保険診断命令書(介護保険診断命令書ItemList, reportManager);
        }
        if (!介護保険指定医依頼兼主治医意見書提出意見書ItemList.isEmpty()) {
            outputService.print介護保険指定医依頼兼主治医意見書提出意見書(介護保険指定医依頼兼主治医意見書提出意見書ItemList, reportManager);
        }
        if (!主治医意見書記入用紙List.isEmpty()) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print(主治医意見書記入用紙List, ReportIdDBZ.DBE231001_Katamen_Mono.getReportId());
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print(主治医意見書記入用紙List, ReportIdDBZ.DBE231001_Ryomen_Mono.getReportId());
            }
        }
        if (!主治医意見書記入用紙OCRList.isEmpty()) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print(主治医意見書記入用紙OCRList, ReportIdDBZ.DBE231011_Katamen_Color.getReportId());
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print(主治医意見書記入用紙OCRList, ReportIdDBZ.DBE231011_Ryomen_Color.getReportId());
            }
        }
        if (!主治医意見書記入用紙DList.isEmpty()) {
            if (CONFIGVALUE1.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print(主治医意見書記入用紙DList, ReportIdDBZ.DBE231012.getReportId());
            } else if (CONFIGVALUE2.equals(DbBusinessConfig.get(ConfigNameDBE.意見書印刷タイプ, date, SubGyomuCode.DBE認定支援))) {
                printService.print(主治医意見書記入用紙DList, ReportIdDBZ.DBE231014.getReportId());
            }
        }
    }

    private RString get主治医意見書作成期限年月日(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row, RString kubun) {

        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 提出期限 = RString.EMPTY;
        RString key = div.getIraiprint().getRadkigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (主治医意見書作成期限設定方法_1.equals(認定調査期限設定方法)) {
            if (SELECTED_KEY0.equals(key)) {
                if (SELECTED_KEY0.equals(kubun)) {
                    提出期限 = row.getShujiiIkenshoSakuseiIraiDay().getValue() != null
                            ? row.getShujiiIkenshoSakuseiIraiDay().getValue().plusDay(期限日数).
                            wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                            separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString() : RString.EMPTY;
                } else {
                    提出期限 = row.getShujiiIkenshoSakuseiIraiDay().getValue() != null
                            ? row.getShujiiIkenshoSakuseiIraiDay().getValue().plusDay(期限日数).
                            wareki().toDateString() : RString.EMPTY;
                }
            } else if (SELECTED_KEY1.equals(key)) {
                提出期限 = RString.EMPTY;
            } else if (SELECTED_KEY2.equals(key)) {
                RDate 共通日 = div.getTxtkigenymd().getValue();
                if (SELECTED_KEY0.equals(kubun)) {
                    提出期限 = (共通日 != null ? 共通日.
                            wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                            separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
                } else {
                    提出期限 = (共通日 != null ? 共通日.wareki().toDateString() : RString.EMPTY);
                }
            }
        } else if (SELECTED_KEY0.equals(kubun)) {
            提出期限 = row.getShinseiDay().getValue() != null
                    ? row.getShinseiDay().getValue().plusDay(期限日数).
                    wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString() : RString.EMPTY;
        } else {
            提出期限 = row.getShinseiDay().getValue() != null
                    ? row.getShinseiDay().getValue().plusDay(期限日数).
                    wareki().toDateString() : RString.EMPTY;
        }
        return 提出期限;
    }

    private PersonalData toPersonalData(ShujiiIkenshoSakuseiIraiDiv div) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private ShujiiIraiAtenaJoho get宛先(dgShinseishaIchiran_Row row) {
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        ShujiiIraiAtenaJohoParameter parameter = new ShujiiIraiAtenaJohoParameter();
        parameter.setShichosonCode(row.getShichosonCode());
        parameter.setShujiiCode(row.getShujiiCode());
        parameter.setShujiiIryokikanCode(row.getShujiiIryoKikanCode());
        return manager.get宛先情報(parameter);
    }

    /**
     * 受診日チェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onBlur_txtjyushinymd(ShujiiIkenshoSakuseiIraiDiv div) {
        if (!RString.isNullOrEmpty(div.getTxtjyushinymd().getText())) {
            if (div.getTxtjyushinymd().getValue().isBefore(RDate.getNowDate())) {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("申請日より過去の日付けが設定されていますが")).respond();
                }
                if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No)) {
                    div.getTxtjyushinymd().clearValue();
                }
            }
        }

        return ResponseData.of(div).respond();
    }
    
    /**
     * 意見書作成依頼チェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_iraiSho(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }
    
    /**
     * 意見書作成依頼一覧表チェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_iraiIchiranHyo(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }
    
     /**
     * 主治医意見書記入用紙チェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_kinyoYoshi(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }
    
     /**
     * 主治医意見書記入用紙OCRチェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_kinyuYoshiOCR(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }
    
     /**
     * 主治医意見書記入用紙デザインチェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_kinyuYoshiDesign(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }
    
     /**
     * 主治医意見書作成料請求書デザインチェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_seikyuSho(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }    

     /**
     * 介護保険指定医依頼兼主治医意見書提出依頼書チェック。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_teishutsuIraiSho(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).respond();
    }    
    
    
     /**
     * 対象選択ラジオボタン選択を設定します。
     *
     * @param div コントロールdiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onChange_radkigen(ShujiiIkenshoSakuseiIraiDiv div) {
        if (SELECTED_KEY0.equals(div.getRadkigen().getSelectedKey())) {
            div.getTxtkigenymd().clearValue();
            div.getTxtkigenymd().setDisabled(true);
            return ResponseData.of(div).respond();
        }
        if (SELECTED_KEY1.equals(div.getRadkigen().getSelectedKey())) {
            div.getTxtkigenymd().clearValue();
            div.getTxtkigenymd().setDisabled(true);
            return ResponseData.of(div).respond();
        }
        if (SELECTED_KEY2.equals(div.getRadkigen().getSelectedKey())) {
            div.getTxtkigenymd().setDisabled(false);
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).respond();
    }
    
         /**
     * 受信期間ラジオボタン選択を設定します。
     *
     * @param div コントロールdiv
     * @return ResponseData<ShujiiIkenshoSakuseiIraiDiv>
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onChange_radjyushin(ShujiiIkenshoSakuseiIraiDiv div) {
        set受信(div);
        return ResponseData.of(div).respond();
    }
    
    private void set受信(ShujiiIkenshoSakuseiIraiDiv div) {
        if (SELECTED_KEY0.equals(div.getRadjyushin().getSelectedKey())) {
            div.getTxtJyushinKikan().clearFromValue();
            div.getTxtJyushinKikan().clearToValue();
            div.getTxtJyushinKikan().setDisabled(true);
            div.getTxtjyushinymd().setDisabled(false);
            div.getTxtjyushintime().setDisabled(false);
        }
        if (SELECTED_KEY1.equals(div.getRadjyushin().getSelectedKey())) {
            div.getTxtjyushinymd().clearValue();
            div.getTxtjyushintime().clearValue();
            div.getTxtjyushinymd().setDisabled(true);
            div.getTxtjyushintime().setDisabled(true);
            div.getTxtJyushinKikan().setDisabled(false);
        }
    }

    private static RString getHihokenshaNo(ShujiiIkenshoSakuseiIraiDiv div) {
        if (div.getHdnClickedButton().toString().equals(ClickedButton.表示する.name())) {
            return div.getCcdNinteishinseishaFinder().getSaikinShorishaDiv().getSelectedHihokenshaNo();
        } else {
            return div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue();
        }
    }

    private enum ClickedButton {
        表示する,
        検索する
    }
}
