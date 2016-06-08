package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB0110001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public enum DBB0110001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    終了する("終了する");

    private final RString name;

    private DBB0110001TransitionEventName(String name) {
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
