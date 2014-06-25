/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.TsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3412
 */
public class TsuchishoSakuseiKobetsu {
    public ResponseData<TsuchishoSakuseiKobetsuDiv> onLoad_TsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv panel) {
        ResponseData<TsuchishoSakuseiKobetsuDiv> response = new ResponseData<>();
        List<dgChohyoSentaku_Row> arrayData = new ArrayList<>();
        
        arrayData.add( set_dgChohyoSentaku_Row(new RString("決定通知書")) );
        arrayData.add( set_dgChohyoSentaku_Row(new RString("変更兼特徴中止通知書")) );
        arrayData.add( set_dgChohyoSentaku_Row(new RString("納入通知書")) );
        arrayData.add( set_dgChohyoSentaku_Row(new RString("郵便振替納付書")) );
        arrayData.add( set_dgChohyoSentaku_Row(new RString("賦課台帳")) );
         
        panel.getDgChohyoSentaku().setDataSource(arrayData);
        
        response.data = panel;
        return response;
    }
    
    
    
    
    private dgChohyoSentaku_Row set_dgChohyoSentaku_Row(RString s){
        dgChohyoSentaku_Row row = new dgChohyoSentaku_Row(RString.EMPTY);
        row.setTxtChohyoSentaku(s);
        return row;
    }
}
