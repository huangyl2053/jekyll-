package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC2000023のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public enum DBC2000023TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    終了("終了"),
    検索結果一覧("検索結果一覧"),
    再検索("再検索");

    private final RString name;

    private DBC2000023TransitionEventName(String name) {
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
