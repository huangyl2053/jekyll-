/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaJisshishaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho.ChosaJisshishaJohoFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 調査実施者情報Divの画面イベントを記述するクラスです。
 * 
 */
public class ChosaJisshishaJoho {
    
    private ChosaJisshishaJohoFinder service;
    
    public ResponseData<ChosaJisshishaJohoDiv> onChange_ddlShozokuKikan(ChosaJisshishaJohoDiv div) {
        service = ChosaJisshishaJohoFinder.createInstance();
        List<ChosainJoho> chosainJohoList = service.getKinyusha(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class).getColumnValue(), div.getDdlShozokuKikan().getSelectedKey()).records();
        List<KeyValueDataSource> kinyusha = new ArrayList<>();
        kinyusha.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosainJoho chosainJoho : chosainJohoList) {
            KeyValueDataSource data = new KeyValueDataSource(chosainJoho.get認定調査員コード(),
                    chosainJoho.get調査員氏名());
            kinyusha.add(data);
        }
        div.getDdlKinyusha().setDataSource(kinyusha);
        return ResponseData.of(div).respond();
    } 
}