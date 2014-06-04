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
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8223
 */
public class JukyushaIdoRenrakuhyoHenkoSearchResultListPanel {
    
    
    
      /**
     * 受給者異動連絡票変更登録　修正状況を設定する。
     *
     * @param panel JukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     * @return PanelDivのResponseData
     */ 
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> onClick_btnUpdate(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> response = new ResponseData<>();

        panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().setRowState(RowState.Modified);

        response.data = panel;
        return response;

    }
   

    /**
     * 受給者異動連絡票変更登録　対象者一覧の内容をセットします。
     *
     * @param panel JukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     * @return PanelDivのResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> onClick_btnSearch(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv> response = new ResponseData<>();

      
        setJukyushaIdoRenrakuhyoHenkoSearchResult(panel);

        response.data = panel;
        return response;

    }

    /*
     * 受給者異動連絡票変更登録 対象者一覧の内容を設定する。
     */
    private void setJukyushaIdoRenrakuhyoHenkoSearchResult(JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel) {

        List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> arraydata = createRowJukyushaIdoRenrakuhyoHenkoSearchResultTestData();
        DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> grid = panel.getDgJukyushaIdoRenrakuhyoHenkoSearchResult();
        
        
        grid.setDataSource(arraydata);

    }

    private List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> createRowJukyushaIdoRenrakuhyoHenkoSearchResultTestData() {
        List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> arrayData = new ArrayList<>();

        List<HashMap> ymlData = ymlData();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            hashMap(hashMap, arrayData);
        }

        return arrayData;
    }

    private void hashMap(HashMap hashMap, List<dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row> arrayData) {
        //TO DO DataGrid
        //異動日
        String resultIdoDate = hashMap.get("resultIdoDate").toString();
        //被保番号
        String resultHihoNo = hashMap.get("resultHihoNo").toString();
        //カナ氏名 
        String resultHihoName = hashMap.get("resultHihoName").toString();
        //送付年月
        String renrakuhyoSendYM  = hashMap.get("renrakuhyoSendYM").toString();
        //削除データ

        dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row item;

        item = createRowJukyushaIdoRenrakuhyoHenkoSearchListData(
                resultIdoDate, 
                resultHihoNo,
                resultHihoName,
                renrakuhyoSendYM
        );
        arrayData.add(item);
    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row createRowJukyushaIdoRenrakuhyoHenkoSearchListData(
            String 異動日,
            String 被保番号,
            String カナ氏名,
            String 送付年月
    ) {

        dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row rowJukyushaIdoRenrakuhyoHenkoSearchResulListData;
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData = new dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row(
                new Button(),
                new Button(),
                new TextBoxDate(),
                new TextBoxCode(),
                new TextBox(),
                new TextBoxDate(),
                new Boolean(false)
        );

        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultIdoDate().setValue(new RDate(異動日));
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultHihoNo().setValue(new RString(被保番号));
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultHihoName().setValue(new RString(カナ氏名));
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultSendYM().setValue(new RDate(送付年月));
        
        //入力不可
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultIdoDate().setReadOnly(true);
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultHihoNo().setReadOnly(true);
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultHihoName().setReadOnly(true);
        rowJukyushaIdoRenrakuhyoHenkoSearchResulListData.getTxtResultSendYM().setReadOnly(true);

        
        return rowJukyushaIdoRenrakuhyoHenkoSearchResulListData;

    }
    
  

    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0220011/JukyushaIdoRenrakuhyoHenkoSearchResultList.yml"));

    }

}
