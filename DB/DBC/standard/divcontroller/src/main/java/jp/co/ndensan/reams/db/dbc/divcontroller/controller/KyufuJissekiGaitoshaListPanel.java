/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8223
 */
public class KyufuJissekiGaitoshaListPanel {

    /**
     * 介護給付費過誤申立書登録 給付実積該当一覧の内容をセットします。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @param panel1
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSearch(KyufuJissekiGaitoshaListPanelDiv panel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        setKyufuJissekiGaitoshaList(panel);

        response.data = panel;
        return response;
    }

    /*
     * 介護給付費過誤申立書登録 給付実積該当一覧のデータを設定する。
     */
    private void setKyufuJissekiGaitoshaList(KyufuJissekiGaitoshaListPanelDiv panel) {
        List<dgHihokenshaSearchGaitosha_Row> arraydata = createRowKyufuJissekiGaitoshaTestData();

        DataGrid<dgHihokenshaSearchGaitosha_Row> grid = panel.getDgHihokenshaSearchGaitosha();
        grid.setDataSource(arraydata);
    }

    /*
     * 介護給付費過誤申立書登録 (YMLDATA)給付実積該当一覧のデータを設定する。
     */
    private List<dgHihokenshaSearchGaitosha_Row> createRowKyufuJissekiGaitoshaTestData() {
        List<dgHihokenshaSearchGaitosha_Row> arrayData = new ArrayList<>();

        List<HashMap> ymlData = ymlData();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            hashMap(hashMap, arrayData);
        }

        return arrayData;
    }

    /*
     * 共通内容を設定する
     */
    private void hashMap(HashMap hashMap, List<dgHihokenshaSearchGaitosha_Row> arrayData) {

        //事業者番号    
        String jigyoshaNo = hashMap.get("jigyoshaNo").toString();
        //事業者名        
        String jigyoshaName = hashMap.get("jigyoshaName").toString();
        //被保番号
        String hihoNo = hashMap.get("hihoNo").toString();
        //氏名         
        String hihoName = hashMap.get("hihoName").toString();
        //様式        
        String kagoForm = hashMap.get("kagoForm").toString();
        //提供年月
        String teikyoYM = hashMap.get("teikyoYM").toString();
        //給付実績作成区分        
        String kyufuJissekiSakuseiKubun = hashMap.get("kyufuJissekiSakuseiKubun").toString();
        //給付区分        
        String kyufuKubun = hashMap.get("kyufuKubun").toString();
        //審査年月        
        String shinsaYM = hashMap.get("shinsaYM").toString();

        dgHihokenshaSearchGaitosha_Row item;

        item = createRowKyufuJissekiGaitoshaListData(
                jigyoshaNo,
                jigyoshaName,
                hihoNo,
                hihoName,
                kagoForm,
                teikyoYM,
                kyufuJissekiSakuseiKubun,
                kyufuKubun,
                shinsaYM
        );
        arrayData.add(item);
        

    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgHihokenshaSearchGaitosha_Row createRowKyufuJissekiGaitoshaListData(
            String 事業者番号,
            String 事業者名,
            String 被保番号,
            String 氏名,
            String 様式,
            String 提供年月,
            String 給付実績作成区分,
            String 給付区分,
            String 審査年月
    ) {

        dgHihokenshaSearchGaitosha_Row rowKyufuJissekiGaitoshaListData;
        rowKyufuJissekiGaitoshaListData = new dgHihokenshaSearchGaitosha_Row(
                new Boolean(false),
                new Button(),
                new TextBoxCode(),
                RString.EMPTY,
                new TextBoxCode(),
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxDate(),
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxDate()
        );

        rowKyufuJissekiGaitoshaListData.getTxtJigyoshaNo().setValue(new RString(事業者番号));
        rowKyufuJissekiGaitoshaListData.setTxtJigyoshaName(new RString(事業者名));
        rowKyufuJissekiGaitoshaListData.getTxtHihoNo().setValue(new RString(被保番号));
        rowKyufuJissekiGaitoshaListData.setTxtHihoName(new RString(氏名));
        rowKyufuJissekiGaitoshaListData.setTxtKagoForm(new RString(様式));
        rowKyufuJissekiGaitoshaListData.getTxtTeikyoYM().setValue(new RDate(提供年月));
        rowKyufuJissekiGaitoshaListData.setTxtKyufuJissekiSakuseiKubun(new RString(給付実績作成区分));
        rowKyufuJissekiGaitoshaListData.setTxtKyufuKubun(new RString(給付区分));
        rowKyufuJissekiGaitoshaListData.getTxtShinsaYM().setValue(new RDate(審査年月));

        return rowKyufuJissekiGaitoshaListData;

    }
    
    
        public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSelect(KyufuJissekiGaitoshaListPanelDiv panel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        
          //事業者NO
         
//        String jigyoshaNo = 
//                 panel.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtJigyoshaNo().getValue().toString();
//        ViewStateHolder.put("事業者NO", jigyoshaNo);
//        
//         System.out.println("111111  ++++++++++++" + jigyoshaNo);
                 
                 
        
//         //事業者NANE
//        
//                 panel.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtJigyoshaNo().getValue().toString();
//         
//         //申立者区分
//        
//                panel.getDgHihokenshaSearchGaitosha().getClickedItem().
//               getTxtKyufuJissekiSakuseiKubun().toString();
//        
//         //様式
//       
//                panel.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtKagoForm().toString();
//        
        
        
        response.data = panel;
        return response;
    }
            
   

    /**
     * 介護給付費過誤申立書登録 過誤申立書情報を確定するボタンを押下後、申立者作成の内容をチェック有り。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @param panel1
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSettle(KyufuJissekiGaitoshaListPanelDiv panel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        panel.getDgHihokenshaSearchGaitosha().getClickedItem().setChkCreateMoshitatesho(Boolean.TRUE);

        response.data = panel;
        return response;
    }

    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc1400011/KagoMoshitateKyufuJissekiGaitoshaList.yml"));
    }

}
