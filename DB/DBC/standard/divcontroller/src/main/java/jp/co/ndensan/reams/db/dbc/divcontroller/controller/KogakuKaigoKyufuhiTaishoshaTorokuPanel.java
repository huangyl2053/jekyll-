/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * 高額介護サービス費給付対象者登録（自庁）パネルです。
 * @author n8223
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuPanel {
            
      public ResponseData<KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv> onLoad(KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv panel) {
        ResponseData<KogakuKaigoKyufuhiTaishoshaTorokuPanelDiv> response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。審査年月
        panel.getTxtShinsaYM().setFromValue(new RDate("201405"));
        panel.getTxtShinsaYM().setToValue(new RDate("201406"));
        
         //初期値を設定したいものに値を入れる。出力順序
        panel.getKariPanel().getTxtNewPageItem().setValue(new RString("氏名５０音カナ"));
        panel.getKariPanel().getTxt1().setValue(new RString("被保険者番号"));
        panel.getKariPanel().getTxt2().setValue(new RString("氏名５０音カナ"));
        panel.getKariPanel().getTxt3().setValue(new RString("決定通知番号"));
        panel.getKariPanel().getTxt4().setValue(new RString("行政区コード"));
        panel.getKariPanel().getTxt5().setValue(new RString("市町村コード"));
        
        response.data = panel;
        return response;
    }
    
}
