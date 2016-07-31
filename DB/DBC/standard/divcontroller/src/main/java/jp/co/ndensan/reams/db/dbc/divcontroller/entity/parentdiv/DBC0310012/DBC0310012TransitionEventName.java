package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0310012のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2130-020 cuilin
 */
public enum DBC0310012TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索に戻る("検索に戻る"),
    処理完了("処理完了"),
    事業者検索("事業者検索");

    private final RString name;

    private DBC0310012TransitionEventName(String name) {
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
