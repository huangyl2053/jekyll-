/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8223
 */
public class KagoMoshitatePanel {
    
     /**
     * 介護給付費過誤申立書登録 給付実積該当者一覧で、選択した内容もとに、過誤申立書情報の内容を設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @param panel1 KyufuJissekiGaitoshaListPanelDiv
     * @return   
     */
    public ResponseData<KagoMoshitatePanelDiv> onClick_btnSelect(KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv panel1) {
        ResponseData<KagoMoshitatePanelDiv> response = new ResponseData<>();
        
       // 過誤申立書情報の内容を設定する。
        setKagoMoshitate(panel, panel1);
        
        response.data = panel;
        return response;

    }


      /**
     * 介護給付費過誤申立書登録  過誤申立書情報の内容を設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @param panel1　KyufuJissekiGaitoshaListPanelDiv
     * @return 
     */
    private void setKagoMoshitate(KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv panel1) {
        
        
        
//        RString jigyoshaNo = (RString) ViewStateHolder.get("事業者NO", RString.class);
//        System.out.println("22222 ++++++++++++" + jigyoshaNo);
//        
//        
//                  //事業者NO
//         panel.getKagoMoshitateInfo().getTxtJigyoshaNo().setValue(new RString(
//                 jigyoshaNo.toString()));
////         ));
        
          //事業者NO
         panel.getKagoMoshitateInfo().getTxtJigyoshaNo().setValue(new RString(
                 panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
                getTxtJigyoshaNo().getValue().toString()
         ));
        
         //事業者NANE
        panel.getKagoMoshitateInfo().getTxtJigyoshaName().setValue(new RString(
                 panel1.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaName().toString()
         ));
      
        //提供年月
         panel.getKagoMoshitateInfo().getTxtTeikyoYM().setValue(new RDate(
                panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
                getTxtTeikyoYM().getValue().toString()
         ));
        
        
         //申立者区分
        panel.getKagoMoshitateInfo().getTxtMoshitateshaKubun().setValue(new RString(
                panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
               getTxtKyufuJissekiSakuseiKubun().toString()
        ));
        
         //様式
        panel.getKagoMoshitateInfo().getTxtKagoForm().setValue(new RString(
                panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
                getTxtKagoForm().toString()
        ));
        
        
         List<HashMap> ymlData = ymlData();
        
        //送付年月
       //  panel.getKagoMoshitateInfo().getTxtSendYM().setValue(new RDate(
       //          ymlData.get(0).get("sendYM").toString()));
        //証記載保険者番号　南魚沼市 　152264 
         panel.getKagoMoshitateInfo().getTxtShokisaiHokenshaNo().setValue(new RString(
                 ymlData.get(0).get("shokisaiHokenshaNo").toString()));
         //証記載保険者名
         panel.getKagoMoshitateInfo().getTxtShokisaiHokenshaName().setValue(new RString(
                 ymlData.get(0).get("shokisaiHokenshaName").toString()));
        
         //申立日
         panel.getKagoMoshitateInfo().getTxtMoshitateDate().setValue(new RDate(
                 ymlData.get(0).get("moshitateDate").toString()));

        
        //事業者NO
//        panel1.getDgHihokenshaSearchGaitosha().ge0tClickedItem().
//                getTxtJigyoshaNo().getValue().toString();
//        //事業者NANE
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtJigyoshaName().toString();
//
//        //申立者区分
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//               getTxtKyufuJissekiSakuseiKubun().toString();
//        
//        //提供年月
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtTeikyoYM().toString();
//        //様式
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtKagoForm().toString();
//        
        
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtHihoNo().getValue();
//        
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtHihoName().toString();        
//        
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtKyufuKubun().toString();
//        
//        panel1.getDgHihokenshaSearchGaitosha().getClickedItem().
//                getTxtShinsaYM().toString();
        
        
    }
    
     private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc1400011/KagoMoshitatePanel.yml"));
    }

    
}
