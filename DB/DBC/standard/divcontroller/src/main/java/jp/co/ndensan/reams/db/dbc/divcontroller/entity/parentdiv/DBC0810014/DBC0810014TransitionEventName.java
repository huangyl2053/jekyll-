package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0810014のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBC0810014TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    申請情報("申請情報"),
    口座情報("口座情報"),
    サービス提供証明書("サービス提供証明書"),
    償還払決定情報("償還払決定情報"),
    一覧に戻る("一覧に戻る"),
    償還払い費支給申請("償還払い費支給申請");

    private final RString name;

    private DBC0810014TransitionEventName(String name) {
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
