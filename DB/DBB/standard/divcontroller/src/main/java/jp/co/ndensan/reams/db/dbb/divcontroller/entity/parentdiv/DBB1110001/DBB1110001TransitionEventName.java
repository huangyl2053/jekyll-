package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB1110001のイベント名定義クラスです</br>
 *
 * @reamsid_L DBB-1650-010 lijunjun
 */
public enum DBB1110001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了("完了"),
    広域("広域"),
    単一他社("単一他社");

    private final RString name;

    private DBB1110001TransitionEventName(String name) {
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
