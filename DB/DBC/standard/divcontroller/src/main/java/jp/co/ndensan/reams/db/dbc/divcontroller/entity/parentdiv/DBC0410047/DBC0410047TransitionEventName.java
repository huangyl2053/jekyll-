package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410047;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0410047のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-2480-040 changying
 */
public enum DBC0410047TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    実行する("実行する"),
    戻る("戻る");

    private final RString name;

    private DBC0410047TransitionEventName(String name) {
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
