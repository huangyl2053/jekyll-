/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0220011.JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 受給者異動連絡票変更登録 対象者一覧のコントローラークラスです。
 *
 * @author n8156 宮本 康
 */
public class JukyushaIdoRenrakuhyoHenkoSearchResultListPanel {

    private static final RString YML_NAME = new RString("dbc0220011/JukyushaIdoRenrakuhyoHenkoSearchResultList.yml");

    /**
     * 検索時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> onClick_btnSearch(
            JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> response = new ResponseData<>();

        setJukyushaIdoRenrakuhyoHenkoSearchResult(panel);

        response.data = panel;
        return response;

    }

    private void setJukyushaIdoRenrakuhyoHenkoSearchResult(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
        List<HashMap> mapList = getYmlData();
        List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> list = new ArrayList<>();
        for (int index = 0; index < mapList.size(); index++) {
            HashMap map = mapList.get(index);
            list.add(createJukyushaIdoRenrakuhyoHenkoSearchResultRow(
                    map.get("異動日").toString(),
                    map.get("被保番号").toString(),
                    map.get("カナ氏名").toString(),
                    map.get("送付年月").toString()));
        }
        panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().setDataSource(list);
    }

    private dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row createJukyushaIdoRenrakuhyoHenkoSearchResultRow(
            String txtResultIdoDate,
            String txtResultHihoNo,
            String txtResultHihoName,
            String txtResultSendYM) {

        TextBoxDate resultIdoDate = new TextBoxDate();
        TextBoxCode resultHihoNo = new TextBoxCode();
        TextBox resultHihoName = new TextBox();
        TextBoxDate resultSendYM = new TextBoxDate();

        resultIdoDate.setValue(new RDate(txtResultIdoDate));
        resultHihoNo.setValue(new RString(txtResultHihoNo));
        resultHihoName.setValue(new RString(txtResultHihoName));
        resultSendYM.setValue(new RDate(txtResultSendYM));

        return new dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row(
                new Button(),
                new Button(),
                resultIdoDate,
                resultHihoNo,
                resultHihoName,
                resultSendYM,
                true);
    }

    private List<HashMap> getYmlData() {
        return YamlLoader.DBC.loadAsList(YML_NAME);
    }
}
