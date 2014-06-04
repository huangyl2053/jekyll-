/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0220011.JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223
 */          
public class JukyushaIdoRenrakuhyoHenkoSearchConditionPanel {
 
        /**
     * 受給者異動連絡票変更登録　対象者検索条件の内容をセットします。
     *
     * @param panel JukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     * @return PanelDivのResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> onLoad(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> response = new ResponseData<>();
        
     setJukyushaIdoRenrakuhyoHenkoSearchCondition(panel);
   
    response.data = panel;
    return response;
   }
 
    /*
     * 受給者異動連絡票変更登録 対象者検索条件の内容を設定する。
     */
    private void setJukyushaIdoRenrakuhyoHenkoSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
    
     List<HashMap> ymlData = ymlData();
     
     //異動日
      String idoDateRangefromPlaceHolder = ymlData.get(0).get("idoDateRangefromPlaceHolder").toString();  
      String idoDateRangetoPlaceHolder = ymlData.get(0).get("idoDateRangetoPlaceHolder").toString();  
     
     //被保番号
      String searchHihoNo = ymlData.get(0).get("searchHihoNo").toString();  
      
     //削除データ検索
     //chkIsSearchDeletedData 
     
      panel.getTxtIdoDateRange().setFromValue(new RDate(idoDateRangefromPlaceHolder));
      panel.getTxtIdoDateRange().setToValue(new RDate(idoDateRangetoPlaceHolder));
      panel.getTxtSearchHihoNo().setValue(new RString(searchHihoNo));
 
      
    }
    
            /**
     * 受給者異動連絡票変更登録　対象者検索条件の内容をセットします。
     *
     * @param panel JukyushaIdoRenrakuhyoHenkoSearchConditionPanel
     * @return PanelDivのResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> onClick_btnClearSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> response = new ResponseData<>();
        
     setClearSearchCondition(panel);
   
    response.data = panel;
    return response;
   }
    
            /**
     * 受給者異動連絡票変更登録　条件をクリアする。
     *
     * @param panel JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv
     * @return PanelDivのResponseData
     */
    private void setClearSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
             panel.getTxtIdoDateRange().clearFromValue();
      panel.getTxtIdoDateRange().clearToValue();
      panel.getTxtSearchHihoNo().clearValue();
    }
    
    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0220011/JukyushaIdoRenrakuhyoHenko.yml"));
    }


}
