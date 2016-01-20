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
import jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo.KojinShinchokuJokyohyoEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.kojinjokyoshokai.KojinJokyoShokaiFinder;
import jp.co.ndensan.reams.db.dbe.service.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(SaibanHanyokeyName.申請書整理番号, ShinseishoKanriNo.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(申請書管理番号);
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
         List<jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai> kojinJokyoShokaiList 
                 = kojinJokyoShokaiFinder.getKojinJokyoShokai(parameter).records();
         if (!kojinJokyoShokaiList.isEmpty()) {
             getHandler(div).setKojinJokyoShokai(kojinJokyoShokaiList);
         }
        
        return ResponseData.of(div).respond();
    }
    
    /**
     * 個人進捗状況表を発行する処理です。
     *
     * @param div KojinJokyoShokaiDiv
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnprint(KojinJokyoShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(SaibanHanyokeyName.申請書整理番号, ShinseishoKanriNo.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(申請書管理番号);
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
       List<jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai> kojinJokyoShokaiList 
                 = kojinJokyoShokaiFinder.getKojinShinchokuJokyohyo(parameter).records();
       KojinShinchokuJokyohyoEntity jokyohyoEntity = new KojinShinchokuJokyohyoEntity();
         if (!kojinJokyoShokaiList.isEmpty()) {
             jokyohyoEntity = getHandler(div).setKojinShinchokuJokyohyo(kojinJokyoShokaiList);
         }
         
        return ResponseData.of(new KojinShinchokuJokyohyoPrintService().print(jokyohyoEntity)).respond();
    }
    
     private KojinJokyoShokaiHandler getHandler(KojinJokyoShokaiDiv div) {
        return new KojinJokyoShokaiHandler(div);
    }
}
