/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuJuminDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuNushiJuminJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面上部の住民の住基と介護の情報のクラスです。
 *
 * @author N8817 久保田 英男
 */
public class KyotakuJuminPanel {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 住民PanelDiv
     * @return 住民PanelDivのResponseData
     */
    public ResponseData<KyotakuJuminDiv> getOnLoadData(KyotakuJuminDiv panel) {
        ResponseData<KyotakuJuminDiv> response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        List<HashMap> ymlData = ymlData("dbc0020000/KyotakuServicePlanIchiranCommonChild.yml");
        
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //高額介護サービス費情報  (被保険者番号～所得段階）
        
        //氏名漢字～個人番号
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtAtenaMeisho().setValue(
        ymlDt.getAsRString("atenaMeisho"));
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtAtenaKanaMeisho().setValue(
        ymlDt.getAsRString("atenaKanMeisho"));
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtSeinengappiYMD().setValue(
        ymlDt.getAsRDate("seinengappiYmd"));
        
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtNenrei().setValue(
        ymlDt.getAsRString("nenrei"));         
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtSeibetsu().setValue(
        ymlDt.getAsRString("seibetsu"));         
        
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtNihonjinGaikokujin().setValue(
        ymlDt.getAsRString("nihonjinGaikokujin"));                
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtJusho().setValue(
        ymlDt.getAsRString("jusho"));        
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtGyoseiku().setValue(
        ymlDt.getAsRString("gyoseiku"));        
        
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtShikibetsuCode().setValue(
        ymlDt.getAsRString("shikibetsuCode"));         
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtYubinNo().setValue(
        ymlDt.getAsYubinNo("yubinNoe"));
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtJuminJotai().setValue(
        ymlDt.getAsRString("juminJotai"));
        
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtSetaiCode().setValue(
        ymlDt.getAsRString("setaiCode"));        
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv1().getAtenaInfo().getTxtKojinHojinCode().setValue(
        ymlDt.getAsRString("kojinHojinCode"));                
        
        
        //資格取得 ～　認定期間
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtHihokenshaNo().setValue(
        ymlDt.getAsRString("hihokenshaNo"));          
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtShutokuYmd().setValue(
        ymlDt.getAsRDate("shotokuYmd"));               
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtShutokuJiyu().setValue(
        ymlDt.getAsRString("shotokuJiyu"));    
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtJutokuTekiyo().setValue(
        ymlDt.getAsRDate("jutokuTekiyo"));          
                      
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtYokaigoJotaiKubun().setValue(
        ymlDt.getAsRString("yokaigojotaiKubun"));
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtShikakuJotai().setValue(
        ymlDt.getAsRString("shikakuJotai"));
        panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtJutokuKaijo().setValue(
        ymlDt.getAsRDate("jutokuKaijo"));          
       
        
       // panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().getTxtNinteiKaishiYmd().
                
                
      //  ymlDt.getAsRDate("niteikikanfrom"));           
       // panel.getKyotakuNushiJuminJoho().getCommonKyotakuJuminChildDiv2().gett
       // ymlDt.getAsRDate("niteikikanto"));
        
        response.data = panel;
        return response;
    }
    
    
        private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }

}
