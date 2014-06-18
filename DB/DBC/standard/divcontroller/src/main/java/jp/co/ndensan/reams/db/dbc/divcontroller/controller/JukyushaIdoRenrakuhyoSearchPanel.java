/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0070011.dgSofuIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.JukyushaIdoRenrakuhyoSearchConditionDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.JukyushaIdoRenrakuhyoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.dgJukyushaIdoRenrakuhyoSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 受給者異動連絡票情報照会の検索パネルです。
 *
 * @author N3317 塚田 萌
 * @author n8823 ymldata
 */
public class JukyushaIdoRenrakuhyoSearchPanel {

    /**
     * 検索パネルが読み込まれた時は、検索項目をEMPTYで初期化し、検索結果一覧を閉じた状態にします。</br>
     * 異動日の初期値をあらかじめセットしておきます
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onLoad(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(false);
        clearSearchCondtion(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition());

        //2014.6.16 ymlData 適用
        setJukyushaIdoRenrakuhyoSearchCondition(searchPanel);

        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
        response.data = searchPanel;
        return response;
    }

    private void setJukyushaIdoRenrakuhyoSearchCondition(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
        List<HashMap> ymlData = ymlData("dbc0040011/JukyushaIdoRenrakuhyoSearchCondition.yml");

        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        searchPanel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtSearchHihoNo().setValue(ymlDt.getAsRString("searchHihoNo"));
        searchPanel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtIdoDateRange().setFromValue(ymlDt.getAsRDate("idoDateRangefrom"));
        searchPanel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtIdoDateRange().setToValue(ymlDt.getAsRDate("idoDateRangeto"));

    }

    /**
     * 検索ボタンが押された時は、検索結果一覧を開き、検索結果を表示します。
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnSearch(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(true);
        setJukyushaIdoRenrakuhyoSearchResultList(searchPanel);

        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
        response.data = searchPanel;

        return response;
    }

    /**
     * 条件をクリアするボタンが押された時は検索条件をEMPTYでクリアします。
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnClearSearchCondition(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(false);
        clearSearchCondtion(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition());

        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
        response.data = searchPanel;

        return response;
    }

    /**
     * 現在使用なし
     *
     * @param searchPanel
     * @return
     */
    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_dgDetail_show(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();

        response.data = searchPanel;
        return response;
    }

    private void clearSearchCondtion(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
        searchConditionDiv.getTxtIdoDateRange().clearFromValue();
        searchConditionDiv.getTxtIdoDateRange().clearToValue();
        searchConditionDiv.getTxtSearchHihoNo().clearValue();
    }

    private void setJukyushaIdoRenrakuhyoSearchResultList(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> arraydata = createTestData(searchPanel);

        DataGrid<dgJukyushaIdoRenrakuhyoSearchResult_Row> grid = searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().getDgJukyushaIdoRenrakuhyoSearchResult();
        grid.setDataSource(arraydata);

    }

    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createTestData(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> list = new ArrayList<>();
        List<HashMap> ymlData = ymlData("dbc0040011/JukyushaIdoRenrakuhyoSearchResultIchiran.yml");

        //TO DO データを増える場合。 
        for (int i = 0; i < ymlData.size(); i++) {

            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);

            list.add(createRow(
                    ymlDt.getAsRString("resultIdoDate"),
                    ymlDt.getAsRString("resultHihoNo"),
                    ymlDt.getAsRString("resultHihoName"),
                    ymlDt.getAsRString("resultSendYM")
            ));

        }
        return list;

    }

    private dgJukyushaIdoRenrakuhyoSearchResult_Row createRow(
            RString resultIdoDate,
            RString resultHihoNo,
            RString resultHihoName,
            RString resultSendYM) {

        dgJukyushaIdoRenrakuhyoSearchResult_Row rowJukyushaIdoRenrakuhyoSearchResultList;
        rowJukyushaIdoRenrakuhyoSearchResultList = new dgJukyushaIdoRenrakuhyoSearchResult_Row(
                new Button(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultIdoDate(setWareki(resultIdoDate));
        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultHihoNo(resultHihoNo);
        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultHihoName(resultHihoName);
        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultSendYM(setWareki(resultSendYM));

        return rowJukyushaIdoRenrakuhyoSearchResultList;
    }

    
    private RString setWareki(RString wareki) {
         FlexibleDate warekiYmd = new FlexibleDate(wareki);
        return warekiYmd.wareki().toDateString();
    }
    
    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }
}
