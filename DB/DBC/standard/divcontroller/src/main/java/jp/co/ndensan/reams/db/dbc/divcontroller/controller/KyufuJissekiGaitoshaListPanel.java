/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchToKyufujissekiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;



/**
 *
 * @author n8223
 * @author n8223 ymldata, SearchToKyufujissekiPanelDiv 追加　2014.06.20 park
 */
public class KyufuJissekiGaitoshaListPanel {

    final static String MessAge  ="該当するデータが0件です";
    /**
     * 介護給付費過誤申立書登録 給付実積該当一覧の内容をセットします。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @param srchpanel
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSearch(KyufuJissekiGaitoshaListPanelDiv panel, SearchToKyufujissekiPanelDiv srchpanel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        ///ユーザが給付実積検索条件を入力されたことをチェックする
        Boolean status = setSearchToKyufujisseki(panel, srchpanel);

        if (status.equals(true)) {
            
            //給付実積該当一覧の内容を設定する。
            setKyufuJissekiGaitoshaList(panel,srchpanel);
            
        }  
        
        response.data = panel;
        return response;
    }

    /*
     * 介護給付費過誤申立書登録 給付実積該当一覧のデータを設定する。
     */
    private void setKyufuJissekiGaitoshaList(KyufuJissekiGaitoshaListPanelDiv panel, SearchToKyufujissekiPanelDiv srchpanel) {
        List<dgHihokenshaSearchGaitosha_Row> arraydata = createRowKyufuJissekiGaitoshaTestData(srchpanel);

        DataGrid<dgHihokenshaSearchGaitosha_Row> grid = panel.getDgHihokenshaSearchGaitosha();
        grid.setDataSource(arraydata);
    }

    /*
     * 介護給付費過誤申立書登録 (YMLDATA)給付実積該当一覧のデータを設定する。
     */
    private List<dgHihokenshaSearchGaitosha_Row> createRowKyufuJissekiGaitoshaTestData(SearchToKyufujissekiPanelDiv srchpanel) {
        List<dgHihokenshaSearchGaitosha_Row> arrayData = new ArrayList<>();
        List<HashMap> ymlData = ymlData();
        RString hihno;
        RString hihnoName;
        
        //被保険番号：
        if(srchpanel.getTxtHihoNo().getValue() == null || "".equals(srchpanel.getTxtHihoNo().getValue().toString())) {
             hihno = RString.EMPTY;
         } else {
             hihno=  srchpanel.getTxtHihoNo().getValue();
         }
        //被保険者名
         if( srchpanel.getTxtHihoName().getValue() == null ||  "".equals(srchpanel.getTxtHihoName().getValue().toString())) {
             hihnoName = RString.EMPTY;
         } else {
             hihnoName= srchpanel.getTxtHihoName().getValue();     
         }
         
        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);
           
