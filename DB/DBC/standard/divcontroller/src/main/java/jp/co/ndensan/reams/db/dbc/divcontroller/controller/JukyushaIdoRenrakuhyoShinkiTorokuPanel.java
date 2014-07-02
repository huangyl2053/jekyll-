/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n8223
 */
public class JukyushaIdoRenrakuhyoShinkiTorokuPanel {

    /**
     * 受給者異動連絡票新規登録 受給者異動連絡票情報をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv> onClick_btnToDecide(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv panel, SearchHihokenshaDiv panel1) {
        ResponseData<JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv> response = new ResponseData<>();

        // 受給者異動連絡票 要介護認定 支給限度基準額
        setJukyushaIdoRenrakuhyoKihonJohoData(panel, panel1);

        response.data = panel;
        return response;

    }

    // 受給者異動連絡票
    private void setJukyushaIdoRenrakuhyoKihonJohoData(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv panel, SearchHihokenshaDiv panel1) {

        List<HashMap> ymlData = ymlData();

        //JukyushaIdoRenrakuhyoKihonJoho 受給者異動連絡票 
        panel1.getSearchResultOfHihokensha().getDgSearchResult().getClickedItem().getHihokenshaKubun();
        panel1.getSearchResultOfHihokensha().getDgSearchResult().getClickedItem().getKanaShimsei();
        panel1.getSearchResultOfHihokensha().getDgSearchResult().getClickedItem().getGender();
        
        if(panel1.getSearchResultOfHihokensha().getDgSearchResult().getClickedItem().getShimei().equals("男")) {
            panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getRadHihoSex().setSelectedItem(new RString("man"));
        } else {
            panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getRadHihoSex().setSelectedItem(new RString("woman"));  
        }

        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoIdoDate()
                .setValue(new FlexibleDate(ymlData.get(0).get("renrakuhyoIdoDate").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoHihoNo()
                .setValue(new RString(panel1.getSearchResultOfHihokensha().getDgSearchResult().getClickedItem().getHihokenshaNo().toString()));       
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuDate()
                .setValue(new FlexibleDate(ymlData.get(0).get("shikakuShutokuDate").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoHihoName()
                .setValue(new RString(panel1.getSearchResultOfHihokensha().getDgSearchResult().getClickedItem().getShimeiAndKanaShimsei().toString()));
        
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtHihoBirthday()
                .setValue(new FlexibleDate(ymlData.get(0).get("hihoBirthday").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtShokisaiHokenshaNo()
                .setValue(new RString(ymlData.get(0).get("shokisaiHokenshaNo").toString()));

        //JukyushaIdoRenrakuhyoYokaigonintei 要介護認定
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().getTxtNinteiDateRange()
                .setFromValue(new RDate(ymlData.get(1).get("ninteiDateRangefromPlaceholder").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei().getTxtNinteiDateRange()
                .setToValue(new RDate(ymlData.get(1).get("ninteiDateRangetoPlaceholder").toString()));


        //KyuHomonTsushoShikyuGendoKijungaku 支給限度基準額
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuHomonTsushoShikyuGendoKijungaku()
                .setValue(new Decimal(ymlData.get(2).get("kyuHomonTsushoShikyuGendoKijungaku").toString()));
        
        
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuHomonTsushoKanriTekiyoDateRange()
                .setFromValue(new RDate(ymlData.get(2).get("kyuHomonTsushoKanriTekiyoDateRangefromPlaceholder").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuHomonTsushoKanriTekiyoDateRange()
                .setToValue(new RDate(ymlData.get(2).get("kyuHomonTsushoKanriTekiyoDateRangetoPlaceholder").toString()));

        
       //JukyushaIdoRenrakuhyoKyotakuServicePlan 居宅サービス計画
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().getTxtShienJigyoshaNo()
                .setValue(new RString(ymlData.get(3).get("shienJigyoshaNo").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().getTxtShienJigyoshaName()
                .setValue(new RString(ymlData.get(3).get("shienJigyoshaName").toString()));
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan().getTxtKyotakuServicePlanTekiyoDateRange().
                setFromValue(new RDate(ymlData.get(3).get("kyotakuServicePlanTekiyoDateRangefromPlaceholder").toString()));
                
    }

    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("JukyushaIdoRenrakuhyoYokaigoninteiRojinHoken.yml"));
    }

}
