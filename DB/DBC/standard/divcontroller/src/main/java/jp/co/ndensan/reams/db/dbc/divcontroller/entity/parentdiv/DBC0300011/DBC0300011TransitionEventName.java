package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0300011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2120-010 panhe
 */
public enum DBC0300011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    事業者選択("事業者選択");

    private final RString name;

    private DBC0300011TransitionEventName(String name) {
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
