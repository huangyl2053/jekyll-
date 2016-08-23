/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8120001;

import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.NendobunFukaList;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiFukaKouseiKanryoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM13001_2_即時賦課更正のクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiKanryo {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div SokujiFukaKouseiKanryoDiv
     * @return 画面のResponseData
     */
    public ResponseData<SokujiFukaKouseiKanryoDiv> onLoad_SokujiFukaKouseiKanryo(SokujiFukaKouseiKanryoDiv div) {
        NendobunFukaList 更正後 = ViewStateHolder.get(ViewStateKeys.更正後, NendobunFukaList.class);
        RString 氏名 = ViewStateHolder.get(ViewStateKeys.氏名, RString.class);
        div.getSokujiFukaKouseiKanryoMsg().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                更正後.get通知書番号().getColumnValue(), 氏名, true);
        return ResponseData.of(div).respond();
    }
}
