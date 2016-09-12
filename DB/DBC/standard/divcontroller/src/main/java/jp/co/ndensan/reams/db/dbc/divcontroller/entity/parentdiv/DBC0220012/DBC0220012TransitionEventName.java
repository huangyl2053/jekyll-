package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0220012のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2101-020 quxiaodong
 */
public enum DBC0220012TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    対象者一覧("対象者一覧"),
    完了("完了");

    private final RString name;

    private DBC0220012TransitionEventName(String name) {
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
