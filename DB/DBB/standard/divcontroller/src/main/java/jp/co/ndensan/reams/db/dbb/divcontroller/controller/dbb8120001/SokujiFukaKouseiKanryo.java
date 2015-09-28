/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb8120001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiFukaKouseiKanryoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiKouseiJuminDiv;
//import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public class SokujiFukaKouseiKanryo {

    public ResponseData<SokujiFukaKouseiKanryoDiv> onLoad_SokujiFukaKouseiKanryo(SokujiFukaKouseiKanryoDiv sokujiFukaKouseiKanryoDiv, SokujiKouseiJuminDiv sokujiKouseiJuminDiv) {
        return ResponseData.of(sokujiFukaKouseiKanryoDiv).respond();
    }
}
