package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410040;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0410040のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2550-040 chendi
 */
public enum DBC0410040TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    実行する("実行する"),
    戻る("戻る");

    private final RString name;

    private DBC0410040TransitionEventName(String name) {
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
