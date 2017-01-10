/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.definition.core.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.DBE2300001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2300001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2300001.ShujiiIkenshoSakuseiIraiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshosakuseiirai.ShujiiIkenshoSakuseiIraiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医意見書作成依頼のクラスです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIkenshoSakuseiIrai {

    private static final RString 削除 = new RString("削除");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final int 数字_1 = 1;
    private static final LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));

    /**
     * 主治医意見書作成依頼の初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onLoad(ShujiiIkenshoSakuseiIraiDiv div) {
        createHandler(div).load();
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
        return ResponseData.of(div).setState(DBE2300001StateName.主治医意見書作成);
    }

    /**
     * 主治医意見書作成依頼の検索画面へ戻ります。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onClick_btnReSearch(ShujiiIkenshoSakuseiIraiDiv div) {
        return ResponseData.of(div).setState(DBE2300001StateName.検索);
    }
    
    /**
     * 「依頼書等を印刷する」ボタンを押下した時の処理です。
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onBeforeOpen_printDialog(ShujiiIkenshoSakuseiIraiDiv div) {
        ShujiiIkenshoSakuseiIraiValidationHandler validationHandler = createValidationHandler(div);
        ValidationMessageControlPairs validationMessages = validationHandler.発行チェック();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        List<ShinseishoKanriNo> list = new ArrayList<>();
        List<dgShinseishaIchiran_Row> rowList = div.getDgShinseishaIchiran().getSelectedItems();
        for (dgShinseishaIchiran_Row row : rowList) {
            if (!RString.isNullOrEmpty(row.getShiseishoKanriNo())) {
                list.add(new ShinseishoKanriNo(row.getShiseishoKanriNo()));
            }
        }
        model.set申請書管理番号リスト(list);
        model.set市町村コード(div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv()
                .getDdlHokenshaNumber().getSelectedItem().get市町村コード());
        model.set遷移元画面区分(GamenSeniKbn.主治医意見書依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        RealInitialLocker.release(排他キー);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 依頼書/認定調査票（OCR用紙）/主治医意見書印刷画面閉じる前の処理です。
     * @param div
     * @return 
     */
    public ResponseData<ShujiiIkenshoSakuseiIraiDiv> onOkClose_printDialog(ShujiiIkenshoSakuseiIraiDiv div) {
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
            List<dgShinseishaIchiran_Row> oldList = div.getDgShinseishaIchiran().getSelectedItems();
            onClick_btnSearch(div);
            for (dgShinseishaIchiran_Row oldRow: oldList) {
                setDgShinseishaIchiran(oldRow, div.getDgShinseishaIchiran());
            }
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }
    
    private void setDgShinseishaIchiran(dgShinseishaIchiran_Row oldRow, DataGrid<dgShinseishaIchiran_Row> grid) {
        for (dgShinseishaIchiran_Row newRow : grid.getDataSource()) {
            if (oldRow.getShiseishoKanriNo().equals(newRow.getShiseishoKanriNo())) {
                newRow.setSelected(true);
            }
        }
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

    private ShujiiIkenshoSakuseiIraiHandler createHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        return new ShujiiIkenshoSakuseiIraiHandler(div);
    }

    private ShujiiIkenshoSakuseiIraiValidationHandler createValidationHandler(ShujiiIkenshoSakuseiIraiDiv div) {
        return new ShujiiIkenshoSakuseiIraiValidationHandler(div);
    }

    private void toHozon(ShujiiIkenshoSakuseiIraiDiv div) {
        ShujiiIkenshoSakuseiIraiManager manager = ShujiiIkenshoSakuseiIraiManager.createInstance();
        for (dgShinseishaIchiran_Row row : div.getDgShinseishaIchiran().getDataSource()) {
            if (新規.equals(row.getStatus())) {
                int rirekiNo = 数字_1;
                if (!RString.isNullOrEmpty(row.getPreRirekiNo())) {
                    rirekiNo = Integer.parseInt(row.getPreRirekiNo().toString()) + 数字_1;
                }
                manager.save主治医意見書作成依頼情報(create主治医意見書作成依頼情報(div, row, rirekiNo), EntityDataState.Added);
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
                        create主治医意見書作成依頼情報(div, row, Integer.parseInt(row.getRirekiNo().toString()) + 1), EntityDataState.Added);

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

    private ShujiiIkenshoIraiJoho create主治医意見書作成依頼情報(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row, int rirekiNo) {
        ShujiiIkenshoIraiJohoBuilder builder = create主治医意見書作成依頼情報Builder(div, row, rirekiNo);
        if (RString.isNullOrEmpty(row.getIraiKubun())) {
            builder.set主治医意見書依頼区分(ShujiiIkenshoIraiKubun.初回.getCode());
        } else if (!row.getSakujoKbn()) {
            builder.set主治医意見書依頼区分(ShujiiIkenshoIraiKubun.再依頼.getCode());
        }
        return builder.build();
    }

    private ShujiiIkenshoIraiJohoBuilder create主治医意見書作成依頼情報Builder(ShujiiIkenshoSakuseiIraiDiv div, dgShinseishaIchiran_Row row,
            int rirekiNo) {
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
        builder.set主治医意見書作成期限年月日(FlexibleDate.EMPTY);
        builder.set論理削除フラグ(false);
        return builder;
    }

    private PersonalData toPersonalData(ShujiiIkenshoSakuseiIraiDiv div) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
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
