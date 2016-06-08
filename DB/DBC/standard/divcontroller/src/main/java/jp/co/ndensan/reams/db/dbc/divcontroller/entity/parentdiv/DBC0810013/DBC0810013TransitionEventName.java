package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810013;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810013のイベント名定義クラスです</br>
 *
 * @reamsid_L DBC-1010-080 gongliang
 */
public enum DBC0810013TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    申請情報("申請情報"),
    一覧に戻る("一覧に戻る"),
    サービス提供証明書("サービス提供証明書"),
    償還払決定情報("償還払決定情報");

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