            arrayData.add(createRowKyufuJissekiGaitoshaListData(
                    srchpanel.getTxtJigyoshaNo().getValue(),
                    srchpanel.getTxtJigyoshaName().getValue(),
                    hihno,
                    hihnoName,
//                    srchpanel.getTxtHihoNo().getValue(),
//                    srchpanel.getTxtHihoName().getValue(),
                    ymlDt.getAsRString("kagoForm"),
                    srchpanel.getTxtTeikyoYMRange().getFromValue(),
                    ymlDt.getAsRString("kyufuJissekiSakuseiKubun"),
                    ymlDt.getAsRString("kyufuKubun"),
                    ymlDt.getAsRString("shinsaYM")
            ));

        }

        return arrayData;
    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
    private dgHihokenshaSearchGaitosha_Row createRowKyufuJissekiGaitoshaListData(
            RString jigyoshaNo,
            RString jigyoshaName,
            RString hihoNo,
            RString hihoName,
            RString kagoForm,
            RDate teikyoYM,
            RString kyufuJissekiSakuseiKubun,
            RString kyufuKubun,
            RString shinsaYM
    ) {

        dgHihokenshaSearchGaitosha_Row rowKyufuJissekiGaitoshaListData;
        rowKyufuJissekiGaitoshaListData = new dgHihokenshaSearchGaitosha_Row(
                new Button(),
                Boolean.FALSE,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        rowKyufuJissekiGaitoshaListData.setTxtJigyoshaNo(jigyoshaNo);
        rowKyufuJissekiGaitoshaListData.setTxtJigyoshaName(jigyoshaName);
        rowKyufuJissekiGaitoshaListData.setTxtHihoNo(hihoNo);
        rowKyufuJissekiGaitoshaListData.setTxtHihoName(hihoName);
        rowKyufuJissekiGaitoshaListData.setTxtKagoForm(kagoForm);
        rowKyufuJissekiGaitoshaListData.setTxtTeikyoYM(setWareki(teikyoYM.toDateString()).substring(0, 6)); 
        rowKyufuJissekiGaitoshaListData.setTxtKyufuJissekiSakuseiKubun(kyufuJissekiSakuseiKubun);
        rowKyufuJissekiGaitoshaListData.setTxtKyufuKubun(kyufuKubun);
        rowKyufuJissekiGaitoshaListData.setTxtShinsaYM(shinsaYM);

        return rowKyufuJissekiGaitoshaListData;

    }
    
   
    /**
     * 介護給付費過誤申立書登録 過誤申立書情報を確定するボタンを押下後、申立者作成の内容をチェック有り。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSettle(KyufuJissekiGaitoshaListPanelDiv panel ,SearchToKyufujissekiPanelDiv srchpanel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        dgHihokenshaSearchGaitosha_Row clickRow = panel.getDgHihokenshaSearchGaitosha().getClickedItem();
        //チェックを設定する。
        clickRow.setChkCreateMoshitatesho(Boolean.TRUE);
        
        //2014.07.02 朴　追加  （保存ボタン）活性化する。
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("cbtSaveElement1"), false);
    
        response.data = panel;
        return response;
    }
    
     /**
     * 介護給付費過誤申立書登録 過誤申立書情報をやめるボタンを押下後、申立者作成の内容をチェックなし。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnCancel(KyufuJissekiGaitoshaListPanelDiv panel ,SearchToKyufujissekiPanelDiv srchpanel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        dgHihokenshaSearchGaitosha_Row clickRow = panel.getDgHihokenshaSearchGaitosha().getClickedItem();
        
        clickRow.setChkCreateMoshitatesho(Boolean.FALSE);
        
        response.data = panel;
        return response;
    }
    
    
    //給付実績条件が入力されたことをチェックするメソッド
     private Boolean setSearchToKyufujisseki(KyufuJissekiGaitoshaListPanelDiv panel ,SearchToKyufujissekiPanelDiv srchpanel) {
         boolean status = true;
         ArrayList<RString> searchToKyufujissekiData = new ArrayList<>();

         //入力項目が空白でないかことを確認する。
         //事業者コード ひ
         searchToKyufujissekiData.add(srchpanel.getTxtJigyoshaNo().getValue());
         //事業者名 2014.6.24  削除
         //searchToKyufujissekiData.add(srchpanel.getTxtJigyoshaName().getValue());
         //被保険番号
         //searchToKyufujissekiData.add(srchpanel.getTxtHihoNo().getValue());
         //被保険名　2014.6.24  削除
         //searchToKyufujissekiData.add(srchpanel.getTxtHihoName().getValue());
         //提供年月（From~）

          RDate TeikyoYMRange =  srchpanel.getTxtTeikyoYMRange().getFromValue();
         if(TeikyoYMRange == null){    
                 status = false;
                 return status;
         }
         
         for (int i = 0; i < searchToKyufujissekiData.size(); i++) {
             RString rString = searchToKyufujissekiData.get(i);
             
             if ((null == rString) || (rString.isEmpty())) {
                 status = false;
                 return status;
             }  
         }
         return status;
    }
    
         
      /**
     * 介護給付費過誤申立書登録 過誤申立情報の入力をやめるボタンを押下後、申立日・申立事由を空白しでもエラーを無視するように設定する
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnCancel(KyufuJissekiGaitoshaListPanelDiv panel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        
        response.data = panel;
        return response;
    }        
            
            
     
    private RString setWareki(RString wareki) {
         FlexibleDate warekiYmd = new FlexibleDate(wareki);
        return warekiYmd.wareki().toDateString();
    }
    
   
    private List<HashMap> ymlData() {
        return YamlLoader.DBC.loadAsList(new RString("dbc1400011/KagoMoshitateKyufuJissekiGaitoshaList.yml"));
    }



}
