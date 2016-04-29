package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810012のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-1010-170 xupeng
 */
public enum DBC0810012TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    一覧に戻る("一覧に戻る"),
    口座情報("口座情報"),
    サービス提供証明書("サービス提供証明書"),
    償還払決定情報("償還払決定情報");

    private final RString name;

    private DBC0810012TransitionEventName(String name) {
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
