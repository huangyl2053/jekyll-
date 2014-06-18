/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SetaiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSetaiJoho_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 世帯情報のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class SetaiJoho {

    /**
     * 世帯情報をセットします。
     *
     * @param panel 住民PanelDiv
     * @return 住民PanelDivのResponseData
     */
    public ResponseData<SetaiJohoDiv> getOnLoadData(SetaiJohoDiv panel) {
        ResponseData<SetaiJohoDiv> response = new ResponseData<>();

        DataGrid<dgSetaiJoho_Row> grid = panel.getDgSetaiJoho();
        List<dgSetaiJoho_Row> arrayData = create世帯情報();
        grid.setDataSource(arrayData);

        response.data = panel;
        return response;
    }

    private List<dgSetaiJoho_Row> create世帯情報() {
        List<dgSetaiJoho_Row> arrayData = new ArrayList<>();
        dgSetaiJoho_Row item;

        item = create世帯("電算　次郎", "男", "昭52.02.21", "子", "123456789012");
        arrayData.add(item);
        item = create世帯("電算　三郎", "男", "昭54.02.21", "子", "123456789013");
        arrayData.add(item);

        return arrayData;
    }

    private dgSetaiJoho_Row create世帯(
            String name,
            String gender,
            String birthDay,
            String tsuzukiGara,
            String JuminCode) {
        dgSetaiJoho_Row rowData = new dgSetaiJoho_Row(
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowData.setSetaiName(new RString(name));
        rowData.setSetaiGender(new RString(gender));
        rowData.setSetaiBirthDay(new RString(birthDay));
        rowData.setSetaiTsuzukiGara(new RString(tsuzukiGara));
        rowData.setSetaiShikibetsuCode(new RString(JuminCode));
        return rowData;
    }
}
