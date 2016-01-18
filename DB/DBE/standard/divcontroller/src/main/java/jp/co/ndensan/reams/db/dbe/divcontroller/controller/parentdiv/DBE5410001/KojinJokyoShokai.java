/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5410001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5410001.KojinJokyoShokaiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.kojinjokyoshokai.KojinJokyoShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 要介護認定個人状況照会処理のクラスです。
 */
public class KojinJokyoShokai {
    
    /**
     * 画面初期化処理です。
     *
     * @param div KojinJokyoShokaiDiv
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onLoad(KojinJokyoShokaiDiv div) {
        //TODO
        //RString 申請書管理番号 = ViewStateHolder.get(SaibanHanyokeyName.申請書整理番号, RString.class);
        ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo("11");
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(shinseishoKanriNo);
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder =KojinJokyoShokaiFinder.createInstance();
         List<jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai> kojinJokyoShokaiList 
                 = kojinJokyoShokaiFinder.getKojinJokyoShokai(parameter).records();
         if(!kojinJokyoShokaiList.isEmpty()){
             getHandler(div).setkojinJokyoShokai(kojinJokyoShokaiList);
         }
        
        return ResponseData.of(div).respond();
    }
    
     private KojinJokyoShokaiHandler getHandler(KojinJokyoShokaiDiv div) {
        return new KojinJokyoShokaiHandler(div);
    }
    
}
