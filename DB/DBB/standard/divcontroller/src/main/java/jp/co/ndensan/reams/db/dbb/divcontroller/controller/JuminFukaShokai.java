/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.JuminFukaShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3412
 */
public class JuminFukaShokai {

    //private static final RString FUKA_SHOKAI_GAITOSHA = new RString("FukaShokaiGaitoshaData.yml");

    public ResponseData<JuminFukaShokaiDiv> onLoad_JuminFukaShokai(JuminFukaShokaiDiv panel) {
        ResponseData<JuminFukaShokaiDiv> response = new ResponseData<>();
        
        AtenaShokaiSimple.setData(panel.getKaigoatena().getAtenaInfo(), new ShikibetsuCode("000000000000094"));
        
        List<HashMap> SokujiKouseiKihonData = YamlLoader.DBB.loadAsList(new RString("DBB8120001/SokujiKouseiKihon.yml"));
        panel.getKaigoKihon().getTxtTsuchishoNo().setValue(new RString(SokujiKouseiKihonData.get(0).get("通知書番号").toString()));
        panel.getKaigoKihon().getTxtHihokenshaNo().setValue(new RString(SokujiKouseiKihonData.get(0).get("被保番号").toString()));
        panel.getKaigoKihon().getTxtHokenryoDankai().setValue(new RString(SokujiKouseiKihonData.get(0).get("保険料段階").toString()));
        panel.getKaigoKihon().getTxtShutokuYmd().setValue(new RDate(SokujiKouseiKihonData.get(0).get("資格取得日").toString()));
        panel.getKaigoKihon().getTxtShutokuJiyu().setValue(new RString(SokujiKouseiKihonData.get(0).get("資格取得事由").toString()));
        panel.getKaigoKihon().getTxtSoshitsuYmd().clearValue();
        panel.getKaigoKihon().getTxtSoshitsuJiyu().setValue(new RString(SokujiKouseiKihonData.get(0).get("資格喪失事由").toString()));   
            
        response.data = panel;
        return response;
    }
       
}
