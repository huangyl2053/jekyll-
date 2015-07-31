/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.JukyushaIdoRenrakuhyoSearchConditionDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.JukyushaIdoRenrakuhyoSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0040011.dgJukyushaIdoRenrakuhyoSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 受給者異動連絡票情報照会の検索パネルです。
 *
 * @author N3317 塚田 萌
 */
public class JukyushaIdoRenrakuhyoSearchPanel {

    final static String IsDeletedDataSearch = "isDeletedDataSearch";
    final static String DeleteFlg = "削除";

    /**
     * 検索パネルが読み込まれた時は、検索項目をEMPTYで初期化し、検索結果一覧を閉じた状態にします。</br>
     * 異動日の初期値をあらかじめセットしておきます
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData onLoad(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(false);
        clearSearchCondtion(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition());

        return ResponseData.of(searchPanel).respond();
    }

    /**
     * 検索ボタンが押された時は、検索結果一覧を開き、検索結果を表示します。
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData onClick_btnSearch(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(true);
        setJukyushaIdoRenrakuhyoSearchResultList(searchPanel);

        return ResponseData.of(searchPanel).respond();
    }

    /**
     * 条件をクリアするボタンが押された時は検索条件をEMPTYでクリアします。
     *
     * @param searchPanel
     * @return ResponseData
     */
    public ResponseData onClick_btnClearSearchCondition(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().setIsOpen(false);
        clearSearchCondtion(searchPanel.getJukyushaIdoRenrakuhyoSearchCondition());

        return ResponseData.of(searchPanel).respond();
    }

    /**
     * データグリッドの詳細ボタン押下時の処理です。
     *
     * @param searchPanel
     * @return
     */
    public ResponseData onClick_dgDetail_show(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        return ResponseData.of(searchPanel).respond();
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

    //状態遷移させるために空行を作る
    private List<dgJukyushaIdoRenrakuhyoSearchResult_Row> createTestData(JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        List<dgJukyushaIdoRenrakuhyoSearchResult_Row> list = new ArrayList<>();
        list.add(createRow());

        return list;
    }

    private dgJukyushaIdoRenrakuhyoSearchResult_Row createRow() {

        dgJukyushaIdoRenrakuhyoSearchResult_Row rowJukyushaIdoRenrakuhyoSearchResultList;
        rowJukyushaIdoRenrakuhyoSearchResultList = new dgJukyushaIdoRenrakuhyoSearchResult_Row();

//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultIdoDate(setWareki(resultIdoDate));
//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtRenrakuhyoIdoKubun(renrakuhyoIdoKubun);
//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtDdlIdoJiyu(ddlIdoJiyu);
//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultHihoNo(resultHihoNo);
//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultHihoName(resultHihoName);
//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtResultSendYM(setWareki(resultSendYM).substring(0, 6));
//        rowJukyushaIdoRenrakuhyoSearchResultList.setTxtDeleteFlg(deleteFlg);
        return rowJukyushaIdoRenrakuhyoSearchResultList;
    }

    private RString setWareki(RString wareki) {
        FlexibleDate warekiYmd = new FlexibleDate(wareki);
        return warekiYmd.wareki().toDateString();
    }
}
