/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.JuminPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public class JuminPanel {

    public ResponseData<JuminPanelDiv> getOnLoadData(JuminPanelDiv panel) {
        ResponseData<JuminPanelDiv> response = new ResponseData<>();
        //初期値を設定したいものに値を入れる。
        panel.getNushiJuminJoho().getTxtNushiShikibetsuCode().setValue(new RString("000000000000001"));
        panel.getNushiJuminJoho().getTxtNushiName().setValue(new RString("電算 太郎"));
        panel.getNushiJuminJoho().getTxtNushiSetaiCode().setValue(new RString("000000000000001"));
        panel.getNushiJuminJoho().getTxtNushiGyoseiku().setValue(new RString("中町"));
        panel.getNushiJuminJoho().getTxtNushiYubinNo().setValue(new RString("123-4567"));
        panel.getNushiJuminJoho().getTxtNushiJusho().setValue(new RString("長野県長野市鶴賀七瀬中町276-6"));
        panel.getKaigoJuminJoho().getTxtHihokenshaNo().setValue(new RString("1234567890"));
        panel.getKaigoJuminJoho().getTxtTsuchishoNo().setValue(new RString("1234567890123456"));
        panel.getKaigoJuminJoho().getTxtChoshuHoho().setValue(new RString("特徴"));
        panel.getKaigoJuminJoho().getTxtShikakuShutokuYMD().setValue(new RString("20100101"));
        panel.getKaigoJuminJoho().getTxtKyuHihokenshaNo().setValue(new RString("1111111111"));
        panel.getKaigoJuminJoho().getTxtKyuShichosonCode().setValue(new RString("203416"));
        panel.getKaigoJuminJoho().getTxtKyuShichosonName().setValue(new RString("鎌倉町"));

        response.data = panel;
        return response;
    }
}
