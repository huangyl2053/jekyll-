package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0150011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public enum DBC0150011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    dummy("dummy"),
    再検索("再検索"),
    検索結果一覧("検索結果一覧");

    private final RString name;

    private DBC0150011TransitionEventName(String name) {
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
