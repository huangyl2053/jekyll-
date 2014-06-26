/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.ValidationErrorException;


/**
 *
 * @author n8223　
 * @author n8223 ymddata,　共有DIV適用　2014.06.20 
 * @author n8223 
 * 
 */
public class KagoMoshitatePanel {
    
     /**
     * 介護給付費過誤申立書登録 給付実積該当者一覧で、選択した内容もとに、過誤申立書情報の内容を設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @param gaitoshaListpanel
     * @return   
     */
    public ResponseData<KagoMoshitatePanelDiv> onClick_btnSelect(KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListpanel) {
        ResponseData<KagoMoshitatePanelDiv> response = new ResponseData<>();
        
        
//       panel.getKagoMoshitateInfo().getTxtMoshitateDate().setRequired(true);
//       panel.getKagoMoshitateInfo().getDdlKagoMoshitateRiyu().setRequired(true); 
       
       //住民情報・世帯員情報の内容を設定する。
        setKagoMoshitateHihokensha(panel);       
       // 過誤申立書情報の内容を設定する。
        setKagoMoshitate(panel, gaitoshaListpanel);
        
        response.data = panel;
        return response;

    }

    /*
    * 住民情報(世帯主)
    * 住民情報(世帯員)
    */
     private void setKagoMoshitateHihokensha(KagoMoshitatePanelDiv panel) {
         
        List<HashMap> ymlData = ymlData("dbc1400011/KagoMoshitateHihokensha.yml");
        
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);
                      
        //氏名漢字～個人番号　世帯主
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtAtenaMeisho().setValue(
        ymlDt.getAsRString("atenaMeisho"));
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtAtenaKanaMeisho().setValue(
        ymlDt.getAsRString("atenaKanMeisho"));
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtSeinengappiYMD().setValue(
        ymlDt.getAsRDate("seinengappiYmd"));
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtNenrei().setValue(
        ymlDt.getAsRString("nenrei"));         
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtSeibetsu().setValue(
        ymlDt.getAsRString("seibetsu"));         
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtNihonjinGaikokujin().setValue(
        ymlDt.getAsRString("nihonjinGaikokujin"));           
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtYubinNo().setValue(
        ymlDt.getAsYubinNo("yubinNo"));           
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtJusho().setValue(
        ymlDt.getAsRString("jusho"));        
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtGyoseiku().setValue(
        ymlDt.getAsRString("gyoseiku"));        
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtShikibetsuCode().setValue(
        ymlDt.getAsRString("shikibetsuCode"));         
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtYubinNo().setValue(
        ymlDt.getAsYubinNo("yubinNo"));
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtJuminJotai().setValue(
        ymlDt.getAsRString("juminJotai"));
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtSetaiCode().setValue(
        ymlDt.getAsRString("setaiCode"));        
        panel.getCommonKaigpAtenainfoChildDiv1().getAtenaInfo().getTxtKojinHojinCode().setValue(
        ymlDt.getAsRString("kojinHojinCode"));                
        
        
        //資格取得 ～　認定期間　世帯員(異動情報）
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtHihokenshaNo().setValue(
        ymlDt.getAsRString("hihokenshaNo"));          
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtShutokuYmd().setValue(
        ymlDt.getAsRDate("shotokuYmd"));               
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtShutokuJiyu().setValue(
        ymlDt.getAsRString("shotokuJiyu"));    
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtJutokuTekiyo().setValue(
        ymlDt.getAsRDate("jutokuTekiyo"));          
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtYokaigoJotaiKubun().setValue(
        ymlDt.getAsRString("yokaigojotaiKubun"));
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtShikakuJotai().setValue(
        ymlDt.getAsRString("shikakuJotai"));
        panel.getCommonKaigoshikakuKihonChildDiv2().getTxtJutokuKaijo().setValue(
        ymlDt.getAsRDate("jutokuKaijo"));  
         
     }
    

      /**
     * 介護給付費過誤申立書登録  過誤申立書情報の内容を設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @param gaitoshaListpanel　KyufuJissekiGaitoshaListPanelDiv
     * @return 
     */
    private void setKagoMoshitate(KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListpanel) {
        
        
        //入力した情報・選択された情報をもとに過誤申立書情報の内容を設定する。
        //事業者NO
         panel.getKagoMoshitateInfo().getTxtJigyoshaNo().
                 setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaNo());
        
        //事業者NANE 2014.06.25 情報はない場合がある　修正
        if (!gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaName().equals("")){
         panel.getKagoMoshitateInfo().getTxtJigyoshaName().
                setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaName());
        }
        //提供年月
         panel.getKagoMoshitateInfo().getTxtTeikyoYM().
                 setValue(new RDate(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtTeikyoYM().toString()));
        
         //申立者区分
        panel.getKagoMoshitateInfo().getTxtMoshitateshaKubun().
                setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtKyufuJissekiSakuseiKubun());
        
         //様式
        panel.getKagoMoshitateInfo().getTxtKagoForm().
                setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtKagoForm());
        
        
        List<HashMap> ymlData = ymlData("dbc1400011/KagoMoshitatePanel.yml");
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);
        
        //送付年月
        //証記載保険者番号　南魚沼市 　152264 
         panel.getKagoMoshitateInfo().getTxtShokisaiHokenshaNo().setValue(ymlDt.getAsRString("shokisaiHokenshaNo"));
         //証記載保険者名
         panel.getKagoMoshitateInfo().getTxtShokisaiHokenshaName().setValue(ymlDt.getAsRString("shokisaiHokenshaName"));
         //申立日 2014.06.24 修正　空白
         //panel.getKagoMoshitateInfo().getTxtMoshitateDate().setValue(ymlDt.getAsRDate("moshitateDate"));
         panel.getKagoMoshitateInfo().getTxtMoshitateDate().clearValue();
         //申立事由 2014.06.24 追加　空白 code00
         panel.getKagoMoshitateInfo().getDdlKagoMoshitateRiyu().setSelectedItem(new RString("code00"));
         
        
    }
    
    
//    public ResponseData<KagoMoshitatePanelDiv> onClick_btnCancel(KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListpanel) {
//        ResponseData<KagoMoshitatePanelDiv> response = new ResponseData<>();
//         
//         panel.getKagoMoshitateInfo().getTxtMoshitateDate().setRequired(false);
//         panel.getKagoMoshitateInfo().getDdlKagoMoshitateRiyu().setRequired(false);
//         
//         response.data = panel;
//         
//         response.getValidateErrorMessage().clear();
//         
//      
//         return response;
//        
//    }
    
    
     private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }
    
}
