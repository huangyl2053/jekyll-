/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.MishinsaShikyuShinseiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.dgMishinsaShikyuShinsei_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 住宅改修費支給申請審査 未審査支給申請検索条件(未審査分を検索するボタン押下後、未審査支給申請一覧の内容が表示する）
 *
 * @author n8223
 */
public class MishinsaShikyuShinseiListPanel {

    private static final int 不承認 = 3;
    /**
     * 住宅改修費支給申請審査 未審査支給申請一覧の内容をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<MishinsaShikyuShinseiListPanelDiv> onLoad(MishinsaShikyuShinseiListPanelDiv panel) {
//        panel.getTxtShinsaDate().setValue(RDate.getNowDate());

        setMishinsaShikyuShinseiList(panel);

        //TO DO
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("tenkyo"), new RString("転居リセットの判定を行う")));
        dataSource.add(new KeyValueDataSource(new RString("threeStep"), new RString("３段階リセットの判定を行う")));
        panel.getSystemCheck().getChkResetCheck().setSelectedItems(dataSource);

        return ResponseData.of(panel).respond();
    }

    /**
     * 住宅改修費支給申請審査 未審査支給申請一覧の内容をセットします。
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<MishinsaShikyuShinseiListPanelDiv> onClick_btnSearchMishinsa(MishinsaShikyuShinseiListPanelDiv panel) {
        //requestSettingでセットしない
        setMishinsaShikyuShinseiList(panel);

        return ResponseData.of(panel).respond();
    }

    /**
     * 住宅改修費支給申請審査 選択された未審査支給申請一覧情報をもとに、 支給申請内容を一括審査するボタンを押下後、審査結果の内容をセットされる。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @return
     */
    public ResponseData<MishinsaShikyuShinseiListPanelDiv> onClick_btnShinsa(MishinsaShikyuShinseiListPanelDiv panel) {

//        if (is３段階チェックあり(panel.getDgMishinsaShikyuShinsei().getDataSource().get(不承認))) {
//            panel.getDgMishinsaShikyuShinsei().getDataSource().get(不承認).setTxtShinsaResult(new RString("承認"));
//        } else {
        for (dgMishinsaShikyuShinsei_Row row : panel.getDgMishinsaShikyuShinsei().getSelectedItems()) {
            if (row.getId() == 不承認) {
                row.setTxtShinsaResult(new RString("相違有り：3段階リセット"));
            } else {
                row.setTxtShinsaResult(new RString("承認"));
            }
        }
//        }
        setAbleCommonButton();

        return ResponseData.of(panel).respond();
    }

    public ResponseData<MishinsaShikyuShinseiListPanelDiv> onSelectByModifyButton(MishinsaShikyuShinseiListPanelDiv panel) {

        dgMishinsaShikyuShinsei_Row selectedRow = panel.getDgMishinsaShikyuShinsei().getClickedItem();
        ViewStateHolder.put("selectedRow", selectedRow);

        return ResponseData.of(panel).respond();
    }

    /**
     * 住宅改修費支給申請審査 申請内容の画面で、3段階リセットをチェックしたから、戻るとき、相違有り：3段階リセットの行で、３段階チェックを設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @return
     */
    public ResponseData<MishinsaShikyuShinseiListPanelDiv> onClick_btnModifyShinseiContents(
            MishinsaShikyuShinseiListPanelDiv panel) {

        panel.getDgMishinsaShikyuShinsei().getDataSource().get(不承認).setRowState(RowState.Modified);
        panel.getDgMishinsaShikyuShinsei().getDataSource().get(不承認).setTxt3DankaiReset(Boolean.TRUE);
        panel.getDgMishinsaShikyuShinsei().getDataSource().get(不承認).setTxtShinsaResult(new RString("承認"));

//        if (is３段階チェックあり(panel1)) {
//            panel.getDgMishinsaShikyuShinsei().getDataSource().get(3).setTxt3DankaiReset(Boolean.TRUE);
//        }
//        List<dgMishinsaShikyuShinsei_Row> selectedMishinsaShikyuShinsei
//                = panel.getDgMishinsaShikyuShinsei().getSelectedItems();
//
//        //TO DO  介護状態区分３段階変更による　チェックされたことを確認する。JutakuKaishuShinseiResetInfoDiv
//        String chkResetInfoSelValue = panel1.getChkResetInfo().getSelectedValues().toString();
//        for (int i = 0; i < selectedMishinsaShikyuShinsei.size(); i++) {
//            dgMishinsaShikyuShinsei_Row mishinsaShikyuShinsei_Row = selectedMishinsaShikyuShinsei.get(i);
//            if (i == 3) {
//                mishinsaShikyuShinsei_Row.setTxtShinsaResult(new RString("相違有り：3段階リセット"));
//
//                if (chkResetInfoSelValue.equals("[要介護状態区分３段階変更による]")) {
//                    if (!chkResetInfoSelValue.isEmpty()) {
//                        mishinsaShikyuShinsei_Row.setTxt3DankaiReset(Boolean.TRUE);
//                    }
//                }
//
//            } else {
//                mishinsaShikyuShinsei_Row.setTxtShinsaResult(new RString("承認"));
//            }
//        }
        return ResponseData.of(panel).respond();
    }

    private void setAbleCommonButton() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), false);
    }

