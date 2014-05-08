/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchConditionDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 受給者異動連絡票情報照会の検索パネルです。
 *
 * @author N3317 塚田 萌
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

        searchPanel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtIdoDateRange().setFromValue(new RDate("20130101"));
        searchPanel.getJukyushaIdoRenrakuhyoSearchCondition().getTxtIdoDateRange().setToValue(new RDate("20140701"));
        ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> response = new ResponseData<>();
        response.data = searchPanel;
        return response;
    }

    /**
     * 検索ボタンが押された時は、検索結果一覧を開き、検索結果を表示します。
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoSearchPanelDiv> onClick_btnSearch(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(true);
        set連絡票検索結果一覧(searchPanel);

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
        searchConditionDiv.getTxtIdoDateRange().setFromValue(null);
        searchConditionDiv.getTxtIdoDateRange().setToValue(null);
        searchConditionDiv.getTxtSearchHihoNo().setValue(RString.EMPTY);
    }

    private void set連絡票検索結果一覧(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().
                getDgJukyushaIdoRenrakuhyoSearchResult().setDataSource(createData(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition()));
    }

    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createData(JukyushaIdoRenrakuhyoSearchConditionDiv searchConditionDiv) {
        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> testDataList;
        testDataList = createTestData();

        return testDataList;
    }

    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createTestData() {
        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> list = new ArrayList<>();
        dgJukyushaIdoRenrakuhyoSearchResult_Row row;

        row = createRow("20130101", "0000000001", "電算　一郎", "20111010");
        list.add(row);
        row = createRow("20130202", "0000000002", "電算　二郎", "20111010");
        list.add(row);
        row = createRow("20140301", "0000000003", "電算　三郎", "20111010");
        list.add(row);
        row = createRow("20140402", "0000000004", "電算　四郎", "20111010");
        list.add(row);
        row = createRow("20140501", "0000000005", "電算　五郎", "20111010");
        list.add(row);
        row = createRow("20140602", "0000000006", "電算　六郎", "20111010");
        list.add(row);

        return list;
    }

    private dgJukyushaIdoRenrakuhyoSearchResult_Row createRow(String 異動日, String 被保番号, String 氏名, String 送付年月) {

        dgJukyushaIdoRenrakuhyoSearchResult_Row row = new dgJukyushaIdoRenrakuhyoSearchResult_Row(
                new Button(), new TextBoxFlexibleDate(), new TextBoxCode(), new TextBox(), new TextBoxFlexibleDate());

        row.getTxtResultIdoDate().setValue(new FlexibleDate(異動日));
        row.getTxtResultHihoNo().setValue(new RString(被保番号));
        row.getTxtResultHihoName().setValue(new RString(氏名));
        row.getTxtResultSendYM().setValue(new FlexibleDate(送付年月));

        return row;
    }
}
