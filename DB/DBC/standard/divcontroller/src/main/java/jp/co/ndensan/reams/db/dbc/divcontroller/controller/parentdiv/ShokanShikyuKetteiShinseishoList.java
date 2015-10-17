/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810000.ShokanShikyuKetteiShinseishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ShokanShikyuShinseishoList.dgShokanShikyuShinseishoList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810000.DBC0810000TransitionEventName.申請者情報;

/**
 * 償還支給申請決定の申請書一覧のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiShinseishoList {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShinseishoListDiv> onLoad(ShokanShikyuKetteiShinseishoListDiv panel) {
        setShinseishoListData(panel);

        return ResponseData.of(panel).respond();
    }

    public ResponseData<ShokanShikyuKetteiShinseishoListDiv> onClick_dgButton(ShokanShikyuKetteiShinseishoListDiv panel) {
        List<dgShokanShikyuShinseishoList_Row> list = panel.getShokanShikyuKetteiShinseishoListInfo().getDgShokanShikyuShinseishoList().getDataSource();
        list.add(new dgShokanShikyuShinseishoList_Row());
        panel.getShokanShikyuKetteiShinseishoListInfo().getDgShokanShikyuShinseishoList().setDataSource(list);

        return ResponseData.of(panel).forwardWithEventName(申請者情報).respond();
    }

    /**
     * 支給申請書情報で「決定情報を保存する」ボタンを押下した時の申請書一覧パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShinseishoListDiv> onClickKetteiSave(ShokanShikyuKetteiShinseishoListDiv panel) {
        return ResponseData.of(panel).respond();
    }

    private void setShinseishoListData(ShokanShikyuKetteiShinseishoListDiv panel) {
        DataGrid<dgShokanShikyuShinseishoList_Row> dgRow = panel.getShokanShikyuKetteiShinseishoListInfo().getDgShokanShikyuShinseishoList();
        List<dgShokanShikyuShinseishoList_Row> dgRowList = dgRow.getDataSource();

        //TODO n3317塚田　遷移させるために空行を作成
        dgRowList.add(new dgShokanShikyuShinseishoList_Row());
//        for (int i = 0; i < 3; i++) {
//            dgRowList.add(create申請書情報(
//                    sourceList.get(i).get("サービス年月").toString(),
//                    sourceList.get(i).get("申請日").toString(),
//                    sourceList.get(i).get("整理番号").toString(),
//                    sourceList.get(i).get("支払金額合計").toString(),
//                    sourceList.get(i).get("保険請求額合計").toString(),
//                    sourceList.get(i).get("自己負担額合計").toString()));
//        }
//        Collections.sort(dgRowList, new DateComparator());
        dgRow.setDataSource(dgRowList);
    }

    private static class DateComparator implements Comparator<dgShokanShikyuShinseishoList_Row> {

        @Override
        public int compare(dgShokanShikyuShinseishoList_Row o1, dgShokanShikyuShinseishoList_Row o2) {
            return new FlexibleDate(o2.getTxtShinseiYMD().replace(".", "")).compareTo(new FlexibleDate(o1.getTxtShinseiYMD().replace(".", "")));
        }
    }

    private dgShokanShikyuShinseishoList_Row create申請書情報(
            String txtServiceYM,
            String txtShinseiYMD,
            String txtSeiriNo,
            String txtShiharaiGokei,
            String txtHokenGokei,
            String txtJikoGokei
    ) {
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();
        dgShokanShikyuShinseishoList_Row item = new dgShokanShikyuShinseishoList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(txtServiceYM),
                new RString(txtShinseiYMD),
                new RString(txtSeiriNo),
                new RString(txtShiharaiGokei),
                new RString(txtHokenGokei),
                new RString(txtJikoGokei)
        );
        return item;
    }
}
