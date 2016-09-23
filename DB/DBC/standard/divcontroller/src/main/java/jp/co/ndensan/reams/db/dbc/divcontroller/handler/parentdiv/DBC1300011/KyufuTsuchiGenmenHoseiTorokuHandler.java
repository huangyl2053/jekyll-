/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiTuchiHosei;
import jp.co.ndensan.reams.db.dbc.business.core.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.DataGridItiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBCMN71001_給付費通知減免情報補正登録Handlerクラスです。
 *
 * @reamsid_L DBC-2260-010 xuyongchao
 */
public class KyufuTsuchiGenmenHoseiTorokuHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString BTN_RESEARCH = new RString("btnResearch");
    private static final RString BTN_RESEARCH_RESULT = new RString("btnSearchResult");
    private static final RString BTN_HOZON = new RString("btnHozon");
    private static final int NUM_2 = 2;
    private static final int NUM_0 = 0;
    private static final int NUM_6 = 6;
    private final KyufuTsuchiGenmenHoseiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KyufuTsuchiGenmenHoseiTorokuHandler(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void onLoad(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getKyufuTsuchiGenmenHoseiTorokuKihon().initialize(識別コード);
        div.getKyufuTsuchiGenmenHoseiTorokuKaigoKihon().initialize(被保険者番号);
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTextBoxNumKensuu().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTextBoxNumKensuu().setValue(new Decimal(検索制御_最大取得件数.toString()));
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setVisible(false);
        div.getTextBoxDateService().clearFromValue();
        div.getTextBoxDateService().clearToValue();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HOZON, true);
    }

    /**
     * 検索処理です。
     *
     * @param list list
     */
    public void search(List<KyufuhigenmenjyouhouRegisterResult> list) {
        setDataGrid(list);
    }

    /**
     * 補正情報を追加する ボタン処理です。
     *
     */
    public void tuika() {
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setVisible(true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_HOZON, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_RESEARCH, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_RESEARCH_RESULT, false);
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu().clearValue();
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務, false);
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxFudangoukei().clearValue();
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxNumHiyouGoukei().clearValue();
    }

    /**
     * 「修正」ボタン処理です
     *
     */
    public void modify() {
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setVisible(true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_HOZON, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_RESEARCH, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_RESEARCH_RESULT, false);
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務, false);
        DataGridItiran_Row row = div.getDataGridItiran().getActiveRow();
        if (!row.getTxtServiceNengetsu().isEmpty()) {
            div.getTextBoxDateSaabisu().setValue(new RDate(row.getTxtServiceNengetsu().toString()));
        } else {
            div.getTextBoxDateSaabisu().setValue(new RDate(RString.EMPTY.toString()));
        }
        if (row.getTxtShokisaiNo().isEmpty()) {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList().setSelectedShoKisaiHokenshaNoIfExist(ShoKisaiHokenshaNo.EMPTY);
        } else {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList().
                    setSelectedShoKisaiHokenshaNoIfExist(new ShoKisaiHokenshaNo(row.getTxtShokisaiNo()));
        }
        if (row.getTxtJigyoshaNo().isEmpty()) {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(RString.EMPTY);
        } else {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(row.getTxtJigyoshaNo());
        }
        if (row.getTxtJigyoshaName().isEmpty()) {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(RString.EMPTY);
        } else {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().setShisetsuMeisho(row.getTxtJigyoshaName());
        }
        if (!row.getTxtServiceShurui().isEmpty()) {
            div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput().initialize(row.getTxtServiceShurui().substring(NUM_0, NUM_2));
        }
        if (!row.getTxtFutangakuGokei().isEmpty()) {
            div.getTextBoxFudangoukei().setValue(new Decimal(row.getTxtFutangakuGokei().toString()));
        }
        if (!row.getTxtServicehiGokei().isEmpty()) {
            div.getTextBoxNumHiyouGoukei().setValue(new Decimal(row.getTxtServicehiGokei().toString()));
        }
    }

    /**
     * 「削除」ボタン処理です
     *
     */
    public void delete() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_HOZON, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HOZON, false);
    }

    /**
     * 「edit」kyufuhiTuchiHosei処理です
     *
     * @param kyufuhiTuchiHosei kyufuhiTuchiHosei
     * @return KyufuhiTuchiHosei
     */
    public KyufuhiTuchiHosei edit(KyufuhiTuchiHosei kyufuhiTuchiHosei) {
        return kyufuhiTuchiHosei.createBuilderForEdit().set利用者負担額(div.getTextBoxFudangoukei().getValue())
                .setサービス費用合計額(div.getTextBoxNumHiyouGoukei().getValue()).build();

    }

    /**
     * 「補正情報一覧に戻る」ボタン処理です
     *
     */
    public void back() {
        div.getTextBoxDateSaabisu().clearValue();
        div.getCcdServiceTypeInput().clear();
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務, false);
        div.getCcdJigyoshaInput().setNyuryokuShisetsuKodo(RString.EMPTY);
        div.getCcdJigyoshaInput().setShisetsuMeisho(RString.EMPTY);
        div.getTextBoxFudangoukei().clearValue();
        div.getTextBoxNumHiyouGoukei().clearValue();
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setVisible(false);
    }

    /**
     * 追加処理です
     *
     * @param eventJotai eventJotai
     */
    public void setDetail(RString eventJotai) {
        DataGridItiran_Row row = new DataGridItiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getDataGridItiran().getActiveRow();
        }
        setRow(row);
        int index = div.getDataGridItiran().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setRowState(RowState.Added);
            div.getDataGridItiran().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(new RString(row.getRowState().toString()))) {
            div.getDataGridItiran().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(new RString(row.getRowState().toString()))) {
            div.getDataGridItiran().getDataSource().set(index, row);
        } else {
            if (状態_修正.equals(eventJotai)) {
                row.setRowState(RowState.Modified);
            } else {
                row.setRowState(RowState.Deleted);
            }
            div.getDataGridItiran().getDataSource().set(index, row);
        }
        CommonButtonHolder.setVisibleByCommonButtonFieldName(BTN_HOZON, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HOZON, false);
    }

    private void setRow(DataGridItiran_Row row) {
        row.setTxtShokisaiNo(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().getColumnValue());
        row.setTxtServiceNengetsu(div.getTextBoxDateSaabisu().getValue().toDateString().substring(NUM_0, NUM_6));
        row.setTxtJigyoshaNo(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo());
        row.setTxtJigyoshaName(div.getCcdJigyoshaInput().getNyuryokuShisetsuMeisho());
        row.setTxtServiceShurui(div.getCcdServiceTypeInput().getサービス種類コード());
        row.setTxtFutangakuGokei(new RString(div.getTextBoxFudangoukei().getValue().toString()));
        row.setTxtServicehiGokei(new RString(div.getTextBoxNumHiyouGoukei().getValue().toString()));
    }

    private void setDataGrid(List<KyufuhigenmenjyouhouRegisterResult> list) {
        List<DataGridItiran_Row> dataGridList = new ArrayList<>();
        for (KyufuhigenmenjyouhouRegisterResult result : list) {
            if (result == null) {
                continue;
            }
            dataGridList.add(createDataGrid(result));
        }
        div.getDataGridItiran().getDataSource().clear();
        div.getDataGridItiran().getDataSource().addAll(dataGridList);
    }

    private DataGridItiran_Row createDataGrid(KyufuhigenmenjyouhouRegisterResult result) {
        DataGridItiran_Row row = new DataGridItiran_Row();
        if (result.get証記載保険者番号().isEmpty()) {
            row.setTxtShokisaiNo(RString.EMPTY);
        } else {
            row.setTxtShokisaiNo(result.get証記載保険者番号().value());
        }
        if (result.getサービス提供年月().isEmpty()) {
            row.setTxtServiceNengetsu(RString.EMPTY);
        } else {
            row.setTxtServiceNengetsu(result.getサービス提供年月().toDateString());
        }
        if (result.get事業者番号().isEmpty()) {
            row.setTxtJigyoshaNo(RString.EMPTY);
        } else {
            row.setTxtJigyoshaNo(result.get事業者番号().value());
        }
        if (result.get事業者名称().isEmpty()) {
            row.setTxtJigyoshaName(RString.EMPTY);
        } else {
            row.setTxtJigyoshaName(result.get事業者名称().value());
        }
        if (result.getサービス種類().isEmpty()) {
            row.setTxtServiceShurui(RString.EMPTY);
        } else {
            row.setTxtServiceShurui(result.getサービス種類());
        }
        if (null == result.get利用者負担額()) {
            row.setTxtFutangakuGokei(RString.EMPTY);
        } else {
            row.setTxtFutangakuGokei(new RString(result.get利用者負担額().toString()));
        }
        if (result.getサービス費用合計額() == null) {
            row.setTxtServicehiGokei(RString.EMPTY);
        } else {
            row.setTxtServicehiGokei(new RString(result.getサービス費用合計額().toString()));
        }
        return row;
    }

}
