package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBB8110001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBB8110001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    検索へ戻る("検索へ戻る"),
    検索結果一覧へ戻る("検索結果一覧へ戻る"),
    戻る("戻る"),
    終了する("終了する");

    private final RString name;

    private DBB8110001TransitionEventName(String name) {
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
