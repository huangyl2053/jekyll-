package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0310011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2130-010 cuilin
 */
public enum DBC0310011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    契約者選択("契約者選択"),
    対象者検索("対象者検索"),
    事業者検索("事業者検索");

    private final RString name;

    private DBC0310011TransitionEventName(String name) {
        this.name = new RString(name);
    }

    /**
     * getName
     *
     * @return 名前
     */
    @Override
    public RString getName() {
        return name;
    }
// </editor-fold>
}
