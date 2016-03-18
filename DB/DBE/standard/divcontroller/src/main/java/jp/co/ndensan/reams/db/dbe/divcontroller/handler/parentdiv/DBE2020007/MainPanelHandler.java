/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020007;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.ChosaChikuChichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.UzT0007CodeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikuchichoson.ChosaChikuChichosonParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.NinteiChosaSchedule7MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.dgChosaChikuChichosonList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.dgChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.chosachikuchichoson.ChosaChikuFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichosonBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichosonIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査スケジュール登録7のHandlerクラスです。
 */
public class MainPanelHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString SELECT_KEY_1 = new RString("key0");
    private static final RString SELECT_KEY_2 = new RString("key1");
    private final NinteiChosaSchedule7MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div div
     */
    public MainPanelHandler(NinteiChosaSchedule7MainDiv div) {
        this.div = div;
    }

    /**
     * 初期化の設定します。
     *
     * @param businessList 調査地区情報
     */
    public void onLoad(List<UzT0007CodeBusiness> businessList) {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().setVisible(true);
        List<dgChosaChikuList_Row> rowList = new ArrayList<>();
        int index = 1;
        for (UzT0007CodeBusiness business : businessList) {
            dgChosaChikuList_Row row = new dgChosaChikuList_Row();
            row.setNo(new RString(String.valueOf(index)));
            row.setChosaChikuCode(business.getコード().value());
            row.setChosaChikuName(business.getコード名称());
            row.setChosaChikuAbbreviatedName(business.getコード略称());
            index++;
            rowList.add(row);
        }
        div.getChosaChikuPanel().getDgChosaChikuList().setDataSource(rowList);
    }

    /**
     * 調査地区一覧の行クリックします。
     *
     * @param businessList 調査地区市町村情報
     * @param dgRow 調査地区市町村行データ
     */
    public void onClik_SelectBtn(List<ChosaChikuChichosonBusiness> businessList, dgChosaChikuList_Row dgRow) {
        List<dgChosaChikuChichosonList_Row> rowList = new ArrayList<>();
        if (!businessList.isEmpty()) {
            div.getCcdKanryoMessage().setVisible(true);
            div.getChosaChikuPanel().setVisible(true);
            div.getChosaChikuShichosoInput().setVisible(true);
            for (ChosaChikuChichosonBusiness business : businessList) {
                dgChosaChikuChichosonList_Row row = new dgChosaChikuChichosonList_Row();
                row.setJotai(RString.EMPTY);
                row.setYusenNo(nullToEmpty(new RString(String.valueOf(business.get優先番号()))));
                row.setCityCode(nullToEmpty(business.get市町村コード()));
                row.setCityName(nullToEmpty(business.get市町村名()));
                row.setJichiku(business.is自地区フラグ());
                rowList.add(row);
            }
            div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().setValue(dgRow.getChosaChikuCode());
            div.getChosaChikuShichosonPanel().getTxtChosaChikuName().setValue(dgRow.getChosaChikuName());
            div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().setReadOnly(true);
            div.getChosaChikuShichosonPanel().getTxtChosaChikuName().setReadOnly(true);
        }
        div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().setDataSource(rowList);
    }

    /**
     * 調査地区市町村を追加します。
     */
    public void onClick_AddBtn() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setDisabled(true);
        div.getChosaChikuShichosoInput().setTxtJotai(状態_追加);
        div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_1);
    }

    /**
     * 修正ボタンを押下します。
     */
    public void onClick_ModifyBtn() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setDisabled(true);
        div.getChosaChikuShichosoInput().getBtnToSearchShichoson().setDisabled(true);
        dgChosaChikuChichosonList_Row dgRow = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getSelectedItems().get(0);
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setValue(dgRow.getCityCode());
        div.getChosaChikuShichosoInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setValue(dgRow.getCityName());
        div.getChosaChikuShichosoInput().setTxtJotai(状態_修正);
        div.getChosaChikuShichosoInput().setHdnYusenNo(dgRow.getYusenNo());
        if (dgRow.getJichiku()) {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_1);
            div.getChosaChikuShichosoInput().setHdnJichiku(SELECT_KEY_1);
        } else {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_2);
            div.getChosaChikuShichosoInput().setHdnJichiku(SELECT_KEY_2);
        }
    }

    /**
     * 削除ボタンを押下します。
     */
    public void onClick_DeleteBtn() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setDisabled(true);
        div.getChosaChikuShichosoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getChosaChikuShichosoInput().getRadJiChikuFlag().setDisabled(true);
        dgChosaChikuChichosonList_Row dgRow = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getSelectedItems().get(0);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setValue(dgRow.getCityCode());
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setValue(dgRow.getCityName());
        div.getChosaChikuShichosoInput().setTxtJotai(状態_削除);
        if (dgRow.getJichiku()) {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_1);
        } else {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_2);
        }
    }

    private void 追加状態() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setDisabled(true);
        dgChosaChikuChichosonList_Row dgRow = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getSelectedItems().get(0);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setValue(dgRow.getCityCode());
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setValue(dgRow.getCityName());
        div.getChosaChikuShichosoInput().setTxtJotai(状態_追加);
        div.getChosaChikuShichosoInput().setHdnYusenNo(dgRow.getYusenNo());
        if (dgRow.getJichiku()) {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_1);
            div.getChosaChikuShichosoInput().setHdnJichiku(SELECT_KEY_1);
        } else {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_2);
            div.getChosaChikuShichosoInput().setHdnJichiku(SELECT_KEY_1);
        }
    }

    private void 明細照会状態() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setDisabled(true);
        div.getChosaChikuShichosoInput().getBtnToSearchShichoson().setDisabled(true);
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setDisabled(true);
        div.getChosaChikuShichosoInput().getRadJiChikuFlag().setDisabled(true);
        div.getChosaChikuShichosoInput().getBtnKakutei().setDisabled(true);
        dgChosaChikuChichosonList_Row dgRow = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getSelectedItems().get(0);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setValue(new Decimal(dgRow.getYusenNo().toString()));
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setValue(dgRow.getCityCode());
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setValue(dgRow.getCityName());
        div.getChosaChikuShichosoInput().setTxtJotai(RString.EMPTY);
        if (dgRow.getJichiku()) {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_1);
        } else {
            div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_2);
        }
    }

    /**
     * ダブルクリック押下します。
     */
    public void onClick_DoubleBtn() {
        dgChosaChikuChichosonList_Row dgRow = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getSelectedItems().get(0);
        if (dgRow.getJotai().equals(状態_追加)) {
            追加状態();
        }
        if (dgRow.getJotai().equals(状態_修正)) {
            onClick_ModifyBtn();
        }
        if (dgRow.getJotai().equals(状態_削除)) {
            onClick_DeleteBtn();
        }
        if (dgRow.getJotai().equals(RString.EMPTY)) {
            明細照会状態();
        }
    }

    /**
     * 市町村検索が戻します。
     */
    public void onOkClose_Dialog() {
        KoseiShiChosonSelectorModel dataPassModel = ViewStateHolder.get(
                ViewStateKeys.構成市町村選択_引き継ぎデータ, KoseiShiChosonSelectorModel.class);
        if (dataPassModel != null) {
            div.getChosaChikuShichosoInput().getTxtShichoSonCode().setValue(dataPassModel.get市町村コード());
            div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setValue(dataPassModel.get市町村名称());
        }
    }

    /**
     * 市町村コードフォーカスをなくなります。
     */
    public void onBlur_ShichosonCode() {
        RString jigyoshaMeisho = ChosaChikuFinder.createInstance().getShichosonMeisho(
                new LasdecCode(div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue()));
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setValue(jigyoshaMeisho);
    }

    /**
     * 取消するボタンが押下します。
     */
    public void onClick_TorikeshiBtn() {
        clearValue();
    }

    /**
     * 確定するボタンが押下します。
     */
    public void onClick_KakuteiBtn() {
        div.getCcdKanryoMessage().setVisible(true);
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosoInput().setVisible(true);
        List<dgChosaChikuChichosonList_Row> rowList = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getDataSource();
        int rowCount = 0;
        if (!状態_追加.equals(div.getChosaChikuShichosoInput().getTxtJotai())) {
            rowCount = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getClickedItem().getId();
        }
        dgChosaChikuChichosonList_Row row;
        if (状態_追加.equals(div.getChosaChikuShichosoInput().getTxtJotai())) {
            row = new dgChosaChikuChichosonList_Row();
            row.setJotai(状態_追加);
            row.setYusenNo(new RString(div.getChosaChikuShichosoInput().getTxtYusenNo().getValue().toString()));
            row.setCityCode(div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue());
            row.setCityName(div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().getValue());
            row.setJichiku(SELECT_KEY_1.equals(div.getChosaChikuShichosoInput().getRadJiChikuFlag().getSelectedKey()));
            rowList.add(row);
            clearValue();
        }
        if (状態_修正.equals(div.getChosaChikuShichosoInput().getTxtJotai())) {
            row = rowList.get(rowCount);
            row.setYusenNo(new RString(div.getChosaChikuShichosoInput().getTxtYusenNo().getValue().toString()));
            row.setCityCode(div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue());
            row.setCityName(div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().getValue());
            row.setJichiku(SELECT_KEY_1.equals(div.getChosaChikuShichosoInput().getRadJiChikuFlag().getSelectedKey()));
            if (状態_追加.equals(row.getJotai())) {
                row.setJotai(状態_追加);
            } else {
                row.setJotai(状態_修正);
            }
            rowList.set(rowCount, row);
            clearValue();
        }
        if (状態_削除.equals(div.getChosaChikuShichosoInput().getTxtJotai())) {
            row = rowList.get(rowCount);
            if (状態_追加.equals(row.getJotai())) {
                rowList.remove(rowCount);
            } else {
                row.setJotai(状態_削除);
                rowList.set(rowCount, row);
            }
            clearValue();
        }

    }

    /**
     * 「保存する」ボタンを押下します。
     */
    public void onClick_HozonnBtn() {
        前排他制御処理();
        List<dgChosaChikuChichosonList_Row> rowList = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getDataSource();
        Models<ChikuShichosonIdentifier, ChikuShichoson> models
                = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録7_地区市町村情報, Models.class);
        for (dgChosaChikuChichosonList_Row listRow : rowList) {
            if (状態_追加.equals(listRow.getJotai())) {
                ChikuShichoson chikuShichoson = new ChikuShichoson(
                        new Code(div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().getValue()),
                        new LasdecCode(listRow.getCityCode()));
                ChikuShichosonBuilder builder = chikuShichoson.createBuilderForEdit();
                builder.set優先番号(Integer.parseInt(listRow.getYusenNo().toString()));
                builder.set自地区フラグ(listRow.getJichiku());
                chikuShichoson.toEntity().setState(EntityDataState.Added);
                ChosaChikuFinder.createInstance().insertOrUpdate(builder.build());
            }
            if (状態_修正.equals(listRow.getJotai())) {
                ChikuShichosonIdentifier key = new ChikuShichosonIdentifier(
                        new Code(div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().getValue()),
                        new LasdecCode(listRow.getCityCode()));
                ChikuShichoson chikuShichoson = models.get(key);
                ChikuShichosonBuilder builder = chikuShichoson.createBuilderForEdit();
                builder.set優先番号(Integer.parseInt(listRow.getYusenNo().toString()));
                builder.set自地区フラグ(listRow.getJichiku());
                chikuShichoson.toEntity().setState(EntityDataState.Modified);
                ChosaChikuFinder.createInstance().insertOrUpdate(builder.build());
            }
            if (状態_削除.equals(listRow.getJotai())) {
                ChosaChikuFinder.createInstance().delete(ChosaChikuChichosonParameter.createParameter(
                        div.getChosaChikuShichosonPanel().getTxtChosaChikuCode().getValue(),
                        listRow.getCityCode()));
            }
        }
        前排他解除処理();
        div.getChosaChikuPanel().setVisible(true);
        div.getChosaChikuShichosonPanel().setVisible(true);
        div.getChosaChikuShichosoInput().setVisible(true);
    }

    private void 前排他制御処理() {
        LockingKey lockingKey = new LockingKey(new RString("ChikuShichosonCode"));
        RealInitialLocker.lock(lockingKey);
    }

    private void 前排他解除処理() {
        LockingKey lockingKey = new LockingKey(new RString("ChikuShichosonCode"));
        RealInitialLocker.release(lockingKey);
    }

    /**
     * 「調査地区一覧へ戻る」ボタンを押下します。
     */
    public void chosaChikuIchiranBtn() {
        clearValue();
    }

    /**
     * 「調査地区市町村一覧へ戻る」ボタンを押下します。
     */
    public void chosaChikuShichoSonIchiranBtn() {
        clearValue();
    }

    private void clearValue() {
        div.getChosaChikuShichosoInput().getTxtYusenNo().clearValue();
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().clearValue();
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().clearValue();
        div.getChosaChikuShichosoInput().setHdnYusenNo(RString.EMPTY);
        div.getChosaChikuShichosoInput().setHdnJichiku(RString.EMPTY);
        div.getChosaChikuShichosoInput().setTxtJotai(RString.EMPTY);
        div.getChosaChikuShichosoInput().setDisabled(false);
        div.getChosaChikuShichosoInput().getTxtYusenNo().setDisabled(false);
        div.getChosaChikuShichosoInput().getTxtShichoSonCode().setDisabled(false);
        div.getChosaChikuShichosoInput().getBtnToSearchShichoson().setDisabled(false);
        div.getChosaChikuShichosoInput().getBtnTorikeshi().setDisabled(false);
        div.getChosaChikuShichosoInput().getBtnKakutei().setDisabled(false);
        div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().setDisabled(false);
        div.getChosaChikuShichosoInput().getRadJiChikuFlag().setDisabled(false);
        div.getChosaChikuShichosoInput().getRadJiChikuFlag().setSelectedKey(SELECT_KEY_1);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
