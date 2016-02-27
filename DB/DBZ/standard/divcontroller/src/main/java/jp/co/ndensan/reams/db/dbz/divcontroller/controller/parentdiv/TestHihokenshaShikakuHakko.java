/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.TestHihokenshaShikakuHakko.TestHihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author huangh
 */
public class TestHihokenshaShikakuHakko {

    /**
     * onLoad時の処理です。<br/>
     *
     * @param div
     * @return ResponseData
     */
    public ResponseData<TestHihokenshaShikakuHakkoDiv> onLoad(TestHihokenshaShikakuHakkoDiv div) {

        div.getCommonChildDiv1().initialize(new HihokenshaNo("100002"), new RString("DBUMN12002"));
        return ResponseData.of(div).respond();

    }
}
