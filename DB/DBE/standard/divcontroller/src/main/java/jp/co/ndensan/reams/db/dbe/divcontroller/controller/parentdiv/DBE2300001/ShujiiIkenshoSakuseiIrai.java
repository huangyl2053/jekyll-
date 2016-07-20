/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2Identifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
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
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
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
    private static final RString 帳票発行 = new RString("btnHakkou");
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

    /**
     * 主治医意見書作成依頼の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onLoad(ShujiiIkenshoSakuseiIraiDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(帳票発行, false);
        LockingKey 排他キー
                = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo")));
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage());
        }
        createHandler(div).load();
        div.getIraiprint().getTxtkigenymd().setValue(RDate.getNowDate());
        div.getTxtShujiiIkensahoSakuseiIraiDay().setValue(RDate.getNowDate());
        div.getIraiprint().getTxtHakobi().setValue(RDate.getNowDate());
        div.getMeireisho().getRadjyushin().setSelectedKey(SELECTED_KEY1);
        div.getMeireisho().setDisplayNone(true);
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
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_Chkprint(ShujiiIkenshoSakuseiIraiDiv div) {
        if (div.getChkprint().getSelectedKeys().contains(SELECTED_KEY3)) {
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
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData(div));
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        ShujiiIkenshoSakuseiIraiParameter param = createHandler(div).createParameter();
        createHandler(div).init(manager.get申請者情報(param).records());
        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報
                = Models.create(manager.get主治医意見書作成依頼情報(param).records());
        Models<NinteiShinseiJoho2Identifier, NinteiShinseiJoho2> 要介護認定申請情報
                = Models.create(manager.get要介護認定申請情報(param).records());
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼情報, 主治医意見書作成依頼情報);
        ViewStateHolder.put(ViewStateKeys.要介護認定申請情報, 要介護認定申請情報);
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
     * 削除処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onSelect_btnDelete(ShujiiIkenshoSakuseiIraiDiv div) {
        dgShinseishaIchiran_Row row = div.getDgShinseishaIchiran().getActiveRow();
        if (RString.isNullOrEmpty(row.getIraiKubun())) {
            clearShujii(row);
            row.setStatus(RString.EMPTY);
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace(再依頼申請者削除.toString())).respond();
            }
            if (new RString(UrQuestionMessages.確認_汎用.getMessage().replace(再依頼申請者削除.toString()).getCode()).
                    equals(ResponseHolder.getMessageCode()) && (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
                row.setStatus(削除);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保存処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnHozon(ShujiiIkenshoSakuseiIraiDiv div) {
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
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
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
     * 発行押下の処理を行います。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<SourceDataCollection> onClick_btnHakkou(ShujiiIkenshoSakuseiIraiDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
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
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnHakkouKanryo(ShujiiIkenshoSakuseiIraiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            RealInitialLocker.release(new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))));
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
        Models<NinteiShinseiJoho2Identifier, NinteiShinseiJoho2> 要介護認定申請情報
                = ViewStateHolder.get(ViewStateKeys.要介護認定申請情報, Models.class);
        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報
                = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼情報, Models.class);
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        RDate sysdate = RDate.getNowDate();
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, sysdate, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, sysdate, SubGyomuCode.DBE認定支援);
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (新規.equals(row.getStatus())) {
                int rirekiNo = 数字_1;
                if (!RString.isNullOrEmpty(row.getPreRirekiNo())) {
                    rirekiNo = Integer.parseInt(row.getPreRirekiNo().toString()) + 数字_1;
                }
                manager.save主治医意見書作成依頼情報(
                        create主治医意見書作成依頼情報(row, 主治医意見書作成期限設定方法, 主治医意見書作成期限日数, rirekiNo), EntityDataState.Added);
                NinteiShinseiJoho2 shinseiJoho = 要介護認定申請情報.get(new NinteiShinseiJoho2Identifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo())));
                NinteiShinseiJoho2Builder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
                shinseiJohoBuilder.set主治医医療機関コード(row.getShujiiIryoKikanCode());
                shinseiJohoBuilder.set主治医コード(row.getShujiiCode());
                shinseiJohoBuilder.set指定医フラグ(row.getShiteiiFlag());
                shinseiJoho = shinseiJohoBuilder.build();
                manager.save要介護認定申請情報(shinseiJoho, EntityDataState.Modified);
            } else if (修正.equals(row.getStatus())) {
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = 主治医意見書作成依頼情報.get(new ShujiiIkenshoIraiJohoIdentifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo()), Integer.parseInt(row.getRirekiNo().toString())));
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                builder.set論理削除フラグ(true);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
                manager.save主治医意見書作成依頼情報(
                        create主治医意見書作成依頼情報(row, 主治医意見書作成期限設定方法, 主治医意見書作成期限日数,
                                Integer.parseInt(row.getRirekiNo().toString()) + 1), EntityDataState.Added);
                NinteiShinseiJoho2 shinseiJoho = 要介護認定申請情報.get(new NinteiShinseiJoho2Identifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo())));
                NinteiShinseiJoho2Builder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
                shinseiJohoBuilder.set主治医医療機関コード(row.getShujiiIryoKikanCode());
                shinseiJohoBuilder.set主治医コード(row.getShujiiCode());
                shinseiJohoBuilder.set指定医フラグ(row.getShiteiiFlag());
                shinseiJoho = shinseiJohoBuilder.build();
                manager.save要介護認定申請情報(shinseiJoho, EntityDataState.Modified);
            } else if (削除.equals(row.getStatus())) {
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = 主治医意見書作成依頼情報.get(new ShujiiIkenshoIraiJohoIdentifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo()), Integer.parseInt(row.getRirekiNo().toString())));
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                builder.set論理削除フラグ(true);
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
            }
        }
    }

    private ShujiiIkenshoIraiJoho create主治医意見書作成依頼情報(dgShinseishaIchiran_Row row, RString 設定方法, RString 期限日数, int rirekiNo) {
        ShujiiIkenshoIraiJohoBuilder builder = create主治医意見書作成依頼情報Builder(row, 設定方法, 期限日数, rirekiNo);
        if (RString.isNullOrEmpty(row.getIraiKubun())) {
            builder.set主治医意見書依頼区分(ShujiiIkenshoIraiKubun.初回.getCode());
        } else if (!row.getSakujoKbn()) {
            builder.set主治医意見書依頼区分(ShujiiIkenshoIraiKubun.再依頼.getCode());
        }
        return builder.build();
    }

    private ShujiiIkenshoIraiJohoBuilder create主治医意見書作成依頼情報Builder(dgShinseishaIchiran_Row row,
            RString 設定方法, RString 期限日数, int rirekiNo) {
        ShujiiIkenshoIraiJoho iraiJoho = new ShujiiIkenshoIraiJoho(new ShinseishoKanriNo(row.getShiseishoKanriNo()),
                rirekiNo);
        ShujiiIkenshoIraiJohoBuilder builder = iraiJoho.createBuilderForEdit();
        builder.set主治医医療機関コード(row.getShujiiIryoKikanCode());
        builder.set主治医コード(row.getShujiiCode());
        builder.set厚労省IF識別コード(new Code(row.getKoroshoIfShikibetsuCode()));
        builder.set主治医意見書作成回数(数字_1);
        builder.set医師区分コード(new Code(row.getIshiKbnCode()));
        builder.set主治医意見書作成依頼年月日(new FlexibleDate(row.getShujiiIkenshoSakuseiIraiDay().getValue().toDateString()));
        if (主治医意見書作成期限設定方法_1.equals(設定方法) && row.getShujiiIkenshoSakuseiIraiDay() != null) {
            builder.set主治医意見書作成期限年月日(new FlexibleDate(row.getShujiiIkenshoSakuseiIraiDay()
                    .getValue().plusDay(Integer.parseInt(期限日数.toString())).toDateString()));
        } else if (row.getShinseiDay() != null) {
            builder.set主治医意見書作成期限年月日(new FlexibleDate(row.getShinseiDay()
                    .getValue().plusDay(Integer.parseInt(期限日数.toString())).toDateString()));
        }
        builder.set論理削除フラグ(false);
        return builder;
    }

    private void printData(ShujiiIkenshoSakuseiIraiDiv div, ReportManager reportManager) {

        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報
                = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼情報, Models.class);
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        主治医意見書作成依頼情報ItemList = new ArrayList<>();
        主治医意見書作成依頼一覧表ItemList = new ArrayList<>();
        主治医意見書作成料請求書ItemList = new ArrayList<>();
        介護保険診断命令書ItemList = new ArrayList<>();
        介護保険指定医依頼兼主治医意見書提出意見書ItemList = new ArrayList<>();
        主治医意見書記入用紙List = new ArrayList<>();
        主治医意見書記入用紙OCRList = new ArrayList<>();
        List<ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報List = new ArrayList<>();

        RDate sysdate = RDate.getNowDate();
        RString 主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, sysdate, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, sysdate, SubGyomuCode.DBE認定支援);
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && !div.getChkirai().getSelectedKeys().isEmpty()) {
                主治医意見書作成依頼情報List.add(create主治医意見書作成依頼情報(主治医意見書作成依頼情報, 主治医意見書作成期限設定方法, 主治医意見書作成期限日数, div, row));
            }
            createChoHyoData(div, row);
        }
        toPrint(reportManager);
        for (ShujiiIkenshoIraiJoho ikenshoIraiJoho : 主治医意見書作成依頼情報List) {
            manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
        }
    }

    private ShujiiIkenshoIraiJoho create主治医意見書作成依頼情報(Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報,
            RString 主治医意見書作成期限設定方法, RString 主治医意見書作成期限日数, ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {

        ShujiiIkenshoIraiJoho ikenshoIraiJoho = 主治医意見書作成依頼情報.get(new ShujiiIkenshoIraiJohoIdentifier(
                new ShinseishoKanriNo(row.getShiseishoKanriNo()), Integer.parseInt(row.getRirekiNo().toString())));
        ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
        builder.set依頼書出力年月日(FlexibleDate.getNowDate());
        if (主治医意見書作成期限設定方法_1.equals(主治医意見書作成期限設定方法)) {
            if (SELECTED_KEY0.equals(div.getIraiprint().getRadkigen().getSelectedKey())) {
                builder.set主治医意見書作成期限年月日(new FlexibleDate(row.getShujiiIkenshoSakuseiIraiDay().getValue().
                        plusDay(Integer.parseInt(主治医意見書作成期限日数.toString())).toDateString()));
            } else if (SELECTED_KEY1.equals(div.getIraiprint().getRadkigen().getSelectedKey())) {
                builder.set主治医意見書作成期限年月日(FlexibleDate.EMPTY);
            } else if (div.getIraiprint().getTxtkigenymd().getValue() != null) {
                builder.set主治医意見書作成期限年月日(new FlexibleDate(div.getIraiprint().getTxtkigenymd().getValue().toDateString()));
            }
        }
        return builder.build();
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
        iraishoItem.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230001.getReportId(), FlexibleDate.getNowDate()));
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
        iraishoItem.setTeishutsuKigen(get主治医意見書作成期限年月日(div, row));
        if (row.getShinseiDay().getValue() != null) {
            iraishoItem.setShinseiYMD(row.getShinseiDay().getValue().toDateString());
        }
        iraishoItem.setShoriName(row.getIraiKubun());
        iraishoItem.setRemban(new RString("1"));
        ShujiiIraiAtenaJoho atenaJoho = get宛先(row);
        if (atenaJoho != null) {
            iraishoItem.setYubinNo1(atenaJoho.getTemp_宛名郵便番号() == null ? RString.EMPTY : atenaJoho.getTemp_宛名郵便番号().value());
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
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().substring(数字_2));
            if (new RString("明").equals(birthYMD.getYear().wareki().getEra())) {
                iraishoItem.setBirthGengoShowa(星);
                iraishoItem.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.getYear().wareki().getEra())) {
                iraishoItem.setBirthGengoMeiji(星);
                iraishoItem.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.getYear().wareki().getEra())) {
                iraishoItem.setBirthGengoTaisho(星);
                iraishoItem.setBirthGengoMeiji(星);
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
            item.setYubinNo1(atenaJoho.getTemp_宛名郵便番号() == null ? RString.EMPTY : atenaJoho.getTemp_宛名郵便番号().value());
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
                ? RString.EMPTY : row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        item.setListIchiranhyo_8(row.getSeibetsu());
        item.setListIchiranhyo_9(get主治医意見書作成期限年月日(div, row));
        item.setTsuchibun1(ReportUtil.get通知文(
                SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230002.getReportId(), KamokuCode.EMPTY, 数字_1).get(数字_1));
        return item;
    }

    private IkenshokinyuyoshiBusiness create主治医意見書記入用紙(dgShinseishaIchiran_Row row) {
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
            business.setBirthYY(birthYMD.getYear().toDateString());
            business.setBirthMM(new RString(String.valueOf(birthYMD.getMonthValue())));
            business.setBirthDD(new RString(String.valueOf(birthYMD.getDayValue())));
            if (new RString("明").equals(birthYMD.getYear().wareki().getEra())) {
                business.setBirthGengoShowa(星);
                business.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.getYear().wareki().getEra())) {
                business.setBirthGengoMeiji(星);
                business.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.getYear().wareki().getEra())) {
                business.setBirthGengoTaisho(星);
                business.setBirthGengoMeiji(星);
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
        business.setHihokenshaName(row.getHokensha());
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
            business.setShinseiYY1(認定申請日.getYear().wareki().toDateString().substring(数字_0, 数字_1));
            business.setShinseiYY2(認定申請日.getYear().wareki().toDateString().substring(数字_1, 数字_2));
            business.setShinseiMM1(new RString(String.valueOf(認定申請日.getMonthValue() / 数字_10)));
            business.setShinseiMM2(new RString(String.valueOf(認定申請日.getMonthValue() % 数字_10)));
            business.setShinseiDD1(new RString(String.valueOf(認定申請日.getDayValue() / 数字_10)));
            business.setShinseiDD2(new RString(String.valueOf(認定申請日.getDayValue() % 数字_10)));
        }
        return business;
    }

    private IkenshokinyuyoshiBusiness create主治医意見書記入用紙OCR(dgShinseishaIchiran_Row row) {
        return create主治医意見書記入用紙(row);
    }

    private ShujiiIkenshoSakuseiRyoSeikyushoItem create主治医意見書作成料請求書(dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        RString tempP_新規在宅金額 = IkenshoSakuseiRyo.在宅新規.get名称();
        RString tempP_新規施設金額 = IkenshoSakuseiRyo.施設新規.get名称();
        RString tempP_継続在宅金額 = IkenshoSakuseiRyo.在宅継続.get名称();
        RString tempP_継続施設金額 = IkenshoSakuseiRyo.施設継続.get名称();
        ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
        item.setShinkiZaitakuKingaku(tempP_新規在宅金額);
        item.setShinkiShisetsuKingaku(tempP_新規施設金額);
        item.setKeizokuZaitakuKingaku(tempP_継続在宅金額);
        item.setKeizokuShisetsuKingaku(tempP_継続施設金額);
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
        item.setSeikyuIryokikanJusho(row.getJusho());
        item.setSeikyuIryokikanYubinNo(getEditedYubinNo(row.getYubinNo()));
        if (row.getBirthYMD().getValue() != null && !FlexibleDate.EMPTY.equals(row.getBirthYMD().getValue())) {
            item.setBirthYMD(row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
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
        } else {
            if (new RString(ShujiiIkenshoIraiKubun.初回.name()).equals(row.getIraiKubun())) {
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
        }
        return item;
    }

    private KaigohokenShindanMeireishoHeaderItem create介護保険診断命令書(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        RStringBuilder jyushin = new RStringBuilder();
        if (SELECTED_KEY0.equals(div.getMeireisho().getRadjyushin().getSelectedKey())) {
            jyushin.append(div.getMeireisho().getTxtjyushinymd().getValue().toDateString());
            jyushin.append(RString.HALF_SPACE);
            jyushin.append(div.getMeireisho().getTxtjyushintime().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm));
        } else {
            jyushin.append(div.getMeireisho().getTxtJyushinKikan().getFromValue().toDateString());
            jyushin.append(new RString("～"));
            jyushin.append(div.getMeireisho().getTxtJyushinKikan().getToValue().toDateString());
        }
        KaigohokenShindanMeireishoHeaderItem item = new KaigohokenShindanMeireishoHeaderItem();
        item.setHihokenshaNo(row.getHihokenshaNo());
        item.setHihokenshaName2(row.getHihokennshaShimei());
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
        item.setMeishoFuyo(DbBusinessConfig.get(ConfigNameDBE.介護保険診断命令書_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        CustomerBarCode barcode = new CustomerBarCode();
        CustomerBarCodeResult result = barcode.convertCustomerBarCode(row.getYubinNo(), row.getJusho());
        item.setCustomerBarCode(result.getCustomerBarCode());
        return item;
    }

    private ShujiiIkenshoTeishutsuIraishoItem create介護保険指定医依頼兼主治医意見書提出意見書(dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        ShujiiIkenshoTeishutsuIraishoItem item = new ShujiiIkenshoTeishutsuIraishoItem();
        item.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援,
                ReportIdDBE.DBE236001.getReportId(), FlexibleDate.getNowDate()));
        item.setTitle(ReportIdDBE.DBE236001.getReportName());
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
            if (new RString("明").equals(birthYMD.getYear().wareki().getEra())) {
                item.setBirthGengoShowa(星);
                item.setBirthGengoTaisho(星);
            } else if (new RString("大").equals(birthYMD.getYear().wareki().getEra())) {
                item.setBirthGengoMeiji(星);
                item.setBirthGengoShowa(星);
            } else if (new RString("昭").equals(birthYMD.getYear().wareki().getEra())) {
                item.setBirthGengoTaisho(星);
                item.setBirthGengoMeiji(星);
            }
        }
        if (!RString.isNullOrEmpty(row.getSeibetsu())) {
            if (Seibetsu.男.get名称().equals(row.getSeibetsu())) {
                item.setSeibetsuWoman(星);
            } else if (Seibetsu.女.get名称().equals(row.getSeibetsu())) {
                item.setSeibetsuMan(星);
            }
        }
        return item;
    }

    private void createChoHyoData(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        if (row.getSelected()) {
            if (div.getIraiprint().getChkirai().getSelectedKeys().contains(SELECTED_KEY0)) {
                主治医意見書作成依頼情報ItemList.add(create主治医意見書作成依頼書(div, row));
            }
            if (div.getIraiprint().getChkirai().getSelectedKeys().contains(SELECTED_KEY1)) {
                主治医意見書作成依頼一覧表ItemList.add(create主治医意見書作成依頼一覧表(div, row));
            }
            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY0)) {
                主治医意見書記入用紙List.add(create主治医意見書記入用紙(row));
            }
            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY1)) {
                主治医意見書記入用紙OCRList.add(create主治医意見書記入用紙OCR(row));
            }
            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY2)) {
                主治医意見書作成料請求書ItemList.add(create主治医意見書作成料請求書(row));
            }
            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY3)) {
                介護保険診断命令書ItemList.add(create介護保険診断命令書(div, row));
            }
            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY4)) {
                介護保険指定医依頼兼主治医意見書提出意見書ItemList.add(create介護保険指定医依頼兼主治医意見書提出意見書(row));
            }
        }
    }

    private void toPrint(ReportManager reportManager) {
        ShujiiIkenshoSakuseiIraiReportOutputService outputService = ShujiiIkenshoSakuseiIraiReportOutputService.createInstance();
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
            outputService.print主治医意見書記入用紙(主治医意見書記入用紙List, reportManager);
        }
        if (!主治医意見書記入用紙OCRList.isEmpty()) {
            outputService.print主治医意見書記入用紙OCR(主治医意見書記入用紙OCRList, reportManager);
        }
    }

    private RString get主治医意見書作成期限年月日(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {

        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援,
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShichosonCode().getSelectedKey());
        RString 提出期限 = RString.EMPTY;
        RString key = div.getIraiprint().getRadkigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (主治医意見書作成期限設定方法_1.equals(認定調査期限設定方法)) {
            if (SELECTED_KEY0.equals(key)) {
                提出期限 = row.getShujiiIkenshoSakuseiIraiDay().getValue() != null
                        ? row.getShujiiIkenshoSakuseiIraiDay().getValue().plusDay(期限日数).toDateString() : RString.EMPTY;
            } else if (SELECTED_KEY1.equals(key)) {
                提出期限 = RString.EMPTY;
            } else if (SELECTED_KEY2.equals(key)) {
                RDate 共通日 = div.getTxtkigenymd().getValue();
                提出期限 = (共通日 != null ? new RString(共通日.plusDay(期限日数).toString()) : RString.EMPTY);
            }
        } else {
            提出期限 = row.getShinseiDay().getValue() != null
                    ? row.getShinseiDay().getValue().plusDay(期限日数).toDateString() : RString.EMPTY;
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
}
