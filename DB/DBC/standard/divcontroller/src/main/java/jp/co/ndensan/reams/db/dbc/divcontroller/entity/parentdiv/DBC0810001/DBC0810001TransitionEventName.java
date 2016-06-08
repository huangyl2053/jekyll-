package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0810001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    申請登録("申請登録"),
    証明書情報("証明書情報");

    private final RString name;

    private DBC0810001TransitionEventName(String name) {
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
