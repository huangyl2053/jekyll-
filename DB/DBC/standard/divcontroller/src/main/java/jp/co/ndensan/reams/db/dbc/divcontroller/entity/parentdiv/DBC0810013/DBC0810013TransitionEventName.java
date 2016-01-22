package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810013;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810013のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0810013TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    戻る("戻る"),
    申請情報へ("申請情報へ"),
    サービスへ("サービスへ"),
    決定情報へ("決定情報へ");

    private final RString name;

    private DBC0810013TransitionEventName(String name) {
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
