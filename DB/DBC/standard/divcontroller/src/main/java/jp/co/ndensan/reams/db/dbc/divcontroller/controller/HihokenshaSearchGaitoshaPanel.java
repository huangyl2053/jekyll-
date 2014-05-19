/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HihokenshaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 福祉用具購入費支給申請 該当者一覧のパネルです。
 *
 * @author n8223
 */
public class HihokenshaSearchGaitoshaPanel {

    /**
     * 福祉用具購入費支給申請 該当者一覧の情報を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<HihokenshaSearchGaitoshaPanelDiv> onClick_HihokenshaSearch(HihokenshaSearchGaitoshaPanelDiv panel, HihokenshaSearchPanelDiv panel1) {
        ResponseData<HihokenshaSearchGaitoshaPanelDiv> response = new ResponseData<>();

        setHihokenshaSearchData(panel);
        response.data = panel;
        return response;

    }

    /*
     該当者一覧の初期値をセットします。
     */
    private void setHihokenshaSearchData(HihokenshaSearchGaitoshaPanelDiv panel) {

        List<dgHihokenshaSearchGaitosha_Row> arraydata = createRowHihokenshaSearchTestData();
        DataGrid<dgHihokenshaSearchGaitosha_Row> grid = panel.getDgHihokenshaSearchGaitosha();
        grid.setDataSource(arraydata);

    }

    /*
     該当者一覧の初期値のテストデータです。
     */
    private List<dgHihokenshaSearchGaitosha_Row> createRowHihokenshaSearchTestData() {
        List<dgHihokenshaSearchGaitosha_Row> arrayData = new ArrayList<>();

        dgHihokenshaSearchGaitosha_Row item;
        item = createRowHihokenshaData(
                "1111111111",
                "電算　太郎",
                "19330325",
                "74",
                "女",
                "長野県長野市1-2-3",
                "1111111114",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "");
        arrayData.add(item);
        return arrayData;

    }

    /*
     引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgHihokenshaSearchGaitosha_Row createRowHihokenshaData(
            String 被保番号,
            String 氏名,
            String 生年月日,
            String 年齢,
            String 性別,
            String 住所,
            String 識別コード,
            String フリガナ,
            String 住所コード,
            String 行政区,
            String 組合,
            String 世帯コード,
            String 連絡先1,
            String 連絡先2,
            String 要介護度,
            String 認定期間開始,
            String 認定期間終了,
            String 旧被保険者番号,
            String 旧市町村コード,
            String 旧市町村
    ) {

        dgHihokenshaSearchGaitosha_Row rowHihokenshaData = new dgHihokenshaSearchGaitosha_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowHihokenshaData.setHihokenshaNo(new RString(被保番号));
        rowHihokenshaData.setShimei(new RString(氏名));
        rowHihokenshaData.setDateOfBirth(new RString(生年月日));
        rowHihokenshaData.setAge(new RString(年齢));
        rowHihokenshaData.setGender(new RString(性別));
        rowHihokenshaData.setJusho(new RString(住所));
        rowHihokenshaData.setShikibetsuCode(new RString(識別コード));

        return rowHihokenshaData;
    }

}
