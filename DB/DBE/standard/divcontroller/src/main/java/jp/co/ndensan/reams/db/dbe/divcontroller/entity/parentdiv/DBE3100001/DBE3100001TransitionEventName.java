package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.core.ui.response.IContainerEvents;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE3100001のイベント名定義クラスです</br>
 *
 * @author 自動生成
 */
public enum DBE3100001TransitionEventName implements IContainerEvents {
// <editor-fold defaultstate="collapsed" desc="Created By UI Designer ver 1.0.0">

    完了処理("完了処理"),
    戻る("戻る"),
    検索結果一覧("検索結果一覧"),
    再検索する("再検索する"),
    終了("終了");

    private final RString name;

    private DBE3100001TransitionEventName(String name) {
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
