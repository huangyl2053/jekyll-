package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0220013のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2102-010 quxiaodong
 */
public enum DBC0220013TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索結果一覧("検索結果一覧"),
    再検索("再検索");

    private final RString name;

    private DBC0220013TransitionEventName(String name) {
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
