/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujiFukaKouseiKanryoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.SokujiKouseiJuminDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3336
 */
public class SokujiFukaKouseiKanryo {

    public ResponseData<SokujiFukaKouseiKanryoDiv> onLoad_SokujiFukaKouseiKanryo(SokujiFukaKouseiKanryoDiv sokujiFukaKouseiKanryoDiv, SokujiKouseiJuminDiv sokujiKouseiJuminDiv) {
        ResponseData<SokujiFukaKouseiKanryoDiv> response = new ResponseData<>();

        KaigoKanryoMessage.setMessage(sokujiFukaKouseiKanryoDiv.getSokujiFukaKouseiKanryoMsg(), new RString("保存は正常に行われました。"), sokujiKouseiJuminDiv.getSokujiKouseiKihon().getTxtTsuchishoNo().getText(), sokujiKouseiJuminDiv.getSokujiKouseiAtena().getAtenaInfo().getTxtAtenaMeisho().getValue());
        response.data = sokujiFukaKouseiKanryoDiv;
        return response;

    }

}
