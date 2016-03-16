/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReport;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoteishutsuiraisho.ShujiiIkenshoTeishutsuIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha._NinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
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
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
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
    private static final RString 継続 = new RString("継続");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 施設 = new RString("施設");
    private static final RString 再依頼申請者削除 = new RString("再依頼申請者を削除します。");
    private List<ShujiiIkenshoSakuseiIraishoItem> 主治医意見書作成依頼情報ItemList;
//    private List<IkenshoSakuseiIraiIchiranhyoItem> 主治医意見書作成依頼一覧表ItemList;
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
        div.getCcdShujiiIryoKikanAndShujiiInput().initialize(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード(),
                ShinseishoKanriNo.EMPTY, SubGyomuCode.DBE認定支援);
        div.getDgShinseishaIchiran().setDataSource(Collections.<dgShinseishaIchiran_Row>emptyList());
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書作成依頼の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnSearch(ShujiiIkenshoSakuseiIraiDiv div) {

        RString 被保険者番号 = div.getCcdHihokenshaFinder().get被保険者番号();
        // QA894　最大表示件数の確認
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        createHandler(div).init(manager.get申請者情報(被保険者番号).records());
        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報
                = Models.create(manager.get主治医意見書作成依頼情報(被保険者番号).records());
        Models<NinteiShinseiJohoIdentifier, NinteiShinseiJoho> 要介護認定申請情報
                = Models.create(manager.get要介護認定申請情報(被保険者番号).records());
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
            row.getShujiiIkenshoSakuseiIraiDay().clearValue();
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
                int rirekiNo = 1;
                if (!RString.isNullOrEmpty(row.getPreRirekiNo())) {
                    rirekiNo = Integer.parseInt(row.getPreRirekiNo().toString()) + 1;
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

//    private boolean 前排他キーのセット() {
//        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
//        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
//                .concat(temp_申請書管理番号.getColumnValue()));
//        return RealInitialLocker.tryGetLock(排他キー);
//    }
//
//    private void 前排他キーの解除() {
//        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
//        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
//                .concat(temp_申請書管理番号.getColumnValue()));
//        RealInitialLocker.release(排他キー);
//    }
    private void printData(ShujiiIkenshoSakuseiIraiDiv div, ReportManager reportManager) {

        Models<ShujiiIkenshoIraiJohoIdentifier, ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報
                = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼_主治医意見書作成依頼情報, Models.class);
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        主治医意見書作成依頼情報ItemList = new ArrayList<>();
//        主治医意見書作成依頼一覧表ItemList = new ArrayList<>();
        主治医意見書作成料請求書ItemList = new ArrayList<>();
        介護保険診断命令書ItemList = new ArrayList<>();
        介護保険指定医依頼兼主治医意見書提出意見書ItemList = new ArrayList<>();

        RString 主治医意見書作成期限設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        RString 主治医意見書作成期限日数 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, SubGyomuCode.DBE認定支援);
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (row.getSelected() && 主治医意見書作成期限設定方法_1.equals(主治医意見書作成期限設定方法) && !div.getChkirai().getSelectedKeys().isEmpty()) {
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
        iraishoItem.setTitle(ReportIdDBE.DBE230001.getReportName());
        iraishoItem.setBunshoNo(ReportUtil.get文書番号(SubGyomuCode.DBE認定支援,
                ReportIdDBE.DBE230001.getReportId(), FlexibleDate.getNowDate()));
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
        iraishoItem.setBirthYMD(new RString(row.getBirthYMD().toString()));
        iraishoItem.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        RString hokenshaNo = row.getHokenshaNo().padRight(RString.EMPTY, 数字_5);
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
        iraishoItem.setShoriName(RString.isNullOrEmpty(row.getIraiKubun()) ? RString.EMPTY
                : new RString(ShujiiIkenshoIraiKubun.toValue(row.getIraiKubun()).name()));
        return iraishoItem;
    }

//    private IkenshoSakuseiIraiIchiranhyoItem create主治医意見書作成依頼一覧表(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
//        return new IkenshoSakuseiIraiIchiranhyoItem(
//                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
//                new RString(RDateTime.now().toString()), RString.EMPTY, row.getShujiiIryoKikan(), row.getYubinNo(),
//                new RString("医療機関住所"), new RString("介護保険　主治医意見書提出依頼書一覧表"), RString.EMPTY, row.getShujii(),
//                row.getHihokenshaNo(), row.getHihokennshaShimei(), RString.EMPTY, row.getJusho(),
//                row.getBirthYMD().getValue() == null ? RString.EMPTY : new RString(row.getBirthYMD().getValue().toString()),
//                row.getSeibetsu(), div.getIraiprint().getTxtkigenymd().getValue() == null ? RString.EMPTY
//                : div.getIraiprint().getTxtkigenymd().getValue().toDateString(),
//                new RString("問合せ先"), row.getShujiiIryoKikanCode());
//    }
    private ShujiiIkenshoSakuseiRyoSeikyushoItem create主治医意見書作成料請求書(dgShinseishaIchiran_Row row) {
        RString hihokenshaNo = row.getHihokenshaNo().padRight(RString.HALF_SPACE, 数字_10);
        RString tempP_新規在宅金額 = IkenshoSakuseiRyo._5000.get名称();
        // TODO QA894 Enumファイルにはコード同じな項目存在する
        RString tempP_新規施設金額 = IkenshoSakuseiRyo._4000.get名称();
        RString tempP_継続在宅金額 = IkenshoSakuseiRyo._4000.get名称();
        RString tempP_継続施設金額 = IkenshoSakuseiRyo._3000.get名称();
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
            item.setIkenshosyubetu1(在宅);
        } else {
            item.setIkenshosyubetu1(施設);
        }
        if (RString.isNullOrEmpty(row.getIraiKubun())) {
            item.setIkenshosyubetu2(新規);
        } else {
            item.setIkenshosyubetu2(継続);
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
        // TODO QA894 帳票設計書と画面設計書不一致
        return new KaigohokenShindanMeireishoHeaderItem(
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, ReportUtil.get文書番号(SubGyomuCode.DBE認定支援,
                        ReportIdDBE.DBE235001.getReportId(), FlexibleDate.getNowDate()), new RString(RDateTime.now().toString()),
                new RString("通知文１"), new RString("通知文２"), row.getHihokenshaNo(), row.getHihokennshaShimei(), row.getShujiiIryoKikan(),
                row.getShujii(), row.getIryoukikanShozaichi(),
                row.getIryoKikanTelNo(), jyushin.toRString(), row.getShujiiIryoKikan(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
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
            item.setBirthYMD(new RString(row.getBirthYMD().getValue().toString()));
        }
        if (Seibetsu.女.getコード().equals(row.getSeibetsu())) {
            item.setSeibetsuMan(Seibetsu.男.get名称());
        } else if (Seibetsu.男.getコード().equals(row.getSeibetsu())) {
            item.setSeibetsuMan(Seibetsu.女.get名称());
        }
        item.setYubinNo(getEditedYubinNo(row.getYubinNo()));
        return item;
    }

    // TODO QA894 帳票設計書と画面設計書不一致
    private void createChoHyoData(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row) {
        if (row.getSelected()) {
            if (div.getIraiprint().getChkirai().getSelectedKeys().contains(SELECTED_KEY0)) {
                主治医意見書作成依頼情報ItemList.add(create主治医意見書作成依頼書(div, row));
            }
//            if (div.getIraiprint().getChkirai().getSelectedKeys().contains(SELECTED_KEY1)) {
//                // 主治医意見書作成依頼一覧帳票仕様変更のため、ソース修正要
//                主治医意見書作成依頼一覧表ItemList.add(create主治医意見書作成依頼一覧表(div, row));
//            }
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

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {

        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaks : property.breakers()) {
            builder.addBreak(breaks);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private void toPrint(ReportManager reportManager) {
        if (!主治医意見書作成依頼情報ItemList.isEmpty()) {
            List<ShujiiIkenshoSakuseiIraishoReport> list = new ArrayList<>();
            list.add(ShujiiIkenshoSakuseiIraishoReport.createFrom(主治医意見書作成依頼情報ItemList));
            ShujiiIkenshoSakuseiIraishoProperty property = new ShujiiIkenshoSakuseiIraishoProperty();
            try (ReportAssembler<ShujiiIkenshoSakuseiIraishoReportSource> assembler = createAssembler(property, reportManager)) {
                for (ShujiiIkenshoSakuseiIraishoReport report : list) {
                    ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
        // 主治医意見書作成依頼一覧帳票仕様変更のため、ソース修正要
//        if (!主治医意見書作成依頼一覧表ItemList.isEmpty()) {
//            List<IkenshoSakuseiIraiIchiranhyoReport> list = new ArrayList<>();
//            list.add(IkenshoSakuseiIraiIchiranhyoReport.createFrom(主治医意見書作成依頼一覧表ItemList));
//            IkenshoSakuseiIraiIchiranhyoProperty property = new IkenshoSakuseiIraiIchiranhyoProperty();
//            try (ReportAssembler<IkenshoSakuseiIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
//                for (IkenshoSakuseiIraiIchiranhyoReport report : list) {
//                    ReportSourceWriter<IkenshoSakuseiIraiIchiranhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
//                    report.writeBy(reportSourceWriter);
//                }
//            }
//        }
        if (!主治医意見書作成料請求書ItemList.isEmpty()) {
            List<ShujiiIkenshoSakuseiRyoSeikyushoReport> list = new ArrayList<>();
            list.add(ShujiiIkenshoSakuseiRyoSeikyushoReport.createFrom(主治医意見書作成料請求書ItemList));
            ShujiiIkenshoSakuseiRyoSeikyushoProperty property = new ShujiiIkenshoSakuseiRyoSeikyushoProperty();
            try (ReportAssembler<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> assembler = createAssembler(property, reportManager)) {
                for (ShujiiIkenshoSakuseiRyoSeikyushoReport report : list) {
                    ReportSourceWriter<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
        if (!介護保険診断命令書ItemList.isEmpty()) {
            List<KaigohokenShindanMeireishoReport> list = new ArrayList<>();
            for (KaigohokenShindanMeireishoHeaderItem item : 介護保険診断命令書ItemList) {
                list.add(KaigohokenShindanMeireishoReport.createFrom(item));
            }
            KaigohokenShindanMeireishoProperty property = new KaigohokenShindanMeireishoProperty();
            try (ReportAssembler<KaigohokenShindanMeireishoReportSource> assembler = createAssembler(property, reportManager)) {
                for (KaigohokenShindanMeireishoReport report : list) {
                    ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
        if (!介護保険指定医依頼兼主治医意見書提出意見書ItemList.isEmpty()) {
            List<ShujiiIkenshoTeishutsuIraishoReport> list = new ArrayList<>();
            ShujiiIkenshoTeishutsuIraishoProperty property = new ShujiiIkenshoTeishutsuIraishoProperty();
            try (ReportAssembler<ShujiiIkenshoTeishutsuIraishoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilder ninshoshaSourceBuilder = new _NinshoshaSourceBuilderCreator().create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                list.add(ShujiiIkenshoTeishutsuIraishoReport.createFrom(setNishosha(介護保険指定医依頼兼主治医意見書提出意見書ItemList,
                        ninshoshaSourceBuilder.buildSource())));
                for (ShujiiIkenshoTeishutsuIraishoReport report : list) {
                    ReportSourceWriter<ShujiiIkenshoTeishutsuIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    private List<ShujiiIkenshoTeishutsuIraishoItem> setNishosha(List<ShujiiIkenshoTeishutsuIraishoItem> itemList, NinshoshaSource ninshosha) {
        List<ShujiiIkenshoTeishutsuIraishoItem> resultList = new ArrayList<>();
        for (ShujiiIkenshoTeishutsuIraishoItem item : itemList) {
            item.setHakkoYMD1(ninshosha.hakkoYMD);
            item.setDenshiKoin(ninshosha.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshosha.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshosha.ninshoshaYakushokuMei1);
            item.setNinshoshaYakushokuMei2(ninshosha.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshosha.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshosha.ninshoshaShimeiKakeru);
            item.setKoinMojiretsu(ninshosha.koinMojiretsu);
            item.setKoinShoryaku(ninshosha.koinShoryaku);
            resultList.add(item);
        }
        return resultList;
    }
}
