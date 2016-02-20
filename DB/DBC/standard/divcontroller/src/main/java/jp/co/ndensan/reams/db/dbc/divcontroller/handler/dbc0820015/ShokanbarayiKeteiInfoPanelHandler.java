/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author 徐浩
 */
public class ShokanbarayiKeteiInfoPanelHandler {
    
    private final ShokanbarayiKeteiInfoPanelDiv div;
    
    private ShokanbarayiKeteiInfoPanelHandler(ShokanbarayiKeteiInfoPanelDiv div) {
        this.div = div;
    }
    
    public static ShokanbarayiKeteiInfoPanelHandler of(ShokanbarayiKeteiInfoPanelDiv div) {
        return new ShokanbarayiKeteiInfoPanelHandler(div);
    }
    
    public void putViewState() {
        // TODO 処理モード　
        ViewStateHolder.put(ViewStateKeys.処理モード, "");
        SyokanbaraihishikyushinseiketteParameter paramter = new SyokanbaraihishikyushinseiketteParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getDomain().toDateString()),
                div.getPanelTwo().getTxtSeiriBango().getValue(), null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, paramter);
    }
    
    public boolean get内容変更状態() {
        return true;
    }
}
