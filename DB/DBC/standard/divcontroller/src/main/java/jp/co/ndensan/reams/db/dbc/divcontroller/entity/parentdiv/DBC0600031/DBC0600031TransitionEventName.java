package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600031;

import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBC0600031のイベント名定義クラスです</br>
 *
 * @author 自動生成
 * @reamsid_L DBC-1020-010 yangchenbing
 */
public enum DBC0600031TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    処理完了("処理完了"),
    一覧に戻る("一覧に戻る"),
    明細情報("明細情報");

    private final RString name;

    private DBC0600031TransitionEventName(String name) {
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
