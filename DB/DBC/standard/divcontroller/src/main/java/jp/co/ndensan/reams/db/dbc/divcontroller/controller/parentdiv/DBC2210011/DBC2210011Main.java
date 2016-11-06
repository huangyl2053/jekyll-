/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011.DBC2210011MainHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author liuyl
 */
public class DBC2210011Main {

    public ResponseData<DBC2210011MainDiv> onLoad(DBC2210011MainDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    public ResponseData<DBC2210011MainDiv> onClick_btnSearch(DBC2210011MainDiv div) {
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者情報 = getHandler(div).onClick_btnSearch();
        ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(事業者情報));
        return ResponseData.of(div).respond();
    }

    private DBC2210011MainHandler getHandler(DBC2210011MainDiv div) {
        return new DBC2210011MainHandler(div);
    }
}
