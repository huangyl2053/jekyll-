/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0220011.JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8223
 */
public class JukyushaIdoRenrakuhyoHenkoTorokuPanel {

    /**
     * 受給者異動連絡票変更登録 受給者異動連絡票情報をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv> onClick_btnModify(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv panel, JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel1) {
        ResponseData<JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv> response = new ResponseData<>();

        // 受給者異動連絡票 要介護認定 支給限度基準額
        setJukyushaIdoRenrakuhyoKihonJohoData(panel, panel1);

        response.data = panel;
        return response;

    }

    // 受給者異動連絡票
    private void setJukyushaIdoRenrakuhyoKihonJohoData(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv panel, JukyushaIdoRenrakuhyoHenkoSearchResultListPanelDiv panel1) {

        List<HashMap> ymlData = ymlData();
        
        //JukyushaIdoRenrakuhyoKihonJoho 受給者異動連絡票 
        //異動日
       // panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultIdoDate().getValue();
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoIdoDate()
                .setValue(new FlexibleDate(
                        panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultIdoDate().getValue().toString()));
        //被保番号
       // panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultHihoNo().getValue();
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoHihoNo()
                .setValue(new RString(
                        panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultHihoNo().getValue().toString()));
       //カナ氏名
       // panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultHihoName().getValue();
         panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoHihoName()
                  .setValue(new RString(
                       panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultHihoName().getValue().toString()));
        
        //送付年月
        //panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultSendYM().getValue();
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoSendYM()
                .setValue(new FlexibleDate(
                                panel1.getDgJukyushaIdoRenrakuhyoHenkoSearchResult().getClickedItem().getTxtResultSendYM().getValue().toString()));
        // 性別
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getRadHihoSex().setSelectedItem(
                new RString(ymlData.get(0).get("radHihoSex").toString()));  
        
        //　資格取得年月日
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtShikakuShutokuDate()
                .setValue(new FlexibleDate(ymlData.get(0).get("shikakuShutokuDate").toString()));
        // 生年月日
        panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho().getTxtHihoBirthday()
                .setValue(new FlexibleDate(ymlData.get(0).get("hihoBirthday").toString()));
        // 保険者番号
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
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0220011/JukyushaIdoRenrakuhyoHenkoToroku.yml"));
    }

}
