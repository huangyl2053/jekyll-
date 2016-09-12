package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC1000065のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public enum DBC1000065TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    対象者検索("対象者検索"),
    完了("完了");

    private final RString name;

    private DBC1000065TransitionEventName(String name) {
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
