package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820011;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0820011のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-1030-140 panhe
 */
public enum DBC0820011TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索に戻る("検索に戻る"),
    償還申請("償還申請"),
    処理完了("処理完了");

    private final RString name;

    private DBC0820011TransitionEventName(String name) {
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
