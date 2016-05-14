/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai.ShujiiIraiAtenaJoho;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiReportOutputService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
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
    private static final int 数字_11 = 11;
    private static final int 数字_12 = 12;
    private static final int 数字_13 = 13;
    private static final int 数字_14 = 14;
    private static final int 数字_15 = 15;
    private static final int 数字_16 = 16;
    private static final int 数字_17 = 17;
    private static final RString 帳票発行 = new RString("btnHakkou");
    private static final RString 意見書作成料_種別 = new RString("✔");
    private static final RString 再依頼申請者削除 = new RString("再依頼申請者を削除します。");
    private static final RString 依頼書印刷処理 = new RString("依頼書印刷処理");
    private List<ShujiiIkenshoSakuseiIraishoItem> 主治医意見書作成依頼情報ItemList;
    private List<IkenshoSakuseiIraiIchiranhyoItem> 主治医意見書作成依頼一覧表ItemList;
    private List<ShujiiIkenshoSakuseiRyoSeikyushoItem> 主治医意見書作成料請求書ItemList;
    private List<KaigohokenShindanMeireishoHeaderItem> 介護保険診断命令書ItemList;
    private List<ShujiiIkenshoTeishutsuIraishoItem> 介護保険指定医依頼兼主治医意見書提出意見書ItemList;

    /**
     * 主治医意見書作成依頼の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onLoad(ShujiiIkenshoSakuseiIraiDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(帳票発行, false);
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
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> 要介護認定申請情報
                = Models.create(manager.get要介護認定申請情報(param).records());
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼_主治医意見書作成依頼情報, 主治医意見書作成依頼情報);
        ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼_要介護認定申請情報, 要介護認定申請情報);
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
            LockingKey 排他キー
                    = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo")));
            if (!RealInitialLocker.tryGetLock(排他キー)) {
                return ResponseData.of(div).addValidationMessages(validationHandler.排他チェック()).respond();
            }
            toHozon(div);
            onClick_btnSearch(div);
            RealInitialLocker.release(排他キー);
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
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
        LockingKey 排他キー
                = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo")));
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            return ResponseData.of(div).addValidationMessages(createValidationHandler(div).排他チェック()).respond();
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
        LockingKey 排他キー
                = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo")));
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            printData(div, reportManager);
            response.data = reportManager.publish();
        }
        RealInitialLocker.release(排他キー);
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
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> 要介護認定申請情報
                = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼_要介護認定申請情報, Models.class);
        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報
                = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼_主治医意見書作成依頼情報, Models.class);
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        RString 主治医意見書作成期限設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, SubGyomuCode.DBE認定支援);
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (新規.equals(row.getStatus())) {
                int rirekiNo = 数字_1;
                if (!RString.isNullOrEmpty(row.getPreRirekiNo())) {
                    rirekiNo = Integer.parseInt(row.getPreRirekiNo().toString()) + 数字_1;
                }
                manager.save主治医意見書作成依頼情報(
                        create主治医意見書作成依頼情報(row, 主治医意見書作成期限設定方法, 主治医意見書作成期限日数, rirekiNo), EntityDataState.Added);
                NinteiShinseiJoho shinseiJoho = 要介護認定申請情報.get(new NinteiShinseiJohoIdentifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo())));
                NinteiShinseiJohoBuilder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
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
                NinteiShinseiJoho shinseiJoho = 要介護認定申請情報.get(new NinteiShinseiJohoIdentifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo())));
                NinteiShinseiJohoBuilder shinseiJohoBuilder = shinseiJoho.createBuilderForEdit();
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
                = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼_主治医意見書作成依頼情報, Models.class);
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        主治医意見書作成依頼情報ItemList = new ArrayList<>();
        // TODO QA894 帳票設計書と画面設計書不一致
        主治医意見書作成依頼一覧表ItemList = new ArrayList<>();
        主治医意見書作成料請求書ItemList = new ArrayList<>();
        介護保険診断命令書ItemList = new ArrayList<>();
        介護保険指定医依頼兼主治医意見書提出意見書ItemList = new ArrayList<>();

        RString 主治医意見書作成期限設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, SubGyomuCode.DBE認定支援);
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && 主治医意見書作成期限設定方法_1.equals(主治医意見書作成期限設定方法)
                    && !div.getChkirai().getSelectedKeys().isEmpty()) {
                ShujiiIkenshoIraiJoho ikenshoIraiJoho = 主治医意見書作成依頼情報.get(new ShujiiIkenshoIraiJohoIdentifier(
                        new ShinseishoKanriNo(row.getShiseishoKanriNo()), Integer.parseInt(row.getRirekiNo().toString())));
                ShujiiIkenshoIraiJohoBuilder builder = ikenshoIraiJoho.createBuilderForEdit();
                builder.set依頼書出力年月日(FlexibleDate.getNowDate());
                if (SELECTED_KEY0.equals(div.getIraiprint().getRadkigen().getSelectedKey())) {
                    builder.set主治医意見書作成期限年月日(new FlexibleDate(row.getShujiiIkenshoSakuseiIraiDay().getValue().
                            plusDay(Integer.parseInt(主治医意見書作成期限日数.toString())).toDateString()));
                } else if (SELECTED_KEY1.equals(div.getIraiprint().getRadkigen().getSelectedKey())) {
                    builder.set主治医意見書作成期限年月日(FlexibleDate.EMPTY);
                } else if (div.getIraiprint().getTxtkigenymd().getValue() != null) {
                    builder.set主治医意見書作成期限年月日(new FlexibleDate(div.getIraiprint().getTxtkigenymd().getValue().toDateString()));
                }
                ikenshoIraiJoho = builder.build();
                manager.save主治医意見書作成依頼情報(ikenshoIraiJoho, EntityDataState.Modified);
            }
            createChoHyoData(div, row);
        }
        toPrint(reportManager);
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
        iraishoItem.setTitle(DbBusinessConifg.get(ConfigNameDBE.主治医意見書作成依頼書, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
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
        iraishoItem.setBirthYMD(row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).width(Width.FULL).toDateString());
        iraishoItem.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        RString hokenshaNo = row.getHokenshaNo().padRight(RString.HALF_SPACE, 数字_5);
        iraishoItem.setHokenshaNo1(hokenshaNo.substring(数字_0, 数字_1));
        iraishoItem.setHokenshaNo2(hokenshaNo.substring(数字_1, 数字_2));
        iraishoItem.setHokenshaNo3(hokenshaNo.substring(数字_2, 数字_3));
        iraishoItem.setHokenshaNo4(hokenshaNo.substring(数字_3, 数字_4));
        iraishoItem.setHokenshaNo5(hokenshaNo.substring(数字_4, 数字_5));
        iraishoItem.setHokenshaNo6(hokenshaNo.substring(数字_5));
        iraishoItem.setShinseiKubun(row.getShinseiKubunShinseiji());
        if (row.getShinseiDay().getValue() != null) {
            iraishoItem.setShinseiYMD(row.getShinseiDay().getValue().toDateString());
        }
        if (div.getIraiprint().getTxtkigenymd().getValue() != null) {
            iraishoItem.setTeishutsuKigen(div.getIraiprint().getTxtkigenymd().getValue().toDateString());
        }
        iraishoItem.setShoriName(row.getIraiKubun());
        iraishoItem.setRemban(new RString("1"));
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        ShujiiIraiAtenaJohoParameter parameter = new ShujiiIraiAtenaJohoParameter();
        parameter.setShichosonCode(row.getShichosonCode());
        parameter.setShujiiCode(row.getShujiiCode());
        parameter.setShujiiIryokikanCode(row.getShujiiIryoKikanCode());
        ShujiiIraiAtenaJoho atenaJoho = manager.get宛先情報(parameter);
        if (atenaJoho != null) {
            iraishoItem.setYubinNo1(atenaJoho.getTemp_宛名郵便番号().value());
            iraishoItem.setJushoText(atenaJoho.getTemp_宛名住所().value());
            iraishoItem.setKikanNameText(atenaJoho.getTemp_宛名機関名());
            iraishoItem.setShimeiText(atenaJoho.getTemp_宛名氏名().value());
        }
        iraishoItem.setMeishoFuyo(
                ChohyoAtesakiKeisho.toValue(BusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称, SubGyomuCode.DBE認定支援)).get名称());
        iraishoItem.setSonota(RString.EMPTY);

        CustomerBarCode barcode = new CustomerBarCode();
        CustomerBarCodeResult result = barcode.convertCustomerBarCode(row.getYubinNo(), row.getJusho());
        iraishoItem.setCustomerBarCode(result.getCustomerBarCode());
        return iraishoItem;
    }

// TODO QA1096 帳票設計書と画面設計書不一致
    private IkenshoSakuseiIraiIchiranhyoItem create主治医意見書作成依頼一覧表(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        IkenshoSakuseiIraiIchiranhyoItem item = new IkenshoSakuseiIraiIchiranhyoItem();

        item.setYubinNo1(getEditedYubinNo(row.getYubinNo()));
        item.setJushoText(row.getJusho());
        item.setKikanNameText(row.getShujiiIryoKikan());
        // TODO QA1096 帳票設計書と画面設計書不一致
        item.setShimeiText(new RString("TODO氏名"));
        item.setShimeiText(div.getSelectControlID());
        item.setMeishoFuyo(new RString("TODO名称付与"));
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
        item.setListIchiranhyo_7(row.getBirthYMD().getValue() == null ? RString.EMPTY
                : row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).width(Width.FULL).toDateString());
        item.setListIchiranhyo_8(row.getSeibetsu());
        item.setListIchiranhyo_9(get主治医意見書作成期限年月日(row));
        // TODO QA1094 通知文関連パラメータ不明
        item.setTsuchibun1(ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE230002.getReportId(), KamokuCode.EMPTY, 数字_0).get(1));
        return item;
    }

    private ShujiiIkenshoSakuseiRyoSeikyushoItem create主治医意見書作成料請求書(dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        RString tempP_新規在宅金額 = IkenshoSakuseiRyo.在宅新規.get名称();
        RString tempP_新規施設金額 = IkenshoSakuseiRyo.施設新規.get名称();
        RString tempP_継続在宅金額 = IkenshoSakuseiRyo.在宅継続.get名称();
        RString tempP_継続施設金額 = IkenshoSakuseiRyo.施設継続.get名称();
        ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
        item.setGengo(RDate.getNowDate().toDateString());
        item.setHihokenshaName(row.getHokensha());
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
        if (row.getBirthYMD().getValue() != null) {
            item.setBirthYMD(row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).width(Width.FULL).toDateString());
        }
        item.setSeibetsu(row.getSeibetsu());
        if (!row.getShisetsuNyushoFlag()) {
            item.setShubetsuZaitaku(意見書作成料_種別);
        } else {
            item.setShubetsuShisetsu(意見書作成料_種別);
        }
        if (RString.isNullOrEmpty(row.getIraiKubun())) {
            item.setShubetsuShinki(意見書作成料_種別);
        } else {
            item.setShubetsuKeizoku(意見書作成料_種別);
        }
        if (!row.getShisetsuNyushoFlag()) {
            if (ShujiiIkenshoIraiKubun.初回.getCode().equals(row.getIraiKubun())) {
                item.setIkenshoSakuseiRyo1(tempP_新規在宅金額.substring(数字_0, 数字_1));
                item.setIkenshoSakuseiRyo2(tempP_新規在宅金額.substring(数字_1, 数字_2));
                item.setIkenshoSakuseiRyo3(tempP_新規在宅金額.substring(数字_2, 数字_3));
                item.setIkenshoSakuseiRyo4(tempP_新規在宅金額.substring(数字_3));
            } else if (ShujiiIkenshoIraiKubun.再依頼.getCode().equals(row.getIraiKubun())) {
                item.setIkenshoSakuseiRyo1(tempP_継続在宅金額.substring(数字_0, 数字_1));
                item.setIkenshoSakuseiRyo2(tempP_継続在宅金額.substring(数字_1, 数字_2));
                item.setIkenshoSakuseiRyo3(tempP_継続在宅金額.substring(数字_2, 数字_3));
                item.setIkenshoSakuseiRyo4(tempP_継続在宅金額.substring(数字_3));
            }
        } else {
            if (ShujiiIkenshoIraiKubun.初回.getCode().equals(row.getIraiKubun())) {
                item.setIkenshoSakuseiRyo1(tempP_新規施設金額.substring(数字_0, 数字_1));
                item.setIkenshoSakuseiRyo2(tempP_新規施設金額.substring(数字_1, 数字_2));
                item.setIkenshoSakuseiRyo3(tempP_新規施設金額.substring(数字_2, 数字_3));
                item.setIkenshoSakuseiRyo4(tempP_新規施設金額.substring(数字_3));
            } else if (ShujiiIkenshoIraiKubun.再依頼.getCode().equals(row.getIraiKubun())) {
                item.setIkenshoSakuseiRyo1(tempP_継続施設金額.substring(数字_0, 数字_1));
                item.setIkenshoSakuseiRyo2(tempP_継続施設金額.substring(数字_1, 数字_2));
                item.setIkenshoSakuseiRyo3(tempP_継続施設金額.substring(数字_2, 数字_3));
                item.setIkenshoSakuseiRyo4(tempP_継続施設金額.substring(数字_3));
            }
        }
        return item;
    }

    // TODO QA1096 帳票設計書と画面設計書不一致
    private KaigohokenShindanMeireishoHeaderItem create介護保険診断命令書(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        RStringBuilder jyushin = new RStringBuilder();
        if (SELECTED_KEY0.equals(div.getMeireisho().getRadjyushin().getSelectedKey())) {
            jyushin.append(div.getMeireisho().getTxtjyushinymd().getValue().toDateString());
            jyushin.append(div.getMeireisho().getTxtjyushintime().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm));
        } else {
            jyushin.append(div.getMeireisho().getTxtJyushinKikan().getFromValue().toDateString());
            jyushin.append(new RString("～"));
            jyushin.append(div.getMeireisho().getTxtJyushinKikan().getToValue().toDateString());
        }
        KaigohokenShindanMeireishoHeaderItem item = new KaigohokenShindanMeireishoHeaderItem();
        item.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId(), FlexibleDate.getNowDate()));
        RString 通知文定型文 = new RString("1024641");
//        ReportUtil.get通知文(
//                SubGyomuCode.DBE認定支援, ReportIdDBE.DBE235001.getReportId(), KamokuCode.EMPTY, 数字_0).get(数字_0);
        通知文定型文 = 通知文定型文.padRight(RString.HALF_SPACE, 数字_17);
        item.setTsuchibun1(通知文定型文.substring(数字_0, 数字_1));
        item.setTsuchibun2(通知文定型文.substring(数字_1, 数字_2));
        item.setTsuchibun3(通知文定型文.substring(数字_2, 数字_3));
        item.setTsuchibun4(通知文定型文.substring(数字_3, 数字_4));
        item.setTsuchibun5(通知文定型文.substring(数字_4, 数字_5));
        item.setTsuchibun6(通知文定型文.substring(数字_5, 数字_6));
        item.setTsuchibun7(通知文定型文.substring(数字_6, 数字_7));
        item.setTsuchibun8(通知文定型文.substring(数字_7, 数字_8));
        item.setTsuchibun9(通知文定型文.substring(数字_8, 数字_9));
        item.setTsuchibun10(通知文定型文.substring(数字_9, 数字_10));
        item.setTsuchibun11(通知文定型文.substring(数字_10, 数字_11));
        item.setTsuchibun12(通知文定型文.substring(数字_11, 数字_12));
        item.setTsuchibun13(通知文定型文.substring(数字_12, 数字_13));
        item.setTsuchibun14(通知文定型文.substring(数字_13, 数字_14));
        item.setTsuchibun15(通知文定型文.substring(数字_14, 数字_15));
        item.setTsuchibun16(通知文定型文.substring(数字_15, 数字_16));
        item.setTsuchibun17(通知文定型文.substring(数字_16));
        item.setHihokenshaNo(row.getHihokenshaNo());
        item.setHihokenshaName(row.getHihokennshaShimei());
        item.setIryokikanName(row.getShujiiIryoKikan());
        item.setTantoIshiName(row.getShujii());
        item.setIryokikanJusho(row.getIryoukikanShozaichi());
        item.setTelNo(row.getIryoKikanTelNo());
        item.setJushinKikan(jyushin.toRString());
        item.setJushinArea(div.getMeireisho().getTxtjyushinbasho().getValue());
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
        if (row.getBirthYMD() != null) {
            item.setBirthYMD(row.getBirthYMD().getValue().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).width(Width.FULL).toDateString());
        }
        if (Seibetsu.女.getコード().equals(row.getSeibetsu())) {
            item.setSeibetsuMan(Seibetsu.男.get名称());
        } else if (Seibetsu.男.getコード().equals(row.getSeibetsu())) {
            item.setSeibetsuMan(Seibetsu.女.get名称());
        }
        item.setYubinNo(getEditedYubinNo(row.getYubinNo()));
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
//            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY0)) {
//                // TODO 主治医意見書記入用紙帳票未実装
//            }
//            if (div.getIraiprint().getChkprint().getSelectedKeys().contains(SELECTED_KEY1)) {
//                // TODO 主治医意見書記入用紙OCR帳票未実装
//            }
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
        ShujiiIkenshoSakuseiIraiReportOutputService outputService = new ShujiiIkenshoSakuseiIraiReportOutputService(reportManager);
        if (!主治医意見書作成依頼情報ItemList.isEmpty()) {
            outputService.print主治医意見書作成依頼情報(主治医意見書作成依頼情報ItemList);
        }
        // TODO QA1096 帳票設計書と画面設計書不一致
        if (!主治医意見書作成依頼一覧表ItemList.isEmpty()) {
            outputService.print主治医意見書作成依頼一覧表(主治医意見書作成依頼一覧表ItemList);
        }
        if (!主治医意見書作成料請求書ItemList.isEmpty()) {
            outputService.print主治医意見書作成料請求書(主治医意見書作成料請求書ItemList);
        }
        if (!介護保険診断命令書ItemList.isEmpty()) {
            outputService.print介護保険診断命令書(介護保険診断命令書ItemList);
        }
        if (!介護保険指定医依頼兼主治医意見書提出意見書ItemList.isEmpty()) {
            outputService.print介護保険指定医依頼兼主治医意見書提出意見書(介護保険指定医依頼兼主治医意見書提出意見書ItemList);
        }
    }

    private RString get主治医意見書作成期限年月日(dgShinseishaIchiran_Row row) {
        RString 設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        RString 期限日数 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, SubGyomuCode.DBE認定支援);
        RString result = RString.EMPTY;
        if (主治医意見書作成期限設定方法_1.equals(設定方法) && row.getShujiiIkenshoSakuseiIraiDay() != null) {
            result = row.getShujiiIkenshoSakuseiIraiDay().getValue().plusDay(Integer.parseInt(期限日数.toString())).toDateString();
        } else if (row.getShinseiDay() != null) {
            result = row.getShinseiDay().getValue().plusDay(Integer.parseInt(期限日数.toString())).toDateString();
        }
        return result;
    }

    private PersonalData toPersonalData(ShujiiIkenshoSakuseiIraiDiv div) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
