/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachiku.ChosaChikuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosachiku.ChosaChikuMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.NinteiChosaSchedule5MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.dgChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.dgNinteiChosainList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.chosachiku.ChosaChikuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosainBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosainIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 地区認定調査員情報のHandlerクラスです。
 *
 * @reamsid_L DBE-0021-010 zhangzhiming
 */
public class MainPanelHandler {

    private final NinteiChosaSchedule5MainDiv div;
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div div
     */
    public MainPanelHandler(NinteiChosaSchedule5MainDiv div) {
        this.div = div;
    }

    /**
     * 初期化の設定します。
     *
     * @param businessList 調査地区/市町村情報
     */
    public void onLoad(List<ChosaChikuBusiness> businessList) {
        div.getCcdKanryoMessage().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().setVisible(true);
        List<dgChosaChikuList_Row> rowList = new ArrayList<>();
        int index = 1;
        for (ChosaChikuBusiness list : businessList) {
            dgChosaChikuList_Row row = new dgChosaChikuList_Row();
            row.setNo(new RString(String.valueOf(index)));
            row.setChosaChikuCode(list.get調査地区コード());
            row.setChosaChikuName(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                    new Code(list.get調査地区コード()), FlexibleDate.getNowDate()));
            row.setChosaChikuAbbreviatedName(CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援,
                    DBECodeShubetsu.調査地区コード.getコード(), new Code(list.get調査地区コード()), FlexibleDate.getNowDate()));
            row.setShichosonCode(list.get市町村コード());
            row.setShichosnMeisho(list.get市町村名称());
            index++;
            rowList.add(row);
        }
        div.getChosaChikuPanel().getDgChosaChikuList().setDataSource(rowList);
    }

    /**
     * 調査地区一覧の行クリックします。
     *
     * @return chikuNinteiChosain
     */
    public Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> onClik_btnSelect() {
        dgChosaChikuList_Row dgRow = div.getChosaChikuPanel().getDgChosaChikuList().getSelectedItems().get(0);
        ChosaChikuMapperParameter paramer = new ChosaChikuMapperParameter();
        paramer.setChosaChikuCode(dgRow.getChosaChikuCode());
        paramer.setShichosonCode(dgRow.getShichosonCode());
        List<ChosaChikuBusiness> businessList = ChosaChikuManager.createInstance()
                .getChikuNinnteiList(paramer).records();
        List<ChikuNinteiChosain> 地区認定調査員情報 = ChosaChikuManager.createInstance().
                get地区認定調査員情報(new Code(dgRow.getChosaChikuCode()), new LasdecCode(dgRow.getShichosonCode())).records();
        Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuNinteiChosain
                = Models.create(地区認定調査員情報);
        List<dgNinteiChosainList_Row> rowList = new ArrayList<>();
        if (!businessList.isEmpty()) {
            div.getCcdKanryoMessage().setVisible(true);
            div.getChosaChikuPanel().setVisible(true);
            div.getNinteiChosainInput().setVisible(true);
            for (ChosaChikuBusiness list : businessList) {
                dgNinteiChosainList_Row row = new dgNinteiChosainList_Row();
                row.setJotai(RString.EMPTY);
                row.setYusenNo(new RString(String.valueOf(list.get優先番号())));
                row.setNinteiChosaItakusakiCode(list.get認定調査委託先コード());
                row.setNinteiChosaItakusakiName(list.get事業者名称());
                row.setNinteiChosainCode(list.get認定調査員コード());
                row.setNinteiChosainName(list.get調査員氏名());
                row.setBiko(list.get備考());
                rowList.add(row);
            }
            div.getNinteiChosainPanel().setShichosonCode(dgRow.getShichosonCode());
            div.getNinteiChosainPanel().setChosaChikuCode(dgRow.getChosaChikuCode());
        }
        div.getNinteiChosainPanel().getDgNinteiChosainList().setDataSource(rowList);
        return chikuNinteiChosain;
    }

    /**
     * 認定調査員を追加します。
     *
     */
    public void onClick_btnAdd() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setDisabled(true);
        div.getNinteiChosainInput().getBtnKakutei().setDisabled(false);
        div.getNinteiChosainInput().setTxtJotai(追加);
        div.getNinteiChosainInput().setTxtShichosonCode(div.getNinteiChosainPanel().getShichosonCode());
        div.getNinteiChosainInput().setTxtChosaChikuCode(div.getNinteiChosainPanel().getChosaChikuCode());
    }

    /**
     * 修正ボタンが押下します。
     *
     */
    public void onClick_btnModify() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setDisabled(true);
        div.getNinteiChosainInput().getBtnToSearchChosaItakusaki().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setDisabled(true);
        div.getNinteiChosainInput().getBtnToSearchChosaIn().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setDisabled(true);
        div.getNinteiChosainInput().getBtnKakutei().setDisabled(false);
        dgNinteiChosainList_Row dgRow = div.getNinteiChosainPanel().getDgNinteiChosainList().getSelectedItems().get(0);
        div.getNinteiChosainInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setValue(dgRow.getNinteiChosaItakusakiCode());
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setValue(dgRow.getNinteiChosaItakusakiName());
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setValue(dgRow.getNinteiChosainCode());
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setValue(dgRow.getNinteiChosainName());
        div.getNinteiChosainInput().getTxtBiko().setValue(dgRow.getBiko());
        div.getNinteiChosainInput().setHidBiko(dgRow.getBiko());
        div.getNinteiChosainInput().setHidYusenNo(dgRow.getYusenNo());
        div.getNinteiChosainInput().setTxtJotai(修正);
        div.getNinteiChosainInput().setTxtShichosonCode(div.getNinteiChosainPanel().getShichosonCode());
        div.getNinteiChosainInput().setTxtChosaChikuCode(div.getNinteiChosainPanel().getChosaChikuCode());
    }

    /**
     * 削除ボタンが押下します。
     *
     */
    public void onClick_btnDelete() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().getTxtYusenNo().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setDisabled(true);
        div.getNinteiChosainInput().getBtnToSearchChosaItakusaki().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setDisabled(true);
        div.getNinteiChosainInput().getBtnToSearchChosaIn().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtBiko().setDisabled(true);
        div.getNinteiChosainInput().getBtnKakutei().setDisabled(false);
        dgNinteiChosainList_Row dgRow = div.getNinteiChosainPanel().getDgNinteiChosainList().getSelectedItems().get(0);
        div.getNinteiChosainInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setValue(dgRow.getNinteiChosaItakusakiCode());
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setValue(dgRow.getNinteiChosaItakusakiName());
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setValue(dgRow.getNinteiChosainCode());
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setValue(dgRow.getNinteiChosainName());
        div.getNinteiChosainInput().getTxtBiko().setValue(dgRow.getBiko());
        div.getNinteiChosainInput().setTxtJotai(削除);
    }

    /**
     * ダブルクリック押下します。
     *
     */
    public void onClick_btnDouble() {
        dgNinteiChosainList_Row dgRow = div.getNinteiChosainPanel().getDgNinteiChosainList().getSelectedItems().get(0);
        if (追加.equals(dgRow.getJotai())) {
            追加状態();
        }
        if (修正.equals(dgRow.getJotai())) {
            onClick_btnModify();
        }
        if (削除.equals(dgRow.getJotai())) {
            onClick_btnDelete();
        }
        if (RString.EMPTY.equals(dgRow.getJotai())) {
            明細照会状態();
        }
    }

    /**
     * 認定調査委託先コードフォーカスをなくなるです。
     *
     */
    public void onBlur_ChosaItakusaki() {
        RString jigyoshaMeisho = ChosaChikuManager.createInstance().getChosaItakusaki(new LasdecCode(div.getNinteiChosainInput()
                .getTxtShichosonCode()), div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue());
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setValue(jigyoshaMeisho);
    }

    /**
     * 認定調査員コードフォーカスをなくなるです。
     *
     */
    public void onBlur_Chosain() {
        RString chosainShimei = ChosaChikuManager.createInstance().getChosain(new LasdecCode(div.getNinteiChosainInput()
                .getTxtShichosonCode()), new ChosaItakusakiCode(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue()),
                new ChosainCode(div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue()));
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setValue(chosainShimei);
    }

    /**
     * 取消するボタンが押下します。
     *
     */
    public void onClick_btnTorikeshi() {
        clearValue();
    }

    /**
     * 確定するボタンが押下します。
     *
     */
    public void onClick_btnKakutei() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainInput().setVisible(true);
        List<dgNinteiChosainList_Row> rowList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();
        int rowcount = 0;
        if (!追加.equals(div.getNinteiChosainInput().getTxtJotai())) {
            rowcount = div.getNinteiChosainPanel().getDgNinteiChosainList().getClickedItem().getId();
        }
        dgNinteiChosainList_Row row;
        if (追加.equals(div.getNinteiChosainInput().getTxtJotai())) {
            row = new dgNinteiChosainList_Row();
            row.setJotai(追加);
            row.setYusenNo(new RString(div.getNinteiChosainInput().getTxtYusenNo().getValue().toString()));
            row.setNinteiChosaItakusakiCode(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue());
            row.setNinteiChosaItakusakiName(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().getValue());
            row.setNinteiChosainCode(div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue());
            row.setNinteiChosainName(div.getNinteiChosainInput().getTxtNinteiChosainMeisho().getValue());
            row.setBiko(div.getNinteiChosainInput().getTxtBiko().getValue());
            rowList.add(row);
            clearValue();
        }
        if (修正.equals(div.getNinteiChosainInput().getTxtJotai())) {
            row = rowList.get(rowcount);
            row.setYusenNo(new RString(div.getNinteiChosainInput().getTxtYusenNo().getValue().toString()));
            row.setNinteiChosaItakusakiCode(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue());
            row.setNinteiChosaItakusakiName(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().getValue());
            row.setNinteiChosainCode(div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue());
            row.setNinteiChosainName(div.getNinteiChosainInput().getTxtNinteiChosainMeisho().getValue());
            row.setBiko(div.getNinteiChosainInput().getTxtBiko().getValue());
            if (追加.equals(row.getJotai())) {
                row.setJotai(追加);
            } else {
                row.setJotai(修正);
            }
            rowList.set(rowcount, row);
            clearValue();
        }
        if (削除.equals(div.getNinteiChosainInput().getTxtJotai())) {
            row = rowList.get(rowcount);
            if (追加.equals(row.getJotai())) {
                rowList.remove(rowcount);
            } else {
                row.setJotai(削除);
                rowList.set(rowcount, row);
            }
            clearValue();
        }

    }

    /**
     * データチェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs detaCheck() {
        return createValidationHandler(div).detaCheck();
    }

    /**
     * 認定調査員一覧データの編集状態チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定調査員一覧Check() {
        return createValidationHandler(div).認定調査員一覧Check();
    }

    /**
     * 調査地区一覧へ戻るボタンが押下します。
     *
     */
    public void btnChosaChikuIchiran() {
        clearValue();
    }

    /**
     * 認定調査員一覧へ戻るボタンが押下します。
     *
     */
    public void btnBackNinteiChosaInIchiran() {
        clearValue();
    }

    private MainPanelValidationHandler createValidationHandler(NinteiChosaSchedule5MainDiv div) {
        return new MainPanelValidationHandler(div);
    }

    /**
     * 認定調査委託先検索ボタンが押下します。
     *
     */
    public void onOpen_ChosaItakusaki() {
        KijuntsukiShichosonjohoiDataPassModel model = new KijuntsukiShichosonjohoiDataPassModel();
        model.set市町村コード(div.getNinteiChosainPanel().getShichosonCode());
        model.set委託先コード(div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue());
        model.set委託先名(RString.EMPTY);
        model.set調査員コード(RString.EMPTY);
        model.set調査員名(RString.EMPTY);
        div.setHdnDataPass(DataPassingConverter.serialize(model));
    }

    /**
     * 認定調査委託先検索が戻します。
     *
     */
    public void onOkClose_ChosaItakusaki() {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (dataPassModel != null) {
            div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setValue(dataPassModel.get委託先コード());
            div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setValue(dataPassModel.get委託先名());
        }
    }

    /**
     * 認定調査員検索ボタンが押下します。
     *
     */
    public void onOpen_Chosain() {
        KijuntsukiShichosonjohoiDataPassModel model = new KijuntsukiShichosonjohoiDataPassModel();
        model.set市町村コード(div.getNinteiChosainPanel().getShichosonCode());
        model.set委託先コード(RString.EMPTY);
        model.set委託先名(RString.EMPTY);
        model.set調査員コード(div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue());
        model.set調査員名(RString.EMPTY);
        div.setHdnDataPass(DataPassingConverter.serialize(model));
    }

    /**
     * 認定調査員検索が戻します。
     *
     */
    public void onOkClose_Chosain() {
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (dataPassModel != null) {
            div.getNinteiChosainInput().getTxtNinteiChosainCode().setValue(dataPassModel.get調査員コード());
            div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setValue(dataPassModel.get調査員名());
        }
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        return createValidationHandler(div).validateCheck();
    }

    /**
     * 保存するボタンが押下の場合、削除実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs btnUpdate_Del() {
        return createValidationHandler(div).btnUpdate_Del();
    }

    /**
     * 保存するボタンが押下します。
     *
     * @param models models
     */
    public void btnUpdate(Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> models) {
        前排他制御処理();
        List<dgNinteiChosainList_Row> rowList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();
        for (dgNinteiChosainList_Row list : rowList) {
            if (追加.equals(list.getJotai())) {
                ChikuNinteiChosain chikuNinteiChosain = new ChikuNinteiChosain(new Code(div.getNinteiChosainPanel().getChosaChikuCode()),
                        list.getNinteiChosaItakusakiCode(), list.getNinteiChosainCode(),
                        new LasdecCode(div.getNinteiChosainPanel().getShichosonCode()));
                ChikuNinteiChosainBuilder builder = chikuNinteiChosain.createBuilderForEdit();
                builder.set備考(list.getBiko());
                builder.set優先番号(Integer.parseInt(list.getYusenNo().toString()));
                chikuNinteiChosain.toEntity().setState(EntityDataState.Added);
                ChosaChikuManager.createInstance().insertOrUpdate(builder.build());
            }
            if (修正.equals(list.getJotai())) {
                ChikuNinteiChosainIdentifier key = new ChikuNinteiChosainIdentifier(new Code(div.getNinteiChosainPanel().getChosaChikuCode()),
                        list.getNinteiChosaItakusakiCode(), list.getNinteiChosainCode(),
                        new LasdecCode(div.getNinteiChosainPanel().getShichosonCode()));
                ChikuNinteiChosain chikuNinteiChosain = models.get(key);
                ChikuNinteiChosainBuilder builder = chikuNinteiChosain.createBuilderForEdit();
                builder.set備考(list.getBiko());
                builder.set優先番号(Integer.parseInt(list.getYusenNo().toString()));
                chikuNinteiChosain.toEntity().setState(EntityDataState.Modified);
                ChosaChikuManager.createInstance().insertOrUpdate(builder.build());
            }
            if (削除.equals(list.getJotai())) {
                ChikuNinteiChosainIdentifier key = new ChikuNinteiChosainIdentifier(new Code(div.getNinteiChosainPanel().getChosaChikuCode()),
                        list.getNinteiChosaItakusakiCode(), list.getNinteiChosainCode(),
                        new LasdecCode(div.getNinteiChosainPanel().getShichosonCode()));
                ChosaChikuManager.createInstance().delete(models, key);
            }
        }
        前排他解除処理();
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().setVisible(true);
    }

    private void 前排他制御処理() {
        LockingKey lockingKey = new LockingKey(new RString("ChikuNinteiChosainCode"));
        RealInitialLocker.lock(lockingKey);
    }

    private void 前排他解除処理() {
        LockingKey lockingKey = new LockingKey(new RString("ChikuNinteiChosainCode"));
        RealInitialLocker.release(lockingKey);
    }

    private void 追加状態() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setDisabled(true);
        div.getNinteiChosainInput().getBtnKakutei().setDisabled(false);
        dgNinteiChosainList_Row dgRow = div.getNinteiChosainPanel().getDgNinteiChosainList().getSelectedItems().get(0);
        div.getNinteiChosainInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setValue(dgRow.getNinteiChosaItakusakiCode());
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setValue(dgRow.getNinteiChosaItakusakiName());
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setValue(dgRow.getNinteiChosainCode());
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setValue(dgRow.getNinteiChosainName());
        div.getNinteiChosainInput().getTxtBiko().setValue(dgRow.getBiko());
        div.getNinteiChosainInput().setHidBiko(dgRow.getBiko());
        div.getNinteiChosainInput().setHidYusenNo(dgRow.getYusenNo());
        div.getNinteiChosainInput().setTxtJotai(追加);
        div.getNinteiChosainInput().setTxtShichosonCode(div.getNinteiChosainPanel().getShichosonCode());
        div.getNinteiChosainInput().setTxtChosaChikuCode(div.getNinteiChosainPanel().getChosaChikuCode());
    }

    private void 明細照会状態() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getNinteiChosainPanel().setVisible(true);
        div.getNinteiChosainInput().getTxtYusenNo().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setDisabled(true);
        div.getNinteiChosainInput().getBtnToSearchChosaItakusaki().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setDisabled(true);
        div.getNinteiChosainInput().getBtnToSearchChosaIn().setDisabled(true);
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setDisabled(true);
        div.getNinteiChosainInput().getTxtBiko().setDisabled(true);
        div.getNinteiChosainInput().getBtnKakutei().setDisabled(true);
        dgNinteiChosainList_Row dgRow = div.getNinteiChosainPanel().getDgNinteiChosainList().getSelectedItems().get(0);
        div.getNinteiChosainInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setValue(dgRow.getNinteiChosaItakusakiCode());
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setValue(dgRow.getNinteiChosaItakusakiName());
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setValue(dgRow.getNinteiChosainCode());
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setValue(dgRow.getNinteiChosainName());
        div.getNinteiChosainInput().getTxtBiko().setValue(dgRow.getBiko());
        div.getNinteiChosainInput().setTxtJotai(RString.EMPTY);
    }

    private void clearValue() {
        div.getNinteiChosainInput().getTxtYusenNo().clearValue();
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().clearValue();
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().clearValue();
        div.getNinteiChosainInput().getTxtNinteiChosainCode().clearValue();
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().clearValue();
        div.getNinteiChosainInput().getTxtBiko().clearValue();
        div.getNinteiChosainInput().setTxtJotai(RString.EMPTY);
        div.getNinteiChosainInput().setTxtShichosonCode(RString.EMPTY);
        div.getNinteiChosainInput().setTxtChosaChikuCode(RString.EMPTY);
        div.getNinteiChosainInput().setHidBiko(RString.EMPTY);
        div.getNinteiChosainInput().setHidYusenNo(RString.EMPTY);
        div.getNinteiChosainInput().setDisabled(false);
        div.getNinteiChosainInput().getTxtYusenNo().setDisabled(false);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().setDisabled(false);
        div.getNinteiChosainInput().getBtnToSearchChosaItakusaki().setDisabled(false);
        div.getNinteiChosainInput().getTxtNinteiChosaItakusakiMeisho().setDisabled(false);
        div.getNinteiChosainInput().getTxtNinteiChosainCode().setDisabled(false);
        div.getNinteiChosainInput().getBtnToSearchChosaIn().setDisabled(false);
        div.getNinteiChosainInput().getTxtNinteiChosainMeisho().setDisabled(false);
        div.getNinteiChosainInput().getTxtBiko().setDisabled(false);
    }
}
