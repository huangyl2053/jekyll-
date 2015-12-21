/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonlist.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonlist.ShichosonList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 */
class HokenshaListDivHandler {

    private final HokenshaListDiv div;

    protected HokenshaListDivHandler(HokenshaListDiv div) {
        this.div = div;
    }

    void load保険者リスト() {
        ShichosonList shichosonList = ShichosonList.createInstance();
        List<KeyValueDataSource> list = new ArrayList<>();
        for (ShichosonCodeNameResult s : shichosonList.getShichosonCodeNameList()) {
            list.add(new KeyValueDataSource(s.get市町村コード().value(), s.get市町村名称()));
        }
        div.getDdlHokenshaList().setDataSource(list);
    }
}
