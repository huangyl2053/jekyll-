/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020008;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.chosachikugroup.ChosaChikuGroupMaster;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chosachikugroup.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.ChosaChikuGroupChosaChikuInputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.NinteiChosaSchedule8MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.dgChosaChikuGroupChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008.dgChosaChikuGroupList_Row;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * 認定調査スケジュール登録8のハンドラークラスです。
 */
public class NinteiChosaSchedule8MainHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString CODESHUBETSU_5002 = new RString("5002");
    private final NinteiChosaSchedule8MainDiv div;

    /**
     * コンストラクタ。
     *
     * @param div MainPanelDiv
     */
    public NinteiChosaSchedule8MainHandler(NinteiChosaSchedule8MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     * @param entityList 調査地区グループ情報
     */
    public void onLoad(List<ChosaChikuGroup> entityList) {
        List<dgChosaChikuGroupList_Row> dataGridList = new ArrayList<>();
        int i = 1;
        for (ChosaChikuGroup chosaChikuGroup : entityList) {
            dgChosaChikuGroupList_Row dataGrid = new dgChosaChikuGroupList_Row();
            dataGrid.setChosaChikuGroupCode(chosaChikuGroup.get調査地区グループコード() == null ? RString.EMPTY
                    : chosaChikuGroup.get調査地区グループコード().getColumnValue());
            dataGrid.setChosaChikuGroupName(chosaChikuGroup.get調査地区グループ名称());
            dataGrid.setNo(new RString(String.valueOf(i)));
            dataGridList.add(dataGrid);
            i++;
        }
        div.getDgChosaChikuGroupList().setDataSource(dataGridList);
    }

    /**
     * 調査地区グループ調査地区一覧情報を取得する。
     *
     * @param entityList 調査地区グループ情報
     * @param row 調査地区グループ一覧で選択された行
     */
    public void setChosaChikuGroupChosaChikuList(List<ChosaChikuGroupMaster> entityList, dgChosaChikuGroupList_Row row) {
        div.getTxtChosaChikuCode().setValue(new Decimal(row.getChosaChikuGroupCode().toString()));
        div.getTxtChosaChikuName().setValue(row.getChosaChikuGroupName());
        List<dgChosaChikuGroupChosaChikuList_Row> dataGridList = new ArrayList<>();
        for (ChosaChikuGroupMaster chosaChikuGroupMaster : entityList) {
            dgChosaChikuGroupChosaChikuList_Row dataGrid = new dgChosaChikuGroupChosaChikuList_Row();
            dataGrid.setYusenNo(new RString(String.valueOf(chosaChikuGroupMaster.get優先番号())));
            dataGrid.setChosaChikuCode(chosaChikuGroupMaster.get調査地区コード() == null ? RString.EMPTY
                    : chosaChikuGroupMaster.get調査地区コード().getColumnValue());
            dataGrid.setChosaChikuName(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                    new CodeShubetsu(CODESHUBETSU_5002), chosaChikuGroupMaster.get調査地区コード()));
            dataGrid.setShichosonCode(chosaChikuGroupMaster.get市町村コード().getColumnValue());
            dataGrid.setShichosonName(chosaChikuGroupMaster.get市町村名称());
            dataGridList.add(dataGrid);
        }
        div.getDgChosaChikuGroupChosaChikuList().setDataSource(dataGridList);
    }

    /**
     * 調査地区グループ調査地区一覧情報を設定します。
     *
     * @param row 調査地区グループ調査地区一覧情報
     */
    public void setChosaChikuGroupChosaChikuInput(dgChosaChikuGroupChosaChikuList_Row row) {
        div.getTxtYusenNo().setValue(row.getYusenNo() == null ? Decimal.ZERO : new Decimal(row.getYusenNo().toString()));
        div.getTxtChosaChikuCode1().setValue(row.getChosaChikuCode());
        div.getTxtShichosonCode().setValue(row.getShichosonCode());
        div.getTxtChosaChikuMeisho1().setValue(row.getChosaChikuName());
        div.getTxtShichosonMeisho().setValue(row.getShichosonName());
    }

    /**
     * 調査地区グループ調査地区情報登録エリアをクリアします。
     */
    public void clearChosaChikuGroupChosaChikuInput() {
        div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().clearValue();
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().clearValue();
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().clearValue();
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().clearValue();
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().clearValue();
    }

    /**
     * 調査地区名称を設定します。
     */
    public void setTxtChosaChikuMeisho() {
        div.getTxtChosaChikuMeisho1().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                new CodeShubetsu(CODESHUBETSU_5002),
                new Code(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1() == null ? RString.EMPTY
                        : div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue())));
    }

    /**
     * 調査地区グループ調査地区登録エリアが活性に設定します。
     */
    public void setDisabledFalseToChosaChikuGroupChosaChikuInput() {
        div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getBtnToSearchChosaChiku().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getBtnToSearchShichoson().setDisabled(false);
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().setDisabled(false);
    }

    /**
     * 調査地区グループ調査地区登録エリアが非活性に設定します。
     */
    public void setDisabledTrueToChosaChikuGroupChosaChikuInput() {
        div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getBtnToSearchChosaChiku().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getBtnToSearchShichoson().setDisabled(true);
        div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().setDisabled(true);
    }

    /**
     * 調査地区グループ調査地区登録エリアを編集します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        ChosaChikuGroupChosaChikuInputDiv chosaChikuInputDiv = div.getChosaChikuGroupChosaChikuInput();
        inputDiv.append(chosaChikuInputDiv.getTxtYusenNo().getValue() == null
                ? Decimal.ZERO : chosaChikuInputDiv.getTxtYusenNo().getValue());
        inputDiv.append(chosaChikuInputDiv.getTxtChosaChikuCode1().getValue());
        inputDiv.append(chosaChikuInputDiv.getTxtChosaChikuMeisho1().getValue());
        inputDiv.append(chosaChikuInputDiv.getTxtShichosonCode().getValue());
        inputDiv.append(chosaChikuInputDiv.getTxtShichosonMeisho().getValue());
        return inputDiv.toRString();
    }

    /**
     * 調査地区グループ調査地区情報を設定します。
     *
     * @param chosaChikuGroup 調査地区グループ調査地区情報
     * @return ShujiiJoho 調査地区グループ調査地区情報
     */
    public ChosaChikuGroup editChosaChikuGroup(ChosaChikuGroup chosaChikuGroup) {
        return chosaChikuGroup.createBuilderForEdit().set優先番号(Integer.valueOf(
                div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().getValue().toString())).
                set調査地区グループ名称(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().getValue())
                .build();
    }

    /**
     * 調査地区グループ調査地区一覧情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setChosaChikuGroupToIchiran(RString eventJotai) {
        dgChosaChikuGroupChosaChikuList_Row row = new dgChosaChikuGroupChosaChikuList_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getActiveRow();
        }
        row.setYusenNo(new RString(div.getChosaChikuGroupChosaChikuInput().getTxtYusenNo().getValue().toString()));
        row.setChosaChikuCode(nullToEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1().getValue()));
        row.setChosaChikuName(nullToEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1().getValue()));
        row.setShichosonCode(nullToEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode().getValue()));
        row.setShichosonName(nullToEmpty(div.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho().getValue()));
        int index = div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setJotai(eventJotai);
            div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(row.getJotai())) {
            div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getDataSource().set(index, row);
        } else {
            row.setJotai(eventJotai);
            div.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList().getDataSource().set(index, row);
        }
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