//    private boolean is３段階チェックあり(dgMishinsaShikyuShinsei_Row row) {
//        return row.getTxt3DankaiReset();
//    }

    /*
     * 住宅改修費支給申請審査 未審査支給申請一覧のデータを設定する。
     */
    private void setMishinsaShikyuShinseiList(MishinsaShikyuShinseiListPanelDiv panel) {

        List<dgMishinsaShikyuShinsei_Row> arraydata = createRowMishinsaShikyuShinseiTestData();
        DataGrid<dgMishinsaShikyuShinsei_Row> grid = panel.getDgMishinsaShikyuShinsei();

        grid.setDataSource(arraydata);
    }

    /*
     * 住宅改修費支給申請審査 (YMLDATA)未審査支給申請一覧のデータを設定する。
     */
    private List<dgMishinsaShikyuShinsei_Row> createRowMishinsaShikyuShinseiTestData() {

        List<dgMishinsaShikyuShinsei_Row> arrayData = new ArrayList<>();
        arrayData.add(new dgMishinsaShikyuShinsei_Row());
        return arrayData;
    }

    /*
     * 共通内容を設定する
     */
//    private void hashMap(HashMap hashMap, List<dgMishinsaShikyuShinsei_Row> arrayData) {
//
//        //TO DO DataGrid
//        RString shikyuShinseiDate = new RString(hashMap.get("shikyuShinseiDate").toString());
//        RString teikyoYM = new RString(hashMap.get("teikyoYM").toString());
//        RString hihoNo = new RString(hashMap.get("hihoNo").toString());
//        RString hihokenshaName = new RString(hashMap.get("hihokenshaName").toString());
//        RString hokenKyufuAmount = new RString(hashMap.get("hokenKyufuAmount").toString());
//        RString riyoshaFutanAmount = new RString(hashMap.get("riyoshaFutanAmount").toString());
//        RString hiyoTotalAmount = new RString(hashMap.get("hiyoTotalAmount").toString());
//        RString tenkyoReset = new RString(hashMap.get("tenkyoReset").toString());
//        RString dankaiReset3 = new RString(hashMap.get("dankaiReset3").toString());
//        RString seiriNo = new RString(hashMap.get("seiriNo").toString());
//
//        dgMishinsaShikyuShinsei_Row item;
//
//        item = createRowishinsaShikyuShinseiListData(
//                shikyuShinseiDate,
//                teikyoYM,
//                hihoNo,
//                hihokenshaName,
//                hokenKyufuAmount,
//                riyoshaFutanAmount,
//                hiyoTotalAmount,
//                tenkyoReset,
//                dankaiReset3,
//                // shinsaResult,
//                seiriNo
//        );
//        arrayData.add(item);
//    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgMishinsaShikyuShinsei_Row createRowishinsaShikyuShinseiListData(
            RString 支給申請日,
            RString 提供年月,
            RString 被保番号,
            RString 氏名,
            RString 保険給付額,
            RString 利用者負担額,
            RString 費用額合計,
            RString 転居,
            RString 段階3,
            RString 整理番号) {

        dgMishinsaShikyuShinsei_Row rowMishinsaShinseiListData;
        rowMishinsaShinseiListData = new dgMishinsaShikyuShinsei_Row(
                new TextBoxDate(),
                new TextBoxDate(),
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(), false, false,
                RString.EMPTY,
                new TextBoxCode()
        );

        rowMishinsaShinseiListData.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日.toString()));
        rowMishinsaShinseiListData.getTxtTeikyoYM().setValue(new RDate(提供年月.toString()));
        rowMishinsaShinseiListData.setTxtHihoNo(new RString(被保番号.toString()));
        rowMishinsaShinseiListData.setTxtHihokenshaName(new RString(氏名.toString()));
        rowMishinsaShinseiListData.getTxtHokenKyufuAmount().setValue(new Decimal(保険給付額.toString()));
        rowMishinsaShinseiListData.getTxtRiyoshaFutanAmount().setValue(new Decimal(利用者負担額.toString()));
        rowMishinsaShinseiListData.getTxtHiyoTotalAmount().setValue(new Decimal(費用額合計.toString()));
        rowMishinsaShinseiListData.setTxtTenkyoReset(Boolean.valueOf(転居.toString()));
        rowMishinsaShinseiListData.setTxt3DankaiReset(Boolean.valueOf(段階3.toString()));
        rowMishinsaShinseiListData.getTxtSeiriNo().setValue(new RString(整理番号.toString()));

        return rowMishinsaShinseiListData;

    }

    /*
     * エラーMESSAGE
     */
//    private void validate(ResponseData<MishinsaShikyuShinseiListPanelDiv> response) {
//       String errMessage = "【未審査支給申請一覧】3行：相違有り3段階をリセットしてください";
//       response.addMessage(new WarningMessage("エラー", errMessage), DivcontrollerMethod.method(SingleButtonType.Free,null));
//    }
}
