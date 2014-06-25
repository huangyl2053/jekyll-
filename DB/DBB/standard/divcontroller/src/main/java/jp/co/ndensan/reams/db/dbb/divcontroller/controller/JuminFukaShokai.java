/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.JuminFukaShokaiDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.controller.AtenaShokaiSimple;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n3412
 */
public class JuminFukaShokai {

    //private static final RString FUKA_SHOKAI_GAITOSHA = new RString("FukaShokaiGaitoshaData.yml");

    public ResponseData<JuminFukaShokaiDiv> onLoad_JuminFukaShokai(JuminFukaShokaiDiv panel) {
        ResponseData<JuminFukaShokaiDiv> response = new ResponseData<>();
        
        AtenaShokaiSimpleDiv a = panel.getKaigoatena().getAtenaInfo();
        AtenaShokaiSimple.setData(a, new ShikibetsuCode("000000000000094"));
            
        response.data = panel;
        return response;
    }
       
}
